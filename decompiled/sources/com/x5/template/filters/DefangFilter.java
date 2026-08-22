package com.x5.template.filters;

import com.x5.template.Chunk;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes9.dex */
public class DefangFilter extends BasicFilter implements ChunkFilter {
    private static final Pattern NOT_HARMLESS_CHAR = Pattern.compile("[^A-Za-z0-9@\\!\\?\\*\\#\\$\\(\\)\\+\\=\\:\\;\\,\\~\\/\\._-]");

    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        if (str == null) {
            return null;
        }
        return defang(str);
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "defang";
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String[] getFilterAliases() {
        return new String[]{"noxss", "neuter"};
    }

    private static String defang(String str) {
        if (str == null) {
            return null;
        }
        return NOT_HARMLESS_CHAR.matcher(str).replaceAll("");
    }
}
