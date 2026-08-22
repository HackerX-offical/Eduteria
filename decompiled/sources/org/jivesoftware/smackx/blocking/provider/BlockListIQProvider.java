package org.jivesoftware.smackx.blocking.provider;

import java.io.IOException;
import java.util.ArrayList;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.blocking.element.BlockListIQ;

/* JADX INFO: loaded from: classes10.dex */
public class BlockListIQProvider extends IQProvider<BlockListIQ> {

    /* JADX INFO: renamed from: org.jivesoftware.smackx.blocking.provider.BlockListIQProvider$1, reason: invalid class name */
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

    @Override // org.jivesoftware.smack.provider.IQProvider
    public BlockListIQ parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        ArrayList arrayList = null;
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                if (xmlPullParser.getName().equals("item")) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(ParserUtils.getJidAttribute(xmlPullParser));
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                BlockListIQ blockListIQ = new BlockListIQ(arrayList);
                blockListIQ.setType(IQ.Type.result);
                return blockListIQ;
            }
        }
    }
}
