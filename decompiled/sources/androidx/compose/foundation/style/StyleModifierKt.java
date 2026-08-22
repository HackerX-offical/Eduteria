package androidx.compose.foundation.style;

import androidx.compose.foundation.text.modifiers.StylePhase;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import com.clevertap.android.sdk.Constants;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import org.jivesoftware.smackx.fallback_indication.element.FallbackIndicationElement;

/* JADX INFO: compiled from: StyleModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0007\"\u00020\u0005H\u0007¢\u0006\u0002\u0010\b\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007\u001a\u0015\u0010\u0011\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0082\b\u001a\u0015\u0010\u0013\u001a\u00020\u0014*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0082\b\u001a\u0019\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014H\u0082\b\u001a\u001c\u0010\u0019\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u000eH\u0082\u0002¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0013\u0010\u001d\u001a\u00020\u0014*\u00020\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 \u001a(\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\rH\u0002\u001a\u0018\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%H\u0002\u001a\u001b\u0010*\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002¢\u0006\u0004\b+\u0010\u001c\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000\"\u0019\u0010\f\u001a\u00020\r*\u00020\u000e8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000f\"\u0019\u0010\u0010\u001a\u00020\r*\u00020\u000e8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000f¨\u0006,"}, d2 = {"styleable", "Landroidx/compose/ui/Modifier;", "styleState", "Landroidx/compose/foundation/style/StyleState;", "style", "Landroidx/compose/foundation/style/Style;", "styles", "", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/style/StyleState;[Landroidx/compose/foundation/style/Style;)Landroidx/compose/ui/Modifier;", "StyleableWithNoStyles", "", "OuterNodeKey", "isSpecified", "", "", "(F)Z", "isUnspecified", "addIfSpecified", "abs", "takeRoundedOrElse", "", FallbackIndicationElement.ELEMENT, "addMaxWithMinimum", Constants.PRIORITY_MAX, "value", "minus", "Landroidx/compose/ui/geometry/CornerRadius;", "minus-Kibmq7A", "(JF)J", "toFlags", "Landroidx/compose/foundation/text/modifiers/StylePhase;", "toFlags-uwmK9pY", "(I)I", "createRoundRectPath", "Landroidx/compose/ui/graphics/Path;", "targetPath", "roundedRect", "Landroidx/compose/ui/geometry/RoundRect;", "strokeWidth", "fillArea", "createInsetRoundedRect", "widthPx", "shrink", "shrink-Kibmq7A", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class StyleModifierKt {
    public static final String OuterNodeKey = "StyleOuterNode";
    private static final String StyleableWithNoStyles = "The styleable() modifier must provide one or more 'style' parameter values. Calling it with no style parameter values has no effect.";

    private static final int addMaxWithMinimum(int i, int i2) {
        if (i == Integer.MAX_VALUE) {
            return i;
        }
        int i3 = i + i2;
        if (i3 < 0) {
            return 0;
        }
        return i3;
    }

    public static /* synthetic */ Modifier styleable$default(Modifier modifier, StyleState styleState, Style style, int i, Object obj) {
        if ((i & 1) != 0) {
            styleState = null;
        }
        return styleable(modifier, styleState, style);
    }

    public static final Modifier styleable(Modifier modifier, StyleState styleState, Style style) {
        return style == Style.INSTANCE ? modifier : modifier.then(new StyleElement(styleState, style)).then(StyleInnerElement.INSTANCE);
    }

    public static final Modifier styleable(Modifier modifier, StyleState styleState, Style... styleArr) {
        return styleable(modifier, styleState, StyleKt.Style((Style[]) Arrays.copyOf(styleArr, styleArr.length)));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = StyleableWithNoStyles)
    public static final Modifier styleable(Modifier modifier, StyleState styleState) {
        throw new IllegalStateException(StyleableWithNoStyles.toString());
    }

    private static final boolean isSpecified(float f2) {
        return !Float.isNaN(f2);
    }

    private static final boolean isUnspecified(float f2) {
        return Float.isNaN(f2);
    }

    private static final float addIfSpecified(float f2, float f3) {
        return Float.isNaN(f3) ? f2 : f2 + f3;
    }

    private static final int takeRoundedOrElse(float f2, int i) {
        return Float.isNaN(f2) ? i : Math.round(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toFlags-uwmK9pY, reason: not valid java name */
    public static final int m1623toFlagsuwmK9pY(int i) {
        if (StylePhase.m2253equalsimpl0(i, StylePhase.INSTANCE.m2259getLayoutoWBPZag())) {
            return 32;
        }
        return StylePhase.m2253equalsimpl0(i, StylePhase.INSTANCE.m2258getDrawoWBPZag()) ? 64 : 96;
    }

    private static final Path createRoundRectPath(Path path, RoundRect roundRect, float f2, boolean z) {
        path.reset();
        Path.addRoundRect$default(path, roundRect, null, 2, null);
        if (!z) {
            Path Path = AndroidPath_androidKt.Path();
            Path.addRoundRect$default(Path, createInsetRoundedRect(f2, roundRect), null, 2, null);
            path.mo5857opN5in7k0(path, Path, PathOperation.INSTANCE.m6276getDifferenceb3I0S0c());
        }
        return path;
    }

    private static final RoundRect createInsetRoundedRect(float f2, RoundRect roundRect) {
        return new RoundRect(f2, f2, roundRect.getWidth() - f2, roundRect.getHeight() - f2, m1622shrinkKibmq7A(roundRect.m5773getTopLeftCornerRadiuskKHJgLs(), f2), m1622shrinkKibmq7A(roundRect.m5774getTopRightCornerRadiuskKHJgLs(), f2), m1622shrinkKibmq7A(roundRect.m5772getBottomRightCornerRadiuskKHJgLs(), f2), m1622shrinkKibmq7A(roundRect.m5771getBottomLeftCornerRadiuskKHJgLs(), f2), null);
    }

    /* JADX INFO: renamed from: minus-Kibmq7A, reason: not valid java name */
    private static final long m1621minusKibmq7A(long j, float f2) {
        float fMax = Math.max(0.0f, Float.intBitsToFloat((int) (j >> 32)) - f2);
        float fMax2 = Math.max(0.0f, Float.intBitsToFloat((int) (j & 4294967295L)) - f2);
        return CornerRadius.m5677constructorimpl((((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(fMax2)) & 4294967295L));
    }

    /* JADX INFO: renamed from: shrink-Kibmq7A, reason: not valid java name */
    private static final long m1622shrinkKibmq7A(long j, float f2) {
        float fMax = Math.max(0.0f, Float.intBitsToFloat((int) (j >> 32)) - f2);
        float fMax2 = Math.max(0.0f, Float.intBitsToFloat((int) (j & 4294967295L)) - f2);
        return CornerRadius.m5677constructorimpl((((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(fMax2)) & 4294967295L));
    }
}
