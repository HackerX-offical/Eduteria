package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.AnnotatedString;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;

/* JADX INFO: compiled from: TextAnnotatedStringNode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {Constants.KEY_HAS_LINKS, "", "Landroidx/compose/ui/text/AnnotatedString;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TextAnnotatedStringNodeKt {
    public static final boolean hasLinks(AnnotatedString annotatedString) {
        return annotatedString.hasLinkAnnotations(0, annotatedString.length());
    }
}
