package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class CircleOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CircleOptions> CREATOR = new zzc();
    private int fillColor;
    private int strokeColor;
    private LatLng zzcp;
    private double zzcq;
    private float zzcr;
    private float zzcs;
    private boolean zzct;
    private boolean zzcu;
    private List<PatternItem> zzcv;

    public CircleOptions() {
        this.zzcp = null;
        this.zzcq = 0.0d;
        this.zzcr = 10.0f;
        this.strokeColor = -16777216;
        this.fillColor = 0;
        this.zzcs = 0.0f;
        this.zzct = true;
        this.zzcu = false;
        this.zzcv = null;
    }

    CircleOptions(LatLng latLng, double d2, float f2, int i, int i2, float f3, boolean z, boolean z2, List<PatternItem> list) {
        this.zzcp = latLng;
        this.zzcq = d2;
        this.zzcr = f2;
        this.strokeColor = i;
        this.fillColor = i2;
        this.zzcs = f3;
        this.zzct = z;
        this.zzcu = z2;
        this.zzcv = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getCenter(), i, false);
        SafeParcelWriter.writeDouble(parcel, 3, getRadius());
        SafeParcelWriter.writeFloat(parcel, 4, getStrokeWidth());
        SafeParcelWriter.writeInt(parcel, 5, getStrokeColor());
        SafeParcelWriter.writeInt(parcel, 6, getFillColor());
        SafeParcelWriter.writeFloat(parcel, 7, getZIndex());
        SafeParcelWriter.writeBoolean(parcel, 8, isVisible());
        SafeParcelWriter.writeBoolean(parcel, 9, isClickable());
        SafeParcelWriter.writeTypedList(parcel, 10, getStrokePattern(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final CircleOptions center(LatLng latLng) {
        this.zzcp = latLng;
        return this;
    }

    public final CircleOptions radius(double d2) {
        this.zzcq = d2;
        return this;
    }

    public final CircleOptions strokeWidth(float f2) {
        this.zzcr = f2;
        return this;
    }

    public final CircleOptions strokeColor(int i) {
        this.strokeColor = i;
        return this;
    }

    public final CircleOptions strokePattern(List<PatternItem> list) {
        this.zzcv = list;
        return this;
    }

    public final CircleOptions fillColor(int i) {
        this.fillColor = i;
        return this;
    }

    public final CircleOptions zIndex(float f2) {
        this.zzcs = f2;
        return this;
    }

    public final CircleOptions visible(boolean z) {
        this.zzct = z;
        return this;
    }

    public final CircleOptions clickable(boolean z) {
        this.zzcu = z;
        return this;
    }

    public final LatLng getCenter() {
        return this.zzcp;
    }

    public final double getRadius() {
        return this.zzcq;
    }

    public final float getStrokeWidth() {
        return this.zzcr;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final List<PatternItem> getStrokePattern() {
        return this.zzcv;
    }

    public final int getFillColor() {
        return this.fillColor;
    }

    public final float getZIndex() {
        return this.zzcs;
    }

    public final boolean isVisible() {
        return this.zzct;
    }

    public final boolean isClickable() {
        return this.zzcu;
    }
}
