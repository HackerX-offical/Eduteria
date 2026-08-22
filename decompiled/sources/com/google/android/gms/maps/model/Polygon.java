package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.maps.zzw;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class Polygon {
    private final zzw zzdw;

    public Polygon(zzw zzwVar) {
        this.zzdw = (zzw) Preconditions.checkNotNull(zzwVar);
    }

    public final void remove() {
        try {
            this.zzdw.remove();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final String getId() {
        try {
            return this.zzdw.getId();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setPoints(List<LatLng> list) {
        try {
            this.zzdw.setPoints(list);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final List<LatLng> getPoints() {
        try {
            return this.zzdw.getPoints();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setHoles(List<? extends List<LatLng>> list) {
        try {
            this.zzdw.setHoles(list);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final List<List<LatLng>> getHoles() {
        try {
            return this.zzdw.getHoles();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setStrokeWidth(float f2) {
        try {
            this.zzdw.setStrokeWidth(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final float getStrokeWidth() {
        try {
            return this.zzdw.getStrokeWidth();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setStrokeColor(int i) {
        try {
            this.zzdw.setStrokeColor(i);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int getStrokeColor() {
        try {
            return this.zzdw.getStrokeColor();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setStrokeJointType(int i) {
        try {
            this.zzdw.setStrokeJointType(i);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int getStrokeJointType() {
        try {
            return this.zzdw.getStrokeJointType();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setStrokePattern(List<PatternItem> list) {
        try {
            this.zzdw.setStrokePattern(list);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final List<PatternItem> getStrokePattern() {
        try {
            return PatternItem.zza(this.zzdw.getStrokePattern());
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setFillColor(int i) {
        try {
            this.zzdw.setFillColor(i);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int getFillColor() {
        try {
            return this.zzdw.getFillColor();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setZIndex(float f2) {
        try {
            this.zzdw.setZIndex(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final float getZIndex() {
        try {
            return this.zzdw.getZIndex();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setVisible(boolean z) {
        try {
            this.zzdw.setVisible(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean isVisible() {
        try {
            return this.zzdw.isVisible();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setGeodesic(boolean z) {
        try {
            this.zzdw.setGeodesic(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean isGeodesic() {
        try {
            return this.zzdw.isGeodesic();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setClickable(boolean z) {
        try {
            this.zzdw.setClickable(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean isClickable() {
        try {
            return this.zzdw.isClickable();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setTag(Object obj) {
        try {
            this.zzdw.zze(ObjectWrapper.wrap(obj));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final Object getTag() {
        try {
            return ObjectWrapper.unwrap(this.zzdw.zzk());
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Polygon)) {
            return false;
        }
        try {
            return this.zzdw.zzb(((Polygon) obj).zzdw);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int hashCode() {
        try {
            return this.zzdw.zzj();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
