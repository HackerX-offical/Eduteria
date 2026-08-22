package org.jivesoftware.smack.xml;

import java.io.IOException;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes10.dex */
public interface XmlPullParser {

    public enum Event {
        START_DOCUMENT,
        END_DOCUMENT,
        START_ELEMENT,
        END_ELEMENT,
        TEXT_CHARACTERS,
        PROCESSING_INSTRUCTION,
        COMMENT,
        IGNORABLE_WHITESPACE,
        ENTITY_REFERENCE,
        OTHER
    }

    public enum TagEvent {
        START_ELEMENT,
        END_ELEMENT
    }

    int getAttributeCount();

    String getAttributeName(int i);

    String getAttributeNamespace(int i);

    String getAttributePrefix(int i);

    QName getAttributeQName(int i);

    String getAttributeType(int i);

    String getAttributeValue(int i);

    String getAttributeValue(String str, String str2);

    int getColumnNumber();

    int getDepth();

    Event getEventType() throws XmlPullParserException;

    String getInputEncoding();

    int getLineNumber();

    String getName();

    String getNamespace();

    String getNamespace(String str);

    int getNamespaceCount() throws XmlPullParserException;

    String getNamespacePrefix(int i) throws XmlPullParserException;

    String getNamespaceUri(int i) throws XmlPullParserException;

    String getPositionDescription();

    String getPrefix();

    Object getProperty(String str);

    QName getQName();

    String getText();

    boolean isWhiteSpace() throws XmlPullParserException;

    Event next() throws XmlPullParserException, IOException;

    TagEvent nextTag() throws XmlPullParserException, IOException;

    String nextText() throws XmlPullParserException, IOException;

    boolean supportsRoundtrip();

    default String getDefaultNamespace() {
        return getNamespace(null);
    }

    default String getAttributeValue(String str) {
        return getAttributeValue(null, str);
    }
}
