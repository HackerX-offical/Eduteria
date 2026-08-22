package com.clevertap.android.sdk;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface GeofenceCallback {
    void handleGeoFences(JSONObject jSONObject);

    void triggerLocation();
}
