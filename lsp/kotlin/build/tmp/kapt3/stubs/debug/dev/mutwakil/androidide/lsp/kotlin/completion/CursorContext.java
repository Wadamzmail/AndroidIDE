package dev.mutwakil.androidide.lsp.kotlin.completion;

/**
 * Defines context at the cursor position.
 */
@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0005H\u00c6\u0003J\t\u0010.\u001a\u00020\u0007H\u00c6\u0003J\t\u0010/\u001a\u00020\tH\u00c6\u0003J\t\u00100\u001a\u00020\u000bH\u00c6\u0003J\t\u00101\u001a\u00020\rH\u00c6\u0003J\t\u00102\u001a\u00020\u000fH\u00c6\u0003J\t\u00103\u001a\u00020\u0011H\u00c6\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u00c6\u0003J\t\u00105\u001a\u00020\u0016H\u00c6\u0003Js\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u00c6\u0001J\u0014\u00107\u001a\u00020\u00162\b\u00108\u001a\u0004\u0018\u00010\u0001H\u00d6\u0083\u0004J\n\u00109\u001a\u00020:H\u00d6\u0081\u0004J\n\u0010;\u001a\u00020<H\u00d6\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010+\u00a8\u0006="}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/completion/CursorContext;", "", "psiElement", "Lorg/jetbrains/kotlin/com/intellij/psi/PsiElement;", "ktFile", "Lorg/jetbrains/kotlin/psi/KtFile;", "ktElement", "Lorg/jetbrains/kotlin/psi/KtElement;", "scopeContext", "Lorg/jetbrains/kotlin/analysis/api/components/KaScopeContext;", "compositeScope", "Lorg/jetbrains/kotlin/analysis/api/scopes/KaScope;", "completionContext", "Ldev/mutwakil/androidide/lsp/kotlin/completion/CompletionContext;", "declarationContext", "Ldev/mutwakil/androidide/lsp/kotlin/completion/DeclarationContext;", "declarationKind", "Ldev/mutwakil/androidide/lsp/kotlin/completion/DeclarationKind;", "existingModifiers", "", "Lorg/jetbrains/kotlin/lexer/KtModifierKeywordToken;", "isInsideModifierList", "", "<init>", "(Lorg/jetbrains/kotlin/com/intellij/psi/PsiElement;Lorg/jetbrains/kotlin/psi/KtFile;Lorg/jetbrains/kotlin/psi/KtElement;Lorg/jetbrains/kotlin/analysis/api/components/KaScopeContext;Lorg/jetbrains/kotlin/analysis/api/scopes/KaScope;Ldev/mutwakil/androidide/lsp/kotlin/completion/CompletionContext;Ldev/mutwakil/androidide/lsp/kotlin/completion/DeclarationContext;Ldev/mutwakil/androidide/lsp/kotlin/completion/DeclarationKind;Ljava/util/Set;Z)V", "getPsiElement", "()Lorg/jetbrains/kotlin/com/intellij/psi/PsiElement;", "getKtFile", "()Lorg/jetbrains/kotlin/psi/KtFile;", "getKtElement", "()Lorg/jetbrains/kotlin/psi/KtElement;", "getScopeContext", "()Lorg/jetbrains/kotlin/analysis/api/components/KaScopeContext;", "getCompositeScope", "()Lorg/jetbrains/kotlin/analysis/api/scopes/KaScope;", "getCompletionContext", "()Ldev/mutwakil/androidide/lsp/kotlin/completion/CompletionContext;", "getDeclarationContext", "()Ldev/mutwakil/androidide/lsp/kotlin/completion/DeclarationContext;", "getDeclarationKind", "()Ldev/mutwakil/androidide/lsp/kotlin/completion/DeclarationKind;", "getExistingModifiers", "()Ljava/util/Set;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "", "toString", "", "kotlin_debug"})
public final class CursorContext {
    @org.jetbrains.annotations.NotNull()
    private final org.jetbrains.kotlin.com.intellij.psi.PsiElement psiElement = null;
    @org.jetbrains.annotations.NotNull()
    private final org.jetbrains.kotlin.psi.KtFile ktFile = null;
    @org.jetbrains.annotations.NotNull()
    private final org.jetbrains.kotlin.psi.KtElement ktElement = null;
    @org.jetbrains.annotations.NotNull()
    private final org.jetbrains.kotlin.analysis.api.components.KaScopeContext scopeContext = null;
    @org.jetbrains.annotations.NotNull()
    private final org.jetbrains.kotlin.analysis.api.scopes.KaScope compositeScope = null;
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.lsp.kotlin.completion.CompletionContext completionContext = null;
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.lsp.kotlin.completion.DeclarationContext declarationContext = null;
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.lsp.kotlin.completion.DeclarationKind declarationKind = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Set<org.jetbrains.kotlin.lexer.KtModifierKeywordToken> existingModifiers = null;
    private final boolean isInsideModifierList = false;
    
    public CursorContext(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.psi.PsiElement psiElement, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtFile ktFile, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtElement ktElement, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.components.KaScopeContext scopeContext, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.scopes.KaScope compositeScope, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.completion.CompletionContext completionContext, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.completion.DeclarationContext declarationContext, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.completion.DeclarationKind declarationKind, @org.jetbrains.annotations.NotNull()
    java.util.Set<org.jetbrains.kotlin.lexer.KtModifierKeywordToken> existingModifiers, boolean isInsideModifierList) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.com.intellij.psi.PsiElement getPsiElement() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.psi.KtFile getKtFile() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.psi.KtElement getKtElement() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.analysis.api.components.KaScopeContext getScopeContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.analysis.api.scopes.KaScope getCompositeScope() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.lsp.kotlin.completion.CompletionContext getCompletionContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.lsp.kotlin.completion.DeclarationContext getDeclarationContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.lsp.kotlin.completion.DeclarationKind getDeclarationKind() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<org.jetbrains.kotlin.lexer.KtModifierKeywordToken> getExistingModifiers() {
        return null;
    }
    
    public final boolean isInsideModifierList() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.com.intellij.psi.PsiElement component1() {
        return null;
    }
    
    public final boolean component10() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.psi.KtFile component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.psi.KtElement component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.analysis.api.components.KaScopeContext component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.analysis.api.scopes.KaScope component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.lsp.kotlin.completion.CompletionContext component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.lsp.kotlin.completion.DeclarationContext component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.lsp.kotlin.completion.DeclarationKind component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<org.jetbrains.kotlin.lexer.KtModifierKeywordToken> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.lsp.kotlin.completion.CursorContext copy(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.psi.PsiElement psiElement, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtFile ktFile, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtElement ktElement, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.components.KaScopeContext scopeContext, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.scopes.KaScope compositeScope, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.completion.CompletionContext completionContext, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.completion.DeclarationContext declarationContext, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.completion.DeclarationKind declarationKind, @org.jetbrains.annotations.NotNull()
    java.util.Set<org.jetbrains.kotlin.lexer.KtModifierKeywordToken> existingModifiers, boolean isInsideModifierList) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}