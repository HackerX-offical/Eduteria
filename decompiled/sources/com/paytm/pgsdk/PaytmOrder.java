package com.paytm.pgsdk;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
public class PaytmOrder {
    private HashMap<String, String> requestParamMap;

    public PaytmOrder(String str, String str2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Invalid orderId");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("Invalid mid");
        }
        if (TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Invalid txnToken");
        }
        if (TextUtils.isEmpty(str5)) {
            throw new IllegalArgumentException("Invalid callbackurl");
        }
        HashMap<String, String> map = new HashMap<>();
        this.requestParamMap = map;
        map.put("ORDER_ID", str);
        this.requestParamMap.put("TXN_AMOUNT", str4);
        this.requestParamMap.put("MID", str2);
        this.requestParamMap.put(Constants.TXN_TOKEN, str3);
        this.requestParamMap.put("CALLBACK_URL", str5);
    }

    public PaytmOrder(HashMap<String, String> map) throws IllegalArgumentException {
        if (map == null || map.size() <= 0) {
            throw new IllegalArgumentException("Invalid request params");
        }
        if (!map.containsKey("CALLBACK_URL")) {
            throw new IllegalArgumentException("CALLBACK_URL not present");
        }
        if (!map.containsKey("CHECKSUMHASH")) {
            throw new IllegalArgumentException("CHECKSUMHASH not present");
        }
        if (!map.containsKey("CUST_ID")) {
            throw new IllegalArgumentException("CUST_ID not present");
        }
        if (!map.containsKey("INDUSTRY_TYPE_ID")) {
            throw new IllegalArgumentException("INDUSTRY_TYPE_ID not present");
        }
        if (!map.containsKey("MID")) {
            throw new IllegalArgumentException("MID not present");
        }
        if (!map.containsKey("ORDER_ID")) {
            throw new IllegalArgumentException("ORDER_ID not present");
        }
        if (!map.containsKey("WEBSITE")) {
            throw new IllegalArgumentException("WEBSITE not present");
        }
        if (!map.containsKey("CHANNEL_ID")) {
            throw new IllegalArgumentException("CHANNEL_ID not present");
        }
        if (!map.containsKey("TXN_AMOUNT")) {
            throw new IllegalArgumentException("TXN_AMOUNT not present");
        }
        this.requestParamMap = map;
    }

    HashMap<String, String> getRequestParamMap() {
        return this.requestParamMap;
    }
}
