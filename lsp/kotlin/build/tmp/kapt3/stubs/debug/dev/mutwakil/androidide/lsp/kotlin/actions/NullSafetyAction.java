package dev.mutwakil.androidide.lsp.kotlin.actions;

/**
 * Offers null-safety quick fixes on an UNSAFE_CALL diagnostic (`receiver.selector` where `receiver`
 * is nullable): assert non-null (`!!`), safe call (`?.`), or an Elvis fallback (`?:`). Each is a
 * separate suggestion. Diagnostic-driven, mirroring [AddImportAction].
 *
 * Scope is deliberately the dot-qualified member-access case (UNSAFE_CALL). The sibling unsafe-call
 * factories (implicit-invoke/infix/operator) sit on other PSI shapes and would need different
 * rewrites; nullable type-mismatch (assignment/return/argument) is a different fix entirely. Both
 * are out of scope here.
 */
@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@\u00a2\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0094\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000bX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001e"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/actions/NullSafetyAction;", "Ldev/mutwakil/androidide/lsp/kotlin/actions/BaseKotlinCodeAction;", "<init>", "()V", "titleTextRes", "", "getTitleTextRes", "()I", "setTitleTextRes", "(I)V", "id", "", "getId", "()Ljava/lang/String;", "label", "getLabel", "setLabel", "(Ljava/lang/String;)V", "prepare", "", "data", "Ldev/mutwakil/androidide/actions/ActionData;", "execAction", "", "Ldev/mutwakil/androidide/lsp/kotlin/utils/NullSafetyVariant;", "(Ldev/mutwakil/androidide/actions/ActionData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postExec", "result", "", "Companion", "kotlin_debug"})
public final class NullSafetyAction extends dev.mutwakil.androidide.lsp.kotlin.actions.BaseKotlinCodeAction {
    private int titleTextRes = dev.mutwakil.androidide.resources.R.string.action_null_safety_fixes;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = "ide.editor.lsp.kt.diagnostics.nullSafety";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String label = "";
    private static final org.slf4j.Logger logger = null;
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.kotlin.actions.NullSafetyAction.Companion Companion = null;
    
    public NullSafetyAction() {
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
    kotlin.coroutines.Continuation<? super java.util.List<dev.mutwakil.androidide.lsp.kotlin.utils.NullSafetyVariant>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    public void postExec(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.actions.ActionData data, @org.jetbrains.annotations.NotNull()
    java.lang.Object result) {
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/actions/NullSafetyAction$Companion;", "", "<init>", "()V", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "kotlin_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}