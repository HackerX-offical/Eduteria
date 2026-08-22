package com.appnew.android.Dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.StoreProvider;
import com.appnew.android.table.PostDataTable;
import com.clevertap.android.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class FeedsDao_Impl implements FeedsDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<PostDataTable> __insertionAdapterOfPostDataTable;
    private final SharedSQLiteStatement __preparedStmtOfDeletePost;
    private final SharedSQLiteStatement __preparedStmtOfDeletePosts_via_id;
    private final SharedSQLiteStatement __preparedStmtOfDeletePosts_via_post_type;
    private final SharedSQLiteStatement __preparedStmtOfDeleteSubCatFeed;
    private final SharedSQLiteStatement __preparedStmtOfDeletedata;
    private final SharedSQLiteStatement __preparedStmtOfDeletepost_without_liveclass;
    private final SharedSQLiteStatement __preparedStmtOfUpdateMyLike;
    private final SharedSQLiteStatement __preparedStmtOfUpdateMyjson;
    private final SharedSQLiteStatement __preparedStmtOfUpdatePinnedPost;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_result;

    public FeedsDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfPostDataTable = new EntityInsertionAdapter<PostDataTable>(__db) { // from class: com.appnew.android.Dao.FeedsDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `PostDataTable` (`created`,`page`,`masterCat`,`postId`,`id`,`json`,`meta_url`,`link_type`,`thumbnail`,`url`,`modified`,`my_like`,`name`,`post_type`,`profile_picture`,`status`,`sub_cat_id`,`text`,`total_comments`,`total_likes`,`user_id`,`newCourseData`,`livetest`,`liveclass`,`testResult`,`bannerlist`,`liveClassStatus`,`liveTestStatus`,`iscommentenable`,`sectionposiiton`,`limit`,`my_pinned`,`parentId`,`description`,`image_type`,`schedule_date`) VALUES (?,?,?,nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final PostDataTable entity) {
                if (entity.getCreated() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getCreated());
                }
                if (entity.getPage() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getPage());
                }
                if (entity.getMasterCat() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMasterCat());
                }
                statement.bindLong(4, entity.getPostId());
                if (entity.getId() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getId());
                }
                if (entity.getJson() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getJson());
                }
                if (entity.getMeta_url() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getMeta_url());
                }
                if (entity.getLink_type() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getLink_type());
                }
                if (entity.getThumbnail() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, entity.getThumbnail());
                }
                if (entity.getUrl() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getUrl());
                }
                if (entity.getModified() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, entity.getModified());
                }
                if (entity.getMy_like() == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, entity.getMy_like());
                }
                if (entity.getName() == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, entity.getName());
                }
                if (entity.getPost_type() == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindString(14, entity.getPost_type());
                }
                if (entity.getProfile_picture() == null) {
                    statement.bindNull(15);
                } else {
                    statement.bindString(15, entity.getProfile_picture());
                }
                if (entity.getStatus() == null) {
                    statement.bindNull(16);
                } else {
                    statement.bindString(16, entity.getStatus());
                }
                if (entity.getSub_cat_id() == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindString(17, entity.getSub_cat_id());
                }
                if (entity.getText() == null) {
                    statement.bindNull(18);
                } else {
                    statement.bindString(18, entity.getText());
                }
                if (entity.getTotal_comments() == null) {
                    statement.bindNull(19);
                } else {
                    statement.bindString(19, entity.getTotal_comments());
                }
                if (entity.getTotal_likes() == null) {
                    statement.bindNull(20);
                } else {
                    statement.bindString(20, entity.getTotal_likes());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(21);
                } else {
                    statement.bindString(21, entity.getUser_id());
                }
                if (entity.getNewCourseData() == null) {
                    statement.bindNull(22);
                } else {
                    statement.bindString(22, entity.getNewCourseData());
                }
                if (entity.getLivetest() == null) {
                    statement.bindNull(23);
                } else {
                    statement.bindString(23, entity.getLivetest());
                }
                if (entity.getLiveclass() == null) {
                    statement.bindNull(24);
                } else {
                    statement.bindString(24, entity.getLiveclass());
                }
                if (entity.getTestResult() == null) {
                    statement.bindNull(25);
                } else {
                    statement.bindString(25, entity.getTestResult());
                }
                if (entity.getBannerlist() == null) {
                    statement.bindNull(26);
                } else {
                    statement.bindString(26, entity.getBannerlist());
                }
                if (entity.getLiveClassStatus() == null) {
                    statement.bindNull(27);
                } else {
                    statement.bindString(27, entity.getLiveClassStatus());
                }
                if (entity.getLiveTestStatus() == null) {
                    statement.bindNull(28);
                } else {
                    statement.bindString(28, entity.getLiveTestStatus());
                }
                if (entity.getIscommentenable() == null) {
                    statement.bindNull(29);
                } else {
                    statement.bindString(29, entity.getIscommentenable());
                }
                if (entity.getSectionposiiton() == null) {
                    statement.bindNull(30);
                } else {
                    statement.bindString(30, entity.getSectionposiiton());
                }
                if (entity.getLimit() == null) {
                    statement.bindNull(31);
                } else {
                    statement.bindString(31, entity.getLimit());
                }
                if (entity.getMy_pinned() == null) {
                    statement.bindNull(32);
                } else {
                    statement.bindString(32, entity.getMy_pinned());
                }
                if (entity.getParentId() == null) {
                    statement.bindNull(33);
                } else {
                    statement.bindString(33, entity.getParentId());
                }
                if (entity.getDescription() == null) {
                    statement.bindNull(34);
                } else {
                    statement.bindString(34, entity.getDescription());
                }
                if (entity.getImage_type() == null) {
                    statement.bindNull(35);
                } else {
                    statement.bindString(35, entity.getImage_type());
                }
                if (entity.getSchedule_date() == null) {
                    statement.bindNull(36);
                } else {
                    statement.bindString(36, entity.getSchedule_date());
                }
            }
        };
        this.__preparedStmtOfDeletedata = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.FeedsDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM PostDataTable";
            }
        };
        this.__preparedStmtOfUpdatePinnedPost = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.FeedsDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE PostDataTable  SET  my_pinned =?  WHERE id = ? ";
            }
        };
        this.__preparedStmtOfUpdate_result = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.FeedsDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE PostDataTable  SET  json =?  WHERE id = ? AND masterCat =? ";
            }
        };
        this.__preparedStmtOfUpdateMyLike = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.FeedsDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE PostDataTable  SET  my_like =?,total_likes =?   WHERE id = ? ";
            }
        };
        this.__preparedStmtOfUpdateMyjson = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.FeedsDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE PostDataTable  SET  json =?   WHERE id = ? ";
            }
        };
        this.__preparedStmtOfDeletePosts_via_id = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.FeedsDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM PostDataTable where masterCat =?";
            }
        };
        this.__preparedStmtOfDeletePost = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.FeedsDao_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM PostDataTable where masterCat =? AND sub_cat_id =?";
            }
        };
        this.__preparedStmtOfDeletePosts_via_post_type = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.FeedsDao_Impl.9
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM PostDataTable where masterCat =? AND post_type IN (?,?) ";
            }
        };
        this.__preparedStmtOfDeletepost_without_liveclass = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.FeedsDao_Impl.10
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM PostDataTable where masterCat =? AND post_type NOT IN (?,?) ";
            }
        };
        this.__preparedStmtOfDeleteSubCatFeed = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.FeedsDao_Impl.11
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM PostDataTable where masterCat =? And sub_cat_id =? AND post_type NOT IN (?,?) ";
            }
        };
    }

    @Override // com.appnew.android.Dao.FeedsDao
    public void insertPost(final PostDataTable post) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPostDataTable.insert(post);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.FeedsDao
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

    @Override // com.appnew.android.Dao.FeedsDao
    public void updatePinnedPost(final String pinnedPost, final String post_id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdatePinnedPost.acquire();
        if (pinnedPost == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, pinnedPost);
        }
        if (post_id == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, post_id);
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
            this.__preparedStmtOfUpdatePinnedPost.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.FeedsDao
    public void update_result(final String json, final String post_id, final String mainid) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_result.acquire();
        if (json == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, json);
        }
        if (post_id == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, post_id);
        }
        if (mainid == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, mainid);
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
            this.__preparedStmtOfUpdate_result.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.FeedsDao
    public void updateMyLike(final String post_id, final String myLike, final String totalike) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateMyLike.acquire();
        if (myLike == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, myLike);
        }
        if (totalike == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, totalike);
        }
        if (post_id == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, post_id);
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
            this.__preparedStmtOfUpdateMyLike.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.FeedsDao
    public void updateMyjson(final String post_id, final String json) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateMyjson.acquire();
        if (json == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, json);
        }
        if (post_id == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, post_id);
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
            this.__preparedStmtOfUpdateMyjson.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.FeedsDao
    public void deletePosts() {
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

    @Override // com.appnew.android.Dao.FeedsDao
    public void deletePosts_via_id(final String mainCat) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeletePosts_via_id.acquire();
        if (mainCat == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, mainCat);
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
            this.__preparedStmtOfDeletePosts_via_id.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.FeedsDao
    public void deletePost(final String mainCat, final String subcat) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeletePost.acquire();
        if (mainCat == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, mainCat);
        }
        if (subcat == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, subcat);
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
            this.__preparedStmtOfDeletePost.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.FeedsDao
    public void deletePosts_via_post_type(final String mainCat, final String liveclassposttype, final String livetestposttype) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeletePosts_via_post_type.acquire();
        if (mainCat == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, mainCat);
        }
        if (liveclassposttype == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, liveclassposttype);
        }
        if (livetestposttype == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, livetestposttype);
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
            this.__preparedStmtOfDeletePosts_via_post_type.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.FeedsDao
    public void deletepost_without_liveclass(final String mainCat, final String liveclassposttype, final String livetestposttype) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeletepost_without_liveclass.acquire();
        if (mainCat == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, mainCat);
        }
        if (liveclassposttype == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, liveclassposttype);
        }
        if (livetestposttype == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, livetestposttype);
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
            this.__preparedStmtOfDeletepost_without_liveclass.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.FeedsDao
    public void deleteSubCatFeed(final String mainCat, final String subcat, final String liveclassposttype, final String livetestposttype) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteSubCatFeed.acquire();
        if (mainCat == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, mainCat);
        }
        if (subcat == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, subcat);
        }
        if (liveclassposttype == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, liveclassposttype);
        }
        if (livetestposttype == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, livetestposttype);
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
            this.__preparedStmtOfDeleteSubCatFeed.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.FeedsDao
    public List<PostDataTable> retrievePostData(final String mainCat) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        int i2;
        String string2;
        int i3;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        String string15;
        String string16;
        String string17;
        String string18;
        String string19;
        String string20;
        String string21;
        String string22;
        String string23;
        String string24;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PostDataTable WHERE masterCat = ?", 1);
        if (mainCat == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, mainCat);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, StoreProvider.StoreData.CREATED_DATE);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "page");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "masterCat");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "postId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "json");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "meta_url");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.LINK_TYPE);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, StoreProvider.StoreData.MODIFIED_DATE);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "my_like");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.POST_TYPE);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.PROFILE_PICTURE);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sub_cat_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "text");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_comments");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_likes");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "newCourseData");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "livetest");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liveclass");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "testResult");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bannerlist");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liveClassStatus");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liveTestStatus");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "iscommentenable");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sectionposiiton");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Constants.KEY_LIMIT);
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "my_pinned");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "parentId");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_type");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_date");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    PostDataTable postDataTable = new PostDataTable();
                    if (cursorQuery.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = cursorQuery.getString(columnIndexOrThrow);
                    }
                    postDataTable.setCreated(string);
                    postDataTable.setPage(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    postDataTable.setMasterCat(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    postDataTable.setPostId(cursorQuery.getInt(columnIndexOrThrow4));
                    postDataTable.setId(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    postDataTable.setJson(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    postDataTable.setMeta_url(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    postDataTable.setLink_type(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    postDataTable.setThumbnail(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    postDataTable.setUrl(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    postDataTable.setModified(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    postDataTable.setMy_like(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    postDataTable.setName(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i5 = i4;
                    if (cursorQuery.isNull(i5)) {
                        i2 = i5;
                        string2 = null;
                    } else {
                        i2 = i5;
                        string2 = cursorQuery.getString(i5);
                    }
                    postDataTable.setPost_type(string2);
                    int i6 = columnIndexOrThrow15;
                    if (cursorQuery.isNull(i6)) {
                        i3 = i6;
                        string3 = null;
                    } else {
                        i3 = i6;
                        string3 = cursorQuery.getString(i6);
                    }
                    postDataTable.setProfile_picture(string3);
                    int i7 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i7)) {
                        columnIndexOrThrow16 = i7;
                        string4 = null;
                    } else {
                        columnIndexOrThrow16 = i7;
                        string4 = cursorQuery.getString(i7);
                    }
                    postDataTable.setStatus(string4);
                    int i8 = columnIndexOrThrow17;
                    if (cursorQuery.isNull(i8)) {
                        columnIndexOrThrow17 = i8;
                        string5 = null;
                    } else {
                        columnIndexOrThrow17 = i8;
                        string5 = cursorQuery.getString(i8);
                    }
                    postDataTable.setSub_cat_id(string5);
                    int i9 = columnIndexOrThrow18;
                    if (cursorQuery.isNull(i9)) {
                        columnIndexOrThrow18 = i9;
                        string6 = null;
                    } else {
                        columnIndexOrThrow18 = i9;
                        string6 = cursorQuery.getString(i9);
                    }
                    postDataTable.setText(string6);
                    int i10 = columnIndexOrThrow19;
                    if (cursorQuery.isNull(i10)) {
                        columnIndexOrThrow19 = i10;
                        string7 = null;
                    } else {
                        columnIndexOrThrow19 = i10;
                        string7 = cursorQuery.getString(i10);
                    }
                    postDataTable.setTotal_comments(string7);
                    int i11 = columnIndexOrThrow20;
                    if (cursorQuery.isNull(i11)) {
                        columnIndexOrThrow20 = i11;
                        string8 = null;
                    } else {
                        columnIndexOrThrow20 = i11;
                        string8 = cursorQuery.getString(i11);
                    }
                    postDataTable.setTotal_likes(string8);
                    int i12 = columnIndexOrThrow21;
                    if (cursorQuery.isNull(i12)) {
                        columnIndexOrThrow21 = i12;
                        string9 = null;
                    } else {
                        columnIndexOrThrow21 = i12;
                        string9 = cursorQuery.getString(i12);
                    }
                    postDataTable.setUser_id(string9);
                    int i13 = columnIndexOrThrow22;
                    if (cursorQuery.isNull(i13)) {
                        columnIndexOrThrow22 = i13;
                        string10 = null;
                    } else {
                        columnIndexOrThrow22 = i13;
                        string10 = cursorQuery.getString(i13);
                    }
                    postDataTable.setNewCourseData(string10);
                    int i14 = columnIndexOrThrow23;
                    if (cursorQuery.isNull(i14)) {
                        columnIndexOrThrow23 = i14;
                        string11 = null;
                    } else {
                        columnIndexOrThrow23 = i14;
                        string11 = cursorQuery.getString(i14);
                    }
                    postDataTable.setLivetest(string11);
                    int i15 = columnIndexOrThrow24;
                    if (cursorQuery.isNull(i15)) {
                        columnIndexOrThrow24 = i15;
                        string12 = null;
                    } else {
                        columnIndexOrThrow24 = i15;
                        string12 = cursorQuery.getString(i15);
                    }
                    postDataTable.setLiveclass(string12);
                    int i16 = columnIndexOrThrow25;
                    if (cursorQuery.isNull(i16)) {
                        columnIndexOrThrow25 = i16;
                        string13 = null;
                    } else {
                        columnIndexOrThrow25 = i16;
                        string13 = cursorQuery.getString(i16);
                    }
                    postDataTable.setTestResult(string13);
                    int i17 = columnIndexOrThrow26;
                    if (cursorQuery.isNull(i17)) {
                        columnIndexOrThrow26 = i17;
                        string14 = null;
                    } else {
                        columnIndexOrThrow26 = i17;
                        string14 = cursorQuery.getString(i17);
                    }
                    postDataTable.setBannerlist(string14);
                    int i18 = columnIndexOrThrow27;
                    if (cursorQuery.isNull(i18)) {
                        columnIndexOrThrow27 = i18;
                        string15 = null;
                    } else {
                        columnIndexOrThrow27 = i18;
                        string15 = cursorQuery.getString(i18);
                    }
                    postDataTable.setLiveClassStatus(string15);
                    int i19 = columnIndexOrThrow28;
                    if (cursorQuery.isNull(i19)) {
                        columnIndexOrThrow28 = i19;
                        string16 = null;
                    } else {
                        columnIndexOrThrow28 = i19;
                        string16 = cursorQuery.getString(i19);
                    }
                    postDataTable.setLiveTestStatus(string16);
                    int i20 = columnIndexOrThrow29;
                    if (cursorQuery.isNull(i20)) {
                        columnIndexOrThrow29 = i20;
                        string17 = null;
                    } else {
                        columnIndexOrThrow29 = i20;
                        string17 = cursorQuery.getString(i20);
                    }
                    postDataTable.setIscommentenable(string17);
                    int i21 = columnIndexOrThrow30;
                    if (cursorQuery.isNull(i21)) {
                        columnIndexOrThrow30 = i21;
                        string18 = null;
                    } else {
                        columnIndexOrThrow30 = i21;
                        string18 = cursorQuery.getString(i21);
                    }
                    postDataTable.setSectionposiiton(string18);
                    int i22 = columnIndexOrThrow31;
                    if (cursorQuery.isNull(i22)) {
                        columnIndexOrThrow31 = i22;
                        string19 = null;
                    } else {
                        columnIndexOrThrow31 = i22;
                        string19 = cursorQuery.getString(i22);
                    }
                    postDataTable.setLimit(string19);
                    int i23 = columnIndexOrThrow32;
                    if (cursorQuery.isNull(i23)) {
                        columnIndexOrThrow32 = i23;
                        string20 = null;
                    } else {
                        columnIndexOrThrow32 = i23;
                        string20 = cursorQuery.getString(i23);
                    }
                    postDataTable.setMy_pinned(string20);
                    int i24 = columnIndexOrThrow33;
                    if (cursorQuery.isNull(i24)) {
                        columnIndexOrThrow33 = i24;
                        string21 = null;
                    } else {
                        columnIndexOrThrow33 = i24;
                        string21 = cursorQuery.getString(i24);
                    }
                    postDataTable.setParentId(string21);
                    int i25 = columnIndexOrThrow34;
                    if (cursorQuery.isNull(i25)) {
                        columnIndexOrThrow34 = i25;
                        string22 = null;
                    } else {
                        columnIndexOrThrow34 = i25;
                        string22 = cursorQuery.getString(i25);
                    }
                    postDataTable.setDescription(string22);
                    int i26 = columnIndexOrThrow35;
                    if (cursorQuery.isNull(i26)) {
                        columnIndexOrThrow35 = i26;
                        string23 = null;
                    } else {
                        columnIndexOrThrow35 = i26;
                        string23 = cursorQuery.getString(i26);
                    }
                    postDataTable.setImage_type(string23);
                    int i27 = columnIndexOrThrow36;
                    if (cursorQuery.isNull(i27)) {
                        columnIndexOrThrow36 = i27;
                        string24 = null;
                    } else {
                        columnIndexOrThrow36 = i27;
                        string24 = cursorQuery.getString(i27);
                    }
                    postDataTable.setSchedule_date(string24);
                    arrayList.add(postDataTable);
                    columnIndexOrThrow15 = i3;
                    i4 = i2;
                    columnIndexOrThrow = i;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
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

    @Override // com.appnew.android.Dao.FeedsDao
    public List<PostDataTable> retrievePostData(final String parentId, final String main, final String subcat) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        int i2;
        String string2;
        String string3;
        String string4;
        int i3;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        String string15;
        String string16;
        String string17;
        String string18;
        String string19;
        String string20;
        String string21;
        String string22;
        String string23;
        String string24;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PostDataTable WHERE parentId = ? AND masterCat =? AND sub_cat_id =?", 3);
        if (parentId == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, parentId);
        }
        if (main == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, main);
        }
        if (subcat == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, subcat);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, StoreProvider.StoreData.CREATED_DATE);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "page");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "masterCat");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "postId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "json");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "meta_url");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.LINK_TYPE);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, StoreProvider.StoreData.MODIFIED_DATE);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "my_like");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.POST_TYPE);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.PROFILE_PICTURE);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sub_cat_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "text");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_comments");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_likes");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "newCourseData");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "livetest");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liveclass");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "testResult");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bannerlist");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liveClassStatus");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liveTestStatus");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "iscommentenable");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sectionposiiton");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Constants.KEY_LIMIT);
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "my_pinned");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "parentId");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_type");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_date");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    PostDataTable postDataTable = new PostDataTable();
                    if (cursorQuery.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = cursorQuery.getString(columnIndexOrThrow);
                    }
                    postDataTable.setCreated(string);
                    postDataTable.setPage(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    postDataTable.setMasterCat(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    postDataTable.setPostId(cursorQuery.getInt(columnIndexOrThrow4));
                    postDataTable.setId(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    postDataTable.setJson(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    postDataTable.setMeta_url(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    postDataTable.setLink_type(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    postDataTable.setThumbnail(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    postDataTable.setUrl(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    postDataTable.setModified(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    postDataTable.setMy_like(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    postDataTable.setName(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i5 = i4;
                    if (cursorQuery.isNull(i5)) {
                        i2 = i5;
                        string2 = null;
                    } else {
                        i2 = i5;
                        string2 = cursorQuery.getString(i5);
                    }
                    postDataTable.setPost_type(string2);
                    int i6 = columnIndexOrThrow15;
                    if (cursorQuery.isNull(i6)) {
                        columnIndexOrThrow15 = i6;
                        string3 = null;
                    } else {
                        columnIndexOrThrow15 = i6;
                        string3 = cursorQuery.getString(i6);
                    }
                    postDataTable.setProfile_picture(string3);
                    int i7 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i7)) {
                        columnIndexOrThrow16 = i7;
                        string4 = null;
                    } else {
                        columnIndexOrThrow16 = i7;
                        string4 = cursorQuery.getString(i7);
                    }
                    postDataTable.setStatus(string4);
                    int i8 = columnIndexOrThrow17;
                    if (cursorQuery.isNull(i8)) {
                        i3 = i8;
                        string5 = null;
                    } else {
                        i3 = i8;
                        string5 = cursorQuery.getString(i8);
                    }
                    postDataTable.setSub_cat_id(string5);
                    int i9 = columnIndexOrThrow18;
                    if (cursorQuery.isNull(i9)) {
                        columnIndexOrThrow18 = i9;
                        string6 = null;
                    } else {
                        columnIndexOrThrow18 = i9;
                        string6 = cursorQuery.getString(i9);
                    }
                    postDataTable.setText(string6);
                    int i10 = columnIndexOrThrow19;
                    if (cursorQuery.isNull(i10)) {
                        columnIndexOrThrow19 = i10;
                        string7 = null;
                    } else {
                        columnIndexOrThrow19 = i10;
                        string7 = cursorQuery.getString(i10);
                    }
                    postDataTable.setTotal_comments(string7);
                    int i11 = columnIndexOrThrow20;
                    if (cursorQuery.isNull(i11)) {
                        columnIndexOrThrow20 = i11;
                        string8 = null;
                    } else {
                        columnIndexOrThrow20 = i11;
                        string8 = cursorQuery.getString(i11);
                    }
                    postDataTable.setTotal_likes(string8);
                    int i12 = columnIndexOrThrow21;
                    if (cursorQuery.isNull(i12)) {
                        columnIndexOrThrow21 = i12;
                        string9 = null;
                    } else {
                        columnIndexOrThrow21 = i12;
                        string9 = cursorQuery.getString(i12);
                    }
                    postDataTable.setUser_id(string9);
                    int i13 = columnIndexOrThrow22;
                    if (cursorQuery.isNull(i13)) {
                        columnIndexOrThrow22 = i13;
                        string10 = null;
                    } else {
                        columnIndexOrThrow22 = i13;
                        string10 = cursorQuery.getString(i13);
                    }
                    postDataTable.setNewCourseData(string10);
                    int i14 = columnIndexOrThrow23;
                    if (cursorQuery.isNull(i14)) {
                        columnIndexOrThrow23 = i14;
                        string11 = null;
                    } else {
                        columnIndexOrThrow23 = i14;
                        string11 = cursorQuery.getString(i14);
                    }
                    postDataTable.setLivetest(string11);
                    int i15 = columnIndexOrThrow24;
                    if (cursorQuery.isNull(i15)) {
                        columnIndexOrThrow24 = i15;
                        string12 = null;
                    } else {
                        columnIndexOrThrow24 = i15;
                        string12 = cursorQuery.getString(i15);
                    }
                    postDataTable.setLiveclass(string12);
                    int i16 = columnIndexOrThrow25;
                    if (cursorQuery.isNull(i16)) {
                        columnIndexOrThrow25 = i16;
                        string13 = null;
                    } else {
                        columnIndexOrThrow25 = i16;
                        string13 = cursorQuery.getString(i16);
                    }
                    postDataTable.setTestResult(string13);
                    int i17 = columnIndexOrThrow26;
                    if (cursorQuery.isNull(i17)) {
                        columnIndexOrThrow26 = i17;
                        string14 = null;
                    } else {
                        columnIndexOrThrow26 = i17;
                        string14 = cursorQuery.getString(i17);
                    }
                    postDataTable.setBannerlist(string14);
                    int i18 = columnIndexOrThrow27;
                    if (cursorQuery.isNull(i18)) {
                        columnIndexOrThrow27 = i18;
                        string15 = null;
                    } else {
                        columnIndexOrThrow27 = i18;
                        string15 = cursorQuery.getString(i18);
                    }
                    postDataTable.setLiveClassStatus(string15);
                    int i19 = columnIndexOrThrow28;
                    if (cursorQuery.isNull(i19)) {
                        columnIndexOrThrow28 = i19;
                        string16 = null;
                    } else {
                        columnIndexOrThrow28 = i19;
                        string16 = cursorQuery.getString(i19);
                    }
                    postDataTable.setLiveTestStatus(string16);
                    int i20 = columnIndexOrThrow29;
                    if (cursorQuery.isNull(i20)) {
                        columnIndexOrThrow29 = i20;
                        string17 = null;
                    } else {
                        columnIndexOrThrow29 = i20;
                        string17 = cursorQuery.getString(i20);
                    }
                    postDataTable.setIscommentenable(string17);
                    int i21 = columnIndexOrThrow30;
                    if (cursorQuery.isNull(i21)) {
                        columnIndexOrThrow30 = i21;
                        string18 = null;
                    } else {
                        columnIndexOrThrow30 = i21;
                        string18 = cursorQuery.getString(i21);
                    }
                    postDataTable.setSectionposiiton(string18);
                    int i22 = columnIndexOrThrow31;
                    if (cursorQuery.isNull(i22)) {
                        columnIndexOrThrow31 = i22;
                        string19 = null;
                    } else {
                        columnIndexOrThrow31 = i22;
                        string19 = cursorQuery.getString(i22);
                    }
                    postDataTable.setLimit(string19);
                    int i23 = columnIndexOrThrow32;
                    if (cursorQuery.isNull(i23)) {
                        columnIndexOrThrow32 = i23;
                        string20 = null;
                    } else {
                        columnIndexOrThrow32 = i23;
                        string20 = cursorQuery.getString(i23);
                    }
                    postDataTable.setMy_pinned(string20);
                    int i24 = columnIndexOrThrow33;
                    if (cursorQuery.isNull(i24)) {
                        columnIndexOrThrow33 = i24;
                        string21 = null;
                    } else {
                        columnIndexOrThrow33 = i24;
                        string21 = cursorQuery.getString(i24);
                    }
                    postDataTable.setParentId(string21);
                    int i25 = columnIndexOrThrow34;
                    if (cursorQuery.isNull(i25)) {
                        columnIndexOrThrow34 = i25;
                        string22 = null;
                    } else {
                        columnIndexOrThrow34 = i25;
                        string22 = cursorQuery.getString(i25);
                    }
                    postDataTable.setDescription(string22);
                    int i26 = columnIndexOrThrow35;
                    if (cursorQuery.isNull(i26)) {
                        columnIndexOrThrow35 = i26;
                        string23 = null;
                    } else {
                        columnIndexOrThrow35 = i26;
                        string23 = cursorQuery.getString(i26);
                    }
                    postDataTable.setImage_type(string23);
                    int i27 = columnIndexOrThrow36;
                    if (cursorQuery.isNull(i27)) {
                        columnIndexOrThrow36 = i27;
                        string24 = null;
                    } else {
                        columnIndexOrThrow36 = i27;
                        string24 = cursorQuery.getString(i27);
                    }
                    postDataTable.setSchedule_date(string24);
                    arrayList.add(postDataTable);
                    columnIndexOrThrow17 = i3;
                    i4 = i2;
                    columnIndexOrThrow = i;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
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

    @Override // com.appnew.android.Dao.FeedsDao
    public List<PostDataTable> retrievePostData_viaposttype(final String parentId, final String main, final String subcat, final String posttype) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        int i2;
        String string2;
        String string3;
        String string4;
        String string5;
        int i3;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        String string15;
        String string16;
        String string17;
        String string18;
        String string19;
        String string20;
        String string21;
        String string22;
        String string23;
        String string24;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PostDataTable WHERE parentId = ? AND masterCat =? AND sub_cat_id =? And post_type =?", 4);
        if (parentId == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, parentId);
        }
        if (main == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, main);
        }
        if (subcat == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, subcat);
        }
        if (posttype == null) {
            roomSQLiteQueryAcquire.bindNull(4);
        } else {
            roomSQLiteQueryAcquire.bindString(4, posttype);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, StoreProvider.StoreData.CREATED_DATE);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "page");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "masterCat");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "postId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "json");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "meta_url");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.LINK_TYPE);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, StoreProvider.StoreData.MODIFIED_DATE);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "my_like");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.POST_TYPE);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.PROFILE_PICTURE);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sub_cat_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "text");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_comments");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_likes");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "newCourseData");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "livetest");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liveclass");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "testResult");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bannerlist");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liveClassStatus");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liveTestStatus");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "iscommentenable");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sectionposiiton");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Constants.KEY_LIMIT);
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "my_pinned");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "parentId");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_type");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_date");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    PostDataTable postDataTable = new PostDataTable();
                    if (cursorQuery.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = cursorQuery.getString(columnIndexOrThrow);
                    }
                    postDataTable.setCreated(string);
                    postDataTable.setPage(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    postDataTable.setMasterCat(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    postDataTable.setPostId(cursorQuery.getInt(columnIndexOrThrow4));
                    postDataTable.setId(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    postDataTable.setJson(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    postDataTable.setMeta_url(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    postDataTable.setLink_type(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    postDataTable.setThumbnail(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    postDataTable.setUrl(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    postDataTable.setModified(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    postDataTable.setMy_like(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    postDataTable.setName(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i5 = i4;
                    if (cursorQuery.isNull(i5)) {
                        i2 = i5;
                        string2 = null;
                    } else {
                        i2 = i5;
                        string2 = cursorQuery.getString(i5);
                    }
                    postDataTable.setPost_type(string2);
                    int i6 = columnIndexOrThrow15;
                    if (cursorQuery.isNull(i6)) {
                        columnIndexOrThrow15 = i6;
                        string3 = null;
                    } else {
                        columnIndexOrThrow15 = i6;
                        string3 = cursorQuery.getString(i6);
                    }
                    postDataTable.setProfile_picture(string3);
                    int i7 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i7)) {
                        columnIndexOrThrow16 = i7;
                        string4 = null;
                    } else {
                        columnIndexOrThrow16 = i7;
                        string4 = cursorQuery.getString(i7);
                    }
                    postDataTable.setStatus(string4);
                    int i8 = columnIndexOrThrow17;
                    if (cursorQuery.isNull(i8)) {
                        columnIndexOrThrow17 = i8;
                        string5 = null;
                    } else {
                        columnIndexOrThrow17 = i8;
                        string5 = cursorQuery.getString(i8);
                    }
                    postDataTable.setSub_cat_id(string5);
                    int i9 = columnIndexOrThrow18;
                    if (cursorQuery.isNull(i9)) {
                        i3 = i9;
                        string6 = null;
                    } else {
                        i3 = i9;
                        string6 = cursorQuery.getString(i9);
                    }
                    postDataTable.setText(string6);
                    int i10 = columnIndexOrThrow19;
                    if (cursorQuery.isNull(i10)) {
                        columnIndexOrThrow19 = i10;
                        string7 = null;
                    } else {
                        columnIndexOrThrow19 = i10;
                        string7 = cursorQuery.getString(i10);
                    }
                    postDataTable.setTotal_comments(string7);
                    int i11 = columnIndexOrThrow20;
                    if (cursorQuery.isNull(i11)) {
                        columnIndexOrThrow20 = i11;
                        string8 = null;
                    } else {
                        columnIndexOrThrow20 = i11;
                        string8 = cursorQuery.getString(i11);
                    }
                    postDataTable.setTotal_likes(string8);
                    int i12 = columnIndexOrThrow21;
                    if (cursorQuery.isNull(i12)) {
                        columnIndexOrThrow21 = i12;
                        string9 = null;
                    } else {
                        columnIndexOrThrow21 = i12;
                        string9 = cursorQuery.getString(i12);
                    }
                    postDataTable.setUser_id(string9);
                    int i13 = columnIndexOrThrow22;
                    if (cursorQuery.isNull(i13)) {
                        columnIndexOrThrow22 = i13;
                        string10 = null;
                    } else {
                        columnIndexOrThrow22 = i13;
                        string10 = cursorQuery.getString(i13);
                    }
                    postDataTable.setNewCourseData(string10);
                    int i14 = columnIndexOrThrow23;
                    if (cursorQuery.isNull(i14)) {
                        columnIndexOrThrow23 = i14;
                        string11 = null;
                    } else {
                        columnIndexOrThrow23 = i14;
                        string11 = cursorQuery.getString(i14);
                    }
                    postDataTable.setLivetest(string11);
                    int i15 = columnIndexOrThrow24;
                    if (cursorQuery.isNull(i15)) {
                        columnIndexOrThrow24 = i15;
                        string12 = null;
                    } else {
                        columnIndexOrThrow24 = i15;
                        string12 = cursorQuery.getString(i15);
                    }
                    postDataTable.setLiveclass(string12);
                    int i16 = columnIndexOrThrow25;
                    if (cursorQuery.isNull(i16)) {
                        columnIndexOrThrow25 = i16;
                        string13 = null;
                    } else {
                        columnIndexOrThrow25 = i16;
                        string13 = cursorQuery.getString(i16);
                    }
                    postDataTable.setTestResult(string13);
                    int i17 = columnIndexOrThrow26;
                    if (cursorQuery.isNull(i17)) {
                        columnIndexOrThrow26 = i17;
                        string14 = null;
                    } else {
                        columnIndexOrThrow26 = i17;
                        string14 = cursorQuery.getString(i17);
                    }
                    postDataTable.setBannerlist(string14);
                    int i18 = columnIndexOrThrow27;
                    if (cursorQuery.isNull(i18)) {
                        columnIndexOrThrow27 = i18;
                        string15 = null;
                    } else {
                        columnIndexOrThrow27 = i18;
                        string15 = cursorQuery.getString(i18);
                    }
                    postDataTable.setLiveClassStatus(string15);
                    int i19 = columnIndexOrThrow28;
                    if (cursorQuery.isNull(i19)) {
                        columnIndexOrThrow28 = i19;
                        string16 = null;
                    } else {
                        columnIndexOrThrow28 = i19;
                        string16 = cursorQuery.getString(i19);
                    }
                    postDataTable.setLiveTestStatus(string16);
                    int i20 = columnIndexOrThrow29;
                    if (cursorQuery.isNull(i20)) {
                        columnIndexOrThrow29 = i20;
                        string17 = null;
                    } else {
                        columnIndexOrThrow29 = i20;
                        string17 = cursorQuery.getString(i20);
                    }
                    postDataTable.setIscommentenable(string17);
                    int i21 = columnIndexOrThrow30;
                    if (cursorQuery.isNull(i21)) {
                        columnIndexOrThrow30 = i21;
                        string18 = null;
                    } else {
                        columnIndexOrThrow30 = i21;
                        string18 = cursorQuery.getString(i21);
                    }
                    postDataTable.setSectionposiiton(string18);
                    int i22 = columnIndexOrThrow31;
                    if (cursorQuery.isNull(i22)) {
                        columnIndexOrThrow31 = i22;
                        string19 = null;
                    } else {
                        columnIndexOrThrow31 = i22;
                        string19 = cursorQuery.getString(i22);
                    }
                    postDataTable.setLimit(string19);
                    int i23 = columnIndexOrThrow32;
                    if (cursorQuery.isNull(i23)) {
                        columnIndexOrThrow32 = i23;
                        string20 = null;
                    } else {
                        columnIndexOrThrow32 = i23;
                        string20 = cursorQuery.getString(i23);
                    }
                    postDataTable.setMy_pinned(string20);
                    int i24 = columnIndexOrThrow33;
                    if (cursorQuery.isNull(i24)) {
                        columnIndexOrThrow33 = i24;
                        string21 = null;
                    } else {
                        columnIndexOrThrow33 = i24;
                        string21 = cursorQuery.getString(i24);
                    }
                    postDataTable.setParentId(string21);
                    int i25 = columnIndexOrThrow34;
                    if (cursorQuery.isNull(i25)) {
                        columnIndexOrThrow34 = i25;
                        string22 = null;
                    } else {
                        columnIndexOrThrow34 = i25;
                        string22 = cursorQuery.getString(i25);
                    }
                    postDataTable.setDescription(string22);
                    int i26 = columnIndexOrThrow35;
                    if (cursorQuery.isNull(i26)) {
                        columnIndexOrThrow35 = i26;
                        string23 = null;
                    } else {
                        columnIndexOrThrow35 = i26;
                        string23 = cursorQuery.getString(i26);
                    }
                    postDataTable.setImage_type(string23);
                    int i27 = columnIndexOrThrow36;
                    if (cursorQuery.isNull(i27)) {
                        columnIndexOrThrow36 = i27;
                        string24 = null;
                    } else {
                        columnIndexOrThrow36 = i27;
                        string24 = cursorQuery.getString(i27);
                    }
                    postDataTable.setSchedule_date(string24);
                    arrayList.add(postDataTable);
                    columnIndexOrThrow18 = i3;
                    i4 = i2;
                    columnIndexOrThrow = i;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
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

    @Override // com.appnew.android.Dao.FeedsDao
    public List<PostDataTable> retrievePostData_viaposttype_withoutsubcat(final String parentId, final String main, final String posttype) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        int i2;
        String string2;
        String string3;
        String string4;
        int i3;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        String string15;
        String string16;
        String string17;
        String string18;
        String string19;
        String string20;
        String string21;
        String string22;
        String string23;
        String string24;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PostDataTable WHERE parentId = ? AND masterCat =?  And post_type =?", 3);
        if (parentId == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, parentId);
        }
        if (main == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, main);
        }
        if (posttype == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, posttype);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, StoreProvider.StoreData.CREATED_DATE);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "page");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "masterCat");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "postId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "json");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "meta_url");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.LINK_TYPE);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, StoreProvider.StoreData.MODIFIED_DATE);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "my_like");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.POST_TYPE);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.PROFILE_PICTURE);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sub_cat_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "text");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_comments");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_likes");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "newCourseData");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "livetest");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liveclass");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "testResult");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bannerlist");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liveClassStatus");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liveTestStatus");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "iscommentenable");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sectionposiiton");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Constants.KEY_LIMIT);
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "my_pinned");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "parentId");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_type");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_date");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    PostDataTable postDataTable = new PostDataTable();
                    if (cursorQuery.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = cursorQuery.getString(columnIndexOrThrow);
                    }
                    postDataTable.setCreated(string);
                    postDataTable.setPage(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    postDataTable.setMasterCat(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    postDataTable.setPostId(cursorQuery.getInt(columnIndexOrThrow4));
                    postDataTable.setId(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    postDataTable.setJson(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    postDataTable.setMeta_url(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    postDataTable.setLink_type(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    postDataTable.setThumbnail(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    postDataTable.setUrl(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    postDataTable.setModified(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    postDataTable.setMy_like(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    postDataTable.setName(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i5 = i4;
                    if (cursorQuery.isNull(i5)) {
                        i2 = i5;
                        string2 = null;
                    } else {
                        i2 = i5;
                        string2 = cursorQuery.getString(i5);
                    }
                    postDataTable.setPost_type(string2);
                    int i6 = columnIndexOrThrow15;
                    if (cursorQuery.isNull(i6)) {
                        columnIndexOrThrow15 = i6;
                        string3 = null;
                    } else {
                        columnIndexOrThrow15 = i6;
                        string3 = cursorQuery.getString(i6);
                    }
                    postDataTable.setProfile_picture(string3);
                    int i7 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i7)) {
                        columnIndexOrThrow16 = i7;
                        string4 = null;
                    } else {
                        columnIndexOrThrow16 = i7;
                        string4 = cursorQuery.getString(i7);
                    }
                    postDataTable.setStatus(string4);
                    int i8 = columnIndexOrThrow17;
                    if (cursorQuery.isNull(i8)) {
                        i3 = i8;
                        string5 = null;
                    } else {
                        i3 = i8;
                        string5 = cursorQuery.getString(i8);
                    }
                    postDataTable.setSub_cat_id(string5);
                    int i9 = columnIndexOrThrow18;
                    if (cursorQuery.isNull(i9)) {
                        columnIndexOrThrow18 = i9;
                        string6 = null;
                    } else {
                        columnIndexOrThrow18 = i9;
                        string6 = cursorQuery.getString(i9);
                    }
                    postDataTable.setText(string6);
                    int i10 = columnIndexOrThrow19;
                    if (cursorQuery.isNull(i10)) {
                        columnIndexOrThrow19 = i10;
                        string7 = null;
                    } else {
                        columnIndexOrThrow19 = i10;
                        string7 = cursorQuery.getString(i10);
                    }
                    postDataTable.setTotal_comments(string7);
                    int i11 = columnIndexOrThrow20;
                    if (cursorQuery.isNull(i11)) {
                        columnIndexOrThrow20 = i11;
                        string8 = null;
                    } else {
                        columnIndexOrThrow20 = i11;
                        string8 = cursorQuery.getString(i11);
                    }
                    postDataTable.setTotal_likes(string8);
                    int i12 = columnIndexOrThrow21;
                    if (cursorQuery.isNull(i12)) {
                        columnIndexOrThrow21 = i12;
                        string9 = null;
                    } else {
                        columnIndexOrThrow21 = i12;
                        string9 = cursorQuery.getString(i12);
                    }
                    postDataTable.setUser_id(string9);
                    int i13 = columnIndexOrThrow22;
                    if (cursorQuery.isNull(i13)) {
                        columnIndexOrThrow22 = i13;
                        string10 = null;
                    } else {
                        columnIndexOrThrow22 = i13;
                        string10 = cursorQuery.getString(i13);
                    }
                    postDataTable.setNewCourseData(string10);
                    int i14 = columnIndexOrThrow23;
                    if (cursorQuery.isNull(i14)) {
                        columnIndexOrThrow23 = i14;
                        string11 = null;
                    } else {
                        columnIndexOrThrow23 = i14;
                        string11 = cursorQuery.getString(i14);
                    }
                    postDataTable.setLivetest(string11);
                    int i15 = columnIndexOrThrow24;
                    if (cursorQuery.isNull(i15)) {
                        columnIndexOrThrow24 = i15;
                        string12 = null;
                    } else {
                        columnIndexOrThrow24 = i15;
                        string12 = cursorQuery.getString(i15);
                    }
                    postDataTable.setLiveclass(string12);
                    int i16 = columnIndexOrThrow25;
                    if (cursorQuery.isNull(i16)) {
                        columnIndexOrThrow25 = i16;
                        string13 = null;
                    } else {
                        columnIndexOrThrow25 = i16;
                        string13 = cursorQuery.getString(i16);
                    }
                    postDataTable.setTestResult(string13);
                    int i17 = columnIndexOrThrow26;
                    if (cursorQuery.isNull(i17)) {
                        columnIndexOrThrow26 = i17;
                        string14 = null;
                    } else {
                        columnIndexOrThrow26 = i17;
                        string14 = cursorQuery.getString(i17);
                    }
                    postDataTable.setBannerlist(string14);
                    int i18 = columnIndexOrThrow27;
                    if (cursorQuery.isNull(i18)) {
                        columnIndexOrThrow27 = i18;
                        string15 = null;
                    } else {
                        columnIndexOrThrow27 = i18;
                        string15 = cursorQuery.getString(i18);
                    }
                    postDataTable.setLiveClassStatus(string15);
                    int i19 = columnIndexOrThrow28;
                    if (cursorQuery.isNull(i19)) {
                        columnIndexOrThrow28 = i19;
                        string16 = null;
                    } else {
                        columnIndexOrThrow28 = i19;
                        string16 = cursorQuery.getString(i19);
                    }
                    postDataTable.setLiveTestStatus(string16);
                    int i20 = columnIndexOrThrow29;
                    if (cursorQuery.isNull(i20)) {
                        columnIndexOrThrow29 = i20;
                        string17 = null;
                    } else {
                        columnIndexOrThrow29 = i20;
                        string17 = cursorQuery.getString(i20);
                    }
                    postDataTable.setIscommentenable(string17);
                    int i21 = columnIndexOrThrow30;
                    if (cursorQuery.isNull(i21)) {
                        columnIndexOrThrow30 = i21;
                        string18 = null;
                    } else {
                        columnIndexOrThrow30 = i21;
                        string18 = cursorQuery.getString(i21);
                    }
                    postDataTable.setSectionposiiton(string18);
                    int i22 = columnIndexOrThrow31;
                    if (cursorQuery.isNull(i22)) {
                        columnIndexOrThrow31 = i22;
                        string19 = null;
                    } else {
                        columnIndexOrThrow31 = i22;
                        string19 = cursorQuery.getString(i22);
                    }
                    postDataTable.setLimit(string19);
                    int i23 = columnIndexOrThrow32;
                    if (cursorQuery.isNull(i23)) {
                        columnIndexOrThrow32 = i23;
                        string20 = null;
                    } else {
                        columnIndexOrThrow32 = i23;
                        string20 = cursorQuery.getString(i23);
                    }
                    postDataTable.setMy_pinned(string20);
                    int i24 = columnIndexOrThrow33;
                    if (cursorQuery.isNull(i24)) {
                        columnIndexOrThrow33 = i24;
                        string21 = null;
                    } else {
                        columnIndexOrThrow33 = i24;
                        string21 = cursorQuery.getString(i24);
                    }
                    postDataTable.setParentId(string21);
                    int i25 = columnIndexOrThrow34;
                    if (cursorQuery.isNull(i25)) {
                        columnIndexOrThrow34 = i25;
                        string22 = null;
                    } else {
                        columnIndexOrThrow34 = i25;
                        string22 = cursorQuery.getString(i25);
                    }
                    postDataTable.setDescription(string22);
                    int i26 = columnIndexOrThrow35;
                    if (cursorQuery.isNull(i26)) {
                        columnIndexOrThrow35 = i26;
                        string23 = null;
                    } else {
                        columnIndexOrThrow35 = i26;
                        string23 = cursorQuery.getString(i26);
                    }
                    postDataTable.setImage_type(string23);
                    int i27 = columnIndexOrThrow36;
                    if (cursorQuery.isNull(i27)) {
                        columnIndexOrThrow36 = i27;
                        string24 = null;
                    } else {
                        columnIndexOrThrow36 = i27;
                        string24 = cursorQuery.getString(i27);
                    }
                    postDataTable.setSchedule_date(string24);
                    arrayList.add(postDataTable);
                    columnIndexOrThrow17 = i3;
                    i4 = i2;
                    columnIndexOrThrow = i;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
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

    @Override // com.appnew.android.Dao.FeedsDao
    public List<PostDataTable> retrievePostData_withoutsubcat(final String parentId, final String main) throws Throwable {
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
        int i;
        String string;
        int i2;
        String string2;
        String string3;
        int i3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        String string15;
        String string16;
        String string17;
        String string18;
        String string19;
        String string20;
        String string21;
        String string22;
        String string23;
        String string24;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PostDataTable WHERE parentId = ? AND masterCat =? ", 2);
        if (parentId == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, parentId);
        }
        if (main == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, main);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, StoreProvider.StoreData.CREATED_DATE);
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "page");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "masterCat");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "postId");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "json");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "meta_url");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.LINK_TYPE);
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, StoreProvider.StoreData.MODIFIED_DATE);
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "my_like");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.POST_TYPE);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.PROFILE_PICTURE);
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sub_cat_id");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "text");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_comments");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_likes");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "newCourseData");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "livetest");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liveclass");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "testResult");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bannerlist");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liveClassStatus");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liveTestStatus");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "iscommentenable");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sectionposiiton");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Constants.KEY_LIMIT);
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "my_pinned");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "parentId");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_type");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_date");
            int i4 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                PostDataTable postDataTable = new PostDataTable();
                if (cursorQuery.isNull(columnIndexOrThrow)) {
                    i = columnIndexOrThrow;
                    string = null;
                } else {
                    i = columnIndexOrThrow;
                    string = cursorQuery.getString(columnIndexOrThrow);
                }
                postDataTable.setCreated(string);
                postDataTable.setPage(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                postDataTable.setMasterCat(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                postDataTable.setPostId(cursorQuery.getInt(columnIndexOrThrow4));
                postDataTable.setId(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                postDataTable.setJson(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                postDataTable.setMeta_url(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                postDataTable.setLink_type(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                postDataTable.setThumbnail(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                postDataTable.setUrl(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                postDataTable.setModified(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                postDataTable.setMy_like(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                postDataTable.setName(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                int i5 = i4;
                if (cursorQuery.isNull(i5)) {
                    i2 = i5;
                    string2 = null;
                } else {
                    i2 = i5;
                    string2 = cursorQuery.getString(i5);
                }
                postDataTable.setPost_type(string2);
                int i6 = columnIndexOrThrow15;
                if (cursorQuery.isNull(i6)) {
                    columnIndexOrThrow15 = i6;
                    string3 = null;
                } else {
                    columnIndexOrThrow15 = i6;
                    string3 = cursorQuery.getString(i6);
                }
                postDataTable.setProfile_picture(string3);
                int i7 = columnIndexOrThrow16;
                if (cursorQuery.isNull(i7)) {
                    i3 = i7;
                    string4 = null;
                } else {
                    i3 = i7;
                    string4 = cursorQuery.getString(i7);
                }
                postDataTable.setStatus(string4);
                int i8 = columnIndexOrThrow17;
                if (cursorQuery.isNull(i8)) {
                    columnIndexOrThrow17 = i8;
                    string5 = null;
                } else {
                    columnIndexOrThrow17 = i8;
                    string5 = cursorQuery.getString(i8);
                }
                postDataTable.setSub_cat_id(string5);
                int i9 = columnIndexOrThrow18;
                if (cursorQuery.isNull(i9)) {
                    columnIndexOrThrow18 = i9;
                    string6 = null;
                } else {
                    columnIndexOrThrow18 = i9;
                    string6 = cursorQuery.getString(i9);
                }
                postDataTable.setText(string6);
                int i10 = columnIndexOrThrow19;
                if (cursorQuery.isNull(i10)) {
                    columnIndexOrThrow19 = i10;
                    string7 = null;
                } else {
                    columnIndexOrThrow19 = i10;
                    string7 = cursorQuery.getString(i10);
                }
                postDataTable.setTotal_comments(string7);
                int i11 = columnIndexOrThrow20;
                if (cursorQuery.isNull(i11)) {
                    columnIndexOrThrow20 = i11;
                    string8 = null;
                } else {
                    columnIndexOrThrow20 = i11;
                    string8 = cursorQuery.getString(i11);
                }
                postDataTable.setTotal_likes(string8);
                int i12 = columnIndexOrThrow21;
                if (cursorQuery.isNull(i12)) {
                    columnIndexOrThrow21 = i12;
                    string9 = null;
                } else {
                    columnIndexOrThrow21 = i12;
                    string9 = cursorQuery.getString(i12);
                }
                postDataTable.setUser_id(string9);
                int i13 = columnIndexOrThrow22;
                if (cursorQuery.isNull(i13)) {
                    columnIndexOrThrow22 = i13;
                    string10 = null;
                } else {
                    columnIndexOrThrow22 = i13;
                    string10 = cursorQuery.getString(i13);
                }
                postDataTable.setNewCourseData(string10);
                int i14 = columnIndexOrThrow23;
                if (cursorQuery.isNull(i14)) {
                    columnIndexOrThrow23 = i14;
                    string11 = null;
                } else {
                    columnIndexOrThrow23 = i14;
                    string11 = cursorQuery.getString(i14);
                }
                postDataTable.setLivetest(string11);
                int i15 = columnIndexOrThrow24;
                if (cursorQuery.isNull(i15)) {
                    columnIndexOrThrow24 = i15;
                    string12 = null;
                } else {
                    columnIndexOrThrow24 = i15;
                    string12 = cursorQuery.getString(i15);
                }
                postDataTable.setLiveclass(string12);
                int i16 = columnIndexOrThrow25;
                if (cursorQuery.isNull(i16)) {
                    columnIndexOrThrow25 = i16;
                    string13 = null;
                } else {
                    columnIndexOrThrow25 = i16;
                    string13 = cursorQuery.getString(i16);
                }
                postDataTable.setTestResult(string13);
                int i17 = columnIndexOrThrow26;
                if (cursorQuery.isNull(i17)) {
                    columnIndexOrThrow26 = i17;
                    string14 = null;
                } else {
                    columnIndexOrThrow26 = i17;
                    string14 = cursorQuery.getString(i17);
                }
                postDataTable.setBannerlist(string14);
                int i18 = columnIndexOrThrow27;
                if (cursorQuery.isNull(i18)) {
                    columnIndexOrThrow27 = i18;
                    string15 = null;
                } else {
                    columnIndexOrThrow27 = i18;
                    string15 = cursorQuery.getString(i18);
                }
                postDataTable.setLiveClassStatus(string15);
                int i19 = columnIndexOrThrow28;
                if (cursorQuery.isNull(i19)) {
                    columnIndexOrThrow28 = i19;
                    string16 = null;
                } else {
                    columnIndexOrThrow28 = i19;
                    string16 = cursorQuery.getString(i19);
                }
                postDataTable.setLiveTestStatus(string16);
                int i20 = columnIndexOrThrow29;
                if (cursorQuery.isNull(i20)) {
                    columnIndexOrThrow29 = i20;
                    string17 = null;
                } else {
                    columnIndexOrThrow29 = i20;
                    string17 = cursorQuery.getString(i20);
                }
                postDataTable.setIscommentenable(string17);
                int i21 = columnIndexOrThrow30;
                if (cursorQuery.isNull(i21)) {
                    columnIndexOrThrow30 = i21;
                    string18 = null;
                } else {
                    columnIndexOrThrow30 = i21;
                    string18 = cursorQuery.getString(i21);
                }
                postDataTable.setSectionposiiton(string18);
                int i22 = columnIndexOrThrow31;
                if (cursorQuery.isNull(i22)) {
                    columnIndexOrThrow31 = i22;
                    string19 = null;
                } else {
                    columnIndexOrThrow31 = i22;
                    string19 = cursorQuery.getString(i22);
                }
                postDataTable.setLimit(string19);
                int i23 = columnIndexOrThrow32;
                if (cursorQuery.isNull(i23)) {
                    columnIndexOrThrow32 = i23;
                    string20 = null;
                } else {
                    columnIndexOrThrow32 = i23;
                    string20 = cursorQuery.getString(i23);
                }
                postDataTable.setMy_pinned(string20);
                int i24 = columnIndexOrThrow33;
                if (cursorQuery.isNull(i24)) {
                    columnIndexOrThrow33 = i24;
                    string21 = null;
                } else {
                    columnIndexOrThrow33 = i24;
                    string21 = cursorQuery.getString(i24);
                }
                postDataTable.setParentId(string21);
                int i25 = columnIndexOrThrow34;
                if (cursorQuery.isNull(i25)) {
                    columnIndexOrThrow34 = i25;
                    string22 = null;
                } else {
                    columnIndexOrThrow34 = i25;
                    string22 = cursorQuery.getString(i25);
                }
                postDataTable.setDescription(string22);
                int i26 = columnIndexOrThrow35;
                if (cursorQuery.isNull(i26)) {
                    columnIndexOrThrow35 = i26;
                    string23 = null;
                } else {
                    columnIndexOrThrow35 = i26;
                    string23 = cursorQuery.getString(i26);
                }
                postDataTable.setImage_type(string23);
                int i27 = columnIndexOrThrow36;
                if (cursorQuery.isNull(i27)) {
                    columnIndexOrThrow36 = i27;
                    string24 = null;
                } else {
                    columnIndexOrThrow36 = i27;
                    string24 = cursorQuery.getString(i27);
                }
                postDataTable.setSchedule_date(string24);
                arrayList.add(postDataTable);
                columnIndexOrThrow16 = i3;
                i4 = i2;
                columnIndexOrThrow = i;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.appnew.android.Dao.FeedsDao
    public PostDataTable retriveObject(final String mainCat, final String postid) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        PostDataTable postDataTable;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PostDataTable WHERE id = ? AND masterCat =?", 2);
        if (postid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, postid);
        }
        if (mainCat == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, mainCat);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, StoreProvider.StoreData.CREATED_DATE);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "page");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "masterCat");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "postId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "json");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "meta_url");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.LINK_TYPE);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, StoreProvider.StoreData.MODIFIED_DATE);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "my_like");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.POST_TYPE);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.PROFILE_PICTURE);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sub_cat_id");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "text");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_comments");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_likes");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "newCourseData");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "livetest");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liveclass");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "testResult");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bannerlist");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liveClassStatus");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liveTestStatus");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "iscommentenable");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sectionposiiton");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Constants.KEY_LIMIT);
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "my_pinned");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "parentId");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_type");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_date");
                if (cursorQuery.moveToFirst()) {
                    PostDataTable postDataTable2 = new PostDataTable();
                    postDataTable2.setCreated(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                    postDataTable2.setPage(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    postDataTable2.setMasterCat(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    postDataTable2.setPostId(cursorQuery.getInt(columnIndexOrThrow4));
                    postDataTable2.setId(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    postDataTable2.setJson(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    postDataTable2.setMeta_url(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    postDataTable2.setLink_type(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    postDataTable2.setThumbnail(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    postDataTable2.setUrl(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    postDataTable2.setModified(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    postDataTable2.setMy_like(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    postDataTable2.setName(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    postDataTable2.setPost_type(cursorQuery.isNull(columnIndexOrThrow14) ? null : cursorQuery.getString(columnIndexOrThrow14));
                    postDataTable2.setProfile_picture(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                    postDataTable2.setStatus(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16));
                    postDataTable2.setSub_cat_id(cursorQuery.isNull(columnIndexOrThrow17) ? null : cursorQuery.getString(columnIndexOrThrow17));
                    postDataTable2.setText(cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18));
                    postDataTable2.setTotal_comments(cursorQuery.isNull(columnIndexOrThrow19) ? null : cursorQuery.getString(columnIndexOrThrow19));
                    postDataTable2.setTotal_likes(cursorQuery.isNull(columnIndexOrThrow20) ? null : cursorQuery.getString(columnIndexOrThrow20));
                    postDataTable2.setUser_id(cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21));
                    postDataTable2.setNewCourseData(cursorQuery.isNull(columnIndexOrThrow22) ? null : cursorQuery.getString(columnIndexOrThrow22));
                    postDataTable2.setLivetest(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                    postDataTable2.setLiveclass(cursorQuery.isNull(columnIndexOrThrow24) ? null : cursorQuery.getString(columnIndexOrThrow24));
                    postDataTable2.setTestResult(cursorQuery.isNull(columnIndexOrThrow25) ? null : cursorQuery.getString(columnIndexOrThrow25));
                    postDataTable2.setBannerlist(cursorQuery.isNull(columnIndexOrThrow26) ? null : cursorQuery.getString(columnIndexOrThrow26));
                    postDataTable2.setLiveClassStatus(cursorQuery.isNull(columnIndexOrThrow27) ? null : cursorQuery.getString(columnIndexOrThrow27));
                    postDataTable2.setLiveTestStatus(cursorQuery.isNull(columnIndexOrThrow28) ? null : cursorQuery.getString(columnIndexOrThrow28));
                    postDataTable2.setIscommentenable(cursorQuery.isNull(columnIndexOrThrow29) ? null : cursorQuery.getString(columnIndexOrThrow29));
                    postDataTable2.setSectionposiiton(cursorQuery.isNull(columnIndexOrThrow30) ? null : cursorQuery.getString(columnIndexOrThrow30));
                    postDataTable2.setLimit(cursorQuery.isNull(columnIndexOrThrow31) ? null : cursorQuery.getString(columnIndexOrThrow31));
                    postDataTable2.setMy_pinned(cursorQuery.isNull(columnIndexOrThrow32) ? null : cursorQuery.getString(columnIndexOrThrow32));
                    postDataTable2.setParentId(cursorQuery.isNull(columnIndexOrThrow33) ? null : cursorQuery.getString(columnIndexOrThrow33));
                    postDataTable2.setDescription(cursorQuery.isNull(columnIndexOrThrow34) ? null : cursorQuery.getString(columnIndexOrThrow34));
                    postDataTable2.setImage_type(cursorQuery.isNull(columnIndexOrThrow35) ? null : cursorQuery.getString(columnIndexOrThrow35));
                    postDataTable2.setSchedule_date(cursorQuery.isNull(columnIndexOrThrow36) ? null : cursorQuery.getString(columnIndexOrThrow36));
                    postDataTable = postDataTable2;
                } else {
                    postDataTable = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return postDataTable;
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

    @Override // com.appnew.android.Dao.FeedsDao
    public PostDataTable postData(final String postid) throws Throwable {
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
        PostDataTable postDataTable;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PostDataTable WHERE id = ?", 1);
        if (postid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, postid);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, StoreProvider.StoreData.CREATED_DATE);
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "page");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "masterCat");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "postId");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "json");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "meta_url");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.LINK_TYPE);
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, StoreProvider.StoreData.MODIFIED_DATE);
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "my_like");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.POST_TYPE);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.PROFILE_PICTURE);
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sub_cat_id");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "text");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_comments");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total_likes");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "newCourseData");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "livetest");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liveclass");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "testResult");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bannerlist");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liveClassStatus");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "liveTestStatus");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "iscommentenable");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sectionposiiton");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Constants.KEY_LIMIT);
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "my_pinned");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "parentId");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_type");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_date");
            if (cursorQuery.moveToFirst()) {
                PostDataTable postDataTable2 = new PostDataTable();
                postDataTable2.setCreated(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                postDataTable2.setPage(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                postDataTable2.setMasterCat(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                postDataTable2.setPostId(cursorQuery.getInt(columnIndexOrThrow4));
                postDataTable2.setId(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                postDataTable2.setJson(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                postDataTable2.setMeta_url(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                postDataTable2.setLink_type(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                postDataTable2.setThumbnail(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                postDataTable2.setUrl(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                postDataTable2.setModified(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                postDataTable2.setMy_like(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                postDataTable2.setName(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                postDataTable2.setPost_type(cursorQuery.isNull(columnIndexOrThrow14) ? null : cursorQuery.getString(columnIndexOrThrow14));
                postDataTable2.setProfile_picture(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                postDataTable2.setStatus(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16));
                postDataTable2.setSub_cat_id(cursorQuery.isNull(columnIndexOrThrow17) ? null : cursorQuery.getString(columnIndexOrThrow17));
                postDataTable2.setText(cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18));
                postDataTable2.setTotal_comments(cursorQuery.isNull(columnIndexOrThrow19) ? null : cursorQuery.getString(columnIndexOrThrow19));
                postDataTable2.setTotal_likes(cursorQuery.isNull(columnIndexOrThrow20) ? null : cursorQuery.getString(columnIndexOrThrow20));
                postDataTable2.setUser_id(cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21));
                postDataTable2.setNewCourseData(cursorQuery.isNull(columnIndexOrThrow22) ? null : cursorQuery.getString(columnIndexOrThrow22));
                postDataTable2.setLivetest(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                postDataTable2.setLiveclass(cursorQuery.isNull(columnIndexOrThrow24) ? null : cursorQuery.getString(columnIndexOrThrow24));
                postDataTable2.setTestResult(cursorQuery.isNull(columnIndexOrThrow25) ? null : cursorQuery.getString(columnIndexOrThrow25));
                postDataTable2.setBannerlist(cursorQuery.isNull(columnIndexOrThrow26) ? null : cursorQuery.getString(columnIndexOrThrow26));
                postDataTable2.setLiveClassStatus(cursorQuery.isNull(columnIndexOrThrow27) ? null : cursorQuery.getString(columnIndexOrThrow27));
                postDataTable2.setLiveTestStatus(cursorQuery.isNull(columnIndexOrThrow28) ? null : cursorQuery.getString(columnIndexOrThrow28));
                postDataTable2.setIscommentenable(cursorQuery.isNull(columnIndexOrThrow29) ? null : cursorQuery.getString(columnIndexOrThrow29));
                postDataTable2.setSectionposiiton(cursorQuery.isNull(columnIndexOrThrow30) ? null : cursorQuery.getString(columnIndexOrThrow30));
                postDataTable2.setLimit(cursorQuery.isNull(columnIndexOrThrow31) ? null : cursorQuery.getString(columnIndexOrThrow31));
                postDataTable2.setMy_pinned(cursorQuery.isNull(columnIndexOrThrow32) ? null : cursorQuery.getString(columnIndexOrThrow32));
                postDataTable2.setParentId(cursorQuery.isNull(columnIndexOrThrow33) ? null : cursorQuery.getString(columnIndexOrThrow33));
                postDataTable2.setDescription(cursorQuery.isNull(columnIndexOrThrow34) ? null : cursorQuery.getString(columnIndexOrThrow34));
                postDataTable2.setImage_type(cursorQuery.isNull(columnIndexOrThrow35) ? null : cursorQuery.getString(columnIndexOrThrow35));
                postDataTable2.setSchedule_date(cursorQuery.isNull(columnIndexOrThrow36) ? null : cursorQuery.getString(columnIndexOrThrow36));
                postDataTable = postDataTable2;
            } else {
                postDataTable = null;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return postDataTable;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.appnew.android.Dao.FeedsDao
    public boolean isFeedExist(final String postid) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM PostDataTable WHERE id = ?)", 1);
        if (postid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, postid);
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

    @Override // com.appnew.android.Dao.FeedsDao
    public boolean isFeedExistviamaincat(final String posttype, final String subcat) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM PostDataTable WHERE post_type = ? AND sub_cat_id =?)", 2);
        if (posttype == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, posttype);
        }
        if (subcat == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, subcat);
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

    @Override // com.appnew.android.Dao.FeedsDao
    public boolean isliveclassExist(final String posttype, final String maincat) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM PostDataTable WHERE post_type = ?  AND masterCat =? )", 2);
        if (posttype == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, posttype);
        }
        if (maincat == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, maincat);
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
