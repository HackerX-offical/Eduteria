package org.jivesoftware.smack.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes10.dex */
public class MultiMap<K, V> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DEFAULT_MAP_SIZE = 6;
    private static final int ENTRY_LIST_SIZE = 3;
    private final Map<K, List<V>> map;

    public MultiMap() {
        this(6);
    }

    public MultiMap(int i) {
        this(new LinkedHashMap(i));
    }

    private MultiMap(Map<K, List<V>> map) {
        this.map = map;
    }

    public int size() {
        Iterator<List<V>> it = this.map.values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public boolean containsKey(K k) {
        return this.map.containsKey(k);
    }

    public boolean containsValue(V v) {
        Iterator<List<V>> it = this.map.values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(v)) {
                return true;
            }
        }
        return false;
    }

    public V getFirst(K k) {
        List<V> all = getAll(k);
        if (all.isEmpty()) {
            return null;
        }
        return all.iterator().next();
    }

    public List<V> getAll(K k) {
        List<V> list = this.map.get(k);
        return list == null ? Collections.emptyList() : list;
    }

    public boolean put(K k, final V v) {
        return putInternal(k, new Consumer() { // from class: org.jivesoftware.smack.util.MultiMap$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.util.Consumer
            public final void accept(Object obj) {
                ((List) obj).add(v);
            }
        });
    }

    public boolean putFirst(K k, final V v) {
        return putInternal(k, new Consumer() { // from class: org.jivesoftware.smack.util.MultiMap$$ExternalSyntheticLambda1
            @Override // org.jivesoftware.smack.util.Consumer
            public final void accept(Object obj) {
                ((List) obj).add(0, v);
            }
        });
    }

    private boolean putInternal(K k, Consumer<List<V>> consumer) {
        boolean z;
        List<V> arrayList = this.map.get(k);
        if (arrayList == null) {
            arrayList = new ArrayList<>(3);
            this.map.put(k, arrayList);
            z = false;
        } else {
            z = true;
        }
        consumer.accept(arrayList);
        return z;
    }

    public V remove(K k) {
        List<V> listRemove = this.map.remove(k);
        if (listRemove == null) {
            return null;
        }
        return listRemove.iterator().next();
    }

    public boolean removeOne(K k, V v) {
        List<V> list = this.map.get(k);
        if (list == null) {
            return false;
        }
        boolean zRemove = list.remove(v);
        if (list.isEmpty()) {
            this.map.remove(k);
        }
        return zRemove;
    }

    public List<V> remove(K k, int i) {
        List<V> list = this.map.get(k);
        if (list == null) {
            return Collections.emptyList();
        }
        if (list.size() <= i) {
            i = list.size();
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(list.get(0));
        }
        if (list.isEmpty()) {
            this.map.remove(k);
        }
        return arrayList;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public void clear() {
        this.map.clear();
    }

    public Set<K> keySet() {
        return this.map.keySet();
    }

    public List<V> values() {
        ArrayList arrayList = new ArrayList(size());
        Iterator<List<V>> it = this.map.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next());
        }
        return arrayList;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(size());
        for (Map.Entry<K, List<V>> entry : this.map.entrySet()) {
            K key = entry.getKey();
            Iterator<V> it = entry.getValue().iterator();
            while (it.hasNext()) {
                linkedHashSet.add(new SimpleMapEntry(key, it.next()));
            }
        }
        return linkedHashSet;
    }

    public MultiMap<K, V> asUnmodifiableMultiMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.map.size());
        for (Map.Entry<K, List<V>> entry : this.map.entrySet()) {
            linkedHashMap.put(entry.getKey(), Collections.unmodifiableList(entry.getValue()));
        }
        return new MultiMap<>(Collections.unmodifiableMap(linkedHashMap));
    }

    public MultiMap<K, V> clone() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.map.size());
        for (Map.Entry<K, List<V>> entry : this.map.entrySet()) {
            linkedHashMap.put(entry.getKey(), CollectionUtil.newListWith(entry.getValue()));
        }
        return new MultiMap<>(linkedHashMap);
    }

    private static final class SimpleMapEntry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;

        private SimpleMapEntry(K k, V v) {
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
