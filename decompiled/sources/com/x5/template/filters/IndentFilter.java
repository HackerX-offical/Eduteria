package com.x5.template.filters;

import com.x5.template.Chunk;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes9.dex */
public class IndentFilter extends BasicFilter implements ChunkFilter {
    private static final Pattern EOL = Pattern.compile("(\\r\\n|\\r\\r|\\n)");

    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        if (str == null) {
            return null;
        }
        return applyIndent(str, filterArgs);
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "indent";
    }

    public static String applyIndent(String str, FilterArgs filterArgs) {
        String str2;
        String[] filterArgs2 = filterArgs.getFilterArgs();
        if (filterArgs2 == null) {
            return str;
        }
        int iEnd = 0;
        String str3 = filterArgs2[0];
        if (filterArgs2.length <= 1) {
            str2 = " ";
        } else {
            str2 = filterArgs2[1];
        }
        try {
            int i = Integer.parseInt(str3);
            int length = str.length();
            String str4 = str2;
            for (int i2 = 1; i2 < i; i2++) {
                str4 = str4 + str2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str4);
            Matcher matcher = EOL.matcher(str);
            while (matcher.find()) {
                sb.append(str.substring(iEnd, matcher.end()));
                iEnd = matcher.end();
                if (iEnd < length) {
                    sb.append(str4);
                }
            }
            if (iEnd < length) {
                sb.append(str.substring(iEnd));
            }
            return sb.toString();
        } catch (NumberFormatException unused) {
            return str;
        }
    }
}
