package com.appnew.android.folder.model;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FolderModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\r¨\u0006!"}, d2 = {"Lcom/appnew/android/folder/model/FolderModel;", "", "id", "", "image_icon", "is_live", "title", "data_order", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getImage_icon", "setImage_icon", "set_live", "getTitle", "setTitle", "getData_order", "setData_order", "component1", "component2", "component3", "component4", "component5", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class FolderModel {
    public static final int $stable = 8;
    private String data_order;
    private String id;
    private String image_icon;
    private String is_live;
    private String title;

    public static /* synthetic */ FolderModel copy$default(FolderModel folderModel, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = folderModel.id;
        }
        if ((i & 2) != 0) {
            str2 = folderModel.image_icon;
        }
        if ((i & 4) != 0) {
            str3 = folderModel.is_live;
        }
        if ((i & 8) != 0) {
            str4 = folderModel.title;
        }
        if ((i & 16) != 0) {
            str5 = folderModel.data_order;
        }
        String str6 = str5;
        String str7 = str3;
        return folderModel.copy(str, str2, str7, str4, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getImage_icon() {
        return this.image_icon;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getIs_live() {
        return this.is_live;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getData_order() {
        return this.data_order;
    }

    public final FolderModel copy(String id, String image_icon, String is_live, String title, String data_order) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(image_icon, "image_icon");
        Intrinsics.checkNotNullParameter(is_live, "is_live");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(data_order, "data_order");
        return new FolderModel(id, image_icon, is_live, title, data_order);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FolderModel)) {
            return false;
        }
        FolderModel folderModel = (FolderModel) other;
        return Intrinsics.areEqual(this.id, folderModel.id) && Intrinsics.areEqual(this.image_icon, folderModel.image_icon) && Intrinsics.areEqual(this.is_live, folderModel.is_live) && Intrinsics.areEqual(this.title, folderModel.title) && Intrinsics.areEqual(this.data_order, folderModel.data_order);
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.image_icon.hashCode()) * 31) + this.is_live.hashCode()) * 31) + this.title.hashCode()) * 31) + this.data_order.hashCode();
    }

    public String toString() {
        return "FolderModel(id=" + this.id + ", image_icon=" + this.image_icon + ", is_live=" + this.is_live + ", title=" + this.title + ", data_order=" + this.data_order + ")";
    }

    public FolderModel(String id, String image_icon, String is_live, String title, String data_order) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(image_icon, "image_icon");
        Intrinsics.checkNotNullParameter(is_live, "is_live");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(data_order, "data_order");
        this.id = id;
        this.image_icon = image_icon;
        this.is_live = is_live;
        this.title = title;
        this.data_order = data_order;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getImage_icon() {
        return this.image_icon;
    }

    public final void setImage_icon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.image_icon = str;
    }

    public final String is_live() {
        return this.is_live;
    }

    public final void set_live(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.is_live = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getData_order() {
        return this.data_order;
    }

    public final void setData_order(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.data_order = str;
    }
}
