package com.hbb20;

import android.content.Context;
import android.util.SparseArray;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.hbb20.CountryCodePicker;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class CCPCountryGroup {
    private static SparseArray<CCPCountryGroup> countryGroups;
    int areaCodeLength;
    String defaultNameCode;
    private HashMap<String, String> nameCodeToAreaCodesMap;

    private CCPCountryGroup(String defaultNameCode, int areaCodeLength, HashMap<String, String> nameCodeToAreaCodesMap) {
        this.defaultNameCode = defaultNameCode;
        this.areaCodeLength = areaCodeLength;
        this.nameCodeToAreaCodesMap = nameCodeToAreaCodesMap;
    }

    private static void initializeGroups() {
        countryGroups = new SparseArray<>();
        addGroupForPhoneCode1();
        addGroupForPhoneCode44();
        addGroupForPhoneCode358();
    }

    private static void addGroupForPhoneCode358() {
        HashMap map = new HashMap();
        map.put("ax", "18");
        countryGroups.put(358, new CCPCountryGroup("fi", 2, map));
    }

    private static void addGroupForPhoneCode44() {
        HashMap map = new HashMap();
        map.put("gg", "1481");
        map.put("im", "1624");
        map.put("je", "1534");
        countryGroups.put(44, new CCPCountryGroup("gb", 4, map));
    }

    private static void addGroupForPhoneCode1() {
        HashMap map = new HashMap();
        map.put("ag", "268");
        map.put("ai", "264");
        map.put("as", "684");
        map.put("bb", "246");
        map.put("bm", "441");
        map.put(CmcdConfiguration.KEY_BUFFER_STARVATION, "242");
        map.put("ca", "204/226/236/249/250/289/306/343/365/403/416/418/431/437/438/450/506/514/519/579/581/587/600/601/604/613/639/647/705/709/769/778/780/782/807/819/825/867/873/902/905/");
        map.put("dm", "767");
        map.put("do", "809/829/849");
        map.put("gd", "473");
        map.put("gu", "671");
        map.put("jm", "876");
        map.put("kn", "869");
        map.put("ky", "345");
        map.put("lc", "758");
        map.put("mp", "670");
        map.put("ms", "664");
        map.put("pr", "787");
        map.put("sx", "721");
        map.put("tc", "649");
        map.put("tt", "868");
        map.put("vc", "784");
        map.put("vg", "284");
        map.put("vi", "340");
        countryGroups.put(1, new CCPCountryGroup("us", 3, map));
    }

    public static CCPCountryGroup getCountryGroupForPhoneCode(int countryCode) {
        if (countryGroups == null) {
            initializeGroups();
        }
        return countryGroups.get(countryCode);
    }

    public CCPCountry getCountryForAreaCode(Context context, CountryCodePicker.Language language, String areaCode) {
        String key = this.defaultNameCode;
        for (Map.Entry<String, String> entry : this.nameCodeToAreaCodesMap.entrySet()) {
            if (entry.getValue().contains(areaCode)) {
                key = entry.getKey();
            }
        }
        return CCPCountry.getCountryForNameCodeFromLibraryMasterList(context, language, key);
    }
}
