package com.x5.template.filters;

import com.x5.template.Chunk;

/* JADX INFO: loaded from: classes9.dex */
public class HexUpperFilter extends HexFilter implements ChunkFilter {
    @Override // com.x5.template.filters.HexFilter, com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        String strTransformText = super.transformText(chunk, str, filterArgs);
        if (strTransformText == null) {
            return null;
        }
        return strTransformText.toUpperCase();
    }

    @Override // com.x5.template.filters.HexFilter, com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "HEX";
    }
}
