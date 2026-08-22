package org.jivesoftware.smackx.jingle.provider;

import java.io.IOException;
import java.util.logging.Logger;
import org.jivesoftware.smack.packet.IqData;
import org.jivesoftware.smack.packet.StandardExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.parsing.StandardExtensionElementProvider;
import org.jivesoftware.smack.provider.AbstractC0760IqProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.jingle.element.Jingle;
import org.jivesoftware.smackx.jingle.element.JingleAction;
import org.jivesoftware.smackx.jingle.element.JingleContent;
import org.jivesoftware.smackx.jingle.element.JingleContentDescription;
import org.jivesoftware.smackx.jingle.element.JingleContentTransport;
import org.jivesoftware.smackx.jingle.element.JingleReason;
import org.jivesoftware.smackx.jingle.element.UnknownJingleContentDescription;
import org.jivesoftware.smackx.jingle.element.UnknownJingleContentTransport;

/* JADX INFO: loaded from: classes10.dex */
public class JingleProvider extends AbstractC0760IqProvider<Jingle> {
    private static final Logger LOGGER = Logger.getLogger(JingleProvider.class.getName());

    @Override // org.jivesoftware.smack.provider.AbstractC0760IqProvider
    public Jingle parse(XmlPullParser xmlPullParser, int i, IqData iqData, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        JingleReason jingleReason;
        Jingle.Builder builder = Jingle.builder(iqData);
        String attributeValue = xmlPullParser.getAttributeValue("", "action");
        if (attributeValue != null) {
            builder.setAction(JingleAction.fromString(attributeValue));
        }
        builder.setInitiator(ParserUtils.getFullJidAttribute(xmlPullParser, Jingle.INITIATOR_ATTRIBUTE_NAME));
        builder.setResponder(ParserUtils.getFullJidAttribute(xmlPullParser, Jingle.RESPONDER_ATTRIBUTE_NAME));
        builder.setSessionId(xmlPullParser.getAttributeValue("", "sid"));
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("reason")) {
                    xmlPullParser.next();
                    String name2 = xmlPullParser.getName();
                    if (name2.equals("alternative-session")) {
                        xmlPullParser.next();
                        jingleReason = new JingleReason.AlternativeSession(xmlPullParser.nextText());
                    } else {
                        jingleReason = new JingleReason(JingleReason.Reason.fromString(name2));
                    }
                    builder.setReason(jingleReason);
                } else if (name.equals("content")) {
                    builder.addJingleContent(parseJingleContent(xmlPullParser, xmlPullParser.getDepth()));
                } else {
                    LOGGER.severe("Unknown Jingle element: " + name);
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                return builder.build();
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.jingle.provider.JingleProvider$1, reason: invalid class name */
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

    /* JADX WARN: Multi-variable type inference failed */
    public static JingleContent parseJingleContent(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException, SmackParsingException {
        JingleContentTransport unknownJingleContentTransport;
        JingleContentDescription unknownJingleContentDescription;
        JingleContent.Builder builder = JingleContent.getBuilder();
        builder.setCreator(JingleContent.Creator.valueOf(xmlPullParser.getAttributeValue("", "creator")));
        builder.setDisposition(xmlPullParser.getAttributeValue("", JingleContent.DISPOSITION_ATTRIBUTE_NAME));
        builder.setName(xmlPullParser.getAttributeValue("", "name"));
        String attributeValue = xmlPullParser.getAttributeValue("", JingleContent.SENDERS_ATTRIBUTE_NAME);
        if (attributeValue != null) {
            builder.setSenders(JingleContent.Senders.valueOf(attributeValue));
        }
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                name.hashCode();
                if (name.equals("description")) {
                    JingleContentDescriptionProvider<?> jingleContentDescriptionProvider = JingleContentProviderManager.getJingleContentDescriptionProvider(namespace);
                    if (jingleContentDescriptionProvider == null) {
                        unknownJingleContentDescription = new UnknownJingleContentDescription((StandardExtensionElement) StandardExtensionElementProvider.INSTANCE.parse(xmlPullParser));
                    } else {
                        unknownJingleContentDescription = (JingleContentDescription) jingleContentDescriptionProvider.parse(xmlPullParser);
                    }
                    builder.setDescription(unknownJingleContentDescription);
                } else if (name.equals("transport")) {
                    JingleContentTransportProvider<?> jingleContentTransportProvider = JingleContentProviderManager.getJingleContentTransportProvider(namespace);
                    if (jingleContentTransportProvider == null) {
                        unknownJingleContentTransport = new UnknownJingleContentTransport((StandardExtensionElement) StandardExtensionElementProvider.INSTANCE.parse(xmlPullParser));
                    } else {
                        unknownJingleContentTransport = (JingleContentTransport) jingleContentTransportProvider.parse(xmlPullParser);
                    }
                    builder.setTransport(unknownJingleContentTransport);
                } else {
                    LOGGER.severe("Unknown Jingle content element: " + name);
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                return builder.build();
            }
        }
    }
}
