package com.google.android.material.carousel;

import android.view.View;

/* JADX INFO: loaded from: classes8.dex */
public abstract class CarouselStrategy {
    static float getChildMaskPercentage(float f2, float f3, float f4) {
        return 1.0f - ((f2 - f4) / (f3 - f4));
    }

    abstract KeylineState onFirstChildMeasuredWithMargins(Carousel carousel, View view);
}
