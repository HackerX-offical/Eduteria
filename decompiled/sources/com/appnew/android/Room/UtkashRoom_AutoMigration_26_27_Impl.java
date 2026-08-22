package com.appnew.android.Room;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes6.dex */
final class UtkashRoom_AutoMigration_26_27_Impl extends Migration {
    public UtkashRoom_AutoMigration_26_27_Impl() {
        super(26, 27);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(final SupportSQLiteDatabase db) {
        db.execSQL("ALTER TABLE `BannerListTable` ADD COLUMN `is_combo` INTEGER NOT NULL DEFAULT 0");
    }
}
