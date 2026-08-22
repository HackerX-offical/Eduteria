package com.x5.template.filters;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.x5.template.Chunk;

/* JADX INFO: loaded from: classes9.dex */
public class QuickCalcFilter extends BasicFilter implements ChunkFilter {
    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        return applyQuickCalc(str, filterArgs.getUnparsedArgs());
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "qcalc";
    }

    private static String applyQuickCalc(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            return str;
        }
        try {
            if (str.indexOf(InstructionFileId.DOT) <= 0 && str2.indexOf(InstructionFileId.DOT) <= 0) {
                long j = Long.parseLong(str);
                char cCharAt = str2.charAt(0);
                long j2 = Long.parseLong(str2.substring(1));
                long jRound = cCharAt == '-' ? j - j2 : j;
                if (cCharAt == '+') {
                    jRound = j + j2;
                }
                if (cCharAt == '*') {
                    jRound = j * j2;
                }
                if (cCharAt == '/') {
                    jRound = j / j2;
                }
                if (cCharAt == '%') {
                    jRound = j % j2;
                }
                if (cCharAt == '^') {
                    jRound = Math.round(Math.pow(j, j2));
                }
                return Long.toString(jRound);
            }
            double d2 = Double.parseDouble(str);
            char cCharAt2 = str2.charAt(0);
            double d3 = Double.parseDouble(str2.substring(1));
            double d4 = cCharAt2 == '-' ? d2 - d3 : d2;
            if (cCharAt2 == '+') {
                d4 = d2 + d3;
            }
            if (cCharAt2 == '*') {
                d4 = d2 * d3;
            }
            if (cCharAt2 == '/') {
                d4 = d2 / d3;
            }
            if (cCharAt2 == '%') {
                d4 = d2 % d3;
            }
            return Double.toString(d4);
        } catch (NumberFormatException unused) {
            return str;
        }
    }
}
