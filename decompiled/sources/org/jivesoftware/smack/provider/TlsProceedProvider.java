package org.jivesoftware.smack.provider;

import org.jivesoftware.smack.packet.TlsFailure;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.xml.XmlPullParser;

/* JADX INFO: loaded from: classes10.dex */
public final class TlsProceedProvider extends NonzaProvider<TlsFailure> {
    public static final TlsProceedProvider INSTANCE = new TlsProceedProvider();

    private TlsProceedProvider() {
    }

    @Override // org.jivesoftware.smack.provider.Provider
    public TlsFailure parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        return TlsFailure.INSTANCE;
    }
}
