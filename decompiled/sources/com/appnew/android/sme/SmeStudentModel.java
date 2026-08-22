package com.appnew.android.sme;

import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmeStudentListModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/appnew/android/sme/SmeStudentModel;", "", "name", "", "profilePicture", "userId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getProfilePicture", "getUserId", "component1", "component2", "component3", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SmeStudentModel {
    public static final int $stable = 0;

    @SerializedName("name")
    private final String name;

    @SerializedName(Const.PROFILE_PICTURE)
    private final String profilePicture;

    @SerializedName("user_id")
    private final String userId;

    public static /* synthetic */ SmeStudentModel copy$default(SmeStudentModel smeStudentModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = smeStudentModel.name;
        }
        if ((i & 2) != 0) {
            str2 = smeStudentModel.profilePicture;
        }
        if ((i & 4) != 0) {
            str3 = smeStudentModel.userId;
        }
        return smeStudentModel.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getProfilePicture() {
        return this.profilePicture;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    public final SmeStudentModel copy(String name, String profilePicture, String userId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(profilePicture, "profilePicture");
        Intrinsics.checkNotNullParameter(userId, "userId");
        return new SmeStudentModel(name, profilePicture, userId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SmeStudentModel)) {
            return false;
        }
        SmeStudentModel smeStudentModel = (SmeStudentModel) other;
        return Intrinsics.areEqual(this.name, smeStudentModel.name) && Intrinsics.areEqual(this.profilePicture, smeStudentModel.profilePicture) && Intrinsics.areEqual(this.userId, smeStudentModel.userId);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.profilePicture.hashCode()) * 31) + this.userId.hashCode();
    }

    public String toString() {
        return "SmeStudentModel(name=" + this.name + ", profilePicture=" + this.profilePicture + ", userId=" + this.userId + ")";
    }

    public SmeStudentModel(String name, String profilePicture, String userId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(profilePicture, "profilePicture");
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.name = name;
        this.profilePicture = profilePicture;
        this.userId = userId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getProfilePicture() {
        return this.profilePicture;
    }

    public final String getUserId() {
        return this.userId;
    }
}
