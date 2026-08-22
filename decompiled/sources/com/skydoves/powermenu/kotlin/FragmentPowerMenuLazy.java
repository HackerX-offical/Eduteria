package com.skydoves.powermenu.kotlin;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenu.Factory;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: FragmentPowerMenuLazy.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0088\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/skydoves/powermenu/kotlin/FragmentPowerMenuLazy;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/skydoves/powermenu/PowerMenu$Factory;", "Lkotlin/Lazy;", "Lcom/skydoves/powermenu/PowerMenu;", "fragment", "Landroidx/fragment/app/Fragment;", "clazz", "Lkotlin/reflect/KClass;", "(Landroidx/fragment/app/Fragment;Lkotlin/reflect/KClass;)V", "cached", "value", "getValue", "()Lcom/skydoves/powermenu/PowerMenu;", "isInitialized", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "powermenu_release"}, k = 1, mv = {1, 4, 1})
public final class FragmentPowerMenuLazy<T extends PowerMenu.Factory> implements Lazy<PowerMenu> {
    private PowerMenu cached;
    private final KClass<T> clazz;
    private final Fragment fragment;

    public FragmentPowerMenuLazy(Fragment fragment, KClass<T> clazz) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        this.fragment = fragment;
        this.clazz = clazz;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.Lazy
    public PowerMenu getValue() {
        Fragment viewLifecycleOwner;
        PowerMenu powerMenu = this.cached;
        if (powerMenu != null || this.fragment.getContext() == null) {
            return powerMenu;
        }
        final KClass<T> kClass = this.clazz;
        PowerMenu.Factory factory = (PowerMenu.Factory) ((Class) new PropertyReference0Impl(kClass) { // from class: com.skydoves.powermenu.kotlin.FragmentPowerMenuLazy$value$factory$1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return JvmClassMappingKt.getJavaClass((KClass) this.receiver);
            }
        }.get()).newInstance();
        if (this.fragment.getView() != null) {
            viewLifecycleOwner = this.fragment.getViewLifecycleOwner();
        } else {
            viewLifecycleOwner = this.fragment;
        }
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "if (fragment.view !== nu…       fragment\n        }");
        PowerMenu powerMenuCreate = factory.create(this.fragment.requireContext(), viewLifecycleOwner);
        this.cached = powerMenuCreate;
        return powerMenuCreate;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this.cached != null;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
