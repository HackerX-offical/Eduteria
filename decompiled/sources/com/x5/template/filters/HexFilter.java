package com.x5.template.filters;

import com.x5.template.Chunk;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes9.dex */
public class HexFilter extends BasicFilter implements ChunkFilter {
    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        String string;
        if (str == null) {
            return null;
        }
        try {
            string = new BigInteger(1, str.getBytes("UTF-8")).toString(16);
        } catch (UnsupportedEncodingException unused) {
            string = new BigInteger(1, str.getBytes()).toString(16);
        }
        return string == null ? str : string;
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "hex";
    }
}
