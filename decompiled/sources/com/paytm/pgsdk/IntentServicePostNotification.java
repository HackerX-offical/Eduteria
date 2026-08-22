package com.paytm.pgsdk;

import android.app.IntentService;
import android.content.Intent;

/* JADX INFO: loaded from: classes9.dex */
public class IntentServicePostNotification extends IntentService {
    public IntentServicePostNotification() {
        super("IntentServicePostNotification");
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) throws Throwable {
        if (intent == null || intent.getExtras() == null) {
            return;
        }
        callHttp(intent.getExtras().getString("url"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void callHttp(java.lang.String r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L7
            goto L48
        L7:
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3c
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3c
            java.net.URLConnection r6 = r1.openConnection()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3c
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3c
            java.io.InputStream r0 = r6.getInputStream()     // Catch: java.lang.Exception -> L35 java.lang.Throwable -> L49
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L35 java.lang.Throwable -> L49
            r1.<init>(r0)     // Catch: java.lang.Exception -> L35 java.lang.Throwable -> L49
            int r0 = r1.read()     // Catch: java.lang.Exception -> L35 java.lang.Throwable -> L49
        L20:
            r2 = -1
            if (r0 == r2) goto L2f
            char r0 = (char) r0     // Catch: java.lang.Exception -> L35 java.lang.Throwable -> L49
            int r2 = r1.read()     // Catch: java.lang.Exception -> L35 java.lang.Throwable -> L49
            java.io.PrintStream r3 = java.lang.System.out     // Catch: java.lang.Exception -> L35 java.lang.Throwable -> L49
            r3.print(r0)     // Catch: java.lang.Exception -> L35 java.lang.Throwable -> L49
            r0 = r2
            goto L20
        L2f:
            if (r6 == 0) goto L48
            r6.disconnect()
            return
        L35:
            r0 = move-exception
            goto L40
        L37:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
            goto L4a
        L3c:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
        L40:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L49
            if (r6 == 0) goto L48
            r6.disconnect()
        L48:
            return
        L49:
            r0 = move-exception
        L4a:
            if (r6 == 0) goto L4f
            r6.disconnect()
        L4f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.pgsdk.IntentServicePostNotification.callHttp(java.lang.String):void");
    }
}
