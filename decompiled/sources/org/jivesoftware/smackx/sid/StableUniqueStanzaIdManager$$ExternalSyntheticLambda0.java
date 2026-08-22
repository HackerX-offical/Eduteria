package org.jivesoftware.smackx.sid;

import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.util.Consumer;
import org.jivesoftware.smackx.sid.element.OriginIdElement;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class StableUniqueStanzaIdManager$$ExternalSyntheticLambda0 implements Consumer {
    @Override // org.jivesoftware.smack.util.Consumer
    public final void accept(Object obj) {
        OriginIdElement.addTo((MessageBuilder) obj);
    }
}
