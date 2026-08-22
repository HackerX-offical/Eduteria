package com.x5.template;

import com.x5.util.LiteXml;
import cz.msebera.android.httpclient.HttpStatus;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.ContainerFactory;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

/* JADX INFO: loaded from: classes9.dex */
public class MacroTag extends BlockTag {
    private static final String FMT_JSON_LAX = "json";
    private static final String FMT_JSON_STRICT = "json-strict";
    private static final String FMT_ORIGINAL = "original";
    private static final String FMT_XML = "xml";
    public static final String MACRO_END_MARKER = "/exec";
    private String dataFormat;
    private List<String> inputErrs;
    private Map<String, Object> macroDefs;
    private Snippet template;
    private String templateRef;
    public static final String MACRO_MARKER = "exec";
    private static final int ARG_START = MACRO_MARKER.length() + 2;

    @Override // com.x5.template.BlockTag
    public boolean doSmartTrimAroundBlock() {
        return true;
    }

    public MacroTag() {
        this.dataFormat = FMT_ORIGINAL;
        this.inputErrs = null;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: net.minidev.json.parser.ParseException */
    public MacroTag(String str, Snippet snippet) throws ParseException {
        this.dataFormat = FMT_ORIGINAL;
        this.inputErrs = null;
        int length = str.length();
        int i = ARG_START;
        if (length > i) {
            String strTrim = str.substring(i).trim();
            this.templateRef = strTrim;
            int iIndexOf = strTrim.indexOf(32);
            if (iIndexOf > 0) {
                String lowerCase = this.templateRef.substring(iIndexOf + 1).toLowerCase();
                this.dataFormat = lowerCase;
                if (lowerCase.charAt(0) == '@') {
                    this.dataFormat = this.dataFormat.substring(1);
                }
                this.templateRef = this.templateRef.substring(0, iIndexOf);
            }
            if (this.templateRef.charAt(0) == '@') {
                if (!this.templateRef.startsWith("@inline") && iIndexOf < 0) {
                    this.dataFormat = this.templateRef.substring(1).toLowerCase();
                }
                this.templateRef = null;
            }
        }
        Snippet snippetCopy = snippet.copy();
        if (this.templateRef == null) {
            parseInlineTemplate(snippetCopy);
        }
        parseDefs(snippetCopy);
    }

    private void parseInlineTemplate(Snippet snippet) {
        List<SnippetPart> parts = snippet.getParts();
        int size = parts.size();
        for (int i = size - 1; i >= 0; i--) {
            SnippetPart snippetPart = parts.get(i);
            if (snippetPart.isTag()) {
                SnippetTag snippetTag = (SnippetTag) snippetPart;
                if (snippetTag.getTag().equals("./body") || snippetTag.getTag().startsWith(".data")) {
                    size = i;
                } else if (snippetTag.getTag().equals(".body")) {
                    Snippet snippet2 = new Snippet(parts, i + 1, size);
                    snippet2.setOrigin(snippet.getOrigin());
                    LoopTag.smartTrimSnippetParts(snippet2.getParts(), false);
                    this.template = snippet2;
                    for (int i2 = size - 1; i2 >= i; i2--) {
                        parts.remove(i2);
                    }
                    return;
                }
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: net.minidev.json.parser.ParseException */
    private void parseDefs(Snippet snippet) throws ParseException {
        Snippet snippetStripCasing = stripCasing(snippet);
        if (this.dataFormat.equals(FMT_ORIGINAL)) {
            parseDefsOriginal(snippetStripCasing);
            return;
        }
        if (this.dataFormat.equals(FMT_JSON_STRICT)) {
            parseDefsJsonStrict(snippetStripCasing);
        } else if (this.dataFormat.equals("json")) {
            parseDefsJsonLax(snippetStripCasing);
        } else if (this.dataFormat.equals("xml")) {
            parseDefsXML(snippetStripCasing);
        }
    }

    private Snippet stripCasing(Snippet snippet) {
        List<SnippetPart> parts = snippet.getParts();
        if (parts != null) {
            int size = parts.size();
            int i = -1;
            for (int i2 = 0; i2 < size; i2++) {
                SnippetPart snippetPart = parts.get(i2);
                if (snippetPart.isTag()) {
                    String tag = ((SnippetTag) snippetPart).getTag();
                    if (tag.startsWith(".data")) {
                        parseDataFormat(tag);
                        i = i2;
                    } else if (tag.equals("./data")) {
                        size = i2;
                    }
                }
            }
            if (i != -1) {
                Snippet snippet2 = new Snippet(parts, i + 1, size);
                if (this.templateRef == null && this.template == null) {
                    LoopTag.smartTrimSnippetParts(parts.subList(0, i), false);
                    if (size < parts.size()) {
                        LoopTag.smartTrimSnippetParts(parts.subList(size + 1, parts.size()), false);
                        parts.remove(size);
                    }
                    for (int i3 = size - 1; i3 >= i; i3--) {
                        parts.remove(i3);
                    }
                    this.template = snippet;
                }
                return snippet2;
            }
        }
        return snippet;
    }

    private void parseDataFormat(String str) {
        if (str.length() < 6) {
            return;
        }
        String strSubstring = str.substring(5);
        Map<String, Object> map = Attributes.parse(strSubstring);
        if (map != null && map.containsKey("format")) {
            strSubstring = (String) map.get("format");
        }
        String strTrim = strSubstring.trim();
        if (strTrim.startsWith("@")) {
            strTrim = strTrim.substring(1);
        }
        this.dataFormat = strTrim;
    }

    private void parseDefsJsonLax(Snippet snippet) {
        snippet.setOrigin(null);
        String string = snippet.toString();
        try {
            Class.forName("net.minidev.json.JSONValue");
        } catch (ClassNotFoundException unused) {
            logInputError("Error: template uses json-formatted args in exec, but json-smart jar is not in the classpath!");
        }
        Object keepingOrder = JSONValue.parseKeepingOrder(string);
        if (keepingOrder instanceof Map) {
            importJSONDefs((Map) keepingOrder);
            return;
        }
        if ((keepingOrder instanceof JSONArray) || (keepingOrder instanceof List)) {
            logInputError("Error processing template: exec expected JSON object, not JSON array.");
        } else {
            if (!(keepingOrder instanceof String) || keepingOrder.toString().trim().length() <= 0) {
                return;
            }
            logInputError("Error processing template: exec expected JSON object, not String.");
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: net.minidev.json.parser.ParseException */
    private void parseDefsJsonStrict(Snippet snippet) throws ParseException {
        try {
            snippet.setOrigin(null);
            String string = snippet.toString();
            try {
                Class.forName("net.minidev.json.JSONValue");
            } catch (ClassNotFoundException unused) {
                logInputError("Error: template uses json-formatted args in exec, but json-smart jar is not in the classpath!");
            }
            Object strictJsonKeepingOrder = parseStrictJsonKeepingOrder(string);
            if (strictJsonKeepingOrder instanceof Map) {
                importJSONDefs((Map) strictJsonKeepingOrder);
                return;
            }
            if (!(strictJsonKeepingOrder instanceof JSONArray) && !(strictJsonKeepingOrder instanceof List)) {
                if (!(strictJsonKeepingOrder instanceof String) || strictJsonKeepingOrder.toString().trim().length() <= 0) {
                    return;
                }
                logInputError("Error processing template: exec expected JSON object, not String.");
                return;
            }
            logInputError("Error processing template: exec expected JSON object, not JSON array.");
        } catch (Exception e2) {
            e2.printStackTrace(System.err);
        }
    }

    private void logInputError(String str) {
        if (this.inputErrs == null) {
            this.inputErrs = new ArrayList();
        }
        this.inputErrs.add(str);
    }

    private Object parseStrictJsonKeepingOrder(String str) throws ParseException {
        return new JSONParser(HttpStatus.SC_BAD_REQUEST).parse(str, ContainerFactory.FACTORY_ORDERED);
    }

    private void importJSONDefs(Map<String, Object> map) {
        this.macroDefs = map;
    }

    private void parseDefsXML(Snippet snippet) {
        snippet.setOrigin(null);
        this.macroDefs = parseXMLObject(new LiteXml(snippet.toString()));
    }

    private Map<String, Object> parseXMLObject(LiteXml liteXml) {
        LiteXml[] childNodes = liteXml.getChildNodes();
        if (childNodes == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (LiteXml liteXml2 : childNodes) {
            String nodeType = liteXml2.getNodeType();
            if (liteXml2.getChildNodes() == null) {
                map.put(nodeType, liteXml2.getNodeValue());
            } else {
                map.put(nodeType, parseXMLObject(liteXml2));
            }
            Map<String, String> attributes = liteXml2.getAttributes();
            if (attributes != null) {
                for (String str : attributes.keySet()) {
                    map.put(nodeType + "@" + str, attributes.get(str));
                }
            }
        }
        return map;
    }

    private void parseDefsOriginal(Snippet snippet) {
        List<SnippetPart> parts = snippet.getParts();
        if (parts == null) {
            return;
        }
        int i = 0;
        while (i < parts.size()) {
            SnippetPart snippetPart = parts.get(i);
            if (snippetPart.isTag()) {
                String tag = ((SnippetTag) snippetPart).getTag();
                if (tag.trim().endsWith("=")) {
                    int i2 = i + 1;
                    int iFindMatchingDefEnd = findMatchingDefEnd(parts, i2);
                    Snippet snippet2 = new Snippet(parts, i2, iFindMatchingDefEnd);
                    snippet2.setOrigin(snippet.getOrigin());
                    saveDef(tag.substring(0, tag.length() - 1), snippet2);
                    if (iFindMatchingDefEnd < parts.size() && parts.get(iFindMatchingDefEnd).getText().equals("{=}")) {
                        iFindMatchingDefEnd++;
                    }
                    i = iFindMatchingDefEnd;
                } else {
                    String[] simpleDef = getSimpleDef(tag);
                    if (simpleDef != null) {
                        saveDef(simpleDef[0], simpleDef[1], snippet.getOrigin());
                    }
                }
            }
            i++;
        }
    }

    private int findMatchingDefEnd(List<SnippetPart> list, int i) {
        int size = list.size();
        while (i < size) {
            SnippetPart snippetPart = list.get(i);
            if (snippetPart.isTag()) {
                String tag = ((SnippetTag) snippetPart).getTag();
                char c2 = '=';
                int iIndexOf = tag.indexOf(61);
                if (iIndexOf >= 0) {
                    if (tag.length() != 1) {
                        char[] charArray = tag.toCharArray();
                        char c3 = 0;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= iIndexOf) {
                                c3 = c2;
                                break;
                            }
                            c2 = charArray[i2];
                            if (c2 == '.' || c2 == '|' || c2 == ':' || c2 == '(') {
                                break;
                            }
                            i2++;
                        }
                        if (c3 == 0) {
                        }
                    }
                    return i;
                }
                continue;
            }
            i++;
        }
        return size;
    }

    private String[] getSimpleDef(String str) {
        int iIndexOf = str.indexOf(61);
        if (iIndexOf <= -1) {
            return null;
        }
        String strTrim = str.substring(0, iIndexOf).trim();
        String strSubstring = str.substring(iIndexOf + 1);
        if (strSubstring.charAt(0) == ' ' && str.charAt(iIndexOf - 1) == ' ') {
            strSubstring = strSubstring.trim();
        }
        return new String[]{strTrim, strSubstring};
    }

    private void saveDef(String str, String str2, String str3) {
        if (str == null || str2 == null) {
            return;
        }
        saveDef(str, Snippet.getSnippet(str2, str3));
    }

    private void saveDef(String str, Snippet snippet) {
        if (str == null || snippet == null) {
            return;
        }
        if (this.macroDefs == null) {
            this.macroDefs = new HashMap();
        }
        this.macroDefs.put(str, snippet);
    }

    @Override // com.x5.template.BlockTag
    public void renderBlock(Writer writer, Chunk chunk, String str, int i) throws IOException {
        Chunk chunk2;
        Set<String> setKeySet;
        ChunkFactory chunkFactory = chunk.getChunkFactory();
        String str2 = this.templateRef;
        if (str2 != null && chunkFactory != null) {
            String strQualifyTemplateRef = qualifyTemplateRef(str, str2);
            this.templateRef = strQualifyTemplateRef;
            chunk2 = chunkFactory.makeChunk(strQualifyTemplateRef);
        } else {
            if (this.template == null) {
                return;
            }
            chunk2 = chunkFactory == null ? new Chunk() : chunkFactory.makeChunk();
            chunk2.append(this.template);
        }
        if (this.inputErrs != null) {
            if (chunk.renderErrorsToOutput()) {
                for (String str3 : this.inputErrs) {
                    writer.append('[');
                    writer.append((CharSequence) str3);
                    writer.append(']');
                }
            }
            Iterator<String> it = this.inputErrs.iterator();
            while (it.hasNext()) {
                chunk.logError(it.next());
            }
        }
        Map<String, Object> map = this.macroDefs;
        if (map != null && (setKeySet = map.keySet()) != null) {
            for (String str4 : setKeySet) {
                chunk2.setOrDelete(str4, resolvePointers(chunk, str, this.macroDefs.get(str4), 0));
            }
        }
        chunk2.render(writer, chunk);
    }

    private Object resolvePointers(Chunk chunk, String str, Object obj, int i) {
        Object objResolveTagValue;
        if (i > 10) {
            return obj;
        }
        if (obj instanceof String) {
            obj = Snippet.getSnippet((String) obj, str);
        }
        if (obj instanceof Snippet) {
            Snippet snippet = (Snippet) obj;
            if (snippet.isSimplePointer() && (objResolveTagValue = chunk.resolveTagValue(snippet.getPointerTag(), 1, str)) != null) {
                return resolvePointers(chunk, str, objResolveTagValue, i + 1);
            }
        }
        return obj;
    }

    @Override // com.x5.template.BlockTag
    public String getBlockStartMarker() {
        return MACRO_MARKER;
    }

    @Override // com.x5.template.BlockTag
    public String getBlockEndMarker() {
        return MACRO_END_MARKER;
    }
}
