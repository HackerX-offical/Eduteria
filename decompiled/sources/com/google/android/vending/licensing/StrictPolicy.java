package com.google.android.vending.licensing;

import com.google.android.vending.licensing.util.URIQueryDecoder;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class StrictPolicy implements Policy {
    private static final String TAG = "StrictPolicy";
    private int mLastResponse = Policy.RETRY;
    private String mLicensingUrl = null;

    @Override // com.google.android.vending.licensing.Policy
    public void processServerResponse(int i, ResponseData responseData) {
        this.mLastResponse = i;
        if (i == 561) {
            this.mLicensingUrl = decodeExtras(responseData).get("LU");
        }
    }

    @Override // com.google.android.vending.licensing.Policy
    public boolean allowAccess() {
        return this.mLastResponse == 256;
    }

    @Override // com.google.android.vending.licensing.Policy
    public String getLicensingUrl() {
        return this.mLicensingUrl;
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
