package com.appnew.android.Room;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.appnew.android.Dao.ApiDao;
import com.appnew.android.Dao.ApiDao_Impl;
import com.appnew.android.Dao.AudioDao;
import com.appnew.android.Dao.AudioDao_Impl;
import com.appnew.android.Dao.BannerListDao;
import com.appnew.android.Dao.BannerListDao_Impl;
import com.appnew.android.Dao.BottomMenuDao;
import com.appnew.android.Dao.BottomMenuDao_Impl;
import com.appnew.android.Dao.CenterIdDao;
import com.appnew.android.Dao.CenterIdDao_Impl;
import com.appnew.android.Dao.CourseDataDao;
import com.appnew.android.Dao.CourseDataDao_Impl;
import com.appnew.android.Dao.CourseDetailDao;
import com.appnew.android.Dao.CourseDetailDao_Impl;
import com.appnew.android.Dao.CourseTypeMasterDao;
import com.appnew.android.Dao.CourseTypeMasterDao_Impl;
import com.appnew.android.Dao.DueEmiDao;
import com.appnew.android.Dao.DueEmiDao_Impl;
import com.appnew.android.Dao.ExpiredEmiDao;
import com.appnew.android.Dao.ExpiredEmiDao_Impl;
import com.appnew.android.Dao.FeedsDao;
import com.appnew.android.Dao.FeedsDao_Impl;
import com.appnew.android.Dao.FolderDao;
import com.appnew.android.Dao.FolderDao_Impl;
import com.appnew.android.Dao.GetMasterAllCatDao;
import com.appnew.android.Dao.GetMasterAllCatDao_Impl;
import com.appnew.android.Dao.HomeApiStatusDao;
import com.appnew.android.Dao.HomeApiStatusDao_Impl;
import com.appnew.android.Dao.Htmllink;
import com.appnew.android.Dao.Htmllink_Impl;
import com.appnew.android.Dao.LaunguageDao;
import com.appnew.android.Dao.LaunguageDao_Impl;
import com.appnew.android.Dao.MasterCatDao;
import com.appnew.android.Dao.MasterCatDao_Impl;
import com.appnew.android.Dao.MycourseDao;
import com.appnew.android.Dao.MycourseDao_Impl;
import com.appnew.android.Dao.PDFDataDao;
import com.appnew.android.Dao.PDFDataDao_Impl;
import com.appnew.android.Dao.PigiBag;
import com.appnew.android.Dao.PigiBag_Impl;
import com.appnew.android.Dao.PollDataDao;
import com.appnew.android.Dao.PollDataDao_Impl;
import com.appnew.android.Dao.TestDao;
import com.appnew.android.Dao.TestDao_Impl;
import com.appnew.android.Dao.TestResumeDao;
import com.appnew.android.Dao.TestResumeDao_Impl;
import com.appnew.android.Dao.ThemeSettingDao;
import com.appnew.android.Dao.ThemeSettingDao_Impl;
import com.appnew.android.Dao.TopperReviewDao;
import com.appnew.android.Dao.TopperReviewDao_Impl;
import com.appnew.android.Dao.UserHistroyDao;
import com.appnew.android.Dao.UserHistroyDao_Impl;
import com.appnew.android.Dao.UserWiseCourseDao;
import com.appnew.android.Dao.UserWiseCourseDao_Impl;
import com.appnew.android.Dao.VideoDao;
import com.appnew.android.Dao.VideoDao_Impl;
import com.appnew.android.Dao.VideoDownload;
import com.appnew.android.Dao.VideoDownload_Impl;
import com.appnew.android.Dao.YoutubePlayerDao;
import com.appnew.android.Dao.YoutubePlayerDao_Impl;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.StoreProvider;
import com.clevertap.android.sdk.Constants;
import com.facebook.AuthenticationTokenClaims;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public final class UtkashRoom_Impl extends UtkashRoom {
    private volatile ApiDao _apiDao;
    private volatile AudioDao _audioDao;
    private volatile BannerListDao _bannerListDao;
    private volatile BottomMenuDao _bottomMenuDao;
    private volatile CenterIdDao _centerIdDao;
    private volatile CourseDataDao _courseDataDao;
    private volatile CourseDetailDao _courseDetailDao;
    private volatile CourseTypeMasterDao _courseTypeMasterDao;
    private volatile DueEmiDao _dueEmiDao;
    private volatile ExpiredEmiDao _expiredEmiDao;
    private volatile FeedsDao _feedsDao;
    private volatile FolderDao _folderDao;
    private volatile GetMasterAllCatDao _getMasterAllCatDao;
    private volatile HomeApiStatusDao _homeApiStatusDao;
    private volatile Htmllink _htmllink;
    private volatile LaunguageDao _launguageDao;
    private volatile MasterCatDao _masterCatDao;
    private volatile MycourseDao _mycourseDao;
    private volatile PDFDataDao _pDFDataDao;
    private volatile PigiBag _pigiBag;
    private volatile PollDataDao _pollDataDao;
    private volatile TestDao _testDao;
    private volatile TestResumeDao _testResumeDao;
    private volatile ThemeSettingDao _themeSettingDao;
    private volatile TopperReviewDao _topperReviewDao;
    private volatile UserHistroyDao _userHistroyDao;
    private volatile UserWiseCourseDao _userWiseCourseDao;
    private volatile VideoDao _videoDao;
    private volatile VideoDownload _videoDownload;
    private volatile YoutubePlayerDao _youtubePlayerDao;

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(final DatabaseConfiguration config) {
        return config.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(new RoomOpenHelper(config, new RoomOpenHelper.Delegate(33) { // from class: com.appnew.android.Room.UtkashRoom_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(final SupportSQLiteDatabase db) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("CREATE TABLE IF NOT EXISTS `ThemeSettings` (`autoid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `theme` TEXT, `bottom` TEXT, `left_menu` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `UserWiseCourseTable` (`auto_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `meta_id` TEXT, `code` TEXT, `version` TEXT, `exp` TEXT, `userid` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `TestTable` (`autoid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `test_id` TEXT, `user_id` TEXT, `course_id` TEXT, `status` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `APITABLE` (`auto_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `user_id` TEXT, `timestamp` TEXT, `cdtimestamp` TEXT, `version` TEXT, `Apiname` TEXT, `Apicode` TEXT, `interval` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `PigibagTable` (`auto_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `cdtimestamp` TEXT, `user_id` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `LanguagesTable` (`autoid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id` TEXT, `language` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `HomeApiStatusTable` (`autoid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userid` TEXT, `mainid` TEXT, `status` TEXT, `page` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `CourseDataTable` (`autoid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userid` TEXT, `cat_type` TEXT DEFAULT '', `mainid` TEXT, `category` TEXT, `courseid` TEXT, `title` TEXT, `cover_image` TEXT, `desc_header_image` TEXT, `mrp` TEXT, `payment_mode` TEXT, `course_sp` TEXT, `subject_id` TEXT, `avg_rating` TEXT, `user_rated` TEXT, `is_purchased` TEXT, `content_type` TEXT, `lang_id` TEXT, `extra_json` TEXT, `validity` TEXT, `type_id` TEXT, `combo_course_ids` TEXT, `viewType` TEXT, `valid_to` TEXT, `hide_validity` TEXT DEFAULT '', `discount` TEXT DEFAULT '', `cart_quantity` TEXT DEFAULT '', `stocks` TEXT DEFAULT '', `delivery_charge` TEXT DEFAULT '', `delivery_charge_out_of_india` TEXT DEFAULT '', `description` TEXT DEFAULT '', `book_redirection_link` TEXT DEFAULT '')");
                db.execSQL("CREATE TABLE IF NOT EXISTS `mycoursetable` (`autoid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id` TEXT, `cat_type` TEXT DEFAULT '', `is_activated` TEXT NOT NULL, `title` TEXT, `isSelect` TEXT, `isExpand` TEXT, `batch_id` TEXT, `cover_image` TEXT, `desc_header_image` TEXT, `expiry_date` TEXT, `purchase_date` TEXT, `mrp` TEXT, `txn_id` TEXT, `lastread` TEXT, `userid` TEXT, `batchtype` TEXT, `delete` INTEGER NOT NULL, `content_type` TEXT, `prices` TEXT, `combo_course_ids` TEXT NOT NULL, `viewType` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `CourseDetailTable` (`autoid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `coursetitle` TEXT, `couseid` TEXT, `display_locked` TEXT, `tax` TEXT, `is_purchased` TEXT, `is_gst` TEXT, `course_code` TEXT, `content_type` TEXT, `validity` TEXT, `is_activated` TEXT, `token_activation` TEXT, `course_sp` TEXT, `userid` TEXT, `tileid` TEXT, `tiletitile` TEXT, `tilerevert` TEXT, `description` TEXT, `tilemeta` TEXT, `skip_payment` TEXT, `cat_type` TEXT, `delivery_charge` TEXT, `txnid` TEXT, `instalment` TEXT, `mrp` TEXT, `view_type` TEXT, `author_title` TEXT, `type` TEXT, `is_combo` TEXT, `desc_header_image` TEXT, `is_trial` TEXT, `last_paid_txn_id` TEXT, `is_rating` TEXT, `payment_mode` TEXT, `event_location` TEXT, `location` TEXT, `start_date` TEXT, `end_date` TEXT, `extra_json` TEXT, `cover_image` TEXT, `subscription_all_data` TEXT, `hide_validity` TEXT DEFAULT '', `avg_rating` TEXT, `user_rated` TEXT, `stocks` TEXT, `external_coupon_off` TEXT, `transaction_status` TEXT, `combo_has_book` TEXT, `tax_rate` TEXT, `set_as_demo` TEXT, `thumbnail` TEXT, `book_redirection_link` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `HtmlTbale` (`autoid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `concept_id` TEXT, `tile_id` TEXT, `user_id` TEXT, `course_id` TEXT, `highight` TEXT, `html` TEXT, `valid_to` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `YoutubePlayerTable` (`autoid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `youtubeid` TEXT, `youtubetime` INTEGER NOT NULL, `userid` TEXT, `videoid` TEXT, `isaudio` TEXT, `videoname` TEXT, `valid_to` TEXT, `course_id` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `VideoTable` (`autoid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `video_id` TEXT, `video_name` TEXT, `user_id` TEXT, `video_currentpos` INTEGER, `jw_url` TEXT, `course_id` TEXT, `valid_to` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `UserHistroyTable` (`autoid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `video_id` TEXT, `video_name` TEXT, `user_id` TEXT, `type` TEXT, `pdf_name` TEXT, `pdf_download` TEXT, `youtube_url` TEXT, `pdf_url` TEXT, `current_time` TEXT, `course_id` TEXT, `valid_to` TEXT, `coursename` TEXT, `tileid` TEXT, `testid` TEXT, `testname` TEXT, `topicname` TEXT, `url` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `AudioTable` (`autoid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `video_id` TEXT, `video_name` TEXT, `user_id` TEXT, `audio_url` TEXT, `audio_currentpos` INTEGER, `jw_url` TEXT, `valid_to` TEXT, `course_id` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `VideoDownload` (`autoid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `video_id` TEXT, `video_type` TEXT, `vdc_id` TEXT, `video_name` TEXT, `originalFileLengthString` TEXT, `videotime` TEXT, `link` TEXT, `total` INTEGER, `lengthInMb` TEXT, `percentage` INTEGER NOT NULL, `user_id` TEXT, `course_id` TEXT, `valid_to` INTEGER NOT NULL, `remaining_time` TEXT NOT NULL, `tile_id` TEXT NOT NULL, `multiplayer` TEXT NOT NULL, `is_limited` TEXT NOT NULL, `video_length` TEXT NOT NULL, `with_validity` TEXT, `with_validity_message` TEXT, `validity_end_date` TEXT, `validity_start_date` TEXT, `position` INTEGER NOT NULL, `mp4_download_url` TEXT, `video_status` TEXT, `thumbnail_url` TEXT, `is_complete` TEXT, `videoCurrentPosition` INTEGER, `jw_url` TEXT, `is_selected` TEXT, `video_history` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `MasteAllCatTable` (`auto_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id` TEXT, `name` TEXT, `parent_id` TEXT, `master_type` TEXT, `user_id` TEXT, `app_hide` TEXT, `font_color` TEXT, `bg_color` TEXT, `image` TEXT NOT NULL, `filters` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `CourseTypeMasterTable` (`display_type` TEXT, `auto_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id` TEXT, `name` TEXT, `user_id` TEXT, `icon` TEXT, `font_color` TEXT, `bg_color` TEXT, `cat_type` TEXT, `master_category_id` TEXT, `course_id` TEXT, `description` TEXT, `sec_color` TEXT, `sec_bg_color` TEXT, `view_type` TEXT, `weblink_url` TEXT, `sub_cat_id` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `MasterCat` (`auto_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id` TEXT, `cat` TEXT, `user_id` TEXT, `app_hide` TEXT, `isSelected` INTEGER NOT NULL DEFAULT false)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `BannerListTable` (`auto_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id` TEXT, `extra` TEXT NOT NULL, `banner_title` TEXT, `image_type` TEXT, `banner_url` TEXT, `user_id` TEXT, `master_cat` TEXT, `course_type` TEXT, `link` TEXT NOT NULL, `course_id` TEXT NOT NULL, `parent_id` TEXT, `banner_type` TEXT NOT NULL, `banner_location` TEXT NOT NULL, `link_type` TEXT, `center_id` TEXT, `is_combo` INTEGER NOT NULL DEFAULT 0)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `PostDataTable` (`created` TEXT NOT NULL, `page` TEXT NOT NULL, `masterCat` TEXT NOT NULL, `postId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id` TEXT NOT NULL, `json` TEXT NOT NULL, `meta_url` TEXT NOT NULL, `link_type` TEXT NOT NULL DEFAULT '', `thumbnail` TEXT NOT NULL, `url` TEXT NOT NULL, `modified` TEXT NOT NULL, `my_like` TEXT NOT NULL, `name` TEXT NOT NULL, `post_type` TEXT NOT NULL, `profile_picture` TEXT NOT NULL, `status` TEXT NOT NULL, `sub_cat_id` TEXT NOT NULL, `text` TEXT NOT NULL, `total_comments` TEXT NOT NULL, `total_likes` TEXT NOT NULL, `user_id` TEXT NOT NULL, `newCourseData` TEXT NOT NULL, `livetest` TEXT NOT NULL, `liveclass` TEXT NOT NULL, `testResult` TEXT NOT NULL, `bannerlist` TEXT NOT NULL, `liveClassStatus` TEXT NOT NULL, `liveTestStatus` TEXT NOT NULL, `iscommentenable` TEXT NOT NULL, `sectionposiiton` TEXT NOT NULL, `limit` TEXT NOT NULL, `my_pinned` TEXT NOT NULL, `parentId` TEXT NOT NULL, `description` TEXT NOT NULL, `image_type` TEXT, `schedule_date` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `TopperReviewTable` (`auto_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id` TEXT, `user_id` TEXT, `title` TEXT, `file_url` TEXT, `thumbnail_url` TEXT, `banner_url` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `BottomMenuTable` (`auto_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT, `icon` TEXT, `type` TEXT, `param_value` TEXT, `user_id` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `ExpiredEMI` (`auto_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id` TEXT, `txn_id` TEXT, `viewType` TEXT, `holderType` TEXT, `maintenanceText` TEXT, `title` TEXT, `segment_information` TEXT, `courseAttribute` TEXT, `cover_image` TEXT, `descHeaderImage` TEXT, `mrp` TEXT, `courseSp` TEXT, `colorCode` TEXT, `validity` TEXT, `avg_rating` TEXT, `user_rated` TEXT, `learner` TEXT, `is_activated` TEXT, `is_subscription` TEXT, `check_for_expiry` TEXT, `isLive` TEXT, `is_locked` TEXT, `home_screen` TEXT, `isExpand` INTEGER NOT NULL, `lastread` TEXT, `skipUnit` TEXT, `skipChapter` TEXT, `combo_course_ids` TEXT, `payment_type` TEXT, `is_postal_available` TEXT, `expiry_date` TEXT, `purchase_date` TEXT, `url` TEXT, `prices` TEXT, `batch_id` TEXT, `subject_id` TEXT, `lang_id` TEXT, `type_id` TEXT, `delete` INTEGER NOT NULL, `payment_mode` TEXT, `emi_payment` TEXT, `subscription_code` TEXT, `isSelect` INTEGER NOT NULL)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `FolderEntity` (`auto_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `hitCount` TEXT, `data` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `DueEmiTable` (`auto_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id` TEXT, `txn_id` TEXT, `viewType` TEXT, `holderType` TEXT, `maintenanceText` TEXT, `title` TEXT, `segment_information` TEXT, `courseAttribute` TEXT, `isSelect` TEXT, `isExpand` TEXT, `cover_image` TEXT, `descHeaderImage` TEXT, `mrp` TEXT, `courseSp` TEXT, `colorCode` TEXT, `validity` TEXT, `avg_rating` TEXT, `user_rated` TEXT, `learner` TEXT, `is_activated` TEXT, `check_for_expiry` TEXT, `isLive` TEXT, `is_locked` TEXT, `home_screen` TEXT, `lastread` TEXT, `skipUnit` TEXT, `skipChapter` TEXT, `combo_course_ids` TEXT, `payment_type` TEXT, `is_postal_available` TEXT, `expiry_date` TEXT, `purchase_date` TEXT, `url` TEXT, `prices` TEXT, `batch_id` TEXT, `subject_id` TEXT, `lang_id` TEXT, `type_id` TEXT, `delete` INTEGER NOT NULL, `payment_mode` TEXT, `emi_payment` TEXT, `subscription_code` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `TestResumeTable` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `courseName` TEXT, `user_id` TEXT, `remaining_time` TEXT, `lastPosition` INTEGER NOT NULL, `courseDescription` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `PollDataTable` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `user_id` TEXT, `poll_id` TEXT, `firebase_node` TEXT, `poll_answer` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `PDFDataTable` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` TEXT, `pdfName` TEXT, `pdfFile` TEXT, `pdfId` TEXT, `pdfImage` TEXT, `pdfPath` TEXT, `is_selected` TEXT, `pdfUrl` TEXT, `isShare` TEXT)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `CenterIdTable` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `center_id` TEXT, `user_id` TEXT, `center_name` TEXT)");
                db.execSQL(RoomMasterTable.CREATE_QUERY);
                db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8f9ee4dd5d677632a57d999f0b4f2808')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("DROP TABLE IF EXISTS `ThemeSettings`");
                db.execSQL("DROP TABLE IF EXISTS `UserWiseCourseTable`");
                db.execSQL("DROP TABLE IF EXISTS `TestTable`");
                db.execSQL("DROP TABLE IF EXISTS `APITABLE`");
                db.execSQL("DROP TABLE IF EXISTS `PigibagTable`");
                db.execSQL("DROP TABLE IF EXISTS `LanguagesTable`");
                db.execSQL("DROP TABLE IF EXISTS `HomeApiStatusTable`");
                db.execSQL("DROP TABLE IF EXISTS `CourseDataTable`");
                db.execSQL("DROP TABLE IF EXISTS `mycoursetable`");
                db.execSQL("DROP TABLE IF EXISTS `CourseDetailTable`");
                db.execSQL("DROP TABLE IF EXISTS `HtmlTbale`");
                db.execSQL("DROP TABLE IF EXISTS `YoutubePlayerTable`");
                db.execSQL("DROP TABLE IF EXISTS `VideoTable`");
                db.execSQL("DROP TABLE IF EXISTS `UserHistroyTable`");
                db.execSQL("DROP TABLE IF EXISTS `AudioTable`");
                db.execSQL("DROP TABLE IF EXISTS `VideoDownload`");
                db.execSQL("DROP TABLE IF EXISTS `MasteAllCatTable`");
                db.execSQL("DROP TABLE IF EXISTS `CourseTypeMasterTable`");
                db.execSQL("DROP TABLE IF EXISTS `MasterCat`");
                db.execSQL("DROP TABLE IF EXISTS `BannerListTable`");
                db.execSQL("DROP TABLE IF EXISTS `PostDataTable`");
                db.execSQL("DROP TABLE IF EXISTS `TopperReviewTable`");
                db.execSQL("DROP TABLE IF EXISTS `BottomMenuTable`");
                db.execSQL("DROP TABLE IF EXISTS `ExpiredEMI`");
                db.execSQL("DROP TABLE IF EXISTS `FolderEntity`");
                db.execSQL("DROP TABLE IF EXISTS `DueEmiTable`");
                db.execSQL("DROP TABLE IF EXISTS `TestResumeTable`");
                db.execSQL("DROP TABLE IF EXISTS `PollDataTable`");
                db.execSQL("DROP TABLE IF EXISTS `PDFDataTable`");
                db.execSQL("DROP TABLE IF EXISTS `CenterIdTable`");
                List list = UtkashRoom_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onDestructiveMigration(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(final SupportSQLiteDatabase db) {
                List list = UtkashRoom_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onCreate(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(final SupportSQLiteDatabase db) {
                UtkashRoom_Impl.this.mDatabase = db;
                UtkashRoom_Impl.this.internalInitInvalidationTracker(db);
                List list = UtkashRoom_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onOpen(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(final SupportSQLiteDatabase db) {
                DBUtil.dropFtsSyncTriggers(db);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(final SupportSQLiteDatabase db) {
                HashMap map = new HashMap(4);
                map.put("autoid", new TableInfo.Column("autoid", "INTEGER", true, 1, null, 1));
                map.put(Const.THEME, new TableInfo.Column(Const.THEME, "TEXT", false, 0, null, 1));
                map.put("bottom", new TableInfo.Column("bottom", "TEXT", false, 0, null, 1));
                map.put("left_menu", new TableInfo.Column("left_menu", "TEXT", false, 0, null, 1));
                TableInfo tableInfo = new TableInfo("ThemeSettings", map, new HashSet(0), new HashSet(0));
                TableInfo tableInfo2 = TableInfo.read(db, "ThemeSettings");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(false, "ThemeSettings(com.appnew.android.table.ThemeSettings).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                HashMap map2 = new HashMap(6);
                map2.put("auto_id", new TableInfo.Column("auto_id", "INTEGER", true, 1, null, 1));
                map2.put("meta_id", new TableInfo.Column("meta_id", "TEXT", false, 0, null, 1));
                map2.put("code", new TableInfo.Column("code", "TEXT", false, 0, null, 1));
                map2.put("version", new TableInfo.Column("version", "TEXT", false, 0, null, 1));
                map2.put(AuthenticationTokenClaims.JSON_KEY_EXP, new TableInfo.Column(AuthenticationTokenClaims.JSON_KEY_EXP, "TEXT", false, 0, null, 1));
                map2.put("userid", new TableInfo.Column("userid", "TEXT", false, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo("UserWiseCourseTable", map2, new HashSet(0), new HashSet(0));
                TableInfo tableInfo4 = TableInfo.read(db, "UserWiseCourseTable");
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenHelper.ValidationResult(false, "UserWiseCourseTable(com.appnew.android.table.UserWiseCourseTable).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                HashMap map3 = new HashMap(5);
                map3.put("autoid", new TableInfo.Column("autoid", "INTEGER", true, 1, null, 1));
                map3.put("test_id", new TableInfo.Column("test_id", "TEXT", false, 0, null, 1));
                map3.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0, null, 1));
                map3.put("course_id", new TableInfo.Column("course_id", "TEXT", false, 0, null, 1));
                map3.put("status", new TableInfo.Column("status", "TEXT", false, 0, null, 1));
                TableInfo tableInfo5 = new TableInfo("TestTable", map3, new HashSet(0), new HashSet(0));
                TableInfo tableInfo6 = TableInfo.read(db, "TestTable");
                if (!tableInfo5.equals(tableInfo6)) {
                    return new RoomOpenHelper.ValidationResult(false, "TestTable(com.appnew.android.table.TestTable).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
                }
                HashMap map4 = new HashMap(8);
                map4.put("auto_id", new TableInfo.Column("auto_id", "INTEGER", true, 1, null, 1));
                map4.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0, null, 1));
                map4.put("timestamp", new TableInfo.Column("timestamp", "TEXT", false, 0, null, 1));
                map4.put("cdtimestamp", new TableInfo.Column("cdtimestamp", "TEXT", false, 0, null, 1));
                map4.put("version", new TableInfo.Column("version", "TEXT", false, 0, null, 1));
                map4.put("Apiname", new TableInfo.Column("Apiname", "TEXT", false, 0, null, 1));
                map4.put("Apicode", new TableInfo.Column("Apicode", "TEXT", false, 0, null, 1));
                map4.put("interval", new TableInfo.Column("interval", "TEXT", false, 0, null, 1));
                TableInfo tableInfo7 = new TableInfo("APITABLE", map4, new HashSet(0), new HashSet(0));
                TableInfo tableInfo8 = TableInfo.read(db, "APITABLE");
                if (!tableInfo7.equals(tableInfo8)) {
                    return new RoomOpenHelper.ValidationResult(false, "APITABLE(com.appnew.android.table.APITABLE).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
                }
                HashMap map5 = new HashMap(3);
                map5.put("auto_id", new TableInfo.Column("auto_id", "INTEGER", true, 1, null, 1));
                map5.put("cdtimestamp", new TableInfo.Column("cdtimestamp", "TEXT", false, 0, null, 1));
                map5.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0, null, 1));
                TableInfo tableInfo9 = new TableInfo("PigibagTable", map5, new HashSet(0), new HashSet(0));
                TableInfo tableInfo10 = TableInfo.read(db, "PigibagTable");
                if (!tableInfo9.equals(tableInfo10)) {
                    return new RoomOpenHelper.ValidationResult(false, "PigibagTable(com.appnew.android.table.PigibagTable).\n Expected:\n" + tableInfo9 + "\n Found:\n" + tableInfo10);
                }
                HashMap map6 = new HashMap(3);
                map6.put("autoid", new TableInfo.Column("autoid", "INTEGER", true, 1, null, 1));
                map6.put("id", new TableInfo.Column("id", "TEXT", false, 0, null, 1));
                map6.put(Const.LANGUAGE, new TableInfo.Column(Const.LANGUAGE, "TEXT", false, 0, null, 1));
                TableInfo tableInfo11 = new TableInfo("LanguagesTable", map6, new HashSet(0), new HashSet(0));
                TableInfo tableInfo12 = TableInfo.read(db, "LanguagesTable");
                if (!tableInfo11.equals(tableInfo12)) {
                    return new RoomOpenHelper.ValidationResult(false, "LanguagesTable(com.appnew.android.table.LanguagesTable).\n Expected:\n" + tableInfo11 + "\n Found:\n" + tableInfo12);
                }
                HashMap map7 = new HashMap(5);
                map7.put("autoid", new TableInfo.Column("autoid", "INTEGER", true, 1, null, 1));
                map7.put("userid", new TableInfo.Column("userid", "TEXT", false, 0, null, 1));
                map7.put("mainid", new TableInfo.Column("mainid", "TEXT", false, 0, null, 1));
                map7.put("status", new TableInfo.Column("status", "TEXT", false, 0, null, 1));
                map7.put("page", new TableInfo.Column("page", "TEXT", false, 0, null, 1));
                TableInfo tableInfo13 = new TableInfo("HomeApiStatusTable", map7, new HashSet(0), new HashSet(0));
                TableInfo tableInfo14 = TableInfo.read(db, "HomeApiStatusTable");
                if (!tableInfo13.equals(tableInfo14)) {
                    return new RoomOpenHelper.ValidationResult(false, "HomeApiStatusTable(com.appnew.android.table.HomeApiStatusTable).\n Expected:\n" + tableInfo13 + "\n Found:\n" + tableInfo14);
                }
                HashMap map8 = new HashMap(32);
                map8.put("autoid", new TableInfo.Column("autoid", "INTEGER", true, 1, null, 1));
                map8.put("userid", new TableInfo.Column("userid", "TEXT", false, 0, null, 1));
                map8.put("cat_type", new TableInfo.Column("cat_type", "TEXT", false, 0, "''", 1));
                map8.put("mainid", new TableInfo.Column("mainid", "TEXT", false, 0, null, 1));
                map8.put(Const.CATEGORY, new TableInfo.Column(Const.CATEGORY, "TEXT", false, 0, null, 1));
                map8.put("courseid", new TableInfo.Column("courseid", "TEXT", false, 0, null, 1));
                map8.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, 1));
                map8.put("cover_image", new TableInfo.Column("cover_image", "TEXT", false, 0, null, 1));
                map8.put("desc_header_image", new TableInfo.Column("desc_header_image", "TEXT", false, 0, null, 1));
                map8.put("mrp", new TableInfo.Column("mrp", "TEXT", false, 0, null, 1));
                map8.put("payment_mode", new TableInfo.Column("payment_mode", "TEXT", false, 0, null, 1));
                map8.put("course_sp", new TableInfo.Column("course_sp", "TEXT", false, 0, null, 1));
                map8.put(Const.SUBJECT_ID, new TableInfo.Column(Const.SUBJECT_ID, "TEXT", false, 0, null, 1));
                map8.put("avg_rating", new TableInfo.Column("avg_rating", "TEXT", false, 0, null, 1));
                map8.put("user_rated", new TableInfo.Column("user_rated", "TEXT", false, 0, null, 1));
                map8.put("is_purchased", new TableInfo.Column("is_purchased", "TEXT", false, 0, null, 1));
                map8.put("content_type", new TableInfo.Column("content_type", "TEXT", false, 0, null, 1));
                map8.put("lang_id", new TableInfo.Column("lang_id", "TEXT", false, 0, null, 1));
                map8.put("extra_json", new TableInfo.Column("extra_json", "TEXT", false, 0, null, 1));
                map8.put("validity", new TableInfo.Column("validity", "TEXT", false, 0, null, 1));
                map8.put("type_id", new TableInfo.Column("type_id", "TEXT", false, 0, null, 1));
                map8.put("combo_course_ids", new TableInfo.Column("combo_course_ids", "TEXT", false, 0, null, 1));
                map8.put("viewType", new TableInfo.Column("viewType", "TEXT", false, 0, null, 1));
                map8.put("valid_to", new TableInfo.Column("valid_to", "TEXT", false, 0, null, 1));
                map8.put("hide_validity", new TableInfo.Column("hide_validity", "TEXT", false, 0, "''", 1));
                map8.put("discount", new TableInfo.Column("discount", "TEXT", false, 0, "''", 1));
                map8.put("cart_quantity", new TableInfo.Column("cart_quantity", "TEXT", false, 0, "''", 1));
                map8.put("stocks", new TableInfo.Column("stocks", "TEXT", false, 0, "''", 1));
                map8.put(Const.DELIVERY_CHARGE, new TableInfo.Column(Const.DELIVERY_CHARGE, "TEXT", false, 0, "''", 1));
                map8.put("delivery_charge_out_of_india", new TableInfo.Column("delivery_charge_out_of_india", "TEXT", false, 0, "''", 1));
                map8.put("description", new TableInfo.Column("description", "TEXT", false, 0, "''", 1));
                map8.put("book_redirection_link", new TableInfo.Column("book_redirection_link", "TEXT", false, 0, "''", 1));
                TableInfo tableInfo15 = new TableInfo("CourseDataTable", map8, new HashSet(0), new HashSet(0));
                TableInfo tableInfo16 = TableInfo.read(db, "CourseDataTable");
                if (!tableInfo15.equals(tableInfo16)) {
                    return new RoomOpenHelper.ValidationResult(false, "CourseDataTable(com.appnew.android.table.CourseDataTable).\n Expected:\n" + tableInfo15 + "\n Found:\n" + tableInfo16);
                }
                HashMap map9 = new HashMap(22);
                map9.put("autoid", new TableInfo.Column("autoid", "INTEGER", true, 1, null, 1));
                map9.put("id", new TableInfo.Column("id", "TEXT", false, 0, null, 1));
                map9.put("cat_type", new TableInfo.Column("cat_type", "TEXT", false, 0, "''", 1));
                map9.put("is_activated", new TableInfo.Column("is_activated", "TEXT", true, 0, null, 1));
                map9.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, 1));
                map9.put("isSelect", new TableInfo.Column("isSelect", "TEXT", false, 0, null, 1));
                map9.put("isExpand", new TableInfo.Column("isExpand", "TEXT", false, 0, null, 1));
                map9.put(Const.BATCH_ID, new TableInfo.Column(Const.BATCH_ID, "TEXT", false, 0, null, 1));
                map9.put("cover_image", new TableInfo.Column("cover_image", "TEXT", false, 0, null, 1));
                map9.put("desc_header_image", new TableInfo.Column("desc_header_image", "TEXT", false, 0, null, 1));
                map9.put("expiry_date", new TableInfo.Column("expiry_date", "TEXT", false, 0, null, 1));
                map9.put("purchase_date", new TableInfo.Column("purchase_date", "TEXT", false, 0, null, 1));
                map9.put("mrp", new TableInfo.Column("mrp", "TEXT", false, 0, null, 1));
                map9.put("txn_id", new TableInfo.Column("txn_id", "TEXT", false, 0, null, 1));
                map9.put("lastread", new TableInfo.Column("lastread", "TEXT", false, 0, null, 1));
                map9.put("userid", new TableInfo.Column("userid", "TEXT", false, 0, null, 1));
                map9.put("batchtype", new TableInfo.Column("batchtype", "TEXT", false, 0, null, 1));
                map9.put("delete", new TableInfo.Column("delete", "INTEGER", true, 0, null, 1));
                map9.put("content_type", new TableInfo.Column("content_type", "TEXT", false, 0, null, 1));
                map9.put("prices", new TableInfo.Column("prices", "TEXT", false, 0, null, 1));
                map9.put("combo_course_ids", new TableInfo.Column("combo_course_ids", "TEXT", true, 0, null, 1));
                map9.put("viewType", new TableInfo.Column("viewType", "TEXT", false, 0, null, 1));
                TableInfo tableInfo17 = new TableInfo("mycoursetable", map9, new HashSet(0), new HashSet(0));
                TableInfo tableInfo18 = TableInfo.read(db, "mycoursetable");
                if (!tableInfo17.equals(tableInfo18)) {
                    return new RoomOpenHelper.ValidationResult(false, "mycoursetable(com.appnew.android.table.MycourseTable).\n Expected:\n" + tableInfo17 + "\n Found:\n" + tableInfo18);
                }
                HashMap map10 = new HashMap(52);
                map10.put("autoid", new TableInfo.Column("autoid", "INTEGER", true, 1, null, 1));
                map10.put("coursetitle", new TableInfo.Column("coursetitle", "TEXT", false, 0, null, 1));
                map10.put("couseid", new TableInfo.Column("couseid", "TEXT", false, 0, null, 1));
                map10.put("display_locked", new TableInfo.Column("display_locked", "TEXT", false, 0, null, 1));
                map10.put("tax", new TableInfo.Column("tax", "TEXT", false, 0, null, 1));
                map10.put("is_purchased", new TableInfo.Column("is_purchased", "TEXT", false, 0, null, 1));
                map10.put("is_gst", new TableInfo.Column("is_gst", "TEXT", false, 0, null, 1));
                map10.put("course_code", new TableInfo.Column("course_code", "TEXT", false, 0, null, 1));
                map10.put("content_type", new TableInfo.Column("content_type", "TEXT", false, 0, null, 1));
                map10.put("validity", new TableInfo.Column("validity", "TEXT", false, 0, null, 1));
                map10.put("is_activated", new TableInfo.Column("is_activated", "TEXT", false, 0, null, 1));
                map10.put("token_activation", new TableInfo.Column("token_activation", "TEXT", false, 0, null, 1));
                map10.put("course_sp", new TableInfo.Column("course_sp", "TEXT", false, 0, null, 1));
                map10.put("userid", new TableInfo.Column("userid", "TEXT", false, 0, null, 1));
                map10.put("tileid", new TableInfo.Column("tileid", "TEXT", false, 0, null, 1));
                map10.put("tiletitile", new TableInfo.Column("tiletitile", "TEXT", false, 0, null, 1));
                map10.put("tilerevert", new TableInfo.Column("tilerevert", "TEXT", false, 0, null, 1));
                map10.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, 1));
                map10.put("tilemeta", new TableInfo.Column("tilemeta", "TEXT", false, 0, null, 1));
                map10.put("skip_payment", new TableInfo.Column("skip_payment", "TEXT", false, 0, null, 1));
                map10.put("cat_type", new TableInfo.Column("cat_type", "TEXT", false, 0, null, 1));
                map10.put(Const.DELIVERY_CHARGE, new TableInfo.Column(Const.DELIVERY_CHARGE, "TEXT", false, 0, null, 1));
                map10.put("txnid", new TableInfo.Column("txnid", "TEXT", false, 0, null, 1));
                map10.put("instalment", new TableInfo.Column("instalment", "TEXT", false, 0, null, 1));
                map10.put("mrp", new TableInfo.Column("mrp", "TEXT", false, 0, null, 1));
                map10.put("view_type", new TableInfo.Column("view_type", "TEXT", false, 0, null, 1));
                map10.put("author_title", new TableInfo.Column("author_title", "TEXT", false, 0, null, 1));
                map10.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, 1));
                map10.put(Const.IS_COMBO, new TableInfo.Column(Const.IS_COMBO, "TEXT", false, 0, null, 1));
                map10.put("desc_header_image", new TableInfo.Column("desc_header_image", "TEXT", false, 0, null, 1));
                map10.put("is_trial", new TableInfo.Column("is_trial", "TEXT", false, 0, null, 1));
                map10.put("last_paid_txn_id", new TableInfo.Column("last_paid_txn_id", "TEXT", false, 0, null, 1));
                map10.put(Const.IS_RATING, new TableInfo.Column(Const.IS_RATING, "TEXT", false, 0, null, 1));
                map10.put("payment_mode", new TableInfo.Column("payment_mode", "TEXT", false, 0, null, 1));
                map10.put("event_location", new TableInfo.Column("event_location", "TEXT", false, 0, null, 1));
                map10.put("location", new TableInfo.Column("location", "TEXT", false, 0, null, 1));
                map10.put(FirebaseAnalytics.Param.START_DATE, new TableInfo.Column(FirebaseAnalytics.Param.START_DATE, "TEXT", false, 0, null, 1));
                map10.put(FirebaseAnalytics.Param.END_DATE, new TableInfo.Column(FirebaseAnalytics.Param.END_DATE, "TEXT", false, 0, null, 1));
                map10.put("extra_json", new TableInfo.Column("extra_json", "TEXT", false, 0, null, 1));
                map10.put("cover_image", new TableInfo.Column("cover_image", "TEXT", false, 0, null, 1));
                map10.put("subscription_all_data", new TableInfo.Column("subscription_all_data", "TEXT", false, 0, null, 1));
                map10.put("hide_validity", new TableInfo.Column("hide_validity", "TEXT", false, 0, "''", 1));
                map10.put("avg_rating", new TableInfo.Column("avg_rating", "TEXT", false, 0, null, 1));
                map10.put("user_rated", new TableInfo.Column("user_rated", "TEXT", false, 0, null, 1));
                map10.put("stocks", new TableInfo.Column("stocks", "TEXT", false, 0, null, 1));
                map10.put("external_coupon_off", new TableInfo.Column("external_coupon_off", "TEXT", false, 0, null, 1));
                map10.put(Const.TRANSACTION_STATUS, new TableInfo.Column(Const.TRANSACTION_STATUS, "TEXT", false, 0, null, 1));
                map10.put("combo_has_book", new TableInfo.Column("combo_has_book", "TEXT", false, 0, null, 1));
                map10.put("tax_rate", new TableInfo.Column("tax_rate", "TEXT", false, 0, null, 1));
                map10.put("set_as_demo", new TableInfo.Column("set_as_demo", "TEXT", false, 0, null, 1));
                map10.put("thumbnail", new TableInfo.Column("thumbnail", "TEXT", false, 0, null, 1));
                map10.put("book_redirection_link", new TableInfo.Column("book_redirection_link", "TEXT", false, 0, null, 1));
                TableInfo tableInfo19 = new TableInfo("CourseDetailTable", map10, new HashSet(0), new HashSet(0));
                TableInfo tableInfo20 = TableInfo.read(db, "CourseDetailTable");
                if (!tableInfo19.equals(tableInfo20)) {
                    return new RoomOpenHelper.ValidationResult(false, "CourseDetailTable(com.appnew.android.table.CourseDetailTable).\n Expected:\n" + tableInfo19 + "\n Found:\n" + tableInfo20);
                }
                HashMap map11 = new HashMap(8);
                map11.put("autoid", new TableInfo.Column("autoid", "INTEGER", true, 1, null, 1));
                map11.put("concept_id", new TableInfo.Column("concept_id", "TEXT", false, 0, null, 1));
                map11.put("tile_id", new TableInfo.Column("tile_id", "TEXT", false, 0, null, 1));
                map11.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0, null, 1));
                map11.put("course_id", new TableInfo.Column("course_id", "TEXT", false, 0, null, 1));
                map11.put("highight", new TableInfo.Column("highight", "TEXT", false, 0, null, 1));
                map11.put("html", new TableInfo.Column("html", "TEXT", false, 0, null, 1));
                map11.put("valid_to", new TableInfo.Column("valid_to", "TEXT", false, 0, null, 1));
                TableInfo tableInfo21 = new TableInfo("HtmlTbale", map11, new HashSet(0), new HashSet(0));
                TableInfo tableInfo22 = TableInfo.read(db, "HtmlTbale");
                if (!tableInfo21.equals(tableInfo22)) {
                    return new RoomOpenHelper.ValidationResult(false, "HtmlTbale(com.appnew.android.table.HtmlTbale).\n Expected:\n" + tableInfo21 + "\n Found:\n" + tableInfo22);
                }
                HashMap map12 = new HashMap(9);
                map12.put("autoid", new TableInfo.Column("autoid", "INTEGER", true, 1, null, 1));
                map12.put("youtubeid", new TableInfo.Column("youtubeid", "TEXT", false, 0, null, 1));
                map12.put("youtubetime", new TableInfo.Column("youtubetime", "INTEGER", true, 0, null, 1));
                map12.put("userid", new TableInfo.Column("userid", "TEXT", false, 0, null, 1));
                map12.put("videoid", new TableInfo.Column("videoid", "TEXT", false, 0, null, 1));
                map12.put("isaudio", new TableInfo.Column("isaudio", "TEXT", false, 0, null, 1));
                map12.put("videoname", new TableInfo.Column("videoname", "TEXT", false, 0, null, 1));
                map12.put("valid_to", new TableInfo.Column("valid_to", "TEXT", false, 0, null, 1));
                map12.put("course_id", new TableInfo.Column("course_id", "TEXT", false, 0, null, 1));
                TableInfo tableInfo23 = new TableInfo("YoutubePlayerTable", map12, new HashSet(0), new HashSet(0));
                TableInfo tableInfo24 = TableInfo.read(db, "YoutubePlayerTable");
                if (!tableInfo23.equals(tableInfo24)) {
                    return new RoomOpenHelper.ValidationResult(false, "YoutubePlayerTable(com.appnew.android.table.YoutubePlayerTable).\n Expected:\n" + tableInfo23 + "\n Found:\n" + tableInfo24);
                }
                HashMap map13 = new HashMap(8);
                map13.put("autoid", new TableInfo.Column("autoid", "INTEGER", true, 1, null, 1));
                map13.put(Const.VIDEO_ID, new TableInfo.Column(Const.VIDEO_ID, "TEXT", false, 0, null, 1));
                map13.put("video_name", new TableInfo.Column("video_name", "TEXT", false, 0, null, 1));
                map13.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0, null, 1));
                map13.put("video_currentpos", new TableInfo.Column("video_currentpos", "INTEGER", false, 0, null, 1));
                map13.put("jw_url", new TableInfo.Column("jw_url", "TEXT", false, 0, null, 1));
                map13.put("course_id", new TableInfo.Column("course_id", "TEXT", false, 0, null, 1));
                map13.put("valid_to", new TableInfo.Column("valid_to", "TEXT", false, 0, null, 1));
                TableInfo tableInfo25 = new TableInfo("VideoTable", map13, new HashSet(0), new HashSet(0));
                TableInfo tableInfo26 = TableInfo.read(db, "VideoTable");
                if (!tableInfo25.equals(tableInfo26)) {
                    return new RoomOpenHelper.ValidationResult(false, "VideoTable(com.appnew.android.table.VideoTable).\n Expected:\n" + tableInfo25 + "\n Found:\n" + tableInfo26);
                }
                HashMap map14 = new HashMap(18);
                map14.put("autoid", new TableInfo.Column("autoid", "INTEGER", true, 1, null, 1));
                map14.put(Const.VIDEO_ID, new TableInfo.Column(Const.VIDEO_ID, "TEXT", false, 0, null, 1));
                map14.put("video_name", new TableInfo.Column("video_name", "TEXT", false, 0, null, 1));
                map14.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0, null, 1));
                map14.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, 1));
                map14.put("pdf_name", new TableInfo.Column("pdf_name", "TEXT", false, 0, null, 1));
                map14.put("pdf_download", new TableInfo.Column("pdf_download", "TEXT", false, 0, null, 1));
                map14.put("youtube_url", new TableInfo.Column("youtube_url", "TEXT", false, 0, null, 1));
                map14.put("pdf_url", new TableInfo.Column("pdf_url", "TEXT", false, 0, null, 1));
                map14.put("current_time", new TableInfo.Column("current_time", "TEXT", false, 0, null, 1));
                map14.put("course_id", new TableInfo.Column("course_id", "TEXT", false, 0, null, 1));
                map14.put("valid_to", new TableInfo.Column("valid_to", "TEXT", false, 0, null, 1));
                map14.put("coursename", new TableInfo.Column("coursename", "TEXT", false, 0, null, 1));
                map14.put("tileid", new TableInfo.Column("tileid", "TEXT", false, 0, null, 1));
                map14.put("testid", new TableInfo.Column("testid", "TEXT", false, 0, null, 1));
                map14.put("testname", new TableInfo.Column("testname", "TEXT", false, 0, null, 1));
                map14.put("topicname", new TableInfo.Column("topicname", "TEXT", false, 0, null, 1));
                map14.put("url", new TableInfo.Column("url", "TEXT", false, 0, null, 1));
                TableInfo tableInfo27 = new TableInfo("UserHistroyTable", map14, new HashSet(0), new HashSet(0));
                TableInfo tableInfo28 = TableInfo.read(db, "UserHistroyTable");
                if (!tableInfo27.equals(tableInfo28)) {
                    return new RoomOpenHelper.ValidationResult(false, "UserHistroyTable(com.appnew.android.table.UserHistroyTable).\n Expected:\n" + tableInfo27 + "\n Found:\n" + tableInfo28);
                }
                HashMap map15 = new HashMap(9);
                map15.put("autoid", new TableInfo.Column("autoid", "INTEGER", true, 1, null, 1));
                map15.put(Const.VIDEO_ID, new TableInfo.Column(Const.VIDEO_ID, "TEXT", false, 0, null, 1));
                map15.put("video_name", new TableInfo.Column("video_name", "TEXT", false, 0, null, 1));
                map15.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0, null, 1));
                map15.put("audio_url", new TableInfo.Column("audio_url", "TEXT", false, 0, null, 1));
                map15.put("audio_currentpos", new TableInfo.Column("audio_currentpos", "INTEGER", false, 0, null, 1));
                map15.put("jw_url", new TableInfo.Column("jw_url", "TEXT", false, 0, null, 1));
                map15.put("valid_to", new TableInfo.Column("valid_to", "TEXT", false, 0, null, 1));
                map15.put("course_id", new TableInfo.Column("course_id", "TEXT", false, 0, null, 1));
                TableInfo tableInfo29 = new TableInfo("AudioTable", map15, new HashSet(0), new HashSet(0));
                TableInfo tableInfo30 = TableInfo.read(db, "AudioTable");
                if (!tableInfo29.equals(tableInfo30)) {
                    return new RoomOpenHelper.ValidationResult(false, "AudioTable(com.appnew.android.table.AudioTable).\n Expected:\n" + tableInfo29 + "\n Found:\n" + tableInfo30);
                }
                HashMap map16 = new HashMap(32);
                map16.put("autoid", new TableInfo.Column("autoid", "INTEGER", true, 1, null, 1));
                map16.put(Const.VIDEO_ID, new TableInfo.Column(Const.VIDEO_ID, "TEXT", false, 0, null, 1));
                map16.put(Const.VIDEO_TYPE, new TableInfo.Column(Const.VIDEO_TYPE, "TEXT", false, 0, null, 1));
                map16.put("vdc_id", new TableInfo.Column("vdc_id", "TEXT", false, 0, null, 1));
                map16.put("video_name", new TableInfo.Column("video_name", "TEXT", false, 0, null, 1));
                map16.put("originalFileLengthString", new TableInfo.Column("originalFileLengthString", "TEXT", false, 0, null, 1));
                map16.put("videotime", new TableInfo.Column("videotime", "TEXT", false, 0, null, 1));
                map16.put("link", new TableInfo.Column("link", "TEXT", false, 0, null, 1));
                map16.put("total", new TableInfo.Column("total", "INTEGER", false, 0, null, 1));
                map16.put("lengthInMb", new TableInfo.Column("lengthInMb", "TEXT", false, 0, null, 1));
                map16.put("percentage", new TableInfo.Column("percentage", "INTEGER", true, 0, null, 1));
                map16.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0, null, 1));
                map16.put("course_id", new TableInfo.Column("course_id", "TEXT", false, 0, null, 1));
                map16.put("valid_to", new TableInfo.Column("valid_to", "INTEGER", true, 0, null, 1));
                map16.put(Const.remaining_time, new TableInfo.Column(Const.remaining_time, "TEXT", true, 0, null, 1));
                map16.put("tile_id", new TableInfo.Column("tile_id", "TEXT", true, 0, null, 1));
                map16.put("multiplayer", new TableInfo.Column("multiplayer", "TEXT", true, 0, null, 1));
                map16.put("is_limited", new TableInfo.Column("is_limited", "TEXT", true, 0, null, 1));
                map16.put("video_length", new TableInfo.Column("video_length", "TEXT", true, 0, null, 1));
                map16.put("with_validity", new TableInfo.Column("with_validity", "TEXT", false, 0, null, 1));
                map16.put("with_validity_message", new TableInfo.Column("with_validity_message", "TEXT", false, 0, null, 1));
                map16.put("validity_end_date", new TableInfo.Column("validity_end_date", "TEXT", false, 0, null, 1));
                map16.put("validity_start_date", new TableInfo.Column("validity_start_date", "TEXT", false, 0, null, 1));
                map16.put(Const.POSITION, new TableInfo.Column(Const.POSITION, "INTEGER", true, 0, null, 1));
                map16.put("mp4_download_url", new TableInfo.Column("mp4_download_url", "TEXT", false, 0, null, 1));
                map16.put("video_status", new TableInfo.Column("video_status", "TEXT", false, 0, null, 1));
                map16.put("thumbnail_url", new TableInfo.Column("thumbnail_url", "TEXT", false, 0, null, 1));
                map16.put("is_complete", new TableInfo.Column("is_complete", "TEXT", false, 0, null, 1));
                map16.put("videoCurrentPosition", new TableInfo.Column("videoCurrentPosition", "INTEGER", false, 0, null, 1));
                map16.put("jw_url", new TableInfo.Column("jw_url", "TEXT", false, 0, null, 1));
                map16.put("is_selected", new TableInfo.Column("is_selected", "TEXT", false, 0, null, 1));
                map16.put("video_history", new TableInfo.Column("video_history", "TEXT", false, 0, null, 1));
                TableInfo tableInfo31 = new TableInfo("VideoDownload", map16, new HashSet(0), new HashSet(0));
                TableInfo tableInfo32 = TableInfo.read(db, "VideoDownload");
                if (!tableInfo31.equals(tableInfo32)) {
                    return new RoomOpenHelper.ValidationResult(false, "VideoDownload(com.appnew.android.table.VideosDownload).\n Expected:\n" + tableInfo31 + "\n Found:\n" + tableInfo32);
                }
                HashMap map17 = new HashMap(11);
                map17.put("auto_id", new TableInfo.Column("auto_id", "INTEGER", true, 1, null, 1));
                map17.put("id", new TableInfo.Column("id", "TEXT", false, 0, null, 1));
                map17.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, 1));
                map17.put(Const.PARENT_ID, new TableInfo.Column(Const.PARENT_ID, "TEXT", false, 0, null, 1));
                map17.put("master_type", new TableInfo.Column("master_type", "TEXT", false, 0, null, 1));
                map17.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0, null, 1));
                map17.put("app_hide", new TableInfo.Column("app_hide", "TEXT", false, 0, null, 1));
                map17.put("font_color", new TableInfo.Column("font_color", "TEXT", false, 0, null, 1));
                map17.put("bg_color", new TableInfo.Column("bg_color", "TEXT", false, 0, null, 1));
                map17.put("image", new TableInfo.Column("image", "TEXT", true, 0, null, 1));
                map17.put("filters", new TableInfo.Column("filters", "TEXT", false, 0, null, 1));
                TableInfo tableInfo33 = new TableInfo("MasteAllCatTable", map17, new HashSet(0), new HashSet(0));
                TableInfo tableInfo34 = TableInfo.read(db, "MasteAllCatTable");
                if (!tableInfo33.equals(tableInfo34)) {
                    return new RoomOpenHelper.ValidationResult(false, "MasteAllCatTable(com.appnew.android.table.MasteAllCatTable).\n Expected:\n" + tableInfo33 + "\n Found:\n" + tableInfo34);
                }
                HashMap map18 = new HashMap(17);
                map18.put("display_type", new TableInfo.Column("display_type", "TEXT", false, 0, null, 1));
                map18.put("auto_id", new TableInfo.Column("auto_id", "INTEGER", true, 1, null, 1));
                map18.put("id", new TableInfo.Column("id", "TEXT", false, 0, null, 1));
                map18.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, 1));
                map18.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0, null, 1));
                map18.put("icon", new TableInfo.Column("icon", "TEXT", false, 0, null, 1));
                map18.put("font_color", new TableInfo.Column("font_color", "TEXT", false, 0, null, 1));
                map18.put("bg_color", new TableInfo.Column("bg_color", "TEXT", false, 0, null, 1));
                map18.put("cat_type", new TableInfo.Column("cat_type", "TEXT", false, 0, null, 1));
                map18.put(Const.MASTER_CATEGORY_ID, new TableInfo.Column(Const.MASTER_CATEGORY_ID, "TEXT", false, 0, null, 1));
                map18.put("course_id", new TableInfo.Column("course_id", "TEXT", false, 0, null, 1));
                map18.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, 1));
                map18.put("sec_color", new TableInfo.Column("sec_color", "TEXT", false, 0, null, 1));
                map18.put("sec_bg_color", new TableInfo.Column("sec_bg_color", "TEXT", false, 0, null, 1));
                map18.put("view_type", new TableInfo.Column("view_type", "TEXT", false, 0, null, 1));
                map18.put("weblink_url", new TableInfo.Column("weblink_url", "TEXT", false, 0, null, 1));
                map18.put("sub_cat_id", new TableInfo.Column("sub_cat_id", "TEXT", false, 0, null, 1));
                TableInfo tableInfo35 = new TableInfo("CourseTypeMasterTable", map18, new HashSet(0), new HashSet(0));
                TableInfo tableInfo36 = TableInfo.read(db, "CourseTypeMasterTable");
                if (!tableInfo35.equals(tableInfo36)) {
                    return new RoomOpenHelper.ValidationResult(false, "CourseTypeMasterTable(com.appnew.android.table.CourseTypeMasterTable).\n Expected:\n" + tableInfo35 + "\n Found:\n" + tableInfo36);
                }
                HashMap map19 = new HashMap(6);
                map19.put("auto_id", new TableInfo.Column("auto_id", "INTEGER", true, 1, null, 1));
                map19.put("id", new TableInfo.Column("id", "TEXT", false, 0, null, 1));
                map19.put("cat", new TableInfo.Column("cat", "TEXT", false, 0, null, 1));
                map19.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0, null, 1));
                map19.put("app_hide", new TableInfo.Column("app_hide", "TEXT", false, 0, null, 1));
                map19.put("isSelected", new TableInfo.Column("isSelected", "INTEGER", true, 0, "false", 1));
                TableInfo tableInfo37 = new TableInfo("MasterCat", map19, new HashSet(0), new HashSet(0));
                TableInfo tableInfo38 = TableInfo.read(db, "MasterCat");
                if (!tableInfo37.equals(tableInfo38)) {
                    return new RoomOpenHelper.ValidationResult(false, "MasterCat(com.appnew.android.table.MasterCat).\n Expected:\n" + tableInfo37 + "\n Found:\n" + tableInfo38);
                }
                HashMap map20 = new HashMap(17);
                map20.put("auto_id", new TableInfo.Column("auto_id", "INTEGER", true, 1, null, 1));
                map20.put("id", new TableInfo.Column("id", "TEXT", false, 0, null, 1));
                map20.put("extra", new TableInfo.Column("extra", "TEXT", true, 0, null, 1));
                map20.put("banner_title", new TableInfo.Column("banner_title", "TEXT", false, 0, null, 1));
                map20.put("image_type", new TableInfo.Column("image_type", "TEXT", false, 0, null, 1));
                map20.put("banner_url", new TableInfo.Column("banner_url", "TEXT", false, 0, null, 1));
                map20.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0, null, 1));
                map20.put("master_cat", new TableInfo.Column("master_cat", "TEXT", false, 0, null, 1));
                map20.put(Const.COURSE_TYPE, new TableInfo.Column(Const.COURSE_TYPE, "TEXT", false, 0, null, 1));
                map20.put("link", new TableInfo.Column("link", "TEXT", true, 0, null, 1));
                map20.put("course_id", new TableInfo.Column("course_id", "TEXT", true, 0, null, 1));
                map20.put(Const.PARENT_ID, new TableInfo.Column(Const.PARENT_ID, "TEXT", false, 0, null, 1));
                map20.put("banner_type", new TableInfo.Column("banner_type", "TEXT", true, 0, null, 1));
                map20.put("banner_location", new TableInfo.Column("banner_location", "TEXT", true, 0, null, 1));
                map20.put(Const.LINK_TYPE, new TableInfo.Column(Const.LINK_TYPE, "TEXT", false, 0, null, 1));
                map20.put("center_id", new TableInfo.Column("center_id", "TEXT", false, 0, null, 1));
                map20.put(Const.IS_COMBO, new TableInfo.Column(Const.IS_COMBO, "INTEGER", true, 0, "0", 1));
                TableInfo tableInfo39 = new TableInfo("BannerListTable", map20, new HashSet(0), new HashSet(0));
                TableInfo tableInfo40 = TableInfo.read(db, "BannerListTable");
                if (!tableInfo39.equals(tableInfo40)) {
                    return new RoomOpenHelper.ValidationResult(false, "BannerListTable(com.appnew.android.table.BannerListTable).\n Expected:\n" + tableInfo39 + "\n Found:\n" + tableInfo40);
                }
                HashMap map21 = new HashMap(36);
                map21.put(StoreProvider.StoreData.CREATED_DATE, new TableInfo.Column(StoreProvider.StoreData.CREATED_DATE, "TEXT", true, 0, null, 1));
                map21.put("page", new TableInfo.Column("page", "TEXT", true, 0, null, 1));
                map21.put("masterCat", new TableInfo.Column("masterCat", "TEXT", true, 0, null, 1));
                map21.put("postId", new TableInfo.Column("postId", "INTEGER", true, 1, null, 1));
                map21.put("id", new TableInfo.Column("id", "TEXT", true, 0, null, 1));
                map21.put("json", new TableInfo.Column("json", "TEXT", true, 0, null, 1));
                map21.put("meta_url", new TableInfo.Column("meta_url", "TEXT", true, 0, null, 1));
                map21.put(Const.LINK_TYPE, new TableInfo.Column(Const.LINK_TYPE, "TEXT", true, 0, "''", 1));
                map21.put("thumbnail", new TableInfo.Column("thumbnail", "TEXT", true, 0, null, 1));
                map21.put("url", new TableInfo.Column("url", "TEXT", true, 0, null, 1));
                map21.put(StoreProvider.StoreData.MODIFIED_DATE, new TableInfo.Column(StoreProvider.StoreData.MODIFIED_DATE, "TEXT", true, 0, null, 1));
                map21.put("my_like", new TableInfo.Column("my_like", "TEXT", true, 0, null, 1));
                map21.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                map21.put(Const.POST_TYPE, new TableInfo.Column(Const.POST_TYPE, "TEXT", true, 0, null, 1));
                map21.put(Const.PROFILE_PICTURE, new TableInfo.Column(Const.PROFILE_PICTURE, "TEXT", true, 0, null, 1));
                map21.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, 1));
                map21.put("sub_cat_id", new TableInfo.Column("sub_cat_id", "TEXT", true, 0, null, 1));
                map21.put("text", new TableInfo.Column("text", "TEXT", true, 0, null, 1));
                map21.put("total_comments", new TableInfo.Column("total_comments", "TEXT", true, 0, null, 1));
                map21.put("total_likes", new TableInfo.Column("total_likes", "TEXT", true, 0, null, 1));
                map21.put("user_id", new TableInfo.Column("user_id", "TEXT", true, 0, null, 1));
                map21.put("newCourseData", new TableInfo.Column("newCourseData", "TEXT", true, 0, null, 1));
                map21.put("livetest", new TableInfo.Column("livetest", "TEXT", true, 0, null, 1));
                map21.put("liveclass", new TableInfo.Column("liveclass", "TEXT", true, 0, null, 1));
                map21.put("testResult", new TableInfo.Column("testResult", "TEXT", true, 0, null, 1));
                map21.put("bannerlist", new TableInfo.Column("bannerlist", "TEXT", true, 0, null, 1));
                map21.put("liveClassStatus", new TableInfo.Column("liveClassStatus", "TEXT", true, 0, null, 1));
                map21.put("liveTestStatus", new TableInfo.Column("liveTestStatus", "TEXT", true, 0, null, 1));
                map21.put("iscommentenable", new TableInfo.Column("iscommentenable", "TEXT", true, 0, null, 1));
                map21.put("sectionposiiton", new TableInfo.Column("sectionposiiton", "TEXT", true, 0, null, 1));
                map21.put(Constants.KEY_LIMIT, new TableInfo.Column(Constants.KEY_LIMIT, "TEXT", true, 0, null, 1));
                map21.put("my_pinned", new TableInfo.Column("my_pinned", "TEXT", true, 0, null, 1));
                map21.put("parentId", new TableInfo.Column("parentId", "TEXT", true, 0, null, 1));
                map21.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, 1));
                map21.put("image_type", new TableInfo.Column("image_type", "TEXT", false, 0, null, 1));
                map21.put("schedule_date", new TableInfo.Column("schedule_date", "TEXT", false, 0, null, 1));
                TableInfo tableInfo41 = new TableInfo("PostDataTable", map21, new HashSet(0), new HashSet(0));
                TableInfo tableInfo42 = TableInfo.read(db, "PostDataTable");
                if (!tableInfo41.equals(tableInfo42)) {
                    return new RoomOpenHelper.ValidationResult(false, "PostDataTable(com.appnew.android.table.PostDataTable).\n Expected:\n" + tableInfo41 + "\n Found:\n" + tableInfo42);
                }
                HashMap map22 = new HashMap(7);
                map22.put("auto_id", new TableInfo.Column("auto_id", "INTEGER", true, 1, null, 1));
                map22.put("id", new TableInfo.Column("id", "TEXT", false, 0, null, 1));
                map22.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0, null, 1));
                map22.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, 1));
                map22.put("file_url", new TableInfo.Column("file_url", "TEXT", false, 0, null, 1));
                map22.put("thumbnail_url", new TableInfo.Column("thumbnail_url", "TEXT", false, 0, null, 1));
                map22.put("banner_url", new TableInfo.Column("banner_url", "TEXT", false, 0, null, 1));
                TableInfo tableInfo43 = new TableInfo("TopperReviewTable", map22, new HashSet(0), new HashSet(0));
                TableInfo tableInfo44 = TableInfo.read(db, "TopperReviewTable");
                if (!tableInfo43.equals(tableInfo44)) {
                    return new RoomOpenHelper.ValidationResult(false, "TopperReviewTable(com.appnew.android.table.TopperReviewTable).\n Expected:\n" + tableInfo43 + "\n Found:\n" + tableInfo44);
                }
                HashMap map23 = new HashMap(6);
                map23.put("auto_id", new TableInfo.Column("auto_id", "INTEGER", true, 1, null, 1));
                map23.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, 1));
                map23.put("icon", new TableInfo.Column("icon", "TEXT", false, 0, null, 1));
                map23.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, 1));
                map23.put(Const.BOTTOM_URL, new TableInfo.Column(Const.BOTTOM_URL, "TEXT", false, 0, null, 1));
                map23.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0, null, 1));
                TableInfo tableInfo45 = new TableInfo("BottomMenuTable", map23, new HashSet(0), new HashSet(0));
                TableInfo tableInfo46 = TableInfo.read(db, "BottomMenuTable");
                if (!tableInfo45.equals(tableInfo46)) {
                    return new RoomOpenHelper.ValidationResult(false, "BottomMenuTable(com.appnew.android.table.BottomMenuTable).\n Expected:\n" + tableInfo45 + "\n Found:\n" + tableInfo46);
                }
                HashMap map24 = new HashMap(44);
                map24.put("auto_id", new TableInfo.Column("auto_id", "INTEGER", true, 1, null, 1));
                map24.put("id", new TableInfo.Column("id", "TEXT", false, 0, null, 1));
                map24.put("txn_id", new TableInfo.Column("txn_id", "TEXT", false, 0, null, 1));
                map24.put("viewType", new TableInfo.Column("viewType", "TEXT", false, 0, null, 1));
                map24.put("holderType", new TableInfo.Column("holderType", "TEXT", false, 0, null, 1));
                map24.put("maintenanceText", new TableInfo.Column("maintenanceText", "TEXT", false, 0, null, 1));
                map24.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, 1));
                map24.put("segment_information", new TableInfo.Column("segment_information", "TEXT", false, 0, null, 1));
                map24.put("courseAttribute", new TableInfo.Column("courseAttribute", "TEXT", false, 0, null, 1));
                map24.put("cover_image", new TableInfo.Column("cover_image", "TEXT", false, 0, null, 1));
                map24.put("descHeaderImage", new TableInfo.Column("descHeaderImage", "TEXT", false, 0, null, 1));
                map24.put("mrp", new TableInfo.Column("mrp", "TEXT", false, 0, null, 1));
                map24.put("courseSp", new TableInfo.Column("courseSp", "TEXT", false, 0, null, 1));
                map24.put("colorCode", new TableInfo.Column("colorCode", "TEXT", false, 0, null, 1));
                map24.put("validity", new TableInfo.Column("validity", "TEXT", false, 0, null, 1));
                map24.put("avg_rating", new TableInfo.Column("avg_rating", "TEXT", false, 0, null, 1));
                map24.put("user_rated", new TableInfo.Column("user_rated", "TEXT", false, 0, null, 1));
                map24.put("learner", new TableInfo.Column("learner", "TEXT", false, 0, null, 1));
                map24.put("is_activated", new TableInfo.Column("is_activated", "TEXT", false, 0, null, 1));
                map24.put("is_subscription", new TableInfo.Column("is_subscription", "TEXT", false, 0, null, 1));
                map24.put("check_for_expiry", new TableInfo.Column("check_for_expiry", "TEXT", false, 0, null, 1));
                map24.put("isLive", new TableInfo.Column("isLive", "TEXT", false, 0, null, 1));
                map24.put("is_locked", new TableInfo.Column("is_locked", "TEXT", false, 0, null, 1));
                map24.put("home_screen", new TableInfo.Column("home_screen", "TEXT", false, 0, null, 1));
                map24.put("isExpand", new TableInfo.Column("isExpand", "INTEGER", true, 0, null, 1));
                map24.put("lastread", new TableInfo.Column("lastread", "TEXT", false, 0, null, 1));
                map24.put("skipUnit", new TableInfo.Column("skipUnit", "TEXT", false, 0, null, 1));
                map24.put("skipChapter", new TableInfo.Column("skipChapter", "TEXT", false, 0, null, 1));
                map24.put("combo_course_ids", new TableInfo.Column("combo_course_ids", "TEXT", false, 0, null, 1));
                map24.put(FirebaseAnalytics.Param.PAYMENT_TYPE, new TableInfo.Column(FirebaseAnalytics.Param.PAYMENT_TYPE, "TEXT", false, 0, null, 1));
                map24.put("is_postal_available", new TableInfo.Column("is_postal_available", "TEXT", false, 0, null, 1));
                map24.put("expiry_date", new TableInfo.Column("expiry_date", "TEXT", false, 0, null, 1));
                map24.put("purchase_date", new TableInfo.Column("purchase_date", "TEXT", false, 0, null, 1));
                map24.put("url", new TableInfo.Column("url", "TEXT", false, 0, null, 1));
                map24.put("prices", new TableInfo.Column("prices", "TEXT", false, 0, null, 1));
                map24.put(Const.BATCH_ID, new TableInfo.Column(Const.BATCH_ID, "TEXT", false, 0, null, 1));
                map24.put(Const.SUBJECT_ID, new TableInfo.Column(Const.SUBJECT_ID, "TEXT", false, 0, null, 1));
                map24.put("lang_id", new TableInfo.Column("lang_id", "TEXT", false, 0, null, 1));
                map24.put("type_id", new TableInfo.Column("type_id", "TEXT", false, 0, null, 1));
                map24.put("delete", new TableInfo.Column("delete", "INTEGER", true, 0, null, 1));
                map24.put("payment_mode", new TableInfo.Column("payment_mode", "TEXT", false, 0, null, 1));
                map24.put("emi_payment", new TableInfo.Column("emi_payment", "TEXT", false, 0, null, 1));
                map24.put("subscription_code", new TableInfo.Column("subscription_code", "TEXT", false, 0, null, 1));
                map24.put("isSelect", new TableInfo.Column("isSelect", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo47 = new TableInfo("ExpiredEMI", map24, new HashSet(0), new HashSet(0));
                TableInfo tableInfo48 = TableInfo.read(db, "ExpiredEMI");
                if (!tableInfo47.equals(tableInfo48)) {
                    return new RoomOpenHelper.ValidationResult(false, "ExpiredEMI(com.appnew.android.Model.ExpiredEmiModel).\n Expected:\n" + tableInfo47 + "\n Found:\n" + tableInfo48);
                }
                HashMap map25 = new HashMap(3);
                map25.put("auto_id", new TableInfo.Column("auto_id", "INTEGER", true, 1, null, 1));
                map25.put("hitCount", new TableInfo.Column("hitCount", "TEXT", false, 0, null, 1));
                map25.put("data", new TableInfo.Column("data", "TEXT", false, 0, null, 1));
                TableInfo tableInfo49 = new TableInfo("FolderEntity", map25, new HashSet(0), new HashSet(0));
                TableInfo tableInfo50 = TableInfo.read(db, "FolderEntity");
                if (!tableInfo49.equals(tableInfo50)) {
                    return new RoomOpenHelper.ValidationResult(false, "FolderEntity(com.appnew.android.table.FolderEntity).\n Expected:\n" + tableInfo49 + "\n Found:\n" + tableInfo50);
                }
                HashMap map26 = new HashMap(43);
                map26.put("auto_id", new TableInfo.Column("auto_id", "INTEGER", true, 1, null, 1));
                map26.put("id", new TableInfo.Column("id", "TEXT", false, 0, null, 1));
                map26.put("txn_id", new TableInfo.Column("txn_id", "TEXT", false, 0, null, 1));
                map26.put("viewType", new TableInfo.Column("viewType", "TEXT", false, 0, null, 1));
                map26.put("holderType", new TableInfo.Column("holderType", "TEXT", false, 0, null, 1));
                map26.put("maintenanceText", new TableInfo.Column("maintenanceText", "TEXT", false, 0, null, 1));
                map26.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, 1));
                map26.put("segment_information", new TableInfo.Column("segment_information", "TEXT", false, 0, null, 1));
                map26.put("courseAttribute", new TableInfo.Column("courseAttribute", "TEXT", false, 0, null, 1));
                map26.put("isSelect", new TableInfo.Column("isSelect", "TEXT", false, 0, null, 1));
                map26.put("isExpand", new TableInfo.Column("isExpand", "TEXT", false, 0, null, 1));
                map26.put("cover_image", new TableInfo.Column("cover_image", "TEXT", false, 0, null, 1));
                map26.put("descHeaderImage", new TableInfo.Column("descHeaderImage", "TEXT", false, 0, null, 1));
                map26.put("mrp", new TableInfo.Column("mrp", "TEXT", false, 0, null, 1));
                map26.put("courseSp", new TableInfo.Column("courseSp", "TEXT", false, 0, null, 1));
                map26.put("colorCode", new TableInfo.Column("colorCode", "TEXT", false, 0, null, 1));
                map26.put("validity", new TableInfo.Column("validity", "TEXT", false, 0, null, 1));
                map26.put("avg_rating", new TableInfo.Column("avg_rating", "TEXT", false, 0, null, 1));
                map26.put("user_rated", new TableInfo.Column("user_rated", "TEXT", false, 0, null, 1));
                map26.put("learner", new TableInfo.Column("learner", "TEXT", false, 0, null, 1));
                map26.put("is_activated", new TableInfo.Column("is_activated", "TEXT", false, 0, null, 1));
                map26.put("check_for_expiry", new TableInfo.Column("check_for_expiry", "TEXT", false, 0, null, 1));
                map26.put("isLive", new TableInfo.Column("isLive", "TEXT", false, 0, null, 1));
                map26.put("is_locked", new TableInfo.Column("is_locked", "TEXT", false, 0, null, 1));
                map26.put("home_screen", new TableInfo.Column("home_screen", "TEXT", false, 0, null, 1));
                map26.put("lastread", new TableInfo.Column("lastread", "TEXT", false, 0, null, 1));
                map26.put("skipUnit", new TableInfo.Column("skipUnit", "TEXT", false, 0, null, 1));
                map26.put("skipChapter", new TableInfo.Column("skipChapter", "TEXT", false, 0, null, 1));
                map26.put("combo_course_ids", new TableInfo.Column("combo_course_ids", "TEXT", false, 0, null, 1));
                map26.put(FirebaseAnalytics.Param.PAYMENT_TYPE, new TableInfo.Column(FirebaseAnalytics.Param.PAYMENT_TYPE, "TEXT", false, 0, null, 1));
                map26.put("is_postal_available", new TableInfo.Column("is_postal_available", "TEXT", false, 0, null, 1));
                map26.put("expiry_date", new TableInfo.Column("expiry_date", "TEXT", false, 0, null, 1));
                map26.put("purchase_date", new TableInfo.Column("purchase_date", "TEXT", false, 0, null, 1));
                map26.put("url", new TableInfo.Column("url", "TEXT", false, 0, null, 1));
                map26.put("prices", new TableInfo.Column("prices", "TEXT", false, 0, null, 1));
                map26.put(Const.BATCH_ID, new TableInfo.Column(Const.BATCH_ID, "TEXT", false, 0, null, 1));
                map26.put(Const.SUBJECT_ID, new TableInfo.Column(Const.SUBJECT_ID, "TEXT", false, 0, null, 1));
                map26.put("lang_id", new TableInfo.Column("lang_id", "TEXT", false, 0, null, 1));
                map26.put("type_id", new TableInfo.Column("type_id", "TEXT", false, 0, null, 1));
                map26.put("delete", new TableInfo.Column("delete", "INTEGER", true, 0, null, 1));
                map26.put("payment_mode", new TableInfo.Column("payment_mode", "TEXT", false, 0, null, 1));
                map26.put("emi_payment", new TableInfo.Column("emi_payment", "TEXT", false, 0, null, 1));
                map26.put("subscription_code", new TableInfo.Column("subscription_code", "TEXT", false, 0, null, 1));
                TableInfo tableInfo51 = new TableInfo("DueEmiTable", map26, new HashSet(0), new HashSet(0));
                TableInfo tableInfo52 = TableInfo.read(db, "DueEmiTable");
                if (!tableInfo51.equals(tableInfo52)) {
                    return new RoomOpenHelper.ValidationResult(false, "DueEmiTable(com.appnew.android.Model.DueEmiTable).\n Expected:\n" + tableInfo51 + "\n Found:\n" + tableInfo52);
                }
                HashMap map27 = new HashMap(6);
                map27.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                map27.put("courseName", new TableInfo.Column("courseName", "TEXT", false, 0, null, 1));
                map27.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0, null, 1));
                map27.put(Const.remaining_time, new TableInfo.Column(Const.remaining_time, "TEXT", false, 0, null, 1));
                map27.put("lastPosition", new TableInfo.Column("lastPosition", "INTEGER", true, 0, null, 1));
                map27.put("courseDescription", new TableInfo.Column("courseDescription", "TEXT", false, 0, null, 1));
                TableInfo tableInfo53 = new TableInfo("TestResumeTable", map27, new HashSet(0), new HashSet(0));
                TableInfo tableInfo54 = TableInfo.read(db, "TestResumeTable");
                if (!tableInfo53.equals(tableInfo54)) {
                    return new RoomOpenHelper.ValidationResult(false, "TestResumeTable(com.appnew.android.table.TestResumeTable).\n Expected:\n" + tableInfo53 + "\n Found:\n" + tableInfo54);
                }
                HashMap map28 = new HashMap(5);
                map28.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                map28.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0, null, 1));
                map28.put("poll_id", new TableInfo.Column("poll_id", "TEXT", false, 0, null, 1));
                map28.put("firebase_node", new TableInfo.Column("firebase_node", "TEXT", false, 0, null, 1));
                map28.put("poll_answer", new TableInfo.Column("poll_answer", "TEXT", false, 0, null, 1));
                TableInfo tableInfo55 = new TableInfo("PollDataTable", map28, new HashSet(0), new HashSet(0));
                TableInfo tableInfo56 = TableInfo.read(db, "PollDataTable");
                if (!tableInfo55.equals(tableInfo56)) {
                    return new RoomOpenHelper.ValidationResult(false, "PollDataTable(com.appnew.android.table.PollDataTable).\n Expected:\n" + tableInfo55 + "\n Found:\n" + tableInfo56);
                }
                HashMap map29 = new HashMap(10);
                map29.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                map29.put("userId", new TableInfo.Column("userId", "TEXT", false, 0, null, 1));
                map29.put("pdfName", new TableInfo.Column("pdfName", "TEXT", false, 0, null, 1));
                map29.put("pdfFile", new TableInfo.Column("pdfFile", "TEXT", false, 0, null, 1));
                map29.put("pdfId", new TableInfo.Column("pdfId", "TEXT", false, 0, null, 1));
                map29.put("pdfImage", new TableInfo.Column("pdfImage", "TEXT", false, 0, null, 1));
                map29.put("pdfPath", new TableInfo.Column("pdfPath", "TEXT", false, 0, null, 1));
                map29.put("is_selected", new TableInfo.Column("is_selected", "TEXT", false, 0, null, 1));
                map29.put("pdfUrl", new TableInfo.Column("pdfUrl", "TEXT", false, 0, null, 1));
                map29.put("isShare", new TableInfo.Column("isShare", "TEXT", false, 0, null, 1));
                TableInfo tableInfo57 = new TableInfo("PDFDataTable", map29, new HashSet(0), new HashSet(0));
                TableInfo tableInfo58 = TableInfo.read(db, "PDFDataTable");
                if (!tableInfo57.equals(tableInfo58)) {
                    return new RoomOpenHelper.ValidationResult(false, "PDFDataTable(com.appnew.android.table.PDFDataTable).\n Expected:\n" + tableInfo57 + "\n Found:\n" + tableInfo58);
                }
                HashMap map30 = new HashMap(4);
                map30.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                map30.put("center_id", new TableInfo.Column("center_id", "TEXT", false, 0, null, 1));
                map30.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0, null, 1));
                map30.put("center_name", new TableInfo.Column("center_name", "TEXT", false, 0, null, 1));
                TableInfo tableInfo59 = new TableInfo("CenterIdTable", map30, new HashSet(0), new HashSet(0));
                TableInfo tableInfo60 = TableInfo.read(db, "CenterIdTable");
                if (!tableInfo59.equals(tableInfo60)) {
                    return new RoomOpenHelper.ValidationResult(false, "CenterIdTable(com.appnew.android.table.CenterIdTable).\n Expected:\n" + tableInfo59 + "\n Found:\n" + tableInfo60);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "8f9ee4dd5d677632a57d999f0b4f2808", "4467b1e4c807b60aa62c059defc10740")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "ThemeSettings", "UserWiseCourseTable", "TestTable", "APITABLE", "PigibagTable", "LanguagesTable", "HomeApiStatusTable", "CourseDataTable", "mycoursetable", "CourseDetailTable", "HtmlTbale", "YoutubePlayerTable", "VideoTable", "UserHistroyTable", "AudioTable", "VideoDownload", "MasteAllCatTable", "CourseTypeMasterTable", "MasterCat", "BannerListTable", "PostDataTable", "TopperReviewTable", "BottomMenuTable", "ExpiredEMI", "FolderEntity", "DueEmiTable", "TestResumeTable", "PollDataTable", "PDFDataTable", "CenterIdTable");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `ThemeSettings`");
            writableDatabase.execSQL("DELETE FROM `UserWiseCourseTable`");
            writableDatabase.execSQL("DELETE FROM `TestTable`");
            writableDatabase.execSQL("DELETE FROM `APITABLE`");
            writableDatabase.execSQL("DELETE FROM `PigibagTable`");
            writableDatabase.execSQL("DELETE FROM `LanguagesTable`");
            writableDatabase.execSQL("DELETE FROM `HomeApiStatusTable`");
            writableDatabase.execSQL("DELETE FROM `CourseDataTable`");
            writableDatabase.execSQL("DELETE FROM `mycoursetable`");
            writableDatabase.execSQL("DELETE FROM `CourseDetailTable`");
            writableDatabase.execSQL("DELETE FROM `HtmlTbale`");
            writableDatabase.execSQL("DELETE FROM `YoutubePlayerTable`");
            writableDatabase.execSQL("DELETE FROM `VideoTable`");
            writableDatabase.execSQL("DELETE FROM `UserHistroyTable`");
            writableDatabase.execSQL("DELETE FROM `AudioTable`");
            writableDatabase.execSQL("DELETE FROM `VideoDownload`");
            writableDatabase.execSQL("DELETE FROM `MasteAllCatTable`");
            writableDatabase.execSQL("DELETE FROM `CourseTypeMasterTable`");
            writableDatabase.execSQL("DELETE FROM `MasterCat`");
            writableDatabase.execSQL("DELETE FROM `BannerListTable`");
            writableDatabase.execSQL("DELETE FROM `PostDataTable`");
            writableDatabase.execSQL("DELETE FROM `TopperReviewTable`");
            writableDatabase.execSQL("DELETE FROM `BottomMenuTable`");
            writableDatabase.execSQL("DELETE FROM `ExpiredEMI`");
            writableDatabase.execSQL("DELETE FROM `FolderEntity`");
            writableDatabase.execSQL("DELETE FROM `DueEmiTable`");
            writableDatabase.execSQL("DELETE FROM `TestResumeTable`");
            writableDatabase.execSQL("DELETE FROM `PollDataTable`");
            writableDatabase.execSQL("DELETE FROM `PDFDataTable`");
            writableDatabase.execSQL("DELETE FROM `CenterIdTable`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(VideoDownload.class, VideoDownload_Impl.getRequiredConverters());
        map.put(AudioDao.class, AudioDao_Impl.getRequiredConverters());
        map.put(ThemeSettingDao.class, ThemeSettingDao_Impl.getRequiredConverters());
        map.put(VideoDao.class, VideoDao_Impl.getRequiredConverters());
        map.put(Htmllink.class, Htmllink_Impl.getRequiredConverters());
        map.put(FolderDao.class, FolderDao_Impl.getRequiredConverters());
        map.put(ApiDao.class, ApiDao_Impl.getRequiredConverters());
        map.put(GetMasterAllCatDao.class, GetMasterAllCatDao_Impl.getRequiredConverters());
        map.put(CourseTypeMasterDao.class, CourseTypeMasterDao_Impl.getRequiredConverters());
        map.put(MycourseDao.class, MycourseDao_Impl.getRequiredConverters());
        map.put(MasterCatDao.class, MasterCatDao_Impl.getRequiredConverters());
        map.put(UserHistroyDao.class, UserHistroyDao_Impl.getRequiredConverters());
        map.put(YoutubePlayerDao.class, YoutubePlayerDao_Impl.getRequiredConverters());
        map.put(CourseDetailDao.class, CourseDetailDao_Impl.getRequiredConverters());
        map.put(CourseDataDao.class, CourseDataDao_Impl.getRequiredConverters());
        map.put(HomeApiStatusDao.class, HomeApiStatusDao_Impl.getRequiredConverters());
        map.put(LaunguageDao.class, LaunguageDao_Impl.getRequiredConverters());
        map.put(PigiBag.class, PigiBag_Impl.getRequiredConverters());
        map.put(TestDao.class, TestDao_Impl.getRequiredConverters());
        map.put(FeedsDao.class, FeedsDao_Impl.getRequiredConverters());
        map.put(UserWiseCourseDao.class, UserWiseCourseDao_Impl.getRequiredConverters());
        map.put(BannerListDao.class, BannerListDao_Impl.getRequiredConverters());
        map.put(BottomMenuDao.class, BottomMenuDao_Impl.getRequiredConverters());
        map.put(TopperReviewDao.class, TopperReviewDao_Impl.getRequiredConverters());
        map.put(ExpiredEmiDao.class, ExpiredEmiDao_Impl.getRequiredConverters());
        map.put(DueEmiDao.class, DueEmiDao_Impl.getRequiredConverters());
        map.put(TestResumeDao.class, TestResumeDao_Impl.getRequiredConverters());
        map.put(PDFDataDao.class, PDFDataDao_Impl.getRequiredConverters());
        map.put(PollDataDao.class, PollDataDao_Impl.getRequiredConverters());
        map.put(CenterIdDao.class, CenterIdDao_Impl.getRequiredConverters());
        return map;
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UtkashRoom_AutoMigration_16_17_Impl());
        arrayList.add(new UtkashRoom_AutoMigration_17_18_Impl());
        arrayList.add(new UtkashRoom_AutoMigration_18_19_Impl());
        arrayList.add(new UtkashRoom_AutoMigration_19_20_Impl());
        arrayList.add(new UtkashRoom_AutoMigration_20_21_Impl());
        arrayList.add(new UtkashRoom_AutoMigration_21_22_Impl());
        arrayList.add(new UtkashRoom_AutoMigration_22_23_Impl());
        arrayList.add(new UtkashRoom_AutoMigration_23_24_Impl());
        arrayList.add(new UtkashRoom_AutoMigration_24_25_Impl());
        arrayList.add(new UtkashRoom_AutoMigration_25_26_Impl());
        arrayList.add(new UtkashRoom_AutoMigration_26_27_Impl());
        arrayList.add(new UtkashRoom_AutoMigration_27_28_Impl());
        arrayList.add(new UtkashRoom_AutoMigration_28_29_Impl());
        arrayList.add(new UtkashRoom_AutoMigration_29_30_Impl());
        arrayList.add(new UtkashRoom_AutoMigration_30_31_Impl());
        arrayList.add(new UtkashRoom_AutoMigration_31_32_Impl());
        arrayList.add(new UtkashRoom_AutoMigration_32_33_Impl());
        return arrayList;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public VideoDownload getvideoDownloadao() {
        VideoDownload videoDownload;
        if (this._videoDownload != null) {
            return this._videoDownload;
        }
        synchronized (this) {
            if (this._videoDownload == null) {
                this._videoDownload = new VideoDownload_Impl(this);
            }
            videoDownload = this._videoDownload;
        }
        return videoDownload;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public AudioDao getaudiodao() {
        AudioDao audioDao;
        if (this._audioDao != null) {
            return this._audioDao;
        }
        synchronized (this) {
            if (this._audioDao == null) {
                this._audioDao = new AudioDao_Impl(this);
            }
            audioDao = this._audioDao;
        }
        return audioDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public ThemeSettingDao getthemeSettingdao() {
        ThemeSettingDao themeSettingDao;
        if (this._themeSettingDao != null) {
            return this._themeSettingDao;
        }
        synchronized (this) {
            if (this._themeSettingDao == null) {
                this._themeSettingDao = new ThemeSettingDao_Impl(this);
            }
            themeSettingDao = this._themeSettingDao;
        }
        return themeSettingDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public VideoDao getvideoDao() {
        VideoDao videoDao;
        if (this._videoDao != null) {
            return this._videoDao;
        }
        synchronized (this) {
            if (this._videoDao == null) {
                this._videoDao = new VideoDao_Impl(this);
            }
            videoDao = this._videoDao;
        }
        return videoDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public Htmllink gethtmllink() {
        Htmllink htmllink;
        if (this._htmllink != null) {
            return this._htmllink;
        }
        synchronized (this) {
            if (this._htmllink == null) {
                this._htmllink = new Htmllink_Impl(this);
            }
            htmllink = this._htmllink;
        }
        return htmllink;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public FolderDao getFolderDetails() {
        FolderDao folderDao;
        if (this._folderDao != null) {
            return this._folderDao;
        }
        synchronized (this) {
            if (this._folderDao == null) {
                this._folderDao = new FolderDao_Impl(this);
            }
            folderDao = this._folderDao;
        }
        return folderDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public ApiDao getapidao() {
        ApiDao apiDao;
        if (this._apiDao != null) {
            return this._apiDao;
        }
        synchronized (this) {
            if (this._apiDao == null) {
                this._apiDao = new ApiDao_Impl(this);
            }
            apiDao = this._apiDao;
        }
        return apiDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public GetMasterAllCatDao getMasterAllCatDao() {
        GetMasterAllCatDao getMasterAllCatDao;
        if (this._getMasterAllCatDao != null) {
            return this._getMasterAllCatDao;
        }
        synchronized (this) {
            if (this._getMasterAllCatDao == null) {
                this._getMasterAllCatDao = new GetMasterAllCatDao_Impl(this);
            }
            getMasterAllCatDao = this._getMasterAllCatDao;
        }
        return getMasterAllCatDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public CourseTypeMasterDao getcoursetypemaster() {
        CourseTypeMasterDao courseTypeMasterDao;
        if (this._courseTypeMasterDao != null) {
            return this._courseTypeMasterDao;
        }
        synchronized (this) {
            if (this._courseTypeMasterDao == null) {
                this._courseTypeMasterDao = new CourseTypeMasterDao_Impl(this);
            }
            courseTypeMasterDao = this._courseTypeMasterDao;
        }
        return courseTypeMasterDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public MycourseDao getMyCourseDao() {
        MycourseDao mycourseDao;
        if (this._mycourseDao != null) {
            return this._mycourseDao;
        }
        synchronized (this) {
            if (this._mycourseDao == null) {
                this._mycourseDao = new MycourseDao_Impl(this);
            }
            mycourseDao = this._mycourseDao;
        }
        return mycourseDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public MasterCatDao getMastercatDao() {
        MasterCatDao masterCatDao;
        if (this._masterCatDao != null) {
            return this._masterCatDao;
        }
        synchronized (this) {
            if (this._masterCatDao == null) {
                this._masterCatDao = new MasterCatDao_Impl(this);
            }
            masterCatDao = this._masterCatDao;
        }
        return masterCatDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public UserHistroyDao getuserhistorydao() {
        UserHistroyDao userHistroyDao;
        if (this._userHistroyDao != null) {
            return this._userHistroyDao;
        }
        synchronized (this) {
            if (this._userHistroyDao == null) {
                this._userHistroyDao = new UserHistroyDao_Impl(this);
            }
            userHistroyDao = this._userHistroyDao;
        }
        return userHistroyDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public YoutubePlayerDao getyoutubedata() {
        YoutubePlayerDao youtubePlayerDao;
        if (this._youtubePlayerDao != null) {
            return this._youtubePlayerDao;
        }
        synchronized (this) {
            if (this._youtubePlayerDao == null) {
                this._youtubePlayerDao = new YoutubePlayerDao_Impl(this);
            }
            youtubePlayerDao = this._youtubePlayerDao;
        }
        return youtubePlayerDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public CourseDetailDao getCourseDetaildata() {
        CourseDetailDao courseDetailDao;
        if (this._courseDetailDao != null) {
            return this._courseDetailDao;
        }
        synchronized (this) {
            if (this._courseDetailDao == null) {
                this._courseDetailDao = new CourseDetailDao_Impl(this);
            }
            courseDetailDao = this._courseDetailDao;
        }
        return courseDetailDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public CourseDataDao getCoursedata() {
        CourseDataDao courseDataDao;
        if (this._courseDataDao != null) {
            return this._courseDataDao;
        }
        synchronized (this) {
            if (this._courseDataDao == null) {
                this._courseDataDao = new CourseDataDao_Impl(this);
            }
            courseDataDao = this._courseDataDao;
        }
        return courseDataDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public HomeApiStatusDao getHomeApiStatusdata() {
        HomeApiStatusDao homeApiStatusDao;
        if (this._homeApiStatusDao != null) {
            return this._homeApiStatusDao;
        }
        synchronized (this) {
            if (this._homeApiStatusDao == null) {
                this._homeApiStatusDao = new HomeApiStatusDao_Impl(this);
            }
            homeApiStatusDao = this._homeApiStatusDao;
        }
        return homeApiStatusDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public LaunguageDao getLaunguages() {
        LaunguageDao launguageDao;
        if (this._launguageDao != null) {
            return this._launguageDao;
        }
        synchronized (this) {
            if (this._launguageDao == null) {
                this._launguageDao = new LaunguageDao_Impl(this);
            }
            launguageDao = this._launguageDao;
        }
        return launguageDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public PigiBag getpigibag() {
        PigiBag pigiBag;
        if (this._pigiBag != null) {
            return this._pigiBag;
        }
        synchronized (this) {
            if (this._pigiBag == null) {
                this._pigiBag = new PigiBag_Impl(this);
            }
            pigiBag = this._pigiBag;
        }
        return pigiBag;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public TestDao getTestDao() {
        TestDao testDao;
        if (this._testDao != null) {
            return this._testDao;
        }
        synchronized (this) {
            if (this._testDao == null) {
                this._testDao = new TestDao_Impl(this);
            }
            testDao = this._testDao;
        }
        return testDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public FeedsDao getFeedDao() {
        FeedsDao feedsDao;
        if (this._feedsDao != null) {
            return this._feedsDao;
        }
        synchronized (this) {
            if (this._feedsDao == null) {
                this._feedsDao = new FeedsDao_Impl(this);
            }
            feedsDao = this._feedsDao;
        }
        return feedsDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public UserWiseCourseDao getuserwisecourse() {
        UserWiseCourseDao userWiseCourseDao;
        if (this._userWiseCourseDao != null) {
            return this._userWiseCourseDao;
        }
        synchronized (this) {
            if (this._userWiseCourseDao == null) {
                this._userWiseCourseDao = new UserWiseCourseDao_Impl(this);
            }
            userWiseCourseDao = this._userWiseCourseDao;
        }
        return userWiseCourseDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public BannerListDao getBannerTableDao() {
        BannerListDao bannerListDao;
        if (this._bannerListDao != null) {
            return this._bannerListDao;
        }
        synchronized (this) {
            if (this._bannerListDao == null) {
                this._bannerListDao = new BannerListDao_Impl(this);
            }
            bannerListDao = this._bannerListDao;
        }
        return bannerListDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public BottomMenuDao getBottomMenuTableDao() {
        BottomMenuDao bottomMenuDao;
        if (this._bottomMenuDao != null) {
            return this._bottomMenuDao;
        }
        synchronized (this) {
            if (this._bottomMenuDao == null) {
                this._bottomMenuDao = new BottomMenuDao_Impl(this);
            }
            bottomMenuDao = this._bottomMenuDao;
        }
        return bottomMenuDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public TopperReviewDao getTopperReviewDao() {
        TopperReviewDao topperReviewDao;
        if (this._topperReviewDao != null) {
            return this._topperReviewDao;
        }
        synchronized (this) {
            if (this._topperReviewDao == null) {
                this._topperReviewDao = new TopperReviewDao_Impl(this);
            }
            topperReviewDao = this._topperReviewDao;
        }
        return topperReviewDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public ExpiredEmiDao getExpiredCancelledDao() {
        ExpiredEmiDao expiredEmiDao;
        if (this._expiredEmiDao != null) {
            return this._expiredEmiDao;
        }
        synchronized (this) {
            if (this._expiredEmiDao == null) {
                this._expiredEmiDao = new ExpiredEmiDao_Impl(this);
            }
            expiredEmiDao = this._expiredEmiDao;
        }
        return expiredEmiDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public DueEmiDao getDueEmi() {
        DueEmiDao dueEmiDao;
        if (this._dueEmiDao != null) {
            return this._dueEmiDao;
        }
        synchronized (this) {
            if (this._dueEmiDao == null) {
                this._dueEmiDao = new DueEmiDao_Impl(this);
            }
            dueEmiDao = this._dueEmiDao;
        }
        return dueEmiDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public TestResumeDao getTestResumeDao() {
        TestResumeDao testResumeDao;
        if (this._testResumeDao != null) {
            return this._testResumeDao;
        }
        synchronized (this) {
            if (this._testResumeDao == null) {
                this._testResumeDao = new TestResumeDao_Impl(this);
            }
            testResumeDao = this._testResumeDao;
        }
        return testResumeDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public PDFDataDao getPDFDataDao() {
        PDFDataDao pDFDataDao;
        if (this._pDFDataDao != null) {
            return this._pDFDataDao;
        }
        synchronized (this) {
            if (this._pDFDataDao == null) {
                this._pDFDataDao = new PDFDataDao_Impl(this);
            }
            pDFDataDao = this._pDFDataDao;
        }
        return pDFDataDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public PollDataDao getPollDataDao() {
        PollDataDao pollDataDao;
        if (this._pollDataDao != null) {
            return this._pollDataDao;
        }
        synchronized (this) {
            if (this._pollDataDao == null) {
                this._pollDataDao = new PollDataDao_Impl(this);
            }
            pollDataDao = this._pollDataDao;
        }
        return pollDataDao;
    }

    @Override // com.appnew.android.Room.UtkashRoom
    public CenterIdDao getCenterIdDao() {
        CenterIdDao centerIdDao;
        if (this._centerIdDao != null) {
            return this._centerIdDao;
        }
        synchronized (this) {
            if (this._centerIdDao == null) {
                this._centerIdDao = new CenterIdDao_Impl(this);
            }
            centerIdDao = this._centerIdDao;
        }
        return centerIdDao;
    }
}
