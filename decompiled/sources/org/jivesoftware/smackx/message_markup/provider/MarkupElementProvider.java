package org.jivesoftware.smackx.message_markup.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.message_markup.element.ListElement;
import org.jivesoftware.smackx.message_markup.element.MarkupElement;
import org.jivesoftware.smackx.message_markup.element.SpanElement;

/* JADX INFO: loaded from: classes10.dex */
public class MarkupElementProvider extends ExtensionElementProvider<MarkupElement> {
    @Override // org.jivesoftware.smack.provider.Provider
    public MarkupElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        MarkupElement.Builder builder = MarkupElement.getBuilder();
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        int integerAttributeOrThrow = -1;
        int integerAttributeOrThrow2 = -1;
        int integerAttributeOrThrow3 = -1;
        int integerAttributeOrThrow4 = -1;
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            int i3 = 0;
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                switch (name) {
                    case "bquote":
                        builder.setBlockQuote(ParserUtils.getIntegerAttributeOrThrow(xmlPullParser, "start", "Message Markup BlockQuoteElement MUST contain a 'start' attribute."), ParserUtils.getIntegerAttributeOrThrow(xmlPullParser, "end", "Message Markup BlockQuoteElement MUST contain a 'end' attribute."));
                        break;
                    case "li":
                        arrayList.add(new ListElement.ListEntryElement(ParserUtils.getIntegerAttributeOrThrow(xmlPullParser, "start", "Message Markup ListElement 'li' MUST contain a 'start' attribute.")));
                        break;
                    case "code":
                        hashSet.add(SpanElement.SpanStyle.code);
                        break;
                    case "list":
                        arrayList = new ArrayList();
                        integerAttributeOrThrow3 = ParserUtils.getIntegerAttributeOrThrow(xmlPullParser, "start", "Message Markup ListElement MUST contain a 'start' attribute.");
                        integerAttributeOrThrow4 = ParserUtils.getIntegerAttributeOrThrow(xmlPullParser, "end", "Message Markup ListElement MUST contain a 'end' attribute.");
                        break;
                    case "span":
                        hashSet = new HashSet();
                        integerAttributeOrThrow = ParserUtils.getIntegerAttributeOrThrow(xmlPullParser, "start", "Message Markup SpanElement MUST contain a 'start' attribute.");
                        integerAttributeOrThrow2 = ParserUtils.getIntegerAttributeOrThrow(xmlPullParser, "end", "Message Markup SpanElement MUST contain a 'end' attribute.");
                        break;
                    case "bcode":
                        builder.setCodeBlock(ParserUtils.getIntegerAttributeOrThrow(xmlPullParser, "start", "Message Markup CodeBlockElement MUST contain a 'start' attribute."), ParserUtils.getIntegerAttributeOrThrow(xmlPullParser, "end", "Message Markup CodeBlockElement MUST contain a 'end' attribute."));
                        break;
                    case "emphasis":
                        hashSet.add(SpanElement.SpanStyle.emphasis);
                        break;
                    case "deleted":
                        hashSet.add(SpanElement.SpanStyle.deleted);
                        break;
                }
            } else if (i2 == 2) {
                if (xmlPullParser.getDepth() == i) {
                    return builder.build();
                }
                String name2 = xmlPullParser.getName();
                name2.hashCode();
                if (name2.equals("list")) {
                    MarkupElement.Builder.ListBuilder listBuilderBeginList = builder.beginList();
                    if (arrayList.size() > 0 && ((ListElement.ListEntryElement) arrayList.get(0)).getStart() != integerAttributeOrThrow3) {
                        throw new IOException("Error while parsing incoming MessageMarkup ListElement: 'start' attribute of first 'li' element must equal 'start' attribute of list.");
                    }
                    while (i3 < arrayList.size()) {
                        listBuilderBeginList.addEntry(((ListElement.ListEntryElement) arrayList.get(i3)).getStart(), i3 < arrayList.size() - 1 ? ((ListElement.ListEntryElement) arrayList.get(i3 + 1)).getStart() : integerAttributeOrThrow4);
                        i3++;
                    }
                    listBuilderBeginList.endList();
                } else if (name2.equals("span")) {
                    builder.addSpan(integerAttributeOrThrow, integerAttributeOrThrow2, hashSet);
                    integerAttributeOrThrow = -1;
                    integerAttributeOrThrow2 = -1;
                }
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.message_markup.provider.MarkupElementProvider$1, reason: invalid class name */
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
