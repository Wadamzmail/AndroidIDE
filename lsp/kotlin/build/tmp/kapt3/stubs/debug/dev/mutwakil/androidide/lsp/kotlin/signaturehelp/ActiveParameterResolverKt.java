package dev.mutwakil.androidide.lsp.kotlin.signaturehelp;

@kotlin.Metadata(mv = {2, 3, 0}, k = 2, xi = 48, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0004H\u0000\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "computeActiveParameter", "", "Lorg/jetbrains/kotlin/analysis/api/KaSession;", "call", "Lorg/jetbrains/kotlin/psi/KtCallElement;", "resolvedCall", "Lorg/jetbrains/kotlin/analysis/api/resolution/KaFunctionCall;", "offset", "kotlin_debug"})
public final class ActiveParameterResolverKt {
    private static final org.slf4j.Logger logger = null;
    
    /**
     * Computes the index of the active value parameter for the call at [offset].
     *
     * Positional arguments map by order. When the cursor is on a named argument, the index is remapped
     * to that parameter's declared position in [resolvedCall] (handles reordered named args). The
     * result is applied by the shared UI to whichever overload it renders, so named-arg remapping is
     * resolved against the active overload only.
     */
    public static final int computeActiveParameter(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.KaSession $this$computeActiveParameter, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtCallElement call, @org.jetbrains.annotations.Nullable()
    org.jetbrains.kotlin.analysis.api.resolution.KaFunctionCall<?> resolvedCall, int offset) {
        return 0;
    }
}