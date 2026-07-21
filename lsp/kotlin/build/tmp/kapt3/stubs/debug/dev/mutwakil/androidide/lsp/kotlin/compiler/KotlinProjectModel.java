package dev.mutwakil.androidide.lsp.kotlin.compiler;

/**
 * Holds the project structure derived from a [Workspace].
 *
 * This is the single source of truth for module layout, dependencies,
 * and source roots. It knows nothing about analysis sessions — it just
 * describes *what* the project looks like.
 *
 * When the project structure changes (re-sync) or source files change
 * (build complete), it notifies registered listeners so they can
 * refresh their sessions.
 */
@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0002#$B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\rJ\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\rJ\u0016\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020\u001bJ\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011\u00a8\u0006%"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/KotlinProjectModel;", "", "<init>", "()V", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "workspace", "Ldev/mutwakil/androidide/projects/IWorkspace;", "platform", "Lorg/jetbrains/kotlin/platform/TargetPlatform;", "listeners", "", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/KotlinProjectModel$ProjectModelListener;", "libraryIndex", "Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbolIndex;", "getLibraryIndex", "()Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbolIndex;", "sourceIndex", "getSourceIndex", "fileIndex", "Lorg/appdevforall/codeonthego/indexing/jvm/KtFileMetadataIndex;", "getFileIndex", "()Lorg/appdevforall/codeonthego/indexing/jvm/KtFileMetadataIndex;", "generatedIndex", "getGeneratedIndex", "addListener", "", "listener", "removeListener", "update", "onSourcesChanged", "notifyListeners", "changeKind", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/KotlinProjectModel$ChangeKind;", "ChangeKind", "ProjectModelListener", "kotlin_debug"})
public final class KotlinProjectModel {
    private final org.slf4j.Logger logger = null;
    @org.jetbrains.annotations.Nullable()
    private dev.mutwakil.androidide.projects.IWorkspace workspace;
    @org.jetbrains.annotations.NotNull()
    private org.jetbrains.kotlin.platform.TargetPlatform platform;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<dev.mutwakil.androidide.lsp.kotlin.compiler.KotlinProjectModel.ProjectModelListener> listeners = null;
    
    public KotlinProjectModel() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex getLibraryIndex() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex getSourceIndex() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.appdevforall.codeonthego.indexing.jvm.KtFileMetadataIndex getFileIndex() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex getGeneratedIndex() {
        return null;
    }
    
    public final void addListener(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.KotlinProjectModel.ProjectModelListener listener) {
    }
    
    public final void removeListener(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.KotlinProjectModel.ProjectModelListener listener) {
    }
    
    /**
     * Called when the project is synced (setupWithProject).
     * This replaces the entire project structure.
     */
    public final void update(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.projects.IWorkspace workspace, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.platform.TargetPlatform platform) {
    }
    
    /**
     * Called when a build completes and source files may have changed
     * (generated sources added/removed), but the module structure is the same.
     */
    public final void onSourcesChanged() {
    }
    
    private final void notifyListeners(dev.mutwakil.androidide.lsp.kotlin.compiler.KotlinProjectModel.ChangeKind changeKind) {
    }
    
    /**
     * The kind of change that occurred.
     */
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/KotlinProjectModel$ChangeKind;", "", "<init>", "(Ljava/lang/String;I)V", "STRUCTURE", "SOURCES", "kotlin_debug"})
    public static enum ChangeKind {
        /*public static final*/ STRUCTURE /* = new STRUCTURE() */,
        /*public static final*/ SOURCES /* = new SOURCES() */;
        
        ChangeKind() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<dev.mutwakil.androidide.lsp.kotlin.compiler.KotlinProjectModel.ChangeKind> getEntries() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b\u00c0\u0006\u0003"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/KotlinProjectModel$ProjectModelListener;", "", "onProjectModelChanged", "", "model", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/KotlinProjectModel;", "changeKind", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/KotlinProjectModel$ChangeKind;", "kotlin_debug"})
    public static abstract interface ProjectModelListener {
        
        public abstract void onProjectModelChanged(@org.jetbrains.annotations.NotNull()
        dev.mutwakil.androidide.lsp.kotlin.compiler.KotlinProjectModel model, @org.jetbrains.annotations.NotNull()
        dev.mutwakil.androidide.lsp.kotlin.compiler.KotlinProjectModel.ChangeKind changeKind);
    }
}