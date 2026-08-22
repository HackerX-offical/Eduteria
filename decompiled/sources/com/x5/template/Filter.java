package com.x5.template;

import com.clevertap.android.sdk.Constants;
import com.x5.template.filters.BasicFilter;
import com.x5.template.filters.ChunkFilter;
import com.x5.template.filters.FilterArgs;
import com.x5.template.filters.RegexFilter;
import com.x5.util.DataCapsule;
import com.x5.util.TableData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes9.dex */
public class Filter {
    public static String FILTER_FIRST = "FILTER_FIRST";
    public static String FILTER_LAST = "FILTER_LAST";
    private static Map<String, ChunkFilter> filters = registerStockFilters();
    private static final Pattern parsePattern = Pattern.compile("includeIf\\(([\\!\\~])(.*)\\)\\.?([^\\)]*)$");
    private static final Pattern parsePatternAlt = Pattern.compile("include\\.\\(([\\!\\~])(.*)\\)([^\\)]*)$");

    private static Map<String, ChunkFilter> registerStockFilters() {
        if (filters == null) {
            filters = BasicFilter.getStockFilters();
        }
        return filters;
    }

    public static Object applyFilter(Chunk chunk, String str, Object obj) {
        TableData table;
        TableData table2;
        ChunkFilter chunkFilter;
        if (str != null) {
            int iFindNextFilter = findNextFilter(str);
            if (iFindNextFilter >= 0) {
                return applyFilter(chunk, str.substring(iFindNextFilter + 1), applyFilter(chunk, str.substring(0, iFindNextFilter), obj));
            }
            FilterArgs filterArgs = new FilterArgs(str);
            String filterName = filterArgs.getFilterName();
            ChunkFactory chunkFactory = chunk.getChunkFactory();
            Map<String, ChunkFilter> filters2 = chunkFactory != null ? chunkFactory.getFilters() : null;
            if (filters2 != null && (chunkFilter = filters2.get(filterName)) != null) {
                try {
                    return chunkFilter.applyFilter(chunk, obj, filterArgs);
                } catch (Exception e2) {
                    e2.printStackTrace(System.err);
                    return obj;
                }
            }
            if (str.equals("type")) {
                return typeFilter(chunk, obj);
            }
            if ((obj instanceof String) || (obj instanceof Snippet)) {
                String strStringify = BasicFilter.stringify(obj);
                if (str.equals("trim")) {
                    if (strStringify == null) {
                        return null;
                    }
                    return strStringify.trim();
                }
                if (str.startsWith("join(")) {
                    if (strStringify != null && (table2 = InlineTable.parseTable(strStringify)) != null) {
                        return joinInlineTable(table2, filterArgs);
                    }
                } else if (str.startsWith("get(")) {
                    if (strStringify != null && (table = InlineTable.parseTable(strStringify)) != null) {
                        return accessArrayIndex(table, filterArgs);
                    }
                } else if (str.equals("type")) {
                    return "STRING";
                }
            }
            ChunkFilter chunkFilter2 = filters.get(filterName);
            if (chunkFilter2 != null) {
                return chunkFilter2.applyFilter(chunk, obj, filterArgs);
            }
        }
        return obj;
    }

    public static String[] splitFilters(String str) {
        int iFindNextFilter = findNextFilter(str);
        if (iFindNextFilter < 0) {
            return new String[]{str};
        }
        ArrayList arrayList = new ArrayList();
        while (iFindNextFilter >= 0) {
            arrayList.add(str.substring(0, iFindNextFilter));
            str = str.substring(iFindNextFilter + 1);
            iFindNextFilter = findNextFilter(str);
        }
        arrayList.add(str);
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static int findNextFilter(String str) {
        int iNextUnescapedDelim;
        int iIndexOf;
        int iNextRegexDelim;
        int iNextUnescapedDelim2;
        int iNextRegexDelim2;
        int iIndexOf2 = str.indexOf(124);
        if (iIndexOf2 >= 0 && str.startsWith("s/")) {
            int iNextRegexDelim3 = RegexFilter.nextRegexDelim(str, 2);
            if (iNextRegexDelim3 >= 0 && (iNextRegexDelim2 = RegexFilter.nextRegexDelim(str, iNextRegexDelim3 + 1)) >= 0 && iNextRegexDelim2 >= iIndexOf2) {
                return str.indexOf("|", iNextRegexDelim2 + 1);
            }
        } else if (iIndexOf2 >= 0 && str.startsWith("onmatch")) {
            int i = 8;
            boolean z = false;
            while (!z && (iIndexOf = str.indexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR, i)) >= 0 && (iNextRegexDelim = RegexFilter.nextRegexDelim(str, iIndexOf + 1)) >= 0 && (iNextUnescapedDelim2 = FilterArgs.nextUnescapedDelim(Constants.SEPARATOR_COMMA, str, iNextRegexDelim + 1)) >= 0) {
                int i2 = iNextUnescapedDelim2 + 1;
                int iNextUnescapedDelim3 = FilterArgs.nextUnescapedDelim(Constants.SEPARATOR_COMMA, str, i2);
                if (iNextUnescapedDelim3 < 0) {
                    int iNextUnescapedDelim4 = FilterArgs.nextUnescapedDelim(")", str, i2);
                    if (iNextUnescapedDelim4 < 0) {
                        break;
                    }
                    int i3 = iNextUnescapedDelim4 + 8;
                    if (str.length() > i3) {
                        i = iNextUnescapedDelim4 + 1;
                        if (str.substring(i, i3).equals("nomatch")) {
                            z = true;
                        }
                    }
                    return str.indexOf("|", iNextUnescapedDelim4 + 1);
                }
                i = iNextUnescapedDelim3 + 1;
            }
            int iIndexOf3 = str.indexOf("(", i);
            if (iIndexOf3 > 0 && (iNextUnescapedDelim = FilterArgs.nextUnescapedDelim(")", str, iIndexOf3 + 1)) > 0) {
                return str.indexOf("|", iNextUnescapedDelim + 1);
            }
            return str.indexOf("|", i);
        }
        return iIndexOf2;
    }

    public static String translateIncludeIf(String str, String str2, String str3, Map<String, Object> map) {
        boolean z;
        boolean z2;
        Matcher matcher = parsePattern.matcher(str);
        if (!matcher.find()) {
            matcher = parsePatternAlt.matcher(str);
            if (!matcher.find()) {
                return "[includeIf bad syntax: " + str + Constants.AES_SUFFIX;
            }
        }
        matcher.group(0);
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(2);
        String strReplaceAll = matcher.group(3).replaceAll("[\\|:].*$", "");
        if (strGroup2.indexOf(61) < 0 && strGroup2.indexOf("!~") < 0) {
            if (strGroup.charAt(0) == '~') {
                return str2 + strGroup2 + "|ondefined(+" + strReplaceAll + "):" + str3;
            }
            return str2 + strGroup2 + "|ondefined():+" + strReplaceAll + str3;
        }
        if (strGroup2.indexOf("==") <= 0) {
            z = strGroup2.indexOf("!=") > 0;
            if (!z) {
                String[] strArrSplit = strGroup2.split("=~");
                if (strArrSplit.length != 2) {
                    strArrSplit = strGroup2.split("!~");
                    if (strArrSplit.length != 2) {
                        return "[includeIf bad syntax: " + str + Constants.AES_SUFFIX;
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                String strTrim = strArrSplit[0].trim();
                String strTrim2 = strArrSplit[1].trim();
                return z2 ? str2 + strTrim + "|onmatch(" + strTrim2 + ",)nomatch(+" + strReplaceAll + ")" + str3 : str2 + strTrim + "|onmatch(" + strTrim2 + ",+" + strReplaceAll + ")nomatch()" + str3;
            }
        } else {
            z = false;
        }
        String[] strArrSplit2 = strGroup2.split("!=|==");
        if (strArrSplit2.length == 2) {
            String strTrim3 = strArrSplit2[0].trim();
            String strTrim4 = strArrSplit2[1].trim();
            if (strTrim4.charAt(0) == '~') {
                Object obj = map.get(strTrim3);
                String string = obj != null ? obj.toString() : null;
                String str4 = string != null ? string : "";
                if (z) {
                    return str2 + strTrim4.substring(1) + "|onmatch(/^" + RegexFilter.escapeRegex(str4) + "$/,)nomatch(+" + strReplaceAll + ")" + str3;
                }
                return str2 + strTrim4.substring(1) + "|onmatch(/^" + RegexFilter.escapeRegex(str4) + "$/,+" + strReplaceAll + ")nomatch()" + str3;
            }
            if (strTrim4.charAt(0) == '\"' && strTrim4.charAt(strTrim4.length() - 1) == '\"') {
                strTrim4 = strTrim4.substring(1, strTrim4.length() - 1);
            }
            if (z) {
                return str2 + strTrim3 + "|onmatch(/^" + RegexFilter.escapeRegex(strTrim4) + "$/,)nomatch(+" + strReplaceAll + ")" + str3;
            }
            return str2 + strTrim3 + "|onmatch(/^" + RegexFilter.escapeRegex(strTrim4) + "$/,+" + strReplaceAll + ")nomatch()" + str3;
        }
        return "[includeIf bad syntax: " + str + Constants.AES_SUFFIX;
    }

    public static int grokFinalFilterPipe(String str, int i) {
        String strSubstring = str.substring(i + 1);
        for (int iFindNextFilter = findNextFilter(strSubstring); iFindNextFilter >= 0; iFindNextFilter = findNextFilter(strSubstring.substring(iFindNextFilter + 1))) {
            i = i + 1 + iFindNextFilter;
        }
        return i;
    }

    public static String accessArrayIndex(TableData tableData, FilterArgs filterArgs) {
        return accessArrayIndex(extractListFromTable(tableData), filterArgs);
    }

    public static String accessArrayIndex(String[] strArr, FilterArgs filterArgs) {
        if (strArr == null) {
            return "";
        }
        return accessArrayIndex((List<String>) Arrays.asList(strArr), filterArgs);
    }

    public static String accessArrayIndex(List<String> list, FilterArgs filterArgs) {
        String[] filterArgs2;
        if (list != null && (filterArgs2 = filterArgs.getFilterArgs()) != null) {
            try {
                int size = Integer.parseInt(filterArgs2[0]);
                if (size < 0) {
                    size += list.size();
                }
                if (size >= 0 && size < list.size()) {
                    return list.get(size);
                }
            } catch (NumberFormatException unused) {
            }
        }
        return "";
    }

    private static List<String> extractListFromTable(TableData tableData) {
        if (tableData == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (tableData.hasNext()) {
            tableData.nextRecord();
            arrayList.add(tableData.getRow()[0]);
        }
        return arrayList;
    }

    public static String joinInlineTable(TableData tableData, FilterArgs filterArgs) {
        return joinStringList(extractListFromTable(tableData), filterArgs);
    }

    public static String joinStringArray(String[] strArr, FilterArgs filterArgs) {
        if (strArr == null) {
            return "";
        }
        return strArr.length == 1 ? strArr[0] : joinStringList(Arrays.asList(strArr), filterArgs);
    }

    public static String joinStringList(List<String> list, FilterArgs filterArgs) {
        if (list == null) {
            return "";
        }
        int i = 0;
        if (list.size() == 1) {
            return list.get(0);
        }
        String unparsedArgs = filterArgs.getUnparsedArgs();
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            if (i > 0 && unparsedArgs != null) {
                sb.append(unparsedArgs);
            }
            if (str != null) {
                sb.append(str);
            }
            i++;
        }
        return sb.toString();
    }

    public static String typeFilter(Chunk chunk, Object obj) {
        return _typeFilter(chunk, obj, 0);
    }

    private static String _typeFilter(Chunk chunk, Object obj, int i) {
        if (i > 7) {
            return "CIRCULAR_POINTER";
        }
        if (obj == null) {
            return "NULL";
        }
        if (obj instanceof String) {
            return isInlineTable((String) obj) ? "LIST" : "STRING";
        }
        if (obj instanceof Snippet) {
            if (isInlineTable(obj.toString())) {
                return "LIST";
            }
            Snippet snippet = (Snippet) obj;
            return snippet.isSimplePointer() ? _typeFilter(chunk, chunk.get(snippet.getPointer()), i + 1) : "STRING";
        }
        if (obj instanceof Chunk) {
            return "CHUNK";
        }
        if ((obj instanceof String[]) || (obj instanceof List) || (obj instanceof Object[]) || (obj instanceof TableData)) {
            return "LIST";
        }
        if ((obj instanceof Map) || (obj instanceof DataCapsule)) {
            return "OBJECT";
        }
        return "UNKNOWN";
    }

    private static boolean isInlineTable(String str) {
        return InlineTable.parseTable(str) != null;
    }
}
