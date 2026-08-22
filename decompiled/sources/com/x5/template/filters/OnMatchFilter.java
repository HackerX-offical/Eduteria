package com.x5.template.filters;

import com.x5.template.Chunk;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes9.dex */
public class OnMatchFilter extends BasicFilter implements ChunkFilter {
    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        return applyMatchTransform(chunk, str, filterArgs);
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "onmatch";
    }

    private static String applyMatchTransform(Chunk chunk, String str, FilterArgs filterArgs) {
        String str2;
        String[] filterArgs2 = filterArgs.getFilterArgs();
        if (filterArgs2 != null && (filterArgs2.length != 1 || (str2 = filterArgs2[0]) == null || str2.length() != 0)) {
            for (int i = 0; i < filterArgs2.length; i += 2) {
                int i2 = i + 1;
                if (i2 < filterArgs2.length) {
                    String str3 = filterArgs2[i];
                    String str4 = filterArgs2[i2];
                    if (str3.equals("|nomatch|")) {
                        return FilterArgs.magicBraces(chunk, str4);
                    }
                    if (str != null) {
                        int iIndexOf = str3.indexOf(47) + 1;
                        int iLastIndexOf = str3.lastIndexOf(47);
                        if (iIndexOf >= 0 && iIndexOf != iLastIndexOf) {
                            String strSubstring = str3.substring(iIndexOf, iLastIndexOf);
                            boolean z = false;
                            boolean z2 = false;
                            boolean z3 = false;
                            for (int length = str3.length() - 1; length > iLastIndexOf; length--) {
                                char cCharAt = str3.charAt(length);
                                if (cCharAt == 'i') {
                                    z2 = true;
                                }
                                if (cCharAt == 'm') {
                                    z = true;
                                }
                                if (cCharAt == 's') {
                                    z3 = true;
                                }
                            }
                            if (z) {
                                strSubstring = "(?m)" + strSubstring;
                            }
                            if (z2) {
                                strSubstring = "(?i)" + strSubstring;
                            }
                            if (z3) {
                                strSubstring = "(?s)" + strSubstring;
                            }
                            if (Pattern.compile(strSubstring).matcher(str).find()) {
                                return FilterArgs.magicBraces(chunk, str4);
                            }
                        }
                    }
                }
            }
            return "";
        }
        return str;
    }
}
