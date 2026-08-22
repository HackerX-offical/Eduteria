package com.clevertap.android.sdk.network.http;

import android.net.Uri;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;

/* JADX INFO: compiled from: Request.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/clevertap/android/sdk/network/http/Request;", "", "url", "Landroid/net/Uri;", HeadersExtension.ELEMENT, "", "", "body", "<init>", "(Landroid/net/Uri;Ljava/util/Map;Ljava/lang/String;)V", "getUrl", "()Landroid/net/Uri;", "getHeaders", "()Ljava/util/Map;", "getBody", "()Ljava/lang/String;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Request {
    private final String body;
    private final Map<String, String> headers;
    private final Uri url;

    public Request(Uri url, Map<String, String> headers, String str) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.url = url;
        this.headers = headers;
        this.body = str;
    }

    public final Uri getUrl() {
        return this.url;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final String getBody() {
        return this.body;
    }
}
