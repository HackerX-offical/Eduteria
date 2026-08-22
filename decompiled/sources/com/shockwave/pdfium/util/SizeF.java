package com.shockwave.pdfium.util;

/* JADX INFO: loaded from: classes9.dex */
public class SizeF {
    private final float height;
    private final float width;

    public SizeF(float f2, float f3) {
        this.width = f2;
        this.height = f3;
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof SizeF) {
            SizeF sizeF = (SizeF) obj;
            if (this.width == sizeF.width && this.height == sizeF.height) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return this.width + "x" + this.height;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.width) ^ Float.floatToIntBits(this.height);
    }

    public Size toSize() {
        return new Size((int) this.width, (int) this.height);
    }
}
