package com.google.firebase.storage.network;

import android.net.Uri;
import com.appnew.android.DownloadServices.VideoDownloadService;
import com.google.firebase.FirebaseApp;
import cz.msebera.android.httpclient.client.methods.HttpPost;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class ResumableUploadCancelRequest extends ResumableNetworkRequest {
    public static boolean cancelCalled = false;
    private final Uri uploadURL;

    public ResumableUploadCancelRequest(Uri uri, FirebaseApp firebaseApp, Uri uri2) {
        super(uri, firebaseApp);
        cancelCalled = true;
        this.uploadURL = uri2;
        super.setCustomHeader("X-Goog-Upload-Protocol", "resumable");
        super.setCustomHeader("X-Goog-Upload-Command", VideoDownloadService.CANCEL);
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
