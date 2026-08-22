package org.jivesoftware.smack.packet.id;

import java.util.concurrent.atomic.AtomicLong;
import org.jivesoftware.smack.util.StringUtils;

/* JADX INFO: loaded from: classes10.dex */
public class StandardStanzaIdSource implements StanzaIdSource {
    public static final StandardStanzaIdSource DEFAULT = new StandardStanzaIdSource();
    private final String prefix = StringUtils.randomString(5) + "-";
    private final AtomicLong id = new AtomicLong();

    @Override // org.jivesoftware.smack.packet.id.StanzaIdSource
    public String getNewStanzaId() {
        return this.prefix + Long.toString(this.id.incrementAndGet());
    }

    public static class Factory implements StanzaIdSourceFactory {
        @Override // org.jivesoftware.smack.packet.id.StanzaIdSourceFactory
        public StandardStanzaIdSource constructStanzaIdSource() {
            return new StandardStanzaIdSource();
        }
    }
}
