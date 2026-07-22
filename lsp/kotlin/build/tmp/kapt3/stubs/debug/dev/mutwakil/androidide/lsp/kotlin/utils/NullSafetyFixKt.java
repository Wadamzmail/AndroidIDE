package dev.mutwakil.androidide.lsp.kotlin.utils;

@kotlin.Metadata(mv = {2, 3, 0}, k = 2, xi = 48, d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\"\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001a\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0000\u001a \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a \u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"UNSAFE_CALL_FACTORY", "", "nullSafetyFactoryFor", "factoryName", "ELVIS_FALLBACK", "findNullableMemberAccess", "Lorg/jetbrains/kotlin/psi/KtDotQualifiedExpression;", "file", "Lorg/jetbrains/kotlin/com/intellij/psi/PsiFile;", "startOffset", "", "endOffset", "nullSafetyVariants", "", "Ldev/mutwakil/androidide/lsp/kotlin/utils/NullSafetyVariant;", "qe", "insertAt", "Ldev/mutwakil/androidide/lsp/models/TextEdit;", "offset", "text", "replace", "range", "Lorg/jetbrains/kotlin/com/intellij/openapi/util/TextRange;", "kotlin_debug"})
public final class NullSafetyFixKt {
    
    /**
     * FIR diagnostic factory name for an unsafe member access on a nullable receiver.
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UNSAFE_CALL_FACTORY = "UNSAFE_CALL";
    
    /**
     * Placeholder fallback for the Elvis variant: `Nothing`, so it type-checks anywhere and forces the user to fill it in.
     */
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ELVIS_FALLBACK = "TODO()";
    
    /**
     * Returns [UNSAFE_CALL_FACTORY] when [factoryName] is the diagnostic the null-safety fixes apply to,
     * else null. Keyed on the factory name (plain data captured inside `analyze`) so the diagnostic's
     * `KaLifetimeOwner` never escapes. This is the single source of truth for the trigger: the diagnostic
     * provider stores its result, and the action gates visibility on it.
     */
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String nullSafetyFactoryFor(@org.jetbrains.annotations.NotNull()
    java.lang.String factoryName) {
        return null;
    }
    
    /**
     * Locates the `receiver.selector` access an UNSAFE_CALL diagnostic (whose PSI is the whole
     * [KtDotQualifiedExpression]) covers, given its [startOffset], [endOffset] in [file]. Returns null
     * when no dot-qualified expression spans exactly that range (e.g. a stale range after edits).
     */
    @org.jetbrains.annotations.Nullable()
    public static final org.jetbrains.kotlin.psi.KtDotQualifiedExpression findNullableMemberAccess(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.psi.PsiFile file, int startOffset, int endOffset) {
        return null;
    }
    
    /**
     * Builds the three null-safety rewrites for [qe]. Each variant is a single, minimal, fully-formed
     * [TextEdit] (LSP code-action edits bypass the editor's auto-indent, so the emitted text must be
     * final). Must be called under `project.read`.
     *
     * The Elvis variant wraps only the receiver, keeping the top-level member access intact so the
     * result is valid in any surrounding context without extra parentheses.
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<dev.mutwakil.androidide.lsp.kotlin.utils.NullSafetyVariant> nullSafetyVariants(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtDotQualifiedExpression qe) {
        return null;
    }
    
    private static final dev.mutwakil.androidide.lsp.models.TextEdit insertAt(int offset, java.lang.String text, org.jetbrains.kotlin.com.intellij.psi.PsiFile file) {
        return null;
    }
    
    private static final dev.mutwakil.androidide.lsp.models.TextEdit replace(org.jetbrains.kotlin.com.intellij.openapi.util.TextRange range, java.lang.String text, org.jetbrains.kotlin.com.intellij.psi.PsiFile file) {
        return null;
    }
}