package dev.mutwakil.androidide.lsp.kotlin.compiler.services;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH$J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0016\u0010\'\u001a\b\u0012\u0004\u0012\u00020(0\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006)"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/services/AbstractDeclarationProvider;", "Lorg/jetbrains/kotlin/analysis/api/platform/declarations/KotlinDeclarationProvider;", "project", "Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "<init>", "(Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;)V", "getProject", "()Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "ktFilesForPackage", "Lkotlin/sequences/Sequence;", "Lorg/jetbrains/kotlin/psi/KtFile;", "fqName", "Lorg/jetbrains/kotlin/name/FqName;", "findFilesForFacade", "", "facadeFqName", "findInternalFilesForFacade", "findFilesForFacadeByPackage", "packageFqName", "findFilesForScript", "Lorg/jetbrains/kotlin/psi/KtScript;", "scriptFqName", "getAllClassesByClassId", "Lorg/jetbrains/kotlin/psi/KtClassOrObject;", "classId", "Lorg/jetbrains/kotlin/name/ClassId;", "getAllTypeAliasesByClassId", "Lorg/jetbrains/kotlin/psi/KtTypeAlias;", "getClassLikeDeclarationByClassId", "Lorg/jetbrains/kotlin/psi/KtClassLikeDeclaration;", "getTopLevelCallableFiles", "callableId", "Lorg/jetbrains/kotlin/name/CallableId;", "getTopLevelFunctions", "Lorg/jetbrains/kotlin/psi/KtNamedFunction;", "getTopLevelKotlinClassLikeDeclarationNamesInPackage", "", "Lorg/jetbrains/kotlin/name/Name;", "getTopLevelCallableNamesInPackage", "getTopLevelProperties", "Lorg/jetbrains/kotlin/psi/KtProperty;", "kotlin_debug"})
public abstract class AbstractDeclarationProvider implements org.jetbrains.kotlin.analysis.api.platform.declarations.KotlinDeclarationProvider {
    @org.jetbrains.annotations.NotNull()
    private final org.jetbrains.kotlin.com.intellij.openapi.project.Project project = null;
    
    public AbstractDeclarationProvider(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.project.Project project) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final org.jetbrains.kotlin.com.intellij.openapi.project.Project getProject() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected abstract kotlin.sequences.Sequence<org.jetbrains.kotlin.psi.KtFile> ktFilesForPackage(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.FqName fqName);
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Collection<org.jetbrains.kotlin.psi.KtFile> findFilesForFacade(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.FqName facadeFqName) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Collection<org.jetbrains.kotlin.psi.KtFile> findInternalFilesForFacade(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.FqName facadeFqName) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Collection<org.jetbrains.kotlin.psi.KtFile> findFilesForFacadeByPackage(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.FqName packageFqName) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Collection<org.jetbrains.kotlin.psi.KtScript> findFilesForScript(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.FqName scriptFqName) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Collection<org.jetbrains.kotlin.psi.KtClassOrObject> getAllClassesByClassId(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.ClassId classId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Collection<org.jetbrains.kotlin.psi.KtTypeAlias> getAllTypeAliasesByClassId(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.ClassId classId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public org.jetbrains.kotlin.psi.KtClassLikeDeclaration getClassLikeDeclarationByClassId(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.ClassId classId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Collection<org.jetbrains.kotlin.psi.KtFile> getTopLevelCallableFiles(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.CallableId callableId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Collection<org.jetbrains.kotlin.psi.KtNamedFunction> getTopLevelFunctions(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.CallableId callableId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Set<org.jetbrains.kotlin.name.Name> getTopLevelKotlinClassLikeDeclarationNamesInPackage(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.FqName packageFqName) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Set<org.jetbrains.kotlin.name.Name> getTopLevelCallableNamesInPackage(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.FqName packageFqName) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Collection<org.jetbrains.kotlin.psi.KtProperty> getTopLevelProperties(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.CallableId callableId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.util.Set<java.lang.String> computePackageNames() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.util.Set<java.lang.String> computePackageNamesWithTopLevelCallables() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.util.Set<java.lang.String> computePackageNamesWithTopLevelClassifiers() {
        return null;
    }
}