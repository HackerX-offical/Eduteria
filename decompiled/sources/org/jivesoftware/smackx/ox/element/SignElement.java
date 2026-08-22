package org.jivesoftware.smackx.ox.element;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class SignElement extends OpenPgpContentElement {
    public static final String ELEMENT = "sign";

    public SignElement(Set<Jid> set, Date date, List<ExtensionElement> list) {
        super(set, date, list);
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilderRightAngleBracket = new XmlStringBuilder((ExtensionElement) this).rightAngleBracket();
        addCommonXml(xmlStringBuilderRightAngleBracket);
        xmlStringBuilderRightAngleBracket.closeElement(this);
        return xmlStringBuilderRightAngleBracket;
    }
}
