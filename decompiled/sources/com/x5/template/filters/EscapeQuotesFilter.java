package com.x5.template.filters;

import com.x5.template.Chunk;

/* JADX INFO: loaded from: classes9.dex */
public class EscapeQuotesFilter extends BasicFilter implements ChunkFilter {
    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        return str != null ? Chunk.findAndReplace(Chunk.findAndReplace(Chunk.findAndReplace(str, "\\", "\\\\"), "\"", "\\\""), "'", "\\'") : str;
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "escapequotes";
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String[] getFilterAliases() {
        return new String[]{"quotedstring", "qs", "quoted"};
    }
}
