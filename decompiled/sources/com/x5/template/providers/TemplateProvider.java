package com.x5.template.providers;

import com.x5.template.ContentSource;
import com.x5.template.Snippet;
import com.x5.template.TemplateDoc;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
public abstract class TemplateProvider implements ContentSource {
    private static String DEFAULT_ENCODING = "UTF-8";
    private static String DEFAULT_EXTENSION = "chtml";
    private String extension = DEFAULT_EXTENSION;
    private String encoding = DEFAULT_ENCODING;
    HashMap<String, Snippet> snippetCache = new HashMap<>();

    @Override // com.x5.template.ContentSource
    public abstract String getProtocol();

    public abstract String loadContainerDoc(String str) throws IOException;

    @Override // com.x5.template.ContentSource
    public String fetch(String str) {
        Snippet snippet = getSnippet(str);
        if (snippet == null) {
            return null;
        }
        return snippet.toString();
    }

    @Override // com.x5.template.ContentSource
    public boolean provides(String str) {
        return getSnippet(str) != null;
    }

    @Override // com.x5.template.ContentSource
    public Snippet getSnippet(String str) {
        String strLoadItemDoc;
        if (this.snippetCache.containsKey(str)) {
            return this.snippetCache.get(str);
        }
        try {
            strLoadItemDoc = loadItemDoc(str);
        } catch (IOException e2) {
            e2.printStackTrace(System.err);
            strLoadItemDoc = null;
        }
        if (strLoadItemDoc == null) {
            this.snippetCache.put(str, null);
            return null;
        }
        try {
            return parseSnippet(new TemplateDoc(str, strLoadItemDoc), str);
        } catch (IOException unused) {
            return null;
        }
    }

    private Snippet parseSnippet(TemplateDoc templateDoc, String str) throws IOException {
        Snippet snippet = null;
        for (TemplateDoc.Doclet doclet : templateDoc.parseTemplates(this.encoding)) {
            String name = doclet.getName();
            Snippet snippet2 = doclet.getSnippet();
            if (name.equals(str)) {
                snippet = snippet2;
            }
            this.snippetCache.put(name, snippet2);
        }
        return snippet;
    }

    public String loadItemDoc(String str) throws IOException {
        return loadContainerDoc(resourceName(str));
    }

    private String resourceName(String str) {
        String str2 = this.extension;
        String embeddedExtension = parseEmbeddedExtension(str);
        if (embeddedExtension != null) {
            str = str.substring(embeddedExtension.length() + 2);
            str2 = embeddedExtension;
        }
        int iIndexOf = str.indexOf(35);
        if (str2 == null || str2.length() < 1) {
            return iIndexOf < 0 ? str : str.substring(0, iIndexOf);
        }
        if (iIndexOf < 0) {
            return str + '.' + str2;
        }
        return str.substring(0, iIndexOf) + '.' + str2;
    }

    private String parseEmbeddedExtension(String str) {
        int iIndexOf;
        if (str.charAt(0) == ';' && (iIndexOf = str.indexOf(59, 1)) >= 0) {
            return str.substring(1, iIndexOf);
        }
        return null;
    }

    public void clearCache() {
        this.snippetCache.clear();
    }

    public void clearCache(String str) {
        this.snippetCache.remove(str);
    }

    public void setDefaultExtension(String str) {
        this.extension = str;
    }
}
