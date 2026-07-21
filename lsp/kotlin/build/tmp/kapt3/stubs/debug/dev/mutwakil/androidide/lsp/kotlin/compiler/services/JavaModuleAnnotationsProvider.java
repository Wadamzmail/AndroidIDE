package dev.mutwakil.androidide.lsp.kotlin.compiler.services;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/JavaModuleAnnotationsProvider;", "Lorg/jetbrains/kotlin/analysis/api/platform/java/KotlinJavaModuleJavaAnnotationsProvider;", "javaModuleResolver", "Lorg/jetbrains/kotlin/cli/jvm/modules/CliJavaModuleResolver;", "<init>", "(Lorg/jetbrains/kotlin/cli/jvm/modules/CliJavaModuleResolver;)V", "getAnnotationsForModuleOwnerOfClass", "", "Lorg/jetbrains/kotlin/load/java/structure/JavaAnnotation;", "classId", "Lorg/jetbrains/kotlin/name/ClassId;", "kotlin_debug"})
@kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaNonPublicApi.class})
public final class JavaModuleAnnotationsProvider implements org.jetbrains.kotlin.analysis.api.platform.java.KotlinJavaModuleJavaAnnotationsProvider {
    @org.jetbrains.annotations.NotNull()
    private final org.jetbrains.kotlin.cli.jvm.modules.CliJavaModuleResolver javaModuleResolver = null;
    
    public JavaModuleAnnotationsProvider(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.cli.jvm.modules.CliJavaModuleResolver javaModuleResolver) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.util.List<org.jetbrains.kotlin.load.java.structure.JavaAnnotation> getAnnotationsForModuleOwnerOfClass(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.ClassId classId) {
        return null;
    }
}