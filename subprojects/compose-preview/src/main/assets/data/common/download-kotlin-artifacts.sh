#!/bin/bash

set -e

# Kotlin version
KOTLIN_VERSION="${1:-2.3.21}"

# Other artifact versions
TROVE4J_VERSION="1.0.20200330"
ANNOTATIONS_VERSION="26.0.2"
COROUTINES_VERSION="1.11.0" 
ROOT="${ROOT:-$HOME}"

PREFIX="$ROOT/usr"
HOME_DIR="$PREFIX/home"

LOCAL_MAVEN_REPO="$ROOT/maven/localMvnRepository"

BASE_URL="https://repo1.maven.org/maven2"

mkdir -p "$LOCAL_MAVEN_REPO"

download_file() {
    local url="$1"
    local output="$2"
    local tmp="${output}.tmp"

    # Remove files left by a previous failed download
    rm -f "$tmp"

    # Remove existing incomplete/old file before downloading
    rm -f "$output"

    echo "Downloading:"
    echo "  $url"

    if curl -fL --retry 3 --retry-delay 1 \
        -o "$tmp" \
        "$url"; then

        # Only move it to its final name after successful download
        mv "$tmp" "$output"

    else
        echo "Download failed:"
        echo "  $url"

        # Delete incomplete file
        rm -f "$tmp"
        rm -f "$output"

        return 1
    fi
}

download_artifact() {
    local group_path="$1"
    local artifact="$2"
    local version="$3"

    local dir="$LOCAL_MAVEN_REPO/$group_path/$artifact/$version"

    local jar="$dir/$artifact-$version.jar"
    local pom="$dir/$artifact-$version.pom"

    mkdir -p "$dir"

    echo
    echo "========================================"
    echo "Artifact: $artifact:$version"
    echo "========================================"

    download_file \
        "$BASE_URL/$group_path/$artifact/$version/$artifact-$version.jar" \
        "$jar"

    download_file \
        "$BASE_URL/$group_path/$artifact/$version/$artifact-$version.pom" \
        "$pom"

    echo "Installed:"
    echo "  $dir"
}

download_artifact \
    "org/jetbrains/kotlin" \
    "kotlin-compiler-embeddable" \
    "$KOTLIN_VERSION"

download_artifact \
    "org/jetbrains/kotlin" \
    "kotlin-daemon-embeddable" \
    "$KOTLIN_VERSION"    

download_artifact \
    "org/jetbrains/kotlin" \
    "kotlin-stdlib" \
    "$KOTLIN_VERSION"

download_artifact \
    "org/jetbrains/kotlin" \
    "kotlin-reflect" \
    "$KOTLIN_VERSION"

download_artifact \
    "org/jetbrains/kotlin" \
    "kotlin-script-runtime" \
    "$KOTLIN_VERSION"
    
download_artifact \
    "org/jetbrains/kotlinx" \
    "kotlinx-coroutines-core-jvm" \
    "$COROUTINES_VERSION"    

download_artifact \
    "org/jetbrains/intellij/deps" \
    "trove4j" \
    "$TROVE4J_VERSION"

download_artifact \
    "org/jetbrains" \
    "annotations" \
    "$ANNOTATIONS_VERSION"

echo
echo "========================================"
echo "All artifacts downloaded successfully."
echo "Local Maven repository:"
echo "$LOCAL_MAVEN_REPO"
echo "========================================"