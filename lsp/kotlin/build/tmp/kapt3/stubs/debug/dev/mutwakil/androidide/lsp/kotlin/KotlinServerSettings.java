package dev.mutwakil.androidide.lsp.kotlin;

@kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0007"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/KotlinServerSettings;", "Ldev/mutwakil/androidide/lsp/util/PrefBasedServerSettings;", "<init>", "()V", "diagnosticsEnabled", "", "Companion", "kotlin_debug"})
public final class KotlinServerSettings extends dev.mutwakil.androidide.lsp.util.PrefBasedServerSettings {
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy<dev.mutwakil.androidide.lsp.kotlin.KotlinServerSettings> _instance$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.kotlin.KotlinServerSettings.Companion Companion = null;
    
    private KotlinServerSettings() {
        super();
    }
    
    @java.lang.Override()
    public boolean diagnosticsEnabled() {
        return false;
    }
    
    @kotlin.jvm.JvmStatic()
    @org.jetbrains.annotations.NotNull()
    public static final dev.mutwakil.androidide.lsp.kotlin.KotlinServerSettings getInstance() {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 3, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0007R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Ldev/mutwakil/androidide/lsp/kotlin/KotlinServerSettings$Companion;", "", "<init>", "()V", "_instance", "Ldev/mutwakil/androidide/lsp/kotlin/KotlinServerSettings;", "get_instance", "()Ldev/mutwakil/androidide/lsp/kotlin/KotlinServerSettings;", "_instance$delegate", "Lkotlin/Lazy;", "getInstance", "kotlin_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        private final dev.mutwakil.androidide.lsp.kotlin.KotlinServerSettings get_instance() {
            return null;
        }
        
        @kotlin.jvm.JvmStatic()
        @org.jetbrains.annotations.NotNull()
        public final dev.mutwakil.androidide.lsp.kotlin.KotlinServerSettings getInstance() {
            return null;
        }
    }
}