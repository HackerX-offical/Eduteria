package com.x5.template;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.x5.template.filters.Calc;
import com.x5.util.DataCapsule;
import com.x5.util.DataCapsuleReader;
import com.x5.util.ObjectDataMap;
import com.x5.util.TableData;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Pattern;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes9.dex */
public class Chunk implements Map<String, Object> {
    public static final int DEPTH_LIMIT = 17;
    public static final int HASH_THRESH = 8;
    private static final Pattern INCLUDEIF_PATTERN = Pattern.compile("^\\.include(If|\\.\\()");
    private static final SimpleDateFormat LOG_DATE = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zZ ");
    private static final String TRUE = "TRUE";
    public static final String VERSION = "3.0.1";
    protected Snippet templateRoot = null;
    private String templateOrigin = null;
    private String[] firstTags = new String[8];
    private Object[] firstValues = new Object[8];
    private int tagCount = 0;
    protected Vector<Snippet> template = null;
    private Hashtable<String, Object> tags = null;
    protected String tagStart = TemplateSet.DEFAULT_TAG_START;
    protected String tagEnd = TemplateSet.DEFAULT_TAG_END;
    private Vector<Vector<Chunk>> contextStack = null;
    private ContentSource macroLibrary = null;
    private ChunkFactory chunkFactory = null;
    private String localeCode = null;
    private ChunkLocale locale = null;
    private boolean renderErrs = true;
    private PrintStream errLog = null;
    private Hashtable<String, ContentSource> altSources = null;

    void setMacroLibrary(ContentSource contentSource, ChunkFactory chunkFactory) {
        this.macroLibrary = contentSource;
        if (this.altSources != null) {
            addProtocol(contentSource);
        }
        this.chunkFactory = chunkFactory;
    }

    public ContentSource getTemplateSet() {
        return this.macroLibrary;
    }

    public void setChunkFactory(ChunkFactory chunkFactory) {
        this.chunkFactory = chunkFactory;
    }

    public ChunkFactory getChunkFactory() {
        return this.chunkFactory;
    }

    public void append(Snippet snippet) {
        if (this.templateRoot == null && this.template == null) {
            this.templateRoot = snippet;
            return;
        }
        Vector<Snippet> vector = this.template;
        if (vector == null) {
            Vector<Snippet> vector2 = new Vector<>();
            this.template = vector2;
            vector2.addElement(this.templateRoot);
            this.template.addElement(snippet);
            return;
        }
        vector.addElement(snippet);
    }

    public void append(String str) {
        if (str == null) {
            return;
        }
        append(Snippet.getSnippet(str));
    }

    public void append(Chunk chunk) {
        if (this.template == null) {
            Vector<Snippet> vector = new Vector<>();
            this.template = vector;
            Snippet snippet = this.templateRoot;
            if (snippet != null) {
                vector.addElement(snippet);
            }
        }
        String str = ";CHUNK_" + chunk.hashCode();
        set(str, chunk);
        this.template.addElement(Snippet.getSnippet(makeTag(str)));
    }

    public void set(String str, String str2) {
        set(str, str2, "");
    }

    public void set(String str, Chunk chunk) {
        set(str, chunk, "");
    }

    public void set(String str, Object obj) {
        set(str, obj, null);
    }

    public void setOrDelete(String str, Object obj) {
        if (obj == null) {
            if (containsKey(str)) {
                this.tags.remove(str);
                return;
            }
            return;
        }
        set(str, obj, null);
    }

    public void setLiteral(String str, String str2) {
        set(str, Snippet.makeLiteralSnippet(str2));
    }

    public void set(String str, Object obj, String str2) {
        if (str == null) {
            return;
        }
        if (obj != null) {
            obj = coercePrimitivesToStringAndBoxAliens(obj);
        }
        if (obj == null) {
            if (str2 == null) {
                str2 = "NULL";
            }
            obj = str2;
        }
        Hashtable<String, Object> hashtable = this.tags;
        if (hashtable != null) {
            hashtable.put(str, obj);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = this.tagCount;
            if (i >= i2) {
                if (i2 >= 8) {
                    this.tags = new Hashtable<>(16);
                    copyToHashtable();
                    this.tags.put(str, obj);
                    return;
                } else {
                    this.firstTags[i2] = str;
                    this.firstValues[i2] = obj;
                    this.tagCount = i2 + 1;
                    return;
                }
            }
            if (this.firstTags[i].equals(str)) {
                this.firstValues[i] = obj;
                return;
            }
            i++;
        }
    }

    public void setToBean(String str, Object obj) {
        setToBean(str, obj, null);
    }

    public void setToBean(String str, Object obj, String str2) {
        set(str, ObjectDataMap.wrapBean(obj), str2);
    }

    public void set(String str) {
        set(str, TRUE);
    }

    public void set(String str, int i) {
        set(str, Integer.toString(i));
    }

    public void set(String str, char c2) {
        set(str, Character.toString(c2));
    }

    public void set(String str, long j) {
        set(str, Long.toString(j));
    }

    public void set(String str, StringBuilder sb) {
        if (sb != null) {
            set(str, sb.toString());
        }
    }

    public void set(String str, StringBuffer stringBuffer) {
        if (stringBuffer != null) {
            set(str, stringBuffer.toString());
        }
    }

    public void unset(String str) {
        if (str != null) {
            setOrDelete(str, null);
        }
    }

    public boolean hasValue(String str) {
        if (str == null) {
            return false;
        }
        Hashtable<String, Object> hashtable = this.tags;
        if (hashtable != null) {
            return hashtable.containsKey(str);
        }
        for (int i = 0; i < this.tagCount; i++) {
            if (this.firstTags[i].equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean stillNeeds(String str) {
        if (str == null) {
            return false;
        }
        return !hasValue(str);
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            render(stringWriter);
            stringWriter.flush();
            return stringWriter.toString();
        } catch (IOException e2) {
            return e2.getLocalizedMessage();
        }
    }

    public String toString(Chunk chunk) {
        StringWriter stringWriter = new StringWriter();
        try {
            render(stringWriter, chunk);
            stringWriter.flush();
            return stringWriter.toString();
        } catch (IOException e2) {
            return e2.getLocalizedMessage();
        }
    }

    public void render(PrintStream printStream) throws IOException {
        PrintWriter printWriter = new PrintWriter(printStream);
        render(printWriter);
        printWriter.flush();
    }

    public void render(Writer writer) throws IOException {
        explodeForParentToPrinter(writer, null);
    }

    public void render(Writer writer, Chunk chunk) throws IOException {
        explodeForParentToPrinter(writer, chunk.prepareParentContext());
    }

    private void pushContextStack(Vector<Chunk> vector) {
        if (this.contextStack == null) {
            this.contextStack = new Vector<>();
        }
        this.contextStack.insertElementAt(vector, 0);
    }

    private void popContextStack() {
        Vector<Vector<Chunk>> vector = this.contextStack;
        if (vector == null || vector.size() == 0) {
            return;
        }
        this.contextStack.removeElementAt(0);
    }

    private void explodeForParentToPrinter(Writer writer, Vector<Chunk> vector) throws IOException {
        if (this.template == null && this.templateRoot == null) {
            return;
        }
        if (vector != null) {
            synchronized (this) {
                pushContextStack(vector);
                renderForParentToPrinter(writer);
                popContextStack();
            }
            return;
        }
        renderForParentToPrinter(writer);
    }

    private void renderForParentToPrinter(Writer writer) throws IOException {
        Vector<Snippet> vector = this.template;
        if (vector == null) {
            explodeToPrinter(writer, this.templateRoot, 1);
            return;
        }
        if (vector.size() > 1) {
            this.template = mergeTemplateParts();
        }
        for (int i = 0; i < this.template.size(); i++) {
            explodeToPrinter(writer, this.template.elementAt(i), 1);
        }
    }

    private Vector<Snippet> mergeTemplateParts() {
        try {
            Snippet snippetConsolidateSnippets = Snippet.consolidateSnippets(this.template);
            Vector<Snippet> vector = new Vector<>();
            vector.add(snippetConsolidateSnippets);
            return vector;
        } catch (EndOfSnippetException unused) {
            return this.template;
        }
    }

    void explodeToPrinter(Writer writer, Object obj, int i) throws IOException {
        if (i >= 17) {
            String strHandleError = handleError("[**ERR** max template recursions: 17]");
            if (strHandleError != null) {
                writer.append((CharSequence) strHandleError);
                return;
            }
            return;
        }
        if (obj instanceof Snippet) {
            ((Snippet) obj).render(writer, this, i);
            return;
        }
        if (obj instanceof String) {
            explodeToPrinter(writer, Snippet.getSnippet((String) obj), i);
            return;
        }
        if (obj instanceof Chunk) {
            ((Chunk) obj).explodeForParentToPrinter(writer, prepareParentContext());
            return;
        }
        if (obj instanceof DataCapsule[]) {
            String strHandleError2 = handleError("[LIST(" + DataCapsuleReader.getReader((DataCapsule[]) obj).getDataClassName() + ") - Use a loop construct to display list data.]");
            if (strHandleError2 != null) {
                writer.append((CharSequence) strHandleError2);
                return;
            }
            return;
        }
        if (obj instanceof String[]) {
            String strHandleError3 = handleError("[LIST(java.lang.String) - Use a loop construct to display list data, or pipe to join().]");
            if (strHandleError3 != null) {
                writer.append((CharSequence) strHandleError3);
                return;
            }
            return;
        }
        if (obj instanceof List) {
            String strHandleError4 = handleError("[LIST - Use a loop construct to display list data, or pipe to join().]");
            if (strHandleError4 != null) {
                writer.append((CharSequence) strHandleError4);
                return;
            }
            return;
        }
        explodeToPrinter(writer, ObjectDataMap.getAsString(obj), i);
    }

    private Vector<Chunk> prepareParentContext() {
        Vector<Vector<Chunk>> vector = this.contextStack;
        if (vector == null) {
            Vector<Chunk> vector2 = new Vector<>();
            vector2.add(this);
            return vector2;
        }
        Vector<Chunk> vector3 = (Vector) vector.firstElement().clone();
        vector3.insertElementAt(this, 0);
        return vector3;
    }

    private Vector<Chunk> getCurrentParentContext() {
        Vector<Vector<Chunk>> vector = this.contextStack;
        if (vector == null || vector.size() == 0) {
            return null;
        }
        return this.contextStack.firstElement();
    }

    public Object getTagValue(String str) {
        Hashtable<String, Object> hashtable = this.tags;
        if (hashtable != null) {
            Object obj = hashtable.get(str);
            if (obj instanceof String) {
                Snippet snippet = Snippet.getSnippet((String) obj);
                this.tags.put(str, snippet);
                return snippet.isSimple() ? snippet.toString() : snippet;
            }
            boolean z = obj instanceof Snippet;
            Object obj2 = obj;
            if (z) {
                Snippet snippet2 = (Snippet) obj;
                boolean zIsSimple = snippet2.isSimple();
                obj2 = snippet2;
                if (zIsSimple) {
                    return snippet2.toString();
                }
            }
            return obj2;
        }
        for (int i = 0; i < this.tagCount; i++) {
            if (this.firstTags[i].equals(str)) {
                Object obj3 = this.firstValues[i];
                if (obj3 instanceof String) {
                    Snippet snippet3 = Snippet.getSnippet((String) obj3);
                    this.firstValues[i] = snippet3;
                    return snippet3.isSimple() ? snippet3.toString() : snippet3;
                }
                if (!(obj3 instanceof Snippet)) {
                    return obj3;
                }
                Snippet snippet4 = (Snippet) obj3;
                return snippet4.isSimple() ? snippet4.toString() : snippet4;
            }
        }
        return null;
    }

    public void addProtocol(ContentSource contentSource) {
        if (this.altSources == null) {
            Hashtable<String, ContentSource> hashtable = new Hashtable<>();
            this.altSources = hashtable;
            ContentSource contentSource2 = this.macroLibrary;
            if (contentSource2 != null) {
                hashtable.put(contentSource2.getProtocol(), this.macroLibrary);
            }
        }
        this.altSources.put(contentSource.getProtocol(), contentSource);
    }

    private Object altFetch(String str, int i) {
        return altFetch(str, i, false);
    }

    private Object altFetch(String str, int i, boolean z) {
        ContentSource contentSource;
        Vector<Chunk> currentParentContext;
        if (str.startsWith(".calc(")) {
            try {
                return Calc.evalCalc(str, this);
            } catch (NoClassDefFoundError unused) {
                return handleError("[ERROR: jeplite jar missing from classpath! .calc command requires jeplite library]");
            }
        }
        if (str.startsWith(".version")) {
            return VERSION;
        }
        if (str.startsWith(".loop")) {
            return LoopTag.expandLoop(str, this, this.templateOrigin, i);
        }
        if (str.startsWith(".tagStack")) {
            return formatTagStack(str.contains("html") ? "html" : "text");
        }
        String strFetch = null;
        if (this.altSources == null && this.macroLibrary == null && getCurrentParentContext() == null) {
            return null;
        }
        if (INCLUDEIF_PATTERN.matcher(str).find()) {
            return Filter.translateIncludeIf(str, this.tagStart, this.tagEnd, this);
        }
        int iIndexOf = str.indexOf(InstructionFileId.DOT, 1);
        int iIndexOf2 = str.indexOf(" ", 1);
        if (iIndexOf < 0 && iIndexOf2 < 0) {
            if (str.startsWith("./")) {
                return null;
            }
            return handleError("[CHUNK_ERR: malformed content reference: '" + str + "' -- missing argument]");
        }
        if (iIndexOf2 > 0 && (iIndexOf < 0 || iIndexOf2 < iIndexOf)) {
            iIndexOf = iIndexOf2;
        }
        String strSubstring = str.substring(1, iIndexOf);
        String strReplaceAll = str.substring(iIndexOf + 1).replaceAll("[\\|:].*$", "");
        Hashtable<String, ContentSource> hashtable = this.altSources;
        if (hashtable != null) {
            contentSource = hashtable.get(strSubstring);
        } else {
            ContentSource contentSource2 = this.macroLibrary;
            contentSource = (contentSource2 == null || !strSubstring.equals(contentSource2.getProtocol())) ? null : this.macroLibrary;
        }
        if (contentSource != null) {
            if (contentSource instanceof Theme) {
                Snippet snippet = ((Theme) contentSource).getSnippet(BlockTag.qualifyTemplateRef(this.templateOrigin, strReplaceAll));
                if (snippet != null) {
                    return snippet;
                }
            } else {
                strFetch = contentSource.fetch(strReplaceAll);
            }
        }
        if (strFetch == null && !z && (currentParentContext = getCurrentParentContext()) != null) {
            Iterator<Chunk> it = currentParentContext.iterator();
            while (it.hasNext()) {
                Object objAltFetch = it.next().altFetch(str, i, true);
                if (objAltFetch != null) {
                    return objAltFetch;
                }
            }
        }
        return strFetch;
    }

    private String resolveBackticks(String str, int i) {
        int i2;
        int iIndexOf;
        int iIndexOf2 = str.indexOf(96);
        if (iIndexOf2 >= 0 && (iIndexOf = str.indexOf(96, (i2 = iIndexOf2 + 1))) >= 0) {
            String strSubstring = str.substring(iIndexOf2 + 2, iIndexOf);
            char cCharAt = str.charAt(i2);
            if (cCharAt == '^' || cCharAt == '.') {
                strSubstring = InstructionFileId.DOT + strSubstring;
            } else if (cCharAt == '~' || cCharAt == '$') {
            }
            Object objResolveTagValue = resolveTagValue(strSubstring, i);
            if (objResolveTagValue != null) {
                return resolveBackticks(str.substring(0, iIndexOf2) + objResolveTagValue + str.substring(iIndexOf + 1), i);
            }
        }
        return str;
    }

    protected Object resolveTagValue(SnippetTag snippetTag, int i, String str) {
        if (str == null) {
            return _resolveTagValue(snippetTag, i, false);
        }
        this.templateOrigin = str;
        Object obj_resolveTagValue = _resolveTagValue(snippetTag, i, false);
        this.templateOrigin = null;
        return obj_resolveTagValue;
    }

    protected Object resolveTagValue(SnippetTag snippetTag, int i) {
        return _resolveTagValue(snippetTag, i, false);
    }

    protected Object _resolveTagValue(SnippetTag snippetTag, int i, boolean z) {
        Object tagValue;
        Object objApplyFilter;
        String[] path = snippetTag.getPath();
        String strResolveBackticks = path[0];
        if (strResolveBackticks.indexOf(96) > -1) {
            strResolveBackticks = resolveBackticks(strResolveBackticks, i);
        }
        if (strResolveBackticks.charAt(0) == '.') {
            tagValue = altFetch(strResolveBackticks, i);
        } else if (hasValue(strResolveBackticks)) {
            tagValue = getTagValue(strResolveBackticks);
        } else {
            if (z) {
                return null;
            }
            Vector<Chunk> currentParentContext = getCurrentParentContext();
            if (currentParentContext != null) {
                Iterator<Chunk> it = currentParentContext.iterator();
                Object tagValue2 = null;
                while (it.hasNext() && (tagValue2 = it.next().getTagValue(strResolveBackticks)) == null) {
                }
                tagValue = tagValue2;
            } else {
                tagValue = null;
            }
        }
        int i2 = 1;
        while (path.length > i2 && tagValue != null) {
            if (tagValue instanceof Map) {
                String strResolveBackticks2 = resolveBackticks(path[i2], i);
                tagValue = ((Map) tagValue).get(strResolveBackticks2);
                int i3 = i2 + 1;
                if (tagValue == null && path.length == i3) {
                    tagValue = getTagValue(path[i2 - 1] + InstructionFileId.DOT + strResolveBackticks2);
                }
                i2 = i3;
            } else {
                tagValue = null;
            }
        }
        if (tagValue != null && !(tagValue instanceof String)) {
            tagValue = coercePrimitivesToStringAndBoxAliens(tagValue);
        }
        String filters = snippetTag.getFilters();
        if (tagValue == null) {
            String defaultValue = snippetTag.getDefaultValue();
            return (filters == null || !(snippetTag.applyFiltersFirst() || defaultValue == null) || (objApplyFilter = Filter.applyFilter(this, filters, null)) == null) ? (snippetTag.applyFiltersFirst() || filters == null) ? defaultValue : Filter.applyFilter(this, filters, defaultValue) : objApplyFilter;
        }
        if (filters == null) {
            return tagValue;
        }
        Object objApplyFilter2 = Filter.applyFilter(this, filters, tagValue);
        return (objApplyFilter2 == null && snippetTag.applyFiltersFirst()) ? snippetTag.getDefaultValue() : objApplyFilter2;
    }

    private Object coercePrimitivesToStringAndBoxAliens(Object obj) {
        if (obj == null) {
            return obj;
        }
        if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                return TRUE;
            }
            return null;
        }
        if (obj != null && ObjectDataMap.isWrapperType(obj.getClass())) {
            return obj.toString();
        }
        return boxIfAlienObject(obj);
    }

    private Object boxIfAlienObject(Object obj) {
        return (obj == null || (obj instanceof Chunk) || (obj instanceof TableData) || (obj instanceof Map) || (obj instanceof String) || (obj instanceof Snippet) || (obj instanceof List) || (obj instanceof Object[])) ? obj : new ObjectDataMap(obj);
    }

    protected Object resolveTagValue(String str, int i) {
        return _resolveTagValue(SnippetTag.parseTag(str), i, false);
    }

    public void resetTags() {
        Hashtable<String, Object> hashtable = this.tags;
        if (hashtable != null) {
            hashtable.clear();
        } else {
            this.tagCount = 0;
        }
    }

    @Override // java.util.Map
    public void clear() {
        resetTags();
    }

    public void resetTemplate() {
        Vector<Snippet> vector = this.template;
        if (vector == null) {
            this.templateRoot = null;
        } else {
            vector.clear();
        }
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        if (this.tags == null) {
            this.tags = new Hashtable<>();
            copyToHashtable();
        }
        return this.tags.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        if (this.tags == null) {
            this.tags = new Hashtable<>();
            copyToHashtable();
        }
        return this.tags.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        if (this.tags == null) {
            this.tags = new Hashtable<>();
            copyToHashtable();
        }
        return this.tags.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (this.tags == null) {
            this.tags = new Hashtable<>();
            copyToHashtable();
        }
        return this.tags.equals(obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return resolveTagValue((String) obj, 1);
    }

    @Override // java.util.Map
    public int hashCode() {
        if (this.tags == null) {
            this.tags = new Hashtable<>();
            copyToHashtable();
        }
        return this.tags.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        Hashtable<String, Object> hashtable = this.tags;
        if (hashtable == null) {
            return this.tagCount == 0;
        }
        return hashtable.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        if (this.tags == null) {
            this.tags = new Hashtable<>();
            copyToHashtable();
        }
        return this.tags.keySet();
    }

    @Override // java.util.Map
    public Object put(String str, Object obj) {
        Object tagValue = getTagValue(str);
        set(str, obj, "");
        return tagValue;
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        if (map == null || map.size() < 0) {
            return;
        }
        for (String str : map.keySet()) {
            set(str, map.get(str), "");
        }
    }

    @Override // java.util.Map
    public int size() {
        Hashtable<String, Object> hashtable = this.tags;
        return hashtable != null ? hashtable.size() : this.tagCount;
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        if (this.tags == null) {
            this.tags = new Hashtable<>();
            copyToHashtable();
        }
        return this.tags.values();
    }

    public void setMultiple(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        for (String str : map.keySet()) {
            setOrDelete(str, map.get(str));
        }
    }

    public void setMultiple(Chunk chunk) {
        if (chunk != null) {
            setMultiple(chunk.getTagsTable());
        }
    }

    public Map<String, Object> getTagsTable() {
        Hashtable<String, Object> hashtable = this.tags;
        if (hashtable != null) {
            return hashtable;
        }
        if (this.tagCount <= 0) {
            return null;
        }
        copyToHashtable();
        return this.tags;
    }

    private void copyToHashtable() {
        if (this.tags == null) {
            this.tags = new Hashtable<>(this.tagCount * 2);
        }
        for (int i = 0; i < this.tagCount; i++) {
            this.tags.put(this.firstTags[i], this.firstValues[i]);
        }
    }

    private String formatTagStack(String str) {
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder();
        if (!str.equals("html")) {
            str2 = "\n";
            str3 = "  ";
        } else {
            str2 = "<br/>\n";
            str3 = "&nbsp;&nbsp;";
        }
        sb.append("Available tags:");
        sb.append(str2);
        outputTags(sb, str2, str3, 0);
        Vector<Chunk> currentParentContext = getCurrentParentContext();
        if (currentParentContext != null) {
            Iterator<Chunk> it = currentParentContext.iterator();
            int i = 1;
            while (it.hasNext()) {
                it.next().outputTags(sb, str2, str3, i);
                i++;
            }
        }
        return sb.toString();
    }

    private void outputTags(StringBuilder sb, String str, String str2, int i) {
        ArrayList<String> arrayList = new ArrayList();
        Hashtable<String, Object> hashtable = this.tags;
        if (hashtable == null) {
            for (int i2 = 0; i2 < this.tagCount; i2++) {
                arrayList.add(this.firstTags[i2]);
            }
        } else {
            arrayList.addAll(hashtable.keySet());
        }
        Collections.sort(arrayList);
        for (String str3 : arrayList) {
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(str2);
            }
            sb.append(Typography.dollar);
            sb.append(str3);
            sb.append(str);
        }
    }

    public void addData(DataCapsule dataCapsule) {
        DataCapsuleReader reader = DataCapsuleReader.getReader(dataCapsule);
        String[] columnLabels = reader.getColumnLabels(null);
        Object[] objArrExtractData = reader.extractData(dataCapsule);
        for (int i = 0; i < columnLabels.length; i++) {
            Object obj = objArrExtractData[i];
            if (obj == null || (obj instanceof String) || (obj instanceof DataCapsule)) {
                setOrDelete(columnLabels[i], obj);
            } else {
                set(columnLabels[i], obj.toString());
            }
        }
    }

    public void addData(DataCapsule dataCapsule, String str) {
        if (dataCapsule == null) {
            return;
        }
        if (str == null) {
            addData(dataCapsule);
        } else {
            set(str, dataCapsule);
        }
    }

    public String makeTag(String str) {
        return this.tagStart + str + this.tagEnd;
    }

    public void setErrorHandling(boolean z, PrintStream printStream) {
        this.renderErrs = z;
        this.errLog = printStream;
    }

    boolean renderErrorsToOutput() {
        return this.renderErrs;
    }

    private String handleError(String str) {
        logError(str);
        if (this.renderErrs) {
            return str;
        }
        return null;
    }

    void logError(String str) {
        logChunkError(this.errLog, str);
    }

    static void logChunkError(PrintStream printStream, String str) {
        if (printStream != null) {
            printStream.print(LOG_DATE.format(new Date()));
            printStream.println(str);
        }
    }

    public void setLocale(String str) {
        this.localeCode = str;
    }

    public void setLocale(Locale locale) {
        if (locale == null) {
            this.localeCode = null;
        } else {
            setLocale(locale.toString().replace('-', '_'));
        }
    }

    public void setLocale(ChunkLocale chunkLocale) {
        if (chunkLocale == null) {
            this.localeCode = null;
        } else {
            setLocale(chunkLocale.toString());
        }
    }

    public ChunkLocale getLocale() {
        String str = this.localeCode;
        if (str == null) {
            return null;
        }
        if (this.locale == null) {
            this.locale = ChunkLocale.getInstance(str, this);
        }
        return this.locale;
    }

    public static String findAndReplace(String str, String str2, String str3) {
        if (str2 == null || str == null || str.indexOf(str2) == -1) {
            return str;
        }
        if (str3 == null) {
            str3 = "";
        }
        int length = str2.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int iIndexOf = str.indexOf(str2, i);
            if (iIndexOf > -1) {
                sb.append(str.substring(i, iIndexOf));
                sb.append(str3);
                i = iIndexOf + length;
            } else {
                sb.append(str.substring(i));
                return sb.toString();
            }
        }
    }

    public String getTemplateOrigin() {
        return this.templateOrigin;
    }
}
