package org.jivesoftware.smackx.muc.packet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.EntityJid;

/* JADX INFO: loaded from: classes10.dex */
public class MUCUser implements ExtensionElement {
    public static final String ELEMENT = "x";
    public static final String NAMESPACE = "http://jabber.org/protocol/muc#user";
    public static final QName QNAME = new QName(NAMESPACE, "x");
    private Decline decline;
    private Destroy destroy;
    private Invite invite;
    private MUCItem item;
    private String password;
    private final Set<Status> statusCodes = new HashSet(4);

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "x";
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement(getInvite());
        xmlStringBuilder.optElement(getDecline());
        xmlStringBuilder.optElement(getItem());
        xmlStringBuilder.optElement("password", getPassword());
        xmlStringBuilder.append(this.statusCodes);
        xmlStringBuilder.optElement(getDestroy());
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public Invite getInvite() {
        return this.invite;
    }

    public Decline getDecline() {
        return this.decline;
    }

    public MUCItem getItem() {
        return this.item;
    }

    public String getPassword() {
        return this.password;
    }

    public Set<Status> getStatus() {
        return this.statusCodes;
    }

    public boolean hasStatus() {
        return !this.statusCodes.isEmpty();
    }

    public Destroy getDestroy() {
        return this.destroy;
    }

    public void setInvite(Invite invite) {
        this.invite = invite;
    }

    public void setDecline(Decline decline) {
        this.decline = decline;
    }

    public void setItem(MUCItem mUCItem) {
        this.item = mUCItem;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void addStatusCodes(Set<Status> set) {
        this.statusCodes.addAll(set);
    }

    public void addStatusCode(Status status) {
        this.statusCodes.add(status);
    }

    public void setDestroy(Destroy destroy) {
        this.destroy = destroy;
    }

    @Deprecated
    public static MUCUser getFrom(Stanza stanza) {
        return from(stanza);
    }

    public static MUCUser from(Stanza stanza) {
        return (MUCUser) stanza.getExtension(MUCUser.class);
    }

    public static class Invite implements NamedElement {
        public static final String ELEMENT = "invite";
        private final EntityJid from;
        private final String reason;
        private final EntityBareJid to;

        public Invite(String str, EntityFullJid entityFullJid) {
            this(str, entityFullJid, null);
        }

        public Invite(String str, EntityBareJid entityBareJid) {
            this(str, null, entityBareJid);
        }

        public Invite(String str, EntityJid entityJid, EntityBareJid entityBareJid) {
            this.reason = str;
            this.from = entityJid;
            this.to = entityBareJid;
        }

        public EntityJid getFrom() {
            return this.from;
        }

        public String getReason() {
            return this.reason;
        }

        public EntityBareJid getTo() {
            return this.to;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this);
            xmlStringBuilder.optAttribute("to", getTo());
            xmlStringBuilder.optAttribute("from", getFrom());
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.optElement("reason", getReason());
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }
    }

    public static class Decline implements ExtensionElement {
        public static final String ELEMENT = "decline";
        public static final QName QNAME = new QName(MUCUser.NAMESPACE, ELEMENT);
        private final EntityBareJid from;
        private final String reason;
        private final EntityBareJid to;

        public Decline(String str, EntityBareJid entityBareJid) {
            this(str, null, entityBareJid);
        }

        public Decline(String str, EntityBareJid entityBareJid, EntityBareJid entityBareJid2) {
            this.reason = str;
            this.from = entityBareJid;
            this.to = entityBareJid2;
        }

        public EntityBareJid getFrom() {
            return this.from;
        }

        public String getReason() {
            return this.reason;
        }

        public EntityBareJid getTo() {
            return this.to;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.optAttribute("to", getTo());
            xmlStringBuilder.optAttribute("from", getFrom());
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.optElement("reason", getReason());
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return QNAME.getLocalPart();
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return QNAME.getNamespaceURI();
        }
    }

    public static final class Status implements NamedElement {
        public static final String ELEMENT = "status";
        private final Integer code;
        private static final Map<Integer, Status> statusMap = new HashMap(8);
        public static final Status PRESENCE_TO_SELF_110 = create((Integer) 110);
        public static final Status ROOM_CREATED_201 = create((Integer) 201);
        public static final Status BANNED_301 = create((Integer) 301);
        public static final Status NEW_NICKNAME_303 = create((Integer) 303);
        public static final Status KICKED_307 = create((Integer) 307);
        public static final Status REMOVED_AFFIL_CHANGE_321 = create((Integer) 321);
        public static final Status REMOVED_FOR_TECHNICAL_REASONS_333 = create((Integer) 333);

        public static Status create(String str) {
            return create(Integer.valueOf(str));
        }

        public static Status create(Integer num) {
            Status status;
            Map<Integer, Status> map = statusMap;
            synchronized (map) {
                status = map.get(num);
                if (status == null) {
                    status = new Status(num.intValue());
                    map.put(num, status);
                }
            }
            return status;
        }

        private Status(int i) {
            this.code = Integer.valueOf(i);
        }

        public int getCode() {
            return this.code.intValue();
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this);
            xmlStringBuilder.attribute("code", getCode());
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        public String toString() {
            return this.code.toString();
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof Status)) {
                return this.code.equals(Integer.valueOf(((Status) obj).getCode()));
            }
            return false;
        }

        public int hashCode() {
            return this.code.intValue();
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "status";
        }
    }
}
