package org.jivesoftware.smackx.bookmarks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.iqprivate.packet.PrivateData;
import org.jivesoftware.smackx.iqprivate.provider.PrivateDataProvider;
import org.jxmpp.jid.parts.Resourcepart;

/* JADX INFO: loaded from: classes10.dex */
public class Bookmarks implements PrivateData {
    public static final String ELEMENT = "storage";
    public static final String NAMESPACE = "storage:bookmarks";
    private final List<BookmarkedURL> bookmarkedURLS = new ArrayList();
    private final List<BookmarkedConference> bookmarkedConferences = new ArrayList();

    public void addBookmarkedURL(BookmarkedURL bookmarkedURL) {
        this.bookmarkedURLS.add(bookmarkedURL);
    }

    public void removeBookmarkedURL(BookmarkedURL bookmarkedURL) {
        this.bookmarkedURLS.remove(bookmarkedURL);
    }

    public void clearBookmarkedURLS() {
        this.bookmarkedURLS.clear();
    }

    public void addBookmarkedConference(BookmarkedConference bookmarkedConference) {
        this.bookmarkedConferences.add(bookmarkedConference);
    }

    public void removeBookmarkedConference(BookmarkedConference bookmarkedConference) {
        this.bookmarkedConferences.remove(bookmarkedConference);
    }

    public void clearBookmarkedConferences() {
        this.bookmarkedConferences.clear();
    }

    public List<BookmarkedURL> getBookmarkedURLS() {
        return this.bookmarkedURLS;
    }

    public List<BookmarkedConference> getBookmarkedConferences() {
        return this.bookmarkedConferences;
    }

    @Override // org.jivesoftware.smackx.iqprivate.packet.PrivateData
    public String getElementName() {
        return "storage";
    }

    @Override // org.jivesoftware.smackx.iqprivate.packet.PrivateData
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smackx.iqprivate.packet.PrivateData
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        xmlStringBuilder.halfOpenElement("storage").xmlnsAttribute(NAMESPACE).rightAngleBracket();
        for (BookmarkedURL bookmarkedURL : getBookmarkedURLS()) {
            if (!bookmarkedURL.isShared()) {
                xmlStringBuilder.halfOpenElement("url").attribute("name", bookmarkedURL.getName()).attribute("url", bookmarkedURL.getURL());
                xmlStringBuilder.condAttribute(bookmarkedURL.isRss(), "rss", "true");
                xmlStringBuilder.closeEmptyElement();
            }
        }
        for (BookmarkedConference bookmarkedConference : getBookmarkedConferences()) {
            if (!bookmarkedConference.isShared()) {
                xmlStringBuilder.halfOpenElement("conference");
                xmlStringBuilder.attribute("name", bookmarkedConference.getName());
                xmlStringBuilder.attribute("autojoin", Boolean.toString(bookmarkedConference.isAutoJoin()));
                xmlStringBuilder.attribute("jid", bookmarkedConference.getJid());
                xmlStringBuilder.rightAngleBracket();
                xmlStringBuilder.optElement("nick", (CharSequence) bookmarkedConference.getNickname());
                xmlStringBuilder.optElement("password", bookmarkedConference.getPassword());
                xmlStringBuilder.closeElement("conference");
            }
        }
        xmlStringBuilder.closeElement("storage");
        return xmlStringBuilder;
    }

    public static class Provider implements PrivateDataProvider {
        @Override // org.jivesoftware.smackx.iqprivate.provider.PrivateDataProvider
        public PrivateData parsePrivateData(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            Bookmarks bookmarks = new Bookmarks();
            boolean z = false;
            while (!z) {
                XmlPullParser.Event next = xmlPullParser.next();
                if (next == XmlPullParser.Event.START_ELEMENT && "url".equals(xmlPullParser.getName())) {
                    BookmarkedURL uRLStorage = Bookmarks.getURLStorage(xmlPullParser);
                    if (uRLStorage != null) {
                        bookmarks.addBookmarkedURL(uRLStorage);
                    }
                } else if (next == XmlPullParser.Event.START_ELEMENT && "conference".equals(xmlPullParser.getName())) {
                    bookmarks.addBookmarkedConference(Bookmarks.getConferenceStorage(xmlPullParser));
                } else if (next == XmlPullParser.Event.END_ELEMENT && "storage".equals(xmlPullParser.getName())) {
                    z = true;
                }
            }
            return bookmarks;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BookmarkedURL getURLStorage(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue("", "name");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "url");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "rss");
        boolean z = false;
        BookmarkedURL bookmarkedURL = new BookmarkedURL(attributeValue2, attributeValue, attributeValue3 != null && "true".equals(attributeValue3));
        while (!z) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT && "shared_bookmark".equals(xmlPullParser.getName())) {
                bookmarkedURL.setShared(true);
            } else if (next == XmlPullParser.Event.END_ELEMENT && "url".equals(xmlPullParser.getName())) {
                z = true;
            }
        }
        return bookmarkedURL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BookmarkedConference getConferenceStorage(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue("", "name");
        boolean z = false;
        boolean booleanAttribute = ParserUtils.getBooleanAttribute(xmlPullParser, "autojoin", false);
        BookmarkedConference bookmarkedConference = new BookmarkedConference(ParserUtils.getBareJidAttribute(xmlPullParser));
        bookmarkedConference.setName(attributeValue);
        bookmarkedConference.setAutoJoin(booleanAttribute);
        while (!z) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT && "nick".equals(xmlPullParser.getName())) {
                bookmarkedConference.setNickname(Resourcepart.from(xmlPullParser.nextText()));
            } else if (next == XmlPullParser.Event.START_ELEMENT && "password".equals(xmlPullParser.getName())) {
                bookmarkedConference.setPassword(xmlPullParser.nextText());
            } else if (next == XmlPullParser.Event.START_ELEMENT && "shared_bookmark".equals(xmlPullParser.getName())) {
                bookmarkedConference.setShared(true);
            } else if (next == XmlPullParser.Event.END_ELEMENT && "conference".equals(xmlPullParser.getName())) {
                z = true;
            }
        }
        return bookmarkedConference;
    }
}
