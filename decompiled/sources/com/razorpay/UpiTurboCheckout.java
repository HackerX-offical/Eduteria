package com.razorpay;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.razorpay.RzpTurboExternalPlugin;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Session;
import org.jivesoftware.smackx.muc.packet.Destroy;

/* JADX INFO: compiled from: UpiTurboCheckout.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\nH\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0007J\u0006\u0010\u0014\u001a\u00020\u0013J\u001a\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0001J\"\u0010\u001a\u001a\u00020\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0001J\"\u0010\u001b\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0001J\"\u0010\u001d\u001a\u00020\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0001J\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/razorpay/UpiTurboCheckout;", "", "activity", "Landroid/app/Activity;", "customerMobile", "", "color", "orderId", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "isPluginIntegrated", "", "pluginCompatibilityResponse", "Lcom/razorpay/RzpPluginCompatibilityResponse;", "razorpayTurbo", "Lcom/razorpay/RzpTurboExternalPlugin;", "razorpayTurboPlugin", "Lcom/razorpay/RzpPlugin;", "checkForPlugin", "clearSession", "", Destroy.ELEMENT, "getLinkedUpiAccounts", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "initTurboSdk", "initialize", Session.ELEMENT, "linkNewUpiAccount", "linkNewUpiAccountCheckout", "amountInDisplayFormat", "manageUpiAccounts", "setMobileNumber", "Companion", "checkout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpiTurboCheckout {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Activity activity;
    private String color;
    private String customerMobile;
    private boolean isPluginIntegrated;
    private String orderId;
    private RzpPluginCompatibilityResponse pluginCompatibilityResponse;
    private RzpTurboExternalPlugin razorpayTurbo;
    private RzpPlugin razorpayTurboPlugin;

    public UpiTurboCheckout(Activity activity, String customerMobile, String str, String str2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(customerMobile, "customerMobile");
        this.activity = activity;
        this.customerMobile = customerMobile;
        this.color = str;
        this.orderId = str2;
    }

    public /* synthetic */ UpiTurboCheckout(Activity activity, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, str, str2, (i & 8) != 0 ? null : str3);
    }

    public final void setMobileNumber(String customerMobile) {
        Intrinsics.checkNotNullParameter(customerMobile, "customerMobile");
        this.customerMobile = customerMobile;
    }

    /* JADX INFO: compiled from: UpiTurboCheckout.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/razorpay/UpiTurboCheckout$Companion;", "", "()V", "initTurboSdk", "", "context", "Landroid/content/Context;", "customerMobile", "", "checkout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void initTurboSdk(Context context, String customerMobile) {
            Class<?> clsLoadClass;
            Intrinsics.checkNotNullParameter(context, "context");
            HashMap<String, String> plugins = BaseUtils.getAllPluginsFromManifest(context);
            Intrinsics.checkNotNullExpressionValue(plugins, "plugins");
            for (Map.Entry<String, String> entry : plugins.entrySet()) {
                String key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "it.key");
                if (StringsKt.contains$default((CharSequence) key, (CharSequence) "upi_turbo", false, 2, (Object) null)) {
                    ClassLoader classLoader = RzpTurboExternalPlugin.class.getClassLoader();
                    Object objNewInstance = (classLoader == null || (clsLoadClass = classLoader.loadClass(entry.getValue())) == null) ? null : clsLoadClass.newInstance();
                    if (objNewInstance == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.razorpay.RzpTurboExternalPlugin");
                    }
                    ((RzpTurboExternalPlugin) objNewInstance).preloadUpiAccountsCheckout((Activity) context, customerMobile, null);
                }
            }
        }
    }

    private final void initTurboSdk() {
        if (checkForPlugin()) {
            RzpTurboExternalPlugin rzpTurboExternalPlugin = this.razorpayTurbo;
            if (rzpTurboExternalPlugin == null) {
                Intrinsics.throwUninitializedPropertyAccessException("razorpayTurbo");
                rzpTurboExternalPlugin = null;
            }
            rzpTurboExternalPlugin.initTurboSdk(this.activity, this.customerMobile, null);
        }
    }

    private final boolean checkForPlugin() {
        Class<?> clsLoadClass;
        Class<?> clsLoadClass2;
        if (this.isPluginIntegrated) {
            return true;
        }
        HashMap<String, String> plugins = BaseUtils.getAllPluginsFromManifest(this.activity);
        Intrinsics.checkNotNullExpressionValue(plugins, "plugins");
        for (Map.Entry<String, String> entry : plugins.entrySet()) {
            String key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "it.key");
            RzpPluginCompatibilityResponse rzpPluginCompatibilityResponse = null;
            if (StringsKt.contains$default((CharSequence) key, (CharSequence) "upi_turbo", false, 2, (Object) null)) {
                ClassLoader classLoader = RzpTurboExternalPlugin.class.getClassLoader();
                Object objNewInstance = (classLoader == null || (clsLoadClass2 = classLoader.loadClass(entry.getValue())) == null) ? null : clsLoadClass2.newInstance();
                if (objNewInstance != null) {
                    this.razorpayTurbo = (RzpTurboExternalPlugin) objNewInstance;
                    ClassLoader classLoader2 = RzpPlugin.class.getClassLoader();
                    Object objNewInstance2 = (classLoader2 == null || (clsLoadClass = classLoader2.loadClass(entry.getValue())) == null) ? null : clsLoadClass.newInstance();
                    if (objNewInstance2 != null) {
                        RzpPlugin rzpPlugin = (RzpPlugin) objNewInstance2;
                        this.razorpayTurboPlugin = rzpPlugin;
                        if (rzpPlugin == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("razorpayTurboPlugin");
                            rzpPlugin = null;
                        }
                        RzpPluginCompatibilityResponse rzpPluginCompatibilityResponseIsCompatible = rzpPlugin.isCompatible("standard", 1714, BuildConfig.VERSION_NAME);
                        Intrinsics.checkNotNullExpressionValue(rzpPluginCompatibilityResponseIsCompatible, "razorpayTurboPlugin.isCo…ON_NAME\n                )");
                        this.pluginCompatibilityResponse = rzpPluginCompatibilityResponseIsCompatible;
                        if (rzpPluginCompatibilityResponseIsCompatible == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pluginCompatibilityResponse");
                        } else {
                            rzpPluginCompatibilityResponse = rzpPluginCompatibilityResponseIsCompatible;
                        }
                        if (!rzpPluginCompatibilityResponse.isCompatible()) {
                            return false;
                        }
                        this.isPluginIntegrated = true;
                        return true;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.razorpay.RzpPlugin");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.razorpay.RzpTurboExternalPlugin");
            }
        }
        return false;
    }

    public static /* synthetic */ void getLinkedUpiAccounts$default(UpiTurboCheckout upiTurboCheckout, Object obj, String str, int i, Object obj2) {
        if ((i & 2) != 0) {
            str = null;
        }
        upiTurboCheckout.getLinkedUpiAccounts(obj, str);
    }

    public final void getLinkedUpiAccounts(Object listener, String customerMobile) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (checkForPlugin()) {
            RzpTurboExternalPlugin rzpTurboExternalPlugin = this.razorpayTurbo;
            if (rzpTurboExternalPlugin == null) {
                Intrinsics.throwUninitializedPropertyAccessException("razorpayTurbo");
                rzpTurboExternalPlugin = null;
            }
            RzpTurboExternalPlugin rzpTurboExternalPlugin2 = rzpTurboExternalPlugin;
            Activity activity = this.activity;
            if (customerMobile == null) {
                customerMobile = this.customerMobile;
            }
            rzpTurboExternalPlugin2.getLinkedUpiAccountsCheckout(activity, customerMobile, null, this.color, listener, this.orderId);
            return;
        }
        throw new RuntimeException("Razorpay UPI-Turbo Wrapper Plugin not integrated. ");
    }

    public final void linkNewUpiAccountCheckout(String color, String amountInDisplayFormat, Object listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (checkForPlugin()) {
            RzpTurboExternalPlugin rzpTurboExternalPlugin = this.razorpayTurbo;
            if (rzpTurboExternalPlugin == null) {
                Intrinsics.throwUninitializedPropertyAccessException("razorpayTurbo");
                rzpTurboExternalPlugin = null;
            }
            RzpTurboExternalPlugin.DefaultImpls.linkNewUpiAccountCheckout$default(rzpTurboExternalPlugin, this.activity, this.customerMobile, null, color, amountInDisplayFormat, listener, this.orderId, false, 128, null);
            return;
        }
        throw new RuntimeException("Razorpay UPI-Turbo Wrapper Plugin not integrated. ");
    }

    public final void linkNewUpiAccount(String customerMobile, String color, Object listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (checkForPlugin()) {
            RzpTurboExternalPlugin rzpTurboExternalPlugin = this.razorpayTurbo;
            if (rzpTurboExternalPlugin == null) {
                Intrinsics.throwUninitializedPropertyAccessException("razorpayTurbo");
                rzpTurboExternalPlugin = null;
            }
            rzpTurboExternalPlugin.linkNewUpiAccountCheckout(this.activity, customerMobile, null, color, null, listener, this.orderId, true);
            return;
        }
        throw new RuntimeException("Razorpay UPI-Turbo Wrapper Plugin not integrated. ");
    }

    public final void initialize(Object session) {
        Intrinsics.checkNotNullParameter(session, "session");
        if (checkForPlugin()) {
            RzpTurboExternalPlugin rzpTurboExternalPlugin = this.razorpayTurbo;
            if (rzpTurboExternalPlugin == null) {
                Intrinsics.throwUninitializedPropertyAccessException("razorpayTurbo");
                rzpTurboExternalPlugin = null;
            }
            rzpTurboExternalPlugin.initialize(this.activity, session, this.customerMobile, null);
            return;
        }
        throw new RuntimeException("Razorpay UPI-Turbo Wrapper Plugin not integrated. ");
    }

    @Deprecated(message = "This method is deprecated, as it is only intended for internal testing")
    public final void clearSession() {
        if (checkForPlugin()) {
            RzpTurboExternalPlugin rzpTurboExternalPlugin = this.razorpayTurbo;
            if (rzpTurboExternalPlugin == null) {
                Intrinsics.throwUninitializedPropertyAccessException("razorpayTurbo");
                rzpTurboExternalPlugin = null;
            }
            rzpTurboExternalPlugin.clearSession();
            return;
        }
        throw new RuntimeException("Razorpay UPI-Turbo Wrapper Plugin not integrated. ");
    }

    public final void manageUpiAccounts(String customerMobile, String color, Object listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (checkForPlugin()) {
            RzpTurboExternalPlugin rzpTurboExternalPlugin = this.razorpayTurbo;
            if (rzpTurboExternalPlugin == null) {
                Intrinsics.throwUninitializedPropertyAccessException("razorpayTurbo");
                rzpTurboExternalPlugin = null;
            }
            rzpTurboExternalPlugin.manageUpiAccounts(this.activity, customerMobile, color, listener);
            return;
        }
        throw new RuntimeException("Razorpay UPI-Turbo Wrapper Plugin not integrated. ");
    }

    public final void destroy() {
        if (checkForPlugin()) {
            RzpTurboExternalPlugin rzpTurboExternalPlugin = this.razorpayTurbo;
            if (rzpTurboExternalPlugin == null) {
                Intrinsics.throwUninitializedPropertyAccessException("razorpayTurbo");
                rzpTurboExternalPlugin = null;
            }
            rzpTurboExternalPlugin.destroy();
            return;
        }
        throw new RuntimeException("Razorpay UPI-Turbo Wrapper Plugin not integrated. ");
    }
}
