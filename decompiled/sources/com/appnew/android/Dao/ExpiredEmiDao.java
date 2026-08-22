package com.appnew.android.Dao;

import com.appnew.android.Model.ExpiredEmiModel;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface ExpiredEmiDao {
    void addCancelledData(ExpiredEmiModel courselist);

    void deleteRecord(String id);

    List<ExpiredEmiModel> getCancelledData();
}
