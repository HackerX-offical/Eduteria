package com.microsoft.clarity.n;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class h {
    public static HttpURLConnection a(String url, String requestMethod, Map requestProperties) throws IOException {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(requestMethod, "requestMethod");
        Intrinsics.checkNotNullParameter(requestProperties, "requestProperties");
        URLConnection uRLConnectionOpenConnection = new URL(url).openConnection();
        if (uRLConnectionOpenConnection == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setRequestMethod(requestMethod);
        for (Map.Entry entry : requestProperties.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        i.b(com.microsoft.clarity.a.b.a("--> ").append(httpURLConnection.getRequestMethod()).append(' ').append(httpURLConnection.getURL()).append('.').toString());
        return httpURLConnection;
    }

    public static void a(HttpURLConnection urlConnection, String serializedRequestData) throws IOException {
        Intrinsics.checkNotNullParameter(urlConnection, "urlConnection");
        Intrinsics.checkNotNullParameter(serializedRequestData, "serializedRequestData");
        i.b("--> " + urlConnection.getURL() + ": " + serializedRequestData + '.');
        byte[] bytes = serializedRequestData.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        a(urlConnection, bytes);
    }

    public static void a(HttpURLConnection urlConnection, byte[] requestData) throws IOException {
        Intrinsics.checkNotNullParameter(urlConnection, "urlConnection");
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        urlConnection.setDoOutput(true);
        urlConnection.setFixedLengthStreamingMode(requestData.length);
        OutputStream outputStream = urlConnection.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "urlConnection.outputStream");
        BufferedOutputStream bufferedOutputStream = outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, 8192);
        try {
            bufferedOutputStream.write(requestData);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedOutputStream, null);
        } finally {
        }
    }

    public static boolean b(HttpURLConnection urlConnection) throws IOException {
        String strSubstringBefore$default;
        Intrinsics.checkNotNullParameter(urlConnection, "urlConnection");
        int responseCode = urlConnection.getResponseCode();
        boolean z = 200 <= responseCode && responseCode < 300;
        String string = com.microsoft.clarity.a.b.a("<-- ").append(urlConnection.getURL()).append(": ").append(urlConnection.getResponseCode()).append(' ').append(urlConnection.getResponseMessage()).append('.').toString();
        if (!z) {
            StringBuilder sbAppend = new StringBuilder().append(string).append(' ');
            InputStream errorStream = urlConnection.getErrorStream();
            if (errorStream != null) {
                Reader inputStreamReader = new InputStreamReader(errorStream, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    strSubstringBefore$default = StringsKt.substringBefore$default(StringsKt.substringAfter$default(TextStreamsKt.readText(bufferedReader), "\"detail\":\"", (String) null, 2, (Object) null), "\"", (String) null, 2, (Object) null);
                    CloseableKt.closeFinally(bufferedReader, null);
                } finally {
                }
            } else {
                strSubstringBefore$default = "";
            }
            string = sbAppend.append(strSubstringBefore$default).toString();
        }
        i.b(string);
        return z;
    }

    public static String a(HttpURLConnection urlConnection) throws com.microsoft.clarity.c.c, IOException {
        Intrinsics.checkNotNullParameter(urlConnection, "urlConnection");
        if (!b(urlConnection)) {
            throw new com.microsoft.clarity.c.c(com.microsoft.clarity.a.b.a("Unsuccessful request: ").append(urlConnection.getResponseMessage()).toString());
        }
        InputStream inputStream = urlConnection.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "urlConnection.inputStream");
        Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            String text = TextStreamsKt.readText(bufferedReader);
            i.b("<-- " + urlConnection.getURL() + ": " + text + '.');
            CloseableKt.closeFinally(bufferedReader, null);
            return text;
        } finally {
        }
    }
}
