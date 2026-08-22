package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.id.StanzaIdSource;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.ToStringUtil;

/* JADX INFO: loaded from: classes10.dex */
public final class PresenceBuilder extends MessageOrPresenceBuilder<Presence, PresenceBuilder> implements PresenceView {
    static final PresenceBuilder EMPTY = new PresenceBuilder(new StanzaIdSource() { // from class: org.jivesoftware.smack.packet.PresenceBuilder$$ExternalSyntheticLambda0
        @Override // org.jivesoftware.smack.packet.id.StanzaIdSource
        public final String getNewStanzaId() {
            return PresenceBuilder.lambda$static$0();
        }
    });
    Presence.Mode mode;
    Byte priority;
    String status;
    Presence.Type type;

    static /* synthetic */ String lambda$static$0() {
        return null;
    }

    @Override // org.jivesoftware.smack.packet.StanzaBuilder
    public PresenceBuilder getThis() {
        return this;
    }

    PresenceBuilder(Presence presence, String str) {
        super(presence, str);
        this.type = Presence.Type.available;
        copyFromPresence(presence);
    }

    PresenceBuilder(Presence presence, StanzaIdSource stanzaIdSource) {
        super(presence, stanzaIdSource);
        this.type = Presence.Type.available;
        copyFromPresence(presence);
    }

    PresenceBuilder(StanzaIdSource stanzaIdSource) {
        super(stanzaIdSource);
        this.type = Presence.Type.available;
    }

    PresenceBuilder(String str) {
        super(str);
        this.type = Presence.Type.available;
    }

    private void copyFromPresence(Presence presence) {
        this.type = presence.getType();
        this.status = presence.getStatus();
        this.priority = Byte.valueOf(presence.getPriorityByte());
        this.mode = presence.getMode();
    }

    @Override // org.jivesoftware.smack.packet.StanzaBuilder
    protected void addStanzaSpecificAttributes(ToStringUtil.Builder builder) {
        builder.addValue("type", this.type).addValue("mode", this.mode).addValue("priority", this.priority).addValue("status", this.status);
    }

    public PresenceBuilder ofType(Presence.Type type) {
        this.type = (Presence.Type) Objects.requireNonNull(type, "Type cannot be null");
        return getThis();
    }

    public PresenceBuilder setStatus(String str) {
        this.status = str;
        return getThis();
    }

    public PresenceBuilder setPriority(int i) {
        if (i < -128 || i > 127) {
            throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 127.");
        }
        return setPriority(Byte.valueOf((byte) i));
    }

    public PresenceBuilder setPriority(Byte b2) {
        this.priority = b2;
        return getThis();
    }

    public PresenceBuilder setMode(Presence.Mode mode) {
        this.mode = mode;
        return getThis();
    }

    @Override // org.jivesoftware.smack.packet.MessageOrPresenceBuilder, org.jivesoftware.smack.packet.StanzaBuilder
    public Presence build() {
        return new Presence(this);
    }

    @Override // org.jivesoftware.smack.packet.PresenceView
    public Presence.Type getType() {
        return this.type;
    }

    @Override // org.jivesoftware.smack.packet.PresenceView
    public String getStatus() {
        return this.status;
    }

    @Override // org.jivesoftware.smack.packet.PresenceView
    public int getPriority() {
        return getPriorityByte();
    }

    @Override // org.jivesoftware.smack.packet.PresenceView
    public byte getPriorityByte() {
        Byte b2 = this.priority;
        if (b2 == null) {
            return (byte) 0;
        }
        return b2.byteValue();
    }

    @Override // org.jivesoftware.smack.packet.PresenceView
    public Presence.Mode getMode() {
        Presence.Mode mode = this.mode;
        return mode == null ? Presence.Mode.available : mode;
    }
}
