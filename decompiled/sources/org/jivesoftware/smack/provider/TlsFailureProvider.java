package org.jivesoftware.smack.provider;

import org.jivesoftware.smack.packet.TlsProceed;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.xml.XmlPullParser;

/* JADX INFO: loaded from: classes10.dex */
public final class TlsFailureProvider extends NonzaProvider<TlsProceed> {
    public static final TlsFailureProvider INSTANCE = new TlsFailureProvider();

    private TlsFailureProvider() {
    }

    @Override // org.jivesoftware.smack.provider.Provider
    public TlsProceed parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        return TlsProceed.INSTANCE;
    }
}
