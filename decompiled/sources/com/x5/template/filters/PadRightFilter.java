package com.x5.template.filters;

import com.google.firebase.dynamiclinks.DynamicLink;
import com.x5.template.Chunk;

/* JADX INFO: loaded from: classes9.dex */
public class PadRightFilter extends BasicFilter implements ChunkFilter {
    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        if (str == null) {
            return null;
        }
        return padText(str, filterArgs.getFilterArgs());
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "rpad";
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String[] getFilterAliases() {
        return new String[]{"pad", DynamicLink.Builder.KEY_SUFFIX};
    }

    protected String padText(String str, String[] strArr) {
        int i;
        if (str.length() == 0) {
            return str;
        }
        if (strArr != null) {
            if (strArr.length != 0 || !strArr[0].equals("rpad")) {
                String str2 = strArr[0];
                if (strArr.length > 1) {
                    try {
                        i = Integer.parseInt(strArr[1]);
                    } catch (NumberFormatException unused) {
                        i = 1;
                    }
                } else {
                    i = 1;
                }
                if (i == 1) {
                    return str + str2;
                }
                StringBuilder sb = new StringBuilder(str);
                for (int i2 = 0; i2 < i; i2++) {
                    sb.append(str2);
                }
                return sb.toString();
            }
        }
        return str + " ";
    }
}
