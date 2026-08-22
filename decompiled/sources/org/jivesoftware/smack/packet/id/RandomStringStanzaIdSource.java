package org.jivesoftware.smack.packet.id;

import org.jivesoftware.smack.util.StringUtils;

/* JADX INFO: loaded from: classes10.dex */
public final class RandomStringStanzaIdSource {

    public static class Factory implements StanzaIdSourceFactory {
        private static final int REQUIRED_MIN_LENGTH = 10;
        private final int length;
        private final boolean verySecure;
        public static final Factory VERY_SECURE = new Factory(10, true);
        public static final Factory MEDIUM_SECURE = new Factory(10, false);

        public Factory(int i, boolean z) {
            if (i < 10) {
                throw new IllegalArgumentException("Insufficient length " + i + ", must be at least 10");
            }
            this.length = i;
            this.verySecure = z;
        }

        @Override // org.jivesoftware.smack.packet.id.StanzaIdSourceFactory
        public StanzaIdSource constructStanzaIdSource() {
            if (this.verySecure) {
                return new StanzaIdSource() { // from class: org.jivesoftware.smack.packet.id.RandomStringStanzaIdSource$Factory$$ExternalSyntheticLambda0
                    @Override // org.jivesoftware.smack.packet.id.StanzaIdSource
                    public final String getNewStanzaId() {
                        return this.f$0.m14205x8a71272c();
                    }
                };
            }
            return new StanzaIdSource() { // from class: org.jivesoftware.smack.packet.id.RandomStringStanzaIdSource$Factory$$ExternalSyntheticLambda1
                @Override // org.jivesoftware.smack.packet.id.StanzaIdSource
                public final String getNewStanzaId() {
                    return this.f$0.m14206x7bc2b6ad();
                }
            };
        }

        /* JADX INFO: renamed from: lambda$constructStanzaIdSource$0$org-jivesoftware-smack-packet-id-RandomStringStanzaIdSource$Factory, reason: not valid java name */
        /* synthetic */ String m14205x8a71272c() {
            return StringUtils.randomString(this.length);
        }

        /* JADX INFO: renamed from: lambda$constructStanzaIdSource$1$org-jivesoftware-smack-packet-id-RandomStringStanzaIdSource$Factory, reason: not valid java name */
        /* synthetic */ String m14206x7bc2b6ad() {
            return StringUtils.insecureRandomString(this.length);
        }
    }
}
