package com.appnew.android.DownloadServices;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.clevertap.android.sdk.Constants;

/* JADX INFO: loaded from: classes6.dex */
public abstract class CustomIntentService extends Service {
    private final String TAG = getClass().getSimpleName();
    private String mName;
    private boolean mRedelivery;
    private volatile ServiceHandler mServiceHandler;
    private volatile Looper mServiceLooper;

    protected abstract void cancelAllDownload();

    protected abstract boolean cancelDownload(String downloadServiceId);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    protected abstract void onHandleIntent(Intent intent);

    protected abstract boolean pauseDownload(String downloadServiceId);

    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            try {
                if (Build.VERSION.SDK_INT >= 31) {
                    try {
                        CustomIntentService.this.onHandleIntent((Intent) msg.obj);
                    } catch (ForegroundServiceStartNotAllowedException e2) {
                        Log.d("ServiceHandler", "error: " + e2.getMessage());
                    }
                } else {
                    CustomIntentService.this.onHandleIntent((Intent) msg.obj);
                }
            } catch (Exception e3) {
                Log.d("ServiceHandler", "error: " + e3.getMessage());
            }
            CustomIntentService.this.stopSelf(msg.arg1);
        }
    }

    public CustomIntentService(String name) {
        this.mName = name;
    }

    public void setIntentRedelivery(boolean enabled) {
        this.mRedelivery = enabled;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        HandlerThread handlerThread = new HandlerThread("IntentService[" + this.mName + Constants.AES_SUFFIX);
        handlerThread.start();
        this.mServiceLooper = handlerThread.getLooper();
        this.mServiceHandler = new ServiceHandler(this.mServiceLooper);
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int startId) {
        Message messageObtainMessage = this.mServiceHandler.obtainMessage();
        messageObtainMessage.arg1 = startId;
        messageObtainMessage.obj = intent;
        try {
            if (intent != null && intent.getAction() != null) {
                String action = intent.getAction();
                action.hashCode();
                switch (action) {
                    case "cancel":
                        if (!cancelDownload(intent.getStringExtra(VideoDownloadService.DOWNLOAD_SERVICE_ID))) {
                            this.mServiceHandler.removeMessages(intent.getIntExtra(VideoDownloadService.DOWNLOAD_SERVICE_ID, -1));
                            break;
                        }
                        break;
                    case "pause":
                        if (!pauseDownload(intent.getStringExtra(VideoDownloadService.DOWNLOAD_SERVICE_ID))) {
                            this.mServiceHandler.removeMessages(intent.getIntExtra(VideoDownloadService.DOWNLOAD_SERVICE_ID, -1));
                        }
                        stopSelf(startId);
                        break;
                    case "cancelAll":
                        cancelAllDownload();
                        this.mServiceHandler.removeCallbacksAndMessages(null);
                        break;
                }
            }
            if (intent != null) {
                messageObtainMessage.what = Integer.parseInt(intent.getStringExtra(VideoDownloadService.DOWNLOAD_SERVICE_ID));
            }
            this.mServiceHandler.sendMessage(messageObtainMessage);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        onStart(intent, startId);
        return this.mRedelivery ? 3 : 2;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.mServiceLooper.quit();
    }
}
