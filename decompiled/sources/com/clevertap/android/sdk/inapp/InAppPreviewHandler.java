package com.clevertap.android.sdk.inapp;

import android.content.Context;
import android.os.Bundle;
import com.clevertap.android.sdk.CTXtensions;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.ILogger;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.network.NetworkManager;
import com.clevertap.android.sdk.response.InAppResponse;
import com.clevertap.android.sdk.task.CTExecutors;
import com.clevertap.android.sdk.task.Task;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: InAppPreviewHandler.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/clevertap/android/sdk/inapp/InAppPreviewHandler;", "", "executors", "Lcom/clevertap/android/sdk/task/CTExecutors;", "networkManager", "Lcom/clevertap/android/sdk/network/NetworkManager;", "inAppResponse", "Lcom/clevertap/android/sdk/response/InAppResponse;", "context", "Landroid/content/Context;", "logger", "Lcom/clevertap/android/sdk/ILogger;", "<init>", "(Lcom/clevertap/android/sdk/task/CTExecutors;Lcom/clevertap/android/sdk/network/NetworkManager;Lcom/clevertap/android/sdk/response/InAppResponse;Landroid/content/Context;Lcom/clevertap/android/sdk/ILogger;)V", "handleInAppPreview", "", "extras", "Landroid/os/Bundle;", "getPreviewPayload", "Lorg/json/JSONObject;", "shouldUseHalfInterstitial", "", "getHalfInterstitialInApp", "inapp", "wrapImageInterstitialContent", "", "content", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InAppPreviewHandler {
    private final Context context;
    private final CTExecutors executors;
    private final InAppResponse inAppResponse;
    private final ILogger logger;
    private final NetworkManager networkManager;

    public InAppPreviewHandler(CTExecutors executors, NetworkManager networkManager, InAppResponse inAppResponse, Context context, ILogger logger) {
        Intrinsics.checkNotNullParameter(executors, "executors");
        Intrinsics.checkNotNullParameter(networkManager, "networkManager");
        Intrinsics.checkNotNullParameter(inAppResponse, "inAppResponse");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.executors = executors;
        this.networkManager = networkManager;
        this.inAppResponse = inAppResponse;
        this.context = context;
        this.logger = logger;
    }

    public final void handleInAppPreview(final Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Task taskPostAsyncSafelyTask = this.executors.postAsyncSafelyTask();
        Intrinsics.checkNotNullExpressionValue(taskPostAsyncSafelyTask, "postAsyncSafelyTask(...)");
        taskPostAsyncSafelyTask.execute("testInappNotification", new Callable() { // from class: com.clevertap.android.sdk.inapp.InAppPreviewHandler$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return InAppPreviewHandler.handleInAppPreview$lambda$2(this.f$0, extras);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleInAppPreview$lambda$2(InAppPreviewHandler this$0, Bundle extras) {
        JSONObject previewPayload;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(extras, "$extras");
        try {
            previewPayload = this$0.getPreviewPayload(extras);
        } catch (Throwable th) {
            this$0.logger.verbose("Failed to display inapp notification from push notification payload", th);
        }
        if (previewPayload == null) {
            return Unit.INSTANCE;
        }
        JSONArray jSONArray = new JSONArray();
        if (!this$0.shouldUseHalfInterstitial(extras) || (previewPayload = this$0.getHalfInterstitialInApp(previewPayload)) != null) {
            JSONArray jSONArrayPut = jSONArray.put(previewPayload);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.INAPP_JSON_RESPONSE_KEY, jSONArrayPut);
            this$0.inAppResponse.processResponse(jSONObject, null, this$0.context);
            return Unit.INSTANCE;
        }
        this$0.logger.debug("Failed to parse the image-interstitial notification. Aborting preview display");
        return Unit.INSTANCE;
    }

    private final JSONObject getPreviewPayload(Bundle extras) {
        JSONObject jSONObjectFetchInAppPreviewPayloadFromUrl;
        String string = extras.getString(Constants.INAPP_PREVIEW_S3_URL_KEY);
        if (CTXtensions.isNotNullAndBlank(string) && (jSONObjectFetchInAppPreviewPayloadFromUrl = this.networkManager.fetchInAppPreviewPayloadFromUrl(string)) != null) {
            return jSONObjectFetchInAppPreviewPayloadFromUrl;
        }
        String string2 = extras.getString(Constants.INAPP_PREVIEW_PUSH_PAYLOAD_KEY);
        if (string2 != null) {
            return new JSONObject(string2);
        }
        return null;
    }

    private final boolean shouldUseHalfInterstitial(Bundle extras) {
        String string = extras.getString(Constants.INAPP_PREVIEW_PUSH_PAYLOAD_TYPE_KEY);
        return Intrinsics.areEqual(string, Constants.INAPP_IMAGE_INTERSTITIAL_TYPE) || Intrinsics.areEqual(string, Constants.INAPP_ADVANCED_BUILDER_TYPE);
    }

    private final JSONObject getHalfInterstitialInApp(JSONObject inapp) throws JSONException {
        String strOptString = inapp.optString(Constants.INAPP_IMAGE_INTERSTITIAL_CONFIG);
        Intrinsics.checkNotNull(strOptString);
        String strWrapImageInterstitialContent = wrapImageInterstitialContent(strOptString);
        if (strWrapImageInterstitialContent == null) {
            this.logger.debug("Failed to parse the image-interstitial notification");
            return null;
        }
        inapp.put("type", Constants.KEY_CUSTOM_HTML);
        Object objOpt = inapp.opt("d");
        JSONObject jSONObject = objOpt instanceof JSONObject ? new JSONObject(((JSONObject) objOpt).toString()) : new JSONObject();
        jSONObject.put("html", strWrapImageInterstitialContent);
        inapp.put("d", jSONObject);
        return inapp;
    }

    private final String wrapImageInterstitialContent(String content) {
        if (StringsKt.isBlank(content)) {
            return null;
        }
        try {
            String assetFile = Utils.readAssetFile(this.context, Constants.INAPP_IMAGE_INTERSTITIAL_HTML_NAME);
            if (assetFile == null) {
                return null;
            }
            List listSplit$default = StringsKt.split$default((CharSequence) assetFile, new String[]{Constants.INAPP_HTML_SPLIT}, false, 0, 6, (Object) null);
            if (listSplit$default.size() == 2) {
                return ((String) listSplit$default.get(0)) + content + ((String) listSplit$default.get(1));
            }
            return null;
        } catch (IOException e2) {
            this.logger.debug("Failed to read the image-interstitial HTML file", e2);
            return null;
        }
    }
}
