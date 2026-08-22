package com.android.billingclient.api;

import android.text.TextUtils;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.ProductDetails;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
public class BillingFlowParams {
    public static final String EXTRA_PARAM_KEY_ACCOUNT_ID = "accountId";
    private boolean zza;
    private String zzb;
    private String zzc;
    private SubscriptionUpdateParams zzd;
    private com.google.android.gms.internal.play_billing.zzbw zze;
    private ArrayList zzf;
    private boolean zzg;

    /* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
    public static class Builder {
        private String zza;
        private String zzb;
        private List zzc;
        private ArrayList zzd;
        private boolean zze;
        private SubscriptionUpdateParams.Builder zzf;

        private Builder() {
            SubscriptionUpdateParams.Builder builderNewBuilder = SubscriptionUpdateParams.newBuilder();
            SubscriptionUpdateParams.Builder.zza(builderNewBuilder);
            this.zzf = builderNewBuilder;
        }

        public BillingFlowParams build() {
            ArrayList arrayList = this.zzd;
            boolean z = true;
            boolean z2 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            List list = this.zzc;
            boolean z3 = (list == null || list.isEmpty()) ? false : true;
            if (!z2 && !z3) {
                throw new IllegalArgumentException("Details of the products must be provided.");
            }
            if (z2 && z3) {
                throw new IllegalArgumentException("Set SkuDetails or ProductDetailsParams, not both.");
            }
            zzcf zzcfVar = null;
            if (!z2) {
                this.zzc.forEach(new Consumer() { // from class: com.android.billingclient.api.zzce
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        if (((BillingFlowParams.ProductDetailsParams) obj) == null) {
                            throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
                        }
                    }
                });
            } else {
                if (this.zzd.contains(null)) {
                    throw new IllegalArgumentException("SKU cannot be null.");
                }
                if (this.zzd.size() > 1) {
                    SkuDetails skuDetails = (SkuDetails) this.zzd.get(0);
                    String type = skuDetails.getType();
                    ArrayList arrayList2 = this.zzd;
                    int size = arrayList2.size();
                    for (int i = 0; i < size; i++) {
                        SkuDetails skuDetails2 = (SkuDetails) arrayList2.get(i);
                        if (!type.equals("play_pass_subs") && !skuDetails2.getType().equals("play_pass_subs") && !type.equals(skuDetails2.getType())) {
                            throw new IllegalArgumentException("SKUs should have the same type.");
                        }
                    }
                    String strZzd = skuDetails.zzd();
                    ArrayList arrayList3 = this.zzd;
                    int size2 = arrayList3.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        SkuDetails skuDetails3 = (SkuDetails) arrayList3.get(i2);
                        if (!type.equals("play_pass_subs") && !skuDetails3.getType().equals("play_pass_subs") && !strZzd.equals(skuDetails3.zzd())) {
                            throw new IllegalArgumentException("All SKUs must have the same package name.");
                        }
                    }
                }
            }
            BillingFlowParams billingFlowParams = new BillingFlowParams(zzcfVar);
            if ((!z2 || ((SkuDetails) this.zzd.get(0)).zzd().isEmpty()) && (!z3 || ((ProductDetailsParams) this.zzc.get(0)).zza().zza().isEmpty())) {
                z = false;
            }
            billingFlowParams.zza = z;
            billingFlowParams.zzb = this.zza;
            billingFlowParams.zzc = this.zzb;
            billingFlowParams.zzd = this.zzf.build();
            ArrayList arrayList4 = this.zzd;
            billingFlowParams.zzf = arrayList4 != null ? new ArrayList(arrayList4) : new ArrayList();
            billingFlowParams.zzg = this.zze;
            List list2 = this.zzc;
            billingFlowParams.zze = list2 != null ? com.google.android.gms.internal.play_billing.zzbw.zzk(list2) : com.google.android.gms.internal.play_billing.zzbw.zzl();
            return billingFlowParams;
        }

        public Builder setIsOfferPersonalized(boolean z) {
            this.zze = z;
            return this;
        }

        public Builder setObfuscatedAccountId(String str) {
            this.zza = str;
            return this;
        }

        public Builder setObfuscatedProfileId(String str) {
            this.zzb = str;
            return this;
        }

        public Builder setProductDetailsParamsList(List<ProductDetailsParams> list) {
            this.zzc = new ArrayList(list);
            return this;
        }

        @Deprecated
        public Builder setSkuDetails(SkuDetails skuDetails) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(skuDetails);
            this.zzd = arrayList;
            return this;
        }

        public Builder setSubscriptionUpdateParams(SubscriptionUpdateParams subscriptionUpdateParams) {
            this.zzf = SubscriptionUpdateParams.zzb(subscriptionUpdateParams);
            return this;
        }

        /* synthetic */ Builder(zzcf zzcfVar) {
            SubscriptionUpdateParams.Builder builderNewBuilder = SubscriptionUpdateParams.newBuilder();
            SubscriptionUpdateParams.Builder.zza(builderNewBuilder);
            this.zzf = builderNewBuilder;
        }
    }

    /* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
    public static final class ProductDetailsParams {
        private final ProductDetails zza;
        private final String zzb;

        /* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
        public static class Builder {
            private ProductDetails zza;
            private String zzb;

            private Builder() {
                throw null;
            }

            /* synthetic */ Builder(zzcf zzcfVar) {
            }

            public ProductDetailsParams build() {
                com.google.android.gms.internal.play_billing.zzam.zzc(this.zza, "ProductDetails is required for constructing ProductDetailsParams.");
                if (this.zza.getSubscriptionOfferDetails() != null) {
                    com.google.android.gms.internal.play_billing.zzam.zzc(this.zzb, "offerToken is required for constructing ProductDetailsParams for subscriptions.");
                }
                return new ProductDetailsParams(this, null);
            }

            public Builder setOfferToken(String str) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("offerToken can not be empty");
                }
                this.zzb = str;
                return this;
            }

            public Builder setProductDetails(ProductDetails productDetails) {
                this.zza = productDetails;
                if (productDetails.getOneTimePurchaseOfferDetails() != null) {
                    productDetails.getOneTimePurchaseOfferDetails().getClass();
                    ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails = productDetails.getOneTimePurchaseOfferDetails();
                    if (oneTimePurchaseOfferDetails.zza() != null) {
                        this.zzb = oneTimePurchaseOfferDetails.zza();
                    }
                }
                return this;
            }
        }

        /* synthetic */ ProductDetailsParams(Builder builder, zzcf zzcfVar) {
            this.zza = builder.zza;
            this.zzb = builder.zzb;
        }

        public static Builder newBuilder() {
            return new Builder(null);
        }

        public final ProductDetails zza() {
            return this.zza;
        }

        public final String zzb() {
            return this.zzb;
        }
    }

    /* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
    public static class SubscriptionUpdateParams {
        private String zza;
        private String zzb;
        private int zzc = 0;

        /* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
        public static class Builder {
            private String zza;
            private String zzb;
            private boolean zzc;
            private int zzd = 0;

            private Builder() {
            }

            /* synthetic */ Builder(zzcf zzcfVar) {
            }

            static /* synthetic */ Builder zza(Builder builder) {
                builder.zzc = true;
                return builder;
            }

            public SubscriptionUpdateParams build() {
                zzcf zzcfVar = null;
                boolean z = true;
                if (TextUtils.isEmpty(this.zza) && TextUtils.isEmpty(null)) {
                    z = false;
                }
                boolean zIsEmpty = TextUtils.isEmpty(this.zzb);
                if (z && !zIsEmpty) {
                    throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
                }
                if (!this.zzc && !z && zIsEmpty) {
                    throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
                }
                SubscriptionUpdateParams subscriptionUpdateParams = new SubscriptionUpdateParams(zzcfVar);
                subscriptionUpdateParams.zza = this.zza;
                subscriptionUpdateParams.zzc = this.zzd;
                subscriptionUpdateParams.zzb = this.zzb;
                return subscriptionUpdateParams;
            }

            public Builder setOldPurchaseToken(String str) {
                this.zza = str;
                return this;
            }

            public Builder setOriginalExternalTransactionId(String str) {
                this.zzb = str;
                return this;
            }

            public Builder setSubscriptionReplacementMode(int i) {
                this.zzd = i;
                return this;
            }

            @Deprecated
            public final Builder zzb(String str) {
                this.zza = str;
                return this;
            }
        }

        /* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
        @Retention(RetentionPolicy.SOURCE)
        public @interface ReplacementMode {
            public static final int CHARGE_FULL_PRICE = 5;
            public static final int CHARGE_PRORATED_PRICE = 2;
            public static final int DEFERRED = 6;
            public static final int UNKNOWN_REPLACEMENT_MODE = 0;
            public static final int WITHOUT_PRORATION = 3;
            public static final int WITH_TIME_PRORATION = 1;
        }

        private SubscriptionUpdateParams() {
        }

        /* synthetic */ SubscriptionUpdateParams(zzcf zzcfVar) {
        }

        public static Builder newBuilder() {
            return new Builder(null);
        }

        static /* bridge */ /* synthetic */ Builder zzb(SubscriptionUpdateParams subscriptionUpdateParams) {
            Builder builderNewBuilder = newBuilder();
            builderNewBuilder.zzb(subscriptionUpdateParams.zza);
            builderNewBuilder.setSubscriptionReplacementMode(subscriptionUpdateParams.zzc);
            builderNewBuilder.setOriginalExternalTransactionId(subscriptionUpdateParams.zzb);
            return builderNewBuilder;
        }

        final int zza() {
            return this.zzc;
        }

        final String zzc() {
            return this.zza;
        }

        final String zzd() {
            return this.zzb;
        }
    }

    private BillingFlowParams() {
        throw null;
    }

    /* synthetic */ BillingFlowParams(zzcf zzcfVar) {
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public final int zza() {
        return this.zzd.zza();
    }

    final BillingResult zzb() {
        if (this.zze.isEmpty()) {
            return zzcj.zzl;
        }
        ProductDetailsParams productDetailsParams = (ProductDetailsParams) this.zze.get(0);
        for (int i = 1; i < this.zze.size(); i++) {
            ProductDetailsParams productDetailsParams2 = (ProductDetailsParams) this.zze.get(i);
            if (!productDetailsParams2.zza().getProductType().equals(productDetailsParams.zza().getProductType()) && !productDetailsParams2.zza().getProductType().equals("play_pass_subs")) {
                return zzcj.zza(5, "All products should have same ProductType.");
            }
        }
        String strZza = productDetailsParams.zza().zza();
        HashSet hashSet = new HashSet();
        HashSet<String> hashSet2 = new HashSet();
        com.google.android.gms.internal.play_billing.zzbw zzbwVar = this.zze;
        int size = zzbwVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            ProductDetailsParams productDetailsParams3 = (ProductDetailsParams) zzbwVar.get(i2);
            productDetailsParams3.zza().getProductType().equals("subs");
            if (hashSet.contains(productDetailsParams3.zza().getProductId())) {
                return zzcj.zza(5, String.format("ProductId can not be duplicated. Invalid product id: %s.", productDetailsParams3.zza().getProductId()));
            }
            hashSet.add(productDetailsParams3.zza().getProductId());
            if (!productDetailsParams.zza().getProductType().equals("play_pass_subs") && !productDetailsParams3.zza().getProductType().equals("play_pass_subs") && !strZza.equals(productDetailsParams3.zza().zza())) {
                return zzcj.zza(5, "All products must have the same package name.");
            }
        }
        for (String str : hashSet2) {
            if (hashSet.contains(str)) {
                return zzcj.zza(5, String.format("OldProductId must not be one of the products to be purchased. Invalid old product id: %s.", str));
            }
        }
        return zzcj.zzl;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzd.zzc();
    }

    public final String zzf() {
        return this.zzd.zzd();
    }

    public final ArrayList zzg() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.zzf);
        return arrayList;
    }

    public final List zzh() {
        return this.zze;
    }

    public final boolean zzp() {
        return this.zzg;
    }

    final boolean zzq() {
        return (this.zzb == null && this.zzc == null && this.zzd.zzd() == null && this.zzd.zza() == 0 && !this.zze.stream().anyMatch(new Predicate() { // from class: com.android.billingclient.api.zzcd
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return false;
            }
        }) && !this.zza && !this.zzg) ? false : true;
    }
}
