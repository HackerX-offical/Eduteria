package com.skydoves.powermenu.kotlin;

import android.content.Context;
import com.skydoves.powermenu.PowerMenu;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: PowerMenuKotlinDsl.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0019\b\u0004\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"createPowerMenu", "Lcom/skydoves/powermenu/PowerMenu;", "context", "Landroid/content/Context;", BlockContactsIQ.ELEMENT, "Lkotlin/Function1;", "Lcom/skydoves/powermenu/PowerMenu$Builder;", "", "Lkotlin/ExtensionFunctionType;", "powermenu_release"}, k = 2, mv = {1, 4, 1})
public final class PowerMenuKotlinDslKt {
    @PowerMenuDsl
    public static final /* synthetic */ PowerMenu createPowerMenu(Context context, Function1<? super PowerMenu.Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        PowerMenu.Builder builder = new PowerMenu.Builder(context);
        block.invoke(builder);
        PowerMenu powerMenuBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(powerMenuBuild, "PowerMenu.Builder(context).apply(block).build()");
        return powerMenuBuild;
    }
}
