package dev.mutwakil.androidide.lsp.kotlin.compiler.services;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00142\u0006\u0010\u0019\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001a"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/AnnotationsResolver;", "Lorg/jetbrains/kotlin/analysis/api/platform/declarations/KotlinAnnotationsResolver;", "project", "Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "scope", "Lorg/jetbrains/kotlin/com/intellij/psi/search/GlobalSearchScope;", "index", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/KtSymbolIndex;", "<init>", "(Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;Lorg/jetbrains/kotlin/com/intellij/psi/search/GlobalSearchScope;Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/KtSymbolIndex;)V", "declarationProvider", "Lorg/jetbrains/kotlin/analysis/api/platform/declarations/KotlinDeclarationProvider;", "getDeclarationProvider", "()Lorg/jetbrains/kotlin/analysis/api/platform/declarations/KotlinDeclarationProvider;", "declarationProvider$delegate", "Lkotlin/Lazy;", "allDeclarations", "", "Lorg/jetbrains/kotlin/psi/KtDeclaration;", "declarationsByAnnotation", "", "Lorg/jetbrains/kotlin/psi/KtAnnotated;", "annotationClassId", "Lorg/jetbrains/kotlin/name/ClassId;", "annotationsOnDeclaration", "declaration", "kotlin_debug"})
@kotlin.Suppress(names = {"UnstableApiUsage"})
public final class AnnotationsResolver implements org.jetbrains.kotlin.analysis.api.platform.declarations.KotlinAnnotationsResolver {
    @org.jetbrains.annotations.NotNull()
    private final org.jetbrains.kotlin.com.intellij.psi.search.GlobalSearchScope scope = null;
    @org.jetbrains.annotations.NotNull()
    private final dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex index = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy declarationProvider$delegate = null;
    
    public AnnotationsResolver(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.project.Project project, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.psi.search.GlobalSearchScope scope, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex index) {
        super();
    }
    
    private final org.jetbrains.kotlin.analysis.api.platform.declarations.KotlinDeclarationProvider getDeclarationProvider() {
        return null;
    }
    
    private final java.util.List<org.jetbrains.kotlin.psi.KtDeclaration> allDeclarations() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Set<org.jetbrains.kotlin.psi.KtAnnotated> declarationsByAnnotation(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.ClassId annotationClassId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Set<org.jetbrains.kotlin.name.ClassId> annotationsOnDeclaration(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtAnnotated declaration) {
        return null;
    }
}