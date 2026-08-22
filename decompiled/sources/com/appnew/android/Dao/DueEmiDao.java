package com.appnew.android.Dao;

import com.appnew.android.Model.DueEmiTable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface DueEmiDao {
    void addDueEmiData(DueEmiTable dueEmiTable);

    void deleteAllDueEmi();

    void deleteRecord(String id);

    List<DueEmiTable> getDueData();

    DueEmiTable getDueEmiData(String courseId);
}
