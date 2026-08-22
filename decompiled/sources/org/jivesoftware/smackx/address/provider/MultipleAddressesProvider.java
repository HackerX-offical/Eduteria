package org.jivesoftware.smackx.address.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;
import org.jivesoftware.smackx.iot.data.element.NodeElement;

/* JADX INFO: loaded from: classes10.dex */
public class MultipleAddressesProvider extends ExtensionElementProvider<MultipleAddresses> {
    @Override // org.jivesoftware.smack.provider.Provider
    public MultipleAddresses parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        MultipleAddresses multipleAddresses = new MultipleAddresses();
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("address")) {
                    multipleAddresses.addAddress(MultipleAddresses.Type.valueOf(xmlPullParser.getAttributeValue("", "type")), ParserUtils.getJidAttribute(xmlPullParser, "jid"), xmlPullParser.getAttributeValue("", NodeElement.ELEMENT), xmlPullParser.getAttributeValue("", "desc"), "true".equals(xmlPullParser.getAttributeValue("", "delivered")), xmlPullParser.getAttributeValue("", "uri"));
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                return multipleAddresses;
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.address.provider.MultipleAddressesProvider$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;

        static {
            int[] iArr = new int[XmlPullParser.Event.values().length];
            $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event = iArr;
            try {
                iArr[XmlPullParser.Event.START_ELEMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[XmlPullParser.Event.END_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
