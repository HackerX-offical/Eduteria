package com.appnew.android.Dao;

import com.appnew.android.table.TestTable;

/* JADX INFO: loaded from: classes6.dex */
public interface TestDao {
    long addUser(TestTable audioTable);

    int deleteUser(TestTable audioTable);

    int delete_test_data(String userid, String test_id);

    void deletedata();

    boolean is_test_exit(String test_id, String userid);

    TestTable test_data(String test_id, String userid);

    int updateUser(TestTable audioTable);
}
