package com.appnew.android.Model.Courses;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: AmountDescription.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR&\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR&\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR&\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R \u0010#\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010(\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R \u0010+\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R \u0010.\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010%\"\u0004\b0\u0010'¨\u00061"}, d2 = {"Lcom/appnew/android/Model/Courses/AmountDescription;", "Ljava/io/Serializable;", "<init>", "()V", "cycle", "", "", "getCycle", "()Ljava/util/List;", "setCycle", "(Ljava/util/List;)V", "cycle_dates_ms", "getCycle_dates_ms", "setCycle_dates_ms", Const.PAYMENT, "getPayment", "setPayment", "tax", "getTax", "setTax", "total_amount", "getTotal_amount", "setTotal_amount", "emi_paid_count", "", "getEmi_paid_count", "()I", "setEmi_paid_count", "(I)V", "emi_cal_date_ms", "", "getEmi_cal_date_ms", "()J", "setEmi_cal_date_ms", "(J)V", "panelty_type", "getPanelty_type", "()Ljava/lang/String;", "setPanelty_type", "(Ljava/lang/String;)V", "panelty", "getPanelty", "setPanelty", "subscription_code", "getSubscription_code", "setSubscription_code", "grace", "getGrace", "setGrace", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AmountDescription implements Serializable {
    public static final int $stable = 8;

    @SerializedName("cycle")
    @Expose
    private List<String> cycle;

    @SerializedName("cycle_dates_ms")
    @Expose
    private List<String> cycle_dates_ms;

    @SerializedName("emi_cal_date_ms")
    @Expose
    private long emi_cal_date_ms;

    @SerializedName("emi_paid_count")
    @Expose
    private int emi_paid_count;

    @SerializedName("grace")
    @Expose
    private String grace;

    @SerializedName("panelty")
    @Expose
    private String panelty;

    @SerializedName("panelty_type")
    @Expose
    private String panelty_type;

    @SerializedName(Const.PAYMENT)
    @Expose
    private List<String> payment;

    @SerializedName("subscription_code")
    @Expose
    private String subscription_code;

    @SerializedName("tax")
    @Expose
    private List<String> tax;

    @SerializedName("total_amount")
    @Expose
    private List<String> total_amount;

    public final List<String> getCycle() {
        return this.cycle;
    }

    public final void setCycle(List<String> list) {
        this.cycle = list;
    }

    public final List<String> getCycle_dates_ms() {
        return this.cycle_dates_ms;
    }

    public final void setCycle_dates_ms(List<String> list) {
        this.cycle_dates_ms = list;
    }

    public final List<String> getPayment() {
        return this.payment;
    }

    public final void setPayment(List<String> list) {
        this.payment = list;
    }

    public final List<String> getTax() {
        return this.tax;
    }

    public final void setTax(List<String> list) {
        this.tax = list;
    }

    public final List<String> getTotal_amount() {
        return this.total_amount;
    }

    public final void setTotal_amount(List<String> list) {
        this.total_amount = list;
    }

    public final int getEmi_paid_count() {
        return this.emi_paid_count;
    }

    public final void setEmi_paid_count(int i) {
        this.emi_paid_count = i;
    }

    public final long getEmi_cal_date_ms() {
        return this.emi_cal_date_ms;
    }

    public final void setEmi_cal_date_ms(long j) {
        this.emi_cal_date_ms = j;
    }

    public final String getPanelty_type() {
        return this.panelty_type;
    }

    public final void setPanelty_type(String str) {
        this.panelty_type = str;
    }

    public final String getPanelty() {
        return this.panelty;
    }

    public final void setPanelty(String str) {
        this.panelty = str;
    }

    public final String getSubscription_code() {
        return this.subscription_code;
    }

    public final void setSubscription_code(String str) {
        this.subscription_code = str;
    }

    public final String getGrace() {
        return this.grace;
    }

    public final void setGrace(String str) {
        this.grace = str;
    }
}
