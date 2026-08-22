package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;
import org.jxmpp.jid.BareJid;

/* JADX INFO: loaded from: classes10.dex */
public class Affiliation implements ExtensionElement {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String ELEMENT = "affiliation";
    private final Type affiliation;
    private final BareJid jid;
    private final AffiliationNamespace namespace;
    private final String node;

    public enum Type {
        member,
        none,
        outcast,
        owner,
        publisher
    }

    public enum AffiliationNamespace {
        basic(PubSubElementType.AFFILIATIONS),
        owner(PubSubElementType.AFFILIATIONS_OWNER);

        public final PubSubElementType type;

        AffiliationNamespace(PubSubElementType pubSubElementType) {
            this.type = pubSubElementType;
        }

        public static AffiliationNamespace fromXmlns(String str) {
            for (AffiliationNamespace affiliationNamespace : values()) {
                if (affiliationNamespace.type.getNamespace().getXmlns().equals(str)) {
                    return affiliationNamespace;
                }
            }
            throw new IllegalArgumentException("Invalid affiliations namespace: " + str);
        }
    }

    public Affiliation(String str, Type type) {
        this(str, type, type == null ? AffiliationNamespace.basic : AffiliationNamespace.owner);
    }

    public Affiliation(String str, Type type, AffiliationNamespace affiliationNamespace) {
        this.node = (String) StringUtils.requireNotNullNorEmpty(str, "node must not be null nor empty");
        this.affiliation = type;
        this.jid = null;
        this.namespace = (AffiliationNamespace) Objects.requireNonNull(affiliationNamespace);
    }

    public Affiliation(BareJid bareJid, Type type) {
        this(bareJid, type, AffiliationNamespace.owner);
    }

    public Affiliation(BareJid bareJid, Type type, AffiliationNamespace affiliationNamespace) {
        this.jid = bareJid;
        this.affiliation = type;
        this.node = null;
        this.namespace = affiliationNamespace;
    }

    @Deprecated
    public String getNodeId() {
        return getNode();
    }

    public String getNode() {
        return this.node;
    }

    @Deprecated
    public Type getType() {
        return getAffiliation();
    }

    public Type getAffiliation() {
        return this.affiliation;
    }

    public BareJid getJid() {
        return this.jid;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "affiliation";
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return getPubSubNamespace().getXmlns();
    }

    public PubSubNamespace getPubSubNamespace() {
        return this.namespace.type.getNamespace();
    }

    public boolean isAffiliationModification() {
        return (this.jid == null || this.affiliation == null) ? false : true;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.optAttribute(NodeElement.ELEMENT, this.node);
        xmlStringBuilder.optAttribute("jid", this.jid);
        xmlStringBuilder.optAttribute("affiliation", this.affiliation);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
