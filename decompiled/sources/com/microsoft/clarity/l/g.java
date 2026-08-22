package com.microsoft.clarity.l;

import android.content.Context;
import com.microsoft.clarity.models.DynamicConfig;
import com.microsoft.clarity.models.PageMetadata;
import com.microsoft.clarity.models.telemetry.ErrorDetails;
import com.microsoft.clarity.models.telemetry.ErrorReport;
import com.microsoft.clarity.n.h;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1070b;

    public g(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f1069a = context;
        this.f1070b = a();
    }

    public final String a() {
        return DynamicConfig.INSTANCE.isFetched(this.f1069a) ? new DynamicConfig(this.f1069a).getReportUrl() : "https://www.clarity.ms/";
    }

    @Override // com.microsoft.clarity.l.c
    public final boolean a(ErrorDetails errorDetails, PageMetadata pageMetadata) throws IOException {
        Intrinsics.checkNotNullParameter(errorDetails, "errorDetails");
        ErrorReport errorReport = new ErrorReport(pageMetadata.getSessionMetadata().getVersion(), pageMetadata.getSessionMetadata().getProjectId(), pageMetadata.getSessionMetadata().getUserId(), pageMetadata.getSessionMetadata().getSessionId(), pageMetadata.getPageNum(), errorDetails.getErrorType().name(), errorDetails.getMessage(), errorDetails.getStackTrace(), errorDetails.getTimestamp(), 0, 512, null);
        HttpURLConnection httpURLConnectionA = h.a(this.f1070b, HttpPost.METHOD_NAME, MapsKt.emptyMap());
        h.a(httpURLConnectionA, errorReport.toJson());
        return h.b(httpURLConnectionA);
    }

    @Override // com.microsoft.clarity.l.c
    public final boolean a(String projectId, String metric) throws IOException {
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        Intrinsics.checkNotNullParameter(metric, "metric");
        URL url = new URL(this.f1070b);
        HttpURLConnection httpURLConnectionA = h.a(url.getProtocol() + "://" + url.getHost() + '/' + StringsKt.replace$default("report/project/{pid}/metrics", "{pid}", projectId, false, 4, (Object) null), HttpPost.METHOD_NAME, MapsKt.emptyMap());
        h.a(httpURLConnectionA, metric);
        return h.b(httpURLConnectionA);
    }
}
