package com.razorpay;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: compiled from: GenericPluginCallback.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H&¨\u0006\b"}, d2 = {"Lcom/razorpay/GenericPluginCallback;", "", "onError", "", "error", "Lorg/json/JSONObject;", "onSuccess", "data", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GenericPluginCallback {
    void onError(JSONObject error);

    void onSuccess(Object data);
}
