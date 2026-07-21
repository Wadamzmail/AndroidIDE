package dev.mutwakil.androidide.lsp.kotlin.utils;

@kotlin.Metadata(mv = {2, 3, 0}, k = 2, xi = 48, d1 = {"\u00000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a.\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0002\u001a\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0002\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"DEFAULT_STAR_PACKAGES", "", "", "getDEFAULT_STAR_PACKAGES", "()Ljava/util/Set;", "KDOC_LINK", "Lkotlin/text/Regex;", "organizedImportBlock", "ktFile", "Lorg/jetbrains/kotlin/psi/KtFile;", "usage", "Ldev/mutwakil/androidide/lsp/kotlin/utils/ImportUsage;", "keepImport", "", "directive", "Lorg/jetbrains/kotlin/psi/KtImportDirective;", "filePackage", "kdocNames", "collectKDocLinkNames", "kotlin_debug"})
public final class ImportOrganizerKt {
    
    /**
     * JVM packages that Kotlin imports with a wildcard by default; explicit named imports from these are redundant.
     */
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Set<java.lang.String> DEFAULT_STAR_PACKAGES = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.text.Regex KDOC_LINK = null;
    
    /**
     * JVM packages that Kotlin imports with a wildcard by default; explicit named imports from these are redundant.
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.util.Set<java.lang.String> getDEFAULT_STAR_PACKAGES() {
        return null;
    }
    
    /**
     * Computes the canonical import block for [ktFile] given [usage]: unused/redundant imports removed,
     * survivors deduped and lexicographically sorted. Returns null when the imports are already in that
     * exact form (no edit needed). The returned text has no surrounding newlines.
     */
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String organizedImportBlock(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtFile ktFile, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.utils.ImportUsage usage) {
        return null;
    }
    
    private static final boolean keepImport(org.jetbrains.kotlin.psi.KtImportDirective directive, dev.mutwakil.androidide.lsp.kotlin.utils.ImportUsage usage, java.lang.String filePackage, java.util.Set<java.lang.String> kdocNames) {
        return false;
    }
    
    private static final java.util.Set<java.lang.String> collectKDocLinkNames(org.jetbrains.kotlin.psi.KtFile ktFile) {
        return null;
    }
}