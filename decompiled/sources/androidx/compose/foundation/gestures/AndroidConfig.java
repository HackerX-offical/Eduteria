package androidx.compose.foundation.gestures;

import android.view.ViewConfiguration;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidScrollable.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\b\u001a\u00020\t*\u00020\nH\u0001¢\u0006\u0002\b\u000bJ\u0011\u0010\f\u001a\u00020\t*\u00020\nH\u0001¢\u0006\u0002\b\rJ#\u0010\u000e\u001a\u00020\u000f*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/gestures/AndroidConfig;", "Landroidx/compose/foundation/gestures/ScrollConfig;", "viewConfiguration", "Landroid/view/ViewConfiguration;", "<init>", "(Landroid/view/ViewConfiguration;)V", "getViewConfiguration", "()Landroid/view/ViewConfiguration;", "getVerticalScrollFactor", "", "Landroidx/compose/ui/unit/Density;", "getVerticalScrollFactor$foundation", "getHorizontalScrollFactor", "getHorizontalScrollFactor$foundation", "calculateMouseWheelScroll", "Landroidx/compose/ui/geometry/Offset;", "event", "Landroidx/compose/ui/input/pointer/PointerEvent;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "calculateMouseWheelScroll-8xgXZGE", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/input/pointer/PointerEvent;J)J", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidConfig implements ScrollConfig {
    public static final int $stable = 8;
    private final ViewConfiguration viewConfiguration;

    public AndroidConfig(ViewConfiguration viewConfiguration) {
        this.viewConfiguration = viewConfiguration;
    }

    public final ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public final float getVerticalScrollFactor$foundation(Density density) {
        return ViewConfigurationApi26Impl.INSTANCE.getVerticalScrollFactor(this.viewConfiguration);
    }

    public final float getHorizontalScrollFactor$foundation(Density density) {
        return ViewConfigurationApi26Impl.INSTANCE.getHorizontalScrollFactor(this.viewConfiguration);
    }

    @Override // androidx.compose.foundation.gestures.ScrollConfig
    /* JADX INFO: renamed from: calculateMouseWheelScroll-8xgXZGE, reason: not valid java name */
    public long mo517calculateMouseWheelScroll8xgXZGE(Density density, PointerEvent pointerEvent, long j) {
        float f2 = -getVerticalScrollFactor$foundation(density);
        float f3 = -getHorizontalScrollFactor$foundation(density);
        List<PointerInputChange> changes = pointerEvent.getChanges();
        Offset offsetM5712boximpl = Offset.m5712boximpl(Offset.INSTANCE.m5739getZeroF1C5BW0());
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            offsetM5712boximpl = Offset.m5712boximpl(Offset.m5728plusMKHz9U(offsetM5712boximpl.m5733unboximpl(), changes.get(i).getScrollDelta()));
        }
        long jM5733unboximpl = offsetM5712boximpl.m5733unboximpl();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jM5733unboximpl >> 32)) * f3;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM5733unboximpl & 4294967295L)) * f2;
        return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
    }
}
