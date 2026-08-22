package org.jivesoftware.smack.packet;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.util.MultiMap;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public final class StandardExtensionElement implements ExtensionElement {
    private final Map<String, String> attributes;
    private final MultiMap<QName, StandardExtensionElement> elements;
    private final String name;
    private final String namespace;
    private final String text;
    private XmlStringBuilder xmlCache;

    public StandardExtensionElement(String str, String str2) {
        this(str, str2, null, null, null);
    }

    private StandardExtensionElement(String str, String str2, Map<String, String> map, String str3, MultiMap<QName, StandardExtensionElement> multiMap) {
        this.name = (String) StringUtils.requireNotNullNorEmpty(str, "Name must not be null nor empty");
        this.namespace = (String) StringUtils.requireNotNullNorEmpty(str2, "Namespace must not be null nor empty");
        if (map == null) {
            this.attributes = Collections.emptyMap();
        } else {
            this.attributes = map;
        }
        this.text = str3;
        this.elements = multiMap;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return this.name;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return this.namespace;
    }

    public String getAttributeValue(String str) {
        return this.attributes.get(str);
    }

    public Map<String, String> getAttributes() {
        return Collections.unmodifiableMap(this.attributes);
    }

    public StandardExtensionElement getFirstElement(String str, String str2) {
        if (this.elements == null) {
            return null;
        }
        return this.elements.getFirst(new QName(str2, str));
    }

    public StandardExtensionElement getFirstElement(String str) {
        return getFirstElement(str, this.namespace);
    }

    public List<StandardExtensionElement> getElements(String str, String str2) {
        if (this.elements == null) {
            return null;
        }
        return this.elements.getAll(new QName(str2, str));
    }

    public List<StandardExtensionElement> getElements(String str) {
        return getElements(str, this.namespace);
    }

    public List<StandardExtensionElement> getElements() {
        MultiMap<QName, StandardExtensionElement> multiMap = this.elements;
        if (multiMap == null) {
            return Collections.emptyList();
        }
        return multiMap.values();
    }

    public String getText() {
        return this.text;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = this.xmlCache;
        if (xmlStringBuilder != null) {
            return xmlStringBuilder;
        }
        XmlStringBuilder xmlStringBuilder2 = new XmlStringBuilder(this, xmlEnvironment);
        for (Map.Entry<String, String> entry : this.attributes.entrySet()) {
            xmlStringBuilder2.attribute(entry.getKey(), entry.getValue());
        }
        xmlStringBuilder2.rightAngleBracket();
        String str = this.text;
        if (str != null) {
            xmlStringBuilder2.text(str);
        }
        MultiMap<QName, StandardExtensionElement> multiMap = this.elements;
        if (multiMap != null) {
            Iterator<Map.Entry<QName, StandardExtensionElement>> it = multiMap.entrySet().iterator();
            while (it.hasNext()) {
                xmlStringBuilder2.append(it.next().getValue().toXML(getNamespace()));
            }
        }
        xmlStringBuilder2.closeElement(this);
        this.xmlCache = xmlStringBuilder2;
        return xmlStringBuilder2;
    }

    public static Builder builder(String str, String str2) {
        return new Builder(str, str2);
    }

    public static final class Builder {
        private Map<String, String> attributes;
        private MultiMap<QName, StandardExtensionElement> elements;
        private final String name;
        private final String namespace;
        private String text;

        private Builder(String str, String str2) {
            this.name = str;
            this.namespace = str2;
        }

        public Builder addAttribute(String str, String str2) {
            StringUtils.requireNotNullNorEmpty(str, "Attribute name must be set");
            Objects.requireNonNull(str2, "Attribute value must be not null");
            if (this.attributes == null) {
                this.attributes = new LinkedHashMap();
            }
            this.attributes.put(str, str2);
            return this;
        }

        public Builder addAttributes(Map<String, String> map) {
            if (this.attributes == null) {
                this.attributes = new LinkedHashMap(map.size());
            }
            this.attributes.putAll(map);
            return this;
        }

        public Builder setText(String str) {
            this.text = (String) Objects.requireNonNull(str, "Text must be not null");
            return this;
        }

        public Builder addElement(StandardExtensionElement standardExtensionElement) {
            Objects.requireNonNull(standardExtensionElement, "Element must not be null");
            if (this.elements == null) {
                this.elements = new MultiMap<>();
            }
            this.elements.put(standardExtensionElement.getQName(), standardExtensionElement);
            return this;
        }

        public Builder addElement(String str, String str2) {
            return addElement(StandardExtensionElement.builder(str, this.namespace).setText(str2).build());
        }

        public StandardExtensionElement build() {
            return new StandardExtensionElement(this.name, this.namespace, this.attributes, this.text, this.elements);
        }
    }
}
