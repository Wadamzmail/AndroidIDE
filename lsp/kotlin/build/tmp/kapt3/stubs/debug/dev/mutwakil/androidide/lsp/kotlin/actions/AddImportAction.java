package dev.mutwakil.androidide.lsp.kotlin.actions;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J(\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@\u00a2\u0006\u0002\u0010\u001aJ7\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000bH\u0000\u00a2\u0006\u0002\b!J\u0018\u0010\"\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0094\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000bX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011\u00a8\u0006&"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/actions/AddImportAction;", "Ldev/mutwakil/androidide/lsp/kotlin/actions/BaseKotlinCodeAction;", "<init>", "()V", "titleTextRes", "", "getTitleTextRes", "()I", "setTitleTextRes", "(I)V", "id", "", "getId", "()Ljava/lang/String;", "label", "getLabel", "setLabel", "(Ljava/lang/String;)V", "prepare", "", "data", "Ldev/mutwakil/androidide/actions/ActionData;", "execAction", "", "", "Ldev/mutwakil/androidide/lsp/models/TextEdit;", "(Ldev/mutwakil/androidide/actions/ActionData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeImportCandidates", "env", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/AbstractCompilationEnvironment;", "nioPath", "Ljava/nio/file/Path;", "reference", "computeImportCandidates$kotlin_debug", "postExec", "result", "", "Companion", "kotlin_debug"})
public final class AddImportAction extends dev.mutwakil.androidide.lsp.kotlin.actions.BaseKotlinCodeAction {
    private int titleTextRes = dev.mutwakil.androidide.resources.R.string.action_import_classes;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = "ide.editor.lsp.kt.diagnostics.addImport";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String label = "";
    private static final org.slf4j.Logger logger = null;
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.kotlin.actions.AddImportAction.Companion Companion = null;
    
    public AddImportAction() {
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
    public void prepare(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.actions.ActionData data) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object execAction(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.actions.ActionData data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, ? extends java.util.List<dev.mutwakil.androidide.lsp.models.TextEdit>>> $completion) {
        return null;
    }
    
    /**
     * Computes, for the unresolved [reference] in the file at [nioPath] within [env], a map from
     * each importable classifier's fully-qualified name to the edits that add its import in sorted
     * position. The [org.jetbrains.kotlin.psi.KtFile] is fetched BEFORE entering [read] (deadlock
     * rule: never block on `getCurrentKtFile(...).get()` inside `project.read`). Keying by FQN
     * collapses the duplicate a symbol picks up from being present in both the source and library
     * indexes. Returns an empty map when there is nothing to import *and* whenever anything in this
     * pipeline throws: the action framework only catches [IllegalArgumentException] and this runs on
     * a coroutine scope with no exception handler, so an uncaught throw here would crash the app.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.util.List<dev.mutwakil.androidide.lsp.models.TextEdit>> computeImportCandidates$kotlin_debug(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.AbstractCompilationEnvironment env, @org.jetbrains.annotations.NotNull()
    java.nio.file.Path nioPath, @org.jetbrains.annotations.NotNull()
    java.lang.String reference) {
        return null;
    }
    
    @java.lang.Override()
    public void postExec(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.actions.ActionData data, @org.jetbrains.annotations.NotNull()
    java.lang.Object result) {
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/actions/AddImportAction$Companion;", "", "<init>", "()V", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "kotlin_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}