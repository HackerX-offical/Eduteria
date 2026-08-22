package org.jivesoftware.smack.roster.packet;

import com.appnew.android.Utils.Const;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.roster.packet.RosterPacket;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.HashCode;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.BareJid;

/* JADX INFO: loaded from: classes10.dex */
public final class RosterPacket extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "jabber:iq:roster";
    private final List<Item> rosterItems;
    private String rosterVersion;

    public RosterPacket() {
        super("query", NAMESPACE);
        this.rosterItems = new ArrayList();
    }

    public void addRosterItem(Item item) {
        synchronized (this.rosterItems) {
            this.rosterItems.add(item);
        }
    }

    public int getRosterItemCount() {
        int size;
        synchronized (this.rosterItems) {
            size = this.rosterItems.size();
        }
        return size;
    }

    public List<Item> getRosterItems() {
        ArrayList arrayList;
        synchronized (this.rosterItems) {
            arrayList = new ArrayList(this.rosterItems);
        }
        return arrayList;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.optAttribute(RosterVer.ELEMENT, this.rosterVersion);
        iQChildElementXmlStringBuilder.rightAngleBracket();
        synchronized (this.rosterItems) {
            Iterator<Item> it = this.rosterItems.iterator();
            while (it.hasNext()) {
                iQChildElementXmlStringBuilder.append(it.next().toXML());
            }
        }
        return iQChildElementXmlStringBuilder;
    }

    public String getVersion() {
        return this.rosterVersion;
    }

    public void setVersion(String str) {
        this.rosterVersion = str;
    }

    public static final class Item implements ExtensionElement {
        public static final String ELEMENT = "item";
        public static final String GROUP = "group";
        public static final QName QNAME = new QName(RosterPacket.NAMESPACE, "item");
        private boolean approved;
        private final Set<String> groupNames;
        private ItemType itemType;
        private final BareJid jid;
        private String name;
        private boolean subscriptionPending;

        public Item(BareJid bareJid, String str) {
            this(bareJid, str, false);
        }

        public Item(BareJid bareJid, String str, boolean z) {
            this.itemType = ItemType.none;
            this.jid = (BareJid) Objects.requireNonNull(bareJid);
            this.name = str;
            this.subscriptionPending = z;
            this.groupNames = new CopyOnWriteArraySet();
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return QNAME.getLocalPart();
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return QNAME.getNamespaceURI();
        }

        @Deprecated
        public String getUser() {
            return this.jid.toString();
        }

        public BareJid getJid() {
            return this.jid;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public ItemType getItemType() {
            return this.itemType;
        }

        public void setItemType(ItemType itemType) {
            this.itemType = (ItemType) Objects.requireNonNull(itemType, "itemType must not be null");
        }

        public void setSubscriptionPending(boolean z) {
            this.subscriptionPending = z;
        }

        public boolean isSubscriptionPending() {
            return this.subscriptionPending;
        }

        public boolean isApproved() {
            return this.approved;
        }

        public void setApproved(boolean z) {
            this.approved = z;
        }

        public Set<String> getGroupNames() {
            return Collections.unmodifiableSet(this.groupNames);
        }

        public void addGroupName(String str) {
            this.groupNames.add(str);
        }

        public void removeGroupName(String str) {
            this.groupNames.remove(str);
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("jid", this.jid);
            xmlStringBuilder.optAttribute("name", this.name);
            xmlStringBuilder.optAttribute(Const.SUBSCRIPTION, this.itemType);
            if (this.subscriptionPending) {
                xmlStringBuilder.append((CharSequence) " ask='subscribe'");
            }
            xmlStringBuilder.optBooleanAttribute("approved", this.approved);
            xmlStringBuilder.rightAngleBracket();
            Iterator<String> it = this.groupNames.iterator();
            while (it.hasNext()) {
                xmlStringBuilder.openElement("group").escape(it.next()).closeElement("group");
            }
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }

        public int hashCode() {
            return HashCode.builder().append(this.groupNames).append(this.subscriptionPending).append(this.itemType).append(this.name).append(this.jid).append(this.approved).build();
        }

        public boolean equals(Object obj) {
            return EqualsUtil.equals(this, obj, new EqualsUtil.EqualsComperator() { // from class: org.jivesoftware.smack.roster.packet.RosterPacket$Item$$ExternalSyntheticLambda0
                @Override // org.jivesoftware.smack.util.EqualsUtil.EqualsComperator
                public final void compare(EqualsUtil.Builder builder, Object obj2) {
                    this.f$0.m14209x63b2cc30(builder, (RosterPacket.Item) obj2);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$equals$0$org-jivesoftware-smack-roster-packet-RosterPacket$Item, reason: not valid java name */
        /* synthetic */ void m14209x63b2cc30(EqualsUtil.Builder builder, Item item) {
            builder.append(this.groupNames, item.groupNames).append(this.subscriptionPending, item.subscriptionPending).append(this.itemType, item.itemType).append(this.name, item.name).append(this.jid, item.jid).append(this.approved, item.approved);
        }
    }

    public enum ItemType {
        none(8869),
        to(8592),
        from(8594),
        both(8596),
        remove(9889);

        private static final char ME = 9679;
        private final String symbol;

        ItemType(char c2) {
            StringBuilder sb = new StringBuilder(2);
            sb.append(ME).append(c2);
            this.symbol = sb.toString();
        }

        public static ItemType fromString(String str) {
            if (StringUtils.isNullOrEmpty(str)) {
                return none;
            }
            return valueOf(str.toLowerCase(Locale.US));
        }

        public String asSymbol() {
            return this.symbol;
        }
    }
}
