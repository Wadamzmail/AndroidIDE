package dev.mutwakil.androidide.lsp.kotlin.compiler;

/**
 * The kind of compilation being performed in a [Compiler].
 */
@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u000b\fJ\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\r\u000e\u00a8\u0006\u000f\u00c0\u0006\u0003"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationKind;", "", "fileExtensions", "", "", "getFileExtensions", "()Ljava/util/List;", "acceptsFile", "", "path", "Ljava/nio/file/Path;", "Default", "Script", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationKind$Default;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationKind$Script;", "kotlin_debug"})
public abstract interface CompilationKind {
    
    /**
     * The types of files this compilation kind accepts.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<java.lang.String> getFileExtensions();
    
    /**
     * Whether this compilation kind accepts the given file path. The default
     * implementation simply checks the accepted [fileExtensions].
     */
    public default boolean acceptsFile(@org.jetbrains.annotations.NotNull()
    java.nio.file.Path path) {
        return false;
    }
    
    /**
     * The default compilation kind. Mostly used for normal Kotlin source files.
     */
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\n\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0083\u0004J\n\u0010\r\u001a\u00020\u000eH\u00d6\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0006H\u00d6\u0081\u0004R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationKind$Default;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationKind;", "<init>", "()V", "fileExtensions", "", "", "getFileExtensions", "()Ljava/util/List;", "equals", "", "other", "", "hashCode", "", "toString", "kotlin_debug"})
    public static final class Default implements dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationKind {
        @org.jetbrains.annotations.NotNull()
        private static final java.util.List<java.lang.String> fileExtensions = null;
        @org.jetbrains.annotations.NotNull()
        public static final dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationKind.Default INSTANCE = null;
        
        private Default() {
            super();
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.util.List<java.lang.String> getFileExtensions() {
            return null;
        }
        
        @java.lang.Override()
        public boolean acceptsFile(@org.jetbrains.annotations.NotNull()
        java.nio.file.Path path) {
            return false;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    /**
     * The kind of compilation being performed in a [Compiler].
     */
    @kotlin.Metadata(mv = {2, 3, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
        
        /**
         * Whether this compilation kind accepts the given file path. The default
         * implementation simply checks the accepted [fileExtensions].
         */
        @java.lang.Deprecated()
        public static boolean acceptsFile(@org.jetbrains.annotations.NotNull()
        dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationKind $this, @org.jetbrains.annotations.NotNull()
        java.nio.file.Path path) {
            return false;
        }
    }
    
    /**
     * Compilation kind for compiling Kotlin scripts.
     */
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\n\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0083\u0004J\n\u0010\r\u001a\u00020\u000eH\u00d6\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0006H\u00d6\u0081\u0004R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationKind$Script;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationKind;", "<init>", "()V", "fileExtensions", "", "", "getFileExtensions", "()Ljava/util/List;", "equals", "", "other", "", "hashCode", "", "toString", "kotlin_debug"})
    public static final class Script implements dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationKind {
        @org.jetbrains.annotations.NotNull()
        private static final java.util.List<java.lang.String> fileExtensions = null;
        @org.jetbrains.annotations.NotNull()
        public static final dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationKind.Script INSTANCE = null;
        
        private Script() {
            super();
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.util.List<java.lang.String> getFileExtensions() {
            return null;
        }
        
        @java.lang.Override()
        public boolean acceptsFile(@org.jetbrains.annotations.NotNull()
        java.nio.file.Path path) {
            return false;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}