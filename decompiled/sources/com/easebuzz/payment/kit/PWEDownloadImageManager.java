package com.easebuzz.payment.kit;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes7.dex */
public class PWEDownloadImageManager extends AsyncTask<String, Void, Bitmap> {
    Context context;
    String fileName;
    ImageView imageView;
    SecureRandom random = new SecureRandom();

    public PWEDownloadImageManager(Context context, String str, ImageView imageView) {
        this.fileName = "";
        this.context = context;
        this.fileName = str;
        this.imageView = imageView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0015 A[EXC_TOP_SPLITTER, PHI: r0 r5
      0x0015: PHI (r0v5 android.graphics.Bitmap) = (r0v1 android.graphics.Bitmap), (r0v9 android.graphics.Bitmap) binds: [B:21:0x0030, B:5:0x0013] A[DONT_GENERATE, DONT_INLINE]
      0x0015: PHI (r5v8 java.io.InputStream) = (r5v7 java.io.InputStream), (r5v14 java.io.InputStream) binds: [B:21:0x0030, B:5:0x0013] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Bitmap doInBackground(java.lang.String... r5) throws java.lang.Throwable {
        /*
            r4 = this;
            r0 = 0
            r5 = r5[r0]
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L2f
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L2f
            java.lang.Object r5 = r1.getContent()     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L2f
            java.io.InputStream r5 = (java.io.InputStream) r5     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L2f
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r5)     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L30
            if (r5 == 0) goto L33
        L15:
            r5.close()     // Catch: java.lang.Exception -> L19
            goto L33
        L19:
            r5 = move-exception
            r5.printStackTrace()
            goto L33
        L1e:
            r0 = move-exception
            goto L24
        L20:
            r5 = move-exception
            r3 = r0
            r0 = r5
            r5 = r3
        L24:
            if (r5 == 0) goto L2e
            r5.close()     // Catch: java.lang.Exception -> L2a
            goto L2e
        L2a:
            r5 = move-exception
            r5.printStackTrace()
        L2e:
            throw r0
        L2f:
            r5 = r0
        L30:
            if (r5 == 0) goto L33
            goto L15
        L33:
            java.security.SecureRandom r5 = r4.random
            r1 = 400(0x190, float:5.6E-43)
            int r5 = r5.nextInt(r1)
            long r1 = (long) r5
            java.lang.Thread.sleep(r1)     // Catch: java.lang.InterruptedException -> L40
            goto L44
        L40:
            r5 = move-exception
            r5.printStackTrace()
        L44:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easebuzz.payment.kit.PWEDownloadImageManager.doInBackground(java.lang.String[]):android.graphics.Bitmap");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Bitmap bitmap) throws Throwable {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            this.imageView.setImageBitmap(bitmap);
            PWECacheImageManager.saveImage(this.context, this.fileName, bitmap);
        }
    }
}
