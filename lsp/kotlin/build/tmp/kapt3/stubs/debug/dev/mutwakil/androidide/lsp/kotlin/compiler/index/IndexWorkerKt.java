package dev.mutwakil.androidide.lsp.kotlin.compiler.index;

@kotlin.Metadata(mv = {2, 3, 0}, k = 2, xi = 48, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aJ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\fH\u0080@\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2 = {"applyRemovals", "", "first", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand$RemoveFromIndex;", "fileIndex", "Lorg/appdevforall/codeonthego/indexing/jvm/KtFileMetadataIndex;", "sourceIndex", "Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbolIndex;", "pollNext", "Lkotlin/Function0;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand;", "pushBack", "Lkotlin/Function1;", "(Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand$RemoveFromIndex;Lorg/appdevforall/codeonthego/indexing/jvm/KtFileMetadataIndex;Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbolIndex;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin_debug"})
public final class IndexWorkerKt {
    
    /**
     * Apply [first] plus any consecutive, immediately-available [IndexCommand.RemoveFromIndex]
     * commands as a single batched removal.
     *
     * The symbol removals and the per-file metadata removals are each collapsed into one
     * batched call — [JvmSymbolIndex.removeBySources] and [KtFileMetadataIndex.removeAll], a
     * single SQLite transaction apiece — instead of issuing one `DELETE` per file (one
     * transaction each), which is the N+1 this fix targets (Sentry APPDEVFORALL-SE).
     *
     * [pollNext] returns the next already-queued index command without blocking, or `null`
     * when none is ready. A polled command that is *not* a removal is handed to [pushBack] so
     * it is processed (in order) on the next loop iteration rather than dropped.
     *
     * @param first      The removal command that triggered this batch.
     * @param fileIndex  Per-file metadata index; removed via the batched [KtFileMetadataIndex.removeAll].
     * @param sourceIndex Symbol index; removed via the batched [JvmSymbolIndex.removeBySources].
     * @param pollNext   Non-blocking poll of the next queued index command.
     * @param pushBack   Returns a non-removal command to the front of the queue.
     */
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Object applyRemovals(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexCommand.RemoveFromIndex first, @org.jetbrains.annotations.NotNull()
    org.appdevforall.codeonthego.indexing.jvm.KtFileMetadataIndex fileIndex, @org.jetbrains.annotations.NotNull()
    org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex sourceIndex, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexCommand> pollNext, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexCommand, kotlin.Unit> pushBack, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}