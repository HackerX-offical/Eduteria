package cz.msebera.android.httpclient;

/* JADX INFO: loaded from: classes9.dex */
public interface StatusLine {
    ProtocolVersion getProtocolVersion();

    String getReasonPhrase();

    int getStatusCode();
}
