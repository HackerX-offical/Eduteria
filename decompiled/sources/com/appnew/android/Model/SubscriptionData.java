package com.appnew.android.Model;

import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubscriptionModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b-\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0015HÆ\u0003J½\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0015HÆ\u0001J\u0013\u0010A\u001a\u00020\u00152\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020EHÖ\u0001J\t\u0010F\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006G"}, d2 = {"Lcom/appnew/android/Model/SubscriptionData;", "Ljava/io/Serializable;", "invoice_url", "", "course_id", "cat_type", "title", "cover_image", "desc_header_image", "expiry_date", "purchase_date", "mrp", "txn_id", "invoice_no", "order_id", "payment_id", Const.TRANSACTION_STATUS, Const.PAY_VIA, "payment_mode", "subscription_code", "expand", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getInvoice_url", "()Ljava/lang/String;", "getCourse_id", "getCat_type", "getTitle", "getCover_image", "getDesc_header_image", "getExpiry_date", "getPurchase_date", "getMrp", "getTxn_id", "getInvoice_no", "getOrder_id", "getPayment_id", "getTransaction_status", "getPay_via", "getPayment_mode", "getSubscription_code", "getExpand", "()Z", "setExpand", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", Constants.COPY_TYPE, "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SubscriptionData implements Serializable {
    public static final int $stable = 8;

    @SerializedName("cat_type")
    private final String cat_type;

    @SerializedName("course_id")
    private final String course_id;

    @SerializedName("cover_image")
    private final String cover_image;

    @SerializedName("desc_header_image")
    private final String desc_header_image;
    private boolean expand;

    @SerializedName("expiry_date")
    private final String expiry_date;

    @SerializedName("invoice_no")
    private final String invoice_no;

    @SerializedName("invoice_url")
    private final String invoice_url;

    @SerializedName("mrp")
    private final String mrp;

    @SerializedName("order_id")
    private final String order_id;

    @SerializedName(Const.PAY_VIA)
    private final String pay_via;

    @SerializedName("payment_id")
    private final String payment_id;

    @SerializedName("payment_mode")
    private final String payment_mode;

    @SerializedName("purchase_date")
    private final String purchase_date;

    @SerializedName("subscription_code")
    private final String subscription_code;

    @SerializedName("title")
    private final String title;

    @SerializedName(Const.TRANSACTION_STATUS)
    private final String transaction_status;

    @SerializedName("txn_id")
    private final String txn_id;

    public static /* synthetic */ SubscriptionData copy$default(SubscriptionData subscriptionData, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, boolean z, int i, Object obj) {
        boolean z2;
        String str18;
        String str19 = (i & 1) != 0 ? subscriptionData.invoice_url : str;
        String str20 = (i & 2) != 0 ? subscriptionData.course_id : str2;
        String str21 = (i & 4) != 0 ? subscriptionData.cat_type : str3;
        String str22 = (i & 8) != 0 ? subscriptionData.title : str4;
        String str23 = (i & 16) != 0 ? subscriptionData.cover_image : str5;
        String str24 = (i & 32) != 0 ? subscriptionData.desc_header_image : str6;
        String str25 = (i & 64) != 0 ? subscriptionData.expiry_date : str7;
        String str26 = (i & 128) != 0 ? subscriptionData.purchase_date : str8;
        String str27 = (i & 256) != 0 ? subscriptionData.mrp : str9;
        String str28 = (i & 512) != 0 ? subscriptionData.txn_id : str10;
        String str29 = (i & 1024) != 0 ? subscriptionData.invoice_no : str11;
        String str30 = (i & 2048) != 0 ? subscriptionData.order_id : str12;
        String str31 = (i & 4096) != 0 ? subscriptionData.payment_id : str13;
        String str32 = (i & 8192) != 0 ? subscriptionData.transaction_status : str14;
        String str33 = str19;
        String str34 = (i & 16384) != 0 ? subscriptionData.pay_via : str15;
        String str35 = (i & 32768) != 0 ? subscriptionData.payment_mode : str16;
        String str36 = (i & 65536) != 0 ? subscriptionData.subscription_code : str17;
        if ((i & 131072) != 0) {
            str18 = str36;
            z2 = subscriptionData.expand;
        } else {
            z2 = z;
            str18 = str36;
        }
        return subscriptionData.copy(str33, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32, str34, str35, str18, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getInvoice_url() {
        return this.invoice_url;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getTxn_id() {
        return this.txn_id;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getInvoice_no() {
        return this.invoice_no;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getOrder_id() {
        return this.order_id;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getPayment_id() {
        return this.payment_id;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getTransaction_status() {
        return this.transaction_status;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getPay_via() {
        return this.pay_via;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getPayment_mode() {
        return this.payment_mode;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getSubscription_code() {
        return this.subscription_code;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final boolean getExpand() {
        return this.expand;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCourse_id() {
        return this.course_id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCat_type() {
        return this.cat_type;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCover_image() {
        return this.cover_image;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDesc_header_image() {
        return this.desc_header_image;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getExpiry_date() {
        return this.expiry_date;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getPurchase_date() {
        return this.purchase_date;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getMrp() {
        return this.mrp;
    }

    public final SubscriptionData copy(String invoice_url, String course_id, String cat_type, String title, String cover_image, String desc_header_image, String expiry_date, String purchase_date, String mrp, String txn_id, String invoice_no, String order_id, String payment_id, String transaction_status, String pay_via, String payment_mode, String subscription_code, boolean expand) {
        Intrinsics.checkNotNullParameter(invoice_url, "invoice_url");
        Intrinsics.checkNotNullParameter(course_id, "course_id");
        Intrinsics.checkNotNullParameter(cat_type, "cat_type");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(cover_image, "cover_image");
        Intrinsics.checkNotNullParameter(desc_header_image, "desc_header_image");
        Intrinsics.checkNotNullParameter(expiry_date, "expiry_date");
        Intrinsics.checkNotNullParameter(purchase_date, "purchase_date");
        Intrinsics.checkNotNullParameter(mrp, "mrp");
        Intrinsics.checkNotNullParameter(txn_id, "txn_id");
        Intrinsics.checkNotNullParameter(invoice_no, "invoice_no");
        Intrinsics.checkNotNullParameter(order_id, "order_id");
        Intrinsics.checkNotNullParameter(payment_id, "payment_id");
        Intrinsics.checkNotNullParameter(transaction_status, "transaction_status");
        Intrinsics.checkNotNullParameter(pay_via, "pay_via");
        Intrinsics.checkNotNullParameter(payment_mode, "payment_mode");
        Intrinsics.checkNotNullParameter(subscription_code, "subscription_code");
        return new SubscriptionData(invoice_url, course_id, cat_type, title, cover_image, desc_header_image, expiry_date, purchase_date, mrp, txn_id, invoice_no, order_id, payment_id, transaction_status, pay_via, payment_mode, subscription_code, expand);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionData)) {
            return false;
        }
        SubscriptionData subscriptionData = (SubscriptionData) other;
        return Intrinsics.areEqual(this.invoice_url, subscriptionData.invoice_url) && Intrinsics.areEqual(this.course_id, subscriptionData.course_id) && Intrinsics.areEqual(this.cat_type, subscriptionData.cat_type) && Intrinsics.areEqual(this.title, subscriptionData.title) && Intrinsics.areEqual(this.cover_image, subscriptionData.cover_image) && Intrinsics.areEqual(this.desc_header_image, subscriptionData.desc_header_image) && Intrinsics.areEqual(this.expiry_date, subscriptionData.expiry_date) && Intrinsics.areEqual(this.purchase_date, subscriptionData.purchase_date) && Intrinsics.areEqual(this.mrp, subscriptionData.mrp) && Intrinsics.areEqual(this.txn_id, subscriptionData.txn_id) && Intrinsics.areEqual(this.invoice_no, subscriptionData.invoice_no) && Intrinsics.areEqual(this.order_id, subscriptionData.order_id) && Intrinsics.areEqual(this.payment_id, subscriptionData.payment_id) && Intrinsics.areEqual(this.transaction_status, subscriptionData.transaction_status) && Intrinsics.areEqual(this.pay_via, subscriptionData.pay_via) && Intrinsics.areEqual(this.payment_mode, subscriptionData.payment_mode) && Intrinsics.areEqual(this.subscription_code, subscriptionData.subscription_code) && this.expand == subscriptionData.expand;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((this.invoice_url.hashCode() * 31) + this.course_id.hashCode()) * 31) + this.cat_type.hashCode()) * 31) + this.title.hashCode()) * 31) + this.cover_image.hashCode()) * 31) + this.desc_header_image.hashCode()) * 31) + this.expiry_date.hashCode()) * 31) + this.purchase_date.hashCode()) * 31) + this.mrp.hashCode()) * 31) + this.txn_id.hashCode()) * 31) + this.invoice_no.hashCode()) * 31) + this.order_id.hashCode()) * 31) + this.payment_id.hashCode()) * 31) + this.transaction_status.hashCode()) * 31) + this.pay_via.hashCode()) * 31) + this.payment_mode.hashCode()) * 31) + this.subscription_code.hashCode()) * 31) + Boolean.hashCode(this.expand);
    }

    public String toString() {
        return "SubscriptionData(invoice_url=" + this.invoice_url + ", course_id=" + this.course_id + ", cat_type=" + this.cat_type + ", title=" + this.title + ", cover_image=" + this.cover_image + ", desc_header_image=" + this.desc_header_image + ", expiry_date=" + this.expiry_date + ", purchase_date=" + this.purchase_date + ", mrp=" + this.mrp + ", txn_id=" + this.txn_id + ", invoice_no=" + this.invoice_no + ", order_id=" + this.order_id + ", payment_id=" + this.payment_id + ", transaction_status=" + this.transaction_status + ", pay_via=" + this.pay_via + ", payment_mode=" + this.payment_mode + ", subscription_code=" + this.subscription_code + ", expand=" + this.expand + ")";
    }

    public SubscriptionData(String invoice_url, String course_id, String cat_type, String title, String cover_image, String desc_header_image, String expiry_date, String purchase_date, String mrp, String txn_id, String invoice_no, String order_id, String payment_id, String transaction_status, String pay_via, String payment_mode, String subscription_code, boolean z) {
        Intrinsics.checkNotNullParameter(invoice_url, "invoice_url");
        Intrinsics.checkNotNullParameter(course_id, "course_id");
        Intrinsics.checkNotNullParameter(cat_type, "cat_type");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(cover_image, "cover_image");
        Intrinsics.checkNotNullParameter(desc_header_image, "desc_header_image");
        Intrinsics.checkNotNullParameter(expiry_date, "expiry_date");
        Intrinsics.checkNotNullParameter(purchase_date, "purchase_date");
        Intrinsics.checkNotNullParameter(mrp, "mrp");
        Intrinsics.checkNotNullParameter(txn_id, "txn_id");
        Intrinsics.checkNotNullParameter(invoice_no, "invoice_no");
        Intrinsics.checkNotNullParameter(order_id, "order_id");
        Intrinsics.checkNotNullParameter(payment_id, "payment_id");
        Intrinsics.checkNotNullParameter(transaction_status, "transaction_status");
        Intrinsics.checkNotNullParameter(pay_via, "pay_via");
        Intrinsics.checkNotNullParameter(payment_mode, "payment_mode");
        Intrinsics.checkNotNullParameter(subscription_code, "subscription_code");
        this.invoice_url = invoice_url;
        this.course_id = course_id;
        this.cat_type = cat_type;
        this.title = title;
        this.cover_image = cover_image;
        this.desc_header_image = desc_header_image;
        this.expiry_date = expiry_date;
        this.purchase_date = purchase_date;
        this.mrp = mrp;
        this.txn_id = txn_id;
        this.invoice_no = invoice_no;
        this.order_id = order_id;
        this.payment_id = payment_id;
        this.transaction_status = transaction_status;
        this.pay_via = pay_via;
        this.payment_mode = payment_mode;
        this.subscription_code = subscription_code;
        this.expand = z;
    }

    public final String getInvoice_url() {
        return this.invoice_url;
    }

    public final String getCourse_id() {
        return this.course_id;
    }

    public final String getCat_type() {
        return this.cat_type;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getCover_image() {
        return this.cover_image;
    }

    public final String getDesc_header_image() {
        return this.desc_header_image;
    }

    public final String getExpiry_date() {
        return this.expiry_date;
    }

    public final String getPurchase_date() {
        return this.purchase_date;
    }

    public final String getMrp() {
        return this.mrp;
    }

    public final String getTxn_id() {
        return this.txn_id;
    }

    public final String getInvoice_no() {
        return this.invoice_no;
    }

    public final String getOrder_id() {
        return this.order_id;
    }

    public final String getPayment_id() {
        return this.payment_id;
    }

    public final String getTransaction_status() {
        return this.transaction_status;
    }

    public final String getPay_via() {
        return this.pay_via;
    }

    public final String getPayment_mode() {
        return this.payment_mode;
    }

    public final String getSubscription_code() {
        return this.subscription_code;
    }

    public final boolean getExpand() {
        return this.expand;
    }

    public final void setExpand(boolean z) {
        this.expand = z;
    }
}
