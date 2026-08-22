package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: TextPreparedSelection.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"calculateNextCursorPositionAndWedgeAffinity", "Landroidx/compose/foundation/text/input/internal/selection/CursorAndWedgeAffinity;", "proposedCursor", "", "cursor", "transformedTextFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "(IILandroidx/compose/foundation/text/input/internal/TransformedTextFieldState;)J", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TextPreparedSelectionKt {

    /* JADX INFO: compiled from: TextPreparedSelection.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IndexTransformationType.values().length];
            try {
                iArr[IndexTransformationType.Untransformed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IndexTransformationType.Deletion.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IndexTransformationType.Replacement.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IndexTransformationType.Insertion.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final long calculateNextCursorPositionAndWedgeAffinity(int i, int i2, TransformedTextFieldState transformedTextFieldState) {
        IndexTransformationType indexTransformationType;
        if (i == -1) {
            return CursorAndWedgeAffinity.m2142constructorimpl(i2);
        }
        boolean z = i > i2;
        long jM2127mapFromTransformedjx7JFs = transformedTextFieldState.m2127mapFromTransformedjx7JFs(i);
        long jM2130mapToTransformedGEjPoXI = transformedTextFieldState.m2130mapToTransformedGEjPoXI(jM2127mapFromTransformedjx7JFs);
        if (TextRange.m8267getCollapsedimpl(jM2127mapFromTransformedjx7JFs) && TextRange.m8267getCollapsedimpl(jM2130mapToTransformedGEjPoXI)) {
            indexTransformationType = IndexTransformationType.Untransformed;
        } else if (!TextRange.m8267getCollapsedimpl(jM2127mapFromTransformedjx7JFs) && !TextRange.m8267getCollapsedimpl(jM2130mapToTransformedGEjPoXI)) {
            indexTransformationType = IndexTransformationType.Replacement;
        } else if (TextRange.m8267getCollapsedimpl(jM2127mapFromTransformedjx7JFs) && !TextRange.m8267getCollapsedimpl(jM2130mapToTransformedGEjPoXI)) {
            indexTransformationType = IndexTransformationType.Insertion;
        } else {
            indexTransformationType = IndexTransformationType.Deletion;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[indexTransformationType.ordinal()];
        if (i3 == 1) {
            return CursorAndWedgeAffinity.m2143constructorimpl(i, z ? WedgeAffinity.Start : WedgeAffinity.End);
        }
        if (i3 == 2) {
            return CursorAndWedgeAffinity.m2142constructorimpl(i);
        }
        if (i3 == 3) {
            if (z) {
                return CursorAndWedgeAffinity.m2143constructorimpl(TextRange.m8268getEndimpl(jM2130mapToTransformedGEjPoXI), WedgeAffinity.Start);
            }
            return CursorAndWedgeAffinity.m2143constructorimpl(TextRange.m8273getStartimpl(jM2130mapToTransformedGEjPoXI), WedgeAffinity.End);
        }
        if (i3 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        if (z) {
            if (i == TextRange.m8273getStartimpl(jM2130mapToTransformedGEjPoXI)) {
                return CursorAndWedgeAffinity.m2143constructorimpl(i, WedgeAffinity.Start);
            }
            return CursorAndWedgeAffinity.m2143constructorimpl(TextRange.m8268getEndimpl(jM2130mapToTransformedGEjPoXI), WedgeAffinity.End);
        }
        if (i == TextRange.m8268getEndimpl(jM2130mapToTransformedGEjPoXI)) {
            return CursorAndWedgeAffinity.m2143constructorimpl(i, WedgeAffinity.End);
        }
        return CursorAndWedgeAffinity.m2143constructorimpl(TextRange.m8273getStartimpl(jM2130mapToTransformedGEjPoXI), WedgeAffinity.Start);
    }
}
