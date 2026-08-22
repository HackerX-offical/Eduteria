package com.x5.template.filters;

import com.x5.template.Chunk;
import java.util.Collection;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;

/* JADX INFO: loaded from: classes9.dex */
public class LengthFilter implements ChunkFilter {
    @Override // com.x5.template.filters.ChunkFilter
    public Object applyFilter(Chunk chunk, String str, FilterArgs filterArgs) {
        if (str == null) {
            return "0";
        }
        return Integer.toString(str.length());
    }

    @Override // com.x5.template.filters.ChunkFilter
    public Object applyFilter(Chunk chunk, Object obj, FilterArgs filterArgs) {
        int length;
        if (obj == null) {
            return "0";
        }
        if (obj instanceof Collection) {
            length = ((Collection) obj).size();
        } else if (obj instanceof Object[]) {
            length = ((Object[]) obj).length;
        } else {
            length = obj.toString().length();
        }
        return Integer.toString(length);
    }

    @Override // com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return Range.ATTR_LENGTH;
    }

    @Override // com.x5.template.filters.ChunkFilter
    public String[] getFilterAliases() {
        return new String[]{"len"};
    }
}
