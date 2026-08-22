package com.skydoves.powermenu;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes9.dex */
class MenuPreferenceManager {
    private static MenuPreferenceManager menuPreferenceManager = null;
    private static final String position = "_POSITION";
    private final SharedPreferences sharedPreferences;

    private MenuPreferenceManager(Context context) {
        this.sharedPreferences = context.getSharedPreferences("com.skydoves.powermenu", 0);
    }

    protected static void initialize(Context context) {
        menuPreferenceManager = new MenuPreferenceManager(context);
    }

    protected static MenuPreferenceManager getInstance() {
        return menuPreferenceManager;
    }

    protected int getPosition(String str, int i) {
        return this.sharedPreferences.getInt(str, i);
    }

    protected void setPosition(String str, int i) {
        this.sharedPreferences.edit().putInt(str, i).apply();
    }

    protected void clearPosition(String str) {
        this.sharedPreferences.edit().remove(str).apply();
    }
}
