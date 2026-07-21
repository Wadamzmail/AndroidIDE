package dev.mutwakil.androidide.lsp.kotlin.compiler;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u00070\u0007\u00a2\u0006\u0002\b\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/KotlinApplicationEnvironmentPin;", "", "<init>", "()V", "pinned", "", "pin", "Lorg/jetbrains/kotlin/com/intellij/openapi/Disposable;", "Lorg/jetbrains/annotations/NotNull;", "ensure", "", "configuration", "Lorg/jetbrains/kotlin/config/CompilerConfiguration;", "kotlin_debug"})
@kotlin.OptIn(markerClass = {org.jetbrains.kotlin.K1Deprecation.class})
public final class KotlinApplicationEnvironmentPin {
    private static boolean pinned = false;
    @org.jetbrains.annotations.NotNull()
    private static final org.jetbrains.kotlin.com.intellij.openapi.Disposable pin = null;
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.kotlin.compiler.KotlinApplicationEnvironmentPin INSTANCE = null;
    
    private KotlinApplicationEnvironmentPin() {
        super();
    }
    
    @kotlin.jvm.Synchronized()
    public final synchronized void ensure(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.config.CompilerConfiguration configuration) {
    }
}