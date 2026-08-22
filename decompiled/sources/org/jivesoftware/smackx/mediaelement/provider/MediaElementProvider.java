package org.jivesoftware.smackx.mediaelement.provider;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.io.IOException;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.datatypes.UInt16;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.mediaelement.element.MediaElement;
import org.jivesoftware.smackx.xdata.provider.FormFieldChildElementProvider;

/* JADX INFO: loaded from: classes10.dex */
public class MediaElementProvider extends FormFieldChildElementProvider<MediaElement> {
    private static final Logger LOGGER = Logger.getLogger(MediaElementProvider.class.getName());

    @Override // org.jivesoftware.smackx.xdata.provider.FormFieldChildElementProvider
    public QName getQName() {
        return MediaElement.QNAME;
    }

    @Override // org.jivesoftware.smack.provider.Provider
    public MediaElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException.SmackUriSyntaxParsingException {
        UInt16 uInt16Attribute = ParserUtils.getUInt16Attribute(xmlPullParser, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        UInt16 uInt16Attribute2 = ParserUtils.getUInt16Attribute(xmlPullParser, ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        MediaElement.Builder builder = MediaElement.builder();
        if (uInt16Attribute != null && uInt16Attribute2 != null) {
            builder.setHeightAndWidth(uInt16Attribute, uInt16Attribute2);
        } else if (uInt16Attribute != null || uInt16Attribute2 != null) {
            LOGGER.warning("Only one of height and width set while parsing media element");
        }
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[xmlPullParser.nextTag().ordinal()];
            if (i2 == 1) {
                if (xmlPullParser.getQName().equals(MediaElement.Uri.QNAME)) {
                    builder.addUri(parseUri(xmlPullParser));
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                return builder.build();
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.mediaelement.provider.MediaElementProvider$1, reason: invalid class name */
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

    private static MediaElement.Uri parseUri(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, SmackParsingException.SmackUriSyntaxParsingException {
        return new MediaElement.Uri(ParserUtils.getUriFromNextText(xmlPullParser), xmlPullParser.getAttributeValue("type"));
    }
}
