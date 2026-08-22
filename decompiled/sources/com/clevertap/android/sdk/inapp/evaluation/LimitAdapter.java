package com.clevertap.android.sdk.inapp.evaluation;

import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.inapp.evaluation.LimitType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: LimitAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0003R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/clevertap/android/sdk/inapp/evaluation/LimitAdapter;", "", "limitJSON", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "limitType", "Lcom/clevertap/android/sdk/inapp/evaluation/LimitType;", "getLimitType", "()Lcom/clevertap/android/sdk/inapp/evaluation/LimitType;", Constants.KEY_LIMIT, "", "getLimit", "()I", Constants.KEY_FREQUENCY, "getFrequency", "toJsonObject", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LimitAdapter {
    private final int frequency;
    private final int limit;
    private final LimitType limitType;

    public LimitAdapter(JSONObject limitJSON) {
        Intrinsics.checkNotNullParameter(limitJSON, "limitJSON");
        LimitType.Companion companion = LimitType.INSTANCE;
        String strOptString = limitJSON.optString("type");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        this.limitType = companion.fromString(strOptString);
        this.limit = limitJSON.optInt(Constants.KEY_LIMIT);
        this.frequency = limitJSON.optInt(Constants.KEY_FREQUENCY);
    }

    public final LimitType getLimitType() {
        return this.limitType;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final int getFrequency() {
        return this.frequency;
    }

    public final JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.limitType.toString());
        jSONObject.put(Constants.KEY_LIMIT, this.limit);
        jSONObject.put(Constants.KEY_FREQUENCY, this.frequency);
        return jSONObject;
    }
}
