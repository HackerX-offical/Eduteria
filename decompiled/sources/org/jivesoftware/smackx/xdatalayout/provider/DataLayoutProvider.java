package org.jivesoftware.smackx.xdatalayout.provider;

import java.io.IOException;
import java.util.List;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;

/* JADX INFO: loaded from: classes10.dex */
public class DataLayoutProvider {
    public static DataLayout parse(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        DataLayout dataLayout = new DataLayout(xmlPullParser.getAttributeValue("", "label"));
        parseLayout(dataLayout.getPageLayout(), xmlPullParser);
        return dataLayout;
    }

    private static DataLayout.Section parseSection(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        DataLayout.Section section = new DataLayout.Section(xmlPullParser.getAttributeValue("", "label"));
        parseLayout(section.getSectionLayout(), xmlPullParser);
        return section;
    }

    private static void parseLayout(List<DataLayout.DataFormLayoutElement> list, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                switch (name) {
                    case "fieldref":
                        list.add(parseFieldref(xmlPullParser));
                        break;
                    case "reportedref":
                        list.add(new DataLayout.Reportedref());
                        break;
                    case "text":
                        list.add(new DataLayout.Text(xmlPullParser.nextText()));
                        break;
                    case "section":
                        list.add(parseSection(xmlPullParser));
                        break;
                }
            } else if (i == 2 && xmlPullParser.getDepth() == depth) {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.xdatalayout.provider.DataLayoutProvider$1, reason: invalid class name */
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

    private static DataLayout.Fieldref parseFieldref(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        DataLayout.Fieldref fieldref = new DataLayout.Fieldref(xmlPullParser.getAttributeValue("", "var"));
        while (true) {
            if (xmlPullParser.next() == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == depth) {
                return fieldref;
            }
        }
    }
}
