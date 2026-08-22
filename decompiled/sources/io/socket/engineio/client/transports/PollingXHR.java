package io.socket.engineio.client.transports;

import cz.msebera.android.httpclient.client.methods.HttpPost;
import io.socket.emitter.Emitter;
import io.socket.engineio.client.Transport;
import io.socket.thread.EventThread;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes9.dex */
public class PollingXHR extends Polling {
    private static boolean LOGGABLE_FINE;
    private static final Logger logger;

    static {
        Logger logger2 = Logger.getLogger(PollingXHR.class.getName());
        logger = logger2;
        LOGGABLE_FINE = logger2.isLoggable(Level.FINE);
    }

    public PollingXHR(Transport.Options options) {
        super(options);
    }

    protected Request request() {
        return request(null);
    }

    protected Request request(Request.Options options) {
        if (options == null) {
            options = new Request.Options();
        }
        options.uri = uri();
        options.callFactory = this.callFactory;
        options.extraHeaders = this.extraHeaders;
        Request request = new Request(options);
        request.on("requestHeaders", new Emitter.Listener() { // from class: io.socket.engineio.client.transports.PollingXHR.2
            @Override // io.socket.emitter.Emitter.Listener
            public void call(Object... objArr) {
                this.emit("requestHeaders", objArr[0]);
            }
        }).on("responseHeaders", new Emitter.Listener() { // from class: io.socket.engineio.client.transports.PollingXHR.1
            @Override // io.socket.emitter.Emitter.Listener
            public void call(final Object... objArr) {
                EventThread.exec(new Runnable() { // from class: io.socket.engineio.client.transports.PollingXHR.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        this.emit("responseHeaders", objArr[0]);
                    }
                });
            }
        });
        return request;
    }

    @Override // io.socket.engineio.client.transports.Polling
    protected void doWrite(String str, final Runnable runnable) {
        Request.Options options = new Request.Options();
        options.method = HttpPost.METHOD_NAME;
        options.data = str;
        options.extraHeaders = this.extraHeaders;
        Request request = request(options);
        request.on("success", new Emitter.Listener() { // from class: io.socket.engineio.client.transports.PollingXHR.3
            @Override // io.socket.emitter.Emitter.Listener
            public void call(Object... objArr) {
                EventThread.exec(new Runnable() { // from class: io.socket.engineio.client.transports.PollingXHR.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        runnable.run();
                    }
                });
            }
        });
        request.on("error", new Emitter.Listener() { // from class: io.socket.engineio.client.transports.PollingXHR.4
            @Override // io.socket.emitter.Emitter.Listener
            public void call(final Object... objArr) {
                EventThread.exec(new Runnable() { // from class: io.socket.engineio.client.transports.PollingXHR.4.1
                    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public void run() {
                        /*
                            r3 = this;
                            java.lang.Object[] r0 = r2
                            int r1 = r0.length
                            if (r1 <= 0) goto Lf
                            r1 = 0
                            r0 = r0[r1]
                            boolean r1 = r0 instanceof java.lang.Exception
                            if (r1 == 0) goto Lf
                            java.lang.Exception r0 = (java.lang.Exception) r0
                            goto L10
                        Lf:
                            r0 = 0
                        L10:
                            io.socket.engineio.client.transports.PollingXHR$4 r1 = io.socket.engineio.client.transports.PollingXHR.AnonymousClass4.this
                            io.socket.engineio.client.transports.PollingXHR r1 = r2
                            java.lang.String r2 = "xhr post error"
                            io.socket.engineio.client.transports.PollingXHR.access$000(r1, r2, r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: io.socket.engineio.client.transports.PollingXHR.AnonymousClass4.AnonymousClass1.run():void");
                    }
                });
            }
        });
        request.create();
    }

    @Override // io.socket.engineio.client.transports.Polling
    protected void doPoll() {
        logger.fine("xhr poll");
        Request request = request();
        request.on("data", new Emitter.Listener() { // from class: io.socket.engineio.client.transports.PollingXHR.5
            @Override // io.socket.emitter.Emitter.Listener
            public void call(final Object... objArr) {
                EventThread.exec(new Runnable() { // from class: io.socket.engineio.client.transports.PollingXHR.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Object[] objArr2 = objArr;
                        this.onData((String) (objArr2.length > 0 ? objArr2[0] : null));
                    }
                });
            }
        });
        request.on("error", new Emitter.Listener() { // from class: io.socket.engineio.client.transports.PollingXHR.6
            @Override // io.socket.emitter.Emitter.Listener
            public void call(final Object... objArr) {
                EventThread.exec(new Runnable() { // from class: io.socket.engineio.client.transports.PollingXHR.6.1
                    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public void run() {
                        /*
                            r3 = this;
                            java.lang.Object[] r0 = r2
                            int r1 = r0.length
                            if (r1 <= 0) goto Lf
                            r1 = 0
                            r0 = r0[r1]
                            boolean r1 = r0 instanceof java.lang.Exception
                            if (r1 == 0) goto Lf
                            java.lang.Exception r0 = (java.lang.Exception) r0
                            goto L10
                        Lf:
                            r0 = 0
                        L10:
                            io.socket.engineio.client.transports.PollingXHR$6 r1 = io.socket.engineio.client.transports.PollingXHR.AnonymousClass6.this
                            io.socket.engineio.client.transports.PollingXHR r1 = r2
                            java.lang.String r2 = "xhr poll error"
                            io.socket.engineio.client.transports.PollingXHR.access$100(r1, r2, r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: io.socket.engineio.client.transports.PollingXHR.AnonymousClass6.AnonymousClass1.run():void");
                    }
                });
            }
        });
        request.create();
    }

    public static class Request extends Emitter {
        public static final String EVENT_DATA = "data";
        public static final String EVENT_ERROR = "error";
        public static final String EVENT_REQUEST_HEADERS = "requestHeaders";
        public static final String EVENT_RESPONSE_HEADERS = "responseHeaders";
        public static final String EVENT_SUCCESS = "success";
        private static final String TEXT_CONTENT_TYPE = "text/plain;charset=UTF-8";
        private static final MediaType TEXT_MEDIA_TYPE = MediaType.parse(TEXT_CONTENT_TYPE);
        private Call.Factory callFactory;
        private String data;
        private Map<String, List<String>> extraHeaders;
        private String method;
        private Call requestCall;
        private Response response;
        private String uri;

        public static class Options {
            public Call.Factory callFactory;
            public String data;
            public Map<String, List<String>> extraHeaders;
            public String method;
            public String uri;
        }

        public Request(Options options) {
            this.method = options.method != null ? options.method : "GET";
            this.uri = options.uri;
            this.data = options.data;
            this.callFactory = options.callFactory != null ? options.callFactory : new OkHttpClient();
            this.extraHeaders = options.extraHeaders;
        }

        public void create() {
            if (PollingXHR.LOGGABLE_FINE) {
                PollingXHR.logger.fine(String.format("xhr open %s: %s", this.method, this.uri));
            }
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            Map<String, List<String>> map = this.extraHeaders;
            if (map != null) {
                treeMap.putAll(map);
            }
            if (HttpPost.METHOD_NAME.equals(this.method)) {
                treeMap.put("Content-type", new LinkedList(Collections.singletonList(TEXT_CONTENT_TYPE)));
            }
            treeMap.put("Accept", new LinkedList(Collections.singletonList("*/*")));
            onRequestHeaders(treeMap);
            if (PollingXHR.LOGGABLE_FINE) {
                PollingXHR.logger.fine(String.format("sending xhr with url %s | data %s", this.uri, this.data));
            }
            Request.Builder builder = new Request.Builder();
            for (Map.Entry<String, List<String>> entry : treeMap.entrySet()) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    builder.addHeader(entry.getKey(), it.next());
                }
            }
            String str = this.data;
            Call callNewCall = this.callFactory.newCall(builder.url(HttpUrl.parse(this.uri)).method(this.method, str != null ? RequestBody.create(TEXT_MEDIA_TYPE, str) : null).build());
            this.requestCall = callNewCall;
            callNewCall.enqueue(new Callback() { // from class: io.socket.engineio.client.transports.PollingXHR.Request.1
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    this.onError(iOException);
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    this.response = response;
                    this.onResponseHeaders(response.headers().toMultimap());
                    try {
                        if (response.isSuccessful()) {
                            this.onLoad();
                        } else {
                            this.onError(new IOException(Integer.toString(response.code())));
                        }
                    } finally {
                        response.close();
                    }
                }
            });
        }

        private void onSuccess() {
            emit("success", new Object[0]);
        }

        private void onData(String str) {
            emit("data", str);
            onSuccess();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onError(Exception exc) {
            emit("error", exc);
        }

        private void onRequestHeaders(Map<String, List<String>> map) {
            emit("requestHeaders", map);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onResponseHeaders(Map<String, List<String>> map) {
            emit("responseHeaders", map);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onLoad() {
            try {
                onData(this.response.body().string());
            } catch (IOException e2) {
                onError(e2);
            }
        }
    }
}
