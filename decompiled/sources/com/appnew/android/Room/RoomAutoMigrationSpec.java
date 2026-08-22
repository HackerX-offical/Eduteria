package com.appnew.android.Room;

import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RoomAutoMigrationSpec.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/appnew/android/Room/RoomAutoMigrationSpec;", "Landroidx/room/migration/AutoMigrationSpec;", "<init>", "()V", "onPostMigrate", "", UserDataStore.DATE_OF_BIRTH, "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RoomAutoMigrationSpec implements AutoMigrationSpec {
    public static final int $stable = 0;

    @Override // androidx.room.migration.AutoMigrationSpec
    public void onPostMigrate(SupportSQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
    }
}
