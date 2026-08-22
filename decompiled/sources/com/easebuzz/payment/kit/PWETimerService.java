package com.easebuzz.payment.kit;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import datamodels.PWEStaticDataModel;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes7.dex */
public class PWETimerService extends Service {
    private PWEPaymentInfoHandler paymentInfoHandler;
    private TimerTask sessionTimerTask;
    private Timer timerTransactionSession;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.timerTransactionSession = new Timer();
        this.paymentInfoHandler = new PWEPaymentInfoHandler(getApplicationContext());
        updateTransactionSessionTime();
    }

    public void updateTransactionSessionTime() {
        TimerTask timerTask = new TimerTask() { // from class: com.easebuzz.payment.kit.PWETimerService.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                boolean z = true;
                if (PWEStaticDataModel.TXN_SESSION_UPDATED_MINUTES == 0 && PWEStaticDataModel.TXN_SESSION_UPDATED_SECONDS == 0) {
                    PWETimerService.this.paymentInfoHandler.setIsTxnSessionExpire(true);
                    PWETimerService.this.timerTransactionSession.cancel();
                } else {
                    if (PWEStaticDataModel.TXN_SESSION_UPDATED_MINUTES == 0) {
                        PWEStaticDataModel.TXN_SESSION_UPDATED_SECONDS--;
                    }
                    if (PWEStaticDataModel.TXN_SESSION_UPDATED_SECONDS > 0 && PWEStaticDataModel.TXN_SESSION_UPDATED_MINUTES > 0) {
                        PWEStaticDataModel.TXN_SESSION_UPDATED_SECONDS--;
                    }
                    if (PWEStaticDataModel.TXN_SESSION_UPDATED_SECONDS == 0 && PWEStaticDataModel.TXN_SESSION_UPDATED_MINUTES > 0) {
                        PWEStaticDataModel.TXN_SESSION_UPDATED_SECONDS = 60;
                        PWEStaticDataModel.TXN_SESSION_UPDATED_MINUTES--;
                    }
                    z = false;
                }
                Intent intent = new Intent("pwe_timer_broad_cast");
                intent.putExtra("is_session_expired", z);
                PWETimerService.this.sendBroadcast(intent);
            }
        };
        this.sessionTimerTask = timerTask;
        this.timerTransactionSession.scheduleAtFixedRate(timerTask, 0L, 1000L);
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            if (PWEStaticDataModel.TXN_SESSION_UPDATED_MINUTES <= 0 && PWEStaticDataModel.TXN_SESSION_UPDATED_SECONDS <= 0) {
                this.paymentInfoHandler.setIsTxnSessionExpire(true);
                this.timerTransactionSession.cancel();
            } else if (this.paymentInfoHandler.IsTxnTimerStopped()) {
                this.timerTransactionSession.cancel();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
    }
}
