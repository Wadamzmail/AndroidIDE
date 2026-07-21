package dev.mutwakil.androidide.lsp.kotlin.compiler.util;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0011\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J9\u0010\u0012\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0014\"\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0002\u0010\u0015R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/util/SLF4JLogger;", "Lorg/jetbrains/kotlin/com/intellij/openapi/diagnostic/Logger;", "name", "", "<init>", "(Ljava/lang/String;)V", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "isDebugEnabled", "", "debug", "", "message", "t", "", "info", "warn", "error", "details", "", "(Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/String;)V", "kotlin_debug"})
public final class SLF4JLogger extends org.jetbrains.kotlin.com.intellij.openapi.diagnostic.Logger {
    private final org.slf4j.Logger logger = null;
    
    public SLF4JLogger(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        super();
    }
    
    @java.lang.Override()
    public boolean isDebugEnabled() {
        return false;
    }
    
    @java.lang.Override()
    public void debug(@org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Throwable t) {
    }
    
    @java.lang.Override()
    public void info(@org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Throwable t) {
    }
    
    @java.lang.Override()
    public void warn(@org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Throwable t) {
    }
    
    @java.lang.Override()
    public void error(@org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Throwable t, @org.jetbrains.annotations.NotNull()
    java.lang.String... details) {
    }
}