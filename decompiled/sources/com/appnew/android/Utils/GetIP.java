package com.appnew.android.Utils;

import android.app.Activity;
import android.os.AsyncTask;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class GetIP extends AsyncTask<Void, Void, Void> {
    Activity activity;
    private String ip = "N/A";
    Progress progress;

    public GetIP(Activity activity) {
        this.activity = activity;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.ip = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Void doInBackground(Void... voids) {
        try {
            InputStream inputStream = new URL("https://api.ipify.org/?format=json").openConnection().getInputStream();
            String str = "";
            while (true) {
                int i = inputStream.read();
                if (i != -1) {
                    str = str + ((char) i);
                } else {
                    this.ip = new JSONObject(str).getString("ip");
                    return null;
                }
            }
        } catch (MalformedURLException unused) {
            this.ip = "N/A";
            return null;
        } catch (IOException unused2) {
            this.ip = "N/A";
            return null;
        } catch (JSONException unused3) {
            this.ip = "N/A";
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        SharedPreference.getInstance().putString("ip", "" + this.ip);
    }
}
