package com.appnew.android.Dao;

import com.appnew.android.table.AudioTable;

/* JADX INFO: loaded from: classes6.dex */
public interface AudioDao {
    long addUser(AudioTable audioTable);

    int deleteUser(AudioTable audioTable);

    void deletedata();

    AudioTable getuser(String videoid, String userid);

    boolean isvideo_exit(String video_id, String user_id);

    int updateUser(AudioTable audioTable);

    void update_audio_currentpos(String videoid, String userid, Long getCurrentPosition);

    void update_videotime(String videoid, String userid, Long getCurrentPosition);

    void update_videotime(String videoid, String userid, Long getCurrentPosition, String audio_url);
}
