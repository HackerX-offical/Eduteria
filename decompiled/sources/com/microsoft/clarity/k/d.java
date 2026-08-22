package com.microsoft.clarity.k;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f1052a;

    public d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f1052a = context.getSharedPreferences("CLARITY_SHARED_PREFERENCES", 0);
    }

    public final String a() {
        return this.f1052a.getString("CLARITY_USER_ID", null);
    }

    public final void a(int i) {
        SharedPreferences.Editor editorEdit = this.f1052a.edit();
        editorEdit.putInt("CLARITY_PAGE_NUM", i);
        editorEdit.apply();
    }

    public final void a(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        SharedPreferences.Editor editorEdit = this.f1052a.edit();
        editorEdit.putString("CLARITY_SESSION_ID", sessionId);
        editorEdit.apply();
    }

    public final void b(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        SharedPreferences.Editor editorEdit = this.f1052a.edit();
        editorEdit.putString("CLARITY_USER_ID", userId);
        editorEdit.apply();
    }
}
