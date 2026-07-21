package dev.mutwakil.androidide.lsp.kotlin.compiler.registrar;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R*\u0010\u0006\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007j\u0002`\nX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR*\u0010\r\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007j\u0002`\nX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0013\u00c0\u0006\u0003"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/AnalysisApiServiceProvider;", "", "pluginRelativePath", "", "getPluginRelativePath", "()Ljava/lang/String;", "applicationServices", "", "Lkotlin/reflect/KClass;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceRegistration;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceMap;", "getApplicationServices", "()Ljava/util/Map;", "projectServices", "getProjectServices", "toBuilder", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/AnalysisApiServiceProvider$Builder;", "SimpleAnalysisApiServiceProvider", "Builder", "kotlin_debug"})
public abstract interface AnalysisApiServiceProvider {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getPluginRelativePath();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.Map<kotlin.reflect.KClass<?>, dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<?>> getApplicationServices();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.Map<kotlin.reflect.KClass<?>, dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<?>> getProjectServices();
    
    @org.jetbrains.annotations.NotNull()
    public default dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.AnalysisApiServiceProvider.Builder toBuilder() {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012 \b\u0002\u0010\u0004\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005j\u0002`\b\u0012 \b\u0002\u0010\t\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005j\u0002`\b\u00a2\u0006\u0004\b\n\u0010\u000bJH\u0010\u0013\u001a\u00020\u00142\u001e\u0010\u0015\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0011j\u0002`\u00122\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00062\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J*\u0010\u001a\u001a\u00020\u00142\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00062\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0002J*\u0010\u001b\u001a\u00020\u00142\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00062\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0002J:\u0010\u001c\u001a\u00020\u0014\"\b\b\u0000\u0010\u001d*\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00062\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u001d0\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0019J5\u0010\u001c\u001a\u00020\u0014\"\b\b\u0000\u0010\u001d*\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00062\u0006\u0010\u0017\u001a\u0002H\u001d2\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\u0002\u0010\u001fJ6\u0010\u001c\u001a\u00020\u0014\"\b\b\u0000\u0010\u001d*\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00192\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u001d0 J:\u0010!\u001a\u00020\u0014\"\b\b\u0000\u0010\u001d*\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00062\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u001d0\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0019J5\u0010!\u001a\u00020\u0014\"\b\b\u0000\u0010\u001d*\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00062\u0006\u0010\u0017\u001a\u0002H\u001d2\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\u0002\u0010\u001fJ6\u0010!\u001a\u00020\u0014\"\b\b\u0000\u0010\u001d*\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00192\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u001d0 J\u0006\u0010\"\u001a\u00020#R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0011j\u0002`\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\t\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0011j\u0002`\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/AnalysisApiServiceProvider$Builder;", "", "pluginRelativePath", "", "appServices", "", "Lkotlin/reflect/KClass;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceRegistration;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceMap;", "projectServices", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getPluginRelativePath", "()Ljava/lang/String;", "setPluginRelativePath", "(Ljava/lang/String;)V", "applicationServices", "", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/MutableServiceMap;", "put", "", "store", "key", "value", "replace", "", "appSvc", "projSvc", "appService", "T", "type", "(Lkotlin/reflect/KClass;Ljava/lang/Object;Z)V", "Lkotlin/Function0;", "projectService", "build", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/AnalysisApiServiceProvider;", "kotlin_debug"})
    public static final class Builder {
        @org.jetbrains.annotations.Nullable()
        private java.lang.String pluginRelativePath;
        @org.jetbrains.annotations.NotNull()
        private final java.util.Map<kotlin.reflect.KClass<?>, dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<?>> applicationServices = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.Map<kotlin.reflect.KClass<?>, dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<?>> projectServices = null;
        
        public Builder(@org.jetbrains.annotations.Nullable()
        java.lang.String pluginRelativePath, @org.jetbrains.annotations.NotNull()
        java.util.Map<kotlin.reflect.KClass<?>, ? extends dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<?>> appServices, @org.jetbrains.annotations.NotNull()
        java.util.Map<kotlin.reflect.KClass<?>, ? extends dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<?>> projectServices) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getPluginRelativePath() {
            return null;
        }
        
        public final void setPluginRelativePath(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        private final void put(java.util.Map<kotlin.reflect.KClass<?>, dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<?>> store, kotlin.reflect.KClass<?> key, dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<?> value, boolean replace) {
        }
        
        private final void appSvc(kotlin.reflect.KClass<?> key, dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<?> value, boolean replace) {
        }
        
        private final void projSvc(kotlin.reflect.KClass<?> key, dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<?> value, boolean replace) {
        }
        
        public final <T extends java.lang.Object>void appService(@org.jetbrains.annotations.NotNull()
        kotlin.reflect.KClass<T> key, @org.jetbrains.annotations.NotNull()
        kotlin.reflect.KClass<? extends T> type, boolean replace) {
        }
        
        public final <T extends java.lang.Object>void appService(@org.jetbrains.annotations.NotNull()
        kotlin.reflect.KClass<T> key, @org.jetbrains.annotations.NotNull()
        T value, boolean replace) {
        }
        
        public final <T extends java.lang.Object>void appService(@org.jetbrains.annotations.NotNull()
        kotlin.reflect.KClass<T> key, boolean replace, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<? extends T> value) {
        }
        
        public final <T extends java.lang.Object>void projectService(@org.jetbrains.annotations.NotNull()
        kotlin.reflect.KClass<T> key, @org.jetbrains.annotations.NotNull()
        kotlin.reflect.KClass<? extends T> type, boolean replace) {
        }
        
        public final <T extends java.lang.Object>void projectService(@org.jetbrains.annotations.NotNull()
        kotlin.reflect.KClass<T> key, @org.jetbrains.annotations.NotNull()
        T value, boolean replace) {
        }
        
        public final <T extends java.lang.Object>void projectService(@org.jetbrains.annotations.NotNull()
        kotlin.reflect.KClass<T> key, boolean replace, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<? extends T> value) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.AnalysisApiServiceProvider build() {
            return null;
        }
        
        public Builder() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Deprecated()
        public static dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.AnalysisApiServiceProvider.Builder toBuilder(@org.jetbrains.annotations.NotNull()
        dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.AnalysisApiServiceProvider $this) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BQ\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001e\u0010\u0004\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005j\u0002`\b\u0012\u001e\u0010\t\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005j\u0002`\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J!\u0010\u0012\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005j\u0002`\bH\u00c6\u0003J!\u0010\u0013\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005j\u0002`\bH\u00c6\u0003JY\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032 \b\u0002\u0010\u0004\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005j\u0002`\b2 \b\u0002\u0010\t\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005j\u0002`\bH\u00c6\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u00d6\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aH\u00d6\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003H\u00d6\u0081\u0004R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR,\u0010\u0004\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005j\u0002`\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR,\u0010\t\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005j\u0002`\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/AnalysisApiServiceProvider$SimpleAnalysisApiServiceProvider;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/AnalysisApiServiceProvider;", "pluginRelativePath", "", "applicationServices", "", "Lkotlin/reflect/KClass;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceRegistration;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceMap;", "projectServices", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getPluginRelativePath", "()Ljava/lang/String;", "getApplicationServices", "()Ljava/util/Map;", "getProjectServices", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "kotlin_debug"})
    public static final class SimpleAnalysisApiServiceProvider implements dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.AnalysisApiServiceProvider {
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String pluginRelativePath = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.Map<kotlin.reflect.KClass<?>, dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<?>> applicationServices = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.Map<kotlin.reflect.KClass<?>, dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<?>> projectServices = null;
        
        public SimpleAnalysisApiServiceProvider(@org.jetbrains.annotations.Nullable()
        java.lang.String pluginRelativePath, @org.jetbrains.annotations.NotNull()
        java.util.Map<kotlin.reflect.KClass<?>, ? extends dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<?>> applicationServices, @org.jetbrains.annotations.NotNull()
        java.util.Map<kotlin.reflect.KClass<?>, ? extends dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<?>> projectServices) {
            super();
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.Nullable()
        public java.lang.String getPluginRelativePath() {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.util.Map<kotlin.reflect.KClass<?>, dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<?>> getApplicationServices() {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.util.Map<kotlin.reflect.KClass<?>, dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<?>> getProjectServices() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<kotlin.reflect.KClass<?>, dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<?>> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<kotlin.reflect.KClass<?>, dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<?>> component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.AnalysisApiServiceProvider.SimpleAnalysisApiServiceProvider copy(@org.jetbrains.annotations.Nullable()
        java.lang.String pluginRelativePath, @org.jetbrains.annotations.NotNull()
        java.util.Map<kotlin.reflect.KClass<?>, ? extends dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<?>> applicationServices, @org.jetbrains.annotations.NotNull()
        java.util.Map<kotlin.reflect.KClass<?>, ? extends dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<?>> projectServices) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.AnalysisApiServiceProvider.Builder toBuilder() {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}