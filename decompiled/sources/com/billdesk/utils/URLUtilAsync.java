package com.billdesk.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.clevertap.android.sdk.Constants;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class URLUtilAsync extends AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Context f550g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HashMap<String, String> f551h;

    public URLUtilAsync(Context context, HashMap<String, String> map, String str) {
        this.f544a = URLUtilAsync.class.getName();
        this.f549f = false;
        this.f550g = context;
        this.f551h = map;
        this.f545b = str;
        execute(new Object[0]);
    }

    public URLUtilAsync(ImageView imageView, String str, Context context) {
        this.f544a = URLUtilAsync.class.getName();
        this.f551h = null;
        this.f547d = imageView;
        this.f549f = true;
        this.f545b = str;
        this.f550g = context;
        execute(new Object[0]);
    }

    public final String a() {
        StringBuilder sbAppend;
        String str = "Billdesk connectToUrlAndGetResponse called [" + this.f545b + Constants.AES_SUFFIX;
        String string = "";
        if (this.f549f) {
            try {
                this.f548e = BitmapFactory.decodeStream(new URL(this.f545b).openConnection().getInputStream());
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else {
            new URL(this.f545b);
            try {
                HttpURLConnection httpURLConnectionA = ConnectionUtil.a(this.f550g, this.f545b);
                httpURLConnectionA.setRequestMethod(HttpPost.METHOD_NAME);
                httpURLConnectionA.setConnectTimeout(15000);
                httpURLConnectionA.setReadTimeout(48000);
                httpURLConnectionA.setDoInput(true);
                httpURLConnectionA.setDoOutput(true);
                String str2 = "";
                for (String str3 : this.f551h.keySet()) {
                    str2 = str2 + str3 + "=" + this.f551h.get(str3) + "&";
                }
                String str4 = "Final url : " + str2;
                if (str2.length() > 0) {
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnectionA.getOutputStream());
                    dataOutputStream.writeBytes(str2.substring(0, str2.length() - 1));
                    dataOutputStream.flush();
                    dataOutputStream.close();
                }
                if (httpURLConnectionA.getResponseCode() == 200) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnectionA.getInputStream()));
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        stringBuffer.append(line);
                    }
                    bufferedReader.close();
                    string = stringBuffer.toString();
                    sbAppend = new StringBuilder().append("Response recvd [").append(stringBuffer.toString()).append(Constants.AES_SUFFIX);
                } else {
                    sbAppend = new StringBuilder().append(httpURLConnectionA.getResponseCode()).append("");
                }
                sbAppend.toString();
                return string;
            } catch (Exception e3) {
                ConnectionUtil.a(this.f550g, this.f545b, e3);
            }
        }
        return string;
    }

    public String b() {
        try {
            this.f546c = a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this.f546c;
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        return b();
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        if (this.f549f) {
            this.f547d.setImageBitmap(this.f548e);
            PaymentLibConstants.p.put(this.f545b, this.f548e);
        }
        super.onPostExecute(obj);
    }
}
