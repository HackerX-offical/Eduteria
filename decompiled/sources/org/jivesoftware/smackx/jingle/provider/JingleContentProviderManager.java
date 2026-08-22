package org.jivesoftware.smackx.jingle.provider;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes10.dex */
public class JingleContentProviderManager {
    private static final Map<String, JingleContentDescriptionProvider<?>> jingleContentDescriptionProviders = new ConcurrentHashMap();
    private static final Map<String, JingleContentTransportProvider<?>> jingleContentTransportProviders = new ConcurrentHashMap();

    public static JingleContentDescriptionProvider<?> addJingleContentDescriptionProvider(String str, JingleContentDescriptionProvider<?> jingleContentDescriptionProvider) {
        return jingleContentDescriptionProviders.put(str, jingleContentDescriptionProvider);
    }

    public static JingleContentDescriptionProvider<?> getJingleContentDescriptionProvider(String str) {
        return jingleContentDescriptionProviders.get(str);
    }

    public static JingleContentTransportProvider<?> addJingleContentTransportProvider(String str, JingleContentTransportProvider<?> jingleContentTransportProvider) {
        return jingleContentTransportProviders.put(str, jingleContentTransportProvider);
    }

    public static JingleContentTransportProvider<?> getJingleContentTransportProvider(String str) {
        return jingleContentTransportProviders.get(str);
    }
}
