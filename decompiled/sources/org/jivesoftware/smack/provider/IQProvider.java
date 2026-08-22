package org.jivesoftware.smack.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IqData;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
public abstract class IQProvider<I extends IQ> extends AbstractC0760IqProvider<I> {
    public abstract I parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException;

    public final I parse(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, SmackParsingException {
        return (I) parse(xmlPullParser, (XmlEnvironment) null);
    }

    public final I parse(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        int depth = xmlPullParser.getDepth();
        I i = (I) parse(xmlPullParser, depth, XmlEnvironment.from(xmlPullParser, xmlEnvironment));
        ParserUtils.forwardToEndTagOfDepth(xmlPullParser, depth);
        return i;
    }

    @Override // org.jivesoftware.smack.provider.AbstractC0760IqProvider
    public final I parse(XmlPullParser xmlPullParser, int i, IqData iqData, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        return (I) parse(xmlPullParser, i, xmlEnvironment);
    }
}
