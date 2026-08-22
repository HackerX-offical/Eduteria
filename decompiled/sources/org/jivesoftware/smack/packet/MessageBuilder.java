package org.jivesoftware.smack.packet;

import java.util.Iterator;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.id.StanzaIdSource;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.ToStringUtil;

/* JADX INFO: loaded from: classes10.dex */
public final class MessageBuilder extends MessageOrPresenceBuilder<Message, MessageBuilder> implements MessageView {
    static final MessageBuilder EMPTY = new MessageBuilder(new StanzaIdSource() { // from class: org.jivesoftware.smack.packet.MessageBuilder$$ExternalSyntheticLambda0
        @Override // org.jivesoftware.smack.packet.id.StanzaIdSource
        public final String getNewStanzaId() {
            return MessageBuilder.lambda$static$0();
        }
    });
    Message.Type type;

    static /* synthetic */ String lambda$static$0() {
        return null;
    }

    @Override // org.jivesoftware.smack.packet.StanzaBuilder
    public MessageBuilder getThis() {
        return this;
    }

    MessageBuilder(Message message, String str) {
        super(message, str);
        copyFromMessage(message);
    }

    MessageBuilder(Message message, StanzaIdSource stanzaIdSource) {
        super(message, stanzaIdSource);
        copyFromMessage(message);
    }

    MessageBuilder(StanzaIdSource stanzaIdSource) {
        super(stanzaIdSource);
    }

    MessageBuilder(String str) {
        super(str);
    }

    private void copyFromMessage(Message message) {
        this.type = message.getType();
    }

    @Override // org.jivesoftware.smack.packet.StanzaBuilder
    protected void addStanzaSpecificAttributes(ToStringUtil.Builder builder) {
        builder.addValue("type", this.type);
    }

    public MessageBuilder ofType(Message.Type type) {
        this.type = type;
        return getThis();
    }

    public MessageBuilder setThread(String str) {
        return setThread(str, null);
    }

    public MessageBuilder setThread(String str, String str2) {
        addExtension(new Message.Thread(str, str2));
        return getThis();
    }

    public MessageBuilder setSubject(String str) {
        return addSubject(null, str);
    }

    public MessageBuilder addSubject(String str, String str2) {
        String str3 = (String) StringUtils.requireNullOrNotEmpty(str, "language must be null or not empty");
        Iterator it = getExtensions(Message.Subject.class).iterator();
        while (it.hasNext()) {
            if (StringUtils.nullSafeCharSequenceEquals(str3, ((Message.Subject) it.next()).getLanguage())) {
                throw new IllegalArgumentException("Subject with the language " + str3 + " already exists");
            }
        }
        addExtension(new Message.Subject(str3, str2));
        return this;
    }

    public MessageBuilder setBody(CharSequence charSequence) {
        return setBody(charSequence.toString());
    }

    public MessageBuilder setBody(String str) {
        return addBody(null, str);
    }

    public MessageBuilder addBody(String str, String str2) {
        String str3 = (String) StringUtils.requireNullOrNotEmpty(str, "language must be null or not empty");
        Iterator it = getExtensions(Message.Body.class).iterator();
        while (it.hasNext()) {
            if (StringUtils.nullSafeCharSequenceEquals(str3, ((Message.Body) it.next()).getLanguage())) {
                throw new IllegalArgumentException("Bodyt with the language " + str3 + " already exists");
            }
        }
        addExtension(new Message.Body(str3, str2));
        return this;
    }

    @Override // org.jivesoftware.smack.packet.MessageOrPresenceBuilder, org.jivesoftware.smack.packet.StanzaBuilder
    public Message build() {
        return new Message(this);
    }

    @Override // org.jivesoftware.smack.packet.MessageView
    public Message.Type getType() {
        return this.type;
    }
}
