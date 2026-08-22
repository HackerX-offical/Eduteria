package com.appnew.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FacebookEventLogger.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u001c\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J$\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u0016\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0007J&\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007J&\u0010\u001a\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010\u001b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010\u001c\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0007J\"\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020'H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/appnew/android/FacebookEventLogger;", "", "<init>", "()V", "TAG", "", "logEvent", "", "context", "Landroid/content/Context;", "eventName", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/os/Bundle;", "logDeactivateApp", "logUserLogin", "userInfo", "logUserRegistration", "logLoginScreen", "logRegistrationScreen", "logFBLoginButtonCreate", "logSignUpEvent", FirebaseAnalytics.Param.METHOD, "logScreenViewed", "screenName", "logViewCourseDetails", "courseId", "logBuyNowClicked", "logAlreadyLogin", "logBannerClicked", "bannerTitle", "logAppUsageEvent", "durationSeconds", "", "logFbSdkInitialize", "logApplicationInstall", "logOtpSend", "logOtpVerification", "logPurchased", "logSignUp", "Landroid/app/Activity;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FacebookEventLogger {
    public static final int $stable = 0;
    public static final FacebookEventLogger INSTANCE = new FacebookEventLogger();
    private static final String TAG = "FBEventLogger";

    @JvmStatic
    public static final void logEvent(Context context, String eventName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        logEvent$default(context, eventName, null, 4, null);
    }

    private FacebookEventLogger() {
    }

    public static /* synthetic */ void logEvent$default(Context context, String str, Bundle bundle, int i, Object obj) {
        if ((i & 4) != 0) {
            bundle = null;
        }
        logEvent(context, str, bundle);
    }

    @JvmStatic
    public static final void logEvent(Context context, String eventName, final Bundle params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        try {
            AppEventsLogger.INSTANCE.newLogger(context).logEvent(eventName, params);
            if (params == null) {
                Log.d(TAG, "Logged event: " + eventName);
                return;
            }
            Set<String> setKeySet = params.keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "keySet(...)");
            Log.d(TAG, "Logged event: " + eventName + " | params: " + CollectionsKt.joinToString$default(setKeySet, null, null, null, 0, null, new Function1() { // from class: com.appnew.android.FacebookEventLogger$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FacebookEventLogger.logEvent$lambda$0(params, (String) obj);
                }
            }, 31, null));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence logEvent$lambda$0(Bundle bundle, String str) {
        return str + "=" + bundle.get(str);
    }

    @JvmStatic
    public static final void logDeactivateApp(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        logEvent$default(context, "deactivate_app", null, 4, null);
    }

    public static /* synthetic */ void logUserLogin$default(Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        logUserLogin(context, str);
    }

    @JvmStatic
    public static final void logUserLogin(Context context, String userInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle bundle = new Bundle();
        if (userInfo == null) {
            userInfo = "unknown_user";
        }
        bundle.putString("userInfo", userInfo);
        logEvent(context, "UserLogin", bundle);
    }

    public static /* synthetic */ void logUserRegistration$default(Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        logUserRegistration(context, str);
    }

    @JvmStatic
    public static final void logUserRegistration(Context context, String userInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle bundle = new Bundle();
        if (userInfo == null) {
            userInfo = "unknown_user";
        }
        bundle.putString("userInfo", userInfo);
        logEvent(context, "complete_registration", bundle);
    }

    @JvmStatic
    public static final void logLoginScreen(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        logEvent$default(context, "LoginScreen", null, 4, null);
    }

    @JvmStatic
    public static final void logRegistrationScreen(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        logEvent$default(context, "RegisterScreen", null, 4, null);
    }

    @JvmStatic
    public static final void logFBLoginButtonCreate(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        logEvent$default(context, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, null, 4, null);
    }

    @JvmStatic
    public static final void logSignUpEvent(Context context, String method, String userInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle bundle = new Bundle();
        if (method == null) {
            method = "unknown_method";
        }
        bundle.putString("signup_method", method);
        if (userInfo == null) {
            userInfo = "unknown_user";
        }
        bundle.putString("userInfo", userInfo);
        logEvent(context, "UserSignUp", bundle);
    }

    @JvmStatic
    public static final void logScreenViewed(Context context, String screenName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle bundle = new Bundle();
        if (screenName == null) {
            screenName = "unknown_screen";
        }
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, screenName);
        logEvent(context, "mobile_screen_view", bundle);
    }

    public static /* synthetic */ void logViewCourseDetails$default(Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        logViewCourseDetails(context, str, str2);
    }

    @JvmStatic
    public static final void logViewCourseDetails(Context context, String courseId, String userInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle bundle = new Bundle();
        if (courseId == null) {
            courseId = "unknown_course";
        }
        bundle.putString("course_id", courseId);
        if (userInfo == null) {
            userInfo = "unknown_user";
        }
        bundle.putString("userInfo", userInfo);
        logEvent(context, "content_view", bundle);
    }

    public static /* synthetic */ void logBuyNowClicked$default(Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        logBuyNowClicked(context, str, str2);
    }

    @JvmStatic
    public static final void logBuyNowClicked(Context context, String courseId, String userInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle bundle = new Bundle();
        if (courseId == null) {
            courseId = "unknown_course";
        }
        bundle.putString("course_id", courseId);
        if (userInfo == null) {
            userInfo = "unknown_user";
        }
        bundle.putString("userInfo", userInfo);
        logEvent(context, "buy_now_clicked", bundle);
    }

    public static /* synthetic */ void logAlreadyLogin$default(Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        logAlreadyLogin(context, str);
    }

    @JvmStatic
    public static final void logAlreadyLogin(Context context, String userInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle bundle = new Bundle();
        if (userInfo == null) {
            userInfo = "unknown_user";
        }
        bundle.putString("userInfo", userInfo);
        logEvent(context, "already_login", bundle);
    }

    public static /* synthetic */ void logBannerClicked$default(Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        logBannerClicked(context, str);
    }

    @JvmStatic
    public static final void logBannerClicked(Context context, String bannerTitle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle bundle = new Bundle();
        if (bannerTitle == null) {
            bannerTitle = "unknown_banner";
        }
        bundle.putString("banner_title", bannerTitle);
        logEvent(context, "Banner_Clicked", bundle);
    }

    @JvmStatic
    public static final void logAppUsageEvent(Context context, long durationSeconds, String userInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle bundle = new Bundle();
        if (userInfo == null) {
            userInfo = "unknown_user";
        }
        bundle.putString("userInfo", userInfo);
        bundle.putLong("duration_seconds", durationSeconds);
        logEvent(context, "AppUsage", bundle);
    }

    @JvmStatic
    public static final void logFbSdkInitialize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        logEvent$default(context, AnalyticsEvents.EVENT_SDK_INITIALIZE, null, 4, null);
    }

    @JvmStatic
    public static final void logApplicationInstall(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        logEvent$default(context, "application_install", null, 4, null);
    }

    @JvmStatic
    public static final void logOtpSend(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        logEvent$default(context, "otp_sent_on_number", null, 4, null);
    }

    @JvmStatic
    public static final void logOtpVerification(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        logEvent$default(context, "otp_verified_on_number", null, 4, null);
    }

    @JvmStatic
    public static final void logPurchased(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        logEvent$default(context, FirebaseAnalytics.Event.PURCHASE, null, 4, null);
    }

    @JvmStatic
    public static final void logSignUp(Activity context) {
        Intrinsics.checkNotNullParameter(context, "context");
        logEvent$default(context, FirebaseAnalytics.Event.SIGN_UP, null, 4, null);
    }
}
