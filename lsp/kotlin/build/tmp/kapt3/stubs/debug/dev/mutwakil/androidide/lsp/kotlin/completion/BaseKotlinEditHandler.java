package dev.mutwakil.androidide.lsp.kotlin.completion;

/**
 * Implementation of [DefaultEditHandler] which avoids reflection in
 * [DefaultEditHandler.executeCommand].
 *
 * @author Akash Yadav
 */
@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014\u00a8\u0006\n"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/completion/BaseKotlinEditHandler;", "Ldev/mutwakil/androidide/lsp/edits/DefaultEditHandler;", "<init>", "()V", "executeCommand", "", "editor", "Lio/github/rosemoe/sora/widget/CodeEditor;", "command", "Ldev/mutwakil/androidide/lsp/models/Command;", "kotlin_debug"})
public class BaseKotlinEditHandler extends dev.mutwakil.androidide.lsp.edits.DefaultEditHandler {
    
    public BaseKotlinEditHandler() {
        super();
    }
    
    @java.lang.Override()
    protected void executeCommand(@org.jetbrains.annotations.NotNull()
    io.github.rosemoe.sora.widget.CodeEditor editor, @org.jetbrains.annotations.Nullable()
    dev.mutwakil.androidide.lsp.models.Command command) {
    }
}