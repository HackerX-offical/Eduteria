package com.google.android.gms.maps.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.maps.GoogleMapOptions;

/* JADX INFO: loaded from: classes8.dex */
public final class LatLngBounds extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new zze();
    public final LatLng northeast;
    public final LatLng southwest;

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        Preconditions.checkNotNull(latLng, "null southwest");
        Preconditions.checkNotNull(latLng2, "null northeast");
        Preconditions.checkArgument(latLng2.latitude >= latLng.latitude, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(latLng.latitude), Double.valueOf(latLng2.latitude));
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double zza(double d2, double d3) {
        return ((d2 - d3) + 360.0d) % 360.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double zzb(double d2, double d3) {
        return ((d3 - d2) + 360.0d) % 360.0d;
    }

    public static final class Builder {
        private double zzdh = Double.POSITIVE_INFINITY;
        private double zzdi = Double.NEGATIVE_INFINITY;
        private double zzdj = Double.NaN;
        private double zzdk = Double.NaN;

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
        
            if (r0 > r4) goto L17;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.google.android.gms.maps.model.LatLngBounds.Builder include(com.google.android.gms.maps.model.LatLng r7) {
            /*
                r6 = this;
                double r0 = r6.zzdh
                double r2 = r7.latitude
                double r0 = java.lang.Math.min(r0, r2)
                r6.zzdh = r0
                double r0 = r6.zzdi
                double r2 = r7.latitude
                double r0 = java.lang.Math.max(r0, r2)
                r6.zzdi = r0
                double r0 = r7.longitude
                double r2 = r6.zzdj
                boolean r7 = java.lang.Double.isNaN(r2)
                if (r7 == 0) goto L21
                r6.zzdj = r0
                goto L4c
            L21:
                double r2 = r6.zzdj
                double r4 = r6.zzdk
                int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r7 > 0) goto L32
                int r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r7 > 0) goto L3b
                int r7 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r7 > 0) goto L3b
                return r6
            L32:
                int r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r7 <= 0) goto L4e
                int r7 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r7 > 0) goto L3b
                goto L4e
            L3b:
                double r2 = com.google.android.gms.maps.model.LatLngBounds.zzc(r2, r0)
                double r4 = r6.zzdk
                double r4 = com.google.android.gms.maps.model.LatLngBounds.zzd(r4, r0)
                int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r7 >= 0) goto L4c
                r6.zzdj = r0
                return r6
            L4c:
                r6.zzdk = r0
            L4e:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.model.LatLngBounds.Builder.include(com.google.android.gms.maps.model.LatLng):com.google.android.gms.maps.model.LatLngBounds$Builder");
        }

        public final LatLngBounds build() {
            Preconditions.checkState(!Double.isNaN(this.zzdj), "no included points");
            return new LatLngBounds(new LatLng(this.zzdh, this.zzdj), new LatLng(this.zzdi, this.zzdk));
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.southwest, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.northeast, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public static Builder builder() {
        return new Builder();
    }

    public final boolean contains(LatLng latLng) {
        double d2 = latLng.latitude;
        return this.southwest.latitude <= d2 && d2 <= this.northeast.latitude && zza(latLng.longitude);
    }

    public final LatLngBounds including(LatLng latLng) {
        double dMin = Math.min(this.southwest.latitude, latLng.latitude);
        double dMax = Math.max(this.northeast.latitude, latLng.latitude);
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        double d4 = latLng.longitude;
        if (!zza(d4)) {
            if (zza(d3, d4) < zzb(d2, d4)) {
                d3 = d4;
            } else {
                d2 = d4;
            }
        }
        return new LatLngBounds(new LatLng(dMin, d3), new LatLng(dMax, d2));
    }

    public final LatLng getCenter() {
        double d2 = (this.southwest.latitude + this.northeast.latitude) / 2.0d;
        double d3 = this.northeast.longitude;
        double d4 = this.southwest.longitude;
        if (d4 > d3) {
            d3 += 360.0d;
        }
        return new LatLng(d2, (d3 + d4) / 2.0d);
    }

    private final boolean zza(double d2) {
        return this.southwest.longitude <= this.northeast.longitude ? this.southwest.longitude <= d2 && d2 <= this.northeast.longitude : this.southwest.longitude <= d2 || d2 <= this.northeast.longitude;
    }

    public final int hashCode() {
        return Objects.hashCode(this.southwest, this.northeast);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("southwest", this.southwest).add("northeast", this.northeast).toString();
    }

    public static LatLngBounds createFromAttributes(Context context, AttributeSet attributeSet) {
        return GoogleMapOptions.zza(context, attributeSet);
    }
}
