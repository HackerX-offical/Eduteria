package com.skydoves.powermenu.kotlin;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenu.Factory;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ActivityPowerMenuLazy.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B#\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX\u0088\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/skydoves/powermenu/kotlin/ActivityPowerMenuLazy;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/skydoves/powermenu/PowerMenu$Factory;", "Lkotlin/Lazy;", "Lcom/skydoves/powermenu/PowerMenu;", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "clazz", "Lkotlin/reflect/KClass;", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lkotlin/reflect/KClass;)V", "cached", "value", "getValue", "()Lcom/skydoves/powermenu/PowerMenu;", "isInitialized", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "powermenu_release"}, k = 1, mv = {1, 4, 1})
public final class ActivityPowerMenuLazy<T extends PowerMenu.Factory> implements Lazy<PowerMenu> {
    private PowerMenu cached;
    private final KClass<T> clazz;
    private final Context context;
    private final LifecycleOwner lifecycleOwner;

    public ActivityPowerMenuLazy(Context context, LifecycleOwner lifecycleOwner, KClass<T> clazz) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        this.context = context;
        this.lifecycleOwner = lifecycleOwner;
        this.clazz = clazz;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.Lazy
    public PowerMenu getValue() {
        PowerMenu powerMenu = this.cached;
        if (powerMenu != null) {
            return powerMenu;
        }
        final KClass<T> kClass = this.clazz;
        PowerMenu powerMenuCreate = ((PowerMenu.Factory) ((Class) new PropertyReference0Impl(kClass) { // from class: com.skydoves.powermenu.kotlin.ActivityPowerMenuLazy$value$factory$1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return JvmClassMappingKt.getJavaClass((KClass) this.receiver);
            }
        }.get()).newInstance()).create(this.context, this.lifecycleOwner);
        this.cached = powerMenuCreate;
        return powerMenuCreate;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this.cached != null;
    }

    public String toString() {
        return isInitialized() ? getValue().toString() : "Lazy value not initialized yet.";
    }
}
