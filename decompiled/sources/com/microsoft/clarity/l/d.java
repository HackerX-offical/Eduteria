package com.microsoft.clarity.l;

import android.content.Context;
import android.net.Uri;
import android.os.Trace;
import com.appnew.android.Utils.Const;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.microsoft.clarity.e.e;
import com.microsoft.clarity.models.AssetType;
import com.microsoft.clarity.models.SessionMetadata;
import com.microsoft.clarity.models.ingest.AssetCheck;
import com.microsoft.clarity.models.ingest.AssetMetadata;
import com.microsoft.clarity.models.ingest.CollectRequest;
import com.microsoft.clarity.models.ingest.Envelope;
import com.microsoft.clarity.models.ingest.IngestConfigs;
import com.microsoft.clarity.models.ingest.SerializedSessionPayload;
import com.microsoft.clarity.models.telemetry.AggregatedMetric;
import com.microsoft.clarity.n.h;
import com.microsoft.clarity.n.i;
import com.microsoft.clarity.n.k;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.microsoft.clarity.m.a f1063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f1064c;

    public d(Context context, com.microsoft.clarity.m.a faultyCollectRequestsStore, c telemetryService) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(faultyCollectRequestsStore, "faultyCollectRequestsStore");
        Intrinsics.checkNotNullParameter(telemetryService, "telemetryService");
        this.f1062a = context;
        this.f1063b = faultyCollectRequestsStore;
        this.f1064c = telemetryService;
    }

    public static String a(String str, double d2) {
        e.a aVar = new e.a(str);
        aVar.a(d2);
        List listListOf = CollectionsKt.listOf(new AggregatedMetric("1.3.3", aVar.d(), aVar.a(), aVar.f(), aVar.c(), aVar.b(), aVar.e(), 0, 128, null));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            arrayList.add(((AggregatedMetric) it.next()).toJsonObject());
        }
        String string = new JSONArray((Collection) arrayList).toString();
        Intrinsics.checkNotNullExpressionValue(string, "JSONArray(aggregatedMetr…sonObject() }).toString()");
        return string;
    }

    @Override // com.microsoft.clarity.l.a
    public final Map a(String ingestUrl, String projectId, ArrayList assets) throws IOException {
        Intrinsics.checkNotNullParameter(ingestUrl, "ingestUrl");
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        Intrinsics.checkNotNullParameter(assets, "assets");
        if (assets.isEmpty()) {
            return MapsKt.emptyMap();
        }
        String string = Uri.parse(ingestUrl).buildUpon().appendPath(projectId).appendPath("check-asset").build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "parse(ingestUrl)\n       …)\n            .toString()");
        HttpURLConnection httpURLConnectionA = h.a(string, HttpPost.METHOD_NAME, MapsKt.mapOf(TuplesKt.to("Content-Type", "application/json")));
        try {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(assets, 10));
            Iterator it = assets.iterator();
            while (it.hasNext()) {
                arrayList.add(((AssetCheck) it.next()).toJsonObject());
            }
            String string2 = new JSONArray((Collection) arrayList).toString();
            Intrinsics.checkNotNullExpressionValue(string2, "JSONArray(assets.map { i…sonObject() }).toString()");
            byte[] bytes = string2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            long length = bytes.length;
            h.a(httpURLConnectionA, bytes);
            httpURLConnectionA.connect();
            String strA = h.a(httpURLConnectionA);
            long length2 = length + ((long) strA.length());
            if (h.b(httpURLConnectionA)) {
                double d2 = length2;
                try {
                    Trace.setCounter("Clarity_CheckAssetBytes", (long) d2);
                    this.f1064c.a(projectId, a("Clarity_CheckAssetBytes", d2));
                } catch (Exception unused) {
                }
            }
            return k.a(new JSONObject(strA));
        } finally {
            httpURLConnectionA.disconnect();
        }
    }

    @Override // com.microsoft.clarity.l.a
    public final IngestConfigs a(String projectId) throws IOException {
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        String string = Uri.parse("https://www.clarity.ms/").buildUpon().appendPath("tag").appendPath(Const.MOBILE).appendPath(projectId).build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "parse(BuildConfig.API_BA…)\n            .toString()");
        HttpURLConnection httpURLConnectionA = h.a(string, "GET", MapsKt.emptyMap());
        try {
            httpURLConnectionA.connect();
            String strA = h.a(httpURLConnectionA);
            if (h.b(httpURLConnectionA)) {
                double length = strA.length();
                try {
                    Trace.setCounter("Clarity_TagBytes", (long) length);
                    this.f1064c.a(projectId, a("Clarity_TagBytes", length));
                } catch (Exception unused) {
                }
            }
            IngestConfigs ingestConfigsFromJson = IngestConfigs.fromJson(strA);
            Intrinsics.checkNotNullExpressionValue(ingestConfigsFromJson, "fromJson(responseData)");
            return ingestConfigsFromJson;
        } finally {
            httpURLConnectionA.disconnect();
        }
    }

    public final void a(String str, SessionMetadata sessionMetadata) {
        String str2 = sessionMetadata.getSessionId() + '_' + System.currentTimeMillis() + ".json";
        i.c(com.microsoft.clarity.a.b.a("Bad collect request for session ").append(sessionMetadata.getSessionId()).append(". Saved at ").append(str2).append('.').toString());
        this.f1063b.a(str2, str, com.microsoft.clarity.m.c.OVERWRITE);
    }

    @Override // com.microsoft.clarity.l.a
    public final boolean a(SessionMetadata sessionMetadata, String hash, byte[] asset, AssetMetadata assetMetadata) throws IOException {
        Intrinsics.checkNotNullParameter(sessionMetadata, "sessionMetadata");
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(assetMetadata, "assetMetadata");
        Uri.Builder builderAppendPath = Uri.parse(sessionMetadata.getIngestUrl()).buildUpon().appendPath(sessionMetadata.getProjectId()).appendPath("upload-asset").appendPath(hash).appendPath(String.valueOf(assetMetadata.getAssetType().ordinal()));
        if (assetMetadata.getAssetType() == AssetType.Image) {
            builderAppendPath.appendQueryParameter(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, String.valueOf(assetMetadata.getWidth())).appendQueryParameter(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, String.valueOf(assetMetadata.getHeight()));
        }
        String string = builderAppendPath.build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "uri\n            .build()\n            .toString()");
        HttpURLConnection httpURLConnectionA = h.a(string, HttpPost.METHOD_NAME, MapsKt.mapOf(TuplesKt.to("Content-Type", "application/octet-stream"), TuplesKt.to("Content-Hash", hash)));
        try {
            h.a(httpURLConnectionA, asset);
            httpURLConnectionA.connect();
            boolean zB = h.b(httpURLConnectionA);
            if (zB) {
                String projectId = sessionMetadata.getProjectId();
                double length = asset.length;
                try {
                    Trace.setCounter("Clarity_UploadAssetBytes", (long) length);
                    this.f1064c.a(projectId, a("Clarity_UploadAssetBytes", length));
                } catch (Exception unused) {
                }
            }
            return zB;
        } finally {
            httpURLConnectionA.disconnect();
        }
    }

    @Override // com.microsoft.clarity.l.a
    public final boolean a(SerializedSessionPayload serializedSessionPayload, SessionMetadata sessionMetadata) throws IOException {
        Intrinsics.checkNotNullParameter(serializedSessionPayload, "serializedSessionPayload");
        Intrinsics.checkNotNullParameter(sessionMetadata, "sessionMetadata");
        String string = Uri.parse(sessionMetadata.getIngestUrl()).buildUpon().appendPath("collect").build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "parse(ingestUrl)\n       …)\n            .toString()");
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("Content-Type", "application/json"));
        mapMutableMapOf.put("Accept", "application/x-clarity-gzip");
        mapMutableMapOf.put("Accept-Encoding", "gzip, deflate, br");
        String packageName = this.f1062a.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        mapMutableMapOf.put("ApplicationPackage", packageName);
        HttpURLConnection httpURLConnectionA = h.a(string, HttpPost.METHOD_NAME, mapMutableMapOf);
        try {
            String strSerialize = new CollectRequest(new Envelope(sessionMetadata, serializedSessionPayload.getPageNum(), serializedSessionPayload.getSequence(), serializedSessionPayload.getStart(), serializedSessionPayload.getDuration()), serializedSessionPayload.getEvents(), serializedSessionPayload.getFrames()).serialize();
            byte[] bArrA = com.microsoft.clarity.n.b.a(strSerialize);
            h.a(httpURLConnectionA, bArrA);
            httpURLConnectionA.connect();
            boolean zB = h.b(httpURLConnectionA);
            if (zB) {
                String projectId = sessionMetadata.getProjectId();
                double length = bArrA.length;
                try {
                    Trace.setCounter("Clarity_UploadSessionSegmentBytes", (long) length);
                    this.f1064c.a(projectId, a("Clarity_UploadSessionSegmentBytes", length));
                } catch (Exception unused) {
                }
            } else {
                a(strSerialize, sessionMetadata);
            }
            return zB;
        } finally {
            httpURLConnectionA.disconnect();
        }
    }

    @Override // com.microsoft.clarity.l.a
    public final boolean a(String ingestUrl, String projectId, String path, byte[] asset) throws IOException {
        Intrinsics.checkNotNullParameter(ingestUrl, "ingestUrl");
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        Intrinsics.checkNotNullParameter("all", "version");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(asset, "asset");
        String string = Uri.parse(ingestUrl).buildUpon().appendPath(projectId).appendPath("upload-web-asset").appendPath("all").build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "parse(ingestUrl)\n       …)\n            .toString()");
        HttpURLConnection httpURLConnectionA = h.a(string, HttpPost.METHOD_NAME, MapsKt.mapOf(TuplesKt.to("Content-Type", "application/octet-stream"), TuplesKt.to("Content-Path", path)));
        try {
            h.a(httpURLConnectionA, asset);
            httpURLConnectionA.connect();
            boolean zB = h.b(httpURLConnectionA);
            if (zB) {
                double length = asset.length;
                try {
                    Trace.setCounter("Clarity_UploadWebAssetBytes", (long) length);
                    this.f1064c.a(projectId, a("Clarity_UploadWebAssetBytes", length));
                } catch (Exception unused) {
                }
            }
            return zB;
        } finally {
            httpURLConnectionA.disconnect();
        }
    }
}
