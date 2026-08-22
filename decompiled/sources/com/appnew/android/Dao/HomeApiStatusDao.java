package com.appnew.android.Dao;

import com.appnew.android.table.HomeApiStatusTable;

/* JADX INFO: loaded from: classes6.dex */
public interface HomeApiStatusDao {
    long addCoursedata(HomeApiStatusTable homeApiStatusTable);

    void deletedata();

    HomeApiStatusTable getcoursedetail(String mainid, String userid);

    boolean isRecordExistsUserId(String userid, String mainid);

    int updaterecord(String page, String status, String mainid, String userid);
}
