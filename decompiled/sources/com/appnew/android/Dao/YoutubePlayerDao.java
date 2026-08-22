package com.appnew.android.Dao;

import com.appnew.android.table.YoutubePlayerTable;

/* JADX INFO: loaded from: classes6.dex */
public interface YoutubePlayerDao {
    long addVideo(YoutubePlayerTable youtubePlayerTable);

    void deletedata();

    YoutubePlayerTable getdata(String userid, String youtubeid);

    long getyoutubedata(String userid, String videoid, String isaudio);

    boolean isUserExist(String videoid, String userid, String isaudio);

    int updateTime(Long youtubetime, String videoid, String userid, String isaudio);
}
