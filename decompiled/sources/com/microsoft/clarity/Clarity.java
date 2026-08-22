package com.microsoft.clarity;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.microsoft.clarity.a;
import com.microsoft.clarity.f.k;
import com.microsoft.clarity.g.e;
import com.microsoft.clarity.n.i;

/* JADX INFO: loaded from: classes9.dex */
public class Clarity {
    public static String getCurrentSessionId() {
        Handler handler = a.f656a;
        if (a.f657b == null) {
            i.e("Clarity has not started yet.");
        }
        k kVar = a.f657b;
        String strB = kVar != null ? kVar.f842c.b() : null;
        if (strB == null) {
            i.e("No Clarity session has started yet.");
        }
        return strB;
    }

    public static Boolean initialize(Activity activity, ClarityConfig clarityConfig) {
        if (activity == null || clarityConfig == null) {
            i.c("activity and config parameters cannot be null.");
            return Boolean.FALSE;
        }
        Handler handler = a.f656a;
        return Boolean.valueOf(a.C0182a.a(activity, activity.getApplicationContext(), clarityConfig));
    }

    public static Boolean initialize(Context context, ClarityConfig clarityConfig) {
        if (context == null || clarityConfig == null) {
            i.c("context and config parameters cannot be null.");
            return Boolean.FALSE;
        }
        Handler handler = a.f656a;
        return Boolean.valueOf(a.C0182a.a((Activity) null, context, clarityConfig));
    }

    public static Boolean maskView(View view) {
        if (view == null) {
            i.c("View cannot be null.");
            return Boolean.FALSE;
        }
        Handler handler = a.f656a;
        return Boolean.valueOf(a.C0182a.a(view));
    }

    public static Boolean setCurrentScreenName(String str) {
        String str2;
        if (str == null) {
            i.c("Screen name cannot be null.");
            return Boolean.FALSE;
        }
        ClarityConfig clarityConfig = a.f660e;
        boolean zA = false;
        if (clarityConfig == null) {
            str2 = "Please initialize Clarity before calling this function.";
        } else {
            if (clarityConfig.isReactNative$sdk_prodRelease()) {
                zA = com.microsoft.clarity.n.e.a(new f(str), g.f880a, (e.c) null, 26);
                return Boolean.valueOf(zA);
            }
            str2 = "Setting current screen names is only available in React Native applications.";
        }
        i.c(str2);
        return Boolean.valueOf(zA);
    }

    public static boolean setCustomTag(String str, String str2) {
        if (str == null || str2 == null) {
            i.c("Custom tag key and value cannot be null.");
            return false;
        }
        Handler handler = a.f656a;
        return a.C0182a.a(str, str2);
    }

    public static Boolean setCustomUserId(String str) {
        if (str == null) {
            i.c("Custom user id cannot be null.");
            return Boolean.FALSE;
        }
        Handler handler = a.f656a;
        return Boolean.valueOf(a.C0182a.a(str));
    }

    public static Boolean unmaskView(View view) {
        if (view == null) {
            i.c("View cannot be null.");
            return Boolean.FALSE;
        }
        Handler handler = a.f656a;
        return Boolean.valueOf(a.C0182a.b(view));
    }
}
