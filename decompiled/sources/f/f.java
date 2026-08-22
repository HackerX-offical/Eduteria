package f;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f1248a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f1249b = "CREATE TABLE IF NOT EXISTS Content (contentIndex INTEGER PRIMARY KEY AUTOINCREMENT, keySetId TEXT NOT NULL, cid TEXT NOT NULL, playbackDuration TEXT NOT NULL, licenseDuration TEXT NOT NULL, registeredDate Date NOT NULL, siteId TEXT NOT NULL, offlineLicenseExpireDate TEXT NOT NULL);";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f1250c = "CREATE TABLE IF NOT EXISTS Time (owner TEXT NOT NULL, tickTime TEXT NOT NULL, tickCount INTEGER NOT NULL );";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f1251d = "CREATE TABLE IF NOT EXISTS Auth (siteId TEXT, sdkCode TEXT );";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f1252e = "ALTER TABLE Content ADD siteId TEXT NOT NULL DEFAULT '';";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f1253f = "ALTER TABLE Content ADD COLUMN offlineLicenseExpireDate TEXT DEFAULT 0";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f1254g = "SELECT * FROM 'Content' %s ORDER BY contentIndex";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f1255h = "SELECT * FROM 'Content' LIMIT 0";
    public static final String i = "SELECT * FROM 'Auth'";
    public static final String j = "SELECT * FROM 'Time'";
    public static final String k = "DELETE FROM 'Content' %s;";
    public static final String l = "DELETE FROM 'Time' %s;";
    public static final String m = "DELETE FROM 'Auth';";
}
