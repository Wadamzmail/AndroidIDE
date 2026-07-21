package dev.mutwakil.androidide.lsp.kotlin.compiler.index;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0007\u0002\u0003\u0004\u0005\u0006\u0007\b\u0082\u0001\u0007\t\n\u000b\f\r\u000e\u000f\u00a8\u0006\u0010\u00c0\u0006\u0003"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand;", "", "Stop", "SourceScanningComplete", "IndexingComplete", "ScanSourceFile", "IndexModifiedFile", "IndexSourceFile", "RemoveFromIndex", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand$IndexModifiedFile;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand$IndexSourceFile;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand$IndexingComplete;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand$RemoveFromIndex;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand$ScanSourceFile;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand$SourceScanningComplete;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand$Stop;", "kotlin_debug"})
public abstract interface IndexCommand {
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fH\u00d6\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u00d6\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand$IndexModifiedFile;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand;", "ktFile", "Lorg/jetbrains/kotlin/psi/KtFile;", "<init>", "(Lorg/jetbrains/kotlin/psi/KtFile;)V", "getKtFile", "()Lorg/jetbrains/kotlin/psi/KtFile;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin_debug"})
    public static final class IndexModifiedFile implements dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexCommand {
        @org.jetbrains.annotations.NotNull()
        private final org.jetbrains.kotlin.psi.KtFile ktFile = null;
        
        public IndexModifiedFile(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.psi.KtFile ktFile) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.psi.KtFile getKtFile() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.psi.KtFile component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexCommand.IndexModifiedFile copy(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.psi.KtFile ktFile) {
            return null;
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
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fH\u00d6\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u00d6\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand$IndexSourceFile;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand;", "vf", "Lorg/jetbrains/kotlin/com/intellij/openapi/vfs/VirtualFile;", "<init>", "(Lorg/jetbrains/kotlin/com/intellij/openapi/vfs/VirtualFile;)V", "getVf", "()Lorg/jetbrains/kotlin/com/intellij/openapi/vfs/VirtualFile;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin_debug"})
    public static final class IndexSourceFile implements dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexCommand {
        @org.jetbrains.annotations.NotNull()
        private final org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile vf = null;
        
        public IndexSourceFile(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile vf) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile getVf() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexCommand.IndexSourceFile copy(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile vf) {
            return null;
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
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00d6\u0083\u0004J\n\u0010\b\u001a\u00020\tH\u00d6\u0081\u0004J\n\u0010\n\u001a\u00020\u000bH\u00d6\u0081\u0004\u00a8\u0006\f"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand$IndexingComplete;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin_debug"})
    public static final class IndexingComplete implements dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexCommand {
        @org.jetbrains.annotations.NotNull()
        public static final dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexCommand.IndexingComplete INSTANCE = null;
        
        private IndexingComplete() {
            super();
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
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fH\u00d6\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u00d6\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand$RemoveFromIndex;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand;", "path", "Ljava/nio/file/Path;", "<init>", "(Ljava/nio/file/Path;)V", "getPath", "()Ljava/nio/file/Path;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin_debug"})
    public static final class RemoveFromIndex implements dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexCommand {
        @org.jetbrains.annotations.NotNull()
        private final java.nio.file.Path path = null;
        
        public RemoveFromIndex(@org.jetbrains.annotations.NotNull()
        java.nio.file.Path path) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.nio.file.Path getPath() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.nio.file.Path component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexCommand.RemoveFromIndex copy(@org.jetbrains.annotations.NotNull()
        java.nio.file.Path path) {
            return null;
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
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fH\u00d6\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u00d6\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand$ScanSourceFile;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand;", "vf", "Lorg/jetbrains/kotlin/com/intellij/openapi/vfs/VirtualFile;", "<init>", "(Lorg/jetbrains/kotlin/com/intellij/openapi/vfs/VirtualFile;)V", "getVf", "()Lorg/jetbrains/kotlin/com/intellij/openapi/vfs/VirtualFile;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin_debug"})
    public static final class ScanSourceFile implements dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexCommand {
        @org.jetbrains.annotations.NotNull()
        private final org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile vf = null;
        
        public ScanSourceFile(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile vf) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile getVf() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexCommand.ScanSourceFile copy(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile vf) {
            return null;
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
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00d6\u0083\u0004J\n\u0010\b\u001a\u00020\tH\u00d6\u0081\u0004J\n\u0010\n\u001a\u00020\u000bH\u00d6\u0081\u0004\u00a8\u0006\f"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand$SourceScanningComplete;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin_debug"})
    public static final class SourceScanningComplete implements dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexCommand {
        @org.jetbrains.annotations.NotNull()
        public static final dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexCommand.SourceScanningComplete INSTANCE = null;
        
        private SourceScanningComplete() {
            super();
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
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00d6\u0083\u0004J\n\u0010\b\u001a\u00020\tH\u00d6\u0081\u0004J\n\u0010\n\u001a\u00020\u000bH\u00d6\u0081\u0004\u00a8\u0006\f"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand$Stop;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin_debug"})
    public static final class Stop implements dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexCommand {
        @org.jetbrains.annotations.NotNull()
        public static final dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexCommand.Stop INSTANCE = null;
        
        private Stop() {
            super();
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