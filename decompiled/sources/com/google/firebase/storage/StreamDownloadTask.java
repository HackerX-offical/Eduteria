package com.google.firebase.storage;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.GetNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class StreamDownloadTask extends StorageTask<TaskSnapshot> {
    static final long PREFERRED_CHUNK_SIZE = 262144;
    private static final String TAG = "StreamDownloadTask";
    private long bytesDownloaded;
    private long bytesDownloadedSnapped;
    private String eTagVerification;
    private InputStream inputStream;
    private StreamProcessor processor;
    private NetworkRequest request;
    private ExponentialBackoffSender sender;
    private StorageReference storageRef;
    private volatile Exception exception = null;
    private volatile int resultCode = 0;
    private long totalBytes = -1;

    /* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
    public interface StreamProcessor {
        void doInBackground(TaskSnapshot taskSnapshot, InputStream inputStream) throws IOException;
    }

    private boolean isValidHttpResponseCode(int i) {
        if (i != 308) {
            return i >= 200 && i < 300;
        }
        return true;
    }

    StreamDownloadTask(StorageReference storageReference) {
        this.storageRef = storageReference;
        FirebaseStorage storage = storageReference.getStorage();
        this.sender = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), storage.getAuthProvider(), storage.getMaxDownloadRetryTimeMillis());
    }

    StreamDownloadTask setStreamProcessor(StreamProcessor streamProcessor) {
        Preconditions.checkNotNull(streamProcessor);
        Preconditions.checkState(this.processor == null);
        this.processor = streamProcessor;
        return this;
    }

    @Override // com.google.firebase.storage.StorageTask
    StorageReference getStorage() {
        return this.storageRef;
    }

    long getTotalBytes() {
        return this.totalBytes;
    }

    void recordDownloadedBytes(long j) {
        long j2 = this.bytesDownloaded + j;
        this.bytesDownloaded = j2;
        if (this.bytesDownloadedSnapped + 262144 <= j2) {
            if (getInternalState() == 4) {
                tryChangeState(4, false);
            } else {
                this.bytesDownloadedSnapped = this.bytesDownloaded;
            }
        }
    }

    @Override // com.google.firebase.storage.StorageTask
    protected void schedule() {
        StorageTaskScheduler.getInstance().scheduleDownload(getRunnable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InputStream createDownloadStream() throws Exception {
        String str;
        this.sender.reset();
        NetworkRequest networkRequest = this.request;
        if (networkRequest != null) {
            networkRequest.performRequestEnd();
        }
        GetNetworkRequest getNetworkRequest = new GetNetworkRequest(this.storageRef.getStorageUri(), this.storageRef.getApp(), this.bytesDownloaded);
        this.request = getNetworkRequest;
        this.sender.sendWithExponentialBackoff(getNetworkRequest, false);
        this.resultCode = this.request.getResultCode();
        this.exception = this.request.getException() != null ? this.request.getException() : this.exception;
        if (isValidHttpResponseCode(this.resultCode) && this.exception == null && getInternalState() == 4) {
            String resultString = this.request.getResultString("ETag");
            if (!TextUtils.isEmpty(resultString) && (str = this.eTagVerification) != null && !str.equals(resultString)) {
                this.resultCode = 409;
                throw new IOException("The ETag on the server changed.");
            }
            this.eTagVerification = resultString;
            if (this.totalBytes == -1) {
                this.totalBytes = this.request.getResultingContentLength();
            }
            return this.request.getStream();
        }
        throw new IOException("Could not open resulting stream.");
    }

    @Override // com.google.firebase.storage.StorageTask
    void run() {
        if (this.exception != null) {
            tryChangeState(64, false);
            return;
        }
        if (tryChangeState(4, false)) {
            StreamProgressWrapper streamProgressWrapper = new StreamProgressWrapper(new Callable<InputStream>() { // from class: com.google.firebase.storage.StreamDownloadTask.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public InputStream call() throws Exception {
                    return StreamDownloadTask.this.createDownloadStream();
                }
            }, this);
            this.inputStream = new BufferedInputStream(streamProgressWrapper);
            try {
                streamProgressWrapper.ensureStream();
                StreamProcessor streamProcessor = this.processor;
                if (streamProcessor != null) {
                    try {
                        streamProcessor.doInBackground(snapState(), this.inputStream);
                    } catch (Exception e2) {
                        Log.w(TAG, "Exception occurred calling doInBackground.", e2);
                        this.exception = e2;
                    }
                }
            } catch (IOException e3) {
                Log.d(TAG, "Initial opening of Stream failed", e3);
                this.exception = e3;
            }
            if (this.inputStream == null) {
                this.request.performRequestEnd();
                this.request = null;
            }
            if (this.exception == null && getInternalState() == 4) {
                tryChangeState(4, false);
                tryChangeState(128, false);
            } else {
                if (tryChangeState(getInternalState() == 32 ? 256 : 64, false)) {
                    return;
                }
                Log.w(TAG, "Unable to change download task to final state from " + getInternalState());
            }
        }
    }

    @Override // com.google.firebase.storage.StorageTask, com.google.firebase.storage.ControllableTask
    public boolean resume() {
        throw new UnsupportedOperationException("this operation is not supported on StreamDownloadTask.");
    }

    @Override // com.google.firebase.storage.StorageTask, com.google.firebase.storage.ControllableTask
    public boolean pause() {
        throw new UnsupportedOperationException("this operation is not supported on StreamDownloadTask.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.storage.StorageTask
    public TaskSnapshot snapStateImpl() {
        return new TaskSnapshot(StorageException.fromExceptionAndHttpCode(this.exception, this.resultCode), this.bytesDownloadedSnapped);
    }

    @Override // com.google.firebase.storage.StorageTask
    protected void onCanceled() {
        this.sender.cancel();
        this.exception = StorageException.fromErrorStatus(Status.RESULT_CANCELED);
    }

    @Override // com.google.firebase.storage.StorageTask
    protected void onProgress() {
        this.bytesDownloadedSnapped = this.bytesDownloaded;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
    static class StreamProgressWrapper extends InputStream {
        private long mDownloadedBytes;
        private Callable<InputStream> mInputStreamCallable;
        private long mLastExceptionPosition;
        private StreamDownloadTask mParentTask;
        private boolean mStreamClosed;
        private IOException mTemporaryException;
        private InputStream mWrappedStream;

        @Override // java.io.InputStream
        public void mark(int i) {
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        StreamProgressWrapper(Callable<InputStream> callable, StreamDownloadTask streamDownloadTask) {
            this.mParentTask = streamDownloadTask;
            this.mInputStreamCallable = callable;
        }

        private void checkCancel() throws IOException {
            StreamDownloadTask streamDownloadTask = this.mParentTask;
            if (streamDownloadTask != null && streamDownloadTask.getInternalState() == 32) {
                throw new CancelException();
            }
        }

        private void recordDownloadedBytes(long j) {
            StreamDownloadTask streamDownloadTask = this.mParentTask;
            if (streamDownloadTask != null) {
                streamDownloadTask.recordDownloadedBytes(j);
            }
            this.mDownloadedBytes += j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean ensureStream() throws IOException {
            checkCancel();
            if (this.mTemporaryException != null) {
                try {
                    InputStream inputStream = this.mWrappedStream;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException unused) {
                }
                this.mWrappedStream = null;
                if (this.mLastExceptionPosition == this.mDownloadedBytes) {
                    Log.i(StreamDownloadTask.TAG, "Encountered exception during stream operation. Aborting.", this.mTemporaryException);
                    return false;
                }
                Log.i(StreamDownloadTask.TAG, "Encountered exception during stream operation. Retrying at " + this.mDownloadedBytes, this.mTemporaryException);
                this.mLastExceptionPosition = this.mDownloadedBytes;
                this.mTemporaryException = null;
            }
            if (this.mStreamClosed) {
                throw new IOException("Can't perform operation on closed stream");
            }
            if (this.mWrappedStream != null) {
                return true;
            }
            try {
                this.mWrappedStream = this.mInputStreamCallable.call();
                return true;
            } catch (Exception e2) {
                if (e2 instanceof IOException) {
                    throw ((IOException) e2);
                }
                throw new IOException("Unable to open stream", e2);
            }
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            while (ensureStream()) {
                try {
                    int i = this.mWrappedStream.read();
                    if (i != -1) {
                        recordDownloadedBytes(1L);
                    }
                    return i;
                } catch (IOException e2) {
                    this.mTemporaryException = e2;
                }
            }
            throw this.mTemporaryException;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            while (ensureStream()) {
                try {
                    return this.mWrappedStream.available();
                } catch (IOException e2) {
                    this.mTemporaryException = e2;
                }
            }
            throw this.mTemporaryException;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            InputStream inputStream = this.mWrappedStream;
            if (inputStream != null) {
                inputStream.close();
            }
            this.mStreamClosed = true;
            StreamDownloadTask streamDownloadTask = this.mParentTask;
            if (streamDownloadTask != null && streamDownloadTask.request != null) {
                this.mParentTask.request.performRequestEnd();
                this.mParentTask.request = null;
            }
            checkCancel();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (ensureStream()) {
                while (i2 > 262144) {
                    try {
                        int i4 = this.mWrappedStream.read(bArr, i, 262144);
                        if (i4 == -1) {
                            if (i3 == 0) {
                                return -1;
                            }
                            return i3;
                        }
                        i3 += i4;
                        i += i4;
                        i2 -= i4;
                        recordDownloadedBytes(i4);
                        checkCancel();
                    } catch (IOException e2) {
                        this.mTemporaryException = e2;
                    }
                }
                if (i2 > 0) {
                    int i5 = this.mWrappedStream.read(bArr, i, i2);
                    if (i5 == -1) {
                        if (i3 == 0) {
                            return -1;
                        }
                        return i3;
                    }
                    i += i5;
                    i3 += i5;
                    i2 -= i5;
                    recordDownloadedBytes(i5);
                }
                if (i2 == 0) {
                    return i3;
                }
            }
            throw this.mTemporaryException;
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            long j2 = 0;
            while (ensureStream()) {
                while (j > 262144) {
                    try {
                        long jSkip = this.mWrappedStream.skip(262144L);
                        if (jSkip < 0) {
                            if (j2 == 0) {
                                return -1L;
                            }
                            return j2;
                        }
                        j2 += jSkip;
                        j -= jSkip;
                        recordDownloadedBytes(jSkip);
                        checkCancel();
                    } catch (IOException e2) {
                        this.mTemporaryException = e2;
                    }
                }
                if (j > 0) {
                    long jSkip2 = this.mWrappedStream.skip(j);
                    if (jSkip2 < 0) {
                        if (j2 == 0) {
                            return -1L;
                        }
                        return j2;
                    }
                    j2 += jSkip2;
                    j -= jSkip2;
                    recordDownloadedBytes(jSkip2);
                }
                if (j == 0) {
                    return j2;
                }
            }
            throw this.mTemporaryException;
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
    public class TaskSnapshot extends StorageTask<TaskSnapshot>.SnapshotBase {
        private final long mBytesDownloaded;

        TaskSnapshot(Exception exc, long j) {
            super(exc);
            this.mBytesDownloaded = j;
        }

        public long getBytesTransferred() {
            return this.mBytesDownloaded;
        }

        public long getTotalByteCount() {
            return StreamDownloadTask.this.getTotalBytes();
        }

        public InputStream getStream() {
            return StreamDownloadTask.this.inputStream;
        }
    }
}
