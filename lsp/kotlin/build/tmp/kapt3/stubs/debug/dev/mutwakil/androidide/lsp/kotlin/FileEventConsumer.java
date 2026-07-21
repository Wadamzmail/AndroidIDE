package dev.mutwakil.androidide.lsp.kotlin;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u000b\u00c0\u0006\u0003"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/FileEventConsumer;", "", "onFileOpened", "", "path", "Ljava/nio/file/Path;", "content", "", "onFileClosed", "onFileContentChanged", "onFileSaved", "kotlin_debug"})
public abstract interface FileEventConsumer {
    
    public abstract void onFileOpened(@org.jetbrains.annotations.NotNull()
    java.nio.file.Path path, @org.jetbrains.annotations.NotNull()
    java.lang.String content);
    
    public abstract void onFileClosed(@org.jetbrains.annotations.NotNull()
    java.nio.file.Path path);
    
    public abstract void onFileContentChanged(@org.jetbrains.annotations.NotNull()
    java.nio.file.Path path, @org.jetbrains.annotations.NotNull()
    java.lang.String content);
    
    public abstract void onFileSaved(@org.jetbrains.annotations.NotNull()
    java.nio.file.Path path);
}