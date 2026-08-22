package com.x5.template.filters;

import com.x5.template.Chunk;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class ListIndexFilter extends ListFilter {
    @Override // com.x5.template.filters.ListFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "get";
    }

    @Override // com.x5.template.filters.ListFilter
    public Object transformList(Chunk chunk, List list, FilterArgs filterArgs) {
        if (list == null) {
            return null;
        }
        String[] filterArgs2 = filterArgs.getFilterArgs();
        if (filterArgs2.length < 1) {
            return null;
        }
        int size = Integer.parseInt(filterArgs2[0]);
        if (size < 0) {
            size += list.size();
        }
        if (size < 0 || size >= list.size()) {
            return null;
        }
        return list.get(size);
    }
}
