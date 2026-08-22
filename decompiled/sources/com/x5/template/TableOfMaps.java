package com.x5.template;

import com.x5.util.ObjectDataMap;
import com.x5.util.TableData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class TableOfMaps implements TableData {
    int cursor = -1;
    private List<Map<String, Object>> data;

    @Override // com.x5.util.TableData
    public String[] getColumnLabels() {
        return null;
    }

    @Override // com.x5.util.TableData
    public String[] getRow() {
        return null;
    }

    @Override // com.x5.util.TableData
    public void setColumnLabels(String[] strArr) {
    }

    public TableOfMaps(List list) {
        this.data = list;
    }

    @Override // com.x5.util.TableData
    public boolean hasNext() {
        List<Map<String, Object>> list = this.data;
        return list != null && list.size() > this.cursor + 1;
    }

    @Override // com.x5.util.TableData
    public Map<String, Object> nextRecord() {
        int i = this.cursor + 1;
        this.cursor = i;
        List<Map<String, Object>> list = this.data;
        if (list == null || i >= list.size()) {
            return null;
        }
        return this.data.get(this.cursor);
    }

    @Override // com.x5.util.TableData
    public void reset() {
        this.cursor = -1;
    }

    static TableData boxObjectArray(Object[] objArr) {
        if (objArr == null || objArr.length < 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            arrayList.add(new ObjectDataMap(obj));
        }
        return new TableOfMaps(arrayList);
    }

    static TableData boxObjectList(List list) {
        if (list == null || list.size() < 1) {
            return null;
        }
        return boxIterator(list.iterator());
    }

    static TableData boxEnumeration(Enumeration enumeration) {
        if (enumeration == null || !enumeration.hasMoreElements()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (enumeration.hasMoreElements()) {
            arrayList.add(new ObjectDataMap(enumeration.nextElement()));
        }
        return new TableOfMaps(arrayList);
    }

    static TableData boxCollection(Collection collection) {
        if (collection == null || collection.size() < 1) {
            return null;
        }
        return boxIterator(collection.iterator());
    }

    static TableData boxIterator(Iterator it) {
        if (it == null || !it.hasNext()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            arrayList.add(new ObjectDataMap(it.next()));
        }
        return new TableOfMaps(arrayList);
    }
}
