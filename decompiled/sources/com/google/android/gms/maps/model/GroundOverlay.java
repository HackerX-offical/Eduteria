package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes8.dex */
public final class GroundOverlay {
    private final com.google.android.gms.internal.maps.zzk zzcw;

    public GroundOverlay(com.google.android.gms.internal.maps.zzk zzkVar) {
        this.zzcw = (com.google.android.gms.internal.maps.zzk) Preconditions.checkNotNull(zzkVar);
    }

    public final void remove() {
        try {
            this.zzcw.remove();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final String getId() {
        try {
            return this.zzcw.getId();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setPosition(LatLng latLng) {
        try {
            this.zzcw.setPosition(latLng);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final LatLng getPosition() {
        try {
            return this.zzcw.getPosition();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setImage(BitmapDescriptor bitmapDescriptor) {
        Preconditions.checkNotNull(bitmapDescriptor, "imageDescriptor must not be null");
        try {
            this.zzcw.zzf(bitmapDescriptor.zzb());
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setDimensions(float f2) {
        try {
            this.zzcw.setDimensions(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setDimensions(float f2, float f3) {
        try {
            this.zzcw.zza(f2, f3);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final float getWidth() {
        try {
            return this.zzcw.getWidth();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final float getHeight() {
        try {
            return this.zzcw.getHeight();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setPositionFromBounds(LatLngBounds latLngBounds) {
        try {
            this.zzcw.setPositionFromBounds(latLngBounds);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final LatLngBounds getBounds() {
        try {
            return this.zzcw.getBounds();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setBearing(float f2) {
        try {
            this.zzcw.setBearing(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final float getBearing() {
        try {
            return this.zzcw.getBearing();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setZIndex(float f2) {
        try {
            this.zzcw.setZIndex(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final float getZIndex() {
        try {
            return this.zzcw.getZIndex();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setVisible(boolean z) {
        try {
            this.zzcw.setVisible(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean isVisible() {
        try {
            return this.zzcw.isVisible();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setClickable(boolean z) {
        try {
            this.zzcw.setClickable(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean isClickable() {
        try {
            return this.zzcw.isClickable();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setTransparency(float f2) {
        try {
            this.zzcw.setTransparency(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final float getTransparency() {
        try {
            return this.zzcw.getTransparency();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setTag(Object obj) {
        try {
            this.zzcw.zze(ObjectWrapper.wrap(obj));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final Object getTag() {
        try {
            return ObjectWrapper.unwrap(this.zzcw.zzk());
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof GroundOverlay)) {
            return false;
        }
        try {
            return this.zzcw.zzb(((GroundOverlay) obj).zzcw);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int hashCode() {
        try {
            return this.zzcw.zzj();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
