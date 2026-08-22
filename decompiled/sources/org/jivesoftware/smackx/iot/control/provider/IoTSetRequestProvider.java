package org.jivesoftware.smackx.iot.control.provider;

import java.io.IOException;
import java.util.ArrayList;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.iot.control.element.IoTSetRequest;
import org.jivesoftware.smackx.iot.control.element.SetBoolData;
import org.jivesoftware.smackx.iot.control.element.SetDoubleData;
import org.jivesoftware.smackx.iot.control.element.SetIntData;
import org.jivesoftware.smackx.iot.control.element.SetLongData;

/* JADX INFO: loaded from: classes10.dex */
public class IoTSetRequestProvider extends IQProvider<IoTSetRequest> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public IoTSetRequest parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList(4);
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                switch (name) {
                    case "double":
                        arrayList.add(new SetDoubleData(xmlPullParser.getAttributeValue(null, "name"), Double.parseDouble(xmlPullParser.getAttributeValue(null, "value"))));
                        break;
                    case "int":
                        arrayList.add(new SetIntData(xmlPullParser.getAttributeValue(null, "name"), Integer.parseInt(xmlPullParser.getAttributeValue(null, "value"))));
                        break;
                    case "bool":
                        arrayList.add(new SetBoolData(xmlPullParser.getAttributeValue(null, "name"), Boolean.parseBoolean(xmlPullParser.getAttributeValue(null, "value"))));
                        break;
                    case "long":
                        arrayList.add(new SetLongData(xmlPullParser.getAttributeValue(null, "name"), Long.parseLong(xmlPullParser.getAttributeValue(null, "value"))));
                        break;
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                return new IoTSetRequest(arrayList);
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.iot.control.provider.IoTSetRequestProvider$1, reason: invalid class name */
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
