package org.jivesoftware.smackx.search;

import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.SimpleIQ;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.DomainBareJid;

/* JADX INFO: loaded from: classes10.dex */
public class UserSearch extends SimpleIQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "jabber:iq:search";

    public UserSearch() {
        super("query", "jabber:iq:search");
    }

    public DataForm getSearchForm(XMPPConnection xMPPConnection, DomainBareJid domainBareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        UserSearch userSearch = new UserSearch();
        userSearch.setType(IQ.Type.get);
        userSearch.setTo(domainBareJid);
        return DataForm.from((IQ) xMPPConnection.createStanzaCollectorAndSend(userSearch).nextResultOrThrow(), "jabber:iq:search");
    }

    public ReportedData sendSearchForm(XMPPConnection xMPPConnection, DataForm dataForm, DomainBareJid domainBareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        UserSearch userSearch = new UserSearch();
        userSearch.setType(IQ.Type.set);
        userSearch.setTo(domainBareJid);
        userSearch.addExtension(dataForm);
        return ReportedData.getReportedDataFrom((IQ) xMPPConnection.createStanzaCollectorAndSend(userSearch).nextResultOrThrow());
    }

    public ReportedData sendSimpleSearchForm(XMPPConnection xMPPConnection, DataForm dataForm, DomainBareJid domainBareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        SimpleUserSearch simpleUserSearch = new SimpleUserSearch();
        simpleUserSearch.setForm(dataForm);
        simpleUserSearch.setType(IQ.Type.set);
        simpleUserSearch.setTo(domainBareJid);
        return ((SimpleUserSearch) xMPPConnection.createStanzaCollectorAndSend(simpleUserSearch).nextResultOrThrow()).getReportedData();
    }

    public static class Provider extends IQProvider<IQ> {
        @Override // org.jivesoftware.smack.provider.IQProvider
        public IQ parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
            SimpleUserSearch simpleUserSearch = new SimpleUserSearch();
            UserSearch userSearch = null;
            boolean z = false;
            while (!z) {
                XmlPullParser.Event next = xmlPullParser.next();
                if (next == XmlPullParser.Event.START_ELEMENT && xmlPullParser.getName().equals("item")) {
                    simpleUserSearch.parseItems(xmlPullParser);
                    return simpleUserSearch;
                }
                if (next == XmlPullParser.Event.START_ELEMENT && xmlPullParser.getNamespace().equals("jabber:x:data")) {
                    userSearch = new UserSearch();
                    PacketParserUtils.addExtensionElement(userSearch, xmlPullParser, xmlEnvironment);
                } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals("query")) {
                    z = true;
                }
            }
            return userSearch != null ? userSearch : simpleUserSearch;
        }
    }
}
