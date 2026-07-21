package dev.mutwakil.androidide.lsp.kotlin.compiler.services;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/JavaModuleAccessibilityChecker;", "Lorg/jetbrains/kotlin/analysis/api/platform/java/KotlinJavaModuleAccessibilityChecker;", "javaModuleResolver", "Lorg/jetbrains/kotlin/cli/jvm/modules/CliJavaModuleResolver;", "<init>", "(Lorg/jetbrains/kotlin/cli/jvm/modules/CliJavaModuleResolver;)V", "checkAccessibility", "Lorg/jetbrains/kotlin/analysis/api/platform/java/KotlinJavaModuleAccessibilityError;", "useSiteFile", "Lorg/jetbrains/kotlin/com/intellij/openapi/vfs/VirtualFile;", "referencedFile", "referencedPackage", "Lorg/jetbrains/kotlin/name/FqName;", "convertAccessError", "accessError", "Lorg/jetbrains/kotlin/resolve/jvm/modules/JavaModuleResolver$AccessError;", "kotlin_debug"})
public final class JavaModuleAccessibilityChecker implements org.jetbrains.kotlin.analysis.api.platform.java.KotlinJavaModuleAccessibilityChecker {
    @org.jetbrains.annotations.NotNull()
    private final org.jetbrains.kotlin.cli.jvm.modules.CliJavaModuleResolver javaModuleResolver = null;
    
    public JavaModuleAccessibilityChecker(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.cli.jvm.modules.CliJavaModuleResolver javaModuleResolver) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public org.jetbrains.kotlin.analysis.api.platform.java.KotlinJavaModuleAccessibilityError checkAccessibility(@org.jetbrains.annotations.Nullable()
    org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile useSiteFile, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile referencedFile, @org.jetbrains.annotations.Nullable()
    org.jetbrains.kotlin.name.FqName referencedPackage) {
        return null;
    }
    
    private final org.jetbrains.kotlin.analysis.api.platform.java.KotlinJavaModuleAccessibilityError convertAccessError(org.jetbrains.kotlin.resolve.jvm.modules.JavaModuleResolver.AccessError accessError) {
        return null;
    }
}