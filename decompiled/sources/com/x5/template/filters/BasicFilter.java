package com.x5.template.filters;

import com.x5.template.Chunk;
import com.x5.template.Snippet;
import com.x5.util.ObjectDataMap;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BasicFilter implements ChunkFilter {
    public static ChunkFilter[] stockFilters = {new AlternateFilter(), new Base64DecodeFilter(), new Base64EncodeFilter(), new CalcFilter(), new CheckedFilter(), new DefangFilter(), new DefaultFilter(), new EscapeQuotesFilter(), new EscapeXMLFilter(), new UnescapeXMLFilter(), new ExecFilter(), new FormatFilter(), new HexFilter(), new HexUpperFilter(), new IndentFilter(), new LetterCaseFilter(), new MD5HexFilter(), new MD5Base64Filter(), new OnEmptyFilter(), new OnDefinedFilter(), new OnMatchFilter(), new OrdinalSuffixFilter(), new PadLeftFilter(), new PadRightFilter(), new QuickCalcFilter(), new RegexFilter(), new SelectedFilter(), new SHA1HexFilter(), new SHA1Base64Filter(), new StringFilter(), new TranslateFilter(), new URLDecodeFilter(), new URLEncodeFilter(), new SliceFilter(), new SortFilter(), new ReverseFilter(), new JoinFilter(), new ListIndexFilter(), new SplitFilter(), new LengthFilter()};

    @Override // com.x5.template.filters.ChunkFilter
    public String[] getFilterAliases() {
        return null;
    }

    @Override // com.x5.template.filters.ChunkFilter
    public abstract String getFilterName();

    public abstract String transformText(Chunk chunk, String str, FilterArgs filterArgs);

    @Override // com.x5.template.filters.ChunkFilter
    public Object applyFilter(Chunk chunk, String str, FilterArgs filterArgs) {
        return transformText(chunk, str, filterArgs);
    }

    @Override // com.x5.template.filters.ChunkFilter
    public Object applyFilter(Chunk chunk, Object obj, FilterArgs filterArgs) {
        return transformText(chunk, obj == null ? null : stringify(obj), filterArgs);
    }

    public static String stringify(Snippet snippet) {
        return snippet.toSimpleString();
    }

    public static String stringify(Object obj) {
        return obj instanceof Snippet ? stringify((Snippet) obj) : ObjectDataMap.getAsString(obj);
    }

    public static Map<String, ChunkFilter> getStockFilters() {
        HashMap map = new HashMap();
        for (ChunkFilter chunkFilter : stockFilters) {
            map.put(chunkFilter.getFilterName(), chunkFilter);
            String[] filterAliases = chunkFilter.getFilterAliases();
            if (filterAliases != null) {
                for (String str : filterAliases) {
                    map.put(str, chunkFilter);
                }
            }
        }
        return map;
    }
}
