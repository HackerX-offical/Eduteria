package com.appnew.android.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import com.appnew.android.Login.Activity.SplashScreen;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class DeveloperOptionDialog {
    private static DeveloperOptionDialog instance;
    private Activity activity;
    private AlertDialog dialog;
    private boolean isDialogShowing;

    private DeveloperOptionDialog() {
    }

    public static DeveloperOptionDialog getInstance() {
        if (instance == null) {
            instance = new DeveloperOptionDialog();
        }
        return instance;
    }

    public void showDialog(final Activity context) {
        this.activity = context;
        if (this.dialog == null || !this.isDialogShowing) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Alert !!").setMessage(context.getResources().getString(R.string.developer_option)).setPositiveButton("Go to settings", new DialogInterface.OnClickListener() { // from class: com.appnew.android.Utils.DeveloperOptionDialog$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    DeveloperOptionDialog.lambda$showDialog$0(context, dialogInterface, i);
                }
            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.appnew.android.Utils.DeveloperOptionDialog$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    context.finishAffinity();
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            this.dialog = alertDialogCreate;
            alertDialogCreate.setCanceledOnTouchOutside(false);
            this.dialog.setCancelable(false);
            if (!context.isFinishing() && !context.isDestroyed()) {
                this.dialog.show();
            }
            this.isDialogShowing = true;
        }
    }

    static /* synthetic */ void lambda$showDialog$0(Activity activity, DialogInterface dialogInterface, int i) {
        activity.startActivityForResult(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"), 0);
        if (activity instanceof SplashScreen) {
            activity.finishAffinity();
        }
    }

    public void dismissDialog() {
        if (this.dialog != null && !this.activity.isFinishing() && !this.activity.isDestroyed()) {
            this.dialog.dismiss();
        }
        this.isDialogShowing = false;
    }
}
