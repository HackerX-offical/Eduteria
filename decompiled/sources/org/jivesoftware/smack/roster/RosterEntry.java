package org.jivesoftware.smack.roster;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.PresenceBuilder;
import org.jivesoftware.smack.roster.packet.RosterPacket;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class RosterEntry extends Manager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private RosterPacket.Item item;
    private final Roster roster;

    RosterEntry(RosterPacket.Item item, Roster roster, XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.item = item;
        this.roster = roster;
    }

    @Deprecated
    public String getUser() {
        return getJid().toString();
    }

    public BareJid getJid() {
        return this.item.getJid();
    }

    public String getName() {
        return this.item.getName();
    }

    public synchronized void setName(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        if (str != null) {
            if (str.equals(getName())) {
                return;
            }
            RosterPacket rosterPacket = new RosterPacket();
            rosterPacket.setType(IQ.Type.set);
            rosterPacket.addRosterItem(toRosterItem(this, str));
            connection().createStanzaCollectorAndSend(rosterPacket).nextResultOrThrow();
            this.item.setName(str);
            return;
        }
        RosterPacket rosterPacket2 = new RosterPacket();
        rosterPacket2.setType(IQ.Type.set);
        rosterPacket2.addRosterItem(toRosterItem(this, str));
        connection().createStanzaCollectorAndSend(rosterPacket2).nextResultOrThrow();
        this.item.setName(str);
        return;
    }

    void updateItem(RosterPacket.Item item) {
        this.item = item;
    }

    public boolean isApproved() {
        return this.item.isApproved();
    }

    public List<RosterGroup> getGroups() {
        ArrayList arrayList = new ArrayList();
        for (RosterGroup rosterGroup : this.roster.getGroups()) {
            if (rosterGroup.contains(this)) {
                arrayList.add(rosterGroup);
            }
        }
        return arrayList;
    }

    public RosterPacket.ItemType getType() {
        return this.item.getItemType();
    }

    public boolean isSubscriptionPending() {
        return this.item.isSubscriptionPending();
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.roster.RosterEntry$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType;

        static {
            int[] iArr = new int[RosterPacket.ItemType.values().length];
            $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType = iArr;
            try {
                iArr[RosterPacket.ItemType.from.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType[RosterPacket.ItemType.both.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType[RosterPacket.ItemType.to.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public boolean canSeeMyPresence() {
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType[getType().ordinal()];
        return i == 1 || i == 2;
    }

    public boolean canSeeHisPresence() {
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType[getType().ordinal()];
        return i == 2 || i == 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void cancelSubscription() throws SmackException.NotConnectedException, InterruptedException {
        XMPPConnection xMPPConnectionConnection = connection();
        xMPPConnectionConnection.sendStanza(((PresenceBuilder) xMPPConnectionConnection.getStanzaFactory().buildPresenceStanza().to((Jid) this.item.getJid())).ofType(Presence.Type.unsubscribed).build());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getName() != null) {
            sb.append(getName()).append(": ");
        }
        sb.append((CharSequence) getJid());
        List<RosterGroup> groups = getGroups();
        if (!groups.isEmpty()) {
            sb.append(" [");
            Iterator<RosterGroup> it = groups.iterator();
            sb.append(it.next().getName());
            while (it.hasNext()) {
                sb.append(", ");
                sb.append(it.next().getName());
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public int hashCode() {
        return getJid().hashCode();
    }

    public boolean equals(Object obj) {
        return EqualsUtil.equals(this, obj, new EqualsUtil.EqualsComperator() { // from class: org.jivesoftware.smack.roster.RosterEntry$$ExternalSyntheticLambda1
            @Override // org.jivesoftware.smack.util.EqualsUtil.EqualsComperator
            public final void compare(EqualsUtil.Builder builder, Object obj2) {
                this.f$0.m14207lambda$equals$0$orgjivesoftwaresmackrosterRosterEntry(builder, (RosterEntry) obj2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$equals$0$org-jivesoftware-smack-roster-RosterEntry, reason: not valid java name */
    /* synthetic */ void m14207lambda$equals$0$orgjivesoftwaresmackrosterRosterEntry(EqualsUtil.Builder builder, RosterEntry rosterEntry) {
        builder.append(getJid(), rosterEntry.getJid());
    }

    public boolean equalsDeep(Object obj) {
        return EqualsUtil.equals(this, obj, new EqualsUtil.EqualsComperator() { // from class: org.jivesoftware.smack.roster.RosterEntry$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.util.EqualsUtil.EqualsComperator
            public final void compare(EqualsUtil.Builder builder, Object obj2) {
                this.f$0.m14208lambda$equalsDeep$1$orgjivesoftwaresmackrosterRosterEntry(builder, (RosterEntry) obj2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$equalsDeep$1$org-jivesoftware-smack-roster-RosterEntry, reason: not valid java name */
    /* synthetic */ void m14208lambda$equalsDeep$1$orgjivesoftwaresmackrosterRosterEntry(EqualsUtil.Builder builder, RosterEntry rosterEntry) {
        builder.append(this.item, rosterEntry.item);
    }

    static RosterPacket.Item toRosterItem(RosterEntry rosterEntry) {
        return toRosterItem(rosterEntry, rosterEntry.getName(), false);
    }

    static RosterPacket.Item toRosterItem(RosterEntry rosterEntry, String str) {
        return toRosterItem(rosterEntry, str, false);
    }

    static RosterPacket.Item toRosterItem(RosterEntry rosterEntry, boolean z) {
        return toRosterItem(rosterEntry, rosterEntry.getName(), z);
    }

    private static RosterPacket.Item toRosterItem(RosterEntry rosterEntry, String str, boolean z) {
        RosterPacket.Item item = new RosterPacket.Item(rosterEntry.getJid(), str);
        item.setItemType(rosterEntry.getType());
        if (z) {
            item.setSubscriptionPending(rosterEntry.isSubscriptionPending());
        }
        item.setApproved(rosterEntry.isApproved());
        Iterator<RosterGroup> it = rosterEntry.getGroups().iterator();
        while (it.hasNext()) {
            item.addGroupName(it.next().getName());
        }
        return item;
    }
}
