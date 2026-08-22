package org.jivesoftware.smackx.sharedgroups.packet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
public class SharedGroupsInfo extends IQ {
    public static final String ELEMENT = "sharedgroup";
    public static final String NAMESPACE = "http://www.jivesoftware.org/protocol/sharedgroup";
    private final List<String> groups;

    public SharedGroupsInfo() {
        super(ELEMENT, NAMESPACE);
        this.groups = new ArrayList();
    }

    public List<String> getGroups() {
        return this.groups;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        Iterator<String> it = this.groups.iterator();
        while (it.hasNext()) {
            iQChildElementXmlStringBuilder.element("group", it.next());
        }
        return iQChildElementXmlStringBuilder;
    }

    public static class Provider extends IQProvider<SharedGroupsInfo> {
        @Override // org.jivesoftware.smack.provider.IQProvider
        public SharedGroupsInfo parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
            SharedGroupsInfo sharedGroupsInfo = new SharedGroupsInfo();
            boolean z = false;
            while (!z) {
                XmlPullParser.Event next = xmlPullParser.next();
                if (next == XmlPullParser.Event.START_ELEMENT && xmlPullParser.getName().equals("group")) {
                    sharedGroupsInfo.getGroups().add(xmlPullParser.nextText());
                } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals(SharedGroupsInfo.ELEMENT)) {
                    z = true;
                }
            }
            return sharedGroupsInfo;
        }
    }
}
