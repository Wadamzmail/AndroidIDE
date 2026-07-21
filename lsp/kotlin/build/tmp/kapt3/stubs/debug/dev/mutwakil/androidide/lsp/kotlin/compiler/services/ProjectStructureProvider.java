package dev.mutwakil.androidide.lsp.kotlin.compiler.services;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\b\u0000\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\fJ\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u000fJ4\u0010\u001d\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0006H\u0016J\u001a\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\'\u001a\u00020\r2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010(\u001a\u0004\u0018\u00010\r2\u0006\u0010)\u001a\u00020\u000fJ\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010+\u001a\u00020\rH\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010\b\u001a\u00020\tH\u0014J(\u0010.\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010+\u001a\u00020\r2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\r00H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a\u00a8\u00062"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/ProjectStructureProvider;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/KtLspService;", "Lorg/jetbrains/kotlin/analysis/api/platform/projectStructure/KotlinProjectStructureProviderBase;", "<init>", "()V", "modules", "", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/KtModule;", "project", "Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "inMemoryVfToModule", "Ljava/util/concurrent/ConcurrentHashMap;", "Lorg/jetbrains/kotlin/com/intellij/openapi/vfs/VirtualFile;", "Lorg/jetbrains/kotlin/analysis/api/projectStructure/KaModule;", "pathToInMemoryVf", "", "registerInMemoryFile", "", "sourcePath", "vf", "unregisterInMemoryFile", "hasInMemoryFile", "", "notUnderContentRootModuleWithoutPsiFile", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/NotUnderContentRootModule;", "getNotUnderContentRootModuleWithoutPsiFile", "()Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/NotUnderContentRootModule;", "notUnderContentRootModuleWithoutPsiFile$delegate", "Lkotlin/Lazy;", "setupWith", "Lorg/jetbrains/kotlin/com/intellij/mock/MockProject;", "index", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/KtSymbolIndex;", "libraryRoots", "Lorg/jetbrains/kotlin/cli/jvm/index/JavaRoot;", "getModule", "element", "Lorg/jetbrains/kotlin/com/intellij/psi/PsiElement;", "useSiteModule", "getModuleImpl", "findModuleForSourceId", "sourceId", "getImplementingModules", "module", "getNotUnderContentRootModule", "Lorg/jetbrains/kotlin/analysis/api/projectStructure/KaNotUnderContentRootModule;", "searchVirtualFileInModule", "visited", "", "Companion", "kotlin_debug"})
public final class ProjectStructureProvider extends org.jetbrains.kotlin.analysis.api.platform.projectStructure.KotlinProjectStructureProviderBase implements dev.mutwakil.androidide.lsp.kotlin.compiler.services.KtLspService {
    private java.util.List<? extends dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> modules;
    private org.jetbrains.kotlin.com.intellij.openapi.project.Project project;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.ConcurrentHashMap<org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile, org.jetbrains.kotlin.analysis.api.projectStructure.KaModule> inMemoryVfToModule = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile> pathToInMemoryVf = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy notUnderContentRootModuleWithoutPsiFile$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.kotlin.compiler.services.ProjectStructureProvider.Companion Companion = null;
    
    public ProjectStructureProvider() {
        super();
    }
    
    public final void registerInMemoryFile(@org.jetbrains.annotations.NotNull()
    java.lang.String sourcePath, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile vf) {
    }
    
    public final void unregisterInMemoryFile(@org.jetbrains.annotations.NotNull()
    java.lang.String sourcePath) {
    }
    
    public final boolean hasInMemoryFile(@org.jetbrains.annotations.NotNull()
    java.lang.String sourcePath) {
        return false;
    }
    
    private final dev.mutwakil.androidide.lsp.kotlin.compiler.modules.NotUnderContentRootModule getNotUnderContentRootModuleWithoutPsiFile() {
        return null;
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
    public org.jetbrains.kotlin.analysis.api.projectStructure.KaModule getModule(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.psi.PsiElement element, @org.jetbrains.annotations.Nullable()
    org.jetbrains.kotlin.analysis.api.projectStructure.KaModule useSiteModule) {
        return null;
    }
    
    private final org.jetbrains.kotlin.analysis.api.projectStructure.KaModule getModuleImpl(org.jetbrains.kotlin.com.intellij.psi.PsiElement element, org.jetbrains.kotlin.analysis.api.projectStructure.KaModule useSiteModule) {
        return null;
    }
    
    /**
     * Find the [KaModule] that owns the given [sourceId].
     *
     * - For library JARs, [sourceId] is the JAR path — matched against [KtModule.contentRoots] exactly.
     * - For source files, [sourceId] is the `.kt` file path — matched by checking whether the path
     *  falls under any source root in [KtModule.contentRoots].
     *
     * The search is recursive: if the top-level modules do not match, their transitive dependencies
     * are checked as well.
     *
     * @return The declaring [KaModule], or `null` if none is found.
     */
    @kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaExperimentalApi.class})
    @org.jetbrains.annotations.Nullable()
    public final org.jetbrains.kotlin.analysis.api.projectStructure.KaModule findModuleForSourceId(@org.jetbrains.annotations.NotNull()
    java.lang.String sourceId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<org.jetbrains.kotlin.analysis.api.projectStructure.KaModule> getImplementingModules(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.analysis.api.projectStructure.KaModule module) {
        return null;
    }
    
    @java.lang.Override()
    @kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaPlatformInterface.class})
    @org.jetbrains.annotations.NotNull()
    protected org.jetbrains.kotlin.analysis.api.projectStructure.KaNotUnderContentRootModule getNotUnderContentRootModule(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.project.Project project) {
        return null;
    }
    
    private final org.jetbrains.kotlin.analysis.api.projectStructure.KaModule searchVirtualFileInModule(org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile vf, org.jetbrains.kotlin.analysis.api.projectStructure.KaModule module, java.util.Set<org.jetbrains.kotlin.analysis.api.projectStructure.KaModule> visited) {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/ProjectStructureProvider$Companion;", "", "<init>", "()V", "getInstance", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/ProjectStructureProvider;", "project", "Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "kotlin_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final dev.mutwakil.androidide.lsp.kotlin.compiler.services.ProjectStructureProvider getInstance(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.com.intellij.openapi.project.Project project) {
            return null;
        }
    }
}