package com.x5.template;

import com.clevertap.android.sdk.Constants;
import com.x5.template.filters.ChunkFilter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class Theme implements ContentSource, ChunkFactory {
    private static final String DEFAULT_THEMES_FOLDER = "themes";
    private HashSet<ContentSource> altSources;
    private int cacheMins;
    private Map<String, ChunkFilter> customFilters;
    private PrintStream errLog;
    private String fileExtension;
    private String localeCode;
    private boolean renderErrs;
    private String themeLayerNames;
    private ArrayList<ContentSource> themeLayers;
    private String themesFolder;

    public Theme() {
        this(null, null, null);
    }

    public Theme(ThemeConfig themeConfig) {
        this(themeConfig.getThemeFolder(), themeConfig.getLayerNames(), themeConfig.getDefaultExtension());
        setDirtyInterval(themeConfig.getCacheMinutes());
        this.localeCode = themeConfig.getLocaleCode();
        if (themeConfig.hideErrors()) {
            setErrorHandling(false, themeConfig.getErrorLog());
        }
        ChunkFilter[] filters = themeConfig.getFilters();
        if (filters != null) {
            for (ChunkFilter chunkFilter : filters) {
                registerFilter(chunkFilter);
            }
        }
        String encoding = themeConfig.getEncoding();
        if (encoding != null) {
            setEncoding(encoding);
        }
    }

    public Theme(ContentSource contentSource) {
        ArrayList<ContentSource> arrayList = new ArrayList<>();
        this.themeLayers = arrayList;
        this.cacheMins = 0;
        this.localeCode = null;
        this.renderErrs = true;
        this.errLog = null;
        this.altSources = null;
        arrayList.add(contentSource);
    }

    public Theme(String str) {
        this(null, str, null);
    }

    public Theme(String str, String str2) {
        this(str, str2, null);
    }

    public Theme(String str, String str2, String str3) {
        this.themeLayers = new ArrayList<>();
        this.cacheMins = 0;
        this.localeCode = null;
        this.renderErrs = true;
        this.errLog = null;
        this.altSources = null;
        this.themesFolder = str;
        this.themeLayerNames = str2;
        this.fileExtension = str3;
    }

    public void setDefaultFileExtension(String str) {
        if (this.themeLayers.size() > 0) {
            throw new IllegalStateException("Must specify extension before lazy init.");
        }
        this.fileExtension = str;
    }

    public void setLocale(String str) {
        this.localeCode = str;
    }

    public String getLocale() {
        return this.localeCode;
    }

    public void setEncoding(String str) {
        ArrayList<TemplateSet> templateSets = getTemplateSets();
        if (templateSets != null) {
            Iterator<TemplateSet> it = templateSets.iterator();
            while (it.hasNext()) {
                it.next().setEncoding(str);
            }
        }
    }

    private void init() {
        if (this.themesFolder == null) {
            this.themesFolder = DEFAULT_THEMES_FOLDER;
        }
        char cCharAt = this.themesFolder.charAt(r0.length() - 1);
        char cCharAt2 = System.getProperty("file.separator").charAt(0);
        if (cCharAt != '\\' && cCharAt != '/' && cCharAt != cCharAt2) {
            this.themesFolder += cCharAt2;
        }
        String[] layerNames = parseLayerNames(this.themeLayerNames);
        if (layerNames == null) {
            TemplateSet templateSet = new TemplateSet(this.themesFolder, this.fileExtension, this.cacheMins);
            if (!this.renderErrs) {
                templateSet.signalFailureWithNull();
            }
            this.themeLayers.add(templateSet);
            return;
        }
        for (int i = 0; i < layerNames.length; i++) {
            TemplateSet templateSet2 = new TemplateSet(this.themesFolder + layerNames[i], this.fileExtension, this.cacheMins);
            templateSet2.setLayerName(layerNames[i]);
            templateSet2.signalFailureWithNull();
            this.themeLayers.add(templateSet2);
        }
    }

    public void addLayer(ContentSource contentSource) {
        this.themeLayers.add(contentSource);
    }

    private ArrayList<ContentSource> getThemeLayers() {
        if (this.themeLayers.size() < 1) {
            init();
        }
        return this.themeLayers;
    }

    private String[] parseLayerNames(String str) {
        if (str == null || str.trim().length() == 0) {
            return null;
        }
        return str.split(" *, *");
    }

    public void setDirtyInterval(int i) {
        if (this.themeLayers.size() == 0) {
            this.cacheMins = i;
            return;
        }
        ArrayList<TemplateSet> templateSets = getTemplateSets();
        if (templateSets != null) {
            Iterator<TemplateSet> it = templateSets.iterator();
            while (it.hasNext()) {
                it.next().setDirtyInterval(i);
            }
        }
    }

    public Snippet getSnippet(String str, String str2) {
        ArrayList<ContentSource> themeLayers = getThemeLayers();
        for (int size = themeLayers.size() - 1; size >= 0; size--) {
            Snippet snippet = themeLayers.get(size).getSnippet(";" + str2 + ";" + str);
            if (snippet != null) {
                return snippet;
            }
        }
        return prettyFail(str, str2);
    }

    @Override // com.x5.template.ContentSource
    public Snippet getSnippet(String str) {
        ArrayList<ContentSource> themeLayers = getThemeLayers();
        for (int size = themeLayers.size() - 1; size >= 0; size--) {
            ContentSource contentSource = themeLayers.get(size);
            if (contentSource.provides(str)) {
                return contentSource.getSnippet(str);
            }
        }
        return prettyFail(str, null);
    }

    @Override // com.x5.template.ContentSource
    public boolean provides(String str) {
        for (int size = this.themeLayers.size() - 1; size >= 0; size--) {
            if (this.themeLayers.get(size).provides(str)) {
                return true;
            }
        }
        return false;
    }

    private Snippet prettyFail(String str, String str2) {
        if (!this.renderErrs && this.errLog == null) {
            return null;
        }
        if (str2 == null) {
            ContentSource contentSource = this.themeLayers.get(0);
            if (contentSource instanceof TemplateSet) {
                str2 = ((TemplateSet) contentSource).getDefaultExtension();
            }
        }
        StringBuilder sb = new StringBuilder(Constants.AES_PREFIX);
        if (str2 != null) {
            sb.append(str2);
            sb.append(" ");
        }
        sb.append("template '");
        sb.append(str);
        sb.append("' not found]");
        if (str2 != null) {
            ArrayList<TemplateSet> templateSets = getTemplateSets();
            String str3 = "";
            if (templateSets != null) {
                for (int size = templateSets.size() - 1; size >= 0; size--) {
                    TemplateSet templateSet = templateSets.get(size);
                    if (str3.length() > 0) {
                        str3 = str3 + Constants.SEPARATOR_COMMA;
                    }
                    str3 = str3 + templateSet.getTemplatePath(str, str2);
                }
            }
            if (str3.length() > 0) {
                sb.append("<!-- looked in [");
                sb.append(str3);
                sb.append("] -->");
            }
        }
        PrintStream printStream = this.errLog;
        if (printStream != null) {
            Chunk.logChunkError(printStream, sb.toString());
        }
        if (this.renderErrs) {
            return Snippet.getSnippet(sb.toString());
        }
        return null;
    }

    @Override // com.x5.template.ContentSource
    public String fetch(String str) {
        ArrayList<ContentSource> themeLayers = getThemeLayers();
        for (int size = themeLayers.size() - 1; size >= 0; size--) {
            ContentSource contentSource = themeLayers.get(size);
            if (contentSource.provides(str)) {
                return contentSource.fetch(str);
            }
        }
        return null;
    }

    @Override // com.x5.template.ContentSource
    public String getProtocol() {
        return "include";
    }

    @Override // com.x5.template.ChunkFactory
    public Chunk makeChunk() {
        Chunk chunk = new Chunk();
        chunk.setMacroLibrary(this, this);
        shareContentSources(chunk);
        chunk.setLocale(this.localeCode);
        chunk.setErrorHandling(this.renderErrs, this.errLog);
        return chunk;
    }

    @Override // com.x5.template.ChunkFactory
    public Chunk makeChunk(String str) {
        Chunk chunk = new Chunk();
        chunk.setMacroLibrary(this, this);
        chunk.append(getSnippet(str));
        shareContentSources(chunk);
        chunk.setLocale(this.localeCode);
        chunk.setErrorHandling(this.renderErrs, this.errLog);
        return chunk;
    }

    @Override // com.x5.template.ChunkFactory
    public Chunk makeChunk(String str, String str2) {
        Chunk chunk = new Chunk();
        chunk.setMacroLibrary(this, this);
        chunk.append(getSnippet(str, str2));
        shareContentSources(chunk);
        chunk.setLocale(this.localeCode);
        chunk.setErrorHandling(this.renderErrs, this.errLog);
        return chunk;
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

    public void setJarContext(Class<?> cls) {
        ArrayList<TemplateSet> templateSets = getTemplateSets();
        if (templateSets != null) {
            Iterator<TemplateSet> it = templateSets.iterator();
            while (it.hasNext()) {
                it.next().setJarContext(cls);
            }
        }
    }

    public void setJarContext(Object obj) {
        ArrayList<TemplateSet> templateSets = getTemplateSets();
        if (templateSets != null) {
            Iterator<TemplateSet> it = templateSets.iterator();
            while (it.hasNext()) {
                it.next().setJarContext(obj);
            }
        }
    }

    private ArrayList<TemplateSet> getTemplateSets() {
        ArrayList<TemplateSet> arrayList = null;
        for (ContentSource contentSource : getThemeLayers()) {
            if (contentSource instanceof TemplateSet) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add((TemplateSet) contentSource);
            }
        }
        return arrayList;
    }

    @Override // com.x5.template.ChunkFactory
    public Map<String, ChunkFilter> getFilters() {
        return this.customFilters;
    }

    public void registerFilter(ChunkFilter chunkFilter) {
        if (this.customFilters == null) {
            this.customFilters = new HashMap();
        }
        this.customFilters.put(chunkFilter.getFilterName(), chunkFilter);
        String[] filterAliases = chunkFilter.getFilterAliases();
        if (filterAliases != null) {
            for (String str : filterAliases) {
                this.customFilters.put(str, chunkFilter);
            }
        }
    }

    public void setErrorHandling(boolean z, PrintStream printStream) {
        this.renderErrs = z;
        this.errLog = printStream;
    }
}
