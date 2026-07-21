package dev.mutwakil.androidide.lsp.kotlin.compiler.index;

@kotlin.Metadata(mv = {2, 3, 0}, k = 2, xi = 48, d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u0011*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e*\u00020\n2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0000\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0004\u00a8\u0006\u0017"}, d2 = {"KT_SOURCE_FILE_INDEX_KEY", "Lorg/appdevforall/codeonthego/indexing/service/IndexKey;", "Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbolIndex;", "getKT_SOURCE_FILE_INDEX_KEY", "()Lorg/appdevforall/codeonthego/indexing/service/IndexKey;", "KT_SOURCE_FILE_META_INDEX_KEY", "Lorg/appdevforall/codeonthego/indexing/jvm/KtFileMetadataIndex;", "getKT_SOURCE_FILE_META_INDEX_KEY", "packageExistsInSource", "", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/index/KtSymbolIndex;", "packageFqn", "", "filesForPackage", "Lkotlin/sequences/Sequence;", "Lorg/appdevforall/codeonthego/indexing/jvm/KtFileMetadata;", "subpackageNames", "", "findSymbolBySimpleName", "Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbol;", "name", "limit", "", "kotlin_debug"})
public final class KtSymbolIndexKt {
    @org.jetbrains.annotations.NotNull()
    private static final org.appdevforall.codeonthego.indexing.service.IndexKey<org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex> KT_SOURCE_FILE_INDEX_KEY = null;
    @org.jetbrains.annotations.NotNull()
    private static final org.appdevforall.codeonthego.indexing.service.IndexKey<org.appdevforall.codeonthego.indexing.jvm.KtFileMetadataIndex> KT_SOURCE_FILE_META_INDEX_KEY = null;
    
    @org.jetbrains.annotations.NotNull()
    public static final org.appdevforall.codeonthego.indexing.service.IndexKey<org.appdevforall.codeonthego.indexing.jvm.JvmSymbolIndex> getKT_SOURCE_FILE_INDEX_KEY() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final org.appdevforall.codeonthego.indexing.service.IndexKey<org.appdevforall.codeonthego.indexing.jvm.KtFileMetadataIndex> getKT_SOURCE_FILE_META_INDEX_KEY() {
        return null;
    }
    
    public static final boolean packageExistsInSource(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex $this$packageExistsInSource, @org.jetbrains.annotations.NotNull()
    java.lang.String packageFqn) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final kotlin.sequences.Sequence<org.appdevforall.codeonthego.indexing.jvm.KtFileMetadata> filesForPackage(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex $this$filesForPackage, @org.jetbrains.annotations.NotNull()
    java.lang.String packageFqn) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.Set<java.lang.String> subpackageNames(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex $this$subpackageNames, @org.jetbrains.annotations.NotNull()
    java.lang.String packageFqn) {
        return null;
    }
    
    /**
     * Returns source- and library-index symbols whose simple name equals [name].
     *
     * [limit] `<= 0` means unbounded, honoring the same convention as
     * [org.appdevforall.codeonthego.indexing.api.ReadableIndex.query] ("If IndexQuery.limit is 0, all
     * matches are emitted"). A plain `take(limit)` would turn the common `limit = 0` call into
     * `take(0)`, silently yielding no results.
     */
    @org.jetbrains.annotations.NotNull()
    public static final kotlin.sequences.Sequence<org.appdevforall.codeonthego.indexing.jvm.JvmSymbol> findSymbolBySimpleName(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.index.KtSymbolIndex $this$findSymbolBySimpleName, @org.jetbrains.annotations.NotNull()
    java.lang.String name, int limit) {
        return null;
    }
}