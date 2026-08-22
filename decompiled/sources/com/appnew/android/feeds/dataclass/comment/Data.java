package com.appnew.android.feeds.dataclass.comment;

import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.StoreProvider;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Data.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lcom/appnew/android/feeds/dataclass/comment/Data;", "", "comment", "", StoreProvider.StoreData.CREATED_DATE, "id", "user_id", "name", Const.PROFILE_PICTURE, "status", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getComment", "()Ljava/lang/String;", "getCreated", "getId", "getUser_id", "getName", "getProfile_picture", "getStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Data {
    public static final int $stable = 0;
    private final String comment;
    private final String created;
    private final String id;
    private final String name;
    private final String profile_picture;
    private final String status;
    private final String user_id;

    public static /* synthetic */ Data copy$default(Data data, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = data.comment;
        }
        if ((i & 2) != 0) {
            str2 = data.created;
        }
        if ((i & 4) != 0) {
            str3 = data.id;
        }
        if ((i & 8) != 0) {
            str4 = data.user_id;
        }
        if ((i & 16) != 0) {
            str5 = data.name;
        }
        if ((i & 32) != 0) {
            str6 = data.profile_picture;
        }
        if ((i & 64) != 0) {
            str7 = data.status;
        }
        String str8 = str6;
        String str9 = str7;
        String str10 = str5;
        String str11 = str3;
        return data.copy(str, str2, str11, str4, str10, str8, str9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getComment() {
        return this.comment;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCreated() {
        return this.created;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUser_id() {
        return this.user_id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getProfile_picture() {
        return this.profile_picture;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final Data copy(String comment, String created, String id, String user_id, String name, String profile_picture, String status) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(created, "created");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(user_id, "user_id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(profile_picture, "profile_picture");
        Intrinsics.checkNotNullParameter(status, "status");
        return new Data(comment, created, id, user_id, name, profile_picture, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Data)) {
            return false;
        }
        Data data = (Data) other;
        return Intrinsics.areEqual(this.comment, data.comment) && Intrinsics.areEqual(this.created, data.created) && Intrinsics.areEqual(this.id, data.id) && Intrinsics.areEqual(this.user_id, data.user_id) && Intrinsics.areEqual(this.name, data.name) && Intrinsics.areEqual(this.profile_picture, data.profile_picture) && Intrinsics.areEqual(this.status, data.status);
    }

    public int hashCode() {
        return (((((((((((this.comment.hashCode() * 31) + this.created.hashCode()) * 31) + this.id.hashCode()) * 31) + this.user_id.hashCode()) * 31) + this.name.hashCode()) * 31) + this.profile_picture.hashCode()) * 31) + this.status.hashCode();
    }

    public String toString() {
        return "Data(comment=" + this.comment + ", created=" + this.created + ", id=" + this.id + ", user_id=" + this.user_id + ", name=" + this.name + ", profile_picture=" + this.profile_picture + ", status=" + this.status + ")";
    }

    public Data(String comment, String created, String id, String user_id, String name, String profile_picture, String status) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(created, "created");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(user_id, "user_id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(profile_picture, "profile_picture");
        Intrinsics.checkNotNullParameter(status, "status");
        this.comment = comment;
        this.created = created;
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.profile_picture = profile_picture;
        this.status = status;
    }

    public final String getComment() {
        return this.comment;
    }

    public final String getCreated() {
        return this.created;
    }

    public final String getId() {
        return this.id;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getProfile_picture() {
        return this.profile_picture;
    }

    public final String getStatus() {
        return this.status;
    }
}
