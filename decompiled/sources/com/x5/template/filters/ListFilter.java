package com.x5.template.filters;

import com.x5.template.Chunk;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public abstract class ListFilter implements ChunkFilter {
    @Override // com.x5.template.filters.ChunkFilter
    public String[] getFilterAliases() {
        return null;
    }

    @Override // com.x5.template.filters.ChunkFilter
    public abstract String getFilterName();

    public abstract Object transformList(Chunk chunk, List list, FilterArgs filterArgs);

    @Override // com.x5.template.filters.ChunkFilter
    public Object applyFilter(Chunk chunk, String str, FilterArgs filterArgs) {
        return applyFilter(chunk, new String[]{str}, filterArgs);
    }

    @Override // com.x5.template.filters.ChunkFilter
    public Object applyFilter(Chunk chunk, Object obj, FilterArgs filterArgs) {
        List listAsList;
        if (obj instanceof List) {
            listAsList = (List) obj;
        } else if (obj instanceof Object[]) {
            listAsList = Arrays.asList((Object[]) obj);
        } else {
            listAsList = Arrays.asList(obj);
        }
        return transformList(chunk, listAsList, filterArgs);
    }
}
