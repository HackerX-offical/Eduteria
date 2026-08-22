package com.appnew.android.Utils.imagecropper;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import com.appnew.android.Utils.imagecropper.MonitoredActivity;
import java.io.Closeable;

/* JADX INFO: loaded from: classes6.dex */
public class Util {
    private static final String TAG = "db.Util";

    private Util() {
    }

    public static Bitmap transform(Matrix scaler, Bitmap source, int targetWidth, int targetHeight, boolean scaleUp) {
        Matrix matrix;
        Matrix matrix2;
        int width = source.getWidth() - targetWidth;
        int height = source.getHeight() - targetHeight;
        if (!scaleUp && (width < 0 || height < 0)) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(targetWidth, targetHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            int iMax = Math.max(0, width / 2);
            int iMax2 = Math.max(0, height / 2);
            Rect rect = new Rect(iMax, iMax2, Math.min(targetWidth, source.getWidth()) + iMax, Math.min(targetHeight, source.getHeight()) + iMax2);
            int iWidth = (targetWidth - rect.width()) / 2;
            int iHeight = (targetHeight - rect.height()) / 2;
            canvas.drawBitmap(source, rect, new Rect(iWidth, iHeight, targetWidth - iWidth, targetHeight - iHeight), (Paint) null);
            return bitmapCreateBitmap;
        }
        float width2 = source.getWidth();
        float height2 = source.getHeight();
        float f2 = targetWidth;
        float f3 = targetHeight;
        if (width2 / height2 > f2 / f3) {
            float f4 = f3 / height2;
            if (f4 < 0.9f || f4 > 1.0f) {
                scaler.setScale(f4, f4);
                matrix2 = scaler;
            } else {
                matrix2 = null;
            }
            matrix = matrix2;
        } else {
            float f5 = f2 / width2;
            if (f5 < 0.9f || f5 > 1.0f) {
                scaler.setScale(f5, f5);
                matrix = scaler;
            } else {
                matrix = null;
            }
        }
        Bitmap bitmapCreateBitmap2 = matrix != null ? Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true) : source;
        Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(bitmapCreateBitmap2, Math.max(0, bitmapCreateBitmap2.getWidth() - targetWidth) / 2, Math.max(0, bitmapCreateBitmap2.getHeight() - targetHeight) / 2, targetWidth, targetHeight);
        if (bitmapCreateBitmap2 != source) {
            bitmapCreateBitmap2.recycle();
        }
        return bitmapCreateBitmap3;
    }

    public static void closeSilently(Closeable c2) {
        if (c2 == null) {
            return;
        }
        try {
            c2.close();
        } catch (Throwable unused) {
        }
    }

    private static class BackgroundJob extends MonitoredActivity.LifeCycleAdapter implements Runnable {
        private final MonitoredActivity mActivity;
        private final Runnable mCleanupRunner = new Runnable() { // from class: com.appnew.android.Utils.imagecropper.Util.BackgroundJob.1
            @Override // java.lang.Runnable
            public void run() {
                BackgroundJob.this.mActivity.removeLifeCycleListener(BackgroundJob.this);
                if (BackgroundJob.this.mDialog.getWindow() != null) {
                    BackgroundJob.this.mDialog.dismiss();
                }
            }
        };
        private final ProgressDialog mDialog;
        private final Handler mHandler;
        private final Runnable mJob;

        public BackgroundJob(MonitoredActivity activity, Runnable job, ProgressDialog dialog, Handler handler) {
            this.mActivity = activity;
            this.mDialog = dialog;
            this.mJob = job;
            activity.addLifeCycleListener(this);
            this.mHandler = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mJob.run();
            } finally {
                this.mHandler.post(this.mCleanupRunner);
            }
        }

        @Override // com.appnew.android.Utils.imagecropper.MonitoredActivity.LifeCycleAdapter, com.appnew.android.Utils.imagecropper.MonitoredActivity.LifeCycleListener
        public void onActivityDestroyed(MonitoredActivity activity) {
            this.mCleanupRunner.run();
            this.mHandler.removeCallbacks(this.mCleanupRunner);
        }

        @Override // com.appnew.android.Utils.imagecropper.MonitoredActivity.LifeCycleAdapter, com.appnew.android.Utils.imagecropper.MonitoredActivity.LifeCycleListener
        public void onActivityStopped(MonitoredActivity activity) {
            this.mDialog.dismiss();
        }

        @Override // com.appnew.android.Utils.imagecropper.MonitoredActivity.LifeCycleAdapter, com.appnew.android.Utils.imagecropper.MonitoredActivity.LifeCycleListener
        public void onActivityStarted(MonitoredActivity activity) {
            this.mDialog.show();
        }
    }

    public static void startBackgroundJob(MonitoredActivity activity, String title, String message, Runnable job, Handler handler) {
        new Thread(new BackgroundJob(activity, job, ProgressDialog.show(activity, title, message, true, false), handler)).start();
    }

    public static BitmapFactory.Options createNativeAllocOptions() {
        return new BitmapFactory.Options();
    }

    public static Bitmap rotateImage(Bitmap src, float degree) {
        try {
            Matrix matrix = new Matrix();
            matrix.postRotate(degree);
            return Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), matrix, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int getOrientationInDegree(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 0) {
            return 0;
        }
        if (rotation == 1) {
            return 90;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : 270;
        }
        return 180;
    }
}
