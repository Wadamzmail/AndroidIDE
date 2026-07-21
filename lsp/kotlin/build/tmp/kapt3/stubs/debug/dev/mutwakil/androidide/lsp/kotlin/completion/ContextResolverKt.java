package dev.mutwakil.androidide.lsp.kotlin.completion;

@kotlin.Metadata(mv = {2, 3, 0}, k = 2, xi = 48, d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0014H\u0002\u001a\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0014H\u0002\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "resolveCursorContext", "Ldev/mutwakil/androidide/lsp/kotlin/completion/CursorContext;", "Lorg/jetbrains/kotlin/analysis/api/KaSession;", "ktFile", "Lorg/jetbrains/kotlin/psi/KtFile;", "offset", "", "determineCompletionContext", "Ldev/mutwakil/androidide/lsp/kotlin/completion/CompletionContext;", "element", "Lorg/jetbrains/kotlin/com/intellij/psi/PsiElement;", "isInSelectorPosition", "", "qualifiedExpr", "Lorg/jetbrains/kotlin/psi/KtQualifiedExpression;", "resolveDeclarationContext", "Ldev/mutwakil/androidide/lsp/kotlin/completion/DeclarationContext;", "Lorg/jetbrains/kotlin/psi/KtElement;", "resolveDeclarationKind", "Ldev/mutwakil/androidide/lsp/kotlin/completion/DeclarationKind;", "kotlin_debug"})
public final class ContextResolverKt {
    private static final org.slf4j.Logger logger = null;
    
    /**
     * Resolves [CursorContext] at the given offset in the given [KtFile].
     */
    @org.jetbrains.annotations.Nullable()
    public static final dev.mutwakil.androidide.lsp.kotlin.completion.CursorContext resolveCursorContext(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.KaSession $this$resolveCursorContext, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtFile ktFile, int offset) {
        return null;
    }
    
    private static final dev.mutwakil.androidide.lsp.kotlin.completion.CompletionContext determineCompletionContext(org.jetbrains.kotlin.com.intellij.psi.PsiElement element) {
        return null;
    }
    
    private static final boolean isInSelectorPosition(org.jetbrains.kotlin.com.intellij.psi.PsiElement element, org.jetbrains.kotlin.psi.KtQualifiedExpression qualifiedExpr) {
        return false;
    }
    
    private static final dev.mutwakil.androidide.lsp.kotlin.completion.DeclarationContext resolveDeclarationContext(org.jetbrains.kotlin.psi.KtElement element) {
        return null;
    }
    
    private static final dev.mutwakil.androidide.lsp.kotlin.completion.DeclarationKind resolveDeclarationKind(org.jetbrains.kotlin.psi.KtElement element) {
        return null;
    }
}