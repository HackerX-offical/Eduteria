package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.StringsHelpers_jvmAndAndroidKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: CodepointTransformation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\u001c\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0000¨\u0006\u000b"}, d2 = {"mask", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation$Companion;", FirebaseAnalytics.Param.CHARACTER, "", "toVisualText", "", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "codepointTransformation", "offsetMappingCalculator", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CodepointTransformationKt {
    public static final CodepointTransformation mask(CodepointTransformation.Companion companion, char c2) {
        return new MaskCodepointTransformation(c2);
    }

    public static final CharSequence toVisualText(TextFieldCharSequence textFieldCharSequence, CodepointTransformation codepointTransformation, OffsetMappingCalculator offsetMappingCalculator) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        boolean z = false;
        int i2 = 0;
        while (i < textFieldCharSequence.length()) {
            int iCodePointAt = CodepointHelpers_jvmAndAndroidKt.codePointAt(textFieldCharSequence, i);
            int iTransform = codepointTransformation.transform(i2, iCodePointAt);
            int iCharCount = CodepointHelpers_jvmAndAndroidKt.charCount(iCodePointAt);
            if (iTransform != iCodePointAt) {
                offsetMappingCalculator.recordEditOperation(sb.length(), sb.length() + iCharCount, CodepointHelpers_jvmAndAndroidKt.charCount(iTransform));
                z = true;
            }
            StringsHelpers_jvmAndAndroidKt.appendCodePointX(sb, iTransform);
            i += iCharCount;
            i2++;
        }
        return z ? sb.toString() : textFieldCharSequence;
    }
}
