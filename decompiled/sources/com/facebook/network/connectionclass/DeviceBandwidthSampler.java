package com.facebook.network.connectionclass;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes7.dex */
public class DeviceBandwidthSampler {
    static final long SAMPLE_TIME = 1000;
    private final ConnectionClassManager mConnectionClassManager;
    private Handler mHandler;
    private long mLastTimeReading;
    private AtomicInteger mSamplingCounter;
    private HandlerThread mThread;

    private static class DeviceBandwidthSamplerHolder {
        public static final DeviceBandwidthSampler instance = new DeviceBandwidthSampler(ConnectionClassManager.getInstance());

        private DeviceBandwidthSamplerHolder() {
        }
    }

    @Nonnull
    public static DeviceBandwidthSampler getInstance() {
        return DeviceBandwidthSamplerHolder.instance;
    }

    private DeviceBandwidthSampler(ConnectionClassManager connectionClassManager) {
        this.mConnectionClassManager = connectionClassManager;
        this.mSamplingCounter = new AtomicInteger();
        HandlerThread handlerThread = new HandlerThread("ParseThread");
        this.mThread = handlerThread;
        handlerThread.start();
        this.mHandler = new SamplingHandler(this.mThread.getLooper());
    }

    public void startSampling() {
        if (this.mSamplingCounter.getAndIncrement() == 0) {
            this.mHandler.sendEmptyMessage(1);
            this.mLastTimeReading = SystemClock.elapsedRealtime();
        }
    }

    public void stopSampling() {
        if (this.mSamplingCounter.decrementAndGet() == 0) {
            this.mHandler.sendEmptyMessage(2);
        }
    }

    private class SamplingHandler extends Handler {
        static final int MSG_START = 1;
        static final int MSG_STOP = 2;

        public SamplingHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                addSample();
                sendEmptyMessageDelayed(1, 1000L);
            } else {
                if (i == 2) {
                    addSample();
                    removeMessages(1);
                    return;
                }
                throw new IllegalArgumentException("Unknown what=" + message.what);
            }
        }

        private void addSample() {
            long dataUsageForUidAndTag = QTagParser.getInstance().parseDataUsageForUidAndTag(Process.myUid());
            synchronized (this) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (dataUsageForUidAndTag != -1) {
                    DeviceBandwidthSampler.this.mConnectionClassManager.addBandwidth(dataUsageForUidAndTag, jElapsedRealtime - DeviceBandwidthSampler.this.mLastTimeReading);
                }
                DeviceBandwidthSampler.this.mLastTimeReading = jElapsedRealtime;
            }
        }
    }

    public boolean isSampling() {
        return this.mSamplingCounter.get() != 0;
    }
}
