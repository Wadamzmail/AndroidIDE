package dev.mutwakil.androidide.lsp.kotlin.utils;

@kotlin.Metadata(mv = {2, 3, 0}, k = 2, xi = 48, d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a&\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u00052\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0000\u001a$\u0010\f\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0002\u001a$\u0010\u000f\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u001a\u0010\u0015\u001a\u00020\u0001*\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0003H\u0002\u001a\u001a\u0010\u0018\u001a\u00020\u0001*\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0003H\u0002\u001a\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0003*\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0017H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"STUB_BODY", "", "membersToImplement", "", "Lorg/jetbrains/kotlin/analysis/api/symbols/KaCallableSymbol;", "Lorg/jetbrains/kotlin/analysis/api/KaSession;", "classSymbol", "Lorg/jetbrains/kotlin/analysis/api/symbols/KaClassSymbol;", "renderOverrideStub", "member", "indent", "unit", "renderFunctionStub", "fn", "Lorg/jetbrains/kotlin/analysis/api/symbols/KaNamedFunctionSymbol;", "renderPropertyStub", "prop", "Lorg/jetbrains/kotlin/analysis/api/symbols/KaPropertySymbol;", "visibilityPrefix", "visibility", "Lorg/jetbrains/kotlin/analysis/api/symbols/KaSymbolVisibility;", "renderTypeParams", "typeParams", "Lorg/jetbrains/kotlin/analysis/api/symbols/KaTypeParameterSymbol;", "renderWhereClause", "meaningfulBounds", "Lorg/jetbrains/kotlin/analysis/api/types/KaType;", "tp", "kotlin_debug"})
public final class AbstractMemberStubsKt {
    
    /**
     * The body every generated stub gets; `TODO` returns `Nothing`, so it type-checks for any return type.
     */
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String STUB_BODY = "TODO(\"Not yet implemented\")";
    
    /**
     * The abstract functions and properties [classSymbol] inherits but does not yet implement, in a
     * stable (name-sorted) order. MUST be called inside an `analyze` block.
     *
     * A member's *effective* modality in [classSymbol]'s member scope is [KaSymbolModality.ABSTRACT] only
     * when no supertype (and not the class itself) provides a concrete override. Overridden members show
     * up non-abstract and are excluded. Members inherited unimplemented from several supertypes collapse
     * to a single intersection symbol here, so each signature is rendered once.
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<org.jetbrains.kotlin.analysis.api.symbols.KaCallableSymbol> membersToImplement(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.KaSession $this$membersToImplement, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.symbols.KaClassSymbol classSymbol) {
        return null;
    }
    
    /**
     * Renders [member] as a complete `override` declaration, ready to drop into a class body. Every line
     * is prefixed with [indent] (the base indentation of a member in the target class); the body is
     * indented one [unit] deeper. The result has no leading or trailing newline. Returns null for a
     * member this renderer doesn't handle.
     *
     * LSP TextEdits bypass the editor's auto-indent, so the emitted text must already be final: nothing
     * re-indents it after it is applied. [unit] is the surrounding file's own indentation step (a tab or
     * N spaces), so stubs match the file's style rather than assuming tabs.
     */
    @kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaExperimentalApi.class})
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String renderOverrideStub(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.KaSession $this$renderOverrideStub, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.symbols.KaCallableSymbol member, @org.jetbrains.annotations.NotNull()
    java.lang.String indent, @org.jetbrains.annotations.NotNull()
    java.lang.String unit) {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaExperimentalApi.class})
    private static final java.lang.String renderFunctionStub(org.jetbrains.kotlin.analysis.api.KaSession $this$renderFunctionStub, org.jetbrains.kotlin.analysis.api.symbols.KaNamedFunctionSymbol fn, java.lang.String indent, java.lang.String unit) {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaExperimentalApi.class})
    private static final java.lang.String renderPropertyStub(org.jetbrains.kotlin.analysis.api.KaSession $this$renderPropertyStub, org.jetbrains.kotlin.analysis.api.symbols.KaPropertySymbol prop, java.lang.String indent, java.lang.String unit) {
        return null;
    }
    
    private static final java.lang.String visibilityPrefix(org.jetbrains.kotlin.analysis.api.symbols.KaSymbolVisibility visibility) {
        return null;
    }
    
    /**
     * Renders `<A, B : Bound>` (or empty). Multi-bound parameters are emitted via [renderWhereClause].
     */
    @kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaExperimentalApi.class})
    private static final java.lang.String renderTypeParams(org.jetbrains.kotlin.analysis.api.KaSession $this$renderTypeParams, java.util.List<? extends org.jetbrains.kotlin.analysis.api.symbols.KaTypeParameterSymbol> typeParams) {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaExperimentalApi.class})
    private static final java.lang.String renderWhereClause(org.jetbrains.kotlin.analysis.api.KaSession $this$renderWhereClause, java.util.List<? extends org.jetbrains.kotlin.analysis.api.symbols.KaTypeParameterSymbol> typeParams) {
        return null;
    }
    
    /**
     * Upper bounds excluding the implicit `Any?` that an unbounded type parameter carries.
     */
    @kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaExperimentalApi.class})
    private static final java.util.List<org.jetbrains.kotlin.analysis.api.types.KaType> meaningfulBounds(org.jetbrains.kotlin.analysis.api.KaSession $this$meaningfulBounds, org.jetbrains.kotlin.analysis.api.symbols.KaTypeParameterSymbol tp) {
        return null;
    }
}