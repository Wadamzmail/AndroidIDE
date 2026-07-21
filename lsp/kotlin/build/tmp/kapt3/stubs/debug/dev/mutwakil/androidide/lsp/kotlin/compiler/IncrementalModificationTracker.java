package dev.mutwakil.androidide.lsp.kotlin.compiler;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0000J\t\u0010\u0007\u001a\u00020\u0000H\u0086\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/IncrementalModificationTracker;", "Lorg/jetbrains/kotlin/com/intellij/openapi/util/ModificationTracker;", "<init>", "()V", "myCounter", "Ljava/util/concurrent/atomic/AtomicLong;", "incModificationCount", "inc", "getModificationCount", "", "kotlin_debug"})
public final class IncrementalModificationTracker implements org.jetbrains.kotlin.com.intellij.openapi.util.ModificationTracker {
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.atomic.AtomicLong myCounter = null;
    
    public IncrementalModificationTracker() {
        super();
    }
    
    /**
     * Increment the modification count.
     */
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.lsp.kotlin.compiler.IncrementalModificationTracker incModificationCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.lsp.kotlin.compiler.IncrementalModificationTracker inc() {
        return null;
    }
    
    @java.lang.Override()
    public long getModificationCount() {
        return 0L;
    }
}