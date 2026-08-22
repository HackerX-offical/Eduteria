package com.appnew.android.Download.Audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes6.dex */
public class HomeWatcher {
    static final String TAG = "hg";
    private Context mContext;
    private IntentFilter mFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    private OnHomePressedListener mListener;
    private InnerReceiver mReceiver;

    public HomeWatcher(Context context) {
        this.mContext = context;
    }

    public void setOnHomePressedListener(OnHomePressedListener listener) {
        this.mListener = listener;
        this.mReceiver = new InnerReceiver();
    }

    public void startWatch() {
        InnerReceiver innerReceiver = this.mReceiver;
        if (innerReceiver != null) {
            this.mContext.registerReceiver(innerReceiver, this.mFilter);
        }
    }

    public void stopWatch() {
        InnerReceiver innerReceiver = this.mReceiver;
        if (innerReceiver != null) {
            this.mContext.unregisterReceiver(innerReceiver);
        }
    }

    class InnerReceiver extends BroadcastReceiver {
        final String SYSTEM_DIALOG_REASON_KEY = "reason";
        final String SYSTEM_DIALOG_REASON_GLOBAL_ACTIONS = "globalactions";
        final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";
        final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";

        InnerReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (!intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") || (stringExtra = intent.getStringExtra("reason")) == null || HomeWatcher.this.mListener == null) {
                return;
            }
            if (stringExtra.equals("homekey")) {
                HomeWatcher.this.mListener.onHomePressed();
            } else if (stringExtra.equals("recentapps")) {
                HomeWatcher.this.mListener.onHomeLongPressed();
            }
        }
    }
}
