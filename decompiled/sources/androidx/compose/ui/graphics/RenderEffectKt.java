package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;

/* JADX INFO: compiled from: RenderEffect.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0007¨\u0006\r"}, d2 = {"BlurEffect", "Landroidx/compose/ui/graphics/BlurEffect;", "radiusX", "", "radiusY", "edgeTreatment", "Landroidx/compose/ui/graphics/TileMode;", "BlurEffect-3YTHUZs", "(FFI)Landroidx/compose/ui/graphics/BlurEffect;", "OffsetEffect", "Landroidx/compose/ui/graphics/OffsetEffect;", "offsetX", "offsetY", "ui-graphics"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class RenderEffectKt {
    /* JADX INFO: renamed from: BlurEffect-3YTHUZs$default, reason: not valid java name */
    public static /* synthetic */ BlurEffect m6295BlurEffect3YTHUZs$default(float f2, float f3, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = TileMode.INSTANCE.m6365getClamp3opZhB0();
        }
        return m6294BlurEffect3YTHUZs(f2, f3, i);
    }

    /* JADX INFO: renamed from: BlurEffect-3YTHUZs, reason: not valid java name */
    public static final BlurEffect m6294BlurEffect3YTHUZs(float f2, float f3, int i) {
        return new BlurEffect(null, f2, f3, i, null);
    }

    public static final OffsetEffect OffsetEffect(float f2, float f3) {
        return new OffsetEffect(null, Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(f3)) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32)), null);
    }
}
