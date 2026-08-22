package com.google.android.play.core.appupdate.internal;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.clevertap.android.sdk.Constants;
import java.util.IllegalFormatException;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.play:app-update@@2.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzm {
    private final String zza;

    public zzm(String str) {
        this.zza = ("UID: [" + Process.myUid() + "]  PID: [" + Process.myPid() + "] ").concat(str);
    }

    private static String zzf(String str, String str2, Object... objArr) {
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException e2) {
                Log.e("PlayCore", "Unable to format ".concat(str2), e2);
                str2 = str2 + " [" + TextUtils.join(", ", objArr) + Constants.AES_SUFFIX;
            }
        }
        return str + " : " + str2;
    }

    public final int zza(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 3)) {
            return Log.d("PlayCore", zzf(this.zza, str, objArr));
        }
        return 0;
    }

    public final int zzb(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            return Log.e("PlayCore", zzf(this.zza, str, objArr));
        }
        return 0;
    }

    public final int zzc(Throwable th, String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            return Log.e("PlayCore", zzf(this.zza, str, objArr), th);
        }
        return 0;
    }

    public final int zzd(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 4)) {
            return Log.i("PlayCore", zzf(this.zza, str, objArr));
        }
        return 0;
    }

    public final int zze(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 5)) {
            return Log.w("PlayCore", zzf(this.zza, "Phonesky package is not signed -- possibly self-built package. Could not verify.", objArr));
        }
        return 0;
    }
}
