package dev.mutwakil.androidide.lsp.kotlin.completion;

@kotlin.Metadata(mv = {2, 3, 0}, k = 2, xi = 48, d1 = {"\u0000\u00be\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0002\u001a!\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0000R\u00020\tj\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0002\u0010\r\u001a!\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0000R\u00020\tj\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0002\u0010\r\u001a+\u0010\u000f\u001a\u00020\u0006*\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002R\u00020\u0010j\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0016\u001a3\u0010\u0017\u001a\u00020\u0006*\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002R\u00020\u0010j\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u001a\u001a3\u0010\u001b\u001a\u00020\u0006*\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002R\u00020\u0010j\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u001a\u001a7\u0010\u001c\u001a\u00020\u0006*\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002R\u00020\tR\u00020\u0010j\u0006\u0010\n\u001a\u00020\tj\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u001d\u001a7\u0010\u001e\u001a\u00020\u0006*\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002R\u00020\tR\u00020\u0010j\u0006\u0010\n\u001a\u00020\tj\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u001d\u001a\'\u0010\u001f\u001a\u0004\u0018\u00010\u0015*\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0002R\u00020\u0010j\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\"\u001a\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0001H\u0002\u001a+\u0010&\u001a\u00020\u0006*\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002R\u00020\u0010j\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0016\u001a+\u0010\'\u001a\u00020\u0006*\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002R\u00020\u0010j\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0016\u001a\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002\u001a3\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00150-*\u00020\u00122\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0-H\u0003R\u00020\u0010j\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b0\u00101\u001a3\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00150-*\u00020\u00122\f\u00102\u001a\b\u0012\u0004\u0012\u0002030-H\u0003R\u00020\u0010j\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b4\u00101\u001a\'\u00105\u001a\u0004\u0018\u00010\u0015*\u00020\u00122\u0006\u0010 \u001a\u00020/H\u0002R\u00020\u0010j\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0002\u00106\u001a-\u00107\u001a\u00020\u0006*\u00020\u00152\u0006\u00108\u001a\u00020\u00012\u0006\u00109\u001a\u00020:H\u0002R\u00020\u0010j\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0002\u0010;\u001a\'\u0010<\u001a\u0004\u0018\u00010\u0015*\u00020\u00122\u0006\u0010 \u001a\u000203H\u0002R\u00020\u0010j\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0002\u0010=\u001a9\u0010>\u001a\u00020\u0006*\u00020\u00152\u0006\u0010?\u001a\u00020\u00012\b\b\u0002\u0010@\u001a\u00020:2\b\b\u0002\u0010A\u001a\u00020\u0001H\u0002R\u00020\u0010j\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0002\u0010B\u001a\'\u0010C\u001a\u0004\u0018\u00010\u0015*\u00020\u00122\u0006\u0010 \u001a\u00020DH\u0002R\u00020\u0010j\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0002\u0010E\u001a-\u0010F\u001a\u00020\u0015*\u00020\u00122\u0006\u00108\u001a\u00020\u00012\u0006\u0010G\u001a\u00020HH\u0002R\u00020\u0010j\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0002\u0010I\u001a\u0014\u0010J\u001a\u00020H*\u00020\u00122\u0006\u0010 \u001a\u00020DH\u0002\u001a\u0014\u0010J\u001a\u00020H*\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0002\u001a\u0010\u0010K\u001a\u00020\u00012\u0006\u0010L\u001a\u00020\u0001H\u0002\u001a,\u0010M\u001a\u00020N2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020N0P2\u0006\u00108\u001a\u00020\u00012\u0006\u0010Q\u001a\u00020\u0001H\u0000\u001a!\u0010R\u001a\u00020N2\u0006\u00108\u001a\u00020\u0001H\u0002R\u00020\u0010j\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0002\u0010S\u001a!\u0010T\u001a\u00020:2\u0006\u00108\u001a\u00020UH\u0002R\u00020\u0010j\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0002\u0010V\u001a\u0010\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZH\u0002\u001a\u0018\u0010[\u001a\u00020:2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010\\\u001a\u00020]H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006^"}, d2 = {"KT_COMPLETION_PLACEHOLDER", "", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "abortIfCancelled", "", "codeComplete", "Ldev/mutwakil/androidide/lsp/models/CompletionResult;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationEnvironment;", "env", "params", "Ldev/mutwakil/androidide/lsp/models/CompletionParams;", "(Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationEnvironment;Ldev/mutwakil/androidide/lsp/models/CompletionParams;)Ldev/mutwakil/androidide/lsp/models/CompletionResult;", "doComplete", "collectMemberCompletions", "Ldev/mutwakil/androidide/lsp/kotlin/utils/AnalysisContext;", "ctx", "Lorg/jetbrains/kotlin/analysis/api/KaSession;", "to", "", "Ldev/mutwakil/androidide/lsp/models/CompletionItem;", "(Ldev/mutwakil/androidide/lsp/kotlin/utils/AnalysisContext;Lorg/jetbrains/kotlin/analysis/api/KaSession;Ljava/util/List;)V", "collectMembersFromType", "receiverType", "Lorg/jetbrains/kotlin/analysis/api/types/KaType;", "(Ldev/mutwakil/androidide/lsp/kotlin/utils/AnalysisContext;Lorg/jetbrains/kotlin/analysis/api/KaSession;Lorg/jetbrains/kotlin/analysis/api/types/KaType;Ljava/util/List;)V", "collectExtensionFunctions", "collectScopeCompletions", "(Ldev/mutwakil/androidide/lsp/kotlin/compiler/CompilationEnvironment;Ldev/mutwakil/androidide/lsp/kotlin/utils/AnalysisContext;Lorg/jetbrains/kotlin/analysis/api/KaSession;Ljava/util/List;)V", "collectUnimportedSymbols", "buildUnimportedSymbolItem", "symbol", "Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbol;", "(Ldev/mutwakil/androidide/lsp/kotlin/utils/AnalysisContext;Lorg/jetbrains/kotlin/analysis/api/KaSession;Lorg/appdevforall/codeonthego/indexing/jvm/JvmSymbol;)Ldev/mutwakil/androidide/lsp/models/CompletionItem;", "internalNameToClassId", "Lorg/jetbrains/kotlin/name/ClassId;", "internalName", "collectKeywordCompletions", "collectSnippetCompletions", "computeIndentLevelAt", "", "ktElement", "Lorg/jetbrains/kotlin/psi/KtElement;", "toCompletionItems", "Lkotlin/sequences/Sequence;", "callables", "Lorg/jetbrains/kotlin/analysis/api/symbols/KaCallableSymbol;", "callablesToCompletionItems", "(Ldev/mutwakil/androidide/lsp/kotlin/utils/AnalysisContext;Lorg/jetbrains/kotlin/analysis/api/KaSession;Lkotlin/sequences/Sequence;)Lkotlin/sequences/Sequence;", "classifiers", "Lorg/jetbrains/kotlin/analysis/api/symbols/KaClassifierSymbol;", "classifiersToCompletionItems", "callableSymbolToCompletionItem", "(Ldev/mutwakil/androidide/lsp/kotlin/utils/AnalysisContext;Lorg/jetbrains/kotlin/analysis/api/KaSession;Lorg/jetbrains/kotlin/analysis/api/symbols/KaCallableSymbol;)Ldev/mutwakil/androidide/lsp/models/CompletionItem;", "setInsertTextForFunction", "name", "hasParams", "", "(Ldev/mutwakil/androidide/lsp/kotlin/utils/AnalysisContext;Ldev/mutwakil/androidide/lsp/models/CompletionItem;Ljava/lang/String;Z)V", "classifierSymbolToCompletionItem", "(Ldev/mutwakil/androidide/lsp/kotlin/utils/AnalysisContext;Lorg/jetbrains/kotlin/analysis/api/KaSession;Lorg/jetbrains/kotlin/analysis/api/symbols/KaClassifierSymbol;)Ldev/mutwakil/androidide/lsp/models/CompletionItem;", "setClassCompletionData", "className", "isNested", "topLevelClass", "(Ldev/mutwakil/androidide/lsp/kotlin/utils/AnalysisContext;Ldev/mutwakil/androidide/lsp/models/CompletionItem;Ljava/lang/String;ZLjava/lang/String;)V", "createSymbolCompletionItem", "Lorg/jetbrains/kotlin/analysis/api/symbols/KaSymbol;", "(Ldev/mutwakil/androidide/lsp/kotlin/utils/AnalysisContext;Lorg/jetbrains/kotlin/analysis/api/KaSession;Lorg/jetbrains/kotlin/analysis/api/symbols/KaSymbol;)Ldev/mutwakil/androidide/lsp/models/CompletionItem;", "ktCompletionItem", "kind", "Ldev/mutwakil/androidide/lsp/models/CompletionItemKind;", "(Ldev/mutwakil/androidide/lsp/kotlin/utils/AnalysisContext;Lorg/jetbrains/kotlin/analysis/api/KaSession;Ljava/lang/String;Ldev/mutwakil/androidide/lsp/models/CompletionItemKind;)Ldev/mutwakil/androidide/lsp/models/CompletionItem;", "kindOf", "partialIdentifier", "prefix", "memoizedMatchLevel", "Ldev/mutwakil/androidide/lsp/models/MatchLevel;", "cache", "", "partial", "matchLevelFor", "(Ldev/mutwakil/androidide/lsp/kotlin/utils/AnalysisContext;Ljava/lang/String;)Ldev/mutwakil/androidide/lsp/models/MatchLevel;", "matchesFilter", "Lorg/jetbrains/kotlin/name/Name;", "(Ldev/mutwakil/androidide/lsp/kotlin/utils/AnalysisContext;Lorg/jetbrains/kotlin/name/Name;)Z", "determineCompletionContext", "Ldev/mutwakil/androidide/lsp/kotlin/completion/CompletionContext;", "element", "Lorg/jetbrains/kotlin/com/intellij/psi/PsiElement;", "isInSelectorPosition", "qualifiedExpr", "Lorg/jetbrains/kotlin/psi/KtQualifiedExpression;", "kotlin_debug"})
public final class KotlinCompletionsKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KT_COMPLETION_PLACEHOLDER = "KT_COMPLETION_PLACEHOLDER";
    private static final org.slf4j.Logger logger = null;
    
    private static final void abortIfCancelled() {
    }
    
    /**
     * Provide code completion for the given completion parameters.
     *
     * @param CompilationEnvironment The compilation environment to use for the code completion.
     * @param params The completion parameters.
     * @return The completion result.
     */
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.models.CompletionResult codeComplete(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationEnvironment env, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.models.CompletionParams params) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.models.CompletionResult doComplete(@org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationEnvironment env, @org.jetbrains.annotations.NotNull()
    dev.mutwakil.androidide.lsp.models.CompletionParams params) {
        return null;
    }
    
    private static final void collectMemberCompletions(dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext ctx, org.jetbrains.kotlin.analysis.api.KaSession $this$collectMemberCompletions, java.util.List<dev.mutwakil.androidide.lsp.models.CompletionItem> to) {
    }
    
    @kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaExperimentalApi.class})
    private static final void collectMembersFromType(dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext ctx, org.jetbrains.kotlin.analysis.api.KaSession $this$collectMembersFromType, org.jetbrains.kotlin.analysis.api.types.KaType receiverType, java.util.List<dev.mutwakil.androidide.lsp.models.CompletionItem> to) {
    }
    
    private static final void collectExtensionFunctions(dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext ctx, org.jetbrains.kotlin.analysis.api.KaSession $this$collectExtensionFunctions, org.jetbrains.kotlin.analysis.api.types.KaType receiverType, java.util.List<dev.mutwakil.androidide.lsp.models.CompletionItem> to) {
    }
    
    private static final void collectScopeCompletions(dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationEnvironment env, dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext ctx, org.jetbrains.kotlin.analysis.api.KaSession $this$collectScopeCompletions, java.util.List<dev.mutwakil.androidide.lsp.models.CompletionItem> to) {
    }
    
    private static final void collectUnimportedSymbols(dev.mutwakil.androidide.lsp.kotlin.compiler.CompilationEnvironment env, dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext ctx, org.jetbrains.kotlin.analysis.api.KaSession $this$collectUnimportedSymbols, java.util.List<dev.mutwakil.androidide.lsp.models.CompletionItem> to) {
    }
    
    private static final dev.mutwakil.androidide.lsp.models.CompletionItem buildUnimportedSymbolItem(dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext ctx, org.jetbrains.kotlin.analysis.api.KaSession $this$buildUnimportedSymbolItem, org.appdevforall.codeonthego.indexing.jvm.JvmSymbol symbol) {
        return null;
    }
    
    private static final org.jetbrains.kotlin.name.ClassId internalNameToClassId(java.lang.String internalName) {
        return null;
    }
    
    private static final void collectKeywordCompletions(dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext ctx, org.jetbrains.kotlin.analysis.api.KaSession $this$collectKeywordCompletions, java.util.List<dev.mutwakil.androidide.lsp.models.CompletionItem> to) {
    }
    
    private static final void collectSnippetCompletions(dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext ctx, org.jetbrains.kotlin.analysis.api.KaSession $this$collectSnippetCompletions, java.util.List<dev.mutwakil.androidide.lsp.models.CompletionItem> to) {
    }
    
    private static final int computeIndentLevelAt(org.jetbrains.kotlin.psi.KtElement ktElement) {
        return 0;
    }
    
    @kotlin.jvm.JvmName(name = "callablesToCompletionItems")
    private static final kotlin.sequences.Sequence<dev.mutwakil.androidide.lsp.models.CompletionItem> callablesToCompletionItems(dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext ctx, org.jetbrains.kotlin.analysis.api.KaSession $this$toCompletionItems, kotlin.sequences.Sequence<? extends org.jetbrains.kotlin.analysis.api.symbols.KaCallableSymbol> callables) {
        return null;
    }
    
    @kotlin.jvm.JvmName(name = "classifiersToCompletionItems")
    private static final kotlin.sequences.Sequence<dev.mutwakil.androidide.lsp.models.CompletionItem> classifiersToCompletionItems(dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext ctx, org.jetbrains.kotlin.analysis.api.KaSession $this$toCompletionItems, kotlin.sequences.Sequence<? extends org.jetbrains.kotlin.analysis.api.symbols.KaClassifierSymbol> classifiers) {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaExperimentalApi.class})
    private static final dev.mutwakil.androidide.lsp.models.CompletionItem callableSymbolToCompletionItem(dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext ctx, org.jetbrains.kotlin.analysis.api.KaSession $this$callableSymbolToCompletionItem, org.jetbrains.kotlin.analysis.api.symbols.KaCallableSymbol symbol) {
        return null;
    }
    
    private static final void setInsertTextForFunction(dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext ctx, dev.mutwakil.androidide.lsp.models.CompletionItem $this$setInsertTextForFunction, java.lang.String name, boolean hasParams) {
    }
    
    @kotlin.OptIn(markerClass = {org.jetbrains.kotlin.analysis.api.KaExperimentalApi.class, org.jetbrains.kotlin.analysis.api.KaIdeApi.class})
    private static final dev.mutwakil.androidide.lsp.models.CompletionItem classifierSymbolToCompletionItem(dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext ctx, org.jetbrains.kotlin.analysis.api.KaSession $this$classifierSymbolToCompletionItem, org.jetbrains.kotlin.analysis.api.symbols.KaClassifierSymbol symbol) {
        return null;
    }
    
    private static final void setClassCompletionData(dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext ctx, dev.mutwakil.androidide.lsp.models.CompletionItem $this$setClassCompletionData, java.lang.String className, boolean isNested, java.lang.String topLevelClass) {
    }
    
    private static final dev.mutwakil.androidide.lsp.models.CompletionItem createSymbolCompletionItem(dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext ctx, org.jetbrains.kotlin.analysis.api.KaSession $this$createSymbolCompletionItem, org.jetbrains.kotlin.analysis.api.symbols.KaSymbol symbol) {
        return null;
    }
    
    private static final dev.mutwakil.androidide.lsp.models.CompletionItem ktCompletionItem(dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext ctx, org.jetbrains.kotlin.analysis.api.KaSession $this$ktCompletionItem, java.lang.String name, dev.mutwakil.androidide.lsp.models.CompletionItemKind kind) {
        return null;
    }
    
    private static final dev.mutwakil.androidide.lsp.models.CompletionItemKind kindOf(org.jetbrains.kotlin.analysis.api.KaSession $this$kindOf, org.jetbrains.kotlin.analysis.api.symbols.KaSymbol symbol) {
        return null;
    }
    
    private static final dev.mutwakil.androidide.lsp.models.CompletionItemKind kindOf(org.jetbrains.kotlin.analysis.api.KaSession $this$kindOf, org.appdevforall.codeonthego.indexing.jvm.JvmSymbol symbol) {
        return null;
    }
    
    private static final java.lang.String partialIdentifier(java.lang.String prefix) {
        return null;
    }
    
    /**
     * Returns the [MatchLevel] of [name] against [partial], memoized in [cache].
     *
     * Match level depends only on (name, partial), so memoizing by name is safe even
     * when multiple symbols share a name. This is the single place match level is
     * computed for a completion request; both the inclusion predicate and item
     * creation route through it so [CompletionItem.matchLevel] runs at most once per
     * distinct candidate name.
     */
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.models.MatchLevel memoizedMatchLevel(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, dev.mutwakil.androidide.lsp.models.MatchLevel> cache, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String partial) {
        return null;
    }
    
    private static final dev.mutwakil.androidide.lsp.models.MatchLevel matchLevelFor(dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext ctx, java.lang.String name) {
        return null;
    }
    
    private static final boolean matchesFilter(dev.mutwakil.androidide.lsp.kotlin.utils.AnalysisContext ctx, org.jetbrains.kotlin.name.Name name) {
        return false;
    }
    
    private static final dev.mutwakil.androidide.lsp.kotlin.completion.CompletionContext determineCompletionContext(org.jetbrains.kotlin.com.intellij.psi.PsiElement element) {
        return null;
    }
    
    private static final boolean isInSelectorPosition(org.jetbrains.kotlin.com.intellij.psi.PsiElement element, org.jetbrains.kotlin.psi.KtQualifiedExpression qualifiedExpr) {
        return false;
    }
}