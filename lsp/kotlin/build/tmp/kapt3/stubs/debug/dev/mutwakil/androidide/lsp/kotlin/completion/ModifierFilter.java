package dev.mutwakil.androidide.lsp.kotlin.completion;

/**
 * Helper for filtering modifier keywords for keyword completions.
 */
@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0012\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\nH\u0002J\u0015\u0010\u000b\u001a\u00020\f*\u00020\n2\u0006\u0010\r\u001a\u00020\u0006H\u0082\u0002\u00a8\u0006\u000e"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/completion/ModifierFilter;", "", "<init>", "()V", "validModifiers", "", "Lorg/jetbrains/kotlin/lexer/KtModifierKeywordToken;", "ctx", "Ldev/mutwakil/androidide/lsp/kotlin/completion/CursorContext;", "types", "Lorg/jetbrains/kotlin/com/intellij/psi/tree/TokenSet;", "contains", "", "token", "kotlin_debug"})
public final class ModifierFilter {
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.kotlin.completion.ModifierFilter INSTANCE = null;
    
    private ModifierFilter() {
        super();
    }
    
    /**
     * Returns which modifier keywords are valid to suggest given the
     * current context, declaration kind, and already-present modifiers.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<org.jetbrains.kotlin.lexer.KtModifierKeywordToken> validModifiers(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.completion.CursorContext ctx) {
        return null;
    }
    
    private final java.util.Set<org.jetbrains.kotlin.lexer.KtModifierKeywordToken> types(org.jetbrains.kotlin.com.intellij.psi.tree.TokenSet $this$types) {
        return null;
    }
    
    private final boolean contains(org.jetbrains.kotlin.com.intellij.psi.tree.TokenSet $this$contains, org.jetbrains.kotlin.lexer.KtModifierKeywordToken token) {
        return false;
    }
}