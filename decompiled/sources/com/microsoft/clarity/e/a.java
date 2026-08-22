package com.microsoft.clarity.e;

import android.content.Context;
import com.microsoft.clarity.b.a;
import com.microsoft.clarity.models.DynamicConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {
    public static void a(Context context, String projectId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        com.microsoft.clarity.g.g gVar = com.microsoft.clarity.b.a.f689a;
        DynamicConfig.INSTANCE.updateSharedPreferences(context, a.C0184a.a(context).a(projectId));
    }
}
