package org.jivesoftware.smackx.iqregister.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iqregister.packet.Registration;

/* JADX INFO: loaded from: classes10.dex */
public class RegistrationStreamFeatureProvider extends ExtensionElementProvider<Registration.Feature> {
    @Override // org.jivesoftware.smack.provider.Provider
    public Registration.Feature parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        return Registration.Feature.INSTANCE;
    }
}
