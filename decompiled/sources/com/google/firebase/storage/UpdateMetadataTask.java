package com.google.firebase.storage;

import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.UpdateMetadataNetworkRequest;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
class UpdateMetadataTask implements Runnable {
    private static final String TAG = "UpdateMetadataTask";
    private final StorageMetadata mNewMetadata;
    private final TaskCompletionSource<StorageMetadata> mPendingResult;
    private StorageMetadata mResultMetadata = null;
    private ExponentialBackoffSender mSender;
    private final StorageReference mStorageRef;

    public UpdateMetadataTask(StorageReference storageReference, TaskCompletionSource<StorageMetadata> taskCompletionSource, StorageMetadata storageMetadata) {
        this.mStorageRef = storageReference;
        this.mPendingResult = taskCompletionSource;
        this.mNewMetadata = storageMetadata;
        FirebaseStorage storage = storageReference.getStorage();
        this.mSender = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), storage.getAuthProvider(), storage.getMaxOperationRetryTimeMillis());
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateMetadataNetworkRequest updateMetadataNetworkRequest = new UpdateMetadataNetworkRequest(this.mStorageRef.getStorageUri(), this.mStorageRef.getApp(), this.mNewMetadata.createJSONObject());
        this.mSender.sendWithExponentialBackoff(updateMetadataNetworkRequest);
        if (updateMetadataNetworkRequest.isResultSuccess()) {
            try {
                this.mResultMetadata = new StorageMetadata.Builder(updateMetadataNetworkRequest.getResultBody(), this.mStorageRef).build();
            } catch (JSONException e2) {
                Log.e(TAG, "Unable to parse a valid JSON object from resulting metadata:" + updateMetadataNetworkRequest.getRawResult(), e2);
                this.mPendingResult.setException(StorageException.fromException(e2));
                return;
            }
        }
        TaskCompletionSource<StorageMetadata> taskCompletionSource = this.mPendingResult;
        if (taskCompletionSource != null) {
            updateMetadataNetworkRequest.completeTask(taskCompletionSource, this.mResultMetadata);
        }
    }
}
