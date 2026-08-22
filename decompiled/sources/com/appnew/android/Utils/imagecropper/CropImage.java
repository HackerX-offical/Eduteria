package com.appnew.android.Utils.imagecropper;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.media.FaceDetector;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.imagecropper.BitmapManager;
import com.eduteria.app.app.R;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes6.dex */
public class CropImage extends MonitoredActivity {
    public static final String ACTION_INLINE_DATA = "inline-data";
    public static final String ASPECT_X = "aspectX";
    public static final String ASPECT_Y = "aspectY";
    public static final int CANNOT_STAT_ERROR = -2;
    public static final String CIRCLE_CROP = "circleCrop";
    public static final String IMAGE_PATH = "image-path";
    public static final int NO_STORAGE_ERROR = -1;
    public static final String ORIENTATION_IN_DEGREES = "orientation_in_degrees";
    public static final String OUTPUT_X = "outputX";
    public static final String OUTPUT_Y = "outputY";
    public static final String RETURN_DATA = "return-data";
    public static final String RETURN_DATA_AS_BITMAP = "data";
    public static final String SCALE = "scale";
    public static final String SCALE_UP_IF_NEEDED = "scaleUpIfNeeded";
    private static final String TAG = "CropImage";
    private int mAspectX;
    private int mAspectY;
    private Bitmap mBitmap;
    private ContentResolver mContentResolver;
    HighlightView mCrop;
    private String mImagePath;
    private CropImageViews mImageView;
    private int mOutputX;
    private int mOutputY;
    boolean mSaving;
    private boolean mScale;
    boolean mWaitingToPick;
    final int IMAGE_MAX_SIZE = 1024;
    private Bitmap.CompressFormat mOutputFormat = Bitmap.CompressFormat.JPEG;
    private Uri mSaveUri = null;
    private boolean mDoFaceDetection = true;
    private boolean mCircleCrop = false;
    private final Handler mHandler = new Handler();
    private boolean mScaleUp = true;
    private final BitmapManager.ThreadSet mDecodingThreads = new BitmapManager.ThreadSet();
    Runnable mRunFaceDetection = new AnonymousClass7();

    @Override // com.appnew.android.Utils.imagecropper.MonitoredActivity, android.app.Activity
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        this.mContentResolver = getContentResolver();
        requestWindowFeature(1);
        setContentView(R.layout.cropimage);
        CropImageViews cropImageViews = (CropImageViews) findViewById(R.id.image);
        this.mImageView = cropImageViews;
        cropImageViews.setBackgroundColor(getResources().getColor(R.color.blue));
        showStorageToast(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.getString(CIRCLE_CROP) != null) {
                this.mImageView.setLayerType(1, null);
                this.mCircleCrop = true;
                this.mAspectX = 1;
                this.mAspectY = 1;
            }
            String string = extras.getString(IMAGE_PATH);
            this.mImagePath = string;
            this.mSaveUri = getImageUri(string);
            this.mBitmap = Helper.decodeSampledBitmap(this.mImagePath, 300, 300);
            if (extras.containsKey(ASPECT_X) && (extras.get(ASPECT_X) instanceof Integer)) {
                this.mAspectX = extras.getInt(ASPECT_X);
                if (extras.containsKey(ASPECT_Y) && (extras.get(ASPECT_Y) instanceof Integer)) {
                    this.mAspectY = extras.getInt(ASPECT_Y);
                    this.mOutputX = extras.getInt(OUTPUT_X);
                    this.mOutputY = extras.getInt(OUTPUT_Y);
                    this.mScale = extras.getBoolean(SCALE, false);
                    this.mScaleUp = extras.getBoolean(SCALE_UP_IF_NEEDED, false);
                } else {
                    throw new IllegalArgumentException("aspect_y must be integer");
                }
            } else {
                throw new IllegalArgumentException("aspect_x must be integer");
            }
        }
        if (this.mBitmap == null) {
            finish();
            return;
        }
        getWindow().addFlags(1024);
        ((Button) findViewById(R.id.discard)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.imagecropper.CropImage.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                CropImage.this.setResult(0);
                CropImage.this.finish();
            }
        });
        ((Button) findViewById(R.id.save)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.imagecropper.CropImage.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    CropImage.this.onSaveClicked();
                } catch (Exception unused) {
                    CropImage.this.finish();
                }
            }
        });
        ((ImageButton) findViewById(R.id.rotateLeft)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.imagecropper.CropImage.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                CropImage cropImage = CropImage.this;
                cropImage.mBitmap = Util.rotateImage(cropImage.mBitmap, -90.0f);
                CropImage.this.mImageView.setImageRotateBitmapResetBase(new RotateBitmap(CropImage.this.mBitmap), true);
                CropImage.this.mRunFaceDetection.run();
            }
        });
        ((ImageButton) findViewById(R.id.rotateRight)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.imagecropper.CropImage.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                CropImage cropImage = CropImage.this;
                cropImage.mBitmap = Util.rotateImage(cropImage.mBitmap, 90.0f);
                CropImage.this.mImageView.setImageRotateBitmapResetBase(new RotateBitmap(CropImage.this.mBitmap), true);
                CropImage.this.mRunFaceDetection.run();
            }
        });
        startFaceDetection();
    }

    private Uri getImageUri(String path) {
        return Uri.fromFile(new File(path));
    }

    private Bitmap getBitmap(String path) {
        Uri imageUri = getImageUri(path);
        try {
            InputStream inputStreamOpenInputStream = this.mContentResolver.openInputStream(imageUri);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
            inputStreamOpenInputStream.close();
            int iPow = (options.outHeight > 1024 || options.outWidth > 1024) ? (int) Math.pow(2.0d, (int) Math.round(Math.log(1024.0d / ((double) Math.max(options.outHeight, options.outWidth))) / Math.log(0.5d))) : 1;
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = iPow;
            InputStream inputStreamOpenInputStream2 = this.mContentResolver.openInputStream(imageUri);
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream2, null, options2);
            inputStreamOpenInputStream2.close();
            return bitmapDecodeStream;
        } catch (FileNotFoundException | IOException unused) {
            return null;
        }
    }

    private void startFaceDetection() {
        if (isFinishing()) {
            return;
        }
        this.mImageView.setImageBitmapResetBase(this.mBitmap, true);
        Util.startBackgroundJob(this, null, "Please wait…", new Runnable() { // from class: com.appnew.android.Utils.imagecropper.CropImage.5
            @Override // java.lang.Runnable
            public void run() {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                final Bitmap bitmap = CropImage.this.mBitmap;
                CropImage.this.mHandler.post(new Runnable() { // from class: com.appnew.android.Utils.imagecropper.CropImage.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bitmap != CropImage.this.mBitmap && bitmap != null) {
                            CropImage.this.mImageView.setImageBitmapResetBase(bitmap, true);
                            CropImage.this.mBitmap.recycle();
                            CropImage.this.mBitmap = bitmap;
                        }
                        if (CropImage.this.mImageView.getScale() == 1.0f) {
                            CropImage.this.mImageView.center(true, true);
                        }
                        countDownLatch.countDown();
                    }
                });
                try {
                    countDownLatch.await();
                    CropImage.this.mRunFaceDetection.run();
                } catch (InterruptedException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }, this.mHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSaveClicked() throws Exception {
        HighlightView highlightView;
        int i;
        Bitmap bitmapCreateBitmap;
        if (this.mSaving || (highlightView = this.mCrop) == null) {
            return;
        }
        this.mSaving = true;
        Rect cropRect = highlightView.getCropRect();
        int iWidth = cropRect.width();
        int iHeight = cropRect.height();
        final Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(iWidth, iHeight, this.mCircleCrop ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        if (bitmapCreateBitmap2 == null) {
            return;
        }
        new Canvas(bitmapCreateBitmap2).drawBitmap(this.mBitmap, cropRect, new Rect(0, 0, iWidth, iHeight), (Paint) null);
        if (this.mCircleCrop) {
            Canvas canvas = new Canvas(bitmapCreateBitmap2);
            Path path = new Path();
            float f2 = iWidth / 2.0f;
            path.addCircle(f2, iHeight / 2.0f, f2, Path.Direction.CW);
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        int i2 = this.mOutputX;
        if (i2 != 0 && (i = this.mOutputY) != 0) {
            if (this.mScale) {
                bitmapCreateBitmap = Util.transform(new Matrix(), bitmapCreateBitmap2, this.mOutputX, this.mOutputY, this.mScaleUp);
                if (bitmapCreateBitmap2 != bitmapCreateBitmap) {
                    bitmapCreateBitmap2.recycle();
                }
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.RGB_565);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                Rect cropRect2 = this.mCrop.getCropRect();
                Rect rect = new Rect(0, 0, this.mOutputX, this.mOutputY);
                int iWidth2 = (cropRect2.width() - rect.width()) / 2;
                int iHeight2 = (cropRect2.height() - rect.height()) / 2;
                cropRect2.inset(Math.max(0, iWidth2), Math.max(0, iHeight2));
                rect.inset(Math.max(0, -iWidth2), Math.max(0, -iHeight2));
                canvas2.drawBitmap(this.mBitmap, cropRect2, rect, (Paint) null);
                bitmapCreateBitmap2.recycle();
            }
            bitmapCreateBitmap2 = bitmapCreateBitmap;
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null && (extras.getParcelable("data") != null || extras.getBoolean(RETURN_DATA))) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("data", bitmapCreateBitmap2);
            setResult(-1, new Intent().setAction(ACTION_INLINE_DATA).putExtras(bundle));
            finish();
            return;
        }
        Util.startBackgroundJob(this, null, getString(R.string.saving_image), new Runnable() { // from class: com.appnew.android.Utils.imagecropper.CropImage.6
            @Override // java.lang.Runnable
            public void run() {
                CropImage.this.saveOutput(bitmapCreateBitmap2);
            }
        }, this.mHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveOutput(Bitmap croppedImage) {
        Uri uri = this.mSaveUri;
        if (uri != null) {
            OutputStream outputStreamOpenOutputStream = null;
            try {
                try {
                    outputStreamOpenOutputStream = this.mContentResolver.openOutputStream(uri);
                    if (outputStreamOpenOutputStream != null) {
                        croppedImage.compress(this.mOutputFormat, 90, outputStreamOpenOutputStream);
                    }
                    Util.closeSilently(outputStreamOpenOutputStream);
                    Bundle bundle = new Bundle();
                    Intent intent = new Intent(this.mSaveUri.toString());
                    intent.putExtras(bundle);
                    intent.putExtra(IMAGE_PATH, this.mImagePath);
                    intent.putExtra(ORIENTATION_IN_DEGREES, Util.getOrientationInDegree(this));
                    setResult(-1, intent);
                } catch (IOException unused) {
                    setResult(0);
                    finish();
                    Util.closeSilently(outputStreamOpenOutputStream);
                    return;
                }
            } catch (Throwable th) {
                Util.closeSilently(outputStreamOpenOutputStream);
                throw th;
            }
        }
        croppedImage.recycle();
        finish();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        BitmapManager.instance().cancelThreadDecoding(this.mDecodingThreads);
    }

    @Override // com.appnew.android.Utils.imagecropper.MonitoredActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.Utils.imagecropper.CropImage$7, reason: invalid class name */
    class AnonymousClass7 implements Runnable {
        Matrix mImageMatrix;
        int mNumFaces;
        float mScale = 1.0f;
        FaceDetector.Face[] mFaces = new FaceDetector.Face[3];

        AnonymousClass7() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleFace(FaceDetector.Face f2) {
            PointF pointF = new PointF();
            int iEyesDistance = ((int) (f2.eyesDistance() * this.mScale)) * 2;
            f2.getMidPoint(pointF);
            pointF.x *= this.mScale;
            pointF.y *= this.mScale;
            int i = (int) pointF.x;
            int i2 = (int) pointF.y;
            HighlightView highlightView = new HighlightView(CropImage.this.mImageView);
            boolean z = false;
            Rect rect = new Rect(0, 0, CropImage.this.mBitmap.getWidth(), CropImage.this.mBitmap.getHeight());
            float f3 = i;
            float f4 = i2;
            RectF rectF = new RectF(f3, f4, f3, f4);
            float f5 = -iEyesDistance;
            rectF.inset(f5, f5);
            if (rectF.left < 0.0f) {
                rectF.inset(-rectF.left, -rectF.left);
            }
            if (rectF.top < 0.0f) {
                rectF.inset(-rectF.top, -rectF.top);
            }
            if (rectF.right > rect.right) {
                rectF.inset(rectF.right - rect.right, rectF.right - rect.right);
            }
            if (rectF.bottom > rect.bottom) {
                rectF.inset(rectF.bottom - rect.bottom, rectF.bottom - rect.bottom);
            }
            Matrix matrix = this.mImageMatrix;
            boolean z2 = CropImage.this.mCircleCrop;
            if (CropImage.this.mAspectX != 0 && CropImage.this.mAspectY != 0) {
                z = true;
            }
            highlightView.setup(matrix, rect, rectF, z2, z);
            CropImage.this.mImageView.add(highlightView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void makeDefault() {
            int i;
            HighlightView highlightView = new HighlightView(CropImage.this.mImageView);
            int width = CropImage.this.mBitmap.getWidth();
            int height = CropImage.this.mBitmap.getHeight();
            boolean z = false;
            Rect rect = new Rect(0, 0, width, height);
            int iMin = (Math.min(width, height) * 4) / 5;
            if (CropImage.this.mAspectX == 0 || CropImage.this.mAspectY == 0) {
                i = iMin;
            } else if (CropImage.this.mAspectX > CropImage.this.mAspectY) {
                i = (CropImage.this.mAspectY * iMin) / CropImage.this.mAspectX;
            } else {
                i = iMin;
                iMin = (CropImage.this.mAspectX * iMin) / CropImage.this.mAspectY;
            }
            RectF rectF = new RectF((width - iMin) / 2, (height - i) / 2, r1 + iMin, r3 + i);
            Matrix matrix = this.mImageMatrix;
            boolean z2 = CropImage.this.mCircleCrop;
            if (CropImage.this.mAspectX != 0 && CropImage.this.mAspectY != 0) {
                z = true;
            }
            highlightView.setup(matrix, rect, rectF, z2, z);
            CropImage.this.mImageView.mHighlightViews.clear();
            CropImage.this.mImageView.add(highlightView);
        }

        private Bitmap prepareBitmap() {
            if (CropImage.this.mBitmap == null) {
                return null;
            }
            if (CropImage.this.mBitmap.getWidth() > 256) {
                this.mScale = 256.0f / CropImage.this.mBitmap.getWidth();
            }
            Matrix matrix = new Matrix();
            float f2 = this.mScale;
            matrix.setScale(f2, f2);
            return Bitmap.createBitmap(CropImage.this.mBitmap, 0, 0, CropImage.this.mBitmap.getWidth(), CropImage.this.mBitmap.getHeight(), matrix, true);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mImageMatrix = CropImage.this.mImageView.getImageMatrix();
            Bitmap bitmapPrepareBitmap = prepareBitmap();
            this.mScale = 1.0f / this.mScale;
            if (bitmapPrepareBitmap != null && CropImage.this.mDoFaceDetection) {
                this.mNumFaces = new FaceDetector(bitmapPrepareBitmap.getWidth(), bitmapPrepareBitmap.getHeight(), this.mFaces.length).findFaces(bitmapPrepareBitmap, this.mFaces);
            }
            if (bitmapPrepareBitmap != null && bitmapPrepareBitmap != CropImage.this.mBitmap) {
                bitmapPrepareBitmap.recycle();
            }
            CropImage.this.mHandler.post(new Runnable() { // from class: com.appnew.android.Utils.imagecropper.CropImage.7.1
                @Override // java.lang.Runnable
                public void run() {
                    CropImage.this.mWaitingToPick = AnonymousClass7.this.mNumFaces > 1;
                    if (AnonymousClass7.this.mNumFaces > 0) {
                        for (int i = 0; i < AnonymousClass7.this.mNumFaces; i++) {
                            AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                            anonymousClass7.handleFace(anonymousClass7.mFaces[i]);
                        }
                    } else {
                        AnonymousClass7.this.makeDefault();
                    }
                    CropImage.this.mImageView.invalidate();
                    if (CropImage.this.mImageView.mHighlightViews.size() == 1) {
                        CropImage.this.mCrop = CropImage.this.mImageView.mHighlightViews.get(0);
                        CropImage.this.mCrop.setFocus(true);
                    }
                    if (AnonymousClass7.this.mNumFaces > 1) {
                        Toast.makeText(CropImage.this, R.string.multi_face_crop_help, 0).show();
                    }
                }
            });
        }
    }

    public static void showStorageToast(Activity activity) {
        showStorageToast(activity, calculatePicturesRemaining(activity));
    }

    public static void showStorageToast(Activity activity, int remaining) {
        String string;
        if (remaining == -1) {
            if (Environment.getExternalStorageState().equals("checking")) {
                string = activity.getString(R.string.preparing_card);
            } else {
                string = activity.getString(R.string.no_storage_card);
            }
        } else {
            string = remaining < 1 ? activity.getString(R.string.not_enough_space) : null;
        }
        if (string != null) {
            Toast.makeText(activity, string, 1).show();
        }
    }

    public static int calculatePicturesRemaining(Activity activity) {
        String string;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                string = Environment.getExternalStorageDirectory().toString();
            } else {
                string = activity.getFilesDir().toString();
            }
            StatFs statFs = new StatFs(string);
            return (int) ((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 400000.0f);
        } catch (Exception unused) {
            return -2;
        }
    }
}
