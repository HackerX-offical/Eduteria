package com.google.android.material.carousel;

import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
final class KeylineState {
    private final int firstFocalKeylineIndex;
    private final float itemSize;
    private final List<Keyline> keylines;
    private final int lastFocalKeylineIndex;

    private KeylineState(float f2, List<Keyline> list, int i, int i2) {
        this.itemSize = f2;
        this.keylines = Collections.unmodifiableList(list);
        this.firstFocalKeylineIndex = i;
        this.lastFocalKeylineIndex = i2;
    }

    float getItemSize() {
        return this.itemSize;
    }

    List<Keyline> getKeylines() {
        return this.keylines;
    }

    Keyline getFirstFocalKeyline() {
        return this.keylines.get(this.firstFocalKeylineIndex);
    }

    int getFirstFocalKeylineIndex() {
        return this.firstFocalKeylineIndex;
    }

    Keyline getLastFocalKeyline() {
        return this.keylines.get(this.lastFocalKeylineIndex);
    }

    int getLastFocalKeylineIndex() {
        return this.lastFocalKeylineIndex;
    }

    Keyline getFirstKeyline() {
        return this.keylines.get(0);
    }

    Keyline getLastKeyline() {
        return this.keylines.get(r0.size() - 1);
    }

    static KeylineState lerp(KeylineState keylineState, KeylineState keylineState2, float f2) {
        if (keylineState.getItemSize() != keylineState2.getItemSize()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
        }
        List<Keyline> keylines = keylineState.getKeylines();
        List<Keyline> keylines2 = keylineState2.getKeylines();
        if (keylines.size() != keylines2.size()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < keylineState.getKeylines().size(); i++) {
            arrayList.add(Keyline.lerp(keylines.get(i), keylines2.get(i), f2));
        }
        return new KeylineState(keylineState.getItemSize(), arrayList, AnimationUtils.lerp(keylineState.getFirstFocalKeylineIndex(), keylineState2.getFirstFocalKeylineIndex(), f2), AnimationUtils.lerp(keylineState.getLastFocalKeylineIndex(), keylineState2.getLastFocalKeylineIndex(), f2));
    }

    static KeylineState reverse(KeylineState keylineState) {
        Builder builder = new Builder(keylineState.getItemSize());
        float f2 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
        int size = keylineState.getKeylines().size() - 1;
        while (size >= 0) {
            Keyline keyline = keylineState.getKeylines().get(size);
            builder.addKeyline((keyline.maskedItemSize / 2.0f) + f2, keyline.mask, keyline.maskedItemSize, size >= keylineState.getFirstFocalKeylineIndex() && size <= keylineState.getLastFocalKeylineIndex());
            f2 += keyline.maskedItemSize;
            size--;
        }
        return builder.build();
    }

    static final class Builder {
        private static final int NO_INDEX = -1;
        private static final float UNKNOWN_LOC = Float.MIN_VALUE;
        private final float itemSize;
        private Keyline tmpFirstFocalKeyline;
        private Keyline tmpLastFocalKeyline;
        private final List<Keyline> tmpKeylines = new ArrayList();
        private int firstFocalKeylineIndex = -1;
        private int lastFocalKeylineIndex = -1;
        private float lastKeylineMaskedSize = 0.0f;

        private static float calculateKeylineLocationForItemPosition(float f2, float f3, int i, int i2) {
            return (f2 - (i * f3)) + (i2 * f3);
        }

        Builder(float f2) {
            this.itemSize = f2;
        }

        Builder addKeyline(float f2, float f3, float f4) {
            return addKeyline(f2, f3, f4, false);
        }

        Builder addKeyline(float f2, float f3, float f4, boolean z) {
            if (f4 <= 0.0f) {
                return this;
            }
            Keyline keyline = new Keyline(Float.MIN_VALUE, f2, f3, f4);
            if (z) {
                if (this.tmpFirstFocalKeyline == null) {
                    this.tmpFirstFocalKeyline = keyline;
                    this.firstFocalKeylineIndex = this.tmpKeylines.size();
                }
                if (this.lastFocalKeylineIndex != -1 && this.tmpKeylines.size() - this.lastFocalKeylineIndex > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f4 != this.tmpFirstFocalKeyline.maskedItemSize) {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
                this.tmpLastFocalKeyline = keyline;
                this.lastFocalKeylineIndex = this.tmpKeylines.size();
            } else {
                if (this.tmpFirstFocalKeyline == null && keyline.maskedItemSize < this.lastKeylineMaskedSize) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                }
                if (this.tmpLastFocalKeyline != null && keyline.maskedItemSize > this.lastKeylineMaskedSize) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.lastKeylineMaskedSize = keyline.maskedItemSize;
            this.tmpKeylines.add(keyline);
            return this;
        }

        Builder addKeylineRange(float f2, float f3, float f4, int i) {
            return addKeylineRange(f2, f3, f4, i, false);
        }

        Builder addKeylineRange(float f2, float f3, float f4, int i, boolean z) {
            if (i > 0 && f4 > 0.0f) {
                for (int i2 = 0; i2 < i; i2++) {
                    addKeyline((i2 * f4) + f2, f3, f4, z);
                }
            }
            return this;
        }

        KeylineState build() {
            if (this.tmpFirstFocalKeyline == null) {
                throw new IllegalStateException("There must be a keyline marked as focal.");
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.tmpKeylines.size(); i++) {
                Keyline keyline = this.tmpKeylines.get(i);
                arrayList.add(new Keyline(calculateKeylineLocationForItemPosition(this.tmpFirstFocalKeyline.locOffset, this.itemSize, this.firstFocalKeylineIndex, i), keyline.locOffset, keyline.mask, keyline.maskedItemSize));
            }
            return new KeylineState(this.itemSize, arrayList, this.firstFocalKeylineIndex, this.lastFocalKeylineIndex);
        }
    }

    static final class Keyline {
        final float loc;
        final float locOffset;
        final float mask;
        final float maskedItemSize;

        Keyline(float f2, float f3, float f4, float f5) {
            this.loc = f2;
            this.locOffset = f3;
            this.mask = f4;
            this.maskedItemSize = f5;
        }

        static Keyline lerp(Keyline keyline, Keyline keyline2, float f2) {
            return new Keyline(AnimationUtils.lerp(keyline.loc, keyline2.loc, f2), AnimationUtils.lerp(keyline.locOffset, keyline2.locOffset, f2), AnimationUtils.lerp(keyline.mask, keyline2.mask, f2), AnimationUtils.lerp(keyline.maskedItemSize, keyline2.maskedItemSize, f2));
        }
    }
}
