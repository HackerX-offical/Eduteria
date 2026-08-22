package org.jivesoftware.smackx.blocking.provider;

import java.io.IOException;
import java.util.ArrayList;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: loaded from: classes10.dex */
public class BlockContactsIQProvider extends IQProvider<BlockContactsIQ> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public BlockContactsIQ parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                if (xmlPullParser.getName().equals("item")) {
                    arrayList.add(ParserUtils.getJidAttribute(xmlPullParser));
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                return new BlockContactsIQ(arrayList);
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.blocking.provider.BlockContactsIQProvider$1, reason: invalid class name */
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
