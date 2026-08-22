package org.jivesoftware.smackx.iot.provisioning.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.provisioning.element.ClearCache;

/* JADX INFO: loaded from: classes10.dex */
public class ClearCacheProvider extends IQProvider<ClearCache> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public ClearCache parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        return new ClearCache();
    }
}
