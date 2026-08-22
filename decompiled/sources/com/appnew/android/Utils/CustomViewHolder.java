package com.appnew.android.Utils;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Utils.Network.APIInterface;
import com.eduteria.app.app.R;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;

/* JADX INFO: loaded from: classes6.dex */
public abstract class CustomViewHolder extends RecyclerView.ViewHolder {
    public Activity activity;
    String id;
    public Progress mprogress;

    public abstract void ErrorCallBack(String jsonstring, String apitype);

    public abstract void SuccessCallBack(JSONObject jsonstring, String apitype) throws JSONException;

    public abstract Call<String> getAPIB(String apitype, APIInterface service);

    public CustomViewHolder(View itemView) {
        super(itemView);
    }

    public void setContext(Activity context) {
        this.activity = context;
        Progress progress = new Progress(this.activity);
        this.mprogress = progress;
        progress.setCancelable(false);
    }

    public void NetworkAPICall(final String apiType, final boolean showprogress) {
        APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
        if (Helper.isConnected(this.activity)) {
            if (showprogress) {
                this.mprogress.show();
            }
            getAPIB(apiType, aPIInterface).enqueue(new Callback<String>() { // from class: com.appnew.android.Utils.CustomViewHolder.1
                /* JADX WARN: Removed duplicated region for block: B:16:0x0056 A[Catch: JSONException -> 0x0082, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0082, blocks: (B:13:0x0033, B:15:0x0039, B:16:0x0056), top: B:24:0x0033 }] */
                @Override // retrofit2.Callback
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void onResponse(retrofit2.Call<java.lang.String> r5, retrofit2.Response<java.lang.String> r6) {
                    /*
                        r4 = this;
                        boolean r5 = r2
                        if (r5 == 0) goto Lb
                        com.appnew.android.Utils.CustomViewHolder r5 = com.appnew.android.Utils.CustomViewHolder.this
                        com.appnew.android.Utils.Progress r5 = r5.mprogress
                        r5.dismiss()
                    Lb:
                        java.lang.Object r5 = r6.body()
                        r0 = 0
                        if (r5 == 0) goto L87
                        boolean r5 = r6.isSuccessful()
                        if (r5 == 0) goto L87
                        java.lang.Object r5 = r6.body()     // Catch: java.lang.Exception -> L2b
                        java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L2b
                        java.lang.String r1 = com.appnew.android.Utils.AES.generatekeyAPI()     // Catch: java.lang.Exception -> L2b
                        java.lang.String r2 = com.appnew.android.Utils.AES.generateVectorAPI()     // Catch: java.lang.Exception -> L2b
                        java.lang.String r5 = com.appnew.android.Utils.AES.decrypt(r5, r1, r2)     // Catch: java.lang.Exception -> L2b
                        goto L31
                    L2b:
                        java.lang.Object r5 = r6.body()
                        java.lang.String r5 = (java.lang.String) r5
                    L31:
                        if (r5 == 0) goto L56
                        boolean r6 = r5.isEmpty()     // Catch: org.json.JSONException -> L82
                        if (r6 != 0) goto L56
                        org.json.JSONObject r6 = new org.json.JSONObject     // Catch: org.json.JSONException -> L82
                        r6.<init>(r5)     // Catch: org.json.JSONException -> L82
                        java.lang.String r5 = "time"
                        java.lang.String r5 = r6.optString(r5)     // Catch: org.json.JSONException -> L82
                        long r0 = java.lang.Long.parseLong(r5)     // Catch: org.json.JSONException -> L82
                        r2 = 1000(0x3e8, double:4.94E-321)
                        long r0 = r0 * r2
                        com.appnew.android.Utils.MakeMyExam.setTime_server(r0)     // Catch: org.json.JSONException -> L82
                        com.appnew.android.Utils.CustomViewHolder r5 = com.appnew.android.Utils.CustomViewHolder.this     // Catch: org.json.JSONException -> L82
                        java.lang.String r0 = r3     // Catch: org.json.JSONException -> L82
                        r5.SuccessCallBack(r6, r0)     // Catch: org.json.JSONException -> L82
                        goto L86
                    L56:
                        com.appnew.android.Utils.CustomViewHolder r5 = com.appnew.android.Utils.CustomViewHolder.this     // Catch: org.json.JSONException -> L82
                        android.app.Activity r5 = r5.activity     // Catch: org.json.JSONException -> L82
                        com.appnew.android.Utils.CustomViewHolder r6 = com.appnew.android.Utils.CustomViewHolder.this     // Catch: org.json.JSONException -> L82
                        android.app.Activity r6 = r6.activity     // Catch: org.json.JSONException -> L82
                        android.content.res.Resources r6 = r6.getResources()     // Catch: org.json.JSONException -> L82
                        r1 = 2132018016(0x7f140360, float:1.9674327E38)
                        java.lang.String r6 = r6.getString(r1)     // Catch: org.json.JSONException -> L82
                        android.widget.Toast r5 = android.widget.Toast.makeText(r5, r6, r0)     // Catch: org.json.JSONException -> L82
                        r5.show()     // Catch: org.json.JSONException -> L82
                        com.appnew.android.Utils.CustomViewHolder r5 = com.appnew.android.Utils.CustomViewHolder.this     // Catch: org.json.JSONException -> L82
                        android.app.Activity r6 = r5.activity     // Catch: org.json.JSONException -> L82
                        android.content.res.Resources r6 = r6.getResources()     // Catch: org.json.JSONException -> L82
                        java.lang.String r6 = r6.getString(r1)     // Catch: org.json.JSONException -> L82
                        java.lang.String r0 = r3     // Catch: org.json.JSONException -> L82
                        r5.ErrorCallBack(r6, r0)     // Catch: org.json.JSONException -> L82
                        goto L86
                    L82:
                        r5 = move-exception
                        r5.printStackTrace()
                    L86:
                        return
                    L87:
                        com.appnew.android.Utils.CustomViewHolder r5 = com.appnew.android.Utils.CustomViewHolder.this
                        android.app.Activity r5 = r5.activity
                        com.appnew.android.Utils.CustomViewHolder r6 = com.appnew.android.Utils.CustomViewHolder.this
                        android.app.Activity r6 = r6.activity
                        android.content.res.Resources r6 = r6.getResources()
                        r1 = 2132017765(0x7f140265, float:1.9673818E38)
                        java.lang.String r6 = r6.getString(r1)
                        android.widget.Toast r5 = android.widget.Toast.makeText(r5, r6, r0)
                        r5.show()
                        com.appnew.android.Utils.CustomViewHolder r5 = com.appnew.android.Utils.CustomViewHolder.this
                        android.app.Activity r6 = r5.activity
                        android.content.res.Resources r6 = r6.getResources()
                        java.lang.String r6 = r6.getString(r1)
                        java.lang.String r0 = r3
                        r5.ErrorCallBack(r6, r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Utils.CustomViewHolder.AnonymousClass1.onResponse(retrofit2.Call, retrofit2.Response):void");
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<String> call, Throwable t) {
                    if (showprogress) {
                        CustomViewHolder.this.mprogress.dismiss();
                    }
                    Toast.makeText(CustomViewHolder.this.activity, CustomViewHolder.this.activity.getResources().getString(R.string.jsonparsing_error_message), 0).show();
                    CustomViewHolder customViewHolder = CustomViewHolder.this;
                    customViewHolder.ErrorCallBack(customViewHolder.activity.getResources().getString(R.string.exception_api_error_message), apiType);
                }
            });
        } else {
            Activity activity = this.activity;
            if (activity == null || activity.isDestroyed()) {
                return;
            }
            ErrorCallBack(this.activity.getResources().getString(R.string.internet_error_message), apiType);
        }
    }

    public void onSessionExpired() {
        Helper.SignOutUser(this.activity);
    }
}
