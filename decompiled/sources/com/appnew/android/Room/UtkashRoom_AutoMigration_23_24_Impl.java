package com.appnew.android.Room;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes6.dex */
final class UtkashRoom_AutoMigration_23_24_Impl extends Migration {
    public UtkashRoom_AutoMigration_23_24_Impl() {
        super(23, 24);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(final SupportSQLiteDatabase db) {
        db.execSQL("ALTER TABLE `CourseDataTable` ADD COLUMN `payment_mode` TEXT DEFAULT NULL");
        db.execSQL("ALTER TABLE `CourseDetailTable` ADD COLUMN `is_trial` TEXT DEFAULT NULL");
        db.execSQL("ALTER TABLE `CourseDetailTable` ADD COLUMN `last_paid_txn_id` TEXT DEFAULT NULL");
    }
}
