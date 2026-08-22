package com.appnew.android;

import android.app.Activity;
import android.content.SharedPreferences;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.appnew.android.Utils.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ColorTheme.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J&\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/appnew/android/ColorTheme;", "", "<init>", "()V", "themeKey", "", "getThemeKey", "()Ljava/lang/String;", "setThemeKey", "(Ljava/lang/String;)V", "setColorTheme", "", "value", "sharedPreferences", "Landroid/content/SharedPreferences;", "activity", "Landroid/app/Activity;", "setToolbarColor", "mainToolbar", "Landroidx/appcompat/widget/Toolbar;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColorTheme {
    public static final int $stable = 8;
    private String themeKey = "currentTheme";

    public final String getThemeKey() {
        return this.themeKey;
    }

    public final void setThemeKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.themeKey = str;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void setColorTheme(String themeKey, String value, SharedPreferences sharedPreferences, Activity activity) {
        Intrinsics.checkNotNullParameter(themeKey, "themeKey");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(activity, "activity");
        String string = sharedPreferences.getString(themeKey, Const.RED);
        if (string != null) {
            switch (string.hashCode()) {
                case 112785:
                    if (string.equals(Const.RED)) {
                        activity.getTheme().applyStyle(com.eduteria.app.app.R.style.OverlayThemeRed, true);
                        break;
                    }
                    break;
                case 3027034:
                    if (string.equals("blue")) {
                        activity.getTheme().applyStyle(com.eduteria.app.app.R.style.OverlayThemeBlue, true);
                        break;
                    }
                    break;
                case 3321813:
                    if (string.equals("lime")) {
                        activity.getTheme().applyStyle(com.eduteria.app.app.R.style.OverlayThemeLime, true);
                    }
                    break;
                case 98619139:
                    if (string.equals("green")) {
                        activity.getTheme().applyStyle(com.eduteria.app.app.R.style.OverlayThemeGreen, true);
                        break;
                    }
                    break;
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void setToolbarColor(String themeKey, SharedPreferences sharedPreferences, Toolbar mainToolbar, Activity activity) {
        Intrinsics.checkNotNullParameter(themeKey, "themeKey");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(mainToolbar, "mainToolbar");
        Intrinsics.checkNotNullParameter(activity, "activity");
        String string = sharedPreferences.getString(themeKey, Const.RED);
        if (string != null) {
            switch (string.hashCode()) {
                case 112785:
                    if (string.equals(Const.RED)) {
                        mainToolbar.setBackgroundColor(ContextCompat.getColor(activity, com.eduteria.app.app.R.color.md_red_700));
                        break;
                    }
                    break;
                case 3027034:
                    if (string.equals("blue")) {
                        mainToolbar.setBackgroundColor(ContextCompat.getColor(activity, com.eduteria.app.app.R.color.colorAccent));
                        break;
                    }
                    break;
                case 3321813:
                    if (string.equals("lime")) {
                        mainToolbar.setBackgroundColor(ContextCompat.getColor(activity, com.eduteria.app.app.R.color.colorAccent));
                    }
                    break;
                case 98619139:
                    if (string.equals("green")) {
                        mainToolbar.setBackgroundColor(ContextCompat.getColor(activity, com.eduteria.app.app.R.color.colorAccent));
                        break;
                    }
                    break;
            }
        }
    }
}
