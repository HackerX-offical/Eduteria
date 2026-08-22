package com.appnew.android.Dao;

import com.appnew.android.table.PigibagTable;

/* JADX INFO: loaded from: classes6.dex */
public interface PigiBag {
    long addApiedata(PigibagTable pigibag);

    void deletedata();

    int deletepigibagdata(String userid);

    PigibagTable getpigidetail(String userid);

    PigibagTable getuserid();

    boolean isRecordExistsUserId(String userid);

    int updaterecord(String userid, String cdtimestamp);
}
