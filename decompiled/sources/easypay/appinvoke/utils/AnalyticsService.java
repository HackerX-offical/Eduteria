package easypay.appinvoke.utils;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.JobIntentService;
import com.clevertap.android.sdk.network.api.CtApi;
import com.google.gson.GsonBuilder;
import easypay.appinvoke.manager.Constants;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes9.dex */
public class AnalyticsService extends JobIntentService {
    private static int JOB_ID = 123;
    protected HashMap<String, Object> mEventMap;

    public static void enqueueWork(Context context, Intent intent) {
        enqueueWork(context, (Class<?>) AnalyticsService.class, JOB_ID, intent);
    }

    @Override // androidx.core.app.JobIntentService
    protected void onHandleWork(Intent intent) {
        if (intent != null) {
            try {
                this.mEventMap = (HashMap) intent.getSerializableExtra("data");
            } catch (Exception e2) {
                e2.printStackTrace();
                AssistLogs.printLog("EXCEPTION", e2);
            }
            if (this.mEventMap != null) {
                try {
                    MediaType mediaType = MediaType.parse(CtApi.DEFAULT_CONTENT_TYPE);
                    OkHttpClient okHttpClient = new OkHttpClient();
                    String json = new GsonBuilder().create().toJson(this.mEventMap);
                    AssistLogs.printLog("analytics log map-json:" + json, this);
                    Log.e("AssistAna", "analytics service :Map" + json);
                    if (okHttpClient.newCall(new Request.Builder().url(Constants.EventUrl).post(RequestBody.create(mediaType, json)).build()).execute().body() != null) {
                        stopSelf();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    AssistLogs.printLog("EXCEPTION", e3);
                }
            }
        }
    }

    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }
}
