package org.jivesoftware.smack.roster.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.roster.packet.SubscriptionPreApproval;
import org.jivesoftware.smack.xml.XmlPullParser;

/* JADX INFO: loaded from: classes10.dex */
public class SubscriptionPreApprovalStreamFeatureProvider extends ExtensionElementProvider<SubscriptionPreApproval> {
    @Override // org.jivesoftware.smack.provider.Provider
    public SubscriptionPreApproval parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        return SubscriptionPreApproval.INSTANCE;
    }
}
