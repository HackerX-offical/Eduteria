package org.jivesoftware.smackx.forward.provider;

import java.io.IOException;
import java.util.logging.Logger;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.delay.packet.DelayInformation;
import org.jivesoftware.smackx.delay.provider.DelayInformationProvider;
import org.jivesoftware.smackx.forward.packet.Forwarded;

/* JADX INFO: loaded from: classes10.dex */
public class ForwardedProvider extends ExtensionElementProvider<Forwarded<?>> {
    public static final ForwardedProvider INSTANCE = new ForwardedProvider();
    private static final Logger LOGGER = Logger.getLogger(ForwardedProvider.class.getName());

    /* JADX INFO: renamed from: org.jivesoftware.smackx.forward.provider.ForwardedProvider$1, reason: invalid class name */
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
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // org.jivesoftware.smack.provider.Provider
    public Forwarded<?> parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        Message message = null;
        DelayInformation delayInformation = null;
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                name.hashCode();
                if (name.equals("delay")) {
                    if (DelayInformation.NAMESPACE.equals(namespace)) {
                        delayInformation = DelayInformationProvider.INSTANCE.parse(xmlPullParser, xmlPullParser.getDepth(), (XmlEnvironment) null);
                    } else {
                        LOGGER.warning("Namespace '" + namespace + "' does not match expected namespace 'urn:xmpp:delay'");
                    }
                } else if (name.equals("message")) {
                    message = PacketParserUtils.parseMessage(xmlPullParser);
                } else {
                    LOGGER.warning("Unsupported forwarded packet type: " + name);
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                break;
            }
        }
        if (message == null) {
            throw new IOException("forwarded extension must contain a packet");
        }
        return new Forwarded<>(message, delayInformation);
    }

    public static Forwarded<Message> parseForwardedMessage(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        return parseForwardedMessage(xmlPullParser, xmlPullParser.getDepth(), xmlEnvironment);
    }

    public static Forwarded<Message> parseForwardedMessage(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        Forwarded forwarded = INSTANCE.parse(xmlPullParser, i, xmlEnvironment);
        if (forwarded.isForwarded(Message.class)) {
            return forwarded;
        }
        throw new SmackParsingException("Expecting a forwarded message, but got " + forwarded);
    }
}
