package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzas;
import com.google.android.gms.internal.clearcut.zzat;
import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
public abstract class zzas<MessageType extends zzas<MessageType, BuilderType>, BuilderType extends zzat<MessageType, BuilderType>> implements zzdo {
    private static boolean zzey = false;
    protected int zzex = 0;

    void zzf(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.clearcut.zzdo
    public final zzbb zzr() {
        try {
            zzbg zzbgVarZzk = zzbb.zzk(zzas());
            zzb(zzbgVarZzk.zzae());
            return zzbgVarZzk.zzad();
        } catch (IOException e2) {
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("ByteString").length()).append("Serializing ").append(name).append(" to a ByteString threw an IOException (should never happen).").toString(), e2);
        }
    }

    int zzs() {
        throw new UnsupportedOperationException();
    }
}
