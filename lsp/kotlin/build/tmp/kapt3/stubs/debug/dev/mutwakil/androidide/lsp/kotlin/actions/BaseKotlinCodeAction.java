package dev.mutwakil.androidide.lsp.kotlin.actions;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0017X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001d8%X\u00a4\u000e\u00a2\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\n $*\u0004\u0018\u00010#0#X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010+\u001a\u0004\u0018\u00010,*\u00020*8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010.\u00a8\u0006/"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/actions/BaseKotlinCodeAction;", "Ldev/mutwakil/androidide/actions/EditorActionItem;", "<init>", "()V", "visible", "", "getVisible", "()Z", "setVisible", "(Z)V", "enabled", "getEnabled", "setEnabled", "icon", "Landroid/graphics/drawable/Drawable;", "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "requiresUIThread", "getRequiresUIThread", "setRequiresUIThread", "location", "Ldev/mutwakil/androidide/actions/ActionItem$Location;", "getLocation", "()Ldev/mutwakil/androidide/actions/ActionItem$Location;", "setLocation", "(Ldev/mutwakil/androidide/actions/ActionItem$Location;)V", "titleTextRes", "", "getTitleTextRes", "()I", "setTitleTextRes", "(I)V", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "getLogger", "()Lorg/slf4j/Logger;", "prepare", "", "data", "Ldev/mutwakil/androidide/actions/ActionData;", "languageClient", "Ldev/mutwakil/androidide/lsp/api/ILanguageClient;", "getLanguageClient", "(Ldev/mutwakil/androidide/actions/ActionData;)Ldev/mutwakil/androidide/lsp/api/ILanguageClient;", "kotlin_debug"})
public abstract class BaseKotlinCodeAction implements dev.mutwakil.androidide.actions.EditorActionItem {
    private boolean visible = true;
    private boolean enabled = true;
    @org.jetbrains.annotations.Nullable()
    private android.graphics.drawable.Drawable icon;
    private boolean requiresUIThread = false;
    @org.jetbrains.annotations.NotNull()
    private dev.mutwakil.androidide.actions.ActionItem.Location location = dev.mutwakil.androidide.actions.ActionItem.Location.EDITOR_CODE_ACTIONS;
    private final org.slf4j.Logger logger = null;
    
    public BaseKotlinCodeAction() {
        super();
    }
    
    @java.lang.Override()
    public boolean getVisible() {
        return false;
    }
    
    @java.lang.Override()
    public void setVisible(boolean p0) {
    }
    
    @java.lang.Override()
    public boolean getEnabled() {
        return false;
    }
    
    @java.lang.Override()
    public void setEnabled(boolean p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.graphics.drawable.Drawable getIcon() {
        return null;
    }
    
    @java.lang.Override()
    public void setIcon(@org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable p0) {
    }
    
    @java.lang.Override()
    public boolean getRequiresUIThread() {
        return false;
    }
    
    @java.lang.Override()
    public void setRequiresUIThread(boolean p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public dev.mutwakil.androidide.actions.ActionItem.Location getLocation() {
        return null;
    }
    
    @java.lang.Override()
    public void setLocation(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.actions.ActionItem.Location p0) {
    }
    
    @androidx.annotation.StringRes()
    protected abstract int getTitleTextRes();
    
    protected abstract void setTitleTextRes(int p0);
    
    protected final org.slf4j.Logger getLogger() {
        return null;
    }
    
    @java.lang.Override()
    public void prepare(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.actions.ActionData data) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final dev.mutwakil.androidide.lsp.api.ILanguageClient getLanguageClient(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.actions.ActionData $this$languageClient) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.view.View createActionView(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.actions.ActionData data) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.graphics.ColorFilter createColorFilter(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.actions.ActionData data) {
        return null;
    }
    
    @java.lang.Override()
    public void destroy() {
    }
    
    @java.lang.Override()
    public boolean dismissOnAction() {
        return false;
    }
    
    @java.lang.Override()
    public int getItemId() {
        return 0;
    }
    
    @java.lang.Override()
    public int getOrder() {
        return 0;
    }
    
    @java.lang.Override()
    public int getShowAsActionFlags(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.actions.ActionData data) {
        return 0;
    }
    
    @java.lang.Override()
    public void postExec(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.actions.ActionData data, @org.jetbrains.annotations.NotNull()
    java.lang.Object result) {
    }
}