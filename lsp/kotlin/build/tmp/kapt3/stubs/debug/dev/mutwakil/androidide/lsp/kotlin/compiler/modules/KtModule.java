package dev.mutwakil.androidide.lsp.kotlin.compiler.modules;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e\u00a8\u0006\u0018\u00c0\u0006\u0003"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/modules/KtModule;", "Lorg/jetbrains/kotlin/analysis/api/projectStructure/KaModule;", "id", "", "getId", "()Ljava/lang/String;", "contentRoots", "", "Ljava/nio/file/Path;", "getContentRoots", "()Ljava/util/Set;", "directRegularDependencies", "", "getDirectRegularDependencies", "()Ljava/util/List;", "directDependsOnDependencies", "getDirectDependsOnDependencies", "directFriendDependencies", "getDirectFriendDependencies", "computeFiles", "Lkotlin/sequences/Sequence;", "Lorg/jetbrains/kotlin/com/intellij/openapi/vfs/VirtualFile;", "extended", "", "kotlin_debug"})
@kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaPlatformInterface.class})
public abstract interface KtModule extends org.jetbrains.kotlin.analysis.api.projectStructure.KaModule {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getId();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.Set<java.nio.file.Path> getContentRoots();
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> getDirectRegularDependencies();
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> getDirectDependsOnDependencies();
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule> getDirectFriendDependencies();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlin.sequences.Sequence<org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile> computeFiles(boolean extended);
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Deprecated()
        public static java.lang.String getStableModuleName(@org.jetbrains.annotations.NotNull()
        dev.mutwakil.androidide.lsp.kotlin.compiler.modules.KtModule $this) {
            return null;
        }
    }
}