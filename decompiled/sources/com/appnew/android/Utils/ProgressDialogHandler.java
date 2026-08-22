package com.appnew.android.Utils;

import android.app.ProgressDialog;
import android.content.Context;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class ProgressDialogHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Context mContext;
    private ProgressDialog mProgressDialog = null;

    public ProgressDialogHandler(Context context) {
        this.mContext = context;
        initProgressBar();
    }

    public void show() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog == null || progressDialog.isShowing()) {
            return;
        }
        this.mProgressDialog.show();
    }

    public void hide() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.mProgressDialog.hide();
        }
        this.mProgressDialog.dismiss();
    }

    private void initProgressBar() {
        ProgressDialog progressDialog = new ProgressDialog(this.mContext, R.style.MyTheme);
        this.mProgressDialog = progressDialog;
        progressDialog.setIndeterminate(false);
        this.mProgressDialog.setCancelable(false);
        this.mProgressDialog.setProgressStyle(android.R.style.Widget.ProgressBar.Small);
    }

    public ProgressDialog getmProgressDialog() {
        return this.mProgressDialog;
    }
}
