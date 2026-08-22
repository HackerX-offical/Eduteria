package com.clevertap.android.sdk.network;

import kotlin.Metadata;
import org.json.JSONArray;

/* JADX INFO: compiled from: BatchListeners.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/clevertap/android/sdk/network/BatchListener;", "", "onBatchSent", "", "batch", "Lorg/json/JSONArray;", "success", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface BatchListener {
    void onBatchSent(JSONArray batch, boolean success);
}
