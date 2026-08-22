package com.google.android.vending.licensing;

import android.content.Context;
import com.google.android.vending.licensing.util.URIQueryDecoder;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/* JADX INFO: loaded from: classes8.dex */
public class APKExpansionPolicy implements Policy {
    private static final String DEFAULT_MAX_RETRIES = "0";
    private static final String DEFAULT_RETRY_COUNT = "0";
    private static final String DEFAULT_RETRY_UNTIL = "0";
    private static final String DEFAULT_VALIDITY_TIMESTAMP = "0";
    public static final int MAIN_FILE_URL_INDEX = 0;
    private static final long MILLIS_PER_MINUTE = 60000;
    public static final int PATCH_FILE_URL_INDEX = 1;
    private static final String PREFS_FILE = "com.google.android.vending.licensing.APKExpansionPolicy";
    private static final String PREF_LAST_RESPONSE = "lastResponse";
    private static final String PREF_LICENSING_URL = "licensingUrl";
    private static final String PREF_MAX_RETRIES = "maxRetries";
    private static final String PREF_RETRY_COUNT = "retryCount";
    private static final String PREF_RETRY_UNTIL = "retryUntil";
    private static final String PREF_VALIDITY_TIMESTAMP = "validityTimestamp";
    private static final String TAG = "APKExpansionPolicy";
    private int mLastResponse;
    private String mLicensingUrl;
    private long mMaxRetries;
    private PreferenceObfuscator mPreferences;
    private long mRetryCount;
    private long mRetryUntil;
    private long mValidityTimestamp;
    private long mLastResponseTime = 0;
    private Vector<String> mExpansionURLs = new Vector<>();
    private Vector<String> mExpansionFileNames = new Vector<>();
    private Vector<Long> mExpansionFileSizes = new Vector<>();

    public APKExpansionPolicy(Context context, Obfuscator obfuscator) {
        PreferenceObfuscator preferenceObfuscator = new PreferenceObfuscator(context.getSharedPreferences(PREFS_FILE, 0), obfuscator);
        this.mPreferences = preferenceObfuscator;
        this.mLastResponse = Integer.parseInt(preferenceObfuscator.getString(PREF_LAST_RESPONSE, Integer.toString(Policy.RETRY)));
        this.mValidityTimestamp = Long.parseLong(this.mPreferences.getString(PREF_VALIDITY_TIMESTAMP, "0"));
        this.mRetryUntil = Long.parseLong(this.mPreferences.getString(PREF_RETRY_UNTIL, "0"));
        this.mMaxRetries = Long.parseLong(this.mPreferences.getString(PREF_MAX_RETRIES, "0"));
        this.mRetryCount = Long.parseLong(this.mPreferences.getString(PREF_RETRY_COUNT, "0"));
        this.mLicensingUrl = this.mPreferences.getString(PREF_LICENSING_URL, null);
    }

    public void resetPolicy() {
        this.mPreferences.putString(PREF_LAST_RESPONSE, Integer.toString(Policy.RETRY));
        setRetryUntil("0");
        setMaxRetries("0");
        setRetryCount(Long.parseLong("0"));
        setValidityTimestamp("0");
        this.mPreferences.commit();
    }

    @Override // com.google.android.vending.licensing.Policy
    public void processServerResponse(int i, ResponseData responseData) {
        if (i != 291) {
            setRetryCount(0L);
        } else {
            setRetryCount(this.mRetryCount + 1);
        }
        Map<String, String> mapDecodeExtras = decodeExtras(responseData);
        if (i == 256) {
            this.mLastResponse = i;
            setLicensingUrl(null);
            setValidityTimestamp(Long.toString(System.currentTimeMillis() + 60000));
            for (String str : mapDecodeExtras.keySet()) {
                if (str.equals("VT")) {
                    setValidityTimestamp(mapDecodeExtras.get(str));
                } else if (str.equals("GT")) {
                    setRetryUntil(mapDecodeExtras.get(str));
                } else if (str.equals("GR")) {
                    setMaxRetries(mapDecodeExtras.get(str));
                } else if (str.startsWith("FILE_URL")) {
                    setExpansionURL(Integer.parseInt(str.substring("FILE_URL".length())) - 1, mapDecodeExtras.get(str));
                } else if (str.startsWith("FILE_NAME")) {
                    setExpansionFileName(Integer.parseInt(str.substring("FILE_NAME".length())) - 1, mapDecodeExtras.get(str));
                } else if (str.startsWith("FILE_SIZE")) {
                    setExpansionFileSize(Integer.parseInt(str.substring("FILE_SIZE".length())) - 1, Long.parseLong(mapDecodeExtras.get(str)));
                }
            }
        } else if (i == 561) {
            setValidityTimestamp("0");
            setRetryUntil("0");
            setMaxRetries("0");
            setLicensingUrl(mapDecodeExtras.get("LU"));
        }
        setLastResponse(i);
        this.mPreferences.commit();
    }

    private void setLastResponse(int i) {
        this.mLastResponseTime = System.currentTimeMillis();
        this.mLastResponse = i;
        this.mPreferences.putString(PREF_LAST_RESPONSE, Integer.toString(i));
    }

    private void setRetryCount(long j) {
        this.mRetryCount = j;
        this.mPreferences.putString(PREF_RETRY_COUNT, Long.toString(j));
    }

    public long getRetryCount() {
        return this.mRetryCount;
    }

    private void setValidityTimestamp(String str) {
        Long lValueOf;
        try {
            lValueOf = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            lValueOf = Long.valueOf(System.currentTimeMillis() + 60000);
            str = Long.toString(lValueOf.longValue());
        }
        this.mValidityTimestamp = lValueOf.longValue();
        this.mPreferences.putString(PREF_VALIDITY_TIMESTAMP, str);
    }

    public long getValidityTimestamp() {
        return this.mValidityTimestamp;
    }

    private void setRetryUntil(String str) {
        Long lValueOf;
        try {
            lValueOf = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            lValueOf = 0L;
            str = "0";
        }
        this.mRetryUntil = lValueOf.longValue();
        this.mPreferences.putString(PREF_RETRY_UNTIL, str);
    }

    public long getRetryUntil() {
        return this.mRetryUntil;
    }

    private void setMaxRetries(String str) {
        Long lValueOf;
        try {
            lValueOf = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            lValueOf = 0L;
            str = "0";
        }
        this.mMaxRetries = lValueOf.longValue();
        this.mPreferences.putString(PREF_MAX_RETRIES, str);
    }

    public long getMaxRetries() {
        return this.mMaxRetries;
    }

    private void setLicensingUrl(String str) {
        this.mLicensingUrl = str;
        this.mPreferences.putString(PREF_LICENSING_URL, str);
    }

    @Override // com.google.android.vending.licensing.Policy
    public String getLicensingUrl() {
        return this.mLicensingUrl;
    }

    public int getExpansionURLCount() {
        return this.mExpansionURLs.size();
    }

    public String getExpansionURL(int i) {
        if (i < this.mExpansionURLs.size()) {
            return this.mExpansionURLs.elementAt(i);
        }
        return null;
    }

    public void setExpansionURL(int i, String str) {
        if (i >= this.mExpansionURLs.size()) {
            this.mExpansionURLs.setSize(i + 1);
        }
        this.mExpansionURLs.set(i, str);
    }

    public String getExpansionFileName(int i) {
        if (i < this.mExpansionFileNames.size()) {
            return this.mExpansionFileNames.elementAt(i);
        }
        return null;
    }

    public void setExpansionFileName(int i, String str) {
        if (i >= this.mExpansionFileNames.size()) {
            this.mExpansionFileNames.setSize(i + 1);
        }
        this.mExpansionFileNames.set(i, str);
    }

    public long getExpansionFileSize(int i) {
        if (i < this.mExpansionFileSizes.size()) {
            return this.mExpansionFileSizes.elementAt(i).longValue();
        }
        return -1L;
    }

    public void setExpansionFileSize(int i, long j) {
        if (i >= this.mExpansionFileSizes.size()) {
            this.mExpansionFileSizes.setSize(i + 1);
        }
        this.mExpansionFileSizes.set(i, Long.valueOf(j));
    }

    @Override // com.google.android.vending.licensing.Policy
    public boolean allowAccess() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i = this.mLastResponse;
        if (i == 256) {
            if (jCurrentTimeMillis <= this.mValidityTimestamp) {
                return true;
            }
        } else if (i == 291 && jCurrentTimeMillis < this.mLastResponseTime + 60000) {
            return jCurrentTimeMillis <= this.mRetryUntil || this.mRetryCount <= this.mMaxRetries;
        }
        return false;
    }

    private Map<String, String> decodeExtras(ResponseData responseData) {
        HashMap map = new HashMap();
        if (responseData != null) {
            try {
                URIQueryDecoder.DecodeQuery(new URI("?" + responseData.extra), map);
            } catch (URISyntaxException unused) {
            }
        }
        return map;
    }
}
