package dev.mutwakil.androidide.lsp.kotlin.compiler.services;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u00a8\u0006\n"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/AnalysisPermissionOptions;", "Lorg/jetbrains/kotlin/analysis/api/platform/permissions/KotlinAnalysisPermissionOptions;", "defaultIsAnalysisAllowedOnEdt", "", "defaultIsAnalysisAllowedInWriteAction", "<init>", "(ZZ)V", "getDefaultIsAnalysisAllowedOnEdt", "()Z", "getDefaultIsAnalysisAllowedInWriteAction", "kotlin_debug"})
public final class AnalysisPermissionOptions implements org.jetbrains.kotlin.analysis.api.platform.permissions.KotlinAnalysisPermissionOptions {
    private final boolean defaultIsAnalysisAllowedOnEdt = false;
    private final boolean defaultIsAnalysisAllowedInWriteAction = false;
    
    public AnalysisPermissionOptions(boolean defaultIsAnalysisAllowedOnEdt, boolean defaultIsAnalysisAllowedInWriteAction) {
        super();
    }
    
    @java.lang.Override()
    public boolean getDefaultIsAnalysisAllowedOnEdt() {
        return false;
    }
    
    @java.lang.Override()
    public boolean getDefaultIsAnalysisAllowedInWriteAction() {
        return false;
    }
    
    public AnalysisPermissionOptions() {
        super();
    }
}