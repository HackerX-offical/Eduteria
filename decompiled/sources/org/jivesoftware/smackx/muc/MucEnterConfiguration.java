package org.jivesoftware.smackx.muc;

import java.util.Date;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.PresenceBuilder;
import org.jivesoftware.smack.util.Consumer;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smackx.muc.packet.MUCInitialPresence;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.jid.parts.Resourcepart;

/* JADX INFO: loaded from: classes10.dex */
public final class MucEnterConfiguration {
    private final Presence joinPresence;
    private final int maxChars;
    private final int maxStanzas;
    private final Resourcepart nickname;
    private final String password;
    private final int seconds;
    private final Date since;
    private final long timeout;

    MucEnterConfiguration(Builder builder) {
        this.nickname = builder.nickname;
        String str = builder.password;
        this.password = str;
        int i = builder.maxChars;
        this.maxChars = i;
        int i2 = builder.maxStanzas;
        this.maxStanzas = i2;
        int i3 = builder.seconds;
        this.seconds = i3;
        Date date = builder.since;
        this.since = date;
        this.timeout = builder.timeout;
        PresenceBuilder presenceBuilderOfType = builder.joinPresence == null ? builder.joinPresenceBuilder.ofType(Presence.Type.available) : builder.joinPresence.asBuilder();
        presenceBuilderOfType.addExtension(new MUCInitialPresence(str, i, i2, i3, date));
        this.joinPresence = presenceBuilderOfType.build();
    }

    Presence getJoinPresence(MultiUserChat multiUserChat) {
        this.joinPresence.setTo(JidCreate.entityFullFrom(multiUserChat.getRoom(), this.nickname));
        return this.joinPresence;
    }

    long getTimeout() {
        return this.timeout;
    }

    public static final class Builder {
        private Presence joinPresence;
        private final PresenceBuilder joinPresenceBuilder;
        private final Resourcepart nickname;
        private String password;
        private Date since;
        private long timeout;
        private int maxChars = -1;
        private int maxStanzas = -1;
        private int seconds = -1;

        Builder(Resourcepart resourcepart, XMPPConnection xMPPConnection) {
            this.nickname = (Resourcepart) Objects.requireNonNull(resourcepart, "Nickname must not be null");
            long replyTimeout = xMPPConnection.getReplyTimeout();
            this.timeout = replyTimeout;
            timeoutAfter(replyTimeout);
            this.joinPresenceBuilder = xMPPConnection.getStanzaFactory().buildPresenceStanza();
        }

        @Deprecated
        public Builder withPresence(Presence presence) {
            if (presence.getType() != Presence.Type.available) {
                throw new IllegalArgumentException("Presence must be of type 'available'");
            }
            this.joinPresence = presence;
            return this;
        }

        public Builder withPresence(Consumer<? super PresenceBuilder> consumer) {
            consumer.accept(this.joinPresenceBuilder);
            if (this.joinPresenceBuilder.getType() == Presence.Type.available) {
                return this;
            }
            throw new IllegalArgumentException("Presence must be of type 'available'");
        }

        public Builder withPassword(String str) {
            this.password = str;
            return this;
        }

        public Builder timeoutAfter(long j) {
            if (j <= 0) {
                throw new IllegalArgumentException("timeout must be positive");
            }
            this.timeout = j;
            return this;
        }

        public Builder requestNoHistory() {
            this.maxChars = 0;
            this.maxStanzas = -1;
            this.seconds = -1;
            this.since = null;
            return this;
        }

        public Builder requestMaxCharsHistory(int i) {
            this.maxChars = i;
            return this;
        }

        public Builder requestMaxStanzasHistory(int i) {
            this.maxStanzas = i;
            return this;
        }

        public Builder requestHistorySince(int i) {
            this.seconds = i;
            return this;
        }

        public Builder requestHistorySince(Date date) {
            this.since = date;
            return this;
        }

        public MucEnterConfiguration build() {
            return new MucEnterConfiguration(this);
        }
    }
}
