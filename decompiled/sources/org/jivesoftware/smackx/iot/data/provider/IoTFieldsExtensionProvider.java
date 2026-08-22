package org.jivesoftware.smackx.iot.data.provider;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.iot.data.element.IoTDataField;
import org.jivesoftware.smackx.iot.data.element.IoTFieldsExtension;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.iot.data.element.TimestampElement;
import org.jivesoftware.smackx.iot.element.NodeInfo;
import org.jivesoftware.smackx.iot.parser.NodeInfoParser;
import org.jxmpp.util.XmppDateTime;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: loaded from: classes10.dex */
public class IoTFieldsExtensionProvider extends ExtensionElementProvider<IoTFieldsExtension> {
    private static final Logger LOGGER = Logger.getLogger(IoTFieldsExtensionProvider.class.getName());

    @Override // org.jivesoftware.smack.provider.Provider
    public IoTFieldsExtension parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws SmackParsingException.SmackTextParseException, XmlPullParserException, IOException {
        int integerAttributeOrThrow = ParserUtils.getIntegerAttributeOrThrow(xmlPullParser, "seqnr", "IoT data request <accepted/> without sequence number");
        boolean booleanAttribute = ParserUtils.getBooleanAttribute(xmlPullParser, ES6Iterator.DONE_PROPERTY, false);
        ArrayList arrayList = new ArrayList();
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            String name = xmlPullParser.getName();
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[next.ordinal()];
            if (i2 == 1) {
                name.hashCode();
                if (name.equals(NodeElement.ELEMENT)) {
                    arrayList.add(parseNode(xmlPullParser));
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                return new IoTFieldsExtension(integerAttributeOrThrow, booleanAttribute, arrayList);
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.iot.data.provider.IoTFieldsExtensionProvider$1, reason: invalid class name */
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

    public NodeElement parseNode(XmlPullParser xmlPullParser) throws SmackParsingException.SmackTextParseException, XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        NodeInfo nodeInfo = NodeInfoParser.parse(xmlPullParser);
        ArrayList arrayList = new ArrayList();
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            String name = xmlPullParser.getName();
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[next.ordinal()];
            if (i == 1) {
                name.hashCode();
                if (name.equals("timestamp")) {
                    arrayList.add(parseTimestampElement(xmlPullParser));
                }
            } else if (i == 2 && xmlPullParser.getDepth() == depth) {
                return new NodeElement(nodeInfo, arrayList);
            }
        }
    }

    public TimestampElement parseTimestampElement(XmlPullParser xmlPullParser) throws SmackParsingException.SmackTextParseException, XmlPullParserException, IOException {
        IoTDataField intField;
        int depth = xmlPullParser.getDepth();
        try {
            Date date = XmppDateTime.parseDate(xmlPullParser.getAttributeValue(null, "value"));
            ArrayList arrayList = new ArrayList();
            while (true) {
                int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
                if (i == 1) {
                    String name = xmlPullParser.getName();
                    String attributeValue = xmlPullParser.getAttributeValue(null, "name");
                    String attributeValue2 = xmlPullParser.getAttributeValue(null, "value");
                    name.hashCode();
                    if (name.equals("int")) {
                        intField = new IoTDataField.IntField(attributeValue, Integer.parseInt(attributeValue2));
                    } else if (name.equals("boolean")) {
                        intField = new IoTDataField.BooleanField(attributeValue, Boolean.parseBoolean(attributeValue2));
                    } else {
                        LOGGER.warning("IoT Data field type '" + name + "' not implement yet. Ignoring.");
                        intField = null;
                    }
                    if (intField != null) {
                        arrayList.add(intField);
                    }
                } else if (i == 2 && xmlPullParser.getDepth() == depth) {
                    return new TimestampElement(date, arrayList);
                }
            }
        } catch (ParseException e2) {
            throw new SmackParsingException.SmackTextParseException(e2);
        }
    }
}
