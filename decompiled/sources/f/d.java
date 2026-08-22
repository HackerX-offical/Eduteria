package f;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1244a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f1246c;

    public final String a() {
        return this.f1244a;
    }

    public final void b(long j) {
        this.f1245b = j;
    }

    public final long c() {
        return this.f1245b;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1244a = str;
    }

    public final long b() {
        return this.f1246c;
    }

    public final void a(long j) {
        this.f1246c = j;
    }
}
