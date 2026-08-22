package com.appnew.android.Utils.Service;

import android.util.Log;
import android.widget.Toast;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.retrofit.WebInterface;
import com.appnew.android.Utils.Progress;
import com.eduteria.app.app.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes6.dex */
public class MyFirebaseInstanceIDService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMessagingService";

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String token) {
        super.onNewToken(token);
        Log.d("TAG_Token", "Refreshed token: " + token);
        sendRegistrationToServer(token);
    }

    private void sendRegistrationToServer(final String token) {
        if (Helper.isNetworkConnected(this)) {
            final Progress progress = new Progress(this);
            progress.show();
            ((WebInterface) MakeMyExam.getRetrofitInstance().create(WebInterface.class)).API_UPDATE_DEVICE_TOKEN("1", token).enqueue(new Callback<JsonObject>() { // from class: com.appnew.android.Utils.Service.MyFirebaseInstanceIDService.1
                @Override // retrofit2.Callback
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    progress.dismiss();
                    new Gson();
                    if (response.body() != null) {
                        try {
                            new JSONObject(response.body().toString()).optString("status").equals("true");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<JsonObject> call, Throwable t) {
                    Toast.makeText(MyFirebaseInstanceIDService.this, t.getMessage(), 0).show();
                }
            });
            return;
        }
        Toast.makeText(this, R.string.Retry_with_Internet_connection, 1).show();
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
    }
}
