package dev.mutwakil.androidide.lsp.kotlin.completion;

/**
 * Defines the possible declaration contexts of the element at cursor position.
 */
@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/completion/DeclarationContext;", "", "<init>", "(Ljava/lang/String;I)V", "TOP_LEVEL", "CLASS_BODY", "INTERFACE_BODY", "OBJECT_BODY", "ENUM_BODY", "FUNCTION_BODY", "SCRIPT_TOP_LEVEL", "ANNOTATION_BODY", "kotlin_debug"})
public enum DeclarationContext {
    /*public static final*/ TOP_LEVEL /* = new TOP_LEVEL() */,
    /*public static final*/ CLASS_BODY /* = new CLASS_BODY() */,
    /*public static final*/ INTERFACE_BODY /* = new INTERFACE_BODY() */,
    /*public static final*/ OBJECT_BODY /* = new OBJECT_BODY() */,
    /*public static final*/ ENUM_BODY /* = new ENUM_BODY() */,
    /*public static final*/ FUNCTION_BODY /* = new FUNCTION_BODY() */,
    /*public static final*/ SCRIPT_TOP_LEVEL /* = new SCRIPT_TOP_LEVEL() */,
    /*public static final*/ ANNOTATION_BODY /* = new ANNOTATION_BODY() */;
    
    DeclarationContext() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<dev.mutwakil.androidide.lsp.kotlin.completion.DeclarationContext> getEntries() {
        return null;
    }
}