package com.google.android.gms.internal.firebase_auth;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzkj<FieldDescriptorType> extends zzkg<FieldDescriptorType, Object> {
    zzkj(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkg
    public final void zza() {
        if (!zzb()) {
            for (int i = 0; i < zzc(); i++) {
                Map.Entry<FieldDescriptorType, Object> entryZzb = zzb(i);
                if (((zzhz) entryZzb.getKey()).zzd()) {
                    entryZzb.setValue(Collections.unmodifiableList((List) entryZzb.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : zzd()) {
                if (((zzhz) entry.getKey()).zzd()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
