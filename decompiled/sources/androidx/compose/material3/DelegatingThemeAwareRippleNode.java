package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Ripple.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/DelegatingThemeAwareRippleNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", "", Constants.KEY_RADIUS, "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "<init>", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "rippleNode", "Landroidx/compose/ui/node/DelegatableNode;", "onAttach", "", "onObservedReadsChanged", "updateConfiguration", "attachNewRipple", "removeRipple", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DelegatingThemeAwareRippleNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, ObserverModifierNode {
    private final boolean bounded;
    private final ColorProducer color;
    private final InteractionSource interactionSource;
    private final float radius;
    private DelegatableNode rippleNode;

    public /* synthetic */ DelegatingThemeAwareRippleNode(InteractionSource interactionSource, boolean z, float f2, ColorProducer colorProducer, DefaultConstructorMarker defaultConstructorMarker) {
        this(interactionSource, z, f2, colorProducer);
    }

    private DelegatingThemeAwareRippleNode(InteractionSource interactionSource, boolean z, float f2, ColorProducer colorProducer) {
        this.interactionSource = interactionSource;
        this.bounded = z;
        this.radius = f2;
        this.color = colorProducer;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateConfiguration();
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        updateConfiguration();
    }

    private final void updateConfiguration() {
        ObserverModifierNodeKt.observeReads(this, new Function0() { // from class: androidx.compose.material3.DelegatingThemeAwareRippleNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DelegatingThemeAwareRippleNode.updateConfiguration$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateConfiguration$lambda$0(DelegatingThemeAwareRippleNode delegatingThemeAwareRippleNode) {
        if (((RippleConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(delegatingThemeAwareRippleNode, RippleKt.getLocalRippleConfiguration())) == null) {
            delegatingThemeAwareRippleNode.removeRipple();
        } else if (delegatingThemeAwareRippleNode.rippleNode == null) {
            delegatingThemeAwareRippleNode.attachNewRipple();
        }
        return Unit.INSTANCE;
    }

    private final void attachNewRipple() {
        this.rippleNode = delegate(androidx.compose.material.ripple.RippleKt.m2398createRippleModifierNodeTDGSqEk(this.interactionSource, this.bounded, this.radius, new ColorProducer() { // from class: androidx.compose.material3.DelegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1
            @Override // androidx.compose.ui.graphics.ColorProducer
            /* JADX INFO: renamed from: invoke-0d7_KjU, reason: not valid java name */
            public final long mo2834invoke0d7_KjU() {
                long jMo2834invoke0d7_KjU = this.this$0.color.mo2834invoke0d7_KjU();
                if (jMo2834invoke0d7_KjU != 16) {
                    return jMo2834invoke0d7_KjU;
                }
                RippleConfiguration rippleConfiguration = (RippleConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.this$0, RippleKt.getLocalRippleConfiguration());
                if (rippleConfiguration != null && rippleConfiguration.getColor() != 16) {
                    return rippleConfiguration.getColor();
                }
                return ((Color) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.this$0, ContentColorKt.getLocalContentColor())).m5978unboximpl();
            }
        }, new Function0() { // from class: androidx.compose.material3.DelegatingThemeAwareRippleNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DelegatingThemeAwareRippleNode.attachNewRipple$lambda$1(this.f$0);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RippleAlpha attachNewRipple$lambda$1(DelegatingThemeAwareRippleNode delegatingThemeAwareRippleNode) {
        RippleAlpha rippleAlpha;
        RippleConfiguration rippleConfiguration = (RippleConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(delegatingThemeAwareRippleNode, RippleKt.getLocalRippleConfiguration());
        return (rippleConfiguration == null || (rippleAlpha = rippleConfiguration.getRippleAlpha()) == null) ? RippleDefaults.INSTANCE.getRippleAlpha() : rippleAlpha;
    }

    private final void removeRipple() {
        DelegatableNode delegatableNode = this.rippleNode;
        if (delegatableNode != null) {
            undelegate(delegatableNode);
        }
        this.rippleNode = null;
    }
}
