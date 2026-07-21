package dev.mutwakil.androidide.lsp.kotlin.completion;

/**
 * Defines declaration kinds for element at cursor.
 */
@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/completion/DeclarationKind;", "", "<init>", "(Ljava/lang/String;I)V", "CLASS", "INTERFACE", "OBJECT", "ENUM_CLASS", "ANNOTATION_CLASS", "FUN", "PROPERTY_VAL", "PROPERTY_VAR", "TYPEALIAS", "CONSTRUCTOR", "UNKNOWN", "kotlin_debug"})
public enum DeclarationKind {
    /*public static final*/ CLASS /* = new CLASS() */,
    /*public static final*/ INTERFACE /* = new INTERFACE() */,
    /*public static final*/ OBJECT /* = new OBJECT() */,
    /*public static final*/ ENUM_CLASS /* = new ENUM_CLASS() */,
    /*public static final*/ ANNOTATION_CLASS /* = new ANNOTATION_CLASS() */,
    /*public static final*/ FUN /* = new FUN() */,
    /*public static final*/ PROPERTY_VAL /* = new PROPERTY_VAL() */,
    /*public static final*/ PROPERTY_VAR /* = new PROPERTY_VAR() */,
    /*public static final*/ TYPEALIAS /* = new TYPEALIAS() */,
    /*public static final*/ CONSTRUCTOR /* = new CONSTRUCTOR() */,
    /*public static final*/ UNKNOWN /* = new UNKNOWN() */;
    
    DeclarationKind() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<dev.mutwakil.androidide.lsp.kotlin.completion.DeclarationKind> getEntries() {
        return null;
    }
}