package androidx.compose.foundation.text.input;

import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;

/* JADX INFO: compiled from: TextFieldCharSequence.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0014\u0010\b\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\f\u0010\t\u001a\u00020\u0004*\u00020\u0005H\u0000*\u0018\b\u0000\u0010\u0000\"\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\n"}, d2 = {"PlacedAnnotation", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "getTextBeforeSelection", "", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "maxChars", "", "getTextAfterSelection", "getSelectedText", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TextFieldCharSequenceKt {
    public static final CharSequence getTextBeforeSelection(TextFieldCharSequence textFieldCharSequence, int i) {
        int iM8271getMinimpl = TextRange.m8271getMinimpl(textFieldCharSequence.getSelection());
        int i2 = iM8271getMinimpl - i;
        if (((i ^ iM8271getMinimpl) & (iM8271getMinimpl ^ i2)) < 0) {
            i2 = 0;
        }
        return textFieldCharSequence.subSequence(Math.max(0, i2), TextRange.m8271getMinimpl(textFieldCharSequence.getSelection()));
    }

    public static final CharSequence getTextAfterSelection(TextFieldCharSequence textFieldCharSequence, int i) {
        int iM8270getMaximpl = TextRange.m8270getMaximpl(textFieldCharSequence.getSelection());
        int iM8270getMaximpl2 = TextRange.m8270getMaximpl(textFieldCharSequence.getSelection());
        int length = iM8270getMaximpl2 + i;
        if (((i ^ length) & (iM8270getMaximpl2 ^ length)) < 0) {
            length = textFieldCharSequence.length();
        }
        return textFieldCharSequence.subSequence(iM8270getMaximpl, Math.min(length, textFieldCharSequence.length()));
    }

    public static final CharSequence getSelectedText(TextFieldCharSequence textFieldCharSequence) {
        return textFieldCharSequence.subSequence(TextRange.m8271getMinimpl(textFieldCharSequence.getSelection()), TextRange.m8270getMaximpl(textFieldCharSequence.getSelection()));
    }
}
