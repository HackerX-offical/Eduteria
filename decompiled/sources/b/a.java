package b;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0092a f244c = new C0092a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f245d = "PallyConDBManager";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f246e = "pallycon_setting";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f247f = "secure_tick_time";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f248g = "secure_tick_count";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static a f249h;
    public static boolean i;
    public static boolean j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences f251b;

    /* JADX INFO: renamed from: b.a$a, reason: collision with other inner class name */
    public static final class C0092a {
        public /* synthetic */ C0092a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return a.j;
        }

        public C0092a() {
        }

        public final void a(boolean z) {
            a.j = z;
        }

        public final a a(Context _context) {
            a aVar;
            Intrinsics.checkNotNullParameter(_context, "_context");
            a aVar2 = a.f249h;
            if (aVar2 != null) {
                return aVar2;
            }
            synchronized (this) {
                aVar = a.f249h;
                if (aVar == null) {
                    aVar = new a(_context);
                    C0092a c0092a = a.f244c;
                    a.f249h = aVar;
                }
            }
            return aVar;
        }
    }

    @DebugMetadata(c = "com.pallycon.widevine.db.PallyConDBManager$updateSecureTime$1", f = "PallyConDBManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f252a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f254c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f255d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Function0<Unit> function0, Function0<Unit> function02, Continuation<? super b> continuation) {
            super(2, continuation);
            this.f254c = function0;
            this.f255d = function02;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return a.this.new b(this.f254c, this.f255d, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x00ed A[Catch: AEADBadTagException -> 0x01a6, Exception -> 0x01a8, all -> 0x01aa, TryCatch #0 {AEADBadTagException -> 0x01a6, blocks: (B:20:0x00ae, B:22:0x00ed, B:28:0x013f, B:30:0x0191, B:32:0x0195, B:33:0x0199, B:35:0x019d, B:23:0x0103, B:25:0x0119, B:27:0x013b, B:26:0x012a), top: B:60:0x00ae }] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0103 A[Catch: AEADBadTagException -> 0x01a6, Exception -> 0x01a8, all -> 0x01aa, TryCatch #0 {AEADBadTagException -> 0x01a6, blocks: (B:20:0x00ae, B:22:0x00ed, B:28:0x013f, B:30:0x0191, B:32:0x0195, B:33:0x0199, B:35:0x019d, B:23:0x0103, B:25:0x0119, B:27:0x013b, B:26:0x012a), top: B:60:0x00ae }] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0191 A[Catch: AEADBadTagException -> 0x01a6, Exception -> 0x01a8, all -> 0x01aa, TryCatch #0 {AEADBadTagException -> 0x01a6, blocks: (B:20:0x00ae, B:22:0x00ed, B:28:0x013f, B:30:0x0191, B:32:0x0195, B:33:0x0199, B:35:0x019d, B:23:0x0103, B:25:0x0119, B:27:0x013b, B:26:0x012a), top: B:60:0x00ae }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0199 A[Catch: AEADBadTagException -> 0x01a6, Exception -> 0x01a8, all -> 0x01aa, TryCatch #0 {AEADBadTagException -> 0x01a6, blocks: (B:20:0x00ae, B:22:0x00ed, B:28:0x013f, B:30:0x0191, B:32:0x0195, B:33:0x0199, B:35:0x019d, B:23:0x0103, B:25:0x0119, B:27:0x013b, B:26:0x012a), top: B:60:0x00ae }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r32) {
            /*
                Method dump skipped, instruction units count: 524
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public a(Context context) throws GeneralSecurityException, IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f250a = context;
        SharedPreferences sharedPreferencesCreate = EncryptedSharedPreferences.create(context, f246e, a(context), EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
        Intrinsics.checkNotNullExpressionValue(sharedPreferencesCreate, "create(...)");
        this.f251b = sharedPreferencesCreate;
    }

    public final long d() {
        return this.f251b.getLong(f248g, 0L);
    }

    public final long e() {
        return this.f251b.getLong(f247f, 0L);
    }

    public final void f() {
        long j2 = this.f251b.getLong(f247f, 0L);
        long j3 = this.f251b.getLong(f248g, 0L);
        this.f251b.edit().clear().apply();
        this.f251b.edit().putLong(f247f, j2).apply();
        this.f251b.edit().putLong(f248g, j3).apply();
    }

    public final void g() throws GeneralSecurityException, IOException {
        this.f251b.edit().clear().apply();
        Context context = this.f250a;
        SharedPreferences sharedPreferencesCreate = EncryptedSharedPreferences.create(context, f246e, a(context), EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
        Intrinsics.checkNotNullExpressionValue(sharedPreferencesCreate, "create(...)");
        this.f251b = sharedPreferencesCreate;
    }

    public final ArrayList<String> c() {
        Object value;
        ArrayList<String> arrayList = new ArrayList<>();
        Map<String, ?> all = this.f251b.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (!Intrinsics.areEqual(entry.getKey(), f247f) && !Intrinsics.areEqual(entry.getKey(), f248g) && (value = entry.getValue()) != null) {
                arrayList.add(value.toString());
            }
        }
        return arrayList;
    }

    public final MasterKey a(Context context) throws GeneralSecurityException, IOException {
        MasterKey masterKeyBuild = new MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build();
        Intrinsics.checkNotNullExpressionValue(masterKeyBuild, "build(...)");
        return masterKeyBuild;
    }

    public final void b(String key, String localUrl) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(localUrl, "localUrl");
        this.f251b.edit().putString(key, localUrl).apply();
    }

    public final void b(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.f251b.edit().remove(url).apply();
    }

    public final void a(Function0<Unit> function0, Function0<Unit> function02) {
        if (i) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new b(function02, function0, null), 3, null);
    }

    public final String a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String string = this.f251b.getString(key, "");
        return string == null ? "" : string;
    }

    public final void a(String url, String key) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(key, "key");
        String string = this.f251b.getString(url, "");
        String str = string != null ? string : "";
        if (str.length() > 0) {
            this.f251b.edit().putString(key, str).apply();
        }
    }
}
