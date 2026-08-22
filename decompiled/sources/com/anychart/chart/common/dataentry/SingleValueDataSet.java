package com.anychart.chart.common.dataentry;

import com.anychart.data.View;
import com.clevertap.android.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SingleValueDataSet extends View {
    private StringBuilder js = new StringBuilder();
    private List<Object> values;

    public SingleValueDataSet(Object[] objArr) {
        this.values = new ArrayList();
        this.values = Arrays.asList(objArr);
    }

    public SingleValueDataSet(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        this.values = arrayList;
        arrayList.addAll(list);
    }

    public void addValue(Object obj) {
        this.values.add(obj);
    }

    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    public void clear() {
        this.values.clear();
    }

    @Override // com.anychart.data.View, com.anychart.core.Base, com.anychart.JsObject
    public String getJsBase() {
        this.js.append(Constants.AES_PREFIX);
        Iterator<Object> it = this.values.iterator();
        while (it.hasNext()) {
            this.js.append(it.next()).append(Constants.SEPARATOR_COMMA);
        }
        this.js.setLength(r0.length() - 1);
        this.js.append(Constants.AES_SUFFIX);
        return this.js.toString();
    }
}
