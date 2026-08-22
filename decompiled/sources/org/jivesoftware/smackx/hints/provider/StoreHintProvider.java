package org.jivesoftware.smackx.hints.provider;

import org.jivesoftware.smackx.hints.element.StoreHint;

/* JADX INFO: loaded from: classes10.dex */
public class StoreHintProvider extends MessageProcessingHintProvider<StoreHint> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jivesoftware.smackx.hints.provider.MessageProcessingHintProvider
    public StoreHint getHint() {
        return StoreHint.INSTANCE;
    }
}
