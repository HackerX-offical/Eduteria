package com.x5.template.filters;

import com.x5.template.Chunk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class SortFilter extends ListFilter {
    @Override // com.x5.template.filters.ListFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "sort";
    }

    @Override // com.x5.template.filters.ListFilter
    public Object transformList(Chunk chunk, List list, FilterArgs filterArgs) {
        if (list != null && list.size() >= 2) {
            try {
                if (!isInOrder(list)) {
                    ArrayList arrayList = new ArrayList(list);
                    Collections.sort(arrayList);
                    return arrayList;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return list;
    }

    private boolean isInOrder(List list) throws ClassCastException {
        boolean z = true;
        for (int i = 1; i < list.size(); i++) {
            if (((Comparable) list.get(i - 1)).compareTo((Comparable) list.get(i)) > 0) {
                z = false;
            }
        }
        return z;
    }
}
