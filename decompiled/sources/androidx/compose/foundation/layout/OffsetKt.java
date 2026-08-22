package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Offset.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\b\u0010\u0006\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f\u001a#\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f¨\u0006\r"}, d2 = {"offset", "Landroidx/compose/ui/Modifier;", "x", "Landroidx/compose/ui/unit/Dp;", "y", "offset-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "absoluteOffset", "absoluteOffset-VpY3zN4", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/IntOffset;", "Lkotlin/ExtensionFunctionType;", "foundation-layout"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class OffsetKt {
    /* JADX INFO: renamed from: offset-VpY3zN4, reason: not valid java name */
    public static final Modifier m1107offsetVpY3zN4(Modifier modifier, final float f2, final float f3) {
        return modifier.then(new OffsetElement(f2, f3, true, new Function1() { // from class: androidx.compose.foundation.layout.OffsetKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OffsetKt.offset_VpY3zN4$lambda$0(f2, f3, (InspectorInfo) obj);
            }
        }, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit offset_VpY3zN4$lambda$0(float f2, float f3, InspectorInfo inspectorInfo) {
        inspectorInfo.setName("offset");
        inspectorInfo.getProperties().set("x", Dp.m8828boximpl(f2));
        inspectorInfo.getProperties().set("y", Dp.m8828boximpl(f3));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: absoluteOffset-VpY3zN4, reason: not valid java name */
    public static final Modifier m1105absoluteOffsetVpY3zN4(Modifier modifier, final float f2, final float f3) {
        return modifier.then(new OffsetElement(f2, f3, false, new Function1() { // from class: androidx.compose.foundation.layout.OffsetKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OffsetKt.absoluteOffset_VpY3zN4$lambda$0(f2, f3, (InspectorInfo) obj);
            }
        }, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit absoluteOffset_VpY3zN4$lambda$0(float f2, float f3, InspectorInfo inspectorInfo) {
        inspectorInfo.setName("absoluteOffset");
        inspectorInfo.getProperties().set("x", Dp.m8828boximpl(f2));
        inspectorInfo.getProperties().set("y", Dp.m8828boximpl(f3));
        return Unit.INSTANCE;
    }

    public static final Modifier offset(Modifier modifier, final Function1<? super Density, IntOffset> function1) {
        return modifier.then(new OffsetPxElement(function1, true, new Function1() { // from class: androidx.compose.foundation.layout.OffsetKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OffsetKt.offset$lambda$0(function1, (InspectorInfo) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit offset$lambda$0(Function1 function1, InspectorInfo inspectorInfo) {
        inspectorInfo.setName("offset");
        inspectorInfo.getProperties().set("offset", function1);
        return Unit.INSTANCE;
    }

    public static final Modifier absoluteOffset(Modifier modifier, final Function1<? super Density, IntOffset> function1) {
        return modifier.then(new OffsetPxElement(function1, false, new Function1() { // from class: androidx.compose.foundation.layout.OffsetKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OffsetKt.absoluteOffset$lambda$0(function1, (InspectorInfo) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit absoluteOffset$lambda$0(Function1 function1, InspectorInfo inspectorInfo) {
        inspectorInfo.setName("absoluteOffset");
        inspectorInfo.getProperties().set("offset", function1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: offset-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1108offsetVpY3zN4$default(Modifier modifier, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = Dp.m8830constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f3 = Dp.m8830constructorimpl(0);
        }
        return m1107offsetVpY3zN4(modifier, f2, f3);
    }

    /* JADX INFO: renamed from: absoluteOffset-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1106absoluteOffsetVpY3zN4$default(Modifier modifier, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = Dp.m8830constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f3 = Dp.m8830constructorimpl(0);
        }
        return m1105absoluteOffsetVpY3zN4(modifier, f2, f3);
    }
}
