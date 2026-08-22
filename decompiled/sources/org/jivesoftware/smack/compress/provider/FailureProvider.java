package org.jivesoftware.smack.compress.provider;

import java.io.IOException;
import java.util.logging.Logger;
import org.jivesoftware.smack.compress.packet.Failure;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.NonzaProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
public final class FailureProvider extends NonzaProvider<Failure> {
    private static final Logger LOGGER = Logger.getLogger(FailureProvider.class.getName());
    public static final FailureProvider INSTANCE = new FailureProvider();

    private FailureProvider() {
    }

    @Override // org.jivesoftware.smack.provider.Provider
    public Failure parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        String name;
        String namespace;
        XmlEnvironment xmlEnvironmentFrom = XmlEnvironment.from(xmlPullParser, xmlEnvironment);
        Failure.CompressFailureError compressFailureErrorValueOf = null;
        StanzaError error = null;
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                name = xmlPullParser.getName();
                namespace = xmlPullParser.getNamespace();
                namespace.hashCode();
                switch (namespace) {
                    case "jabber:client":
                    case "jabber:server":
                        name.hashCode();
                        if (name.equals("error")) {
                            error = PacketParserUtils.parseError(xmlPullParser, xmlEnvironmentFrom);
                            break;
                        } else {
                            LOGGER.warning("Unknown element in " + namespace + ": " + name);
                            break;
                        }
                        break;
                    case "http://jabber.org/protocol/compress":
                        compressFailureErrorValueOf = Failure.CompressFailureError.valueOf(name.replace("-", "_"));
                        if (compressFailureErrorValueOf != null) {
                            break;
                        } else {
                            LOGGER.warning("Unknown element in http://jabber.org/protocol/compress: " + name);
                            break;
                        }
                        break;
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                return new Failure(compressFailureErrorValueOf, error);
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.compress.provider.FailureProvider$1, reason: invalid class name */
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
