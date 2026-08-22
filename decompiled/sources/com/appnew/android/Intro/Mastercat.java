package com.appnew.android.Intro;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Mastercat.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0010\"\u0004\b\u0013\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/appnew/android/Intro/Mastercat;", "", "catid", "", "catname", "is_select", "", "is_expand_maincat", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getCatid", "()Ljava/lang/String;", "setCatid", "(Ljava/lang/String;)V", "getCatname", "setCatname", "()Z", "set_select", "(Z)V", "set_expand_maincat", "component1", "component2", "component3", "component4", Constants.COPY_TYPE, "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Mastercat {
    public static final int $stable = 8;
    private String catid;
    private String catname;
    private boolean is_expand_maincat;
    private boolean is_select;

    public static /* synthetic */ Mastercat copy$default(Mastercat mastercat, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mastercat.catid;
        }
        if ((i & 2) != 0) {
            str2 = mastercat.catname;
        }
        if ((i & 4) != 0) {
            z = mastercat.is_select;
        }
        if ((i & 8) != 0) {
            z2 = mastercat.is_expand_maincat;
        }
        return mastercat.copy(str, str2, z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCatid() {
        return this.catid;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCatname() {
        return this.catname;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIs_select() {
        return this.is_select;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIs_expand_maincat() {
        return this.is_expand_maincat;
    }

    public final Mastercat copy(String catid, String catname, boolean is_select, boolean is_expand_maincat) {
        Intrinsics.checkNotNullParameter(catid, "catid");
        Intrinsics.checkNotNullParameter(catname, "catname");
        return new Mastercat(catid, catname, is_select, is_expand_maincat);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Mastercat)) {
            return false;
        }
        Mastercat mastercat = (Mastercat) other;
        return Intrinsics.areEqual(this.catid, mastercat.catid) && Intrinsics.areEqual(this.catname, mastercat.catname) && this.is_select == mastercat.is_select && this.is_expand_maincat == mastercat.is_expand_maincat;
    }

    public int hashCode() {
        return (((((this.catid.hashCode() * 31) + this.catname.hashCode()) * 31) + Boolean.hashCode(this.is_select)) * 31) + Boolean.hashCode(this.is_expand_maincat);
    }

    public String toString() {
        return "Mastercat(catid=" + this.catid + ", catname=" + this.catname + ", is_select=" + this.is_select + ", is_expand_maincat=" + this.is_expand_maincat + ")";
    }

    public Mastercat(String catid, String catname, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(catid, "catid");
        Intrinsics.checkNotNullParameter(catname, "catname");
        this.catid = catid;
        this.catname = catname;
        this.is_select = z;
        this.is_expand_maincat = z2;
    }

    public /* synthetic */ Mastercat(String str, String str2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2);
    }

    public final String getCatid() {
        return this.catid;
    }

    public final void setCatid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.catid = str;
    }

    public final String getCatname() {
        return this.catname;
    }

    public final void setCatname(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.catname = str;
    }

    public final boolean is_select() {
        return this.is_select;
    }

    public final void set_select(boolean z) {
        this.is_select = z;
    }

    public final boolean is_expand_maincat() {
        return this.is_expand_maincat;
    }

    public final void set_expand_maincat(boolean z) {
        this.is_expand_maincat = z;
    }
}
