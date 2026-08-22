package com.x5.template.filters;

/* JADX INFO: loaded from: classes9.dex */
public class PadLeftFilter extends PadRightFilter implements ChunkFilter {
    @Override // com.x5.template.filters.PadRightFilter, com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "lpad";
    }

    @Override // com.x5.template.filters.PadRightFilter, com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String[] getFilterAliases() {
        return new String[]{"prefix"};
    }

    @Override // com.x5.template.filters.PadRightFilter
    protected String padText(String str, String[] strArr) {
        int i;
        if (str.length() == 0) {
            return str;
        }
        if (strArr == null) {
            return " " + str;
        }
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
            return str2 + str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(str2);
        }
        sb.append(str);
        return sb.toString();
    }
}
