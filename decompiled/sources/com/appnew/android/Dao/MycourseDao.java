package com.appnew.android.Dao;

import com.appnew.android.Model.Courselist;
import com.appnew.android.table.MycourseTable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface MycourseDao {
    long addUser(MycourseTable getProfileTable);

    void delete(String course_id, String txn_id);

    int deleteUser(MycourseTable userTable);

    void deletedata();

    List<MycourseTable> getAllUser();

    List<String> getAllcourseid(String userid);

    List<Courselist> getFreecourse(String mrp, String batch_type);

    List<Courselist> getpaidcourse(String batch_type);

    Courselist getuser(String userid, String id, String batch_type);

    boolean isRecordExists(String userid);

    boolean isRecordExistsUserId(String userid, String batch_type, String id);

    int updateUser(MycourseTable userTable);

    int update_course_lastread(String lastread_timestamp, String c_id, String userid);

    int update_course_lastread(String lastread_timestamp, String c_id, String userid, String batch_type);
}
