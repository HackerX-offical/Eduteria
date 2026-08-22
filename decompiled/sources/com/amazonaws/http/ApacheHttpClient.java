package com.amazonaws.http;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.http.HttpResponse;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.client.params.ClientPNames;
import java.io.IOException;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: classes4.dex */
public class ApacheHttpClient implements HttpClient {
    private final org.apache.http.client.HttpClient httpClient;
    private HttpParams params = null;

    public ApacheHttpClient(ClientConfiguration clientConfiguration) {
        org.apache.http.client.HttpClient httpClientCreateHttpClient = new HttpClientFactory().createHttpClient(clientConfiguration);
        this.httpClient = httpClientCreateHttpClient;
        ((AbstractHttpClient) httpClientCreateHttpClient).setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
        ((SSLSocketFactory) httpClientCreateHttpClient.getConnectionManager().getSchemeRegistry().getScheme(TournamentShareDialogURIBuilder.scheme).getSocketFactory()).setHostnameVerifier(SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    @Override // com.amazonaws.http.HttpClient
    public HttpResponse execute(HttpRequest httpRequest) throws IOException {
        org.apache.http.HttpResponse httpResponseExecute = this.httpClient.execute(createHttpRequest(httpRequest));
        HttpResponse.Builder builderContent = HttpResponse.builder().statusCode(httpResponseExecute.getStatusLine().getStatusCode()).statusText(httpResponseExecute.getStatusLine().getReasonPhrase()).content(httpResponseExecute.getEntity() != null ? httpResponseExecute.getEntity().getContent() : null);
        for (Header header : httpResponseExecute.getAllHeaders()) {
            builderContent.header(header.getName(), header.getValue());
        }
        return builderContent.build();
    }

    @Override // com.amazonaws.http.HttpClient
    public void shutdown() {
        this.httpClient.getConnectionManager().shutdown();
    }

    private HttpUriRequest createHttpRequest(HttpRequest httpRequest) {
        HttpUriRequest httpHead;
        String method = httpRequest.getMethod();
        if (HttpPost.METHOD_NAME.equals(method)) {
            org.apache.http.client.methods.HttpPost httpPost = new org.apache.http.client.methods.HttpPost(httpRequest.getUri());
            httpHead = httpPost;
            if (httpRequest.getContent() != null) {
                httpPost.setEntity(new InputStreamEntity(httpRequest.getContent(), httpRequest.getContentLength()));
                httpHead = httpPost;
            }
        } else if ("GET".equals(method)) {
            httpHead = new HttpGet(httpRequest.getUri());
        } else if ("PUT".equals(method)) {
            HttpPut httpPut = new HttpPut(httpRequest.getUri());
            httpHead = httpPut;
            if (httpRequest.getContent() != null) {
                httpPut.setEntity(new InputStreamEntity(httpRequest.getContent(), httpRequest.getContentLength()));
                httpHead = httpPut;
            }
        } else if ("DELETE".equals(method)) {
            httpHead = new HttpDelete(httpRequest.getUri());
        } else if ("HEAD".equals(method)) {
            httpHead = new HttpHead(httpRequest.getUri());
        } else {
            throw new UnsupportedOperationException("Unsupported method: " + method);
        }
        if (httpRequest.getHeaders() != null && !httpRequest.getHeaders().isEmpty()) {
            for (Map.Entry<String, String> entry : httpRequest.getHeaders().entrySet()) {
                String key = entry.getKey();
                if (!key.equals("Content-Length") && !key.equals("Host")) {
                    httpHead.addHeader(entry.getKey(), entry.getValue());
                }
            }
        }
        if (this.params == null) {
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            this.params = basicHttpParams;
            basicHttpParams.setParameter(ClientPNames.HANDLE_REDIRECTS, false);
        }
        httpHead.setParams(this.params);
        return httpHead;
    }
}
