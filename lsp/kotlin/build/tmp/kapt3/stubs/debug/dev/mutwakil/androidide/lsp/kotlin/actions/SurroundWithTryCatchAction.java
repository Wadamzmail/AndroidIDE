package dev.mutwakil.androidide.lsp.kotlin.actions;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@\u00a2\u0006\u0002\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0094\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000bX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\""}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/actions/SurroundWithTryCatchAction;", "Ldev/mutwakil/androidide/lsp/kotlin/actions/BaseKotlinCodeAction;", "<init>", "()V", "titleTextRes", "", "getTitleTextRes", "()I", "setTitleTextRes", "(I)V", "id", "", "getId", "()Ljava/lang/String;", "label", "getLabel", "setLabel", "(Ljava/lang/String;)V", "requiresUIThread", "", "getRequiresUIThread", "()Z", "setRequiresUIThread", "(Z)V", "execAction", "", "Ldev/mutwakil/androidide/lsp/models/TextEdit;", "data", "Ldev/mutwakil/androidide/actions/ActionData;", "(Ldev/mutwakil/androidide/actions/ActionData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postExec", "", "result", "", "kotlin_debug"})
public final class SurroundWithTryCatchAction extends dev.mutwakil.androidide.lsp.kotlin.actions.BaseKotlinCodeAction {
    private int titleTextRes = dev.mutwakil.androidide.resources.R.string.action_surround_with_try_catch;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = "ide.editor.lsp.kt.surroundWithTryCatch";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String label = "";
    private boolean requiresUIThread = true;
    
    public SurroundWithTryCatchAction() {
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
    public boolean getRequiresUIThread() {
        return false;
    }
    
    @java.lang.Override()
    public void setRequiresUIThread(boolean p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object execAction(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.actions.ActionData data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<dev.mutwakil.androidide.lsp.models.TextEdit>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    public void postExec(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.actions.ActionData data, @org.jetbrains.annotations.NotNull()
    java.lang.Object result) {
    }
}