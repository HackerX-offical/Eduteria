package org.jivesoftware.smack.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Provider<E extends Element> extends AbstractProvider<E> {
    public abstract E parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException;

    public final E parse(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, SmackParsingException {
        return (E) parse(xmlPullParser, null);
    }

    public final E parse(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        int depth = xmlPullParser.getDepth();
        E e2 = (E) parse(xmlPullParser, depth, XmlEnvironment.from(xmlPullParser, xmlEnvironment));
        ParserUtils.forwardToEndTagOfDepth(xmlPullParser, depth);
        return e2;
    }
}
