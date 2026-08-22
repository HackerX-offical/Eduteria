package com.x5.template.filters;

import com.x5.template.Chunk;

/* JADX INFO: loaded from: classes9.dex */
public class OnEmptyFilter extends BasicFilter implements ChunkFilter {
    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        String[] filterArgs2 = filterArgs.getFilterArgs();
        String str2 = (filterArgs2 == null || filterArgs2.length <= 0) ? null : filterArgs2[0];
        if (str2 == null) {
            return null;
        }
        return (str == null || str.trim().length() == 0) ? FilterArgs.magicBraces(chunk, str2) : str;
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "onempty";
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String[] getFilterAliases() {
        return new String[]{"else"};
    }
}
