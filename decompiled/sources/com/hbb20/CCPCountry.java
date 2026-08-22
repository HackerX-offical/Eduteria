package com.hbb20;

import android.content.Context;
import android.util.Log;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.appnew.android.home.Constants;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.UserDataStore;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.google.common.base.Ascii;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.hbb20.CountryCodePicker;
import cz.msebera.android.httpclient.HttpStatus;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.io.encoding.Base64;
import okio.Utf8;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.math.Primes;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.hoxt.packet.Base64BinaryChunk;
import org.jivesoftware.smackx.sid.element.StanzaIdElement;
import org.mozilla.classfile.ByteCode;

/* JADX INFO: loaded from: classes9.dex */
public class CCPCountry implements Comparable<CCPCountry> {
    private static String ANGUILLA_AREA_CODES = "264";
    private static String ANTIGUA_AND_BARBUDA_AREA_CODES = "268";
    private static String BAHAMAS_AREA_CODES = "242";
    private static String BARBADOS_AREA_CODES = "246";
    private static String BERMUDA_AREA_CODES = "441";
    private static String BRITISH_VIRGIN_ISLANDS_AREA_CODES = "284";
    private static String CANADA_AREA_CODES = "204/226/236/249/250/289/306/343/365/403/416/418/431/437/438/450/506/514/519/579/581/587/600/604/613/639/647/705/709/769/778/780/782/807/819/825/867/873/902/905/";
    private static String CAYMAN_ISLANDS_AREA_CODES = "345";
    static int DEFAULT_FLAG_RES = -99;
    private static String DOMINICAN_REPUBLIC_AREA_CODES = "809/829/849";
    private static String DOMINICA_AREA_CODES = "767";
    private static String GRENADA_AREA_CODES = "473";
    private static String ISLE_OF_MAN = "1624";
    private static String JAMAICA_AREA_CODES = "876";
    private static String MONTSERRAT_AREA_CODES = "664";
    private static String PUERTO_RICO_AREA_CODES = "787";
    private static String SAINT_KITTS_AND_NEVIS_AREA_CODES = "869";
    private static String SAINT_LUCIA_AREA_CODES = "758";
    private static String SAINT_VINCENT_AND_THE_GRENADINES_AREA_CODES = "784";
    private static String SINT_MAARTEN_AREA_CODES = "721";
    static String TAG = "Class Country";
    private static String TRINIDAD_AND_TOBAGO_AREA_CODES = "868";
    private static String TURKS_AND_CAICOS_ISLANDS_AREA_CODES = "649";
    private static String US_VIRGIN_ISLANDS_AREA_CODES = "340";
    static String dialogTitle;
    static CountryCodePicker.Language loadedLibraryMasterListLanguage;
    static List<CCPCountry> loadedLibraryMaterList;
    static String noResultFoundAckMessage;
    static String searchHintMessage;
    String englishName;
    int flagResID;
    String name;
    String nameCode;
    String phoneCode;

    public CCPCountry() {
        this.flagResID = DEFAULT_FLAG_RES;
    }

    public CCPCountry(String nameCode, String phoneCode, String name, int flagResID) {
        this.flagResID = DEFAULT_FLAG_RES;
        this.nameCode = nameCode.toUpperCase(Locale.ROOT);
        this.phoneCode = phoneCode;
        this.name = name;
        this.flagResID = flagResID;
    }

    static CountryCodePicker.Language getLoadedLibraryMasterListLanguage() {
        return loadedLibraryMasterListLanguage;
    }

    static void setLoadedLibraryMasterListLanguage(CountryCodePicker.Language loadedLibraryMasterListLanguage2) {
        loadedLibraryMasterListLanguage = loadedLibraryMasterListLanguage2;
    }

    public static List<CCPCountry> getLoadedLibraryMaterList() {
        return loadedLibraryMaterList;
    }

    static void setLoadedLibraryMaterList(List<CCPCountry> loadedLibraryMaterList2) {
        loadedLibraryMaterList = loadedLibraryMaterList2;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void loadDataFromXML(android.content.Context r8, com.hbb20.CountryCodePicker.Language r9) {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbb20.CCPCountry.loadDataFromXML(android.content.Context, com.hbb20.CountryCodePicker$Language):void");
    }

    public static String getDialogTitle(Context context, CountryCodePicker.Language language) {
        String str;
        CountryCodePicker.Language language2 = loadedLibraryMasterListLanguage;
        if (language2 == null || language2 != language || (str = dialogTitle) == null || str.length() == 0) {
            loadDataFromXML(context, language);
        }
        return dialogTitle;
    }

    public static String getSearchHintMessage(Context context, CountryCodePicker.Language language) {
        String str;
        CountryCodePicker.Language language2 = loadedLibraryMasterListLanguage;
        if (language2 == null || language2 != language || (str = searchHintMessage) == null || str.length() == 0) {
            loadDataFromXML(context, language);
        }
        return searchHintMessage;
    }

    public static String getNoResultFoundAckMessage(Context context, CountryCodePicker.Language language) {
        String str;
        CountryCodePicker.Language language2 = loadedLibraryMasterListLanguage;
        if (language2 == null || language2 != language || (str = noResultFoundAckMessage) == null || str.length() == 0) {
            loadDataFromXML(context, language);
        }
        return noResultFoundAckMessage;
    }

    public static void setDialogTitle(String dialogTitle2) {
        dialogTitle = dialogTitle2;
    }

    public static void setSearchHintMessage(String searchHintMessage2) {
        searchHintMessage = searchHintMessage2;
    }

    public static void setNoResultFoundAckMessage(String noResultFoundAckMessage2) {
        noResultFoundAckMessage = noResultFoundAckMessage2;
    }

    public static CCPCountry getCountryForCode(Context context, CountryCodePicker.Language language, List<CCPCountry> preferredCountries, String code) {
        if (preferredCountries != null && !preferredCountries.isEmpty()) {
            for (CCPCountry cCPCountry : preferredCountries) {
                if (cCPCountry.getPhoneCode().equals(code)) {
                    return cCPCountry;
                }
            }
        }
        for (CCPCountry cCPCountry2 : getLibraryMasterCountryList(context, language)) {
            if (cCPCountry2.getPhoneCode().equals(code)) {
                return cCPCountry2;
            }
        }
        return null;
    }

    static CCPCountry getCountryForCodeFromEnglishList(String code) {
        for (CCPCountry cCPCountry : getLibraryMasterCountriesEnglish()) {
            if (cCPCountry.getPhoneCode().equals(code)) {
                return cCPCountry;
            }
        }
        return null;
    }

    static List<CCPCountry> getCustomMasterCountryList(Context context, CountryCodePicker codePicker) {
        codePicker.refreshCustomMasterList();
        if (codePicker.customMasterCountriesList != null && codePicker.customMasterCountriesList.size() > 0) {
            return codePicker.getCustomMasterCountriesList();
        }
        return getLibraryMasterCountryList(context, codePicker.getLanguageToApply());
    }

    static CCPCountry getCountryForNameCodeFromCustomMasterList(Context context, List<CCPCountry> customMasterCountriesList, CountryCodePicker.Language language, String nameCode) {
        if (customMasterCountriesList == null || customMasterCountriesList.size() == 0) {
            return getCountryForNameCodeFromLibraryMasterList(context, language, nameCode);
        }
        for (CCPCountry cCPCountry : customMasterCountriesList) {
            if (cCPCountry.getNameCode().equalsIgnoreCase(nameCode)) {
                return cCPCountry;
            }
        }
        return null;
    }

    public static CCPCountry getCountryForNameCodeFromLibraryMasterList(Context context, CountryCodePicker.Language language, String nameCode) {
        for (CCPCountry cCPCountry : getLibraryMasterCountryList(context, language)) {
            if (cCPCountry.getNameCode().equalsIgnoreCase(nameCode)) {
                return cCPCountry;
            }
        }
        return null;
    }

    static CCPCountry getCountryForNameCodeFromEnglishList(String nameCode) {
        for (CCPCountry cCPCountry : getLibraryMasterCountriesEnglish()) {
            if (cCPCountry.getNameCode().equalsIgnoreCase(nameCode)) {
                return cCPCountry;
            }
        }
        return null;
    }

    static CCPCountry getCountryForCode(Context context, CountryCodePicker.Language language, List<CCPCountry> preferredCountries, int code) {
        return getCountryForCode(context, language, preferredCountries, code + "");
    }

    static CCPCountry getCountryForNumber(Context context, CountryCodePicker.Language language, List<CCPCountry> preferredCountries, String fullNumber) {
        CCPCountryGroup countryGroupForPhoneCode;
        if (fullNumber == null) {
            return null;
        }
        String strTrim = fullNumber.trim();
        if (strTrim.length() != 0) {
            int i = strTrim.charAt(0) == '+' ? 1 : 0;
            for (int i2 = i; i2 <= strTrim.length(); i2++) {
                String strSubstring = strTrim.substring(i, i2);
                try {
                    countryGroupForPhoneCode = CCPCountryGroup.getCountryGroupForPhoneCode(Integer.parseInt(strSubstring));
                } catch (Exception unused) {
                    countryGroupForPhoneCode = null;
                }
                if (countryGroupForPhoneCode != null) {
                    int length = i + strSubstring.length();
                    if (strTrim.length() >= countryGroupForPhoneCode.areaCodeLength + length) {
                        return countryGroupForPhoneCode.getCountryForAreaCode(context, language, strTrim.substring(length, countryGroupForPhoneCode.areaCodeLength + length));
                    }
                    return getCountryForNameCodeFromLibraryMasterList(context, language, countryGroupForPhoneCode.defaultNameCode);
                }
                CCPCountry countryForCode = getCountryForCode(context, language, preferredCountries, strSubstring);
                if (countryForCode != null) {
                    return countryForCode;
                }
            }
        }
        return null;
    }

    public static CCPCountry getCountryForNumber(Context context, CountryCodePicker.Language language, String fullNumber) {
        return getCountryForNumber(context, language, null, fullNumber);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static int getFlagMasterResID(CCPCountry CCPCountry) {
        String lowerCase = CCPCountry.getNameCode().toLowerCase();
        lowerCase.hashCode();
        byte b2 = -1;
        switch (lowerCase.hashCode()) {
            case 3107:
                if (lowerCase.equals("ad")) {
                    b2 = 0;
                }
                break;
            case 3108:
                if (lowerCase.equals("ae")) {
                    b2 = 1;
                }
                break;
            case 3109:
                if (lowerCase.equals("af")) {
                    b2 = 2;
                }
                break;
            case 3110:
                if (lowerCase.equals("ag")) {
                    b2 = 3;
                }
                break;
            case 3112:
                if (lowerCase.equals("ai")) {
                    b2 = 4;
                }
                break;
            case 3115:
                if (lowerCase.equals("al")) {
                    b2 = 5;
                }
                break;
            case 3116:
                if (lowerCase.equals("am")) {
                    b2 = 6;
                }
                break;
            case 3118:
                if (lowerCase.equals("ao")) {
                    b2 = 7;
                }
                break;
            case 3120:
                if (lowerCase.equals("aq")) {
                    b2 = 8;
                }
                break;
            case 3121:
                if (lowerCase.equals("ar")) {
                    b2 = 9;
                }
                break;
            case 3122:
                if (lowerCase.equals("as")) {
                    b2 = 10;
                }
                break;
            case 3123:
                if (lowerCase.equals(DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_AT)) {
                    b2 = 11;
                }
                break;
            case 3124:
                if (lowerCase.equals("au")) {
                    b2 = 12;
                }
                break;
            case 3126:
                if (lowerCase.equals("aw")) {
                    b2 = 13;
                }
                break;
            case 3127:
                if (lowerCase.equals("ax")) {
                    b2 = 14;
                }
                break;
            case 3129:
                if (lowerCase.equals("az")) {
                    b2 = Ascii.SI;
                }
                break;
            case 3135:
                if (lowerCase.equals("ba")) {
                    b2 = 16;
                }
                break;
            case 3136:
                if (lowerCase.equals("bb")) {
                    b2 = 17;
                }
                break;
            case 3138:
                if (lowerCase.equals("bd")) {
                    b2 = Ascii.DC2;
                }
                break;
            case 3139:
                if (lowerCase.equals("be")) {
                    b2 = 19;
                }
                break;
            case 3140:
                if (lowerCase.equals("bf")) {
                    b2 = Ascii.DC4;
                }
                break;
            case 3141:
                if (lowerCase.equals(Constants.KEY_BG)) {
                    b2 = Ascii.NAK;
                }
                break;
            case 3142:
                if (lowerCase.equals("bh")) {
                    b2 = Ascii.SYN;
                }
                break;
            case 3143:
                if (lowerCase.equals("bi")) {
                    b2 = Ascii.ETB;
                }
                break;
            case 3144:
                if (lowerCase.equals("bj")) {
                    b2 = Ascii.CAN;
                }
                break;
            case 3146:
                if (lowerCase.equals(CmcdConfiguration.KEY_BUFFER_LENGTH)) {
                    b2 = Ascii.EM;
                }
                break;
            case 3147:
                if (lowerCase.equals("bm")) {
                    b2 = Ascii.SUB;
                }
                break;
            case 3148:
                if (lowerCase.equals("bn")) {
                    b2 = Ascii.ESC;
                }
                break;
            case 3149:
                if (lowerCase.equals("bo")) {
                    b2 = Ascii.FS;
                }
                break;
            case 3152:
                if (lowerCase.equals("br")) {
                    b2 = Ascii.GS;
                }
                break;
            case 3153:
                if (lowerCase.equals(CmcdConfiguration.KEY_BUFFER_STARVATION)) {
                    b2 = Ascii.RS;
                }
                break;
            case 3154:
                if (lowerCase.equals("bt")) {
                    b2 = Ascii.US;
                }
                break;
            case 3157:
                if (lowerCase.equals("bw")) {
                    b2 = 32;
                }
                break;
            case 3159:
                if (lowerCase.equals(StanzaIdElement.ATTR_BY)) {
                    b2 = 33;
                }
                break;
            case 3160:
                if (lowerCase.equals("bz")) {
                    b2 = 34;
                }
                break;
            case 3166:
                if (lowerCase.equals("ca")) {
                    b2 = 35;
                }
                break;
            case 3168:
                if (lowerCase.equals("cc")) {
                    b2 = 36;
                }
                break;
            case 3169:
                if (lowerCase.equals("cd")) {
                    b2 = 37;
                }
                break;
            case 3171:
                if (lowerCase.equals("cf")) {
                    b2 = 38;
                }
                break;
            case 3172:
                if (lowerCase.equals("cg")) {
                    b2 = 39;
                }
                break;
            case 3173:
                if (lowerCase.equals("ch")) {
                    b2 = 40;
                }
                break;
            case 3174:
                if (lowerCase.equals("ci")) {
                    b2 = 41;
                }
                break;
            case 3176:
                if (lowerCase.equals("ck")) {
                    b2 = 42;
                }
                break;
            case 3177:
                if (lowerCase.equals("cl")) {
                    b2 = 43;
                }
                break;
            case 3178:
                if (lowerCase.equals("cm")) {
                    b2 = 44;
                }
                break;
            case 3179:
                if (lowerCase.equals("cn")) {
                    b2 = 45;
                }
                break;
            case 3180:
                if (lowerCase.equals("co")) {
                    b2 = 46;
                }
                break;
            case 3183:
                if (lowerCase.equals("cr")) {
                    b2 = 47;
                }
                break;
            case 3186:
                if (lowerCase.equals("cu")) {
                    b2 = 48;
                }
                break;
            case 3187:
                if (lowerCase.equals("cv")) {
                    b2 = 49;
                }
                break;
            case 3188:
                if (lowerCase.equals("cw")) {
                    b2 = 50;
                }
                break;
            case 3189:
                if (lowerCase.equals("cx")) {
                    b2 = 51;
                }
                break;
            case 3190:
                if (lowerCase.equals("cy")) {
                    b2 = 52;
                }
                break;
            case 3191:
                if (lowerCase.equals("cz")) {
                    b2 = 53;
                }
                break;
            case 3201:
                if (lowerCase.equals("de")) {
                    b2 = 54;
                }
                break;
            case 3206:
                if (lowerCase.equals("dj")) {
                    b2 = 55;
                }
                break;
            case 3207:
                if (lowerCase.equals(Constants.INAPP_NOTIF_DARKEN_SCREEN)) {
                    b2 = 56;
                }
                break;
            case 3209:
                if (lowerCase.equals("dm")) {
                    b2 = 57;
                }
                break;
            case 3211:
                if (lowerCase.equals("do")) {
                    b2 = 58;
                }
                break;
            case 3222:
                if (lowerCase.equals("dz")) {
                    b2 = 59;
                }
                break;
            case 3230:
                if (lowerCase.equals("ec")) {
                    b2 = 60;
                }
                break;
            case 3232:
                if (lowerCase.equals("ee")) {
                    b2 = Base64.padSymbol;
                }
                break;
            case 3234:
                if (lowerCase.equals("eg")) {
                    b2 = 62;
                }
                break;
            case 3245:
                if (lowerCase.equals("er")) {
                    b2 = Utf8.REPLACEMENT_BYTE;
                }
                break;
            case 3246:
                if (lowerCase.equals("es")) {
                    b2 = 64;
                }
                break;
            case 3247:
                if (lowerCase.equals("et")) {
                    b2 = 65;
                }
                break;
            case 3267:
                if (lowerCase.equals("fi")) {
                    b2 = 66;
                }
                break;
            case 3268:
                if (lowerCase.equals("fj")) {
                    b2 = 67;
                }
                break;
            case 3269:
                if (lowerCase.equals("fk")) {
                    b2 = 68;
                }
                break;
            case 3271:
                if (lowerCase.equals("fm")) {
                    b2 = 69;
                }
                break;
            case 3273:
                if (lowerCase.equals("fo")) {
                    b2 = 70;
                }
                break;
            case 3276:
                if (lowerCase.equals("fr")) {
                    b2 = 71;
                }
                break;
            case 3290:
                if (lowerCase.equals("ga")) {
                    b2 = 72;
                }
                break;
            case 3291:
                if (lowerCase.equals("gb")) {
                    b2 = 73;
                }
                break;
            case 3293:
                if (lowerCase.equals("gd")) {
                    b2 = 74;
                }
                break;
            case 3294:
                if (lowerCase.equals(UserDataStore.GENDER)) {
                    b2 = 75;
                }
                break;
            case 3295:
                if (lowerCase.equals("gf")) {
                    b2 = 76;
                }
                break;
            case 3296:
                if (lowerCase.equals("gg")) {
                    b2 = 77;
                }
                break;
            case 3297:
                if (lowerCase.equals("gh")) {
                    b2 = 78;
                }
                break;
            case 3298:
                if (lowerCase.equals("gi")) {
                    b2 = 79;
                }
                break;
            case 3301:
                if (lowerCase.equals("gl")) {
                    b2 = 80;
                }
                break;
            case 3302:
                if (lowerCase.equals("gm")) {
                    b2 = 81;
                }
                break;
            case 3303:
                if (lowerCase.equals("gn")) {
                    b2 = 82;
                }
                break;
            case 3305:
                if (lowerCase.equals("gp")) {
                    b2 = 83;
                }
                break;
            case 3306:
                if (lowerCase.equals("gq")) {
                    b2 = 84;
                }
                break;
            case 3307:
                if (lowerCase.equals("gr")) {
                    b2 = 85;
                }
                break;
            case 3309:
                if (lowerCase.equals("gt")) {
                    b2 = 86;
                }
                break;
            case 3310:
                if (lowerCase.equals("gu")) {
                    b2 = 87;
                }
                break;
            case 3312:
                if (lowerCase.equals("gw")) {
                    b2 = 88;
                }
                break;
            case 3314:
                if (lowerCase.equals("gy")) {
                    b2 = 89;
                }
                break;
            case 3331:
                if (lowerCase.equals("hk")) {
                    b2 = 90;
                }
                break;
            case 3334:
                if (lowerCase.equals("hn")) {
                    b2 = 91;
                }
                break;
            case 3338:
                if (lowerCase.equals("hr")) {
                    b2 = 92;
                }
                break;
            case 3340:
                if (lowerCase.equals("ht")) {
                    b2 = 93;
                }
                break;
            case 3341:
                if (lowerCase.equals("hu")) {
                    b2 = 94;
                }
                break;
            case 3355:
                if (lowerCase.equals("id")) {
                    b2 = 95;
                }
                break;
            case 3356:
                if (lowerCase.equals("ie")) {
                    b2 = 96;
                }
                break;
            case 3363:
                if (lowerCase.equals("il")) {
                    b2 = 97;
                }
                break;
            case 3364:
                if (lowerCase.equals("im")) {
                    b2 = 98;
                }
                break;
            case 3365:
                if (lowerCase.equals("in")) {
                    b2 = 99;
                }
                break;
            case 3366:
                if (lowerCase.equals("io")) {
                    b2 = 100;
                }
                break;
            case 3368:
                if (lowerCase.equals(IQ.IQ_ELEMENT)) {
                    b2 = 101;
                }
                break;
            case 3369:
                if (lowerCase.equals("ir")) {
                    b2 = 102;
                }
                break;
            case 3370:
                if (lowerCase.equals("is")) {
                    b2 = 103;
                }
                break;
            case 3371:
                if (lowerCase.equals("it")) {
                    b2 = 104;
                }
                break;
            case 3387:
                if (lowerCase.equals("je")) {
                    b2 = 105;
                }
                break;
            case 3395:
                if (lowerCase.equals("jm")) {
                    b2 = 106;
                }
                break;
            case 3397:
                if (lowerCase.equals("jo")) {
                    b2 = 107;
                }
                break;
            case 3398:
                if (lowerCase.equals("jp")) {
                    b2 = 108;
                }
                break;
            case 3418:
                if (lowerCase.equals("ke")) {
                    b2 = 109;
                }
                break;
            case 3420:
                if (lowerCase.equals("kg")) {
                    b2 = 110;
                }
                break;
            case 3421:
                if (lowerCase.equals("kh")) {
                    b2 = 111;
                }
                break;
            case 3422:
                if (lowerCase.equals("ki")) {
                    b2 = 112;
                }
                break;
            case 3426:
                if (lowerCase.equals("km")) {
                    b2 = 113;
                }
                break;
            case 3427:
                if (lowerCase.equals("kn")) {
                    b2 = 114;
                }
                break;
            case 3429:
                if (lowerCase.equals("kp")) {
                    b2 = 115;
                }
                break;
            case 3431:
                if (lowerCase.equals("kr")) {
                    b2 = 116;
                }
                break;
            case 3436:
                if (lowerCase.equals("kw")) {
                    b2 = 117;
                }
                break;
            case 3438:
                if (lowerCase.equals("ky")) {
                    b2 = 118;
                }
                break;
            case 3439:
                if (lowerCase.equals("kz")) {
                    b2 = 119;
                }
                break;
            case 3445:
                if (lowerCase.equals("la")) {
                    b2 = 120;
                }
                break;
            case 3446:
                if (lowerCase.equals("lb")) {
                    b2 = 121;
                }
                break;
            case 3447:
                if (lowerCase.equals("lc")) {
                    b2 = 122;
                }
                break;
            case 3453:
                if (lowerCase.equals("li")) {
                    b2 = 123;
                }
                break;
            case 3455:
                if (lowerCase.equals("lk")) {
                    b2 = 124;
                }
                break;
            case 3462:
                if (lowerCase.equals("lr")) {
                    b2 = 125;
                }
                break;
            case 3463:
                if (lowerCase.equals("ls")) {
                    b2 = 126;
                }
                break;
            case 3464:
                if (lowerCase.equals("lt")) {
                    b2 = 127;
                }
                break;
            case 3465:
                if (lowerCase.equals("lu")) {
                    b2 = 128;
                }
                break;
            case 3466:
                if (lowerCase.equals("lv")) {
                    b2 = 129;
                }
                break;
            case 3469:
                if (lowerCase.equals("ly")) {
                    b2 = 130;
                }
                break;
            case 3476:
                if (lowerCase.equals("ma")) {
                    b2 = 131;
                }
                break;
            case 3478:
                if (lowerCase.equals("mc")) {
                    b2 = 132;
                }
                break;
            case 3479:
                if (lowerCase.equals("md")) {
                    b2 = 133;
                }
                break;
            case 3480:
                if (lowerCase.equals(TournamentShareDialogURIBuilder.f586me)) {
                    b2 = 134;
                }
                break;
            case 3481:
                if (lowerCase.equals("mf")) {
                    b2 = 135;
                }
                break;
            case 3482:
                if (lowerCase.equals("mg")) {
                    b2 = 136;
                }
                break;
            case 3483:
                if (lowerCase.equals("mh")) {
                    b2 = 137;
                }
                break;
            case 3486:
                if (lowerCase.equals("mk")) {
                    b2 = 138;
                }
                break;
            case 3487:
                if (lowerCase.equals("ml")) {
                    b2 = 139;
                }
                break;
            case 3488:
                if (lowerCase.equals("mm")) {
                    b2 = 140;
                }
                break;
            case 3489:
                if (lowerCase.equals("mn")) {
                    b2 = 141;
                }
                break;
            case 3490:
                if (lowerCase.equals("mo")) {
                    b2 = 142;
                }
                break;
            case 3491:
                if (lowerCase.equals("mp")) {
                    b2 = 143;
                }
                break;
            case 3492:
                if (lowerCase.equals("mq")) {
                    b2 = 144;
                }
                break;
            case 3493:
                if (lowerCase.equals("mr")) {
                    b2 = 145;
                }
                break;
            case 3494:
                if (lowerCase.equals("ms")) {
                    b2 = 146;
                }
                break;
            case 3495:
                if (lowerCase.equals("mt")) {
                    b2 = 147;
                }
                break;
            case 3496:
                if (lowerCase.equals("mu")) {
                    b2 = 148;
                }
                break;
            case 3497:
                if (lowerCase.equals("mv")) {
                    b2 = 149;
                }
                break;
            case 3498:
                if (lowerCase.equals("mw")) {
                    b2 = 150;
                }
                break;
            case 3499:
                if (lowerCase.equals("mx")) {
                    b2 = 151;
                }
                break;
            case 3500:
                if (lowerCase.equals("my")) {
                    b2 = 152;
                }
                break;
            case 3501:
                if (lowerCase.equals("mz")) {
                    b2 = 153;
                }
                break;
            case 3507:
                if (lowerCase.equals("na")) {
                    b2 = 154;
                }
                break;
            case 3509:
                if (lowerCase.equals("nc")) {
                    b2 = 155;
                }
                break;
            case 3511:
                if (lowerCase.equals("ne")) {
                    b2 = 156;
                }
                break;
            case 3512:
                if (lowerCase.equals("nf")) {
                    b2 = 157;
                }
                break;
            case 3513:
                if (lowerCase.equals("ng")) {
                    b2 = 158;
                }
                break;
            case 3515:
                if (lowerCase.equals("ni")) {
                    b2 = 159;
                }
                break;
            case 3518:
                if (lowerCase.equals("nl")) {
                    b2 = 160;
                }
                break;
            case 3521:
                if (lowerCase.equals("no")) {
                    b2 = 161;
                }
                break;
            case 3522:
                if (lowerCase.equals("np")) {
                    b2 = 162;
                }
                break;
            case 3524:
                if (lowerCase.equals(Base64BinaryChunk.ATTRIBUTE_NR)) {
                    b2 = 163;
                }
                break;
            case 3527:
                if (lowerCase.equals("nu")) {
                    b2 = 164;
                }
                break;
            case 3532:
                if (lowerCase.equals("nz")) {
                    b2 = 165;
                }
                break;
            case 3550:
                if (lowerCase.equals("om")) {
                    b2 = 166;
                }
                break;
            case 3569:
                if (lowerCase.equals("pa")) {
                    b2 = 167;
                }
                break;
            case 3573:
                if (lowerCase.equals("pe")) {
                    b2 = 168;
                }
                break;
            case 3574:
                if (lowerCase.equals("pf")) {
                    b2 = 169;
                }
                break;
            case 3575:
                if (lowerCase.equals("pg")) {
                    b2 = 170;
                }
                break;
            case 3576:
                if (lowerCase.equals(UserDataStore.PHONE)) {
                    b2 = 171;
                }
                break;
            case 3579:
                if (lowerCase.equals("pk")) {
                    b2 = 172;
                }
                break;
            case 3580:
                if (lowerCase.equals("pl")) {
                    b2 = 173;
                }
                break;
            case 3581:
                if (lowerCase.equals("pm")) {
                    b2 = 174;
                }
                break;
            case 3582:
                if (lowerCase.equals("pn")) {
                    b2 = 175;
                }
                break;
            case 3586:
                if (lowerCase.equals("pr")) {
                    b2 = 176;
                }
                break;
            case 3587:
                if (lowerCase.equals("ps")) {
                    b2 = 177;
                }
                break;
            case 3588:
                if (lowerCase.equals(DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_PT)) {
                    b2 = 178;
                }
                break;
            case 3591:
                if (lowerCase.equals("pw")) {
                    b2 = 179;
                }
                break;
            case 3593:
                if (lowerCase.equals("py")) {
                    b2 = 180;
                }
                break;
            case 3600:
                if (lowerCase.equals("qa")) {
                    b2 = 181;
                }
                break;
            case 3635:
                if (lowerCase.equals("re")) {
                    b2 = 182;
                }
                break;
            case 3645:
                if (lowerCase.equals("ro")) {
                    b2 = 183;
                }
                break;
            case 3649:
                if (lowerCase.equals("rs")) {
                    b2 = 184;
                }
                break;
            case 3651:
                if (lowerCase.equals("ru")) {
                    b2 = 185;
                }
                break;
            case 3653:
                if (lowerCase.equals("rw")) {
                    b2 = 186;
                }
                break;
            case 3662:
                if (lowerCase.equals("sa")) {
                    b2 = 187;
                }
                break;
            case 3663:
                if (lowerCase.equals("sb")) {
                    b2 = PSSSigner.TRAILER_IMPLICIT;
                }
                break;
            case 3664:
                if (lowerCase.equals(Constants.INAPP_NOTIF_SHOW_CLOSE)) {
                    b2 = 189;
                }
                break;
            case 3665:
                if (lowerCase.equals(DynamicLink.SocialMetaTagParameters.KEY_SOCIAL_DESCRIPTION)) {
                    b2 = 190;
                }
                break;
            case 3666:
                if (lowerCase.equals("se")) {
                    b2 = 191;
                }
                break;
            case 3668:
                if (lowerCase.equals("sg")) {
                    b2 = 192;
                }
                break;
            case 3669:
                if (lowerCase.equals("sh")) {
                    b2 = 193;
                }
                break;
            case 3670:
                if (lowerCase.equals("si")) {
                    b2 = 194;
                }
                break;
            case 3672:
                if (lowerCase.equals("sk")) {
                    b2 = 195;
                }
                break;
            case 3673:
                if (lowerCase.equals("sl")) {
                    b2 = 196;
                }
                break;
            case 3674:
                if (lowerCase.equals(StreamManagement.StreamManagementFeature.ELEMENT)) {
                    b2 = 197;
                }
                break;
            case 3675:
                if (lowerCase.equals("sn")) {
                    b2 = 198;
                }
                break;
            case 3676:
                if (lowerCase.equals("so")) {
                    b2 = 199;
                }
                break;
            case 3679:
                if (lowerCase.equals("sr")) {
                    b2 = 200;
                }
                break;
            case 3680:
                if (lowerCase.equals(Constants.KEY_ENCRYPTION_INAPP_SS)) {
                    b2 = 201;
                }
                break;
            case 3681:
                if (lowerCase.equals("st")) {
                    b2 = 202;
                }
                break;
            case 3683:
                if (lowerCase.equals("sv")) {
                    b2 = 203;
                }
                break;
            case 3685:
                if (lowerCase.equals("sx")) {
                    b2 = 204;
                }
                break;
            case 3686:
                if (lowerCase.equals("sy")) {
                    b2 = 205;
                }
                break;
            case 3687:
                if (lowerCase.equals("sz")) {
                    b2 = 206;
                }
                break;
            case 3695:
                if (lowerCase.equals("tc")) {
                    b2 = 207;
                }
                break;
            case 3696:
                if (lowerCase.equals("td")) {
                    b2 = 208;
                }
                break;
            case 3699:
                if (lowerCase.equals("tg")) {
                    b2 = 209;
                }
                break;
            case 3700:
                if (lowerCase.equals("th")) {
                    b2 = 210;
                }
                break;
            case 3702:
                if (lowerCase.equals("tj")) {
                    b2 = 211;
                }
                break;
            case 3703:
                if (lowerCase.equals("tk")) {
                    b2 = 212;
                }
                break;
            case 3704:
                if (lowerCase.equals("tl")) {
                    b2 = 213;
                }
                break;
            case 3705:
                if (lowerCase.equals("tm")) {
                    b2 = 214;
                }
                break;
            case 3706:
                if (lowerCase.equals("tn")) {
                    b2 = 215;
                }
                break;
            case 3707:
                if (lowerCase.equals("to")) {
                    b2 = 216;
                }
                break;
            case 3710:
                if (lowerCase.equals("tr")) {
                    b2 = 217;
                }
                break;
            case 3712:
                if (lowerCase.equals("tt")) {
                    b2 = 218;
                }
                break;
            case 3714:
                if (lowerCase.equals("tv")) {
                    b2 = 219;
                }
                break;
            case 3715:
                if (lowerCase.equals("tw")) {
                    b2 = 220;
                }
                break;
            case 3718:
                if (lowerCase.equals("tz")) {
                    b2 = 221;
                }
                break;
            case 3724:
                if (lowerCase.equals("ua")) {
                    b2 = 222;
                }
                break;
            case 3730:
                if (lowerCase.equals("ug")) {
                    b2 = 223;
                }
                break;
            case 3742:
                if (lowerCase.equals("us")) {
                    b2 = 224;
                }
                break;
            case 3748:
                if (lowerCase.equals("uy")) {
                    b2 = 225;
                }
                break;
            case 3749:
                if (lowerCase.equals("uz")) {
                    b2 = 226;
                }
                break;
            case 3755:
                if (lowerCase.equals("va")) {
                    b2 = 227;
                }
                break;
            case 3757:
                if (lowerCase.equals("vc")) {
                    b2 = 228;
                }
                break;
            case 3759:
                if (lowerCase.equals("ve")) {
                    b2 = 229;
                }
                break;
            case 3761:
                if (lowerCase.equals("vg")) {
                    b2 = 230;
                }
                break;
            case 3763:
                if (lowerCase.equals("vi")) {
                    b2 = 231;
                }
                break;
            case 3768:
                if (lowerCase.equals("vn")) {
                    b2 = 232;
                }
                break;
            case 3775:
                if (lowerCase.equals("vu")) {
                    b2 = 233;
                }
                break;
            case 3791:
                if (lowerCase.equals("wf")) {
                    b2 = 234;
                }
                break;
            case 3804:
                if (lowerCase.equals("ws")) {
                    b2 = 235;
                }
                break;
            case 3827:
                if (lowerCase.equals("xk")) {
                    b2 = 236;
                }
                break;
            case 3852:
                if (lowerCase.equals("ye")) {
                    b2 = 237;
                }
                break;
            case 3867:
                if (lowerCase.equals("yt")) {
                    b2 = 238;
                }
                break;
            case 3879:
                if (lowerCase.equals("za")) {
                    b2 = 239;
                }
                break;
            case 3891:
                if (lowerCase.equals("zm")) {
                    b2 = 240;
                }
                break;
            case 3901:
                if (lowerCase.equals("zw")) {
                    b2 = 241;
                }
                break;
        }
        switch (b2) {
            case 0:
                return R.drawable.flag_andorra;
            case 1:
                return R.drawable.flag_uae;
            case 2:
                return R.drawable.flag_afghanistan;
            case 3:
                return R.drawable.flag_antigua_and_barbuda;
            case 4:
                return R.drawable.flag_anguilla;
            case 5:
                return R.drawable.flag_albania;
            case 6:
                return R.drawable.flag_armenia;
            case 7:
                return R.drawable.flag_angola;
            case 8:
                return R.drawable.flag_antarctica;
            case 9:
                return R.drawable.flag_argentina;
            case 10:
                return R.drawable.flag_american_samoa;
            case 11:
                return R.drawable.flag_austria;
            case 12:
                return R.drawable.flag_australia;
            case 13:
                return R.drawable.flag_aruba;
            case 14:
                return R.drawable.flag_aland;
            case 15:
                return R.drawable.flag_azerbaijan;
            case 16:
                return R.drawable.flag_bosnia;
            case 17:
                return R.drawable.flag_barbados;
            case 18:
                return R.drawable.flag_bangladesh;
            case 19:
                return R.drawable.flag_belgium;
            case 20:
                return R.drawable.flag_burkina_faso;
            case 21:
                return R.drawable.flag_bulgaria;
            case 22:
                return R.drawable.flag_bahrain;
            case 23:
                return R.drawable.flag_burundi;
            case 24:
                return R.drawable.flag_benin;
            case 25:
                return R.drawable.flag_saint_barthelemy;
            case 26:
                return R.drawable.flag_bermuda;
            case 27:
                return R.drawable.flag_brunei;
            case 28:
                return R.drawable.flag_bolivia;
            case 29:
                return R.drawable.flag_brazil;
            case 30:
                return R.drawable.flag_bahamas;
            case 31:
                return R.drawable.flag_bhutan;
            case 32:
                return R.drawable.flag_botswana;
            case 33:
                return R.drawable.flag_belarus;
            case 34:
                return R.drawable.flag_belize;
            case 35:
                return R.drawable.flag_canada;
            case 36:
                return R.drawable.flag_cocos;
            case 37:
                return R.drawable.flag_democratic_republic_of_the_congo;
            case 38:
                return R.drawable.flag_central_african_republic;
            case 39:
                return R.drawable.flag_republic_of_the_congo;
            case 40:
                return R.drawable.flag_switzerland;
            case 41:
                return R.drawable.flag_cote_divoire;
            case 42:
                return R.drawable.flag_cook_islands;
            case 43:
                return R.drawable.flag_chile;
            case 44:
                return R.drawable.flag_cameroon;
            case 45:
                return R.drawable.flag_china;
            case 46:
                return R.drawable.flag_colombia;
            case 47:
                return R.drawable.flag_costa_rica;
            case 48:
                return R.drawable.flag_cuba;
            case 49:
                return R.drawable.flag_cape_verde;
            case 50:
                return R.drawable.flag_curacao;
            case 51:
                return R.drawable.flag_christmas_island;
            case 52:
                return R.drawable.flag_cyprus;
            case 53:
                return R.drawable.flag_czech_republic;
            case 54:
                return R.drawable.flag_germany;
            case 55:
                return R.drawable.flag_djibouti;
            case 56:
                return R.drawable.flag_denmark;
            case 57:
                return R.drawable.flag_dominica;
            case 58:
                return R.drawable.flag_dominican_republic;
            case 59:
                return R.drawable.flag_algeria;
            case 60:
                return R.drawable.flag_ecuador;
            case 61:
                return R.drawable.flag_estonia;
            case 62:
                return R.drawable.flag_egypt;
            case 63:
                return R.drawable.flag_eritrea;
            case 64:
                return R.drawable.flag_spain;
            case 65:
                return R.drawable.flag_ethiopia;
            case 66:
                return R.drawable.flag_finland;
            case 67:
                return R.drawable.flag_fiji;
            case 68:
                return R.drawable.flag_falkland_islands;
            case 69:
                return R.drawable.flag_micronesia;
            case 70:
                return R.drawable.flag_faroe_islands;
            case 71:
                return R.drawable.flag_france;
            case 72:
                return R.drawable.flag_gabon;
            case 73:
                return R.drawable.flag_united_kingdom;
            case 74:
                return R.drawable.flag_grenada;
            case 75:
                return R.drawable.flag_georgia;
            case 76:
                return R.drawable.flag_guyane;
            case 77:
                return R.drawable.flag_guernsey;
            case 78:
                return R.drawable.flag_ghana;
            case 79:
                return R.drawable.flag_gibraltar;
            case 80:
                return R.drawable.flag_greenland;
            case 81:
                return R.drawable.flag_gambia;
            case 82:
                return R.drawable.flag_guinea;
            case 83:
                return R.drawable.flag_guadeloupe;
            case 84:
                return R.drawable.flag_equatorial_guinea;
            case 85:
                return R.drawable.flag_greece;
            case 86:
                return R.drawable.flag_guatemala;
            case 87:
                return R.drawable.flag_guam;
            case 88:
                return R.drawable.flag_guinea_bissau;
            case 89:
                return R.drawable.flag_guyana;
            case 90:
                return R.drawable.flag_hong_kong;
            case 91:
                return R.drawable.flag_honduras;
            case 92:
                return R.drawable.flag_croatia;
            case 93:
                return R.drawable.flag_haiti;
            case 94:
                return R.drawable.flag_hungary;
            case 95:
                return R.drawable.flag_indonesia;
            case 96:
                return R.drawable.flag_ireland;
            case 97:
                return R.drawable.flag_israel;
            case 98:
                return R.drawable.flag_isleof_man;
            case 99:
                return R.drawable.flag_india;
            case 100:
                return R.drawable.flag_british_indian_ocean_territory;
            case 101:
                return R.drawable.flag_iraq_new;
            case 102:
                return R.drawable.flag_iran;
            case 103:
                return R.drawable.flag_iceland;
            case 104:
                return R.drawable.flag_italy;
            case 105:
                return R.drawable.flag_jersey;
            case 106:
                return R.drawable.flag_jamaica;
            case 107:
                return R.drawable.flag_jordan;
            case 108:
                return R.drawable.flag_japan;
            case 109:
                return R.drawable.flag_kenya;
            case 110:
                return R.drawable.flag_kyrgyzstan;
            case 111:
                return R.drawable.flag_cambodia;
            case 112:
                return R.drawable.flag_kiribati;
            case 113:
                return R.drawable.flag_comoros;
            case 114:
                return R.drawable.flag_saint_kitts_and_nevis;
            case 115:
                return R.drawable.flag_north_korea;
            case 116:
                return R.drawable.flag_south_korea;
            case 117:
                return R.drawable.flag_kuwait;
            case 118:
                return R.drawable.flag_cayman_islands;
            case 119:
                return R.drawable.flag_kazakhstan;
            case 120:
                return R.drawable.flag_laos;
            case 121:
                return R.drawable.flag_lebanon;
            case 122:
                return R.drawable.flag_saint_lucia;
            case 123:
                return R.drawable.flag_liechtenstein;
            case 124:
                return R.drawable.flag_sri_lanka;
            case 125:
                return R.drawable.flag_liberia;
            case 126:
                return R.drawable.flag_lesotho;
            case 127:
                return R.drawable.flag_lithuania;
            case 128:
                return R.drawable.flag_luxembourg;
            case 129:
                return R.drawable.flag_latvia;
            case 130:
                return R.drawable.flag_libya;
            case 131:
                return R.drawable.flag_morocco;
            case 132:
                return R.drawable.flag_monaco;
            case 133:
                return R.drawable.flag_moldova;
            case 134:
                return R.drawable.flag_of_montenegro;
            case 135:
                return R.drawable.flag_saint_martin;
            case 136:
                return R.drawable.flag_madagascar;
            case 137:
                return R.drawable.flag_marshall_islands;
            case 138:
                return R.drawable.flag_macedonia;
            case 139:
                return R.drawable.flag_mali;
            case 140:
                return R.drawable.flag_myanmar;
            case 141:
                return R.drawable.flag_mongolia;
            case 142:
                return R.drawable.flag_macao;
            case 143:
                return R.drawable.flag_northern_mariana_islands;
            case 144:
                return R.drawable.flag_martinique;
            case 145:
                return R.drawable.flag_mauritania;
            case 146:
                return R.drawable.flag_montserrat;
            case 147:
                return R.drawable.flag_malta;
            case 148:
                return R.drawable.flag_mauritius;
            case 149:
                return R.drawable.flag_maldives;
            case 150:
                return R.drawable.flag_malawi;
            case 151:
                return R.drawable.flag_mexico;
            case 152:
                return R.drawable.flag_malaysia;
            case 153:
                return R.drawable.flag_mozambique;
            case 154:
                return R.drawable.flag_namibia;
            case 155:
                return R.drawable.flag_new_caledonia;
            case 156:
                return R.drawable.flag_niger;
            case 157:
                return R.drawable.flag_norfolk_island;
            case 158:
                return R.drawable.flag_nigeria;
            case 159:
                return R.drawable.flag_nicaragua;
            case 160:
                return R.drawable.flag_netherlands;
            case 161:
                return R.drawable.flag_norway;
            case 162:
                return R.drawable.flag_nepal;
            case 163:
                return R.drawable.flag_nauru;
            case 164:
                return R.drawable.flag_niue;
            case 165:
                return R.drawable.flag_new_zealand;
            case 166:
                return R.drawable.flag_oman;
            case ByteCode.GOTO /* 167 */:
                return R.drawable.flag_panama;
            case 168:
                return R.drawable.flag_peru;
            case ByteCode.RET /* 169 */:
                return R.drawable.flag_french_polynesia;
            case 170:
                return R.drawable.flag_papua_new_guinea;
            case ByteCode.LOOKUPSWITCH /* 171 */:
                return R.drawable.flag_philippines;
            case 172:
                return R.drawable.flag_pakistan;
            case ByteCode.LRETURN /* 173 */:
                return R.drawable.flag_poland;
            case ByteCode.FRETURN /* 174 */:
                return R.drawable.flag_saint_pierre;
            case ByteCode.DRETURN /* 175 */:
                return R.drawable.flag_pitcairn_islands;
            case ByteCode.ARETURN /* 176 */:
                return R.drawable.flag_puerto_rico;
            case ByteCode.RETURN /* 177 */:
                return R.drawable.flag_palestine;
            case ByteCode.GETSTATIC /* 178 */:
                return R.drawable.flag_portugal;
            case ByteCode.PUTSTATIC /* 179 */:
                return R.drawable.flag_palau;
            case 180:
                return R.drawable.flag_paraguay;
            case ByteCode.PUTFIELD /* 181 */:
                return R.drawable.flag_qatar;
            case ByteCode.INVOKEVIRTUAL /* 182 */:
                return R.drawable.flag_martinique;
            case ByteCode.INVOKESPECIAL /* 183 */:
                return R.drawable.flag_romania;
            case ByteCode.INVOKESTATIC /* 184 */:
                return R.drawable.flag_serbia;
            case ByteCode.INVOKEINTERFACE /* 185 */:
                return R.drawable.flag_russian_federation;
            case ByteCode.INVOKEDYNAMIC /* 186 */:
                return R.drawable.flag_rwanda;
            case ByteCode.NEW /* 187 */:
                return R.drawable.flag_saudi_arabia;
            case 188:
                return R.drawable.flag_soloman_islands;
            case 189:
                return R.drawable.flag_seychelles;
            case 190:
                return R.drawable.flag_sudan;
            case ByteCode.ATHROW /* 191 */:
                return R.drawable.flag_sweden;
            case 192:
                return R.drawable.flag_singapore;
            case ByteCode.INSTANCEOF /* 193 */:
                return R.drawable.flag_saint_helena;
            case ByteCode.MONITORENTER /* 194 */:
                return R.drawable.flag_slovenia;
            case ByteCode.MONITOREXIT /* 195 */:
                return R.drawable.flag_slovakia;
            case ByteCode.WIDE /* 196 */:
                return R.drawable.flag_sierra_leone;
            case ByteCode.MULTIANEWARRAY /* 197 */:
                return R.drawable.flag_san_marino;
            case ByteCode.IFNULL /* 198 */:
                return R.drawable.flag_senegal;
            case ByteCode.IFNONNULL /* 199 */:
                return R.drawable.flag_somalia;
            case 200:
                return R.drawable.flag_suriname;
            case 201:
                return R.drawable.flag_south_sudan;
            case 202:
                return R.drawable.flag_sao_tome_and_principe;
            case 203:
                return R.drawable.flag_el_salvador;
            case 204:
                return R.drawable.flag_sint_maarten;
            case HttpStatus.SC_RESET_CONTENT /* 205 */:
                return R.drawable.flag_syria;
            case 206:
                return R.drawable.flag_swaziland;
            case 207:
                return R.drawable.flag_turks_and_caicos_islands;
            case 208:
                return R.drawable.flag_chad;
            case 209:
                return R.drawable.flag_togo;
            case 210:
                return R.drawable.flag_thailand;
            case Primes.SMALL_FACTOR_LIMIT /* 211 */:
                return R.drawable.flag_tajikistan;
            case 212:
                return R.drawable.flag_tokelau;
            case 213:
                return R.drawable.flag_timor_leste;
            case 214:
                return R.drawable.flag_turkmenistan;
            case 215:
                return R.drawable.flag_tunisia;
            case 216:
                return R.drawable.flag_tonga;
            case 217:
                return R.drawable.flag_turkey;
            case 218:
                return R.drawable.flag_trinidad_and_tobago;
            case 219:
                return R.drawable.flag_tuvalu;
            case 220:
                return R.drawable.flag_taiwan;
            case easypay.appinvoke.manager.Constants.EASY_PAY_MINIMIZE_ASSIST /* 221 */:
                return R.drawable.flag_tanzania;
            case easypay.appinvoke.manager.Constants.EASY_PAY_MAXIMIZE_ASSIST /* 222 */:
                return R.drawable.flag_ukraine;
            case 223:
                return R.drawable.flag_uganda;
            case 224:
                return R.drawable.flag_united_states_of_america;
            case 225:
                return R.drawable.flag_uruguay;
            case 226:
                return R.drawable.flag_uzbekistan;
            case 227:
                return R.drawable.flag_vatican_city;
            case 228:
                return R.drawable.flag_saint_vicent_and_the_grenadines;
            case 229:
                return R.drawable.flag_venezuela;
            case 230:
                return R.drawable.flag_british_virgin_islands;
            case 231:
                return R.drawable.flag_us_virgin_islands;
            case 232:
                return R.drawable.flag_vietnam;
            case 233:
                return R.drawable.flag_vanuatu;
            case 234:
                return R.drawable.flag_wallis_and_futuna;
            case 235:
                return R.drawable.flag_samoa;
            case 236:
                return R.drawable.flag_kosovo;
            case 237:
                return R.drawable.flag_yemen;
            case 238:
                return R.drawable.flag_martinique;
            case 239:
                return R.drawable.flag_south_africa;
            case 240:
                return R.drawable.flag_zambia;
            case 241:
                return R.drawable.flag_zimbabwe;
            default:
                return R.drawable.flag_transparent;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static String getFlagEmoji(CCPCountry CCPCountry) {
        String lowerCase = CCPCountry.getNameCode().toLowerCase();
        lowerCase.hashCode();
        byte b2 = -1;
        switch (lowerCase.hashCode()) {
            case 3107:
                if (lowerCase.equals("ad")) {
                    b2 = 0;
                }
                break;
            case 3108:
                if (lowerCase.equals("ae")) {
                    b2 = 1;
                }
                break;
            case 3109:
                if (lowerCase.equals("af")) {
                    b2 = 2;
                }
                break;
            case 3110:
                if (lowerCase.equals("ag")) {
                    b2 = 3;
                }
                break;
            case 3112:
                if (lowerCase.equals("ai")) {
                    b2 = 4;
                }
                break;
            case 3115:
                if (lowerCase.equals("al")) {
                    b2 = 5;
                }
                break;
            case 3116:
                if (lowerCase.equals("am")) {
                    b2 = 6;
                }
                break;
            case 3118:
                if (lowerCase.equals("ao")) {
                    b2 = 7;
                }
                break;
            case 3120:
                if (lowerCase.equals("aq")) {
                    b2 = 8;
                }
                break;
            case 3121:
                if (lowerCase.equals("ar")) {
                    b2 = 9;
                }
                break;
            case 3122:
                if (lowerCase.equals("as")) {
                    b2 = 10;
                }
                break;
            case 3123:
                if (lowerCase.equals(DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_AT)) {
                    b2 = 11;
                }
                break;
            case 3124:
                if (lowerCase.equals("au")) {
                    b2 = 12;
                }
                break;
            case 3126:
                if (lowerCase.equals("aw")) {
                    b2 = 13;
                }
                break;
            case 3127:
                if (lowerCase.equals("ax")) {
                    b2 = 14;
                }
                break;
            case 3129:
                if (lowerCase.equals("az")) {
                    b2 = Ascii.SI;
                }
                break;
            case 3135:
                if (lowerCase.equals("ba")) {
                    b2 = 16;
                }
                break;
            case 3136:
                if (lowerCase.equals("bb")) {
                    b2 = 17;
                }
                break;
            case 3138:
                if (lowerCase.equals("bd")) {
                    b2 = Ascii.DC2;
                }
                break;
            case 3139:
                if (lowerCase.equals("be")) {
                    b2 = 19;
                }
                break;
            case 3140:
                if (lowerCase.equals("bf")) {
                    b2 = Ascii.DC4;
                }
                break;
            case 3141:
                if (lowerCase.equals(Constants.KEY_BG)) {
                    b2 = Ascii.NAK;
                }
                break;
            case 3142:
                if (lowerCase.equals("bh")) {
                    b2 = Ascii.SYN;
                }
                break;
            case 3143:
                if (lowerCase.equals("bi")) {
                    b2 = Ascii.ETB;
                }
                break;
            case 3144:
                if (lowerCase.equals("bj")) {
                    b2 = Ascii.CAN;
                }
                break;
            case 3146:
                if (lowerCase.equals(CmcdConfiguration.KEY_BUFFER_LENGTH)) {
                    b2 = Ascii.EM;
                }
                break;
            case 3147:
                if (lowerCase.equals("bm")) {
                    b2 = Ascii.SUB;
                }
                break;
            case 3148:
                if (lowerCase.equals("bn")) {
                    b2 = Ascii.ESC;
                }
                break;
            case 3149:
                if (lowerCase.equals("bo")) {
                    b2 = Ascii.FS;
                }
                break;
            case 3151:
                if (lowerCase.equals("bq")) {
                    b2 = Ascii.GS;
                }
                break;
            case 3152:
                if (lowerCase.equals("br")) {
                    b2 = Ascii.RS;
                }
                break;
            case 3153:
                if (lowerCase.equals(CmcdConfiguration.KEY_BUFFER_STARVATION)) {
                    b2 = Ascii.US;
                }
                break;
            case 3154:
                if (lowerCase.equals("bt")) {
                    b2 = 32;
                }
                break;
            case 3156:
                if (lowerCase.equals("bv")) {
                    b2 = 33;
                }
                break;
            case 3157:
                if (lowerCase.equals("bw")) {
                    b2 = 34;
                }
                break;
            case 3159:
                if (lowerCase.equals(StanzaIdElement.ATTR_BY)) {
                    b2 = 35;
                }
                break;
            case 3160:
                if (lowerCase.equals("bz")) {
                    b2 = 36;
                }
                break;
            case 3166:
                if (lowerCase.equals("ca")) {
                    b2 = 37;
                }
                break;
            case 3168:
                if (lowerCase.equals("cc")) {
                    b2 = 38;
                }
                break;
            case 3169:
                if (lowerCase.equals("cd")) {
                    b2 = 39;
                }
                break;
            case 3171:
                if (lowerCase.equals("cf")) {
                    b2 = 40;
                }
                break;
            case 3172:
                if (lowerCase.equals("cg")) {
                    b2 = 41;
                }
                break;
            case 3173:
                if (lowerCase.equals("ch")) {
                    b2 = 42;
                }
                break;
            case 3174:
                if (lowerCase.equals("ci")) {
                    b2 = 43;
                }
                break;
            case 3176:
                if (lowerCase.equals("ck")) {
                    b2 = 44;
                }
                break;
            case 3177:
                if (lowerCase.equals("cl")) {
                    b2 = 45;
                }
                break;
            case 3178:
                if (lowerCase.equals("cm")) {
                    b2 = 46;
                }
                break;
            case 3179:
                if (lowerCase.equals("cn")) {
                    b2 = 47;
                }
                break;
            case 3180:
                if (lowerCase.equals("co")) {
                    b2 = 48;
                }
                break;
            case 3183:
                if (lowerCase.equals("cr")) {
                    b2 = 49;
                }
                break;
            case 3186:
                if (lowerCase.equals("cu")) {
                    b2 = 50;
                }
                break;
            case 3187:
                if (lowerCase.equals("cv")) {
                    b2 = 51;
                }
                break;
            case 3188:
                if (lowerCase.equals("cw")) {
                    b2 = 52;
                }
                break;
            case 3189:
                if (lowerCase.equals("cx")) {
                    b2 = 53;
                }
                break;
            case 3190:
                if (lowerCase.equals("cy")) {
                    b2 = 54;
                }
                break;
            case 3191:
                if (lowerCase.equals("cz")) {
                    b2 = 55;
                }
                break;
            case 3201:
                if (lowerCase.equals("de")) {
                    b2 = 56;
                }
                break;
            case 3206:
                if (lowerCase.equals("dj")) {
                    b2 = 57;
                }
                break;
            case 3207:
                if (lowerCase.equals(Constants.INAPP_NOTIF_DARKEN_SCREEN)) {
                    b2 = 58;
                }
                break;
            case 3209:
                if (lowerCase.equals("dm")) {
                    b2 = 59;
                }
                break;
            case 3211:
                if (lowerCase.equals("do")) {
                    b2 = 60;
                }
                break;
            case 3222:
                if (lowerCase.equals("dz")) {
                    b2 = Base64.padSymbol;
                }
                break;
            case 3230:
                if (lowerCase.equals("ec")) {
                    b2 = 62;
                }
                break;
            case 3232:
                if (lowerCase.equals("ee")) {
                    b2 = Utf8.REPLACEMENT_BYTE;
                }
                break;
            case 3234:
                if (lowerCase.equals("eg")) {
                    b2 = 64;
                }
                break;
            case 3235:
                if (lowerCase.equals("eh")) {
                    b2 = 65;
                }
                break;
            case 3245:
                if (lowerCase.equals("er")) {
                    b2 = 66;
                }
                break;
            case 3246:
                if (lowerCase.equals("es")) {
                    b2 = 67;
                }
                break;
            case 3247:
                if (lowerCase.equals("et")) {
                    b2 = 68;
                }
                break;
            case 3267:
                if (lowerCase.equals("fi")) {
                    b2 = 69;
                }
                break;
            case 3268:
                if (lowerCase.equals("fj")) {
                    b2 = 70;
                }
                break;
            case 3269:
                if (lowerCase.equals("fk")) {
                    b2 = 71;
                }
                break;
            case 3271:
                if (lowerCase.equals("fm")) {
                    b2 = 72;
                }
                break;
            case 3273:
                if (lowerCase.equals("fo")) {
                    b2 = 73;
                }
                break;
            case 3276:
                if (lowerCase.equals("fr")) {
                    b2 = 74;
                }
                break;
            case 3290:
                if (lowerCase.equals("ga")) {
                    b2 = 75;
                }
                break;
            case 3291:
                if (lowerCase.equals("gb")) {
                    b2 = 76;
                }
                break;
            case 3293:
                if (lowerCase.equals("gd")) {
                    b2 = 77;
                }
                break;
            case 3294:
                if (lowerCase.equals(UserDataStore.GENDER)) {
                    b2 = 78;
                }
                break;
            case 3295:
                if (lowerCase.equals("gf")) {
                    b2 = 79;
                }
                break;
            case 3296:
                if (lowerCase.equals("gg")) {
                    b2 = 80;
                }
                break;
            case 3297:
                if (lowerCase.equals("gh")) {
                    b2 = 81;
                }
                break;
            case 3298:
                if (lowerCase.equals("gi")) {
                    b2 = 82;
                }
                break;
            case 3301:
                if (lowerCase.equals("gl")) {
                    b2 = 83;
                }
                break;
            case 3302:
                if (lowerCase.equals("gm")) {
                    b2 = 84;
                }
                break;
            case 3303:
                if (lowerCase.equals("gn")) {
                    b2 = 85;
                }
                break;
            case 3305:
                if (lowerCase.equals("gp")) {
                    b2 = 86;
                }
                break;
            case 3306:
                if (lowerCase.equals("gq")) {
                    b2 = 87;
                }
                break;
            case 3307:
                if (lowerCase.equals("gr")) {
                    b2 = 88;
                }
                break;
            case 3308:
                if (lowerCase.equals("gs")) {
                    b2 = 89;
                }
                break;
            case 3309:
                if (lowerCase.equals("gt")) {
                    b2 = 90;
                }
                break;
            case 3310:
                if (lowerCase.equals("gu")) {
                    b2 = 91;
                }
                break;
            case 3312:
                if (lowerCase.equals("gw")) {
                    b2 = 92;
                }
                break;
            case 3314:
                if (lowerCase.equals("gy")) {
                    b2 = 93;
                }
                break;
            case 3331:
                if (lowerCase.equals("hk")) {
                    b2 = 94;
                }
                break;
            case com.appnew.android.home.Constants.MIGRATED_DOWNLOAD_ID /* 3333 */:
                if (lowerCase.equals("hm")) {
                    b2 = 95;
                }
                break;
            case 3334:
                if (lowerCase.equals("hn")) {
                    b2 = 96;
                }
                break;
            case 3338:
                if (lowerCase.equals("hr")) {
                    b2 = 97;
                }
                break;
            case 3340:
                if (lowerCase.equals("ht")) {
                    b2 = 98;
                }
                break;
            case 3341:
                if (lowerCase.equals("hu")) {
                    b2 = 99;
                }
                break;
            case 3355:
                if (lowerCase.equals("id")) {
                    b2 = 100;
                }
                break;
            case 3356:
                if (lowerCase.equals("ie")) {
                    b2 = 101;
                }
                break;
            case 3363:
                if (lowerCase.equals("il")) {
                    b2 = 102;
                }
                break;
            case 3364:
                if (lowerCase.equals("im")) {
                    b2 = 103;
                }
                break;
            case 3365:
                if (lowerCase.equals("in")) {
                    b2 = 104;
                }
                break;
            case 3366:
                if (lowerCase.equals("io")) {
                    b2 = 105;
                }
                break;
            case 3368:
                if (lowerCase.equals(IQ.IQ_ELEMENT)) {
                    b2 = 106;
                }
                break;
            case 3369:
                if (lowerCase.equals("ir")) {
                    b2 = 107;
                }
                break;
            case 3370:
                if (lowerCase.equals("is")) {
                    b2 = 108;
                }
                break;
            case 3371:
                if (lowerCase.equals("it")) {
                    b2 = 109;
                }
                break;
            case 3387:
                if (lowerCase.equals("je")) {
                    b2 = 110;
                }
                break;
            case 3395:
                if (lowerCase.equals("jm")) {
                    b2 = 111;
                }
                break;
            case 3397:
                if (lowerCase.equals("jo")) {
                    b2 = 112;
                }
                break;
            case 3398:
                if (lowerCase.equals("jp")) {
                    b2 = 113;
                }
                break;
            case 3418:
                if (lowerCase.equals("ke")) {
                    b2 = 114;
                }
                break;
            case 3420:
                if (lowerCase.equals("kg")) {
                    b2 = 115;
                }
                break;
            case 3421:
                if (lowerCase.equals("kh")) {
                    b2 = 116;
                }
                break;
            case 3422:
                if (lowerCase.equals("ki")) {
                    b2 = 117;
                }
                break;
            case 3426:
                if (lowerCase.equals("km")) {
                    b2 = 118;
                }
                break;
            case 3427:
                if (lowerCase.equals("kn")) {
                    b2 = 119;
                }
                break;
            case 3429:
                if (lowerCase.equals("kp")) {
                    b2 = 120;
                }
                break;
            case 3431:
                if (lowerCase.equals("kr")) {
                    b2 = 121;
                }
                break;
            case 3436:
                if (lowerCase.equals("kw")) {
                    b2 = 122;
                }
                break;
            case 3438:
                if (lowerCase.equals("ky")) {
                    b2 = 123;
                }
                break;
            case 3439:
                if (lowerCase.equals("kz")) {
                    b2 = 124;
                }
                break;
            case 3445:
                if (lowerCase.equals("la")) {
                    b2 = 125;
                }
                break;
            case 3446:
                if (lowerCase.equals("lb")) {
                    b2 = 126;
                }
                break;
            case 3447:
                if (lowerCase.equals("lc")) {
                    b2 = 127;
                }
                break;
            case 3453:
                if (lowerCase.equals("li")) {
                    b2 = 128;
                }
                break;
            case 3455:
                if (lowerCase.equals("lk")) {
                    b2 = 129;
                }
                break;
            case 3462:
                if (lowerCase.equals("lr")) {
                    b2 = 130;
                }
                break;
            case 3463:
                if (lowerCase.equals("ls")) {
                    b2 = 131;
                }
                break;
            case 3464:
                if (lowerCase.equals("lt")) {
                    b2 = 132;
                }
                break;
            case 3465:
                if (lowerCase.equals("lu")) {
                    b2 = 133;
                }
                break;
            case 3466:
                if (lowerCase.equals("lv")) {
                    b2 = 134;
                }
                break;
            case 3469:
                if (lowerCase.equals("ly")) {
                    b2 = 135;
                }
                break;
            case 3476:
                if (lowerCase.equals("ma")) {
                    b2 = 136;
                }
                break;
            case 3478:
                if (lowerCase.equals("mc")) {
                    b2 = 137;
                }
                break;
            case 3479:
                if (lowerCase.equals("md")) {
                    b2 = 138;
                }
                break;
            case 3480:
                if (lowerCase.equals(TournamentShareDialogURIBuilder.f586me)) {
                    b2 = 139;
                }
                break;
            case 3481:
                if (lowerCase.equals("mf")) {
                    b2 = 140;
                }
                break;
            case 3482:
                if (lowerCase.equals("mg")) {
                    b2 = 141;
                }
                break;
            case 3483:
                if (lowerCase.equals("mh")) {
                    b2 = 142;
                }
                break;
            case 3486:
                if (lowerCase.equals("mk")) {
                    b2 = 143;
                }
                break;
            case 3487:
                if (lowerCase.equals("ml")) {
                    b2 = 144;
                }
                break;
            case 3488:
                if (lowerCase.equals("mm")) {
                    b2 = 145;
                }
                break;
            case 3489:
                if (lowerCase.equals("mn")) {
                    b2 = 146;
                }
                break;
            case 3490:
                if (lowerCase.equals("mo")) {
                    b2 = 147;
                }
                break;
            case 3491:
                if (lowerCase.equals("mp")) {
                    b2 = 148;
                }
                break;
            case 3492:
                if (lowerCase.equals("mq")) {
                    b2 = 149;
                }
                break;
            case 3493:
                if (lowerCase.equals("mr")) {
                    b2 = 150;
                }
                break;
            case 3494:
                if (lowerCase.equals("ms")) {
                    b2 = 151;
                }
                break;
            case 3495:
                if (lowerCase.equals("mt")) {
                    b2 = 152;
                }
                break;
            case 3496:
                if (lowerCase.equals("mu")) {
                    b2 = 153;
                }
                break;
            case 3497:
                if (lowerCase.equals("mv")) {
                    b2 = 154;
                }
                break;
            case 3498:
                if (lowerCase.equals("mw")) {
                    b2 = 155;
                }
                break;
            case 3499:
                if (lowerCase.equals("mx")) {
                    b2 = 156;
                }
                break;
            case 3500:
                if (lowerCase.equals("my")) {
                    b2 = 157;
                }
                break;
            case 3501:
                if (lowerCase.equals("mz")) {
                    b2 = 158;
                }
                break;
            case 3507:
                if (lowerCase.equals("na")) {
                    b2 = 159;
                }
                break;
            case 3509:
                if (lowerCase.equals("nc")) {
                    b2 = 160;
                }
                break;
            case 3511:
                if (lowerCase.equals("ne")) {
                    b2 = 161;
                }
                break;
            case 3512:
                if (lowerCase.equals("nf")) {
                    b2 = 162;
                }
                break;
            case 3513:
                if (lowerCase.equals("ng")) {
                    b2 = 163;
                }
                break;
            case 3515:
                if (lowerCase.equals("ni")) {
                    b2 = 164;
                }
                break;
            case 3518:
                if (lowerCase.equals("nl")) {
                    b2 = 165;
                }
                break;
            case 3521:
                if (lowerCase.equals("no")) {
                    b2 = 166;
                }
                break;
            case 3522:
                if (lowerCase.equals("np")) {
                    b2 = 167;
                }
                break;
            case 3524:
                if (lowerCase.equals(Base64BinaryChunk.ATTRIBUTE_NR)) {
                    b2 = 168;
                }
                break;
            case 3527:
                if (lowerCase.equals("nu")) {
                    b2 = 169;
                }
                break;
            case 3532:
                if (lowerCase.equals("nz")) {
                    b2 = 170;
                }
                break;
            case 3550:
                if (lowerCase.equals("om")) {
                    b2 = 171;
                }
                break;
            case 3569:
                if (lowerCase.equals("pa")) {
                    b2 = 172;
                }
                break;
            case 3573:
                if (lowerCase.equals("pe")) {
                    b2 = 173;
                }
                break;
            case 3574:
                if (lowerCase.equals("pf")) {
                    b2 = 174;
                }
                break;
            case 3575:
                if (lowerCase.equals("pg")) {
                    b2 = 175;
                }
                break;
            case 3576:
                if (lowerCase.equals(UserDataStore.PHONE)) {
                    b2 = 176;
                }
                break;
            case 3579:
                if (lowerCase.equals("pk")) {
                    b2 = 177;
                }
                break;
            case 3580:
                if (lowerCase.equals("pl")) {
                    b2 = 178;
                }
                break;
            case 3581:
                if (lowerCase.equals("pm")) {
                    b2 = 179;
                }
                break;
            case 3582:
                if (lowerCase.equals("pn")) {
                    b2 = 180;
                }
                break;
            case 3586:
                if (lowerCase.equals("pr")) {
                    b2 = 181;
                }
                break;
            case 3587:
                if (lowerCase.equals("ps")) {
                    b2 = 182;
                }
                break;
            case 3588:
                if (lowerCase.equals(DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_PT)) {
                    b2 = 183;
                }
                break;
            case 3591:
                if (lowerCase.equals("pw")) {
                    b2 = 184;
                }
                break;
            case 3593:
                if (lowerCase.equals("py")) {
                    b2 = 185;
                }
                break;
            case 3600:
                if (lowerCase.equals("qa")) {
                    b2 = 186;
                }
                break;
            case 3635:
                if (lowerCase.equals("re")) {
                    b2 = 187;
                }
                break;
            case 3645:
                if (lowerCase.equals("ro")) {
                    b2 = PSSSigner.TRAILER_IMPLICIT;
                }
                break;
            case 3649:
                if (lowerCase.equals("rs")) {
                    b2 = 189;
                }
                break;
            case 3651:
                if (lowerCase.equals("ru")) {
                    b2 = 190;
                }
                break;
            case 3653:
                if (lowerCase.equals("rw")) {
                    b2 = 191;
                }
                break;
            case 3662:
                if (lowerCase.equals("sa")) {
                    b2 = 192;
                }
                break;
            case 3663:
                if (lowerCase.equals("sb")) {
                    b2 = 193;
                }
                break;
            case 3664:
                if (lowerCase.equals(Constants.INAPP_NOTIF_SHOW_CLOSE)) {
                    b2 = 194;
                }
                break;
            case 3665:
                if (lowerCase.equals(DynamicLink.SocialMetaTagParameters.KEY_SOCIAL_DESCRIPTION)) {
                    b2 = 195;
                }
                break;
            case 3666:
                if (lowerCase.equals("se")) {
                    b2 = 196;
                }
                break;
            case 3668:
                if (lowerCase.equals("sg")) {
                    b2 = 197;
                }
                break;
            case 3669:
                if (lowerCase.equals("sh")) {
                    b2 = 198;
                }
                break;
            case 3670:
                if (lowerCase.equals("si")) {
                    b2 = 199;
                }
                break;
            case 3671:
                if (lowerCase.equals("sj")) {
                    b2 = 200;
                }
                break;
            case 3672:
                if (lowerCase.equals("sk")) {
                    b2 = 201;
                }
                break;
            case 3673:
                if (lowerCase.equals("sl")) {
                    b2 = 202;
                }
                break;
            case 3674:
                if (lowerCase.equals(StreamManagement.StreamManagementFeature.ELEMENT)) {
                    b2 = 203;
                }
                break;
            case 3675:
                if (lowerCase.equals("sn")) {
                    b2 = 204;
                }
                break;
            case 3676:
                if (lowerCase.equals("so")) {
                    b2 = 205;
                }
                break;
            case 3679:
                if (lowerCase.equals("sr")) {
                    b2 = 206;
                }
                break;
            case 3680:
                if (lowerCase.equals(Constants.KEY_ENCRYPTION_INAPP_SS)) {
                    b2 = 207;
                }
                break;
            case 3681:
                if (lowerCase.equals("st")) {
                    b2 = 208;
                }
                break;
            case 3683:
                if (lowerCase.equals("sv")) {
                    b2 = 209;
                }
                break;
            case 3685:
                if (lowerCase.equals("sx")) {
                    b2 = 210;
                }
                break;
            case 3686:
                if (lowerCase.equals("sy")) {
                    b2 = 211;
                }
                break;
            case 3687:
                if (lowerCase.equals("sz")) {
                    b2 = 212;
                }
                break;
            case 3695:
                if (lowerCase.equals("tc")) {
                    b2 = 213;
                }
                break;
            case 3696:
                if (lowerCase.equals("td")) {
                    b2 = 214;
                }
                break;
            case 3698:
                if (lowerCase.equals("tf")) {
                    b2 = 215;
                }
                break;
            case 3699:
                if (lowerCase.equals("tg")) {
                    b2 = 216;
                }
                break;
            case 3700:
                if (lowerCase.equals("th")) {
                    b2 = 217;
                }
                break;
            case 3702:
                if (lowerCase.equals("tj")) {
                    b2 = 218;
                }
                break;
            case 3703:
                if (lowerCase.equals("tk")) {
                    b2 = 219;
                }
                break;
            case 3704:
                if (lowerCase.equals("tl")) {
                    b2 = 220;
                }
                break;
            case 3705:
                if (lowerCase.equals("tm")) {
                    b2 = 221;
                }
                break;
            case 3706:
                if (lowerCase.equals("tn")) {
                    b2 = 222;
                }
                break;
            case 3707:
                if (lowerCase.equals("to")) {
                    b2 = 223;
                }
                break;
            case 3710:
                if (lowerCase.equals("tr")) {
                    b2 = 224;
                }
                break;
            case 3712:
                if (lowerCase.equals("tt")) {
                    b2 = 225;
                }
                break;
            case 3714:
                if (lowerCase.equals("tv")) {
                    b2 = 226;
                }
                break;
            case 3715:
                if (lowerCase.equals("tw")) {
                    b2 = 227;
                }
                break;
            case 3718:
                if (lowerCase.equals("tz")) {
                    b2 = 228;
                }
                break;
            case 3724:
                if (lowerCase.equals("ua")) {
                    b2 = 229;
                }
                break;
            case 3730:
                if (lowerCase.equals("ug")) {
                    b2 = 230;
                }
                break;
            case 3736:
                if (lowerCase.equals("um")) {
                    b2 = 231;
                }
                break;
            case 3742:
                if (lowerCase.equals("us")) {
                    b2 = 232;
                }
                break;
            case 3748:
                if (lowerCase.equals("uy")) {
                    b2 = 233;
                }
                break;
            case 3749:
                if (lowerCase.equals("uz")) {
                    b2 = 234;
                }
                break;
            case 3755:
                if (lowerCase.equals("va")) {
                    b2 = 235;
                }
                break;
            case 3757:
                if (lowerCase.equals("vc")) {
                    b2 = 236;
                }
                break;
            case 3759:
                if (lowerCase.equals("ve")) {
                    b2 = 237;
                }
                break;
            case 3761:
                if (lowerCase.equals("vg")) {
                    b2 = 238;
                }
                break;
            case 3763:
                if (lowerCase.equals("vi")) {
                    b2 = 239;
                }
                break;
            case 3768:
                if (lowerCase.equals("vn")) {
                    b2 = 240;
                }
                break;
            case 3775:
                if (lowerCase.equals("vu")) {
                    b2 = 241;
                }
                break;
            case 3791:
                if (lowerCase.equals("wf")) {
                    b2 = 242;
                }
                break;
            case 3804:
                if (lowerCase.equals("ws")) {
                    b2 = 243;
                }
                break;
            case 3827:
                if (lowerCase.equals("xk")) {
                    b2 = 244;
                }
                break;
            case 3852:
                if (lowerCase.equals("ye")) {
                    b2 = 245;
                }
                break;
            case 3867:
                if (lowerCase.equals("yt")) {
                    b2 = 246;
                }
                break;
            case 3879:
                if (lowerCase.equals("za")) {
                    b2 = 247;
                }
                break;
            case 3891:
                if (lowerCase.equals("zm")) {
                    b2 = 248;
                }
                break;
            case 3901:
                if (lowerCase.equals("zw")) {
                    b2 = 249;
                }
                break;
        }
        switch (b2) {
            case 0:
                return "🇦🇩";
            case 1:
                return "🇦🇪";
            case 2:
                return "🇦🇫";
            case 3:
                return "🇦🇬";
            case 4:
                return "🇦🇮";
            case 5:
                return "🇦🇱";
            case 6:
                return "🇦🇲";
            case 7:
                return "🇦🇴";
            case 8:
                return "🇦🇶";
            case 9:
                return "🇦🇷";
            case 10:
                return "🇦🇸";
            case 11:
                return "🇦🇹";
            case 12:
                return "🇦🇺";
            case 13:
                return "🇦🇼";
            case 14:
                return "🇦🇽";
            case 15:
                return "🇦🇿";
            case 16:
                return "🇧🇦";
            case 17:
                return "🇧🇧";
            case 18:
                return "🇧🇩";
            case 19:
                return "🇧🇪";
            case 20:
                return "🇧🇫";
            case 21:
                return "🇧🇬";
            case 22:
                return "🇧🇭";
            case 23:
                return "🇧🇮";
            case 24:
                return "🇧🇯";
            case 25:
                return "🇧🇱";
            case 26:
                return "🇧🇲";
            case 27:
                return "🇧🇳";
            case 28:
                return "🇧🇴";
            case 29:
                return "🇧🇶";
            case 30:
                return "🇧🇷";
            case 31:
                return "🇧🇸";
            case 32:
                return "🇧🇹";
            case 33:
                return "🇧🇻";
            case 34:
                return "🇧🇼";
            case 35:
                return "🇧🇾";
            case 36:
                return "🇧🇿";
            case 37:
                return "🇨🇦";
            case 38:
                return "🇨🇨";
            case 39:
                return "🇨🇩";
            case 40:
                return "🇨🇫";
            case 41:
                return "🇨🇬";
            case 42:
                return "🇨🇭";
            case 43:
                return "🇨🇮";
            case 44:
                return "🇨🇰";
            case 45:
                return "🇨🇱";
            case 46:
                return "🇨🇲";
            case 47:
                return "🇨🇳";
            case 48:
                return "🇨🇴";
            case 49:
                return "🇨🇷";
            case 50:
                return "🇨🇺";
            case 51:
                return "🇨🇻";
            case 52:
                return "🇨🇼";
            case 53:
                return "🇨🇽";
            case 54:
                return "🇨🇾";
            case 55:
                return "🇨🇿";
            case 56:
                return "🇩🇪";
            case 57:
                return "🇩🇯";
            case 58:
                return "🇩🇰";
            case 59:
                return "🇩🇲";
            case 60:
                return "🇩🇴";
            case 61:
                return "🇩🇿";
            case 62:
                return "🇪🇨";
            case 63:
                return "🇪🇪";
            case 64:
                return "🇪🇬";
            case 65:
                return "🇪🇭";
            case 66:
                return "🇪🇷";
            case 67:
                return "🇪🇸";
            case 68:
                return "🇪🇹";
            case 69:
                return "🇫🇮";
            case 70:
                return "🇫🇯";
            case 71:
                return "🇫🇰";
            case 72:
                return "🇫🇲";
            case 73:
                return "🇫🇴";
            case 74:
                return "🇫🇷";
            case 75:
                return "🇬🇦";
            case 76:
                return "🇬🇧";
            case 77:
                return "🇬🇩";
            case 78:
                return "🇬🇪";
            case 79:
                return "🇬🇫";
            case 80:
                return "🇬🇬";
            case 81:
                return "🇬🇭";
            case 82:
                return "🇬🇮";
            case 83:
                return "🇬🇱";
            case 84:
                return "🇬🇲";
            case 85:
                return "🇬🇳";
            case 86:
                return "🇬🇵";
            case 87:
                return "🇬🇶";
            case 88:
                return "🇬🇷";
            case 89:
                return "🇬🇸";
            case 90:
                return "🇬🇹";
            case 91:
                return "🇬🇺";
            case 92:
                return "🇬🇼";
            case 93:
                return "🇬🇾";
            case 94:
                return "🇭🇰";
            case 95:
                return "🇭🇲";
            case 96:
                return "🇭🇳";
            case 97:
                return "🇭🇷";
            case 98:
                return "🇭🇹";
            case 99:
                return "🇭🇺";
            case 100:
                return "🇮🇩";
            case 101:
                return "🇮🇪";
            case 102:
                return "🇮🇱";
            case 103:
                return "🇮🇲";
            case 104:
                return "🇮🇳";
            case 105:
                return "🇮🇴";
            case 106:
                return "🇮🇶";
            case 107:
                return "🇮🇷";
            case 108:
                return "🇮🇸";
            case 109:
                return "🇮🇹";
            case 110:
                return "🇯🇪";
            case 111:
                return "🇯🇲";
            case 112:
                return "🇯🇴";
            case 113:
                return "🇯🇵";
            case 114:
                return "🇰🇪";
            case 115:
                return "🇰🇬";
            case 116:
                return "🇰🇭";
            case 117:
                return "🇰🇮";
            case 118:
                return "🇰🇲";
            case 119:
                return "🇰🇳";
            case 120:
                return "🇰🇵";
            case 121:
                return "🇰🇷";
            case 122:
                return "🇰🇼";
            case 123:
                return "🇰🇾";
            case 124:
                return "🇰🇿";
            case 125:
                return "🇱🇦";
            case 126:
                return "🇱🇧";
            case 127:
                return "🇱🇨";
            case 128:
                return "🇱🇮";
            case 129:
                return "🇱🇰";
            case 130:
                return "🇱🇷";
            case 131:
                return "🇱🇸";
            case 132:
                return "🇱🇹";
            case 133:
                return "🇱🇺";
            case 134:
                return "🇱🇻";
            case 135:
                return "🇱🇾";
            case 136:
                return "🇲🇦";
            case 137:
                return "🇲🇨";
            case 138:
                return "🇲🇩";
            case 139:
                return "🇲🇪";
            case 140:
                return "🇲🇫";
            case 141:
                return "🇲🇬";
            case 142:
                return "🇲🇭";
            case 143:
                return "🇲🇰";
            case 144:
                return "🇲🇱";
            case 145:
                return "🇲🇲";
            case 146:
                return "🇲🇳";
            case 147:
                return "🇲🇴";
            case 148:
                return "🇲🇵";
            case 149:
                return "🇲🇶";
            case 150:
                return "🇲🇷";
            case 151:
                return "🇲🇸";
            case 152:
                return "🇲🇹";
            case 153:
                return "🇲🇺";
            case 154:
                return "🇲🇻";
            case 155:
                return "🇲🇼";
            case 156:
                return "🇲🇽";
            case 157:
                return "🇲🇾";
            case 158:
                return "🇲🇿";
            case 159:
                return "🇳🇦";
            case 160:
                return "🇳🇨";
            case 161:
                return "🇳🇪";
            case 162:
                return "🇳🇫";
            case 163:
                return "🇳🇬";
            case 164:
                return "🇳🇮";
            case 165:
                return "🇳🇱";
            case 166:
                return "🇳🇴";
            case ByteCode.GOTO /* 167 */:
                return "🇳🇵";
            case 168:
                return "🇳🇷";
            case ByteCode.RET /* 169 */:
                return "🇳🇺";
            case 170:
                return "🇳🇿";
            case ByteCode.LOOKUPSWITCH /* 171 */:
                return "🇴🇲";
            case 172:
                return "🇵🇦";
            case ByteCode.LRETURN /* 173 */:
                return "🇵🇪";
            case ByteCode.FRETURN /* 174 */:
                return "🇵🇫";
            case ByteCode.DRETURN /* 175 */:
                return "🇵🇬";
            case ByteCode.ARETURN /* 176 */:
                return "🇵🇭";
            case ByteCode.RETURN /* 177 */:
                return "🇵🇰";
            case ByteCode.GETSTATIC /* 178 */:
                return "🇵🇱";
            case ByteCode.PUTSTATIC /* 179 */:
                return "🇵🇲";
            case 180:
                return "🇵🇳";
            case ByteCode.PUTFIELD /* 181 */:
                return "🇵🇷";
            case ByteCode.INVOKEVIRTUAL /* 182 */:
                return "🇵🇸";
            case ByteCode.INVOKESPECIAL /* 183 */:
                return "🇵🇹";
            case ByteCode.INVOKESTATIC /* 184 */:
                return "🇵🇼";
            case ByteCode.INVOKEINTERFACE /* 185 */:
                return "🇵🇾";
            case ByteCode.INVOKEDYNAMIC /* 186 */:
                return "🇶🇦";
            case ByteCode.NEW /* 187 */:
                return "🇷🇪";
            case 188:
                return "🇷🇴";
            case 189:
                return "🇷🇸";
            case 190:
                return "🇷🇺";
            case ByteCode.ATHROW /* 191 */:
                return "🇷🇼";
            case 192:
                return "🇸🇦";
            case ByteCode.INSTANCEOF /* 193 */:
                return "🇸🇧";
            case ByteCode.MONITORENTER /* 194 */:
                return "🇸🇨";
            case ByteCode.MONITOREXIT /* 195 */:
                return "🇸🇩";
            case ByteCode.WIDE /* 196 */:
                return "🇸🇪";
            case ByteCode.MULTIANEWARRAY /* 197 */:
                return "🇸🇬";
            case ByteCode.IFNULL /* 198 */:
                return "🇸🇭";
            case ByteCode.IFNONNULL /* 199 */:
                return "🇸🇮";
            case 200:
                return "🇸🇯";
            case 201:
                return "🇸🇰";
            case 202:
                return "🇸🇱";
            case 203:
                return "🇸🇲";
            case 204:
                return "🇸🇳";
            case HttpStatus.SC_RESET_CONTENT /* 205 */:
                return "🇸🇴";
            case 206:
                return "🇸🇷";
            case 207:
                return "🇸🇸";
            case 208:
                return "🇸🇹";
            case 209:
                return "🇸🇻";
            case 210:
                return "🇸🇽";
            case Primes.SMALL_FACTOR_LIMIT /* 211 */:
                return "🇸🇾";
            case 212:
                return "🇸🇿";
            case 213:
                return "🇹🇨";
            case 214:
                return "🇹🇩";
            case 215:
                return "🇹🇫";
            case 216:
                return "🇹🇬";
            case 217:
                return "🇹🇭";
            case 218:
                return "🇹🇯";
            case 219:
                return "🇹🇰";
            case 220:
                return "🇹🇱";
            case easypay.appinvoke.manager.Constants.EASY_PAY_MINIMIZE_ASSIST /* 221 */:
                return "🇹🇲";
            case easypay.appinvoke.manager.Constants.EASY_PAY_MAXIMIZE_ASSIST /* 222 */:
                return "🇹🇳";
            case 223:
                return "🇹🇴";
            case 224:
                return "🇹🇷";
            case 225:
                return "🇹🇹";
            case 226:
                return "🇹🇻";
            case 227:
                return "🇹🇼";
            case 228:
                return "🇹🇿";
            case 229:
                return "🇺🇦";
            case 230:
                return "🇺🇬";
            case 231:
                return "🇺🇲";
            case 232:
                return "🇺🇸";
            case 233:
                return "🇺🇾";
            case 234:
                return "🇺🇿";
            case 235:
                return "🇻🇦";
            case 236:
                return "🇻🇨";
            case 237:
                return "🇻🇪";
            case 238:
                return "🇻🇬";
            case 239:
                return "🇻🇮";
            case 240:
                return "🇻🇳";
            case 241:
                return "🇻🇺";
            case 242:
                return "🇼🇫";
            case 243:
                return "🇼🇸";
            case 244:
                return "🇽🇰";
            case 245:
                return "🇾🇪";
            case 246:
                return "🇾🇹";
            case 247:
                return "🇿🇦";
            case 248:
                return "🇿🇲";
            case 249:
                return "🇿🇼";
            default:
                return " ";
        }
    }

    public static List<CCPCountry> getLibraryMasterCountryList(Context context, CountryCodePicker.Language language) {
        List<CCPCountry> list;
        CountryCodePicker.Language language2 = loadedLibraryMasterListLanguage;
        if (language2 == null || language != language2 || (list = loadedLibraryMaterList) == null || list.size() == 0) {
            loadDataFromXML(context, language);
        }
        return loadedLibraryMaterList;
    }

    public static List<CCPCountry> getLibraryMasterCountriesEnglish() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CCPCountry("ad", "376", "Andorra", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ae", "971", "United Arab Emirates (UAE)", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("af", "93", "Afghanistan", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ag", "1", "Antigua and Barbuda", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ai", "1", "Anguilla", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("al", "355", "Albania", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("am", "374", "Armenia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ao", "244", "Angola", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("aq", "672", "Antarctica", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ar", "54", "Argentina", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("as", "1", "American Samoa", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry(DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_AT, "43", "Austria", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("au", "61", "Australia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("aw", "297", "Aruba", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ax", "358", "Åland Islands", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("az", "994", "Azerbaijan", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ba", "387", "Bosnia And Herzegovina", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("bb", "1", "Barbados", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("bd", "880", "Bangladesh", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("be", Constants.LEFT_NAV_KEY.attendance_report, "Belgium", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("bf", "226", "Burkina Faso", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry(com.clevertap.android.sdk.Constants.KEY_BG, "359", "Bulgaria", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("bh", "973", "Bahrain", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("bi", "257", "Burundi", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("bj", "229", "Benin", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry(CmcdConfiguration.KEY_BUFFER_LENGTH, "590", "Saint Barthélemy", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("bm", "1", "Bermuda", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("bn", "673", "Brunei Darussalam", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("bo", "591", "Bolivia, Plurinational State Of", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("br", "55", "Brazil", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry(CmcdConfiguration.KEY_BUFFER_STARVATION, "1", "Bahamas", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("bt", "975", "Bhutan", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("bw", "267", "Botswana", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry(StanzaIdElement.ATTR_BY, "375", "Belarus", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("bz", "501", "Belize", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ca", "1", "Canada", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("cc", "61", "Cocos (keeling) Islands", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("cd", "243", "Congo, The Democratic Republic Of The", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("cf", "236", "Central African Republic", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("cg", "242", "Congo", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ch", "41", "Switzerland", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ci", "225", "Côte D'ivoire", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ck", "682", "Cook Islands", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("cl", "56", "Chile", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("cm", "237", "Cameroon", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("cn", "86", "China", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("co", "57", "Colombia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("cr", "506", "Costa Rica", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("cu", "53", "Cuba", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("cv", "238", "Cape Verde", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("cw", "599", "Curaçao", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("cx", "61", "Christmas Island", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("cy", "357", "Cyprus", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("cz", "420", "Czech Republic", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("de", "49", "Germany", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("dj", "253", "Djibouti", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry(com.clevertap.android.sdk.Constants.INAPP_NOTIF_DARKEN_SCREEN, "45", "Denmark", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("dm", "1", "Dominica", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("do", "1", "Dominican Republic", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("dz", "213", "Algeria", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ec", "593", "Ecuador", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ee", "372", "Estonia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("eg", "20", "Egypt", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("er", "291", "Eritrea", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("es", Constants.LEFT_NAV_KEY.TEACHER_TIME_TABLE, "Spain", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("et", "251", "Ethiopia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("fi", "358", "Finland", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("fj", "679", "Fiji", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("fk", "500", "Falkland Islands (malvinas)", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("fm", "691", "Micronesia, Federated States Of", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("fo", "298", "Faroe Islands", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("fr", Constants.LEFT_NAV_KEY.LANGUAGE, "France", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ga", "241", "Gabon", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("gb", "44", "United Kingdom", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("gd", "1", "Grenada", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry(UserDataStore.GENDER, "995", "Georgia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("gf", "594", "French Guyana", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("gh", "233", "Ghana", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("gi", "350", "Gibraltar", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("gl", "299", "Greenland", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("gm", "220", "Gambia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("gn", "224", "Guinea", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("gp", "450", "Guadeloupe", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("gq", "240", "Equatorial Guinea", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("gr", "30", "Greece", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("gt", "502", "Guatemala", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("gu", "1", "Guam", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("gw", "245", "Guinea-bissau", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("gy", "592", "Guyana", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("hk", "852", "Hong Kong", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("hn", "504", "Honduras", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("hr", "385", "Croatia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ht", "509", "Haiti", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("hu", Constants.LEFT_NAV_KEY.NOTICE_BOARD, "Hungary", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("id", "62", "Indonesia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ie", "353", "Ireland", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("il", "972", "Israel", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("im", "44", "Isle Of Man", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("is", "354", "Iceland", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("in", "91", "India", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("io", "246", "British Indian Ocean Territory", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry(IQ.IQ_ELEMENT, "964", "Iraq", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ir", Constants.LEFT_NAV_KEY.book_store, "Iran, Islamic Republic Of", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("it", "39", "Italy", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("je", "44", "Jersey ", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("jm", "1", "Jamaica", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("jo", "962", "Jordan", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("jp", "81", "Japan", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ke", "254", "Kenya", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("kg", "996", "Kyrgyzstan", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("kh", "855", "Cambodia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ki", "686", "Kiribati", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("km", "269", "Comoros", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("kn", "1", "Saint Kitts and Nevis", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("kp", "850", "North Korea", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("kr", "82", "South Korea", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("kw", "965", "Kuwait", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ky", "1", "Cayman Islands", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("kz", "7", "Kazakhstan", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("la", "856", "Lao People's Democratic Republic", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("lb", "961", "Lebanon", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("lc", "1", "Saint Lucia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("li", "423", "Liechtenstein", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("lk", "94", "Sri Lanka", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("lr", "231", "Liberia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ls", "266", "Lesotho", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("lt", "370", "Lithuania", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("lu", "352", "Luxembourg", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("lv", "371", "Latvia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ly", "218", "Libya", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ma", "212", "Morocco", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("mc", "377", "Monaco", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("md", "373", "Moldova, Republic Of", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry(TournamentShareDialogURIBuilder.f586me, "382", "Montenegro", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("mf", "590", "Saint Martin", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("mg", "261", "Madagascar", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("mh", "692", "Marshall Islands", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("mk", "389", "Macedonia (FYROM)", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ml", "223", "Mali", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("mm", "95", "Myanmar", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("mn", "976", "Mongolia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("mo", "853", "Macau", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("mp", "1", "Northern Mariana Islands", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("mq", "596", "Martinique", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("mr", "222", "Mauritania", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ms", "1", "Montserrat", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("mt", "356", "Malta", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("mu", "230", "Mauritius", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("mv", "960", "Maldives", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("mw", "265", "Malawi", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("mx", "52", "Mexico", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("my", "60", "Malaysia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("mz", "258", "Mozambique", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("na", "264", "Namibia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("nc", "687", "New Caledonia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ne", "227", "Niger", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("nf", "672", "Norfolk Islands", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ng", "234", "Nigeria", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ni", "505", "Nicaragua", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("nl", Constants.LEFT_NAV_KEY.Course_Chat, "Netherlands", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("no", "47", "Norway", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("np", "977", "Nepal", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry(Base64BinaryChunk.ATTRIBUTE_NR, "674", "Nauru", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("nu", "683", "Niue", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("nz", "64", "New Zealand", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("om", "968", "Oman", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("pa", "507", "Panama", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("pe", "51", "Peru", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("pf", "689", "French Polynesia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("pg", "675", "Papua New Guinea", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry(UserDataStore.PHONE, "63", "Philippines", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("pk", "92", "Pakistan", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("pl", "48", "Poland", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("pm", "508", "Saint Pierre And Miquelon", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("pn", "870", "Pitcairn Islands", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("pr", "1", "Puerto Rico", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ps", "970", "Palestine", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry(DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_PT, "351", "Portugal", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("pw", "680", "Palau", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("py", "595", "Paraguay", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("qa", "974", "Qatar", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("re", "262", "Réunion", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ro", "40", "Romania", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("rs", "381", "Serbia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ru", "7", "Russian Federation", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("rw", "250", "Rwanda", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("sa", "966", "Saudi Arabia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("sb", "677", "Solomon Islands", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry(com.clevertap.android.sdk.Constants.INAPP_NOTIF_SHOW_CLOSE, "248", "Seychelles", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry(DynamicLink.SocialMetaTagParameters.KEY_SOCIAL_DESCRIPTION, "249", "Sudan", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("se", "46", "Sweden", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("sg", "65", "Singapore", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("sh", "290", "Saint Helena, Ascension And Tristan Da Cunha", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("si", "386", "Slovenia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("sk", "421", "Slovakia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("sl", "232", "Sierra Leone", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry(StreamManagement.StreamManagementFeature.ELEMENT, "378", "San Marino", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("sn", "221", "Senegal", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("so", "252", "Somalia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("sr", "597", "Suriname", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry(com.clevertap.android.sdk.Constants.KEY_ENCRYPTION_INAPP_SS, "211", "South Sudan", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("st", "239", "Sao Tome And Principe", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("sv", "503", "El Salvador", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("sx", "1", "Sint Maarten", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("sy", "963", "Syrian Arab Republic", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("sz", "268", "Swaziland", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("tc", "1", "Turks and Caicos Islands", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("td", "235", "Chad", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("tg", "228", "Togo", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("th", "66", "Thailand", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("tj", "992", "Tajikistan", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("tk", "690", "Tokelau", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("tl", "670", "Timor-leste", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("tm", "993", "Turkmenistan", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("tn", "216", "Tunisia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("to", "676", "Tonga", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("tr", "90", "Turkey", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("tt", "1", "Trinidad &amp; Tobago", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("tv", "688", "Tuvalu", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("tw", "886", "Taiwan", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("tz", "255", "Tanzania, United Republic Of", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ua", "380", "Ukraine", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ug", "256", "Uganda", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("us", "1", "United States", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("uy", "598", "Uruguay", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("uz", "998", "Uzbekistan", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("va", "379", "Holy See (vatican City State)", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("vc", "1", "Saint Vincent &amp; The Grenadines", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ve", "58", "Venezuela, Bolivarian Republic Of", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("vg", "1", "British Virgin Islands", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("vi", "1", "US Virgin Islands", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("vn", "84", "Vietnam", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("vu", "678", "Vanuatu", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("wf", "681", "Wallis And Futuna", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ws", "685", "Samoa", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("xk", "383", "Kosovo", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("ye", "967", "Yemen", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("yt", "262", "Mayotte", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("za", Constants.LEFT_NAV_KEY.bookmark, "South Africa", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("zm", "260", "Zambia", DEFAULT_FLAG_RES));
        arrayList.add(new CCPCountry("zw", "263", "Zimbabwe", DEFAULT_FLAG_RES));
        return arrayList;
    }

    public String getEnglishName() {
        return this.englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public int getFlagID() {
        if (this.flagResID == -99) {
            this.flagResID = getFlagMasterResID(this);
        }
        return this.flagResID;
    }

    public String getNameCode() {
        return this.nameCode;
    }

    public void setNameCode(String nameCode) {
        this.nameCode = nameCode;
    }

    public String getPhoneCode() {
        return this.phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void log() {
        try {
            Log.d(TAG, "Country->" + this.nameCode + ":" + this.phoneCode + ":" + this.name);
        } catch (NullPointerException unused) {
            Log.d(TAG, "Null");
        }
    }

    String logString() {
        return this.nameCode.toUpperCase() + " +" + this.phoneCode + "(" + this.name + ")";
    }

    boolean isEligibleForQuery(String query) {
        String lowerCase = query.toLowerCase();
        return containsQueryWord(com.clevertap.android.sdk.Constants.KEY_ENCRYPTION_NAME, getName(), lowerCase) || containsQueryWord("NameCode", getNameCode(), lowerCase) || containsQueryWord("PhoneCode", getPhoneCode(), lowerCase) || containsQueryWord("EnglishName", getEnglishName(), lowerCase);
    }

    private boolean containsQueryWord(String fieldName, String fieldValue, String query) {
        if (fieldValue != null && query != null) {
            try {
                return fieldValue.toLowerCase(Locale.ROOT).contains(query);
            } catch (Exception unused) {
                Log.w("CCPCountry", fieldName + ":" + fieldValue + " failed to execute toLowerCase(Locale.ROOT).contains(query) for query:" + query);
            }
        }
        return false;
    }

    @Override // java.lang.Comparable
    public int compareTo(CCPCountry o) {
        return Collator.getInstance().compare(getName(), o.getName());
    }
}
