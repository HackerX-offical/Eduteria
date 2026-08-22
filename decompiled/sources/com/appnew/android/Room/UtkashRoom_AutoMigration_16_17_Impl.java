package com.appnew.android.Room;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes6.dex */
final class UtkashRoom_AutoMigration_16_17_Impl extends Migration {
    public UtkashRoom_AutoMigration_16_17_Impl() {
        super(16, 17);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(final SupportSQLiteDatabase db) {
        db.execSQL("ALTER TABLE `CourseDetailTable` ADD COLUMN `is_rating` TEXT DEFAULT NULL");
        db.execSQL("ALTER TABLE `CourseDetailTable` ADD COLUMN `payment_mode` TEXT DEFAULT NULL");
        db.execSQL("ALTER TABLE `CourseDetailTable` ADD COLUMN `event_location` TEXT DEFAULT NULL");
        db.execSQL("ALTER TABLE `CourseDetailTable` ADD COLUMN `location` TEXT DEFAULT NULL");
        db.execSQL("ALTER TABLE `CourseDetailTable` ADD COLUMN `start_date` TEXT DEFAULT NULL");
        db.execSQL("ALTER TABLE `CourseDetailTable` ADD COLUMN `end_date` TEXT DEFAULT NULL");
        db.execSQL("ALTER TABLE `CourseDetailTable` ADD COLUMN `extra_json` TEXT DEFAULT NULL");
        db.execSQL("ALTER TABLE `VideoDownload` ADD COLUMN `with_validity` TEXT DEFAULT NULL");
        db.execSQL("ALTER TABLE `VideoDownload` ADD COLUMN `with_validity_message` TEXT DEFAULT NULL");
        db.execSQL("ALTER TABLE `VideoDownload` ADD COLUMN `validity_end_date` TEXT DEFAULT NULL");
        db.execSQL("ALTER TABLE `VideoDownload` ADD COLUMN `validity_start_date` TEXT DEFAULT NULL");
        db.execSQL("ALTER TABLE `CourseTypeMasterTable` ADD COLUMN `sub_cat_id` TEXT DEFAULT NULL");
        db.execSQL("ALTER TABLE `MasterCat` ADD COLUMN `isSelected` INTEGER NOT NULL DEFAULT false");
        db.execSQL("ALTER TABLE `BannerListTable` ADD COLUMN `course_type` TEXT DEFAULT NULL");
        db.execSQL("CREATE TABLE IF NOT EXISTS `PollDataTable` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `user_id` TEXT, `poll_id` TEXT, `firebase_node` TEXT, `poll_answer` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `CenterIdTable` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `center_id` TEXT, `user_id` TEXT, `center_name` TEXT)");
    }
}
