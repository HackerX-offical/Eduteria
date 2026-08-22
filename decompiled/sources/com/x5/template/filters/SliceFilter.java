package com.x5.template.filters;

import com.x5.template.Chunk;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class SliceFilter extends ListFilter {
    @Override // com.x5.template.filters.ListFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "slice";
    }

    private static int parseSliceArg(String str, int i, int i2) {
        if (str != null && str.trim().length() > 0) {
            try {
                int i3 = Integer.parseInt(str.trim());
                if (i2 < 0 || i3 >= 0) {
                    return i3;
                }
                int i4 = i2 + i3;
                if (i4 < 0) {
                    return 0;
                }
                return i4;
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    @Override // com.x5.template.filters.ListFilter
    public Object transformList(Chunk chunk, List list, FilterArgs filterArgs) {
        int sliceArg;
        String str;
        if (list == null) {
            return list;
        }
        int size = list.size();
        String[] filterArgs2 = filterArgs.getFilterArgs();
        String str2 = filterArgs2[0];
        if (filterArgs2.length > 0) {
            String[] strArrSplitNonRegex = SplitFilter.splitNonRegex(str2, ":");
            boolean z = strArrSplitNonRegex.length > 1;
            String str3 = strArrSplitNonRegex[0];
            if (z) {
                str = strArrSplitNonRegex[1];
                if (strArrSplitNonRegex.length > 2) {
                    str = strArrSplitNonRegex[2];
                }
            } else if (filterArgs2.length > 1) {
                String str4 = filterArgs2[1];
                str = filterArgs2.length > 2 ? filterArgs2[2] : null;
                str = str4;
            } else {
                str = null;
            }
            sliceArg = parseSliceArg(str, 1, -1);
            int sliceArg2 = parseSliceArg(str3, sliceArg < 0 ? size - 1 : 0, size);
            int sliceArg3 = parseSliceArg(str, sliceArg >= 0 ? size : -1, size);
            if (sliceArg2 <= size) {
                size = sliceArg2;
            }
            if (sliceArg == 0) {
                sliceArg3 = size;
                sliceArg = 1;
            }
            if ((sliceArg > 0 && sliceArg3 < size) || (sliceArg < 0 && sliceArg3 > size)) {
                sliceArg3 = size;
            }
            i = size;
            size = sliceArg3;
        } else {
            sliceArg = 1;
        }
        if (sliceArg == 1) {
            return list.subList(i, size);
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (sliceArg <= 0) {
                if (i <= size) {
                    break;
                }
                arrayList.add(list.get(i));
                i += sliceArg;
            } else {
                if (i >= size) {
                    break;
                }
                arrayList.add(list.get(i));
                i += sliceArg;
            }
        }
        return arrayList;
    }
}
