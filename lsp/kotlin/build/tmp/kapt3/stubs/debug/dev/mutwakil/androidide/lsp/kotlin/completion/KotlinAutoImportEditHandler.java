package dev.mutwakil.androidide.lsp.kotlin.completion;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J1\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u00020\u0003j\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0011R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/completion/KotlinAutoImportEditHandler;", "Ldev/mutwakil/androidide/lsp/kotlin/completion/AdvancedKotlinEditHandler;", "analysisContext", "Ldev/mutwakil/androidide/lsp/kotlin/utils/AnalysisContext;", "symbolToImport", "Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbol;", "<init>", "(Ldev/mutwakil/androidide/lsp/kotlin/utils/AnalysisContext;Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbol;)V", "performEdits", "", "ctx", "ktFile", "Lorg/jetbrains/kotlin/psi/KtFile;", "editor", "Lio/github/rosemoe/sora/widget/CodeEditor;", "item", "Ldev/mutwakil/androidide/lsp/models/CompletionItem;", "(Ldev/mutwakil/androidide/lsp/kotlin/utils/AnalysisContext;Lorg/jetbrains/kotlin/psi/KtFile;Lio/github/rosemoe/sora/widget/CodeEditor;Ldev/mutwakil/androidide/lsp/models/CompletionItem;)V", "kotlin_debug"})
public final class KotlinAutoImportEditHandler extends dev.mutwakil.androidide.lsp.kotlin.completion.AdvancedKotlinEditHandler {
    @org.jetbrains.annotations.Nullable()
    private final org.appdevforall.codeonthego.indexing.jvm.JvmSymbol symbolToImport = null;
    
    public KotlinAutoImportEditHandler(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext analysisContext, @org.jetbrains.annotations.Nullable()
    org.appdevforall.codeonthego.indexing.jvm.JvmSymbol symbolToImport) {
        super(null);
    }
    
    @java.lang.Override()
    public void performEdits(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext ctx, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtFile ktFile, @org.jetbrains.annotations.NotNull()
    io.github.rosemoe.sora.widget.CodeEditor editor, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.models.CompletionItem item) {
    }
}