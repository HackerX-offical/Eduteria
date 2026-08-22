package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.ElevatedCardTokens;
import androidx.compose.material3.tokens.FilledCardTokens;
import androidx.compose.material3.tokens.OutlinedCardTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: Card.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0015\u0010\u0016JK\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0018\u0010\u0016JK\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001a\u0010\u0016J\r\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001dJ7\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020\u001fH\u0007¢\u0006\u0004\b#\u0010$J\r\u0010)\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001dJ7\u0010)\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020\u001fH\u0007¢\u0006\u0004\b*\u0010$J\r\u0010-\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001dJ7\u0010-\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020\u001fH\u0007¢\u0006\u0004\b.\u0010$J\u0017\u00101\u001a\u0002022\b\b\u0002\u00103\u001a\u000204H\u0007¢\u0006\u0002\u00105R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0018\u0010%\u001a\u00020\u001c*\u00020&8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0018\u0010+\u001a\u00020\u001c*\u00020&8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b,\u0010(R\u0018\u0010/\u001a\u00020\u001c*\u00020&8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b0\u0010(¨\u00066"}, d2 = {"Landroidx/compose/material3/CardDefaults;", "", "<init>", "()V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "elevatedShape", "getElevatedShape", "outlinedShape", "getOutlinedShape", "cardElevation", "Landroidx/compose/material3/CardElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "cardElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CardElevation;", "elevatedCardElevation", "elevatedCardElevation-aqJV_2Y", "outlinedCardElevation", "outlinedCardElevation-aqJV_2Y", "cardColors", "Landroidx/compose/material3/CardColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/CardColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "cardColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CardColors;", "defaultCardColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultCardColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/CardColors;", "elevatedCardColors", "elevatedCardColors-ro_MJ88", "defaultElevatedCardColors", "getDefaultElevatedCardColors$material3", "outlinedCardColors", "outlinedCardColors-ro_MJ88", "defaultOutlinedCardColors", "getDefaultOutlinedCardColors$material3", "outlinedCardBorder", "Landroidx/compose/foundation/BorderStroke;", StreamManagement.Enabled.ELEMENT, "", "(ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CardDefaults {
    public static final int $stable = 0;
    public static final CardDefaults INSTANCE = new CardDefaults();

    private CardDefaults() {
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1266660211, "C(<get-shape>)370@16546L5:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1266660211, i, -1, "androidx.compose.material3.CardDefaults.<get-shape> (Card.kt:370)");
        }
        Shape value = ShapesKt.getValue(FilledCardTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getElevatedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -133496185, "C(<get-elevatedShape>)374@16691L5:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-133496185, i, -1, "androidx.compose.material3.CardDefaults.<get-elevatedShape> (Card.kt:374)");
        }
        Shape value = ShapesKt.getValue(ElevatedCardTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getOutlinedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1095404023, "C(<get-outlinedShape>)378@16836L5:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1095404023, i, -1, "androidx.compose.material3.CardDefaults.<get-outlinedShape> (Card.kt:378)");
        }
        Shape value = ShapesKt.getValue(OutlinedCardTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: cardElevation-aqJV_2Y, reason: not valid java name */
    public final CardElevation m2531cardElevationaqJV_2Y(float f2, float f3, float f4, float f5, float f6, float f7, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -574898487, "C(cardElevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,draggedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Card.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f2 = FilledCardTokens.INSTANCE.m4498getContainerElevationD9Ej5fM();
        }
        float f8 = f2;
        if ((i2 & 2) != 0) {
            f3 = FilledCardTokens.INSTANCE.m4504getPressedContainerElevationD9Ej5fM();
        }
        float f9 = f3;
        if ((i2 & 4) != 0) {
            f4 = FilledCardTokens.INSTANCE.m4501getFocusContainerElevationD9Ej5fM();
        }
        float f10 = f4;
        if ((i2 & 8) != 0) {
            f5 = FilledCardTokens.INSTANCE.m4502getHoverContainerElevationD9Ej5fM();
        }
        float f11 = f5;
        float fM4500getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? FilledCardTokens.INSTANCE.m4500getDraggedContainerElevationD9Ej5fM() : f6;
        float fM4499getDisabledContainerElevationD9Ej5fM = (i2 & 32) != 0 ? FilledCardTokens.INSTANCE.m4499getDisabledContainerElevationD9Ej5fM() : f7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-574898487, i, -1, "androidx.compose.material3.CardDefaults.cardElevation (Card.kt:400)");
        }
        CardElevation cardElevation = new CardElevation(f8, f9, f10, f11, fM4500getDraggedContainerElevationD9Ej5fM, fM4499getDisabledContainerElevationD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return cardElevation;
    }

    /* JADX INFO: renamed from: elevatedCardElevation-aqJV_2Y, reason: not valid java name */
    public final CardElevation m2533elevatedCardElevationaqJV_2Y(float f2, float f3, float f4, float f5, float f6, float f7, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1154241939, "C(elevatedCardElevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,draggedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Card.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f2 = ElevatedCardTokens.INSTANCE.m4416getContainerElevationD9Ej5fM();
        }
        float f8 = f2;
        if ((i2 & 2) != 0) {
            f3 = ElevatedCardTokens.INSTANCE.m4422getPressedContainerElevationD9Ej5fM();
        }
        float f9 = f3;
        if ((i2 & 4) != 0) {
            f4 = ElevatedCardTokens.INSTANCE.m4419getFocusContainerElevationD9Ej5fM();
        }
        float f10 = f4;
        if ((i2 & 8) != 0) {
            f5 = ElevatedCardTokens.INSTANCE.m4420getHoverContainerElevationD9Ej5fM();
        }
        float f11 = f5;
        float fM4418getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? ElevatedCardTokens.INSTANCE.m4418getDraggedContainerElevationD9Ej5fM() : f6;
        float fM4417getDisabledContainerElevationD9Ej5fM = (i2 & 32) != 0 ? ElevatedCardTokens.INSTANCE.m4417getDisabledContainerElevationD9Ej5fM() : f7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1154241939, i, -1, "androidx.compose.material3.CardDefaults.elevatedCardElevation (Card.kt:430)");
        }
        CardElevation cardElevation = new CardElevation(f8, f9, f10, f11, fM4418getDraggedContainerElevationD9Ej5fM, fM4417getDisabledContainerElevationD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return cardElevation;
    }

    /* JADX INFO: renamed from: outlinedCardElevation-aqJV_2Y, reason: not valid java name */
    public final CardElevation m2535outlinedCardElevationaqJV_2Y(float f2, float f3, float f4, float f5, float f6, float f7, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -97678773, "C(outlinedCardElevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,draggedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Card.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f2 = OutlinedCardTokens.INSTANCE.m4650getContainerElevationD9Ej5fM();
        }
        float f8 = f2;
        float f9 = (i2 & 2) != 0 ? f8 : f3;
        float f10 = (i2 & 4) != 0 ? f8 : f4;
        float f11 = (i2 & 8) != 0 ? f8 : f5;
        float fM4652getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? OutlinedCardTokens.INSTANCE.m4652getDraggedContainerElevationD9Ej5fM() : f6;
        float fM4651getDisabledContainerElevationD9Ej5fM = (i2 & 32) != 0 ? OutlinedCardTokens.INSTANCE.m4651getDisabledContainerElevationD9Ej5fM() : f7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-97678773, i, -1, "androidx.compose.material3.CardDefaults.outlinedCardElevation (Card.kt:459)");
        }
        CardElevation cardElevation = new CardElevation(f8, f9, f10, f11, fM4652getDraggedContainerElevationD9Ej5fM, fM4651getDisabledContainerElevationD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return cardElevation;
    }

    public final CardColors cardColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1876034303, "C(cardColors)472@21474L11:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1876034303, i, -1, "androidx.compose.material3.CardDefaults.cardColors (Card.kt:472)");
        }
        CardColors defaultCardColors$material3 = getDefaultCardColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultCardColors$material3;
    }

    /* JADX INFO: renamed from: cardColors-ro_MJ88, reason: not valid java name */
    public final CardColors m2530cardColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1589582123, "C(cardColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)486@22085L31,490@22291L11:Card.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        long jM2664contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m2664contentColorForek8zF_U(jM6004getUnspecified0d7_KjU, composer, i & 14) : j2;
        long jM6004getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        long jM5967copywmQWz5c$default = (i2 & 8) != 0 ? Color.m5967copywmQWz5c$default(jM2664contentColorForek8zF_U, 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1589582123, i, -1, "androidx.compose.material3.CardDefaults.cardColors (Card.kt:490)");
        }
        CardColors cardColorsM2525copyjRlVdoo = getDefaultCardColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2525copyjRlVdoo(jM6004getUnspecified0d7_KjU, jM2664contentColorForek8zF_U, jM6004getUnspecified0d7_KjU2, jM5967copywmQWz5c$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return cardColorsM2525copyjRlVdoo;
    }

    public final CardColors getDefaultCardColors$material3(ColorScheme colorScheme) {
        CardColors defaultCardColorsCached = colorScheme.getDefaultCardColorsCached();
        if (defaultCardColorsCached != null) {
            return defaultCardColorsCached;
        }
        CardColors cardColors = new CardColors(ColorSchemeKt.fromToken(colorScheme, FilledCardTokens.INSTANCE.getContainerColor()), ColorSchemeKt.m2663contentColorFor4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, FilledCardTokens.INSTANCE.getContainerColor())), ColorKt.m6013compositeOverOWjLjI(Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledCardTokens.INSTANCE.getDisabledContainerColor()), FilledCardTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledCardTokens.INSTANCE.getContainerColor())), Color.m5967copywmQWz5c$default(ColorSchemeKt.m2663contentColorFor4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, FilledCardTokens.INSTANCE.getContainerColor())), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultCardColorsCached$material3(cardColors);
        return cardColors;
    }

    public final CardColors elevatedCardColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1610137975, "C(elevatedCardColors)518@23660L11:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1610137975, i, -1, "androidx.compose.material3.CardDefaults.elevatedCardColors (Card.kt:518)");
        }
        CardColors defaultElevatedCardColors$material3 = getDefaultElevatedCardColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultElevatedCardColors$material3;
    }

    /* JADX INFO: renamed from: elevatedCardColors-ro_MJ88, reason: not valid java name */
    public final CardColors m2532elevatedCardColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 139558303, "C(elevatedCardColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)532@24328L31,536@24534L11:Card.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        long jM2664contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m2664contentColorForek8zF_U(jM6004getUnspecified0d7_KjU, composer, i & 14) : j2;
        long jM6004getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        long jM5967copywmQWz5c$default = (i2 & 8) != 0 ? Color.m5967copywmQWz5c$default(jM2664contentColorForek8zF_U, 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(139558303, i, -1, "androidx.compose.material3.CardDefaults.elevatedCardColors (Card.kt:536)");
        }
        CardColors cardColorsM2525copyjRlVdoo = getDefaultElevatedCardColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2525copyjRlVdoo(jM6004getUnspecified0d7_KjU, jM2664contentColorForek8zF_U, jM6004getUnspecified0d7_KjU2, jM5967copywmQWz5c$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return cardColorsM2525copyjRlVdoo;
    }

    public final CardColors getDefaultElevatedCardColors$material3(ColorScheme colorScheme) {
        CardColors defaultElevatedCardColorsCached = colorScheme.getDefaultElevatedCardColorsCached();
        if (defaultElevatedCardColorsCached != null) {
            return defaultElevatedCardColorsCached;
        }
        CardColors cardColors = new CardColors(ColorSchemeKt.fromToken(colorScheme, ElevatedCardTokens.INSTANCE.getContainerColor()), ColorSchemeKt.m2663contentColorFor4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, ElevatedCardTokens.INSTANCE.getContainerColor())), ColorKt.m6013compositeOverOWjLjI(Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ElevatedCardTokens.INSTANCE.getDisabledContainerColor()), ElevatedCardTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, ElevatedCardTokens.INSTANCE.getDisabledContainerColor())), Color.m5967copywmQWz5c$default(ColorSchemeKt.m2663contentColorFor4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, ElevatedCardTokens.INSTANCE.getContainerColor())), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultElevatedCardColorsCached$material3(cardColors);
        return cardColors;
    }

    public final CardColors outlinedCardColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1204388929, "C(outlinedCardColors)567@26053L11:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1204388929, i, -1, "androidx.compose.material3.CardDefaults.outlinedCardColors (Card.kt:567)");
        }
        CardColors defaultOutlinedCardColors$material3 = getDefaultOutlinedCardColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultOutlinedCardColors$material3;
    }

    /* JADX INFO: renamed from: outlinedCardColors-ro_MJ88, reason: not valid java name */
    public final CardColors m2534outlinedCardColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1112362409, "C(outlinedCardColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)581@26721L31,583@26851L31,585@26946L11:Card.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        long jM2664contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m2664contentColorForek8zF_U(jM6004getUnspecified0d7_KjU, composer, i & 14) : j2;
        long jM6004getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        long jM5967copywmQWz5c$default = (i2 & 8) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.m2664contentColorForek8zF_U(jM6004getUnspecified0d7_KjU, composer, i & 14), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1112362409, i, -1, "androidx.compose.material3.CardDefaults.outlinedCardColors (Card.kt:585)");
        }
        CardColors cardColorsM2525copyjRlVdoo = getDefaultOutlinedCardColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2525copyjRlVdoo(jM6004getUnspecified0d7_KjU, jM2664contentColorForek8zF_U, jM6004getUnspecified0d7_KjU2, jM5967copywmQWz5c$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return cardColorsM2525copyjRlVdoo;
    }

    public final CardColors getDefaultOutlinedCardColors$material3(ColorScheme colorScheme) {
        CardColors defaultOutlinedCardColorsCached = colorScheme.getDefaultOutlinedCardColorsCached();
        if (defaultOutlinedCardColorsCached != null) {
            return defaultOutlinedCardColorsCached;
        }
        CardColors cardColors = new CardColors(ColorSchemeKt.fromToken(colorScheme, OutlinedCardTokens.INSTANCE.getContainerColor()), ColorSchemeKt.m2663contentColorFor4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, OutlinedCardTokens.INSTANCE.getContainerColor())), ColorSchemeKt.fromToken(colorScheme, OutlinedCardTokens.INSTANCE.getContainerColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.m2663contentColorFor4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, OutlinedCardTokens.INSTANCE.getContainerColor())), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultOutlinedCardColorsCached$material3(cardColors);
        return cardColors;
    }

    public final BorderStroke outlinedCardBorder(boolean z, Composer composer, int i, int i2) {
        long jM6013compositeOverOWjLjI;
        ComposerKt.sourceInformationMarkerStart(composer, -392936593, "C(outlinedCardBorder)N(enabled)622@28587L72:Card.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            z = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-392936593, i, -1, "androidx.compose.material3.CardDefaults.outlinedCardBorder (Card.kt:613)");
        }
        if (z) {
            composer.startReplaceGroup(2106932974);
            ComposerKt.sourceInformation(composer, "616@28316L5");
            jM6013compositeOverOWjLjI = ColorSchemeKt.getValue(OutlinedCardTokens.INSTANCE.getOutlineColor(), composer, 6);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(2107012365);
            ComposerKt.sourceInformation(composer, "618@28399L5,620@28551L5");
            jM6013compositeOverOWjLjI = ColorKt.m6013compositeOverOWjLjI(Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedCardTokens.INSTANCE.getDisabledOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.getValue(ElevatedCardTokens.INSTANCE.getContainerColor(), composer, 6));
            composer.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerStart(composer, 345070519, "CC(remember):Card.kt#9igjgp");
        boolean zChanged = composer.changed(jM6013compositeOverOWjLjI);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = BorderStrokeKt.m348BorderStrokecXLIe8U(OutlinedCardTokens.INSTANCE.m4656getOutlineWidthD9Ej5fM(), jM6013compositeOverOWjLjI);
            composer.updateRememberedValue(objRememberedValue);
        }
        BorderStroke borderStroke = (BorderStroke) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return borderStroke;
    }
}
