package g;

import androidx.media3.exoplayer.upstream.Loader;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0208a f1304d = new C0208a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Loader f1306b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f1305a = CollectionsKt.listOf((Object[]) new String[]{"time.android.com", "time.google.com", "time.windows.com", "time.kriss.re.kr"});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f1307c = new b();

    /* JADX INFO: renamed from: g.a$a, reason: collision with other inner class name */
    public static final class C0208a {
        public /* synthetic */ C0208a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(long j) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%04d-%02d-%02dT%02d:%02d:%02dZ", Arrays.copyOf(new Object[]{Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13))}, 6));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }

        public C0208a() {
        }
    }

    public final List<String> a() {
        return this.f1305a;
    }

    public final long b() {
        Iterator<String> it = this.f1305a.iterator();
        while (it.hasNext()) {
            if (this.f1307c.a(it.next(), 3000)) {
                long jB = this.f1307c.b();
                if (jB != -9223372036854775807L) {
                    return jB;
                }
            }
        }
        return 0L;
    }

    public final Object a(String str, Continuation<? super Long> continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        b bVar = new b();
        bVar.a(str, 3000);
        Result.Companion companion = Result.INSTANCE;
        safeContinuation.resumeWith(Result.m12393constructorimpl(Boxing.boxLong(bVar.b())));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
