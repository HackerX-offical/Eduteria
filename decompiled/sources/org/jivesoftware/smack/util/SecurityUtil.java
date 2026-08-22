package org.jivesoftware.smack.util;

import java.lang.reflect.InvocationTargetException;
import java.security.Provider;
import java.security.Security;
import org.jxmpp.util.cache.LruCache;

/* JADX INFO: loaded from: classes10.dex */
public class SecurityUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final LruCache<Class<? extends Provider>, Void> INSERTED_PROVIDERS_CACHE = new LruCache<>(8);

    public static void ensureProviderAtFirstPosition(Class<? extends Provider> cls) {
        LruCache<Class<? extends Provider>, Void> lruCache = INSERTED_PROVIDERS_CACHE;
        if (lruCache.containsKey(cls)) {
            return;
        }
        try {
            Provider providerNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            String name = providerNewInstance.getName();
            synchronized (Security.class) {
                Security.removeProvider(name);
                Security.insertProviderAt(providerNewInstance, 1);
            }
            lruCache.put(cls, null);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
