package com.appnew.android.Utils.Network.retrofit;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class RetrofitResponse {
    private static final String TAG = "RetrofitResponse";

    static /* synthetic */ void lambda$GetApiData$0() {
    }

    public static void GetApiData(Context context, String auth_code, String msg, boolean showMaintanance) {
        if (auth_code != null) {
            try {
                if (!auth_code.equalsIgnoreCase(Const.EXPIRY_AUTH_CODE)) {
                    if (showMaintanance) {
                        DialogUtils.makeSingleButtonDialog((Activity) context, context.getString(R.string.maintain_app_dialog_title), context.getString(R.string.maintain_app_dialog_message), context.getResources().getString(R.string.close), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Utils.Network.retrofit.RetrofitResponse$$ExternalSyntheticLambda0
                            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                            public final void onOKClick() {
                                RetrofitResponse.lambda$GetApiData$0();
                            }
                        });
                    }
                } else {
                    if (SharedPreference.getInstance().getLoggedInUser().getId() == null || TextUtils.isEmpty(SharedPreference.getInstance().getLoggedInUser().getId())) {
                        return;
                    }
                    Toast.makeText(context, "" + msg, 1).show();
                    Helper.SignOutUser(context);
                }
            } catch (Exception unused) {
            }
        }
    }
}
