package com.appnew.android.Model;

import com.appnew.android.Utils.StoreProvider;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Emi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0013HÆ\u0003J©\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001J\u0013\u0010;\u001a\u00020\u00132\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\t\u0010>\u001a\u00020?HÖ\u0001J\t\u0010@\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006A"}, d2 = {"Lcom/appnew/android/Model/Emi;", "Ljava/io/Serializable;", "subscriptionCode", "", "emi_status", "emiNo", "emiMrp", "creation_date", "emiTax", "totalMrp", "txnStatus", "emiValidity", StoreProvider.StoreData.CREATED_DATE, "invoiceUrl", "invoiceNo", "discount_amount", "planeId", "autopay_status", "expand", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getSubscriptionCode", "()Ljava/lang/String;", "getEmi_status", "getEmiNo", "getEmiMrp", "getCreation_date", "getEmiTax", "getTotalMrp", "getTxnStatus", "getEmiValidity", "getCreated", "getInvoiceUrl", "getInvoiceNo", "getDiscount_amount", "getPlaneId", "getAutopay_status", "getExpand", "()Z", "setExpand", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", Constants.COPY_TYPE, "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Emi implements Serializable {
    public static final int $stable = 8;

    @SerializedName("autopay_status")
    private final String autopay_status;

    @SerializedName(StoreProvider.StoreData.CREATED_DATE)
    private final String created;

    @SerializedName("creation_date")
    private final String creation_date;

    @SerializedName("discount_amount")
    private final String discount_amount;

    @SerializedName("emi_mrp")
    private final String emiMrp;

    @SerializedName("emi_no")
    private final String emiNo;

    @SerializedName("emi_tax")
    private final String emiTax;

    @SerializedName("emi_validity")
    private final String emiValidity;

    @SerializedName("emi_status")
    private final String emi_status;
    private boolean expand;

    @SerializedName("invoice_no")
    private final String invoiceNo;

    @SerializedName("invoice_url")
    private final String invoiceUrl;

    @SerializedName("plan_id")
    private final String planeId;

    @SerializedName("subscription_code")
    private final String subscriptionCode;

    @SerializedName("total_mrp")
    private final String totalMrp;

    @SerializedName("txn_status")
    private final String txnStatus;

    public static /* synthetic */ Emi copy$default(Emi emi, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, boolean z, int i, Object obj) {
        String str16 = (i & 1) != 0 ? emi.subscriptionCode : str;
        return emi.copy(str16, (i & 2) != 0 ? emi.emi_status : str2, (i & 4) != 0 ? emi.emiNo : str3, (i & 8) != 0 ? emi.emiMrp : str4, (i & 16) != 0 ? emi.creation_date : str5, (i & 32) != 0 ? emi.emiTax : str6, (i & 64) != 0 ? emi.totalMrp : str7, (i & 128) != 0 ? emi.txnStatus : str8, (i & 256) != 0 ? emi.emiValidity : str9, (i & 512) != 0 ? emi.created : str10, (i & 1024) != 0 ? emi.invoiceUrl : str11, (i & 2048) != 0 ? emi.invoiceNo : str12, (i & 4096) != 0 ? emi.discount_amount : str13, (i & 8192) != 0 ? emi.planeId : str14, (i & 16384) != 0 ? emi.autopay_status : str15, (i & 32768) != 0 ? emi.expand : z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubscriptionCode() {
        return this.subscriptionCode;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getCreated() {
        return this.created;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getInvoiceUrl() {
        return this.invoiceUrl;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getInvoiceNo() {
        return this.invoiceNo;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getDiscount_amount() {
        return this.discount_amount;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getPlaneId() {
        return this.planeId;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getAutopay_status() {
        return this.autopay_status;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getExpand() {
        return this.expand;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEmi_status() {
        return this.emi_status;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEmiNo() {
        return this.emiNo;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getEmiMrp() {
        return this.emiMrp;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCreation_date() {
        return this.creation_date;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getEmiTax() {
        return this.emiTax;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTotalMrp() {
        return this.totalMrp;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getTxnStatus() {
        return this.txnStatus;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getEmiValidity() {
        return this.emiValidity;
    }

    public final Emi copy(String subscriptionCode, String emi_status, String emiNo, String emiMrp, String creation_date, String emiTax, String totalMrp, String txnStatus, String emiValidity, String created, String invoiceUrl, String invoiceNo, String discount_amount, String planeId, String autopay_status, boolean expand) {
        Intrinsics.checkNotNullParameter(subscriptionCode, "subscriptionCode");
        Intrinsics.checkNotNullParameter(emi_status, "emi_status");
        Intrinsics.checkNotNullParameter(emiNo, "emiNo");
        Intrinsics.checkNotNullParameter(emiMrp, "emiMrp");
        Intrinsics.checkNotNullParameter(creation_date, "creation_date");
        Intrinsics.checkNotNullParameter(emiTax, "emiTax");
        Intrinsics.checkNotNullParameter(totalMrp, "totalMrp");
        Intrinsics.checkNotNullParameter(txnStatus, "txnStatus");
        Intrinsics.checkNotNullParameter(emiValidity, "emiValidity");
        Intrinsics.checkNotNullParameter(created, "created");
        Intrinsics.checkNotNullParameter(invoiceUrl, "invoiceUrl");
        Intrinsics.checkNotNullParameter(invoiceNo, "invoiceNo");
        Intrinsics.checkNotNullParameter(discount_amount, "discount_amount");
        Intrinsics.checkNotNullParameter(planeId, "planeId");
        Intrinsics.checkNotNullParameter(autopay_status, "autopay_status");
        return new Emi(subscriptionCode, emi_status, emiNo, emiMrp, creation_date, emiTax, totalMrp, txnStatus, emiValidity, created, invoiceUrl, invoiceNo, discount_amount, planeId, autopay_status, expand);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Emi)) {
            return false;
        }
        Emi emi = (Emi) other;
        return Intrinsics.areEqual(this.subscriptionCode, emi.subscriptionCode) && Intrinsics.areEqual(this.emi_status, emi.emi_status) && Intrinsics.areEqual(this.emiNo, emi.emiNo) && Intrinsics.areEqual(this.emiMrp, emi.emiMrp) && Intrinsics.areEqual(this.creation_date, emi.creation_date) && Intrinsics.areEqual(this.emiTax, emi.emiTax) && Intrinsics.areEqual(this.totalMrp, emi.totalMrp) && Intrinsics.areEqual(this.txnStatus, emi.txnStatus) && Intrinsics.areEqual(this.emiValidity, emi.emiValidity) && Intrinsics.areEqual(this.created, emi.created) && Intrinsics.areEqual(this.invoiceUrl, emi.invoiceUrl) && Intrinsics.areEqual(this.invoiceNo, emi.invoiceNo) && Intrinsics.areEqual(this.discount_amount, emi.discount_amount) && Intrinsics.areEqual(this.planeId, emi.planeId) && Intrinsics.areEqual(this.autopay_status, emi.autopay_status) && this.expand == emi.expand;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((this.subscriptionCode.hashCode() * 31) + this.emi_status.hashCode()) * 31) + this.emiNo.hashCode()) * 31) + this.emiMrp.hashCode()) * 31) + this.creation_date.hashCode()) * 31) + this.emiTax.hashCode()) * 31) + this.totalMrp.hashCode()) * 31) + this.txnStatus.hashCode()) * 31) + this.emiValidity.hashCode()) * 31) + this.created.hashCode()) * 31) + this.invoiceUrl.hashCode()) * 31) + this.invoiceNo.hashCode()) * 31) + this.discount_amount.hashCode()) * 31) + this.planeId.hashCode()) * 31) + this.autopay_status.hashCode()) * 31) + Boolean.hashCode(this.expand);
    }

    public String toString() {
        return "Emi(subscriptionCode=" + this.subscriptionCode + ", emi_status=" + this.emi_status + ", emiNo=" + this.emiNo + ", emiMrp=" + this.emiMrp + ", creation_date=" + this.creation_date + ", emiTax=" + this.emiTax + ", totalMrp=" + this.totalMrp + ", txnStatus=" + this.txnStatus + ", emiValidity=" + this.emiValidity + ", created=" + this.created + ", invoiceUrl=" + this.invoiceUrl + ", invoiceNo=" + this.invoiceNo + ", discount_amount=" + this.discount_amount + ", planeId=" + this.planeId + ", autopay_status=" + this.autopay_status + ", expand=" + this.expand + ")";
    }

    public Emi(String subscriptionCode, String emi_status, String emiNo, String emiMrp, String creation_date, String emiTax, String totalMrp, String txnStatus, String emiValidity, String created, String invoiceUrl, String invoiceNo, String discount_amount, String planeId, String autopay_status, boolean z) {
        Intrinsics.checkNotNullParameter(subscriptionCode, "subscriptionCode");
        Intrinsics.checkNotNullParameter(emi_status, "emi_status");
        Intrinsics.checkNotNullParameter(emiNo, "emiNo");
        Intrinsics.checkNotNullParameter(emiMrp, "emiMrp");
        Intrinsics.checkNotNullParameter(creation_date, "creation_date");
        Intrinsics.checkNotNullParameter(emiTax, "emiTax");
        Intrinsics.checkNotNullParameter(totalMrp, "totalMrp");
        Intrinsics.checkNotNullParameter(txnStatus, "txnStatus");
        Intrinsics.checkNotNullParameter(emiValidity, "emiValidity");
        Intrinsics.checkNotNullParameter(created, "created");
        Intrinsics.checkNotNullParameter(invoiceUrl, "invoiceUrl");
        Intrinsics.checkNotNullParameter(invoiceNo, "invoiceNo");
        Intrinsics.checkNotNullParameter(discount_amount, "discount_amount");
        Intrinsics.checkNotNullParameter(planeId, "planeId");
        Intrinsics.checkNotNullParameter(autopay_status, "autopay_status");
        this.subscriptionCode = subscriptionCode;
        this.emi_status = emi_status;
        this.emiNo = emiNo;
        this.emiMrp = emiMrp;
        this.creation_date = creation_date;
        this.emiTax = emiTax;
        this.totalMrp = totalMrp;
        this.txnStatus = txnStatus;
        this.emiValidity = emiValidity;
        this.created = created;
        this.invoiceUrl = invoiceUrl;
        this.invoiceNo = invoiceNo;
        this.discount_amount = discount_amount;
        this.planeId = planeId;
        this.autopay_status = autopay_status;
        this.expand = z;
    }

    public final String getSubscriptionCode() {
        return this.subscriptionCode;
    }

    public final String getEmi_status() {
        return this.emi_status;
    }

    public final String getEmiNo() {
        return this.emiNo;
    }

    public final String getEmiMrp() {
        return this.emiMrp;
    }

    public final String getCreation_date() {
        return this.creation_date;
    }

    public final String getEmiTax() {
        return this.emiTax;
    }

    public final String getTotalMrp() {
        return this.totalMrp;
    }

    public final String getTxnStatus() {
        return this.txnStatus;
    }

    public final String getEmiValidity() {
        return this.emiValidity;
    }

    public final String getCreated() {
        return this.created;
    }

    public final String getInvoiceUrl() {
        return this.invoiceUrl;
    }

    public final String getInvoiceNo() {
        return this.invoiceNo;
    }

    public final String getDiscount_amount() {
        return this.discount_amount;
    }

    public final String getPlaneId() {
        return this.planeId;
    }

    public final String getAutopay_status() {
        return this.autopay_status;
    }

    public final boolean getExpand() {
        return this.expand;
    }

    public final void setExpand(boolean z) {
        this.expand = z;
    }
}
