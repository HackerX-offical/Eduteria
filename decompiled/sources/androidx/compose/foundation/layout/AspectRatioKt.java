package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AspectRatio.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {Constants.INAPP_ASPECT_RATIO, "Landroidx/compose/ui/Modifier;", "ratio", "", "matchHeightConstraintsFirst", "", "isSatisfiedBy", "Landroidx/compose/ui/unit/Constraints;", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "isSatisfiedBy-NN6Ew-U", "(JII)Z", "foundation-layout"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AspectRatioKt {
    public static /* synthetic */ Modifier aspectRatio$default(Modifier modifier, float f2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return aspectRatio(modifier, f2, z);
    }

    public static final Modifier aspectRatio(Modifier modifier, final float f2, final boolean z) {
        return modifier.then(new AspectRatioElement(f2, z, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.AspectRatioKt$aspectRatio$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName(Constants.INAPP_ASPECT_RATIO);
                inspectorInfo.getProperties().set("ratio", Float.valueOf(f2));
                inspectorInfo.getProperties().set("matchHeightConstraintsFirst", Boolean.valueOf(z));
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }

    /* JADX INFO: renamed from: isSatisfiedBy-NN6Ew-U, reason: not valid java name */
    public static final boolean m843isSatisfiedByNN6EwU(long j, int i, int i2) {
        int iM8785getMinWidthimpl = Constraints.m8785getMinWidthimpl(j);
        if (i > Constraints.m8783getMaxWidthimpl(j) || iM8785getMinWidthimpl > i) {
            return false;
        }
        return i2 <= Constraints.m8782getMaxHeightimpl(j) && Constraints.m8784getMinHeightimpl(j) <= i2;
    }
}
