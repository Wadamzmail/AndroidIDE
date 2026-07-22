package dev.mutwakil.androidide.lsp.kotlin.utils;

@kotlin.Metadata(mv = {2, 3, 0}, k = 2, xi = 48, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u001a \u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001e\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u0005H\u0002\u00a8\u0006\u000b"}, d2 = {"computeSurroundWithTryCatchEdit", "Ldev/mutwakil/androidide/lsp/models/TextEdit;", "text", "", "startLine", "", "endLine", "lineStartIndex", "lines", "", "line", "kotlin_debug"})
public final class SurroundWithTryCatchKt {
    
    /**
     * Wraps lines [startLine]..[endLine] (0-based, inclusive) of [text] in a
     * try/catch block. Whole-line based: columns are ignored and full lines are
     * replaced. Indentation is computed here so the result is correct even without a
     * follow-up formatter. Returns null when the span is blank or out of range.
     */
    @org.jetbrains.annotations.Nullable()
    public static final dev.mutwakil.androidide.lsp.models.TextEdit computeSurroundWithTryCatchEdit(@org.jetbrains.annotations.NotNull()
    java.lang.String text, int startLine, int endLine) {
        return null;
    }
    
    private static final int lineStartIndex(java.util.List<java.lang.String> lines, int line) {
        return 0;
    }
}