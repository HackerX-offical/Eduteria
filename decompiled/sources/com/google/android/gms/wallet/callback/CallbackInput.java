package com.google.android.gms.wallet.callback;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-wallet@@18.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public class CallbackInput extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CallbackInput> CREATOR = new zzh();
    int zza;
    byte[] zzb;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-wallet@@18.1.3 */
    public final class Builder {
        /* synthetic */ Builder(zzg zzgVar) {
        }

        public CallbackInput build() {
            return CallbackInput.this;
        }

        public Builder setCallbackType(int i) {
            CallbackInput.this.zza = i;
            return this;
        }

        public Builder setRequestBytes(byte[] bArr) {
            CallbackInput.this.zzb = bArr;
            return this;
        }
    }

    private CallbackInput() {
    }

    public static Builder newBuilder() {
        return new CallbackInput().new Builder(null);
    }

    public <T extends AbstractSafeParcelable> T deserializeRequest(Parcelable.Creator<T> creator) {
        byte[] bArr = this.zzb;
        if (bArr == null) {
            return null;
        }
        return (T) SafeParcelableSerializer.deserializeFromBytes(bArr, creator);
    }

    public int getCallbackType() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public CallbackInput(int i, byte[] bArr) {
        this.zza = i;
        this.zzb = bArr;
    }
}
