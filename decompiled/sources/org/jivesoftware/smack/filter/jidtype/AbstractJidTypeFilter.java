package org.jivesoftware.smack.filter.jidtype;

import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.Objects;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractJidTypeFilter implements StanzaFilter {
    private final JidType jidType;

    protected abstract Jid getJidToMatchFrom(Stanza stanza);

    protected AbstractJidTypeFilter(JidType jidType) {
        this.jidType = (JidType) Objects.requireNonNull(jidType, "jidType must not be null");
    }

    @Override // org.jivesoftware.smack.filter.StanzaFilter
    public boolean accept(Stanza stanza) {
        Jid jidToMatchFrom = getJidToMatchFrom(stanza);
        if (jidToMatchFrom == null) {
            return false;
        }
        return this.jidType.isTypeOf(jidToMatchFrom);
    }

    public final String toString() {
        return getClass().getSimpleName() + ": " + this.jidType;
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.filter.jidtype.AbstractJidTypeFilter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$filter$jidtype$AbstractJidTypeFilter$JidType;

        static {
            int[] iArr = new int[JidType.values().length];
            $SwitchMap$org$jivesoftware$smack$filter$jidtype$AbstractJidTypeFilter$JidType = iArr;
            try {
                iArr[JidType.BareJid.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$filter$jidtype$AbstractJidTypeFilter$JidType[JidType.DomainBareJid.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$filter$jidtype$AbstractJidTypeFilter$JidType[JidType.DomainFullJid.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$filter$jidtype$AbstractJidTypeFilter$JidType[JidType.EntityBareJid.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$filter$jidtype$AbstractJidTypeFilter$JidType[JidType.EntityFullJid.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$filter$jidtype$AbstractJidTypeFilter$JidType[JidType.EntityJid.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$filter$jidtype$AbstractJidTypeFilter$JidType[JidType.FullJid.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public enum JidType {
        BareJid,
        DomainBareJid,
        DomainFullJid,
        DomainJid,
        EntityBareJid,
        EntityFullJid,
        EntityJid,
        FullJid;

        public boolean isTypeOf(Jid jid) {
            if (jid == null) {
                return false;
            }
            switch (AnonymousClass1.$SwitchMap$org$jivesoftware$smack$filter$jidtype$AbstractJidTypeFilter$JidType[ordinal()]) {
                case 1:
                    return jid.hasNoResource();
                case 2:
                    return jid.isDomainBareJid();
                case 3:
                    return jid.isDomainFullJid();
                case 4:
                    return jid.isEntityBareJid();
                case 5:
                    return jid.isEntityFullJid();
                case 6:
                    return jid.isEntityJid();
                case 7:
                    return jid.hasResource();
                default:
                    throw new IllegalStateException();
            }
        }
    }
}
