package org.jivesoftware.smackx.stanza_content_encryption.element;

import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class ToAffixElement extends JidAffixElement {
    public static final String ELEMENT = "to";

    public ToAffixElement(Jid jid) {
        super(jid);
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "to";
    }
}
