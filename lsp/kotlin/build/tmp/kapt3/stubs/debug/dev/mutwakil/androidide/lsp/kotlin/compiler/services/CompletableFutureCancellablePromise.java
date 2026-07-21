package dev.mutwakil.androidide.lsp.kotlin.compiler.services;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\r\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\rJ\u001e\u0010\f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0002\u00a2\u0006\u0002\u0010\u0012J\b\u0010\u0007\u001a\u00020\u0013H\u0016J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0016H\u0016J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00180\u0016H\u0016J \u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0010\u0010\u0015\u001a\f\u0012\b\b\u0000\u0012\u0004\u0018\u00018\u00000\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u001dH\u0016J\u001d\u0010\u001f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016\u00a2\u0006\u0002\u0010!J,\u0010\"\u001a\b\u0012\u0004\u0012\u0002H#0\u001d\"\u0004\b\u0001\u0010#2\u0016\u0010\u0015\u001a\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u0002H#0$H\u0016J2\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0\u001d\"\u0004\b\u0001\u0010#2\u001c\u0010\u0015\u001a\u0018\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H#0\u001d0$H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/CompletableFutureCancellablePromise;", "T", "Lorg/jetbrains/concurrency/CancellablePromise;", "future", "Ljava/util/concurrent/CompletableFuture;", "<init>", "(Ljava/util/concurrent/CompletableFuture;)V", "cancel", "", "mayInterruptIfRunning", "isCancelled", "isDone", "get", "()Ljava/lang/Object;", "timeout", "", "unit", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "", "onSuccess", "handler", "Ljava/util/function/Consumer;", "onError", "", "onProcessed", "getState", "Lorg/jetbrains/concurrency/Promise$State;", "processed", "Lorg/jetbrains/concurrency/Promise;", "child", "blockingGet", "", "(ILjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "then", "SUB_RESULT", "Lorg/jetbrains/kotlin/com/intellij/util/Function;", "thenAsync", "kotlin_debug"})
final class CompletableFutureCancellablePromise<T extends java.lang.Object> implements org.jetbrains.concurrency.CancellablePromise<T> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.CompletableFuture<T> future = null;
    
    public CompletableFutureCancellablePromise(@org.jetbrains.annotations.NotNull()
    java.util.concurrent.CompletableFuture<T> future) {
        super();
    }
    
    @java.lang.Override()
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }
    
    @java.lang.Override()
    public boolean isCancelled() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isDone() {
        return false;
    }
    
    @java.lang.Override()
    public T get() {
        return null;
    }
    
    @java.lang.Override()
    public T get(long timeout, @org.jetbrains.annotations.NotNull()
    java.util.concurrent.TimeUnit unit) {
        return null;
    }
    
    @java.lang.Override()
    public void cancel() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.concurrency.CancellablePromise<T> onSuccess(@org.jetbrains.annotations.NotNull()
    java.util.function.Consumer<? super T> handler) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.concurrency.CancellablePromise<T> onError(@org.jetbrains.annotations.NotNull()
    java.util.function.Consumer<? super java.lang.Throwable> handler) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.concurrency.CancellablePromise<T> onProcessed(@org.jetbrains.annotations.NotNull()
    java.util.function.Consumer<? super T> handler) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.concurrency.Promise.State getState() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.concurrency.Promise<T> processed(@org.jetbrains.annotations.NotNull()
    org.jetbrains.concurrency.Promise<? super T> child) {
        return null;
    }
    
    @java.lang.Override()
    public T blockingGet(int timeout, @org.jetbrains.annotations.NotNull()
    java.util.concurrent.TimeUnit unit) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public <SUB_RESULT extends java.lang.Object>org.jetbrains.concurrency.Promise<SUB_RESULT> then(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.util.Function<? super T, ? extends SUB_RESULT> handler) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public <SUB_RESULT extends java.lang.Object>org.jetbrains.concurrency.Promise<SUB_RESULT> thenAsync(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.util.Function<? super T, ? extends org.jetbrains.concurrency.Promise<SUB_RESULT>> handler) {
        return null;
    }
}