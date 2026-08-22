package com.clevertap.android.sdk;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface SyncListener {
    void profileDataUpdated(JSONObject jSONObject);

    void profileDidInitialize(String str);
}
