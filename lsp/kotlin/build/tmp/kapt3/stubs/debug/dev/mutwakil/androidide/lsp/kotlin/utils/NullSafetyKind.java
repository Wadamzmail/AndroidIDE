package dev.mutwakil.androidide.lsp.kotlin.utils;

/**
 * The distinct null-safety rewrites offered for one unsafe `receiver.selector` access.
 */
@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/utils/NullSafetyKind;", "", "<init>", "(Ljava/lang/String;I)V", "ASSERT_NON_NULL", "SAFE_CALL", "ELVIS", "kotlin_debug"})
public enum NullSafetyKind {
    /*public static final*/ ASSERT_NON_NULL /* = new ASSERT_NON_NULL() */,
    /*public static final*/ SAFE_CALL /* = new SAFE_CALL() */,
    /*public static final*/ ELVIS /* = new ELVIS() */;
    
    NullSafetyKind() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<dev.mutwakil.androidide.lsp.kotlin.utils.NullSafetyKind> getEntries() {
        return null;
    }
}