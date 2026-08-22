package com.appnew.android.Room;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes6.dex */
final class UtkashRoom_AutoMigration_20_21_Impl extends Migration {
    public UtkashRoom_AutoMigration_20_21_Impl() {
        super(20, 21);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(final SupportSQLiteDatabase db) {
        db.execSQL("ALTER TABLE `CourseDataTable` ADD COLUMN `book_redirection_link` TEXT DEFAULT ''");
        db.execSQL("ALTER TABLE `CourseDetailTable` ADD COLUMN `thumbnail` TEXT DEFAULT NULL");
        db.execSQL("ALTER TABLE `CourseDetailTable` ADD COLUMN `book_redirection_link` TEXT DEFAULT NULL");
    }
}
