package dev.mutwakil.androidide.lsp.kotlin.compiler.registrar;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u001e\u0010\t\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\nj\u0002`\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/LspAnalysisApiServiceRegistrar;", "Lorg/jetbrains/kotlin/analysis/api/standalone/base/projectStructure/AnalysisApiSimpleServiceRegistrar;", "provider", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/AnalysisApiServiceProvider;", "<init>", "(Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/AnalysisApiServiceProvider;)V", "servAll", "", "Lorg/jetbrains/kotlin/com/intellij/mock/MockComponentManager;", "services", "", "Lkotlin/reflect/KClass;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceRegistration;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceMap;", "registerApplicationServices", "application", "Lorg/jetbrains/kotlin/com/intellij/mock/MockApplication;", "registerProjectServices", "project", "Lorg/jetbrains/kotlin/com/intellij/mock/MockProject;", "registerProjectModelServices", "disposable", "Lorg/jetbrains/kotlin/com/intellij/openapi/Disposable;", "kotlin_debug"})
@kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaImplementationDetail.class})
public final class LspAnalysisApiServiceRegistrar extends org.jetbrains.kotlin.analysis.api.standalone.base.projectStructure.AnalysisApiSimpleServiceRegistrar {
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.AnalysisApiServiceProvider provider = null;
    
    public LspAnalysisApiServiceRegistrar(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.AnalysisApiServiceProvider provider) {
        super();
    }
    
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    private final void servAll(org.jetbrains.kotlin.com.intellij.mock.MockComponentManager $this$servAll, java.util.Map<kotlin.reflect.KClass<?>, ? extends dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<?>> services) {
    }
    
    @java.lang.Override()
    public void registerApplicationServices(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.mock.MockApplication application) {
    }
    
    @java.lang.Override()
    public void registerProjectServices(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.mock.MockProject project) {
    }
    
    @java.lang.Override()
    public void registerProjectModelServices(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.mock.MockProject project, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.Disposable disposable) {
    }
}