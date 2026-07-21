package dev.mutwakil.androidide.lsp.kotlin.actions;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@\u00a2\u0006\u0002\u0010\u0017J#\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0000\u00a2\u0006\u0002\b\u001dJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0094\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000bX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011\u00a8\u0006#"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/actions/OrganizeImportsAction;", "Ldev/mutwakil/androidide/lsp/kotlin/actions/BaseKotlinCodeAction;", "<init>", "()V", "titleTextRes", "", "getTitleTextRes", "()I", "setTitleTextRes", "(I)V", "id", "", "getId", "()Ljava/lang/String;", "label", "getLabel", "setLabel", "(Ljava/lang/String;)V", "execAction", "", "Ldev/mutwakil/androidide/lsp/models/TextEdit;", "data", "Ldev/mutwakil/androidide/actions/ActionData;", "(Ldev/mutwakil/androidide/actions/ActionData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeOrganizeEdit", "env", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/AbstractCompilationEnvironment;", "nioPath", "Ljava/nio/file/Path;", "computeOrganizeEdit$kotlin_debug", "postExec", "", "result", "", "Companion", "kotlin_debug"})
public final class OrganizeImportsAction extends dev.mutwakil.androidide.lsp.kotlin.actions.BaseKotlinCodeAction {
    private int titleTextRes = dev.mutwakil.androidide.resources.R.string.action_organize_imports;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = "ide.editor.lsp.kt.organizeImports";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String label = "";
    private static final org.slf4j.Logger logger = null;
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.kotlin.actions.OrganizeImportsAction.Companion Companion = null;
    
    public OrganizeImportsAction() {
        super();
    }
    
    @java.lang.Override()
    protected int getTitleTextRes() {
        return 0;
    }
    
    @java.lang.Override()
    protected void setTitleTextRes(int p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getId() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getLabel() {
        return null;
    }
    
    @java.lang.Override()
    public void setLabel(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object execAction(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.actions.ActionData data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<dev.mutwakil.androidide.lsp.models.TextEdit>> $completion) {
        return null;
    }
    
    /**
     * Computes the text edits that organize the imports of the file at [nioPath] within [env].
     * The current [org.jetbrains.kotlin.psi.KtFile] is fetched BEFORE entering [read] (deadlock
     * rule: never block on `getCurrentKtFile(...).get()` inside `project.read`). Returns an empty
     * list when there is nothing to do (no imports, already organized, or no usable range) *and*
     * whenever anything in this pipeline (the `.get()`, analysis, or PSI access) throws: the action
     * framework only catches [IllegalArgumentException] and this runs on a coroutine scope with no
     * exception handler, so an uncaught throw here would crash the app. Degrading to zero edits is
     * always safe -- it just leaves the imports as-is, never produces a partial/incorrect rewrite.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<dev.mutwakil.androidide.lsp.models.TextEdit> computeOrganizeEdit$kotlin_debug(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.AbstractCompilationEnvironment env, @org.jetbrains.annotations.NotNull()
    java.nio.file.Path nioPath) {
        return null;
    }
    
    @java.lang.Override()
    public void postExec(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.actions.ActionData data, @org.jetbrains.annotations.NotNull()
    java.lang.Object result) {
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/actions/OrganizeImportsAction$Companion;", "", "<init>", "()V", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "kotlin_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}