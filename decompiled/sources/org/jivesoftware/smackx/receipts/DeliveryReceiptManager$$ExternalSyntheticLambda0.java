package org.jivesoftware.smackx.receipts;

import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.util.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class DeliveryReceiptManager$$ExternalSyntheticLambda0 implements Consumer {
    @Override // org.jivesoftware.smack.util.Consumer
    public final void accept(Object obj) {
        DeliveryReceiptRequest.addTo((MessageBuilder) obj);
    }
}
