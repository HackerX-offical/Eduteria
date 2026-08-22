package com.google.firebase.storage.network;

import android.net.Uri;
import com.google.firebase.FirebaseApp;
import cz.msebera.android.httpclient.client.methods.HttpPost;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class ResumableUploadQueryRequest extends ResumableNetworkRequest {
    private final Uri uploadURL;

    public ResumableUploadQueryRequest(Uri uri, FirebaseApp firebaseApp, Uri uri2) {
        super(uri, firebaseApp);
        this.uploadURL = uri2;
        super.setCustomHeader("X-Goog-Upload-Protocol", "resumable");
        super.setCustomHeader("X-Goog-Upload-Command", "query");
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected String getAction() {
        return HttpPost.METHOD_NAME;
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected Uri getURL() {
        return this.uploadURL;
    }
}
