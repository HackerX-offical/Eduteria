package org.jivesoftware.smack.parsing;

import java.io.IOException;
import java.util.LinkedHashMap;
import org.jivesoftware.smack.packet.StandardExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
public class StandardExtensionElementProvider extends ExtensionElementProvider<StandardExtensionElement> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static StandardExtensionElementProvider INSTANCE = new StandardExtensionElementProvider();

    @Override // org.jivesoftware.smack.provider.Provider
    public StandardExtensionElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        StandardExtensionElement.Builder builder = StandardExtensionElement.builder(xmlPullParser.getName(), xmlPullParser.getNamespace());
        int namespaceCount = xmlPullParser.getNamespaceCount();
        int attributeCount = xmlPullParser.getAttributeCount();
        LinkedHashMap linkedHashMap = new LinkedHashMap(namespaceCount + attributeCount);
        for (int i2 = 0; i2 < namespaceCount; i2++) {
            String namespacePrefix = xmlPullParser.getNamespacePrefix(i2);
            if (namespacePrefix != null) {
                linkedHashMap.put("xmlns:" + namespacePrefix, xmlPullParser.getNamespaceUri(i2));
            }
        }
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String attributePrefix = xmlPullParser.getAttributePrefix(i3);
            String attributeName = xmlPullParser.getAttributeName(i3);
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            if (!StringUtils.isNullOrEmpty(attributePrefix)) {
                attributeName = attributePrefix + ':' + attributeName;
            }
            linkedHashMap.put(attributeName, attributeValue);
        }
        builder.addAttributes(linkedHashMap);
        while (true) {
            int i4 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i4 == 1) {
                builder.addElement(parse(xmlPullParser, xmlPullParser.getDepth(), xmlEnvironment));
            } else if (i4 == 2) {
                builder.setText(xmlPullParser.getText());
            } else if (i4 == 3 && i == xmlPullParser.getDepth()) {
                ParserUtils.assertAtEndTag(xmlPullParser);
                return builder.build();
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.parsing.StandardExtensionElementProvider$1, reason: invalid class name */
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
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[XmlPullParser.Event.TEXT_CHARACTERS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[XmlPullParser.Event.END_ELEMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
