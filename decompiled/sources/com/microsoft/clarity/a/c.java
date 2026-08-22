package com.microsoft.clarity.a;

import com.microsoft.clarity.models.PageMetadata;
import com.microsoft.clarity.models.SessionMetadata;
import com.microsoft.clarity.models.display.blobs.TextBlob;
import com.microsoft.clarity.models.display.images.Image;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Image f682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TextBlob f683b;

    public static final class a {
        public static Image a() {
            return c.f682a;
        }

        public static TextBlob b() {
            return c.f683b;
        }
    }

    static {
        new PageMetadata(new SessionMetadata("DUMMY", "DUMMY", "DUMMY", "DUMMY", 0L, 1, false, "https://www.clarity.ms/eus2/"), 0);
        f682a = new Image(null, new byte[0], null, null);
        f683b = new TextBlob(null, CollectionsKt.emptyList());
    }
}
