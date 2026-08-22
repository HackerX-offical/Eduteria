package com.pallycon.exoplayersample.simple.network;

import cz.msebera.android.httpclient.client.methods.HttpPost;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public class HttpRequestHelper {
    private String TAG = "HttpRequestHelper.class";

    public InputStream postRequest(String str, ArrayList<String[]> arrayList, String str2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            for (String[] strArr : arrayList) {
                httpURLConnection.setRequestProperty(strArr[0], strArr[1]);
            }
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
            httpURLConnection.setDoInput(true);
            httpURLConnection.getOutputStream().write(str2.getBytes());
            return httpURLConnection.getInputStream();
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
