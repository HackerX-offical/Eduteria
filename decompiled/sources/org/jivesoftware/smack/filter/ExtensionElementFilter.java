package org.jivesoftware.smack.filter;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.XmppElementUtil;

/* JADX INFO: loaded from: classes10.dex */
public class ExtensionElementFilter<E extends ExtensionElement> implements StanzaFilter {
    private final Class<E> extensionElementClass;
    private final QName extensionElementQName;

    public boolean accept(E e2) {
        return true;
    }

    protected ExtensionElementFilter(Class<E> cls) {
        this.extensionElementClass = cls;
        this.extensionElementQName = XmppElementUtil.getQNameFor(cls);
    }

    @Override // org.jivesoftware.smack.filter.StanzaFilter
    public final boolean accept(Stanza stanza) {
        ExtensionElement extension = stanza.getExtension(this.extensionElementQName);
        if (extension != null && this.extensionElementClass.isInstance(extension)) {
            return accept(this.extensionElementClass.cast(extension));
        }
        return false;
    }
}
