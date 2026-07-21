package dev.mutwakil.androidide.lsp.kotlin.utils;

@kotlin.Metadata(mv = {2, 3, 0}, k = 2, xi = 48, d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a6\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "resolveAnalysisContext", "Ldev/mutwakil/androidide/lsp/kotlin/utils/AnalysisContext;", "Lorg/jetbrains/kotlin/analysis/api/KaSession;", "env", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationEnvironment;", "file", "Ljava/nio/file/Path;", "ktFile", "Lorg/jetbrains/kotlin/psi/KtFile;", "offset", "", "partial", "", "resolveDeclarationContext", "Ldev/mutwakil/androidide/lsp/kotlin/completion/DeclarationContext;", "element", "Lorg/jetbrains/kotlin/psi/KtElement;", "resolveDeclarationKind", "Ldev/mutwakil/androidide/lsp/kotlin/completion/DeclarationKind;", "kotlin_debug"})
public final class ContextResolverKt {
    private static final org.slf4j.Logger logger = null;
    
    /**
     * Resolves [AnalysisContext] at the given offset in the given [KtFile].
     *
     * @param env The compilation environment.
     * @param ktFile The Kotlin file.
     * @param offset The offset to resolve context at.
     * @param partial The partial identifier at the cursor position.
     */
    @org.jetbrains.annotations.Nullable()
    public static final dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext resolveAnalysisContext(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.KaSession $this$resolveAnalysisContext, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationEnvironment env, @org.jetbrains.annotations.NotNull()
    java.nio.file.Path file, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtFile ktFile, int offset, @org.jetbrains.annotations.NotNull()
    java.lang.String partial) {
        return null;
    }
    
    private static final dev.mutwakil.androidide.lsp.kotlin.completion.DeclarationContext resolveDeclarationContext(org.jetbrains.kotlin.psi.KtElement element) {
        return null;
    }
    
    private static final dev.mutwakil.androidide.lsp.kotlin.completion.DeclarationKind resolveDeclarationKind(org.jetbrains.kotlin.psi.KtElement element) {
        return null;
    }
}