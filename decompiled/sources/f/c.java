package f;

import android.util.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1236a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1237b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1238c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1239d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f1240e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1241f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f1242g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f1243h = "";

    public final void a(int i) {
        this.f1236a = i;
    }

    public final int b() {
        return this.f1236a;
    }

    public final String c() {
        return this.f1238c;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1243h = str;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1241f = str;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1240e = str;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1237b = str;
    }

    public final String h() {
        return this.f1240e;
    }

    public final String i() {
        return this.f1237b;
    }

    public final String j() {
        return StringsKt.trimIndent("\n            contentIndex : " + this.f1236a + "\n            siteId : " + this.f1237b + "\n            keySetId : " + this.f1238c + "\n            cid : " + this.f1239d + "\n            playbackDuration : " + this.f1241f + "\n            licenseDuration : " + this.f1242g + "\n            registeredDate : " + this.f1240e + "offlineLicenseExpireDate : " + this.f1243h + "\n            ");
    }

    public final String a() {
        return this.f1239d;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1238c = str;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1242g = str;
    }

    public final byte[] d() {
        byte[] bArrDecode = Base64.decode(this.f1238c, 2);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        return bArrDecode;
    }

    public final String e() {
        return this.f1242g;
    }

    public final String f() {
        return this.f1243h;
    }

    public final String g() {
        return this.f1241f;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1239d = str;
    }

    public final void a(byte[] bArr) {
        String strEncodeToString = Base64.encodeToString(bArr, 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        this.f1238c = strEncodeToString;
    }
}
