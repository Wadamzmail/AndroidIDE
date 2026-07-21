package dev.mutwakil.androidide.lsp.kotlin.completion;

/**
 * Snippet scopes for Kotlin source files.
 *
 * @author Akash Yadav
 */
@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/completion/KotlinSnippetScope;", "Ldev/mutwakil/androidide/lsp/snippets/ISnippetScope;", "", "filename", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getFilename", "()Ljava/lang/String;", "TOP_LEVEL", "MEMBER", "LOCAL", "GLOBAL", "kotlin_debug"})
public enum KotlinSnippetScope implements dev.mutwakil.androidide.lsp.snippets.ISnippetScope {
    /*public static final*/ TOP_LEVEL /* = new TOP_LEVEL(null) */,
    /*public static final*/ MEMBER /* = new MEMBER(null) */,
    /*public static final*/ LOCAL /* = new LOCAL(null) */,
    /*public static final*/ GLOBAL /* = new GLOBAL(null) */;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String filename = null;
    
    KotlinSnippetScope(java.lang.String filename) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getFilename() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<dev.mutwakil.androidide.lsp.kotlin.completion.KotlinSnippetScope> getEntries() {
        return null;
    }
}