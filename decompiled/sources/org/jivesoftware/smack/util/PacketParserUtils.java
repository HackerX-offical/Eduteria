package org.jivesoftware.smack.util;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.compress.packet.Compress;
import org.jivesoftware.smack.packet.EmptyResultIQ;
import org.jivesoftware.smack.packet.ErrorIQ;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IqData;
import org.jivesoftware.smack.packet.Mechanisms;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.PresenceBuilder;
import org.jivesoftware.smack.packet.Session;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaBuilder;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.packet.StartTls;
import org.jivesoftware.smack.packet.StreamError;
import org.jivesoftware.smack.packet.UnparsedIQ;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.parsing.StandardExtensionElementProvider;
import org.jivesoftware.smack.provider.AbstractC0760IqProvider;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smack.xml.SmackXmlParser;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.sid.element.StanzaIdElement;
import org.jivesoftware.smackx.xdata.FormField;
import org.jxmpp.jid.Jid;
import org.jxmpp.stringprep.XmppStringprepException;

/* JADX INFO: loaded from: classes10.dex */
public class PacketParserUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger LOGGER = Logger.getLogger(PacketParserUtils.class.getName());

    /* JADX INFO: Access modifiers changed from: private */
    interface StanzaBuilderSupplier<SB extends StanzaBuilder<?>> {
        SB get(String str);
    }

    public static XmlPullParser getParserFor(String str) throws XmlPullParserException, IOException {
        return getParserFor(new StringReader(str));
    }

    public static XmlPullParser getParserFor(InputStream inputStream) throws XmlPullParserException {
        return SmackXmlParser.newXmlParser(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
    }

    public static XmlPullParser getParserFor(Reader reader) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParserNewXmlParser = SmackXmlParser.newXmlParser(reader);
        ParserUtils.forwardToStartElement(xmlPullParserNewXmlParser);
        return xmlPullParserNewXmlParser;
    }

    public static <S extends Stanza> S parseStanza(String str) throws XmlPullParserException, SmackParsingException, IOException {
        return (S) parseStanza(getParserFor(str), XmlEnvironment.EMPTY);
    }

    public static Stanza parseStanza(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, SmackParsingException, IOException {
        String name;
        ParserUtils.assertAtStartTag(xmlPullParser);
        name = xmlPullParser.getName();
        name.hashCode();
        switch (name) {
            case "presence":
                return parsePresence(xmlPullParser, xmlEnvironment);
            case "iq":
                return parseIQ(xmlPullParser, xmlEnvironment);
            case "message":
                return parseMessage(xmlPullParser, xmlEnvironment);
            default:
                throw new IllegalArgumentException("Can only parse message, iq or presence, not " + name);
        }
    }

    private static <SB extends StanzaBuilder<?>> SB parseCommonStanzaAttributes(StanzaBuilderSupplier<SB> stanzaBuilderSupplier, XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmppStringprepException {
        SB sb = (SB) stanzaBuilderSupplier.get(xmlPullParser.getAttributeValue("id"));
        sb.to(ParserUtils.getJidAttribute(xmlPullParser, "to"));
        sb.from(ParserUtils.getJidAttribute(xmlPullParser, "from"));
        sb.setLanguage(ParserUtils.getXmlLang(xmlPullParser, xmlEnvironment));
        return sb;
    }

    public static Message parseMessage(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, SmackParsingException {
        return parseMessage(xmlPullParser, XmlEnvironment.EMPTY);
    }

    public static Message parseMessage(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        XmlEnvironment xmlEnvironmentFrom = XmlEnvironment.from(xmlPullParser, xmlEnvironment);
        int depth = xmlPullParser.getDepth();
        MessageBuilder messageBuilder = (MessageBuilder) parseCommonStanzaAttributes(new StanzaBuilderSupplier() { // from class: org.jivesoftware.smack.util.PacketParserUtils$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.util.PacketParserUtils.StanzaBuilderSupplier
            public final StanzaBuilder get(String str) {
                return StanzaBuilder.buildMessage(str);
            }
        }, xmlPullParser, xmlEnvironment);
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null) {
            messageBuilder.ofType(Message.Type.fromString(attributeValue));
        }
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                name.hashCode();
                if (name.equals("error")) {
                    messageBuilder.setError(parseError(xmlPullParser, xmlEnvironmentFrom));
                } else {
                    messageBuilder.addExtension(parseExtensionElement(name, namespace, xmlPullParser, xmlEnvironmentFrom));
                }
            } else if (i == 2 && xmlPullParser.getDepth() == depth) {
                return messageBuilder.build();
            }
        }
    }

    public static String parseElementText(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        XmlPullParser.Event next = xmlPullParser.next();
        if (next != XmlPullParser.Event.TEXT_CHARACTERS) {
            if (next == XmlPullParser.Event.END_ELEMENT) {
                return "";
            }
            throw new XmlPullParserException("Non-empty element tag not followed by text, while Mixed Content (XML 3.2.2) is disallowed");
        }
        String text = xmlPullParser.getText();
        if (xmlPullParser.next() == XmlPullParser.Event.END_ELEMENT) {
            return text;
        }
        throw new XmlPullParserException("Non-empty element tag contains child-elements, while Mixed Content (XML 3.2.2) is disallowed");
    }

    public static CharSequence parseElement(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return parseElement(xmlPullParser, false);
    }

    public static CharSequence parseElement(XmlPullParser xmlPullParser, boolean z) throws XmlPullParserException, IOException {
        return parseContentDepth(xmlPullParser, xmlPullParser.getDepth(), z);
    }

    public static CharSequence parseContentDepth(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
        return parseContentDepth(xmlPullParser, i, false);
    }

    public static CharSequence parseContentDepth(XmlPullParser xmlPullParser, int i, boolean z) throws XmlPullParserException, IOException {
        if (xmlPullParser.supportsRoundtrip()) {
            return parseContentDepthWithRoundtrip(xmlPullParser, i);
        }
        return parseContentDepthWithoutRoundtrip(xmlPullParser, i, z);
    }

    private static CharSequence parseContentDepthWithoutRoundtrip(XmlPullParser xmlPullParser, int i, boolean z) throws XmlPullParserException, IOException {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        XmlPullParser.Event eventType = xmlPullParser.getEventType();
        String name = null;
        boolean z2 = false;
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[eventType.ordinal()];
            if (i2 == 1) {
                if (z2) {
                    xmlStringBuilder.rightAngleBracket();
                } else {
                    z2 = true;
                }
                xmlStringBuilder.halfOpenElement(xmlPullParser.getName());
                if (name == null || z) {
                    String namespace = xmlPullParser.getNamespace();
                    if (StringUtils.isNotEmpty(namespace)) {
                        xmlStringBuilder.attribute("xmlns", namespace);
                        name = xmlPullParser.getName();
                    }
                }
                for (int i3 = 0; i3 < xmlPullParser.getAttributeCount(); i3++) {
                    xmlStringBuilder.attribute(xmlPullParser.getAttributeName(i3), xmlPullParser.getAttributeValue(i3));
                }
            } else if (i2 == 2) {
                if (z2) {
                    xmlStringBuilder.closeEmptyElement();
                    z2 = false;
                } else {
                    xmlStringBuilder.closeElement(xmlPullParser.getName());
                }
                if (name != null && name.equals(xmlPullParser.getName())) {
                    name = null;
                }
                if (xmlPullParser.getDepth() <= i) {
                    return xmlStringBuilder;
                }
            } else if (i2 == 3) {
                if (z2) {
                    xmlStringBuilder.rightAngleBracket();
                    z2 = false;
                }
                xmlStringBuilder.escape(xmlPullParser.getText());
            }
            eventType = xmlPullParser.next();
        }
    }

    private static XmlStringBuilder parseContentDepthWithRoundtrip(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        XmlPullParser.Event eventType = xmlPullParser.getEventType();
        boolean z = false;
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[eventType.ordinal()];
            if (i2 == 1) {
                xmlStringBuilder.append((CharSequence) xmlPullParser.getText());
                z = true;
            } else if (i2 == 2) {
                boolean z2 = z ? false : z;
                if (!z) {
                    xmlStringBuilder.append((CharSequence) xmlPullParser.getText());
                }
                if (xmlPullParser.getDepth() <= i) {
                    return xmlStringBuilder;
                }
                z = z2;
            } else {
                CharSequence text = xmlPullParser.getText();
                if (eventType == XmlPullParser.Event.TEXT_CHARACTERS) {
                    text = StringUtils.escapeForXml(text);
                }
                xmlStringBuilder.append(text);
                z = false;
            }
            eventType = xmlPullParser.next();
        }
    }

    public static Presence parsePresence(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, SmackParsingException {
        return parsePresence(xmlPullParser, XmlEnvironment.EMPTY);
    }

    public static Presence parsePresence(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        String name;
        String namespace;
        ParserUtils.assertAtStartTag(xmlPullParser);
        int depth = xmlPullParser.getDepth();
        XmlEnvironment xmlEnvironmentFrom = XmlEnvironment.from(xmlPullParser, xmlEnvironment);
        PresenceBuilder presenceBuilder = (PresenceBuilder) parseCommonStanzaAttributes(new StanzaBuilderSupplier() { // from class: org.jivesoftware.smack.util.PacketParserUtils$$ExternalSyntheticLambda1
            @Override // org.jivesoftware.smack.util.PacketParserUtils.StanzaBuilderSupplier
            public final StanzaBuilder get(String str) {
                return StanzaBuilder.buildPresence(str);
            }
        }, xmlPullParser, xmlEnvironment);
        Presence.Type typeFromString = Presence.Type.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            typeFromString = Presence.Type.fromString(attributeValue);
        }
        presenceBuilder.ofType(typeFromString);
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                name = xmlPullParser.getName();
                namespace = xmlPullParser.getNamespace();
                name.hashCode();
                switch (name) {
                    case "priority":
                        presenceBuilder.setPriority(ParserUtils.getByteAttributeFromNextText(xmlPullParser));
                        break;
                    case "status":
                        presenceBuilder.setStatus(xmlPullParser.nextText());
                        break;
                    case "show":
                        String strNextText = xmlPullParser.nextText();
                        if (StringUtils.isNotEmpty(strNextText)) {
                            presenceBuilder.setMode(Presence.Mode.fromString(strNextText));
                            break;
                        } else {
                            LOGGER.warning("Empty or null mode text in presence show element form " + presenceBuilder + "' which is invalid according to RFC6121 4.7.2.1");
                            break;
                        }
                        break;
                    case "error":
                        presenceBuilder.setError(parseError(xmlPullParser, xmlEnvironmentFrom));
                        break;
                    default:
                        try {
                            presenceBuilder.addExtension(parseExtensionElement(name, namespace, xmlPullParser, xmlEnvironmentFrom));
                            break;
                        } catch (Exception e2) {
                            LOGGER.log(Level.WARNING, "Failed to parse extension element in Presence stanza: " + presenceBuilder, (Throwable) e2);
                            break;
                        }
                        break;
                }
            } else if (i == 2 && xmlPullParser.getDepth() == depth) {
                return presenceBuilder.build();
            }
        }
    }

    public static IQ parseIQ(XmlPullParser xmlPullParser) throws Exception {
        return parseIQ(xmlPullParser, null);
    }

    public static IQ parseIQ(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        int depth = xmlPullParser.getDepth();
        XmlEnvironment xmlEnvironmentFrom = XmlEnvironment.from(xmlPullParser, xmlEnvironment);
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        IqData iqDataBuildIqData = StanzaBuilder.buildIqData(attributeValue);
        Jid jidAttribute = ParserUtils.getJidAttribute(xmlPullParser, "to");
        iqDataBuildIqData.to(jidAttribute);
        Jid jidAttribute2 = ParserUtils.getJidAttribute(xmlPullParser, "from");
        iqDataBuildIqData.from(jidAttribute2);
        IQ.Type typeFromString = IQ.Type.fromString(xmlPullParser.getAttributeValue("", "type"));
        iqDataBuildIqData.ofType(typeFromString);
        IQ errorIQ = null;
        StanzaError error = null;
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                name.hashCode();
                if (name.equals("error")) {
                    error = parseError(xmlPullParser, xmlEnvironmentFrom);
                } else {
                    AbstractC0760IqProvider<IQ> iQProvider = ProviderManager.getIQProvider(name, namespace);
                    if (iQProvider != null) {
                        errorIQ = iQProvider.parse(xmlPullParser, iqDataBuildIqData, xmlEnvironment);
                    } else {
                        errorIQ = new UnparsedIQ(name, namespace, parseElement(xmlPullParser));
                    }
                }
            } else if (i == 2 && xmlPullParser.getDepth() == depth) {
                break;
            }
        }
        if (errorIQ == null) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[typeFromString.ordinal()];
            if (i2 == 1) {
                errorIQ = new ErrorIQ(error);
            } else if (i2 == 2) {
                errorIQ = new EmptyResultIQ();
            }
        }
        errorIQ.setStanzaId(attributeValue);
        errorIQ.setTo(jidAttribute);
        errorIQ.setFrom(jidAttribute2);
        errorIQ.setType(typeFromString);
        errorIQ.setError(error);
        return errorIQ;
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.util.PacketParserUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$IQ$Type;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;

        static {
            int[] iArr = new int[IQ.Type.values().length];
            $SwitchMap$org$jivesoftware$smack$packet$IQ$Type = iArr;
            try {
                iArr[IQ.Type.error.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$IQ$Type[IQ.Type.result.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[XmlPullParser.Event.values().length];
            $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event = iArr2;
            try {
                iArr2[XmlPullParser.Event.START_ELEMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[XmlPullParser.Event.END_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[XmlPullParser.Event.TEXT_CHARACTERS.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static Collection<String> parseMechanisms(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (!z) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals("mechanism")) {
                    arrayList.add(xmlPullParser.nextText());
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals(Mechanisms.ELEMENT)) {
                z = true;
            }
        }
        return arrayList;
    }

    public static Compress.Feature parseCompressionFeature(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals(FirebaseAnalytics.Param.METHOD)) {
                    linkedList.add(xmlPullParser.nextText());
                }
            } else if (i != 2) {
                continue;
            } else {
                String name2 = xmlPullParser.getName();
                name2.hashCode();
                if (name2.equals(Compress.Feature.ELEMENT) && xmlPullParser.getDepth() == depth) {
                    return new Compress.Feature(linkedList);
                }
            }
        }
    }

    public static Map<String, String> parseDescriptiveTexts(XmlPullParser xmlPullParser, Map<String, String> map) throws XmlPullParserException, IOException {
        if (map == null) {
            map = new HashMap<>();
        }
        String xmlLang = ParserUtils.getXmlLang(xmlPullParser);
        if (xmlLang == null) {
            xmlLang = "";
        }
        map.put(xmlLang, xmlPullParser.nextText());
        return map;
    }

    public static StreamError parseStreamError(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, SmackParsingException {
        return parseStreamError(xmlPullParser, null);
    }

    public static StreamError parseStreamError(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList = new ArrayList();
        XmlEnvironment xmlEnvironmentFrom = XmlEnvironment.from(xmlPullParser, xmlEnvironment);
        StreamError.Condition conditionFromString = null;
        String strNextText = null;
        Map<String, String> descriptiveTexts = null;
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                namespace.hashCode();
                if (namespace.equals(StreamError.NAMESPACE)) {
                    name.hashCode();
                    if (name.equals("text")) {
                        descriptiveTexts = parseDescriptiveTexts(xmlPullParser, descriptiveTexts);
                    } else {
                        conditionFromString = StreamError.Condition.fromString(name);
                        strNextText = xmlPullParser.nextText();
                        if (strNextText.isEmpty()) {
                            strNextText = null;
                        }
                    }
                } else {
                    addExtensionElement(arrayList, xmlPullParser, name, namespace, xmlEnvironmentFrom);
                }
            } else if (i == 2 && xmlPullParser.getDepth() == depth) {
                return new StreamError(conditionFromString, strNextText, descriptiveTexts, arrayList);
            }
        }
    }

    public static StanzaError parseError(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, SmackParsingException {
        return parseError(xmlPullParser, null);
    }

    public static StanzaError parseError(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        int depth = xmlPullParser.getDepth();
        XmlEnvironment xmlEnvironmentFrom = XmlEnvironment.from(xmlPullParser, xmlEnvironment);
        ArrayList arrayList = new ArrayList();
        StanzaError.Builder builder = StanzaError.getBuilder();
        builder.setType(StanzaError.Type.fromString(xmlPullParser.getAttributeValue("", "type")));
        builder.setErrorGenerator(xmlPullParser.getAttributeValue("", StanzaIdElement.ATTR_BY));
        Map<String, String> descriptiveTexts = null;
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                namespace.hashCode();
                if (namespace.equals("urn:ietf:params:xml:ns:xmpp-stanzas")) {
                    name.hashCode();
                    if (name.equals("text")) {
                        descriptiveTexts = parseDescriptiveTexts(xmlPullParser, descriptiveTexts);
                    } else {
                        builder.setCondition(StanzaError.Condition.fromString(name));
                        String strNextText = xmlPullParser.nextText();
                        if (!strNextText.isEmpty()) {
                            builder.setConditionText(strNextText);
                        }
                    }
                } else {
                    addExtensionElement(arrayList, xmlPullParser, name, namespace, xmlEnvironmentFrom);
                }
            } else if (i == 2 && xmlPullParser.getDepth() == depth) {
                builder.setExtensions(arrayList).setDescriptiveTexts(descriptiveTexts);
                return builder.build();
            }
        }
    }

    public static ExtensionElement parseExtensionElement(String str, String str2, XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        ExtensionElementProvider<ExtensionElement> extensionProvider = ProviderManager.getExtensionProvider(str, str2);
        if (extensionProvider != null) {
            return extensionProvider.parse(xmlPullParser, xmlEnvironment);
        }
        return (ExtensionElement) StandardExtensionElementProvider.INSTANCE.parse(xmlPullParser, xmlEnvironment);
    }

    public static StartTls parseStartTlsFeature(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        int depth = xmlPullParser.getDepth();
        boolean z = false;
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals(FormField.Required.ELEMENT)) {
                    z = true;
                }
            } else if (i == 2 && xmlPullParser.getDepth() == depth) {
                ParserUtils.assertAtEndTag(xmlPullParser);
                return new StartTls(z);
            }
        }
    }

    public static Session.Feature parseSessionFeature(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        int depth = xmlPullParser.getDepth();
        boolean z = false;
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals(Session.Feature.OPTIONAL_ELEMENT)) {
                    z = true;
                }
            } else if (i == 2 && xmlPullParser.getDepth() == depth) {
                return new Session.Feature(z);
            }
        }
    }

    public static void addExtensionElement(StanzaBuilder<?> stanzaBuilder, XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        addExtensionElement(stanzaBuilder, xmlPullParser, xmlPullParser.getName(), xmlPullParser.getNamespace(), xmlEnvironment);
    }

    public static void addExtensionElement(StanzaBuilder<?> stanzaBuilder, XmlPullParser xmlPullParser, String str, String str2, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        stanzaBuilder.addExtension(parseExtensionElement(str, str2, xmlPullParser, xmlEnvironment));
    }

    public static void addExtensionElement(Stanza stanza, XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        addExtensionElement(stanza, xmlPullParser, xmlPullParser.getName(), xmlPullParser.getNamespace(), xmlEnvironment);
    }

    public static void addExtensionElement(Stanza stanza, XmlPullParser xmlPullParser, String str, String str2, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        stanza.addExtension(parseExtensionElement(str, str2, xmlPullParser, xmlEnvironment));
    }

    public static void addExtensionElement(Collection<ExtensionElement> collection, XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        addExtensionElement(collection, xmlPullParser, xmlPullParser.getName(), xmlPullParser.getNamespace(), xmlEnvironment);
    }

    public static void addExtensionElement(Collection<ExtensionElement> collection, XmlPullParser xmlPullParser, String str, String str2, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        collection.add(parseExtensionElement(str, str2, xmlPullParser, xmlEnvironment));
    }
}
