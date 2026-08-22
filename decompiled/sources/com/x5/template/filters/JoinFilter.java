package com.x5.template.filters;

import com.x5.template.Chunk;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class JoinFilter extends ListFilter {
    @Override // com.x5.template.filters.ListFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "join";
    }

    @Override // com.x5.template.filters.ListFilter
    public Object transformList(Chunk chunk, List list, FilterArgs filterArgs) {
        if (list == null) {
            return "";
        }
        int i = 0;
        if (list.size() == 1) {
            return list.get(0);
        }
        String unparsedArgs = filterArgs.getUnparsedArgs();
        StringBuilder sb = new StringBuilder();
        for (Object obj : list) {
            if (i > 0 && unparsedArgs != null) {
                sb.append(unparsedArgs);
            }
            if (obj != null) {
                sb.append(obj.toString());
            }
            i++;
        }
        return sb.toString();
    }
}
