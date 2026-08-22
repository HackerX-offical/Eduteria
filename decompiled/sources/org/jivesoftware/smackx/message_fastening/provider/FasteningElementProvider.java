package org.jivesoftware.smackx.message_fastening.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.message_fastening.element.ExternalElement;
import org.jivesoftware.smackx.message_fastening.element.FasteningElement;

/* JADX INFO: loaded from: classes10.dex */
public class FasteningElementProvider extends ExtensionElementProvider<FasteningElement> {
    public static final FasteningElementProvider TEST_INSTANCE = new FasteningElementProvider();

    @Override // org.jivesoftware.smack.provider.Provider
    public FasteningElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        FasteningElement.Builder builder = FasteningElement.builder();
        builder.setOriginId(xmlPullParser.getAttributeValue("", "id"));
        if (ParserUtils.getBooleanAttribute(xmlPullParser, FasteningElement.ATTR_CLEAR, false)) {
            builder.setClear();
        }
        if (ParserUtils.getBooleanAttribute(xmlPullParser, FasteningElement.ATTR_SHELL, false)) {
            builder.setShell();
        }
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if ("urn:xmpp:fasten:0".equals(namespace) && ExternalElement.ELEMENT.equals(name)) {
                    builder.addExternalPayload(new ExternalElement(xmlPullParser.getAttributeValue("", "name"), xmlPullParser.getAttributeValue("", ExternalElement.ATTR_ELEMENT_NAMESPACE)));
                } else {
                    builder.addWrappedPayload(PacketParserUtils.parseExtensionElement(name, namespace, xmlPullParser, xmlEnvironment));
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                return builder.build();
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.message_fastening.provider.FasteningElementProvider$1, reason: invalid class name */
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
