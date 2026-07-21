package dev.mutwakil.androidide.lsp.kotlin.compiler.modules;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\b \u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0014J\u0006\u0010\u0015\u001a\u00020\u0013J\n\u0010%\u001a\u00020 H\u0096\u0080\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\fR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\fR\u001a\u0010\u001f\u001a\u00020 8VX\u0096\u0004\u00a2\u0006\f\u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006&"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/AbstractKtModule;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/KtModule;", "Lorg/jetbrains/kotlin/analysis/api/platform/projectStructure/KaModuleBase;", "project", "Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "directRegularDependencies", "", "<init>", "(Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;Ljava/util/List;)V", "getProject", "()Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "getDirectRegularDependencies", "()Ljava/util/List;", "searchScopeLock", "", "_baseSearchScope", "Lorg/jetbrains/kotlin/com/intellij/psi/search/GlobalSearchScope;", "_contentScope", "maybeCreateScopesLocked", "", "computeBaseContentScope", "invalidateSearchScope", "baseContentScope", "getBaseContentScope", "()Lorg/jetbrains/kotlin/com/intellij/psi/search/GlobalSearchScope;", "contentScope", "getContentScope", "directDependsOnDependencies", "getDirectDependsOnDependencies", "directFriendDependencies", "getDirectFriendDependencies", "moduleDescription", "", "getModuleDescription$annotations", "()V", "getModuleDescription", "()Ljava/lang/String;", "toString", "kotlin_debug"})
@kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaPlatformInterface.class})
public abstract class AbstractKtModule extends org.jetbrains.kotlin.analysis.api.platform.projectStructure.KaModuleBase implements dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule {
    @org.jetbrains.annotations.NotNull()
    private final org.jetbrains.kotlin.com.intellij.openapi.project.Project project = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> directRegularDependencies = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object searchScopeLock = null;
    @org.jetbrains.annotations.Nullable()
    private org.jetbrains.kotlin.com.intellij.psi.search.GlobalSearchScope _baseSearchScope;
    @org.jetbrains.annotations.Nullable()
    private org.jetbrains.kotlin.com.intellij.psi.search.GlobalSearchScope _contentScope;
    
    public AbstractKtModule(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.project.Project project, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> directRegularDependencies) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.kotlin.com.intellij.openapi.project.Project getProject() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> getDirectRegularDependencies() {
        return null;
    }
    
    private final void maybeCreateScopesLocked() {
    }
    
    /**
     * Computes the base content scope for this module.
     *
     * The default is a snapshot of the currently resolvable [VirtualFile]s
     * ([computeFiles]). Subclasses whose membership is better expressed by path
     * (e.g. source modules, where files are created/deleted/refreshed while
     * editing) should override this with a path-predicate scope so that scope
     * membership stays consistent with the way the module is resolved in
     * `ProjectStructureProvider.getModule`.
     */
    @org.jetbrains.annotations.NotNull()
    protected org.jetbrains.kotlin.com.intellij.psi.search.GlobalSearchScope computeBaseContentScope() {
        return null;
    }
    
    public final void invalidateSearchScope() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.kotlin.com.intellij.psi.search.GlobalSearchScope getBaseContentScope() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.kotlin.com.intellij.psi.search.GlobalSearchScope getContentScope() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> getDirectDependsOnDependencies() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> getDirectFriendDependencies() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getModuleDescription() {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaExperimentalApi.class})
    @java.lang.Deprecated()
    public static void getModuleDescription$annotations() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}