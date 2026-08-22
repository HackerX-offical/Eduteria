package e;

import androidx.media3.exoplayer.source.MediaSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaSource.Factory f1155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1156b;

    public a(MediaSource.Factory factory, String mimeType) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        this.f1155a = factory;
        this.f1156b = mimeType;
    }

    public final MediaSource.Factory a() {
        return this.f1155a;
    }

    public final String b() {
        return this.f1156b;
    }

    public final MediaSource.Factory c() {
        return this.f1155a;
    }

    public final String d() {
        return this.f1156b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.f1155a, aVar.f1155a) && Intrinsics.areEqual(this.f1156b, aVar.f1156b);
    }

    public int hashCode() {
        return (this.f1155a.hashCode() * 31) + this.f1156b.hashCode();
    }

    public String toString() {
        return "MediaSourceInfo(factory=" + this.f1155a + ", mimeType=" + this.f1156b + ')';
    }

    public final a a(MediaSource.Factory factory, String mimeType) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        return new a(factory, mimeType);
    }

    public static /* synthetic */ a a(a aVar, MediaSource.Factory factory, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            factory = aVar.f1155a;
        }
        if ((i & 2) != 0) {
            str = aVar.f1156b;
        }
        return aVar.a(factory, str);
    }
}
