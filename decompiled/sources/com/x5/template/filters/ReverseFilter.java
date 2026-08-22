package com.x5.template.filters;

import com.x5.template.Chunk;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class ReverseFilter extends SliceFilter {
    @Override // com.x5.template.filters.SliceFilter, com.x5.template.filters.ListFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "reverse";
    }

    @Override // com.x5.template.filters.SliceFilter, com.x5.template.filters.ListFilter
    public Object transformList(Chunk chunk, List list, FilterArgs filterArgs) {
        return super.transformList(chunk, list, new FilterArgs("slice(::-1)"));
    }
}
