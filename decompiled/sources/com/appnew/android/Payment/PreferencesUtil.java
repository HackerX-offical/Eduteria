package com.appnew.android.Payment;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaymentViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\"\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u0011"}, d2 = {"Lcom/appnew/android/Payment/PreferencesUtil;", "", "<init>", "()V", "getSharedPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "setStringPreference", "", "key", "", "val", "getStringPreference", "removePreference", "removeAllPreference", "removeAllCredentials", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreferencesUtil {
    public static final int $stable = 0;
    public static final PreferencesUtil INSTANCE = new PreferencesUtil();

    private PreferencesUtil() {
    }

    private final SharedPreferences getSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("tag", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }

    public final void setStringPreference(Context context, String key, String val) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = getSharedPreferences(context).edit();
        editorEdit.putString(key, val);
        editorEdit.apply();
    }

    public final String getStringPreference(Context context, String key) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getSharedPreferences(context).getString(key, "");
    }

    public final void removePreference(Context context, String key) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = getSharedPreferences(context).edit();
        editorEdit.remove(key);
        editorEdit.apply();
    }

    public final void removeAllPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = getSharedPreferences(context).edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    public final void removeAllCredentials(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = getSharedPreferences(context).edit();
        editorEdit.remove(Credentials.RZP);
        editorEdit.remove(Credentials.PAYTM);
        editorEdit.remove(Credentials.CCAV);
        editorEdit.remove(Credentials.CF);
        editorEdit.remove(Credentials.FONEPAY);
        editorEdit.remove(Credentials.BILLDESK);
        editorEdit.remove(Credentials.EASEBUZZ);
        editorEdit.remove(Credentials.WORLDLINE);
        editorEdit.remove(Credentials.EASYPAY);
        editorEdit.apply();
    }
}
