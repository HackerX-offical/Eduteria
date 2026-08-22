package com.appnew.android.Dao;

import com.appnew.android.table.ThemeSettings;

/* JADX INFO: loaded from: classes6.dex */
public interface ThemeSettingDao {
    long addUser(ThemeSettings themeSettings);

    ThemeSettings data();

    int deleteUser(ThemeSettings themeSettings);

    void deletedata();

    boolean is_setting_exit();

    int updateUser(ThemeSettings themeSettings);
}
