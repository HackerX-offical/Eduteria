package org.jivesoftware.smackx.usertune.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.usertune.element.UserTuneElement;

/* JADX INFO: loaded from: classes10.dex */
public class UserTuneProvider extends ExtensionElementProvider<UserTuneElement> {
    public static final UserTuneProvider INSTANCE = new UserTuneProvider();

    @Override // org.jivesoftware.smack.provider.Provider
    public UserTuneElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        UserTuneElement.Builder builder = UserTuneElement.getBuilder();
        XmlPullParser.TagEvent tagEventNextTag = xmlPullParser.nextTag();
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[tagEventNextTag.ordinal()];
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                if ("http://jabber.org/protocol/tune".equals(xmlPullParser.getNamespace())) {
                    while (tagEventNextTag == XmlPullParser.TagEvent.START_ELEMENT) {
                        name.hashCode();
                        switch (name) {
                            case "artist":
                                builder.setArtist(xmlPullParser.nextText());
                                break;
                            case "length":
                                builder.setLength(ParserUtils.getIntegerFromNextText(xmlPullParser));
                                break;
                            case "rating":
                                builder.setRating(ParserUtils.getIntegerFromNextText(xmlPullParser));
                                break;
                            case "source":
                                builder.setSource(xmlPullParser.nextText());
                                break;
                            case "uri":
                                builder.setUri(ParserUtils.getUriFromNextText(xmlPullParser));
                                break;
                            case "title":
                                builder.setTitle(xmlPullParser.nextText());
                                break;
                            case "track":
                                builder.setTrack(xmlPullParser.nextText());
                                break;
                        }
                        tagEventNextTag = xmlPullParser.nextTag();
                        name = xmlPullParser.getName();
                    }
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                return builder.build();
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.usertune.provider.UserTuneProvider$1, reason: invalid class name */
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
