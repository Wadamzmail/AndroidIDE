package dev.mutwakil.androidide.lsp.kotlin.compiler.services;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\rX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/DeclarationProvider;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/AbstractDeclarationProvider;", "scope", "Lorg/jetbrains/kotlin/com/intellij/psi/search/GlobalSearchScope;", "project", "Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "index", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/KtSymbolIndex;", "<init>", "(Lorg/jetbrains/kotlin/com/intellij/psi/search/GlobalSearchScope;Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/KtSymbolIndex;)V", "getScope", "()Lorg/jetbrains/kotlin/com/intellij/psi/search/GlobalSearchScope;", "hasSpecificCallablePackageNamesComputation", "", "getHasSpecificCallablePackageNamesComputation", "()Z", "hasSpecificClassifierPackageNamesComputation", "getHasSpecificClassifierPackageNamesComputation", "ktFilesForPackage", "Lkotlin/sequences/Sequence;", "Lorg/jetbrains/kotlin/psi/KtFile;", "fqName", "Lorg/jetbrains/kotlin/name/FqName;", "kotlin_debug"})
public final class DeclarationProvider extends dev.mutwakil.androidide.lsp.kotlin.compiler.services.AbstractDeclarationProvider {
    @org.jetbrains.annotations.NotNull()
    private final org.jetbrains.kotlin.com.intellij.psi.search.GlobalSearchScope scope = null;
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex index = null;
    private final boolean hasSpecificCallablePackageNamesComputation = false;
    private final boolean hasSpecificClassifierPackageNamesComputation = false;
    
    public DeclarationProvider(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.psi.search.GlobalSearchScope scope, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.project.Project project, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex index) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.com.intellij.psi.search.GlobalSearchScope getScope() {
        return null;
    }
    
    @java.lang.Override()
    public boolean getHasSpecificCallablePackageNamesComputation() {
        return false;
    }
    
    @java.lang.Override()
    public boolean getHasSpecificClassifierPackageNamesComputation() {
        return false;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected kotlin.sequences.Sequence<org.jetbrains.kotlin.psi.KtFile> ktFilesForPackage(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.FqName fqName) {
        return null;
    }
}