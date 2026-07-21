package dev.mutwakil.androidide.lsp.kotlin.compiler.index;

@kotlin.Metadata(mv = {2, 3, 0}, k = 2, xi = 48, d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0000\u001a6\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0080@\u00a2\u0006\u0002\u0010\u0010\u001a\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001a\u000e\u0010\u0018\u001a\u0004\u0018\u00010\u0015*\u00020\u0019H\u0002\u001a\u000e\u0010\u001a\u001a\u0004\u0018\u00010\u0015*\u00020\u0017H\u0002\u001a\f\u0010\u001b\u001a\u00020\u001c*\u00020\u001dH\u0002\u001a\u0014\u0010\u001e\u001a\u00020\u0015*\u00020\u00132\u0006\u0010\u001f\u001a\u00020 H\u0002\u001a\u0014\u0010!\u001a\u00020\u0015*\u00020\u00132\u0006\u0010\u001f\u001a\u00020 H\u0002\u001a\u001e\u0010\"\u001a\u0004\u0018\u00010\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020#H\u0002\u001a\u001e\u0010$\u001a\u0004\u0018\u00010\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0019H\u0002\u001a\u001e\u0010%\u001a\u0004\u0018\u00010\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020&H\u0002\u001a\u001e\u0010\'\u001a\u0004\u0018\u00010\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020(H\u0002\u001a\u001e\u0010)\u001a\u0004\u0018\u00010\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020*H\u0002\u00a8\u0006+"}, d2 = {"toMetadata", "Lorg/appdevforall/codeonthego/indexing/jvm/KtFileMetadata;", "Lorg/jetbrains/kotlin/psi/KtFile;", "project", "Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "isIndexed", "", "indexSourceFile", "", "ktFile", "fileIndex", "Lorg/appdevforall/codeonthego/indexing/jvm/KtFileMetadataIndex;", "symbolsIndex", "Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbolIndex;", "cancelChecker", "Ldev/mutwakil/androidide/progress/ICancelChecker;", "(Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;Lorg/jetbrains/kotlin/psi/KtFile;Lorg/appdevforall/codeonthego/indexing/jvm/KtFileMetadataIndex;Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbolIndex;Ldev/mutwakil/androidide/progress/ICancelChecker;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "analyzeDeclaration", "Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbol;", "Lorg/jetbrains/kotlin/analysis/api/KaSession;", "filePath", "", "dcl", "Lorg/jetbrains/kotlin/psi/KtDeclaration;", "internalName", "Lorg/jetbrains/kotlin/psi/KtClassOrObject;", "containingClassInternalName", "jvmVisibility", "Lorg/appdevforall/codeonthego/indexing/jvm/JvmVisibility;", "Lorg/jetbrains/kotlin/psi/KtModifierListOwner;", "kaTypeInternalName", "type", "Lorg/jetbrains/kotlin/analysis/api/types/KaType;", "kaTypeDisplayName", "analyzeFunction", "Lorg/jetbrains/kotlin/psi/KtNamedFunction;", "analyzeClassOrObject", "analyzeProperty", "Lorg/jetbrains/kotlin/psi/KtProperty;", "analyzeParameter", "Lorg/jetbrains/kotlin/psi/KtParameter;", "analyzeTypeAlias", "Lorg/jetbrains/kotlin/psi/KtTypeAlias;", "kotlin_debug"})
public final class SourceFileIndexerKt {
    
    @org.jetbrains.annotations.NotNull()
    public static final org.appdevforall.codeonthego.indexing.jvm.KtFileMetadata toMetadata(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtFile $this$toMetadata, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.project.Project project, boolean isIndexed) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Object indexSourceFile(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.project.Project project, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtFile ktFile, @org.jetbrains.annotations.NotNull()
    org.appdevforall.codeonthego.indexing.jvm.KtFileMetadataIndex fileIndex, @org.jetbrains.annotations.NotNull()
    org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex symbolsIndex, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.progress.ICancelChecker cancelChecker, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaImplementationDetail.class})
    private static final org.appdevforall.codeonthego.indexing.jvm.JvmSymbol analyzeDeclaration(org.jetbrains.kotlin.analysis.api.KaSession $this$analyzeDeclaration, java.lang.String filePath, org.jetbrains.kotlin.psi.KtDeclaration dcl) {
        return null;
    }
    
    /**
     * Slash-package / dollar-nesting internal name for this class.
     * Returns null for anonymous/local classes that have no stable FQ name.
     */
    private static final java.lang.String internalName(org.jetbrains.kotlin.psi.KtClassOrObject $this$internalName) {
        return null;
    }
    
    /**
     * Walk the PSI parent chain to find the internal name of the nearest
     * enclosing class or object.  Returns null for top-level declarations.
     */
    private static final java.lang.String containingClassInternalName(org.jetbrains.kotlin.psi.KtDeclaration $this$containingClassInternalName) {
        return null;
    }
    
    private static final org.appdevforall.codeonthego.indexing.jvm.JvmVisibility jvmVisibility(org.jetbrains.kotlin.psi.KtModifierListOwner $this$jvmVisibility) {
        return null;
    }
    
    /**
     * Slash-package / dollar-nesting internal name for a resolved [KaType].
     * Mirrors [KotlinMetadataScanner]'s `kmTypeToName`.
     * Returns an empty string for unresolvable types (type parameters, errors).
     */
    private static final java.lang.String kaTypeInternalName(org.jetbrains.kotlin.analysis.api.KaSession $this$kaTypeInternalName, org.jetbrains.kotlin.analysis.api.types.KaType type) {
        return null;
    }
    
    /**
     * Short display name (last segment after '/' and '$'), with generic arguments
     * and a trailing '?' for nullable types.
     * Mirrors [KotlinMetadataScanner]'s `kmTypeToDisplayName`.
     */
    private static final java.lang.String kaTypeDisplayName(org.jetbrains.kotlin.analysis.api.KaSession $this$kaTypeDisplayName, org.jetbrains.kotlin.analysis.api.types.KaType type) {
        return null;
    }
    
    private static final org.appdevforall.codeonthego.indexing.jvm.JvmSymbol analyzeFunction(org.jetbrains.kotlin.analysis.api.KaSession $this$analyzeFunction, java.lang.String filePath, org.jetbrains.kotlin.psi.KtNamedFunction dcl) {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaExperimentalApi.class})
    private static final org.appdevforall.codeonthego.indexing.jvm.JvmSymbol analyzeClassOrObject(org.jetbrains.kotlin.analysis.api.KaSession $this$analyzeClassOrObject, java.lang.String filePath, org.jetbrains.kotlin.psi.KtClassOrObject dcl) {
        return null;
    }
    
    private static final org.appdevforall.codeonthego.indexing.jvm.JvmSymbol analyzeProperty(org.jetbrains.kotlin.analysis.api.KaSession $this$analyzeProperty, java.lang.String filePath, org.jetbrains.kotlin.psi.KtProperty dcl) {
        return null;
    }
    
    /**
     * Constructor `val`/`var` parameters are indexed as properties so that
     * they appear in completion and navigation just like explicitly declared
     * properties.  Plain constructor or function parameters are skipped.
     */
    private static final org.appdevforall.codeonthego.indexing.jvm.JvmSymbol analyzeParameter(org.jetbrains.kotlin.analysis.api.KaSession $this$analyzeParameter, java.lang.String filePath, org.jetbrains.kotlin.psi.KtParameter dcl) {
        return null;
    }
    
    private static final org.appdevforall.codeonthego.indexing.jvm.JvmSymbol analyzeTypeAlias(org.jetbrains.kotlin.analysis.api.KaSession $this$analyzeTypeAlias, java.lang.String filePath, org.jetbrains.kotlin.psi.KtTypeAlias dcl) {
        return null;
    }
}