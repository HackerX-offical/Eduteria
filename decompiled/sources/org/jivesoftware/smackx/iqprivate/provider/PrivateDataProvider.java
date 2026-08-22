package org.jivesoftware.smackx.iqprivate.provider;

import java.io.IOException;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.iqprivate.packet.PrivateData;

/* JADX INFO: loaded from: classes10.dex */
public interface PrivateDataProvider {
    PrivateData parsePrivateData(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException;
}
