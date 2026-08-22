package org.jxmpp.util.cache;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes10.dex */
public class ExpirationCache<K, V> implements Cache<K, V>, Map<K, V> {
    private final LruCache<K, ExpireElement<V>> cache;
    private long defaultExpirationTime;

    public ExpirationCache(int i, long j) {
        this.cache = new LruCache<>(i);
        setDefaultExpirationTime(j);
    }

    public void setDefaultExpirationTime(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException();
        }
        this.defaultExpirationTime = j;
    }

    @Override // org.jxmpp.util.cache.Cache, java.util.Map
    public V put(K k, V v) {
        return put(k, v, this.defaultExpirationTime);
    }

    public V put(K k, V v, long j) {
        ExpireElement<V> expireElementPut = this.cache.put(k, new ExpireElement<>(v, j));
        if (expireElementPut == null) {
            return null;
        }
        return (V) ((ExpireElement) expireElementPut).element;
    }

    @Override // org.jxmpp.util.cache.Cache
    public V lookup(K k) {
        return get(k);
    }

    @Override // java.util.Map
    public V get(Object obj) {
        ExpireElement<V> expireElement = this.cache.get(obj);
        if (expireElement == null) {
            return null;
        }
        if (expireElement.isExpired()) {
            remove(obj);
            return null;
        }
        return (V) ((ExpireElement) expireElement).element;
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        ExpireElement<V> expireElementRemove = this.cache.remove(obj);
        if (expireElementRemove == null) {
            return null;
        }
        return (V) ((ExpireElement) expireElementRemove).element;
    }

    @Override // org.jxmpp.util.cache.Cache
    public int getMaxCacheSize() {
        return this.cache.getMaxCacheSize();
    }

    @Override // org.jxmpp.util.cache.Cache
    public void setMaxCacheSize(int i) {
        this.cache.setMaxCacheSize(i);
    }

    private static class ExpireElement<V> {
        private final V element;
        private final long expirationTimestamp;

        private ExpireElement(V v, long j) {
            this.element = v;
            this.expirationTimestamp = System.currentTimeMillis() + j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isExpired() {
            return System.currentTimeMillis() > this.expirationTimestamp;
        }

        public int hashCode() {
            return this.element.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof ExpireElement) {
                return this.element.equals(((ExpireElement) obj).element);
            }
            return false;
        }
    }

    @Override // java.util.Map
    public int size() {
        return this.cache.size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.cache.isEmpty();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.cache.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.cache.containsValue(obj);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public void clear() {
        this.cache.clear();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return this.cache.keySet();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        HashSet hashSet = new HashSet();
        Iterator<ExpireElement<V>> it = this.cache.values().iterator();
        while (it.hasNext()) {
            hashSet.add(((ExpireElement) it.next()).element);
        }
        return hashSet;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        HashSet hashSet = new HashSet();
        for (Map.Entry<K, ExpireElement<V>> entry : this.cache.entrySet()) {
            hashSet.add(new EntryImpl(entry.getKey(), ((ExpireElement) entry.getValue()).element));
        }
        return hashSet;
    }

    private static class EntryImpl<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;

        EntryImpl(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }
    }
}
