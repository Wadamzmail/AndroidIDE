package dev.mutwakil.androidide.lsp.kotlin.utils;

@kotlin.Metadata(mv = {2, 3, 0}, k = 2, xi = 48, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u000e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0007H\u0002\u00a8\u0006\b"}, d2 = {"collectImportUsage", "Ldev/mutwakil/androidide/lsp/kotlin/utils/ImportUsage;", "Lorg/jetbrains/kotlin/analysis/api/KaSession;", "ktFile", "Lorg/jetbrains/kotlin/psi/KtFile;", "importableFqNameString", "", "Lorg/jetbrains/kotlin/analysis/api/symbols/KaSymbol;", "kotlin_debug"})
public final class ImportUsageCollectorKt {
    
    /**
     * Collects the importable fq-names (and their packages) referenced by [ktFile]'s body. MUST be
     * called inside [analyzeMaybeDangling]. Returns only plain strings, so nothing escapes the analyze
     * lifetime. A reference that fails to resolve doesn't join the used set; instead its short name is
     * recorded in [ImportUsage.unresolvedNames] so its import is kept. Both paths are safe: they lead to
     * keeping an import, never removing a used one.
     */
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.kotlin.utils.ImportUsage collectImportUsage(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.KaSession $this$collectImportUsage, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtFile ktFile) {
        return null;
    }
    
    private static final java.lang.String importableFqNameString(org.jetbrains.kotlin.analysis.api.symbols.KaSymbol $this$importableFqNameString) {
        return null;
    }
}