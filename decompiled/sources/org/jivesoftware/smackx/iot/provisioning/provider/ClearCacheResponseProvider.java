package org.jivesoftware.smackx.iot.provisioning.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.provisioning.element.ClearCacheResponse;

/* JADX INFO: loaded from: classes10.dex */
public class ClearCacheResponseProvider extends IQProvider<ClearCacheResponse> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public ClearCacheResponse parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        return new ClearCacheResponse();
    }
}
