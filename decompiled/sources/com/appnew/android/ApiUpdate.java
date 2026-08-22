package com.appnew.android;

import android.app.Activity;
import android.os.Bundle;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.google.gson.Gson;
import me.leolin.shortcutbadger.ShortcutBadger;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class ApiUpdate implements NetworkCall.MyNetworkCallBack {
    Activity activity;
    Bundle bundle;
    private final NetworkCall networkCall;
    private String notificationId;

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public ApiUpdate(Activity activity) {
        this.activity = activity;
        this.networkCall = new NetworkCall(this, activity);
    }

    public void callApi(String apiType, String typeApi, boolean showProgress, String NotificationID, Bundle b2) {
        this.notificationId = NotificationID;
        this.bundle = b2;
        this.networkCall.NetworkAPICall(apiType, typeApi, false, showProgress);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setId("");
        if (this.bundle.getString(Const.NOTIFICATION_CODE) != null && this.bundle.getString(Const.NOTIFICATION_CODE).equalsIgnoreCase("20009")) {
            encryptionData.setNotification_code(this.bundle.getString(Const.NOTIFICATION_CODE));
            encryptionData.setNotification_id(this.bundle.getString(Const.NOTIFICATION_ID));
            encryptionData.setTitle(this.bundle.getString("title"));
            encryptionData.setMessage(this.bundle.getString("message"));
            encryptionData.setVideo_id(this.bundle.getString(Const.VIDEO_ID));
        } else {
            encryptionData.setNotification_id(this.notificationId);
        }
        return service.setread(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        try {
            if (!jsonstring.getString("status").equalsIgnoreCase("true")) {
                RetrofitResponse.GetApiData(this.activity, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
            } else {
                SharedPreference.getInstance().putInt(Const.NOTIFICATION_COUNT, SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT) - 1);
                ShortcutBadger.applyCount(this.activity, SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
