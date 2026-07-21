package dev.mutwakil.androidide.lsp.kotlin.signaturehelp;

@kotlin.Metadata(mv = {2, 3, 0}, k = 2, xi = 48, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\"\u0010\n\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0080@R\u00020\u000bj\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u000f\"\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"buildSignatureHelp", "Ldev/mutwakil/androidide/lsp/models/SignatureHelp;", "Lorg/jetbrains/kotlin/analysis/api/KaSession;", "call", "Lorg/jetbrains/kotlin/psi/KtCallElement;", "offset", "", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "doSignatureHelp", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationEnvironment;", "env", "params", "Ldev/mutwakil/androidide/lsp/models/SignatureHelpParams;", "(Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationEnvironment;Ldev/mutwakil/androidide/lsp/models/SignatureHelpParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin_debug"})
public final class KotlinSignatureHelpKt {
    private static final org.slf4j.Logger logger = null;
    
    /**
     * Builds a [SignatureHelp] for the function [call] with the cursor at [offset].
     *
     * Overloads come from the compiler's own candidate resolution; the active overload is the candidate
     * the compiler marks as best (falling back to the resolved call, then to the first candidate). The
     * active parameter is computed against that active overload.
     */
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.models.SignatureHelp buildSignatureHelp(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.KaSession $this$buildSignatureHelp, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtCallElement call, int offset) {
        return null;
    }
    
    /**
     * Computes [SignatureHelp] for the request described by [params], using the given
     * [CompilationEnvironment] to resolve the enclosing call and analyze it.
     */
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Object doSignatureHelp(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationEnvironment env, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.models.SignatureHelpParams params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super dev.mutwakil.androidide.lsp.models.SignatureHelp> $completion) {
        return null;
    }
}