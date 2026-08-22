package org.jivesoftware.smack.packet;

import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.util.XmppElementUtil;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public interface StanzaView extends XmlLangElement {
    StanzaError getError();

    ExtensionElement getExtension(QName qName);

    List<ExtensionElement> getExtensions();

    <E extends ExtensionElement> List<E> getExtensions(Class<E> cls);

    List<ExtensionElement> getExtensions(QName qName);

    Jid getFrom();

    String getStanzaId();

    Jid getTo();

    default boolean hasExtension(QName qName) {
        return getExtension(qName) != null;
    }

    default boolean hasExtension(Class<? extends ExtensionElement> cls) {
        return getExtension(cls) != null;
    }

    default boolean hasExtension(String str) {
        Iterator<ExtensionElement> it = getExtensions().iterator();
        while (it.hasNext()) {
            if (it.next().getNamespace().equals(str)) {
                return true;
            }
        }
        return false;
    }

    default <E extends ExtensionElement> E getExtension(Class<E> cls) {
        ExtensionElement extension = getExtension(XmppElementUtil.getQNameFor(cls));
        if (extension == null) {
            return null;
        }
        return (E) XmppElementUtil.castOrThrow(extension, cls);
    }
}
