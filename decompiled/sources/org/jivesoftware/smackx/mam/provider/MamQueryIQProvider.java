package org.jivesoftware.smackx.mam.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.mam.element.MamQueryIQ;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jivesoftware.smackx.xdata.provider.DataFormProvider;

/* JADX INFO: loaded from: classes10.dex */
public class MamQueryIQProvider extends IQProvider<MamQueryIQ> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jivesoftware.smack.provider.IQProvider
    public MamQueryIQ parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        String attributeValue = xmlPullParser.getAttributeValue("", "queryid");
        String attributeValue2 = xmlPullParser.getAttributeValue("", NodeElement.ELEMENT);
        DataForm dataForm = null;
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("x")) {
                    dataForm = (DataForm) DataFormProvider.INSTANCE.parse(xmlPullParser);
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                return new MamQueryIQ(attributeValue, attributeValue2, dataForm);
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.mam.provider.MamQueryIQProvider$1, reason: invalid class name */
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
