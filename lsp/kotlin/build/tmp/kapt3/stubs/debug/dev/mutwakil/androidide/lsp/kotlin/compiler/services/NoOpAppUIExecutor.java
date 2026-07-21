package dev.mutwakil.androidide.lsp.kotlin.compiler.services;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0001H\u0016J\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\b\u0000\u0010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0014H\u0016J\u0014\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0016\u00a8\u0006\u0015"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/NoOpAppUIExecutor;", "Lorg/jetbrains/kotlin/com/intellij/openapi/application/AppUIExecutor;", "<init>", "()V", "later", "withDocumentsCommitted", "project", "Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "inSmartMode", "expireWith", "disposable", "Lorg/jetbrains/kotlin/com/intellij/openapi/Disposable;", "execute", "", "runnable", "Ljava/lang/Runnable;", "submit", "Lorg/jetbrains/concurrency/CancellablePromise;", "T", "callable", "Ljava/util/concurrent/Callable;", "kotlin_debug"})
final class NoOpAppUIExecutor implements org.jetbrains.kotlin.com.intellij.openapi.application.AppUIExecutor {
    
    public NoOpAppUIExecutor() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.kotlin.com.intellij.openapi.application.AppUIExecutor later() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.kotlin.com.intellij.openapi.application.AppUIExecutor withDocumentsCommitted(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.project.Project project) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.kotlin.com.intellij.openapi.application.AppUIExecutor inSmartMode(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.project.Project project) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.kotlin.com.intellij.openapi.application.AppUIExecutor expireWith(@org.jetbrains.annotations.NotNull()
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