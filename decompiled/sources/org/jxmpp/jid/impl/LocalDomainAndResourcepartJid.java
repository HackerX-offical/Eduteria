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
public final class LocalDomainAndResourcepartJid extends AbstractJid implements EntityFullJid {
    private static final long serialVersionUID = 1;
    private final EntityBareJid bareJid;
    private final Resourcepart resource;
    private String unescapedCache;

    @Override // org.jxmpp.jid.Jid
    public DomainFullJid asDomainFullJidIfPossible() {
        return null;
    }

    @Override // org.jxmpp.jid.Jid
    public EntityFullJid asEntityFullJidIfPossible() {
        return this;
    }

    @Override // org.jxmpp.jid.Jid
    public EntityJid asEntityJidIfPossible() {
        return this;
    }

    @Override // org.jxmpp.jid.Jid
    public FullJid asFullJidIfPossible() {
        return this;
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
    public boolean isParentOf(DomainFullJid domainFullJid) {
        return false;
    }

    @Override // org.jxmpp.jid.Jid
    public boolean isParentOf(EntityBareJid entityBareJid) {
        return false;
    }

    LocalDomainAndResourcepartJid(String str, String str2, String str3, JxmppContext jxmppContext) throws XmppStringprepException {
        this(new LocalAndDomainpartJid(str, str2, jxmppContext), Resourcepart.from(str3, jxmppContext));
    }

    LocalDomainAndResourcepartJid(EntityBareJid entityBareJid, Resourcepart resourcepart) {
        this.bareJid = (EntityBareJid) requireNonNull(entityBareJid, "The EntityBareJid must not be null");
        this.resource = (Resourcepart) requireNonNull(resourcepart, "The Resourcepart must not be null");
    }

    @Override // org.jxmpp.jid.Jid, java.lang.CharSequence
    public String toString() {
        if (this.cache != null) {
            return this.cache;
        }
        this.cache = this.bareJid.toString() + '/' + ((Object) this.resource);
        return this.cache;
    }

    @Override // org.jxmpp.jid.Jid
    public String asUnescapedString() {
        String str = this.unescapedCache;
        if (str != null) {
            return str;
        }
        String str2 = this.bareJid.asUnescapedString() + '/' + ((Object) this.resource);
        this.unescapedCache = str2;
        return str2;
    }

    @Override // org.jxmpp.jid.EntityJid
    public EntityBareJid asEntityBareJid() {
        return this.bareJid;
    }

    @Override // org.jxmpp.jid.EntityJid
    public String asEntityBareJidString() {
        return asEntityBareJid().toString();
    }

    @Override // org.jxmpp.jid.Jid
    public EntityBareJid asEntityBareJidIfPossible() {
        return asEntityBareJid();
    }

    @Override // org.jxmpp.jid.impl.AbstractJid, org.jxmpp.jid.Jid
    public Localpart getLocalpartOrNull() {
        return this.bareJid.getLocalpart();
    }

    @Override // org.jxmpp.jid.impl.AbstractJid, org.jxmpp.jid.Jid
    public Resourcepart getResourceOrNull() {
        return getResourcepart();
    }

    @Override // org.jxmpp.jid.Jid
    public boolean isParentOf(EntityFullJid entityFullJid) {
        return equals((CharSequence) entityFullJid);
    }

    @Override // org.jxmpp.jid.Jid
    public DomainBareJid asDomainBareJid() {
        return this.bareJid.asDomainBareJid();
    }

    @Override // org.jxmpp.jid.FullJid
    public Resourcepart getResourcepart() {
        return this.resource;
    }

    @Override // org.jxmpp.jid.Jid
    public BareJid asBareJid() {
        return asEntityBareJid();
    }

    @Override // org.jxmpp.jid.Jid
    public Domainpart getDomain() {
        return this.bareJid.getDomain();
    }

    @Override // org.jxmpp.jid.EntityJid
    public Localpart getLocalpart() {
        return this.bareJid.getLocalpart();
    }
}
