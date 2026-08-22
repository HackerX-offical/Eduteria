package org.jivesoftware.smackx.hints.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.hints.element.MessageProcessingHint;

/* JADX INFO: loaded from: classes10.dex */
public abstract class MessageProcessingHintProvider<H extends MessageProcessingHint> extends ExtensionElementProvider<H> {
    protected abstract H getHint();

    @Override // org.jivesoftware.smack.provider.Provider
    public H parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        return (H) getHint();
    }
}
