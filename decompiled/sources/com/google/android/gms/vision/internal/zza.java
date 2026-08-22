package com.google.android.gms.vision.internal;

import android.os.RemoteException;
import com.google.android.gms.common.util.PlatformVersion;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public final class zza {
    public static RemoteException zza(String str) {
        return PlatformVersion.isAtLeastIceCreamSandwichMR1() ? new RemoteException(str) : new RemoteException();
    }
}
