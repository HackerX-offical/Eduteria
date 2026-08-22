package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class Circle {
    private final com.google.android.gms.internal.maps.zzh zzco;

    public Circle(com.google.android.gms.internal.maps.zzh zzhVar) {
        this.zzco = (com.google.android.gms.internal.maps.zzh) Preconditions.checkNotNull(zzhVar);
    }

    public final void remove() {
        try {
            this.zzco.remove();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final String getId() {
        try {
            return this.zzco.getId();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setCenter(LatLng latLng) {
        try {
            this.zzco.setCenter(latLng);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final LatLng getCenter() {
        try {
            return this.zzco.getCenter();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setRadius(double d2) {
        try {
            this.zzco.setRadius(d2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final double getRadius() {
        try {
            return this.zzco.getRadius();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setStrokeWidth(float f2) {
        try {
            this.zzco.setStrokeWidth(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final float getStrokeWidth() {
        try {
            return this.zzco.getStrokeWidth();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setStrokeColor(int i) {
        try {
            this.zzco.setStrokeColor(i);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int getStrokeColor() {
        try {
            return this.zzco.getStrokeColor();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setStrokePattern(List<PatternItem> list) {
        try {
            this.zzco.setStrokePattern(list);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final List<PatternItem> getStrokePattern() {
        try {
            return PatternItem.zza(this.zzco.getStrokePattern());
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setFillColor(int i) {
        try {
            this.zzco.setFillColor(i);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int getFillColor() {
        try {
            return this.zzco.getFillColor();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setZIndex(float f2) {
        try {
            this.zzco.setZIndex(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final float getZIndex() {
        try {
            return this.zzco.getZIndex();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setVisible(boolean z) {
        try {
            this.zzco.setVisible(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean isVisible() {
        try {
            return this.zzco.isVisible();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setClickable(boolean z) {
        try {
            this.zzco.setClickable(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean isClickable() {
        try {
            return this.zzco.isClickable();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setTag(Object obj) {
        try {
            this.zzco.zze(ObjectWrapper.wrap(obj));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final Object getTag() {
        try {
            return ObjectWrapper.unwrap(this.zzco.zzk());
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Circle)) {
            return false;
        }
        try {
            return this.zzco.zzb(((Circle) obj).zzco);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int hashCode() {
        try {
            return this.zzco.zzj();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
