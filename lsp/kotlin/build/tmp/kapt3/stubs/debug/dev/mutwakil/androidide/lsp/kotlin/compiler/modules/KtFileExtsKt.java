package dev.mutwakil.androidide.lsp.kotlin.compiler.modules;

@kotlin.Metadata(mv = {2, 3, 0}, k = 2, xi = 48, d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0012H\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013\u001a:\u0010\u0014\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0019\b\u0004\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u0002H\u00100\u0017\u00a2\u0006\u0002\b\u0019H\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001a\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"=\u0010\u0005\u001a\t\u0018\u00010\u0002\u00a2\u0006\u0002\b\u0004*\u00020\u00062\r\u0010\u0003\u001a\t\u0018\u00010\u0002\u00a2\u0006\u0002\b\u00048F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\"\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001b"}, d2 = {"KT_LSP_COMPLETION_BACKING_FILE", "Lorg/jetbrains/kotlin/com/intellij/openapi/util/Key;", "Ljava/nio/file/Path;", "<set-?>", "Lorg/jetbrains/annotations/Nullable;", "backingFilePath", "Lorg/jetbrains/kotlin/psi/KtFile;", "getBackingFilePath", "(Lorg/jetbrains/kotlin/psi/KtFile;)Ljava/nio/file/Path;", "setBackingFilePath", "(Lorg/jetbrains/kotlin/psi/KtFile;Ljava/nio/file/Path;)V", "backingFilePath$delegate", "Lorg/jetbrains/kotlin/psi/UserDataProperty;", "analysisLock", "Ljava/util/concurrent/locks/ReentrantLock;", "withAnalysisLock", "R", "action", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "analyzeMaybeDangling", "useSiteElement", "Lorg/jetbrains/kotlin/psi/KtElement;", "Lkotlin/Function1;", "Lorg/jetbrains/kotlin/analysis/api/KaSession;", "Lkotlin/ExtensionFunctionType;", "(Lorg/jetbrains/kotlin/psi/KtElement;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin_debug"})
public final class KtFileExtsKt {
    @org.jetbrains.annotations.NotNull()
    private static final org.jetbrains.kotlin.com.intellij.openapi.util.Key<java.nio.file.Path> KT_LSP_COMPLETION_BACKING_FILE = null;
    @org.jetbrains.annotations.NotNull()
    private static final org.jetbrains.kotlin.psi.UserDataProperty backingFilePath$delegate = null;
    
    /**
     * Serializes all Kotlin Analysis API access (`analyze` / `analyzeCopy`).
     *
     * The Analysis API tracks its `analyze` lifetime context in a per-thread stack and is not safe to
     * drive concurrently from multiple background threads without the platform read-action coordination
     * that this LSP replaces with a custom [dev.mutwakil.androidide.lsp.kotlin.compiler.read] lock.
     * Indexing, diagnostics and completion all run analysis on `Dispatchers.Default` and frequently
     * target the same edited file, so overlapping `analyze` calls corrupted the lifetime/session
     * lifecycle and surfaced as
     * `KaInaccessibleLifetimeOwnerAccessException: ... Called outside an \`analyze\` context.`
     *
     * Holding this lock around every analysis entry point makes analyses mutually exclusive. It is a
     * [ReentrantLock] so an (indirect) nested analysis on the same thread cannot deadlock.
     *
     * **Footgun:** analysis runs under the *read* (shared) side of the global
     * [dev.mutwakil.androidide.lsp.kotlin.compiler.read] lock, and that `ReentrantReadWriteLock` is
     * non-upgradeable. Code running inside [withAnalysisLock] / an `analyze` block must therefore never
     * call [dev.mutwakil.androidide.lsp.kotlin.compiler.write] — upgrading read → write on the same thread
     * deadlocks.
     */
    @org.jetbrains.annotations.NotNull()
    private static final java.util.concurrent.locks.ReentrantLock analysisLock = null;
    
    @org.jetbrains.annotations.Nullable()
    public static final java.nio.file.Path getBackingFilePath(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtFile $this$backingFilePath) {
        return null;
    }
    
    public static final void setBackingFilePath(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtFile $this$backingFilePath, @org.jetbrains.annotations.Nullable()
    java.nio.file.Path p1) {
    }
    
    /**
     * Runs [action] while holding the shared [analysisLock]. **All** Analysis API access must go through
     * this helper (or [analyzeMaybeDangling], which already does); never call `analyze` / `analyzeCopy`
     * directly, or the serialization guarantee is lost.
     */
    public static final <R extends java.lang.Object>R withAnalysisLock(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends R> action) {
        return null;
    }
    
    public static final <R extends java.lang.Object>R analyzeMaybeDangling(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtElement useSiteElement, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super org.jetbrains.kotlin.analysis.api.KaSession, ? extends R> action) {
        return null;
    }
}