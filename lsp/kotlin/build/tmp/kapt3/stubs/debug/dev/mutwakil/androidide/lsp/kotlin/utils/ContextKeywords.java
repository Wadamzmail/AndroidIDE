package dev.mutwakil.androidide.lsp.kotlin.utils;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000f\u001a\u00020\u0010R\u001f\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001f\u0010\n\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u001f\u0010\f\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t\u00a8\u0006\u0011"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/utils/ContextKeywords;", "", "<init>", "()V", "STATEMENT_KEYWORDS", "", "Lorg/jetbrains/kotlin/lexer/KtKeywordToken;", "kotlin.jvm.PlatformType", "getSTATEMENT_KEYWORDS", "()Ljava/util/Set;", "DECLARATION_KEYWORDS", "getDECLARATION_KEYWORDS", "TOP_LEVEL_ONLY", "getTOP_LEVEL_ONLY", "keywordsFor", "ctx", "Ldev/mutwakil/androidide/lsp/kotlin/completion/DeclarationContext;", "kotlin_debug"})
public final class ContextKeywords {
    
    /**
     * Hard keywords valid as *statement starters* inside a function body
     */
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Set<org.jetbrains.kotlin.lexer.KtKeywordToken> STATEMENT_KEYWORDS = null;
    
    /**
     * Declaration starters at top-level / class body
     */
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Set<org.jetbrains.kotlin.lexer.KtKeywordToken> DECLARATION_KEYWORDS = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Set<org.jetbrains.kotlin.lexer.KtKeywordToken> TOP_LEVEL_ONLY = null;
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.kotlin.utils.ContextKeywords INSTANCE = null;
    
    private ContextKeywords() {
        super();
    }
    
    /**
     * Hard keywords valid as *statement starters* inside a function body
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<org.jetbrains.kotlin.lexer.KtKeywordToken> getSTATEMENT_KEYWORDS() {
        return null;
    }
    
    /**
     * Declaration starters at top-level / class body
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<org.jetbrains.kotlin.lexer.KtKeywordToken> getDECLARATION_KEYWORDS() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<org.jetbrains.kotlin.lexer.KtKeywordToken> getTOP_LEVEL_ONLY() {
        return null;
    }
    
    /**
     * Resolve valid keywords for the given declaration context.
     *
     * @param ctx The declaration context.
     * @return The keyword tokens for the declaration context.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<org.jetbrains.kotlin.lexer.KtKeywordToken> keywordsFor(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.completion.DeclarationContext ctx) {
        return null;
    }
}