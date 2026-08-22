package com.x5.template.filters;

import com.x5.template.BlockTag;
import com.x5.template.Chunk;
import com.x5.template.ContentSource;
import com.x5.template.Snippet;

/* JADX INFO: loaded from: classes9.dex */
public class ExecFilter extends BasicFilter {
    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        ContentSource templateSet;
        Snippet snippet;
        String[] filterArgs2 = filterArgs.getFilterArgs();
        if (filterArgs2 == null || filterArgs2.length <= 0) {
            return null;
        }
        String strQualifyTemplateRef = filterArgs2[0];
        if (chunk != null) {
            strQualifyTemplateRef = BlockTag.qualifyTemplateRef(chunk.getTemplateOrigin(), strQualifyTemplateRef);
        }
        if (chunk == null || (templateSet = chunk.getTemplateSet()) == null || (snippet = templateSet.getSnippet(strQualifyTemplateRef)) == null) {
            return null;
        }
        Chunk chunk2 = new Chunk();
        chunk2.append(snippet);
        chunk2.setOrDelete("x", str);
        return chunk2.toString();
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "filter";
    }
}
