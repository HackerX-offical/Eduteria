package com.android.billingclient.api;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class AcknowledgePurchaseParams {
    private String zza;

    /* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
    public static final class Builder {
        private String zza;

        private Builder() {
            throw null;
        }

        /* synthetic */ Builder(zza zzaVar) {
        }

        public AcknowledgePurchaseParams build() {
            String str = this.zza;
            if (str == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            }
            AcknowledgePurchaseParams acknowledgePurchaseParams = new AcknowledgePurchaseParams(null);
            acknowledgePurchaseParams.zza = str;
            return acknowledgePurchaseParams;
        }

        public Builder setPurchaseToken(String str) {
            this.zza = str;
            return this;
        }
    }

    private AcknowledgePurchaseParams() {
        throw null;
    }

    /* synthetic */ AcknowledgePurchaseParams(zza zzaVar) {
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public String getPurchaseToken() {
        return this.zza;
    }
}
