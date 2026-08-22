package com.google.android.gms.internal.play_billing;

import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
abstract class zzaq implements zzcr {
    zzaq() {
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzcr) {
            return zzc().equals(((zzcr) obj).zzc());
        }
        return false;
    }

    public final int hashCode() {
        return zzc().hashCode();
    }

    public final String toString() {
        return zzc().toString();
    }
}
