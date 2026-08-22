package com.pallycon.exoplayersample.simple;

import android.content.Context;

/* JADX INFO: loaded from: classes9.dex */
public class VideoCrypt {
    private static VideoCrypt instance;
    private Context context;
    NetworkCallDrm networkCall;

    private VideoCrypt(Context context) {
        this.context = context;
    }

    public static VideoCrypt getInstance(Context context) {
        if (instance == null) {
            instance = new VideoCrypt(context);
        }
        return instance;
    }

    public NetworkCallDrm initialize(InitializePlayerService initializePlayerService, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        NetworkCallDrm networkCallDrm = new NetworkCallDrm(this.context, initializePlayerService, str, str2, str3, str4, str5, str6, str7, str8);
        this.networkCall = networkCallDrm;
        return networkCallDrm;
    }
}
