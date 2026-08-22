package com.appnew.android.Model.Sme;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmeModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/appnew/android/Model/Sme/Data;", "", "app_id", "", "expert_left_menu", "Lcom/appnew/android/Model/Sme/ExpertLeftMenu;", "<init>", "(Ljava/lang/String;Lcom/appnew/android/Model/Sme/ExpertLeftMenu;)V", "getApp_id", "()Ljava/lang/String;", "getExpert_left_menu", "()Lcom/appnew/android/Model/Sme/ExpertLeftMenu;", "component1", "component2", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Data {
    public static final int $stable = 0;
    private final String app_id;
    private final ExpertLeftMenu expert_left_menu;

    public static /* synthetic */ Data copy$default(Data data, String str, ExpertLeftMenu expertLeftMenu, int i, Object obj) {
        if ((i & 1) != 0) {
            str = data.app_id;
        }
        if ((i & 2) != 0) {
            expertLeftMenu = data.expert_left_menu;
        }
        return data.copy(str, expertLeftMenu);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getApp_id() {
        return this.app_id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ExpertLeftMenu getExpert_left_menu() {
        return this.expert_left_menu;
    }

    public final Data copy(String app_id, ExpertLeftMenu expert_left_menu) {
        Intrinsics.checkNotNullParameter(app_id, "app_id");
        Intrinsics.checkNotNullParameter(expert_left_menu, "expert_left_menu");
        return new Data(app_id, expert_left_menu);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Data)) {
            return false;
        }
        Data data = (Data) other;
        return Intrinsics.areEqual(this.app_id, data.app_id) && Intrinsics.areEqual(this.expert_left_menu, data.expert_left_menu);
    }

    public int hashCode() {
        return (this.app_id.hashCode() * 31) + this.expert_left_menu.hashCode();
    }

    public String toString() {
        return "Data(app_id=" + this.app_id + ", expert_left_menu=" + this.expert_left_menu + ")";
    }

    public Data(String app_id, ExpertLeftMenu expert_left_menu) {
        Intrinsics.checkNotNullParameter(app_id, "app_id");
        Intrinsics.checkNotNullParameter(expert_left_menu, "expert_left_menu");
        this.app_id = app_id;
        this.expert_left_menu = expert_left_menu;
    }

    public final String getApp_id() {
        return this.app_id;
    }

    public final ExpertLeftMenu getExpert_left_menu() {
        return this.expert_left_menu;
    }
}
