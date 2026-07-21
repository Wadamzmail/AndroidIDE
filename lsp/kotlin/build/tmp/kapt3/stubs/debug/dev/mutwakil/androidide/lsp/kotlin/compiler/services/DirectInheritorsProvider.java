package dev.mutwakil.androidide.lsp.kotlin.compiler.services;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J4\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\bH\u0016J&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0014H\u0002J\u001e\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u000e2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000fH\u0002J(\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\'2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u001a\u0010(\u001a\b\u0012\u0002\b\u0003\u0018\u00010)*\u00020*2\u0006\u0010+\u001a\u00020,H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000f0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/DirectInheritorsProvider;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/KtLspService;", "Lorg/jetbrains/kotlin/analysis/api/platform/declarations/KotlinDirectInheritorsProvider;", "<init>", "()V", "index", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/KtSymbolIndex;", "modules", "", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/KtModule;", "project", "Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "classesBySupertypeName", "", "Lorg/jetbrains/kotlin/name/Name;", "", "Lorg/jetbrains/kotlin/psi/KtClassOrObject;", "inheritableTypeAliasesByAliasedName", "Lorg/jetbrains/kotlin/psi/KtTypeAlias;", "setupWith", "", "Lorg/jetbrains/kotlin/com/intellij/mock/MockProject;", "libraryRoots", "Lorg/jetbrains/kotlin/cli/jvm/index/JavaRoot;", "getDirectKotlinInheritors", "", "ktClass", "Lorg/jetbrains/kotlin/psi/KtClass;", "scope", "Lorg/jetbrains/kotlin/com/intellij/psi/search/GlobalSearchScope;", "includeLocalInheritors", "", "computeIndex", "calculateAliases", "aliasedName", "aliases", "isValidInheritor", "candidate", "baseFirClass", "Lorg/jetbrains/kotlin/fir/declarations/FirClass;", "toFirSymbol", "Lorg/jetbrains/kotlin/fir/symbols/impl/FirClassLikeSymbol;", "Lorg/jetbrains/kotlin/name/ClassId;", "module", "Lorg/jetbrains/kotlin/analysis/api/projectStructure/KaModule;", "kotlin_debug"})
public final class DirectInheritorsProvider implements dev.mutwakil.androidide.lsp.kotlin.compiler.services.KtLspService, org.jetbrains.kotlin.analysis.api.platform.declarations.KotlinDirectInheritorsProvider {
    private dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex index;
    private java.util.List<? extends dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> modules;
    private org.jetbrains.kotlin.com.intellij.openapi.project.Project project;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<org.jetbrains.kotlin.name.Name, java.util.Set<org.jetbrains.kotlin.psi.KtClassOrObject>> classesBySupertypeName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<org.jetbrains.kotlin.name.Name, java.util.Set<org.jetbrains.kotlin.psi.KtTypeAlias>> inheritableTypeAliasesByAliasedName = null;
    
    public DirectInheritorsProvider() {
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
    @kotlin.OptIn(markerClass = {org.jetbrains.kotlin.fir.symbols.SymbolInternals.class})
    @org.jetbrains.annotations.NotNull()
    public java.lang.Iterable<org.jetbrains.kotlin.psi.KtClassOrObject> getDirectKotlinInheritors(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtClass ktClass, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.psi.search.GlobalSearchScope scope, boolean includeLocalInheritors) {
        return null;
    }
    
    private final void computeIndex() {
    }
    
    private final void calculateAliases(org.jetbrains.kotlin.name.Name aliasedName, java.util.Set<org.jetbrains.kotlin.name.Name> aliases) {
    }
    
    @kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaImplementationDetail.class, org.jetbrains.kotlin.fir.symbols.SymbolInternals.class})
    private final boolean isValidInheritor(org.jetbrains.kotlin.psi.KtClassOrObject candidate, org.jetbrains.kotlin.fir.declarations.FirClass baseFirClass, org.jetbrains.kotlin.com.intellij.psi.search.GlobalSearchScope scope, boolean includeLocalInheritors) {
        return false;
    }
    
    @kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.low.level.api.fir.LLFirInternals.class})
    private final org.jetbrains.kotlin.fir.symbols.impl.FirClassLikeSymbol<?> toFirSymbol(org.jetbrains.kotlin.name.ClassId $this$toFirSymbol, org.jetbrains.kotlin.analysis.api.projectStructure.KaModule module) {
        return null;
    }
}