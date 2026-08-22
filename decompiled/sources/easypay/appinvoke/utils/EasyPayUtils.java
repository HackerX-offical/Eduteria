package easypay.appinvoke.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;
import easypay.appinvoke.entity.AssistDetailsResponse;
import easypay.appinvoke.entity.NewConfigResponse;
import easypay.appinvoke.entity.PreferenceList;
import easypay.appinvoke.manager.Constants;

/* JADX INFO: loaded from: classes9.dex */
public class EasyPayUtils {
    public static void saveConfigWithEtag(Context context, String str, String str2) {
        PreferenceList preferenceList;
        PreferenceList preferenceList2;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.EASYPAY_NEW_PREFERENCE_FILE, 0);
            String string = sharedPreferences.getString(Constants.EASY_PAY_CONFIG_BANK_LIST_KEY, "");
            Gson gson = new Gson();
            if (!TextUtils.isEmpty(str)) {
                NewConfigResponse newConfigResponse = (NewConfigResponse) gson.fromJson(str, NewConfigResponse.class);
                if (newConfigResponse != null && newConfigResponse.getResponseCode() != null && !TextUtils.isEmpty(newConfigResponse.getResponseMessage()) && newConfigResponse.getResponseCode().intValue() != 403 && !newConfigResponse.getResponseMessage().contains("Bank name is not supported")) {
                    if (newConfigResponse.getAssistBaseSRO() != null) {
                        newConfigResponse.getAssistBaseSRO().setEtag(str2);
                    }
                    if (TextUtils.isEmpty(string)) {
                        preferenceList2 = new PreferenceList();
                        preferenceList2.getPrefList().add(newConfigResponse.getAssistBaseSRO());
                    } else {
                        preferenceList2 = (PreferenceList) gson.fromJson(string, PreferenceList.class);
                        if (preferenceList2 != null) {
                            int i = 0;
                            while (true) {
                                if (i >= preferenceList2.getPrefList().size()) {
                                    i = -1;
                                    break;
                                } else if (newConfigResponse.getAssistBaseSRO().equals(preferenceList2.getPrefList().get(i))) {
                                    break;
                                } else {
                                    i++;
                                }
                            }
                            if (i != -1) {
                                preferenceList2.getPrefList().set(i, newConfigResponse.getAssistBaseSRO());
                            } else if (preferenceList2.getPrefList().size() < 5) {
                                preferenceList2.getPrefList().add(newConfigResponse.getAssistBaseSRO());
                            } else {
                                preferenceList2.getPrefList().remove(preferenceList2.getPrefList().size() - 1);
                                preferenceList2.getPrefList().add(0, newConfigResponse.getAssistBaseSRO());
                            }
                        }
                    }
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString(Constants.EASY_PAY_CONFIG_BANK_LIST_KEY, new Gson().toJson(preferenceList2));
                    editorEdit.putString("config", new Gson().toJson(newConfigResponse.getAssistBaseSRO()));
                    editorEdit.apply();
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(string) || (preferenceList = (PreferenceList) gson.fromJson(string, PreferenceList.class)) == null) {
                return;
            }
            for (int i2 = 0; i2 < preferenceList.getPrefList().size(); i2++) {
                AssistDetailsResponse assistDetailsResponse = preferenceList.getPrefList().get(i2);
                if (assistDetailsResponse.getEtag().equals(str2)) {
                    SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
                    editorEdit2.putString("config", new Gson().toJson(assistDetailsResponse));
                    editorEdit2.apply();
                    return;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    public static String getSavedEtag(Context context, String str, String str2, String str3) {
        PreferenceList preferenceList;
        try {
            String string = context.getSharedPreferences(Constants.EASYPAY_NEW_PREFERENCE_FILE, 0).getString(Constants.EASY_PAY_CONFIG_BANK_LIST_KEY, "");
            Gson gson = new Gson();
            if (!TextUtils.isEmpty(string) && (preferenceList = (PreferenceList) gson.fromJson(string, PreferenceList.class)) != null) {
                for (int i = 0; i < preferenceList.getPrefList().size(); i++) {
                    AssistDetailsResponse assistDetailsResponse = preferenceList.getPrefList().get(i);
                    if ((str + str2 + str3).equals(assistDetailsResponse.toString())) {
                        return assistDetailsResponse.getEtag();
                    }
                }
            }
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
            return "";
        }
    }
}
