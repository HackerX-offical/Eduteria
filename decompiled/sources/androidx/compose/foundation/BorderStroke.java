package androidx.compose.foundation;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.unit.Dp;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BorderStroke.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J!\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/BorderStroke;", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "Landroidx/compose/ui/unit/Dp;", "brush", "Landroidx/compose/ui/graphics/Brush;", "<init>", "(FLandroidx/compose/ui/graphics/Brush;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getWidth-D9Ej5fM", "()F", "F", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", Constants.COPY_TYPE, "copy-D5KLDUw", "(FLandroidx/compose/ui/graphics/Brush;)Landroidx/compose/foundation/BorderStroke;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BorderStroke {
    public static final int $stable = 0;
    private final Brush brush;
    private final float width;

    public /* synthetic */ BorderStroke(float f2, Brush brush, DefaultConstructorMarker defaultConstructorMarker) {
        this(f2, brush);
    }

    private BorderStroke(float f2, Brush brush) {
        this.width = f2;
        this.brush = brush;
    }

    public final Brush getBrush() {
        return this.brush;
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getWidth() {
        return this.width;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BorderStroke)) {
            return false;
        }
        BorderStroke borderStroke = (BorderStroke) other;
        return Dp.m8835equalsimpl0(this.width, borderStroke.width) && Intrinsics.areEqual(this.brush, borderStroke.brush);
    }

    public int hashCode() {
        return (Dp.m8836hashCodeimpl(this.width) * 31) + this.brush.hashCode();
    }

    public String toString() {
        return "BorderStroke(width=" + ((Object) Dp.m8841toStringimpl(this.width)) + ", brush=" + this.brush + ')';
    }

    /* JADX INFO: renamed from: copy-D5KLDUw$default, reason: not valid java name */
    public static /* synthetic */ BorderStroke m345copyD5KLDUw$default(BorderStroke borderStroke, float f2, Brush brush, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = borderStroke.width;
        }
        if ((i & 2) != 0) {
            brush = borderStroke.brush;
        }
        return borderStroke.m346copyD5KLDUw(f2, brush);
    }

    /* JADX INFO: renamed from: copy-D5KLDUw, reason: not valid java name */
    public final BorderStroke m346copyD5KLDUw(float width, Brush brush) {
        return new BorderStroke(width, brush, null);
    }
}
