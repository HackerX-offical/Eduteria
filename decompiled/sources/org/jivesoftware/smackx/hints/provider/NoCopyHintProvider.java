package org.jivesoftware.smackx.hints.provider;

import org.jivesoftware.smackx.hints.element.NoCopyHint;

/* JADX INFO: loaded from: classes10.dex */
public class NoCopyHintProvider extends MessageProcessingHintProvider<NoCopyHint> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jivesoftware.smackx.hints.provider.MessageProcessingHintProvider
    public NoCopyHint getHint() {
        return NoCopyHint.INSTANCE;
    }
}
