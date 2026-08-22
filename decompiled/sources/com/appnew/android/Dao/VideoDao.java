package com.appnew.android.Dao;

import com.appnew.android.table.VideoTable;

/* JADX INFO: loaded from: classes6.dex */
public interface VideoDao {
    long addUser(VideoTable videoTable);

    int deleteUser(VideoTable videoTable);

    void deletedata();

    VideoTable getuser(String videoid, String userid);

    boolean isvideo_exit(String video_id, String user_id);

    int updateUser(VideoTable audioTable);

    void update_video_currentpos(String videoid, String userid, Long getCurrentPosition);

    void update_videotime(String videoid, String userid, Long getCurrentPosition);
}
