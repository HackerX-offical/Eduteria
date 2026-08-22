package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.filter.AbstractJidTypeFilter;
import org.jivesoftware.smack.packet.Stanza;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractPossibleJidTypeFilter extends AbstractJidTypeFilter {
    protected AbstractPossibleJidTypeFilter(AbstractJidTypeFilter.JidType jidType) {
        super(jidType);
    }

    @Override // org.jivesoftware.smack.filter.StanzaFilter
    public final boolean accept(Stanza stanza) {
        Jid jidToInspect = getJidToInspect(stanza);
        if (jidToInspect == null) {
            return false;
        }
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$filter$AbstractJidTypeFilter$JidType[this.jidType.ordinal()];
        if (i == 1) {
            return jidToInspect.asEntityFullJidIfPossible() != null;
        }
        if (i == 2) {
            return jidToInspect.asEntityBareJidIfPossible() != null;
        }
        if (i == 3) {
            return jidToInspect.asDomainFullJidIfPossible() != null;
        }
        if (i == 4 || i == 5) {
            return true;
        }
        throw new AssertionError();
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.filter.AbstractPossibleJidTypeFilter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$filter$AbstractJidTypeFilter$JidType;

        static {
            int[] iArr = new int[AbstractJidTypeFilter.JidType.values().length];
            $SwitchMap$org$jivesoftware$smack$filter$AbstractJidTypeFilter$JidType = iArr;
            try {
                iArr[AbstractJidTypeFilter.JidType.entityFull.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$filter$AbstractJidTypeFilter$JidType[AbstractJidTypeFilter.JidType.entityBare.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$filter$AbstractJidTypeFilter$JidType[AbstractJidTypeFilter.JidType.domainFull.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$filter$AbstractJidTypeFilter$JidType[AbstractJidTypeFilter.JidType.domainBare.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$filter$AbstractJidTypeFilter$JidType[AbstractJidTypeFilter.JidType.any.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
