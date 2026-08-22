package io.socket.client;

import io.socket.client.Manager;
import io.socket.client.Url;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Call;
import okhttp3.WebSocket;

/* JADX INFO: loaded from: classes9.dex */
public class IO {
    private static final Logger logger = Logger.getLogger(IO.class.getName());
    private static final ConcurrentHashMap<String, Manager> managers = new ConcurrentHashMap<>();
    public static int protocol = 5;

    public static void setDefaultOkHttpWebSocketFactory(WebSocket.Factory factory) {
        Manager.defaultWebSocketFactory = factory;
    }

    public static void setDefaultOkHttpCallFactory(Call.Factory factory) {
        Manager.defaultCallFactory = factory;
    }

    private IO() {
    }

    public static Socket socket(String str) throws URISyntaxException {
        return socket(str, (Options) null);
    }

    public static Socket socket(String str, Options options) throws URISyntaxException {
        return socket(new URI(str), options);
    }

    public static Socket socket(URI uri) {
        return socket(uri, (Options) null);
    }

    public static Socket socket(URI uri, Options options) {
        Manager manager;
        if (options == null) {
            options = new Options();
        }
        Url.ParsedURI parsedURI = Url.parse(uri);
        URI uri2 = parsedURI.uri;
        String str = parsedURI.id;
        ConcurrentHashMap<String, Manager> concurrentHashMap = managers;
        boolean z = true;
        boolean z2 = concurrentHashMap.containsKey(str) && concurrentHashMap.get(str).nsps.containsKey(uri2.getPath());
        if (!options.forceNew && options.multiplex && !z2) {
            z = false;
        }
        String query = uri2.getQuery();
        if (query != null && (options.query == null || options.query.isEmpty())) {
            options.query = query;
        }
        if (z) {
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(String.format("ignoring socket cache for %s", uri2));
            }
            manager = new Manager(uri2, options);
        } else {
            if (!concurrentHashMap.containsKey(str)) {
                Logger logger3 = logger;
                if (logger3.isLoggable(Level.FINE)) {
                    logger3.fine(String.format("new io instance for %s", uri2));
                }
                concurrentHashMap.putIfAbsent(str, new Manager(uri2, options));
            }
            manager = concurrentHashMap.get(str);
        }
        return manager.socket(uri2.getPath(), options);
    }

    public static class Options extends Manager.Options {
        public boolean forceNew;
        public boolean multiplex = true;

        public static SocketOptionBuilder builder() {
            return SocketOptionBuilder.builder();
        }
    }
}
