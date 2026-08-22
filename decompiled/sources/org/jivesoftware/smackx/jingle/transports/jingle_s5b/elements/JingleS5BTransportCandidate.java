package org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.InternetAddress;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jivesoftware.smackx.jingle.element.JingleContentTransportCandidate;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;

/* JADX INFO: loaded from: classes10.dex */
public final class JingleS5BTransportCandidate extends JingleContentTransportCandidate {
    public static final String ATTR_CID = "cid";
    public static final String ATTR_HOST = "host";
    public static final String ATTR_JID = "jid";
    public static final String ATTR_PORT = "port";
    public static final String ATTR_PRIORITY = "priority";
    public static final String ATTR_TYPE = "type";
    public static final String NAMESPACE = "urn:xmpp:jingle:transports:s5b:1";
    private final String cid;
    private final InternetAddress host;
    private final Jid jid;
    private final int port;
    private final int priority;
    private final Type type;

    public JingleS5BTransportCandidate(String str, String str2, Jid jid, int i, int i2, Type type) {
        this(str, InternetAddress.from(str2), jid, i, i2, type);
    }

    public JingleS5BTransportCandidate(String str, InternetAddress internetAddress, Jid jid, int i, int i2, Type type) {
        Objects.requireNonNull(str);
        Objects.requireNonNull(internetAddress);
        Objects.requireNonNull(jid);
        if (i2 < 0) {
            throw new IllegalArgumentException("Priority MUST NOT be less than 0.");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Port MUST NOT be less than 0.");
        }
        this.cid = str;
        this.host = internetAddress;
        this.jid = jid;
        this.port = i;
        this.priority = i2;
        this.type = type;
    }

    public JingleS5BTransportCandidate(Bytestream.StreamHost streamHost, int i, Type type) {
        this(StringUtils.randomString(24), streamHost.getAddress(), streamHost.getJID(), streamHost.getPort(), i, type);
    }

    public enum Type {
        assisted(120),
        direct(126),
        proxy(10),
        tunnel(110);

        private final int weight;

        public int getWeight() {
            return this.weight;
        }

        Type(int i) {
            this.weight = i;
        }

        public static Type fromString(String str) {
            for (Type type : values()) {
                if (type.toString().equals(str)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Illegal type: " + str);
        }
    }

    public String getCandidateId() {
        return this.cid;
    }

    public InternetAddress getHost() {
        return this.host;
    }

    public Jid getJid() {
        return this.jid;
    }

    public int getPort() {
        return this.port;
    }

    public int getPriority() {
        return this.priority;
    }

    public Type getType() {
        return this.type;
    }

    public Bytestream.StreamHost getStreamHost() {
        return new Bytestream.StreamHost(this.jid, this.host, this.port);
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:xmpp:jingle:transports:s5b:1";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.attribute("cid", this.cid);
        xmlStringBuilder.attribute(ATTR_HOST, this.host);
        xmlStringBuilder.attribute("jid", this.jid);
        int i = this.port;
        if (i >= 0) {
            xmlStringBuilder.attribute("port", i);
        }
        xmlStringBuilder.attribute("priority", this.priority);
        xmlStringBuilder.optAttribute("type", this.type);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String cid;
        private InternetAddress host;
        private Jid jid;
        private int port;
        private int priority;
        private Type type;

        private Builder() {
            this.port = -1;
            this.priority = -1;
        }

        public Builder setCandidateId(String str) {
            this.cid = str;
            return this;
        }

        public Builder setHost(String str) {
            return setHost(InternetAddress.from(str));
        }

        public Builder setHost(InternetAddress internetAddress) {
            this.host = internetAddress;
            return this;
        }

        public Builder setJid(String str) throws XmppStringprepException {
            this.jid = JidCreate.from(str);
            return this;
        }

        public Builder setPort(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Port MUST NOT be less than 0.");
            }
            this.port = i;
            return this;
        }

        public Builder setPriority(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Priority MUST NOT be less than 0.");
            }
            this.priority = i;
            return this;
        }

        public Builder setType(Type type) {
            this.type = type;
            return this;
        }

        public JingleS5BTransportCandidate build() {
            return new JingleS5BTransportCandidate(this.cid, this.host, this.jid, this.port, this.priority, this.type);
        }
    }
}
