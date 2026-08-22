package com.appnew.android.Dao;

import com.appnew.android.table.MasteAllCatTable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface GetMasterAllCatDao {
    long addUser(MasteAllCatTable getMasterData_allcat);

    int deleteUser(MasteAllCatTable getMasterData_allcat);

    void deletedata();

    List<MasteAllCatTable> getAllUser();

    String getfilteddata(String id);

    List<MasteAllCatTable> getmaster_allcat(String userid);

    boolean isRecordExistsUserId(String userid);

    int updateUser(MasteAllCatTable getMasterData_allcat);
}
