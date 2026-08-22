package androidx.compose.foundation.border;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import kotlin.Metadata;

/* JADX INFO: compiled from: BorderLogic.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u001b\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"createRoundRectPath", "Landroidx/compose/ui/graphics/Path;", "targetPath", "roundedRect", "Landroidx/compose/ui/geometry/RoundRect;", "strokeWidth", "", "fillArea", "", "createInsetRoundedRect", "widthPx", "shrink", "Landroidx/compose/ui/geometry/CornerRadius;", "value", "shrink-Kibmq7A", "(JF)J", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class BorderLogicKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Path createRoundRectPath(Path path, RoundRect roundRect, float f2, boolean z) {
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
        return new RoundRect(roundRect.getLeft() + f2, roundRect.getTop() + f2, roundRect.getRight() - f2, roundRect.getBottom() - f2, m430shrinkKibmq7A(roundRect.m5773getTopLeftCornerRadiuskKHJgLs(), f2), m430shrinkKibmq7A(roundRect.m5774getTopRightCornerRadiuskKHJgLs(), f2), m430shrinkKibmq7A(roundRect.m5772getBottomRightCornerRadiuskKHJgLs(), f2), m430shrinkKibmq7A(roundRect.m5771getBottomLeftCornerRadiuskKHJgLs(), f2), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: shrink-Kibmq7A, reason: not valid java name */
    public static final long m430shrinkKibmq7A(long j, float f2) {
        float fMax = Math.max(0.0f, Float.intBitsToFloat((int) (j >> 32)) - f2);
        float fMax2 = Math.max(0.0f, Float.intBitsToFloat((int) (j & 4294967295L)) - f2);
        return CornerRadius.m5677constructorimpl((((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(fMax2)) & 4294967295L));
    }
}
