package org.jivesoftware.smack.roster.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.roster.packet.RosterVer;
import org.jivesoftware.smack.xml.XmlPullParser;

/* JADX INFO: loaded from: classes10.dex */
public class RosterVerStreamFeatureProvider extends ExtensionElementProvider<RosterVer> {
    @Override // org.jivesoftware.smack.provider.Provider
    public RosterVer parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        return RosterVer.INSTANCE;
    }
}
