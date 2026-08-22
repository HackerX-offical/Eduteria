package com.x5.template.filters;

import com.x5.template.Chunk;

/* JADX INFO: loaded from: classes9.dex */
public class AlternateFilter extends BasicFilter implements ChunkFilter {
    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        String[] filterArgs2 = filterArgs.getFilterArgs();
        if (filterArgs2 != null) {
            try {
                if (Integer.parseInt(str) % 2 == 0) {
                    str2 = filterArgs2[0];
                } else if (filterArgs2.length >= 2) {
                    str2 = filterArgs2[1];
                }
                return FilterArgs.magicBraces(chunk, str2);
            } catch (NumberFormatException unused) {
            }
        }
        return str;
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "alternate";
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String[] getFilterAliases() {
        return new String[]{"evenodd"};
    }
}
