package com.appnew.android.Intro;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubCat.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003JO\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0013\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0017\"\u0004\b\u001a\u0010\u0019R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0017\"\u0004\b\u001b\u0010\u0019¨\u0006)"}, d2 = {"Lcom/appnew/android/Intro/SubCat;", "", "id", "", "name", "parenid", "mastertype", "is_selct", "", "is_subcatselct", "is_maincatselct", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZ)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "setName", "getParenid", "setParenid", "getMastertype", "setMastertype", "()Z", "set_selct", "(Z)V", "set_subcatselct", "set_maincatselct", "component1", "component2", "component3", "component4", "component5", "component6", "component7", Constants.COPY_TYPE, "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SubCat {
    public static final int $stable = 8;
    private String id;
    private boolean is_maincatselct;
    private boolean is_selct;
    private boolean is_subcatselct;
    private String mastertype;
    private String name;
    private String parenid;

    public static /* synthetic */ SubCat copy$default(SubCat subCat, String str, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subCat.id;
        }
        if ((i & 2) != 0) {
            str2 = subCat.name;
        }
        if ((i & 4) != 0) {
            str3 = subCat.parenid;
        }
        if ((i & 8) != 0) {
            str4 = subCat.mastertype;
        }
        if ((i & 16) != 0) {
            z = subCat.is_selct;
        }
        if ((i & 32) != 0) {
            z2 = subCat.is_subcatselct;
        }
        if ((i & 64) != 0) {
            z3 = subCat.is_maincatselct;
        }
        boolean z4 = z2;
        boolean z5 = z3;
        boolean z6 = z;
        String str5 = str3;
        return subCat.copy(str, str2, str5, str4, z6, z4, z5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getParenid() {
        return this.parenid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMastertype() {
        return this.mastertype;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIs_selct() {
        return this.is_selct;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIs_subcatselct() {
        return this.is_subcatselct;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIs_maincatselct() {
        return this.is_maincatselct;
    }

    public final SubCat copy(String id, String name, String parenid, String mastertype, boolean is_selct, boolean is_subcatselct, boolean is_maincatselct) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parenid, "parenid");
        Intrinsics.checkNotNullParameter(mastertype, "mastertype");
        return new SubCat(id, name, parenid, mastertype, is_selct, is_subcatselct, is_maincatselct);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubCat)) {
            return false;
        }
        SubCat subCat = (SubCat) other;
        return Intrinsics.areEqual(this.id, subCat.id) && Intrinsics.areEqual(this.name, subCat.name) && Intrinsics.areEqual(this.parenid, subCat.parenid) && Intrinsics.areEqual(this.mastertype, subCat.mastertype) && this.is_selct == subCat.is_selct && this.is_subcatselct == subCat.is_subcatselct && this.is_maincatselct == subCat.is_maincatselct;
    }

    public int hashCode() {
        return (((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.parenid.hashCode()) * 31) + this.mastertype.hashCode()) * 31) + Boolean.hashCode(this.is_selct)) * 31) + Boolean.hashCode(this.is_subcatselct)) * 31) + Boolean.hashCode(this.is_maincatselct);
    }

    public String toString() {
        return "SubCat(id=" + this.id + ", name=" + this.name + ", parenid=" + this.parenid + ", mastertype=" + this.mastertype + ", is_selct=" + this.is_selct + ", is_subcatselct=" + this.is_subcatselct + ", is_maincatselct=" + this.is_maincatselct + ")";
    }

    public SubCat(String id, String name, String parenid, String mastertype, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parenid, "parenid");
        Intrinsics.checkNotNullParameter(mastertype, "mastertype");
        this.id = id;
        this.name = name;
        this.parenid = parenid;
        this.mastertype = mastertype;
        this.is_selct = z;
        this.is_subcatselct = z2;
        this.is_maincatselct = z3;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ SubCat(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, boolean r6, boolean r7, boolean r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r1 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L6
            java.lang.String r2 = ""
        L6:
            r10 = r9 & 16
            r0 = 0
            if (r10 == 0) goto Lc
            r6 = r0
        Lc:
            r10 = r9 & 32
            if (r10 == 0) goto L11
            r7 = r0
        L11:
            r9 = r9 & 64
            if (r9 == 0) goto L1e
            r10 = r0
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L26
        L1e:
            r10 = r8
            r9 = r7
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L26:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Intro.SubCat.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getId() {
        return this.id;
    }

    public final String getMastertype() {
        return this.mastertype;
    }

    public final String getName() {
        return this.name;
    }

    public final String getParenid() {
        return this.parenid;
    }

    public final boolean is_maincatselct() {
        return this.is_maincatselct;
    }

    public final boolean is_selct() {
        return this.is_selct;
    }

    public final boolean is_subcatselct() {
        return this.is_subcatselct;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final void setMastertype(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mastertype = str;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setParenid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.parenid = str;
    }

    public final void set_maincatselct(boolean z) {
        this.is_maincatselct = z;
    }

    public final void set_selct(boolean z) {
        this.is_selct = z;
    }

    public final void set_subcatselct(boolean z) {
        this.is_subcatselct = z;
    }
}
