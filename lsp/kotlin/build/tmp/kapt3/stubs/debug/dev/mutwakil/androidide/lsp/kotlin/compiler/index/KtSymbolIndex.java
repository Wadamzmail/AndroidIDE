package dev.mutwakil.androidide.lsp.kotlin.compiler.index;

/**
 * An index of symbols from Kotlin source files and JARs.
 *
 * NOTE: This index does not own the provided [fileIndex], [sourceIndex] and [libraryIndex].
 * Callers are responsible for closing the provided indexes.
 */
@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0000\u0018\u0000 W2\u00020\u0001:\u0002WXBV\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\r\b\u0002\u0010\u000e\u001a\u00070\u000f\u00a2\u0006\u0002\b\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010<\u001a\u00020=J\b\u0010>\u001a\u00020=H\u0002J\b\u0010?\u001a\u00020=H\u0002J\u0006\u0010@\u001a\u00020=J\u0012\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020*H\u0002J\u0016\u0010D\u001a\u00020=2\u0006\u0010C\u001a\u00020*H\u0086@\u00a2\u0006\u0002\u0010EJ\u0016\u0010F\u001a\u00020=2\u0006\u0010C\u001a\u00020*H\u0086@\u00a2\u0006\u0002\u0010EJ\u000e\u0010G\u001a\u00020=2\u0006\u0010H\u001a\u00020,J\u0016\u0010I\u001a\u00020=2\u0006\u0010H\u001a\u00020,H\u0086@\u00a2\u0006\u0002\u0010JJ\u0016\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,082\u0006\u0010C\u001a\u00020*J\"\u0010L\u001a\u0002092\u0006\u0010C\u001a\u00020*2\u0006\u0010M\u001a\u00020;2\b\u0010N\u001a\u0004\u0018\u00010,H\u0002J\u000e\u0010O\u001a\u00020=2\u0006\u0010C\u001a\u00020*J\u0010\u0010P\u001a\u0004\u0018\u00010,2\u0006\u0010C\u001a\u00020*J\u0010\u0010Q\u001a\u0004\u0018\u00010,2\u0006\u0010R\u001a\u00020BJ\u001c\u0010Q\u001a\u0004\u0018\u00010,2\u0006\u0010C\u001a\u00020*2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010BJ\u0010\u0010T\u001a\u00020,2\u0006\u0010R\u001a\u00020BH\u0002J\u000e\u0010U\u001a\u00020=H\u0086@\u00a2\u0006\u0002\u0010VR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\'\u001a\u0004\u0018\u00010&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R/\u0010(\u001a#\u0012\f\u0012\n +*\u0004\u0018\u00010*0*\u0012\f\u0012\n +*\u0004\u0018\u00010,0,0)\u00a2\u0006\u0002\b-X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020/X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u000205X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u00106\u001a\u0014\u0012\u0004\u0012\u00020*\u0012\n\u0012\b\u0012\u0004\u0012\u0002090807X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020;07X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006Y"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/KtSymbolIndex;", "", "kind", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationKind;", "project", "Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "modules", "", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/KtModule;", "fileIndex", "Lorg/appdevforall/codeonthego/indexing/jvm/KtFileMetadataIndex;", "sourceIndex", "Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbolIndex;", "libraryIndex", "cacheSize", "", "Lorg/checkerframework/checker/index/qual/NonNegative;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationKind;Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;Ljava/util/List;Lorg/appdevforall/codeonthego/indexing/jvm/KtFileMetadataIndex;Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbolIndex;Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbolIndex;JLkotlinx/coroutines/CoroutineScope;)V", "getKind", "()Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationKind;", "getProject", "()Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "getFileIndex", "()Lorg/appdevforall/codeonthego/indexing/jvm/KtFileMetadataIndex;", "getSourceIndex", "()Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbolIndex;", "getLibraryIndex", "workerQueue", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/WorkerQueue;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand;", "indexWorker", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexWorker;", "scanningWorker", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/ScanningWorker;", "scanningJob", "Lkotlinx/coroutines/Job;", "indexingJob", "ktFileCache", "Lcom/github/benmanes/caffeine/cache/Cache;", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "Lorg/jetbrains/kotlin/psi/KtFile;", "Lorg/checkerframework/checker/nullness/qual/NonNull;", "parser", "Lorg/jetbrains/kotlin/psi/KtPsiFactory;", "getParser", "()Lorg/jetbrains/kotlin/psi/KtPsiFactory;", "setParser", "(Lorg/jetbrains/kotlin/psi/KtPsiFactory;)V", "refreshExecutor", "Ljava/util/concurrent/ExecutorService;", "currentFiles", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CompletableFuture;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/KtSymbolIndex$VersionedKtFile;", "currentVersions", "", "syncIndexInBackground", "", "startIndexing", "startScanning", "refreshSources", "getVirtualFileOrWarn", "Lorg/jetbrains/kotlin/com/intellij/openapi/vfs/VirtualFile;", "path", "submitForIndexing", "(Ljava/nio/file/Path;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFromIndex", "queueOnFileChangedAsync", "ktFile", "queueOnFileChanged", "(Lorg/jetbrains/kotlin/psi/KtFile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentKtFile", "refreshToCurrent", "version", "old", "invalidateCurrent", "getCurrentKtFileIfPresent", "getKtFile", "vf", "virtualFile", "loadKtFile", "close", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "VersionedKtFile", "kotlin_debug"})
public final class KtSymbolIndex {
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationKind kind = null;
    @org.jetbrains.annotations.NotNull()
    private final org.jetbrains.kotlin.com.intellij.openapi.project.Project project = null;
    @org.jetbrains.annotations.NotNull()
    private final org.appdevforall.codeonthego.indexing.jvm.KtFileMetadataIndex fileIndex = null;
    @org.jetbrains.annotations.NotNull()
    private final org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex sourceIndex = null;
    @org.jetbrains.annotations.NotNull()
    private final org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex libraryIndex = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    private static final org.slf4j.Logger logger = null;
    public static final long DEFAULT_CACHE_SIZE = 100L;
    private static final long CLOSE_DRAIN_TIMEOUT_SECONDS = 5L;
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.lsp.kotlin.compiler.index.WorkerQueue<dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexCommand> workerQueue = null;
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexWorker indexWorker = null;
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.lsp.kotlin.compiler.index.ScanningWorker scanningWorker = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job scanningJob;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job indexingJob;
    @org.jetbrains.annotations.NotNull()
    private final com.github.benmanes.caffeine.cache.Cache<java.nio.file.Path, org.jetbrains.kotlin.psi.KtFile> ktFileCache = null;
    
    /**
     * Set by AbstractCompilationEnvironment.initialize once the env's KtPsiFactory exists.
     */
    public org.jetbrains.kotlin.psi.KtPsiFactory parser;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.ExecutorService refreshExecutor = null;
    
    /**
     * path -> in-flight/last-launched refresh; mutated only inside the per-key `compute` below.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.ConcurrentHashMap<java.nio.file.Path, java.util.concurrent.CompletableFuture<dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex.VersionedKtFile>> currentFiles = null;
    
    /**
     * path -> last-launched version; read/written only inside that same `compute` section.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.ConcurrentHashMap<java.nio.file.Path, java.lang.Integer> currentVersions = null;
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex.Companion Companion = null;
    
    public KtSymbolIndex(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationKind kind, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.project.Project project, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> modules, @org.jetbrains.annotations.NotNull()
    org.appdevforall.codeonthego.indexing.jvm.KtFileMetadataIndex fileIndex, @org.jetbrains.annotations.NotNull()
    org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex sourceIndex, @org.jetbrains.annotations.NotNull()
    org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex libraryIndex, long cacheSize, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationKind getKind() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.com.intellij.openapi.project.Project getProject() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.appdevforall.codeonthego.indexing.jvm.KtFileMetadataIndex getFileIndex() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex getSourceIndex() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex getLibraryIndex() {
        return null;
    }
    
    /**
     * Set by AbstractCompilationEnvironment.initialize once the env's KtPsiFactory exists.
     */
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.psi.KtPsiFactory getParser() {
        return null;
    }
    
    /**
     * Set by AbstractCompilationEnvironment.initialize once the env's KtPsiFactory exists.
     */
    public final void setParser(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtPsiFactory p0) {
    }
    
    public final void syncIndexInBackground() {
    }
    
    private final void startIndexing() {
    }
    
    private final void startScanning() {
    }
    
    public final void refreshSources() {
    }
    
    private final org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile getVirtualFileOrWarn(java.nio.file.Path path) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object submitForIndexing(@org.jetbrains.annotations.NotNull()
    java.nio.file.Path path, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object removeFromIndex(@org.jetbrains.annotations.NotNull()
    java.nio.file.Path path, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void queueOnFileChangedAsync(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtFile ktFile) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object queueOnFileChanged(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtFile ktFile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Returns the canonical [KtFile] for [path] at the current document version, parsing (once) on a
     * version miss. For non-open paths (no active document) falls back to the disk [getKtFile].
     * Single-flight: concurrent callers at the same version share one parse.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.concurrent.CompletableFuture<org.jetbrains.kotlin.psi.KtFile> getCurrentKtFile(@org.jetbrains.annotations.NotNull()
    java.nio.file.Path path) {
        return null;
    }
    
    /**
     * Parses [path]'s live document into a fresh [KtFile], registers it as the in-memory file, and
     * transitions the module's FIR session (invalidate + reindex) so later analysis sees the content.
     *
     * The result is stamped with [version] (captured when the refresh was launched) even though the
     * content is read later, here. FileManager writes version-before-content unsynchronized, so the
     * stamp may lag the content but never lead it: callers never get older-than-requested content, and
     * a lagging stamp only costs one redundant re-parse on the next request.
     */
    private final dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex.VersionedKtFile refreshToCurrent(java.nio.file.Path path, int version, org.jetbrains.kotlin.psi.KtFile old) {
        return null;
    }
    
    /**
     * Drops the cached current file for [path] (e.g. on close).
     */
    public final void invalidateCurrent(@org.jetbrains.annotations.NotNull()
    java.nio.file.Path path) {
    }
    
    /**
     * Non-blocking: the current cached instance for [path] if a refresh has already completed,
     * else `null`. Safe to call while holding `project.read` (unlike [getCurrentKtFile], which may
     * trigger a blocking refresh that needs `project.write`).
     */
    @org.jetbrains.annotations.Nullable()
    public final org.jetbrains.kotlin.psi.KtFile getCurrentKtFileIfPresent(@org.jetbrains.annotations.NotNull()
    java.nio.file.Path path) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.jetbrains.kotlin.psi.KtFile getKtFile(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile vf) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.jetbrains.kotlin.psi.KtFile getKtFile(@org.jetbrains.annotations.NotNull()
    java.nio.file.Path path, @org.jetbrains.annotations.Nullable()
    org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile virtualFile) {
        return null;
    }
    
    private final org.jetbrains.kotlin.psi.KtFile loadKtFile(org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile vf) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object close(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/KtSymbolIndex$Companion;", "", "<init>", "()V", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "DEFAULT_CACHE_SIZE", "", "CLOSE_DRAIN_TIMEOUT_SECONDS", "kotlin_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0003H\u00d6\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014H\u00d6\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/KtSymbolIndex$VersionedKtFile;", "", "version", "", "ktFile", "Lorg/jetbrains/kotlin/psi/KtFile;", "<init>", "(ILorg/jetbrains/kotlin/psi/KtFile;)V", "getVersion", "()I", "getKtFile", "()Lorg/jetbrains/kotlin/psi/KtFile;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "kotlin_debug"})
    static final class VersionedKtFile {
        private final int version = 0;
        @org.jetbrains.annotations.NotNull()
        private final org.jetbrains.kotlin.psi.KtFile ktFile = null;
        
        public VersionedKtFile(int version, @org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.psi.KtFile ktFile) {
            super();
        }
        
        public final int getVersion() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.psi.KtFile getKtFile() {
            return null;
        }
        
        public final int component1() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.psi.KtFile component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex.VersionedKtFile copy(int version, @org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.psi.KtFile ktFile) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}