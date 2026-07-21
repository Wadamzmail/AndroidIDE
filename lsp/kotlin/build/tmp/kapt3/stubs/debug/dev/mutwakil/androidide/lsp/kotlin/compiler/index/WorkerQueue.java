package dev.mutwakil.androidide.lsp.kotlin.compiler.index;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0086@\u00a2\u0006\u0002\u0010\u000eJ\r\u0010\u0011\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00028\u0000H\u0086@\u00a2\u0006\u0002\u0010\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00018\u0000X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\n\u00a8\u0006\u0017"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/WorkerQueue;", "T", "", "<init>", "()V", "scanChannel", "Lkotlinx/coroutines/channels/Channel;", "editChannel", "indexChannel", "pushedBack", "Ljava/lang/Object;", "putScanQueue", "", "item", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putEditQueue", "putIndexQueue", "pollIndexQueue", "()Ljava/lang/Object;", "pushBackIndexQueue", "(Ljava/lang/Object;)V", "take", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin_debug"})
public final class WorkerQueue<T extends java.lang.Object> {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<T> scanChannel = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<T> editChannel = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<T> indexChannel = null;
    @org.jetbrains.annotations.Nullable()
    private T pushedBack;
    
    public WorkerQueue() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object putScanQueue(T item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object putEditQueue(T item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object putIndexQueue(T item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Non-blocking poll of the index queue. Returns the next already-available
     * index-queue item, or `null` if none is immediately ready.
     *
     * Used to coalesce a run of consecutive removal commands into a single
     * batched index operation (see [IndexWorker]) instead of issuing one
     * transaction per command. A polled item that is not batchable must be
     * returned via [pushBackIndexQueue] so it is not dropped.
     */
    @org.jetbrains.annotations.Nullable()
    public final T pollIndexQueue() {
        return null;
    }
    
    /**
     * Return an item previously obtained from [pollIndexQueue] to the front of
     * the queue so the next [take] yields it before any channel item. At most
     * one item may be pushed back at a time.
     */
    public final void pushBackIndexQueue(T item) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object take(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super T> $completion) {
        return null;
    }
}