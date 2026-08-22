package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-wallet@@18.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public final class InstrumentInfo extends AbstractSafeParcelable {
    public static final int CARD_CLASS_CREDIT = 1;
    public static final int CARD_CLASS_DEBIT = 2;
    public static final int CARD_CLASS_PREPAID = 3;
    public static final int CARD_CLASS_UNKNOWN = 0;
    public static final Parcelable.Creator<InstrumentInfo> CREATOR = new zzn();
    private String zza;
    private String zzb;
    private int zzc;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-wallet@@18.1.3 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface CardClass {
    }

    private InstrumentInfo() {
    }

    public int getCardClass() {
        int i = this.zzc;
        if (i == 1 || i == 2 || i == 3) {
            return i;
        }
        return 0;
    }

    public String getInstrumentDetails() {
        return this.zzb;
    }

    public String getInstrumentType() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getInstrumentType(), false);
        SafeParcelWriter.writeString(parcel, 3, getInstrumentDetails(), false);
        SafeParcelWriter.writeInt(parcel, 4, getCardClass());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public InstrumentInfo(String str, String str2, int i) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i;
    }
}
