package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.work.Logger;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class EnqueueRunnable {
    private static final String TAG = Logger.tagWithPrefix("EnqueueRunnable");

    private EnqueueRunnable() {
    }

    public static void enqueue(WorkContinuationImpl workContinuation) {
        if (workContinuation.hasCycles()) {
            throw new IllegalStateException("WorkContinuation has cycles (" + workContinuation + ")");
        }
        if (addToDatabase(workContinuation)) {
            scheduleWorkInBackground(workContinuation);
        }
    }

    public static boolean addToDatabase(WorkContinuationImpl workContinuation) {
        WorkManagerImpl workManagerImpl = workContinuation.getWorkManagerImpl();
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            EnqueueUtilsKt.checkContentUriTriggerWorkerLimits(workDatabase, workManagerImpl.getConfiguration(), workContinuation);
            boolean zProcessContinuation = processContinuation(workContinuation);
            workDatabase.setTransactionSuccessful();
            return zProcessContinuation;
        } finally {
            workDatabase.endTransaction();
        }
    }

    public static void scheduleWorkInBackground(WorkContinuationImpl workContinuation) {
        WorkManagerImpl workManagerImpl = workContinuation.getWorkManagerImpl();
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }

    private static boolean processContinuation(WorkContinuationImpl workContinuation) {
        List<WorkContinuationImpl> parents = workContinuation.getParents();
        boolean zProcessContinuation = false;
        if (parents != null) {
            for (WorkContinuationImpl workContinuationImpl : parents) {
                if (!workContinuationImpl.isEnqueued()) {
                    zProcessContinuation |= processContinuation(workContinuationImpl);
                } else {
                    Logger.get().warning(TAG, "Already enqueued work ids (" + TextUtils.join(", ", workContinuationImpl.getIds()) + ")");
                }
            }
        }
        return enqueueContinuation(workContinuation) | zProcessContinuation;
    }

    private static boolean enqueueContinuation(WorkContinuationImpl workContinuation) {
        boolean zEnqueueWorkWithPrerequisites = enqueueWorkWithPrerequisites(workContinuation.getWorkManagerImpl(), workContinuation.getWork(), (String[]) WorkContinuationImpl.prerequisitesFor(workContinuation).toArray(new String[0]), workContinuation.getName(), workContinuation.getExistingWorkPolicy());
        workContinuation.markEnqueued();
        return zEnqueueWorkWithPrerequisites;
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean enqueueWorkWithPrerequisites(androidx.work.impl.WorkManagerImpl r17, java.util.List<? extends androidx.work.WorkRequest> r18, java.lang.String[] r19, java.lang.String r20, androidx.work.ExistingWorkPolicy r21) {
        /*
            Method dump skipped, instruction units count: 495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.EnqueueRunnable.enqueueWorkWithPrerequisites(androidx.work.impl.WorkManagerImpl, java.util.List, java.lang.String[], java.lang.String, androidx.work.ExistingWorkPolicy):boolean");
    }
}
