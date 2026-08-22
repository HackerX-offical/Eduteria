package org.jivesoftware.smackx.caps;

import org.jivesoftware.smack.packet.PresenceBuilder;
import org.jivesoftware.smack.util.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class EntityCapsManager$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ EntityCapsManager f$0;

    public /* synthetic */ EntityCapsManager$$ExternalSyntheticLambda0(EntityCapsManager entityCapsManager) {
        this.f$0 = entityCapsManager;
    }

    @Override // org.jivesoftware.smack.util.Consumer
    public final void accept(Object obj) {
        this.f$0.addCapsExtension((PresenceBuilder) obj);
    }
}
