package com.amazonaws.http.impl.client;

import com.amazonaws.http.conn.ClientConnectionManagerFactory;
import com.amazonaws.http.protocol.SdkHttpRequestExecutor;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpRequestExecutor;

/* JADX INFO: loaded from: classes4.dex */
public class SdkHttpClient extends DefaultHttpClient {
    public SdkHttpClient(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        super(ClientConnectionManagerFactory.wrap(clientConnectionManager), httpParams);
    }

    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    protected HttpRequestExecutor createRequestExecutor() {
        return new SdkHttpRequestExecutor();
    }
}
