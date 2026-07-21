package dev.mutwakil.androidide.lsp.kotlin.compiler.services;

/**
 * No-op [AsyncExecutionService] for standalone (non-IDE) environments.
 *
 * The real implementation requires an IDE event-dispatch / write-thread infrastructure that does
 * not exist in our standalone setup. Submitted tasks are run asynchronously on the common
 * ForkJoin pool so that stub rebuilds triggered by structural PSI changes don't block the
 * analysis thread or deadlock against the project read/write lock.
 */
@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0014J$\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f\"\u0004\b\u0000\u0010\u00102\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00100\u0012H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/NoOpAsyncExecutionService;", "Lorg/jetbrains/kotlin/com/intellij/openapi/application/AsyncExecutionService;", "<init>", "()V", "executor", "Lorg/jetbrains/kotlin/com/intellij/openapi/application/AppUIExecutor;", "createExecutor", "Lorg/jetbrains/kotlin/com/intellij/openapi/application/ExpirableExecutor;", "backgroundExecutor", "Ljava/util/concurrent/Executor;", "createUIExecutor", "modalityState", "Lorg/jetbrains/kotlin/com/intellij/openapi/application/ModalityState;", "createWriteThreadExecutor", "buildNonBlockingReadAction", "Lorg/jetbrains/kotlin/com/intellij/openapi/application/NonBlockingReadAction;", "T", "callable", "Ljava/util/concurrent/Callable;", "kotlin_debug"})
public final class NoOpAsyncExecutionService extends org.jetbrains.kotlin.com.intellij.openapi.application.AsyncExecutionService {
    @org.jetbrains.annotations.NotNull()
    private final org.jetbrains.kotlin.com.intellij.openapi.application.AppUIExecutor executor = null;
    
    public NoOpAsyncExecutionService() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected org.jetbrains.kotlin.com.intellij.openapi.application.ExpirableExecutor createExecutor(@org.jetbrains.annotations.NotNull()
    java.util.concurrent.Executor backgroundExecutor) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected org.jetbrains.kotlin.com.intellij.openapi.application.AppUIExecutor createUIExecutor(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.application.ModalityState modalityState) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected org.jetbrains.kotlin.com.intellij.openapi.application.AppUIExecutor createWriteThreadExecutor(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.application.ModalityState modalityState) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected <T extends java.lang.Object>org.jetbrains.kotlin.com.intellij.openapi.application.NonBlockingReadAction<T> buildNonBlockingReadAction(@org.jetbrains.annotations.NotNull()
    java.util.concurrent.Callable<? extends T> callable) {
        return null;
    }
}