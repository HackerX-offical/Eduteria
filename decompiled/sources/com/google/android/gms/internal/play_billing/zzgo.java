package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzgo;
import com.google.android.gms.internal.play_billing.zzgs;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public class zzgo<MessageType extends zzgs<MessageType, BuilderType>, BuilderType extends zzgo<MessageType, BuilderType>> extends zzfc<MessageType, BuilderType> {
    protected zzgs zza;
    private final zzgs zzb;

    protected zzgo(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzA()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = messagetype.zzp();
    }

    private static void zza(Object obj, Object obj2) {
        zzic.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzgo zzb() {
        zzgo zzgoVar = (zzgo) this.zzb.zzd(5, null, null);
        zzgoVar.zza = zzh();
        return zzgoVar;
    }

    public final zzgo zze(zzgs zzgsVar) {
        if (!this.zzb.equals(zzgsVar)) {
            if (!this.zza.zzA()) {
                zzk();
            }
            zza(this.zza, zzgsVar);
        }
        return this;
    }

    public final MessageType zzf() {
        MessageType messagetype = (MessageType) zzh();
        if (zzgs.zzz(messagetype, true)) {
            return messagetype;
        }
        throw new zziq(messagetype);
    }

    @Override // com.google.android.gms.internal.play_billing.zzht
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public MessageType zzh() {
        if (!this.zza.zzA()) {
            return (MessageType) this.zza;
        }
        this.zza.zzv();
        return (MessageType) this.zza;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final /* bridge */ /* synthetic */ zzhu zzi() {
        throw null;
    }

    protected final void zzj() {
        if (this.zza.zzA()) {
            return;
        }
        zzk();
    }

    protected void zzk() {
        zzgs zzgsVarZzp = this.zzb.zzp();
        zza(zzgsVarZzp, this.zza);
        this.zza = zzgsVarZzp;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final boolean zzl() {
        return zzgs.zzz(this.zza, false);
    }
}
