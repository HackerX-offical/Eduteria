package com.x5.template;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.clevertap.android.sdk.Constants;
import com.csvreader.CsvReader;
import com.x5.template.TemplateDoc;
import com.x5.template.filters.ChunkFilter;
import com.x5.template.filters.RegexFilter;
import com.x5.util.JarResource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes9.dex */
public class TemplateSet implements ContentSource, ChunkFactory {
    public static final String BLOCKEND_LONGHAND = "{~./";
    public static final String BLOCKEND_SHORTHAND = "{/";
    private static final String DEFAULT_EXTENSION = "chtml";
    private static final int DEFAULT_REFRESH = 15;
    public static String DEFAULT_TAG_END = "}";
    public static String DEFAULT_TAG_START = "{$";
    public static final String INCLUDE_SHORTHAND = "{+";
    private static final long MIN_CACHE = 5000;
    public static final String PROTOCOL_SHORTHAND = "{.";
    private static final long oneMinuteInMillis = 60000;
    private HashSet<ContentSource> altSources;
    private Hashtable<String, Snippet> cache;
    private Hashtable<String, Long> cacheFetch;
    private Class<?> classInJar;
    private String defaultExtension;
    private int dirtyInterval;
    private String expectedEncoding;
    private String layerName;
    private boolean prettyFail;
    private Object resourceContext;
    private String tagEnd;
    private String tagStart;
    private String templatePath;

    @Override // com.x5.template.ChunkFactory
    public Map<String, ChunkFilter> getFilters() {
        return null;
    }

    public TemplateSet() {
        this.cache = new Hashtable<>();
        this.cacheFetch = new Hashtable<>();
        this.dirtyInterval = 15;
        this.defaultExtension = DEFAULT_EXTENSION;
        this.tagStart = DEFAULT_TAG_START;
        this.tagEnd = DEFAULT_TAG_END;
        this.templatePath = System.getProperty("templateset.folder", "");
        this.layerName = null;
        this.classInJar = null;
        this.resourceContext = null;
        this.prettyFail = true;
        this.expectedEncoding = TemplateDoc.getDefaultEncoding();
        this.altSources = null;
    }

    public TemplateSet(String str) {
        this(str, DEFAULT_EXTENSION, 15);
    }

    public TemplateSet(String str, String str2, int i) {
        this.cache = new Hashtable<>();
        this.cacheFetch = new Hashtable<>();
        this.dirtyInterval = 15;
        this.defaultExtension = DEFAULT_EXTENSION;
        this.tagStart = DEFAULT_TAG_START;
        this.tagEnd = DEFAULT_TAG_END;
        this.templatePath = System.getProperty("templateset.folder", "");
        this.layerName = null;
        this.classInJar = null;
        this.resourceContext = null;
        this.prettyFail = true;
        this.expectedEncoding = TemplateDoc.getDefaultEncoding();
        this.altSources = null;
        if (str != null) {
            char cCharAt = str.charAt(str.length() - 1);
            char cCharAt2 = System.getProperty("file.separator").charAt(0);
            if (cCharAt != '\\' && cCharAt != '/' && cCharAt != cCharAt2) {
                str = str + cCharAt2;
            }
            this.templatePath = str;
        }
        this.dirtyInterval = i;
        this.defaultExtension = str2 == null ? DEFAULT_EXTENSION : str2;
    }

    @Override // com.x5.template.ContentSource
    public Snippet getSnippet(String str) {
        if (str.charAt(0) == ';') {
            int iIndexOf = str.indexOf(59, 1);
            if (iIndexOf < 0) {
                return getSnippet(str, this.defaultExtension);
            }
            return getSnippet(str.substring(iIndexOf + 1), str.substring(1, iIndexOf));
        }
        return getSnippet(str, this.defaultExtension);
    }

    @Override // com.x5.template.ContentSource
    public String fetch(String str) {
        Snippet cleanTemplate = getCleanTemplate(str);
        if (cleanTemplate == null) {
            return null;
        }
        return cleanTemplate.toString();
    }

    @Override // com.x5.template.ContentSource
    public String getProtocol() {
        return "include";
    }

    private Snippet getCleanTemplate(String str) {
        return getSnippet(str, "_CLEAN_:" + this.defaultExtension);
    }

    public Snippet getSnippet(String str, String str2) {
        return _get(str, str2, this.prettyFail);
    }

    private void importTemplates(InputStream inputStream, String str, String str2) throws IOException {
        Iterator<TemplateDoc.Doclet> it = new TemplateDoc(str, inputStream).parseTemplates(this.expectedEncoding).iterator();
        while (it.hasNext()) {
            cacheTemplate(it.next(), str2);
        }
    }

    private Snippet _get(String str, String str2, boolean z) {
        String strReplace;
        Snippet fromCache = getFromCache(str, str2);
        if (fromCache == null) {
            String strTruncateNameToStub = TemplateDoc.truncateNameToStub(str);
            String templatePath = getTemplatePath(str, str2);
            char cCharAt = System.getProperty("file.separator").charAt(0);
            strReplace = templatePath.replace('\\', cCharAt).replace('/', cCharAt);
            try {
                File file = new File(strReplace);
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    importTemplates(fileInputStream, strTruncateNameToStub, str2);
                    fileInputStream.close();
                    fromCache = getFromCache(str, str2);
                } else {
                    String resourcePath = getResourcePath(str, str2);
                    if (this.classInJar == null) {
                        this.classInJar = grokCallerClass();
                    }
                    Class<?> cls = this.classInJar;
                    InputStream resourceAsStream = cls != null ? cls.getResourceAsStream(resourcePath) : null;
                    if (resourceAsStream == null) {
                        resourceAsStream = fishForTemplate(resourcePath);
                    }
                    if (resourceAsStream != null) {
                        importTemplates(resourceAsStream, strTruncateNameToStub, str2);
                        fromCache = getFromCache(str, str2);
                        resourceAsStream.close();
                    }
                }
            } catch (IOException e2) {
                if (!z) {
                    return null;
                }
                StringBuilder sb = new StringBuilder("[error fetching ");
                sb.append(str2);
                sb.append(" template '");
                sb.append(str);
                sb.append("']<!-- ");
                StringWriter stringWriter = new StringWriter();
                e2.printStackTrace(new PrintWriter(stringWriter));
                sb.append(stringWriter.toString());
                sb.append(" -->");
                fromCache = Snippet.getSnippet(sb.toString());
            }
        } else {
            strReplace = null;
        }
        if (fromCache != null) {
            return fromCache;
        }
        if (!z) {
            return null;
        }
        return Snippet.getSnippet(Constants.AES_PREFIX + str2 + " template '" + str + "' not found]<!-- looked in [" + strReplace + "] -->");
    }

    static Class<?> grokCallerClass() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (int i = 4; i < stackTrace.length; i++) {
            StackTraceElement stackTraceElement = stackTrace[i];
            if (!stackTraceElement.getClassName().matches("^com\\.x5\\.template\\.[^\\.]*$")) {
                try {
                    return Class.forName(stackTraceElement.getClassName());
                } catch (ClassNotFoundException unused) {
                    continue;
                }
            }
        }
        return null;
    }

    private InputStream fishForTemplate(String str) {
        String[] strArrSplit;
        InputStream inputStreamPeekInsideJar;
        InputStream inputStreamFishForTemplateInContext;
        if (this.resourceContext != null && (inputStreamFishForTemplateInContext = fishForTemplateInContext(str)) != null) {
            return inputStreamFishForTemplateInContext;
        }
        String property = System.getProperty("java.class.path");
        if (property == null || (strArrSplit = property.split(":")) == null) {
            return null;
        }
        for (String str2 : strArrSplit) {
            if (str2.endsWith(".jar") && (inputStreamPeekInsideJar = JarResource.peekInsideJar("jar:file:" + str2, str)) != null) {
                return inputStreamPeekInsideJar;
            }
        }
        return null;
    }

    private InputStream fishForTemplateInContext(String str) {
        Set<String> set;
        InputStream inputStreamPeekInsideJar;
        InputStream inputStream;
        Class<?> cls = this.resourceContext.getClass();
        try {
            Class<?>[] clsArr = {String.class};
            Method method = cls.getMethod("getResourceAsStream", clsArr);
            if (method != null && (inputStream = (InputStream) method.invoke(this.resourceContext, str)) != null) {
                return inputStream;
            }
            Method method2 = cls.getMethod("getResourcePaths", clsArr);
            if (method2 == null || (set = (Set) method2.invoke(this.resourceContext, "/WEB-INF/lib")) == null) {
                return null;
            }
            for (String str2 : set) {
                if (str2.endsWith(".jar") && (inputStreamPeekInsideJar = JarResource.peekInsideJar("jar:" + ((URL) cls.getMethod("getResource", clsArr).invoke(this.resourceContext, str2)).toString(), str)) != null) {
                    return inputStreamPeekInsideJar;
                }
            }
            return null;
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // com.x5.template.ChunkFactory
    public Chunk makeChunk() {
        Chunk chunk = new Chunk();
        chunk.setMacroLibrary(this, this);
        shareContentSources(chunk);
        return chunk;
    }

    @Override // com.x5.template.ChunkFactory
    public Chunk makeChunk(String str) {
        Chunk chunk = new Chunk();
        chunk.setMacroLibrary(this, this);
        chunk.append(getSnippet(str));
        shareContentSources(chunk);
        return chunk;
    }

    @Override // com.x5.template.ChunkFactory
    public Chunk makeChunk(String str, String str2) {
        Chunk chunk = new Chunk();
        chunk.setMacroLibrary(this, this);
        chunk.append(getSnippet(str, str2));
        shareContentSources(chunk);
        return chunk;
    }

    private void cacheTemplate(TemplateDoc.Doclet doclet, String str) {
        String strReplace = doclet.getName().replace(CsvReader.Letters.POUND, '.');
        String str2 = str + InstructionFileId.DOT + strReplace;
        String str3 = "_CLEAN_:" + str2;
        String template = doclet.getTemplate();
        this.cache.put(str3, Snippet.makeLiteralSnippet(template));
        this.cacheFetch.put(str3, Long.valueOf(System.currentTimeMillis()));
        StringBuilder sbExpandShorthand = TemplateDoc.expandShorthand(strReplace, new StringBuilder(template));
        if (sbExpandShorthand == null) {
            return;
        }
        this.cache.put(str2, Snippet.getSnippet(removeBlockTagIndents(sbExpandShorthand.toString()), doclet.getOrigin()));
        this.cacheFetch.put(str2, Long.valueOf(System.currentTimeMillis()));
    }

    public static String removeBlockTagIndents(String str) {
        return RegexFilter.applyRegex(str, "s/^[ \\t]*(\\{(\\% *(\\~\\.)?(end)?|(\\^|\\~\\.)\\/?)(loop|exec|if|else|elseIf|divider|onEmpty|body|data)([^\\}]*|[^\\}]*\\/[^\\/]*\\/[^\\}]*)\\})[ \\t]*$/$1/gmi");
    }

    protected Snippet getFromCache(String str, String str2) {
        String str3 = str2 + InstructionFileId.DOT + str.replace(CsvReader.Letters.POUND, '.');
        long j = ((long) this.dirtyInterval) * 60000;
        if (j < 5000) {
            j = 5000;
        }
        if (!this.cache.containsKey(str3)) {
            return null;
        }
        if (System.currentTimeMillis() < this.cacheFetch.get(str3).longValue() + j) {
            return this.cache.get(str3);
        }
        return null;
    }

    public void clearCache() {
        this.cache.clear();
        this.cacheFetch.clear();
    }

    public void setDirtyInterval(int i) {
        this.dirtyInterval = i;
    }

    public String convertToMyTags(String str, String str2, String str3) {
        return convertTags(str, str2, str3, this.tagStart, this.tagEnd);
    }

    public static String convertTags(String str, String str2, String str3) {
        return convertTags(str, str2, str3, DEFAULT_TAG_START, DEFAULT_TAG_END);
    }

    public static String convertTags(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        int length = 0;
        while (true) {
            int iIndexOf = str.indexOf(str2, length);
            if (iIndexOf <= -1) {
                break;
            }
            sb.append(str.substring(length, iIndexOf));
            length = str2.length() + iIndexOf;
            int iIndexOf2 = str.indexOf(str3);
            if (iIndexOf2 > -1) {
                sb.append(str4);
                sb.append(str.substring(length, iIndexOf2));
                sb.append(str5);
                length = str3.length() + iIndexOf2;
            } else {
                sb.append(str2);
            }
        }
        if (length == 0) {
            return str;
        }
        sb.append(str.substring(length));
        return sb.toString();
    }

    public TemplateSet getSubset(String str) {
        return new TemplateSetSlice(this, str);
    }

    public void addProtocol(ContentSource contentSource) {
        if (this.altSources == null) {
            this.altSources = new HashSet<>();
        }
        this.altSources.add(contentSource);
    }

    private void shareContentSources(Chunk chunk) {
        HashSet<ContentSource> hashSet = this.altSources;
        if (hashSet == null) {
            return;
        }
        Iterator<ContentSource> it = hashSet.iterator();
        while (it.hasNext()) {
            chunk.addProtocol(it.next());
        }
    }

    public void signalFailureWithNull() {
        this.prettyFail = false;
    }

    public String getTemplatePath(String str, String str2) {
        String str3 = this.templatePath + TemplateDoc.truncateNameToStub(str);
        return (str2 == null || str2.length() <= 0) ? str3 : str3 + '.' + str2;
    }

    public String getResourcePath(String str, String str2) {
        String str3;
        String strTruncateNameToStub = TemplateDoc.truncateNameToStub(str);
        if (this.layerName == null) {
            str3 = "/themes/" + strTruncateNameToStub;
        } else {
            str3 = "/themes/" + this.layerName + strTruncateNameToStub;
        }
        return (str2 == null || str2.length() <= 0) ? str3 : str3 + '.' + str2;
    }

    public String getDefaultExtension() {
        return this.defaultExtension;
    }

    @Override // com.x5.template.ContentSource
    public boolean provides(String str) {
        return _get(str, this.defaultExtension, false) != null;
    }

    public void setJarContext(Class<?> cls) {
        this.classInJar = cls;
    }

    public void setJarContext(Object obj) {
        this.resourceContext = obj;
    }

    public void setLayerName(String str) {
        this.layerName = str;
        if (str == null || str.endsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            return;
        }
        this.layerName += MqttTopic.TOPIC_LEVEL_SEPARATOR;
    }

    public void setEncoding(String str) {
        this.expectedEncoding = str;
    }
}
