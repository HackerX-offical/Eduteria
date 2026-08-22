package com.appnew.android.Dao;

import com.appnew.android.table.CenterIdTable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface CenterIdDao {
    CenterIdTable center_data(String centerId, String userid);

    void delete(CenterIdTable model);

    void delete_test_data(String centerId);

    List<CenterIdTable> getCenterIdList();

    void insert(CenterIdTable model);

    void update(CenterIdTable model);

    void update(String centerID, String centerName, String userID);
}
