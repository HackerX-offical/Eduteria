package com.google.firebase.storage.network;

import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.FirebaseApp;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class ResumableUploadStartRequest extends ResumableNetworkRequest {
    private final String contentType;
    private final JSONObject metadata;

    public ResumableUploadStartRequest(Uri uri, FirebaseApp firebaseApp, JSONObject jSONObject, String str) {
        super(uri, firebaseApp);
        this.metadata = jSONObject;
        this.contentType = str;
        if (TextUtils.isEmpty(str)) {
            this.mException = new IllegalArgumentException("mContentType is null or empty");
        }
        super.setCustomHeader("X-Goog-Upload-Protocol", "resumable");
        super.setCustomHeader("X-Goog-Upload-Command", "start");
        super.setCustomHeader("X-Goog-Upload-Header-Content-Type", str);
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected Uri getURL() {
        Uri.Builder builderBuildUpon = sNetworkRequestUrl.buildUpon();
        builderBuildUpon.appendPath("b");
        builderBuildUpon.appendPath(this.mGsUri.getAuthority());
        builderBuildUpon.appendPath("o");
        return builderBuildUpon.build();
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected String getAction() {
        return HttpPost.METHOD_NAME;
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected Map<String, String> getQueryParameters() {
        HashMap map = new HashMap();
        map.put("name", getPathWithoutBucket());
        map.put("uploadType", "resumable");
        return map;
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected JSONObject getOutputJSON() {
        return this.metadata;
    }
}
