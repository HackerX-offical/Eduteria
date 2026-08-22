package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.material3.internal.Icons;
import androidx.compose.material3.tokens.OutlinedSegmentedButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SegmentedButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J\u0087\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010(J\r\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u00101JA\u00102\u001a\u0002002\u0006\u00103\u001a\u0002042\u0013\b\u0002\u00105\u001a\r\u0012\u0004\u0012\u00020006¢\u0006\u0002\b72\u0015\b\u0002\u00108\u001a\u000f\u0012\u0004\u0012\u000200\u0018\u000106¢\u0006\u0002\b7H\u0007¢\u0006\u0002\u00109J\u001f\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\b2\b\b\u0002\u0010=\u001a\u00020\u001f¢\u0006\u0004\b>\u0010?R\u0018\u0010\u0016\u001a\u00020\u0005*\u00020\u00178@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u00020\u001f¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0013\u0010)\u001a\u00020\u001f¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b*\u0010!R\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006@"}, d2 = {"Landroidx/compose/material3/SegmentedButtonDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/SegmentedButtonColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SegmentedButtonColors;", "activeContainerColor", "Landroidx/compose/ui/graphics/Color;", "activeContentColor", "activeBorderColor", "inactiveContainerColor", "inactiveContentColor", "inactiveBorderColor", "disabledActiveContainerColor", "disabledActiveContentColor", "disabledActiveBorderColor", "disabledInactiveContainerColor", "disabledInactiveContentColor", "disabledInactiveBorderColor", "colors-XqyqHi0", "(JJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SegmentedButtonColors;", "defaultSegmentedButtonColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultSegmentedButtonColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SegmentedButtonColors;", "baseShape", "Landroidx/compose/foundation/shape/CornerBasedShape;", "getBaseShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/shape/CornerBasedShape;", "BorderWidth", "Landroidx/compose/ui/unit/Dp;", "getBorderWidth-D9Ej5fM", "()F", "F", "itemShape", "Landroidx/compose/ui/graphics/Shape;", FirebaseAnalytics.Param.INDEX, "", "count", "(IILandroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/Shape;", "IconSize", "getIconSize-D9Ej5fM", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "ActiveIcon", "", "(Landroidx/compose/runtime/Composer;I)V", "Icon", "active", "", "activeContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "inactiveContent", "(ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "borderStroke", "Landroidx/compose/foundation/BorderStroke;", "color", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "borderStroke-l07J4OM", "(JF)Landroidx/compose/foundation/BorderStroke;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SegmentedButtonDefaults {
    public static final int $stable = 0;
    public static final SegmentedButtonDefaults INSTANCE = new SegmentedButtonDefaults();
    private static final float BorderWidth = OutlinedSegmentedButtonTokens.INSTANCE.m4660getOutlineWidthD9Ej5fM();
    private static final float IconSize = OutlinedSegmentedButtonTokens.INSTANCE.m4659getIconSizeD9Ej5fM();
    private static final PaddingValues ContentPadding = ButtonDefaults.INSTANCE.getTextButtonContentPadding();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActiveIcon$lambda$1(SegmentedButtonDefaults segmentedButtonDefaults, int i, Composer composer, int i2) {
        segmentedButtonDefaults.ActiveIcon(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Icon$lambda$2(SegmentedButtonDefaults segmentedButtonDefaults, boolean z, Function2 function2, Function2 function22, int i, int i2, Composer composer, int i3) {
        segmentedButtonDefaults.Icon(z, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private SegmentedButtonDefaults() {
    }

    public final SegmentedButtonColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 679457321, "C(colors)494@21063L11:SegmentedButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(679457321, i, -1, "androidx.compose.material3.SegmentedButtonDefaults.colors (SegmentedButton.kt:494)");
        }
        SegmentedButtonColors defaultSegmentedButtonColors$material3 = getDefaultSegmentedButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultSegmentedButtonColors$material3;
    }

    /* JADX INFO: renamed from: colors-XqyqHi0, reason: not valid java name */
    public final SegmentedButtonColors m3392colorsXqyqHi0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, Composer composer, int i, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 132526205, "C(colors)N(activeContainerColor:c#ui.graphics.Color,activeContentColor:c#ui.graphics.Color,activeBorderColor:c#ui.graphics.Color,inactiveContainerColor:c#ui.graphics.Color,inactiveContentColor:c#ui.graphics.Color,inactiveBorderColor:c#ui.graphics.Color,disabledActiveContainerColor:c#ui.graphics.Color,disabledActiveContentColor:c#ui.graphics.Color,disabledActiveBorderColor:c#ui.graphics.Color,disabledInactiveContainerColor:c#ui.graphics.Color,disabledInactiveContentColor:c#ui.graphics.Color,disabledInactiveBorderColor:c#ui.graphics.Color)530@23230L11:SegmentedButton.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i3 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        long jM6004getUnspecified0d7_KjU2 = (i3 & 2) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j2;
        long jM6004getUnspecified0d7_KjU3 = (i3 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        long jM6004getUnspecified0d7_KjU4 = (i3 & 8) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j4;
        long jM6004getUnspecified0d7_KjU5 = (i3 & 16) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j5;
        long jM6004getUnspecified0d7_KjU6 = (i3 & 32) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j6;
        long jM6004getUnspecified0d7_KjU7 = (i3 & 64) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j7;
        long jM6004getUnspecified0d7_KjU8 = (i3 & 128) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j8;
        long jM6004getUnspecified0d7_KjU9 = (i3 & 256) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j9;
        long jM6004getUnspecified0d7_KjU10 = (i3 & 512) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j10;
        long jM6004getUnspecified0d7_KjU11 = (i3 & 1024) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j11;
        long jM6004getUnspecified0d7_KjU12 = (i3 & 2048) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j12;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(132526205, i, i2, "androidx.compose.material3.SegmentedButtonDefaults.colors (SegmentedButton.kt:530)");
        }
        SegmentedButtonColors segmentedButtonColorsM3376copy2qZNXz8 = getDefaultSegmentedButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3376copy2qZNXz8(jM6004getUnspecified0d7_KjU, jM6004getUnspecified0d7_KjU2, jM6004getUnspecified0d7_KjU3, jM6004getUnspecified0d7_KjU4, jM6004getUnspecified0d7_KjU5, jM6004getUnspecified0d7_KjU6, jM6004getUnspecified0d7_KjU7, jM6004getUnspecified0d7_KjU8, jM6004getUnspecified0d7_KjU9, jM6004getUnspecified0d7_KjU10, jM6004getUnspecified0d7_KjU11, jM6004getUnspecified0d7_KjU12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return segmentedButtonColorsM3376copy2qZNXz8;
    }

    public final SegmentedButtonColors getDefaultSegmentedButtonColors$material3(ColorScheme colorScheme) {
        SegmentedButtonColors defaultSegmentedButtonColorsCached = colorScheme.getDefaultSegmentedButtonColorsCached();
        if (defaultSegmentedButtonColorsCached != null) {
            return defaultSegmentedButtonColorsCached;
        }
        SegmentedButtonColors segmentedButtonColors = new SegmentedButtonColors(ColorSchemeKt.fromToken(colorScheme, OutlinedSegmentedButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedSegmentedButtonTokens.INSTANCE.getSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedSegmentedButtonTokens.INSTANCE.getOutlineColor()), Color.INSTANCE.m6003getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, OutlinedSegmentedButtonTokens.INSTANCE.getUnselectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedSegmentedButtonTokens.INSTANCE.getOutlineColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedSegmentedButtonTokens.INSTANCE.getSelectedContainerColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedSegmentedButtonTokens.INSTANCE.getDisabledLabelTextColor()), OutlinedSegmentedButtonTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedSegmentedButtonTokens.INSTANCE.getOutlineColor()), OutlinedSegmentedButtonTokens.INSTANCE.getDisabledOutlineOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.INSTANCE.m6003getTransparent0d7_KjU(), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedSegmentedButtonTokens.INSTANCE.getDisabledLabelTextColor()), OutlinedSegmentedButtonTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedSegmentedButtonTokens.INSTANCE.getOutlineColor()), OutlinedSegmentedButtonTokens.INSTANCE.getDisabledOutlineOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultSegmentedButtonColorsCached$material3(segmentedButtonColors);
        return segmentedButtonColors;
    }

    public final CornerBasedShape getBaseShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1264240381, "C(<get-baseShape>)578@25979L5:SegmentedButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1264240381, i, -1, "androidx.compose.material3.SegmentedButtonDefaults.<get-baseShape> (SegmentedButton.kt:578)");
        }
        Shape value = ShapesKt.getValue(OutlinedSegmentedButtonTokens.INSTANCE.getShape(), composer, 6);
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
        CornerBasedShape cornerBasedShape = (CornerBasedShape) value;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return cornerBasedShape;
    }

    /* JADX INFO: renamed from: getBorderWidth-D9Ej5fM, reason: not valid java name */
    public final float m3393getBorderWidthD9Ej5fM() {
        return BorderWidth;
    }

    public final Shape itemShape(int i, int i2, CornerBasedShape cornerBasedShape, Composer composer, int i3, int i4) {
        CornerBasedShape rectangleShape;
        ComposerKt.sourceInformationMarkerStart(composer, -942072063, "C(itemShape)N(index,count,baseShape)594@26645L9:SegmentedButton.kt#uh7d8r");
        if ((i4 & 4) != 0) {
            cornerBasedShape = getBaseShape(composer, (i3 >> 9) & 14);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-942072063, i3, -1, "androidx.compose.material3.SegmentedButtonDefaults.itemShape (SegmentedButton.kt:594)");
        }
        if (i2 == 1) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return cornerBasedShape;
        }
        if (i == 0) {
            rectangleShape = ShapesKt.start$default(cornerBasedShape, null, 1, null);
        } else if (i == i2 - 1) {
            rectangleShape = ShapesKt.end$default(cornerBasedShape, null, 1, null);
        } else {
            rectangleShape = RectangleShapeKt.getRectangleShape();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return rectangleShape;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3394getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    public final void ActiveIcon(Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1273041460);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ActiveIcon)615@27266L148:SegmentedButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1273041460, i2, -1, "androidx.compose.material3.SegmentedButtonDefaults.ActiveIcon (SegmentedButton.kt:614)");
            }
            IconKt.m2997Iconww6aTOc(Icons.Filled.INSTANCE.getCheck$material3(), (String) null, SizeKt.m1221size3ABfNKs(Modifier.INSTANCE, IconSize), 0L, composerStartRestartGroup, 48, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SegmentedButtonDefaults$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SegmentedButtonDefaults.ActiveIcon$lambda$1(this.f$0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Icon(final boolean r17, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r18, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SegmentedButtonDefaults.Icon(boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: renamed from: borderStroke-l07J4OM$default, reason: not valid java name */
    public static /* synthetic */ BorderStroke m3390borderStrokel07J4OM$default(SegmentedButtonDefaults segmentedButtonDefaults, long j, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = BorderWidth;
        }
        return segmentedButtonDefaults.m3391borderStrokel07J4OM(j, f2);
    }

    /* JADX INFO: renamed from: borderStroke-l07J4OM, reason: not valid java name */
    public final BorderStroke m3391borderStrokel07J4OM(long color, float width) {
        return BorderStrokeKt.m348BorderStrokecXLIe8U(width, color);
    }
}
