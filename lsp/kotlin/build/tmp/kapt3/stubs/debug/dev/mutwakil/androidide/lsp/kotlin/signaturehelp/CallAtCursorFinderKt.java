package dev.mutwakil.androidide.lsp.kotlin.signaturehelp;

@kotlin.Metadata(mv = {2, 3, 0}, k = 2, xi = 48, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "findEnclosingCall", "Lorg/jetbrains/kotlin/psi/KtCallElement;", "file", "Lorg/jetbrains/kotlin/psi/KtFile;", "offset", "", "kotlin_debug"})
public final class CallAtCursorFinderKt {
    private static final org.slf4j.Logger logger = null;
    
    /**
     * Finds the innermost [KtCallElement] whose argument list directly contains [offset].
     *
     * Returns `null` when the cursor is inside a lambda body (trailing or argument lambda) or otherwise
     * not directly within a call's arguments, so that signature help is not shown there.
     */
    @org.jetbrains.annotations.Nullable()
    public static final org.jetbrains.kotlin.psi.KtCallElement findEnclosingCall(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtFile file, int offset) {
        return null;
    }
}