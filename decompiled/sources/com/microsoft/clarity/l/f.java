package com.microsoft.clarity.l;

import android.net.Uri;
import com.facebook.internal.AnalyticsEvents;
import com.microsoft.clarity.models.AssetType;
import com.microsoft.clarity.models.ingest.SessionEvent;
import com.microsoft.clarity.n.h;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import java.io.IOException;
import java.net.HttpURLConnection;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements b {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1068a;

        static {
            int[] iArr = new int[AssetType.values().length];
            iArr[AssetType.Image.ordinal()] = 1;
            iArr[AssetType.Typeface.ordinal()] = 2;
            iArr[AssetType.Web.ordinal()] = 3;
            iArr[AssetType.Unsupported.ordinal()] = 4;
            f1068a = iArr;
        }
    }

    public static boolean a(String path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        String string = Uri.parse("https://www.clarity.ms/").buildUpon().appendPath("api").appendPath("v1").appendPath("assets").appendPath(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB).build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "parse(BuildConfig.API_BA…)\n            .toString()");
        HttpURLConnection httpURLConnectionA = h.a(string, "HEAD", MapsKt.mapOf(TuplesKt.to("Content-Path", path)));
        try {
            try {
                httpURLConnectionA.connect();
                return h.b(httpURLConnectionA);
            } catch (Exception e2) {
                e2.printStackTrace();
                httpURLConnectionA.disconnect();
                return false;
            }
        } finally {
            httpURLConnectionA.disconnect();
        }
    }

    public static boolean a(String hash, AssetType type) throws IOException {
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(type, "type");
        HttpURLConnection httpURLConnectionA = h.a(a(type), "HEAD", MapsKt.mapOf(TuplesKt.to("Content-Hash", hash)));
        try {
            try {
                httpURLConnectionA.connect();
                return h.b(httpURLConnectionA);
            } catch (Exception e2) {
                e2.printStackTrace();
                httpURLConnectionA.disconnect();
                return false;
            }
        } finally {
            httpURLConnectionA.disconnect();
        }
    }

    @Override // com.microsoft.clarity.l.b
    public final boolean a(AssetType type, byte[] asset, String hash) throws IOException {
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(asset, "asset");
        if (a(hash, type)) {
            return true;
        }
        HttpURLConnection httpURLConnectionA = h.a(a(type), HttpPost.METHOD_NAME, MapsKt.mapOf(TuplesKt.to("Content-Hash", hash), TuplesKt.to("Content-Type", "application/octet-stream")));
        try {
            h.a(httpURLConnectionA, asset);
            httpURLConnectionA.connect();
            return h.b(httpURLConnectionA);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        } finally {
            httpURLConnectionA.disconnect();
        }
    }

    @Override // com.microsoft.clarity.l.b
    public final boolean a(SessionEvent sessionEvent, e type) {
        Intrinsics.checkNotNullParameter(sessionEvent, "sessionEvent");
        Intrinsics.checkNotNullParameter(type, "type");
        return a(sessionEvent.serialize(), type);
    }

    public static String a(AssetType assetType) {
        String str;
        Uri.Builder builderAppendPath = Uri.parse("https://www.clarity.ms/").buildUpon().appendPath("api").appendPath("v1").appendPath("assets");
        int i = a.f1068a[assetType.ordinal()];
        if (i == 1) {
            str = "image";
        } else {
            if (i != 2) {
                if (i == 3) {
                    throw new IllegalArgumentException("Web assets have their own endpoint");
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new IllegalArgumentException("Unexpected asset type");
            }
            str = "typeface";
        }
        String string = builderAppendPath.appendPath(str).build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "parse(BuildConfig.API_BA…)\n            .toString()");
        return string;
    }

    @Override // com.microsoft.clarity.l.b
    public final boolean a(String serializedEvent, e type) throws IOException {
        Intrinsics.checkNotNullParameter(serializedEvent, "serializedEvent");
        Intrinsics.checkNotNullParameter(type, "type");
        String string = Uri.parse("https://www.clarity.ms/").buildUpon().appendPath("api").appendPath("v1").appendPath((type == e.Playback ? "playback" : "analytics").concat("-events")).build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "parse(BuildConfig.API_BA…)\n            .toString()");
        HttpURLConnection httpURLConnectionA = h.a(string, HttpPost.METHOD_NAME, MapsKt.mapOf(TuplesKt.to("Content-Type", "application/json")));
        try {
            try {
                h.a(httpURLConnectionA, serializedEvent);
                httpURLConnectionA.connect();
                return h.b(httpURLConnectionA);
            } catch (Exception e2) {
                e2.printStackTrace();
                httpURLConnectionA.disconnect();
                return false;
            }
        } finally {
            httpURLConnectionA.disconnect();
        }
    }

    @Override // com.microsoft.clarity.l.b
    public final boolean a(String path, byte[] content) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(content, "content");
        if (a(path)) {
            return true;
        }
        String string = Uri.parse("https://www.clarity.ms/").buildUpon().appendPath("api").appendPath("v1").appendPath("assets").appendPath(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB).build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "parse(BuildConfig.API_BA…)\n            .toString()");
        HttpURLConnection httpURLConnectionA = h.a(string, HttpPost.METHOD_NAME, MapsKt.mapOf(TuplesKt.to("Content-Path", path), TuplesKt.to("Content-Type", "application/octet-stream")));
        try {
            h.a(httpURLConnectionA, content);
            httpURLConnectionA.connect();
            return h.b(httpURLConnectionA);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        } finally {
            httpURLConnectionA.disconnect();
        }
    }
}
