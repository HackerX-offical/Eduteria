package com.google.firebase.storage.network;

import android.net.Uri;
import com.google.firebase.FirebaseApp;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class GetMetadataNetworkRequest extends NetworkRequest {
    public GetMetadataNetworkRequest(Uri uri, FirebaseApp firebaseApp) {
        super(uri, firebaseApp);
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected String getAction() {
        return "GET";
    }
}
