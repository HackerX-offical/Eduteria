package com.appnew.android.Dao;

import com.appnew.android.table.PollDataTable;

/* JADX INFO: loaded from: classes6.dex */
public interface PollDataDao {
    void delete(PollDataTable model);

    void delete_poll_data(String poll_Id);

    void insert(PollDataTable model);

    boolean pollData(String poll_Id);

    PollDataTable poll_data(String userid);

    PollDataTable poll_data(String poll_Id, String userid);

    void update(PollDataTable model);
}
