package f;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.pallycon.widevine.exception.PallyConException;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f1228f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f1229g = "pallycon_database";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f1230h = "pallyconDataBase";
    public static final int i = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f.a f1232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SQLiteDatabase f1233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SQLiteDatabase f1234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1235e;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public b(Context context) throws Exception {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f1231a = context;
        try {
            f.a aVar = new f.a(context, f1230h, null, 4);
            this.f1232b = aVar;
            this.f1233c = aVar.getReadableDatabase();
            f.a aVar2 = this.f1232b;
            this.f1234d = aVar2 != null ? aVar2.getWritableDatabase() : null;
            SQLiteDatabase sQLiteDatabase = this.f1233c;
            Intrinsics.checkNotNull(sQLiteDatabase);
            if (sQLiteDatabase.rawQuery(f.f1255h, null).getColumnIndex("offlineLicenseExpireDate") == -1) {
                SQLiteDatabase sQLiteDatabase2 = this.f1234d;
                Intrinsics.checkNotNull(sQLiteDatabase2);
                sQLiteDatabase2.execSQL(f.f1253f);
            }
            this.f1235e = true;
        } catch (Exception e2) {
            this.f1235e = false;
            throw e2;
        }
    }

    public final void a() {
        f.a aVar = this.f1232b;
        if (aVar != null) {
            aVar.close();
        }
    }

    public final c b(String cid, String siteId) {
        Intrinsics.checkNotNullParameter(cid, "cid");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        c cVarA = null;
        if (!this.f1235e) {
            Log.d("pallycon_database", "DatabaseManager have not been initialized.");
            return null;
        }
        String str = String.format(f.f1254g, "WHERE cid='" + cid + "' AND siteId='" + siteId + '\'');
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        Cursor cursorD = d(str);
        if (cursorD != null) {
            if (cursorD.moveToFirst()) {
                do {
                    cVarA = a(cursorD, 0);
                } while (cursorD.moveToNext());
            }
            cursorD.close();
        }
        return cVarA;
    }

    public final ArrayList<c> c() {
        ArrayList<c> arrayList = new ArrayList<>();
        if (!this.f1235e) {
            Log.d("pallycon_database", "DatabaseManager have not been initialized.");
            return arrayList;
        }
        String str = String.format(f.f1254g, new Object[0]);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        Cursor cursorD = d(str);
        if (cursorD != null) {
            if (cursorD.moveToFirst()) {
                do {
                    c cVarA = a(cursorD, 0);
                    if (cVarA != null) {
                        arrayList.add(cVarA);
                    }
                } while (cursorD.moveToNext());
            }
            cursorD.close();
        }
        return arrayList;
    }

    public final void d() {
        f.a aVar = this.f1232b;
        this.f1233c = aVar != null ? aVar.getReadableDatabase() : null;
    }

    public final d e() {
        d dVarB = null;
        if (!this.f1235e) {
            Log.d("pallycon_database", "DatabaseManager have not been initialized.");
            return null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(f.j, Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        Cursor cursorD = d(str);
        if (cursorD != null) {
            if (cursorD.moveToFirst()) {
                do {
                    dVarB = b(cursorD, 0);
                } while (cursorD.moveToNext());
            }
            cursorD.close();
        }
        return dVarB;
    }

    public final void f() {
        f.a aVar = this.f1232b;
        this.f1234d = aVar != null ? aVar.getWritableDatabase() : null;
    }

    public final boolean a(String cid, String siteId) throws SQLiteException {
        Intrinsics.checkNotNullParameter(cid, "cid");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        if (!this.f1235e) {
            Log.d("pallycon_database", "DatabaseManager have not been initialized.");
            return false;
        }
        String str = String.format(f.k, "WHERE cid='" + cid + "' AND siteId='" + siteId + '\'');
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return c(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.database.Cursor d(java.lang.String r3) {
        /*
            r2 = this;
            boolean r0 = r2.f1235e
            r1 = 0
            if (r0 != 0) goto Ld
            java.lang.String r3 = "pallycon_database"
            java.lang.String r0 = "DatabaseManager have not been initialized."
            android.util.Log.d(r3, r0)
            return r1
        Ld:
            android.database.sqlite.SQLiteDatabase r0 = r2.f1233c
            if (r0 == 0) goto L1a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r0 = r0.isOpen()
            if (r0 != 0) goto L1d
        L1a:
            r2.f()
        L1d:
            android.database.sqlite.SQLiteDatabase r0 = r2.f1233c
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            android.database.Cursor r3 = r0.rawQuery(r3, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: f.b.d(java.lang.String):android.database.Cursor");
    }

    public final void a(String siteId) {
        String str;
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        if (!this.f1235e) {
            Log.d("pallycon_database", "DatabaseManager have not been initialized.");
            return;
        }
        if (siteId.length() == 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            str = String.format("DELETE FROM 'Content'", Arrays.copyOf(new Object[0], 0));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        } else {
            str = String.format(f.k, "WHERE siteId='" + siteId + '\'');
        }
        Intrinsics.checkNotNull(str);
        c(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(java.lang.String r2) throws android.database.sqlite.SQLiteException {
        /*
            r1 = this;
            boolean r0 = r1.f1235e
            if (r0 != 0) goto Ld
            java.lang.String r2 = "pallycon_database"
            java.lang.String r0 = "DatabaseManager have not been initialized."
            android.util.Log.d(r2, r0)
            r2 = 0
            return r2
        Ld:
            android.database.sqlite.SQLiteDatabase r0 = r1.f1234d
            if (r0 == 0) goto L1a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r0 = r0.isOpen()
            if (r0 != 0) goto L1d
        L1a:
            r1.f()
        L1d:
            android.database.sqlite.SQLiteDatabase r0 = r1.f1234d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0.execSQL(r2)
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: f.b.c(java.lang.String):boolean");
    }

    public final void b(String owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (!this.f1235e) {
            Log.d("pallycon_database", "DatabaseManager have not been initialized.");
            return;
        }
        String str = String.format(f.l, "WHERE owner='" + owner + '\'');
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        c(str);
    }

    public final c a(Cursor cursor, int i2) {
        if (!this.f1235e) {
            Log.d("pallycon_database", "DatabaseManager have not been initialized.");
            return null;
        }
        c cVar = new c();
        int i3 = i2 + 1;
        cVar.a(cursor.getInt(i2));
        try {
            cVar.b("");
            if (cVar.d().length == 0) {
                String string = cursor.getString(i2);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                cVar.b(string);
            }
        } catch (PallyConException.MigrationException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalArgumentException unused) {
            String string2 = cursor.getString(i2);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            cVar.b(string2);
        }
        String string3 = cursor.getString(i3);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        cVar.a(string3);
        String string4 = cursor.getString(i2 + 2);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        cVar.e(string4);
        String string5 = cursor.getString(i2 + 3);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        cVar.c(string5);
        String string6 = cursor.getString(i2 + 4);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        cVar.f(string6);
        String string7 = cursor.getString(i2 + 5);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        cVar.g(string7);
        return cVar;
    }

    public final void b() {
        if (!this.f1235e) {
            Log.d("pallycon_database", "DatabaseManager have not been initialized.");
            return;
        }
        String str = String.format(f.m, "");
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        c(str);
    }

    public final d b(Cursor cursor, int i2) {
        if (!this.f1235e) {
            Log.d("pallycon_database", "DatabaseManager have not been initialized.");
            return null;
        }
        d dVar = new d();
        int i3 = i2 + 1;
        String string = cursor.getString(i2);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        dVar.a(string);
        try {
            dVar.b(Long.parseLong(""));
            Log.d("pallycon_database", "parseLong is success.");
            dVar.a(cursor.getLong(i3));
            return dVar;
        } catch (PallyConException.MigrationException e2) {
            throw new PallyConException.MigrationException(e2, "[time] " + e2.getMessage());
        } catch (Exception e3) {
            e3.printStackTrace();
            Log.e("pallycon_database", "tickTime : ");
            throw new PallyConException.MigrationException(e3, "[time] tickTime:");
        }
    }
}
