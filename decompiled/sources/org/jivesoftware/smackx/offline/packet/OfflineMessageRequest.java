package org.jivesoftware.smackx.offline.packet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.iot.data.element.NodeElement;

/* JADX INFO: loaded from: classes10.dex */
public class OfflineMessageRequest extends IQ {
    public static final String ELEMENT = "offline";
    public static final String NAMESPACE = "http://jabber.org/protocol/offline";
    private boolean fetch;
    private final List<Item> items;
    private boolean purge;

    public OfflineMessageRequest() {
        super(ELEMENT, "http://jabber.org/protocol/offline");
        this.items = new ArrayList();
        this.purge = false;
        this.fetch = false;
    }

    public List<Item> getItems() {
        List<Item> listUnmodifiableList;
        synchronized (this.items) {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(this.items));
        }
        return listUnmodifiableList;
    }

    public void addItem(Item item) {
        synchronized (this.items) {
            this.items.add(item);
        }
    }

    public boolean isPurge() {
        return this.purge;
    }

    public void setPurge(boolean z) {
        this.purge = z;
    }

    public boolean isFetch() {
        return this.fetch;
    }

    public void setFetch(boolean z) {
        this.fetch = z;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        synchronized (this.items) {
            Iterator<Item> it = this.items.iterator();
            while (it.hasNext()) {
                iQChildElementXmlStringBuilder.append((CharSequence) it.next().toXML());
            }
        }
        if (this.purge) {
            iQChildElementXmlStringBuilder.append("<purge/>");
        }
        if (this.fetch) {
            iQChildElementXmlStringBuilder.append("<fetch/>");
        }
        return iQChildElementXmlStringBuilder;
    }

    public static class Item {
        private String action;
        private String jid;
        private String node;

        public Item(String str) {
            this.node = str;
        }

        public String getNode() {
            return this.node;
        }

        public String getAction() {
            return this.action;
        }

        public void setAction(String str) {
            this.action = str;
        }

        public String getJid() {
            return this.jid;
        }

        public void setJid(String str) {
            this.jid = str;
        }

        public String toXML() {
            StringBuilder sb = new StringBuilder("<item");
            if (getAction() != null) {
                sb.append(" action=\"").append(getAction()).append('\"');
            }
            if (getJid() != null) {
                sb.append(" jid=\"").append(getJid()).append('\"');
            }
            if (getNode() != null) {
                sb.append(" node=\"").append(getNode()).append('\"');
            }
            sb.append("/>");
            return sb.toString();
        }
    }

    public static class Provider extends IQProvider<OfflineMessageRequest> {
        @Override // org.jivesoftware.smack.provider.IQProvider
        public OfflineMessageRequest parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
            OfflineMessageRequest offlineMessageRequest = new OfflineMessageRequest();
            boolean z = false;
            while (!z) {
                XmlPullParser.Event next = xmlPullParser.next();
                if (next == XmlPullParser.Event.START_ELEMENT) {
                    if (xmlPullParser.getName().equals("item")) {
                        offlineMessageRequest.addItem(parseItem(xmlPullParser));
                    } else if (xmlPullParser.getName().equals("purge")) {
                        offlineMessageRequest.setPurge(true);
                    } else if (xmlPullParser.getName().equals("fetch")) {
                        offlineMessageRequest.setFetch(true);
                    }
                } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals(OfflineMessageRequest.ELEMENT)) {
                    z = true;
                }
            }
            return offlineMessageRequest;
        }

        private static Item parseItem(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            Item item = new Item(xmlPullParser.getAttributeValue("", NodeElement.ELEMENT));
            item.setAction(xmlPullParser.getAttributeValue("", "action"));
            item.setJid(xmlPullParser.getAttributeValue("", "jid"));
            boolean z = false;
            while (!z) {
                if (xmlPullParser.next() == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals("item")) {
                    z = true;
                }
            }
            return item;
        }
    }
}
