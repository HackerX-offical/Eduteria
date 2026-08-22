package com.paytm.pgsdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import datamodels.PWEStaticDataModel;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class PaytmUtility {
    private static final String AMPERSAND = "&";
    private static final String EQUAL_TO = "=";
    private static final String TAG = "PGSDK";
    private static final String UTF_8 = "UTF-8";

    protected static synchronized Bundle getBundleFromString(String str) {
        Bundle bundle;
        bundle = new Bundle();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() > 0) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String string = jSONObject.getString(next);
                    debugLog(next + " = " + string);
                    bundle.putString(next, string);
                }
            }
        } catch (Exception e2) {
            AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, e2.getMessage());
            debugLog("Error while parsing the Merchant Response");
            printStackTrace(e2);
        }
        return bundle;
    }

    protected static synchronized String getStringFromBundle(Bundle bundle) {
        StringBuffer stringBuffer;
        try {
            debugLog("Extracting Strings from Bundle...");
            stringBuffer = new StringBuffer();
            boolean z = true;
            for (String str : bundle.keySet()) {
                if (z) {
                    z = false;
                } else {
                    stringBuffer.append(AMPERSAND);
                }
                stringBuffer.append(str);
                stringBuffer.append(EQUAL_TO);
                stringBuffer.append(bundle.getString(str));
            }
            debugLog("Extracted String is " + stringBuffer.toString());
        } catch (Exception e2) {
            printStackTrace(e2);
            return null;
        }
        return stringBuffer.toString();
    }

    protected static synchronized String getURLEncodedStringFromBundle(Bundle bundle) {
        StringBuffer stringBuffer;
        try {
            debugLog("Extracting Strings from Bundle...");
            stringBuffer = new StringBuffer();
            boolean z = true;
            for (String str : bundle.keySet()) {
                if (z) {
                    z = false;
                } else {
                    stringBuffer.append(AMPERSAND);
                }
                stringBuffer.append(URLEncoder.encode(str, "UTF-8"));
                stringBuffer.append(EQUAL_TO);
                stringBuffer.append(URLEncoder.encode(bundle.getString(str), "UTF-8"));
            }
            debugLog("URL encoded String is " + stringBuffer.toString());
        } catch (Exception e2) {
            printStackTrace(e2);
            return null;
        }
        return stringBuffer.toString();
    }

    public static synchronized void debugLog(String str) {
        Log.d(TAG, str);
    }

    protected static synchronized void printStackTrace(Exception exc) {
        exc.printStackTrace();
    }

    protected static synchronized boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected static java.lang.String getJSONString(android.os.Bundle r5) {
        /*
            r0 = 0
            if (r5 == 0) goto L2a
            int r1 = r5.size()     // Catch: java.lang.Exception -> L46
            if (r1 <= 0) goto L2a
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L46
            r1.<init>()     // Catch: java.lang.Exception -> L46
            java.util.Set r2 = r5.keySet()     // Catch: java.lang.Exception -> L46
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Exception -> L46
        L16:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Exception -> L46
            if (r3 == 0) goto L2b
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Exception -> L46
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Exception -> L46
            java.lang.Object r4 = r5.get(r3)     // Catch: java.lang.Exception -> L46
            r1.put(r3, r4)     // Catch: java.lang.Exception -> L46
            goto L16
        L2a:
            r1 = r0
        L2b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L46
            r5.<init>()     // Catch: java.lang.Exception -> L46
            java.lang.String r2 = "JSON string is "
            java.lang.StringBuilder r5 = r5.append(r2)     // Catch: java.lang.Exception -> L46
            java.lang.StringBuilder r5 = r5.append(r1)     // Catch: java.lang.Exception -> L46
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L46
            debugLog(r5)     // Catch: java.lang.Exception -> L46
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Exception -> L46
            return r5
        L46:
            r5 = move-exception
            printStackTrace(r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.pgsdk.PaytmUtility.getJSONString(android.os.Bundle):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected static java.lang.String getURLEncodedJSONString(android.os.Bundle r6) {
        /*
            java.lang.String r0 = "UTF-8"
            r1 = 0
            if (r6 == 0) goto L34
            int r2 = r6.size()     // Catch: java.lang.Exception -> L50
            if (r2 <= 0) goto L34
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> L50
            r2.<init>()     // Catch: java.lang.Exception -> L50
            java.util.Set r3 = r6.keySet()     // Catch: java.lang.Exception -> L50
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Exception -> L50
        L18:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Exception -> L50
            if (r4 == 0) goto L35
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Exception -> L50
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> L50
            java.lang.String r5 = java.net.URLEncoder.encode(r4, r0)     // Catch: java.lang.Exception -> L50
            java.lang.String r4 = r6.getString(r4)     // Catch: java.lang.Exception -> L50
            java.lang.String r4 = java.net.URLEncoder.encode(r4, r0)     // Catch: java.lang.Exception -> L50
            r2.put(r5, r4)     // Catch: java.lang.Exception -> L50
            goto L18
        L34:
            r2 = r1
        L35:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L50
            r6.<init>()     // Catch: java.lang.Exception -> L50
            java.lang.String r0 = "URL encoded JSON string is "
            java.lang.StringBuilder r6 = r6.append(r0)     // Catch: java.lang.Exception -> L50
            java.lang.StringBuilder r6 = r6.append(r2)     // Catch: java.lang.Exception -> L50
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L50
            debugLog(r6)     // Catch: java.lang.Exception -> L50
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Exception -> L50
            return r6
        L50:
            r6 = move-exception
            printStackTrace(r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.pgsdk.PaytmUtility.getURLEncodedJSONString(android.os.Bundle):java.lang.String");
    }

    public static boolean isPaytmUPIPresent(Context context) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(PWEStaticDataModel.PAYOPT_UPI_CODE).authority("pay");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(builder.toString()));
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 0).iterator();
        while (it.hasNext()) {
            if (TransactionManager.PAYTM_APP_PACKAGE.equalsIgnoreCase(it.next().activityInfo.packageName)) {
                return true;
            }
        }
        return false;
    }

    public static String getSHA256HashString(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.reset();
            return new String(messageDigest.digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e2) {
            printStackTrace(e2);
            return null;
        }
    }

    public static boolean isPaytmAppInstalled(Context context) {
        try {
            context.getPackageManager().getPackageInfo(TransactionManager.PAYTM_APP_PACKAGE, 0);
            AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_PAYTM_APP_EXIST, Constants.FLOW_TYPE_APP_INVOKE, Constants.EVENT_LABEL_KEY_EXIST, "true");
            return true;
        } catch (Exception unused) {
            AnalyticsManager.getInstance().logEvent(Constants.EVENT_ACTION_PAYTM_APP_EXIST, Constants.FLOW_TYPE_APP_INVOKE, Constants.EVENT_LABEL_KEY_EXIST, "false");
            debugLog("Paytm app not installed");
            return false;
        }
    }
}
