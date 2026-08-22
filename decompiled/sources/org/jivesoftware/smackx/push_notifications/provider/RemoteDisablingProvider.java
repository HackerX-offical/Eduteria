package org.jivesoftware.smackx.push_notifications.provider;

import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smackx.push_notifications.element.PushNotificationsElements;

/* JADX INFO: loaded from: classes10.dex */
public class RemoteDisablingProvider extends ExtensionElementProvider<PushNotificationsElements.RemoteDisablingExtension> {
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004a, code lost:
    
        throw new java.io.IOException("Invalid affiliation: " + r2);
     */
    @Override // org.jivesoftware.smack.provider.Provider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.jivesoftware.smackx.push_notifications.element.PushNotificationsElements.RemoteDisablingExtension parse(org.jivesoftware.smack.xml.XmlPullParser r5, int r6, org.jivesoftware.smack.packet.XmlEnvironment r7) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException {
        /*
            r4 = this;
            java.lang.String r7 = "node"
            java.lang.String r0 = ""
            java.lang.String r7 = r5.getAttributeValue(r0, r7)
            r1 = 0
        L9:
            org.jivesoftware.smack.xml.XmlPullParser$Event r2 = r5.next()
            org.jivesoftware.smack.xml.XmlPullParser$Event r3 = org.jivesoftware.smack.xml.XmlPullParser.Event.START_ELEMENT
            if (r2 != r3) goto L4b
            java.lang.String r2 = r5.getName()
            java.lang.String r3 = "affiliation"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L9
            java.lang.String r1 = "jid"
            java.lang.String r1 = r5.getAttributeValue(r0, r1)
            org.jxmpp.jid.Jid r1 = org.jxmpp.jid.impl.JidCreate.from(r1)
            java.lang.String r2 = r5.getAttributeValue(r0, r3)
            if (r2 == 0) goto L36
            java.lang.String r3 = "none"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L36
            goto L9
        L36:
            java.io.IOException r5 = new java.io.IOException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Invalid affiliation: "
            r6.<init>(r7)
            java.lang.StringBuilder r6 = r6.append(r2)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L4b:
            org.jivesoftware.smack.xml.XmlPullParser$Event r3 = org.jivesoftware.smack.xml.XmlPullParser.Event.END_ELEMENT
            if (r2 != r3) goto L9
            int r2 = r5.getDepth()
            if (r2 != r6) goto L9
            org.jivesoftware.smackx.push_notifications.element.PushNotificationsElements$RemoteDisablingExtension r5 = new org.jivesoftware.smackx.push_notifications.element.PushNotificationsElements$RemoteDisablingExtension
            r5.<init>(r7, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.push_notifications.provider.RemoteDisablingProvider.parse(org.jivesoftware.smack.xml.XmlPullParser, int, org.jivesoftware.smack.packet.XmlEnvironment):org.jivesoftware.smackx.push_notifications.element.PushNotificationsElements$RemoteDisablingExtension");
    }
}
