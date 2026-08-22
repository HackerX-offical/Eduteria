package com.x5.util;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class DataCapsuleTable implements TableData {
    private String[] columnLabels;
    private Map<String, Object> currentRecord;
    private int cursor = -1;
    private DataCapsule[] records;

    public static DataCapsuleTable extractData(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        DataCapsule[] dataCapsuleArr = new DataCapsule[objArr.length];
        int i = 0;
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj != null && (obj instanceof DataCapsule)) {
                dataCapsuleArr[i2] = (DataCapsule) obj;
                i++;
            }
        }
        if (i == 0) {
            return null;
        }
        return new DataCapsuleTable(dataCapsuleArr);
    }

    public DataCapsuleTable(DataCapsule[] dataCapsuleArr) {
        this.records = dataCapsuleArr;
    }

    @Override // com.x5.util.TableData
    public String[] getColumnLabels() {
        String[] strArr = this.columnLabels;
        return strArr == null ? getReader().getColumnLabels() : strArr;
    }

    public Object[] getRowRaw() {
        if (this.cursor < 0) {
            this.cursor = 0;
        }
        DataCapsule[] dataCapsuleArr = this.records;
        if (dataCapsuleArr == null || dataCapsuleArr.length <= this.cursor) {
            return null;
        }
        return getReader().extractData(this.records[this.cursor]);
    }

    private DataCapsuleReader getReader() {
        int i = this.cursor;
        if (i < 0) {
            i = 0;
        }
        DataCapsule[] dataCapsuleArr = this.records;
        if (dataCapsuleArr == null || dataCapsuleArr.length <= i) {
            return null;
        }
        return DataCapsuleReader.getReader(dataCapsuleArr[i]);
    }

    @Override // com.x5.util.TableData
    public String[] getRow() {
        Object[] rowRaw = getRowRaw();
        String[] strArr = new String[rowRaw.length];
        for (int i = 0; i < rowRaw.length; i++) {
            Object obj = rowRaw[i];
            if (obj == null) {
                strArr[i] = null;
            } else if (obj instanceof String) {
                strArr[i] = (String) obj;
            } else {
                strArr[i] = obj.toString();
            }
        }
        return strArr;
    }

    @Override // com.x5.util.TableData
    public boolean hasNext() {
        DataCapsule[] dataCapsuleArr = this.records;
        return dataCapsuleArr != null && dataCapsuleArr.length > this.cursor + 1;
    }

    @Override // com.x5.util.TableData
    public Map<String, Object> nextRecord() {
        this.cursor++;
        String[] row = getRow();
        if (row == null) {
            return null;
        }
        Map<String, Object> map = this.currentRecord;
        if (map == null) {
            this.currentRecord = new HashMap();
        } else {
            map.clear();
        }
        String[] columnLabels = getColumnLabels();
        for (int i = 0; i < columnLabels.length; i++) {
            this.currentRecord.put(columnLabels[i], row[i]);
        }
        return this.currentRecord;
    }

    @Override // com.x5.util.TableData
    public void setColumnLabels(String[] strArr) {
        this.columnLabels = strArr;
    }

    @Override // com.x5.util.TableData
    public void reset() {
        this.cursor = -1;
    }
}
