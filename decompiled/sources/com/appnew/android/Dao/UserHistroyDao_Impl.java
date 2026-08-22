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
import com.appnew.android.table.UserHistroyTable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class UserHistroyDao_Impl implements UserHistroyDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<UserHistroyTable> __deletionAdapterOfUserHistroyTable;
    private final EntityInsertionAdapter<UserHistroyTable> __insertionAdapterOfUserHistroyTable;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfDelete_1;
    private final SharedSQLiteStatement __preparedStmtOfDelete_right;
    private final SharedSQLiteStatement __preparedStmtOfDelete_via_user;
    private final SharedSQLiteStatement __preparedStmtOfDelete_viavideo_id;
    private final SharedSQLiteStatement __preparedStmtOfDeletedata;
    private final SharedSQLiteStatement __preparedStmtOfDeletevideo_id;
    private final EntityDeletionOrUpdateAdapter<UserHistroyTable> __updateAdapterOfUserHistroyTable;

    public UserHistroyDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfUserHistroyTable = new EntityInsertionAdapter<UserHistroyTable>(__db) { // from class: com.appnew.android.Dao.UserHistroyDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `UserHistroyTable` (`autoid`,`video_id`,`video_name`,`user_id`,`type`,`pdf_name`,`pdf_download`,`youtube_url`,`pdf_url`,`current_time`,`course_id`,`valid_to`,`coursename`,`tileid`,`testid`,`testname`,`topicname`,`url`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final UserHistroyTable entity) {
                statement.bindLong(1, entity.getAutoid());
                if (entity.getVideo_id() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getVideo_id());
                }
                if (entity.getVideo_name() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getVideo_name());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getUser_id());
                }
                if (entity.getType() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getType());
                }
                if (entity.getPdf_name() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getPdf_name());
                }
                if (entity.getPdf_download() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getPdf_download());
                }
                if (entity.getYoutube_url() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getYoutube_url());
                }
                if (entity.getPdf_url() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, entity.getPdf_url());
                }
                if (entity.getCurrent_time() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getCurrent_time());
                }
                if (entity.getCourse_id() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, entity.getCourse_id());
                }
                if (entity.getValid_to() == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, entity.getValid_to());
                }
                if (entity.getCoursename() == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, entity.getCoursename());
                }
                if (entity.getTileid() == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindString(14, entity.getTileid());
                }
                if (entity.getTestid() == null) {
                    statement.bindNull(15);
                } else {
                    statement.bindString(15, entity.getTestid());
                }
                if (entity.getTestname() == null) {
                    statement.bindNull(16);
                } else {
                    statement.bindString(16, entity.getTestname());
                }
                if (entity.getTopicname() == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindString(17, entity.getTopicname());
                }
                if (entity.getUrl() == null) {
                    statement.bindNull(18);
                } else {
                    statement.bindString(18, entity.getUrl());
                }
            }
        };
        this.__deletionAdapterOfUserHistroyTable = new EntityDeletionOrUpdateAdapter<UserHistroyTable>(__db) { // from class: com.appnew.android.Dao.UserHistroyDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `UserHistroyTable` WHERE `autoid` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final UserHistroyTable entity) {
                statement.bindLong(1, entity.getAutoid());
            }
        };
        this.__updateAdapterOfUserHistroyTable = new EntityDeletionOrUpdateAdapter<UserHistroyTable>(__db) { // from class: com.appnew.android.Dao.UserHistroyDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `UserHistroyTable` SET `autoid` = ?,`video_id` = ?,`video_name` = ?,`user_id` = ?,`type` = ?,`pdf_name` = ?,`pdf_download` = ?,`youtube_url` = ?,`pdf_url` = ?,`current_time` = ?,`course_id` = ?,`valid_to` = ?,`coursename` = ?,`tileid` = ?,`testid` = ?,`testname` = ?,`topicname` = ?,`url` = ? WHERE `autoid` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final UserHistroyTable entity) {
                statement.bindLong(1, entity.getAutoid());
                if (entity.getVideo_id() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getVideo_id());
                }
                if (entity.getVideo_name() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getVideo_name());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getUser_id());
                }
                if (entity.getType() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getType());
                }
                if (entity.getPdf_name() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getPdf_name());
                }
                if (entity.getPdf_download() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getPdf_download());
                }
                if (entity.getYoutube_url() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getYoutube_url());
                }
                if (entity.getPdf_url() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, entity.getPdf_url());
                }
                if (entity.getCurrent_time() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getCurrent_time());
                }
                if (entity.getCourse_id() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, entity.getCourse_id());
                }
                if (entity.getValid_to() == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, entity.getValid_to());
                }
                if (entity.getCoursename() == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, entity.getCoursename());
                }
                if (entity.getTileid() == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindString(14, entity.getTileid());
                }
                if (entity.getTestid() == null) {
                    statement.bindNull(15);
                } else {
                    statement.bindString(15, entity.getTestid());
                }
                if (entity.getTestname() == null) {
                    statement.bindNull(16);
                } else {
                    statement.bindString(16, entity.getTestname());
                }
                if (entity.getTopicname() == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindString(17, entity.getTopicname());
                }
                if (entity.getUrl() == null) {
                    statement.bindNull(18);
                } else {
                    statement.bindString(18, entity.getUrl());
                }
                statement.bindLong(19, entity.getAutoid());
            }
        };
        this.__preparedStmtOfDeletedata = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.UserHistroyDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM UserHistroyTable";
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.UserHistroyDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM UserHistroyTable WHERE `current_time` < (SELECT `current_time` FROM UserHistroyTable ORDER BY `current_time` DESC LIMIT 1 OFFSET 1000)";
            }
        };
        this.__preparedStmtOfDelete_1 = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.UserHistroyDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "Delete from UserHistroyTable where course_id LIKE ? || '%'  AND user_id =?";
            }
        };
        this.__preparedStmtOfDelete_right = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.UserHistroyDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "Delete from UserHistroyTable where course_id   LIKE '%' || ?     AND user_id =?";
            }
        };
        this.__preparedStmtOfDelete_via_user = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.UserHistroyDao_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "Delete from UserHistroyTable where user_id =?";
            }
        };
        this.__preparedStmtOfDelete_viavideo_id = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.UserHistroyDao_Impl.9
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "Delete from UserHistroyTable where course_id = ? AND video_id =? AND user_id =?";
            }
        };
        this.__preparedStmtOfDeletevideo_id = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.UserHistroyDao_Impl.10
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "Delete from UserHistroyTable where user_id = ? AND video_id =?";
            }
        };
    }

    @Override // com.appnew.android.Dao.UserHistroyDao
    public long addUser(final UserHistroyTable userHistroyTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfUserHistroyTable.insertAndReturnId(userHistroyTable);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.UserHistroyDao
    public int deleteUser(final UserHistroyTable userHistroyTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfUserHistroyTable.handle(userHistroyTable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.UserHistroyDao
    public int updateUser(final UserHistroyTable userHistroyTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfUserHistroyTable.handle(userHistroyTable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.UserHistroyDao
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

    @Override // com.appnew.android.Dao.UserHistroyDao
    public void delete() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete.acquire();
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

    @Override // com.appnew.android.Dao.UserHistroyDao
    public void delete(final String courseid, final String Userid) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete_1.acquire();
        if (courseid == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, courseid);
        }
        if (Userid == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, Userid);
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
            this.__preparedStmtOfDelete_1.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.UserHistroyDao
    public void delete_right(final String courseid, final String Userid) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete_right.acquire();
        if (courseid == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, courseid);
        }
        if (Userid == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, Userid);
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
            this.__preparedStmtOfDelete_right.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.UserHistroyDao
    public void delete_via_user(final String Userid) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete_via_user.acquire();
        if (Userid == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, Userid);
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
            this.__preparedStmtOfDelete_via_user.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.UserHistroyDao
    public void delete_viavideo_id(final String videoid, final String course_id, final String userid) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete_viavideo_id.acquire();
        if (course_id == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, course_id);
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
            this.__preparedStmtOfDelete_viavideo_id.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.UserHistroyDao
    public void deletevideo_id(final String videoid, final String userid) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeletevideo_id.acquire();
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, userid);
        }
        if (videoid == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, videoid);
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
            this.__preparedStmtOfDeletevideo_id.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.UserHistroyDao
    public List<UserHistroyTable> getallhistory(final String user_id) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        int i2;
        String string2;
        String string3;
        String string4;
        String string5;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM UserHistroyTable  WHERE user_id = ?  ORDER BY `current_time` DESC   LIMIT 1000 OFFSET 0", 1);
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
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pdf_name");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pdf_download");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "youtube_url");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pdf_url");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "current_time");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coursename");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tileid");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "testid");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "testname");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "topicname");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    UserHistroyTable userHistroyTable = new UserHistroyTable();
                    ArrayList arrayList2 = arrayList;
                    userHistroyTable.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                    userHistroyTable.setVideo_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    userHistroyTable.setVideo_name(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    userHistroyTable.setUser_id(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    userHistroyTable.setType(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    userHistroyTable.setPdf_name(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    userHistroyTable.setPdf_download(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    userHistroyTable.setYoutube_url(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    userHistroyTable.setPdf_url(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    userHistroyTable.setCurrent_time(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    userHistroyTable.setCourse_id(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    userHistroyTable.setValid_to(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    userHistroyTable.setCoursename(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i4 = i3;
                    if (cursorQuery.isNull(i4)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = cursorQuery.getString(i4);
                    }
                    userHistroyTable.setTileid(string);
                    int i5 = columnIndexOrThrow15;
                    if (cursorQuery.isNull(i5)) {
                        i2 = i5;
                        string2 = null;
                    } else {
                        i2 = i5;
                        string2 = cursorQuery.getString(i5);
                    }
                    userHistroyTable.setTestid(string2);
                    int i6 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i6)) {
                        columnIndexOrThrow16 = i6;
                        string3 = null;
                    } else {
                        columnIndexOrThrow16 = i6;
                        string3 = cursorQuery.getString(i6);
                    }
                    userHistroyTable.setTestname(string3);
                    int i7 = columnIndexOrThrow17;
                    if (cursorQuery.isNull(i7)) {
                        columnIndexOrThrow17 = i7;
                        string4 = null;
                    } else {
                        columnIndexOrThrow17 = i7;
                        string4 = cursorQuery.getString(i7);
                    }
                    userHistroyTable.setTopicname(string4);
                    int i8 = columnIndexOrThrow18;
                    if (cursorQuery.isNull(i8)) {
                        columnIndexOrThrow18 = i8;
                        string5 = null;
                    } else {
                        columnIndexOrThrow18 = i8;
                        string5 = cursorQuery.getString(i8);
                    }
                    userHistroyTable.setUrl(string5);
                    arrayList2.add(userHistroyTable);
                    columnIndexOrThrow15 = i2;
                    i3 = i4;
                    arrayList = arrayList2;
                    columnIndexOrThrow = i;
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

    @Override // com.appnew.android.Dao.UserHistroyDao
    public UserHistroyTable user_hisorydao(final String user_id, final String videoid) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        UserHistroyTable userHistroyTable;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM UserHistroyTable  WHERE user_id = ? AND video_id =?", 2);
        if (user_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, user_id);
        }
        if (videoid == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, videoid);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_ID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pdf_name");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pdf_download");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "youtube_url");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pdf_url");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "current_time");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coursename");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tileid");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "testid");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "testname");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "topicname");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                if (cursorQuery.moveToFirst()) {
                    UserHistroyTable userHistroyTable2 = new UserHistroyTable();
                    userHistroyTable2.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                    userHistroyTable2.setVideo_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    userHistroyTable2.setVideo_name(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    userHistroyTable2.setUser_id(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    userHistroyTable2.setType(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    userHistroyTable2.setPdf_name(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    userHistroyTable2.setPdf_download(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    userHistroyTable2.setYoutube_url(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    userHistroyTable2.setPdf_url(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    userHistroyTable2.setCurrent_time(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    userHistroyTable2.setCourse_id(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    userHistroyTable2.setValid_to(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    userHistroyTable2.setCoursename(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    userHistroyTable2.setTileid(cursorQuery.isNull(columnIndexOrThrow14) ? null : cursorQuery.getString(columnIndexOrThrow14));
                    userHistroyTable2.setTestid(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                    userHistroyTable2.setTestname(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16));
                    userHistroyTable2.setTopicname(cursorQuery.isNull(columnIndexOrThrow17) ? null : cursorQuery.getString(columnIndexOrThrow17));
                    userHistroyTable2.setUrl(cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18));
                    userHistroyTable = userHistroyTable2;
                } else {
                    userHistroyTable = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return userHistroyTable;
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

    @Override // com.appnew.android.Dao.UserHistroyDao
    public UserHistroyTable user_history(final String user_id, final String videoid) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        UserHistroyTable userHistroyTable;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM UserHistroyTable  WHERE user_id = ?  AND video_id =?", 2);
        if (user_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, user_id);
        }
        if (videoid == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, videoid);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_ID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pdf_name");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pdf_download");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "youtube_url");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pdf_url");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "current_time");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coursename");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tileid");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "testid");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "testname");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "topicname");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                if (cursorQuery.moveToFirst()) {
                    UserHistroyTable userHistroyTable2 = new UserHistroyTable();
                    userHistroyTable2.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                    userHistroyTable2.setVideo_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    userHistroyTable2.setVideo_name(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    userHistroyTable2.setUser_id(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    userHistroyTable2.setType(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    userHistroyTable2.setPdf_name(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    userHistroyTable2.setPdf_download(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    userHistroyTable2.setYoutube_url(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    userHistroyTable2.setPdf_url(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    userHistroyTable2.setCurrent_time(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    userHistroyTable2.setCourse_id(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    userHistroyTable2.setValid_to(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    userHistroyTable2.setCoursename(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    userHistroyTable2.setTileid(cursorQuery.isNull(columnIndexOrThrow14) ? null : cursorQuery.getString(columnIndexOrThrow14));
                    userHistroyTable2.setTestid(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                    userHistroyTable2.setTestname(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16));
                    userHistroyTable2.setTopicname(cursorQuery.isNull(columnIndexOrThrow17) ? null : cursorQuery.getString(columnIndexOrThrow17));
                    userHistroyTable2.setUrl(cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18));
                    userHistroyTable = userHistroyTable2;
                } else {
                    userHistroyTable = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return userHistroyTable;
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

    @Override // com.appnew.android.Dao.UserHistroyDao
    public List<String> getlikehistiry(final String user_id, final String courseid) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT  DISTINCT course_id FROM UserHistroyTable where course_id LIKE '%' || ? || '%'  AND user_id =?", 2);
        if (courseid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, courseid);
        }
        if (user_id == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, user_id);
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

    @Override // com.appnew.android.Dao.UserHistroyDao
    public boolean isRecordExistsUserId(final String course_id, final String userid) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM UserHistroyTable WHERE course_id = ? And user_id=?)", 2);
        if (course_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, course_id);
        }
        if (userid == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, userid);
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

    @Override // com.appnew.android.Dao.UserHistroyDao
    public List<String> courseids(final String userid) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT  DISTINCT course_id  FROM UserHistroyTable  where  user_id=?", 1);
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

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
