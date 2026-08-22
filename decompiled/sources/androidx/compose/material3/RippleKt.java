package androidx.compose.material3;

import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.unit.Dp;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Ripple.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\n2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000b\u0010\f\"\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"ripple", "Landroidx/compose/foundation/IndicationNodeFactory;", "bounded", "", Constants.KEY_RADIUS, "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "ripple-H2RKhps", "(ZFJ)Landroidx/compose/foundation/IndicationNodeFactory;", "Landroidx/compose/ui/graphics/ColorProducer;", "ripple-wH6b6FI", "(Landroidx/compose/ui/graphics/ColorProducer;ZF)Landroidx/compose/foundation/IndicationNodeFactory;", "LocalRippleConfiguration", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/RippleConfiguration;", "getLocalRippleConfiguration", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "DefaultBoundedRipple", "Landroidx/compose/material3/RippleNodeFactory;", "DefaultUnboundedRipple", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RippleKt {
    private static final ProvidableCompositionLocal<RippleConfiguration> LocalRippleConfiguration = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.RippleKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return RippleKt.LocalRippleConfiguration$lambda$0();
        }
    }, 1, null);
    private static final RippleNodeFactory DefaultBoundedRipple = new RippleNodeFactory(true, Dp.INSTANCE.m8850getUnspecifiedD9Ej5fM(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), (DefaultConstructorMarker) null);
    private static final RippleNodeFactory DefaultUnboundedRipple = new RippleNodeFactory(false, Dp.INSTANCE.m8850getUnspecifiedD9Ej5fM(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), (DefaultConstructorMarker) null);

    /* JADX INFO: renamed from: ripple-H2RKhps$default, reason: not valid java name */
    public static /* synthetic */ IndicationNodeFactory m3315rippleH2RKhps$default(boolean z, float f2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            f2 = Dp.INSTANCE.m8850getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            j = Color.INSTANCE.m6004getUnspecified0d7_KjU();
        }
        return m3314rippleH2RKhps(z, f2, j);
    }

    /* JADX INFO: renamed from: ripple-H2RKhps, reason: not valid java name */
    public static final IndicationNodeFactory m3314rippleH2RKhps(boolean z, float f2, long j) {
        if (Dp.m8835equalsimpl0(f2, Dp.INSTANCE.m8850getUnspecifiedD9Ej5fM()) && Color.m5969equalsimpl0(j, Color.INSTANCE.m6004getUnspecified0d7_KjU())) {
            return z ? DefaultBoundedRipple : DefaultUnboundedRipple;
        }
        return new RippleNodeFactory(z, f2, j, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: renamed from: ripple-wH6b6FI$default, reason: not valid java name */
    public static /* synthetic */ IndicationNodeFactory m3317ripplewH6b6FI$default(ColorProducer colorProducer, boolean z, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            f2 = Dp.INSTANCE.m8850getUnspecifiedD9Ej5fM();
        }
        return m3316ripplewH6b6FI(colorProducer, z, f2);
    }

    /* JADX INFO: renamed from: ripple-wH6b6FI, reason: not valid java name */
    public static final IndicationNodeFactory m3316ripplewH6b6FI(ColorProducer colorProducer, boolean z, float f2) {
        return new RippleNodeFactory(z, f2, colorProducer, (DefaultConstructorMarker) null);
    }

    public static final ProvidableCompositionLocal<RippleConfiguration> getLocalRippleConfiguration() {
        return LocalRippleConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RippleConfiguration LocalRippleConfiguration$lambda$0() {
        return new RippleConfiguration(0L, null, 3, null);
    }
}
