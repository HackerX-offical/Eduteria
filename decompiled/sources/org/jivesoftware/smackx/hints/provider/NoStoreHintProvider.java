package org.jivesoftware.smackx.hints.provider;

import org.jivesoftware.smackx.hints.element.NoStoreHint;

/* JADX INFO: loaded from: classes10.dex */
public class NoStoreHintProvider extends MessageProcessingHintProvider<NoStoreHint> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jivesoftware.smackx.hints.provider.MessageProcessingHintProvider
    public NoStoreHint getHint() {
        return NoStoreHint.INSTANCE;
    }
}
