package com.appnew.android.TeacherTimeTable.Activity;

import android.content.SharedPreferences;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.databinding.ActivityNoticeboardBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Noticeboard.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000\"\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000\"\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"binding", "Lcom/appnew/android/databinding/ActivityNoticeboardBinding;", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "id", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "setSharedPreferences", "(Landroid/content/SharedPreferences;)V", "app_EDUTERIARelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class NoticeboardKt {
    private static ActivityNoticeboardBinding binding;
    private static String id;
    private static NetworkCall networkCall;
    public static SharedPreferences sharedPreferences;

    public static final NetworkCall getNetworkCall() {
        return networkCall;
    }

    public static final void setNetworkCall(NetworkCall networkCall2) {
        networkCall = networkCall2;
    }

    public static final SharedPreferences getSharedPreferences() {
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (sharedPreferences2 != null) {
            return sharedPreferences2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        return null;
    }

    public static final void setSharedPreferences(SharedPreferences sharedPreferences2) {
        Intrinsics.checkNotNullParameter(sharedPreferences2, "<set-?>");
        sharedPreferences = sharedPreferences2;
    }
}
