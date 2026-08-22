package org.jivesoftware.smackx.blocking.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.blocking.element.BlockedErrorExtension;

/* JADX INFO: loaded from: classes10.dex */
public class BlockedErrorExtensionProvider extends ExtensionElementProvider<BlockedErrorExtension> {
    @Override // org.jivesoftware.smack.provider.Provider
    public BlockedErrorExtension parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        return new BlockedErrorExtension();
    }
}
