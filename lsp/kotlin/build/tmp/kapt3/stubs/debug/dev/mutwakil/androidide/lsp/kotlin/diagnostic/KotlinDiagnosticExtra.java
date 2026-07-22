package dev.mutwakil.androidide.lsp.kotlin.diagnostic;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016H\u00d6\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003H\u00d6\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u00a8\u0006\u0018"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/diagnostic/KotlinDiagnosticExtra;", "", "unresolvedReference", "", "compilationEnv", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationEnvironment;", "nullSafetyFactory", "<init>", "(Ljava/lang/String;Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationEnvironment;Ljava/lang/String;)V", "getUnresolvedReference", "()Ljava/lang/String;", "getCompilationEnv", "()Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationEnvironment;", "getNullSafetyFactory", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "kotlin_debug"})
public final class KotlinDiagnosticExtra {
    
    /**
     * The unresolved-reference name extracted from an [KaFirDiagnostic.UnresolvedReference]
     * diagnostic, or `null` for any other diagnostic. This is plain data extracted *inside* the
     * `analyze` block on purpose: storing the [KaDiagnosticWithPsi] (a `KaLifetimeOwner`) here and
     * reading its members later from a code action would access it outside an `analyze` context and
     * crash with `KaInaccessibleLifetimeOwnerAccessException`.
     */
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String unresolvedReference = null;
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationEnvironment compilationEnv = null;
    
    /**
     * The FIR diagnostic factory name (e.g. `UNSAFE_CALL`) when this diagnostic flags an unsafe
     * member access on a nullable receiver, else `null`. Captured here as plain data so a code
     * action can decide visibility without touching the [KaDiagnosticWithPsi] lifetime owner.
     */
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String nullSafetyFactory = null;
    
    public KotlinDiagnosticExtra(@org.jetbrains.annotations.Nullable()
    java.lang.String unresolvedReference, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationEnvironment compilationEnv, @org.jetbrains.annotations.Nullable()
    java.lang.String nullSafetyFactory) {
        super();
    }
    
    /**
     * The unresolved-reference name extracted from an [KaFirDiagnostic.UnresolvedReference]
     * diagnostic, or `null` for any other diagnostic. This is plain data extracted *inside* the
     * `analyze` block on purpose: storing the [KaDiagnosticWithPsi] (a `KaLifetimeOwner`) here and
     * reading its members later from a code action would access it outside an `analyze` context and
     * crash with `KaInaccessibleLifetimeOwnerAccessException`.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUnresolvedReference() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationEnvironment getCompilationEnv() {
        return null;
    }
    
    /**
     * The FIR diagnostic factory name (e.g. `UNSAFE_CALL`) when this diagnostic flags an unsafe
     * member access on a nullable receiver, else `null`. Captured here as plain data so a code
     * action can decide visibility without touching the [KaDiagnosticWithPsi] lifetime owner.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNullSafetyFactory() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationEnvironment component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.lsp.kotlin.diagnostic.KotlinDiagnosticExtra copy(@org.jetbrains.annotations.Nullable()
    java.lang.String unresolvedReference, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationEnvironment compilationEnv, @org.jetbrains.annotations.Nullable()
    java.lang.String nullSafetyFactory) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}