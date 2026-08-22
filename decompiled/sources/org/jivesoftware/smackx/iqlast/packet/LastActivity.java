package org.jivesoftware.smackx.iqlast.packet;

import java.io.IOException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class LastActivity extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "jabber:iq:last";
    public long lastActivity;
    public String message;

    public LastActivity() {
        super("query", NAMESPACE);
        this.lastActivity = -1L;
        setType(IQ.Type.get);
    }

    public LastActivity(Jid jid) {
        this();
        setTo(jid);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.optLongAttribute("seconds", Long.valueOf(this.lastActivity));
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }

    public void setLastActivity(long j) {
        this.lastActivity = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessage(String str) {
        this.message = str;
    }

    public long getIdleTime() {
        return this.lastActivity;
    }

    public String getStatusMessage() {
        return this.message;
    }

    public static class Provider extends IQProvider<LastActivity> {
        @Override // org.jivesoftware.smack.provider.IQProvider
        public LastActivity parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
            LastActivity lastActivity = new LastActivity();
            String attributeValue = xmlPullParser.getAttributeValue("", "seconds");
            if (attributeValue != null) {
                try {
                    lastActivity.setLastActivity(Long.parseLong(attributeValue));
                } catch (NumberFormatException e2) {
                    throw new IOException("Could not parse last activity number", e2);
                }
            }
            lastActivity.setMessage(xmlPullParser.nextText());
            return lastActivity;
        }
    }
}
