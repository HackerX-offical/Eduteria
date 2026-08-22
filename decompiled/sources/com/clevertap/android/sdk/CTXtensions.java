package com.clevertap.android.sdk;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import com.clevertap.android.sdk.events.EventGroup;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CTXtensions.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0002\u001a*\u0010\f\u001a\u0004\u0018\u00010\n*\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0001H\u0007\u001a(\u0010\u0011\u001a\u0004\u0018\u00010\n*\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\nH\u0003\u001a\u001c\u0010\u0013\u001a\u00020\n*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0003\u001a\f\u0010\u0014\u001a\u00020\n*\u00020\rH\u0003\u001a\u0014\u0010\u0015\u001a\u00020\n*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0003\u001a$\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0002H\u0007\u001a\u0014\u0010\u001b\u001a\u00020\u0001*\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0004\u001a\n\u0010\u001e\u001a\u00020\u0001*\u00020\u001f\u001a\f\u0010 \u001a\u00020\u001c*\u0004\u0018\u00010\u001c\u001a\u001b\u0010!\u001a\b\u0012\u0004\u0012\u0002H#0\"\"\u0006\b\u0000\u0010#\u0018\u0001*\u00020\u001cH\u0086\b\u001a;\u0010$\u001a\u00020\u0017\"\u0006\b\u0000\u0010#\u0018\u0001*\u00020\u001c2!\u0010%\u001a\u001d\u0012\u0013\u0012\u0011H#¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00170&H\u0086\bø\u0001\u0000\u001a \u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u001c0+*\u00020,2\u0006\u0010-\u001a\u00020\n\u001a \u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u001c0+*\u00020,2\u0006\u0010-\u001a\u00020\n\u001a\u0012\u0010/\u001a\u00020\u0017*\u00020,2\u0006\u00100\u001a\u00020,\u001a\n\u00101\u001a\u00020,*\u00020,\u001a\f\u00102\u001a\u00020\u0001*\u0004\u0018\u00010,\u001a\"\u00103\u001a\u0004\u0018\u00010\n*\u0004\u0018\u00010\n2\b\u00100\u001a\u0004\u0018\u00010\n2\b\b\u0002\u00104\u001a\u00020\n\u001a\n\u00105\u001a\u00020\u0001*\u000206\u001a\u000e\u00107\u001a\u0004\u0018\u00010,*\u0004\u0018\u00010\n\u001a\u001d\u00108\u001a\u00020\u0001*\u0004\u0018\u00010\n\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0000\u001a\u0004\b\u0003\u0010\u0000\u001aB\u00109\u001a\u00020\u0017*\u00020:26\u0010;\u001a2\u0012\u0013\u0012\u00110=¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(>\u0012\u0013\u0012\u00110?¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\u00170<\u001a8\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0+\"\u0006\b\u0000\u0010#\u0018\u0001*\u00020\u001c2\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00010&H\u0086\bø\u0001\u0000\"\u0015\u0010\u0005\u001a\u00020\u0004*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006C"}, d2 = {"isPackageAndOsTargetsAbove", "", "Landroid/content/Context;", "apiLevel", "", "targetSdkVersion", "getTargetSdkVersion", "(Landroid/content/Context;)I", "isNotificationChannelEnabled", "channelId", "", "areAppNotificationsEnabled", "getOrCreateChannel", "Landroid/app/NotificationManager;", "msgChannel", "context", "hideHeadsUp", "tryGetChannel", "channelSource", "createFallbackChannel", "createLowImportanceFallback", "createDefaultFallbackChannel", "flushPushImpressionsOnPostAsyncSafely", "", "Lcom/clevertap/android/sdk/CleverTapAPI;", "logTag", "caller", "isInvalidIndex", "Lorg/json/JSONArray;", FirebaseAnalytics.Param.INDEX, "hasData", "Landroid/content/SharedPreferences;", "orEmptyArray", "toList", "", ExifInterface.GPS_DIRECTION_TRUE, "iterator", "foreach", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "element", "safeGetJSONArrayOrNullIfEmpty", "Lkotlin/Pair;", "Lorg/json/JSONObject;", "key", "safeGetJSONArray", "copyFrom", "other", Constants.COPY_TYPE, "isNotNullAndEmpty", "concatIfNotNull", "separator", "isValid", "Landroid/location/Location;", "toJsonOrNull", "isNotNullAndBlank", "applyInsetsWithMarginAdjustment", "Landroid/view/View;", "marginAdjuster", "Lkotlin/Function2;", "Landroidx/core/graphics/Insets;", "insets", "Landroid/view/ViewGroup$MarginLayoutParams;", "mlp", "partition", "predicate", "clevertap-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CTXtensions {
    public static final boolean isPackageAndOsTargetsAbove(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return Build.VERSION.SDK_INT > i && getTargetSdkVersion(context) > i;
    }

    public static final int getTargetSdkVersion(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getApplicationContext().getApplicationInfo().targetSdkVersion;
    }

    public static final boolean isNotificationChannelEnabled(Context context, String channelId) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (!areAppNotificationsEnabled(context)) {
            return false;
        }
        try {
            Object systemService = context.getSystemService("notification");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            return ((NotificationManager) systemService).getNotificationChannel(channelId).getImportance() != 0;
        } catch (Exception unused) {
            Logger.d("Unable to find notification channel with id = " + channelId);
            return false;
        }
    }

    public static final boolean areAppNotificationsEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            return NotificationManagerCompat.from(context).areNotificationsEnabled();
        } catch (Exception e2) {
            Logger.d("Unable to query notifications enabled flag, returning true!");
            e2.printStackTrace();
            return true;
        }
    }

    public static /* synthetic */ String getOrCreateChannel$default(NotificationManager notificationManager, String str, Context context, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return getOrCreateChannel(notificationManager, str, context, z);
    }

    public static final String getOrCreateChannel(NotificationManager notificationManager, String str, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(notificationManager, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            String strTryGetChannel = tryGetChannel(notificationManager, str, z, "Payload");
            if (strTryGetChannel != null) {
                return strTryGetChannel;
            }
            String strTryGetChannel2 = tryGetChannel(notificationManager, ManifestInfo.getInstance(context).getDevDefaultPushChannelId(), z, "Manifest");
            return strTryGetChannel2 != null ? strTryGetChannel2 : createFallbackChannel(notificationManager, context, z);
        } catch (Exception e2) {
            Logger.v(Constants.CLEVERTAP_LOG_TAG, "Error getting or creating notification channel", e2);
            return null;
        }
    }

    private static final String tryGetChannel(NotificationManager notificationManager, String str, boolean z, String str2) {
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            Logger.d(Constants.CLEVERTAP_LOG_TAG, "channelID from " + str2 + " is null or empty");
            return null;
        }
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
        if (notificationChannel == null) {
            return null;
        }
        if (!z || notificationChannel.getImportance() == 2) {
            return str;
        }
        Logger.d(Constants.CLEVERTAP_LOG_TAG, "Skipping channel " + str + " because heads-up should be hidden in FG but importance is " + notificationChannel.getImportance());
        return null;
    }

    private static final String createFallbackChannel(NotificationManager notificationManager, Context context, boolean z) {
        if (z) {
            return createLowImportanceFallback(notificationManager);
        }
        return createDefaultFallbackChannel(notificationManager, context);
    }

    private static final String createLowImportanceFallback(NotificationManager notificationManager) {
        if (notificationManager.getNotificationChannel(Constants.CT_FALLBACK_NOTIFICATION_CHANNEL_ID_LOW) != null) {
            return Constants.CT_FALLBACK_NOTIFICATION_CHANNEL_ID_LOW;
        }
        notificationManager.createNotificationChannel(new NotificationChannel(Constants.CT_FALLBACK_NOTIFICATION_CHANNEL_ID_LOW, Constants.LOW_IMPORTANCE_FALLBACK_NOTIFICATION_CHANNEL_NAME, 2));
        Logger.d(Constants.CLEVERTAP_LOG_TAG, "Created low importance fallback channel: ct_fallback_notification_channel_low_importance");
        return Constants.CT_FALLBACK_NOTIFICATION_CHANNEL_ID_LOW;
    }

    private static final String createDefaultFallbackChannel(NotificationManager notificationManager, Context context) {
        String string;
        if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
            try {
                string = context.getString(R.string.ct_fcm_fallback_notification_channel_label);
            } catch (Exception unused) {
                string = Constants.FCM_FALLBACK_NOTIFICATION_CHANNEL_NAME;
            }
            Intrinsics.checkNotNull(string);
            notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", string, 3));
            Logger.d(Constants.CLEVERTAP_LOG_TAG, "Created default fallback channel: fcm_fallback_notification_channel");
        }
        return "fcm_fallback_notification_channel";
    }

    public static final void flushPushImpressionsOnPostAsyncSafely(final CleverTapAPI cleverTapAPI, final String logTag, final String caller, final Context context) {
        Intrinsics.checkNotNullParameter(cleverTapAPI, "<this>");
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        Intrinsics.checkNotNullParameter(caller, "caller");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            CTExecutorFactory.executors(cleverTapAPI.getCoreState().getConfig()).postAsyncSafelyTask().submit(logTag, new Callable() { // from class: com.clevertap.android.sdk.CTXtensions$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return CTXtensions.flushPushImpressionsOnPostAsyncSafely$lambda$2(cleverTapAPI, context, caller, logTag);
                }
            }).get();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void flushPushImpressionsOnPostAsyncSafely$lambda$2(CleverTapAPI this_flushPushImpressionsOnPostAsyncSafely, Context context, String caller, String logTag) {
        Intrinsics.checkNotNullParameter(this_flushPushImpressionsOnPostAsyncSafely, "$this_flushPushImpressionsOnPostAsyncSafely");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(caller, "$caller");
        Intrinsics.checkNotNullParameter(logTag, "$logTag");
        try {
            this_flushPushImpressionsOnPostAsyncSafely.getCoreState().getBaseEventQueueManager().flushQueueSync(context, EventGroup.PUSH_NOTIFICATION_VIEWED, caller);
            return null;
        } catch (Exception unused) {
            Logger.d(logTag, "failed to flush push impressions on ct instance = " + this_flushPushImpressionsOnPostAsyncSafely.getCoreState().getConfig().getAccountId());
            return null;
        }
    }

    public static final boolean isInvalidIndex(JSONArray jSONArray, int i) {
        return jSONArray == null || i < 0 || i >= jSONArray.length();
    }

    public static final boolean hasData(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullExpressionValue(sharedPreferences.getAll(), "getAll(...)");
        return !r1.isEmpty();
    }

    public static final JSONArray orEmptyArray(JSONArray jSONArray) {
        return jSONArray == null ? new JSONArray() : jSONArray;
    }

    public static final /* synthetic */ <T> List<T> toList(JSONArray jSONArray) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = jSONArray.get(i);
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (obj instanceof Object) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final /* synthetic */ <T> void iterator(JSONArray jSONArray, Function1<? super T, Unit> foreach) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        Intrinsics.checkNotNullParameter(foreach, "foreach");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = jSONArray.get(i);
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (obj instanceof Object) {
                foreach.invoke(obj);
            }
        }
    }

    public static final Pair<Boolean, JSONArray> safeGetJSONArrayOrNullIfEmpty(JSONObject jSONObject, String key) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(key);
        if (jSONArrayOptJSONArray == null) {
            return new Pair<>(false, null);
        }
        Boolean boolValueOf = Boolean.valueOf(jSONArrayOptJSONArray.length() > 0);
        if (jSONArrayOptJSONArray.length() <= 0) {
            jSONArrayOptJSONArray = null;
        }
        return new Pair<>(boolValueOf, jSONArrayOptJSONArray);
    }

    public static final Pair<Boolean, JSONArray> safeGetJSONArray(JSONObject jSONObject, String key) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(key);
        if (jSONArrayOptJSONArray == null) {
            return new Pair<>(false, null);
        }
        Boolean boolValueOf = Boolean.valueOf(jSONArrayOptJSONArray.length() >= 0);
        if (jSONArrayOptJSONArray.length() < 0) {
            jSONArrayOptJSONArray = null;
        }
        return new Pair<>(boolValueOf, jSONArrayOptJSONArray);
    }

    public static final void copyFrom(JSONObject jSONObject, JSONObject other) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Iterator<String> itKeys = other.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            jSONObject.put(next, other.opt(next));
        }
    }

    public static final JSONObject copy(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        JSONObject jSONObject2 = new JSONObject();
        copyFrom(jSONObject2, jSONObject);
        return jSONObject2;
    }

    public static final boolean isNotNullAndEmpty(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }

    public static /* synthetic */ String concatIfNotNull$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = "";
        }
        return concatIfNotNull(str, str2, str3);
    }

    public static final String concatIfNotNull(String str, String str2, String separator) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        if (str == null || str2 == null) {
            return str == null ? str2 : str;
        }
        return str + separator + str2;
    }

    public static final boolean isValid(Location location) {
        Intrinsics.checkNotNullParameter(location, "<this>");
        double latitude = location.getLatitude();
        if (-90.0d > latitude || latitude > 90.0d) {
            return false;
        }
        double longitude = location.getLongitude();
        return -180.0d <= longitude && longitude <= 180.0d;
    }

    public static final JSONObject toJsonOrNull(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static final boolean isNotNullAndBlank(String str) {
        String str2 = str;
        return !(str2 == null || StringsKt.isBlank(str2));
    }

    public static final void applyInsetsWithMarginAdjustment(View view, final Function2<? super Insets, ? super ViewGroup.MarginLayoutParams, Unit> marginAdjuster) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(marginAdjuster, "marginAdjuster");
        ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: com.clevertap.android.sdk.CTXtensions$$ExternalSyntheticLambda1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                return CTXtensions.applyInsetsWithMarginAdjustment$lambda$7(marginAdjuster, view2, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat applyInsetsWithMarginAdjustment$lambda$7(Function2 marginAdjuster, View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(marginAdjuster, "$marginAdjuster");
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginAdjuster.invoke(insets2, marginLayoutParams);
            v.setLayoutParams(marginLayoutParams);
            return WindowInsetsCompat.CONSUMED;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public static final /* synthetic */ <T> Pair<JSONArray, JSONArray> partition(JSONArray jSONArray, Function1<? super T, Boolean> predicate) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = jSONArray.get(i);
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (obj instanceof Object) {
                if (predicate.invoke(obj).booleanValue()) {
                    jSONArray2.put(obj);
                } else {
                    jSONArray3.put(obj);
                }
            }
        }
        return TuplesKt.to(jSONArray2, jSONArray3);
    }
}
