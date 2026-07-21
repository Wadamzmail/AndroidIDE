package dev.mutwakil.androidide.lsp.kotlin.completion;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0016\u0010\u0017B\t\b\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0018\u00a8\u0006\u0019"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/completion/KotlinCompletionItem;", "Ldev/mutwakil/androidide/lsp/models/CompletionItem;", "ideLabel", "", "detail", "insertText", "insertTextFormat", "Ldev/mutwakil/androidide/lsp/models/InsertTextFormat;", "sortText", "command", "Ldev/mutwakil/androidide/lsp/models/Command;", "completionKind", "Ldev/mutwakil/androidide/lsp/models/CompletionItemKind;", "matchLevel", "Ldev/mutwakil/androidide/lsp/models/MatchLevel;", "additionalTextEdits", "", "Ldev/mutwakil/androidide/lsp/models/TextEdit;", "data", "Ldev/mutwakil/androidide/lsp/models/ICompletionData;", "editHandler", "Ldev/mutwakil/androidide/lsp/edits/IEditHandler;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldev/mutwakil/androidide/lsp/models/InsertTextFormat;Ljava/lang/String;Ldev/mutwakil/androidide/lsp/models/Command;Ldev/mutwakil/androidide/lsp/models/CompletionItemKind;Ldev/mutwakil/androidide/lsp/models/MatchLevel;Ljava/util/List;Ldev/mutwakil/androidide/lsp/models/ICompletionData;Ldev/mutwakil/androidide/lsp/edits/IEditHandler;)V", "()V", "kotlin_debug"})
public final class KotlinCompletionItem extends dev.mutwakil.androidide.lsp.models.CompletionItem {
    
    public KotlinCompletionItem(@org.jetbrains.annotations.NotNull()
    java.lang.String ideLabel, @org.jetbrains.annotations.NotNull()
    java.lang.String detail, @org.jetbrains.annotations.Nullable()
    java.lang.String insertText, @org.jetbrains.annotations.Nullable()
    dev.mutwakil.androidide.lsp.models.InsertTextFormat insertTextFormat, @org.jetbrains.annotations.Nullable()
    java.lang.String sortText, @org.jetbrains.annotations.Nullable()
    dev.mutwakil.androidide.lsp.models.Command command, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.models.CompletionItemKind completionKind, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.models.MatchLevel matchLevel, @org.jetbrains.annotations.Nullable()
    java.util.List<dev.mutwakil.androidide.lsp.models.TextEdit> additionalTextEdits, @org.jetbrains.annotations.Nullable()
    dev.mutwakil.androidide.lsp.models.ICompletionData data, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.edits.IEditHandler editHandler) {
        super(null, null, null, null, null, null, null, null, null, null, null);
    }
    
    public KotlinCompletionItem() {
        super(null, null, null, null, null, null, null, null, null, null, null);
    }
}