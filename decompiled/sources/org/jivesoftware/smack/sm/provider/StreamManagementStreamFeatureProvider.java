package org.jivesoftware.smack.sm.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smack.xml.XmlPullParser;

/* JADX INFO: loaded from: classes10.dex */
public class StreamManagementStreamFeatureProvider extends ExtensionElementProvider<StreamManagement.StreamManagementFeature> {
    @Override // org.jivesoftware.smack.provider.Provider
    public StreamManagement.StreamManagementFeature parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        return StreamManagement.StreamManagementFeature.INSTANCE;
    }
}
