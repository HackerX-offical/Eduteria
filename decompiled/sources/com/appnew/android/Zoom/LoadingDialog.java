package com.appnew.android.Zoom;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class LoadingDialog extends Dialog {
    public LoadingDialog(Context context) {
        super(context);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_dialog);
        setCanceledOnTouchOutside(false);
    }
}
