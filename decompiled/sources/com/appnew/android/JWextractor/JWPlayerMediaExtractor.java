package com.appnew.android.JWextractor;

import android.os.AsyncTask;
import com.canhub.cropper.CropImageOptionsKt;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class JWPlayerMediaExtractor extends AsyncTask<String, Void, String> {
    String errorMessage;
    JWPlayerExtractorCallBack jwPlayerExtractorCallBack;
    int responseCode;

    public JWPlayerMediaExtractor(JWPlayerExtractorCallBack jwPlayerExtractorCallBack) {
        this.jwPlayerExtractorCallBack = jwPlayerExtractorCallBack;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public String doInBackground(String... urls) {
        HttpResponse httpResponseExecute;
        try {
            httpResponseExecute = new DefaultHttpClient().execute(new HttpGet(urls[0]));
        } catch (IOException e2) {
            this.errorMessage = e2.getMessage();
            httpResponseExecute = null;
        }
        int statusCode = httpResponseExecute != null ? httpResponseExecute.getStatusLine().getStatusCode() : 0;
        this.responseCode = statusCode;
        if (statusCode == 200) {
            try {
                return EntityUtils.toString(httpResponseExecute.getEntity());
            } catch (IOException e3) {
                this.errorMessage = e3.getMessage();
                return "errorMessage: " + e3.getMessage();
            }
        }
        return "errorCode: " + this.responseCode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(String result) {
        super.onPostExecute(result);
        try {
            JSONObject jSONObject = new JSONObject(result);
            if (jSONObject.toString().isEmpty()) {
                return;
            }
            if (jSONObject.optString("errorCode").isEmpty() && jSONObject.optString("errorMessage").isEmpty()) {
                boolean z = false;
                JSONArray jSONArray = new JSONArray(new JSONObject(new JSONArray(jSONObject.optString("playlist")).optString(0)).optString("sources"));
                HashMap<Integer, String> map = new HashMap<>();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = new JSONObject(jSONArray.optString(i));
                    if (jSONObject2.optString("file").contains(".m3u8") || jSONObject2.optString("type").contains(".apple")) {
                        map.put(-1, jSONObject2.optString("file"));
                    } else if (jSONObject2.optString("label").equalsIgnoreCase("180p")) {
                        map.put(180, jSONObject2.optString("file"));
                    } else if (jSONObject2.optString("label").equalsIgnoreCase("270p")) {
                        map.put(270, jSONObject2.optString("file"));
                    } else if (jSONObject2.optString("label").equalsIgnoreCase("360p")) {
                        map.put(Integer.valueOf(CropImageOptionsKt.DEGREES_360), jSONObject2.optString("file"));
                    } else if (jSONObject2.optString("label").equalsIgnoreCase("540p")) {
                        map.put(540, jSONObject2.optString("file"));
                    } else if (jSONObject2.optString("label").equalsIgnoreCase("720p")) {
                        map.put(720, jSONObject2.optString("file"));
                    } else if (jSONObject2.optString("label").equalsIgnoreCase("AAC Audio")) {
                        map.put(0, jSONObject2.optString("file"));
                    }
                }
                if (map.keySet().size() == 1 && map.containsKey(-1) && map.get(-1) != null && map.get(-1).contains(".m3u8")) {
                    z = true;
                }
                this.jwPlayerExtractorCallBack.onExtractorSuccess(this.responseCode, map, z);
                return;
            }
            this.jwPlayerExtractorCallBack.onExtractorError(this.responseCode, this.errorMessage);
        } catch (JSONException e2) {
            this.jwPlayerExtractorCallBack.onExtractorError(this.responseCode, e2.getMessage());
        }
    }
}
