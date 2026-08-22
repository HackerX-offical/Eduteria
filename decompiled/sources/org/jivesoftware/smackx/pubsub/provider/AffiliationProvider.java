package org.jivesoftware.smackx.pubsub.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.pubsub.Affiliation;
import org.jxmpp.jid.EntityBareJid;

/* JADX INFO: loaded from: classes10.dex */
public class AffiliationProvider extends ExtensionElementProvider<Affiliation> {
    @Override // org.jivesoftware.smack.provider.Provider
    public Affiliation parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, NodeElement.ELEMENT);
        EntityBareJid bareJidAttribute = ParserUtils.getBareJidAttribute(xmlPullParser);
        Affiliation.AffiliationNamespace affiliationNamespaceFromXmlns = Affiliation.AffiliationNamespace.fromXmlns(xmlPullParser.getNamespace());
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "affiliation");
        Affiliation.Type typeValueOf = attributeValue2 != null ? Affiliation.Type.valueOf(attributeValue2) : null;
        if (attributeValue != null && bareJidAttribute == null) {
            return new Affiliation(attributeValue, typeValueOf, affiliationNamespaceFromXmlns);
        }
        if (attributeValue == null && bareJidAttribute != null) {
            return new Affiliation(bareJidAttribute, typeValueOf, affiliationNamespaceFromXmlns);
        }
        throw new IOException("Invalid affililation. Either one of 'node' or 'jid' must be set. Node: " + attributeValue + ". Jid: " + ((Object) bareJidAttribute) + '.');
    }
}
