package org.jxmpp.jid.impl;

import org.jxmpp.JxmppContext;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.DomainFullJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.EntityJid;
import org.jxmpp.jid.FullJid;
import org.jxmpp.jid.parts.Domainpart;
import org.jxmpp.jid.parts.Localpart;
import org.jxmpp.jid.parts.Resourcepart;
import org.jxmpp.stringprep.XmppStringprepException;

/* JADX INFO: loaded from: classes10.dex */
public final class DomainAndResourcepartJid extends AbstractJid implements DomainFullJid {
    private static final long serialVersionUID = 1;
    private final DomainBareJid domainBareJid;
    private final Resourcepart resource;

    @Override // org.jxmpp.jid.Jid
    public DomainFullJid asDomainFullJidIfPossible() {
        return this;
    }

    @Override // org.jxmpp.jid.Jid
    public EntityBareJid asEntityBareJidIfPossible() {
        return null;
    }

    @Override // org.jxmpp.jid.Jid
    public EntityFullJid asEntityFullJidIfPossible() {
        return null;
    }

    @Override // org.jxmpp.jid.Jid
    public EntityJid asEntityJidIfPossible() {
        return null;
    }

    @Override // org.jxmpp.jid.Jid
    public FullJid asFullJidIfPossible() {
        return this;
    }

    @Override // org.jxmpp.jid.impl.AbstractJid, org.jxmpp.jid.Jid
    public Localpart getLocalpartOrNull() {
        return null;
    }

    @Override // org.jxmpp.jid.impl.AbstractJid, org.jxmpp.jid.Jid
    public boolean hasNoResource() {
        return false;
    }

    @Override // org.jxmpp.jid.Jid
    public boolean isParentOf(DomainBareJid domainBareJid) {
        return false;
    }

    @Override // org.jxmpp.jid.Jid
    public boolean isParentOf(EntityBareJid entityBareJid) {
        return false;
    }

    @Override // org.jxmpp.jid.Jid
    public boolean isParentOf(EntityFullJid entityFullJid) {
        return false;
    }

    DomainAndResourcepartJid(String str, String str2, JxmppContext jxmppContext) throws XmppStringprepException {
        this(new DomainpartJid(str, jxmppContext), Resourcepart.from(str2, jxmppContext));
    }

    DomainAndResourcepartJid(DomainBareJid domainBareJid, Resourcepart resourcepart) {
        this.domainBareJid = (DomainBareJid) requireNonNull(domainBareJid, "The DomainBareJid must not be null");
        this.resource = (Resourcepart) requireNonNull(resourcepart, "The Resource must not be null");
    }

    @Override // org.jxmpp.jid.Jid, java.lang.CharSequence
    public String toString() {
        if (this.cache != null) {
            return this.cache;
        }
        this.cache = this.domainBareJid.toString() + '/' + ((Object) this.resource);
        return this.cache;
    }

    @Override // org.jxmpp.jid.Jid
    public DomainBareJid asDomainBareJid() {
        return this.domainBareJid;
    }

    @Override // org.jxmpp.jid.impl.AbstractJid, org.jxmpp.jid.Jid
    public Resourcepart getResourceOrNull() {
        return getResourcepart();
    }

    @Override // org.jxmpp.jid.Jid
    public boolean isParentOf(DomainFullJid domainFullJid) {
        return this.domainBareJid.equals((CharSequence) domainFullJid.getDomain()) && this.resource.equals(domainFullJid.getResourcepart());
    }

    @Override // org.jxmpp.jid.FullJid
    public Resourcepart getResourcepart() {
        return this.resource;
    }

    @Override // org.jxmpp.jid.Jid
    public BareJid asBareJid() {
        return asDomainBareJid();
    }

    @Override // org.jxmpp.jid.Jid
    public Domainpart getDomain() {
        return this.domainBareJid.getDomain();
    }

    @Override // org.jxmpp.jid.Jid
    public String asUnescapedString() {
        return toString();
    }
}
