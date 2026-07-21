package dev.mutwakil.androidide.lsp.kotlin.compiler.modules;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BE\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010&\u001a\u00020\'H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/NotUnderContentRootModule;", "Lorg/jetbrains/kotlin/analysis/api/projectStructure/KaNotUnderContentRootModule;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/AbstractKtModule;", "id", "", "project", "Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "moduleDescription", "directRegularDependencies", "", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/KtModule;", "targetPlatform", "Lorg/jetbrains/kotlin/platform/TargetPlatform;", "file", "Lorg/jetbrains/kotlin/com/intellij/psi/PsiFile;", "<init>", "(Ljava/lang/String;Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;Ljava/lang/String;Ljava/util/List;Lorg/jetbrains/kotlin/platform/TargetPlatform;Lorg/jetbrains/kotlin/com/intellij/psi/PsiFile;)V", "getId", "()Ljava/lang/String;", "getModuleDescription", "getTargetPlatform", "()Lorg/jetbrains/kotlin/platform/TargetPlatform;", "getFile", "()Lorg/jetbrains/kotlin/com/intellij/psi/PsiFile;", "name", "getName", "baseContentScope", "Lorg/jetbrains/kotlin/com/intellij/psi/search/GlobalSearchScope;", "getBaseContentScope", "()Lorg/jetbrains/kotlin/com/intellij/psi/search/GlobalSearchScope;", "contentRoots", "", "Ljava/nio/file/Path;", "getContentRoots", "()Ljava/util/Set;", "computeFiles", "Lkotlin/sequences/Sequence;", "Lorg/jetbrains/kotlin/com/intellij/openapi/vfs/VirtualFile;", "extended", "", "kotlin_debug"})
@kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaPlatformInterface.class, org.jetbrains.kotlin.analysis.api.KaExperimentalApi.class})
public final class NotUnderContentRootModule extends dev.mutwakil.androidide.lsp.kotlin.compiler.modules.AbstractKtModule implements org.jetbrains.kotlin.analysis.api.projectStructure.KaNotUnderContentRootModule {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String moduleDescription = null;
    @org.jetbrains.annotations.NotNull()
    private final org.jetbrains.kotlin.platform.TargetPlatform targetPlatform = null;
    @org.jetbrains.annotations.Nullable()
    private final org.jetbrains.kotlin.com.intellij.psi.PsiFile file = null;
    
    public NotUnderContentRootModule(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.project.Project project, @org.jetbrains.annotations.NotNull()
    java.lang.String moduleDescription, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> directRegularDependencies, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.platform.TargetPlatform targetPlatform, @org.jetbrains.annotations.Nullable()
    org.jetbrains.kotlin.com.intellij.psi.PsiFile file) {
        super(null, null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getId() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getModuleDescription() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.kotlin.platform.TargetPlatform getTargetPlatform() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public org.jetbrains.kotlin.com.intellij.psi.PsiFile getFile() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getName() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.kotlin.com.intellij.psi.search.GlobalSearchScope getBaseContentScope() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Set<java.nio.file.Path> getContentRoots() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlin.sequences.Sequence<org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile> computeFiles(boolean extended) {
        return null;
    }
}