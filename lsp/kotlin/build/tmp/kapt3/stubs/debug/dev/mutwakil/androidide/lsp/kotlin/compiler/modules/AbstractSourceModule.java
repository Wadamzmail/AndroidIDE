package dev.mutwakil.androidide.lsp.kotlin.compiler.modules;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0014\u00a8\u0006\u0010"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/AbstractSourceModule;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/AbstractKtModule;", "project", "Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "directRegularDependencies", "", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/KtModule;", "<init>", "(Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;Ljava/util/List;)V", "computeFiles", "Lkotlin/sequences/Sequence;", "Lorg/jetbrains/kotlin/com/intellij/openapi/vfs/VirtualFile;", "extended", "", "computeBaseContentScope", "Lorg/jetbrains/kotlin/com/intellij/psi/search/GlobalSearchScope;", "kotlin_debug"})
public abstract class AbstractSourceModule extends dev.mutwakil.androidide.lsp.kotlin.compiler.modules.AbstractKtModule {
    
    public AbstractSourceModule(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.project.Project project, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> directRegularDependencies) {
        super(null, null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlin.sequences.Sequence<org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile> computeFiles(boolean extended) {
        return null;
    }
    
    /**
     * Membership is decided by path rather than by a frozen snapshot of
     * [VirtualFile] instances. This keeps the content scope consistent with
     * [ProjectStructureProvider.getModule], which resolves files to this module
     * by path (`findModuleForSourceId`).
     *
     * A snapshot-based scope (`filesScope`) goes stale whenever a source file is
     * created, or its [VirtualFile] instance changes due to a VFS refresh (e.g.
     * right after a build). The file is then still mapped to this module by path
     * but is absent from the scope, which makes the Analysis API reject it with
     * `KaBaseIllegalPsiException` ("element cannot be analyzed in the context of
     * the current session"). The predicate below mirrors the [computeFiles]
     * filter and `findModuleForSourceId`, so the two can never disagree.
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected org.jetbrains.kotlin.com.intellij.psi.search.GlobalSearchScope computeBaseContentScope() {
        return null;
    }
}