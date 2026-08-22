package com.appnew.android.Utils;

import android.content.Context;
import androidx.media3.common.util.Util;
import androidx.multidex.MultiDexApplication;
import com.eduteria.app.app.R;
import com.google.firebase.FirebaseApp;

/* JADX INFO: loaded from: classes6.dex */
public class eMedicozApp extends MultiDexApplication {
    private static Context appContext;
    protected String userAgent;

    public static Context getAppContext() {
        return appContext;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(appContext);
        appContext = this;
        this.userAgent = Util.getUserAgent(this, getResources().getString(R.string.app_name));
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
    }
}
