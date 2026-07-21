package dev.mutwakil.androidide.lsp.kotlin.compiler;

/**
 * A compilation environment for compiling Kotlin sources.
 *
 * @param intellijPluginRoot The IntelliJ plugin root. This is usually the embeddable JAR location. Required.
 * @param languageVersion The language version this environment should target.
 * @param jdkHome Path to the JDK installation directory.
 * @param jdkRelease The JDK release version at [jdkHome].
 */
@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u00be\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 l2\u00020\u00012\u00020\u0002:\u0001lB]\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0016\u0010\u0017J$\u0010B\u001a\u00020C2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020F0E2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020H0EH\u0002J\u001e\u0010I\u001a\b\u0012\u0004\u0012\u00020F0E2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0002J\u000e\u0010N\u001a\b\u0012\u0004\u0012\u00020O0EH\u0014J\b\u0010P\u001a\u00020QH\u0014J\u0016\u0010R\u001a\u00020S2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020H0EH\u0014J\u0006\u0010T\u001a\u00020SJ\u000e\u0010U\u001a\u00020S2\u0006\u0010V\u001a\u00020\fJ\u000e\u0010W\u001a\u00020S2\u0006\u0010V\u001a\u00020\fJ\u000e\u0010X\u001a\u00020S2\u0006\u0010V\u001a\u00020\fJ\u000e\u0010Y\u001a\u00020S2\u0006\u0010V\u001a\u00020\fJ\'\u0010Z\u001a\u00020S2\u0006\u0010V\u001a\u00020\f2\u0014\b\u0004\u0010[\u001a\u000e\u0012\u0004\u0012\u00020]\u0012\u0004\u0012\u00020^0\\H\u0082\bJ\u0016\u0010_\u001a\u00020S2\u0006\u0010V\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010`J\u0016\u0010a\u001a\u00020S2\u0006\u0010V\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010`J\u001e\u0010b\u001a\u00020S2\u0006\u0010c\u001a\u00020\f2\u0006\u0010d\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010eJ\u000e\u0010f\u001a\u00020S2\u0006\u0010V\u001a\u00020\fJ\b\u0010g\u001a\u00020SH\u0016J\u0018\u0010h\u001a\u00020S2\u0006\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020kH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0013\u0010$\u001a\u0004\u0018\u00010%8F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\'R\u0011\u0010(\u001a\u00020%8F\u00a2\u0006\u0006\u001a\u0004\b)\u0010\'R\u0013\u0010*\u001a\u0004\u0018\u00010%8F\u00a2\u0006\u0006\u001a\u0004\b+\u0010\'R\u0011\u0010,\u001a\u00020%8F\u00a2\u0006\u0006\u001a\u0004\b-\u0010\'R\u0013\u0010.\u001a\u0004\u0018\u00010/8F\u00a2\u0006\u0006\u001a\u0004\b0\u00101R\u0011\u00102\u001a\u00020/8F\u00a2\u0006\u0006\u001a\u0004\b3\u00101R\u0013\u00104\u001a\u0004\u0018\u00010%8F\u00a2\u0006\u0006\u001a\u0004\b5\u0010\'R\u001b\u00106\u001a\u0002078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b8\u00109R(\u0010=\u001a\u0004\u0018\u00010\u001d2\b\u0010<\u001a\u0004\u0018\u00010\u001d8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A\u00a8\u0006m"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationEnvironment;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/AbstractCompilationEnvironment;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/KotlinProjectModel$ProjectModelListener;", "name", "", "kind", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationKind;", "workspace", "Ldev/mutwakil/androidide/projects/IWorkspace;", "ktProject", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/KotlinProjectModel;", "intellijPluginRoot", "Ljava/nio/file/Path;", "jdkHome", "jdkRelease", "", "languageVersion", "Lorg/jetbrains/kotlin/config/LanguageVersion;", "enableParserEventSystem", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ljava/lang/String;Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationKind;Ldev/mutwakil/androidide/projects/IWorkspace;Ldev/mutwakil/androidide/lsp/kotlin/compiler/KotlinProjectModel;Ljava/nio/file/Path;Ljava/nio/file/Path;ILorg/jetbrains/kotlin/config/LanguageVersion;ZLkotlinx/coroutines/CoroutineScope;)V", "getKtProject", "()Ldev/mutwakil/androidide/lsp/kotlin/compiler/KotlinProjectModel;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "_languageClient", "Ldev/mutwakil/androidide/lsp/api/ILanguageClient;", "fileAnalyzer", "Ldev/mutwakil/androidide/utils/KeyedDebouncingAction;", "getFileAnalyzer", "()Ldev/mutwakil/androidide/utils/KeyedDebouncingAction;", "refreshScheduler", "getRefreshScheduler", "libraryIndex", "Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbolIndex;", "getLibraryIndex", "()Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbolIndex;", "requireLibraryIndex", "getRequireLibraryIndex", "sourceIndex", "getSourceIndex", "requireSourceIndex", "getRequireSourceIndex", "fileIndex", "Lorg/appdevforall/codeonthego/indexing/jvm/KtFileMetadataIndex;", "getFileIndex", "()Lorg/appdevforall/codeonthego/indexing/jvm/KtFileMetadataIndex;", "requireFileIndex", "getRequireFileIndex", "generatedIndex", "getGeneratedIndex", "symbolVisibilityChecker", "Ldev/mutwakil/androidide/lsp/kotlin/utils/SymbolVisibilityChecker;", "getSymbolVisibilityChecker", "()Ldev/mutwakil/androidide/lsp/kotlin/utils/SymbolVisibilityChecker;", "symbolVisibilityChecker$delegate", "Lkotlin/Lazy;", "value", "languageClient", "getLanguageClient", "()Ldev/mutwakil/androidide/lsp/api/ILanguageClient;", "setLanguageClient", "(Ldev/mutwakil/androidide/lsp/api/ILanguageClient;)V", "buildKtSymbolIndex", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/KtSymbolIndex;", "modules", "", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/KtModule;", "libraryRoots", "Lorg/jetbrains/kotlin/cli/jvm/index/JavaRoot;", "buildModules", "project", "Lorg/jetbrains/kotlin/com/intellij/mock/MockProject;", "applicationEnv", "Lorg/jetbrains/kotlin/cli/jvm/compiler/KotlinCoreApplicationEnvironment;", "createServiceRegistrars", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/LspAnalysisApiServiceRegistrar;", "createMessageCollector", "Lorg/jetbrains/kotlin/cli/common/messages/MessageCollector;", "postInit", "", "refreshSources", "openFileIfNeeded", "path", "onFileOpen", "onFileSaved", "onFileClosed", "notifyElementModifiedForPath", "typeProvider", "Lkotlin/Function1;", "Lorg/jetbrains/kotlin/psi/KtFile;", "Lorg/jetbrains/kotlin/analysis/api/platform/modification/KaElementModificationType;", "onFileCreated", "(Ljava/nio/file/Path;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onFileRemoved", "onFileMoved", "fromPath", "toPath", "(Ljava/nio/file/Path;Ljava/nio/file/Path;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onFileContentChanged", "close", "onProjectModelChanged", "model", "changeKind", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/KotlinProjectModel$ChangeKind;", "Companion", "kotlin_debug"})
public final class CompilationEnvironment extends dev.mutwakil.androidide.lsp.kotlin.compiler.AbstractCompilationEnvironment implements dev.mutwakil.androidide.lsp.kotlin.compiler.KotlinProjectModel.ProjectModelListener {
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.projects.IWorkspace workspace = null;
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.lsp.kotlin.compiler.KotlinProjectModel ktProject = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    private static final long DEFAULT_FILE_MOD_EVENT_DEBOUNCE_DURATION = 0L;
    private static final org.slf4j.Logger logger = null;
    @org.jetbrains.annotations.Nullable()
    private dev.mutwakil.androidide.lsp.api.ILanguageClient _languageClient;
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.utils.KeyedDebouncingAction<java.nio.file.Path> fileAnalyzer = null;
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.utils.KeyedDebouncingAction<java.nio.file.Path> refreshScheduler = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy symbolVisibilityChecker$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationEnvironment.Companion Companion = null;
    
    public CompilationEnvironment(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationKind kind, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.projects.IWorkspace workspace, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.KotlinProjectModel ktProject, @org.jetbrains.annotations.NotNull()
    java.nio.file.Path intellijPluginRoot, @org.jetbrains.annotations.NotNull()
    java.nio.file.Path jdkHome, int jdkRelease, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.config.LanguageVersion languageVersion, boolean enableParserEventSystem, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope coroutineScope) {
        super(null, null, null, null, 0, null, null, false);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.lsp.kotlin.compiler.KotlinProjectModel getKtProject() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.CoroutineScope getCoroutineScope() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.utils.KeyedDebouncingAction<java.nio.file.Path> getFileAnalyzer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.utils.KeyedDebouncingAction<java.nio.file.Path> getRefreshScheduler() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex getLibraryIndex() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex getRequireLibraryIndex() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex getSourceIndex() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex getRequireSourceIndex() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.appdevforall.codeonthego.indexing.jvm.KtFileMetadataIndex getFileIndex() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.appdevforall.codeonthego.indexing.jvm.KtFileMetadataIndex getRequireFileIndex() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex getGeneratedIndex() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.lsp.kotlin.utils.SymbolVisibilityChecker getSymbolVisibilityChecker() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final dev.mutwakil.androidide.lsp.api.ILanguageClient getLanguageClient() {
        return null;
    }
    
    public final void setLanguageClient(@org.jetbrains.annotations.Nullable()
    dev.mutwakil.androidide.lsp.api.ILanguageClient value) {
    }
    
    @kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaImplementationDetail.class})
    @kotlin.Suppress(names = {"UNUSED_PARAMETER"})
    private final dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex buildKtSymbolIndex(java.util.List<? extends dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> modules, java.util.List<org.jetbrains.kotlin.cli.jvm.index.JavaRoot> libraryRoots) {
        return null;
    }
    
    private final java.util.List<dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> buildModules(org.jetbrains.kotlin.com.intellij.mock.MockProject project, org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreApplicationEnvironment applicationEnv) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected java.util.List<dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.LspAnalysisApiServiceRegistrar> createServiceRegistrars() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected org.jetbrains.kotlin.cli.common.messages.MessageCollector createMessageCollector() {
        return null;
    }
    
    @java.lang.Override()
    protected void postInit(@org.jetbrains.annotations.NotNull()
    java.util.List<org.jetbrains.kotlin.cli.jvm.index.JavaRoot> libraryRoots) {
    }
    
    public final void refreshSources() {
    }
    
    public final void openFileIfNeeded(@org.jetbrains.annotations.NotNull()
    java.nio.file.Path path) {
    }
    
    public final void onFileOpen(@org.jetbrains.annotations.NotNull()
    java.nio.file.Path path) {
    }
    
    public final void onFileSaved(@org.jetbrains.annotations.NotNull()
    java.nio.file.Path path) {
    }
    
    public final void onFileClosed(@org.jetbrains.annotations.NotNull()
    java.nio.file.Path path) {
    }
    
    @kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaImplementationDetail.class})
    private final void notifyElementModifiedForPath(java.nio.file.Path path, kotlin.jvm.functions.Function1<? super org.jetbrains.kotlin.psi.KtFile, ? extends org.jetbrains.kotlin.analysis.api.platform.modification.KaElementModificationType> typeProvider) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object onFileCreated(@org.jetbrains.annotations.NotNull()
    java.nio.file.Path path, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object onFileRemoved(@org.jetbrains.annotations.NotNull()
    java.nio.file.Path path, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object onFileMoved(@org.jetbrains.annotations.NotNull()
    java.nio.file.Path fromPath, @org.jetbrains.annotations.NotNull()
    java.nio.file.Path toPath, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void onFileContentChanged(@org.jetbrains.annotations.NotNull()
    java.nio.file.Path path) {
    }
    
    @java.lang.Override()
    public void close() {
    }
    
    @java.lang.Override()
    public void onProjectModelChanged(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.KotlinProjectModel model, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.KotlinProjectModel.ChangeKind changeKind) {
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationEnvironment$Companion;", "", "<init>", "()V", "DEFAULT_FILE_MOD_EVENT_DEBOUNCE_DURATION", "Lkotlin/time/Duration;", "getDEFAULT_FILE_MOD_EVENT_DEBOUNCE_DURATION-UwyO8pc", "()J", "J", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "kotlin_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}