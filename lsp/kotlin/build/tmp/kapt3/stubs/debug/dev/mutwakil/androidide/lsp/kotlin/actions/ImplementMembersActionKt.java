package dev.mutwakil.androidide.lsp.kotlin.actions;

@kotlin.Metadata(mv = {2, 3, 0}, k = 2, xi = 48, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0001H\u0002\u001a(\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002\u001a\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002\u001a4\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00142\u0006\u0010\u000e\u001a\u00020\u000bH\u0002\u00a8\u0006\u0017"}, d2 = {"findEnclosingClassOrObject", "Lorg/jetbrains/kotlin/psi/KtClassOrObject;", "ktFile", "Lorg/jetbrains/kotlin/psi/KtFile;", "offset", "", "isImplementable", "", "classSymbol", "Lorg/jetbrains/kotlin/analysis/api/symbols/KaClassSymbol;", "classIndentOf", "", "classOrObject", "memberIndentOf", "classIndent", "unit", "leadingIndentAt", "text", "detectIndentUnit", "buildInsertionEdit", "", "Ldev/mutwakil/androidide/lsp/models/TextEdit;", "stubs", "kotlin_debug"})
public final class ImplementMembersActionKt {
    
    /**
     * Innermost [KtClassOrObject] containing [offset], or null. Tries [offset] then [offset]-1 so a caret sitting just after a token still resolves.
     */
    private static final org.jetbrains.kotlin.psi.KtClassOrObject findEnclosingClassOrObject(org.jetbrains.kotlin.psi.KtFile ktFile, int offset) {
        return null;
    }
    
    /**
     * Only concrete classes and objects are *required* to implement inherited members; abstract/sealed classes, interfaces, enums and annotations are not.
     */
    private static final boolean isImplementable(org.jetbrains.kotlin.analysis.api.symbols.KaClassSymbol classSymbol) {
        return false;
    }
    
    /**
     * Leading whitespace of the line the declaration starts on (its base indentation).
     */
    private static final java.lang.String classIndentOf(org.jetbrains.kotlin.psi.KtFile ktFile, org.jetbrains.kotlin.psi.KtClassOrObject classOrObject) {
        return null;
    }
    
    /**
     * The indentation each generated member should carry, matched to the surrounding code.
     */
    private static final java.lang.String memberIndentOf(org.jetbrains.kotlin.psi.KtFile ktFile, org.jetbrains.kotlin.psi.KtClassOrObject classOrObject, java.lang.String classIndent, java.lang.String unit) {
        return null;
    }
    
    /**
     * Leading run of spaces/tabs on the line containing [offset].
     */
    private static final java.lang.String leadingIndentAt(java.lang.String text, int offset) {
        return null;
    }
    
    /**
     * One indentation level for [text], inferred from its existing lines: a tab if any line is
     * tab-indented, otherwise the smallest positive run of leading spaces, defaulting to a single tab
     * when nothing is indented (the project convention). This keeps generated stubs consistent with the
     * file's own style rather than assuming tabs -- TextEdits bypass the editor's reindent, so the text
     * must be final.
     */
    private static final java.lang.String detectIndentUnit(java.lang.String text) {
        return null;
    }
    
    /**
     * A single [TextEdit] that drops [stubs] into [classOrObject]'s body:
     * - no body -> append ` { ... }` after the declaration;
     * - empty body -> replace the whitespace between the braces;
     * - non-empty body -> insert after the last existing member (leaving existing code untouched).
     */
    private static final java.util.List<dev.mutwakil.androidide.lsp.models.TextEdit> buildInsertionEdit(org.jetbrains.kotlin.psi.KtFile ktFile, org.jetbrains.kotlin.psi.KtClassOrObject classOrObject, java.util.List<java.lang.String> stubs, java.lang.String classIndent) {
        return null;
    }
}