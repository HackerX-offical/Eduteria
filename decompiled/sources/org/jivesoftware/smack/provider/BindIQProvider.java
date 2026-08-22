package org.jivesoftware.smack.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.Bind;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.jid.parts.Resourcepart;

/* JADX INFO: loaded from: classes10.dex */
public class BindIQProvider extends IQProvider<Bind> {

    /* JADX INFO: renamed from: org.jivesoftware.smack.provider.BindIQProvider$1, reason: invalid class name */
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
    public Bind parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        Bind bindNewResult = null;
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("resource")) {
                    bindNewResult = Bind.newSet(Resourcepart.from(xmlPullParser.nextText()));
                } else if (name.equals("jid")) {
                    bindNewResult = Bind.newResult(JidCreate.entityFullFrom(xmlPullParser.nextText()));
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                return bindNewResult;
            }
        }
    }
}
