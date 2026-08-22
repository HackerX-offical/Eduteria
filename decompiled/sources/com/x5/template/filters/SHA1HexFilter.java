package com.x5.template.filters;

import com.x5.template.Chunk;

/* JADX INFO: loaded from: classes9.dex */
public class SHA1HexFilter extends BasicFilter implements ChunkFilter {
    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        if (str == null) {
            return null;
        }
        return sha1Hex(str);
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "sha1";
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String[] getFilterAliases() {
        return new String[]{"sha1hex"};
    }

    public static String sha1Hex(String str) {
        return sha1(str, false);
    }

    public static String sha1Base64(String str) {
        return sha1(str, true);
    }

    public static String sha1(String str, boolean z) {
        return MD5HexFilter.hashCrypt("SHA-1", str, z);
    }
}
