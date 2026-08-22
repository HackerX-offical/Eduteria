package com.paytm.pgsdk;

import android.app.IntentService;
import android.content.Intent;

/* JADX INFO: loaded from: classes9.dex */
public class IntentServicePreNotification extends IntentService {
    public IntentServicePreNotification() {
        super("IntentServicePreNotification");
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) throws Throwable {
        if (intent != null) {
            callHttp(intent.getExtras().getString("url"));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void callHttp(java.lang.String r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L35
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L35
            java.net.URLConnection r6 = r1.openConnection()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L35
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L35
            java.io.InputStream r0 = r6.getInputStream()     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L42
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L42
            r1.<init>(r0)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L42
            int r0 = r1.read()     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L42
        L19:
            r2 = -1
            if (r0 == r2) goto L28
            char r0 = (char) r0     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L42
            int r2 = r1.read()     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L42
            java.io.PrintStream r3 = java.lang.System.out     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L42
            r3.print(r0)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L42
            r0 = r2
            goto L19
        L28:
            if (r6 == 0) goto L41
            r6.disconnect()
            return
        L2e:
            r0 = move-exception
            goto L39
        L30:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
            goto L43
        L35:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
        L39:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L42
            if (r6 == 0) goto L41
            r6.disconnect()
        L41:
            return
        L42:
            r0 = move-exception
        L43:
            if (r6 == 0) goto L48
            r6.disconnect()
        L48:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.pgsdk.IntentServicePreNotification.callHttp(java.lang.String):void");
    }
}
