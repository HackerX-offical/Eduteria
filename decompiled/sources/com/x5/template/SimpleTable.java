package com.x5.template;

import com.x5.util.TableData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/* JADX INFO: loaded from: classes9.dex */
public class SimpleTable implements TableData, Map<String, Object> {
    public static final String ANON_ARRAY_LABEL = "_anonymous_";
    private Map<String, Integer> columnIndex;
    private int cursor;
    private String[] labels;
    private List<String[]> records;
    private int size;

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

    public SimpleTable(String[] strArr, Vector<String[]> vector) {
        this.cursor = -1;
        this.size = 0;
        this.labels = strArr;
        this.records = new ArrayList(vector);
    }

    public SimpleTable(String[] strArr, ArrayList<String[]> arrayList) {
        this.cursor = -1;
        this.size = 0;
        this.labels = strArr;
        this.records = arrayList;
    }

    public SimpleTable(String[] strArr, String[][] strArr2) {
        this.cursor = -1;
        this.size = 0;
        this.labels = strArr;
        this.records = new ArrayList();
        if (strArr2 != null) {
            for (String[] strArr3 : strArr2) {
                this.records.add(strArr3);
            }
        }
    }

    public SimpleTable(String[] strArr) {
        this.cursor = -1;
        this.size = 0;
        if (strArr == null) {
            return;
        }
        this.labels = new String[]{ANON_ARRAY_LABEL};
        this.records = new ArrayList();
        for (String str : strArr) {
            this.records.add(new String[]{str});
        }
    }

    public SimpleTable(List list) {
        this.cursor = -1;
        this.size = 0;
        if (list == null) {
            return;
        }
        this.labels = new String[]{ANON_ARRAY_LABEL};
        this.records = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            this.records.add(new String[]{list.get(i).toString()});
        }
    }

    @Override // com.x5.util.TableData
    public String[] getColumnLabels() {
        return this.labels;
    }

    @Override // com.x5.util.TableData
    public void setColumnLabels(String[] strArr) {
        this.labels = strArr;
    }

    @Override // com.x5.util.TableData
    public String[] getRow() {
        if (this.cursor < 0) {
            this.cursor = 0;
            List<String[]> list = this.records;
            this.size = list != null ? list.size() : 0;
        }
        int i = this.size;
        int i2 = this.cursor;
        if (i > i2) {
            return this.records.get(i2);
        }
        return null;
    }

    @Override // com.x5.util.TableData
    public boolean hasNext() {
        int i = this.size;
        if (i > this.cursor + 1) {
            return true;
        }
        if (i == 0) {
            List<String[]> list = this.records;
            int size = list == null ? 0 : list.size();
            this.size = size;
            if (size > this.cursor + 1) {
                return true;
            }
        }
        return false;
    }

    @Override // com.x5.util.TableData
    public Map<String, Object> nextRecord() {
        int i = this.cursor + 1;
        this.cursor = i;
        int i2 = this.size;
        if (i2 <= i) {
            if (i2 == 0) {
                List<String[]> list = this.records;
                int size = list == null ? 0 : list.size();
                this.size = size;
                if (size > this.cursor) {
                }
            }
            return null;
        }
        return this;
    }

    @Override // com.x5.util.TableData
    public void reset() {
        this.cursor = -1;
    }

    @Override // java.util.Map
    public int size() {
        String[] strArr = this.labels;
        if (strArr == null) {
            return 0;
        }
        return strArr.length;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.labels == null;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        if (this.columnIndex == null) {
            indexColumns();
        }
        Map<String, Integer> map = this.columnIndex;
        if (map == null) {
            return false;
        }
        return map.containsKey(obj);
    }

    private void indexColumns() {
        if (this.labels == null) {
            return;
        }
        this.columnIndex = new HashMap(this.labels.length);
        int i = 0;
        while (true) {
            String[] strArr = this.labels;
            if (i >= strArr.length) {
                return;
            }
            this.columnIndex.put(strArr[i], Integer.valueOf(i));
            i++;
        }
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        String[] row = getRow();
        if (row == null) {
            return false;
        }
        for (String str : row) {
            if (obj.equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        if (this.labels == null) {
            return null;
        }
        if (this.columnIndex == null) {
            indexColumns();
        }
        Map<String, Integer> map = this.columnIndex;
        if (map != null && map.containsKey(obj)) {
            try {
                return getRow()[this.columnIndex.get(obj).intValue()];
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return null;
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        if (this.labels == null) {
            return null;
        }
        if (this.columnIndex == null) {
            indexColumns();
        }
        Map<String, Integer> map = this.columnIndex;
        if (map != null) {
            return map.keySet();
        }
        return null;
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        String[] row = getRow();
        if (row == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : row) {
            arrayList.add(str);
        }
        return arrayList;
    }
}
