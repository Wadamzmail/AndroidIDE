package dev.mutwakil.androidide.lsp.kotlin.compiler;

/**
 * Base class shared by [CompilationEnvironment] (production) and the test-only
 * `KtLspTestEnvironment`.  Handles all IntelliJ / Analysis API infrastructure
 * that is identical in both environments:
 */
@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u00be\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000 d2\u00060\u0001j\u0002`\u0002:\u0001dBK\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010U\u001a\b\u0012\u0004\u0012\u00020V0;H$J\u0016\u0010W\u001a\u00020X2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020B0;H\u0014J\u0016\u0010Y\u001a\u00020X2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020B0;H\u0014J\b\u0010Z\u001a\u00020[H\u0014J\u008a\u0001\u0010\\\u001a\u00020X2<\u0010]\u001a8\u0012\u0013\u0012\u001107\u00a2\u0006\f\b_\u0012\b\b\u0003\u0012\u0004\b\b(6\u0012\u0013\u0012\u00110/\u00a2\u0006\f\b_\u0012\b\b\u0003\u0012\u0004\b\b(.\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0;0^2B\u0010`\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020<0;\u00a2\u0006\f\b_\u0012\b\b\u0003\u0012\u0004\b\b(:\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020B0;\u00a2\u0006\f\b_\u0012\b\b\u0003\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020F0^H\u0014J\b\u0010a\u001a\u00020bH\u0002J\b\u0010c\u001a\u00020XH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0019\u0010#\u001a\u00070$\u00a2\u0006\u0002\b%X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u001a\u0010(\u001a\u00020)X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0011\u0010.\u001a\u00020/8F\u00a2\u0006\u0006\u001a\u0004\b0\u00101R\u0011\u00102\u001a\u0002038F\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\u0011\u00106\u001a\u0002078F\u00a2\u0006\u0006\u001a\u0004\b8\u00109R \u0010:\u001a\b\u0012\u0004\u0012\u00020<0;X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R \u0010A\u001a\b\u0012\u0004\u0012\u00020B0;X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010>\"\u0004\bD\u0010@R\u001a\u0010E\u001a\u00020FX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020LX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0011\u0010Q\u001a\u00020R8F\u00a2\u0006\u0006\u001a\u0004\bS\u0010T\u00a8\u0006e"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/AbstractCompilationEnvironment;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "name", "", "kind", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationKind;", "intellijPluginRoot", "Ljava/nio/file/Path;", "jdkHome", "jdkRelease", "", "languageVersion", "Lorg/jetbrains/kotlin/config/LanguageVersion;", "applicationEnvironmentMode", "Lorg/jetbrains/kotlin/cli/jvm/compiler/KotlinCoreApplicationEnvironmentMode;", "enableParserEventSystem", "", "<init>", "(Ljava/lang/String;Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationKind;Ljava/nio/file/Path;Ljava/nio/file/Path;ILorg/jetbrains/kotlin/config/LanguageVersion;Lorg/jetbrains/kotlin/cli/jvm/compiler/KotlinCoreApplicationEnvironmentMode;Z)V", "getName", "()Ljava/lang/String;", "getKind", "()Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationKind;", "getIntellijPluginRoot", "()Ljava/nio/file/Path;", "getJdkHome", "getJdkRelease", "()I", "getLanguageVersion", "()Lorg/jetbrains/kotlin/config/LanguageVersion;", "getApplicationEnvironmentMode", "()Lorg/jetbrains/kotlin/cli/jvm/compiler/KotlinCoreApplicationEnvironmentMode;", "getEnableParserEventSystem", "()Z", "disposable", "Lorg/jetbrains/kotlin/com/intellij/openapi/Disposable;", "Lorg/jetbrains/annotations/NotNull;", "getDisposable", "()Lorg/jetbrains/kotlin/com/intellij/openapi/Disposable;", "projectEnv", "Lorg/jetbrains/kotlin/cli/jvm/compiler/KotlinCoreProjectEnvironment;", "getProjectEnv", "()Lorg/jetbrains/kotlin/cli/jvm/compiler/KotlinCoreProjectEnvironment;", "setProjectEnv", "(Lorg/jetbrains/kotlin/cli/jvm/compiler/KotlinCoreProjectEnvironment;)V", "applicationEnv", "Lorg/jetbrains/kotlin/cli/jvm/compiler/KotlinCoreApplicationEnvironment;", "getApplicationEnv", "()Lorg/jetbrains/kotlin/cli/jvm/compiler/KotlinCoreApplicationEnvironment;", "application", "Lorg/jetbrains/kotlin/com/intellij/mock/MockApplication;", "getApplication", "()Lorg/jetbrains/kotlin/com/intellij/mock/MockApplication;", "project", "Lorg/jetbrains/kotlin/com/intellij/mock/MockProject;", "getProject", "()Lorg/jetbrains/kotlin/com/intellij/mock/MockProject;", "modules", "", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/KtModule;", "getModules", "()Ljava/util/List;", "setModules", "(Ljava/util/List;)V", "libraryRoots", "Lorg/jetbrains/kotlin/cli/jvm/index/JavaRoot;", "getLibraryRoots", "setLibraryRoots", "ktSymbolIndex", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/KtSymbolIndex;", "getKtSymbolIndex", "()Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/KtSymbolIndex;", "setKtSymbolIndex", "(Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/KtSymbolIndex;)V", "parser", "Lorg/jetbrains/kotlin/psi/KtPsiFactory;", "getParser", "()Lorg/jetbrains/kotlin/psi/KtPsiFactory;", "setParser", "(Lorg/jetbrains/kotlin/psi/KtPsiFactory;)V", "psiManager", "Lorg/jetbrains/kotlin/com/intellij/psi/PsiManager;", "getPsiManager", "()Lorg/jetbrains/kotlin/com/intellij/psi/PsiManager;", "createServiceRegistrars", "Lorg/jetbrains/kotlin/analysis/api/standalone/base/projectStructure/AnalysisApiSimpleServiceRegistrar;", "setupServices", "", "postInit", "createMessageCollector", "Lorg/jetbrains/kotlin/cli/common/messages/MessageCollector;", "initialize", "buildModules", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "buildKtSymbolIndex", "createCompilerConfiguration", "Lorg/jetbrains/kotlin/config/CompilerConfiguration;", "close", "Companion", "kotlin_debug"})
@kotlin.OptIn(markerClass = {org.jetbrains.kotlin.K1Deprecation.class})
public abstract class AbstractCompilationEnvironment implements java.lang.AutoCloseable {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationKind kind = null;
    @org.jetbrains.annotations.NotNull()
    private final java.nio.file.Path intellijPluginRoot = null;
    @org.jetbrains.annotations.NotNull()
    private final java.nio.file.Path jdkHome = null;
    private final int jdkRelease = 0;
    @org.jetbrains.annotations.NotNull()
    private final org.jetbrains.kotlin.config.LanguageVersion languageVersion = null;
    @org.jetbrains.annotations.NotNull()
    private final org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreApplicationEnvironmentMode applicationEnvironmentMode = null;
    private final boolean enableParserEventSystem = false;
    
    /**
     * Max time close() will block the (main) thread draining background workers before disposal.
     */
    private static final long CLOSE_DRAIN_TIMEOUT = 0L;
    @org.jetbrains.annotations.NotNull()
    private final org.jetbrains.kotlin.com.intellij.openapi.Disposable disposable = null;
    public org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreProjectEnvironment projectEnv;
    public java.util.List<? extends dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> modules;
    public java.util.List<org.jetbrains.kotlin.cli.jvm.index.JavaRoot> libraryRoots;
    public dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex ktSymbolIndex;
    public org.jetbrains.kotlin.psi.KtPsiFactory parser;
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.kotlin.compiler.AbstractCompilationEnvironment.Companion Companion = null;
    
    public AbstractCompilationEnvironment(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationKind kind, @org.jetbrains.annotations.NotNull()
    java.nio.file.Path intellijPluginRoot, @org.jetbrains.annotations.NotNull()
    java.nio.file.Path jdkHome, int jdkRelease, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.config.LanguageVersion languageVersion, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreApplicationEnvironmentMode applicationEnvironmentMode, boolean enableParserEventSystem) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationKind getKind() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.nio.file.Path getIntellijPluginRoot() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.nio.file.Path getJdkHome() {
        return null;
    }
    
    public final int getJdkRelease() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.config.LanguageVersion getLanguageVersion() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreApplicationEnvironmentMode getApplicationEnvironmentMode() {
        return null;
    }
    
    public final boolean getEnableParserEventSystem() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final org.jetbrains.kotlin.com.intellij.openapi.Disposable getDisposable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreProjectEnvironment getProjectEnv() {
        return null;
    }
    
    public final void setProjectEnv(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreProjectEnvironment p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreApplicationEnvironment getApplicationEnv() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.com.intellij.mock.MockApplication getApplication() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.com.intellij.mock.MockProject getProject() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> getModules() {
        return null;
    }
    
    public final void setModules(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<org.jetbrains.kotlin.cli.jvm.index.JavaRoot> getLibraryRoots() {
        return null;
    }
    
    public final void setLibraryRoots(@org.jetbrains.annotations.NotNull()
    java.util.List<org.jetbrains.kotlin.cli.jvm.index.JavaRoot> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex getKtSymbolIndex() {
        return null;
    }
    
    public final void setKtSymbolIndex(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.psi.KtPsiFactory getParser() {
        return null;
    }
    
    public final void setParser(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtPsiFactory p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.com.intellij.psi.PsiManager getPsiManager() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected abstract java.util.List<org.jetbrains.kotlin.analysis.api.standalone.base.projectStructure.AnalysisApiSimpleServiceRegistrar> createServiceRegistrars();
    
    /**
     * Wires platform services to [ktSymbolIndex], [modules], and [libraryRoots]
     * via [KtLspService.setupWith].  The default implementation calls [KtLspService.setupWith]
     * for all standard Analysis API services.
     */
    protected void setupServices(@org.jetbrains.annotations.NotNull()
    java.util.List<org.jetbrains.kotlin.cli.jvm.index.JavaRoot> libraryRoots) {
    }
    
    /**
     * Called at the end of [initialize]. Production uses this to start background indexing.
     */
    protected void postInit(@org.jetbrains.annotations.NotNull()
    java.util.List<org.jetbrains.kotlin.cli.jvm.index.JavaRoot> libraryRoots) {
    }
    
    /**
     * The [MessageCollector] used by the [CompilerConfiguration]. Defaults to no-op.
     */
    @org.jetbrains.annotations.NotNull()
    protected org.jetbrains.kotlin.cli.common.messages.MessageCollector createMessageCollector() {
        return null;
    }
    
    @kotlin.Suppress(names = {"UnstableApiUsage"})
    protected void initialize(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super org.jetbrains.kotlin.com.intellij.mock.MockProject, ? super org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreApplicationEnvironment, ? extends java.util.List<? extends dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule>> buildModules, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.util.List<? extends dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule>, ? super java.util.List<org.jetbrains.kotlin.cli.jvm.index.JavaRoot>, dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex> buildKtSymbolIndex) {
    }
    
    private final org.jetbrains.kotlin.config.CompilerConfiguration createCompilerConfiguration() {
        return null;
    }
    
    @java.lang.Override()
    public void close() {
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/AbstractCompilationEnvironment$Companion;", "", "<init>", "()V", "CLOSE_DRAIN_TIMEOUT", "Lkotlin/time/Duration;", "getCLOSE_DRAIN_TIMEOUT-UwyO8pc", "()J", "J", "kotlin_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}