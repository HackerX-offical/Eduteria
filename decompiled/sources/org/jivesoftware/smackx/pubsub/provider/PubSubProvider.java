package org.jivesoftware.smackx.pubsub.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.pubsub.packet.PubSub;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;

/* JADX INFO: loaded from: classes10.dex */
public class PubSubProvider extends IQProvider<PubSub> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public PubSub parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        PubSub pubSub = new PubSub(PubSubNamespace.valueOfFromXmlns(xmlPullParser.getNamespace()));
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                PacketParserUtils.addExtensionElement(pubSub, xmlPullParser, xmlEnvironment);
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                return pubSub;
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.pubsub.provider.PubSubProvider$1, reason: invalid class name */
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
