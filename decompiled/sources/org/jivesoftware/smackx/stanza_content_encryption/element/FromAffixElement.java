package org.jivesoftware.smackx.stanza_content_encryption.element;

import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class FromAffixElement extends JidAffixElement {
    public static final String ELEMENT = "from";

    public FromAffixElement(Jid jid) {
        super(jid);
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "from";
    }
}
