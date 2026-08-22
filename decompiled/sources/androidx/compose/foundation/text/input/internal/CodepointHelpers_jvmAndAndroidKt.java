package androidx.compose.foundation.text.input.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: CodepointHelpers.jvmAndAndroid.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0005\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0007"}, d2 = {"codePointAt", "", "", FirebaseAnalytics.Param.INDEX, "charCount", "codePoint", "codePointBefore", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CodepointHelpers_jvmAndAndroidKt {
    public static final int codePointAt(CharSequence charSequence, int i) {
        return Character.codePointAt(charSequence, i);
    }

    public static final int charCount(int i) {
        return Character.charCount(i);
    }

    public static final int codePointBefore(CharSequence charSequence, int i) {
        return Character.codePointBefore(charSequence, i);
    }
}
