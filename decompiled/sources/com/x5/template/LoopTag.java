package com.x5.template;

import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.x5.template.filters.RegexFilter;
import com.x5.util.DataCapsuleTable;
import com.x5.util.ObjectDataMap;
import com.x5.util.TableData;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes9.dex */
public class LoopTag extends BlockTag {
    private static final String FIRST_MARKER = "first";
    private static final String LAST_MARKER = "last";
    private static final String PLACE_TAG = "place";
    private static final Pattern UNIVERSAL_LF = Pattern.compile("\n|\r\n|\r\r");
    private Chunk chunk;
    private String emptyTemplate;
    private Map<String, Object> options;
    private String rowTemplate;
    private Chunk rowX;
    private Snippet emptySnippet = null;
    private Snippet dividerSnippet = null;
    private Snippet rowSnippet = null;

    @Override // com.x5.template.BlockTag
    public boolean doSmartTrimAroundBlock() {
        return true;
    }

    public static void main(String[] strArr) {
        LoopTag loopTag = new LoopTag();
        loopTag.parseParams("{~.loop data=\"~mydata\" template=\"#test_row\" no_data=\"#test_empty\"}");
        System.out.println("row_tpl=" + loopTag.rowTemplate);
        System.out.println("empty_tpl=" + loopTag.emptyTemplate);
    }

    public static String expandLoop(String str, Chunk chunk, String str2, int i) {
        LoopTag loopTag = new LoopTag(str, chunk, str2);
        StringWriter stringWriter = new StringWriter();
        try {
            loopTag.renderBlock(stringWriter, chunk, str2, i);
        } catch (IOException e2) {
            e2.printStackTrace(System.err);
        }
        return stringWriter.toString();
    }

    public LoopTag() {
    }

    public LoopTag(String str, Chunk chunk, String str2) {
        this.chunk = chunk;
        parseParams(str);
        initWithoutBlock(str2);
    }

    private void initWithoutBlock(String str) {
        ContentSource templateSet;
        Chunk chunk = this.chunk;
        if (chunk == null || (templateSet = chunk.getTemplateSet()) == null) {
            return;
        }
        String str2 = this.rowTemplate;
        if (str2 != null) {
            this.rowSnippet = templateSet.getSnippet(qualifyTemplateRef(str, str2));
        }
        String str3 = this.emptyTemplate;
        if (str3 != null) {
            this.emptySnippet = templateSet.getSnippet(qualifyTemplateRef(str, str3));
        }
    }

    public LoopTag(String str, Snippet snippet) {
        parseParams(str);
        initBody(snippet);
    }

    private void parseParams(String str) {
        if (str == null) {
            return;
        }
        if (str.startsWith(".loop(")) {
            parseFnParams(str);
        } else if (str.matches("\\.loop [^\" ]+ .*")) {
            parseEZParams(str);
        } else {
            parseAttributes(str);
        }
    }

    private void parseEZParams(String str) {
        String strSubstring;
        String[] strArrSplit = str.split(" +");
        String str2 = strArrSplit[2];
        Map<String, Object> map = Attributes.parse(str);
        this.options = map;
        if (map == null) {
            this.options = new HashMap();
        }
        this.options.put("data", str2);
        if (this.options.containsKey(Const.COUNTER)) {
            Map<String, Object> map2 = this.options;
            map2.put("counter_tag", map2.get(Const.COUNTER));
        }
        if (strArrSplit.length <= 3 || !strArrSplit[3].equals("as") || (strSubstring = strArrSplit[4]) == null) {
            return;
        }
        if (strSubstring.startsWith("~") || strSubstring.startsWith("$")) {
            strSubstring = strSubstring.substring(1);
        }
        if (strSubstring.contains(":")) {
            String[] strArrSplit2 = strSubstring.split(":");
            String strSubstring2 = strArrSplit2[1];
            if (strSubstring2.startsWith("~") || strSubstring2.startsWith("$")) {
                strSubstring2 = strSubstring2.substring(1);
            }
            this.options.put("keyname", strArrSplit2[0]);
            this.options.put("valname", strSubstring2);
        }
        this.options.put("name", strSubstring);
    }

    private void parseFnParams(String str) {
        int length = str.length();
        if (str.endsWith(")")) {
            length--;
        }
        String[] strArrSplit = str.substring(".loop(".length(), length).split(Constants.SEPARATOR_COMMA);
        if (strArrSplit == null || strArrSplit.length < 2) {
            return;
        }
        String str2 = strArrSplit[0];
        if (this.options == null) {
            this.options = new HashMap();
        }
        this.options.put("data", str2);
        this.rowTemplate = strArrSplit[1];
        if (strArrSplit.length > 2) {
            this.emptyTemplate = strArrSplit[2];
        } else {
            this.emptyTemplate = null;
        }
    }

    private void parseAttributes(String str) {
        Map<String, Object> map = Attributes.parse(str);
        if (map == null) {
            return;
        }
        if (map.containsKey(Const.COUNTER)) {
            map.put("counter_tag", map.get(Const.COUNTER));
        }
        this.options = map;
        this.rowTemplate = (String) map.get(SDKConstants.PARAM_UPDATE_TEMPLATE);
        this.emptyTemplate = (String) map.get(Const.NO_DATA);
    }

    private TableData fetchData(String str, String str2) {
        boolean z;
        TableData tableDataBoxIterator = null;
        if (str != null) {
            int iIndexOf = str.indexOf(Constants.AES_PREFIX);
            if (iIndexOf > 0) {
                int iIndexOf2 = str.indexOf(Constants.AES_SUFFIX, iIndexOf);
                if (iIndexOf2 < 0) {
                    iIndexOf2 = str.length();
                }
                String strSubstring = str.substring(iIndexOf + 1, iIndexOf2);
                str = str.substring(0, iIndexOf);
                registerOption("range", strSubstring);
            }
            char cCharAt = str.charAt(0);
            if (cCharAt == '^' || cCharAt == '.') {
                str = RegexFilter.applyRegex(str, "s/^[\\^\\.]/~./");
                z = true;
            } else {
                z = false;
            }
            if (z || cCharAt == '~' || cCharAt == '$') {
                String strSubstring2 = str.substring(1);
                Chunk chunk = this.chunk;
                if (chunk != null) {
                    Object obj = chunk.get(strSubstring2);
                    int i = 0;
                    while (true) {
                        if (obj == null || i >= 10) {
                            break;
                        }
                        if (obj instanceof TableData) {
                            return (TableData) obj;
                        }
                        if (obj instanceof String) {
                            return InlineTable.parseTable((String) obj);
                        }
                        if (obj instanceof Snippet) {
                            Snippet snippet = (Snippet) obj;
                            if (snippet.isSimplePointer()) {
                                obj = this.chunk.get(snippet.getPointer());
                                i++;
                            } else {
                                return InlineTable.parseTable(snippet.toString());
                            }
                        } else {
                            if (obj instanceof String[]) {
                                return new SimpleTable((String[]) obj);
                            }
                            if (obj instanceof List) {
                                List list = (List) obj;
                                if (list.size() > 0) {
                                    Object obj2 = list.get(0);
                                    if (obj2 instanceof String) {
                                        return new SimpleTable(list);
                                    }
                                    if (obj2 instanceof Map) {
                                        return new TableOfMaps(list);
                                    }
                                    return TableOfMaps.boxCollection(list);
                                }
                            } else {
                                if (obj instanceof Object[]) {
                                    Object[] objArr = (Object[]) obj;
                                    DataCapsuleTable dataCapsuleTableExtractData = DataCapsuleTable.extractData(objArr);
                                    return dataCapsuleTableExtractData == null ? TableOfMaps.boxObjectArray(objArr) : dataCapsuleTableExtractData;
                                }
                                if (obj instanceof Map) {
                                    if (obj instanceof ObjectDataMap) {
                                        Object objUnwrap = ((ObjectDataMap) obj).unwrap();
                                        if (objUnwrap instanceof Collection) {
                                            tableDataBoxIterator = TableOfMaps.boxCollection((Collection) objUnwrap);
                                        } else if (objUnwrap instanceof Enumeration) {
                                            tableDataBoxIterator = TableOfMaps.boxEnumeration((Enumeration) objUnwrap);
                                        } else if (objUnwrap instanceof Iterator) {
                                            tableDataBoxIterator = TableOfMaps.boxIterator((Iterator) objUnwrap);
                                        }
                                    }
                                    if (tableDataBoxIterator == null) {
                                        return new ObjectTable((Map) obj);
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (this.chunk != null) {
                String strFetch = this.chunk.getTemplateSet().fetch(qualifyTemplateRef(str2, str));
                if (strFetch != null) {
                    return InlineTable.parseTable(strFetch);
                }
            }
        }
        return tableDataBoxIterator;
    }

    private void registerOption(String str, String str2) {
        if (this.options == null) {
            this.options = new HashMap();
        }
        this.options.put(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x045d  */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r19v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void cookLoopToPrinter(java.io.Writer r28, com.x5.template.Chunk r29, java.lang.String r30, boolean r31, int r32, com.x5.util.TableData r33) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1191
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.x5.template.LoopTag.cookLoopToPrinter(java.io.Writer, com.x5.template.Chunk, java.lang.String, boolean, int, com.x5.util.TableData):void");
    }

    private String eatTagSymbol(String str) {
        if (str == null) {
            return null;
        }
        char cCharAt = str.length() > 0 ? str.charAt(0) : (char) 0;
        return (cCharAt == '$' || cCharAt == '~') ? str.substring(1) : str;
    }

    @Override // com.x5.template.BlockTag
    public boolean hasBody(String str) {
        return str != null && str.indexOf("template=") < 0;
    }

    public static String getAttribute(String str, String str2) {
        int iIndexOf;
        String strSubstring;
        int iIndexOf2;
        int iIndexOf3;
        if (str2 == null || (iIndexOf = str2.indexOf(32)) < 0 || (iIndexOf2 = (strSubstring = str2.substring(iIndexOf + 1)).indexOf(str)) < 0 || (iIndexOf3 = strSubstring.indexOf(34, strSubstring.indexOf(61, iIndexOf2 + str.length()))) < 0) {
            return null;
        }
        int i = iIndexOf3 + 1;
        int iIndexOf4 = i;
        do {
            iIndexOf4 = strSubstring.indexOf(34, iIndexOf4);
            if (iIndexOf4 >= 0) {
                if (strSubstring.charAt(iIndexOf4 - 1) == '\\') {
                    iIndexOf4++;
                }
                if (iIndexOf4 >= strSubstring.length()) {
                    break;
                }
            } else {
                return null;
            }
        } while (strSubstring.charAt(iIndexOf4) != '\"');
        if (iIndexOf4 < strSubstring.length()) {
            return strSubstring.substring(i, iIndexOf4);
        }
        return null;
    }

    @Override // com.x5.template.BlockTag
    public String getBlockStartMarker() {
        return "loop";
    }

    @Override // com.x5.template.BlockTag
    public String getBlockEndMarker() {
        return "/loop";
    }

    private void smartTrim(List<SnippetPart> list) {
        smartTrimSnippetParts(list, isTrimAll());
    }

    public static void smartTrimSnippetParts(List<SnippetPart> list, boolean z) {
        if (list == null || list.size() <= 0) {
            return;
        }
        SnippetPart snippetPart = list.get(0);
        if (snippetPart.isLiteral()) {
            snippetPart.setText(z ? trimLeft(snippetPart.getText()) : smartTrimString(snippetPart.getText(), true, false));
        }
        if (z) {
            SnippetPart snippetPart2 = list.get(list.size() - 1);
            if (snippetPart2.isLiteral()) {
                snippetPart2.setText(trimRight(snippetPart2.getText()));
            }
        }
    }

    private static String trimLeft(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        char cCharAt = str.charAt(0);
        while (true) {
            if ((cCharAt != '\n' && cCharAt != ' ' && cCharAt != '\r' && cCharAt != '\t') || (i = i + 1) == str.length()) {
                break;
            }
            cCharAt = str.charAt(i);
        }
        return i == 0 ? str : str.substring(i);
    }

    private static String trimRight(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length() - 1;
        char cCharAt = str.charAt(length);
        while (true) {
            if ((cCharAt != '\n' && cCharAt != ' ' && cCharAt != '\r' && cCharAt != '\t') || length - 1 == -1) {
                break;
            }
            cCharAt = str.charAt(length);
        }
        int i = length + 1;
        return i >= str.length() ? str : str.substring(0, i);
    }

    private boolean isTrimAll() {
        Map<String, Object> map = this.options;
        String str = map != null ? (String) map.get("trim") : null;
        return str != null && str.equals("all");
    }

    private static String smartTrimString(String str, boolean z, boolean z2) {
        if (!z && z2) {
            return str.trim();
        }
        Matcher matcher = UNIVERSAL_LF.matcher(str);
        if (matcher.find() && str.substring(0, matcher.start()).trim().length() == 0) {
            return str.substring(matcher.end());
        }
        return z ? str : str.trim();
    }

    private void initBody(Snippet snippet) {
        int i;
        List<SnippetPart> parts = snippet.getParts();
        int size = parts.size();
        int size2 = parts.size();
        int i2 = -1;
        int i3 = -1;
        for (int size3 = parts.size() - 1; size3 >= 0; size3--) {
            SnippetPart snippetPart = parts.get(size3);
            if (snippetPart.isTag()) {
                String tag = ((SnippetTag) snippetPart).getTag();
                if (tag.equals(".onEmpty")) {
                    i2 = size3;
                } else if (tag.equals(".divider")) {
                    i3 = size3;
                } else if (tag.equals("./divider")) {
                    size2 = size3;
                } else if (tag.equals("./onEmpty")) {
                    size = size3;
                }
            }
        }
        Map<String, Object> map = this.options;
        String str = map == null ? null : (String) map.get("trim");
        boolean z = str == null || !str.equalsIgnoreCase("false");
        if (i2 > -1 && i3 > -1) {
            if (i2 > i3) {
                size2 = Math.min(i2, size2);
                i = i3;
            } else {
                size = Math.min(i3, size);
                i = i2;
            }
            this.emptySnippet = extractParts(parts, i2 + 1, size, z);
            this.dividerSnippet = extractParts(parts, i3 + 1, size2, z);
            i2 = i;
        } else if (i2 > -1) {
            this.emptySnippet = extractParts(parts, i2 + 1, size, z);
            this.dividerSnippet = null;
        } else if (i3 > -1) {
            this.emptySnippet = null;
            this.dividerSnippet = extractParts(parts, i3 + 1, size2, z);
            i2 = i3;
        } else {
            this.emptySnippet = null;
            this.dividerSnippet = null;
            i2 = -1;
        }
        if (i2 > -1) {
            for (int size4 = parts.size() - 1; size4 >= i2; size4--) {
                parts.remove(size4);
            }
        }
        if (z) {
            smartTrim(parts);
        }
        this.rowSnippet = snippet;
    }

    private Snippet extractParts(List<SnippetPart> list, int i, int i2, boolean z) {
        ArrayList arrayList = new ArrayList();
        while (i < i2) {
            arrayList.add(list.get(i));
            i++;
        }
        if (z) {
            smartTrim(arrayList);
        }
        return new Snippet(arrayList);
    }

    @Override // com.x5.template.BlockTag
    public void renderBlock(Writer writer, Chunk chunk, String str, int i) throws IOException {
        if (this.dividerSnippet != null && !this.options.containsKey("dividerSnippet")) {
            this.options.put("dividerSnippet", this.dividerSnippet);
        }
        this.chunk = chunk;
        Map<String, Object> map = this.options;
        cookLoopToPrinter(writer, chunk, str, true, i, map != null ? fetchData((String) map.get("data"), str) : null);
    }
}
