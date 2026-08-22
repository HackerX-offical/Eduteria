package com.appnew.android.Dao;

import com.appnew.android.table.TestResumeTable;

/* JADX INFO: loaded from: classes6.dex */
public interface TestResumeDao {
    void delete(TestResumeTable model);

    void delete_test_data(String test_id);

    void insert(TestResumeTable model);

    boolean testData(String test_id);

    TestResumeTable test_data(String userid);

    TestResumeTable test_data(String test_id, String userid);

    void update(TestResumeTable model);
}
