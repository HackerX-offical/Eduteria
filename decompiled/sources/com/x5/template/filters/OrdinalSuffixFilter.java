package com.x5.template.filters;

import com.x5.template.Chunk;

/* JADX INFO: loaded from: classes9.dex */
public class OrdinalSuffixFilter extends BasicFilter implements ChunkFilter {
    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        if (str == null) {
            return null;
        }
        return ordinalSuffix(str);
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "th";
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String[] getFilterAliases() {
        return new String[]{"ord", "ordsuffix"};
    }

    private static String ordinalSuffix(String str) {
        if (str == null) {
            return null;
        }
        int i = Integer.parseInt(str);
        int i2 = i % 100;
        int i3 = i % 10;
        if (i2 - i3 == 10) {
            return str + "th";
        }
        if (i3 == 1) {
            return str + "st";
        }
        if (i3 == 2) {
            return str + "nd";
        }
        if (i3 != 3) {
            return str + "th";
        }
        return str + "rd";
    }
}
