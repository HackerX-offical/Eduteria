package com.clevertap.android.sdk.network;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: compiled from: NetworkHeadersListener.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/clevertap/android/sdk/network/NetworkHeadersListener;", "", "onAttachHeaders", "Lorg/json/JSONObject;", "endpointId", "Lcom/clevertap/android/sdk/network/EndpointId;", "onSentHeaders", "", "allHeaders", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface NetworkHeadersListener {
    JSONObject onAttachHeaders(EndpointId endpointId);

    void onSentHeaders(JSONObject allHeaders, EndpointId endpointId);
}
