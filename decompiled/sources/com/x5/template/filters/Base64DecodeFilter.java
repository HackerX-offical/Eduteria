package com.x5.template.filters;

import com.x5.template.Chunk;
import com.x5.util.Base64;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes9.dex */
public class Base64DecodeFilter extends BasicFilter implements ChunkFilter {
    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        if (str == null) {
            return null;
        }
        return base64Decode(str);
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "base64decode";
    }

    public static String base64Decode(String str) {
        byte[] bytes;
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        byte[] bArrDecode = Base64.decode(bytes, 0, bytes.length);
        if (bArrDecode == null) {
            return str;
        }
        try {
            return new String(bArrDecode, "UTF-8");
        } catch (UnsupportedEncodingException unused2) {
            return new String(bArrDecode);
        }
    }
}
