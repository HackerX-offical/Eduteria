package f;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0206a f1226a = new C0206a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f1227b = "pallycon_database";

    /* JADX INFO: renamed from: f.a$a, reason: collision with other inner class name */
    public static final class C0206a {
        public /* synthetic */ C0206a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public C0206a() {
        }
    }

    public a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sqLiteDatabase) throws SQLiteException {
        Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
        sqLiteDatabase.execSQL(f.f1249b);
        sqLiteDatabase.execSQL(f.f1250c);
        sqLiteDatabase.execSQL(f.f1251d);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Log.d("pallycon_database", "onDowngrade.");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
        Log.d("pallycon_database", "onUpgrade.");
        if (i < 2) {
            sqLiteDatabase.execSQL(f.f1252e);
        }
        if (i < 3) {
            sqLiteDatabase.execSQL(f.f1251d);
        }
    }
}
