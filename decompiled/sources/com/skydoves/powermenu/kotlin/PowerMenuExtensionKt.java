package com.skydoves.powermenu.kotlin;

import android.view.View;
import com.skydoves.powermenu.AbstractPowerMenu;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: PowerMenuExtension.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0004\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0081\bø\u0001\u0000\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007\u001a*\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a\u001a\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007\u001a*\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a\u001a\u0010\f\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007\u001a*\u0010\f\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a\u001a\u0010\r\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007\u001a*\u0010\r\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a\u001a\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007\u001a*\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a\u001a\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007\u001a*\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a\u001a\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007\u001a*\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a*\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a2\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00072\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"powermenu", "", "Landroid/view/View;", BlockContactsIQ.ELEMENT, "Lkotlin/Function0;", "showAsAnchorCenter", "powerMenu", "Lcom/skydoves/powermenu/AbstractPowerMenu;", "xOff", "", "yOff", "showAsAnchorLeftBottom", "showAsAnchorLeftTop", "showAsAnchorRightBottom", "showAsAnchorRightTop", "showAsDropDown", "showAtCenter", "showAtLocation", "gravity", "powermenu_release"}, k = 2, mv = {1, 4, 1})
public final class PowerMenuExtensionKt {
    public static final /* synthetic */ void powermenu(View powermenu, final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(powermenu, "$this$powermenu");
        Intrinsics.checkNotNullParameter(block, "block");
        powermenu.post(new Runnable() { // from class: com.skydoves.powermenu.kotlin.PowerMenuExtensionKt.powermenu.1
            @Override // java.lang.Runnable
            public final void run() {
                block.invoke();
            }
        });
    }

    public static final void showAsDropDown(final View showAsDropDown, final AbstractPowerMenu<?, ?> powerMenu) {
        Intrinsics.checkNotNullParameter(showAsDropDown, "$this$showAsDropDown");
        Intrinsics.checkNotNullParameter(powerMenu, "powerMenu");
        showAsDropDown.post(new Runnable() { // from class: com.skydoves.powermenu.kotlin.PowerMenuExtensionKt$showAsDropDown$$inlined$powermenu$1
            @Override // java.lang.Runnable
            public final void run() {
                powerMenu.showAsDropDown(showAsDropDown);
            }
        });
    }

    public static final void showAsDropDown(final View showAsDropDown, final AbstractPowerMenu<?, ?> powerMenu, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(showAsDropDown, "$this$showAsDropDown");
        Intrinsics.checkNotNullParameter(powerMenu, "powerMenu");
        showAsDropDown.post(new Runnable() { // from class: com.skydoves.powermenu.kotlin.PowerMenuExtensionKt$showAsDropDown$$inlined$powermenu$2
            @Override // java.lang.Runnable
            public final void run() {
                powerMenu.showAsDropDown(showAsDropDown, i, i2);
            }
        });
    }

    public static final void showAsAnchorLeftTop(final View showAsAnchorLeftTop, final AbstractPowerMenu<?, ?> powerMenu) {
        Intrinsics.checkNotNullParameter(showAsAnchorLeftTop, "$this$showAsAnchorLeftTop");
        Intrinsics.checkNotNullParameter(powerMenu, "powerMenu");
        showAsAnchorLeftTop.post(new Runnable() { // from class: com.skydoves.powermenu.kotlin.PowerMenuExtensionKt$showAsAnchorLeftTop$$inlined$powermenu$1
            @Override // java.lang.Runnable
            public final void run() {
                powerMenu.showAsAnchorLeftTop(showAsAnchorLeftTop);
            }
        });
    }

    public static final void showAsAnchorLeftTop(final View showAsAnchorLeftTop, final AbstractPowerMenu<?, ?> powerMenu, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(showAsAnchorLeftTop, "$this$showAsAnchorLeftTop");
        Intrinsics.checkNotNullParameter(powerMenu, "powerMenu");
        showAsAnchorLeftTop.post(new Runnable() { // from class: com.skydoves.powermenu.kotlin.PowerMenuExtensionKt$showAsAnchorLeftTop$$inlined$powermenu$2
            @Override // java.lang.Runnable
            public final void run() {
                powerMenu.showAsAnchorLeftTop(showAsAnchorLeftTop, i, i2);
            }
        });
    }

    public static final void showAsAnchorLeftBottom(final View showAsAnchorLeftBottom, final AbstractPowerMenu<?, ?> powerMenu) {
        Intrinsics.checkNotNullParameter(showAsAnchorLeftBottom, "$this$showAsAnchorLeftBottom");
        Intrinsics.checkNotNullParameter(powerMenu, "powerMenu");
        showAsAnchorLeftBottom.post(new Runnable() { // from class: com.skydoves.powermenu.kotlin.PowerMenuExtensionKt$showAsAnchorLeftBottom$$inlined$powermenu$1
            @Override // java.lang.Runnable
            public final void run() {
                powerMenu.showAsAnchorLeftBottom(showAsAnchorLeftBottom);
            }
        });
    }

    public static final void showAsAnchorLeftBottom(final View showAsAnchorLeftBottom, final AbstractPowerMenu<?, ?> powerMenu, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(showAsAnchorLeftBottom, "$this$showAsAnchorLeftBottom");
        Intrinsics.checkNotNullParameter(powerMenu, "powerMenu");
        showAsAnchorLeftBottom.post(new Runnable() { // from class: com.skydoves.powermenu.kotlin.PowerMenuExtensionKt$showAsAnchorLeftBottom$$inlined$powermenu$2
            @Override // java.lang.Runnable
            public final void run() {
                powerMenu.showAsAnchorLeftBottom(showAsAnchorLeftBottom, i, i2);
            }
        });
    }

    public static final void showAsAnchorRightTop(final View showAsAnchorRightTop, final AbstractPowerMenu<?, ?> powerMenu) {
        Intrinsics.checkNotNullParameter(showAsAnchorRightTop, "$this$showAsAnchorRightTop");
        Intrinsics.checkNotNullParameter(powerMenu, "powerMenu");
        showAsAnchorRightTop.post(new Runnable() { // from class: com.skydoves.powermenu.kotlin.PowerMenuExtensionKt$showAsAnchorRightTop$$inlined$powermenu$1
            @Override // java.lang.Runnable
            public final void run() {
                powerMenu.showAsAnchorRightTop(showAsAnchorRightTop);
            }
        });
    }

    public static final void showAsAnchorRightTop(final View showAsAnchorRightTop, final AbstractPowerMenu<?, ?> powerMenu, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(showAsAnchorRightTop, "$this$showAsAnchorRightTop");
        Intrinsics.checkNotNullParameter(powerMenu, "powerMenu");
        showAsAnchorRightTop.post(new Runnable() { // from class: com.skydoves.powermenu.kotlin.PowerMenuExtensionKt$showAsAnchorRightTop$$inlined$powermenu$2
            @Override // java.lang.Runnable
            public final void run() {
                powerMenu.showAsAnchorRightTop(showAsAnchorRightTop, i, i2);
            }
        });
    }

    public static final void showAsAnchorRightBottom(final View showAsAnchorRightBottom, final AbstractPowerMenu<?, ?> powerMenu) {
        Intrinsics.checkNotNullParameter(showAsAnchorRightBottom, "$this$showAsAnchorRightBottom");
        Intrinsics.checkNotNullParameter(powerMenu, "powerMenu");
        showAsAnchorRightBottom.post(new Runnable() { // from class: com.skydoves.powermenu.kotlin.PowerMenuExtensionKt$showAsAnchorRightBottom$$inlined$powermenu$1
            @Override // java.lang.Runnable
            public final void run() {
                powerMenu.showAsAnchorRightBottom(showAsAnchorRightBottom);
            }
        });
    }

    public static final void showAsAnchorRightBottom(final View showAsAnchorRightBottom, final AbstractPowerMenu<?, ?> powerMenu, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(showAsAnchorRightBottom, "$this$showAsAnchorRightBottom");
        Intrinsics.checkNotNullParameter(powerMenu, "powerMenu");
        showAsAnchorRightBottom.post(new Runnable() { // from class: com.skydoves.powermenu.kotlin.PowerMenuExtensionKt$showAsAnchorRightBottom$$inlined$powermenu$2
            @Override // java.lang.Runnable
            public final void run() {
                powerMenu.showAsAnchorRightBottom(showAsAnchorRightBottom, i, i2);
            }
        });
    }

    public static final void showAsAnchorCenter(final View showAsAnchorCenter, final AbstractPowerMenu<?, ?> powerMenu) {
        Intrinsics.checkNotNullParameter(showAsAnchorCenter, "$this$showAsAnchorCenter");
        Intrinsics.checkNotNullParameter(powerMenu, "powerMenu");
        showAsAnchorCenter.post(new Runnable() { // from class: com.skydoves.powermenu.kotlin.PowerMenuExtensionKt$showAsAnchorCenter$$inlined$powermenu$1
            @Override // java.lang.Runnable
            public final void run() {
                powerMenu.showAsAnchorRightBottom(showAsAnchorCenter);
            }
        });
    }

    public static final void showAsAnchorCenter(final View showAsAnchorCenter, final AbstractPowerMenu<?, ?> powerMenu, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(showAsAnchorCenter, "$this$showAsAnchorCenter");
        Intrinsics.checkNotNullParameter(powerMenu, "powerMenu");
        showAsAnchorCenter.post(new Runnable() { // from class: com.skydoves.powermenu.kotlin.PowerMenuExtensionKt$showAsAnchorCenter$$inlined$powermenu$2
            @Override // java.lang.Runnable
            public final void run() {
                powerMenu.showAsAnchorCenter(showAsAnchorCenter, i, i2);
            }
        });
    }

    public static final void showAtCenter(final View showAtCenter, final AbstractPowerMenu<?, ?> powerMenu) {
        Intrinsics.checkNotNullParameter(showAtCenter, "$this$showAtCenter");
        Intrinsics.checkNotNullParameter(powerMenu, "powerMenu");
        showAtCenter.post(new Runnable() { // from class: com.skydoves.powermenu.kotlin.PowerMenuExtensionKt$showAtCenter$$inlined$powermenu$1
            @Override // java.lang.Runnable
            public final void run() {
                powerMenu.showAtCenter(showAtCenter);
            }
        });
    }

    public static final void showAtCenter(final View showAtCenter, final AbstractPowerMenu<?, ?> powerMenu, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(showAtCenter, "$this$showAtCenter");
        Intrinsics.checkNotNullParameter(powerMenu, "powerMenu");
        showAtCenter.post(new Runnable() { // from class: com.skydoves.powermenu.kotlin.PowerMenuExtensionKt$showAtCenter$$inlined$powermenu$2
            @Override // java.lang.Runnable
            public final void run() {
                powerMenu.showAtCenter(showAtCenter, i, i2);
            }
        });
    }

    public static final void showAtLocation(final View showAtLocation, final AbstractPowerMenu<?, ?> powerMenu, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(showAtLocation, "$this$showAtLocation");
        Intrinsics.checkNotNullParameter(powerMenu, "powerMenu");
        showAtLocation.post(new Runnable() { // from class: com.skydoves.powermenu.kotlin.PowerMenuExtensionKt$showAtLocation$$inlined$powermenu$1
            @Override // java.lang.Runnable
            public final void run() {
                powerMenu.showAtLocation(showAtLocation, i, i2);
            }
        });
    }

    public static final void showAtLocation(final View showAtLocation, final AbstractPowerMenu<?, ?> powerMenu, final int i, final int i2, final int i3) {
        Intrinsics.checkNotNullParameter(showAtLocation, "$this$showAtLocation");
        Intrinsics.checkNotNullParameter(powerMenu, "powerMenu");
        showAtLocation.post(new Runnable() { // from class: com.skydoves.powermenu.kotlin.PowerMenuExtensionKt$showAtLocation$$inlined$powermenu$2
            @Override // java.lang.Runnable
            public final void run() {
                powerMenu.showAtLocation(showAtLocation, i, i2, i3);
            }
        });
    }
}
