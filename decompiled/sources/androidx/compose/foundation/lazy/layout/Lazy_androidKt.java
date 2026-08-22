package androidx.compose.foundation.lazy.layout;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: Lazy.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"getDefaultLazyLayoutKey", "", FirebaseAnalytics.Param.INDEX, "", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class Lazy_androidKt {
    public static final Object getDefaultLazyLayoutKey(int i) {
        return new DefaultLazyKey(i);
    }
}
