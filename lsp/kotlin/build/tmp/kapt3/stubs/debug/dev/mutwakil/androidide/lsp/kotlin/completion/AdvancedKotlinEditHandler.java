package dev.mutwakil.androidide.lsp.kotlin.completion;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J8\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J1\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH&R\u00020\u0003j\u0006\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0019"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/completion/AdvancedKotlinEditHandler;", "Ldev/mutwakil/androidide/lsp/kotlin/completion/BaseKotlinEditHandler;", "analysisContext", "Ldev/mutwakil/androidide/lsp/kotlin/utils/AnalysisContext;", "<init>", "(Ldev/mutwakil/androidide/lsp/kotlin/utils/AnalysisContext;)V", "getAnalysisContext", "()Ldev/mutwakil/androidide/lsp/kotlin/utils/AnalysisContext;", "performEdits", "", "item", "Ldev/mutwakil/androidide/lsp/models/CompletionItem;", "editor", "Lio/github/rosemoe/sora/widget/CodeEditor;", "text", "Lio/github/rosemoe/sora/text/Content;", "line", "", "column", "index", "ctx", "ktFile", "Lorg/jetbrains/kotlin/psi/KtFile;", "(Ldev/mutwakil/androidide/lsp/kotlin/utils/AnalysisContext;Lorg/jetbrains/kotlin/psi/KtFile;Lio/github/rosemoe/sora/widget/CodeEditor;Ldev/mutwakil/androidide/lsp/models/CompletionItem;)V", "Companion", "kotlin_debug"})
public abstract class AdvancedKotlinEditHandler extends dev.mutwakil.androidide.lsp.kotlin.completion.BaseKotlinEditHandler {
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext analysisContext = null;
    private static final org.slf4j.Logger logger = null;
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.kotlin.completion.AdvancedKotlinEditHandler.Companion Companion = null;
    
    public AdvancedKotlinEditHandler(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext analysisContext) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext getAnalysisContext() {
        return null;
    }
    
    @java.lang.Override()
    public void performEdits(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.models.CompletionItem item, @org.jetbrains.annotations.NotNull()
    io.github.rosemoe.sora.widget.CodeEditor editor, @org.jetbrains.annotations.NotNull()
    io.github.rosemoe.sora.text.Content text, int line, int column, int index) {
    }
    
    public abstract void performEdits(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext ktFile, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtFile editor, @org.jetbrains.annotations.NotNull()
    io.github.rosemoe.sora.widget.CodeEditor item, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.models.CompletionItem p3);
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/completion/AdvancedKotlinEditHandler$Companion;", "", "<init>", "()V", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "kotlin_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}