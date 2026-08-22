package org.xmlpull.v1.wrapper;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes9.dex */
public interface XmlSerializerWrapper extends XmlSerializer {
    public static final String NO_NAMESPACE = "";
    public static final String XSD_NS = "http://www.w3.org/2001/XMLSchema";
    public static final String XSI_NS = "http://www.w3.org/2001/XMLSchema-instance";

    XmlSerializerWrapper attribute(String str, String str2) throws IllegalStateException, IOException, IllegalArgumentException;

    XmlSerializerWrapper element(String str, String str2) throws XmlPullParserException, IOException;

    XmlSerializerWrapper element(String str, String str2, String str3) throws XmlPullParserException, IOException;

    XmlSerializerWrapper endTag(String str) throws IllegalStateException, IOException, IllegalArgumentException;

    String escapeAttributeValue(String str) throws IllegalArgumentException;

    String escapeText(String str) throws IllegalArgumentException;

    void event(XmlPullParser xmlPullParser) throws XmlPullParserException, IllegalStateException, IOException, IllegalArgumentException;

    void fragment(String str) throws XmlPullParserException, IllegalStateException, IOException, IllegalArgumentException;

    String getCurrentNamespaceForElements();

    String setCurrentNamespaceForElements(String str);

    XmlSerializerWrapper startTag(String str) throws IllegalStateException, IOException, IllegalArgumentException;
}
