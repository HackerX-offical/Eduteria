package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes8.dex */
public abstract class zzad extends zzb implements zzac {
    public static zzac zzj(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
        if (iInterfaceQueryLocalInterface instanceof zzac) {
            return (zzac) iInterfaceQueryLocalInterface;
        }
        return new zzae(iBinder);
    }
}
