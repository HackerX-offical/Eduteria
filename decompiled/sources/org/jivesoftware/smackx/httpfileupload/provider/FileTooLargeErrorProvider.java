package org.jivesoftware.smackx.httpfileupload.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.httpfileupload.element.FileTooLargeError;
import org.jivesoftware.smackx.httpfileupload.element.FileTooLargeError_V0_2;

/* JADX INFO: loaded from: classes10.dex */
public class FileTooLargeErrorProvider extends ExtensionElementProvider<FileTooLargeError> {
    @Override // org.jivesoftware.smack.provider.Provider
    public FileTooLargeError parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        String namespace = xmlPullParser.getNamespace();
        Long lValueOf = null;
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("max-file-size")) {
                    lValueOf = Long.valueOf(xmlPullParser.nextText());
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                break;
            }
        }
        namespace.hashCode();
        if (namespace.equals("urn:xmpp:http:upload:0")) {
            return new FileTooLargeError(lValueOf.longValue());
        }
        if (namespace.equals("urn:xmpp:http:upload")) {
            return new FileTooLargeError_V0_2(lValueOf.longValue());
        }
        throw new AssertionError();
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.httpfileupload.provider.FileTooLargeErrorProvider$1, reason: invalid class name */
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
