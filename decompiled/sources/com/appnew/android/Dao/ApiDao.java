package com.appnew.android.Dao;

import com.appnew.android.table.APITABLE;

/* JADX INFO: loaded from: classes6.dex */
public interface ApiDao {
    long addUser(APITABLE apitable);

    int deleteUser(APITABLE apitable);

    void deletedata();

    APITABLE getapidetail(String apicode, String userid);

    boolean is_api_code_exits(String userid, String apicode);

    int updateUser(APITABLE apitable);

    void update_api_version(String apicode, String userid, String timestamp, String interval, String cdtimestamp);

    int updateversion(String version, String userid, String apicode);
}
