package com.clevertap.android.sdk.response;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: ClevertapResponseHandler.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/clevertap/android/sdk/response/ClevertapResponseHandler;", "", "context", "Landroid/content/Context;", "responses", "", "Lcom/clevertap/android/sdk/response/CleverTapResponse;", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "getResponses", "()Ljava/util/List;", "handleResponse", "", "isFullResponse", "", "bodyJson", "Lorg/json/JSONObject;", "bodyString", "", "isUserSwitching", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ClevertapResponseHandler {
    private final Context context;
    private final List<CleverTapResponse> responses;

    /* JADX WARN: Multi-variable type inference failed */
    public ClevertapResponseHandler(Context context, List<? extends CleverTapResponse> responses) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(responses, "responses");
        this.context = context;
        this.responses = responses;
    }

    public final Context getContext() {
        return this.context;
    }

    public final List<CleverTapResponse> getResponses() {
        return this.responses;
    }

    public final void handleResponse(boolean isFullResponse, JSONObject bodyJson, String bodyString, boolean isUserSwitching) {
        Intrinsics.checkNotNullParameter(bodyString, "bodyString");
        if (isUserSwitching) {
            List<CleverTapResponse> list = this.responses;
            ArrayList<CleverTapResponse> arrayList = new ArrayList();
            for (Object obj : list) {
                CleverTapResponse cleverTapResponse = (CleverTapResponse) obj;
                if (!(cleverTapResponse instanceof InboxResponse) && !(cleverTapResponse instanceof DisplayUnitResponse) && !(cleverTapResponse instanceof FetchVariablesResponse)) {
                    arrayList.add(obj);
                }
            }
            for (CleverTapResponse cleverTapResponse2 : arrayList) {
                cleverTapResponse2.isFullResponse = isFullResponse;
                if (cleverTapResponse2 instanceof InAppResponse) {
                    ((InAppResponse) cleverTapResponse2).processResponse(bodyJson, bodyString, this.context, true);
                } else {
                    cleverTapResponse2.processResponse(bodyJson, bodyString, this.context);
                }
            }
            return;
        }
        for (CleverTapResponse cleverTapResponse3 : this.responses) {
            cleverTapResponse3.isFullResponse = isFullResponse;
            cleverTapResponse3.processResponse(bodyJson, bodyString, this.context);
        }
    }
}
