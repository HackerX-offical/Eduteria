package com.x5.template.filters;

import com.x5.template.Chunk;

/* JADX INFO: loaded from: classes9.dex */
public class SelectedFilter extends BasicFilter implements ChunkFilter {
    private static final String CHECKED_TOKEN = " checked=\"checked\" ";
    private static final String SELECTED_TOKEN = " selected=\"selected\" ";

    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        if (str == null) {
            return null;
        }
        return selected(chunk, str, filterArgs);
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "selected";
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String[] getFilterAliases() {
        return new String[]{"select", "sel"};
    }

    private static String selected(Chunk chunk, String str, FilterArgs filterArgs) {
        return selected(chunk, str, filterArgs, SELECTED_TOKEN);
    }

    protected static String checked(Chunk chunk, String str, FilterArgs filterArgs) {
        return selected(chunk, str, filterArgs, CHECKED_TOKEN);
    }

    private static String selected(Chunk chunk, String str, FilterArgs filterArgs, String str2) {
        String[] filterArgs2 = filterArgs.getFilterArgs();
        if (filterArgs2 == null) {
            return str2;
        }
        String str3 = filterArgs2[0];
        if (filterArgs2.length > 1) {
            str2 = filterArgs2[1];
        }
        if (str3.charAt(0) == '~' || str3.charAt(0) == '$') {
            Object obj = chunk.get(str3.substring(1));
            if (obj == null || !str.equals(obj.toString())) {
                return "";
            }
        } else if (!str.equals(str3)) {
            return "";
        }
        return str2;
    }
}
