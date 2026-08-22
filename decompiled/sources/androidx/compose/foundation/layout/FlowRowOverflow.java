package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FlowLayoutOverflow.kt */
/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "FlowLayout overflow is no longer maintained")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0089\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00120\b\u0002\u0010\u0007\u001a*\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000f\u0018\u00010\b\u00120\b\u0002\u0010\u0010\u001a*\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000f\u0018\u00010\b¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/layout/FlowRowOverflow;", "Landroidx/compose/foundation/layout/FlowLayoutOverflow;", "type", "Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "minLinesToShowCollapse", "", "minCrossAxisSizeToShowCollapse", "seeMoreGetter", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "Lkotlin/ParameterName;", "name", "state", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "collapseGetter", "<init>", "(Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Companion", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowRowOverflow extends FlowLayoutOverflow {
    public static final int $stable = 0;
    private static final FlowRowOverflow Clip;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final FlowRowOverflow Visible;

    public /* synthetic */ FlowRowOverflow(FlowLayoutOverflow.OverflowType overflowType, int i, int i2, Function1 function1, Function1 function12, DefaultConstructorMarker defaultConstructorMarker) {
        this(overflowType, i, i2, function1, function12);
    }

    private FlowRowOverflow(FlowLayoutOverflow.OverflowType overflowType, int i, int i2, Function1<? super FlowLayoutOverflowState, ? extends Function2<? super Composer, ? super Integer, Unit>> function1, Function1<? super FlowLayoutOverflowState, ? extends Function2<? super Composer, ? super Integer, Unit>> function12) {
        super(overflowType, i, i2, function1, function12, null);
    }

    /* synthetic */ FlowRowOverflow(FlowLayoutOverflow.OverflowType overflowType, int i, int i2, Function1 function1, Function1 function12, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(overflowType, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? null : function1, (i3 & 16) != 0 ? null : function12);
    }

    /* JADX INFO: compiled from: FlowLayoutOverflow.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\f\u001a\u00020\u00052\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013J_\u0010\u0014\u001a\u00020\u00052\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122\u001c\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\b¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/layout/FlowRowOverflow$Companion;", "", "<init>", "()V", "Visible", "Landroidx/compose/foundation/layout/FlowRowOverflow;", "getVisible$annotations", "getVisible", "()Landroidx/compose/foundation/layout/FlowRowOverflow;", "Clip", "getClip$annotations", "getClip", "expandIndicator", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowRowOverflowScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/layout/FlowRowOverflow;", "expandOrCollapseIndicator", "collapseIndicator", "minRowsToShowCollapse", "", "minHeightToShowCollapse", "Landroidx/compose/ui/unit/Dp;", "expandOrCollapseIndicator--jt2gSs", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;IFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/layout/FlowRowOverflow;", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getClip$annotations() {
        }

        public static /* synthetic */ void getVisible$annotations() {
        }

        private Companion() {
        }

        public final FlowRowOverflow getVisible() {
            return FlowRowOverflow.Visible;
        }

        public final FlowRowOverflow getClip() {
            return FlowRowOverflow.Clip;
        }

        public final FlowRowOverflow expandIndicator(final Function3<? super FlowRowOverflowScope, ? super Composer, ? super Integer, Unit> content) {
            return new FlowRowOverflow(FlowLayoutOverflow.OverflowType.ExpandIndicator, 0, 0, new Function1() { // from class: androidx.compose.foundation.layout.FlowRowOverflow$Companion$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FlowRowOverflow.Companion.expandIndicator$lambda$0(content, (FlowLayoutOverflowState) obj);
                }
            }, null, 22, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Function2 expandIndicator$lambda$0(final Function3 function3, final FlowLayoutOverflowState flowLayoutOverflowState) {
            return ComposableLambdaKt.composableLambdaInstance(-982932461, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowRowOverflow$Companion$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FlowRowOverflow.Companion.expandIndicator$lambda$0$0(flowLayoutOverflowState, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit expandIndicator$lambda$0$0(FlowLayoutOverflowState flowLayoutOverflowState, Function3 function3, Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C99@4786L9:FlowLayoutOverflow.kt#2w3rfo");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-982932461, i, -1, "androidx.compose.foundation.layout.FlowRowOverflow.Companion.expandIndicator.<anonymous>.<anonymous> (FlowLayoutOverflow.kt:98)");
                }
                function3.invoke(new FlowRowOverflowScopeImpl(flowLayoutOverflowState), composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: expandOrCollapseIndicator--jt2gSs, reason: not valid java name */
        public final FlowRowOverflow m1020expandOrCollapseIndicatorjt2gSs(final Function3<? super FlowRowOverflowScope, ? super Composer, ? super Integer, Unit> function3, final Function3<? super FlowRowOverflowScope, ? super Composer, ? super Integer, Unit> function32, int i, float f2, Composer composer, int i2, int i3) {
            ComposerKt.sourceInformationMarkerStart(composer, 1512952504, "C(expandOrCollapseIndicator)N(expandIndicator,collapseIndicator,minRowsToShowCollapse,minHeightToShowCollapse:c#ui.unit.Dp)136@6835L7,137@6903L1081:FlowLayoutOverflow.kt#2w3rfo");
            boolean z = true;
            int i4 = (i3 & 4) != 0 ? 1 : i;
            float fM8830constructorimpl = (i3 & 8) != 0 ? Dp.m8830constructorimpl(0) : f2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1512952504, i2, -1, "androidx.compose.foundation.layout.FlowRowOverflow.Companion.expandOrCollapseIndicator (FlowLayoutOverflow.kt:134)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            int iMo482roundToPx0680j_4 = ((Density) objConsume).mo482roundToPx0680j_4(fM8830constructorimpl);
            ComposerKt.sourceInformationMarkerStart(composer, -2046541583, "CC(remember):FlowLayoutOverflow.kt#9igjgp");
            boolean zChanged = ((((i2 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(i4)) || (i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | composer.changed(iMo482roundToPx0680j_4) | ((((i2 & 14) ^ 6) > 4 && composer.changed(function3)) || (i2 & 6) == 4);
            if ((((i2 & 112) ^ 48) <= 32 || !composer.changed(function32)) && (i2 & 48) != 32) {
                z = false;
            }
            boolean z2 = zChanged | z;
            Object objRememberedValue = composer.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                FlowRowOverflow flowRowOverflow = new FlowRowOverflow(FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator, i4, iMo482roundToPx0680j_4, new Function1() { // from class: androidx.compose.foundation.layout.FlowRowOverflow$Companion$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FlowRowOverflow.Companion.expandOrCollapseIndicator__jt2gSs$lambda$1$0(function3, (FlowLayoutOverflowState) obj);
                    }
                }, new Function1() { // from class: androidx.compose.foundation.layout.FlowRowOverflow$Companion$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FlowRowOverflow.Companion.expandOrCollapseIndicator__jt2gSs$lambda$1$1(function32, (FlowLayoutOverflowState) obj);
                    }
                }, null);
                composer.updateRememberedValue(flowRowOverflow);
                objRememberedValue = flowRowOverflow;
            }
            FlowRowOverflow flowRowOverflow2 = (FlowRowOverflow) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return flowRowOverflow2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Function2 expandOrCollapseIndicator__jt2gSs$lambda$1$0(final Function3 function3, final FlowLayoutOverflowState flowLayoutOverflowState) {
            return ComposableLambdaKt.composableLambdaInstance(1742323353, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowRowOverflow$Companion$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FlowRowOverflow.Companion.expandOrCollapseIndicator__jt2gSs$lambda$1$0$0(flowLayoutOverflowState, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit expandOrCollapseIndicator__jt2gSs$lambda$1$0$0(FlowLayoutOverflowState flowLayoutOverflowState, Function3 function3, Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C146@7283L17:FlowLayoutOverflow.kt#2w3rfo");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1742323353, i, -1, "androidx.compose.foundation.layout.FlowRowOverflow.Companion.expandOrCollapseIndicator.<anonymous>.<anonymous>.<anonymous> (FlowLayoutOverflow.kt:145)");
                }
                function3.invoke(new FlowRowOverflowScopeImpl(flowLayoutOverflowState), composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Function2 expandOrCollapseIndicator__jt2gSs$lambda$1$1(final Function3 function3, final FlowLayoutOverflowState flowLayoutOverflowState) {
            return ComposableLambdaKt.composableLambdaInstance(-1862526094, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowRowOverflow$Companion$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FlowRowOverflow.Companion.expandOrCollapseIndicator__jt2gSs$lambda$1$1$0(flowLayoutOverflowState, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit expandOrCollapseIndicator__jt2gSs$lambda$1$1$0(FlowLayoutOverflowState flowLayoutOverflowState, Function3 function3, Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C153@7547L19:FlowLayoutOverflow.kt#2w3rfo");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1862526094, i, -1, "androidx.compose.foundation.layout.FlowRowOverflow.Companion.expandOrCollapseIndicator.<anonymous>.<anonymous>.<anonymous> (FlowLayoutOverflow.kt:152)");
                }
                function3.invoke(new FlowRowOverflowScopeImpl(flowLayoutOverflowState), composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    }

    static {
        int i = 0;
        Function1 function1 = null;
        Visible = new FlowRowOverflow(FlowLayoutOverflow.OverflowType.Visible, 0, i, null, function1, 30, null);
        Clip = new FlowRowOverflow(FlowLayoutOverflow.OverflowType.Clip, i, 0, function1, null, 30, null);
    }
}
