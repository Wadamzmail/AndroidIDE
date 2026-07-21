package dev.mutwakil.androidide.lsp.kotlin.utils;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0016\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bJ\u0016\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bJ*\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/utils/SymbolVisibilityChecker;", "", "structureProvider", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/ProjectStructureProvider;", "<init>", "(Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/ProjectStructureProvider;)V", "moduleVisibilityCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lorg/jetbrains/kotlin/analysis/api/projectStructure/KaModule;", "", "isVisible", "", "symbol", "Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbol;", "useSiteModule", "useSitePackage", "", "isReachable", "declaringModule", "arePlatformCompatible", "isDeclarationVisible", "Companion", "kotlin_debug"})
public final class SymbolVisibilityChecker {
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.lsp.kotlin.compiler.services.ProjectStructureProvider structureProvider = null;
    private static final org.slf4j.Logger logger = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.ConcurrentHashMap<org.jetbrains.kotlin.analysis.api.projectStructure.KaModule, java.util.List<org.jetbrains.kotlin.analysis.api.projectStructure.KaModule>> moduleVisibilityCache = null;
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.kotlin.utils.SymbolVisibilityChecker.Companion Companion = null;
    
    public SymbolVisibilityChecker(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.services.ProjectStructureProvider structureProvider) {
        super();
    }
    
    public final boolean isVisible(@org.jetbrains.annotations.NotNull()
    org.appdevforall.codeonthego.indexing.jvm.JvmSymbol symbol, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.projectStructure.KaModule useSiteModule, @org.jetbrains.annotations.Nullable()
    java.lang.String useSitePackage) {
        return false;
    }
    
    public final boolean isReachable(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.projectStructure.KaModule useSiteModule, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.projectStructure.KaModule declaringModule) {
        return false;
    }
    
    public final boolean arePlatformCompatible(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.projectStructure.KaModule useSiteModule, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.projectStructure.KaModule declaringModule) {
        return false;
    }
    
    public final boolean isDeclarationVisible(@org.jetbrains.annotations.NotNull()
    org.appdevforall.codeonthego.indexing.jvm.JvmSymbol symbol, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.projectStructure.KaModule useSiteModule, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.projectStructure.KaModule declaringModule, @org.jetbrains.annotations.Nullable()
    java.lang.String useSitePackage) {
        return false;
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/utils/SymbolVisibilityChecker$Companion;", "", "<init>", "()V", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "kotlin_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}