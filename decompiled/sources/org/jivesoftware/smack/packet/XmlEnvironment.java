package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.xml.XmlPullParser;

/* JADX INFO: loaded from: classes10.dex */
public class XmlEnvironment {
    public static final XmlEnvironment EMPTY = new XmlEnvironment((String) null);
    private transient String effectiveLanguage;
    private transient boolean effectiveLanguageDetermined;
    private transient String effectiveNamespace;
    private transient boolean effectiveNamespaceDetermined;
    private final String language;
    private final String namespace;
    private final XmlEnvironment next;
    private transient String toStringCache;

    static {
    }

    public XmlEnvironment(String str) {
        this(str, (String) null);
    }

    public XmlEnvironment(String str, String str2) {
        this(str, str2, null);
    }

    private XmlEnvironment(Builder builder) {
        this(builder.namespace, builder.language, builder.next);
    }

    public XmlEnvironment(String str, String str2, XmlEnvironment xmlEnvironment) {
        this.namespace = str;
        this.language = str2;
        this.next = xmlEnvironment;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public String getEffectiveNamespace() {
        if (this.effectiveNamespaceDetermined) {
            return this.effectiveNamespace;
        }
        if (StringUtils.isNotEmpty(this.namespace)) {
            this.effectiveNamespace = this.namespace;
        } else {
            XmlEnvironment xmlEnvironment = this.next;
            if (xmlEnvironment != null) {
                this.effectiveNamespace = xmlEnvironment.getEffectiveNamespace();
            }
        }
        this.effectiveNamespaceDetermined = true;
        return this.effectiveNamespace;
    }

    public String getEffectiveNamespaceOrUse(String str) {
        String effectiveNamespace = getEffectiveNamespace();
        return StringUtils.isNullOrEmpty(effectiveNamespace) ? str : effectiveNamespace;
    }

    public boolean effectiveNamespaceEquals(String str) {
        String effectiveNamespace = getEffectiveNamespace();
        if (effectiveNamespace == null) {
            return false;
        }
        return effectiveNamespace.equals(str);
    }

    public String getLanguage() {
        return this.language;
    }

    public String getEffectiveLanguage() {
        if (this.effectiveLanguageDetermined) {
            return this.effectiveLanguage;
        }
        if (StringUtils.isNotEmpty(this.language)) {
            this.effectiveLanguage = this.language;
        } else {
            XmlEnvironment xmlEnvironment = this.next;
            if (xmlEnvironment != null) {
                this.effectiveLanguage = xmlEnvironment.getEffectiveLanguage();
            }
        }
        this.effectiveLanguageDetermined = true;
        return this.effectiveLanguage;
    }

    public boolean effectiveLanguageEquals(String str) {
        String effectiveLanguage = getEffectiveLanguage();
        if (effectiveLanguage == null) {
            return false;
        }
        return effectiveLanguage.equals(str);
    }

    public String toString() {
        if (this.toStringCache == null) {
            StringBuilder sb = new StringBuilder("XmlEnvironment xmlns=");
            sb.append(getEffectiveNamespace()).append(" xmllang=");
            sb.append(getEffectiveLanguage()).append(' ');
            this.toStringCache = sb.toString();
        }
        return this.toStringCache;
    }

    public static XmlEnvironment from(XmlPullParser xmlPullParser) {
        return from(xmlPullParser, null);
    }

    public static XmlEnvironment from(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) {
        return new XmlEnvironment(xmlPullParser.getDefaultNamespace(), ParserUtils.getXmlLang(xmlPullParser), xmlEnvironment);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String language;
        private String namespace;
        private XmlEnvironment next;

        public Builder withNamespace(String str) {
            this.namespace = str;
            return this;
        }

        public Builder withLanguage(String str) {
            this.language = str;
            return this;
        }

        public Builder withNext(XmlEnvironment xmlEnvironment) {
            this.next = xmlEnvironment;
            return this;
        }

        public Builder with(StreamOpen streamOpen) {
            withNamespace(streamOpen.getNamespace());
            withLanguage(streamOpen.getLanguage());
            return this;
        }

        public XmlEnvironment build() {
            return new XmlEnvironment(this);
        }
    }
}
