package dev.mutwakil.androidide.lsp.kotlin.compiler;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\bJ\u0010\u0010\'\u001a\u0004\u0018\u00010\u00142\u0006\u0010&\u001a\u00020\bJ\u000e\u0010\'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020%J\b\u0010)\u001a\u00020 H\u0016R\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006*"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/Compiler;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "workspace", "Ldev/mutwakil/androidide/projects/IWorkspace;", "projectModel", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/KotlinProjectModel;", "intellijPluginRoot", "Ljava/nio/file/Path;", "jdkHome", "jdkRelease", "", "languageVersion", "Lorg/jetbrains/kotlin/config/LanguageVersion;", "<init>", "(Ldev/mutwakil/androidide/projects/IWorkspace;Ldev/mutwakil/androidide/lsp/kotlin/compiler/KotlinProjectModel;Ljava/nio/file/Path;Ljava/nio/file/Path;ILorg/jetbrains/kotlin/config/LanguageVersion;)V", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "defaultCompilationEnv", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationEnvironment;", "getDefaultCompilationEnv$annotations", "()V", "fileSystem", "Lorg/jetbrains/kotlin/com/intellij/openapi/vfs/VirtualFileSystem;", "getFileSystem", "()Lorg/jetbrains/kotlin/com/intellij/openapi/vfs/VirtualFileSystem;", "defaultKotlinParser", "Lorg/jetbrains/kotlin/psi/KtPsiFactory;", "getDefaultKotlinParser", "()Lorg/jetbrains/kotlin/psi/KtPsiFactory;", "refreshSources", "", "updateLanguageClient", "client", "Ldev/mutwakil/androidide/lsp/api/ILanguageClient;", "compilationKindFor", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationKind;", "file", "compilationEnvironmentFor", "compilationKind", "close", "kotlin_debug"})
public final class Compiler implements java.lang.AutoCloseable {
    private final org.slf4j.Logger logger = null;
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationEnvironment defaultCompilationEnv = null;
    @org.jetbrains.annotations.NotNull()
    private final org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFileSystem fileSystem = null;
    
    public Compiler(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.projects.IWorkspace workspace, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.KotlinProjectModel projectModel, @org.jetbrains.annotations.NotNull()
    java.nio.file.Path intellijPluginRoot, @org.jetbrains.annotations.NotNull()
    java.nio.file.Path jdkHome, int jdkRelease, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.config.LanguageVersion languageVersion) {
        super();
    }
    
    @kotlin.Suppress(names = {"JoinDeclarationAndAssignment"})
    @java.lang.Deprecated()
    private static void getDefaultCompilationEnv$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFileSystem getFileSystem() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.psi.KtPsiFactory getDefaultKotlinParser() {
        return null;
    }
    
    public final void refreshSources() {
    }
    
    public final void updateLanguageClient(@org.jetbrains.annotations.Nullable()
    dev.mutwakil.androidide.lsp.api.ILanguageClient client) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationKind compilationKindFor(@org.jetbrains.annotations.NotNull()
    java.nio.file.Path file) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationEnvironment compilationEnvironmentFor(@org.jetbrains.annotations.NotNull()
    java.nio.file.Path file) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationEnvironment compilationEnvironmentFor(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationKind compilationKind) {
        return null;
    }
    
    @java.lang.Override()
    public void close() {
    }
}