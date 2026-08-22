package com.skydoves.powermenu.kotlin;

import android.app.Activity;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"isFinishing", "", "Landroid/content/Context;", "powermenu_release"}, k = 2, mv = {1, 4, 1})
public final class ContextExtensionsKt {
    public static final boolean isFinishing(Context isFinishing) {
        Intrinsics.checkNotNullParameter(isFinishing, "$this$isFinishing");
        return (isFinishing instanceof Activity) && ((Activity) isFinishing).isFinishing();
    }
}
