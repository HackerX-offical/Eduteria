package com.clevertap.android.sdk.pushnotification;

import android.os.Bundle;
import com.clevertap.android.sdk.Constants;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public class PushNotificationUtil {
    public static String getAccountIdFromNotificationBundle(Bundle bundle) {
        return bundle != null ? bundle.getString(Constants.WZRK_ACCT_ID_KEY, "") : "";
    }

    public static String getPushIdFromNotificationBundle(Bundle bundle) {
        return bundle != null ? bundle.getString(Constants.WZRK_PUSH_ID, "") : "";
    }

    public static ArrayList<PushType> getDefaultPushTypes() {
        ArrayList<PushType> arrayList = new ArrayList<>();
        arrayList.add(PushConstants.FCM);
        return arrayList;
    }

    private PushNotificationUtil() {
    }

    public static String buildPushNotificationRenderedListenerKey(String str, String str2) {
        return str + "_" + str2;
    }
}
