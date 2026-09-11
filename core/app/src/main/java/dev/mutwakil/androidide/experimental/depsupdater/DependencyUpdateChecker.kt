package dev.mutwakil.androidide.experimental.depsupdater

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import org.xml.sax.InputSource
import java.util.concurrent.TimeUnit
import android.util.Log
import org.w3c.dom.Element
import javax.xml.parsers.DocumentBuilderFactory
import java.io.StringReader

class DependencyUpdateChecker {
    
    private val client = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .build()
    
    suspend fun checkForUpdates(
        dependencies: List<Dependency>,
        versionCatalog: Map<String, DependencyInfo>
    ): List<Dependency> = withContext(Dispatchers.IO) {
        
        val deferredUpdates = dependencies.map { dep ->
            async {
                try {
                    if (dep.catalogReference != null) {
                        val normalizedRef = dep.catalogReference.replace(".", "-")
                        
                        Log.d("DependencyUpdateChecker", "Looking for catalogRef: ${dep.catalogReference} (normalized: $normalizedRef)")
                        
                        val catalogInfo = versionCatalog[normalizedRef]
                        
                        if (catalogInfo != null && catalogInfo.group.isNotEmpty() && catalogInfo.name.isNotEmpty()) {
                            Log.d("DependencyUpdateChecker", "Found catalog info: ${catalogInfo.group}:${catalogInfo.name}:${catalogInfo.version}")
                            val latestVersion = fetchLatestVersionFromAllRepos(catalogInfo.group, catalogInfo.name)
                            Log.d("DependencyUpdateChecker", "Latest version: $latestVersion")
                            dep.copy(
                                group = catalogInfo.group,
                                name = catalogInfo.name,
                                currentVersion = catalogInfo.version,
                                latestVersion = latestVersion,
                                hasUpdate = isNewer(latestVersion, catalogInfo.version)
                            )
                        } else {
                            Log.d("DependencyUpdateChecker", "No catalog info found for $normalizedRef")
                            dep
                        }
                    } else if (dep.group.isNotEmpty() && dep.name.isNotEmpty()) {
                        val latestVersion = fetchLatestVersionFromAllRepos(dep.group, dep.name)
                        dep.copy(
                            latestVersion = latestVersion,
                            hasUpdate = isNewer(latestVersion, dep.currentVersion)
                        )
                    } else {
                        dep
                    }
                } catch (e: Exception) {
                    Log.e("DependencyUpdateChecker", "Error checking update for ${dep.catalogReference ?: dep.name}", e)
                    dep.copy(latestVersion = "Error: ${e.message}")
                }
            }
        }
        
        deferredUpdates.awaitAll()
    }
    
    private fun fetchLatestVersionFromAllRepos(group: String, name: String): String? {
        val versions = mutableListOf<String>()
        
        fetchFromGoogleMaven(group, name)?.let { versions.add(it) }
        fetchFromMavenCentral(group, name)?.let { versions.add(it) }
        fetchFromJitPack(group, name)?.let { versions.add(it) }
        fetchFromJCenter(group, name)?.let { versions.add(it) }
        fetchFromGradlePluginPortal(group, name)?.let { versions.add(it) }
        fetchFromMavenRepository(group, name)?.let { versions.add(it) }
        
        return if (versions.isNotEmpty()) {
            versions.maxWithOrNull(::compareVersionStrings)
        } else {
            null
        }
    }
    
    private fun fetchFromMavenCentral(group: String, name: String): String? {
        return try {
            Log.d("DependencyUpdateChecker", "Checking Maven Central for $group:$name")
            val mavenUrl = "https://search.maven.org/solrsearch/select?q=g:\"$group\"+AND+a:\"$name\"&rows=1&wt=json"
            
            val request = Request.Builder()
                .url(mavenUrl)
                .build()
            
            val response = client.newCall(request).execute()
            if (!response.isSuccessful) {
                Log.d("DependencyUpdateChecker", "Maven Central returned: ${response.code}")
                return null
            }
            
            val body = response.body?.string() ?: return null
            val json = JSONObject(body)
            val docs = json.getJSONObject("response").getJSONArray("docs")
            
            if (docs.length() > 0) {
                val latest = docs.getJSONObject(0).getString("latestVersion")
                Log.d("DependencyUpdateChecker", "Maven Central found: $latest")
                latest
            } else {
                null
            }
        } catch (e: Exception) {
            Log.e("DependencyUpdateChecker", "Error fetching from Maven Central", e)
            null
        }
    }
    
    private fun fetchFromGoogleMaven(group: String, name: String): String? {
        return try {
            Log.d("DependencyUpdateChecker", "Checking Google Maven for $group:$name")
            val groupPath = group.replace(".", "/")
            val mavenMetadataUrl = "https://dl.google.com/dl/android/maven2/$groupPath/$name/maven-metadata.xml"
            
            val request = Request.Builder()
                .url(mavenMetadataUrl)
                .build()
            
            val response = client.newCall(request).execute()
            if (!response.isSuccessful) {
                Log.d("DependencyUpdateChecker", "Google Maven returned: ${response.code}")
                return null
            }
            
            val body = response.body?.string() ?: return null
            val latest = parseLatestVersionFromXml(body)
            Log.d("DependencyUpdateChecker", "Google Maven found: $latest")
            latest
        } catch (e: Exception) {
            Log.e("DependencyUpdateChecker", "Error fetching from Google Maven", e)
            null
        }
    }
    
    private fun fetchFromJitPack(group: String, name: String): String? {
        return try {
            Log.d("DependencyUpdateChecker", "Checking JitPack for $group:$name")
            val groupPath = group.replace(".", "/")
            val mavenMetadataUrl = "https://jitpack.io/$groupPath/$name/maven-metadata.xml"
            
            val request = Request.Builder()
                .url(mavenMetadataUrl)
                .build()
            
            val response = client.newCall(request).execute()
            if (!response.isSuccessful) {
                Log.d("DependencyUpdateChecker", "JitPack returned: ${response.code}")
                return null
            }
            
            val body = response.body?.string() ?: return null
            val latest = parseLatestVersionFromXml(body)
            Log.d("DependencyUpdateChecker", "JitPack found: $latest")
            latest
        } catch (e: Exception) {
            Log.e("DependencyUpdateChecker", "Error fetching from JitPack", e)
            null
        }
    }
    
    private fun fetchFromJCenter(group: String, name: String): String? {
        return try {
            Log.d("DependencyUpdateChecker", "Checking JCenter for $group:$name")
            val groupPath = group.replace(".", "/")
            val mavenMetadataUrl = "https://jcenter.bintray.com/$groupPath/$name/maven-metadata.xml"
            
            val request = Request.Builder()
                .url(mavenMetadataUrl)
                .build()
            
            val response = client.newCall(request).execute()
            if (!response.isSuccessful) {
                Log.d("DependencyUpdateChecker", "JCenter returned: ${response.code}")
                return null
            }
            
            val body = response.body?.string() ?: return null
            val latest = parseLatestVersionFromXml(body)
            Log.d("DependencyUpdateChecker", "JCenter found: $latest")
            latest
        } catch (e: Exception) {
            Log.e("DependencyUpdateChecker", "Error fetching from JCenter", e)
            null
        }
    }
    
    private fun fetchFromGradlePluginPortal(group: String, name: String): String? {
        return try {
            Log.d("DependencyUpdateChecker", "Checking Gradle Plugin Portal for $group:$name")
            val groupPath = group.replace(".", "/")
            val mavenMetadataUrl = "https://plugins.gradle.org/m2/$groupPath/$name/maven-metadata.xml"
            
            val request = Request.Builder()
                .url(mavenMetadataUrl)
                .build()
            
            val response = client.newCall(request).execute()
            if (!response.isSuccessful) {
                Log.d("DependencyUpdateChecker", "Gradle Plugin Portal returned: ${response.code}")
                return null
            }
            
            val body = response.body?.string() ?: return null
            val latest = parseLatestVersionFromXml(body)
            Log.d("DependencyUpdateChecker", "Gradle Plugin Portal found: $latest")
            latest
        } catch (e: Exception) {
            Log.e("DependencyUpdateChecker", "Error fetching from Gradle Plugin Portal", e)
            null
        }
    }
    
    private fun fetchFromMavenRepository(group: String, name: String): String? {
        return try {
            Log.d("DependencyUpdateChecker", "Checking Maven Repository (repo1) for $group:$name")
            val groupPath = group.replace(".", "/")
            val mavenMetadataUrl = "https://repo1.maven.org/maven2/$groupPath/$name/maven-metadata.xml"
            
            val request = Request.Builder()
                .url(mavenMetadataUrl)
                .build()
            
            val response = client.newCall(request).execute()
            if (!response.isSuccessful) {
                Log.d("DependencyUpdateChecker", "Maven Repository returned: ${response.code}")
                return null
            }
            
            val body = response.body?.string() ?: return null
            val latest = parseLatestVersionFromXml(body)
            Log.d("DependencyUpdateChecker", "Maven Repository found: $latest")
            latest
        } catch (e: Exception) {
            Log.e("DependencyUpdateChecker", "Error fetching from Maven Repository", e)
            null
        }
    }
    
    private fun parseLatestVersionFromXml(xml: String): String? {
        return try {
            val factory = DocumentBuilderFactory.newInstance()
            val builder = factory.newDocumentBuilder()
            val doc = builder.parse(InputSource(StringReader(xml)))
            
            val releaseNodes = doc.getElementsByTagName("release")
            if (releaseNodes.length > 0) {
                return releaseNodes.item(0).textContent
            }
            
            val latestNodes = doc.getElementsByTagName("latest")
            if (latestNodes.length > 0) {
                return latestNodes.item(0).textContent
            }
            
            val versioningNodes = doc.getElementsByTagName("versioning")
            if (versioningNodes.length > 0) {
                val versioning = versioningNodes.item(0) as Element
                val versions = versioning.getElementsByTagName("version")
                if (versions.length > 0) {
                    val allVersions = mutableListOf<String>()
                    for (i in 0 until versions.length) {
                        allVersions.add(versions.item(i).textContent)
                    }
                    return allVersions.filter { !it.contains("alpha", true) && !it.contains("beta", true) && !it.contains("rc", true) }
                        .maxWithOrNull(::compareVersionStrings) ?: allVersions.last()
                }
            }
            
            null
        } catch (e: Exception) {
            Log.e("DependencyUpdateChecker", "Error parsing XML", e)
            null
        }
    }
    
    private fun isNewer(latest: String?, current: String): Boolean {
        if (latest == null || current.isEmpty()) return false
        return compareVersions(latest, current) > 0
    }
    
    private fun compareVersions(v1: String, v2: String): Int {
        val parts1 = parseVersionParts(v1)
        val parts2 = parseVersionParts(v2)
        
        val maxLength = maxOf(parts1.size, parts2.size)
        
        for (i in 0 until maxLength) {
            val part1 = parts1.getOrNull(i) ?: 0
            val part2 = parts2.getOrNull(i) ?: 0
            
            if (part1 != part2) {
                return part1.compareTo(part2)
            }
        }
        
        return 0
    }
    
    private fun parseVersionParts(version: String): List<Int> {
        return version.split(".", "-")
            .map { it.filter { c -> c.isDigit() } }
            .filter { it.isNotEmpty() }
            .map { it.toIntOrNull() ?: 0 }
    }
    
    private fun compareVersionStrings(v1: String, v2: String): Int {
        return compareVersions(v1, v2)
    }
}