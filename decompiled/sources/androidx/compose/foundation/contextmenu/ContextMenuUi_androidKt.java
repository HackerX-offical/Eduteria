package androidx.compose.foundation.contextmenu;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: ContextMenuUi.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010\u0006\u001a/\u0010\u0007\u001a\u00020\b*\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\"\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\u0004H\u0002\u001a\u001d\u0010\u0011\u001a\u00020\b*\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001d\u0010\u0014\u001a\u00020\b*\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0013¨\u0006\u0016"}, d2 = {"computeContextMenuColors", "Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "backgroundStyleId", "", "foregroundStyleId", "(IILandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "resolveColor", "Landroidx/compose/ui/graphics/Color;", "Landroid/content/Context;", "resId", "attrId", "defaultColor", "resolveColor-g2O1Hgs", "(Landroid/content/Context;IIJ)J", "resolveColorStateList", "Landroid/content/res/ColorStateList;", "enabledColor", "enabledColor-4WTKRHQ", "(Landroid/content/res/ColorStateList;J)J", "disabledColor", "disabledColor-4WTKRHQ", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ContextMenuUi_androidKt {
    public static final ContextMenuColors computeContextMenuColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1428061410, "C(computeContextMenuColors)32@1185L160:ContextMenuUi.android.kt#3xeu6s");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1428061410, i, -1, "androidx.compose.foundation.contextmenu.computeContextMenuColors (ContextMenuUi.android.kt:32)");
        }
        ContextMenuColors contextMenuColorsComputeContextMenuColors = computeContextMenuColors(R.style.Widget.PopupMenu, R.style.TextAppearance.Widget.PopupMenu.Large, composer, 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return contextMenuColorsComputeContextMenuColors;
    }

    public static final ContextMenuColors computeContextMenuColors(int i, int i2, Composer composer, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 1689505294, "C(computeContextMenuColors)N(backgroundStyleId,foregroundStyleId)42@1528L7,43@1584L7,43@1547L851:ContextMenuUi.android.kt#3xeu6s");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1689505294, i3, -1, "androidx.compose.foundation.contextmenu.computeContextMenuColors (ContextMenuUi.android.kt:41)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) objConsume;
        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 116956225, "CC(remember):ContextMenuUi.android.kt#9igjgp");
        boolean zChanged = composer.changed((Configuration) objConsume2) | composer.changed(context);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            long jM472resolveColorg2O1Hgs = m472resolveColorg2O1Hgs(context, i, R.attr.colorBackground, ContextMenuUiKt.getDefaultContextMenuColors().getBackgroundColor());
            ColorStateList colorStateListResolveColorStateList = resolveColorStateList(context, i2, R.attr.textColorPrimary);
            long jM471enabledColor4WTKRHQ = m471enabledColor4WTKRHQ(colorStateListResolveColorStateList, ContextMenuUiKt.getDefaultContextMenuColors().getTextColor());
            long jM470disabledColor4WTKRHQ = m470disabledColor4WTKRHQ(colorStateListResolveColorStateList, ContextMenuUiKt.getDefaultContextMenuColors().getDisabledTextColor());
            Object contextMenuColors = new ContextMenuColors(jM472resolveColorg2O1Hgs, jM471enabledColor4WTKRHQ, jM471enabledColor4WTKRHQ, jM470disabledColor4WTKRHQ, jM470disabledColor4WTKRHQ, null);
            composer.updateRememberedValue(contextMenuColors);
            objRememberedValue = contextMenuColors;
        }
        ContextMenuColors contextMenuColors2 = (ContextMenuColors) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return contextMenuColors2;
    }

    /* JADX INFO: renamed from: resolveColor-g2O1Hgs, reason: not valid java name */
    private static final long m472resolveColorg2O1Hgs(Context context, int i, int i2, long j) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, new int[]{i2});
        int iM6022toArgb8_81llA = ColorKt.m6022toArgb8_81llA(j);
        int color = typedArrayObtainStyledAttributes.getColor(0, iM6022toArgb8_81llA);
        typedArrayObtainStyledAttributes.recycle();
        return color == iM6022toArgb8_81llA ? j : ColorKt.Color(color);
    }

    private static final ColorStateList resolveColorStateList(Context context, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, new int[]{i2});
        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(0);
        typedArrayObtainStyledAttributes.recycle();
        return colorStateList;
    }

    /* JADX INFO: renamed from: enabledColor-4WTKRHQ, reason: not valid java name */
    private static final long m471enabledColor4WTKRHQ(ColorStateList colorStateList, long j) {
        int iM6022toArgb8_81llA = ColorKt.m6022toArgb8_81llA(j);
        Integer numValueOf = colorStateList != null ? Integer.valueOf(colorStateList.getColorForState(new int[]{R.attr.state_enabled}, iM6022toArgb8_81llA)) : null;
        return (numValueOf == null || numValueOf.intValue() == iM6022toArgb8_81llA) ? j : ColorKt.Color(numValueOf.intValue());
    }

    /* JADX INFO: renamed from: disabledColor-4WTKRHQ, reason: not valid java name */
    private static final long m470disabledColor4WTKRHQ(ColorStateList colorStateList, long j) {
        int iM6022toArgb8_81llA = ColorKt.m6022toArgb8_81llA(j);
        Integer numValueOf = colorStateList != null ? Integer.valueOf(colorStateList.getColorForState(new int[]{-16842910}, iM6022toArgb8_81llA)) : null;
        return (numValueOf == null || numValueOf.intValue() == iM6022toArgb8_81llA) ? j : ColorKt.Color(numValueOf.intValue());
    }
}
