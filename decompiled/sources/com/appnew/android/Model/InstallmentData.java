package com.appnew.android.Model;

import com.appnew.android.Utils.StoreProvider;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.hoxt.packet.Base64BinaryChunk;

/* JADX INFO: compiled from: InstallmentData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b1\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR \u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR \u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\tR \u0010!\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR \u0010$\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR \u0010'\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\tR \u0010*\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\tR \u0010-\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\tR \u00100\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010\tR\u001e\u00103\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0007\"\u0004\b5\u0010\tR\u001e\u00106\u001a\u0002078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R \u0010<\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0007\"\u0004\b>\u0010\t¨\u0006@"}, d2 = {"Lcom/appnew/android/Model/InstallmentData;", "Ljava/io/Serializable;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "transactionId", "getTransactionId", "setTransactionId", "userId", "getUserId", "setUserId", "courseId", "getCourseId", "setCourseId", "attempt", "getAttempt", "setAttempt", "nextDate", "getNextDate", "setNextDate", "amountPaid", "getAmountPaid", "setAmountPaid", "name", "getName", "setName", "isComplete", "setComplete", "planData", "getPlanData", "setPlanData", StoreProvider.StoreData.CREATED_DATE, "getCreated", "setCreated", "subscription_code", "getSubscription_code", "setSubscription_code", "panelty_type", "getPanelty_type", "setPanelty_type", "panelty_rate", "getPanelty_rate", "setPanelty_rate", "panelty_amount", "getPanelty_amount", "setPanelty_amount", Base64BinaryChunk.ATTRIBUTE_STREAM_ID, "getStreamId", "setStreamId", "emi_paid_count", "", "getEmi_paid_count", "()I", "setEmi_paid_count", "(I)V", StoreProvider.StoreData.MODIFIED_DATE, "getModified", "setModified", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InstallmentData implements Serializable {
    private static final long serialVersionUID = -1603018997163015590L;

    @SerializedName("amount_paid")
    @Expose
    private String amountPaid;

    @SerializedName("attempt")
    @Expose
    private String attempt;

    @SerializedName("course_id")
    @Expose
    private String courseId;

    @SerializedName(StoreProvider.StoreData.CREATED_DATE)
    @Expose
    private String created;

    @SerializedName("emi_paid_count")
    @Expose
    private int emi_paid_count;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("is_complete")
    @Expose
    private String isComplete;

    @SerializedName(StoreProvider.StoreData.MODIFIED_DATE)
    @Expose
    private String modified;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("next_date")
    @Expose
    private String nextDate;

    @SerializedName("panelty_amount")
    @Expose
    private String panelty_amount;

    @SerializedName("panelty_rate")
    @Expose
    private String panelty_rate;

    @SerializedName("panelty_type")
    @Expose
    private String panelty_type;

    @SerializedName("plan_data")
    @Expose
    private String planData;

    @SerializedName(Base64BinaryChunk.ATTRIBUTE_STREAM_ID)
    @Expose
    private String streamId = "";

    @SerializedName("subscription_code")
    @Expose
    private String subscription_code;

    @SerializedName("transaction_id")
    @Expose
    private String transactionId;

    @SerializedName("user_id")
    @Expose
    private String userId;
    public static final int $stable = 8;

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public final void setTransactionId(String str) {
        this.transactionId = str;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final String getCourseId() {
        return this.courseId;
    }

    public final void setCourseId(String str) {
        this.courseId = str;
    }

    public final String getAttempt() {
        return this.attempt;
    }

    public final void setAttempt(String str) {
        this.attempt = str;
    }

    public final String getNextDate() {
        return this.nextDate;
    }

    public final void setNextDate(String str) {
        this.nextDate = str;
    }

    public final String getAmountPaid() {
        return this.amountPaid;
    }

    public final void setAmountPaid(String str) {
        this.amountPaid = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    /* JADX INFO: renamed from: isComplete, reason: from getter */
    public final String getIsComplete() {
        return this.isComplete;
    }

    public final void setComplete(String str) {
        this.isComplete = str;
    }

    public final String getPlanData() {
        return this.planData;
    }

    public final void setPlanData(String str) {
        this.planData = str;
    }

    public final String getCreated() {
        return this.created;
    }

    public final void setCreated(String str) {
        this.created = str;
    }

    public final String getSubscription_code() {
        return this.subscription_code;
    }

    public final void setSubscription_code(String str) {
        this.subscription_code = str;
    }

    public final String getPanelty_type() {
        return this.panelty_type;
    }

    public final void setPanelty_type(String str) {
        this.panelty_type = str;
    }

    public final String getPanelty_rate() {
        return this.panelty_rate;
    }

    public final void setPanelty_rate(String str) {
        this.panelty_rate = str;
    }

    public final String getPanelty_amount() {
        return this.panelty_amount;
    }

    public final void setPanelty_amount(String str) {
        this.panelty_amount = str;
    }

    public final String getStreamId() {
        return this.streamId;
    }

    public final void setStreamId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.streamId = str;
    }

    public final int getEmi_paid_count() {
        return this.emi_paid_count;
    }

    public final void setEmi_paid_count(int i) {
        this.emi_paid_count = i;
    }

    public final String getModified() {
        return this.modified;
    }

    public final void setModified(String str) {
        this.modified = str;
    }
}
