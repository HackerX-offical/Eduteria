package com.appnew.android.Room;

import android.content.Context;
import android.os.Environment;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.appnew.android.Dao.ApiDao;
import com.appnew.android.Dao.AudioDao;
import com.appnew.android.Dao.BannerListDao;
import com.appnew.android.Dao.BottomMenuDao;
import com.appnew.android.Dao.CenterIdDao;
import com.appnew.android.Dao.CourseDataDao;
import com.appnew.android.Dao.CourseDetailDao;
import com.appnew.android.Dao.CourseTypeMasterDao;
import com.appnew.android.Dao.DueEmiDao;
import com.appnew.android.Dao.ExpiredEmiDao;
import com.appnew.android.Dao.FeedsDao;
import com.appnew.android.Dao.FolderDao;
import com.appnew.android.Dao.GetMasterAllCatDao;
import com.appnew.android.Dao.HomeApiStatusDao;
import com.appnew.android.Dao.Htmllink;
import com.appnew.android.Dao.LaunguageDao;
import com.appnew.android.Dao.MasterCatDao;
import com.appnew.android.Dao.MycourseDao;
import com.appnew.android.Dao.PDFDataDao;
import com.appnew.android.Dao.PigiBag;
import com.appnew.android.Dao.PollDataDao;
import com.appnew.android.Dao.TestDao;
import com.appnew.android.Dao.TestResumeDao;
import com.appnew.android.Dao.ThemeSettingDao;
import com.appnew.android.Dao.TopperReviewDao;
import com.appnew.android.Dao.UserHistroyDao;
import com.appnew.android.Dao.UserWiseCourseDao;
import com.appnew.android.Dao.VideoDao;
import com.appnew.android.Dao.VideoDownload;
import com.appnew.android.Dao.YoutubePlayerDao;
import com.appnew.android.Utils.MakeMyExam;

/* JADX INFO: loaded from: classes6.dex */
public abstract class UtkashRoom extends RoomDatabase {
    private static final String DATABASE_NAME = "EDUTERIADB.db";
    private static UtkashRoom INSTANCE;
    static final Migration MIGRATION_8_9 = new Migration(8, 9) { // from class: com.appnew.android.Room.UtkashRoom.1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE BannerListTable ADD COLUMN is_combo INTEGER NOT NULL DEFAULT 0");
        }
    };

    public abstract BannerListDao getBannerTableDao();

    public abstract BottomMenuDao getBottomMenuTableDao();

    public abstract CenterIdDao getCenterIdDao();

    public abstract CourseDetailDao getCourseDetaildata();

    public abstract CourseDataDao getCoursedata();

    public abstract DueEmiDao getDueEmi();

    public abstract ExpiredEmiDao getExpiredCancelledDao();

    public abstract FeedsDao getFeedDao();

    public abstract FolderDao getFolderDetails();

    public abstract HomeApiStatusDao getHomeApiStatusdata();

    public abstract LaunguageDao getLaunguages();

    public abstract GetMasterAllCatDao getMasterAllCatDao();

    public abstract MasterCatDao getMastercatDao();

    public abstract MycourseDao getMyCourseDao();

    public abstract PDFDataDao getPDFDataDao();

    public abstract PollDataDao getPollDataDao();

    public abstract TestDao getTestDao();

    public abstract TestResumeDao getTestResumeDao();

    public abstract TopperReviewDao getTopperReviewDao();

    public abstract ApiDao getapidao();

    public abstract AudioDao getaudiodao();

    public abstract CourseTypeMasterDao getcoursetypemaster();

    public abstract Htmllink gethtmllink();

    public abstract PigiBag getpigibag();

    public abstract ThemeSettingDao getthemeSettingdao();

    public abstract UserHistroyDao getuserhistorydao();

    public abstract UserWiseCourseDao getuserwisecourse();

    public abstract VideoDao getvideoDao();

    public abstract VideoDownload getvideoDownloadao();

    public abstract YoutubePlayerDao getyoutubedata();

    public static synchronized UtkashRoom getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = (UtkashRoom) Room.databaseBuilder(MakeMyExam.getAppContext(), UtkashRoom.class, MakeMyExam.getAppContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "166EDUTERIADB.db").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        UtkashRoom utkashRoom = INSTANCE;
        if (utkashRoom != null && utkashRoom.isOpen()) {
            INSTANCE.close();
        }
        INSTANCE = null;
    }
}
