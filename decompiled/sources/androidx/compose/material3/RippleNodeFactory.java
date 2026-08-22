package androidx.compose.material3;

import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Dp;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Ripple.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\fB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/RippleNodeFactory;", "Landroidx/compose/foundation/IndicationNodeFactory;", "bounded", "", Constants.KEY_RADIUS, "Landroidx/compose/ui/unit/Dp;", "colorProducer", "Landroidx/compose/ui/graphics/ColorProducer;", "color", "Landroidx/compose/ui/graphics/Color;", "<init>", "(ZFLandroidx/compose/ui/graphics/ColorProducer;J)V", "(ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(ZFJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "J", "create", "Landroidx/compose/ui/node/DelegatableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "equals", "other", "", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class RippleNodeFactory implements IndicationNodeFactory {
    private final boolean bounded;
    private final long color;
    private final ColorProducer colorProducer;
    private final float radius;

    public /* synthetic */ RippleNodeFactory(boolean z, float f2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, f2, j);
    }

    public /* synthetic */ RippleNodeFactory(boolean z, float f2, ColorProducer colorProducer, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, f2, colorProducer);
    }

    private RippleNodeFactory(boolean z, float f2, ColorProducer colorProducer, long j) {
        this.bounded = z;
        this.radius = f2;
        this.colorProducer = colorProducer;
        this.color = j;
    }

    private RippleNodeFactory(boolean z, float f2, ColorProducer colorProducer) {
        this(z, f2, colorProducer, Color.INSTANCE.m6004getUnspecified0d7_KjU());
    }

    private RippleNodeFactory(boolean z, float f2, long j) {
        this(z, f2, (ColorProducer) null, j);
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public DelegatableNode create(InteractionSource interactionSource) {
        ColorProducer colorProducer = this.colorProducer;
        if (colorProducer == null) {
            colorProducer = new ColorProducer() { // from class: androidx.compose.material3.RippleNodeFactory$create$colorProducer$1
                @Override // androidx.compose.ui.graphics.ColorProducer
                /* JADX INFO: renamed from: invoke-0d7_KjU */
                public final long mo2834invoke0d7_KjU() {
                    return this.this$0.color;
                }
            };
        }
        return new DelegatingThemeAwareRippleNode(interactionSource, this.bounded, this.radius, colorProducer, null);
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RippleNodeFactory)) {
            return false;
        }
        RippleNodeFactory rippleNodeFactory = (RippleNodeFactory) other;
        if (this.bounded == rippleNodeFactory.bounded && Dp.m8835equalsimpl0(this.radius, rippleNodeFactory.radius) && Intrinsics.areEqual(this.colorProducer, rippleNodeFactory.colorProducer)) {
            return Color.m5969equalsimpl0(this.color, rippleNodeFactory.color);
        }
        return false;
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.bounded) * 31) + Dp.m8836hashCodeimpl(this.radius)) * 31;
        ColorProducer colorProducer = this.colorProducer;
        return ((iHashCode + (colorProducer != null ? colorProducer.hashCode() : 0)) * 31) + Color.m5975hashCodeimpl(this.color);
    }
}
