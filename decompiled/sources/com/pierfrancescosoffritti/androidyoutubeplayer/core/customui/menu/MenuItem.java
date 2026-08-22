package com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.menu;

import android.view.View;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MenuItem.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J.\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/menu/MenuItem;", "", "text", "", "icon", "", "onClickListener", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;Ljava/lang/Integer;Landroid/view/View$OnClickListener;)V", "getIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOnClickListener", "()Landroid/view/View$OnClickListener;", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", Constants.COPY_TYPE, "(Ljava/lang/String;Ljava/lang/Integer;Landroid/view/View$OnClickListener;)Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/menu/MenuItem;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "custom-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MenuItem {
    private final Integer icon;
    private final View.OnClickListener onClickListener;
    private final String text;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MenuItem(String text, View.OnClickListener onClickListener) {
        this(text, null, onClickListener, 2, null);
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
    }

    public static /* synthetic */ MenuItem copy$default(MenuItem menuItem, String str, Integer num, View.OnClickListener onClickListener, int i, Object obj) {
        if ((i & 1) != 0) {
            str = menuItem.text;
        }
        if ((i & 2) != 0) {
            num = menuItem.icon;
        }
        if ((i & 4) != 0) {
            onClickListener = menuItem.onClickListener;
        }
        return menuItem.copy(str, num, onClickListener);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final View.OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    public final MenuItem copy(String text, Integer icon, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        return new MenuItem(text, icon, onClickListener);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MenuItem)) {
            return false;
        }
        MenuItem menuItem = (MenuItem) other;
        return Intrinsics.areEqual(this.text, menuItem.text) && Intrinsics.areEqual(this.icon, menuItem.icon) && Intrinsics.areEqual(this.onClickListener, menuItem.onClickListener);
    }

    public int hashCode() {
        int iHashCode = this.text.hashCode() * 31;
        Integer num = this.icon;
        return ((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.onClickListener.hashCode();
    }

    public String toString() {
        return "MenuItem(text=" + this.text + ", icon=" + this.icon + ", onClickListener=" + this.onClickListener + ')';
    }

    public MenuItem(String text, Integer num, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.text = text;
        this.icon = num;
        this.onClickListener = onClickListener;
    }

    public /* synthetic */ MenuItem(String str, Integer num, View.OnClickListener onClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : num, onClickListener);
    }

    public final String getText() {
        return this.text;
    }

    public final Integer getIcon() {
        return this.icon;
    }

    public final View.OnClickListener getOnClickListener() {
        return this.onClickListener;
    }
}
