package com.x5.template.filters;

import com.x5.template.Chunk;
import com.x5.util.LiteXml;

/* JADX INFO: loaded from: classes9.dex */
public class UnescapeXMLFilter extends BasicFilter implements ChunkFilter {
    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        if (str == null) {
            return null;
        }
        return LiteXml.unescapeXML(str);
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "unescape";
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String[] getFilterAliases() {
        return new String[]{"unhtml", "unxml", "xmlunescape", "htmlunescape", "unescapexml", "unescapehtml"};
    }
}
