package androidx.compose.foundation.shape;

import androidx.compose.ui.platform.InspectableValue;
import androidx.compose.ui.unit.Density;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: CornerSize.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0013\u001a\u00020\u0004HÂ\u0003J\u0013\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/shape/PxCornerSize;", "Landroidx/compose/foundation/shape/CornerSize;", "Landroidx/compose/ui/platform/InspectableValue;", "size", "", "<init>", "(F)V", "toPx", "shapeSize", "Landroidx/compose/ui/geometry/Size;", "density", "Landroidx/compose/ui/unit/Density;", "toPx-TmRCtEA", "(JLandroidx/compose/ui/unit/Density;)F", InAppPurchaseConstants.METHOD_TO_STRING, "", "valueOverride", "getValueOverride", "()Ljava/lang/String;", "component1", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final /* data */ class PxCornerSize implements CornerSize, InspectableValue {
    private final float size;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final float getSize() {
        return this.size;
    }

    public static /* synthetic */ PxCornerSize copy$default(PxCornerSize pxCornerSize, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = pxCornerSize.size;
        }
        return pxCornerSize.copy(f2);
    }

    public final PxCornerSize copy(float size) {
        return new PxCornerSize(size);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PxCornerSize) && Float.compare(this.size, ((PxCornerSize) other).size) == 0;
    }

    public int hashCode() {
        return Float.hashCode(this.size);
    }

    public PxCornerSize(float f2) {
        this.size = f2;
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    /* JADX INFO: renamed from: toPx-TmRCtEA */
    public float mo1523toPxTmRCtEA(long shapeSize, Density density) {
        return this.size;
    }

    public String toString() {
        return "CornerSize(size = " + this.size + ".px)";
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    public String getValueOverride() {
        return this.size + "px";
    }
}
