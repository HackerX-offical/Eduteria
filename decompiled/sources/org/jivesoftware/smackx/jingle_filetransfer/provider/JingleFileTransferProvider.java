package org.jivesoftware.smackx.jingle_filetransfer.provider;

import java.io.IOException;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.hashes.element.HashElement;
import org.jivesoftware.smackx.hashes.provider.HashElementProvider;
import org.jivesoftware.smackx.jingle.provider.JingleContentDescriptionProvider;
import org.jivesoftware.smackx.jingle_filetransfer.element.JingleFileTransfer;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;

/* JADX INFO: loaded from: classes10.dex */
public class JingleFileTransferProvider extends JingleContentDescriptionProvider<JingleFileTransfer> {
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0009, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jivesoftware.smackx.jingle.provider.JingleContentDescriptionProvider, org.jivesoftware.smack.provider.Provider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.jivesoftware.smackx.jingle_filetransfer.element.JingleFileTransfer parse(org.jivesoftware.smack.xml.XmlPullParser r6, int r7, org.jivesoftware.smack.packet.XmlEnvironment r8) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException, org.jivesoftware.smack.parsing.SmackParsingException {
        /*
            Method dump skipped, instruction units count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.jingle_filetransfer.provider.JingleFileTransferProvider.parse(org.jivesoftware.smack.xml.XmlPullParser, int, org.jivesoftware.smack.packet.XmlEnvironment):org.jivesoftware.smackx.jingle_filetransfer.element.JingleFileTransfer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Range parseRangeElement(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, SmackParsingException {
        int depth = xmlPullParser.getDepth();
        Integer integerAttribute = ParserUtils.getIntegerAttribute(xmlPullParser, "offset");
        Integer integerAttribute2 = ParserUtils.getIntegerAttribute(xmlPullParser, Range.ATTR_LENGTH);
        HashElement hashElement = null;
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals(HashElement.ELEMENT)) {
                    hashElement = (HashElement) HashElementProvider.INSTANCE.parse(xmlPullParser);
                }
            } else if (i == 2 && xmlPullParser.getName().equals("range") && xmlPullParser.getDepth() == depth) {
                return new Range(integerAttribute, integerAttribute2, hashElement);
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.jingle_filetransfer.provider.JingleFileTransferProvider$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent;

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
            int[] iArr2 = new int[XmlPullParser.TagEvent.values().length];
            $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent = iArr2;
            try {
                iArr2[XmlPullParser.TagEvent.START_ELEMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[XmlPullParser.TagEvent.END_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
