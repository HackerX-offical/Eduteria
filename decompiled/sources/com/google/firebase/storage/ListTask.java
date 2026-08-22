package com.google.firebase.storage;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.ListNetworkRequest;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
class ListTask implements Runnable {
    private static final String TAG = "ListTask";
    private final Integer maxResults;
    private final String pageToken;
    private final TaskCompletionSource<ListResult> pendingResult;
    private final ExponentialBackoffSender sender;
    private final StorageReference storageRef;

    ListTask(StorageReference storageReference, Integer num, String str, TaskCompletionSource<ListResult> taskCompletionSource) {
        Preconditions.checkNotNull(storageReference);
        Preconditions.checkNotNull(taskCompletionSource);
        this.storageRef = storageReference;
        this.maxResults = num;
        this.pageToken = str;
        this.pendingResult = taskCompletionSource;
        FirebaseStorage storage = storageReference.getStorage();
        this.sender = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), storage.getAuthProvider(), storage.getMaxDownloadRetryTimeMillis());
    }

    @Override // java.lang.Runnable
    public void run() {
        ListResult listResultFromJSON;
        ListNetworkRequest listNetworkRequest = new ListNetworkRequest(this.storageRef.getStorageUri(), this.storageRef.getApp(), this.maxResults, this.pageToken);
        this.sender.sendWithExponentialBackoff(listNetworkRequest);
        if (listNetworkRequest.isResultSuccess()) {
            try {
                listResultFromJSON = ListResult.fromJSON(this.storageRef.getStorage(), listNetworkRequest.getResultBody());
            } catch (JSONException e2) {
                Log.e(TAG, "Unable to parse response body. " + listNetworkRequest.getRawResult(), e2);
                this.pendingResult.setException(StorageException.fromException(e2));
                return;
            }
        } else {
            listResultFromJSON = null;
        }
        TaskCompletionSource<ListResult> taskCompletionSource = this.pendingResult;
        if (taskCompletionSource != null) {
            listNetworkRequest.completeTask(taskCompletionSource, listResultFromJSON);
        }
    }
}
