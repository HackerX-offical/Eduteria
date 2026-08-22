package com.x5.template.filters;

import com.x5.template.Chunk;

/* JADX INFO: loaded from: classes9.dex */
public class CalcFilter extends BasicFilter implements ChunkFilter {
    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        if (str == null) {
            return null;
        }
        return filterArgs.getFilterArgs() == null ? str : easyCalc(str, filterArgs);
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "calc";
    }

    private static String easyCalc(String str, FilterArgs filterArgs) {
        String[] filterArgs2 = filterArgs.getFilterArgs();
        String str2 = filterArgs2[0];
        String str3 = filterArgs2.length > 1 ? filterArgs2[1] : null;
        if (str2.indexOf("x") < 0) {
            str2 = "x" + str2;
        }
        try {
            return Calc.evalExpression(str2.replace("\\$", ""), str3, new String[]{"x"}, new String[]{str});
        } catch (NoClassDefFoundError unused) {
            return "[ERROR: jeplite jar missing from classpath! calc filter requires jeplite library]";
        } catch (NumberFormatException unused2) {
            return str;
        }
    }
}
