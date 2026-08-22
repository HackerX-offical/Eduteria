package a.a.a.b;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import com.clevertap.android.sdk.Constants;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class d extends AsyncTask<Void, Void, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f125a = getClass().getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap<String, String> f127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f128d;

    public d(Context context, HashMap<String, String> map, String str) {
        this.f128d = context;
        this.f127c = map;
        this.f126b = str;
    }

    public final String a() {
        String str = this.f126b;
        new URL(this.f126b);
        StringBuilder sb = new StringBuilder();
        try {
            HttpURLConnection httpURLConnectionA = b.a(this.f128d, this.f126b);
            httpURLConnectionA.setRequestMethod(HttpPost.METHOD_NAME);
            httpURLConnectionA.setConnectTimeout(15000);
            httpURLConnectionA.setReadTimeout(20000);
            httpURLConnectionA.setDoInput(true);
            httpURLConnectionA.setDoOutput(true);
            String str2 = "Final url : " + str;
            HashMap<String, String> map = this.f127c;
            if (map != null) {
                String str3 = "";
                for (String str4 : map.keySet()) {
                    str3 = str3 + str4 + "=" + this.f127c.get(str4) + "&";
                }
                if (str3.length() > 0) {
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnectionA.getOutputStream());
                    dataOutputStream.writeBytes(str3.substring(0, str3.length() - 1));
                    dataOutputStream.flush();
                    dataOutputStream.close();
                }
            }
            if (httpURLConnectionA.getResponseCode() != 200) {
                String str5 = "Server error [" + httpURLConnectionA.getResponseCode() + Constants.AES_SUFFIX;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnectionA.getInputStream()));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb = sb.append(line);
            }
        } catch (Exception e2) {
            Context context = this.f128d;
            String str6 = "connection issue:" + this.f125a + ":" + this.f126b + " err msg:" + e2.getMessage();
            System.err.println(str6);
            new Handler(context.getMainLooper()).post(new a(context, str6));
        }
        String str7 = "Response recvd [" + sb.toString() + Constants.AES_SUFFIX;
        return sb.toString();
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void[] voidArr) {
        try {
            return a();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
