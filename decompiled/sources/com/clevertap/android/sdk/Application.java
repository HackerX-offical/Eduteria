package com.clevertap.android.sdk;

/* JADX INFO: loaded from: classes7.dex */
public class Application extends android.app.Application {
    @Override // android.app.Application
    public void onCreate() {
        ActivityLifecycleCallback.register(this);
        super.onCreate();
    }
}
