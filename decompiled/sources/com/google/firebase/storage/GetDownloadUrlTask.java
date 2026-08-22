package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import com.clevertap.android.sdk.Constants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.GetMetadataNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
class GetDownloadUrlTask implements Runnable {
    private static final String DOWNLOAD_TOKENS_KEY = "downloadTokens";
    private static final String TAG = "GetMetadataTask";
    private TaskCompletionSource<Uri> pendingResult;
    private ExponentialBackoffSender sender;
    private StorageReference storageRef;

    GetDownloadUrlTask(StorageReference storageReference, TaskCompletionSource<Uri> taskCompletionSource) {
        Preconditions.checkNotNull(storageReference);
        Preconditions.checkNotNull(taskCompletionSource);
        this.storageRef = storageReference;
        this.pendingResult = taskCompletionSource;
        if (storageReference.getRoot().getName().equals(storageReference.getName())) {
            throw new IllegalArgumentException("getDownloadUrl() is not supported at the root of the bucket.");
        }
        FirebaseStorage storage = this.storageRef.getStorage();
        this.sender = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), storage.getAuthProvider(), storage.getMaxOperationRetryTimeMillis());
    }

    private Uri extractDownloadUrl(JSONObject jSONObject) {
        String strOptString = jSONObject.optString(DOWNLOAD_TOKENS_KEY);
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        String str = strOptString.split(Constants.SEPARATOR_COMMA, -1)[0];
        Uri.Builder builderBuildUpon = NetworkRequest.getDefaultURL(this.storageRef.getStorageUri()).buildUpon();
        builderBuildUpon.appendQueryParameter("alt", "media");
        builderBuildUpon.appendQueryParameter("token", str);
        return builderBuildUpon.build();
    }

    @Override // java.lang.Runnable
    public void run() {
        GetMetadataNetworkRequest getMetadataNetworkRequest = new GetMetadataNetworkRequest(this.storageRef.getStorageUri(), this.storageRef.getApp());
        this.sender.sendWithExponentialBackoff(getMetadataNetworkRequest);
        Uri uriExtractDownloadUrl = getMetadataNetworkRequest.isResultSuccess() ? extractDownloadUrl(getMetadataNetworkRequest.getResultBody()) : null;
        TaskCompletionSource<Uri> taskCompletionSource = this.pendingResult;
        if (taskCompletionSource != null) {
            getMetadataNetworkRequest.completeTask(taskCompletionSource, uriExtractDownloadUrl);
        }
    }
}
