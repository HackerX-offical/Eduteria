package com.clevertap.android.sdk.leanplum;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.Logger;
import com.facebook.internal.NativeProtocol;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.xmlelement.element.DataFormsXmlElement;

/* JADX INFO: compiled from: LeanplumCT.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0007J\u001c\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0007J*\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0015H\u0007J4\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u001e\u0010\u0019\u001a\u00020\u000b2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0007J \u0010\u001a\u001a\u00020\u000b2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0015H\u0007J*\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\t2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0015H\u0007J\u0012\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\tH\u0007J\u001a\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020!H\u0007J\u001c\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0007J*\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0015H\u0007J2\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020!2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0015H\u0007J$\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020!2\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0007J<\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020!2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0015H\u0007J8\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\t2\b\u0010'\u001a\u0004\u0018\u00010\t2\b\u0010(\u001a\u0004\u0018\u00010\tH\u0007JH\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0015H\u0007JZ\u0010\"\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\t2\b\u0010'\u001a\u0004\u0018\u00010\t2\b\u0010(\u001a\u0004\u0018\u00010\t2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0015H\u0007J:\u0010*\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010\t2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0015H\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006+"}, d2 = {"Lcom/clevertap/android/sdk/leanplum/LeanplumCT;", "", "<init>", "()V", DataFormsXmlElement.ELEMENT, "Lcom/clevertap/android/sdk/leanplum/CTWrapper;", "getWrapper", "()Lcom/clevertap/android/sdk/leanplum/CTWrapper;", "getPurchaseEventName", "", "initWithContext", "", "context", "Landroid/content/Context;", "initWithInstance", "cleverTapInstance", "Lcom/clevertap/android/sdk/CleverTapAPI;", "advanceTo", "state", "info", NativeProtocol.WEB_DIALOG_PARAMS, "", "setLogLevel", "logLevel", "Lcom/clevertap/android/sdk/CleverTapAPI$LogLevel;", "setTrafficSourceInfo", "setUserAttributes", "attributes", "userId", "setUserId", "track", "event", "value", "", "trackGooglePlayPurchase", "item", "priceMicros", "", Constants.CURRENCY_CODE_PARAM, "purchaseData", "dataSignature", "eventName", "trackPurchase", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LeanplumCT {
    public static final LeanplumCT INSTANCE = new LeanplumCT();
    private static CTWrapper wrapper;

    private LeanplumCT() {
    }

    private final CTWrapper getWrapper() {
        if (wrapper == null) {
            Logger.i("LeanplumCT", "Please initialize LeanplumCT before using it.");
        }
        return wrapper;
    }

    @JvmStatic
    public static final String getPurchaseEventName() {
        return "Purchase";
    }

    @JvmStatic
    public static final void initWithContext(Context context) {
        if (context != null) {
            wrapper = new CTWrapper(new CleverTapProvider(context));
        }
    }

    @JvmStatic
    public static final void initWithInstance(CleverTapAPI cleverTapInstance) {
        if (cleverTapInstance != null) {
            wrapper = new CTWrapper(new CleverTapProvider(cleverTapInstance));
        }
    }

    @JvmStatic
    public static final void advanceTo(String state) {
        advanceTo(state, null, null);
    }

    @JvmStatic
    public static final void advanceTo(String state, String info2) {
        advanceTo(state, info2, null);
    }

    @JvmStatic
    public static final void advanceTo(String state, Map<String, ? extends Object> params) {
        advanceTo(state, null, params);
    }

    @JvmStatic
    public static final void advanceTo(String state, String info2, Map<String, ? extends Object> params) {
        CTWrapper wrapper2 = INSTANCE.getWrapper();
        if (wrapper2 != null) {
            wrapper2.advanceTo(state, info2, params);
        }
    }

    @JvmStatic
    public static final void setLogLevel(CleverTapAPI.LogLevel logLevel) {
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        CleverTapAPI.setDebugLevel(logLevel);
    }

    @JvmStatic
    public static final void setTrafficSourceInfo(Map<String, String> info2) {
        CTWrapper wrapper2;
        if (info2 == null || (wrapper2 = INSTANCE.getWrapper()) == null) {
            return;
        }
        wrapper2.setTrafficSourceInfo(info2);
    }

    @JvmStatic
    public static final void setUserAttributes(Map<String, ? extends Object> attributes) {
        CTWrapper wrapper2 = INSTANCE.getWrapper();
        if (wrapper2 != null) {
            wrapper2.setUserAttributes(attributes);
        }
    }

    @JvmStatic
    public static final void setUserAttributes(String userId, Map<String, ? extends Object> attributes) {
        if (userId != null) {
            setUserId(userId);
        }
        setUserAttributes(attributes);
    }

    @JvmStatic
    public static final void setUserId(String userId) {
        CTWrapper wrapper2 = INSTANCE.getWrapper();
        if (wrapper2 != null) {
            wrapper2.setUserId(userId);
        }
    }

    @JvmStatic
    public static final void track(String event) {
        track(event, 0.0d, null, null);
    }

    @JvmStatic
    public static final void track(String event, double value) {
        track(event, value, null, null);
    }

    @JvmStatic
    public static final void track(String event, String info2) {
        track(event, 0.0d, info2, null);
    }

    @JvmStatic
    public static final void track(String event, Map<String, ? extends Object> params) {
        track(event, 0.0d, null, params);
    }

    @JvmStatic
    public static final void track(String event, double value, Map<String, ? extends Object> params) {
        track(event, value, null, params);
    }

    @JvmStatic
    public static final void track(String event, double value, String info2) {
        track(event, value, info2, null);
    }

    @JvmStatic
    public static final void track(String event, double value, String info2, Map<String, ? extends Object> params) {
        CTWrapper wrapper2 = INSTANCE.getWrapper();
        if (wrapper2 != null) {
            wrapper2.track(event, value, info2, params);
        }
    }

    @JvmStatic
    public static final void trackGooglePlayPurchase(String item, long priceMicros, String currencyCode, String purchaseData, String dataSignature) {
        trackGooglePlayPurchase(getPurchaseEventName(), item, priceMicros, currencyCode, purchaseData, dataSignature, null);
    }

    @JvmStatic
    public static final void trackGooglePlayPurchase(String item, long priceMicros, String currencyCode, String purchaseData, String dataSignature, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
        Intrinsics.checkNotNullParameter(purchaseData, "purchaseData");
        Intrinsics.checkNotNullParameter(dataSignature, "dataSignature");
        trackGooglePlayPurchase(getPurchaseEventName(), item, priceMicros, currencyCode, purchaseData, dataSignature, params);
    }

    @JvmStatic
    public static final void trackGooglePlayPurchase(String eventName, String item, long priceMicros, String currencyCode, String purchaseData, String dataSignature, Map<String, ? extends Object> params) {
        String str = eventName;
        if (str == null || str.length() == 0) {
            Logger.i("LeanplumCT", "Failed to call trackGooglePlayPurchase, event name is null");
            return;
        }
        CTWrapper wrapper2 = INSTANCE.getWrapper();
        if (wrapper2 != null) {
            wrapper2.trackGooglePlayPurchase(eventName, item, priceMicros / 1000000.0d, currencyCode, purchaseData, dataSignature, params);
        }
    }

    @JvmStatic
    public static final void trackPurchase(String event, double value, String currencyCode, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(event, "event");
        CTWrapper wrapper2 = INSTANCE.getWrapper();
        if (wrapper2 != null) {
            wrapper2.trackPurchase(event, value, currencyCode, params);
        }
    }
}
