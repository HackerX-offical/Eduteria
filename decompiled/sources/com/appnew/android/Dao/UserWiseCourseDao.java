package com.appnew.android.Dao;

import com.appnew.android.table.UserWiseCourseTable;

/* JADX INFO: loaded from: classes6.dex */
public interface UserWiseCourseDao {
    long addUser(UserWiseCourseTable apitable);

    int deleteUser(UserWiseCourseTable apitable);

    void deletedata();

    UserWiseCourseTable getapidetail(String apicode, String userid);

    boolean is_api_code_exits(String userid, String apicode);

    int updateUser(UserWiseCourseTable apitable);

    void update_api_version(String apicode, String userid, String version);

    int updateversion(String version, String userid, String apicode);
}
