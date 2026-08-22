package com.clevertap.android.sdk.network.api;

import com.clevertap.android.sdk.Constants;
import com.csvreader.CsvReader;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SendQueueRequestBody.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/clevertap/android/sdk/network/api/SendQueueRequestBody;", "", "queueHeader", "Lorg/json/JSONObject;", "queue", "Lorg/json/JSONArray;", "<init>", "(Lorg/json/JSONObject;Lorg/json/JSONArray;)V", "getQueueHeader", "()Lorg/json/JSONObject;", "getQueue", "()Lorg/json/JSONArray;", InAppPurchaseConstants.METHOD_TO_STRING, "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SendQueueRequestBody {
    private final JSONArray queue;
    private final JSONObject queueHeader;

    public SendQueueRequestBody(JSONObject jSONObject, JSONArray queue) {
        Intrinsics.checkNotNullParameter(queue, "queue");
        this.queueHeader = jSONObject;
        this.queue = queue;
    }

    public final JSONObject getQueueHeader() {
        return this.queueHeader;
    }

    public final JSONArray getQueue() {
        return this.queue;
    }

    public String toString() {
        if (this.queueHeader == null) {
            String string = this.queue.toString();
            Intrinsics.checkNotNull(string);
            return string;
        }
        StringBuilder sbAppend = new StringBuilder(Constants.AES_PREFIX).append(this.queueHeader).append(CsvReader.Letters.COMMA);
        String string2 = this.queue.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        String strSubstring = string2.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return sbAppend.append(strSubstring).toString();
    }
}
