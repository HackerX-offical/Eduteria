package com.appnew.android.testmodulessc.models;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SSCTestOption.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/appnew/android/testmodulessc/models/SSCTestOption;", "", FirebaseAnalytics.Param.INDEX, "", "text", "", "isSelected", "", "fibAnswer", "<init>", "(ILjava/lang/String;ZLjava/lang/String;)V", "getIndex", "()I", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "()Z", "setSelected", "(Z)V", "getFibAnswer", "setFibAnswer", "component1", "component2", "component3", "component4", Constants.COPY_TYPE, "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SSCTestOption {
    public static final int $stable = 8;
    private String fibAnswer;
    private final int index;
    private boolean isSelected;
    private String text;

    public static /* synthetic */ SSCTestOption copy$default(SSCTestOption sSCTestOption, int i, String str, boolean z, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = sSCTestOption.index;
        }
        if ((i2 & 2) != 0) {
            str = sSCTestOption.text;
        }
        if ((i2 & 4) != 0) {
            z = sSCTestOption.isSelected;
        }
        if ((i2 & 8) != 0) {
            str2 = sSCTestOption.fibAnswer;
        }
        return sSCTestOption.copy(i, str, z, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFibAnswer() {
        return this.fibAnswer;
    }

    public final SSCTestOption copy(int index, String text, boolean isSelected, String fibAnswer) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new SSCTestOption(index, text, isSelected, fibAnswer);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SSCTestOption)) {
            return false;
        }
        SSCTestOption sSCTestOption = (SSCTestOption) other;
        return this.index == sSCTestOption.index && Intrinsics.areEqual(this.text, sSCTestOption.text) && this.isSelected == sSCTestOption.isSelected && Intrinsics.areEqual(this.fibAnswer, sSCTestOption.fibAnswer);
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.index) * 31) + this.text.hashCode()) * 31) + Boolean.hashCode(this.isSelected)) * 31;
        String str = this.fibAnswer;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SSCTestOption(index=" + this.index + ", text=" + this.text + ", isSelected=" + this.isSelected + ", fibAnswer=" + this.fibAnswer + ")";
    }

    public SSCTestOption(int i, String text, boolean z, String str) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.index = i;
        this.text = text;
        this.isSelected = z;
        this.fibAnswer = str;
    }

    public /* synthetic */ SSCTestOption(int i, String str, boolean z, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? null : str2);
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final String getFibAnswer() {
        return this.fibAnswer;
    }

    public final void setFibAnswer(String str) {
        this.fibAnswer = str;
    }
}
