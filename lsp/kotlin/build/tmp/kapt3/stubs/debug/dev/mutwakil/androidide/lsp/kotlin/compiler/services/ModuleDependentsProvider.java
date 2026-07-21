package dev.mutwakil.androidide.lsp.kotlin.compiler.services;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J4\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006H\u0016J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120\u001c2\u0006\u0010!\u001a\u00020\u0012H\u0016J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120\u001c2\u0006\u0010!\u001a\u00020\u0012H\u0016J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120\u001c2\u0006\u0010!\u001a\u00020\u0012H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R-\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00130\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R9\u0010\u0018\u001a-\u0012\u000e\u0012\f0\u0012\u00a2\u0006\u0002\b\u001a\u00a2\u0006\u0002\b\u001b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00120\u001c\u00a2\u0006\u0002\b\u001a\u00a2\u0006\u0002\b\u001b0\u0019\u00a2\u0006\u0002\b\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R-\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00130\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b\u001e\u0010\u0015\u00a8\u0006$"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/ModuleDependentsProvider;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/KtLspService;", "Lorg/jetbrains/kotlin/analysis/api/platform/projectStructure/KotlinModuleDependentsProviderBase;", "<init>", "()V", "modules", "", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/KtModule;", "setupWith", "", "project", "Lorg/jetbrains/kotlin/com/intellij/mock/MockProject;", "index", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/KtSymbolIndex;", "libraryRoots", "Lorg/jetbrains/kotlin/cli/jvm/index/JavaRoot;", "directDependentsByKtModule", "", "Lorg/jetbrains/kotlin/analysis/api/projectStructure/KaModule;", "", "getDirectDependentsByKtModule", "()Ljava/util/Map;", "directDependentsByKtModule$delegate", "Lkotlin/Lazy;", "transitiveDependentsByKtModule", "Ljava/util/concurrent/ConcurrentMap;", "Lorg/jetbrains/annotations/NotNull;", "Lkotlin/jvm/internal/EnhancedNullability;", "", "refinementDependentsByKtModule", "getRefinementDependentsByKtModule", "refinementDependentsByKtModule$delegate", "getDirectDependents", "module", "getRefinementDependents", "getTransitiveDependents", "kotlin_debug"})
public final class ModuleDependentsProvider extends org.jetbrains.kotlin.analysis.api.platform.projectStructure.KotlinModuleDependentsProviderBase implements dev.mutwakil.androidide.lsp.kotlin.compiler.services.KtLspService {
    private java.util.List<? extends dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> modules;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy directDependentsByKtModule$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.ConcurrentMap<org.jetbrains.kotlin.analysis.api.projectStructure.KaModule, java.util.Set<org.jetbrains.kotlin.analysis.api.projectStructure.KaModule>> transitiveDependentsByKtModule = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy refinementDependentsByKtModule$delegate = null;
    
    public ModuleDependentsProvider() {
        super();
    }
    
    @java.lang.Override()
    public void setupWith(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.mock.MockProject project, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex index, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> modules, @org.jetbrains.annotations.NotNull()
    java.util.List<org.jetbrains.kotlin.cli.jvm.index.JavaRoot> libraryRoots) {
    }
    
    private final java.util.Map<org.jetbrains.kotlin.analysis.api.projectStructure.KaModule, java.util.Set<org.jetbrains.kotlin.analysis.api.projectStructure.KaModule>> getDirectDependentsByKtModule() {
        return null;
    }
    
    private final java.util.Map<org.jetbrains.kotlin.analysis.api.projectStructure.KaModule, java.util.Set<org.jetbrains.kotlin.analysis.api.projectStructure.KaModule>> getRefinementDependentsByKtModule() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Set<org.jetbrains.kotlin.analysis.api.projectStructure.KaModule> getDirectDependents(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.projectStructure.KaModule module) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Set<org.jetbrains.kotlin.analysis.api.projectStructure.KaModule> getRefinementDependents(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.projectStructure.KaModule module) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Set<org.jetbrains.kotlin.analysis.api.projectStructure.KaModule> getTransitiveDependents(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.projectStructure.KaModule module) {
        return null;
    }
}