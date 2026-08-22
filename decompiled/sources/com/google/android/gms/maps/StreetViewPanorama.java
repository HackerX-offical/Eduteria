package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;

/* JADX INFO: loaded from: classes8.dex */
public class StreetViewPanorama {
    private final IStreetViewPanoramaDelegate zzbo;

    public interface OnStreetViewPanoramaCameraChangeListener {
        void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetViewPanoramaCamera);
    }

    public interface OnStreetViewPanoramaChangeListener {
        void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetViewPanoramaLocation);
    }

    public interface OnStreetViewPanoramaClickListener {
        void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    public interface OnStreetViewPanoramaLongClickListener {
        void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    public StreetViewPanorama(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) {
        this.zzbo = (IStreetViewPanoramaDelegate) Preconditions.checkNotNull(iStreetViewPanoramaDelegate, "delegate");
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.zzbo.isZoomGesturesEnabled();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setZoomGesturesEnabled(boolean z) {
        try {
            this.zzbo.enableZoom(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isPanningGesturesEnabled() {
        try {
            return this.zzbo.isPanningGesturesEnabled();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setPanningGesturesEnabled(boolean z) {
        try {
            this.zzbo.enablePanning(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isUserNavigationEnabled() {
        try {
            return this.zzbo.isUserNavigationEnabled();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setUserNavigationEnabled(boolean z) {
        try {
            this.zzbo.enableUserNavigation(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public boolean isStreetNamesEnabled() {
        try {
            return this.zzbo.isStreetNamesEnabled();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setStreetNamesEnabled(boolean z) {
        try {
            this.zzbo.enableStreetNames(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void animateTo(StreetViewPanoramaCamera streetViewPanoramaCamera, long j) {
        try {
            this.zzbo.animateTo(streetViewPanoramaCamera, j);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public StreetViewPanoramaCamera getPanoramaCamera() {
        try {
            return this.zzbo.getPanoramaCamera();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setPosition(String str) {
        try {
            this.zzbo.setPositionWithID(str);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            this.zzbo.setPosition(latLng);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setPosition(LatLng latLng, int i) {
        try {
            this.zzbo.setPositionWithRadius(latLng, i);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setPosition(LatLng latLng, StreetViewSource streetViewSource) {
        try {
            this.zzbo.setPositionWithSource(latLng, streetViewSource);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public void setPosition(LatLng latLng, int i, StreetViewSource streetViewSource) {
        try {
            this.zzbo.setPositionWithRadiusAndSource(latLng, i, streetViewSource);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public StreetViewPanoramaLocation getLocation() {
        try {
            return this.zzbo.getStreetViewPanoramaLocation();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public StreetViewPanoramaOrientation pointToOrientation(Point point) {
        try {
            return this.zzbo.pointToOrientation(ObjectWrapper.wrap(point));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public Point orientationToPoint(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        try {
            IObjectWrapper iObjectWrapperOrientationToPoint = this.zzbo.orientationToPoint(streetViewPanoramaOrientation);
            if (iObjectWrapperOrientationToPoint == null) {
                return null;
            }
            return (Point) ObjectWrapper.unwrap(iObjectWrapperOrientationToPoint);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setOnStreetViewPanoramaChangeListener(OnStreetViewPanoramaChangeListener onStreetViewPanoramaChangeListener) {
        try {
            if (onStreetViewPanoramaChangeListener == null) {
                this.zzbo.setOnStreetViewPanoramaChangeListener(null);
            } else {
                this.zzbo.setOnStreetViewPanoramaChangeListener(new zzad(this, onStreetViewPanoramaChangeListener));
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setOnStreetViewPanoramaCameraChangeListener(OnStreetViewPanoramaCameraChangeListener onStreetViewPanoramaCameraChangeListener) {
        try {
            if (onStreetViewPanoramaCameraChangeListener == null) {
                this.zzbo.setOnStreetViewPanoramaCameraChangeListener(null);
            } else {
                this.zzbo.setOnStreetViewPanoramaCameraChangeListener(new zzae(this, onStreetViewPanoramaCameraChangeListener));
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setOnStreetViewPanoramaClickListener(OnStreetViewPanoramaClickListener onStreetViewPanoramaClickListener) {
        try {
            if (onStreetViewPanoramaClickListener == null) {
                this.zzbo.setOnStreetViewPanoramaClickListener(null);
            } else {
                this.zzbo.setOnStreetViewPanoramaClickListener(new zzaf(this, onStreetViewPanoramaClickListener));
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void setOnStreetViewPanoramaLongClickListener(OnStreetViewPanoramaLongClickListener onStreetViewPanoramaLongClickListener) {
        try {
            if (onStreetViewPanoramaLongClickListener == null) {
                this.zzbo.setOnStreetViewPanoramaLongClickListener(null);
            } else {
                this.zzbo.setOnStreetViewPanoramaLongClickListener(new zzag(this, onStreetViewPanoramaLongClickListener));
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
