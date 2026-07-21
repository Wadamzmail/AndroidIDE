package dev.mutwakil.androidide.lsp.kotlin.utils;

/**
 * What a file's body actually uses, expressed as plain strings so nothing crosses an `analyze`
 * lifetime boundary. Produced by [collectImportUsage].
 *
 * @property usedFqNames importable fully-qualified names referenced by the body.
 * @property usedPackages parent packages/objects of used symbols (for wildcard matching).
 * @property unresolvedNames short names of body references that failed to resolve; an import
 *  matching one of these is kept, since a resolution failure can't prove the import unused.
 */
@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J9\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015H\u00d6\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0004H\u00d6\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n\u00a8\u0006\u0017"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/utils/ImportUsage;", "", "usedFqNames", "", "", "usedPackages", "unresolvedNames", "<init>", "(Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;)V", "getUsedFqNames", "()Ljava/util/Set;", "getUsedPackages", "getUnresolvedNames", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "kotlin_debug"})
public final class ImportUsage {
    @org.jetbrains.annotations.NotNull()
    private final java.util.Set<java.lang.String> usedFqNames = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Set<java.lang.String> usedPackages = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Set<java.lang.String> unresolvedNames = null;
    
    public ImportUsage(@org.jetbrains.annotations.NotNull()
    java.util.Set<java.lang.String> usedFqNames, @org.jetbrains.annotations.NotNull()
    java.util.Set<java.lang.String> usedPackages, @org.jetbrains.annotations.NotNull()
    java.util.Set<java.lang.String> unresolvedNames) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<java.lang.String> getUsedFqNames() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<java.lang.String> getUsedPackages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<java.lang.String> getUnresolvedNames() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<java.lang.String> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<java.lang.String> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<java.lang.String> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.lsp.kotlin.utils.ImportUsage copy(@org.jetbrains.annotations.NotNull()
    java.util.Set<java.lang.String> usedFqNames, @org.jetbrains.annotations.NotNull()
    java.util.Set<java.lang.String> usedPackages, @org.jetbrains.annotations.NotNull()
    java.util.Set<java.lang.String> unresolvedNames) {
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