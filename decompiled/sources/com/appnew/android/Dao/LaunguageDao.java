package com.appnew.android.Dao;

import com.appnew.android.table.LanguagesTable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface LaunguageDao {
    long addLaunguage(LanguagesTable languagesTable);

    void deletedata();

    List<LanguagesTable> getLaunguagedetail();
}
