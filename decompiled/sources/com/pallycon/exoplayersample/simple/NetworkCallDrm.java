package com.pallycon.exoplayersample.simple;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;
import androidx.media3.common.C;
import com.appnew.android.Utils.Const;
import com.pallycon.exoplayersample.simple.network.AES;
import com.pallycon.exoplayersample.simple.network.NetworkUtils;
import com.pallycon.widevine.exception.PallyConException;
import com.pallycon.widevine.exception.PallyConLicenseServerException;
import com.pallycon.widevine.model.ContentData;
import com.pallycon.widevine.model.PallyConDrmConfigration;
import com.pallycon.widevine.model.PallyConEventListener;
import com.pallycon.widevine.sdk.PallyConWvSDK;
import java.io.IOException;
import java.util.UUID;
import okhttp3.ResponseBody;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes9.dex */
public class NetworkCallDrm {
    private static final String TAG = "NetworkCallImpl";
    private Context context;
    InitializePlayerService initializePlayerService;
    String url;
    private String version;
    PallyConWvSDK WVMAgent = null;
    private String deviceName = Build.MODEL;

    public NetworkCallDrm(Context context, InitializePlayerService initializePlayerService, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.context = context;
        this.initializePlayerService = initializePlayerService;
        this.version = String.valueOf(getVersionCode(context));
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        createVideoLink(str, str2, str3, str4, str5, str6, str7, str8);
    }

    public void getVideoList() {
        NetworkUtils.getClient().getVideoList("2").enqueue(new Callback<ResponseBody>() { // from class: com.pallycon.exoplayersample.simple.NetworkCallDrm.1
            @Override // retrofit2.Callback
            public void onFailure(Call<ResponseBody> call, Throwable th) {
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null) {
                    JSONObject jSONObject = null;
                    try {
                        try {
                            try {
                                jSONObject = new JSONObject(AES.decrypt(response.body().string(), AES.generatekey("1234_1012_4321576824136875"), AES.generateVector("1234_1012_4321576824136875")));
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return;
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    ((JSONObject) ((JSONArray) ((JSONObject) jSONObject.get("data")).get(Const.VIDEO_LIST)).get(0)).getString("token");
                }
            }
        });
    }

    private void createVideoLink(String str, String str2, String str3, String str4, String str5, String str6, final String str7, final String str8) {
        NetworkUtils.getClient().createVideoLink(str3, str4, this.version, this.deviceName, str2, str5, str6, str, "1").enqueue(new Callback<ResponseBody>() { // from class: com.pallycon.exoplayersample.simple.NetworkCallDrm.2
            @Override // retrofit2.Callback
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    JSONObject jSONObject = new JSONObject(response.body().string()).getJSONObject("data").getJSONObject("link");
                    NetworkCallDrm.this.url = jSONObject.getString("file_url");
                    String string = jSONObject.getString("token");
                    if (NetworkCallDrm.this.url.endsWith("index.mpd")) {
                        String str9 = "";
                        String[] strArrSplit = NetworkCallDrm.this.url.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                        for (int i = 0; i < strArrSplit.length; i++) {
                            if (i != strArrSplit.length - 1) {
                                if (i == 0) {
                                    str9 = str9 + strArrSplit[i] + "//";
                                }
                                str9 = str9 + strArrSplit[i] + MqttTopic.TOPIC_LEVEL_SEPARATOR;
                            } else {
                                str9 = str9 + "start/" + str7 + MqttTopic.TOPIC_LEVEL_SEPARATOR + strArrSplit[strArrSplit.length - 1];
                            }
                        }
                        new PlayerHelper(str9.substring(8), "", NetworkCallDrm.this.context, string, NetworkCallDrm.this.initializePlayerService, str8);
                        return;
                    }
                    if (!NetworkCallDrm.this.url.endsWith("Dash.mpd") && !NetworkCallDrm.this.url.endsWith("VOD.mpd")) {
                        new PlayerHelper(NetworkCallDrm.this.url, "", NetworkCallDrm.this.context, string, NetworkCallDrm.this.initializePlayerService, str8);
                        return;
                    }
                    new PlayerHelper(NetworkCallDrm.this.url, "", NetworkCallDrm.this.context, string, NetworkCallDrm.this.initializePlayerService, str8);
                } catch (IOException | JSONException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<ResponseBody> call, Throwable th) {
                Log.e("DRM url ERROR", th.getLocalizedMessage());
            }
        });
    }

    public static class PlayerHelper {
        private static final String TAG = "PlayerHelper";
        PallyConWvSDK WVMAgent;
        private String actualtoken;
        private String drmLicenseUrl;
        PallyConEventListener drmListener = new PallyConEventListener() { // from class: com.pallycon.exoplayersample.simple.NetworkCallDrm.PlayerHelper.1
            @Override // com.pallycon.widevine.model.PallyConEventListener
            public void onCompleted(ContentData contentData) {
            }

            @Override // com.pallycon.widevine.model.PallyConEventListener
            public void onPaused(ContentData contentData) {
            }

            @Override // com.pallycon.widevine.model.PallyConEventListener
            public void onProgress(ContentData contentData, float f2, long j) {
            }

            @Override // com.pallycon.widevine.model.PallyConEventListener
            public void onRemoved(ContentData contentData) {
            }

            @Override // com.pallycon.widevine.model.PallyConEventListener
            public void onRestarting(ContentData contentData) {
            }

            @Override // com.pallycon.widevine.model.PallyConEventListener
            public void onStopped(ContentData contentData) {
            }

            @Override // com.pallycon.widevine.model.PallyConEventListener
            public void onFailed(ContentData contentData, PallyConLicenseServerException pallyConLicenseServerException) {
                Toast.makeText((Context) PlayerHelper.this.initializePlayerService, String.format("%d, %s", Integer.valueOf(pallyConLicenseServerException.getErrorCode()), pallyConLicenseServerException.getBody()), 1).show();
            }

            @Override // com.pallycon.widevine.model.PallyConEventListener
            public void onFailed(ContentData contentData, PallyConException pallyConException) {
                Toast.makeText((Context) PlayerHelper.this.initializePlayerService, pallyConException.getMsg(), 1).show();
            }
        };
        InitializePlayerService initializePlayerService;
        private Context mActivity;
        private String token;
        private String url;

        public PlayerHelper(String str, String str2, Context context, String str3, InitializePlayerService initializePlayerService, String str4) {
            this.url = "";
            this.token = "";
            this.actualtoken = "";
            this.drmLicenseUrl = "";
            this.url = str;
            this.token = str2;
            this.actualtoken = str3;
            this.drmLicenseUrl = str4;
            this.mActivity = context;
            this.initializePlayerService = initializePlayerService;
            initializePlayer();
        }

        private Context getContext() {
            return this.mActivity;
        }

        private void initializePlayer() {
            try {
                PallyConWvSDK pallyConWvSDKCreatePallyConWvSDK = PallyConWvSDK.INSTANCE.createPallyConWvSDK(this.mActivity, new ContentData(this.url, new PallyConDrmConfigration("", "", this.actualtoken, null, null, null, null, this.drmLicenseUrl, UUID.fromString(C.WIDEVINE_UUID.toString()))));
                this.WVMAgent = pallyConWvSDKCreatePallyConWvSDK;
                pallyConWvSDKCreatePallyConWvSDK.setPallyConEventListener(this.drmListener);
                try {
                    this.initializePlayerService.initializePlayer(this.WVMAgent.getMediaSource(), this.url, this.actualtoken);
                } catch (PallyConException.ContentDataException e2) {
                    e2.printStackTrace();
                } catch (PallyConException.DetectedDeviceTimeModifiedException e3) {
                    e3.printStackTrace();
                }
            } catch (Exception e4) {
                if (e4 instanceof NoSuchMethodException) {
                    Toast.makeText(this.mActivity, "asasd", 0).show();
                }
                e4.printStackTrace();
            }
        }
    }

    public String getUrl() {
        return this.url;
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
