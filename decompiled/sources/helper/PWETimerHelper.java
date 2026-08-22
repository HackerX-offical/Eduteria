package helper;

import android.content.Context;
import android.content.Intent;
import com.easebuzz.payment.kit.PWETimerService;
import datamodels.PWEStaticDataModel;

/* JADX INFO: loaded from: classes9.dex */
public class PWETimerHelper {
    private Context context;

    public PWETimerHelper(Context context) {
        this.context = context;
    }

    public void initiateSessionTime() {
        PWEStaticDataModel.TXN_SESSION_UPDATED_MINUTES = PWEStaticDataModel.TXN_SESSION_REM_MINUTES;
        PWEStaticDataModel.TXN_SESSION_UPDATED_SECONDS = PWEStaticDataModel.TXN_SESSION_REM_SECONDS;
    }

    public void stopGenericSessionTimer() {
        this.context.stopService(new Intent(this.context, (Class<?>) PWETimerService.class));
    }

    public void updateTransactionSessionTime() {
        this.context.startService(new Intent(this.context, (Class<?>) PWETimerService.class));
    }
}
