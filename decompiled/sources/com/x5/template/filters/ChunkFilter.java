package com.x5.template.filters;

import com.x5.template.Chunk;

/* JADX INFO: loaded from: classes9.dex */
public interface ChunkFilter {
    Object applyFilter(Chunk chunk, Object obj, FilterArgs filterArgs);

    Object applyFilter(Chunk chunk, String str, FilterArgs filterArgs);

    String[] getFilterAliases();

    String getFilterName();
}
