package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import org.jivesoftware.smackx.message_markup.element.SpanElement;

/* JADX INFO: compiled from: EditingBuffer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", TypedValues.AttributesType.S_TARGET, SpanElement.deleted, "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class EditingBufferKt {
    /* JADX INFO: renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m8441updateRangeAfterDeletepWDy79M(long j, long j2) {
        int iM8269getLengthimpl;
        int iM8271getMinimpl = TextRange.m8271getMinimpl(j);
        int iM8270getMaximpl = TextRange.m8270getMaximpl(j);
        if (TextRange.m8275intersects5zctL8(j2, j)) {
            if (TextRange.m8263contains5zctL8(j2, j)) {
                iM8271getMinimpl = TextRange.m8271getMinimpl(j2);
                iM8270getMaximpl = iM8271getMinimpl;
            } else {
                if (TextRange.m8263contains5zctL8(j, j2)) {
                    iM8269getLengthimpl = TextRange.m8269getLengthimpl(j2);
                } else if (TextRange.m8264containsimpl(j2, iM8271getMinimpl)) {
                    iM8271getMinimpl = TextRange.m8271getMinimpl(j2);
                    iM8269getLengthimpl = TextRange.m8269getLengthimpl(j2);
                } else {
                    iM8270getMaximpl = TextRange.m8271getMinimpl(j2);
                }
                iM8270getMaximpl -= iM8269getLengthimpl;
            }
        } else if (iM8270getMaximpl > TextRange.m8271getMinimpl(j2)) {
            iM8271getMinimpl -= TextRange.m8269getLengthimpl(j2);
            iM8269getLengthimpl = TextRange.m8269getLengthimpl(j2);
            iM8270getMaximpl -= iM8269getLengthimpl;
        }
        return TextRangeKt.TextRange(iM8271getMinimpl, iM8270getMaximpl);
    }
}
