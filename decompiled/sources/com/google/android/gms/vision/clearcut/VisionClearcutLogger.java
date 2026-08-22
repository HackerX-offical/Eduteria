package com.google.android.gms.vision.clearcut;

import android.content.Context;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.internal.vision.zzfe;
import com.google.android.gms.internal.vision.zzfi;
import com.google.android.gms.internal.vision.zzio;
import com.google.android.gms.vision.L;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public class VisionClearcutLogger {
    private final ClearcutLogger zza;
    private boolean zzb = true;

    public VisionClearcutLogger(Context context) {
        this.zza = new ClearcutLogger(context, "VISION", null);
    }

    public final void zza(int i, zzfi.zzo zzoVar) {
        byte[] bArrZzh = zzoVar.zzh();
        if (i < 0 || i > 3) {
            L.i("Illegal event code: %d", Integer.valueOf(i));
            return;
        }
        try {
            if (this.zzb) {
                this.zza.newEvent(bArrZzh).setEventCode(i).log();
                return;
            }
            zzfi.zzo.zza zzaVarZza = zzfi.zzo.zza();
            try {
                zzaVarZza.zza(bArrZzh, 0, bArrZzh.length, zzio.zzc());
                L.e("Would have logged:\n%s", zzaVarZza.toString());
            } catch (Exception e2) {
                L.e(e2, "Parsing error", new Object[0]);
            }
        } catch (Exception e3) {
            zzfe.zza(e3);
            L.e(e3, "Failed to log", new Object[0]);
        }
    }
}
