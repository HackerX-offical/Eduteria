package com.clevertap.android.sdk;

import android.content.Context;

/* JADX INFO: loaded from: classes7.dex */
abstract class BaseSessionManager {
    abstract void destroySession();

    abstract void lazyCreateSession(Context context);

    BaseSessionManager() {
    }
}
