package dev.mutwakil.androidide.lsp.kotlin.compiler.index;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/ScanningWorker;", "", "kind", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationKind;", "sourceIndex", "Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbolIndex;", "indexWorker", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexWorker;", "modules", "", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/KtModule;", "<init>", "(Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationKind;Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbolIndex;Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/IndexWorker;Ljava/util/List;)V", "scan", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "kotlin_debug"})
public final class ScanningWorker {
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationKind kind = null;
    @org.jetbrains.annotations.NotNull()
    private final org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex sourceIndex = null;
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexWorker indexWorker = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> modules = null;
    private static final org.slf4j.Logger logger = null;
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.kotlin.compiler.index.ScanningWorker.Companion Companion = null;
    
    public ScanningWorker(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationKind kind, @org.jetbrains.annotations.NotNull()
    org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex sourceIndex, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.index.IndexWorker indexWorker, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> modules) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object scan(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/ScanningWorker$Companion;", "", "<init>", "()V", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "kotlin_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}