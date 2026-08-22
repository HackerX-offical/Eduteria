package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Gainmap;
import android.graphics.Paint;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapFactory;
import com.bumptech.glide.util.GlideSuppliers;
import com.bumptech.glide.util.Preconditions;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
final class GlideBitmapFactory {
    private static final String TAG = "GlideBitmapFactory";

    private GlideBitmapFactory() {
    }

    public static Bitmap decodeStream(InputStream inputStream, BitmapFactory.Options options, ImageReader imageReader) {
        if (Build.VERSION.SDK_INT == 34 && GainmapDecoderWorkaroundStateCalculator.needsGainmapDecodeWorkaround(options) && isLikelyToContainGainmap(imageReader)) {
            return safeAndExpensiveDecodeHardwareBitmapWithGainmap(inputStream, options);
        }
        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    public static Bitmap decodeByteArray(byte[] bArr, BitmapFactory.Options options, ImageReader imageReader) {
        if (Build.VERSION.SDK_INT == 34 && GainmapDecoderWorkaroundStateCalculator.needsGainmapDecodeWorkaround(options) && isLikelyToContainGainmap(imageReader)) {
            return safeAndExpensiveDecodeHardwareBitmapWithGainmap(bArr, options);
        }
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, BitmapFactory.Options options, ImageReader imageReader) {
        if (Build.VERSION.SDK_INT == 34 && GainmapDecoderWorkaroundStateCalculator.needsGainmapDecodeWorkaround(options) && isLikelyToContainGainmap(imageReader)) {
            return safeAndExpensiveDecodeHardwareBitmapWithGainmap(fileDescriptor, options);
        }
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }

    private static boolean isLikelyToContainGainmap(ImageReader imageReader) {
        try {
            boolean zHasJpegMpf = imageReader.hasJpegMpf();
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "isLikelyToContainGainmap=" + zHasJpegMpf);
            }
            return zHasJpegMpf;
        } catch (IOException e2) {
            if (!Log.isLoggable(TAG, 2)) {
                return false;
            }
            Log.v(TAG, "isLikelyToContainGainmap failed", e2);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0019 A[PHI: r0
      0x0019: PHI (r0v10 android.graphics.Bitmap) = (r0v8 android.graphics.Bitmap), (r0v4 android.graphics.Bitmap) binds: [B:14:0x0025, B:9:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Bitmap safeAndExpensiveDecodeHardwareBitmapWithGainmap(java.io.InputStream r3, android.graphics.BitmapFactory.Options r4) throws java.lang.Throwable {
        /*
            android.graphics.Bitmap$Config r0 = r4.inPreferredConfig
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.HARDWARE
            if (r0 != r1) goto L8
            r0 = 1
            goto L9
        L8:
            r0 = 0
        L9:
            com.bumptech.glide.util.Preconditions.checkArgument(r0)
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
            r4.inPreferredConfig = r0
            r0 = 0
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r3, r0, r4)     // Catch: java.lang.Throwable -> L2a
            if (r3 != 0) goto L21
            if (r3 == 0) goto L1c
        L19:
            r3.recycle()
        L1c:
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.HARDWARE
            r4.inPreferredConfig = r3
            return r0
        L21:
            android.graphics.Bitmap r0 = safeDecodeBitmapWithGainmap(r3)     // Catch: java.lang.Throwable -> L28
            if (r3 == 0) goto L1c
            goto L19
        L28:
            r0 = move-exception
            goto L2e
        L2a:
            r3 = move-exception
            r2 = r0
            r0 = r3
            r3 = r2
        L2e:
            if (r3 == 0) goto L33
            r3.recycle()
        L33:
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.HARDWARE
            r4.inPreferredConfig = r3
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.GlideBitmapFactory.safeAndExpensiveDecodeHardwareBitmapWithGainmap(java.io.InputStream, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b A[PHI: r0
      0x001b: PHI (r0v10 android.graphics.Bitmap) = (r0v8 android.graphics.Bitmap), (r0v4 android.graphics.Bitmap) binds: [B:14:0x0027, B:9:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Bitmap safeAndExpensiveDecodeHardwareBitmapWithGainmap(byte[] r4, android.graphics.BitmapFactory.Options r5) throws java.lang.Throwable {
        /*
            android.graphics.Bitmap$Config r0 = r5.inPreferredConfig
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.HARDWARE
            r2 = 0
            if (r0 != r1) goto L9
            r0 = 1
            goto La
        L9:
            r0 = r2
        La:
            com.bumptech.glide.util.Preconditions.checkArgument(r0)
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
            r5.inPreferredConfig = r0
            r0 = 0
            int r1 = r4.length     // Catch: java.lang.Throwable -> L2c
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeByteArray(r4, r2, r1, r5)     // Catch: java.lang.Throwable -> L2c
            if (r4 != 0) goto L23
            if (r4 == 0) goto L1e
        L1b:
            r4.recycle()
        L1e:
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.HARDWARE
            r5.inPreferredConfig = r4
            return r0
        L23:
            android.graphics.Bitmap r0 = safeDecodeBitmapWithGainmap(r4)     // Catch: java.lang.Throwable -> L2a
            if (r4 == 0) goto L1e
            goto L1b
        L2a:
            r0 = move-exception
            goto L30
        L2c:
            r4 = move-exception
            r3 = r0
            r0 = r4
            r4 = r3
        L30:
            if (r4 == 0) goto L35
            r4.recycle()
        L35:
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.HARDWARE
            r5.inPreferredConfig = r4
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.GlideBitmapFactory.safeAndExpensiveDecodeHardwareBitmapWithGainmap(byte[], android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0019 A[PHI: r0
      0x0019: PHI (r0v10 android.graphics.Bitmap) = (r0v8 android.graphics.Bitmap), (r0v4 android.graphics.Bitmap) binds: [B:14:0x0025, B:9:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Bitmap safeAndExpensiveDecodeHardwareBitmapWithGainmap(java.io.FileDescriptor r3, android.graphics.BitmapFactory.Options r4) throws java.lang.Throwable {
        /*
            android.graphics.Bitmap$Config r0 = r4.inPreferredConfig
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.HARDWARE
            if (r0 != r1) goto L8
            r0 = 1
            goto L9
        L8:
            r0 = 0
        L9:
            com.bumptech.glide.util.Preconditions.checkArgument(r0)
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
            r4.inPreferredConfig = r0
            r0 = 0
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeFileDescriptor(r3, r0, r4)     // Catch: java.lang.Throwable -> L2a
            if (r3 != 0) goto L21
            if (r3 == 0) goto L1c
        L19:
            r3.recycle()
        L1c:
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.HARDWARE
            r4.inPreferredConfig = r3
            return r0
        L21:
            android.graphics.Bitmap r0 = safeDecodeBitmapWithGainmap(r3)     // Catch: java.lang.Throwable -> L28
            if (r3 == 0) goto L1c
            goto L19
        L28:
            r0 = move-exception
            goto L2e
        L2a:
            r3 = move-exception
            r2 = r0
            r0 = r3
            r3 = r2
        L2e:
            if (r3 == 0) goto L33
            r3.recycle()
        L33:
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.HARDWARE
            r4.inPreferredConfig = r3
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.GlideBitmapFactory.safeAndExpensiveDecodeHardwareBitmapWithGainmap(java.io.FileDescriptor, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    private static Bitmap safeDecodeBitmapWithGainmap(Bitmap bitmap) {
        Gainmap gainmap = bitmap.getGainmap();
        if (gainmap != null && gainmap.getGainmapContents().getConfig() == Bitmap.Config.ALPHA_8) {
            bitmap.setGainmap(GainmapCopier.convertSingleChannelGainmapToTripleChannelGainmap(gainmap));
        }
        return bitmap.copy(Bitmap.Config.HARDWARE, false);
    }

    private static final class GainmapCopier {
        private static final ColorMatrixColorFilter OPAQUE_FILTER = new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 255.0f});

        private GainmapCopier() {
        }

        public static Gainmap convertSingleChannelGainmapToTripleChannelGainmap(Gainmap gainmap) {
            Bitmap gainmapContents = gainmap.getGainmapContents();
            if (gainmapContents.getConfig() != Bitmap.Config.ALPHA_8) {
                return gainmap;
            }
            Gainmap gainmap2 = new Gainmap(copyAlpha8ToOpaqueArgb888(gainmapContents));
            float[] ratioMin = gainmap.getRatioMin();
            gainmap2.setRatioMin(ratioMin[0], ratioMin[1], ratioMin[2]);
            float[] ratioMax = gainmap.getRatioMax();
            gainmap2.setRatioMax(ratioMax[0], ratioMax[1], ratioMax[2]);
            float[] gamma = gainmap.getGamma();
            gainmap2.setGamma(gamma[0], gamma[1], gamma[2]);
            float[] epsilonSdr = gainmap.getEpsilonSdr();
            gainmap2.setEpsilonSdr(epsilonSdr[0], epsilonSdr[1], epsilonSdr[2]);
            float[] epsilonHdr = gainmap.getEpsilonHdr();
            gainmap2.setEpsilonHdr(epsilonHdr[0], epsilonHdr[1], epsilonHdr[2]);
            gainmap2.setDisplayRatioForFullHdr(gainmap.getDisplayRatioForFullHdr());
            gainmap2.setMinDisplayRatioForHdrTransition(gainmap.getMinDisplayRatioForHdrTransition());
            return gainmap2;
        }

        private static Bitmap copyAlpha8ToOpaqueArgb888(Bitmap bitmap) {
            Preconditions.checkArgument(bitmap.getConfig() == Bitmap.Config.ALPHA_8);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            paint.setColorFilter(OPAQUE_FILTER);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            canvas.setBitmap(null);
            return bitmapCreateBitmap;
        }
    }

    public static final class GainmapDecoderWorkaroundStateCalculator {
        private static final GlideSuppliers.GlideSupplier<Boolean> REQUIRES_GAIN_MAP_FIX = GlideSuppliers.memorize(new GlideSuppliers.GlideSupplier() { // from class: com.bumptech.glide.load.resource.bitmap.GlideBitmapFactory$GainmapDecoderWorkaroundStateCalculator$$ExternalSyntheticLambda0
            @Override // com.bumptech.glide.util.GlideSuppliers.GlideSupplier
            public final Object get() {
                return Boolean.valueOf(GlideBitmapFactory.GainmapDecoderWorkaroundStateCalculator.calculateNeedsGainmapDecodeWorkaround());
            }
        });
        private static final String TAG = "GainmapWorkaroundCalc";

        private GainmapDecoderWorkaroundStateCalculator() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean needsGainmapDecodeWorkaround(BitmapFactory.Options options) {
            if (Build.VERSION.SDK_INT == 34 && options.inPreferredConfig == Bitmap.Config.HARDWARE) {
                return REQUIRES_GAIN_MAP_FIX.get().booleanValue();
            }
            return false;
        }

        private static boolean calculateNeedsGainmapDecodeWorkaround() {
            if (Build.VERSION.SDK_INT != 34) {
                return false;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
            Bitmap bitmapCopy = bitmapCreateBitmap.copy(Bitmap.Config.HARDWARE, false);
            bitmapCreateBitmap.recycle();
            boolean z = bitmapCopy == null;
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "calculateNeedsGainmapDecodeWorkaround=" + z);
            }
            if (bitmapCopy != null) {
                bitmapCopy.recycle();
            }
            return z;
        }
    }
}
