package org.jxmpp.jid.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.DomainFullJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.EntityJid;
import org.jxmpp.jid.FullJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.parts.Localpart;
import org.jxmpp.jid.parts.Resourcepart;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractJid implements Jid {
    private static final long serialVersionUID = 1;
    protected String cache;
    private transient String internalizedCache;
    private transient String urlEncodedCache;

    @Override // org.jxmpp.jid.Jid
    public abstract Localpart getLocalpartOrNull();

    @Override // org.jxmpp.jid.Jid
    public abstract Resourcepart getResourceOrNull();

    @Override // org.jxmpp.jid.Jid
    public abstract boolean hasNoResource();

    @Override // org.jxmpp.jid.Jid
    public final boolean isEntityJid() {
        return isEntityBareJid() || isEntityFullJid();
    }

    @Override // org.jxmpp.jid.Jid
    public final boolean isEntityBareJid() {
        return this instanceof EntityBareJid;
    }

    @Override // org.jxmpp.jid.Jid
    public final boolean isEntityFullJid() {
        return this instanceof EntityFullJid;
    }

    @Override // org.jxmpp.jid.Jid
    public final boolean isDomainBareJid() {
        return this instanceof DomainBareJid;
    }

    @Override // org.jxmpp.jid.Jid
    public final boolean isDomainFullJid() {
        return this instanceof DomainFullJid;
    }

    @Override // org.jxmpp.jid.Jid
    public final boolean hasResource() {
        return this instanceof FullJid;
    }

    @Override // org.jxmpp.jid.Jid
    public final boolean hasLocalpart() {
        return this instanceof EntityJid;
    }

    @Override // org.jxmpp.jid.Jid
    public final <T extends Jid> T downcast(Class<T> cls) {
        return cls.cast(this);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return toString().length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return toString().charAt(i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return toString().subSequence(i, i2);
    }

    @Override // org.jxmpp.jid.Jid
    public final EntityBareJid asEntityBareJidOrThrow() {
        EntityBareJid entityBareJidAsEntityBareJidIfPossible = asEntityBareJidIfPossible();
        if (entityBareJidAsEntityBareJidIfPossible == null) {
            throwIse("can not be converted to EntityBareJid");
        }
        return entityBareJidAsEntityBareJidIfPossible;
    }

    @Override // org.jxmpp.jid.Jid
    public EntityFullJid asEntityFullJidOrThrow() {
        EntityFullJid entityFullJidAsEntityFullJidIfPossible = asEntityFullJidIfPossible();
        if (entityFullJidAsEntityFullJidIfPossible == null) {
            throwIse("can not be converted to EntityFullJid");
        }
        return entityFullJidAsEntityFullJidIfPossible;
    }

    @Override // org.jxmpp.jid.Jid
    public EntityJid asEntityJidOrThrow() {
        EntityJid entityJidAsEntityJidIfPossible = asEntityJidIfPossible();
        if (entityJidAsEntityJidIfPossible == null) {
            throwIse("can not be converted to EntityJid");
        }
        return entityJidAsEntityJidIfPossible;
    }

    @Override // org.jxmpp.jid.Jid
    public EntityFullJid asFullJidOrThrow() {
        EntityFullJid entityFullJidAsEntityFullJidIfPossible = asEntityFullJidIfPossible();
        if (entityFullJidAsEntityFullJidIfPossible == null) {
            throwIse("can not be converted to EntityBareJid");
        }
        return entityFullJidAsEntityFullJidIfPossible;
    }

    @Override // org.jxmpp.jid.Jid
    public DomainFullJid asDomainFullJidOrThrow() {
        DomainFullJid domainFullJidAsDomainFullJidIfPossible = asDomainFullJidIfPossible();
        if (domainFullJidAsDomainFullJidIfPossible == null) {
            throwIse("can not be converted to DomainFullJid");
        }
        return domainFullJidAsDomainFullJidIfPossible;
    }

    @Override // org.jxmpp.jid.Jid
    public final Resourcepart getResourceOrEmpty() {
        Resourcepart resourceOrNull = getResourceOrNull();
        return resourceOrNull == null ? Resourcepart.EMPTY : resourceOrNull;
    }

    @Override // org.jxmpp.jid.Jid
    public final Resourcepart getResourceOrThrow() {
        Resourcepart resourceOrNull = getResourceOrNull();
        if (resourceOrNull == null) {
            throwIse("has no resourcepart");
        }
        return resourceOrNull;
    }

    @Override // org.jxmpp.jid.Jid
    public final Localpart getLocalpartOrThrow() {
        Localpart localpartOrNull = getLocalpartOrNull();
        if (localpartOrNull == null) {
            throwIse("has no localpart");
        }
        return localpartOrNull;
    }

    @Override // org.jxmpp.jid.Jid
    public final boolean isParentOf(Jid jid) {
        EntityFullJid entityFullJidAsEntityFullJidIfPossible = jid.asEntityFullJidIfPossible();
        if (entityFullJidAsEntityFullJidIfPossible != null) {
            return isParentOf(entityFullJidAsEntityFullJidIfPossible);
        }
        EntityBareJid entityBareJidAsEntityBareJidIfPossible = jid.asEntityBareJidIfPossible();
        if (entityBareJidAsEntityBareJidIfPossible != null) {
            return isParentOf(entityBareJidAsEntityBareJidIfPossible);
        }
        DomainFullJid domainFullJidAsDomainFullJidIfPossible = jid.asDomainFullJidIfPossible();
        if (domainFullJidAsDomainFullJidIfPossible != null) {
            return isParentOf(domainFullJidAsDomainFullJidIfPossible);
        }
        return isParentOf(jid.asDomainBareJid());
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof CharSequence) {
            return equals((CharSequence) obj);
        }
        return false;
    }

    @Override // org.jxmpp.jid.Jid
    public final boolean equals(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        return equals(charSequence.toString());
    }

    @Override // org.jxmpp.jid.Jid
    public final boolean equals(String str) {
        return toString().equals(str);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Jid jid) {
        return toString().compareTo(jid.toString());
    }

    @Override // org.jxmpp.jid.Jid
    public final String intern() {
        if (this.internalizedCache == null) {
            String strIntern = toString().intern();
            this.internalizedCache = strIntern;
            this.cache = strIntern;
        }
        return this.internalizedCache;
    }

    @Override // org.jxmpp.jid.Jid
    public final String asUrlEncodedString() {
        if (this.urlEncodedCache == null) {
            try {
                this.urlEncodedCache = URLEncoder.encode(toString(), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
        return this.urlEncodedCache;
    }

    private void throwIse(String str) {
        throw new IllegalStateException("The JID '" + ((Object) this) + "' " + str);
    }

    static <O> O requireNonNull(O o, String str) {
        if (o != null) {
            return o;
        }
        throw new IllegalArgumentException(str);
    }
}
