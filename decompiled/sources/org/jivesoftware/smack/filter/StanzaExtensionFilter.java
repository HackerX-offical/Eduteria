package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.StringUtils;

/* JADX INFO: loaded from: classes10.dex */
public class StanzaExtensionFilter implements StanzaFilter {
    private final String elementName;
    private final String namespace;

    public StanzaExtensionFilter(String str, String str2) {
        StringUtils.requireNotNullNorEmpty(str2, "namespace must not be null nor empty");
        this.elementName = str;
        this.namespace = str2;
    }

    public StanzaExtensionFilter(String str) {
        this(null, str);
    }

    public StanzaExtensionFilter(ExtensionElement extensionElement) {
        this(extensionElement.getElementName(), extensionElement.getNamespace());
    }

    @Override // org.jivesoftware.smack.filter.StanzaFilter
    public boolean accept(Stanza stanza) {
        return stanza.hasExtension(this.elementName, this.namespace);
    }

    public String toString() {
        return getClass().getSimpleName() + ": element=" + this.elementName + " namespace=" + this.namespace;
    }
}
