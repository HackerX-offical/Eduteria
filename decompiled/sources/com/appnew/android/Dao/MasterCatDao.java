package com.appnew.android.Dao;

import com.appnew.android.table.MasterCat;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface MasterCatDao {
    long addUser(MasterCat courseTypeMasterTable);

    int deleteUser(MasterCat courseTypeMasterTable);

    void deletedata();

    List<MasterCat> getAllUser();

    List<MasterCat> getmastercat(String userid);

    int updateUser(MasterCat courseTypeMasterTable);
}
