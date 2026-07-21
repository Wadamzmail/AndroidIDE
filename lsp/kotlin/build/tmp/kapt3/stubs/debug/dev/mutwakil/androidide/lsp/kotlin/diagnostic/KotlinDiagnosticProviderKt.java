package dev.mutwakil.androidide.lsp.kotlin.diagnostic;

@kotlin.Metadata(mv = {2, 3, 0}, k = 2, xi = 48, d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000R\u00020\u0005j\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000b\u001a)\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u00020\u0005j\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000b\u001a\u0010\u0010\r\u001a\u00020\u000e*\u0006\u0012\u0002\b\u00030\u000fH\u0002\u001a(\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001a\f\u0010\u0018\u001a\u00020\u0017*\u00020\u0019H\u0002\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "collectDiagnosticsFor", "Ldev/mutwakil/androidide/lsp/models/DiagnosticResult;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationEnvironment;", "env", "file", "Ljava/nio/file/Path;", "cancelChecker", "Ldev/mutwakil/androidide/progress/ICancelChecker;", "(Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationEnvironment;Ljava/nio/file/Path;Ldev/mutwakil/androidide/progress/ICancelChecker;)Ldev/mutwakil/androidide/lsp/models/DiagnosticResult;", "doAnalyze", "toDiagnosticItem", "Ldev/mutwakil/androidide/lsp/models/DiagnosticItem;", "Lorg/jetbrains/kotlin/analysis/api/diagnostics/KaDiagnosticWithPsi;", "diagnosticItem", "Lorg/jetbrains/kotlin/com/intellij/psi/PsiFile;", "message", "", "range", "Lorg/jetbrains/kotlin/com/intellij/openapi/util/TextRange;", "severity", "Ldev/mutwakil/androidide/lsp/models/DiagnosticSeverity;", "toDiagnosticSeverity", "Lorg/jetbrains/kotlin/analysis/api/diagnostics/KaSeverity;", "kotlin_debug"})
public final class KotlinDiagnosticProviderKt {
    private static final org.slf4j.Logger logger = null;
    
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.models.DiagnosticResult collectDiagnosticsFor(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationEnvironment env, @org.jetbrains.annotations.NotNull()
    java.nio.file.Path file, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.progress.ICancelChecker cancelChecker) {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaExperimentalApi.class})
    private static final dev.mutwakil.androidide.lsp.models.DiagnosticResult doAnalyze(dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationEnvironment env, java.nio.file.Path file, dev.mutwakil.androidide.progress.ICancelChecker cancelChecker) {
        return null;
    }
    
    private static final dev.mutwakil.androidide.lsp.models.DiagnosticItem toDiagnosticItem(org.jetbrains.kotlin.analysis.api.diagnostics.KaDiagnosticWithPsi<?> $this$toDiagnosticItem) {
        return null;
    }
    
    private static final dev.mutwakil.androidide.lsp.models.DiagnosticItem diagnosticItem(org.jetbrains.kotlin.com.intellij.psi.PsiFile file, java.lang.String message, org.jetbrains.kotlin.com.intellij.openapi.util.TextRange range, dev.mutwakil.androidide.lsp.models.DiagnosticSeverity severity) {
        return null;
    }
    
    private static final dev.mutwakil.androidide.lsp.models.DiagnosticSeverity toDiagnosticSeverity(org.jetbrains.kotlin.analysis.api.diagnostics.KaSeverity $this$toDiagnosticSeverity) {
        return null;
    }
}