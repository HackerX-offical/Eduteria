package org.jivesoftware.smackx.iqregister.provider;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.iqregister.packet.Registration;

/* JADX INFO: loaded from: classes10.dex */
public class RegistrationProvider extends IQProvider<Registration> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public Registration parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        String text;
        HashMap map = new HashMap();
        LinkedList linkedList = new LinkedList();
        String str = null;
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getNamespace().equals(Registration.NAMESPACE)) {
                    String name = xmlPullParser.getName();
                    if (xmlPullParser.next() != XmlPullParser.Event.TEXT_CHARACTERS) {
                        text = "";
                    } else {
                        text = xmlPullParser.getText();
                    }
                    if (name.equals("instructions")) {
                        str = text;
                    } else {
                        map.put(name, text);
                    }
                } else {
                    PacketParserUtils.addExtensionElement(linkedList, xmlPullParser, xmlEnvironment);
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals("query")) {
                Registration registration = new Registration(str, map);
                registration.addExtensions(linkedList);
                return registration;
            }
        }
    }
}
