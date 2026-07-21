package dev.mutwakil.androidide.lsp.kotlin.compiler.services;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J4\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rH\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/DeclarationProviderFactory;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/KtLspService;", "Lorg/jetbrains/kotlin/analysis/api/platform/declarations/KotlinDeclarationProviderFactory;", "<init>", "()V", "project", "Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "index", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/KtSymbolIndex;", "setupWith", "", "Lorg/jetbrains/kotlin/com/intellij/mock/MockProject;", "modules", "", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/KtModule;", "libraryRoots", "Lorg/jetbrains/kotlin/cli/jvm/index/JavaRoot;", "createDeclarationProvider", "Lorg/jetbrains/kotlin/analysis/api/platform/declarations/KotlinDeclarationProvider;", "scope", "Lorg/jetbrains/kotlin/com/intellij/psi/search/GlobalSearchScope;", "contextualModule", "Lorg/jetbrains/kotlin/analysis/api/projectStructure/KaModule;", "kotlin_debug"})
public final class DeclarationProviderFactory implements dev.mutwakil.androidide.lsp.kotlin.compiler.services.KtLspService, org.jetbrains.kotlin.analysis.api.platform.declarations.KotlinDeclarationProviderFactory {
    private org.jetbrains.kotlin.com.intellij.openapi.project.Project project;
    private dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex index;
    
    public DeclarationProviderFactory() {
        super();
    }
    
    @java.lang.Override()
    public void setupWith(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.mock.MockProject project, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex index, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> modules, @org.jetbrains.annotations.NotNull()
    java.util.List<org.jetbrains.kotlin.cli.jvm.index.JavaRoot> libraryRoots) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.kotlin.analysis.api.platform.declarations.KotlinDeclarationProvider createDeclarationProvider(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.psi.search.GlobalSearchScope scope, @org.jetbrains.annotations.Nullable()
    org.jetbrains.kotlin.analysis.api.projectStructure.KaModule contextualModule) {
        return null;
    }
}