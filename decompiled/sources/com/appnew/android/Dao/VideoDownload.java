package com.appnew.android.Dao;

import com.appnew.android.table.VideosDownload;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface VideoDownload {
    long addUser(VideosDownload videosDownload);

    List<String> courseids(String userid);

    void delete(String videoid, String course_id, String userid);

    int deleteUser(VideosDownload videosDownload);

    void delete_viavideoid(String videoid, String userid);

    void delete_viavideoid_for_audio(String videoid, String userid);

    void delete_viavideoid_for_youtube(String videoid, String userid);

    void deletedata();

    List<VideosDownload> getallcourse_id(String courseid, String userid);

    List<VideosDownload> getalldownload_videos(String user_id);

    List<VideosDownload> getalldownload_videos_for_audio(String user_id);

    List<VideosDownload> getalldownload_videos_for_youtube(String user_id);

    List<VideosDownload> getcourse_expire(String courseid, String userid);

    List<VideosDownload> getcourse_expire_left(String courseid, String userid);

    VideosDownload getuser(String videoid, String complete);

    VideosDownload getuser_for_audio(String videoid, String complete);

    VideosDownload getuser_for_youtube(String videoid, String complete);

    VideosDownload getvideo_byuserid(String videoid, String user_id);

    VideosDownload getvideo_byuserid(String videoid, String complete, String user_id);

    VideosDownload getvideo_byuserid_for_audio(String videoid, String user_id);

    VideosDownload getvideo_byuserid_for_youtube(String videoid, String user_id);

    boolean isLimitedvideo_exit(String video_id, String user_id, String is_limited);

    boolean isRecordExistsUserId(String video_id, String is_complete, String user_id);

    boolean isRecordExistsUserId_for_audio(String video_id, String is_complete, String user_id);

    boolean isRecordExistsUserId_for_youtube(String video_id, String is_complete, String user_id);

    boolean isRecordexist_1(String video_id, String is_complete, String user_id);

    boolean isvideo_exit(String video_id, String user_id);

    boolean isvideo_exit_for_audio(String video_id, String user_id);

    boolean isvideo_exit_for_youtube(String video_id, String user_id);

    int updateUser(VideosDownload videosDownload);

    void update_pos(String userid, String videoid, long getCurrentPosition);

    void update_pos_for_audio(String userid, String videoid, long getCurrentPosition);

    void update_pos_for_youtube(String userid, String videoid, long getCurrentPosition);

    void update_progress(String videoid, String isconpelte, String status, String userid);

    void update_progress_for_audio(String videoid, String isconpelte, String status, String userid);

    void update_progress_for_youtube(String videoid, String isconpelte, String status, String userid);

    void update_videoRemainingtime(String videoid, String userid, String remaining_time);

    void update_videoTotleTime(String videoid, String userid, String video_length);

    void update_videocurrenttime(String videoid, String userid, Long getCurrentPosition, String video_time);

    int update_videofilelenght(String testid, String originalFileLengthString, Long total, String lengthInMb, int percentage, String iscomplete, String status, String videotime, String mp4ulr);

    int update_videofilelenght_for_audio(String testid, String originalFileLengthString, Long total, String lengthInMb, int percentage, String iscomplete, String status, String videotime, String mp4ulr);

    int update_videofilelenght_for_youtube(String testid, String originalFileLengthString, Long total, String lengthInMb, int percentage, String iscomplete, String status, String videotime, String mp4ulr);

    void update_videostatus(String videoid, String status, String user_id);

    void update_videostatus(String testid, String isconpelte, String status, int percentage);

    void update_videostatus_for_audio(String videoid, String status, String user_id);

    void update_videostatus_for_audio(String testid, String isconpelte, String status, int percentage);

    void update_videostatus_for_youtube(String videoid, String status, String user_id);

    void update_videostatus_for_youtube(String testid, String isconpelte, String status, int percentage);
}
