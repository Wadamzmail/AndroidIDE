package dev.mutwakil.androidide.lsp.kotlin.compiler.index;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexWorker;", "", "project", "Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "queue", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/WorkerQueue;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand;", "fileIndex", "Lorg/appdevforall/codeonthego/indexing/jvm/KtFileMetadataIndex;", "sourceIndex", "Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbolIndex;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/WorkerQueue;Lorg/appdevforall/codeonthego/indexing/jvm/KtFileMetadataIndex;Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbolIndex;Lkotlinx/coroutines/CoroutineScope;)V", "start", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitCommand", "cmd", "(Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexCommand;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ModFileIndexKey", "kotlin_debug"})
public final class IndexWorker {
    @org.jetbrains.annotations.NotNull()
    private final org.jetbrains.kotlin.com.intellij.openapi.project.Project project = null;
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.lsp.kotlin.compiler.index.WorkerQueue<dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexCommand> queue = null;
    @org.jetbrains.annotations.NotNull()
    private final org.appdevforall.codeonthego.indexing.jvm.KtFileMetadataIndex fileIndex = null;
    @org.jetbrains.annotations.NotNull()
    private final org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex sourceIndex = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    private static final org.slf4j.Logger logger = null;
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexWorker.Companion Companion = null;
    
    public IndexWorker(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.project.Project project, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.index.WorkerQueue<dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexCommand> queue, @org.jetbrains.annotations.NotNull()
    org.appdevforall.codeonthego.indexing.jvm.KtFileMetadataIndex fileIndex, @org.jetbrains.annotations.NotNull()
    org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex sourceIndex, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object start(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object submitCommand(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexCommand cmd, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexWorker$Companion;", "", "<init>", "()V", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "kotlin_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004J\t\u0010\u0011\u001a\u00020\u0003H\u0086\u0002J\t\u0010\u0012\u001a\u00020\u0005H\u0086\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexWorker$ModFileIndexKey;", "", "path", "Ljava/nio/file/Path;", "ktFile", "Lorg/jetbrains/kotlin/psi/KtFile;", "<init>", "(Ljava/nio/file/Path;Lorg/jetbrains/kotlin/psi/KtFile;)V", "getPath", "()Ljava/nio/file/Path;", "getKtFile", "()Lorg/jetbrains/kotlin/psi/KtFile;", "equals", "", "other", "hashCode", "", "component1", "component2", "kotlin_debug"})
    static final class ModFileIndexKey {
        @org.jetbrains.annotations.NotNull()
        private final java.nio.file.Path path = null;
        @org.jetbrains.annotations.NotNull()
        private final org.jetbrains.kotlin.psi.KtFile ktFile = null;
        
        public ModFileIndexKey(@org.jetbrains.annotations.NotNull()
        java.nio.file.Path path, @org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.psi.KtFile ktFile) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.nio.file.Path getPath() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.psi.KtFile getKtFile() {
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
        
        @org.jetbrains.annotations.NotNull()
        public final java.nio.file.Path component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.psi.KtFile component2() {
            return null;
        }
    }
}