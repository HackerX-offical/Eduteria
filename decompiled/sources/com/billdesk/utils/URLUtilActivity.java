package com.billdesk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.billdesk.sdk.BaseClass;
import com.billdesk.utils.ResultWrapper;
import com.clevertap.android.sdk.Constants;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.HashMap;
import org.joda.time.DateTimeConstants;

/* JADX INFO: loaded from: classes6.dex */
public class URLUtilActivity extends BaseClass implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap<String, String> f541c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f539a = URLUtilActivity.class.getName();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f542d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f543e = true;

    public final ResultWrapper b() {
        BufferedReader bufferedReader;
        ResultWrapper resultWrapper = new ResultWrapper();
        try {
            String str = "Billdesk in connectToUrlAndGetResponse url[" + this.f542d + "] req_type=" + this.f540b;
            if (!Helper.b(this)) {
                resultWrapper.f529a = ResultWrapper.RESULT.ERROR;
                resultWrapper.f532d = new BillDeskSDKException("No Internet connection.");
                return resultWrapper;
            }
            HttpURLConnection httpURLConnectionA = ConnectionUtil.a(getApplicationContext(), this.f542d);
            boolean z = true;
            if (this.f542d.contains("http://prelive.viraltech.in")) {
                String str2 = "url contains " + this.f542d;
            } else {
                httpURLConnectionA.setRequestMethod(HttpPost.METHOD_NAME);
                httpURLConnectionA.setDoOutput(true);
            }
            httpURLConnectionA.setConnectTimeout(DateTimeConstants.MILLIS_PER_MINUTE);
            httpURLConnectionA.setReadTimeout(DateTimeConstants.MILLIS_PER_MINUTE);
            httpURLConnectionA.setDoInput(true);
            int i = this.f540b;
            String str3 = "";
            if (i == 106) {
                String str4 = "Billdesk hitting [106 ]valMap[" + this.f541c.toString() + Constants.AES_SUFFIX;
                for (String str5 : this.f541c.keySet()) {
                    String str6 = "key : [" + str5 + "]value[" + this.f541c.get(str5) + Constants.AES_SUFFIX;
                    str3 = str3 + str5 + "=" + this.f541c.get(str5) + "&";
                    z = z;
                }
                if (str3.length() > 0) {
                    String str7 = "URL [" + this.f542d + "] Post data  : [" + str3.substring(0, str3.length() - 1) + Constants.AES_SUFFIX;
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnectionA.getOutputStream());
                    dataOutputStream.writeBytes(str3.substring(0, str3.length() - 1));
                    dataOutputStream.flush();
                    dataOutputStream.close();
                }
                String str8 = "connectToUrlAndGetResponse: code is [" + httpURLConnectionA.getResponseCode() + Constants.AES_SUFFIX;
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnectionA.getInputStream()));
            } else if (i == 108) {
                for (String str9 : this.f541c.keySet()) {
                    String str10 = "key : [" + str9 + "]value[" + this.f541c.get(str9) + Constants.AES_SUFFIX;
                    str3 = str3 + str9 + "=" + this.f541c.get(str9) + "&";
                }
                if (str3.length() > 0) {
                    DataOutputStream dataOutputStream2 = new DataOutputStream(httpURLConnectionA.getOutputStream());
                    dataOutputStream2.writeBytes(str3.substring(0, str3.length() - 1));
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                }
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnectionA.getInputStream()));
            } else {
                for (String str11 : this.f541c.keySet()) {
                    String str12 = "key : [" + str11 + "]value[" + this.f541c.get(str11) + Constants.AES_SUFFIX;
                    str3 = str3 + str11 + "=" + this.f541c.get(str11) + "&";
                }
                String str13 = "StrValues==" + str3;
                if (str3.length() > 0) {
                    String str14 = "URL [" + this.f542d + "] Post data  : [" + str3.substring(0, str3.length() - 1) + Constants.AES_SUFFIX;
                    DataOutputStream dataOutputStream3 = new DataOutputStream(httpURLConnectionA.getOutputStream());
                    dataOutputStream3.writeBytes(str3.substring(0, str3.length() - 1));
                    dataOutputStream3.flush();
                    dataOutputStream3.close();
                }
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnectionA.getInputStream()));
            }
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    String string = sb.toString();
                    resultWrapper.f529a = ResultWrapper.RESULT.SUCCESS;
                    resultWrapper.f531c = string;
                    resultWrapper.f530b = httpURLConnectionA.getResponseCode();
                    return resultWrapper;
                }
                sb = sb.append(line);
            }
        } catch (IOException e2) {
            ConnectionUtil.a(getApplicationContext(), this.f542d, e2);
            String str15 = "connectToUrlAndGetResponse: url " + this.f542d + "exception " + e2.getMessage();
            e2.printStackTrace();
            return resultWrapper;
        } catch (Exception e3) {
            resultWrapper.f529a = ResultWrapper.RESULT.ERROR;
            resultWrapper.f532d = e3;
            e3.printStackTrace();
            return resultWrapper;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent = new Intent();
        ResultWrapper resultWrapper = new ResultWrapper();
        resultWrapper.f529a = ResultWrapper.RESULT.CANCEL;
        intent.putExtra("data", resultWrapper);
        setResult(this.f540b, intent);
        super.onBackPressed();
    }

    @Override // com.billdesk.sdk.BaseClass, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(Helper.a(this, 17, 0, 0, new int[]{0, 0, 0, 0}));
        linearLayout.setOrientation(1);
        Bundle extras = getIntent().getExtras();
        if (extras.containsKey("isShowProgress")) {
            this.f543e = extras.getBoolean("isShowProgress");
            String str = "isShowProgress..........." + this.f543e;
        }
        this.f540b = extras.getInt("req_type");
        this.f542d = extras.getString("url");
        this.f541c = (HashMap) extras.getSerializable("paymentDetail");
        String str2 = "Value of payment Detail" + this.f541c;
        String str3 = "Billdesk Payment [" + this.f540b + "]url[" + this.f542d + Constants.AES_SUFFIX;
        new Thread(this).start();
        if (this.f543e) {
            linearLayout.addView(Helper.a("", (Activity) this));
        }
        linearLayout.addView(this.f543e ? Helper.a((Context) this) : new LinearLayout(this));
        setContentView(linearLayout);
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = "Billdesk Payment thread started[" + this.f540b + "]url[" + this.f542d + Constants.AES_SUFFIX;
        ResultWrapper resultWrapperB = b();
        String str2 = "Billdesk Payment thread ended response[" + resultWrapperB + Constants.AES_SUFFIX;
        Intent intent = new Intent();
        intent.putExtra("data", resultWrapperB);
        setResult(this.f540b, intent);
        finish();
    }
}
