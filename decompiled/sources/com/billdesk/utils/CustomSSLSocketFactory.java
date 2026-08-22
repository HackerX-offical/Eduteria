package com.billdesk.utils;

import java.net.Socket;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes6.dex */
public class CustomSSLSocketFactory extends SSLSocketFactory {
    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() {
        throw null;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        throw null;
    }
}
