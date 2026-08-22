package org.jivesoftware.smack.packet;

import com.csvreader.CsvReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.packet.id.StandardStanzaIdSource;
import org.jivesoftware.smack.packet.id.StanzaIdSource;
import org.jivesoftware.smack.util.MultiMap;
import org.jivesoftware.smack.util.PacketUtil;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smack.util.XmppElementUtil;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Stanza implements StanzaView, TopLevelStreamElement {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected static final String DEFAULT_LANGUAGE = Locale.getDefault().getLanguage().toLowerCase(Locale.US);
    public static final String ITEM = "item";
    public static final String TEXT = "text";
    private StanzaError error;
    private final MultiMap<QName, ExtensionElement> extensionElements;
    private Jid from;
    private String id;
    protected String language;
    private final String namespace;
    private Jid to;
    private final StanzaIdSource usedStanzaIdSource;

    public abstract String toString();

    protected Stanza() {
        this.namespace = "jabber:client";
        this.id = null;
        this.error = null;
        this.extensionElements = new MultiMap<>();
        this.usedStanzaIdSource = null;
        this.id = StandardStanzaIdSource.DEFAULT.getNewStanzaId();
    }

    protected Stanza(StanzaBuilder<?> stanzaBuilder) {
        this.namespace = "jabber:client";
        this.id = null;
        this.error = null;
        if (stanzaBuilder.stanzaIdSource != null) {
            this.id = stanzaBuilder.stanzaIdSource.getNewStanzaId();
            this.usedStanzaIdSource = stanzaBuilder.stanzaIdSource;
        } else {
            this.id = stanzaBuilder.stanzaId;
            this.usedStanzaIdSource = null;
        }
        this.to = stanzaBuilder.to;
        this.from = stanzaBuilder.from;
        this.error = stanzaBuilder.stanzaError;
        this.language = stanzaBuilder.language;
        this.extensionElements = stanzaBuilder.extensionElements.clone();
    }

    protected Stanza(Stanza stanza) {
        this.namespace = "jabber:client";
        this.id = null;
        this.error = null;
        this.usedStanzaIdSource = stanza.usedStanzaIdSource;
        this.id = stanza.getStanzaId();
        this.to = stanza.getTo();
        this.from = stanza.getFrom();
        this.error = stanza.error;
        this.extensionElements = stanza.extensionElements.clone();
    }

    @Override // org.jivesoftware.smack.packet.StanzaView
    public final String getStanzaId() {
        return this.id;
    }

    public void setStanzaId(String str) {
        if (str != null) {
            StringUtils.requireNotNullNorEmpty(str, "id must either be null or not the empty String");
        }
        this.id = str;
    }

    public final boolean hasStanzaIdSet() {
        return this.id != null;
    }

    @Deprecated
    public String setStanzaId() {
        if (!hasStanzaIdSet()) {
            setNewStanzaId();
        }
        return getStanzaId();
    }

    public final void throwIfNoStanzaId() {
        if (!hasStanzaIdSet()) {
            throw new IllegalArgumentException("The stanza has no RFC stanza ID set, although one is required");
        }
    }

    protected String setNewStanzaId() {
        StanzaIdSource stanzaIdSource = this.usedStanzaIdSource;
        if (stanzaIdSource != null) {
            this.id = stanzaIdSource.getNewStanzaId();
        } else {
            this.id = StandardStanzaIdSource.DEFAULT.getNewStanzaId();
        }
        return getStanzaId();
    }

    @Override // org.jivesoftware.smack.packet.StanzaView
    public final Jid getTo() {
        return this.to;
    }

    public void setTo(Jid jid) {
        this.to = jid;
    }

    @Override // org.jivesoftware.smack.packet.StanzaView
    public final Jid getFrom() {
        return this.from;
    }

    public void setFrom(Jid jid) {
        this.from = jid;
    }

    @Override // org.jivesoftware.smack.packet.StanzaView
    public final StanzaError getError() {
        return this.error;
    }

    public void setError(StanzaError stanzaError) {
        this.error = stanzaError;
    }

    @Deprecated
    public void setError(StanzaError.Builder builder) {
        setError(builder.build());
    }

    @Override // org.jivesoftware.smack.packet.XmlLangElement
    public final String getLanguage() {
        return this.language;
    }

    @Deprecated
    public void setLanguage(String str) {
        this.language = str;
    }

    @Override // org.jivesoftware.smack.packet.StanzaView
    public final List<ExtensionElement> getExtensions() {
        List<ExtensionElement> listValues;
        synchronized (this.extensionElements) {
            listValues = this.extensionElements.values();
        }
        return listValues;
    }

    public final MultiMap<QName, ExtensionElement> getExtensionsMap() {
        return cloneExtensionsMap();
    }

    final MultiMap<QName, ExtensionElement> cloneExtensionsMap() {
        MultiMap<QName, ExtensionElement> multiMapM14232clone;
        synchronized (this.extensionElements) {
            multiMapM14232clone = this.extensionElements.clone();
        }
        return multiMapM14232clone;
    }

    public final List<ExtensionElement> getExtensions(String str, String str2) {
        StringUtils.requireNotNullNorEmpty(str, "elementName must not be null nor empty");
        StringUtils.requireNotNullNorEmpty(str2, "namespace must not be null nor empty");
        return getExtensions(new QName(str2, str));
    }

    @Override // org.jivesoftware.smack.packet.StanzaView
    public final List<ExtensionElement> getExtensions(QName qName) {
        List<ExtensionElement> all;
        synchronized (this.extensionElements) {
            all = this.extensionElements.getAll(qName);
        }
        return Collections.unmodifiableList(all);
    }

    @Override // org.jivesoftware.smack.packet.StanzaView
    public final <E extends ExtensionElement> List<E> getExtensions(Class<E> cls) {
        List<E> elementsFrom;
        synchronized (this.extensionElements) {
            elementsFrom = XmppElementUtil.getElementsFrom(this.extensionElements, cls);
        }
        return elementsFrom;
    }

    public final ExtensionElement getExtension(String str) {
        return PacketUtil.extensionElementFrom(getExtensions(), null, str);
    }

    public final ExtensionElement getExtensionElement(String str, String str2) {
        ExtensionElement extension;
        if (str2 == null || (extension = getExtension(new QName(str2, str))) == null) {
            return null;
        }
        return extension;
    }

    @Deprecated
    public final <E extends ExtensionElement> E getExtension(String str, String str2) {
        return (E) getExtensionElement(str, str2);
    }

    @Override // org.jivesoftware.smack.packet.StanzaView
    public final ExtensionElement getExtension(QName qName) {
        ExtensionElement first;
        synchronized (this.extensionElements) {
            first = this.extensionElements.getFirst(qName);
        }
        return first;
    }

    public final void addExtension(ExtensionElement extensionElement) {
        if (extensionElement == null) {
            return;
        }
        QName qName = extensionElement.getQName();
        synchronized (this.extensionElements) {
            this.extensionElements.put(qName, extensionElement);
        }
    }

    public final ExtensionElement overrideExtension(ExtensionElement extensionElement) {
        ExtensionElement extensionElementRemoveExtension;
        if (extensionElement == null) {
            return null;
        }
        synchronized (this.extensionElements) {
            extensionElementRemoveExtension = removeExtension(extensionElement.getElementName(), extensionElement.getNamespace());
            addExtension(extensionElement);
        }
        return extensionElementRemoveExtension;
    }

    public final void addExtensions(Collection<? extends ExtensionElement> collection) {
        if (collection == null) {
            return;
        }
        Iterator<? extends ExtensionElement> it = collection.iterator();
        while (it.hasNext()) {
            addExtension(it.next());
        }
    }

    public final boolean hasExtension(String str, String str2) {
        boolean zContainsKey;
        if (str == null) {
            return hasExtension(str2);
        }
        QName qName = new QName(str2, str);
        synchronized (this.extensionElements) {
            zContainsKey = this.extensionElements.containsKey(qName);
        }
        return zContainsKey;
    }

    @Override // org.jivesoftware.smack.packet.StanzaView
    public final boolean hasExtension(String str) {
        synchronized (this.extensionElements) {
            Iterator<ExtensionElement> it = this.extensionElements.values().iterator();
            while (it.hasNext()) {
                if (it.next().getNamespace().equals(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    public final ExtensionElement removeExtension(String str, String str2) {
        ExtensionElement extensionElementRemove;
        QName qName = new QName(str2, str);
        synchronized (this.extensionElements) {
            extensionElementRemove = this.extensionElements.remove(qName);
        }
        return extensionElementRemove;
    }

    @Deprecated
    public final ExtensionElement removeExtension(ExtensionElement extensionElement) {
        QName qName = extensionElement.getQName();
        synchronized (this.extensionElements) {
            if (this.extensionElements.getAll(qName).remove(extensionElement)) {
                return extensionElement;
            }
            return null;
        }
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public final String getNamespace() {
        return "jabber:client";
    }

    public static String getDefaultLanguage() {
        return DEFAULT_LANGUAGE;
    }

    protected final void addCommonAttributes(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.optAttribute("to", getTo());
        xmlStringBuilder.optAttribute("from", getFrom());
        xmlStringBuilder.optAttribute("id", getStanzaId());
    }

    protected void logCommonAttributes(StringBuilder sb) {
        if (getTo() != null) {
            sb.append("to=").append((CharSequence) this.to).append(CsvReader.Letters.COMMA);
        }
        if (getFrom() != null) {
            sb.append("from=").append((CharSequence) this.from).append(CsvReader.Letters.COMMA);
        }
        if (hasStanzaIdSet()) {
            sb.append("id=").append(this.id).append(CsvReader.Letters.COMMA);
        }
    }

    protected final void appendErrorIfExists(XmlStringBuilder xmlStringBuilder) {
        StanzaError error = getError();
        if (error != null) {
            xmlStringBuilder.append(error);
        }
    }

    static String determineLanguage(XmlLangElement xmlLangElement, String str) {
        return (str == null || str.isEmpty()) ? xmlLangElement.getLanguage() : str;
    }
}
