package com.google.firebase.storage;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.StorageTask.ProvideError;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class StorageTask<ResultT extends ProvideError> extends ControllableTask<ResultT> {
    static final int INTERNAL_STATE_CANCELED = 256;
    static final int INTERNAL_STATE_CANCELING = 32;
    static final int INTERNAL_STATE_FAILURE = 64;
    static final int INTERNAL_STATE_IN_PROGRESS = 4;
    static final int INTERNAL_STATE_NOT_STARTED = 1;
    static final int INTERNAL_STATE_PAUSED = 16;
    static final int INTERNAL_STATE_PAUSING = 8;
    static final int INTERNAL_STATE_QUEUED = 2;
    static final int INTERNAL_STATE_SUCCESS = 128;
    static final int STATES_CANCELED = 256;
    static final int STATES_COMPLETE = 448;
    static final int STATES_FAILURE = 64;
    static final int STATES_INPROGRESS = -465;
    static final int STATES_PAUSED = 16;
    static final int STATES_SUCCESS = 128;
    private static final String TAG = "StorageTask";
    private static final HashMap<Integer, HashSet<Integer>> ValidTaskInitiatedStateChanges;
    private static final HashMap<Integer, HashSet<Integer>> ValidUserInitiatedStateChanges;
    private ResultT finalResult;
    protected final Object syncObject = new Object();
    final TaskListenerImpl<OnSuccessListener<? super ResultT>, ResultT> successManager = new TaskListenerImpl<>(this, 128, StorageTask$$Lambda$1.lambdaFactory$(this));
    final TaskListenerImpl<OnFailureListener, ResultT> failureManager = new TaskListenerImpl<>(this, 64, StorageTask$$Lambda$4.lambdaFactory$(this));
    final TaskListenerImpl<OnCompleteListener<ResultT>, ResultT> completeListener = new TaskListenerImpl<>(this, STATES_COMPLETE, StorageTask$$Lambda$5.lambdaFactory$(this));
    final TaskListenerImpl<OnCanceledListener, ResultT> cancelManager = new TaskListenerImpl<>(this, 256, StorageTask$$Lambda$6.lambdaFactory$(this));
    final TaskListenerImpl<OnProgressListener<? super ResultT>, ResultT> progressManager = new TaskListenerImpl<>(this, STATES_INPROGRESS, StorageTask$$Lambda$7.instance);
    final TaskListenerImpl<OnPausedListener<? super ResultT>, ResultT> pausedManager = new TaskListenerImpl<>(this, 16, StorageTask$$Lambda$8.instance);
    private volatile int currentState = 1;

    /* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
    protected interface ProvideError {
        Exception getError();
    }

    abstract StorageReference getStorage();

    protected void onCanceled() {
    }

    protected void onFailure() {
    }

    protected void onPaused() {
    }

    protected void onProgress() {
    }

    protected void onQueued() {
    }

    protected void onSuccess() {
    }

    void resetState() {
    }

    abstract void run();

    abstract void schedule();

    abstract ResultT snapStateImpl();

    static {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        ValidUserInitiatedStateChanges = map;
        HashMap<Integer, HashSet<Integer>> map2 = new HashMap<>();
        ValidTaskInitiatedStateChanges = map2;
        map.put(1, new HashSet<>(Arrays.asList(16, 256)));
        map.put(2, new HashSet<>(Arrays.asList(8, 32)));
        map.put(4, new HashSet<>(Arrays.asList(8, 32)));
        map.put(16, new HashSet<>(Arrays.asList(2, 256)));
        map.put(64, new HashSet<>(Arrays.asList(2, 256)));
        map2.put(1, new HashSet<>(Arrays.asList(2, 64)));
        map2.put(2, new HashSet<>(Arrays.asList(4, 64, 128)));
        map2.put(4, new HashSet<>(Arrays.asList(4, 64, 128)));
        map2.put(8, new HashSet<>(Arrays.asList(16, 64, 128)));
        map2.put(32, new HashSet<>(Arrays.asList(256, 64, 128)));
    }

    static /* synthetic */ void lambda$new$0(StorageTask storageTask, OnSuccessListener onSuccessListener, ProvideError provideError) {
        StorageTaskManager.getInstance().unRegister(storageTask);
        onSuccessListener.onSuccess(provideError);
    }

    static /* synthetic */ void lambda$new$1(StorageTask storageTask, OnFailureListener onFailureListener, ProvideError provideError) {
        StorageTaskManager.getInstance().unRegister(storageTask);
        onFailureListener.onFailure(provideError.getError());
    }

    static /* synthetic */ void lambda$new$2(StorageTask storageTask, OnCompleteListener onCompleteListener, ProvideError provideError) {
        StorageTaskManager.getInstance().unRegister(storageTask);
        onCompleteListener.onComplete(storageTask);
    }

    static /* synthetic */ void lambda$new$3(StorageTask storageTask, OnCanceledListener onCanceledListener, ProvideError provideError) {
        StorageTaskManager.getInstance().unRegister(storageTask);
        onCanceledListener.onCanceled();
    }

    protected StorageTask() {
    }

    boolean queue() {
        if (!tryChangeState(2, false)) {
            return false;
        }
        schedule();
        return true;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public boolean resume() {
        if (!tryChangeState(2, true)) {
            return false;
        }
        resetState();
        schedule();
        return true;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public boolean pause() {
        return tryChangeState(new int[]{16, 8}, true);
    }

    @Override // com.google.firebase.storage.CancellableTask
    public boolean cancel() {
        return tryChangeState(new int[]{256, 32}, true);
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isComplete() {
        return (getInternalState() & STATES_COMPLETE) != 0;
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isSuccessful() {
        return (getInternalState() & 128) != 0;
    }

    @Override // com.google.firebase.storage.CancellableTask, com.google.android.gms.tasks.Task
    public boolean isCanceled() {
        return getInternalState() == 256;
    }

    @Override // com.google.firebase.storage.CancellableTask
    public boolean isInProgress() {
        return (getInternalState() & STATES_INPROGRESS) != 0;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public boolean isPaused() {
        return (getInternalState() & 16) != 0;
    }

    @Override // com.google.android.gms.tasks.Task
    public ResultT getResult() {
        if (getFinalResult() == null) {
            throw new IllegalStateException();
        }
        Exception error = getFinalResult().getError();
        if (error != null) {
            throw new RuntimeExecutionException(error);
        }
        return (ResultT) getFinalResult();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X extends java.lang.Throwable */
    @Override // com.google.android.gms.tasks.Task
    public <X extends Throwable> ResultT getResult(Class<X> cls) throws Throwable {
        if (getFinalResult() == null) {
            throw new IllegalStateException();
        }
        if (cls.isInstance(getFinalResult().getError())) {
            throw cls.cast(getFinalResult().getError());
        }
        Exception error = getFinalResult().getError();
        if (error != null) {
            throw new RuntimeExecutionException(error);
        }
        return (ResultT) getFinalResult();
    }

    @Override // com.google.android.gms.tasks.Task
    public Exception getException() {
        if (getFinalResult() == null) {
            return null;
        }
        return getFinalResult().getError();
    }

    public ResultT getSnapshot() {
        return (ResultT) snapState();
    }

    int getInternalState() {
        return this.currentState;
    }

    Object getSyncObject() {
        return this.syncObject;
    }

    ResultT snapState() {
        ResultT resultt;
        synchronized (this.syncObject) {
            resultt = (ResultT) snapStateImpl();
        }
        return resultt;
    }

    boolean tryChangeState(int[] iArr, boolean z) {
        HashMap<Integer, HashSet<Integer>> map = z ? ValidUserInitiatedStateChanges : ValidTaskInitiatedStateChanges;
        synchronized (this.syncObject) {
            for (int i : iArr) {
                HashSet<Integer> hashSet = map.get(Integer.valueOf(getInternalState()));
                if (hashSet != null && hashSet.contains(Integer.valueOf(i))) {
                    this.currentState = i;
                    int i2 = this.currentState;
                    if (i2 == 2) {
                        StorageTaskManager.getInstance().ensureRegistered(this);
                        onQueued();
                    } else if (i2 == 4) {
                        onProgress();
                    } else if (i2 == 16) {
                        onPaused();
                    } else if (i2 == 64) {
                        onFailure();
                    } else if (i2 == 128) {
                        onSuccess();
                    } else if (i2 == 256) {
                        onCanceled();
                    }
                    this.successManager.onInternalStateChanged();
                    this.failureManager.onInternalStateChanged();
                    this.cancelManager.onInternalStateChanged();
                    this.completeListener.onInternalStateChanged();
                    this.pausedManager.onInternalStateChanged();
                    this.progressManager.onInternalStateChanged();
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "changed internal state to: " + getStateString(i) + " isUser: " + z + " from state:" + getStateString(this.currentState));
                    }
                    return true;
                }
            }
            Log.w(TAG, "unable to change internal state to: " + getStateString(iArr) + " isUser: " + z + " from state:" + getStateString(this.currentState));
            return false;
        }
    }

    boolean tryChangeState(int i, boolean z) {
        return tryChangeState(new int[]{i}, z);
    }

    private ResultT getFinalResult() {
        ResultT resultt = this.finalResult;
        if (resultt != null) {
            return resultt;
        }
        if (!isComplete()) {
            return null;
        }
        if (this.finalResult == null) {
            this.finalResult = (ResultT) snapState();
        }
        return this.finalResult;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public StorageTask<ResultT> addOnPausedListener(OnPausedListener<? super ResultT> onPausedListener) {
        Preconditions.checkNotNull(onPausedListener);
        this.pausedManager.addListener(null, null, onPausedListener);
        return this;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public StorageTask<ResultT> addOnPausedListener(Executor executor, OnPausedListener<? super ResultT> onPausedListener) {
        Preconditions.checkNotNull(onPausedListener);
        Preconditions.checkNotNull(executor);
        this.pausedManager.addListener(null, executor, onPausedListener);
        return this;
    }

    @Override // com.google.firebase.storage.ControllableTask
    public StorageTask<ResultT> addOnPausedListener(Activity activity, OnPausedListener<? super ResultT> onPausedListener) {
        Preconditions.checkNotNull(onPausedListener);
        Preconditions.checkNotNull(activity);
        this.pausedManager.addListener(activity, null, onPausedListener);
        return this;
    }

    public StorageTask<ResultT> removeOnPausedListener(OnPausedListener<? super ResultT> onPausedListener) {
        Preconditions.checkNotNull(onPausedListener);
        this.pausedManager.removeListener(onPausedListener);
        return this;
    }

    @Override // com.google.firebase.storage.CancellableTask
    public StorageTask<ResultT> addOnProgressListener(OnProgressListener<? super ResultT> onProgressListener) {
        Preconditions.checkNotNull(onProgressListener);
        this.progressManager.addListener(null, null, onProgressListener);
        return this;
    }

    @Override // com.google.firebase.storage.CancellableTask
    public StorageTask<ResultT> addOnProgressListener(Executor executor, OnProgressListener<? super ResultT> onProgressListener) {
        Preconditions.checkNotNull(onProgressListener);
        Preconditions.checkNotNull(executor);
        this.progressManager.addListener(null, executor, onProgressListener);
        return this;
    }

    @Override // com.google.firebase.storage.CancellableTask
    public StorageTask<ResultT> addOnProgressListener(Activity activity, OnProgressListener<? super ResultT> onProgressListener) {
        Preconditions.checkNotNull(onProgressListener);
        Preconditions.checkNotNull(activity);
        this.progressManager.addListener(activity, null, onProgressListener);
        return this;
    }

    public StorageTask<ResultT> removeOnProgressListener(OnProgressListener<? super ResultT> onProgressListener) {
        Preconditions.checkNotNull(onProgressListener);
        this.progressManager.removeListener(onProgressListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnSuccessListener(OnSuccessListener<? super ResultT> onSuccessListener) {
        Preconditions.checkNotNull(onSuccessListener);
        this.successManager.addListener(null, null, onSuccessListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnSuccessListener(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(onSuccessListener);
        this.successManager.addListener(null, executor, onSuccessListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnSuccessListener(Activity activity, OnSuccessListener<? super ResultT> onSuccessListener) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(onSuccessListener);
        this.successManager.addListener(activity, null, onSuccessListener);
        return this;
    }

    public StorageTask<ResultT> removeOnSuccessListener(OnSuccessListener<? super ResultT> onSuccessListener) {
        Preconditions.checkNotNull(onSuccessListener);
        this.successManager.removeListener(onSuccessListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnFailureListener(OnFailureListener onFailureListener) {
        Preconditions.checkNotNull(onFailureListener);
        this.failureManager.addListener(null, null, onFailureListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        Preconditions.checkNotNull(onFailureListener);
        Preconditions.checkNotNull(executor);
        this.failureManager.addListener(null, executor, onFailureListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        Preconditions.checkNotNull(onFailureListener);
        Preconditions.checkNotNull(activity);
        this.failureManager.addListener(activity, null, onFailureListener);
        return this;
    }

    public StorageTask<ResultT> removeOnFailureListener(OnFailureListener onFailureListener) {
        Preconditions.checkNotNull(onFailureListener);
        this.failureManager.removeListener(onFailureListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnCompleteListener(OnCompleteListener<ResultT> onCompleteListener) {
        Preconditions.checkNotNull(onCompleteListener);
        this.completeListener.addListener(null, null, onCompleteListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnCompleteListener(Executor executor, OnCompleteListener<ResultT> onCompleteListener) {
        Preconditions.checkNotNull(onCompleteListener);
        Preconditions.checkNotNull(executor);
        this.completeListener.addListener(null, executor, onCompleteListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnCompleteListener(Activity activity, OnCompleteListener<ResultT> onCompleteListener) {
        Preconditions.checkNotNull(onCompleteListener);
        Preconditions.checkNotNull(activity);
        this.completeListener.addListener(activity, null, onCompleteListener);
        return this;
    }

    public StorageTask<ResultT> removeOnCompleteListener(OnCompleteListener<ResultT> onCompleteListener) {
        Preconditions.checkNotNull(onCompleteListener);
        this.completeListener.removeListener(onCompleteListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnCanceledListener(OnCanceledListener onCanceledListener) {
        Preconditions.checkNotNull(onCanceledListener);
        this.cancelManager.addListener(null, null, onCanceledListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        Preconditions.checkNotNull(onCanceledListener);
        Preconditions.checkNotNull(executor);
        this.cancelManager.addListener(null, executor, onCanceledListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public StorageTask<ResultT> addOnCanceledListener(Activity activity, OnCanceledListener onCanceledListener) {
        Preconditions.checkNotNull(onCanceledListener);
        Preconditions.checkNotNull(activity);
        this.cancelManager.addListener(activity, null, onCanceledListener);
        return this;
    }

    public StorageTask<ResultT> removeOnCanceledListener(OnCanceledListener onCanceledListener) {
        Preconditions.checkNotNull(onCanceledListener);
        this.cancelManager.removeListener(onCanceledListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public <ContinuationResultT> Task<ContinuationResultT> continueWith(Continuation<ResultT, ContinuationResultT> continuation) {
        return continueWithImpl(null, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public <ContinuationResultT> Task<ContinuationResultT> continueWith(Executor executor, Continuation<ResultT, ContinuationResultT> continuation) {
        return continueWithImpl(executor, continuation);
    }

    private <ContinuationResultT> Task<ContinuationResultT> continueWithImpl(Executor executor, Continuation<ResultT, ContinuationResultT> continuation) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.completeListener.addListener(null, executor, StorageTask$$Lambda$9.lambdaFactory$(this, continuation, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    static /* synthetic */ void lambda$continueWithImpl$4(StorageTask storageTask, Continuation continuation, TaskCompletionSource taskCompletionSource, Task task) {
        try {
            Object objThen = continuation.then(storageTask);
            if (taskCompletionSource.getTask().isComplete()) {
                return;
            }
            taskCompletionSource.setResult(objThen);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                taskCompletionSource.setException((Exception) e2.getCause());
            } else {
                taskCompletionSource.setException(e2);
            }
        } catch (Exception e3) {
            taskCompletionSource.setException(e3);
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public <ContinuationResultT> Task<ContinuationResultT> continueWithTask(Continuation<ResultT, Task<ContinuationResultT>> continuation) {
        return continueWithTaskImpl(null, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public <ContinuationResultT> Task<ContinuationResultT> continueWithTask(Executor executor, Continuation<ResultT, Task<ContinuationResultT>> continuation) {
        return continueWithTaskImpl(executor, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public <ContinuationResultT> Task<ContinuationResultT> onSuccessTask(SuccessContinuation<ResultT, ContinuationResultT> successContinuation) {
        return successTaskImpl(null, successContinuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public <ContinuationResultT> Task<ContinuationResultT> onSuccessTask(Executor executor, SuccessContinuation<ResultT, ContinuationResultT> successContinuation) {
        return successTaskImpl(executor, successContinuation);
    }

    private <ContinuationResultT> Task<ContinuationResultT> continueWithTaskImpl(Executor executor, Continuation<ResultT, Task<ContinuationResultT>> continuation) {
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        this.completeListener.addListener(null, executor, StorageTask$$Lambda$10.lambdaFactory$(this, continuation, taskCompletionSource, cancellationTokenSource));
        return taskCompletionSource.getTask();
    }

    static /* synthetic */ void lambda$continueWithTaskImpl$5(StorageTask storageTask, Continuation continuation, TaskCompletionSource taskCompletionSource, CancellationTokenSource cancellationTokenSource, Task task) {
        try {
            Task task2 = (Task) continuation.then(storageTask);
            if (taskCompletionSource.getTask().isComplete()) {
                return;
            }
            if (task2 == null) {
                taskCompletionSource.setException(new NullPointerException("Continuation returned null"));
                return;
            }
            taskCompletionSource.getClass();
            task2.addOnSuccessListener(StorageTask$$Lambda$16.lambdaFactory$(taskCompletionSource));
            taskCompletionSource.getClass();
            task2.addOnFailureListener(StorageTask$$Lambda$17.lambdaFactory$(taskCompletionSource));
            cancellationTokenSource.getClass();
            task2.addOnCanceledListener(StorageTask$$Lambda$18.lambdaFactory$(cancellationTokenSource));
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                taskCompletionSource.setException((Exception) e2.getCause());
            } else {
                taskCompletionSource.setException(e2);
            }
        } catch (Exception e3) {
            taskCompletionSource.setException(e3);
        }
    }

    private <ContinuationResultT> Task<ContinuationResultT> successTaskImpl(Executor executor, SuccessContinuation<ResultT, ContinuationResultT> successContinuation) {
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        this.successManager.addListener(null, executor, StorageTask$$Lambda$11.lambdaFactory$(successContinuation, taskCompletionSource, cancellationTokenSource));
        return taskCompletionSource.getTask();
    }

    static /* synthetic */ void lambda$successTaskImpl$6(SuccessContinuation successContinuation, TaskCompletionSource taskCompletionSource, CancellationTokenSource cancellationTokenSource, ProvideError provideError) {
        try {
            Task taskThen = successContinuation.then(provideError);
            taskCompletionSource.getClass();
            taskThen.addOnSuccessListener(StorageTask$$Lambda$13.lambdaFactory$(taskCompletionSource));
            taskCompletionSource.getClass();
            taskThen.addOnFailureListener(StorageTask$$Lambda$14.lambdaFactory$(taskCompletionSource));
            cancellationTokenSource.getClass();
            taskThen.addOnCanceledListener(StorageTask$$Lambda$15.lambdaFactory$(cancellationTokenSource));
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                taskCompletionSource.setException((Exception) e2.getCause());
            } else {
                taskCompletionSource.setException(e2);
            }
        } catch (Exception e3) {
            taskCompletionSource.setException(e3);
        }
    }

    Runnable getRunnable() {
        return StorageTask$$Lambda$12.lambdaFactory$(this);
    }

    static /* synthetic */ void lambda$getRunnable$7(StorageTask storageTask) {
        try {
            storageTask.run();
        } finally {
            storageTask.ensureFinalState();
        }
    }

    private void ensureFinalState() {
        if (isComplete() || isPaused() || getInternalState() == 2 || tryChangeState(256, false)) {
            return;
        }
        tryChangeState(64, false);
    }

    private String getStateString(int[] iArr) {
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i : iArr) {
            sb.append(getStateString(i)).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    private String getStateString(int i) {
        if (i == 1) {
            return "INTERNAL_STATE_NOT_STARTED";
        }
        if (i == 2) {
            return "INTERNAL_STATE_QUEUED";
        }
        if (i == 4) {
            return "INTERNAL_STATE_IN_PROGRESS";
        }
        if (i == 8) {
            return "INTERNAL_STATE_PAUSING";
        }
        if (i == 16) {
            return "INTERNAL_STATE_PAUSED";
        }
        if (i == 32) {
            return "INTERNAL_STATE_CANCELING";
        }
        if (i == 64) {
            return "INTERNAL_STATE_FAILURE";
        }
        if (i == 128) {
            return "INTERNAL_STATE_SUCCESS";
        }
        if (i == 256) {
            return "INTERNAL_STATE_CANCELED";
        }
        return "Unknown Internal State!";
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
    public class SnapshotBase implements ProvideError {
        private final Exception error;

        public SnapshotBase(Exception exc) {
            if (exc == null) {
                if (StorageTask.this.isCanceled()) {
                    this.error = StorageException.fromErrorStatus(Status.RESULT_CANCELED);
                    return;
                } else if (StorageTask.this.getInternalState() == 64) {
                    this.error = StorageException.fromErrorStatus(Status.RESULT_INTERNAL_ERROR);
                    return;
                } else {
                    this.error = null;
                    return;
                }
            }
            this.error = exc;
        }

        public StorageTask<ResultT> getTask() {
            return StorageTask.this;
        }

        public StorageReference getStorage() {
            return getTask().getStorage();
        }

        @Override // com.google.firebase.storage.StorageTask.ProvideError
        public Exception getError() {
            return this.error;
        }
    }
}
