package com.appnew.android.Room;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes6.dex */
final class UtkashRoom_AutoMigration_21_22_Impl extends Migration {
    public UtkashRoom_AutoMigration_21_22_Impl() {
        super(21, 22);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(final SupportSQLiteDatabase db) {
        db.execSQL("ALTER TABLE `ExpiredEMI` ADD COLUMN `is_subscription` TEXT DEFAULT NULL");
    }
}
