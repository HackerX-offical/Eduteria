package easypay.appinvoke.utils;

import android.text.TextUtils;
import easypay.appinvoke.manager.Constants;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes9.dex */
public class AssistLogs {
    public static void printLog(String str, Object obj) {
        if (Constants.DEV_MODE) {
            obj.getClass().getSimpleName();
            Log.d(Constants.ASSIST_LOG_CONSTANT, obj + ":" + str);
            try {
                if (TextUtils.isEmpty(str)) {
                    throw new LogNotPrintedException();
                }
            } catch (Exception e2) {
                e2.printStackTrace(new PrintWriter(new StringWriter()));
            }
        }
    }
}
