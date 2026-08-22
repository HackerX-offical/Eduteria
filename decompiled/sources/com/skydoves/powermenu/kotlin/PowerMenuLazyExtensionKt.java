package com.skydoves.powermenu.kotlin;

import androidx.activity.ComponentActivity;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.skydoves.powermenu.PowerMenu;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: PowerMenuLazyExtension.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007H\u0087\b\u001a/\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u0004*\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007H\u0087\b¨\u0006\t"}, d2 = {"powerMenu", "Lkotlin/Lazy;", "Lcom/skydoves/powermenu/PowerMenu;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/skydoves/powermenu/PowerMenu$Factory;", "Landroidx/activity/ComponentActivity;", "factory", "Lkotlin/reflect/KClass;", "Landroidx/fragment/app/Fragment;", "powermenu_release"}, k = 2, mv = {1, 4, 1})
public final class PowerMenuLazyExtensionKt {
    public static final /* synthetic */ <T extends PowerMenu.Factory> Lazy<PowerMenu> powerMenu(ComponentActivity powerMenu, KClass<T> factory) {
        Intrinsics.checkNotNullParameter(powerMenu, "$this$powerMenu");
        Intrinsics.checkNotNullParameter(factory, "factory");
        return new ActivityPowerMenuLazy(powerMenu, powerMenu, factory);
    }

    public static final /* synthetic */ <T extends PowerMenu.Factory> Lazy<PowerMenu> powerMenu(Fragment powerMenu, KClass<T> factory) {
        Intrinsics.checkNotNullParameter(powerMenu, "$this$powerMenu");
        Intrinsics.checkNotNullParameter(factory, "factory");
        return new FragmentPowerMenuLazy(powerMenu, factory);
    }
}
