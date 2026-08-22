package com.appnew.android.Dao;

import com.appnew.android.table.BottomMenuTable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface BottomMenuDao {
    long addBottomMenu(BottomMenuTable bottomMenuTable);

    int deleteBottomMenu(BottomMenuTable bottomMenuTable);

    void deleteBottomMenu();

    List<BottomMenuTable> getAllBottomMenu();

    List<BottomMenuTable> getBottomMenu(String userid);

    int updateBottomMenu(BottomMenuTable bottomMenuTable);
}
