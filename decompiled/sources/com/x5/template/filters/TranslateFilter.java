package com.x5.template.filters;

import com.x5.template.Chunk;
import com.x5.template.ChunkLocale;

/* JADX INFO: loaded from: classes9.dex */
public class TranslateFilter extends BasicFilter implements ChunkFilter {
    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        ChunkLocale locale;
        if (str == null) {
            return null;
        }
        return (chunk == null || (locale = chunk.getLocale()) == null) ? str : locale.translate(str, null, chunk);
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "_";
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String[] getFilterAliases() {
        return new String[]{"__", "translate", "xlate"};
    }
}
