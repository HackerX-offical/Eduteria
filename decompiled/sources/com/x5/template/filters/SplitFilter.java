package com.x5.template.filters;

import com.clevertap.android.sdk.Constants;
import com.x5.template.Chunk;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public class SplitFilter implements ChunkFilter {
    public static final String DEFAULT_DELIM = "/\\s+/";

    @Override // com.x5.template.filters.ChunkFilter
    public String[] getFilterAliases() {
        return null;
    }

    @Override // com.x5.template.filters.ChunkFilter
    public Object applyFilter(Chunk chunk, String str, FilterArgs filterArgs) {
        if (str == null) {
            return str;
        }
        String[] filterArgs2 = filterArgs.getFilterArgs();
        String str2 = DEFAULT_DELIM;
        int i = -1;
        if (filterArgs2 != null && filterArgs2.length >= 1 && filterArgs.getUnparsedArgs().length() >= 1) {
            if (filterArgs2.length == 1) {
                str2 = filterArgs2[0];
            } else if (filterArgs2.length <= 1) {
                str2 = null;
            } else if (filterArgs.getUnparsedArgs().equals(Constants.SEPARATOR_COMMA)) {
                str2 = Constants.SEPARATOR_COMMA;
            } else {
                String str3 = filterArgs2[0];
                if (str3.length() != 0) {
                    str2 = str3;
                }
                try {
                    i = Integer.parseInt(filterArgs2[1]);
                } catch (NumberFormatException unused) {
                }
            }
        }
        if (str2.length() > 1 && str2.charAt(0) == '/' && str2.charAt(str2.length() - 1) == '/') {
            String strSubstring = str2.substring(1, str2.length() - 1);
            if (i > 0) {
                String[] strArrSplit = str.split(strSubstring, i + 1);
                if (strArrSplit.length <= i) {
                    return strArrSplit;
                }
                String[] strArr = new String[i];
                System.arraycopy(strArrSplit, 0, strArr, 0, i);
                return strArr;
            }
            return str.split(strSubstring);
        }
        return splitNonRegex(str, str2, i);
    }

    @Override // com.x5.template.filters.ChunkFilter
    public Object applyFilter(Chunk chunk, Object obj, FilterArgs filterArgs) {
        if (obj == null) {
            return null;
        }
        return applyFilter(chunk, obj.toString(), filterArgs);
    }

    @Override // com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "split";
    }

    public static String[] splitNonRegex(String str, String str2) {
        return splitNonRegex(str, str2, -1);
    }

    public static String[] splitNonRegex(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        int length = str2.length();
        int i2 = 0;
        while (true) {
            int iIndexOf = str.indexOf(str2, i2);
            if (iIndexOf == -1) {
                arrayList.add(str.substring(i2));
            } else {
                arrayList.add(str.substring(i2, iIndexOf));
                i2 = iIndexOf + length;
            }
            if (iIndexOf == -1 || (i > 0 && arrayList.size() >= i)) {
                break;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
