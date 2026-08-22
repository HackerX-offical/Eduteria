package com.appnew.android.Utils.firebaseToken;

import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserInfo.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0000J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/appnew/android/Utils/firebaseToken/UserInfo;", "", "userId", "", "email", Const.MOBILE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getEmail", "getMobile", "isSameUser", "", "other", "component1", "component2", "component3", Constants.COPY_TYPE, "equals", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class UserInfo {
    public static final int $stable = 0;
    private final String email;
    private final String mobile;
    private final String userId;

    public UserInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ UserInfo copy$default(UserInfo userInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userInfo.userId;
        }
        if ((i & 2) != 0) {
            str2 = userInfo.email;
        }
        if ((i & 4) != 0) {
            str3 = userInfo.mobile;
        }
        return userInfo.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMobile() {
        return this.mobile;
    }

    public final UserInfo copy(String userId, String email, String mobile) {
        return new UserInfo(userId, email, mobile);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) other;
        return Intrinsics.areEqual(this.userId, userInfo.userId) && Intrinsics.areEqual(this.email, userInfo.email) && Intrinsics.areEqual(this.mobile, userInfo.mobile);
    }

    public int hashCode() {
        String str = this.userId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.email;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.mobile;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "UserInfo(userId=" + this.userId + ", email=" + this.email + ", mobile=" + this.mobile + ")";
    }

    public UserInfo(String str, String str2, String str3) {
        this.userId = str;
        this.email = str2;
        this.mobile = str3;
    }

    public /* synthetic */ UserInfo(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getMobile() {
        return this.mobile;
    }

    public final boolean isSameUser(UserInfo other) {
        if (other == null) {
            return false;
        }
        String str = this.userId;
        if (str != null && str.length() > 0 && Intrinsics.areEqual(this.userId, other.userId)) {
            return true;
        }
        String str2 = this.mobile;
        if (str2 != null && str2.length() != 0 && Intrinsics.areEqual(this.mobile, other.mobile)) {
            return true;
        }
        String str3 = this.email;
        return (str3 == null || str3.length() == 0 || !Intrinsics.areEqual(this.email, other.email)) ? false : true;
    }
}
