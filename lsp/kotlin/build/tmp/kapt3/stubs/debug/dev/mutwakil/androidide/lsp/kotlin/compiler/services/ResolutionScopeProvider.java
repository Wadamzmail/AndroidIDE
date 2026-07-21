package dev.mutwakil.androidide.lsp.kotlin.compiler.services;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0014J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\r\u00a8\u0006\u0010"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/ResolutionScopeProvider;", "Lorg/jetbrains/kotlin/analysis/api/impl/base/projectStructure/KaBaseResolutionScopeProvider;", "<init>", "()V", "getResolutionScope", "Lorg/jetbrains/kotlin/analysis/api/platform/projectStructure/KaResolutionScope;", "module", "Lorg/jetbrains/kotlin/analysis/api/projectStructure/KaModule;", "buildSearchScope", "Lorg/jetbrains/kotlin/com/intellij/psi/search/GlobalSearchScope;", "analyzableModules", "", "invalidate", "", "invalidateAll", "Companion", "kotlin_debug"})
public final class ResolutionScopeProvider extends org.jetbrains.kotlin.analysis.api.impl.base.projectStructure.KaBaseResolutionScopeProvider {
    private static final org.slf4j.Logger logger = null;
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.kotlin.compiler.services.ResolutionScopeProvider.Companion Companion = null;
    
    public ResolutionScopeProvider() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.kotlin.analysis.api.platform.projectStructure.KaResolutionScope getResolutionScope(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.projectStructure.KaModule module) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected org.jetbrains.kotlin.com.intellij.psi.search.GlobalSearchScope buildSearchScope(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.projectStructure.KaModule module, @org.jetbrains.annotations.NotNull()
    java.util.Set<? extends org.jetbrains.kotlin.analysis.api.projectStructure.KaModule> analyzableModules) {
        return null;
    }
    
    public final void invalidate(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.projectStructure.KaModule module) {
    }
    
    public final void invalidateAll() {
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/ResolutionScopeProvider$Companion;", "", "<init>", "()V", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "getInstance", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/ResolutionScopeProvider;", "project", "Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "kotlin_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final dev.mutwakil.androidide.lsp.kotlin.compiler.services.ResolutionScopeProvider getInstance(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.com.intellij.openapi.project.Project project) {
            return null;
        }
    }
}