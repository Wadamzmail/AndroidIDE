package dev.mutwakil.androidide.lsp.kotlin.compiler.services;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0018H\u0016J\'\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u001b\"\u00020\u001cH\u0016\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\r\u0010\"\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010#R\u0016\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/NoOpNonBlockingReadAction;", "T", "Lorg/jetbrains/kotlin/com/intellij/openapi/application/NonBlockingReadAction;", "callable", "Ljava/util/concurrent/Callable;", "<init>", "(Ljava/util/concurrent/Callable;)V", "inSmartMode", "project", "Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "withDocumentsCommitted", "expireWhen", "condition", "Ljava/util/function/BooleanSupplier;", "wrapProgress", "indicator", "Lorg/jetbrains/kotlin/com/intellij/openapi/progress/ProgressIndicator;", "expireWith", "disposable", "Lorg/jetbrains/kotlin/com/intellij/openapi/Disposable;", "finishOnUiThread", "modalityState", "Lorg/jetbrains/kotlin/com/intellij/openapi/application/ModalityState;", "uiThreadAction", "Ljava/util/function/Consumer;", "coalesceBy", "equality", "", "", "([Ljava/lang/Object;)Lorg/jetbrains/kotlin/com/intellij/openapi/application/NonBlockingReadAction;", "submit", "Lorg/jetbrains/concurrency/CancellablePromise;", "backgroundThreadExecutor", "Ljava/util/concurrent/Executor;", "executeSynchronously", "()Ljava/lang/Object;", "kotlin_debug"})
final class NoOpNonBlockingReadAction<T extends java.lang.Object> implements org.jetbrains.kotlin.com.intellij.openapi.application.NonBlockingReadAction<T> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.Callable<? extends T> callable = null;
    
    public NoOpNonBlockingReadAction(@org.jetbrains.annotations.NotNull()
    java.util.concurrent.Callable<? extends T> callable) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.kotlin.com.intellij.openapi.application.NonBlockingReadAction<T> inSmartMode(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.project.Project project) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.kotlin.com.intellij.openapi.application.NonBlockingReadAction<T> withDocumentsCommitted(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.project.Project project) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.kotlin.com.intellij.openapi.application.NonBlockingReadAction<T> expireWhen(@org.jetbrains.annotations.NotNull()
    java.util.function.BooleanSupplier condition) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.kotlin.com.intellij.openapi.application.NonBlockingReadAction<T> wrapProgress(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.progress.ProgressIndicator indicator) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.kotlin.com.intellij.openapi.application.NonBlockingReadAction<T> expireWith(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.Disposable disposable) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.kotlin.com.intellij.openapi.application.NonBlockingReadAction<T> finishOnUiThread(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.application.ModalityState modalityState, @org.jetbrains.annotations.NotNull()
    java.util.function.Consumer<? super T> uiThreadAction) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.kotlin.com.intellij.openapi.application.NonBlockingReadAction<T> coalesceBy(@org.jetbrains.annotations.NotNull()
    java.lang.Object... equality) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.concurrency.CancellablePromise<T> submit(@org.jetbrains.annotations.NotNull()
    java.util.concurrent.Executor backgroundThreadExecutor) {
        return null;
    }
    
    @java.lang.Override()
    public T executeSynchronously() {
        return null;
    }
}