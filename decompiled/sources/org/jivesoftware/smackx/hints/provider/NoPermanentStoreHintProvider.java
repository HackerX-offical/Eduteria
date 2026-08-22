package org.jivesoftware.smackx.hints.provider;

import org.jivesoftware.smackx.hints.element.NoPermanentStoreHint;

/* JADX INFO: loaded from: classes10.dex */
public class NoPermanentStoreHintProvider extends MessageProcessingHintProvider<NoPermanentStoreHint> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jivesoftware.smackx.hints.provider.MessageProcessingHintProvider
    public NoPermanentStoreHint getHint() {
        return NoPermanentStoreHint.INSTANCE;
    }
}
