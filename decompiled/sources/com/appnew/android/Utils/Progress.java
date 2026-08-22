package com.appnew.android.Utils;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.wang.avi.AVLoadingIndicatorView;

/* JADX INFO: loaded from: classes6.dex */
public class Progress extends Dialog {
    private static final String TAG = "Progress";
    private final Context context;
    private AVLoadingIndicatorView progressIV;

    public Progress(Context context) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.context = context;
        try {
            requestWindowFeature(1);
            setContentView(com.eduteria.app.app.R.layout.progress_layout);
            Window window = getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.gravity = 17;
                attributes.flags &= -5;
                window.setAttributes(attributes);
                window.setLayout(-1, -1);
            }
            this.progressIV = (AVLoadingIndicatorView) findViewById(com.eduteria.app.app.R.id.testLoader);
            super.setCancelable(false);
        } catch (Exception e2) {
            Log.e(TAG, "Error initializing Progress dialog", e2);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        if (isContextValid()) {
            try {
                if (isShowing()) {
                    return;
                }
                super.show();
                return;
            } catch (Exception e2) {
                Log.e(TAG, "Exception showing progress dialog", e2);
                return;
            }
        }
        Log.w(TAG, "Attempted to show progress dialog with invalid context");
    }

    @Override // android.app.Dialog
    public void hide() {
        try {
            if (isShowing()) {
                super.hide();
            }
        } catch (Exception e2) {
            Log.e(TAG, "Exception hiding progress dialog", e2);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            if (isShowing()) {
                super.dismiss();
            }
        } catch (Exception e2) {
            Log.e(TAG, "Exception dismissing progress dialog", e2);
        }
    }

    private boolean isContextValid() {
        Context context = this.context;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                return true;
            }
        }
        return false;
    }
}
