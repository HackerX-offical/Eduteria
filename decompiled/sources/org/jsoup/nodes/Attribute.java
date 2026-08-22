package org.jsoup.nodes;

import cz.msebera.android.httpclient.client.config.CookieSpecs;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import org.jivesoftware.smackx.xdata.FormField;
import org.jsoup.SerializationException;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;

/* JADX INFO: loaded from: classes10.dex */
public class Attribute implements Map.Entry<String, String>, Cloneable {
    private String key;

    @Nullable
    Attributes parent;

    @Nullable
    private String val;
    private static final String[] booleanAttributes = {"allowfullscreen", "async", "autofocus", "checked", "compact", "declare", CookieSpecs.DEFAULT, "defer", "disabled", "formnovalidate", "hidden", "inert", "ismap", "itemscope", "multiple", "muted", "nohref", "noresize", "noshade", "novalidate", "nowrap", "open", "readonly", FormField.Required.ELEMENT, "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch"};
    private static final Pattern xmlKeyValid = Pattern.compile("[a-zA-Z_:][-a-zA-Z0-9_:.]*");
    private static final Pattern xmlKeyReplace = Pattern.compile("[^-a-zA-Z0-9_:.]");
    private static final Pattern htmlKeyValid = Pattern.compile("[^\\x00-\\x1f\\x7f-\\x9f \"'/=]+");
    private static final Pattern htmlKeyReplace = Pattern.compile("[\\x00-\\x1f\\x7f-\\x9f \"'/=]");

    public Attribute(String str, @Nullable String str2) {
        this(str, str2, null);
    }

    public Attribute(String str, @Nullable String str2, @Nullable Attributes attributes) {
        Validate.notNull(str);
        String strTrim = str.trim();
        Validate.notEmpty(strTrim);
        this.key = strTrim;
        this.val = str2;
        this.parent = attributes;
    }

    @Override // java.util.Map.Entry
    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        int iIndexOfKey;
        Validate.notNull(str);
        String strTrim = str.trim();
        Validate.notEmpty(strTrim);
        Attributes attributes = this.parent;
        if (attributes != null && (iIndexOfKey = attributes.indexOfKey(this.key)) != -1) {
            this.parent.keys[iIndexOfKey] = strTrim;
        }
        this.key = strTrim;
    }

    @Override // java.util.Map.Entry
    public String getValue() {
        return Attributes.checkNotNull(this.val);
    }

    public boolean hasDeclaredValue() {
        return this.val != null;
    }

    @Override // java.util.Map.Entry
    public String setValue(@Nullable String str) {
        int iIndexOfKey;
        String str2 = this.val;
        Attributes attributes = this.parent;
        if (attributes != null && (iIndexOfKey = attributes.indexOfKey(this.key)) != -1) {
            str2 = this.parent.get(this.key);
            this.parent.vals[iIndexOfKey] = str;
        }
        this.val = str;
        return Attributes.checkNotNull(str2);
    }

    public String html() {
        StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        try {
            html(sbBorrowBuilder, new Document("").outputSettings());
            return StringUtil.releaseBuilder(sbBorrowBuilder);
        } catch (IOException e2) {
            throw new SerializationException(e2);
        }
    }

    protected void html(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        html(this.key, this.val, appendable, outputSettings);
    }

    protected static void html(String str, @Nullable String str2, Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        String validKey = getValidKey(str, outputSettings.syntax());
        if (validKey == null) {
            return;
        }
        htmlNoValidate(validKey, str2, appendable, outputSettings);
    }

    static void htmlNoValidate(String str, @Nullable String str2, Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        appendable.append(str);
        if (shouldCollapseAttribute(str, str2, outputSettings)) {
            return;
        }
        appendable.append("=\"");
        Entities.escape(appendable, Attributes.checkNotNull(str2), outputSettings, true, false, false, false);
        appendable.append('\"');
    }

    @Nullable
    public static String getValidKey(String str, Document.OutputSettings.Syntax syntax) {
        if (syntax == Document.OutputSettings.Syntax.xml) {
            Pattern pattern = xmlKeyValid;
            if (!pattern.matcher(str).matches()) {
                String strReplaceAll = xmlKeyReplace.matcher(str).replaceAll("");
                if (pattern.matcher(strReplaceAll).matches()) {
                    return strReplaceAll;
                }
                return null;
            }
        }
        if (syntax == Document.OutputSettings.Syntax.html) {
            Pattern pattern2 = htmlKeyValid;
            if (!pattern2.matcher(str).matches()) {
                String strReplaceAll2 = htmlKeyReplace.matcher(str).replaceAll("");
                if (pattern2.matcher(strReplaceAll2).matches()) {
                    return strReplaceAll2;
                }
                return null;
            }
        }
        return str;
    }

    public String toString() {
        return html();
    }

    public static Attribute createFromEncoded(String str, String str2) {
        return new Attribute(str, Entities.unescape(str2, true), null);
    }

    protected boolean isDataAttribute() {
        return isDataAttribute(this.key);
    }

    protected static boolean isDataAttribute(String str) {
        return str.startsWith("data-") && str.length() > "data-".length();
    }

    protected final boolean shouldCollapseAttribute(Document.OutputSettings outputSettings) {
        return shouldCollapseAttribute(this.key, this.val, outputSettings);
    }

    protected static boolean shouldCollapseAttribute(String str, @Nullable String str2, Document.OutputSettings outputSettings) {
        if (outputSettings.syntax() != Document.OutputSettings.Syntax.html) {
            return false;
        }
        if (str2 != null) {
            return (str2.isEmpty() || str2.equalsIgnoreCase(str)) && isBooleanAttribute(str);
        }
        return true;
    }

    public static boolean isBooleanAttribute(String str) {
        return Arrays.binarySearch(booleanAttributes, Normalizer.lowerCase(str)) >= 0;
    }

    @Override // java.util.Map.Entry
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Attribute attribute = (Attribute) obj;
            String str = this.key;
            if (str == null ? attribute.key != null : !str.equals(attribute.key)) {
                return false;
            }
            String str2 = this.val;
            String str3 = attribute.val;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        String str = this.key;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.val;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public Attribute clone() {
        try {
            return (Attribute) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }
}
