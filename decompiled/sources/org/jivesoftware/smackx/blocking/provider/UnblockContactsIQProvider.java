package org.jivesoftware.smackx.blocking.provider;

import java.io.IOException;
import java.util.ArrayList;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.blocking.element.UnblockContactsIQ;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: loaded from: classes10.dex */
public class UnblockContactsIQProvider extends IQProvider<UnblockContactsIQ> {

    /* JADX INFO: renamed from: org.jivesoftware.smackx.blocking.provider.UnblockContactsIQProvider$1, reason: invalid class name */
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

    @Override // org.jivesoftware.smack.provider.IQProvider
    public UnblockContactsIQ parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        ArrayList arrayList = null;
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                if (xmlPullParser.getName().equals("item")) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(JidCreate.from(xmlPullParser.getAttributeValue("", "jid")));
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                return new UnblockContactsIQ(arrayList);
            }
        }
    }
}
