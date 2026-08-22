package easypay.appinvoke.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.compose.runtime.ComposeVersion;
import androidx.core.app.JobIntentService;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import easypay.appinvoke.manager.Constants;
import easypay.appinvoke.manager.PaytmAssist;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class EasyPayConfigDownloader extends JobIntentService {
    private static final int JOB_ID = 2321;
    private JsonDownloadListener mJsonDownloadListener;
    private String requestBankDetailJson;
    private SharedPreferences sharedPref;
    SharedPreferences sharedPrefETag;

    public interface JsonDownloadListener {
        void OnJsonDownLoadFailure(String str);

        void OnJsonDownLoadSuccess(String str);
    }

    public EasyPayConfigDownloader() {
    }

    public EasyPayConfigDownloader(JsonDownloadListener jsonDownloadListener, Context context, Intent intent) {
        setJsonDownloadListener(jsonDownloadListener);
        enqueueWork(context, intent);
    }

    public static void enqueueWork(Context context, Intent intent) {
        enqueueWork(context, (Class<?>) EasyPayConfigDownloader.class, JOB_ID, intent);
    }

    public void setJsonDownloadListener(JsonDownloadListener jsonDownloadListener) {
        this.mJsonDownloadListener = jsonDownloadListener;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // androidx.core.app.JobIntentService
    protected void onHandleWork(Intent intent) {
        this.sharedPref = getSharedPreferences(Constants.EASYPAY_NEW_PREFERENCE_FILE, 0);
        this.sharedPrefETag = getSharedPreferences(Constants.EASY_PAY_ETAG_PREF, 0);
        this.requestBankDetailJson = intent.getStringExtra(Constants.EXTRA_BANK_REQ_JSON);
        downloadConfigFile();
    }

    public void downloadConfigFile() {
        try {
            if (System.currentTimeMillis() - this.sharedPref.getLong("easypay_configuration_load_timestamp", 0L) > this.sharedPref.getLong("easypay_configuration_ttl", 0L)) {
                String configUrlToHit = PaytmAssist.getAssistInstance().getConfigUrlToHit();
                AssistLogs.printLog("EasyPay Config requestURL:" + configUrlToHit, this);
                if (TextUtils.isEmpty(configUrlToHit) || !downloadFilew(configUrlToHit)) {
                    return;
                }
                SharedPreferences.Editor editorEdit = this.sharedPref.edit();
                editorEdit.putLong("easypay_configuration_load_timestamp", System.currentTimeMillis());
                editorEdit.apply();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    public boolean downloadFilew(String str) {
        try {
            URL url = new URL(str);
            AssistLogs.printLog("url:" + url.toString(), this);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setConnectTimeout(ComposeVersion.version);
            httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
            JSONObject jSONObject = new JSONObject(this.requestBankDetailJson);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("bankName", jSONObject.getString(Constants.EXTRA_BANK_CODE));
            jSONObject2.put("payMode", jSONObject.getString(Constants.EXTRA_BANK_PAYTYPE));
            if (jSONObject.getString(Constants.EXTRA_BANK_PAYTYPE).equals(Constants.EASYPAY_PAYTYPE_NETBANKING)) {
                jSONObject2.put(Constants.EXTRA_BANK_SCHEME, (Object) null);
            } else {
                jSONObject2.put(Constants.EXTRA_BANK_SCHEME, jSONObject.getString(Constants.EXTRA_BANK_SCHEME));
            }
            jSONObject2.put("orderId", PaytmAssist.getAssistInstance().getOrderId());
            jSONObject2.put("mid", PaytmAssist.getAssistInstance().getMid());
            jSONObject2.put("deviceType", "ANDROID");
            AssistLogs.printLog("resquestBody:" + jSONObject2.toString(), this);
            String savedEtag = EasyPayUtils.getSavedEtag(this, jSONObject.getString(Constants.EXTRA_BANK_CODE), jSONObject.getString(Constants.EXTRA_BANK_PAYTYPE), jSONObject.getString(Constants.EXTRA_BANK_SCHEME));
            if (savedEtag == null) {
                savedEtag = "";
            }
            httpURLConnection.setRequestProperty("If-None-Match", savedEtag);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(jSONObject2.toString().getBytes());
            outputStream.close();
            AssistLogs.printLog("EasyPay Config requestbody:" + jSONObject2.toString(), this);
            String headerField = httpURLConnection.getHeaderField("ETag");
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5120);
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedInputStream.close();
                    AssistLogs.printLog("unique Assist Config response" + sb.toString(), this);
                    EasyPayUtils.saveConfigWithEtag(this, sb.toString(), headerField);
                    Intent intent = new Intent();
                    intent.setAction(Constants.EASYPAY_ACTION_FILE_DOWNLOADED);
                    sendBroadcast(intent);
                    return true;
                }
                sb.append(line);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
