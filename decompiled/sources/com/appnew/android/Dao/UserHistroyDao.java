package com.appnew.android.Dao;

import com.appnew.android.table.UserHistroyTable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface UserHistroyDao {
    long addUser(UserHistroyTable userHistroyTable);

    List<String> courseids(String userid);

    void delete();

    void delete(String courseid, String Userid);

    int deleteUser(UserHistroyTable userHistroyTable);

    void delete_right(String courseid, String Userid);

    void delete_via_user(String Userid);

    void delete_viavideo_id(String videoid, String course_id, String userid);

    void deletedata();

    void deletevideo_id(String videoid, String userid);

    List<UserHistroyTable> getallhistory(String user_id);

    List<String> getlikehistiry(String user_id, String courseid);

    boolean isRecordExistsUserId(String course_id, String userid);

    int updateUser(UserHistroyTable userHistroyTable);

    UserHistroyTable user_hisorydao(String user_id, String videoid);

    UserHistroyTable user_history(String user_id, String videoid);
}
