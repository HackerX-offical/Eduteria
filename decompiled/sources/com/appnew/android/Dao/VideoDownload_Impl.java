package com.appnew.android.Dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.appnew.android.Utils.Const;
import com.appnew.android.table.VideosDownload;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class VideoDownload_Impl implements VideoDownload {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<VideosDownload> __deletionAdapterOfVideosDownload;
    private final EntityInsertionAdapter<VideosDownload> __insertionAdapterOfVideosDownload;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfDelete_viavideoid;
    private final SharedSQLiteStatement __preparedStmtOfDelete_viavideoid_for_audio;
    private final SharedSQLiteStatement __preparedStmtOfDelete_viavideoid_for_youtube;
    private final SharedSQLiteStatement __preparedStmtOfDeletedata;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_pos;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_pos_for_audio;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_pos_for_youtube;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_progress;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_progress_for_audio;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_progress_for_youtube;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_videoRemainingtime;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_videoTotleTime;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_videocurrenttime;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_videofilelenght;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_videofilelenght_for_audio;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_videofilelenght_for_youtube;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_videostatus;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_videostatus_1;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_videostatus_for_audio;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_videostatus_for_audio_1;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_videostatus_for_youtube;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_videostatus_for_youtube_1;
    private final EntityDeletionOrUpdateAdapter<VideosDownload> __updateAdapterOfVideosDownload;

    public VideoDownload_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfVideosDownload = new EntityInsertionAdapter<VideosDownload>(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `VideoDownload` (`autoid`,`video_id`,`video_type`,`vdc_id`,`video_name`,`originalFileLengthString`,`videotime`,`link`,`total`,`lengthInMb`,`percentage`,`user_id`,`course_id`,`valid_to`,`remaining_time`,`tile_id`,`multiplayer`,`is_limited`,`video_length`,`with_validity`,`with_validity_message`,`validity_end_date`,`validity_start_date`,`position`,`mp4_download_url`,`video_status`,`thumbnail_url`,`is_complete`,`videoCurrentPosition`,`jw_url`,`is_selected`,`video_history`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final VideosDownload entity) {
                statement.bindLong(1, entity.getAutoid());
                if (entity.getVideo_id() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getVideo_id());
                }
                if (entity.getVideo_type() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getVideo_type());
                }
                if (entity.getVdcId() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getVdcId());
                }
                if (entity.getVideo_name() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getVideo_name());
                }
                if (entity.getOriginalFileLengthString() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getOriginalFileLengthString());
                }
                if (entity.getVideotime() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getVideotime());
                }
                if (entity.getLink() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getLink());
                }
                if (entity.getToal_downloadlocale() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindLong(9, entity.getToal_downloadlocale().longValue());
                }
                if (entity.getLengthInMb() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getLengthInMb());
                }
                statement.bindLong(11, entity.getPercentage());
                if (entity.getUser_id() == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, entity.getUser_id());
                }
                if (entity.getCourse_id() == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, entity.getCourse_id());
                }
                statement.bindLong(14, entity.getValid_to());
                if (entity.getRemaining_time() == null) {
                    statement.bindNull(15);
                } else {
                    statement.bindString(15, entity.getRemaining_time());
                }
                if (entity.getTile_id() == null) {
                    statement.bindNull(16);
                } else {
                    statement.bindString(16, entity.getTile_id());
                }
                if (entity.getMultiplayer() == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindString(17, entity.getMultiplayer());
                }
                if (entity.getIs_limited() == null) {
                    statement.bindNull(18);
                } else {
                    statement.bindString(18, entity.getIs_limited());
                }
                if (entity.getVideo_length() == null) {
                    statement.bindNull(19);
                } else {
                    statement.bindString(19, entity.getVideo_length());
                }
                if (entity.getWith_validity() == null) {
                    statement.bindNull(20);
                } else {
                    statement.bindString(20, entity.getWith_validity());
                }
                if (entity.getWith_validity_message() == null) {
                    statement.bindNull(21);
                } else {
                    statement.bindString(21, entity.getWith_validity_message());
                }
                if (entity.getValidity_end_date() == null) {
                    statement.bindNull(22);
                } else {
                    statement.bindString(22, entity.getValidity_end_date());
                }
                if (entity.getValidity_start_date() == null) {
                    statement.bindNull(23);
                } else {
                    statement.bindString(23, entity.getValidity_start_date());
                }
                statement.bindLong(24, entity.getPosition());
                if (entity.getMp4_download_url() == null) {
                    statement.bindNull(25);
                } else {
                    statement.bindString(25, entity.getMp4_download_url());
                }
                if (entity.getVideo_status() == null) {
                    statement.bindNull(26);
                } else {
                    statement.bindString(26, entity.getVideo_status());
                }
                if (entity.getThumbnail_url() == null) {
                    statement.bindNull(27);
                } else {
                    statement.bindString(27, entity.getThumbnail_url());
                }
                if (entity.getIs_complete() == null) {
                    statement.bindNull(28);
                } else {
                    statement.bindString(28, entity.getIs_complete());
                }
                if (entity.getVideoCurrentPosition() == null) {
                    statement.bindNull(29);
                } else {
                    statement.bindLong(29, entity.getVideoCurrentPosition().longValue());
                }
                if (entity.getJw_url() == null) {
                    statement.bindNull(30);
                } else {
                    statement.bindString(30, entity.getJw_url());
                }
                if (entity.getIs_selected() == null) {
                    statement.bindNull(31);
                } else {
                    statement.bindString(31, entity.getIs_selected());
                }
                if (entity.getVideo_history() == null) {
                    statement.bindNull(32);
                } else {
                    statement.bindString(32, entity.getVideo_history());
                }
            }
        };
        this.__deletionAdapterOfVideosDownload = new EntityDeletionOrUpdateAdapter<VideosDownload>(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `VideoDownload` WHERE `autoid` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final VideosDownload entity) {
                statement.bindLong(1, entity.getAutoid());
            }
        };
        this.__updateAdapterOfVideosDownload = new EntityDeletionOrUpdateAdapter<VideosDownload>(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `VideoDownload` SET `autoid` = ?,`video_id` = ?,`video_type` = ?,`vdc_id` = ?,`video_name` = ?,`originalFileLengthString` = ?,`videotime` = ?,`link` = ?,`total` = ?,`lengthInMb` = ?,`percentage` = ?,`user_id` = ?,`course_id` = ?,`valid_to` = ?,`remaining_time` = ?,`tile_id` = ?,`multiplayer` = ?,`is_limited` = ?,`video_length` = ?,`with_validity` = ?,`with_validity_message` = ?,`validity_end_date` = ?,`validity_start_date` = ?,`position` = ?,`mp4_download_url` = ?,`video_status` = ?,`thumbnail_url` = ?,`is_complete` = ?,`videoCurrentPosition` = ?,`jw_url` = ?,`is_selected` = ?,`video_history` = ? WHERE `autoid` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final VideosDownload entity) {
                statement.bindLong(1, entity.getAutoid());
                if (entity.getVideo_id() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getVideo_id());
                }
                if (entity.getVideo_type() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getVideo_type());
                }
                if (entity.getVdcId() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getVdcId());
                }
                if (entity.getVideo_name() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getVideo_name());
                }
                if (entity.getOriginalFileLengthString() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getOriginalFileLengthString());
                }
                if (entity.getVideotime() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getVideotime());
                }
                if (entity.getLink() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getLink());
                }
                if (entity.getToal_downloadlocale() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindLong(9, entity.getToal_downloadlocale().longValue());
                }
                if (entity.getLengthInMb() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getLengthInMb());
                }
                statement.bindLong(11, entity.getPercentage());
                if (entity.getUser_id() == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, entity.getUser_id());
                }
                if (entity.getCourse_id() == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, entity.getCourse_id());
                }
                statement.bindLong(14, entity.getValid_to());
                if (entity.getRemaining_time() == null) {
                    statement.bindNull(15);
                } else {
                    statement.bindString(15, entity.getRemaining_time());
                }
                if (entity.getTile_id() == null) {
                    statement.bindNull(16);
                } else {
                    statement.bindString(16, entity.getTile_id());
                }
                if (entity.getMultiplayer() == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindString(17, entity.getMultiplayer());
                }
                if (entity.getIs_limited() == null) {
                    statement.bindNull(18);
                } else {
                    statement.bindString(18, entity.getIs_limited());
                }
                if (entity.getVideo_length() == null) {
                    statement.bindNull(19);
                } else {
                    statement.bindString(19, entity.getVideo_length());
                }
                if (entity.getWith_validity() == null) {
                    statement.bindNull(20);
                } else {
                    statement.bindString(20, entity.getWith_validity());
                }
                if (entity.getWith_validity_message() == null) {
                    statement.bindNull(21);
                } else {
                    statement.bindString(21, entity.getWith_validity_message());
                }
                if (entity.getValidity_end_date() == null) {
                    statement.bindNull(22);
                } else {
                    statement.bindString(22, entity.getValidity_end_date());
                }
                if (entity.getValidity_start_date() == null) {
                    statement.bindNull(23);
                } else {
                    statement.bindString(23, entity.getValidity_start_date());
                }
                statement.bindLong(24, entity.getPosition());
                if (entity.getMp4_download_url() == null) {
                    statement.bindNull(25);
                } else {
                    statement.bindString(25, entity.getMp4_download_url());
                }
                if (entity.getVideo_status() == null) {
                    statement.bindNull(26);
                } else {
                    statement.bindString(26, entity.getVideo_status());
                }
                if (entity.getThumbnail_url() == null) {
                    statement.bindNull(27);
                } else {
                    statement.bindString(27, entity.getThumbnail_url());
                }
                if (entity.getIs_complete() == null) {
                    statement.bindNull(28);
                } else {
                    statement.bindString(28, entity.getIs_complete());
                }
                if (entity.getVideoCurrentPosition() == null) {
                    statement.bindNull(29);
                } else {
                    statement.bindLong(29, entity.getVideoCurrentPosition().longValue());
                }
                if (entity.getJw_url() == null) {
                    statement.bindNull(30);
                } else {
                    statement.bindString(30, entity.getJw_url());
                }
                if (entity.getIs_selected() == null) {
                    statement.bindNull(31);
                } else {
                    statement.bindString(31, entity.getIs_selected());
                }
                if (entity.getVideo_history() == null) {
                    statement.bindNull(32);
                } else {
                    statement.bindString(32, entity.getVideo_history());
                }
                statement.bindLong(33, entity.getAutoid());
            }
        };
        this.__preparedStmtOfUpdate_videoRemainingtime = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE VideoDownload SET   remaining_time =?   WHERE video_id = ?    AND user_id =? AND video_type != '15'";
            }
        };
        this.__preparedStmtOfUpdate_videoTotleTime = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE VideoDownload SET   video_length =?   WHERE video_id = ?    AND user_id =? AND video_type != '15'";
            }
        };
        this.__preparedStmtOfUpdate_videofilelenght = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE VideoDownload SET mp4_download_url=? , videotime=? , originalFileLengthString=?  , video_status=?  , total =? , lengthInMb =? , percentage =?  , is_complete =? WHERE video_id = ? AND is_complete = ? AND video_type != '15'";
            }
        };
        this.__preparedStmtOfUpdate_videofilelenght_for_audio = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE VideoDownload SET mp4_download_url=? , videotime=? , originalFileLengthString=?  , video_status=?  , total =? , lengthInMb =? , percentage =?  , is_complete =? WHERE video_id = ? AND is_complete = ? AND video_type == '15'";
            }
        };
        this.__preparedStmtOfUpdate_videofilelenght_for_youtube = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE VideoDownload SET mp4_download_url=? , videotime=? , originalFileLengthString=?  , video_status=?  , total =? , lengthInMb =? , percentage =?  , is_complete =? WHERE video_id = ? AND is_complete = ? AND video_type == '1'";
            }
        };
        this.__preparedStmtOfDelete_viavideoid = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.9
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "Delete from VideoDownload where video_id = ? AND user_id=? AND video_type != '15'";
            }
        };
        this.__preparedStmtOfDelete_viavideoid_for_audio = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.10
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "Delete from VideoDownload where video_id = ? AND user_id=? AND video_type == '15'";
            }
        };
        this.__preparedStmtOfDelete_viavideoid_for_youtube = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.11
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "Delete from VideoDownload where video_id = ? AND user_id=? AND video_type == '1'";
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.12
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "Delete from VideoDownload where video_id = ? AND course_id=? AND user_id=? AND video_type != '15'";
            }
        };
        this.__preparedStmtOfUpdate_videostatus = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.13
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE VideoDownload SET video_status =? , percentage =?  , is_complete =?  WHERE video_id = ? AND video_type != '15'";
            }
        };
        this.__preparedStmtOfUpdate_videostatus_1 = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.14
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE VideoDownload SET  video_status =? , user_id =?  WHERE video_id = ? AND video_type != '15'";
            }
        };
        this.__preparedStmtOfUpdate_videostatus_for_audio = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.15
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE VideoDownload SET video_status =? , percentage =?  , is_complete =?  WHERE video_id = ? AND video_type == '15'";
            }
        };
        this.__preparedStmtOfUpdate_videostatus_for_audio_1 = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.16
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE VideoDownload SET  video_status =? , user_id =?  WHERE video_id = ? AND video_type == '15'";
            }
        };
        this.__preparedStmtOfUpdate_videostatus_for_youtube = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.17
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE VideoDownload SET video_status =? , percentage =?  , is_complete =?  WHERE video_id = ? AND video_type == '1'";
            }
        };
        this.__preparedStmtOfUpdate_videostatus_for_youtube_1 = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.18
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE VideoDownload SET  video_status =? , user_id =?  WHERE video_id = ? AND video_type == '1'";
            }
        };
        this.__preparedStmtOfUpdate_progress = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.19
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE VideoDownload SET  video_status =? , is_complete =?  WHERE video_id = ?  AND user_id =? AND video_type != '15'";
            }
        };
        this.__preparedStmtOfUpdate_progress_for_audio = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.20
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE VideoDownload SET  video_status =? , is_complete =?  WHERE video_id = ?  AND user_id =? AND video_type == '15'";
            }
        };
        this.__preparedStmtOfUpdate_progress_for_youtube = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.21
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE VideoDownload SET  video_status =? , is_complete =?  WHERE video_id = ?  AND user_id =? AND video_type == '1'";
            }
        };
        this.__preparedStmtOfUpdate_videocurrenttime = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.22
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE VideoDownload SET videoCurrentPosition =? ,  videotime = ?  WHERE video_id = ?  AND user_id =? AND video_type != '15'";
            }
        };
        this.__preparedStmtOfDeletedata = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.23
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM VideoDownload";
            }
        };
        this.__preparedStmtOfUpdate_pos = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.24
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE VideoDownload SET   position =?   WHERE video_id = ?  AND user_id =? AND video_type != '15'";
            }
        };
        this.__preparedStmtOfUpdate_pos_for_audio = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.25
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE VideoDownload SET   position =?   WHERE video_id = ?  AND user_id =? AND video_type == '15'";
            }
        };
        this.__preparedStmtOfUpdate_pos_for_youtube = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDownload_Impl.26
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE VideoDownload SET   position =?   WHERE video_id = ?  AND user_id =? AND video_type == '1'";
            }
        };
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public long addUser(final VideosDownload videosDownload) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfVideosDownload.insertAndReturnId(videosDownload);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public int deleteUser(final VideosDownload videosDownload) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfVideosDownload.handle(videosDownload);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public int updateUser(final VideosDownload videosDownload) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfVideosDownload.handle(videosDownload);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public void update_videoRemainingtime(final String videoid, final String userid, final String remaining_time) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_videoRemainingtime.acquire();
        if (remaining_time == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, remaining_time);
        }
        if (videoid == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, videoid);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, userid);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdate_videoRemainingtime.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public void update_videoTotleTime(final String videoid, final String userid, final String video_length) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_videoTotleTime.acquire();
        if (video_length == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, video_length);
        }
        if (videoid == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, videoid);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, userid);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdate_videoTotleTime.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public int update_videofilelenght(final String testid, final String originalFileLengthString, final Long total, final String lengthInMb, final int percentage, final String iscomplete, final String status, final String videotime, final String mp4ulr) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_videofilelenght.acquire();
        if (mp4ulr == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, mp4ulr);
        }
        if (videotime == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, videotime);
        }
        if (originalFileLengthString == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, originalFileLengthString);
        }
        if (status == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, status);
        }
        if (total == null) {
            supportSQLiteStatementAcquire.bindNull(5);
        } else {
            supportSQLiteStatementAcquire.bindLong(5, total.longValue());
        }
        if (lengthInMb == null) {
            supportSQLiteStatementAcquire.bindNull(6);
        } else {
            supportSQLiteStatementAcquire.bindString(6, lengthInMb);
        }
        supportSQLiteStatementAcquire.bindLong(7, percentage);
        if (iscomplete == null) {
            supportSQLiteStatementAcquire.bindNull(8);
        } else {
            supportSQLiteStatementAcquire.bindString(8, iscomplete);
        }
        if (testid == null) {
            supportSQLiteStatementAcquire.bindNull(9);
        } else {
            supportSQLiteStatementAcquire.bindString(9, testid);
        }
        if (iscomplete == null) {
            supportSQLiteStatementAcquire.bindNull(10);
        } else {
            supportSQLiteStatementAcquire.bindString(10, iscomplete);
        }
        try {
            this.__db.beginTransaction();
            try {
                int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                return iExecuteUpdateDelete;
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdate_videofilelenght.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public int update_videofilelenght_for_audio(final String testid, final String originalFileLengthString, final Long total, final String lengthInMb, final int percentage, final String iscomplete, final String status, final String videotime, final String mp4ulr) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_videofilelenght_for_audio.acquire();
        if (mp4ulr == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, mp4ulr);
        }
        if (videotime == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, videotime);
        }
        if (originalFileLengthString == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, originalFileLengthString);
        }
        if (status == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, status);
        }
        if (total == null) {
            supportSQLiteStatementAcquire.bindNull(5);
        } else {
            supportSQLiteStatementAcquire.bindLong(5, total.longValue());
        }
        if (lengthInMb == null) {
            supportSQLiteStatementAcquire.bindNull(6);
        } else {
            supportSQLiteStatementAcquire.bindString(6, lengthInMb);
        }
        supportSQLiteStatementAcquire.bindLong(7, percentage);
        if (iscomplete == null) {
            supportSQLiteStatementAcquire.bindNull(8);
        } else {
            supportSQLiteStatementAcquire.bindString(8, iscomplete);
        }
        if (testid == null) {
            supportSQLiteStatementAcquire.bindNull(9);
        } else {
            supportSQLiteStatementAcquire.bindString(9, testid);
        }
        if (iscomplete == null) {
            supportSQLiteStatementAcquire.bindNull(10);
        } else {
            supportSQLiteStatementAcquire.bindString(10, iscomplete);
        }
        try {
            this.__db.beginTransaction();
            try {
                int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                return iExecuteUpdateDelete;
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdate_videofilelenght_for_audio.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public int update_videofilelenght_for_youtube(final String testid, final String originalFileLengthString, final Long total, final String lengthInMb, final int percentage, final String iscomplete, final String status, final String videotime, final String mp4ulr) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_videofilelenght_for_youtube.acquire();
        if (mp4ulr == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, mp4ulr);
        }
        if (videotime == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, videotime);
        }
        if (originalFileLengthString == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, originalFileLengthString);
        }
        if (status == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, status);
        }
        if (total == null) {
            supportSQLiteStatementAcquire.bindNull(5);
        } else {
            supportSQLiteStatementAcquire.bindLong(5, total.longValue());
        }
        if (lengthInMb == null) {
            supportSQLiteStatementAcquire.bindNull(6);
        } else {
            supportSQLiteStatementAcquire.bindString(6, lengthInMb);
        }
        supportSQLiteStatementAcquire.bindLong(7, percentage);
        if (iscomplete == null) {
            supportSQLiteStatementAcquire.bindNull(8);
        } else {
            supportSQLiteStatementAcquire.bindString(8, iscomplete);
        }
        if (testid == null) {
            supportSQLiteStatementAcquire.bindNull(9);
        } else {
            supportSQLiteStatementAcquire.bindString(9, testid);
        }
        if (iscomplete == null) {
            supportSQLiteStatementAcquire.bindNull(10);
        } else {
            supportSQLiteStatementAcquire.bindString(10, iscomplete);
        }
        try {
            this.__db.beginTransaction();
            try {
                int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                return iExecuteUpdateDelete;
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdate_videofilelenght_for_youtube.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public void delete_viavideoid(final String videoid, final String userid) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete_viavideoid.acquire();
        if (videoid == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, videoid);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, userid);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfDelete_viavideoid.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public void delete_viavideoid_for_audio(final String videoid, final String userid) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete_viavideoid_for_audio.acquire();
        if (videoid == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, videoid);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, userid);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfDelete_viavideoid_for_audio.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public void delete_viavideoid_for_youtube(final String videoid, final String userid) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete_viavideoid_for_youtube.acquire();
        if (videoid == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, videoid);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, userid);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfDelete_viavideoid_for_youtube.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public void delete(final String videoid, final String course_id, final String userid) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete.acquire();
        if (videoid == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, videoid);
        }
        if (course_id == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, course_id);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, userid);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfDelete.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public void update_videostatus(final String testid, final String isconpelte, final String status, final int percentage) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_videostatus.acquire();
        if (status == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, status);
        }
        supportSQLiteStatementAcquire.bindLong(2, percentage);
        if (isconpelte == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, isconpelte);
        }
        if (testid == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, testid);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdate_videostatus.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public void update_videostatus(final String videoid, final String status, final String user_id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_videostatus_1.acquire();
        if (status == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, status);
        }
        if (user_id == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, user_id);
        }
        if (videoid == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, videoid);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdate_videostatus_1.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public void update_videostatus_for_audio(final String testid, final String isconpelte, final String status, final int percentage) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_videostatus_for_audio.acquire();
        if (status == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, status);
        }
        supportSQLiteStatementAcquire.bindLong(2, percentage);
        if (isconpelte == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, isconpelte);
        }
        if (testid == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, testid);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdate_videostatus_for_audio.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public void update_videostatus_for_audio(final String videoid, final String status, final String user_id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_videostatus_for_audio_1.acquire();
        if (status == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, status);
        }
        if (user_id == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, user_id);
        }
        if (videoid == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, videoid);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdate_videostatus_for_audio_1.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public void update_videostatus_for_youtube(final String testid, final String isconpelte, final String status, final int percentage) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_videostatus_for_youtube.acquire();
        if (status == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, status);
        }
        supportSQLiteStatementAcquire.bindLong(2, percentage);
        if (isconpelte == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, isconpelte);
        }
        if (testid == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, testid);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdate_videostatus_for_youtube.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public void update_videostatus_for_youtube(final String videoid, final String status, final String user_id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_videostatus_for_youtube_1.acquire();
        if (status == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, status);
        }
        if (user_id == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, user_id);
        }
        if (videoid == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, videoid);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdate_videostatus_for_youtube_1.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public void update_progress(final String videoid, final String isconpelte, final String status, final String userid) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_progress.acquire();
        if (status == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, status);
        }
        if (isconpelte == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, isconpelte);
        }
        if (videoid == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, videoid);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, userid);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdate_progress.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public void update_progress_for_audio(final String videoid, final String isconpelte, final String status, final String userid) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_progress_for_audio.acquire();
        if (status == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, status);
        }
        if (isconpelte == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, isconpelte);
        }
        if (videoid == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, videoid);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, userid);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdate_progress_for_audio.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public void update_progress_for_youtube(final String videoid, final String isconpelte, final String status, final String userid) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_progress_for_youtube.acquire();
        if (status == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, status);
        }
        if (isconpelte == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, isconpelte);
        }
        if (videoid == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, videoid);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, userid);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdate_progress_for_youtube.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public void update_videocurrenttime(final String videoid, final String userid, final Long getCurrentPosition, final String video_time) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_videocurrenttime.acquire();
        if (getCurrentPosition == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindLong(1, getCurrentPosition.longValue());
        }
        if (video_time == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, video_time);
        }
        if (videoid == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, videoid);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, userid);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdate_videocurrenttime.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public void deletedata() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeletedata.acquire();
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfDeletedata.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public void update_pos(final String userid, final String videoid, final long getCurrentPosition) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_pos.acquire();
        supportSQLiteStatementAcquire.bindLong(1, getCurrentPosition);
        if (videoid == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, videoid);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, userid);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdate_pos.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public void update_pos_for_audio(final String userid, final String videoid, final long getCurrentPosition) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_pos_for_audio.acquire();
        supportSQLiteStatementAcquire.bindLong(1, getCurrentPosition);
        if (videoid == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, videoid);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, userid);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdate_pos_for_audio.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public void update_pos_for_youtube(final String userid, final String videoid, final long getCurrentPosition) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_pos_for_youtube.acquire();
        supportSQLiteStatementAcquire.bindLong(1, getCurrentPosition);
        if (videoid == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, videoid);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, userid);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdate_pos_for_youtube.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public VideosDownload getuser(final String videoid, final String complete) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        VideosDownload videosDownload;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM VideoDownload  WHERE video_id = ? AND is_complete =? AND video_type != '15'", 2);
        if (videoid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, videoid);
        }
        if (complete == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, complete);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_ID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_TYPE);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vdc_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originalFileLengthString");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videotime");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "link");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lengthInMb");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "percentage");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.remaining_time);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tile_id");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "multiplayer");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_limited");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_length");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity_message");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_end_date");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_start_date");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.POSITION);
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mp4_download_url");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_status");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_url");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_complete");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videoCurrentPosition");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jw_url");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_selected");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_history");
                if (cursorQuery.moveToFirst()) {
                    VideosDownload videosDownload2 = new VideosDownload();
                    videosDownload2.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                    videosDownload2.setVideo_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    videosDownload2.setVideo_type(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    videosDownload2.setVdcId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    videosDownload2.setVideo_name(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    videosDownload2.setOriginalFileLengthString(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    videosDownload2.setVideotime(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    videosDownload2.setLink(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    videosDownload2.setToal_downloadlocale(cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)));
                    videosDownload2.setLengthInMb(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    videosDownload2.setPercentage(cursorQuery.getInt(columnIndexOrThrow11));
                    videosDownload2.setUser_id(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    videosDownload2.setCourse_id(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    videosDownload2.setValid_to(cursorQuery.getInt(columnIndexOrThrow14));
                    videosDownload2.setRemaining_time(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                    videosDownload2.setTile_id(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16));
                    videosDownload2.setMultiplayer(cursorQuery.isNull(columnIndexOrThrow17) ? null : cursorQuery.getString(columnIndexOrThrow17));
                    videosDownload2.setIs_limited(cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18));
                    videosDownload2.setVideo_length(cursorQuery.isNull(columnIndexOrThrow19) ? null : cursorQuery.getString(columnIndexOrThrow19));
                    videosDownload2.setWith_validity(cursorQuery.isNull(columnIndexOrThrow20) ? null : cursorQuery.getString(columnIndexOrThrow20));
                    videosDownload2.setWith_validity_message(cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21));
                    videosDownload2.setValidity_end_date(cursorQuery.isNull(columnIndexOrThrow22) ? null : cursorQuery.getString(columnIndexOrThrow22));
                    videosDownload2.setValidity_start_date(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                    videosDownload2.setPosition(cursorQuery.getInt(columnIndexOrThrow24));
                    videosDownload2.setMp4_download_url(cursorQuery.isNull(columnIndexOrThrow25) ? null : cursorQuery.getString(columnIndexOrThrow25));
                    videosDownload2.setVideo_status(cursorQuery.isNull(columnIndexOrThrow26) ? null : cursorQuery.getString(columnIndexOrThrow26));
                    videosDownload2.setThumbnail_url(cursorQuery.isNull(columnIndexOrThrow27) ? null : cursorQuery.getString(columnIndexOrThrow27));
                    videosDownload2.setIs_complete(cursorQuery.isNull(columnIndexOrThrow28) ? null : cursorQuery.getString(columnIndexOrThrow28));
                    videosDownload2.setVideoCurrentPosition(cursorQuery.isNull(columnIndexOrThrow29) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow29)));
                    videosDownload2.setJw_url(cursorQuery.isNull(columnIndexOrThrow30) ? null : cursorQuery.getString(columnIndexOrThrow30));
                    videosDownload2.setIs_selected(cursorQuery.isNull(columnIndexOrThrow31) ? null : cursorQuery.getString(columnIndexOrThrow31));
                    videosDownload2.setVideo_history(cursorQuery.isNull(columnIndexOrThrow32) ? null : cursorQuery.getString(columnIndexOrThrow32));
                    videosDownload = videosDownload2;
                } else {
                    videosDownload = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return videosDownload;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public VideosDownload getuser_for_audio(final String videoid, final String complete) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        VideosDownload videosDownload;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM VideoDownload  WHERE video_id = ? AND is_complete =? AND video_type == '15'", 2);
        if (videoid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, videoid);
        }
        if (complete == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, complete);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_ID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_TYPE);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vdc_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originalFileLengthString");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videotime");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "link");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lengthInMb");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "percentage");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.remaining_time);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tile_id");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "multiplayer");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_limited");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_length");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity_message");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_end_date");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_start_date");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.POSITION);
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mp4_download_url");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_status");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_url");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_complete");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videoCurrentPosition");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jw_url");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_selected");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_history");
                if (cursorQuery.moveToFirst()) {
                    VideosDownload videosDownload2 = new VideosDownload();
                    videosDownload2.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                    videosDownload2.setVideo_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    videosDownload2.setVideo_type(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    videosDownload2.setVdcId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    videosDownload2.setVideo_name(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    videosDownload2.setOriginalFileLengthString(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    videosDownload2.setVideotime(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    videosDownload2.setLink(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    videosDownload2.setToal_downloadlocale(cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)));
                    videosDownload2.setLengthInMb(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    videosDownload2.setPercentage(cursorQuery.getInt(columnIndexOrThrow11));
                    videosDownload2.setUser_id(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    videosDownload2.setCourse_id(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    videosDownload2.setValid_to(cursorQuery.getInt(columnIndexOrThrow14));
                    videosDownload2.setRemaining_time(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                    videosDownload2.setTile_id(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16));
                    videosDownload2.setMultiplayer(cursorQuery.isNull(columnIndexOrThrow17) ? null : cursorQuery.getString(columnIndexOrThrow17));
                    videosDownload2.setIs_limited(cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18));
                    videosDownload2.setVideo_length(cursorQuery.isNull(columnIndexOrThrow19) ? null : cursorQuery.getString(columnIndexOrThrow19));
                    videosDownload2.setWith_validity(cursorQuery.isNull(columnIndexOrThrow20) ? null : cursorQuery.getString(columnIndexOrThrow20));
                    videosDownload2.setWith_validity_message(cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21));
                    videosDownload2.setValidity_end_date(cursorQuery.isNull(columnIndexOrThrow22) ? null : cursorQuery.getString(columnIndexOrThrow22));
                    videosDownload2.setValidity_start_date(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                    videosDownload2.setPosition(cursorQuery.getInt(columnIndexOrThrow24));
                    videosDownload2.setMp4_download_url(cursorQuery.isNull(columnIndexOrThrow25) ? null : cursorQuery.getString(columnIndexOrThrow25));
                    videosDownload2.setVideo_status(cursorQuery.isNull(columnIndexOrThrow26) ? null : cursorQuery.getString(columnIndexOrThrow26));
                    videosDownload2.setThumbnail_url(cursorQuery.isNull(columnIndexOrThrow27) ? null : cursorQuery.getString(columnIndexOrThrow27));
                    videosDownload2.setIs_complete(cursorQuery.isNull(columnIndexOrThrow28) ? null : cursorQuery.getString(columnIndexOrThrow28));
                    videosDownload2.setVideoCurrentPosition(cursorQuery.isNull(columnIndexOrThrow29) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow29)));
                    videosDownload2.setJw_url(cursorQuery.isNull(columnIndexOrThrow30) ? null : cursorQuery.getString(columnIndexOrThrow30));
                    videosDownload2.setIs_selected(cursorQuery.isNull(columnIndexOrThrow31) ? null : cursorQuery.getString(columnIndexOrThrow31));
                    videosDownload2.setVideo_history(cursorQuery.isNull(columnIndexOrThrow32) ? null : cursorQuery.getString(columnIndexOrThrow32));
                    videosDownload = videosDownload2;
                } else {
                    videosDownload = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return videosDownload;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public VideosDownload getuser_for_youtube(final String videoid, final String complete) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        VideosDownload videosDownload;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM VideoDownload  WHERE video_id = ? AND is_complete =? AND video_type == '1'", 2);
        if (videoid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, videoid);
        }
        if (complete == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, complete);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_ID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_TYPE);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vdc_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originalFileLengthString");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videotime");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "link");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lengthInMb");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "percentage");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.remaining_time);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tile_id");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "multiplayer");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_limited");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_length");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity_message");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_end_date");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_start_date");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.POSITION);
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mp4_download_url");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_status");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_url");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_complete");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videoCurrentPosition");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jw_url");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_selected");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_history");
                if (cursorQuery.moveToFirst()) {
                    VideosDownload videosDownload2 = new VideosDownload();
                    videosDownload2.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                    videosDownload2.setVideo_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    videosDownload2.setVideo_type(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    videosDownload2.setVdcId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    videosDownload2.setVideo_name(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    videosDownload2.setOriginalFileLengthString(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    videosDownload2.setVideotime(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    videosDownload2.setLink(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    videosDownload2.setToal_downloadlocale(cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)));
                    videosDownload2.setLengthInMb(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    videosDownload2.setPercentage(cursorQuery.getInt(columnIndexOrThrow11));
                    videosDownload2.setUser_id(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    videosDownload2.setCourse_id(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    videosDownload2.setValid_to(cursorQuery.getInt(columnIndexOrThrow14));
                    videosDownload2.setRemaining_time(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                    videosDownload2.setTile_id(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16));
                    videosDownload2.setMultiplayer(cursorQuery.isNull(columnIndexOrThrow17) ? null : cursorQuery.getString(columnIndexOrThrow17));
                    videosDownload2.setIs_limited(cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18));
                    videosDownload2.setVideo_length(cursorQuery.isNull(columnIndexOrThrow19) ? null : cursorQuery.getString(columnIndexOrThrow19));
                    videosDownload2.setWith_validity(cursorQuery.isNull(columnIndexOrThrow20) ? null : cursorQuery.getString(columnIndexOrThrow20));
                    videosDownload2.setWith_validity_message(cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21));
                    videosDownload2.setValidity_end_date(cursorQuery.isNull(columnIndexOrThrow22) ? null : cursorQuery.getString(columnIndexOrThrow22));
                    videosDownload2.setValidity_start_date(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                    videosDownload2.setPosition(cursorQuery.getInt(columnIndexOrThrow24));
                    videosDownload2.setMp4_download_url(cursorQuery.isNull(columnIndexOrThrow25) ? null : cursorQuery.getString(columnIndexOrThrow25));
                    videosDownload2.setVideo_status(cursorQuery.isNull(columnIndexOrThrow26) ? null : cursorQuery.getString(columnIndexOrThrow26));
                    videosDownload2.setThumbnail_url(cursorQuery.isNull(columnIndexOrThrow27) ? null : cursorQuery.getString(columnIndexOrThrow27));
                    videosDownload2.setIs_complete(cursorQuery.isNull(columnIndexOrThrow28) ? null : cursorQuery.getString(columnIndexOrThrow28));
                    videosDownload2.setVideoCurrentPosition(cursorQuery.isNull(columnIndexOrThrow29) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow29)));
                    videosDownload2.setJw_url(cursorQuery.isNull(columnIndexOrThrow30) ? null : cursorQuery.getString(columnIndexOrThrow30));
                    videosDownload2.setIs_selected(cursorQuery.isNull(columnIndexOrThrow31) ? null : cursorQuery.getString(columnIndexOrThrow31));
                    videosDownload2.setVideo_history(cursorQuery.isNull(columnIndexOrThrow32) ? null : cursorQuery.getString(columnIndexOrThrow32));
                    videosDownload = videosDownload2;
                } else {
                    videosDownload = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return videosDownload;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public VideosDownload getvideo_byuserid(final String videoid, final String complete, final String user_id) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        VideosDownload videosDownload;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM VideoDownload  WHERE video_id = ? AND is_complete =? AND user_id =? AND video_type != '15'", 3);
        if (videoid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, videoid);
        }
        if (complete == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, complete);
        }
        if (user_id == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, user_id);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_ID);
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_TYPE);
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vdc_id");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_name");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originalFileLengthString");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videotime");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "link");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lengthInMb");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "percentage");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.remaining_time);
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tile_id");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "multiplayer");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_limited");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_length");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity_message");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_end_date");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_start_date");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.POSITION);
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mp4_download_url");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_status");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_url");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_complete");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videoCurrentPosition");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jw_url");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_selected");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_history");
            if (cursorQuery.moveToFirst()) {
                VideosDownload videosDownload2 = new VideosDownload();
                videosDownload2.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                videosDownload2.setVideo_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                videosDownload2.setVideo_type(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                videosDownload2.setVdcId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                videosDownload2.setVideo_name(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                videosDownload2.setOriginalFileLengthString(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                videosDownload2.setVideotime(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                videosDownload2.setLink(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                videosDownload2.setToal_downloadlocale(cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)));
                videosDownload2.setLengthInMb(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                videosDownload2.setPercentage(cursorQuery.getInt(columnIndexOrThrow11));
                videosDownload2.setUser_id(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                videosDownload2.setCourse_id(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                videosDownload2.setValid_to(cursorQuery.getInt(columnIndexOrThrow14));
                videosDownload2.setRemaining_time(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                videosDownload2.setTile_id(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16));
                videosDownload2.setMultiplayer(cursorQuery.isNull(columnIndexOrThrow17) ? null : cursorQuery.getString(columnIndexOrThrow17));
                videosDownload2.setIs_limited(cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18));
                videosDownload2.setVideo_length(cursorQuery.isNull(columnIndexOrThrow19) ? null : cursorQuery.getString(columnIndexOrThrow19));
                videosDownload2.setWith_validity(cursorQuery.isNull(columnIndexOrThrow20) ? null : cursorQuery.getString(columnIndexOrThrow20));
                videosDownload2.setWith_validity_message(cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21));
                videosDownload2.setValidity_end_date(cursorQuery.isNull(columnIndexOrThrow22) ? null : cursorQuery.getString(columnIndexOrThrow22));
                videosDownload2.setValidity_start_date(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                videosDownload2.setPosition(cursorQuery.getInt(columnIndexOrThrow24));
                videosDownload2.setMp4_download_url(cursorQuery.isNull(columnIndexOrThrow25) ? null : cursorQuery.getString(columnIndexOrThrow25));
                videosDownload2.setVideo_status(cursorQuery.isNull(columnIndexOrThrow26) ? null : cursorQuery.getString(columnIndexOrThrow26));
                videosDownload2.setThumbnail_url(cursorQuery.isNull(columnIndexOrThrow27) ? null : cursorQuery.getString(columnIndexOrThrow27));
                videosDownload2.setIs_complete(cursorQuery.isNull(columnIndexOrThrow28) ? null : cursorQuery.getString(columnIndexOrThrow28));
                videosDownload2.setVideoCurrentPosition(cursorQuery.isNull(columnIndexOrThrow29) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow29)));
                videosDownload2.setJw_url(cursorQuery.isNull(columnIndexOrThrow30) ? null : cursorQuery.getString(columnIndexOrThrow30));
                videosDownload2.setIs_selected(cursorQuery.isNull(columnIndexOrThrow31) ? null : cursorQuery.getString(columnIndexOrThrow31));
                videosDownload2.setVideo_history(cursorQuery.isNull(columnIndexOrThrow32) ? null : cursorQuery.getString(columnIndexOrThrow32));
                videosDownload = videosDownload2;
            } else {
                videosDownload = null;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return videosDownload;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public VideosDownload getvideo_byuserid(final String videoid, final String user_id) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        VideosDownload videosDownload;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM VideoDownload  WHERE video_id = ? AND user_id =? AND video_type != '15'", 2);
        if (videoid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, videoid);
        }
        if (user_id == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, user_id);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_ID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_TYPE);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vdc_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originalFileLengthString");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videotime");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "link");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lengthInMb");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "percentage");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.remaining_time);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tile_id");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "multiplayer");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_limited");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_length");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity_message");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_end_date");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_start_date");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.POSITION);
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mp4_download_url");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_status");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_url");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_complete");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videoCurrentPosition");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jw_url");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_selected");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_history");
                if (cursorQuery.moveToFirst()) {
                    VideosDownload videosDownload2 = new VideosDownload();
                    videosDownload2.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                    videosDownload2.setVideo_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    videosDownload2.setVideo_type(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    videosDownload2.setVdcId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    videosDownload2.setVideo_name(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    videosDownload2.setOriginalFileLengthString(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    videosDownload2.setVideotime(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    videosDownload2.setLink(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    videosDownload2.setToal_downloadlocale(cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)));
                    videosDownload2.setLengthInMb(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    videosDownload2.setPercentage(cursorQuery.getInt(columnIndexOrThrow11));
                    videosDownload2.setUser_id(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    videosDownload2.setCourse_id(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    videosDownload2.setValid_to(cursorQuery.getInt(columnIndexOrThrow14));
                    videosDownload2.setRemaining_time(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                    videosDownload2.setTile_id(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16));
                    videosDownload2.setMultiplayer(cursorQuery.isNull(columnIndexOrThrow17) ? null : cursorQuery.getString(columnIndexOrThrow17));
                    videosDownload2.setIs_limited(cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18));
                    videosDownload2.setVideo_length(cursorQuery.isNull(columnIndexOrThrow19) ? null : cursorQuery.getString(columnIndexOrThrow19));
                    videosDownload2.setWith_validity(cursorQuery.isNull(columnIndexOrThrow20) ? null : cursorQuery.getString(columnIndexOrThrow20));
                    videosDownload2.setWith_validity_message(cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21));
                    videosDownload2.setValidity_end_date(cursorQuery.isNull(columnIndexOrThrow22) ? null : cursorQuery.getString(columnIndexOrThrow22));
                    videosDownload2.setValidity_start_date(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                    videosDownload2.setPosition(cursorQuery.getInt(columnIndexOrThrow24));
                    videosDownload2.setMp4_download_url(cursorQuery.isNull(columnIndexOrThrow25) ? null : cursorQuery.getString(columnIndexOrThrow25));
                    videosDownload2.setVideo_status(cursorQuery.isNull(columnIndexOrThrow26) ? null : cursorQuery.getString(columnIndexOrThrow26));
                    videosDownload2.setThumbnail_url(cursorQuery.isNull(columnIndexOrThrow27) ? null : cursorQuery.getString(columnIndexOrThrow27));
                    videosDownload2.setIs_complete(cursorQuery.isNull(columnIndexOrThrow28) ? null : cursorQuery.getString(columnIndexOrThrow28));
                    videosDownload2.setVideoCurrentPosition(cursorQuery.isNull(columnIndexOrThrow29) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow29)));
                    videosDownload2.setJw_url(cursorQuery.isNull(columnIndexOrThrow30) ? null : cursorQuery.getString(columnIndexOrThrow30));
                    videosDownload2.setIs_selected(cursorQuery.isNull(columnIndexOrThrow31) ? null : cursorQuery.getString(columnIndexOrThrow31));
                    videosDownload2.setVideo_history(cursorQuery.isNull(columnIndexOrThrow32) ? null : cursorQuery.getString(columnIndexOrThrow32));
                    videosDownload = videosDownload2;
                } else {
                    videosDownload = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return videosDownload;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public VideosDownload getvideo_byuserid_for_audio(final String videoid, final String user_id) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        VideosDownload videosDownload;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM VideoDownload  WHERE video_id = ?  AND user_id =? AND video_type == '15'", 2);
        if (videoid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, videoid);
        }
        if (user_id == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, user_id);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_ID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_TYPE);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vdc_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originalFileLengthString");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videotime");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "link");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lengthInMb");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "percentage");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.remaining_time);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tile_id");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "multiplayer");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_limited");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_length");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity_message");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_end_date");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_start_date");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.POSITION);
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mp4_download_url");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_status");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_url");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_complete");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videoCurrentPosition");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jw_url");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_selected");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_history");
                if (cursorQuery.moveToFirst()) {
                    VideosDownload videosDownload2 = new VideosDownload();
                    videosDownload2.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                    videosDownload2.setVideo_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    videosDownload2.setVideo_type(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    videosDownload2.setVdcId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    videosDownload2.setVideo_name(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    videosDownload2.setOriginalFileLengthString(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    videosDownload2.setVideotime(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    videosDownload2.setLink(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    videosDownload2.setToal_downloadlocale(cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)));
                    videosDownload2.setLengthInMb(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    videosDownload2.setPercentage(cursorQuery.getInt(columnIndexOrThrow11));
                    videosDownload2.setUser_id(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    videosDownload2.setCourse_id(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    videosDownload2.setValid_to(cursorQuery.getInt(columnIndexOrThrow14));
                    videosDownload2.setRemaining_time(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                    videosDownload2.setTile_id(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16));
                    videosDownload2.setMultiplayer(cursorQuery.isNull(columnIndexOrThrow17) ? null : cursorQuery.getString(columnIndexOrThrow17));
                    videosDownload2.setIs_limited(cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18));
                    videosDownload2.setVideo_length(cursorQuery.isNull(columnIndexOrThrow19) ? null : cursorQuery.getString(columnIndexOrThrow19));
                    videosDownload2.setWith_validity(cursorQuery.isNull(columnIndexOrThrow20) ? null : cursorQuery.getString(columnIndexOrThrow20));
                    videosDownload2.setWith_validity_message(cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21));
                    videosDownload2.setValidity_end_date(cursorQuery.isNull(columnIndexOrThrow22) ? null : cursorQuery.getString(columnIndexOrThrow22));
                    videosDownload2.setValidity_start_date(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                    videosDownload2.setPosition(cursorQuery.getInt(columnIndexOrThrow24));
                    videosDownload2.setMp4_download_url(cursorQuery.isNull(columnIndexOrThrow25) ? null : cursorQuery.getString(columnIndexOrThrow25));
                    videosDownload2.setVideo_status(cursorQuery.isNull(columnIndexOrThrow26) ? null : cursorQuery.getString(columnIndexOrThrow26));
                    videosDownload2.setThumbnail_url(cursorQuery.isNull(columnIndexOrThrow27) ? null : cursorQuery.getString(columnIndexOrThrow27));
                    videosDownload2.setIs_complete(cursorQuery.isNull(columnIndexOrThrow28) ? null : cursorQuery.getString(columnIndexOrThrow28));
                    videosDownload2.setVideoCurrentPosition(cursorQuery.isNull(columnIndexOrThrow29) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow29)));
                    videosDownload2.setJw_url(cursorQuery.isNull(columnIndexOrThrow30) ? null : cursorQuery.getString(columnIndexOrThrow30));
                    videosDownload2.setIs_selected(cursorQuery.isNull(columnIndexOrThrow31) ? null : cursorQuery.getString(columnIndexOrThrow31));
                    videosDownload2.setVideo_history(cursorQuery.isNull(columnIndexOrThrow32) ? null : cursorQuery.getString(columnIndexOrThrow32));
                    videosDownload = videosDownload2;
                } else {
                    videosDownload = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return videosDownload;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public VideosDownload getvideo_byuserid_for_youtube(final String videoid, final String user_id) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        VideosDownload videosDownload;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM VideoDownload  WHERE video_id = ?  AND user_id =? AND video_type == '1'", 2);
        if (videoid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, videoid);
        }
        if (user_id == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, user_id);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_ID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_TYPE);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vdc_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originalFileLengthString");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videotime");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "link");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lengthInMb");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "percentage");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.remaining_time);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tile_id");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "multiplayer");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_limited");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_length");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity_message");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_end_date");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_start_date");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.POSITION);
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mp4_download_url");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_status");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_url");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_complete");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videoCurrentPosition");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jw_url");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_selected");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_history");
                if (cursorQuery.moveToFirst()) {
                    VideosDownload videosDownload2 = new VideosDownload();
                    videosDownload2.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                    videosDownload2.setVideo_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    videosDownload2.setVideo_type(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    videosDownload2.setVdcId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    videosDownload2.setVideo_name(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    videosDownload2.setOriginalFileLengthString(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    videosDownload2.setVideotime(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    videosDownload2.setLink(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    videosDownload2.setToal_downloadlocale(cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)));
                    videosDownload2.setLengthInMb(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    videosDownload2.setPercentage(cursorQuery.getInt(columnIndexOrThrow11));
                    videosDownload2.setUser_id(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    videosDownload2.setCourse_id(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    videosDownload2.setValid_to(cursorQuery.getInt(columnIndexOrThrow14));
                    videosDownload2.setRemaining_time(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                    videosDownload2.setTile_id(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16));
                    videosDownload2.setMultiplayer(cursorQuery.isNull(columnIndexOrThrow17) ? null : cursorQuery.getString(columnIndexOrThrow17));
                    videosDownload2.setIs_limited(cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18));
                    videosDownload2.setVideo_length(cursorQuery.isNull(columnIndexOrThrow19) ? null : cursorQuery.getString(columnIndexOrThrow19));
                    videosDownload2.setWith_validity(cursorQuery.isNull(columnIndexOrThrow20) ? null : cursorQuery.getString(columnIndexOrThrow20));
                    videosDownload2.setWith_validity_message(cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21));
                    videosDownload2.setValidity_end_date(cursorQuery.isNull(columnIndexOrThrow22) ? null : cursorQuery.getString(columnIndexOrThrow22));
                    videosDownload2.setValidity_start_date(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                    videosDownload2.setPosition(cursorQuery.getInt(columnIndexOrThrow24));
                    videosDownload2.setMp4_download_url(cursorQuery.isNull(columnIndexOrThrow25) ? null : cursorQuery.getString(columnIndexOrThrow25));
                    videosDownload2.setVideo_status(cursorQuery.isNull(columnIndexOrThrow26) ? null : cursorQuery.getString(columnIndexOrThrow26));
                    videosDownload2.setThumbnail_url(cursorQuery.isNull(columnIndexOrThrow27) ? null : cursorQuery.getString(columnIndexOrThrow27));
                    videosDownload2.setIs_complete(cursorQuery.isNull(columnIndexOrThrow28) ? null : cursorQuery.getString(columnIndexOrThrow28));
                    videosDownload2.setVideoCurrentPosition(cursorQuery.isNull(columnIndexOrThrow29) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow29)));
                    videosDownload2.setJw_url(cursorQuery.isNull(columnIndexOrThrow30) ? null : cursorQuery.getString(columnIndexOrThrow30));
                    videosDownload2.setIs_selected(cursorQuery.isNull(columnIndexOrThrow31) ? null : cursorQuery.getString(columnIndexOrThrow31));
                    videosDownload2.setVideo_history(cursorQuery.isNull(columnIndexOrThrow32) ? null : cursorQuery.getString(columnIndexOrThrow32));
                    videosDownload = videosDownload2;
                } else {
                    videosDownload = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return videosDownload;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public List<VideosDownload> getalldownload_videos(final String user_id) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        int i2;
        String string10;
        String string11;
        String string12;
        String string13;
        Long lValueOf;
        String string14;
        String string15;
        String string16;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM VideoDownload  WHERE user_id = ? AND video_type != '15'", 1);
        if (user_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, user_id);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_ID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_TYPE);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vdc_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originalFileLengthString");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videotime");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "link");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lengthInMb");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "percentage");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.remaining_time);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tile_id");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "multiplayer");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_limited");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_length");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity_message");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_end_date");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_start_date");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.POSITION);
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mp4_download_url");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_status");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_url");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_complete");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videoCurrentPosition");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jw_url");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_selected");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_history");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    VideosDownload videosDownload = new VideosDownload();
                    ArrayList arrayList2 = arrayList;
                    videosDownload.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                    videosDownload.setVideo_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    videosDownload.setVideo_type(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    videosDownload.setVdcId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    videosDownload.setVideo_name(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    videosDownload.setOriginalFileLengthString(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    videosDownload.setVideotime(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    videosDownload.setLink(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    videosDownload.setToal_downloadlocale(cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)));
                    videosDownload.setLengthInMb(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    videosDownload.setPercentage(cursorQuery.getInt(columnIndexOrThrow11));
                    videosDownload.setUser_id(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    videosDownload.setCourse_id(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i4 = i3;
                    int i5 = columnIndexOrThrow;
                    videosDownload.setValid_to(cursorQuery.getInt(i4));
                    int i6 = columnIndexOrThrow15;
                    if (cursorQuery.isNull(i6)) {
                        i = i6;
                        string = null;
                    } else {
                        i = i6;
                        string = cursorQuery.getString(i6);
                    }
                    videosDownload.setRemaining_time(string);
                    int i7 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i7)) {
                        columnIndexOrThrow16 = i7;
                        string2 = null;
                    } else {
                        columnIndexOrThrow16 = i7;
                        string2 = cursorQuery.getString(i7);
                    }
                    videosDownload.setTile_id(string2);
                    int i8 = columnIndexOrThrow17;
                    if (cursorQuery.isNull(i8)) {
                        columnIndexOrThrow17 = i8;
                        string3 = null;
                    } else {
                        columnIndexOrThrow17 = i8;
                        string3 = cursorQuery.getString(i8);
                    }
                    videosDownload.setMultiplayer(string3);
                    int i9 = columnIndexOrThrow18;
                    if (cursorQuery.isNull(i9)) {
                        columnIndexOrThrow18 = i9;
                        string4 = null;
                    } else {
                        columnIndexOrThrow18 = i9;
                        string4 = cursorQuery.getString(i9);
                    }
                    videosDownload.setIs_limited(string4);
                    int i10 = columnIndexOrThrow19;
                    if (cursorQuery.isNull(i10)) {
                        columnIndexOrThrow19 = i10;
                        string5 = null;
                    } else {
                        columnIndexOrThrow19 = i10;
                        string5 = cursorQuery.getString(i10);
                    }
                    videosDownload.setVideo_length(string5);
                    int i11 = columnIndexOrThrow20;
                    if (cursorQuery.isNull(i11)) {
                        columnIndexOrThrow20 = i11;
                        string6 = null;
                    } else {
                        columnIndexOrThrow20 = i11;
                        string6 = cursorQuery.getString(i11);
                    }
                    videosDownload.setWith_validity(string6);
                    int i12 = columnIndexOrThrow21;
                    if (cursorQuery.isNull(i12)) {
                        columnIndexOrThrow21 = i12;
                        string7 = null;
                    } else {
                        columnIndexOrThrow21 = i12;
                        string7 = cursorQuery.getString(i12);
                    }
                    videosDownload.setWith_validity_message(string7);
                    int i13 = columnIndexOrThrow22;
                    if (cursorQuery.isNull(i13)) {
                        columnIndexOrThrow22 = i13;
                        string8 = null;
                    } else {
                        columnIndexOrThrow22 = i13;
                        string8 = cursorQuery.getString(i13);
                    }
                    videosDownload.setValidity_end_date(string8);
                    int i14 = columnIndexOrThrow23;
                    if (cursorQuery.isNull(i14)) {
                        columnIndexOrThrow23 = i14;
                        string9 = null;
                    } else {
                        columnIndexOrThrow23 = i14;
                        string9 = cursorQuery.getString(i14);
                    }
                    videosDownload.setValidity_start_date(string9);
                    int i15 = columnIndexOrThrow24;
                    videosDownload.setPosition(cursorQuery.getInt(i15));
                    int i16 = columnIndexOrThrow25;
                    if (cursorQuery.isNull(i16)) {
                        i2 = i15;
                        string10 = null;
                    } else {
                        i2 = i15;
                        string10 = cursorQuery.getString(i16);
                    }
                    videosDownload.setMp4_download_url(string10);
                    int i17 = columnIndexOrThrow26;
                    if (cursorQuery.isNull(i17)) {
                        columnIndexOrThrow26 = i17;
                        string11 = null;
                    } else {
                        columnIndexOrThrow26 = i17;
                        string11 = cursorQuery.getString(i17);
                    }
                    videosDownload.setVideo_status(string11);
                    int i18 = columnIndexOrThrow27;
                    if (cursorQuery.isNull(i18)) {
                        columnIndexOrThrow27 = i18;
                        string12 = null;
                    } else {
                        columnIndexOrThrow27 = i18;
                        string12 = cursorQuery.getString(i18);
                    }
                    videosDownload.setThumbnail_url(string12);
                    int i19 = columnIndexOrThrow28;
                    if (cursorQuery.isNull(i19)) {
                        columnIndexOrThrow28 = i19;
                        string13 = null;
                    } else {
                        columnIndexOrThrow28 = i19;
                        string13 = cursorQuery.getString(i19);
                    }
                    videosDownload.setIs_complete(string13);
                    int i20 = columnIndexOrThrow29;
                    if (cursorQuery.isNull(i20)) {
                        columnIndexOrThrow29 = i20;
                        lValueOf = null;
                    } else {
                        columnIndexOrThrow29 = i20;
                        lValueOf = Long.valueOf(cursorQuery.getLong(i20));
                    }
                    videosDownload.setVideoCurrentPosition(lValueOf);
                    int i21 = columnIndexOrThrow30;
                    if (cursorQuery.isNull(i21)) {
                        columnIndexOrThrow30 = i21;
                        string14 = null;
                    } else {
                        columnIndexOrThrow30 = i21;
                        string14 = cursorQuery.getString(i21);
                    }
                    videosDownload.setJw_url(string14);
                    int i22 = columnIndexOrThrow31;
                    if (cursorQuery.isNull(i22)) {
                        columnIndexOrThrow31 = i22;
                        string15 = null;
                    } else {
                        columnIndexOrThrow31 = i22;
                        string15 = cursorQuery.getString(i22);
                    }
                    videosDownload.setIs_selected(string15);
                    int i23 = columnIndexOrThrow32;
                    if (cursorQuery.isNull(i23)) {
                        columnIndexOrThrow32 = i23;
                        string16 = null;
                    } else {
                        columnIndexOrThrow32 = i23;
                        string16 = cursorQuery.getString(i23);
                    }
                    videosDownload.setVideo_history(string16);
                    arrayList2.add(videosDownload);
                    columnIndexOrThrow24 = i2;
                    columnIndexOrThrow25 = i16;
                    arrayList = arrayList2;
                    columnIndexOrThrow = i5;
                    i3 = i4;
                    columnIndexOrThrow15 = i;
                }
                ArrayList arrayList3 = arrayList;
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList3;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public List<VideosDownload> getalldownload_videos_for_audio(final String user_id) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        int i2;
        String string10;
        String string11;
        String string12;
        String string13;
        Long lValueOf;
        String string14;
        String string15;
        String string16;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM VideoDownload  WHERE user_id = ? AND video_type == '15'", 1);
        if (user_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, user_id);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_ID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_TYPE);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vdc_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originalFileLengthString");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videotime");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "link");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lengthInMb");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "percentage");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.remaining_time);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tile_id");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "multiplayer");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_limited");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_length");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity_message");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_end_date");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_start_date");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.POSITION);
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mp4_download_url");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_status");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_url");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_complete");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videoCurrentPosition");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jw_url");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_selected");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_history");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    VideosDownload videosDownload = new VideosDownload();
                    ArrayList arrayList2 = arrayList;
                    videosDownload.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                    videosDownload.setVideo_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    videosDownload.setVideo_type(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    videosDownload.setVdcId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    videosDownload.setVideo_name(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    videosDownload.setOriginalFileLengthString(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    videosDownload.setVideotime(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    videosDownload.setLink(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    videosDownload.setToal_downloadlocale(cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)));
                    videosDownload.setLengthInMb(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    videosDownload.setPercentage(cursorQuery.getInt(columnIndexOrThrow11));
                    videosDownload.setUser_id(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    videosDownload.setCourse_id(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i4 = i3;
                    int i5 = columnIndexOrThrow;
                    videosDownload.setValid_to(cursorQuery.getInt(i4));
                    int i6 = columnIndexOrThrow15;
                    if (cursorQuery.isNull(i6)) {
                        i = i6;
                        string = null;
                    } else {
                        i = i6;
                        string = cursorQuery.getString(i6);
                    }
                    videosDownload.setRemaining_time(string);
                    int i7 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i7)) {
                        columnIndexOrThrow16 = i7;
                        string2 = null;
                    } else {
                        columnIndexOrThrow16 = i7;
                        string2 = cursorQuery.getString(i7);
                    }
                    videosDownload.setTile_id(string2);
                    int i8 = columnIndexOrThrow17;
                    if (cursorQuery.isNull(i8)) {
                        columnIndexOrThrow17 = i8;
                        string3 = null;
                    } else {
                        columnIndexOrThrow17 = i8;
                        string3 = cursorQuery.getString(i8);
                    }
                    videosDownload.setMultiplayer(string3);
                    int i9 = columnIndexOrThrow18;
                    if (cursorQuery.isNull(i9)) {
                        columnIndexOrThrow18 = i9;
                        string4 = null;
                    } else {
                        columnIndexOrThrow18 = i9;
                        string4 = cursorQuery.getString(i9);
                    }
                    videosDownload.setIs_limited(string4);
                    int i10 = columnIndexOrThrow19;
                    if (cursorQuery.isNull(i10)) {
                        columnIndexOrThrow19 = i10;
                        string5 = null;
                    } else {
                        columnIndexOrThrow19 = i10;
                        string5 = cursorQuery.getString(i10);
                    }
                    videosDownload.setVideo_length(string5);
                    int i11 = columnIndexOrThrow20;
                    if (cursorQuery.isNull(i11)) {
                        columnIndexOrThrow20 = i11;
                        string6 = null;
                    } else {
                        columnIndexOrThrow20 = i11;
                        string6 = cursorQuery.getString(i11);
                    }
                    videosDownload.setWith_validity(string6);
                    int i12 = columnIndexOrThrow21;
                    if (cursorQuery.isNull(i12)) {
                        columnIndexOrThrow21 = i12;
                        string7 = null;
                    } else {
                        columnIndexOrThrow21 = i12;
                        string7 = cursorQuery.getString(i12);
                    }
                    videosDownload.setWith_validity_message(string7);
                    int i13 = columnIndexOrThrow22;
                    if (cursorQuery.isNull(i13)) {
                        columnIndexOrThrow22 = i13;
                        string8 = null;
                    } else {
                        columnIndexOrThrow22 = i13;
                        string8 = cursorQuery.getString(i13);
                    }
                    videosDownload.setValidity_end_date(string8);
                    int i14 = columnIndexOrThrow23;
                    if (cursorQuery.isNull(i14)) {
                        columnIndexOrThrow23 = i14;
                        string9 = null;
                    } else {
                        columnIndexOrThrow23 = i14;
                        string9 = cursorQuery.getString(i14);
                    }
                    videosDownload.setValidity_start_date(string9);
                    int i15 = columnIndexOrThrow24;
                    videosDownload.setPosition(cursorQuery.getInt(i15));
                    int i16 = columnIndexOrThrow25;
                    if (cursorQuery.isNull(i16)) {
                        i2 = i15;
                        string10 = null;
                    } else {
                        i2 = i15;
                        string10 = cursorQuery.getString(i16);
                    }
                    videosDownload.setMp4_download_url(string10);
                    int i17 = columnIndexOrThrow26;
                    if (cursorQuery.isNull(i17)) {
                        columnIndexOrThrow26 = i17;
                        string11 = null;
                    } else {
                        columnIndexOrThrow26 = i17;
                        string11 = cursorQuery.getString(i17);
                    }
                    videosDownload.setVideo_status(string11);
                    int i18 = columnIndexOrThrow27;
                    if (cursorQuery.isNull(i18)) {
                        columnIndexOrThrow27 = i18;
                        string12 = null;
                    } else {
                        columnIndexOrThrow27 = i18;
                        string12 = cursorQuery.getString(i18);
                    }
                    videosDownload.setThumbnail_url(string12);
                    int i19 = columnIndexOrThrow28;
                    if (cursorQuery.isNull(i19)) {
                        columnIndexOrThrow28 = i19;
                        string13 = null;
                    } else {
                        columnIndexOrThrow28 = i19;
                        string13 = cursorQuery.getString(i19);
                    }
                    videosDownload.setIs_complete(string13);
                    int i20 = columnIndexOrThrow29;
                    if (cursorQuery.isNull(i20)) {
                        columnIndexOrThrow29 = i20;
                        lValueOf = null;
                    } else {
                        columnIndexOrThrow29 = i20;
                        lValueOf = Long.valueOf(cursorQuery.getLong(i20));
                    }
                    videosDownload.setVideoCurrentPosition(lValueOf);
                    int i21 = columnIndexOrThrow30;
                    if (cursorQuery.isNull(i21)) {
                        columnIndexOrThrow30 = i21;
                        string14 = null;
                    } else {
                        columnIndexOrThrow30 = i21;
                        string14 = cursorQuery.getString(i21);
                    }
                    videosDownload.setJw_url(string14);
                    int i22 = columnIndexOrThrow31;
                    if (cursorQuery.isNull(i22)) {
                        columnIndexOrThrow31 = i22;
                        string15 = null;
                    } else {
                        columnIndexOrThrow31 = i22;
                        string15 = cursorQuery.getString(i22);
                    }
                    videosDownload.setIs_selected(string15);
                    int i23 = columnIndexOrThrow32;
                    if (cursorQuery.isNull(i23)) {
                        columnIndexOrThrow32 = i23;
                        string16 = null;
                    } else {
                        columnIndexOrThrow32 = i23;
                        string16 = cursorQuery.getString(i23);
                    }
                    videosDownload.setVideo_history(string16);
                    arrayList2.add(videosDownload);
                    columnIndexOrThrow24 = i2;
                    columnIndexOrThrow25 = i16;
                    arrayList = arrayList2;
                    columnIndexOrThrow = i5;
                    i3 = i4;
                    columnIndexOrThrow15 = i;
                }
                ArrayList arrayList3 = arrayList;
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList3;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public List<VideosDownload> getalldownload_videos_for_youtube(final String user_id) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        int i2;
        String string10;
        String string11;
        String string12;
        String string13;
        Long lValueOf;
        String string14;
        String string15;
        String string16;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM VideoDownload  WHERE user_id = ? AND video_type == '1'", 1);
        if (user_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, user_id);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_ID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_TYPE);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vdc_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originalFileLengthString");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videotime");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "link");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lengthInMb");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "percentage");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.remaining_time);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tile_id");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "multiplayer");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_limited");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_length");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity_message");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_end_date");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_start_date");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.POSITION);
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mp4_download_url");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_status");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_url");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_complete");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videoCurrentPosition");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jw_url");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_selected");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_history");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    VideosDownload videosDownload = new VideosDownload();
                    ArrayList arrayList2 = arrayList;
                    videosDownload.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                    videosDownload.setVideo_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    videosDownload.setVideo_type(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    videosDownload.setVdcId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    videosDownload.setVideo_name(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    videosDownload.setOriginalFileLengthString(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    videosDownload.setVideotime(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    videosDownload.setLink(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    videosDownload.setToal_downloadlocale(cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)));
                    videosDownload.setLengthInMb(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    videosDownload.setPercentage(cursorQuery.getInt(columnIndexOrThrow11));
                    videosDownload.setUser_id(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    videosDownload.setCourse_id(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i4 = i3;
                    int i5 = columnIndexOrThrow;
                    videosDownload.setValid_to(cursorQuery.getInt(i4));
                    int i6 = columnIndexOrThrow15;
                    if (cursorQuery.isNull(i6)) {
                        i = i6;
                        string = null;
                    } else {
                        i = i6;
                        string = cursorQuery.getString(i6);
                    }
                    videosDownload.setRemaining_time(string);
                    int i7 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i7)) {
                        columnIndexOrThrow16 = i7;
                        string2 = null;
                    } else {
                        columnIndexOrThrow16 = i7;
                        string2 = cursorQuery.getString(i7);
                    }
                    videosDownload.setTile_id(string2);
                    int i8 = columnIndexOrThrow17;
                    if (cursorQuery.isNull(i8)) {
                        columnIndexOrThrow17 = i8;
                        string3 = null;
                    } else {
                        columnIndexOrThrow17 = i8;
                        string3 = cursorQuery.getString(i8);
                    }
                    videosDownload.setMultiplayer(string3);
                    int i9 = columnIndexOrThrow18;
                    if (cursorQuery.isNull(i9)) {
                        columnIndexOrThrow18 = i9;
                        string4 = null;
                    } else {
                        columnIndexOrThrow18 = i9;
                        string4 = cursorQuery.getString(i9);
                    }
                    videosDownload.setIs_limited(string4);
                    int i10 = columnIndexOrThrow19;
                    if (cursorQuery.isNull(i10)) {
                        columnIndexOrThrow19 = i10;
                        string5 = null;
                    } else {
                        columnIndexOrThrow19 = i10;
                        string5 = cursorQuery.getString(i10);
                    }
                    videosDownload.setVideo_length(string5);
                    int i11 = columnIndexOrThrow20;
                    if (cursorQuery.isNull(i11)) {
                        columnIndexOrThrow20 = i11;
                        string6 = null;
                    } else {
                        columnIndexOrThrow20 = i11;
                        string6 = cursorQuery.getString(i11);
                    }
                    videosDownload.setWith_validity(string6);
                    int i12 = columnIndexOrThrow21;
                    if (cursorQuery.isNull(i12)) {
                        columnIndexOrThrow21 = i12;
                        string7 = null;
                    } else {
                        columnIndexOrThrow21 = i12;
                        string7 = cursorQuery.getString(i12);
                    }
                    videosDownload.setWith_validity_message(string7);
                    int i13 = columnIndexOrThrow22;
                    if (cursorQuery.isNull(i13)) {
                        columnIndexOrThrow22 = i13;
                        string8 = null;
                    } else {
                        columnIndexOrThrow22 = i13;
                        string8 = cursorQuery.getString(i13);
                    }
                    videosDownload.setValidity_end_date(string8);
                    int i14 = columnIndexOrThrow23;
                    if (cursorQuery.isNull(i14)) {
                        columnIndexOrThrow23 = i14;
                        string9 = null;
                    } else {
                        columnIndexOrThrow23 = i14;
                        string9 = cursorQuery.getString(i14);
                    }
                    videosDownload.setValidity_start_date(string9);
                    int i15 = columnIndexOrThrow24;
                    videosDownload.setPosition(cursorQuery.getInt(i15));
                    int i16 = columnIndexOrThrow25;
                    if (cursorQuery.isNull(i16)) {
                        i2 = i15;
                        string10 = null;
                    } else {
                        i2 = i15;
                        string10 = cursorQuery.getString(i16);
                    }
                    videosDownload.setMp4_download_url(string10);
                    int i17 = columnIndexOrThrow26;
                    if (cursorQuery.isNull(i17)) {
                        columnIndexOrThrow26 = i17;
                        string11 = null;
                    } else {
                        columnIndexOrThrow26 = i17;
                        string11 = cursorQuery.getString(i17);
                    }
                    videosDownload.setVideo_status(string11);
                    int i18 = columnIndexOrThrow27;
                    if (cursorQuery.isNull(i18)) {
                        columnIndexOrThrow27 = i18;
                        string12 = null;
                    } else {
                        columnIndexOrThrow27 = i18;
                        string12 = cursorQuery.getString(i18);
                    }
                    videosDownload.setThumbnail_url(string12);
                    int i19 = columnIndexOrThrow28;
                    if (cursorQuery.isNull(i19)) {
                        columnIndexOrThrow28 = i19;
                        string13 = null;
                    } else {
                        columnIndexOrThrow28 = i19;
                        string13 = cursorQuery.getString(i19);
                    }
                    videosDownload.setIs_complete(string13);
                    int i20 = columnIndexOrThrow29;
                    if (cursorQuery.isNull(i20)) {
                        columnIndexOrThrow29 = i20;
                        lValueOf = null;
                    } else {
                        columnIndexOrThrow29 = i20;
                        lValueOf = Long.valueOf(cursorQuery.getLong(i20));
                    }
                    videosDownload.setVideoCurrentPosition(lValueOf);
                    int i21 = columnIndexOrThrow30;
                    if (cursorQuery.isNull(i21)) {
                        columnIndexOrThrow30 = i21;
                        string14 = null;
                    } else {
                        columnIndexOrThrow30 = i21;
                        string14 = cursorQuery.getString(i21);
                    }
                    videosDownload.setJw_url(string14);
                    int i22 = columnIndexOrThrow31;
                    if (cursorQuery.isNull(i22)) {
                        columnIndexOrThrow31 = i22;
                        string15 = null;
                    } else {
                        columnIndexOrThrow31 = i22;
                        string15 = cursorQuery.getString(i22);
                    }
                    videosDownload.setIs_selected(string15);
                    int i23 = columnIndexOrThrow32;
                    if (cursorQuery.isNull(i23)) {
                        columnIndexOrThrow32 = i23;
                        string16 = null;
                    } else {
                        columnIndexOrThrow32 = i23;
                        string16 = cursorQuery.getString(i23);
                    }
                    videosDownload.setVideo_history(string16);
                    arrayList2.add(videosDownload);
                    columnIndexOrThrow24 = i2;
                    columnIndexOrThrow25 = i16;
                    arrayList = arrayList2;
                    columnIndexOrThrow = i5;
                    i3 = i4;
                    columnIndexOrThrow15 = i;
                }
                ArrayList arrayList3 = arrayList;
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList3;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public List<VideosDownload> getcourse_expire(final String courseid, final String userid) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        int i2;
        String string10;
        String string11;
        String string12;
        String string13;
        Long lValueOf;
        String string14;
        String string15;
        String string16;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM VideoDownload  WHERE course_id LIKE '%' || ? AND user_id =? AND video_type != '15'", 2);
        if (courseid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, courseid);
        }
        if (userid == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, userid);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_ID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_TYPE);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vdc_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originalFileLengthString");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videotime");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "link");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lengthInMb");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "percentage");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.remaining_time);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tile_id");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "multiplayer");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_limited");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_length");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity_message");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_end_date");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_start_date");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.POSITION);
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mp4_download_url");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_status");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_url");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_complete");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videoCurrentPosition");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jw_url");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_selected");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_history");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    VideosDownload videosDownload = new VideosDownload();
                    ArrayList arrayList2 = arrayList;
                    videosDownload.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                    videosDownload.setVideo_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    videosDownload.setVideo_type(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    videosDownload.setVdcId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    videosDownload.setVideo_name(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    videosDownload.setOriginalFileLengthString(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    videosDownload.setVideotime(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    videosDownload.setLink(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    videosDownload.setToal_downloadlocale(cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)));
                    videosDownload.setLengthInMb(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    videosDownload.setPercentage(cursorQuery.getInt(columnIndexOrThrow11));
                    videosDownload.setUser_id(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    videosDownload.setCourse_id(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i4 = i3;
                    int i5 = columnIndexOrThrow;
                    videosDownload.setValid_to(cursorQuery.getInt(i4));
                    int i6 = columnIndexOrThrow15;
                    if (cursorQuery.isNull(i6)) {
                        columnIndexOrThrow15 = i6;
                        string = null;
                    } else {
                        columnIndexOrThrow15 = i6;
                        string = cursorQuery.getString(i6);
                    }
                    videosDownload.setRemaining_time(string);
                    int i7 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i7)) {
                        i = i7;
                        string2 = null;
                    } else {
                        i = i7;
                        string2 = cursorQuery.getString(i7);
                    }
                    videosDownload.setTile_id(string2);
                    int i8 = columnIndexOrThrow17;
                    if (cursorQuery.isNull(i8)) {
                        columnIndexOrThrow17 = i8;
                        string3 = null;
                    } else {
                        columnIndexOrThrow17 = i8;
                        string3 = cursorQuery.getString(i8);
                    }
                    videosDownload.setMultiplayer(string3);
                    int i9 = columnIndexOrThrow18;
                    if (cursorQuery.isNull(i9)) {
                        columnIndexOrThrow18 = i9;
                        string4 = null;
                    } else {
                        columnIndexOrThrow18 = i9;
                        string4 = cursorQuery.getString(i9);
                    }
                    videosDownload.setIs_limited(string4);
                    int i10 = columnIndexOrThrow19;
                    if (cursorQuery.isNull(i10)) {
                        columnIndexOrThrow19 = i10;
                        string5 = null;
                    } else {
                        columnIndexOrThrow19 = i10;
                        string5 = cursorQuery.getString(i10);
                    }
                    videosDownload.setVideo_length(string5);
                    int i11 = columnIndexOrThrow20;
                    if (cursorQuery.isNull(i11)) {
                        columnIndexOrThrow20 = i11;
                        string6 = null;
                    } else {
                        columnIndexOrThrow20 = i11;
                        string6 = cursorQuery.getString(i11);
                    }
                    videosDownload.setWith_validity(string6);
                    int i12 = columnIndexOrThrow21;
                    if (cursorQuery.isNull(i12)) {
                        columnIndexOrThrow21 = i12;
                        string7 = null;
                    } else {
                        columnIndexOrThrow21 = i12;
                        string7 = cursorQuery.getString(i12);
                    }
                    videosDownload.setWith_validity_message(string7);
                    int i13 = columnIndexOrThrow22;
                    if (cursorQuery.isNull(i13)) {
                        columnIndexOrThrow22 = i13;
                        string8 = null;
                    } else {
                        columnIndexOrThrow22 = i13;
                        string8 = cursorQuery.getString(i13);
                    }
                    videosDownload.setValidity_end_date(string8);
                    int i14 = columnIndexOrThrow23;
                    if (cursorQuery.isNull(i14)) {
                        columnIndexOrThrow23 = i14;
                        string9 = null;
                    } else {
                        columnIndexOrThrow23 = i14;
                        string9 = cursorQuery.getString(i14);
                    }
                    videosDownload.setValidity_start_date(string9);
                    int i15 = columnIndexOrThrow24;
                    videosDownload.setPosition(cursorQuery.getInt(i15));
                    int i16 = columnIndexOrThrow25;
                    if (cursorQuery.isNull(i16)) {
                        i2 = i15;
                        string10 = null;
                    } else {
                        i2 = i15;
                        string10 = cursorQuery.getString(i16);
                    }
                    videosDownload.setMp4_download_url(string10);
                    int i17 = columnIndexOrThrow26;
                    if (cursorQuery.isNull(i17)) {
                        columnIndexOrThrow26 = i17;
                        string11 = null;
                    } else {
                        columnIndexOrThrow26 = i17;
                        string11 = cursorQuery.getString(i17);
                    }
                    videosDownload.setVideo_status(string11);
                    int i18 = columnIndexOrThrow27;
                    if (cursorQuery.isNull(i18)) {
                        columnIndexOrThrow27 = i18;
                        string12 = null;
                    } else {
                        columnIndexOrThrow27 = i18;
                        string12 = cursorQuery.getString(i18);
                    }
                    videosDownload.setThumbnail_url(string12);
                    int i19 = columnIndexOrThrow28;
                    if (cursorQuery.isNull(i19)) {
                        columnIndexOrThrow28 = i19;
                        string13 = null;
                    } else {
                        columnIndexOrThrow28 = i19;
                        string13 = cursorQuery.getString(i19);
                    }
                    videosDownload.setIs_complete(string13);
                    int i20 = columnIndexOrThrow29;
                    if (cursorQuery.isNull(i20)) {
                        columnIndexOrThrow29 = i20;
                        lValueOf = null;
                    } else {
                        columnIndexOrThrow29 = i20;
                        lValueOf = Long.valueOf(cursorQuery.getLong(i20));
                    }
                    videosDownload.setVideoCurrentPosition(lValueOf);
                    int i21 = columnIndexOrThrow30;
                    if (cursorQuery.isNull(i21)) {
                        columnIndexOrThrow30 = i21;
                        string14 = null;
                    } else {
                        columnIndexOrThrow30 = i21;
                        string14 = cursorQuery.getString(i21);
                    }
                    videosDownload.setJw_url(string14);
                    int i22 = columnIndexOrThrow31;
                    if (cursorQuery.isNull(i22)) {
                        columnIndexOrThrow31 = i22;
                        string15 = null;
                    } else {
                        columnIndexOrThrow31 = i22;
                        string15 = cursorQuery.getString(i22);
                    }
                    videosDownload.setIs_selected(string15);
                    int i23 = columnIndexOrThrow32;
                    if (cursorQuery.isNull(i23)) {
                        columnIndexOrThrow32 = i23;
                        string16 = null;
                    } else {
                        columnIndexOrThrow32 = i23;
                        string16 = cursorQuery.getString(i23);
                    }
                    videosDownload.setVideo_history(string16);
                    arrayList2.add(videosDownload);
                    columnIndexOrThrow24 = i2;
                    columnIndexOrThrow25 = i16;
                    arrayList = arrayList2;
                    columnIndexOrThrow = i5;
                    i3 = i4;
                    columnIndexOrThrow16 = i;
                }
                ArrayList arrayList3 = arrayList;
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList3;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public List<VideosDownload> getcourse_expire_left(final String courseid, final String userid) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        int i2;
        String string10;
        String string11;
        String string12;
        String string13;
        Long lValueOf;
        String string14;
        String string15;
        String string16;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM VideoDownload  WHERE course_id LIKE ? || '%' AND user_id =? AND video_type != '15'", 2);
        if (courseid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, courseid);
        }
        if (userid == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, userid);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_ID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_TYPE);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vdc_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originalFileLengthString");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videotime");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "link");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lengthInMb");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "percentage");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.remaining_time);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tile_id");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "multiplayer");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_limited");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_length");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity_message");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_end_date");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_start_date");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.POSITION);
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mp4_download_url");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_status");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_url");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_complete");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videoCurrentPosition");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jw_url");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_selected");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_history");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    VideosDownload videosDownload = new VideosDownload();
                    ArrayList arrayList2 = arrayList;
                    videosDownload.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                    videosDownload.setVideo_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    videosDownload.setVideo_type(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    videosDownload.setVdcId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    videosDownload.setVideo_name(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    videosDownload.setOriginalFileLengthString(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    videosDownload.setVideotime(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    videosDownload.setLink(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    videosDownload.setToal_downloadlocale(cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)));
                    videosDownload.setLengthInMb(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    videosDownload.setPercentage(cursorQuery.getInt(columnIndexOrThrow11));
                    videosDownload.setUser_id(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    videosDownload.setCourse_id(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i4 = i3;
                    int i5 = columnIndexOrThrow;
                    videosDownload.setValid_to(cursorQuery.getInt(i4));
                    int i6 = columnIndexOrThrow15;
                    if (cursorQuery.isNull(i6)) {
                        columnIndexOrThrow15 = i6;
                        string = null;
                    } else {
                        columnIndexOrThrow15 = i6;
                        string = cursorQuery.getString(i6);
                    }
                    videosDownload.setRemaining_time(string);
                    int i7 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i7)) {
                        i = i7;
                        string2 = null;
                    } else {
                        i = i7;
                        string2 = cursorQuery.getString(i7);
                    }
                    videosDownload.setTile_id(string2);
                    int i8 = columnIndexOrThrow17;
                    if (cursorQuery.isNull(i8)) {
                        columnIndexOrThrow17 = i8;
                        string3 = null;
                    } else {
                        columnIndexOrThrow17 = i8;
                        string3 = cursorQuery.getString(i8);
                    }
                    videosDownload.setMultiplayer(string3);
                    int i9 = columnIndexOrThrow18;
                    if (cursorQuery.isNull(i9)) {
                        columnIndexOrThrow18 = i9;
                        string4 = null;
                    } else {
                        columnIndexOrThrow18 = i9;
                        string4 = cursorQuery.getString(i9);
                    }
                    videosDownload.setIs_limited(string4);
                    int i10 = columnIndexOrThrow19;
                    if (cursorQuery.isNull(i10)) {
                        columnIndexOrThrow19 = i10;
                        string5 = null;
                    } else {
                        columnIndexOrThrow19 = i10;
                        string5 = cursorQuery.getString(i10);
                    }
                    videosDownload.setVideo_length(string5);
                    int i11 = columnIndexOrThrow20;
                    if (cursorQuery.isNull(i11)) {
                        columnIndexOrThrow20 = i11;
                        string6 = null;
                    } else {
                        columnIndexOrThrow20 = i11;
                        string6 = cursorQuery.getString(i11);
                    }
                    videosDownload.setWith_validity(string6);
                    int i12 = columnIndexOrThrow21;
                    if (cursorQuery.isNull(i12)) {
                        columnIndexOrThrow21 = i12;
                        string7 = null;
                    } else {
                        columnIndexOrThrow21 = i12;
                        string7 = cursorQuery.getString(i12);
                    }
                    videosDownload.setWith_validity_message(string7);
                    int i13 = columnIndexOrThrow22;
                    if (cursorQuery.isNull(i13)) {
                        columnIndexOrThrow22 = i13;
                        string8 = null;
                    } else {
                        columnIndexOrThrow22 = i13;
                        string8 = cursorQuery.getString(i13);
                    }
                    videosDownload.setValidity_end_date(string8);
                    int i14 = columnIndexOrThrow23;
                    if (cursorQuery.isNull(i14)) {
                        columnIndexOrThrow23 = i14;
                        string9 = null;
                    } else {
                        columnIndexOrThrow23 = i14;
                        string9 = cursorQuery.getString(i14);
                    }
                    videosDownload.setValidity_start_date(string9);
                    int i15 = columnIndexOrThrow24;
                    videosDownload.setPosition(cursorQuery.getInt(i15));
                    int i16 = columnIndexOrThrow25;
                    if (cursorQuery.isNull(i16)) {
                        i2 = i15;
                        string10 = null;
                    } else {
                        i2 = i15;
                        string10 = cursorQuery.getString(i16);
                    }
                    videosDownload.setMp4_download_url(string10);
                    int i17 = columnIndexOrThrow26;
                    if (cursorQuery.isNull(i17)) {
                        columnIndexOrThrow26 = i17;
                        string11 = null;
                    } else {
                        columnIndexOrThrow26 = i17;
                        string11 = cursorQuery.getString(i17);
                    }
                    videosDownload.setVideo_status(string11);
                    int i18 = columnIndexOrThrow27;
                    if (cursorQuery.isNull(i18)) {
                        columnIndexOrThrow27 = i18;
                        string12 = null;
                    } else {
                        columnIndexOrThrow27 = i18;
                        string12 = cursorQuery.getString(i18);
                    }
                    videosDownload.setThumbnail_url(string12);
                    int i19 = columnIndexOrThrow28;
                    if (cursorQuery.isNull(i19)) {
                        columnIndexOrThrow28 = i19;
                        string13 = null;
                    } else {
                        columnIndexOrThrow28 = i19;
                        string13 = cursorQuery.getString(i19);
                    }
                    videosDownload.setIs_complete(string13);
                    int i20 = columnIndexOrThrow29;
                    if (cursorQuery.isNull(i20)) {
                        columnIndexOrThrow29 = i20;
                        lValueOf = null;
                    } else {
                        columnIndexOrThrow29 = i20;
                        lValueOf = Long.valueOf(cursorQuery.getLong(i20));
                    }
                    videosDownload.setVideoCurrentPosition(lValueOf);
                    int i21 = columnIndexOrThrow30;
                    if (cursorQuery.isNull(i21)) {
                        columnIndexOrThrow30 = i21;
                        string14 = null;
                    } else {
                        columnIndexOrThrow30 = i21;
                        string14 = cursorQuery.getString(i21);
                    }
                    videosDownload.setJw_url(string14);
                    int i22 = columnIndexOrThrow31;
                    if (cursorQuery.isNull(i22)) {
                        columnIndexOrThrow31 = i22;
                        string15 = null;
                    } else {
                        columnIndexOrThrow31 = i22;
                        string15 = cursorQuery.getString(i22);
                    }
                    videosDownload.setIs_selected(string15);
                    int i23 = columnIndexOrThrow32;
                    if (cursorQuery.isNull(i23)) {
                        columnIndexOrThrow32 = i23;
                        string16 = null;
                    } else {
                        columnIndexOrThrow32 = i23;
                        string16 = cursorQuery.getString(i23);
                    }
                    videosDownload.setVideo_history(string16);
                    arrayList2.add(videosDownload);
                    columnIndexOrThrow24 = i2;
                    columnIndexOrThrow25 = i16;
                    arrayList = arrayList2;
                    columnIndexOrThrow = i5;
                    i3 = i4;
                    columnIndexOrThrow16 = i;
                }
                ArrayList arrayList3 = arrayList;
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList3;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public List<VideosDownload> getallcourse_id(final String courseid, final String userid) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        int i2;
        String string10;
        String string11;
        String string12;
        String string13;
        Long lValueOf;
        String string14;
        String string15;
        String string16;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM VideoDownload  WHERE course_id LIKE '%' || ? || '%'  AND user_id =? AND video_type != '15'", 2);
        if (courseid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, courseid);
        }
        if (userid == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, userid);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_ID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_TYPE);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vdc_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "originalFileLengthString");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videotime");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "link");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lengthInMb");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "percentage");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.remaining_time);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tile_id");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "multiplayer");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_limited");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_length");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "with_validity_message");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_end_date");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity_start_date");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.POSITION);
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mp4_download_url");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_status");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_url");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_complete");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videoCurrentPosition");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jw_url");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_selected");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_history");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    VideosDownload videosDownload = new VideosDownload();
                    ArrayList arrayList2 = arrayList;
                    videosDownload.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                    videosDownload.setVideo_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    videosDownload.setVideo_type(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    videosDownload.setVdcId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    videosDownload.setVideo_name(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    videosDownload.setOriginalFileLengthString(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    videosDownload.setVideotime(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    videosDownload.setLink(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    videosDownload.setToal_downloadlocale(cursorQuery.isNull(columnIndexOrThrow9) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow9)));
                    videosDownload.setLengthInMb(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    videosDownload.setPercentage(cursorQuery.getInt(columnIndexOrThrow11));
                    videosDownload.setUser_id(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    videosDownload.setCourse_id(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i4 = i3;
                    int i5 = columnIndexOrThrow;
                    videosDownload.setValid_to(cursorQuery.getInt(i4));
                    int i6 = columnIndexOrThrow15;
                    if (cursorQuery.isNull(i6)) {
                        columnIndexOrThrow15 = i6;
                        string = null;
                    } else {
                        columnIndexOrThrow15 = i6;
                        string = cursorQuery.getString(i6);
                    }
                    videosDownload.setRemaining_time(string);
                    int i7 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i7)) {
                        i = i7;
                        string2 = null;
                    } else {
                        i = i7;
                        string2 = cursorQuery.getString(i7);
                    }
                    videosDownload.setTile_id(string2);
                    int i8 = columnIndexOrThrow17;
                    if (cursorQuery.isNull(i8)) {
                        columnIndexOrThrow17 = i8;
                        string3 = null;
                    } else {
                        columnIndexOrThrow17 = i8;
                        string3 = cursorQuery.getString(i8);
                    }
                    videosDownload.setMultiplayer(string3);
                    int i9 = columnIndexOrThrow18;
                    if (cursorQuery.isNull(i9)) {
                        columnIndexOrThrow18 = i9;
                        string4 = null;
                    } else {
                        columnIndexOrThrow18 = i9;
                        string4 = cursorQuery.getString(i9);
                    }
                    videosDownload.setIs_limited(string4);
                    int i10 = columnIndexOrThrow19;
                    if (cursorQuery.isNull(i10)) {
                        columnIndexOrThrow19 = i10;
                        string5 = null;
                    } else {
                        columnIndexOrThrow19 = i10;
                        string5 = cursorQuery.getString(i10);
                    }
                    videosDownload.setVideo_length(string5);
                    int i11 = columnIndexOrThrow20;
                    if (cursorQuery.isNull(i11)) {
                        columnIndexOrThrow20 = i11;
                        string6 = null;
                    } else {
                        columnIndexOrThrow20 = i11;
                        string6 = cursorQuery.getString(i11);
                    }
                    videosDownload.setWith_validity(string6);
                    int i12 = columnIndexOrThrow21;
                    if (cursorQuery.isNull(i12)) {
                        columnIndexOrThrow21 = i12;
                        string7 = null;
                    } else {
                        columnIndexOrThrow21 = i12;
                        string7 = cursorQuery.getString(i12);
                    }
                    videosDownload.setWith_validity_message(string7);
                    int i13 = columnIndexOrThrow22;
                    if (cursorQuery.isNull(i13)) {
                        columnIndexOrThrow22 = i13;
                        string8 = null;
                    } else {
                        columnIndexOrThrow22 = i13;
                        string8 = cursorQuery.getString(i13);
                    }
                    videosDownload.setValidity_end_date(string8);
                    int i14 = columnIndexOrThrow23;
                    if (cursorQuery.isNull(i14)) {
                        columnIndexOrThrow23 = i14;
                        string9 = null;
                    } else {
                        columnIndexOrThrow23 = i14;
                        string9 = cursorQuery.getString(i14);
                    }
                    videosDownload.setValidity_start_date(string9);
                    int i15 = columnIndexOrThrow24;
                    videosDownload.setPosition(cursorQuery.getInt(i15));
                    int i16 = columnIndexOrThrow25;
                    if (cursorQuery.isNull(i16)) {
                        i2 = i15;
                        string10 = null;
                    } else {
                        i2 = i15;
                        string10 = cursorQuery.getString(i16);
                    }
                    videosDownload.setMp4_download_url(string10);
                    int i17 = columnIndexOrThrow26;
                    if (cursorQuery.isNull(i17)) {
                        columnIndexOrThrow26 = i17;
                        string11 = null;
                    } else {
                        columnIndexOrThrow26 = i17;
                        string11 = cursorQuery.getString(i17);
                    }
                    videosDownload.setVideo_status(string11);
                    int i18 = columnIndexOrThrow27;
                    if (cursorQuery.isNull(i18)) {
                        columnIndexOrThrow27 = i18;
                        string12 = null;
                    } else {
                        columnIndexOrThrow27 = i18;
                        string12 = cursorQuery.getString(i18);
                    }
                    videosDownload.setThumbnail_url(string12);
                    int i19 = columnIndexOrThrow28;
                    if (cursorQuery.isNull(i19)) {
                        columnIndexOrThrow28 = i19;
                        string13 = null;
                    } else {
                        columnIndexOrThrow28 = i19;
                        string13 = cursorQuery.getString(i19);
                    }
                    videosDownload.setIs_complete(string13);
                    int i20 = columnIndexOrThrow29;
                    if (cursorQuery.isNull(i20)) {
                        columnIndexOrThrow29 = i20;
                        lValueOf = null;
                    } else {
                        columnIndexOrThrow29 = i20;
                        lValueOf = Long.valueOf(cursorQuery.getLong(i20));
                    }
                    videosDownload.setVideoCurrentPosition(lValueOf);
                    int i21 = columnIndexOrThrow30;
                    if (cursorQuery.isNull(i21)) {
                        columnIndexOrThrow30 = i21;
                        string14 = null;
                    } else {
                        columnIndexOrThrow30 = i21;
                        string14 = cursorQuery.getString(i21);
                    }
                    videosDownload.setJw_url(string14);
                    int i22 = columnIndexOrThrow31;
                    if (cursorQuery.isNull(i22)) {
                        columnIndexOrThrow31 = i22;
                        string15 = null;
                    } else {
                        columnIndexOrThrow31 = i22;
                        string15 = cursorQuery.getString(i22);
                    }
                    videosDownload.setIs_selected(string15);
                    int i23 = columnIndexOrThrow32;
                    if (cursorQuery.isNull(i23)) {
                        columnIndexOrThrow32 = i23;
                        string16 = null;
                    } else {
                        columnIndexOrThrow32 = i23;
                        string16 = cursorQuery.getString(i23);
                    }
                    videosDownload.setVideo_history(string16);
                    arrayList2.add(videosDownload);
                    columnIndexOrThrow24 = i2;
                    columnIndexOrThrow25 = i16;
                    arrayList = arrayList2;
                    columnIndexOrThrow = i5;
                    i3 = i4;
                    columnIndexOrThrow16 = i;
                }
                ArrayList arrayList3 = arrayList;
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList3;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public boolean isRecordExistsUserId(final String video_id, final String is_complete, final String user_id) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM VideoDownload WHERE video_id = ? AND is_complete = ?  AND user_id = ? AND video_type != '15')", 3);
        if (video_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, video_id);
        }
        if (is_complete == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, is_complete);
        }
        if (user_id == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, user_id);
        }
        this.__db.assertNotSuspendingTransaction();
        boolean z = false;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                z = cursorQuery.getInt(0) != 0;
            }
            return z;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public boolean isRecordExistsUserId_for_audio(final String video_id, final String is_complete, final String user_id) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM VideoDownload WHERE video_id = ? AND is_complete = ?  AND user_id = ? AND video_type == '15')", 3);
        if (video_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, video_id);
        }
        if (is_complete == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, is_complete);
        }
        if (user_id == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, user_id);
        }
        this.__db.assertNotSuspendingTransaction();
        boolean z = false;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                z = cursorQuery.getInt(0) != 0;
            }
            return z;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public boolean isRecordExistsUserId_for_youtube(final String video_id, final String is_complete, final String user_id) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM VideoDownload WHERE video_id = ? AND is_complete = ?  AND user_id = ? AND video_type == '1')", 3);
        if (video_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, video_id);
        }
        if (is_complete == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, is_complete);
        }
        if (user_id == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, user_id);
        }
        this.__db.assertNotSuspendingTransaction();
        boolean z = false;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                z = cursorQuery.getInt(0) != 0;
            }
            return z;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public boolean isRecordexist_1(final String video_id, final String is_complete, final String user_id) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM VideoDownload WHERE video_id = ? AND is_complete = ?  AND user_id = ? AND video_type != '15')", 3);
        if (video_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, video_id);
        }
        if (is_complete == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, is_complete);
        }
        if (user_id == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, user_id);
        }
        this.__db.assertNotSuspendingTransaction();
        boolean z = false;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                z = cursorQuery.getInt(0) != 0;
            }
            return z;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public List<String> courseids(final String userid) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT  DISTINCT course_id  FROM VideoDownload  WHERE  user_id=? AND video_type != '15'", 1);
        if (userid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, userid);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public boolean isvideo_exit(final String video_id, final String user_id) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM VideoDownload WHERE video_id = ?   AND user_id = ? AND video_type != '15')", 2);
        if (video_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, video_id);
        }
        if (user_id == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, user_id);
        }
        this.__db.assertNotSuspendingTransaction();
        boolean z = false;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                z = cursorQuery.getInt(0) != 0;
            }
            return z;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public boolean isvideo_exit_for_audio(final String video_id, final String user_id) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM VideoDownload WHERE video_id = ?   AND user_id = ? AND video_type == '15')", 2);
        if (video_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, video_id);
        }
        if (user_id == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, user_id);
        }
        this.__db.assertNotSuspendingTransaction();
        boolean z = false;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                z = cursorQuery.getInt(0) != 0;
            }
            return z;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public boolean isvideo_exit_for_youtube(final String video_id, final String user_id) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM VideoDownload WHERE video_id = ?   AND user_id = ? AND video_type == '1')", 2);
        if (video_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, video_id);
        }
        if (user_id == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, user_id);
        }
        this.__db.assertNotSuspendingTransaction();
        boolean z = false;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                z = cursorQuery.getInt(0) != 0;
            }
            return z;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.VideoDownload
    public boolean isLimitedvideo_exit(final String video_id, final String user_id, final String is_limited) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM VideoDownload WHERE video_id = ?   AND user_id = ? AND is_limited = ? AND video_type != '15')", 3);
        if (video_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, video_id);
        }
        if (user_id == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, user_id);
        }
        if (is_limited == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, is_limited);
        }
        this.__db.assertNotSuspendingTransaction();
        boolean z = false;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                z = cursorQuery.getInt(0) != 0;
            }
            return z;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
