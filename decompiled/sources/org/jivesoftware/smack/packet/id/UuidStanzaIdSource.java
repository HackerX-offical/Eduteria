package org.jivesoftware.smack.packet.id;

import java.util.UUID;

/* JADX INFO: loaded from: classes10.dex */
public final class UuidStanzaIdSource implements StanzaIdSource {
    public static final UuidStanzaIdSource INSTANCE = new UuidStanzaIdSource();

    private UuidStanzaIdSource() {
    }

    @Override // org.jivesoftware.smack.packet.id.StanzaIdSource
    public String getNewStanzaId() {
        return UUID.randomUUID().toString();
    }

    public static class Factory implements StanzaIdSourceFactory {
        @Override // org.jivesoftware.smack.packet.id.StanzaIdSourceFactory
        public UuidStanzaIdSource constructStanzaIdSource() {
            return UuidStanzaIdSource.INSTANCE;
        }
    }
}
