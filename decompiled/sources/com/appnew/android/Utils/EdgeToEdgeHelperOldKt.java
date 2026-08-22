package com.appnew.android.Utils;

import android.view.Window;
import kotlin.Metadata;

/* JADX INFO: compiled from: EdgeToEdgeHelperOld.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"safeSetStatusBarColor", "", "Landroid/view/Window;", "color", "", "app_EDUTERIARelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class EdgeToEdgeHelperOldKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void safeSetStatusBarColor(Window window, int i) {
        window.setStatusBarColor(i);
    }
}
