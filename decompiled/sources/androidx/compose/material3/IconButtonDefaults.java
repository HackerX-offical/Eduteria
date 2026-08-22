package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.FilledIconButtonTokens;
import androidx.compose.material3.tokens.FilledTonalIconButtonTokens;
import androidx.compose.material3.tokens.OutlinedIconButtonTokens;
import androidx.compose.material3.tokens.SmallIconButtonTokens;
import androidx.compose.material3.tokens.StandardIconButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: IconButtonDefaults.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001_B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u0005*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0014\u0010\rJ\u0011\u0010\u0015\u001a\u00020\u0005*\u00020\u000fH\u0000¢\u0006\u0002\b\u0016J\r\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\u0018*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010!\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\b\"\u0010\u001dJ\u0011\u0010#\u001a\u00020\u0018*\u00020\u000fH\u0000¢\u0006\u0002\b$J\r\u0010%\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010%\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b&\u0010\rJ\r\u0010*\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010*\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\b+\u0010\u001dJ\r\u0010/\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010/\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b0\u0010\rJ\r\u00103\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u00103\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\b4\u0010\u001dJ\r\u00107\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u00107\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b8\u0010\rJ\u001b\u00109\u001a\u00020\u0005*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0000¢\u0006\u0004\b:\u0010\u0012J\r\u0010;\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010;\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b<\u0010\rJ\u0011\u0010=\u001a\u00020\u0005*\u00020\u000fH\u0000¢\u0006\u0002\b>J\r\u0010?\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010?\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\b@\u0010\u001dJ\u001b\u0010A\u001a\u00020\u0018*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0000¢\u0006\u0004\bB\u0010 J\r\u0010C\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010C\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\bD\u0010\u001dJ\u0011\u0010E\u001a\u00020\u0018*\u00020\u000fH\u0000¢\u0006\u0002\bFJ\u001f\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020JH\u0007¢\u0006\u0002\u0010LJ\u001f\u0010M\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020JH\u0007¢\u0006\u0002\u0010LJ\u0015\u0010N\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0007¢\u0006\u0002\u0010OJ\u0015\u0010P\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0007¢\u0006\u0002\u0010OJ\u0019\u0010Y\u001a\u00020Z2\b\b\u0002\u0010[\u001a\u00020\\H\u0000¢\u0006\u0004\b]\u0010^R\u0018\u0010'\u001a\u00020\u0005*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0018\u0010,\u001a\u00020\u0018*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0018\u00101\u001a\u00020\u0005*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b2\u0010)R\u0018\u00105\u001a\u00020\u0018*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u0010.R\u0011\u0010Q\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0011\u0010U\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bV\u0010TR\u0011\u0010W\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bX\u0010T¨\u0006`"}, d2 = {"Landroidx/compose/material3/IconButtonDefaults;", "", "<init>", "()V", "iconButtonColors", "Landroidx/compose/material3/IconButtonColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconButtonColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "iconButtonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconButtonColors;", "defaultIconButtonColors", "Landroidx/compose/material3/ColorScheme;", "localContentColor", "defaultIconButtonColors-4WTKRHQ$material3", "(Landroidx/compose/material3/ColorScheme;J)Landroidx/compose/material3/IconButtonColors;", "iconButtonVibrantColors", "iconButtonVibrantColors-ro_MJ88", "defaultIconButtonVibrantColors", "defaultIconButtonVibrantColors$material3", "iconToggleButtonColors", "Landroidx/compose/material3/IconToggleButtonColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconToggleButtonColors;", "checkedContainerColor", "checkedContentColor", "iconToggleButtonColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconToggleButtonColors;", "defaultIconToggleButtonColors", "defaultIconToggleButtonColors-4WTKRHQ$material3", "(Landroidx/compose/material3/ColorScheme;J)Landroidx/compose/material3/IconToggleButtonColors;", "iconToggleButtonVibrantColors", "iconToggleButtonVibrantColors-5tl4gsc", "defaultIconToggleButtonVibrantColors", "defaultIconToggleButtonVibrantColors$material3", "filledIconButtonColors", "filledIconButtonColors-ro_MJ88", "defaultFilledIconButtonColors", "getDefaultFilledIconButtonColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/IconButtonColors;", "filledIconToggleButtonColors", "filledIconToggleButtonColors-5tl4gsc", "defaultFilledIconToggleButtonColors", "getDefaultFilledIconToggleButtonColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/IconToggleButtonColors;", "filledTonalIconButtonColors", "filledTonalIconButtonColors-ro_MJ88", "defaultFilledTonalIconButtonColors", "getDefaultFilledTonalIconButtonColors$material3", "filledTonalIconToggleButtonColors", "filledTonalIconToggleButtonColors-5tl4gsc", "defaultFilledTonalIconToggleButtonColors", "getDefaultFilledTonalIconToggleButtonColors$material3", "outlinedIconButtonColors", "outlinedIconButtonColors-ro_MJ88", "defaultOutlinedIconButtonColors", "defaultOutlinedIconButtonColors-4WTKRHQ$material3", "outlinedIconButtonVibrantColors", "outlinedIconButtonVibrantColors-ro_MJ88", "defaultOutlinedIconButtonVibrantColors", "defaultOutlinedIconButtonVibrantColors$material3", "outlinedIconToggleButtonColors", "outlinedIconToggleButtonColors-5tl4gsc", "defaultOutlinedIconToggleButtonColors", "defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3", "outlinedIconToggleButtonVibrantColors", "outlinedIconToggleButtonVibrantColors-5tl4gsc", "defaultOutlinedIconToggleButtonVibrantColors", "defaultOutlinedIconToggleButtonVibrantColors$material3", "outlinedIconToggleButtonBorder", "Landroidx/compose/foundation/BorderStroke;", StreamManagement.Enabled.ELEMENT, "", "checked", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconToggleButtonVibrantBorder", "outlinedIconButtonBorder", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconButtonVibrantBorder", "standardShape", "Landroidx/compose/ui/graphics/Shape;", "getStandardShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "filledShape", "getFilledShape", "outlinedShape", "getOutlinedShape", "smallContainerSize", "Landroidx/compose/ui/unit/DpSize;", "widthOption", "Landroidx/compose/material3/IconButtonDefaults$IconButtonWidthOption;", "smallContainerSize-N-wlBFI$material3", "(I)J", "IconButtonWidthOption", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IconButtonDefaults {
    public static final int $stable = 0;
    public static final IconButtonDefaults INSTANCE = new IconButtonDefaults();

    private IconButtonDefaults() {
    }

    public final IconButtonColors iconButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1037266503, "C(iconButtonColors)43@1790L7,44@1833L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1037266503, i, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButtonDefaults.kt:42)");
        }
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM5978unboximpl = ((Color) objConsume).m5978unboximpl();
        IconButtonColors iconButtonColorsM2961defaultIconButtonColors4WTKRHQ$material3 = m2961defaultIconButtonColors4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6), jM5978unboximpl);
        if (!Color.m5969equalsimpl0(iconButtonColorsM2961defaultIconButtonColors4WTKRHQ$material3.getContentColor(), jM5978unboximpl)) {
            iconButtonColorsM2961defaultIconButtonColors4WTKRHQ$material3 = IconButtonColors.m2952copyjRlVdoo$default(iconButtonColorsM2961defaultIconButtonColors4WTKRHQ$material3, 0L, jM5978unboximpl, 0L, Color.m5967copywmQWz5c$default(jM5978unboximpl, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), 5, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsM2961defaultIconButtonColors4WTKRHQ$material3;
    }

    /* JADX INFO: renamed from: iconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m2969iconButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        long jM5978unboximpl;
        long j5;
        long jM5967copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, -1639168605, "C(iconButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)73@3133L7,78@3368L11,79@3435L7:IconButtonDefaults.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        if ((i2 & 2) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM5978unboximpl = ((Color) objConsume).m5978unboximpl();
        } else {
            jM5978unboximpl = j2;
        }
        long jM6004getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j6 = jM5978unboximpl;
            jM5967copywmQWz5c$default = Color.m5967copywmQWz5c$default(j6, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            j5 = j6;
        } else {
            j5 = jM5978unboximpl;
            jM5967copywmQWz5c$default = j4;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1639168605, i, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButtonDefaults.kt:78)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer, 6);
        ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localContentColor2);
        ComposerKt.sourceInformationMarkerEnd(composer);
        IconButtonColors iconButtonColorsM2955copyjRlVdoo = m2961defaultIconButtonColors4WTKRHQ$material3(colorScheme, ((Color) objConsume2).m5978unboximpl()).m2955copyjRlVdoo(jM6004getUnspecified0d7_KjU, j5, jM6004getUnspecified0d7_KjU2, jM5967copywmQWz5c$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsM2955copyjRlVdoo;
    }

    /* JADX INFO: renamed from: defaultIconButtonColors-4WTKRHQ$material3, reason: not valid java name */
    public final IconButtonColors m2961defaultIconButtonColors4WTKRHQ$material3(ColorScheme colorScheme, long j) {
        IconButtonColors defaultIconButtonColorsCached = colorScheme.getDefaultIconButtonColorsCached();
        if (defaultIconButtonColorsCached != null) {
            return defaultIconButtonColorsCached;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(Color.INSTANCE.m6003getTransparent0d7_KjU(), j, Color.INSTANCE.m6003getTransparent0d7_KjU(), Color.m5967copywmQWz5c$default(j, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultIconButtonColorsCached$material3(iconButtonColors);
        return iconButtonColors;
    }

    public final IconButtonColors iconButtonVibrantColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 111454247, "C(iconButtonVibrantColors)110@4699L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(111454247, i, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonVibrantColors (IconButtonDefaults.kt:110)");
        }
        IconButtonColors iconButtonColorsDefaultIconButtonVibrantColors$material3 = defaultIconButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsDefaultIconButtonVibrantColors$material3;
    }

    /* JADX INFO: renamed from: iconButtonVibrantColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m2970iconButtonVibrantColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1036440437, "C(iconButtonVibrantColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)132@5742L11:IconButtonDefaults.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        long jM6004getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j2;
        long jM6004getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        long jM5967copywmQWz5c$default = (i2 & 8) != 0 ? Color.m5967copywmQWz5c$default(jM6004getUnspecified0d7_KjU2, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1036440437, i, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonVibrantColors (IconButtonDefaults.kt:132)");
        }
        IconButtonColors iconButtonColorsM2955copyjRlVdoo = defaultIconButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2955copyjRlVdoo(jM6004getUnspecified0d7_KjU, jM6004getUnspecified0d7_KjU2, jM6004getUnspecified0d7_KjU3, jM5967copywmQWz5c$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsM2955copyjRlVdoo;
    }

    public final IconButtonColors defaultIconButtonVibrantColors$material3(ColorScheme colorScheme) {
        IconButtonColors defaultIconButtonVibrantColorsCached = colorScheme.getDefaultIconButtonVibrantColorsCached();
        if (defaultIconButtonVibrantColorsCached != null) {
            return defaultIconButtonVibrantColorsCached;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(Color.INSTANCE.m6003getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, StandardIconButtonTokens.INSTANCE.getColor()), Color.INSTANCE.m6003getTransparent0d7_KjU(), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, StandardIconButtonTokens.INSTANCE.getDisabledColor()), StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultIconButtonVibrantColorsCached$material3(iconButtonColors);
        return iconButtonColors;
    }

    public final IconToggleButtonColors iconToggleButtonColors(Composer composer, int i) {
        composer.startReplaceGroup(-1355771567);
        ComposerKt.sourceInformation(composer, "C(iconToggleButtonColors)165@7229L7,166@7272L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1355771567, i, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonColors (IconButtonDefaults.kt:164)");
        }
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM5978unboximpl = ((Color) objConsume).m5978unboximpl();
        IconToggleButtonColors iconToggleButtonColorsM2962defaultIconToggleButtonColors4WTKRHQ$material3 = m2962defaultIconToggleButtonColors4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6), jM5978unboximpl);
        if (Color.m5969equalsimpl0(iconToggleButtonColorsM2962defaultIconToggleButtonColors4WTKRHQ$material3.getContentColor(), jM5978unboximpl)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return iconToggleButtonColorsM2962defaultIconToggleButtonColors4WTKRHQ$material3;
        }
        IconToggleButtonColors iconToggleButtonColorsM2999copytNS2XkQ$default = IconToggleButtonColors.m2999copytNS2XkQ$default(iconToggleButtonColorsM2962defaultIconToggleButtonColors4WTKRHQ$material3, 0L, jM5978unboximpl, 0L, Color.m5967copywmQWz5c$default(jM5978unboximpl, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 53, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return iconToggleButtonColorsM2999copytNS2XkQ$default;
    }

    /* JADX INFO: renamed from: iconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m2971iconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        long jM5978unboximpl;
        long j7;
        long jM5967copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, 1402082449, "C(iconToggleButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)196@8713L7,203@9068L11,204@9141L7:IconButtonDefaults.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        if ((i2 & 2) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM5978unboximpl = ((Color) objConsume).m5978unboximpl();
        } else {
            jM5978unboximpl = j2;
        }
        long jM6004getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j8 = jM5978unboximpl;
            jM5967copywmQWz5c$default = Color.m5967copywmQWz5c$default(j8, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            j7 = j8;
        } else {
            j7 = jM5978unboximpl;
            jM5967copywmQWz5c$default = j4;
        }
        long jM6004getUnspecified0d7_KjU3 = (i2 & 16) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j5;
        long jM6004getUnspecified0d7_KjU4 = (i2 & 32) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1402082449, i, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonColors (IconButtonDefaults.kt:203)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer, 6);
        ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localContentColor2);
        ComposerKt.sourceInformationMarkerEnd(composer);
        IconToggleButtonColors iconToggleButtonColorsM3000copytNS2XkQ = m2962defaultIconToggleButtonColors4WTKRHQ$material3(colorScheme, ((Color) objConsume2).m5978unboximpl()).m3000copytNS2XkQ(jM6004getUnspecified0d7_KjU, j7, jM6004getUnspecified0d7_KjU2, jM5967copywmQWz5c$default, jM6004getUnspecified0d7_KjU3, jM6004getUnspecified0d7_KjU4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsM3000copytNS2XkQ;
    }

    /* JADX INFO: renamed from: defaultIconToggleButtonColors-4WTKRHQ$material3, reason: not valid java name */
    public final IconToggleButtonColors m2962defaultIconToggleButtonColors4WTKRHQ$material3(ColorScheme colorScheme, long j) {
        IconToggleButtonColors defaultIconToggleButtonColorsCached = colorScheme.getDefaultIconToggleButtonColorsCached();
        if (defaultIconToggleButtonColorsCached != null) {
            return defaultIconToggleButtonColorsCached;
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(Color.INSTANCE.m6003getTransparent0d7_KjU(), j, Color.INSTANCE.m6003getTransparent0d7_KjU(), Color.m5967copywmQWz5c$default(j, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.INSTANCE.m6003getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, StandardIconButtonTokens.INSTANCE.getSelectedColor()), null);
        colorScheme.setDefaultIconToggleButtonColorsCached$material3(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final IconToggleButtonColors iconToggleButtonVibrantColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1755001127, "C(iconToggleButtonVibrantColors)241@10812L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1755001127, i, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonVibrantColors (IconButtonDefaults.kt:241)");
        }
        IconToggleButtonColors iconToggleButtonColorsDefaultIconToggleButtonVibrantColors$material3 = defaultIconToggleButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsDefaultIconToggleButtonVibrantColors$material3;
    }

    /* JADX INFO: renamed from: iconToggleButtonVibrantColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m2972iconToggleButtonVibrantColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1027328773, "C(iconToggleButtonVibrantColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)267@12180L11:IconButtonDefaults.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        long jM6004getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j2;
        long jM6004getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        long jM5967copywmQWz5c$default = (i2 & 8) != 0 ? Color.m5967copywmQWz5c$default(jM6004getUnspecified0d7_KjU2, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j4;
        long jM6004getUnspecified0d7_KjU4 = (i2 & 16) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j5;
        long jM6004getUnspecified0d7_KjU5 = (i2 & 32) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1027328773, i, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonVibrantColors (IconButtonDefaults.kt:267)");
        }
        IconToggleButtonColors iconToggleButtonColorsM3000copytNS2XkQ = defaultIconToggleButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3000copytNS2XkQ(jM6004getUnspecified0d7_KjU, jM6004getUnspecified0d7_KjU2, jM6004getUnspecified0d7_KjU3, jM5967copywmQWz5c$default, jM6004getUnspecified0d7_KjU4, jM6004getUnspecified0d7_KjU5);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsM3000copytNS2XkQ;
    }

    public final IconToggleButtonColors defaultIconToggleButtonVibrantColors$material3(ColorScheme colorScheme) {
        IconToggleButtonColors defaultIconToggleButtonVibrantColorsCached = colorScheme.getDefaultIconToggleButtonVibrantColorsCached();
        if (defaultIconToggleButtonVibrantColorsCached != null) {
            return defaultIconToggleButtonVibrantColorsCached;
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(Color.INSTANCE.m6003getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, StandardIconButtonTokens.INSTANCE.getUnselectedColor()), Color.INSTANCE.m6003getTransparent0d7_KjU(), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, StandardIconButtonTokens.INSTANCE.getDisabledColor()), StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.INSTANCE.m6003getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, StandardIconButtonTokens.INSTANCE.getSelectedColor()), null);
        colorScheme.setDefaultIconToggleButtonVibrantColorsCached$material3(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final IconButtonColors filledIconButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -958304265, "C(filledIconButtonColors)300@13760L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-958304265, i, -1, "androidx.compose.material3.IconButtonDefaults.filledIconButtonColors (IconButtonDefaults.kt:300)");
        }
        IconButtonColors defaultFilledIconButtonColors$material3 = getDefaultFilledIconButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultFilledIconButtonColors$material3;
    }

    /* JADX INFO: renamed from: filledIconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m2965filledIconButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -245481051, "C(filledIconButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)313@14404L31,317@14601L11:IconButtonDefaults.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        long jM2664contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m2664contentColorForek8zF_U(jM6004getUnspecified0d7_KjU, composer, i & 14) : j2;
        long jM6004getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        long jM6004getUnspecified0d7_KjU3 = (i2 & 8) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-245481051, i, -1, "androidx.compose.material3.IconButtonDefaults.filledIconButtonColors (IconButtonDefaults.kt:317)");
        }
        IconButtonColors iconButtonColorsM2955copyjRlVdoo = getDefaultFilledIconButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2955copyjRlVdoo(jM6004getUnspecified0d7_KjU, jM2664contentColorForek8zF_U, jM6004getUnspecified0d7_KjU2, jM6004getUnspecified0d7_KjU3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsM2955copyjRlVdoo;
    }

    public final IconButtonColors getDefaultFilledIconButtonColors$material3(ColorScheme colorScheme) {
        IconButtonColors defaultFilledIconButtonColorsCached = colorScheme.getDefaultFilledIconButtonColorsCached();
        if (defaultFilledIconButtonColorsCached != null) {
            return defaultFilledIconButtonColorsCached;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getDisabledContainerColor()), FilledIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getDisabledColor()), FilledIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultFilledIconButtonColorsCached$material3(iconButtonColors);
        return iconButtonColors;
    }

    public final IconToggleButtonColors filledIconToggleButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1455160689, "C(filledIconToggleButtonColors)346@16003L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1455160689, i, -1, "androidx.compose.material3.IconButtonDefaults.filledIconToggleButtonColors (IconButtonDefaults.kt:346)");
        }
        IconToggleButtonColors defaultFilledIconToggleButtonColors$material3 = getDefaultFilledIconToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultFilledIconToggleButtonColors$material3;
    }

    /* JADX INFO: renamed from: filledIconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m2966filledIconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1473292947, "C(filledIconToggleButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)368@17217L38,370@17311L11:IconButtonDefaults.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        long jM6004getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j2;
        long jM6004getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        long jM6004getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j4;
        long jM6004getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j5;
        long jM2664contentColorForek8zF_U = (i2 & 32) != 0 ? ColorSchemeKt.m2664contentColorForek8zF_U(jM6004getUnspecified0d7_KjU5, composer, (i >> 12) & 14) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1473292947, i, -1, "androidx.compose.material3.IconButtonDefaults.filledIconToggleButtonColors (IconButtonDefaults.kt:370)");
        }
        IconToggleButtonColors iconToggleButtonColorsM3000copytNS2XkQ = getDefaultFilledIconToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3000copytNS2XkQ(jM6004getUnspecified0d7_KjU, jM6004getUnspecified0d7_KjU2, jM6004getUnspecified0d7_KjU3, jM6004getUnspecified0d7_KjU4, jM6004getUnspecified0d7_KjU5, jM2664contentColorForek8zF_U);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsM3000copytNS2XkQ;
    }

    public final IconToggleButtonColors getDefaultFilledIconToggleButtonColors$material3(ColorScheme colorScheme) {
        IconToggleButtonColors defaultFilledIconToggleButtonColorsCached = colorScheme.getDefaultFilledIconToggleButtonColorsCached();
        if (defaultFilledIconToggleButtonColorsCached != null) {
            return defaultFilledIconToggleButtonColorsCached;
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getUnselectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getUnselectedColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getDisabledContainerColor()), FilledIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getDisabledColor()), FilledIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getSelectedColor()), null);
        colorScheme.setDefaultFilledIconToggleButtonColorsCached$material3(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final IconButtonColors filledTonalIconButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1145002745, "C(filledTonalIconButtonColors)407@19290L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1145002745, i, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconButtonColors (IconButtonDefaults.kt:407)");
        }
        IconButtonColors defaultFilledTonalIconButtonColors$material3 = getDefaultFilledTonalIconButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultFilledTonalIconButtonColors$material3;
    }

    /* JADX INFO: renamed from: filledTonalIconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m2967filledTonalIconButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 562762851, "C(filledTonalIconButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)421@19956L31,425@20153L11:IconButtonDefaults.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        long jM2664contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m2664contentColorForek8zF_U(jM6004getUnspecified0d7_KjU, composer, i & 14) : j2;
        long jM6004getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        long jM6004getUnspecified0d7_KjU3 = (i2 & 8) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(562762851, i, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconButtonColors (IconButtonDefaults.kt:425)");
        }
        IconButtonColors iconButtonColorsM2955copyjRlVdoo = getDefaultFilledTonalIconButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2955copyjRlVdoo(jM6004getUnspecified0d7_KjU, jM2664contentColorForek8zF_U, jM6004getUnspecified0d7_KjU2, jM6004getUnspecified0d7_KjU3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsM2955copyjRlVdoo;
    }

    public final IconButtonColors getDefaultFilledTonalIconButtonColors$material3(ColorScheme colorScheme) {
        IconButtonColors defaultFilledTonalIconButtonColorsCached = colorScheme.getDefaultFilledTonalIconButtonColorsCached();
        if (defaultFilledTonalIconButtonColorsCached != null) {
            return defaultFilledTonalIconButtonColorsCached;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerColor()), FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getDisabledColor()), FilledTonalIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultFilledTonalIconButtonColorsCached$material3(iconButtonColors);
        return iconButtonColors;
    }

    public final IconToggleButtonColors filledTonalIconToggleButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 656374417, "C(filledTonalIconToggleButtonColors)454@21615L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(656374417, i, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconToggleButtonColors (IconButtonDefaults.kt:454)");
        }
        IconToggleButtonColors defaultFilledTonalIconToggleButtonColors$material3 = getDefaultFilledTonalIconToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultFilledTonalIconToggleButtonColors$material3;
    }

    /* JADX INFO: renamed from: filledTonalIconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m2968filledTonalIconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 2130748241, "C(filledTonalIconToggleButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)470@22481L31,474@22725L38,476@22819L11:IconButtonDefaults.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        long jM2664contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m2664contentColorForek8zF_U(jM6004getUnspecified0d7_KjU, composer, i & 14) : j2;
        long jM6004getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        long jM6004getUnspecified0d7_KjU3 = (i2 & 8) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j4;
        long jM6004getUnspecified0d7_KjU4 = (i2 & 16) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j5;
        long jM2664contentColorForek8zF_U2 = (i2 & 32) != 0 ? ColorSchemeKt.m2664contentColorForek8zF_U(jM6004getUnspecified0d7_KjU4, composer, (i >> 12) & 14) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2130748241, i, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconToggleButtonColors (IconButtonDefaults.kt:476)");
        }
        IconToggleButtonColors iconToggleButtonColorsM3000copytNS2XkQ = getDefaultFilledTonalIconToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3000copytNS2XkQ(jM6004getUnspecified0d7_KjU, jM2664contentColorForek8zF_U, jM6004getUnspecified0d7_KjU2, jM6004getUnspecified0d7_KjU3, jM6004getUnspecified0d7_KjU4, jM2664contentColorForek8zF_U2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsM3000copytNS2XkQ;
    }

    public final IconToggleButtonColors getDefaultFilledTonalIconToggleButtonColors$material3(ColorScheme colorScheme) {
        IconToggleButtonColors defaultFilledTonalIconToggleButtonColorsCached = colorScheme.getDefaultFilledTonalIconToggleButtonColorsCached();
        if (defaultFilledTonalIconToggleButtonColorsCached != null) {
            return defaultFilledTonalIconToggleButtonColorsCached;
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getUnselectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getUnselectedColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerColor()), FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getDisabledColor()), FilledTonalIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getSelectedColor()), null);
        colorScheme.setDefaultFilledTonalIconToggleButtonColorsCached$material3(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final IconButtonColors outlinedIconButtonColors(Composer composer, int i) {
        composer.startReplaceGroup(1591384183);
        ComposerKt.sourceInformation(composer, "C(outlinedIconButtonColors)514@24910L7,515@24953L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1591384183, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonColors (IconButtonDefaults.kt:513)");
        }
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM5978unboximpl = ((Color) objConsume).m5978unboximpl();
        IconButtonColors iconButtonColorsM2963defaultOutlinedIconButtonColors4WTKRHQ$material3 = m2963defaultOutlinedIconButtonColors4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6), jM5978unboximpl);
        if (Color.m5969equalsimpl0(iconButtonColorsM2963defaultOutlinedIconButtonColors4WTKRHQ$material3.getContentColor(), jM5978unboximpl)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return iconButtonColorsM2963defaultOutlinedIconButtonColors4WTKRHQ$material3;
        }
        IconButtonColors iconButtonColorsM2952copyjRlVdoo$default = IconButtonColors.m2952copyjRlVdoo$default(iconButtonColorsM2963defaultOutlinedIconButtonColors4WTKRHQ$material3, 0L, jM5978unboximpl, 0L, Color.m5967copywmQWz5c$default(jM5978unboximpl, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), 5, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return iconButtonColorsM2952copyjRlVdoo$default;
    }

    /* JADX INFO: renamed from: outlinedIconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m2973outlinedIconButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        long jM5978unboximpl;
        long j5;
        long jM5967copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, -1335916251, "C(outlinedIconButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)542@26100L7,547@26335L11,548@26410L7:IconButtonDefaults.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        if ((i2 & 2) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM5978unboximpl = ((Color) objConsume).m5978unboximpl();
        } else {
            jM5978unboximpl = j2;
        }
        long jM6004getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j6 = jM5978unboximpl;
            jM5967copywmQWz5c$default = Color.m5967copywmQWz5c$default(j6, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            j5 = j6;
        } else {
            j5 = jM5978unboximpl;
            jM5967copywmQWz5c$default = j4;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1335916251, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonColors (IconButtonDefaults.kt:547)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer, 6);
        ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localContentColor2);
        ComposerKt.sourceInformationMarkerEnd(composer);
        IconButtonColors iconButtonColorsM2955copyjRlVdoo = m2963defaultOutlinedIconButtonColors4WTKRHQ$material3(colorScheme, ((Color) objConsume2).m5978unboximpl()).m2955copyjRlVdoo(jM6004getUnspecified0d7_KjU, j5, jM6004getUnspecified0d7_KjU2, jM5967copywmQWz5c$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsM2955copyjRlVdoo;
    }

    /* JADX INFO: renamed from: defaultOutlinedIconButtonColors-4WTKRHQ$material3, reason: not valid java name */
    public final IconButtonColors m2963defaultOutlinedIconButtonColors4WTKRHQ$material3(ColorScheme colorScheme, long j) {
        IconButtonColors defaultOutlinedIconButtonColorsCached = colorScheme.getDefaultOutlinedIconButtonColorsCached();
        if (defaultOutlinedIconButtonColorsCached != null) {
            return defaultOutlinedIconButtonColorsCached;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(Color.INSTANCE.m6003getTransparent0d7_KjU(), j, Color.INSTANCE.m6003getTransparent0d7_KjU(), Color.m5967copywmQWz5c$default(j, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultOutlinedIconButtonColorsCached$material3(iconButtonColors);
        return iconButtonColors;
    }

    public final IconButtonColors outlinedIconButtonVibrantColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -899469399, "C(outlinedIconButtonVibrantColors)581@27717L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-899469399, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonVibrantColors (IconButtonDefaults.kt:581)");
        }
        IconButtonColors iconButtonColorsDefaultOutlinedIconButtonVibrantColors$material3 = defaultOutlinedIconButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsDefaultOutlinedIconButtonVibrantColors$material3;
    }

    /* JADX INFO: renamed from: outlinedIconButtonVibrantColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m2974outlinedIconButtonVibrantColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -278201933, "C(outlinedIconButtonVibrantColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)603@28773L11:IconButtonDefaults.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        long jM6004getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j2;
        long jM6004getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        long jM5967copywmQWz5c$default = (i2 & 8) != 0 ? Color.m5967copywmQWz5c$default(jM6004getUnspecified0d7_KjU2, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-278201933, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonVibrantColors (IconButtonDefaults.kt:603)");
        }
        IconButtonColors iconButtonColorsM2955copyjRlVdoo = defaultOutlinedIconButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2955copyjRlVdoo(jM6004getUnspecified0d7_KjU, jM6004getUnspecified0d7_KjU2, jM6004getUnspecified0d7_KjU3, jM5967copywmQWz5c$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsM2955copyjRlVdoo;
    }

    public final IconButtonColors defaultOutlinedIconButtonVibrantColors$material3(ColorScheme colorScheme) {
        IconButtonColors defaultOutlinedIconButtonVibrantColorsCached = colorScheme.getDefaultOutlinedIconButtonVibrantColorsCached();
        if (defaultOutlinedIconButtonVibrantColorsCached != null) {
            return defaultOutlinedIconButtonVibrantColorsCached;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(Color.INSTANCE.m6003getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getColor()), Color.INSTANCE.m6003getTransparent0d7_KjU(), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getDisabledColor()), OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultOutlinedIconButtonVibrantColorsCached$material3(iconButtonColors);
        return iconButtonColors;
    }

    public final IconToggleButtonColors outlinedIconToggleButtonColors(Composer composer, int i) {
        composer.startReplaceGroup(-834376945);
        ComposerKt.sourceInformation(composer, "C(outlinedIconToggleButtonColors)637@30317L7,638@30360L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-834376945, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonColors (IconButtonDefaults.kt:636)");
        }
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM5978unboximpl = ((Color) objConsume).m5978unboximpl();
        IconToggleButtonColors iconToggleButtonColorsM2964defaultOutlinedIconToggleButtonColors4WTKRHQ$material3 = m2964defaultOutlinedIconToggleButtonColors4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6), jM5978unboximpl);
        if (Color.m5969equalsimpl0(iconToggleButtonColorsM2964defaultOutlinedIconToggleButtonColors4WTKRHQ$material3.getContentColor(), jM5978unboximpl)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return iconToggleButtonColorsM2964defaultOutlinedIconToggleButtonColors4WTKRHQ$material3;
        }
        IconToggleButtonColors iconToggleButtonColorsM2999copytNS2XkQ$default = IconToggleButtonColors.m2999copytNS2XkQ$default(iconToggleButtonColorsM2964defaultOutlinedIconToggleButtonColors4WTKRHQ$material3, 0L, jM5978unboximpl, 0L, Color.m5967copywmQWz5c$default(jM5978unboximpl, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 53, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return iconToggleButtonColorsM2999copytNS2XkQ$default;
    }

    /* JADX INFO: renamed from: outlinedIconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m2975outlinedIconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        long jM5978unboximpl;
        long j7;
        long jM5967copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, -514625005, "C(outlinedIconToggleButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)668@31784L7,673@32066L38,675@32160L11,676@32241L7:IconButtonDefaults.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        if ((i2 & 2) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM5978unboximpl = ((Color) objConsume).m5978unboximpl();
        } else {
            jM5978unboximpl = j2;
        }
        long jM6004getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j8 = jM5978unboximpl;
            jM5967copywmQWz5c$default = Color.m5967copywmQWz5c$default(j8, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            j7 = j8;
        } else {
            j7 = jM5978unboximpl;
            jM5967copywmQWz5c$default = j4;
        }
        long jM6004getUnspecified0d7_KjU3 = (i2 & 16) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j5;
        long jM2664contentColorForek8zF_U = (i2 & 32) != 0 ? ColorSchemeKt.m2664contentColorForek8zF_U(jM6004getUnspecified0d7_KjU3, composer, (i >> 12) & 14) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-514625005, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonColors (IconButtonDefaults.kt:675)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer, 6);
        ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localContentColor2);
        ComposerKt.sourceInformationMarkerEnd(composer);
        IconToggleButtonColors iconToggleButtonColorsM3000copytNS2XkQ = m2964defaultOutlinedIconToggleButtonColors4WTKRHQ$material3(colorScheme, ((Color) objConsume2).m5978unboximpl()).m3000copytNS2XkQ(jM6004getUnspecified0d7_KjU, j7, jM6004getUnspecified0d7_KjU2, jM5967copywmQWz5c$default, jM6004getUnspecified0d7_KjU3, jM2664contentColorForek8zF_U);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsM3000copytNS2XkQ;
    }

    /* JADX INFO: renamed from: defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3, reason: not valid java name */
    public final IconToggleButtonColors m2964defaultOutlinedIconToggleButtonColors4WTKRHQ$material3(ColorScheme colorScheme, long j) {
        IconToggleButtonColors defaultIconToggleButtonColorsCached = colorScheme.getDefaultIconToggleButtonColorsCached();
        if (defaultIconToggleButtonColorsCached != null) {
            return defaultIconToggleButtonColorsCached;
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(Color.INSTANCE.m6003getTransparent0d7_KjU(), j, Color.INSTANCE.m6003getTransparent0d7_KjU(), Color.m5967copywmQWz5c$default(j, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.m2663contentColorFor4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getSelectedContainerColor())), null);
        colorScheme.setDefaultOutlinedIconToggleButtonColorsCached$material3(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final IconToggleButtonColors outlinedIconToggleButtonVibrantColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1236236887, "C(outlinedIconToggleButtonVibrantColors)719@34133L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1236236887, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonVibrantColors (IconButtonDefaults.kt:719)");
        }
        IconToggleButtonColors iconToggleButtonColorsDefaultOutlinedIconToggleButtonVibrantColors$material3 = defaultOutlinedIconToggleButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsDefaultOutlinedIconToggleButtonVibrantColors$material3;
    }

    /* JADX INFO: renamed from: outlinedIconToggleButtonVibrantColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m2976outlinedIconToggleButtonVibrantColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -142016199, "C(outlinedIconToggleButtonVibrantColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)743@35442L38,745@35536L11:IconButtonDefaults.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        long jM6004getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j2;
        long jM6004getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        long jM5967copywmQWz5c$default = (i2 & 8) != 0 ? Color.m5967copywmQWz5c$default(jM6004getUnspecified0d7_KjU2, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j4;
        long jM6004getUnspecified0d7_KjU4 = (i2 & 16) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j5;
        long jM2664contentColorForek8zF_U = (i2 & 32) != 0 ? ColorSchemeKt.m2664contentColorForek8zF_U(jM6004getUnspecified0d7_KjU4, composer, (i >> 12) & 14) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-142016199, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonVibrantColors (IconButtonDefaults.kt:745)");
        }
        IconToggleButtonColors iconToggleButtonColorsM3000copytNS2XkQ = defaultOutlinedIconToggleButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3000copytNS2XkQ(jM6004getUnspecified0d7_KjU, jM6004getUnspecified0d7_KjU2, jM6004getUnspecified0d7_KjU3, jM5967copywmQWz5c$default, jM6004getUnspecified0d7_KjU4, jM2664contentColorForek8zF_U);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsM3000copytNS2XkQ;
    }

    public final IconToggleButtonColors defaultOutlinedIconToggleButtonVibrantColors$material3(ColorScheme colorScheme) {
        IconToggleButtonColors defaultOutlinedIconToggleButtonVibrantColorsCached = colorScheme.getDefaultOutlinedIconToggleButtonVibrantColorsCached();
        if (defaultOutlinedIconToggleButtonVibrantColorsCached != null) {
            return defaultOutlinedIconToggleButtonVibrantColorsCached;
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(Color.INSTANCE.m6003getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getUnselectedColor()), Color.INSTANCE.m6003getTransparent0d7_KjU(), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getDisabledColor()), OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getSelectedColor()), null);
        colorScheme.setDefaultOutlinedIconToggleButtonColorsCached$material3(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final BorderStroke outlinedIconToggleButtonBorder(boolean z, boolean z2, Composer composer, int i) {
        composer.startReplaceGroup(1933433512);
        ComposerKt.sourceInformation(composer, "C(outlinedIconToggleButtonBorder)N(enabled,checked)790@37646L33:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1933433512, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonBorder (IconButtonDefaults.kt:786)");
        }
        if (z2) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return null;
        }
        BorderStroke borderStrokeOutlinedIconButtonBorder = outlinedIconButtonBorder(z, composer, (i & 14) | ((i >> 3) & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return borderStrokeOutlinedIconButtonBorder;
    }

    public final BorderStroke outlinedIconToggleButtonVibrantBorder(boolean z, boolean z2, Composer composer, int i) {
        composer.startReplaceGroup(394022990);
        ComposerKt.sourceInformation(composer, "C(outlinedIconToggleButtonVibrantBorder)N(enabled,checked)805@38193L40:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(394022990, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonVibrantBorder (IconButtonDefaults.kt:801)");
        }
        if (z2) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return null;
        }
        BorderStroke borderStrokeOutlinedIconButtonVibrantBorder = outlinedIconButtonVibrantBorder(z, composer, (i & 14) | ((i >> 3) & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return borderStrokeOutlinedIconButtonVibrantBorder;
    }

    public final BorderStroke outlinedIconButtonBorder(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1270640488, "C(outlinedIconButtonBorder)N(enabled)819@38754L7,826@38979L83:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1270640488, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonBorder (IconButtonDefaults.kt:818)");
        }
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM5978unboximpl = ((Color) objConsume).m5978unboximpl();
        if (!z) {
            jM5978unboximpl = Color.m5967copywmQWz5c$default(jM5978unboximpl, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1314785653, "CC(remember):IconButtonDefaults.kt#9igjgp");
        boolean zChanged = composer.changed(jM5978unboximpl);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = BorderStrokeKt.m348BorderStrokecXLIe8U(SmallIconButtonTokens.INSTANCE.m4803getOutlinedOutlineWidthD9Ej5fM(), jM5978unboximpl);
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

    public final BorderStroke outlinedIconButtonVibrantBorder(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2139728858, "C(outlinedIconButtonVibrantBorder)N(enabled)837@39473L5,844@39696L83:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2139728858, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonVibrantBorder (IconButtonDefaults.kt:836)");
        }
        long value = ColorSchemeKt.getValue(OutlinedIconButtonTokens.INSTANCE.getOutlineColor(), composer, 6);
        if (!z) {
            value = Color.m5967copywmQWz5c$default(value, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1009914297, "CC(remember):IconButtonDefaults.kt#9igjgp");
        boolean zChanged = composer.changed(value);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = BorderStrokeKt.m348BorderStrokecXLIe8U(SmallIconButtonTokens.INSTANCE.m4803getOutlinedOutlineWidthD9Ej5fM(), value);
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

    public final Shape getStandardShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -377108005, "C(<get-standardShape>)849@39946L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-377108005, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-standardShape> (IconButtonDefaults.kt:849)");
        }
        Shape value = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getFilledShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1542796069, "C(<get-filledShape>)853@40101L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1542796069, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-filledShape> (IconButtonDefaults.kt:853)");
        }
        Shape value = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getOutlinedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1706356635, "C(<get-outlinedShape>)857@40261L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1706356635, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-outlinedShape> (IconButtonDefaults.kt:857)");
        }
        Shape value = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: smallContainerSize-N-wlBFI$material3$default, reason: not valid java name */
    public static /* synthetic */ long m2960smallContainerSizeNwlBFI$material3$default(IconButtonDefaults iconButtonDefaults, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = IconButtonWidthOption.INSTANCE.m2986getUniformrc6NtMs();
        }
        return iconButtonDefaults.m2977smallContainerSizeNwlBFI$material3(i);
    }

    /* JADX INFO: renamed from: smallContainerSize-N-wlBFI$material3, reason: not valid java name */
    public final long m2977smallContainerSizeNwlBFI$material3(int widthOption) {
        float fM8830constructorimpl;
        if (!IconButtonWidthOption.m2981equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m2985getNarrowrc6NtMs())) {
            if (!IconButtonWidthOption.m2981equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m2986getUniformrc6NtMs())) {
                if (IconButtonWidthOption.m2981equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m2987getWiderc6NtMs())) {
                    fM8830constructorimpl = Dp.m8830constructorimpl(SmallIconButtonTokens.INSTANCE.m4804getWideLeadingSpaceD9Ej5fM() + SmallIconButtonTokens.INSTANCE.m4805getWideTrailingSpaceD9Ej5fM());
                } else {
                    fM8830constructorimpl = Dp.m8830constructorimpl(0);
                }
            } else {
                fM8830constructorimpl = Dp.m8830constructorimpl(SmallIconButtonTokens.INSTANCE.m4798getDefaultLeadingSpaceD9Ej5fM() + SmallIconButtonTokens.INSTANCE.m4798getDefaultLeadingSpaceD9Ej5fM());
            }
        } else {
            fM8830constructorimpl = Dp.m8830constructorimpl(SmallIconButtonTokens.INSTANCE.m4801getNarrowLeadingSpaceD9Ej5fM() + SmallIconButtonTokens.INSTANCE.m4802getNarrowTrailingSpaceD9Ej5fM());
        }
        return DpKt.m8852DpSizeYgX7TsA(Dp.m8830constructorimpl(SmallIconButtonTokens.INSTANCE.m4800getIconSizeD9Ej5fM() + fM8830constructorimpl), SmallIconButtonTokens.INSTANCE.m4797getContainerHeightD9Ej5fM());
    }

    /* JADX INFO: compiled from: IconButtonDefaults.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/IconButtonDefaults$IconButtonWidthOption;", "", "value", "", "constructor-impl", "(I)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    public static final class IconButtonWidthOption {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int Narrow = m2979constructorimpl(0);
        private static final int Uniform = m2979constructorimpl(1);
        private static final int Wide = m2979constructorimpl(2);
        private final int value;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ IconButtonWidthOption m2978boximpl(int i) {
            return new IconButtonWidthOption(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        private static int m2979constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m2980equalsimpl(int i, Object obj) {
            return (obj instanceof IconButtonWidthOption) && i == ((IconButtonWidthOption) obj).getValue();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2981equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m2982hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        public boolean equals(Object other) {
            return m2980equalsimpl(this.value, other);
        }

        public int hashCode() {
            return m2982hashCodeimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }

        /* JADX INFO: compiled from: IconButtonDefaults.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/material3/IconButtonDefaults$IconButtonWidthOption$Companion;", "", "<init>", "()V", "Narrow", "Landroidx/compose/material3/IconButtonDefaults$IconButtonWidthOption;", "getNarrow-rc6NtMs", "()I", "I", "Uniform", "getUniform-rc6NtMs", "Wide", "getWide-rc6NtMs", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getNarrow-rc6NtMs, reason: not valid java name */
            public final int m2985getNarrowrc6NtMs() {
                return IconButtonWidthOption.Narrow;
            }

            /* JADX INFO: renamed from: getUniform-rc6NtMs, reason: not valid java name */
            public final int m2986getUniformrc6NtMs() {
                return IconButtonWidthOption.Uniform;
            }

            /* JADX INFO: renamed from: getWide-rc6NtMs, reason: not valid java name */
            public final int m2987getWiderc6NtMs() {
                return IconButtonWidthOption.Wide;
            }
        }

        private /* synthetic */ IconButtonWidthOption(int i) {
            this.value = i;
        }

        public String toString() {
            return m2983toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m2983toStringimpl(int i) {
            return m2981equalsimpl0(i, Narrow) ? "Narrow" : m2981equalsimpl0(i, Uniform) ? "Uniform" : m2981equalsimpl0(i, Wide) ? "Wide" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
    }
}
