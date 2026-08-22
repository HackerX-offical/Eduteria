package com.appnew.android.Utils;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes6.dex */
public class NightModeHelper {
    private static final String PREF_KEY = "nightModeState";
    private static int sUiNightMode;
    private WeakReference<Activity> mActivity;
    private SharedPreferences mPrefs;

    public NightModeHelper(Activity activity, int theme) {
        int i = activity.getResources().getConfiguration().uiMode & 48;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
        this.mPrefs = defaultSharedPreferences;
        init(activity, theme, defaultSharedPreferences.getInt(PREF_KEY, i));
    }

    public NightModeHelper(Activity activity, int theme, int defaultUiMode) {
        init(activity, theme, defaultUiMode);
    }

    private void init(Activity activity, int theme, int defaultUiMode) {
        this.mActivity = new WeakReference<>(activity);
        if (sUiNightMode == 0) {
            sUiNightMode = defaultUiMode;
        }
        updateConfig(sUiNightMode);
        activity.setTheme(theme);
    }

    private void updateConfig(int uiNightMode) {
        Activity activity = this.mActivity.get();
        if (activity == null) {
            throw new IllegalStateException("Activity went away?");
        }
        Configuration configuration = new Configuration(activity.getResources().getConfiguration());
        configuration.uiMode &= -49;
        configuration.uiMode |= uiNightMode;
        activity.getResources().updateConfiguration(configuration, null);
        sUiNightMode = uiNightMode;
        SharedPreferences sharedPreferences = this.mPrefs;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(PREF_KEY, sUiNightMode).apply();
        }
    }

    public static int getUiNightMode() {
        return sUiNightMode;
    }

    public void toggle() {
        if (sUiNightMode == 32) {
            notNight();
        } else {
            night();
        }
    }

    public void notNight() {
        updateConfig(16);
        this.mActivity.get().recreate();
    }

    public void night() {
        updateConfig(32);
        this.mActivity.get().recreate();
    }
}
