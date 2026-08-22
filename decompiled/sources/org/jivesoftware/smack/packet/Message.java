package org.jivesoftware.smack.packet;

import com.csvreader.CsvReader;
import java.util.Iterator;
import java.util.Locale;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.HashCode;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;

/* JADX INFO: loaded from: classes10.dex */
public final class Message extends MessageOrPresence<MessageBuilder> implements MessageView {
    public static final String BODY = "body";
    public static final String ELEMENT = "message";
    private Type type;

    @Deprecated
    public Message() {
    }

    @Deprecated
    public Message(Jid jid) {
        setTo(jid);
    }

    @Deprecated
    public Message(Jid jid, Type type) {
        this(jid);
        setType(type);
    }

    @Deprecated
    public Message(Jid jid, String str) {
        this(jid);
        setBody(str);
    }

    @Deprecated
    public Message(String str, String str2) throws XmppStringprepException {
        this(JidCreate.from(str), str2);
    }

    @Deprecated
    public Message(Jid jid, ExtensionElement extensionElement) {
        this(jid);
        addExtension(extensionElement);
    }

    Message(MessageBuilder messageBuilder) {
        super(messageBuilder);
        this.type = messageBuilder.type;
    }

    public Message(Message message) {
        super(message);
        this.type = message.type;
    }

    @Override // org.jivesoftware.smack.packet.MessageView
    public Type getType() {
        Type type = this.type;
        return type == null ? Type.normal : type;
    }

    @Deprecated
    public void setType(Type type) {
        this.type = type;
    }

    @Deprecated
    public void setSubject(String str) {
        if (str == null) {
            removeSubject("");
        } else {
            addSubject(null, str);
        }
    }

    @Deprecated
    public Subject addSubject(String str, String str2) {
        String strDetermineLanguage = Stanza.determineLanguage(this, str);
        Iterator it = getExtensions(Subject.class).iterator();
        while (it.hasNext()) {
            if (strDetermineLanguage.equals(((Subject) it.next()).getLanguage())) {
                throw new IllegalArgumentException("Subject with the language " + strDetermineLanguage + " already exists");
            }
        }
        Subject subject = new Subject(strDetermineLanguage, str2);
        addExtension(subject);
        return subject;
    }

    @Deprecated
    public boolean removeSubject(String str) {
        String strDetermineLanguage = Stanza.determineLanguage(this, str);
        for (Subject subject : getExtensions(Subject.class)) {
            if (strDetermineLanguage.equals(subject.language)) {
                return removeSubject(subject);
            }
        }
        return false;
    }

    @Deprecated
    public boolean removeSubject(Subject subject) {
        return removeExtension(subject) != null;
    }

    @Deprecated
    public void setBody(CharSequence charSequence) {
        setBody(charSequence != null ? charSequence.toString() : null);
    }

    @Deprecated
    public void setBody(String str) {
        if (str == null) {
            removeBody("");
        } else {
            addBody(null, str);
        }
    }

    @Deprecated
    public Body addBody(String str, String str2) {
        String strDetermineLanguage = Stanza.determineLanguage(this, str);
        removeBody(strDetermineLanguage);
        Body body = new Body(strDetermineLanguage, str2);
        addExtension(body);
        return body;
    }

    @Deprecated
    public boolean removeBody(String str) {
        String strDetermineLanguage = Stanza.determineLanguage(this, str);
        for (Body body : getBodies()) {
            if (Objects.equals(body.getLanguage(), strDetermineLanguage)) {
                removeExtension(body);
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public boolean removeBody(Body body) {
        return removeExtension(body) != null;
    }

    @Deprecated
    public void setThread(String str) {
        addExtension(new Thread(str));
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "message";
    }

    @Override // org.jivesoftware.smack.packet.MessageOrPresence
    public MessageBuilder asBuilder() {
        return StanzaBuilder.buildMessageFrom(this, getStanzaId());
    }

    @Override // org.jivesoftware.smack.packet.MessageOrPresence
    public MessageBuilder asBuilder(String str) {
        return StanzaBuilder.buildMessageFrom(this, str);
    }

    @Override // org.jivesoftware.smack.packet.MessageOrPresence
    public MessageBuilder asBuilder(XMPPConnection xMPPConnection) {
        return xMPPConnection.getStanzaFactory().buildMessageStanzaFrom(this);
    }

    @Override // org.jivesoftware.smack.packet.Stanza
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Message Stanza [");
        logCommonAttributes(sb);
        if (this.type != null) {
            sb.append("type=").append(this.type).append(CsvReader.Letters.COMMA);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        addCommonAttributes(xmlStringBuilder);
        xmlStringBuilder.optAttribute("type", this.type);
        xmlStringBuilder.rightAngleBracket();
        if (this.type == Type.error) {
            appendErrorIfExists(xmlStringBuilder);
        }
        xmlStringBuilder.append(getExtensions());
        xmlStringBuilder.closeElement("message");
        return xmlStringBuilder;
    }

    @Deprecated
    public Message clone() {
        return new Message(this);
    }

    public static final class Subject implements ExtensionElement {
        public static final String ELEMENT = "subject";
        public static final String NAMESPACE = "jabber:client";
        public static final QName QNAME = new QName("jabber:client", "subject");
        private final HashCode.Cache hashCodeCache = new HashCode.Cache();
        private final String language;
        private final String subject;

        public Subject(String str, String str2) {
            if (str2 == null) {
                throw new NullPointerException("Subject cannot be null.");
            }
            this.language = str;
            this.subject = str2;
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement, org.jivesoftware.smack.packet.XmlLangElement
        public String getLanguage() {
            return this.language;
        }

        public String getSubject() {
            return this.subject;
        }

        public int hashCode() {
            return this.hashCodeCache.getHashCode(new HashCode.Calculator() { // from class: org.jivesoftware.smack.packet.Message$Subject$$ExternalSyntheticLambda0
                @Override // org.jivesoftware.smack.util.HashCode.Calculator
                public final void calculateHash(HashCode.Builder builder) {
                    this.f$0.m14203lambda$hashCode$0$orgjivesoftwaresmackpacketMessage$Subject(builder);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$hashCode$0$org-jivesoftware-smack-packet-Message$Subject, reason: not valid java name */
        /* synthetic */ void m14203lambda$hashCode$0$orgjivesoftwaresmackpacketMessage$Subject(HashCode.Builder builder) {
            builder.append(this.language).append(this.subject);
        }

        public boolean equals(Object obj) {
            return EqualsUtil.equals(this, obj, new EqualsUtil.EqualsComperator() { // from class: org.jivesoftware.smack.packet.Message$Subject$$ExternalSyntheticLambda1
                @Override // org.jivesoftware.smack.util.EqualsUtil.EqualsComperator
                public final void compare(EqualsUtil.Builder builder, Object obj2) {
                    this.f$0.m14202lambda$equals$1$orgjivesoftwaresmackpacketMessage$Subject(builder, (Message.Subject) obj2);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$equals$1$org-jivesoftware-smack-packet-Message$Subject, reason: not valid java name */
        /* synthetic */ void m14202lambda$equals$1$orgjivesoftwaresmackpacketMessage$Subject(EqualsUtil.Builder builder, Subject subject) {
            builder.append(this.language, subject.language).append(this.subject, subject.subject);
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "subject";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return "jabber:client";
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.escape(this.subject);
            xmlStringBuilder.closeElement(getElementName());
            return xmlStringBuilder;
        }
    }

    public static final class Body implements ExtensionElement {
        public static final String ELEMENT = "body";
        public static final String NAMESPACE = "jabber:client";
        public static final QName QNAME = new QName("jabber:client", "body");
        private final HashCode.Cache hashCodeCache;
        private final String language;
        private final String message;
        private final BodyElementNamespace namespace;

        enum BodyElementNamespace {
            client("jabber:client"),
            server(StreamOpen.SERVER_NAMESPACE);

            private final String xmlNamespace;

            BodyElementNamespace(String str) {
                this.xmlNamespace = str;
            }

            public String getNamespace() {
                return this.xmlNamespace;
            }
        }

        public Body(String str, String str2) {
            this(str, str2, BodyElementNamespace.client);
        }

        public Body(String str, String str2, BodyElementNamespace bodyElementNamespace) {
            this.hashCodeCache = new HashCode.Cache();
            if (str2 == null) {
                throw new NullPointerException("Message cannot be null.");
            }
            this.language = str;
            this.message = str2;
            this.namespace = (BodyElementNamespace) Objects.requireNonNull(bodyElementNamespace);
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement, org.jivesoftware.smack.packet.XmlLangElement
        public String getLanguage() {
            return this.language;
        }

        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.hashCodeCache.getHashCode(new HashCode.Calculator() { // from class: org.jivesoftware.smack.packet.Message$Body$$ExternalSyntheticLambda1
                @Override // org.jivesoftware.smack.util.HashCode.Calculator
                public final void calculateHash(HashCode.Builder builder) {
                    this.f$0.m14201lambda$hashCode$0$orgjivesoftwaresmackpacketMessage$Body(builder);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$hashCode$0$org-jivesoftware-smack-packet-Message$Body, reason: not valid java name */
        /* synthetic */ void m14201lambda$hashCode$0$orgjivesoftwaresmackpacketMessage$Body(HashCode.Builder builder) {
            builder.append(this.language).append(this.message);
        }

        public boolean equals(Object obj) {
            return EqualsUtil.equals(this, obj, new EqualsUtil.EqualsComperator() { // from class: org.jivesoftware.smack.packet.Message$Body$$ExternalSyntheticLambda0
                @Override // org.jivesoftware.smack.util.EqualsUtil.EqualsComperator
                public final void compare(EqualsUtil.Builder builder, Object obj2) {
                    this.f$0.m14200lambda$equals$1$orgjivesoftwaresmackpacketMessage$Body(builder, (Message.Body) obj2);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$equals$1$org-jivesoftware-smack-packet-Message$Body, reason: not valid java name */
        /* synthetic */ void m14200lambda$equals$1$orgjivesoftwaresmackpacketMessage$Body(EqualsUtil.Builder builder, Body body) {
            builder.append(this.language, body.language).append(this.message, body.message);
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "body";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return this.namespace.xmlNamespace;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.text(this.message);
            xmlStringBuilder.closeElement(getElementName());
            return xmlStringBuilder;
        }
    }

    public static class Thread implements ExtensionElement {
        public static final String NAMESPACE = "jabber:client";
        public static final String PARENT_ATTRIBUTE_NAME = "parent";
        private final String parent;
        private final String thread;
        public static final String ELEMENT = "thread";
        public static final QName QNAME = new QName("jabber:client", ELEMENT);

        public Thread(String str) {
            this(str, null);
        }

        public Thread(String str, String str2) {
            this.thread = (String) StringUtils.requireNotNullNorEmpty(str, "thread must not be null nor empty");
            this.parent = (String) StringUtils.requireNullOrNotEmpty(str2, "parent must be null or not empty");
        }

        public String getThread() {
            return this.thread;
        }

        public String getParent() {
            return this.parent;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return "jabber:client";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public QName getQName() {
            return QNAME;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.optAttribute(PARENT_ATTRIBUTE_NAME, this.parent);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.escape(this.thread);
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }
    }

    public enum Type {
        normal,
        chat,
        groupchat,
        headline,
        error;

        public static Type fromString(String str) {
            return valueOf(str.toLowerCase(Locale.US));
        }
    }
}
