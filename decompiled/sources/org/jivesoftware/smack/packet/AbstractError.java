package org.jivesoftware.smack.packet;

import com.appnew.android.Utils.Const;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.jivesoftware.smack.util.ExceptionUtil;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.PacketUtil;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class AbstractError {
    protected final Map<String, String> descriptiveTexts;
    protected final List<ExtensionElement> extensions;
    protected final String textNamespace;

    protected AbstractError(Map<String, String> map) {
        this(map, null);
    }

    protected AbstractError(Map<String, String> map, List<ExtensionElement> list) {
        this(map, null, list);
    }

    protected AbstractError(Map<String, String> map, String str, List<ExtensionElement> list) {
        if (map != null) {
            this.descriptiveTexts = map;
        } else {
            this.descriptiveTexts = Collections.emptyMap();
        }
        this.textNamespace = str;
        if (list != null) {
            this.extensions = list;
        } else {
            this.extensions = Collections.emptyList();
        }
    }

    public String getDescriptiveText() {
        if (this.descriptiveTexts.isEmpty()) {
            return null;
        }
        Locale locale = Locale.getDefault();
        String[] strArr = {locale.getLanguage() + "-" + locale.getCountry() + "-" + locale.getVariant(), locale.getLanguage() + "-" + locale.getCountry(), locale.getLanguage(), Const.ENGLISH, ""};
        for (int i = 0; i < 5; i++) {
            String descriptiveText = getDescriptiveText(strArr[i]);
            if (descriptiveText != null) {
                return descriptiveText;
            }
        }
        return this.descriptiveTexts.values().iterator().next();
    }

    public String getDescriptiveText(String str) {
        Objects.requireNonNull(str, "xmllang must not be null");
        return this.descriptiveTexts.get(str);
    }

    public <PE extends ExtensionElement> PE getExtension(String str, String str2) {
        return (PE) PacketUtil.extensionElementFrom(this.extensions, str, str2);
    }

    protected void addDescriptiveTextsAndExtensions(XmlStringBuilder xmlStringBuilder) {
        for (Map.Entry<String, String> entry : this.descriptiveTexts.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            xmlStringBuilder.halfOpenElement("text").xmlnsAttribute(this.textNamespace).optXmlLangAttribute(key).rightAngleBracket();
            xmlStringBuilder.escape(value);
            xmlStringBuilder.closeElement("text");
        }
        xmlStringBuilder.append(this.extensions);
    }

    public static abstract class Builder<B extends Builder<B>> {
        protected Map<String, String> descriptiveTexts;
        protected List<ExtensionElement> extensions;
        protected String textNamespace;

        protected abstract B getThis();

        public B setDescriptiveTexts(Map<String, String> map) {
            if (map == null) {
                this.descriptiveTexts = null;
                return (B) getThis();
            }
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("descriptiveTexts cannot contain null key");
                }
            }
            Map<String, String> map2 = this.descriptiveTexts;
            if (map2 == null) {
                this.descriptiveTexts = map;
            } else {
                map2.putAll(map);
            }
            return (B) getThis();
        }

        public B setDescriptiveEnText(String str) {
            if (this.descriptiveTexts == null) {
                this.descriptiveTexts = new HashMap();
            }
            this.descriptiveTexts.put(Const.ENGLISH, str);
            return (B) getThis();
        }

        public B setDescriptiveEnText(String str, Exception exc) {
            StringBuilder sb = new StringBuilder(512);
            sb.append(str).append('\n');
            sb.append(ExceptionUtil.getStackTrace(exc));
            return (B) setDescriptiveEnText(sb.toString());
        }

        public B setTextNamespace(String str) {
            this.textNamespace = str;
            return (B) getThis();
        }

        public B setExtensions(List<ExtensionElement> list) {
            List<ExtensionElement> list2 = this.extensions;
            if (list2 == null) {
                this.extensions = list;
            } else {
                list2.addAll(list);
            }
            return (B) getThis();
        }

        public B addExtension(ExtensionElement extensionElement) {
            if (this.extensions == null) {
                this.extensions = new ArrayList();
            }
            this.extensions.add(extensionElement);
            return (B) getThis();
        }
    }
}
