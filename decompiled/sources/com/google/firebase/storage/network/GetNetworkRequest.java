package com.google.firebase.storage.network;

import android.net.Uri;
import com.google.firebase.FirebaseApp;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class GetNetworkRequest extends NetworkRequest {
    private static final String TAG = "GetNetworkRequest";

    public GetNetworkRequest(Uri uri, FirebaseApp firebaseApp, long j) {
        super(uri, firebaseApp);
        if (j != 0) {
            super.setCustomHeader("Range", "bytes=" + j + "-");
        }
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected String getAction() {
        return "GET";
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected Map<String, String> getQueryParameters() {
        return Collections.singletonMap("alt", "media");
    }
}
