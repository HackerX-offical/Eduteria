package org.jivesoftware.smackx.bob.element;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.StanzaView;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.bob.BoBData;
import org.jivesoftware.smackx.bob.ContentId;

/* JADX INFO: loaded from: classes10.dex */
public class BoBDataExtension implements ExtensionElement {
    public static final String ELEMENT = "data";
    public static final String NAMESPACE = "urn:xmpp:bob";
    private final BoBData bobData;
    private final ContentId cid;

    public BoBDataExtension(ContentId contentId, BoBData boBData) {
        this.cid = (ContentId) Objects.requireNonNull(contentId);
        this.bobData = (BoBData) Objects.requireNonNull(boBData);
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "data";
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:xmpp:bob";
    }

    public final ContentId getContentId() {
        return this.cid;
    }

    public final BoBData getBobData() {
        return this.bobData;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute("cid", this.cid.getCid());
        xmlStringBuilder.attribute("type", this.bobData.getType());
        xmlStringBuilder.optAttribute("max-age", this.bobData.getMaxAge());
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append((CharSequence) this.bobData.getContentBase64Encoded());
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public static BoBDataExtension from(StanzaView stanzaView) {
        return (BoBDataExtension) stanzaView.getExtension(BoBDataExtension.class);
    }
}
