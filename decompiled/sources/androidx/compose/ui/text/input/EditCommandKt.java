package androidx.compose.ui.text.input;

import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;

/* JADX INFO: compiled from: EditCommand.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¨\u0006\u0005"}, d2 = {"isSurrogatePair", "", Constants.PRIORITY_HIGH, "", "low", "ui-text"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class EditCommandKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isSurrogatePair(char c2, char c3) {
        return Character.isHighSurrogate(c2) && Character.isLowSurrogate(c3);
    }
}
