package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.maps.zzac;

/* JADX INFO: loaded from: classes8.dex */
public final class TileOverlay {
    private final zzac zzeh;

    public TileOverlay(zzac zzacVar) {
        this.zzeh = (zzac) Preconditions.checkNotNull(zzacVar);
    }

    public final void remove() {
        try {
            this.zzeh.remove();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void clearTileCache() {
        try {
            this.zzeh.clearTileCache();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final String getId() {
        try {
            return this.zzeh.getId();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setZIndex(float f2) {
        try {
            this.zzeh.setZIndex(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final float getZIndex() {
        try {
            return this.zzeh.getZIndex();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setVisible(boolean z) {
        try {
            this.zzeh.setVisible(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean isVisible() {
        try {
            return this.zzeh.isVisible();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setFadeIn(boolean z) {
        try {
            this.zzeh.setFadeIn(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean getFadeIn() {
        try {
            return this.zzeh.getFadeIn();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setTransparency(float f2) {
        try {
            this.zzeh.setTransparency(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final float getTransparency() {
        try {
            return this.zzeh.getTransparency();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TileOverlay)) {
            return false;
        }
        try {
            return this.zzeh.zza(((TileOverlay) obj).zzeh);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int hashCode() {
        try {
            return this.zzeh.zzj();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
