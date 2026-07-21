package dev.mutwakil.androidide.lsp.kotlin.compiler.services;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0011H\u0016J\u0014\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/NoOpExpirableExecutor;", "Lorg/jetbrains/kotlin/com/intellij/openapi/application/ExpirableExecutor;", "exec", "Ljava/util/concurrent/Executor;", "<init>", "(Ljava/util/concurrent/Executor;)V", "expireWith", "disposable", "Lorg/jetbrains/kotlin/com/intellij/openapi/Disposable;", "execute", "", "runnable", "Ljava/lang/Runnable;", "submit", "Lorg/jetbrains/concurrency/CancellablePromise;", "T", "callable", "Ljava/util/concurrent/Callable;", "kotlin_debug"})
final class NoOpExpirableExecutor implements org.jetbrains.kotlin.com.intellij.openapi.application.ExpirableExecutor {
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.Executor exec = null;
    
    public NoOpExpirableExecutor(@org.jetbrains.annotations.NotNull()
    java.util.concurrent.Executor exec) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.kotlin.com.intellij.openapi.application.ExpirableExecutor expireWith(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.Disposable disposable) {
        return null;
    }
    
    @java.lang.Override()
    public void execute(@org.jetbrains.annotations.NotNull()
    java.lang.Runnable runnable) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public <T extends java.lang.Object>org.jetbrains.concurrency.CancellablePromise<T> submit(@org.jetbrains.annotations.NotNull()
    java.util.concurrent.Callable<T> callable) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.concurrency.CancellablePromise<?> submit(@org.jetbrains.annotations.NotNull()
    java.lang.Runnable runnable) {
        return null;
    }
}