package com.razorpay;

import android.app.Activity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jivesoftware.smackx.muc.packet.Destroy;

/* JADX INFO: compiled from: RzpTurboExternalPlugin.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H&J\b\u0010\u0006\u001a\u00020\u0003H'J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H&J\b\u0010\t\u001a\u00020\u0003H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H&J,\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0001H&J,\u0010\u0012\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0001H&J,\u0010\u0014\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0001H&J@\u0010\u0015\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fH&J$\u0010\u0017\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J,\u0010\u0018\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J>\u0010\u001a\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0001H&J6\u0010\u001c\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH&JT\u0010\u001d\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u001f\u001a\u00020 H&J,\u0010!\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0001H&J,\u0010\"\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0001H&J\b\u0010#\u001a\u00020\u0003H&J@\u0010$\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010%\u001a\u00020 H&J$\u0010&\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\b\u0010'\u001a\u00020\u0003H&J \u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H&J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020 H&J\u0018\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H&¨\u0006."}, d2 = {"Lcom/razorpay/RzpTurboExternalPlugin;", "", "changeUpiPin", "", "upiAccount", "callback", "clearSession", "delink", "upiAcOrLinkedBankAc", Destroy.ELEMENT, "getBalance", "getLinkedBankAccounts", "activity", "Landroid/app/Activity;", "customerMobile", "", "customerId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getLinkedTPVUpiAccounts", "orderId", "getLinkedUpiAccounts", "getLinkedUpiAccountsCheckout", "color", "initTurboSdk", "initialize", "sessionDelegate", "linkNewTPVUpiAccount", "tpvBankAccount", "linkNewUpiAccount", "linkNewUpiAccountCheckout", "amountInDisplayFormat", "triggeredByMerchant", "", "manageUpiAccounts", "manageUpiAccountsCustom", "onPermissionsRequestResult", "prefetchAndLinkNewUpiAccount", "linkAccountsWithUPIPinNotSet", "preloadUpiAccountsCheckout", "releaseActivityReference", "resetUpiPin", "card", "setFeeBearer", "feeBearer", "setUpiPinWithUI", "bankAccount", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RzpTurboExternalPlugin {
    void changeUpiPin(Object upiAccount, Object callback);

    @Deprecated(message = "This method is deprecated, as it is only intended for internal testing purposes.")
    void clearSession();

    void delink(Object upiAcOrLinkedBankAc, Object callback);

    void destroy();

    void getBalance(Object upiAccount, Object callback);

    void getLinkedBankAccounts(Activity activity, String customerMobile, String customerId, Object listener);

    void getLinkedTPVUpiAccounts(Activity activity, String customerMobile, String orderId, Object listener);

    void getLinkedUpiAccounts(Activity activity, String customerMobile, String customerId, Object listener);

    void getLinkedUpiAccountsCheckout(Activity activity, String customerMobile, String customerId, String color, Object listener, String orderId);

    void initTurboSdk(Activity activity, String customerMobile, String customerId);

    void initialize(Activity activity, Object sessionDelegate, String customerMobile, String customerId);

    void linkNewTPVUpiAccount(Activity activity, String customerMobile, String orderId, Object tpvBankAccount, String customerId, Object listener);

    void linkNewUpiAccount(Activity activity, String customerMobile, String customerId, Object listener, String color);

    void linkNewUpiAccountCheckout(Activity activity, String customerMobile, String customerId, String color, String amountInDisplayFormat, Object listener, String orderId, boolean triggeredByMerchant);

    void manageUpiAccounts(Activity activity, String customerMobile, String color, Object listener);

    void manageUpiAccountsCustom(Activity activity, String customerMobile, String customerId, Object listener);

    void onPermissionsRequestResult();

    void prefetchAndLinkNewUpiAccount(Activity activity, String customerMobile, String customerId, Object listener, String color, boolean linkAccountsWithUPIPinNotSet);

    void preloadUpiAccountsCheckout(Activity activity, String customerMobile, String customerId);

    void releaseActivityReference();

    void resetUpiPin(Object card, Object upiAccount, Object callback);

    void setFeeBearer(boolean feeBearer);

    void setUpiPinWithUI(Object bankAccount, Object listener);

    /* JADX INFO: compiled from: RzpTurboExternalPlugin.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void prefetchAndLinkNewUpiAccount$default(RzpTurboExternalPlugin rzpTurboExternalPlugin, Activity activity, String str, String str2, Object obj, String str3, boolean z, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: prefetchAndLinkNewUpiAccount");
            }
            if ((i & 32) != 0) {
                z = false;
            }
            rzpTurboExternalPlugin.prefetchAndLinkNewUpiAccount(activity, str, str2, obj, str3, z);
        }

        public static /* synthetic */ void linkNewUpiAccountCheckout$default(RzpTurboExternalPlugin rzpTurboExternalPlugin, Activity activity, String str, String str2, String str3, String str4, Object obj, String str5, boolean z, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: linkNewUpiAccountCheckout");
            }
            rzpTurboExternalPlugin.linkNewUpiAccountCheckout(activity, str, str2, str3, str4, obj, str5, (i & 128) != 0 ? false : z);
        }
    }
}
