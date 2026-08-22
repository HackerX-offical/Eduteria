package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes6.dex */
public interface BitmapPool {
    void clearMemory();

    Bitmap get(int i, int i2, Bitmap.Config config);

    Bitmap getDirty(int i, int i2, Bitmap.Config config);

    long getMaxSize();

    void put(Bitmap bitmap);

    void setSizeMultiplier(float f2);

    void trimMemory(int i);
}
