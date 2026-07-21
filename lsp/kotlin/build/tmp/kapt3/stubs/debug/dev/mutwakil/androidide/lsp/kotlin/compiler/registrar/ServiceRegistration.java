package dev.mutwakil.androidide.lsp.kotlin.compiler.registrar;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \r*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0004\r\u000e\u000f\u0010B\t\b\u0004\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&R\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0003\u0011\u0012\u0013\u00a8\u0006\u0014"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceRegistration;", "T", "", "<init>", "()V", "klass", "Lkotlin/reflect/KClass;", "getKlass", "()Lkotlin/reflect/KClass;", "register", "", "to", "Lorg/jetbrains/kotlin/com/intellij/mock/MockComponentManager;", "Companion", "Typed", "Instance", "InstanceFactory", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceRegistration$Instance;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceRegistration$InstanceFactory;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceRegistration$Typed;", "kotlin_debug"})
public abstract class ServiceRegistration<T extends java.lang.Object> {
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration.Companion Companion = null;
    
    private ServiceRegistration() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlin.reflect.KClass<T> getKlass();
    
    public abstract void register(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.mock.MockComponentManager to);
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\b2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00060\bH\u0086\u0002J4\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\n\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\u000b\u001a\u0002H\u0006H\u0086\u0002\u00a2\u0006\u0002\u0010\fJ5\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\r\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000fH\u0086\u0002\u00a8\u0006\u0010"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceRegistration$Companion;", "", "<init>", "()V", "invoke", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceRegistration$Typed;", "T", "klass", "Lkotlin/reflect/KClass;", "type", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceRegistration$Instance;", "instance", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceRegistration$Instance;", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceRegistration$InstanceFactory;", "factory", "Lkotlin/Function0;", "kotlin_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final <T extends java.lang.Object>dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration.Typed<T> invoke(@org.jetbrains.annotations.NotNull()
        kotlin.reflect.KClass<T> klass, @org.jetbrains.annotations.NotNull()
        kotlin.reflect.KClass<? extends T> type) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final <T extends java.lang.Object>dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration.Instance<T> invoke(@org.jetbrains.annotations.NotNull()
        kotlin.reflect.KClass<T> klass, @org.jetbrains.annotations.NotNull()
        T instance) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final <T extends java.lang.Object>dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration.InstanceFactory<T> invoke(@org.jetbrains.annotations.NotNull()
        kotlin.reflect.KClass<T> klass, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<? extends T> factory) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u00c6\u0003J\u000e\u0010\u0013\u001a\u00028\u0001H\u00c6\u0003\u00a2\u0006\u0002\u0010\fJ.\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00028\u0001H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u00d6\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aH\u00d6\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cH\u00d6\u0081\u0004R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u00028\u0001\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001d"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceRegistration$Instance;", "T", "", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceRegistration;", "klass", "Lkotlin/reflect/KClass;", "instance", "<init>", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)V", "getKlass", "()Lkotlin/reflect/KClass;", "getInstance", "()Ljava/lang/Object;", "Ljava/lang/Object;", "register", "", "to", "Lorg/jetbrains/kotlin/com/intellij/mock/MockComponentManager;", "component1", "component2", "copy", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceRegistration$Instance;", "equals", "", "other", "hashCode", "", "toString", "", "kotlin_debug"})
    public static final class Instance<T extends java.lang.Object> extends dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<T> {
        @org.jetbrains.annotations.NotNull()
        private final kotlin.reflect.KClass<T> klass = null;
        @org.jetbrains.annotations.NotNull()
        private final T instance = null;
        
        public Instance(@org.jetbrains.annotations.NotNull()
        kotlin.reflect.KClass<T> klass, @org.jetbrains.annotations.NotNull()
        T instance) {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public kotlin.reflect.KClass<T> getKlass() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final T getInstance() {
            return null;
        }
        
        @java.lang.Override()
        public void register(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.com.intellij.mock.MockComponentManager to) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlin.reflect.KClass<T> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final T component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration.Instance<T> copy(@org.jetbrains.annotations.NotNull()
        kotlin.reflect.KClass<T> klass, @org.jetbrains.annotations.NotNull()
        T instance) {
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
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u00c6\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u00c6\u0003J/\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u00c6\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u00d6\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019H\u00d6\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bH\u00d6\u0081\u0004R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001c"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceRegistration$InstanceFactory;", "T", "", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceRegistration;", "klass", "Lkotlin/reflect/KClass;", "factory", "Lkotlin/Function0;", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)V", "getKlass", "()Lkotlin/reflect/KClass;", "getFactory", "()Lkotlin/jvm/functions/Function0;", "register", "", "to", "Lorg/jetbrains/kotlin/com/intellij/mock/MockComponentManager;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "kotlin_debug"})
    public static final class InstanceFactory<T extends java.lang.Object> extends dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<T> {
        @org.jetbrains.annotations.NotNull()
        private final kotlin.reflect.KClass<T> klass = null;
        @org.jetbrains.annotations.NotNull()
        private final kotlin.jvm.functions.Function0<T> factory = null;
        
        public InstanceFactory(@org.jetbrains.annotations.NotNull()
        kotlin.reflect.KClass<T> klass, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<? extends T> factory) {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public kotlin.reflect.KClass<T> getKlass() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlin.jvm.functions.Function0<T> getFactory() {
            return null;
        }
        
        @java.lang.Override()
        public void register(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.com.intellij.mock.MockComponentManager to) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlin.reflect.KClass<T> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlin.jvm.functions.Function0<T> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration.InstanceFactory<T> copy(@org.jetbrains.annotations.NotNull()
        kotlin.reflect.KClass<T> klass, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<? extends T> factory) {
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
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u00c6\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0005H\u00c6\u0003J1\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0005H\u00c6\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u00d6\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017H\u00d6\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019H\u00d6\u0081\u0004R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n\u00a8\u0006\u001a"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceRegistration$Typed;", "T", "", "Ldev/mutwakil/androidide/lsp/kotlin/compiler/registrar/ServiceRegistration;", "klass", "Lkotlin/reflect/KClass;", "type", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;)V", "getKlass", "()Lkotlin/reflect/KClass;", "getType", "register", "", "to", "Lorg/jetbrains/kotlin/com/intellij/mock/MockComponentManager;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "kotlin_debug"})
    public static final class Typed<T extends java.lang.Object> extends dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration<T> {
        @org.jetbrains.annotations.NotNull()
        private final kotlin.reflect.KClass<T> klass = null;
        @org.jetbrains.annotations.NotNull()
        private final kotlin.reflect.KClass<? extends T> type = null;
        
        public Typed(@org.jetbrains.annotations.NotNull()
        kotlin.reflect.KClass<T> klass, @org.jetbrains.annotations.NotNull()
        kotlin.reflect.KClass<? extends T> type) {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public kotlin.reflect.KClass<T> getKlass() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlin.reflect.KClass<? extends T> getType() {
            return null;
        }
        
        @java.lang.Override()
        public void register(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.com.intellij.mock.MockComponentManager to) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlin.reflect.KClass<T> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlin.reflect.KClass<? extends T> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final dev.mutwakil.androidide.lsp.kotlin.compiler.registrar.ServiceRegistration.Typed<T> copy(@org.jetbrains.annotations.NotNull()
        kotlin.reflect.KClass<T> klass, @org.jetbrains.annotations.NotNull()
        kotlin.reflect.KClass<? extends T> type) {
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
        public java.lang.String toString() {
            return null;
        }
    }
}