package com.clevertap.android.sdk.network.api;

import com.clevertap.android.sdk.Constants;
import com.csvreader.CsvReader;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ContentFetchRequestBody.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/clevertap/android/sdk/network/api/ContentFetchRequestBody;", "", "header", "Lorg/json/JSONObject;", FirebaseAnalytics.Param.ITEMS, "Lorg/json/JSONArray;", "<init>", "(Lorg/json/JSONObject;Lorg/json/JSONArray;)V", "getHeader", "()Lorg/json/JSONObject;", "getItems", "()Lorg/json/JSONArray;", InAppPurchaseConstants.METHOD_TO_STRING, "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContentFetchRequestBody {
    private final JSONObject header;
    private final JSONArray items;

    public ContentFetchRequestBody(JSONObject header, JSONArray items) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(items, "items");
        this.header = header;
        this.items = items;
    }

    public final JSONObject getHeader() {
        return this.header;
    }

    public final JSONArray getItems() {
        return this.items;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder(Constants.AES_PREFIX).append(this.header).append(CsvReader.Letters.COMMA);
        String string = this.items.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String strSubstring = string.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return sbAppend.append(strSubstring).toString();
    }
}
