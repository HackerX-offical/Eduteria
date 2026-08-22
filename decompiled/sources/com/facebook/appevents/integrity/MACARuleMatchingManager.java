package com.facebook.appevents.integrity;

import android.os.Build;
import android.os.Bundle;
import com.appnew.android.Utils.Const;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.amp.packet.AMPExtension;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: MACARuleMatchingManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J&\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0007J\b\u0010\u001c\u001a\u00020\fH\u0002J\u001a\u0010\u001d\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0007J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\"\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\""}, d2 = {"Lcom/facebook/appevents/integrity/MACARuleMatchingManager;", "", "()V", "MACARules", "Lorg/json/JSONArray;", StreamManagement.Enabled.ELEMENT, "", "keys", "", "", "[Ljava/lang/String;", "enable", "", "generateInfo", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/os/Bundle;", "event", "getKey", "logic", "Lorg/json/JSONObject;", "getMatchPropertyIDs", "getStringArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "jsonArray", "isMatchCCRule", "ruleString", "data", "loadMACARules", "processParameters", "removeGeneratedInfo", "stringComparison", "variable", "values", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MACARuleMatchingManager {
    private static JSONArray MACARules;
    private static boolean enabled;
    public static final MACARuleMatchingManager INSTANCE = new MACARuleMatchingManager();
    private static String[] keys = {"event", "_locale", "_appVersion", "_deviceOS", "_platform", "_deviceModel", "_nativeAppID", "_nativeAppShortVersion", "_timezone", "_carrier", "_deviceOSTypeName", "_deviceOSVersion", "_remainingDiskGB"};

    private MACARuleMatchingManager() {
    }

    @JvmStatic
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            INSTANCE.loadMACARules();
            if (MACARules != null) {
                enabled = true;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    private final void loadMACARules() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (fetchedAppSettingsQueryAppSettings == null) {
                return;
            }
            MACARules = fetchedAppSettingsQueryAppSettings.getMACARuleMatchingSetting();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @JvmStatic
    public static final String getKey(JSONObject logic) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(logic, "logic");
            Iterator<String> itKeys = logic.keys();
            if (itKeys.hasNext()) {
                return itKeys.next();
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0224 A[Catch: all -> 0x0378, TryCatch #0 {all -> 0x0378, blocks: (B:5:0x000a, B:8:0x001d, B:11:0x0038, B:17:0x004a, B:24:0x0065, B:25:0x006a, B:27:0x006f, B:30:0x0079, B:32:0x0094, B:35:0x009e, B:39:0x00ae, B:133:0x0224, B:135:0x022a, B:138:0x0234, B:139:0x0238, B:141:0x023e, B:42:0x00b8, B:45:0x00c2, B:47:0x00e1, B:150:0x026f, B:152:0x0275, B:155:0x027f, B:156:0x0283, B:158:0x0289, B:50:0x00eb, B:53:0x00f5, B:55:0x0110, B:105:0x01c0, B:58:0x011a, B:98:0x01a4, B:61:0x0124, B:88:0x017e, B:64:0x012e, B:67:0x0138, B:124:0x0205, B:70:0x0142, B:73:0x014c, B:199:0x0344, B:76:0x0156, B:112:0x01d6, B:79:0x0160, B:82:0x016a, B:119:0x01f2, B:85:0x0174, B:92:0x0190, B:95:0x019a, B:102:0x01b6, B:109:0x01cc, B:116:0x01e8, B:121:0x01fb, B:128:0x0217, B:145:0x0262, B:162:0x02ad, B:165:0x02b7, B:169:0x02d5, B:172:0x02df, B:174:0x02ec, B:192:0x032f, B:177:0x02f6, B:180:0x0300, B:182:0x0310, B:185:0x031a, B:187:0x0323, B:194:0x0338, B:201:0x034d, B:204:0x0356, B:20:0x005b), top: B:211:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x026f A[Catch: all -> 0x0378, TryCatch #0 {all -> 0x0378, blocks: (B:5:0x000a, B:8:0x001d, B:11:0x0038, B:17:0x004a, B:24:0x0065, B:25:0x006a, B:27:0x006f, B:30:0x0079, B:32:0x0094, B:35:0x009e, B:39:0x00ae, B:133:0x0224, B:135:0x022a, B:138:0x0234, B:139:0x0238, B:141:0x023e, B:42:0x00b8, B:45:0x00c2, B:47:0x00e1, B:150:0x026f, B:152:0x0275, B:155:0x027f, B:156:0x0283, B:158:0x0289, B:50:0x00eb, B:53:0x00f5, B:55:0x0110, B:105:0x01c0, B:58:0x011a, B:98:0x01a4, B:61:0x0124, B:88:0x017e, B:64:0x012e, B:67:0x0138, B:124:0x0205, B:70:0x0142, B:73:0x014c, B:199:0x0344, B:76:0x0156, B:112:0x01d6, B:79:0x0160, B:82:0x016a, B:119:0x01f2, B:85:0x0174, B:92:0x0190, B:95:0x019a, B:102:0x01b6, B:109:0x01cc, B:116:0x01e8, B:121:0x01fb, B:128:0x0217, B:145:0x0262, B:162:0x02ad, B:165:0x02b7, B:169:0x02d5, B:172:0x02df, B:174:0x02ec, B:192:0x032f, B:177:0x02f6, B:180:0x0300, B:182:0x0310, B:185:0x031a, B:187:0x0323, B:194:0x0338, B:201:0x034d, B:204:0x0356, B:20:0x005b), top: B:211:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x032f A[Catch: all -> 0x0378, TryCatch #0 {all -> 0x0378, blocks: (B:5:0x000a, B:8:0x001d, B:11:0x0038, B:17:0x004a, B:24:0x0065, B:25:0x006a, B:27:0x006f, B:30:0x0079, B:32:0x0094, B:35:0x009e, B:39:0x00ae, B:133:0x0224, B:135:0x022a, B:138:0x0234, B:139:0x0238, B:141:0x023e, B:42:0x00b8, B:45:0x00c2, B:47:0x00e1, B:150:0x026f, B:152:0x0275, B:155:0x027f, B:156:0x0283, B:158:0x0289, B:50:0x00eb, B:53:0x00f5, B:55:0x0110, B:105:0x01c0, B:58:0x011a, B:98:0x01a4, B:61:0x0124, B:88:0x017e, B:64:0x012e, B:67:0x0138, B:124:0x0205, B:70:0x0142, B:73:0x014c, B:199:0x0344, B:76:0x0156, B:112:0x01d6, B:79:0x0160, B:82:0x016a, B:119:0x01f2, B:85:0x0174, B:92:0x0190, B:95:0x019a, B:102:0x01b6, B:109:0x01cc, B:116:0x01e8, B:121:0x01fb, B:128:0x0217, B:145:0x0262, B:162:0x02ad, B:165:0x02b7, B:169:0x02d5, B:172:0x02df, B:174:0x02ec, B:192:0x032f, B:177:0x02f6, B:180:0x0300, B:182:0x0310, B:185:0x031a, B:187:0x0323, B:194:0x0338, B:201:0x034d, B:204:0x0356, B:20:0x005b), top: B:211:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0344 A[Catch: all -> 0x0378, TryCatch #0 {all -> 0x0378, blocks: (B:5:0x000a, B:8:0x001d, B:11:0x0038, B:17:0x004a, B:24:0x0065, B:25:0x006a, B:27:0x006f, B:30:0x0079, B:32:0x0094, B:35:0x009e, B:39:0x00ae, B:133:0x0224, B:135:0x022a, B:138:0x0234, B:139:0x0238, B:141:0x023e, B:42:0x00b8, B:45:0x00c2, B:47:0x00e1, B:150:0x026f, B:152:0x0275, B:155:0x027f, B:156:0x0283, B:158:0x0289, B:50:0x00eb, B:53:0x00f5, B:55:0x0110, B:105:0x01c0, B:58:0x011a, B:98:0x01a4, B:61:0x0124, B:88:0x017e, B:64:0x012e, B:67:0x0138, B:124:0x0205, B:70:0x0142, B:73:0x014c, B:199:0x0344, B:76:0x0156, B:112:0x01d6, B:79:0x0160, B:82:0x016a, B:119:0x01f2, B:85:0x0174, B:92:0x0190, B:95:0x019a, B:102:0x01b6, B:109:0x01cc, B:116:0x01e8, B:121:0x01fb, B:128:0x0217, B:145:0x0262, B:162:0x02ad, B:165:0x02b7, B:169:0x02d5, B:172:0x02df, B:174:0x02ec, B:192:0x032f, B:177:0x02f6, B:180:0x0300, B:182:0x0310, B:185:0x031a, B:187:0x0323, B:194:0x0338, B:201:0x034d, B:204:0x0356, B:20:0x005b), top: B:211:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean stringComparison(java.lang.String r8, org.json.JSONObject r9, android.os.Bundle r10) {
        /*
            Method dump skipped, instruction units count: 1028
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.integrity.MACARuleMatchingManager.stringComparison(java.lang.String, org.json.JSONObject, android.os.Bundle):boolean");
    }

    @JvmStatic
    public static final ArrayList<String> getStringArrayList(JSONArray jsonArray) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class) || jsonArray == null) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(jsonArray.get(i).toString());
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final boolean isMatchCCRule(String ruleString, Bundle data) {
        if (!CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class) && ruleString != null && data != null) {
            try {
                JSONObject jSONObject = new JSONObject(ruleString);
                String key = getKey(jSONObject);
                if (key == null) {
                    return false;
                }
                Object obj = jSONObject.get(key);
                int iHashCode = key.hashCode();
                if (iHashCode != 3555) {
                    if (iHashCode != 96727) {
                        if (iHashCode == 109267 && key.equals("not")) {
                            return !isMatchCCRule(obj.toString(), data);
                        }
                    } else if (key.equals("and")) {
                        JSONArray jSONArray = (JSONArray) obj;
                        if (jSONArray == null) {
                            return false;
                        }
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            if (!isMatchCCRule(jSONArray.get(i).toString(), data)) {
                                return false;
                            }
                        }
                        return true;
                    }
                } else if (key.equals("or")) {
                    JSONArray jSONArray2 = (JSONArray) obj;
                    if (jSONArray2 == null) {
                        return false;
                    }
                    int length2 = jSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        if (isMatchCCRule(jSONArray2.get(i2).toString(), data)) {
                            return true;
                        }
                    }
                    return false;
                }
                JSONObject jSONObject2 = (JSONObject) obj;
                if (jSONObject2 == null) {
                    return false;
                }
                return stringComparison(key, jSONObject2, data);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            }
        }
        return false;
    }

    @JvmStatic
    public static final String getMatchPropertyIDs(Bundle params) {
        String strOptString;
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return null;
        }
        try {
            JSONArray jSONArray = MACARules;
            if (jSONArray == null) {
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            if (jSONArray != null && jSONArray.length() == 0) {
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            JSONArray jSONArray2 = MACARules;
            Intrinsics.checkNotNull(jSONArray2, "null cannot be cast to non-null type org.json.JSONArray");
            ArrayList arrayList = new ArrayList();
            int length = jSONArray2.length();
            for (int i = 0; i < length; i++) {
                String strOptString2 = jSONArray2.optString(i);
                if (strOptString2 != null) {
                    JSONObject jSONObject = new JSONObject(strOptString2);
                    long jOptLong = jSONObject.optLong("id");
                    if (jOptLong != 0 && (strOptString = jSONObject.optString(AMPExtension.Rule.ELEMENT)) != null && isMatchCCRule(strOptString, params)) {
                        arrayList.add(Long.valueOf(jOptLong));
                    }
                }
            }
            String string = new JSONArray((Collection) arrayList).toString();
            Intrinsics.checkNotNullExpressionValue(string, "JSONArray(res).toString()");
            return string;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final void processParameters(Bundle params, String event) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!enabled || params == null) {
                return;
            }
            try {
                generateInfo(params, event);
                params.putString("_audiencePropertyIds", getMatchPropertyIDs(params));
                params.putString("cs_maca", "1");
                removeGeneratedInfo(params);
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    @JvmStatic
    public static final void generateInfo(Bundle params, String event) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(event, "event");
            params.putString("event", event);
            StringBuilder sb = new StringBuilder();
            Locale locale = Utility.INSTANCE.getLocale();
            String language = locale != null ? locale.getLanguage() : null;
            String str = "";
            if (language == null) {
                language = "";
            }
            StringBuilder sbAppend = sb.append(language).append('_');
            Locale locale2 = Utility.INSTANCE.getLocale();
            String country = locale2 != null ? locale2.getCountry() : null;
            if (country == null) {
                country = "";
            }
            params.putString("_locale", sbAppend.append(country).toString());
            String versionName = Utility.INSTANCE.getVersionName();
            if (versionName == null) {
                versionName = "";
            }
            params.putString("_appVersion", versionName);
            params.putString("_deviceOS", "ANDROID");
            params.putString("_platform", Const.MOBILE);
            String str2 = Build.MODEL;
            if (str2 == null) {
                str2 = "";
            }
            params.putString("_deviceModel", str2);
            params.putString("_nativeAppID", FacebookSdk.getApplicationId());
            String versionName2 = Utility.INSTANCE.getVersionName();
            if (versionName2 != null) {
                str = versionName2;
            }
            params.putString("_nativeAppShortVersion", str);
            params.putString("_timezone", Utility.INSTANCE.getDeviceTimeZoneName());
            params.putString("_carrier", Utility.INSTANCE.getCarrierName());
            params.putString("_deviceOSTypeName", "ANDROID");
            params.putString("_deviceOSVersion", Build.VERSION.RELEASE);
            params.putLong("_remainingDiskGB", Utility.INSTANCE.getAvailableExternalStorageGB());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    @JvmStatic
    public static final void removeGeneratedInfo(Bundle params) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(params, "params");
            for (String str : keys) {
                params.remove(str);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }
}
