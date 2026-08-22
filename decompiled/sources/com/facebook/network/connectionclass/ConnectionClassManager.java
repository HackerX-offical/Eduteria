package com.facebook.network.connectionclass;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes7.dex */
public class ConnectionClassManager {
    static final long BANDWIDTH_LOWER_BOUND = 10;
    private static final int BYTES_TO_BITS = 8;
    private static final double DEFAULT_DECAY_CONSTANT = 0.05d;
    private static final int DEFAULT_GOOD_BANDWIDTH = 2000;
    private static final int DEFAULT_MODERATE_BANDWIDTH = 550;
    private static final int DEFAULT_POOR_BANDWIDTH = 150;
    static final double DEFAULT_SAMPLES_TO_QUALITY_CHANGE = 5.0d;
    private AtomicReference<ConnectionQuality> mCurrentBandwidthConnectionQuality;
    private ExponentialGeometricAverage mDownloadBandwidth;
    private volatile boolean mInitiateStateChange;
    private ArrayList<ConnectionClassStateChangeListener> mListenerList;
    private AtomicReference<ConnectionQuality> mNextBandwidthConnectionQuality;
    private int mSampleCounter;

    public interface ConnectionClassStateChangeListener {
        void onBandwidthStateChange(ConnectionQuality connectionQuality);
    }

    private static class ConnectionClassManagerHolder {
        public static final ConnectionClassManager instance = new ConnectionClassManager();

        private ConnectionClassManagerHolder() {
        }
    }

    @Nonnull
    public static ConnectionClassManager getInstance() {
        return ConnectionClassManagerHolder.instance;
    }

    private ConnectionClassManager() {
        this.mDownloadBandwidth = new ExponentialGeometricAverage(DEFAULT_DECAY_CONSTANT);
        this.mInitiateStateChange = false;
        this.mCurrentBandwidthConnectionQuality = new AtomicReference<>(ConnectionQuality.UNKNOWN);
        this.mListenerList = new ArrayList<>();
    }

    public synchronized void addBandwidth(long j, long j2) {
        if (j2 != 0) {
            double d2 = ((j * 1.0d) / j2) * 8.0d;
            if (d2 >= 10.0d) {
                this.mDownloadBandwidth.addMeasurement(d2);
                if (this.mInitiateStateChange) {
                    this.mSampleCounter++;
                    if (getCurrentBandwidthQuality() != this.mNextBandwidthConnectionQuality.get()) {
                        this.mInitiateStateChange = false;
                        this.mSampleCounter = 1;
                    }
                    if (this.mSampleCounter >= DEFAULT_SAMPLES_TO_QUALITY_CHANGE) {
                        this.mInitiateStateChange = false;
                        this.mSampleCounter = 1;
                        this.mCurrentBandwidthConnectionQuality.set(this.mNextBandwidthConnectionQuality.get());
                        notifyListeners();
                    }
                    return;
                }
                if (this.mCurrentBandwidthConnectionQuality.get() != getCurrentBandwidthQuality()) {
                    this.mInitiateStateChange = true;
                    this.mNextBandwidthConnectionQuality = new AtomicReference<>(getCurrentBandwidthQuality());
                }
            }
        }
    }

    public void reset() {
        ExponentialGeometricAverage exponentialGeometricAverage = this.mDownloadBandwidth;
        if (exponentialGeometricAverage != null) {
            exponentialGeometricAverage.reset();
        }
        this.mCurrentBandwidthConnectionQuality.set(ConnectionQuality.UNKNOWN);
    }

    public synchronized ConnectionQuality getCurrentBandwidthQuality() {
        ExponentialGeometricAverage exponentialGeometricAverage = this.mDownloadBandwidth;
        if (exponentialGeometricAverage == null) {
            return ConnectionQuality.UNKNOWN;
        }
        return mapBandwidthQuality(exponentialGeometricAverage.getAverage());
    }

    private ConnectionQuality mapBandwidthQuality(double d2) {
        if (d2 < 0.0d) {
            return ConnectionQuality.UNKNOWN;
        }
        if (d2 < 150.0d) {
            return ConnectionQuality.POOR;
        }
        if (d2 < 550.0d) {
            return ConnectionQuality.MODERATE;
        }
        if (d2 < 2000.0d) {
            return ConnectionQuality.GOOD;
        }
        return ConnectionQuality.EXCELLENT;
    }

    public synchronized double getDownloadKBitsPerSecond() {
        ExponentialGeometricAverage exponentialGeometricAverage;
        exponentialGeometricAverage = this.mDownloadBandwidth;
        return exponentialGeometricAverage == null ? -1.0d : exponentialGeometricAverage.getAverage();
    }

    public ConnectionQuality register(ConnectionClassStateChangeListener connectionClassStateChangeListener) {
        if (connectionClassStateChangeListener != null) {
            this.mListenerList.add(connectionClassStateChangeListener);
        }
        return this.mCurrentBandwidthConnectionQuality.get();
    }

    public void remove(ConnectionClassStateChangeListener connectionClassStateChangeListener) {
        if (connectionClassStateChangeListener != null) {
            this.mListenerList.remove(connectionClassStateChangeListener);
        }
    }

    private void notifyListeners() {
        int size = this.mListenerList.size();
        for (int i = 0; i < size; i++) {
            this.mListenerList.get(i).onBandwidthStateChange(this.mCurrentBandwidthConnectionQuality.get());
        }
    }
}
