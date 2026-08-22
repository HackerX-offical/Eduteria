package org.jivesoftware.smack.packet;

import com.csvreader.CsvReader;
import java.util.List;
import java.util.Locale;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class Presence extends MessageOrPresence<PresenceBuilder> implements PresenceView {
    public static final String ELEMENT = "presence";
    private Mode mode;
    private Byte priority;
    private String status;
    private Type type;

    @Deprecated
    public Presence(Type type) {
        this.type = Type.available;
        this.status = null;
        this.mode = null;
        setType(type);
    }

    @Deprecated
    public Presence(Jid jid, Type type) {
        this(type);
        setTo(jid);
    }

    @Deprecated
    public Presence(Type type, String str, int i, Mode mode) {
        this.type = Type.available;
        this.status = null;
        this.mode = null;
        setType(type);
        setStatus(str);
        setPriority(i);
        setMode(mode);
    }

    Presence(PresenceBuilder presenceBuilder) {
        super(presenceBuilder);
        this.type = Type.available;
        this.status = null;
        this.mode = null;
        this.type = presenceBuilder.type;
        this.status = presenceBuilder.status;
        this.priority = presenceBuilder.priority;
        this.mode = presenceBuilder.mode;
    }

    public Presence(Presence presence) {
        super(presence);
        this.type = Type.available;
        this.status = null;
        this.mode = null;
        this.type = presence.type;
        this.status = presence.status;
        this.priority = presence.priority;
        this.mode = presence.mode;
    }

    public boolean isAvailable() {
        return this.type == Type.available;
    }

    public boolean isAway() {
        if (this.type == Type.available) {
            return this.mode == Mode.away || this.mode == Mode.xa || this.mode == Mode.dnd;
        }
        return false;
    }

    @Override // org.jivesoftware.smack.packet.PresenceView
    public Type getType() {
        return this.type;
    }

    @Deprecated
    public void setType(Type type) {
        this.type = (Type) Objects.requireNonNull(type, "Type cannot be null");
    }

    @Override // org.jivesoftware.smack.packet.PresenceView
    public String getStatus() {
        return this.status;
    }

    @Deprecated
    public void setStatus(String str) {
        this.status = str;
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

    @Deprecated
    public void setPriority(int i) {
        if (i < -128 || i > 127) {
            throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 127.");
        }
        setPriority((byte) i);
    }

    public void setPriority(byte b2) {
        this.priority = Byte.valueOf(b2);
    }

    @Override // org.jivesoftware.smack.packet.PresenceView
    public Mode getMode() {
        Mode mode = this.mode;
        return mode == null ? Mode.available : mode;
    }

    @Deprecated
    public void setMode(Mode mode) {
        this.mode = mode;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.MessageOrPresence
    public PresenceBuilder asBuilder() {
        return StanzaBuilder.buildPresenceFrom(this, getStanzaId());
    }

    @Override // org.jivesoftware.smack.packet.MessageOrPresence
    public PresenceBuilder asBuilder(String str) {
        return StanzaBuilder.buildPresenceFrom(this, str);
    }

    @Override // org.jivesoftware.smack.packet.MessageOrPresence
    public PresenceBuilder asBuilder(XMPPConnection xMPPConnection) {
        return xMPPConnection.getStanzaFactory().buildPresenceStanzaFrom(this);
    }

    @Override // org.jivesoftware.smack.packet.Stanza
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Presence Stanza [");
        logCommonAttributes(sb);
        sb.append("type=").append(this.type).append(CsvReader.Letters.COMMA);
        if (this.mode != null) {
            sb.append("mode=").append(this.mode).append(CsvReader.Letters.COMMA);
        }
        if (!StringUtils.isNullOrEmpty(this.status)) {
            sb.append("status=").append(this.status).append(CsvReader.Letters.COMMA);
        }
        if (this.priority != null) {
            sb.append("prio=").append(this.priority).append(CsvReader.Letters.COMMA);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        Mode mode;
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        addCommonAttributes(xmlStringBuilder);
        if (this.type != Type.available) {
            xmlStringBuilder.attribute("type", this.type);
        }
        List<ExtensionElement> extensions = getExtensions();
        if (this.status == null && this.priority == null && (((mode = this.mode) == null || mode == Mode.available) && extensions.isEmpty() && getError() == null)) {
            return xmlStringBuilder.closeEmptyElement();
        }
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement("status", this.status);
        xmlStringBuilder.optElement("priority", this.priority);
        Mode mode2 = this.mode;
        if (mode2 != null && mode2 != Mode.available) {
            xmlStringBuilder.element("show", this.mode);
        }
        xmlStringBuilder.append(extensions);
        appendErrorIfExists(xmlStringBuilder);
        xmlStringBuilder.closeElement(ELEMENT);
        return xmlStringBuilder;
    }

    @Deprecated
    public Presence clone() {
        return new Presence(this);
    }

    @Deprecated
    public Presence cloneWithNewId() {
        Presence presenceClone = clone();
        presenceClone.setNewStanzaId();
        return presenceClone;
    }

    public enum Type {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe;

        public static Type fromString(String str) {
            return valueOf(str.toLowerCase(Locale.US));
        }
    }

    public enum Mode {
        chat,
        available,
        away,
        xa,
        dnd;

        public static Mode fromString(String str) {
            return valueOf(str.toLowerCase(Locale.US));
        }
    }
}
