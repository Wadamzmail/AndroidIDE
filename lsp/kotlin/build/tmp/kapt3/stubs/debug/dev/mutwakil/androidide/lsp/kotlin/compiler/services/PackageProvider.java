package dev.mutwakil.androidide.lsp.kotlin.compiler.services;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/PackageProvider;", "Lorg/jetbrains/kotlin/analysis/api/platform/packages/KotlinPackageProviderBase;", "project", "Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "searchScope", "Lorg/jetbrains/kotlin/com/intellij/psi/search/GlobalSearchScope;", "index", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/KtSymbolIndex;", "<init>", "(Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;Lorg/jetbrains/kotlin/com/intellij/psi/search/GlobalSearchScope;Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/KtSymbolIndex;)V", "doesKotlinOnlyPackageExist", "", "packageFqName", "Lorg/jetbrains/kotlin/name/FqName;", "getKotlinOnlySubpackageNames", "", "Lorg/jetbrains/kotlin/name/Name;", "kotlin_debug"})
final class PackageProvider extends org.jetbrains.kotlin.analysis.api.platform.packages.KotlinPackageProviderBase {
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex index = null;
    
    public PackageProvider(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.project.Project project, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.psi.search.GlobalSearchScope searchScope, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex index) {
        super(null, null);
    }
    
    @java.lang.Override()
    public boolean doesKotlinOnlyPackageExist(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.FqName packageFqName) {
        return false;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Set<org.jetbrains.kotlin.name.Name> getKotlinOnlySubpackageNames(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.FqName packageFqName) {
        return null;
    }
}