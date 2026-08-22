package com.google.firebase.storage.network;

import android.net.Uri;
import com.google.firebase.FirebaseApp;
import cz.msebera.android.httpclient.client.methods.HttpPatch;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class UpdateMetadataNetworkRequest extends NetworkRequest {
    private final JSONObject metadata;

    public UpdateMetadataNetworkRequest(Uri uri, FirebaseApp firebaseApp, JSONObject jSONObject) {
        super(uri, firebaseApp);
        this.metadata = jSONObject;
        setCustomHeader("X-HTTP-Method-Override", HttpPatch.METHOD_NAME);
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected String getAction() {
        return "PUT";
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected JSONObject getOutputJSON() {
        return this.metadata;
    }
}
