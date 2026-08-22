package com.razorpay.nfc;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardData.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/razorpay/nfc/CardData;", "", "pan", "", "expiry", "(Ljava/lang/String;Ljava/lang/String;)V", "getExpiry", "()Ljava/lang/String;", "getPan", "component1", "component2", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class CardData {
    private final String expiry;
    private final String pan;

    public static /* synthetic */ CardData copy$default(CardData cardData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cardData.pan;
        }
        if ((i & 2) != 0) {
            str2 = cardData.expiry;
        }
        return cardData.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPan() {
        return this.pan;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getExpiry() {
        return this.expiry;
    }

    public final CardData copy(String pan, String expiry) {
        Intrinsics.checkNotNullParameter(pan, "pan");
        return new CardData(pan, expiry);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardData)) {
            return false;
        }
        CardData cardData = (CardData) other;
        return Intrinsics.areEqual(this.pan, cardData.pan) && Intrinsics.areEqual(this.expiry, cardData.expiry);
    }

    public final int hashCode() {
        int iHashCode = this.pan.hashCode() * 31;
        String str = this.expiry;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "CardData(pan=" + this.pan + ", expiry=" + this.expiry + ')';
    }

    public CardData(String pan, String str) {
        Intrinsics.checkNotNullParameter(pan, "pan");
        this.pan = pan;
        this.expiry = str;
    }

    public final String getExpiry() {
        return this.expiry;
    }

    public final String getPan() {
        return this.pan;
    }
}
