package org.jivesoftware.smackx.jingle.transports.jingle_s5b.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jivesoftware.smackx.jingle.provider.JingleContentTransportProvider;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransport;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportInfo;

/* JADX INFO: loaded from: classes10.dex */
public class JingleS5BTransportProvider extends JingleContentTransportProvider<JingleS5BTransport> {
    @Override // org.jivesoftware.smackx.jingle.provider.JingleContentTransportProvider, org.jivesoftware.smack.provider.Provider
    public JingleS5BTransport parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        JingleS5BTransport.Builder builder = JingleS5BTransport.getBuilder();
        builder.setStreamId(xmlPullParser.getAttributeValue(null, "sid"));
        builder.setDestinationAddress(xmlPullParser.getAttributeValue(null, JingleS5BTransport.ATTR_DSTADDR));
        String attributeValue = xmlPullParser.getAttributeValue(null, "mode");
        if (attributeValue != null) {
            builder.setMode(attributeValue.equals(Bytestream.Mode.udp.toString()) ? Bytestream.Mode.udp : Bytestream.Mode.tcp);
        }
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[xmlPullParser.nextTag().ordinal()];
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                switch (name) {
                    case "candidate-error":
                        builder.setTransportInfo(JingleS5BTransportInfo.CandidateError.INSTANCE);
                        break;
                    case "candidate":
                        JingleS5BTransportCandidate.Builder builder2 = JingleS5BTransportCandidate.getBuilder();
                        builder2.setCandidateId(xmlPullParser.getAttributeValue(null, "cid"));
                        builder2.setHost(xmlPullParser.getAttributeValue(null, JingleS5BTransportCandidate.ATTR_HOST));
                        builder2.setJid(xmlPullParser.getAttributeValue(null, "jid"));
                        builder2.setPriority(Integer.parseInt(xmlPullParser.getAttributeValue(null, "priority")));
                        String attributeValue2 = xmlPullParser.getAttributeValue(null, "port");
                        if (attributeValue2 != null) {
                            builder2.setPort(Integer.parseInt(attributeValue2));
                        }
                        String attributeValue3 = xmlPullParser.getAttributeValue(null, "type");
                        if (attributeValue3 != null) {
                            builder2.setType(JingleS5BTransportCandidate.Type.fromString(attributeValue3));
                        }
                        builder.addTransportCandidate(builder2.build());
                        break;
                    case "proxy-error":
                        builder.setTransportInfo(JingleS5BTransportInfo.ProxyError.INSTANCE);
                        break;
                    case "candidate-used":
                        builder.setTransportInfo(new JingleS5BTransportInfo.CandidateUsed(xmlPullParser.getAttributeValue(null, "cid")));
                        break;
                    case "candidate-activated":
                        builder.setTransportInfo(new JingleS5BTransportInfo.CandidateActivated(xmlPullParser.getAttributeValue(null, "cid")));
                        break;
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                return builder.build();
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.jingle.transports.jingle_s5b.provider.JingleS5BTransportProvider$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent;

        static {
            int[] iArr = new int[XmlPullParser.TagEvent.values().length];
            $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent = iArr;
            try {
                iArr[XmlPullParser.TagEvent.START_ELEMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[XmlPullParser.TagEvent.END_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
