package com.google.firebase.storage;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.GetMetadataNetworkRequest;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
class GetMetadataTask implements Runnable {
    private static final String TAG = "GetMetadataTask";
    private TaskCompletionSource<StorageMetadata> mPendingResult;
    private StorageMetadata mResultMetadata;
    private ExponentialBackoffSender mSender;
    private StorageReference mStorageRef;

    GetMetadataTask(StorageReference storageReference, TaskCompletionSource<StorageMetadata> taskCompletionSource) {
        Preconditions.checkNotNull(storageReference);
        Preconditions.checkNotNull(taskCompletionSource);
        this.mStorageRef = storageReference;
        this.mPendingResult = taskCompletionSource;
        if (storageReference.getRoot().getName().equals(storageReference.getName())) {
            throw new IllegalArgumentException("getMetadata() is not supported at the root of the bucket.");
        }
        FirebaseStorage storage = this.mStorageRef.getStorage();
        this.mSender = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), storage.getAuthProvider(), storage.getMaxDownloadRetryTimeMillis());
    }

    @Override // java.lang.Runnable
    public void run() {
        GetMetadataNetworkRequest getMetadataNetworkRequest = new GetMetadataNetworkRequest(this.mStorageRef.getStorageUri(), this.mStorageRef.getApp());
        this.mSender.sendWithExponentialBackoff(getMetadataNetworkRequest);
        if (getMetadataNetworkRequest.isResultSuccess()) {
            try {
                this.mResultMetadata = new StorageMetadata.Builder(getMetadataNetworkRequest.getResultBody(), this.mStorageRef).build();
            } catch (JSONException e2) {
                Log.e(TAG, "Unable to parse resulting metadata. " + getMetadataNetworkRequest.getRawResult(), e2);
                this.mPendingResult.setException(StorageException.fromException(e2));
                return;
            }
        }
        TaskCompletionSource<StorageMetadata> taskCompletionSource = this.mPendingResult;
        if (taskCompletionSource != null) {
            getMetadataNetworkRequest.completeTask(taskCompletionSource, this.mResultMetadata);
        }
    }
}
