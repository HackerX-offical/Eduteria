package com.google.firebase.storage.network.connection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class HttpURLConnectionFactoryImpl implements HttpURLConnectionFactory {
    @Override // com.google.firebase.storage.network.connection.HttpURLConnectionFactory
    public HttpURLConnection createInstance(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }
}
