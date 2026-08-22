package org.pgpainless.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes10.dex */
public class MultiMap<K, V> {
    private final Map<K, Set<V>> map;

    public MultiMap() {
        this.map = new HashMap();
    }

    public MultiMap(@Nonnull MultiMap<K, V> multiMap) {
        this.map = new HashMap();
        for (K k : multiMap.map.keySet()) {
            this.map.put(k, new HashSet(multiMap.map.get(k)));
        }
    }

    public MultiMap(@Nonnull Map<K, Set<V>> map) {
        this.map = new HashMap(map);
    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public boolean containsKey(K k) {
        return this.map.containsKey(k);
    }

    public boolean containsValue(V v) {
        Iterator<Set<V>> it = this.map.values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(v)) {
                return true;
            }
        }
        return false;
    }

    public Set<V> get(K k) {
        return this.map.get(k);
    }

    public void put(K k, V v) {
        Set<V> hashSet = this.map.get(k);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.map.put(k, hashSet);
        }
        hashSet.add(v);
    }

    public void put(K k, Set<V> set) {
        Iterator<V> it = set.iterator();
        while (it.hasNext()) {
            put(k, it.next());
        }
    }

    public void removeAll(K k) {
        this.map.remove(k);
    }

    public void remove(K k, V v) {
        Set<V> set = this.map.get(k);
        if (set == null) {
            return;
        }
        set.remove(v);
    }

    public void putAll(MultiMap<K, V> multiMap) {
        for (K k : multiMap.keySet()) {
            put((Object) k, (Set) multiMap.get(k));
        }
    }

    public void clear() {
        this.map.clear();
    }

    public Set<K> keySet() {
        return this.map.keySet();
    }

    public Collection<Set<V>> values() {
        return this.map.values();
    }

    public Set<Map.Entry<K, Set<V>>> entrySet() {
        return this.map.entrySet();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof MultiMap)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.map.equals(((MultiMap) obj).map);
    }

    public int hashCode() {
        return this.map.hashCode();
    }
}
