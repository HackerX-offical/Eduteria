package com.razorpay;

import android.os.AsyncTask;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes9.dex */
public class Owl extends AsyncTask<String, Void, ResponseObject> {
    private Callback cb;
    private String method = null;
    private Map<String, String> headers = new HashMap();
    private String data = null;

    private Owl(Callback callback) {
        this.cb = callback;
    }

    static AsyncTask get(String str, Callback callback) {
        return new Owl(callback).method("GET").execute(str);
    }

    static AsyncTask get(String str, Map<String, String> map, Callback callback) {
        return new Owl(callback).method("GET").headers(map).execute(str);
    }

    static AsyncTask get(String str, String str2, Map<String, String> map, Callback callback) {
        return new Owl(callback).method("GET").data(str2).headers(map).execute(str);
    }

    public static AsyncTask post(String str, String str2, Callback callback) {
        return new Owl(callback).method(HttpPost.METHOD_NAME).data(str2).execute(str);
    }

    public static AsyncTask post(String str, String str2, Map<String, String> map, Callback callback) {
        return new Owl(callback).method(HttpPost.METHOD_NAME).data(str2).headers(map).execute(str);
    }

    Owl headers(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    Owl method(String str) {
        this.method = str;
        return this;
    }

    Owl data(String str) {
        this.data = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public ResponseObject doInBackground(String... strArr) {
        InputStream inputStream;
        ResponseObject responseObject = new ResponseObject();
        InputStream inputStream2 = null;
        try {
            try {
                try {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(strArr[0]).openConnection();
                    for (Map.Entry<String, String> entry : this.headers.entrySet()) {
                        httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                    httpsURLConnection.setRequestMethod(this.method);
                    if (this.data != null) {
                        httpsURLConnection.setDoOutput(true);
                        httpsURLConnection.getOutputStream().write(this.data.getBytes(StandardCharsets.UTF_8));
                    }
                    httpsURLConnection.setConnectTimeout(15000);
                    httpsURLConnection.setReadTimeout(20000);
                    httpsURLConnection.connect();
                    int responseCode = httpsURLConnection.getResponseCode();
                    responseObject.setResponseCode(responseCode);
                    Map<String, String> map = this.headers;
                    if (map == null || !map.containsKey("accept-encoding") || this.headers.get("accept-encoding") == null || !this.headers.get("accept-encoding").equalsIgnoreCase("gzip")) {
                        if (responseCode >= 400) {
                            inputStream = httpsURLConnection.getErrorStream();
                        } else {
                            inputStream = httpsURLConnection.getInputStream();
                        }
                    } else if (responseCode > 400) {
                        inputStream = httpsURLConnection.getErrorStream();
                    } else {
                        inputStream = new GZIPInputStream(httpsURLConnection.getInputStream());
                    }
                    inputStream2 = inputStream;
                    responseObject.setHeaders(httpsURLConnection.getHeaderFields());
                    responseObject.setResponseResult(readIt(inputStream2));
                    if (inputStream2 != null) {
                        inputStream2.close();
                        return responseObject;
                    }
                } catch (Exception e2) {
                    AnalyticsUtil.reportError(getClass().getName(), "S2", e2.getMessage());
                }
            } catch (Exception e3) {
                e3.getLocalizedMessage();
                AnalyticsUtil.reportError(getClass().getName(), "S2", e3.getMessage());
                if (inputStream2 != null) {
                    inputStream2.close();
                }
            }
            return responseObject;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream2.close();
                } catch (Exception e4) {
                    AnalyticsUtil.reportError(getClass().getName(), "S2", e4.getMessage());
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(ResponseObject responseObject) {
        Callback callback = this.cb;
        if (callback != null) {
            callback.run(responseObject);
        }
    }

    private String readIt(InputStream inputStream) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                sb.append(line);
            } else {
                bufferedReader.close();
                return sb.toString();
            }
        }
    }
}
