package com.x5.template;

import com.x5.util.TableData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes9.dex */
public class ObjectTable implements TableData, Map<String, Object> {
    public static final String KEY = "key";
    private static final String[] LABELS = {"key", "value"};
    public static final String VALUE = "value";
    private Map obj;
    private Iterator i = null;
    private Object currentKey = null;

    @Override // java.util.Map
    public void clear() {
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return null;
    }

    @Override // java.util.Map
    public Object put(String str, Object obj) {
        return null;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return null;
    }

    @Override // com.x5.util.TableData
    public void setColumnLabels(String[] strArr) {
    }

    public ObjectTable(Map map) {
        this.obj = map;
    }

    @Override // com.x5.util.TableData
    public String[] getColumnLabels() {
        return LABELS;
    }

    @Override // com.x5.util.TableData
    public String[] getRow() {
        Object obj = this.currentKey;
        if (obj == null) {
            return null;
        }
        return new String[]{obj.toString(), this.obj.get(this.currentKey).toString()};
    }

    @Override // com.x5.util.TableData
    public boolean hasNext() {
        if (this.obj == null) {
            return false;
        }
        if (this.i == null) {
            this.i = getOrderedKeys().iterator();
        }
        return this.i.hasNext();
    }

    @Override // com.x5.util.TableData
    public Map<String, Object> nextRecord() {
        if (hasNext()) {
            this.currentKey = this.i.next();
            return this;
        }
        this.currentKey = null;
        return null;
    }

    private List getOrderedKeys() {
        ArrayList arrayList = new ArrayList(this.obj.keySet());
        Map map = this.obj;
        if (!(map instanceof LinkedHashMap) && !(map instanceof SortedMap)) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    @Override // com.x5.util.TableData
    public void reset() {
        this.i = getOrderedKeys().iterator();
    }

    @Override // java.util.Map
    public int size() {
        if (hasNext()) {
            return LABELS.length;
        }
        return 0;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.currentKey == null;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        if (obj != null) {
            String[] strArr = LABELS;
            if (obj.equals(strArr[0]) || obj.equals(strArr[1])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return obj != null && obj.equals(this.obj.get(this.currentKey));
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        if (obj != null && this.currentKey != null) {
            if (obj.equals("key")) {
                return this.currentKey;
            }
            if (obj.equals("value")) {
                return this.obj.get(this.currentKey);
            }
        }
        return null;
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        HashSet hashSet = new HashSet();
        hashSet.add("key");
        hashSet.add("value");
        return hashSet;
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        if (this.currentKey == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(this.obj.get(this.currentKey));
        return hashSet;
    }
}
