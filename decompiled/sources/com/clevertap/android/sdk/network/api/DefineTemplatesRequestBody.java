package com.clevertap.android.sdk.network.api;

import com.clevertap.android.sdk.inapp.customtemplates.CustomTemplate;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: DefineTemplatesRequestBody.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/clevertap/android/sdk/network/api/DefineTemplatesRequestBody;", "", "header", "Lorg/json/JSONObject;", "templates", "", "Lcom/clevertap/android/sdk/inapp/customtemplates/CustomTemplate;", "<init>", "(Lorg/json/JSONObject;Ljava/util/Collection;)V", "jsonArray", "Lorg/json/JSONArray;", "getJsonArray", "()Lorg/json/JSONArray;", InAppPurchaseConstants.METHOD_TO_STRING, "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefineTemplatesRequestBody {
    private final JSONArray jsonArray;

    public DefineTemplatesRequestBody(JSONObject header, Collection<CustomTemplate> templates) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(templates, "templates");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(header);
        jSONArray.put(DefineTemplatesRequestBodyKt.toJSON(templates));
        this.jsonArray = jSONArray;
    }

    public final JSONArray getJsonArray() {
        return this.jsonArray;
    }

    public String toString() {
        String string = this.jsonArray.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
