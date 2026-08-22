package com.appnew.android.Model;

import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QRPaymentData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/appnew/android/Model/QRPaymentData;", "", Const.COURSE_FINAL_PAYMENT_TOKEN, "", Const.COURSE_INIT_PAYMENT_TOKEN, Const.TRANSACTION_STATUS, "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getPost_transaction_id", "()Ljava/lang/String;", "getPre_transaction_id", "getTransaction_status", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", Constants.COPY_TYPE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/appnew/android/Model/QRPaymentData;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class QRPaymentData {
    public static final int $stable = 0;
    private final String post_transaction_id;
    private final String pre_transaction_id;
    private final Long transaction_status;

    public QRPaymentData() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ QRPaymentData copy$default(QRPaymentData qRPaymentData, String str, String str2, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = qRPaymentData.post_transaction_id;
        }
        if ((i & 2) != 0) {
            str2 = qRPaymentData.pre_transaction_id;
        }
        if ((i & 4) != 0) {
            l = qRPaymentData.transaction_status;
        }
        return qRPaymentData.copy(str, str2, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPost_transaction_id() {
        return this.post_transaction_id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPre_transaction_id() {
        return this.pre_transaction_id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getTransaction_status() {
        return this.transaction_status;
    }

    public final QRPaymentData copy(String post_transaction_id, String pre_transaction_id, Long transaction_status) {
        return new QRPaymentData(post_transaction_id, pre_transaction_id, transaction_status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QRPaymentData)) {
            return false;
        }
        QRPaymentData qRPaymentData = (QRPaymentData) other;
        return Intrinsics.areEqual(this.post_transaction_id, qRPaymentData.post_transaction_id) && Intrinsics.areEqual(this.pre_transaction_id, qRPaymentData.pre_transaction_id) && Intrinsics.areEqual(this.transaction_status, qRPaymentData.transaction_status);
    }

    public int hashCode() {
        String str = this.post_transaction_id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.pre_transaction_id;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.transaction_status;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "QRPaymentData(post_transaction_id=" + this.post_transaction_id + ", pre_transaction_id=" + this.pre_transaction_id + ", transaction_status=" + this.transaction_status + ")";
    }

    public QRPaymentData(String str, String str2, Long l) {
        this.post_transaction_id = str;
        this.pre_transaction_id = str2;
        this.transaction_status = l;
    }

    public /* synthetic */ QRPaymentData(String str, String str2, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : l);
    }

    public final String getPost_transaction_id() {
        return this.post_transaction_id;
    }

    public final String getPre_transaction_id() {
        return this.pre_transaction_id;
    }

    public final Long getTransaction_status() {
        return this.transaction_status;
    }
}
