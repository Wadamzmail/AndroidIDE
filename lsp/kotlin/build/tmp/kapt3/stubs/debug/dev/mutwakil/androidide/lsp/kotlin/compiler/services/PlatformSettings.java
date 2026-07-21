package dev.mutwakil.androidide.lsp.kotlin.compiler.services;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/PlatformSettings;", "Lorg/jetbrains/kotlin/analysis/api/platform/KotlinPlatformSettings;", "<init>", "()V", "deserializedDeclarationsOrigin", "Lorg/jetbrains/kotlin/analysis/api/platform/KotlinDeserializedDeclarationsOrigin;", "getDeserializedDeclarationsOrigin", "()Lorg/jetbrains/kotlin/analysis/api/platform/KotlinDeserializedDeclarationsOrigin;", "kotlin_debug"})
public final class PlatformSettings implements org.jetbrains.kotlin.analysis.api.platform.KotlinPlatformSettings {
    
    public PlatformSettings() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.kotlin.analysis.api.platform.KotlinDeserializedDeclarationsOrigin getDeserializedDeclarationsOrigin() {
        return null;
    }
    
    @java.lang.Override()
    public boolean getAllowUseSiteLibraryModuleAnalysis() {
        return false;
    }
}