package org.jxmpp.util.cache;

/* JADX INFO: loaded from: classes10.dex */
public interface Cache<K, V> {
    int getMaxCacheSize();

    V lookup(K k);

    V put(K k, V v);

    void setMaxCacheSize(int i);
}
