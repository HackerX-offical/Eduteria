package com.clevertap.android.sdk.network.http;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;

/* JADX INFO: compiled from: Response.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001c\u001a\u00020\bJ\b\u0010\u001d\u001a\u0004\u0018\u00010\bJ\b\u0010\u001e\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/clevertap/android/sdk/network/http/Response;", "Ljava/io/Closeable;", "request", "Lcom/clevertap/android/sdk/network/http/Request;", "code", "", HeadersExtension.ELEMENT, "", "", "", "bodyStream", "Ljava/io/InputStream;", "closeDelegate", "Lkotlin/Function0;", "", "<init>", "(Lcom/clevertap/android/sdk/network/http/Request;ILjava/util/Map;Ljava/io/InputStream;Lkotlin/jvm/functions/Function0;)V", "getRequest", "()Lcom/clevertap/android/sdk/network/http/Request;", "getCode", "()I", "getHeaders", "()Ljava/util/Map;", "bodyReader", "Ljava/io/Reader;", "isSuccess", "", "getHeaderValue", "header", "readBody", "close", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Response implements Closeable {
    private final Reader bodyReader;
    private final Function0<Unit> closeDelegate;
    private final int code;
    private final Map<String, List<String>> headers;
    private final Request request;

    /* JADX WARN: Multi-variable type inference failed */
    public Response(Request request, int i, Map<String, ? extends List<String>> headers, InputStream inputStream, Function0<Unit> closeDelegate) {
        BufferedReader bufferedReader;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(closeDelegate, "closeDelegate");
        this.request = request;
        this.code = i;
        this.headers = headers;
        this.closeDelegate = closeDelegate;
        if (inputStream != null) {
            Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        } else {
            bufferedReader = null;
        }
        this.bodyReader = bufferedReader;
    }

    public final Request getRequest() {
        return this.request;
    }

    public final int getCode() {
        return this.code;
    }

    public final Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public final boolean isSuccess() {
        return this.code == 200;
    }

    public final String getHeaderValue(String header) {
        Intrinsics.checkNotNullParameter(header, "header");
        List<String> list = this.headers.get(header);
        if (list != null) {
            return (String) CollectionsKt.lastOrNull((List) list);
        }
        return null;
    }

    public final String readBody() {
        Reader reader = this.bodyReader;
        if (reader != null) {
            return TextStreamsKt.readText(reader);
        }
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Reader reader = this.bodyReader;
        if (reader != null) {
            reader.close();
        }
        this.closeDelegate.invoke();
    }
}
