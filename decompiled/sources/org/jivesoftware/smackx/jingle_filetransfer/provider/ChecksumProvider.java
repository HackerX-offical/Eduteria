package org.jivesoftware.smackx.jingle_filetransfer.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.hashes.element.HashElement;
import org.jivesoftware.smackx.hashes.provider.HashElementProvider;
import org.jivesoftware.smackx.jingle.element.JingleContent;
import org.jivesoftware.smackx.jingle_filetransfer.element.Checksum;
import org.jivesoftware.smackx.jingle_filetransfer.element.JingleFileTransferChild;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;

/* JADX INFO: loaded from: classes10.dex */
public class ChecksumProvider extends ExtensionElementProvider<Checksum> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jivesoftware.smack.provider.Provider
    public Checksum parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        Range range;
        String attributeValue = xmlPullParser.getAttributeValue(null, "creator");
        JingleContent.Creator creatorValueOf = attributeValue != null ? JingleContent.Creator.valueOf(attributeValue) : null;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "name");
        JingleFileTransferChild.Builder builder = JingleFileTransferChild.getBuilder();
        HashElement hashElement = null;
        Range range2 = null;
        boolean z = true;
        while (z) {
            XmlPullParser.TagEvent tagEventNextTag = xmlPullParser.nextTag();
            String text = xmlPullParser.getText();
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[tagEventNextTag.ordinal()];
            if (i2 == 1) {
                text.hashCode();
                if (text.equals(HashElement.ELEMENT)) {
                    hashElement = (HashElement) new HashElementProvider().parse(xmlPullParser);
                } else if (text.equals("range")) {
                    String attributeValue3 = xmlPullParser.getAttributeValue(null, "offset");
                    String attributeValue4 = xmlPullParser.getAttributeValue(null, Range.ATTR_LENGTH);
                    range = new Range(attributeValue3 != null ? Integer.parseInt(attributeValue3) : 0, attributeValue4 == null ? -1 : Integer.parseInt(attributeValue4));
                    range2 = range;
                }
            } else if (i2 == 2) {
                text.hashCode();
                if (text.equals("file")) {
                    if (hashElement != null) {
                        builder.setHash(hashElement);
                    }
                    if (range2 != null) {
                        builder.setRange(range2);
                    }
                    z = false;
                } else if (text.equals("range") && hashElement != null && range2 != null) {
                    range = new Range(Integer.valueOf(range2.getOffset()), Integer.valueOf(range2.getLength()), hashElement);
                    hashElement = null;
                    range2 = range;
                }
            }
        }
        return new Checksum(creatorValueOf, attributeValue2, builder.build());
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.jingle_filetransfer.provider.ChecksumProvider$1, reason: invalid class name */
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
