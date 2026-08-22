package androidx.window.layout.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.inputmethodservice.InputMethodService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextCompatHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/window/layout/util/ContextCompatHelper;", "", "<init>", "()V", "unwrapContext", "Landroid/content/Context;", "context", "unwrapContext$window_release", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextCompatHelper {
    public static final ContextCompatHelper INSTANCE = new ContextCompatHelper();

    private ContextCompatHelper() {
    }

    public final Context unwrapContext$window_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context baseContext = context;
        while (baseContext instanceof ContextWrapper) {
            if (!(baseContext instanceof Activity) && !(baseContext instanceof InputMethodService)) {
                ContextWrapper contextWrapper = (ContextWrapper) baseContext;
                if (contextWrapper.getBaseContext() != null) {
                    baseContext = contextWrapper.getBaseContext();
                    Intrinsics.checkNotNullExpressionValue(baseContext, "getBaseContext(...)");
                }
            }
            return baseContext;
        }
        return context;
    }
}
