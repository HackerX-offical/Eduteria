package h;

import android.content.Context;
import android.util.Log;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1339a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static f f1340b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Context f1341c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f1342d = "PallyConWvSDKLog";

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final f a(Context _context) {
            f fVar;
            Intrinsics.checkNotNullParameter(_context, "_context");
            f fVar2 = f.f1340b;
            if (fVar2 != null) {
                return fVar2;
            }
            synchronized (this) {
                fVar = f.f1340b;
                if (fVar == null) {
                    fVar = new f(null);
                    a aVar = f.f1339a;
                    f.f1341c = _context;
                    f.f1340b = fVar;
                    Log.e(f.f1342d, "-------------------------------------");
                    Log.e(f.f1342d, "-- PALLYCON WideVine SDK version : 4.3.2");
                    Log.e(f.f1342d, "-------------------------------------");
                }
            }
            return fVar;
        }

        public a() {
        }
    }

    public /* synthetic */ f(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public f() {
    }
}
