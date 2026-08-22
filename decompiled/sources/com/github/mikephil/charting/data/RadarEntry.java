package com.github.mikephil.charting.data;

/* JADX INFO: loaded from: classes7.dex */
public class RadarEntry extends Entry {
    public RadarEntry(float f2) {
        super(0.0f, f2);
    }

    public RadarEntry(float f2, Object obj) {
        super(0.0f, f2, obj);
    }

    public float getValue() {
        return getY();
    }

    @Override // com.github.mikephil.charting.data.Entry
    public RadarEntry copy() {
        return new RadarEntry(getY(), getData());
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public void setX(float f2) {
        super.setX(f2);
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public float getX() {
        return super.getX();
    }
}
