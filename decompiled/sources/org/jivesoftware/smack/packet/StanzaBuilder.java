package org.jivesoftware.smack.packet;

import com.appnew.android.Utils.Const;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.StanzaBuilder;
import org.jivesoftware.smack.packet.id.StanzaIdSource;
import org.jivesoftware.smack.util.Function;
import org.jivesoftware.smack.util.MultiMap;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.ToStringUtil;
import org.jivesoftware.smack.util.XmppElementUtil;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;

/* JADX INFO: loaded from: classes10.dex */
public abstract class StanzaBuilder<B extends StanzaBuilder<B>> implements StanzaView {
    MultiMap<QName, ExtensionElement> extensionElements;
    Jid from;
    String language;
    StanzaError stanzaError;
    final String stanzaId;
    final StanzaIdSource stanzaIdSource;
    Jid to;

    protected abstract void addStanzaSpecificAttributes(ToStringUtil.Builder builder);

    public abstract Stanza build();

    public abstract B getThis();

    protected StanzaBuilder(StanzaBuilder<?> stanzaBuilder) {
        this.extensionElements = new MultiMap<>();
        this.stanzaIdSource = stanzaBuilder.stanzaIdSource;
        this.stanzaId = stanzaBuilder.stanzaId;
        this.to = stanzaBuilder.to;
        this.from = stanzaBuilder.from;
        this.stanzaError = stanzaBuilder.stanzaError;
        this.language = stanzaBuilder.language;
        this.extensionElements = stanzaBuilder.extensionElements.clone();
    }

    protected StanzaBuilder(StanzaIdSource stanzaIdSource) {
        this.extensionElements = new MultiMap<>();
        this.stanzaIdSource = stanzaIdSource;
        this.stanzaId = null;
    }

    protected StanzaBuilder(String str) {
        this.extensionElements = new MultiMap<>();
        this.stanzaIdSource = null;
        this.stanzaId = (String) StringUtils.requireNullOrNotEmpty(str, "Stanza ID must not be the empty String");
    }

    protected StanzaBuilder(Stanza stanza, String str) {
        this(str);
        copyFromStanza(stanza);
    }

    protected StanzaBuilder(Stanza stanza, StanzaIdSource stanzaIdSource) {
        this(stanzaIdSource);
        copyFromStanza(stanza);
    }

    private void copyFromStanza(Stanza stanza) {
        this.to = stanza.getTo();
        this.from = stanza.getFrom();
        this.stanzaError = stanza.getError();
        this.language = stanza.getLanguage();
        this.extensionElements = stanza.cloneExtensionsMap();
    }

    public final B to(CharSequence charSequence) throws XmppStringprepException {
        return (B) to(JidCreate.from(charSequence));
    }

    public final B to(Jid jid) {
        this.to = jid;
        return (B) getThis();
    }

    public final B from(CharSequence charSequence) throws XmppStringprepException {
        return (B) from(JidCreate.from(charSequence));
    }

    public final B from(Jid jid) {
        this.from = jid;
        return (B) getThis();
    }

    public final B setError(StanzaError stanzaError) {
        this.stanzaError = stanzaError;
        return (B) getThis();
    }

    public final B setLanguage(String str) {
        this.language = str;
        return (B) getThis();
    }

    public final B addExtension(ExtensionElement extensionElement) {
        this.extensionElements.put(extensionElement.getQName(), extensionElement);
        return (B) getThis();
    }

    public final B addOptExtensions(Collection<? extends ExtensionElement> collection) {
        if (collection == null) {
            return (B) getThis();
        }
        return (B) addExtensions(collection);
    }

    public final B addExtensions(Collection<? extends ExtensionElement> collection) {
        Iterator<? extends ExtensionElement> it = collection.iterator();
        while (it.hasNext()) {
            addExtension(it.next());
        }
        return (B) getThis();
    }

    public final B overrideExtension(ExtensionElement extensionElement) {
        QName qName = extensionElement.getQName();
        this.extensionElements.remove(qName);
        this.extensionElements.put(qName, extensionElement);
        return (B) getThis();
    }

    public final B removeExtension(String str, String str2) {
        this.extensionElements.remove(new QName(str2, str));
        return (B) getThis();
    }

    public final B removeExtension(ExtensionElement extensionElement) {
        this.extensionElements.getAll(extensionElement.getQName()).remove(extensionElement);
        return (B) getThis();
    }

    @Override // org.jivesoftware.smack.packet.StanzaView
    public final String getStanzaId() {
        return this.stanzaId;
    }

    @Override // org.jivesoftware.smack.packet.StanzaView
    public final Jid getTo() {
        return this.to;
    }

    @Override // org.jivesoftware.smack.packet.StanzaView
    public final Jid getFrom() {
        return this.from;
    }

    @Override // org.jivesoftware.smack.packet.XmlLangElement
    public final String getLanguage() {
        return this.language;
    }

    @Override // org.jivesoftware.smack.packet.StanzaView
    public final StanzaError getError() {
        return this.stanzaError;
    }

    @Override // org.jivesoftware.smack.packet.StanzaView
    public final ExtensionElement getExtension(QName qName) {
        return this.extensionElements.getFirst(qName);
    }

    @Override // org.jivesoftware.smack.packet.StanzaView
    public final List<ExtensionElement> getExtensions() {
        return this.extensionElements.values();
    }

    @Override // org.jivesoftware.smack.packet.StanzaView
    public final List<ExtensionElement> getExtensions(QName qName) {
        return this.extensionElements.getAll(qName);
    }

    @Override // org.jivesoftware.smack.packet.StanzaView
    public final <E extends ExtensionElement> List<E> getExtensions(Class<E> cls) {
        return XmppElementUtil.getElementsFrom(this.extensionElements, cls);
    }

    public final boolean willBuildStanzaWithId() {
        return this.stanzaIdSource != null || StringUtils.isNotEmpty(this.stanzaId);
    }

    public final void throwIfNoStanzaId() {
        if (!willBuildStanzaWithId()) {
            throw new IllegalArgumentException("The builder will not build a stanza with an ID set, although it is required");
        }
    }

    public final String toString() {
        ToStringUtil.Builder builderAddValue = ToStringUtil.builderFor(getClass()).addValue("id", this.stanzaId).addValue("from", this.from).addValue("to", this.to).addValue(Const.LANGUAGE, this.language).addValue("error", this.stanzaError);
        addStanzaSpecificAttributes(builderAddValue);
        builderAddValue.add("Extension Elements", this.extensionElements.values(), new Function() { // from class: org.jivesoftware.smack.packet.StanzaBuilder$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.util.Function
            public final Object apply(Object obj) {
                return ((ExtensionElement) obj).getQName();
            }
        });
        return builderAddValue.build();
    }

    public static MessageBuilder buildMessage() {
        return buildMessage(null);
    }

    public static MessageBuilder buildMessage(String str) {
        return new MessageBuilder(str);
    }

    public static MessageBuilder buildMessageFrom(Message message, String str) {
        return new MessageBuilder(message, str);
    }

    public static MessageBuilder buildMessageFrom(Message message, StanzaIdSource stanzaIdSource) {
        return new MessageBuilder(message, stanzaIdSource);
    }

    public static PresenceBuilder buildPresence() {
        return buildPresence(null);
    }

    public static PresenceBuilder buildPresence(String str) {
        return new PresenceBuilder(str);
    }

    public static PresenceBuilder buildPresenceFrom(Presence presence, String str) {
        return new PresenceBuilder(presence, str);
    }

    public static PresenceBuilder buildPresenceFrom(Presence presence, StanzaIdSource stanzaIdSource) {
        return new PresenceBuilder(presence, stanzaIdSource);
    }

    public static IqData buildIqData(String str) {
        return new IqData(str);
    }

    public static <SB extends StanzaBuilder<?>> SB buildResponse(StanzaView stanzaView, Function<SB, String> function) {
        SB sbApply = function.apply(stanzaView.getStanzaId());
        sbApply.to(stanzaView.getFrom()).from(stanzaView.getTo());
        return sbApply;
    }
}
