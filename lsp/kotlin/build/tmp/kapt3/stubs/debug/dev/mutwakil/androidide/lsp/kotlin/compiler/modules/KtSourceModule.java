package dev.mutwakil.androidide.lsp.kotlin.compiler.modules;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0002/0B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R)\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\u00138VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\'\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u0011R\u001a\u0010#\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\f\u0012\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0011R\u0014\u0010\'\u001a\u00020(8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010.\u00a8\u00061"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/KtSourceModule;", "Lorg/jetbrains/kotlin/analysis/api/projectStructure/KaSourceModule;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/AbstractSourceModule;", "project", "Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "module", "Ldev/mutwakil/androidide/projects/ModuleProject;", "directRegularDependencies", "", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/KtModule;", "<init>", "(Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;Ldev/mutwakil/androidide/projects/ModuleProject;Ljava/util/List;)V", "getModule", "()Ldev/mutwakil/androidide/projects/ModuleProject;", "id", "", "getId", "()Ljava/lang/String;", "contentRoots", "", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "getContentRoots", "()Ljava/util/Set;", "contentRoots$delegate", "Lkotlin/Lazy;", "versions", "Lkotlin/Pair;", "Lorg/jetbrains/kotlin/config/LanguageVersion;", "Lorg/jetbrains/kotlin/config/JvmTarget;", "getVersions", "()Lkotlin/Pair;", "versions$delegate", "name", "getName", "moduleDescription", "getModuleDescription$annotations", "()V", "getModuleDescription", "languageVersionSettings", "Lorg/jetbrains/kotlin/config/LanguageVersionSettings;", "getLanguageVersionSettings", "()Lorg/jetbrains/kotlin/config/LanguageVersionSettings;", "targetPlatform", "Lorg/jetbrains/kotlin/platform/TargetPlatform;", "getTargetPlatform", "()Lorg/jetbrains/kotlin/platform/TargetPlatform;", "Companion", "Builder", "kotlin_debug"})
@kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaPlatformInterface.class})
public final class KtSourceModule extends dev.mutwakil.androidide.lsp.kotlin.compiler.modules.AbstractSourceModule implements org.jetbrains.kotlin.analysis.api.projectStructure.KaSourceModule {
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.projects.ModuleProject module = null;
    private static final org.slf4j.Logger logger = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy contentRoots$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy versions$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtSourceModule.Companion Companion = null;
    
    public KtSourceModule(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.project.Project project, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.projects.ModuleProject module, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> directRegularDependencies) {
        super(null, null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dev.mutwakil.androidide.projects.ModuleProject getModule() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getId() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Set<java.nio.file.Path> getContentRoots() {
        return null;
    }
    
    private final kotlin.Pair<org.jetbrains.kotlin.config.LanguageVersion, org.jetbrains.kotlin.config.JvmTarget> getVersions() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getName() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getModuleDescription() {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaExperimentalApi.class})
    @java.lang.Deprecated()
    public static void getModuleDescription$annotations() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.kotlin.config.LanguageVersionSettings getLanguageVersionSettings() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.kotlin.platform.TargetPlatform getTargetPlatform() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<org.jetbrains.kotlin.com.intellij.psi.PsiFileSystemItem> getPsiRoots() {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/KtSourceModule$Builder;", "", "project", "Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "<init>", "(Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;)V", "module", "Ldev/mutwakil/androidide/projects/ModuleProject;", "getModule", "()Ldev/mutwakil/androidide/projects/ModuleProject;", "setModule", "(Ldev/mutwakil/androidide/projects/ModuleProject;)V", "dependencies", "", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/KtModule;", "addDependency", "", "dep", "build", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/KtSourceModule;", "kotlin_debug"})
    public static final class Builder {
        @org.jetbrains.annotations.NotNull()
        private final org.jetbrains.kotlin.com.intellij.openapi.project.Project project = null;
        public dev.mutwakil.androidide.projects.ModuleProject module;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> dependencies = null;
        
        public Builder(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.com.intellij.openapi.project.Project project) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final dev.mutwakil.androidide.projects.ModuleProject getModule() {
            return null;
        }
        
        public final void setModule(@org.jetbrains.annotations.NotNull()
        dev.mutwakil.androidide.projects.ModuleProject p0) {
        }
        
        public final void addDependency(@org.jetbrains.annotations.NotNull()
        dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule dep) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtSourceModule build() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/KtSourceModule$Companion;", "", "<init>", "()V", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "kotlin_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}