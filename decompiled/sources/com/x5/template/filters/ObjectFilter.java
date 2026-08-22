package com.x5.template.filters;

import com.x5.template.Chunk;
import com.x5.util.ObjectDataMap;

/* JADX INFO: loaded from: classes9.dex */
public abstract class ObjectFilter implements ChunkFilter {
    @Override // com.x5.template.filters.ChunkFilter
    public Object applyFilter(Chunk chunk, String str, FilterArgs filterArgs) {
        return str;
    }

    @Override // com.x5.template.filters.ChunkFilter
    public String[] getFilterAliases() {
        return null;
    }

    @Override // com.x5.template.filters.ChunkFilter
    public abstract String getFilterName();

    public abstract Object transformObject(Chunk chunk, Object obj, FilterArgs filterArgs);

    @Override // com.x5.template.filters.ChunkFilter
    public Object applyFilter(Chunk chunk, Object obj, FilterArgs filterArgs) {
        if (obj instanceof ObjectDataMap) {
            obj = ((ObjectDataMap) obj).unwrap();
        }
        return transformObject(chunk, obj, filterArgs);
    }
}
