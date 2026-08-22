package com.google.android.vending.licensing.util;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Scanner;

/* JADX INFO: loaded from: classes8.dex */
public class URIQueryDecoder {
    private static final String TAG = "URIQueryDecoder";

    public static void DecodeQuery(URI uri, Map<String, String> map) {
        String strDecode;
        Scanner scanner = new Scanner(uri.getRawQuery());
        scanner.useDelimiter("&");
        while (scanner.hasNext()) {
            try {
                String[] strArrSplit = scanner.next().split("=");
                if (strArrSplit.length == 1) {
                    strDecode = null;
                } else if (strArrSplit.length == 2) {
                    strDecode = URLDecoder.decode(strArrSplit[1], "UTF-8");
                } else {
                    throw new IllegalArgumentException("query parameter invalid");
                }
                map.put(URLDecoder.decode(strArrSplit[0], "UTF-8"), strDecode);
            } catch (UnsupportedEncodingException unused) {
                return;
            }
        }
    }
}
