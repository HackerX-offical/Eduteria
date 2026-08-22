package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
class TransferStatusUpdater {
    private static TransferDBUtil dbUtil;
    private static TransferStatusUpdater transferStatusUpdater;
    private final Handler mainHandler;
    private final Map<Integer, TransferRecord> transfers;
    private static final Log LOGGER = LogFactory.getLog(TransferStatusUpdater.class);
    private static final HashSet<TransferState> STATES_NOT_TO_NOTIFY = new HashSet<>(Arrays.asList(TransferState.PART_COMPLETED, TransferState.PENDING_CANCEL, TransferState.PENDING_PAUSE, TransferState.PENDING_NETWORK_DISCONNECT));
    static final Map<Integer, List<TransferListener>> LISTENERS = new ConcurrentHashMap<Integer, List<TransferListener>>() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.1
    };

    TransferStatusUpdater(TransferDBUtil transferDBUtil) {
        dbUtil = transferDBUtil;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.transfers = new ConcurrentHashMap();
    }

    public static synchronized TransferStatusUpdater getInstance(Context context) {
        if (transferStatusUpdater == null) {
            TransferDBUtil transferDBUtil = new TransferDBUtil(context);
            dbUtil = transferDBUtil;
            transferStatusUpdater = new TransferStatusUpdater(transferDBUtil);
        }
        return transferStatusUpdater;
    }

    synchronized Map<Integer, TransferRecord> getTransfers() {
        return Collections.unmodifiableMap(this.transfers);
    }

    synchronized void addTransfer(TransferRecord transferRecord) {
        this.transfers.put(Integer.valueOf(transferRecord.id), transferRecord);
    }

    synchronized TransferRecord getTransfer(int i) {
        return this.transfers.get(Integer.valueOf(i));
    }

    synchronized void removeTransfer(int i) {
        Map<Integer, List<TransferListener>> map = LISTENERS;
        synchronized (map) {
            map.remove(Integer.valueOf(i));
        }
        this.transfers.remove(Integer.valueOf(i));
    }

    synchronized void removeTransferRecordFromDB(int i) {
        S3ClientReference.remove(Integer.valueOf(i));
        dbUtil.deleteTransferRecords(i);
    }

    synchronized void updateState(final int i, final TransferState transferState) {
        boolean zContains = STATES_NOT_TO_NOTIFY.contains(transferState);
        TransferRecord transferRecord = this.transfers.get(Integer.valueOf(i));
        if (transferRecord == null) {
            if (dbUtil.updateState(i, transferState) == 0) {
                LOGGER.warn("Failed to update the status of transfer " + i);
            }
        } else {
            zContains |= transferState.equals(transferRecord.state);
            transferRecord.state = transferState;
            if (dbUtil.updateTransferRecord(transferRecord) == 0) {
                LOGGER.warn("Failed to update the status of transfer " + i);
            }
        }
        if (zContains) {
            return;
        }
        if (TransferState.COMPLETED.equals(transferState)) {
            removeTransferRecordFromDB(i);
        }
        Map<Integer, List<TransferListener>> map = LISTENERS;
        synchronized (map) {
            List<TransferListener> list = map.get(Integer.valueOf(i));
            if (list != null && !list.isEmpty()) {
                for (final TransferListener transferListener : list) {
                    this.mainHandler.post(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.2
                        @Override // java.lang.Runnable
                        public void run() {
                            transferListener.onStateChanged(i, transferState);
                        }
                    });
                }
                if (TransferState.COMPLETED.equals(transferState) || TransferState.FAILED.equals(transferState) || TransferState.CANCELED.equals(transferState)) {
                    list.clear();
                }
            }
        }
    }

    synchronized void updateProgress(final int i, final long j, long j2, boolean z) {
        final long j3;
        TransferRecord transferRecord = this.transfers.get(Integer.valueOf(i));
        if (transferRecord != null) {
            transferRecord.bytesCurrent = j;
            j3 = j2;
            transferRecord.bytesTotal = j3;
        } else {
            j3 = j2;
        }
        dbUtil.updateBytesTransferred(i, j);
        if (z) {
            Map<Integer, List<TransferListener>> map = LISTENERS;
            synchronized (map) {
                List<TransferListener> list = map.get(Integer.valueOf(i));
                if (list != null && !list.isEmpty()) {
                    for (final TransferListener transferListener : list) {
                        this.mainHandler.post(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.3
                            @Override // java.lang.Runnable
                            public void run() {
                                transferListener.onProgressChanged(i, j, j3);
                            }
                        });
                        j3 = j2;
                    }
                }
            }
        }
    }

    void throwError(final int i, final Exception exc) {
        Map<Integer, List<TransferListener>> map = LISTENERS;
        synchronized (map) {
            List<TransferListener> list = map.get(Integer.valueOf(i));
            if (list != null && !list.isEmpty()) {
                for (final TransferListener transferListener : list) {
                    this.mainHandler.post(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.4
                        @Override // java.lang.Runnable
                        public void run() {
                            transferListener.onError(i, exc);
                        }
                    });
                }
            }
        }
    }

    synchronized void clear() {
        Map<Integer, List<TransferListener>> map = LISTENERS;
        synchronized (map) {
            map.clear();
        }
        this.transfers.clear();
    }

    static void registerListener(int i, TransferListener transferListener) {
        if (transferListener == null) {
            throw new IllegalArgumentException("Listener can't be null");
        }
        Map<Integer, List<TransferListener>> map = LISTENERS;
        synchronized (map) {
            List<TransferListener> list = map.get(Integer.valueOf(i));
            if (list == null) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                copyOnWriteArrayList.add(transferListener);
                map.put(Integer.valueOf(i), copyOnWriteArrayList);
            } else if (!list.contains(transferListener)) {
                list.add(transferListener);
            }
        }
    }

    static void unregisterListener(int i, TransferListener transferListener) {
        if (transferListener == null) {
            throw new IllegalArgumentException("Listener can't be null");
        }
        Map<Integer, List<TransferListener>> map = LISTENERS;
        synchronized (map) {
            List<TransferListener> list = map.get(Integer.valueOf(i));
            if (list != null && !list.isEmpty()) {
                list.remove(transferListener);
            }
        }
    }

    private class TransferProgressListener implements ProgressListener {
        private long bytesTransferredSoFar;
        private final TransferRecord transfer;

        public TransferProgressListener(TransferRecord transferRecord) {
            this.transfer = transferRecord;
        }

        @Override // com.amazonaws.event.ProgressListener
        public synchronized void progressChanged(ProgressEvent progressEvent) {
            if (32 == progressEvent.getEventCode()) {
                TransferStatusUpdater.LOGGER.info("Reset Event triggerred. Resetting the bytesCurrent to 0.");
                this.bytesTransferredSoFar = 0L;
            } else {
                long bytesTransferred = this.bytesTransferredSoFar + progressEvent.getBytesTransferred();
                this.bytesTransferredSoFar = bytesTransferred;
                if (bytesTransferred > this.transfer.bytesCurrent) {
                    this.transfer.bytesCurrent = this.bytesTransferredSoFar;
                    TransferStatusUpdater.this.updateProgress(this.transfer.id, this.transfer.bytesCurrent, this.transfer.bytesTotal, true);
                }
            }
        }
    }

    synchronized ProgressListener newProgressListener(int i) {
        TransferRecord transfer;
        transfer = getTransfer(i);
        if (transfer == null) {
            LOGGER.info("TransferStatusUpdater doesn't track the transfer: " + i);
            throw new IllegalArgumentException("transfer " + i + " doesn't exist");
        }
        LOGGER.info("Creating a new progress listener for transfer: " + i);
        return new TransferProgressListener(transfer);
    }
}
