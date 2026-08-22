package org.jxmpp.jid.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.jxmpp.JxmppContext;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.DomainFullJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.EntityJid;
import org.jxmpp.jid.FullJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.parts.Domainpart;
import org.jxmpp.jid.parts.Localpart;
import org.jxmpp.jid.parts.Resourcepart;
import org.jxmpp.stringprep.XmppStringprepException;
import org.jxmpp.util.XmppStringUtils;
import org.jxmpp.util.cache.Cache;
import org.jxmpp.util.cache.LruCache;

/* JADX INFO: loaded from: classes10.dex */
public class JidCreate {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Cache<String, Jid> JID_CACHE = new LruCache(100);
    private static final Cache<String, BareJid> BAREJID_CACHE = new LruCache(100);
    private static final Cache<String, EntityJid> ENTITYJID_CACHE = new LruCache(100);
    private static final Cache<String, FullJid> FULLJID_CACHE = new LruCache(100);
    private static final Cache<String, EntityBareJid> ENTITY_BAREJID_CACHE = new LruCache(100);
    private static final Cache<String, EntityFullJid> ENTITY_FULLJID_CACHE = new LruCache(100);
    private static final Cache<String, DomainBareJid> DOMAINJID_CACHE = new LruCache(100);
    private static final Cache<String, DomainFullJid> DOMAINRESOURCEJID_CACHE = new LruCache(100);

    public static Jid from(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) throws XmppStringprepException {
        return from(charSequence.toString(), charSequence2.toString(), charSequence3.toString());
    }

    public static Jid from(String str, String str2, String str3) throws XmppStringprepException {
        return from(str, str2, str3, JxmppContext.getDefaultContext());
    }

    public static Jid from(String str, String str2, String str3, JxmppContext jxmppContext) throws XmppStringprepException {
        Jid domainAndResourcepartJid;
        Jid jidLookup;
        if (str2.isEmpty()) {
            throw XmppStringprepException.MissingDomainpart.from(str, str3);
        }
        String strCompleteJidFrom = XmppStringUtils.completeJidFrom(str, str2, str3);
        if (jxmppContext.isCachingEnabled() && (jidLookup = JID_CACHE.lookup(strCompleteJidFrom)) != null) {
            return jidLookup;
        }
        if (str != null && str3 != null) {
            domainAndResourcepartJid = new LocalDomainAndResourcepartJid(str, str2, str3, jxmppContext);
        } else if (str != null && str3 == null) {
            domainAndResourcepartJid = new LocalAndDomainpartJid(str, str2, jxmppContext);
        } else if (str == null && str3 == null) {
            domainAndResourcepartJid = new DomainpartJid(str2, jxmppContext);
        } else {
            domainAndResourcepartJid = (str != null || str3 == null) ? null : new DomainAndResourcepartJid(str2, str3, jxmppContext);
        }
        if (jxmppContext.isCachingEnabled()) {
            JID_CACHE.put(strCompleteJidFrom, domainAndResourcepartJid);
        }
        return domainAndResourcepartJid;
    }

    public static Jid fromOrThrowUnchecked(CharSequence charSequence) {
        try {
            return from(charSequence);
        } catch (XmppStringprepException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static Jid from(CharSequence charSequence) throws XmppStringprepException {
        return from(charSequence.toString());
    }

    public static Jid from(String str) throws XmppStringprepException {
        return from(str, JxmppContext.getDefaultContext());
    }

    public static Jid from(String str, JxmppContext jxmppContext) throws XmppStringprepException {
        try {
            return from(XmppStringUtils.parseLocalpart(str), XmppStringUtils.parseDomain(str), XmppStringUtils.parseResource(str), jxmppContext);
        } catch (XmppStringprepException e2) {
            throw new XmppStringprepException(str, e2);
        }
    }

    public static Jid fromOrNull(CharSequence charSequence) {
        try {
            return from(charSequence);
        } catch (XmppStringprepException unused) {
            return null;
        }
    }

    public static Jid fromUnescapedOrThrowUnchecked(CharSequence charSequence) {
        try {
            return fromUnescaped(charSequence);
        } catch (XmppStringprepException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static Jid fromUnescaped(CharSequence charSequence) throws XmppStringprepException {
        return fromUnescaped(charSequence.toString());
    }

    public static Jid fromUnescaped(String str) throws XmppStringprepException {
        try {
            return from(XmppStringUtils.escapeLocalpart(XmppStringUtils.parseLocalpart(str)), XmppStringUtils.parseDomain(str), XmppStringUtils.parseResource(str));
        } catch (XmppStringprepException e2) {
            throw new XmppStringprepException(str, e2);
        }
    }

    public static Jid fromUnescapedOrNull(CharSequence charSequence) {
        try {
            return fromUnescaped(charSequence);
        } catch (XmppStringprepException unused) {
            return null;
        }
    }

    public static Jid fromUrlEncoded(CharSequence charSequence) throws XmppStringprepException {
        return from(urlDecode(charSequence));
    }

    public static BareJid bareFromOrThrowUnchecked(CharSequence charSequence) {
        try {
            return bareFrom(charSequence);
        } catch (XmppStringprepException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static BareJid bareFrom(CharSequence charSequence) throws XmppStringprepException {
        return bareFrom(charSequence.toString());
    }

    public static BareJid bareFrom(String str) throws XmppStringprepException {
        return bareFrom(str, JxmppContext.getDefaultContext());
    }

    public static BareJid bareFrom(String str, JxmppContext jxmppContext) throws XmppStringprepException {
        BareJid localAndDomainpartJid;
        BareJid bareJidLookup;
        if (jxmppContext.isCachingEnabled() && (bareJidLookup = BAREJID_CACHE.lookup(str)) != null) {
            return bareJidLookup;
        }
        String localpart = XmppStringUtils.parseLocalpart(str);
        String domain = XmppStringUtils.parseDomain(str);
        if (localpart != null) {
            try {
                if (localpart.length() == 0) {
                    localAndDomainpartJid = new DomainpartJid(domain, jxmppContext);
                } else {
                    localAndDomainpartJid = new LocalAndDomainpartJid(localpart, domain, jxmppContext);
                }
            } catch (XmppStringprepException e2) {
                throw new XmppStringprepException(str, e2);
            }
        } else {
            localAndDomainpartJid = new DomainpartJid(domain, jxmppContext);
        }
        if (jxmppContext.isCachingEnabled()) {
            BAREJID_CACHE.put(str, localAndDomainpartJid);
        }
        return localAndDomainpartJid;
    }

    public static BareJid bareFrom(Localpart localpart, DomainBareJid domainBareJid) {
        return bareFrom(localpart, domainBareJid.getDomain());
    }

    public static BareJid bareFrom(Localpart localpart, Domainpart domainpart) {
        if (localpart != null) {
            return new LocalAndDomainpartJid(localpart, domainpart);
        }
        return new DomainpartJid(domainpart);
    }

    public static BareJid bareFromOrNull(CharSequence charSequence) {
        try {
            return bareFrom(charSequence);
        } catch (XmppStringprepException unused) {
            return null;
        }
    }

    public static BareJid bareFromUrlEncoded(CharSequence charSequence) throws XmppStringprepException {
        return bareFrom(urlDecode(charSequence.toString()));
    }

    public static FullJid fullFromOrThrowUnchecked(CharSequence charSequence) {
        try {
            return fullFrom(charSequence);
        } catch (XmppStringprepException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static FullJid fullFrom(CharSequence charSequence) throws XmppStringprepException {
        return fullFrom(charSequence.toString());
    }

    public static FullJid fullFrom(String str) throws XmppStringprepException {
        Cache<String, FullJid> cache = FULLJID_CACHE;
        FullJid fullJidLookup = cache.lookup(str);
        if (fullJidLookup != null) {
            return fullJidLookup;
        }
        try {
            FullJid fullJidFullFrom = fullFrom(XmppStringUtils.parseLocalpart(str), XmppStringUtils.parseDomain(str), XmppStringUtils.parseResource(str));
            cache.put(str, fullJidFullFrom);
            return fullJidFullFrom;
        } catch (XmppStringprepException e2) {
            throw new XmppStringprepException(str, e2);
        }
    }

    public static FullJid fullFrom(String str, String str2, String str3) throws XmppStringprepException {
        return fullFrom(str, str2, str3, JxmppContext.getDefaultContext());
    }

    public static FullJid fullFrom(String str, String str2, String str3, JxmppContext jxmppContext) throws XmppStringprepException {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    return new LocalDomainAndResourcepartJid(str, str2, str3, jxmppContext);
                }
            } catch (XmppStringprepException e2) {
                throw new XmppStringprepException(str + '@' + str2 + '/' + str3, e2);
            }
        }
        return new DomainAndResourcepartJid(str2, str3, jxmppContext);
    }

    public static FullJid fullFrom(Localpart localpart, DomainBareJid domainBareJid, Resourcepart resourcepart) {
        return fullFrom(localpart, domainBareJid.getDomain(), resourcepart);
    }

    public static FullJid fullFrom(Localpart localpart, Domainpart domainpart, Resourcepart resourcepart) {
        return fullFrom(entityBareFrom(localpart, domainpart), resourcepart);
    }

    public static FullJid fullFrom(BareJid bareJid, Resourcepart resourcepart) {
        if (bareJid.isEntityBareJid()) {
            return new LocalDomainAndResourcepartJid((EntityBareJid) bareJid, resourcepart);
        }
        return new DomainAndResourcepartJid((DomainBareJid) bareJid, resourcepart);
    }

    public static FullJid fullFromOrNull(CharSequence charSequence) {
        try {
            return fullFrom(charSequence);
        } catch (XmppStringprepException unused) {
            return null;
        }
    }

    public static FullJid fullFromUrlEncoded(CharSequence charSequence) throws XmppStringprepException {
        return fullFrom(urlDecode(charSequence));
    }

    public static EntityJid entityFromOrThrowUnchecked(CharSequence charSequence) {
        try {
            return entityFrom(charSequence);
        } catch (XmppStringprepException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static EntityJid entityFrom(CharSequence charSequence) throws XmppStringprepException {
        return entityFrom(charSequence.toString());
    }

    public static EntityJid entityFrom(String str) throws XmppStringprepException {
        return entityFrom(str, false);
    }

    public static EntityJid entityFromUnescapedOrThrowUnchecked(CharSequence charSequence) {
        try {
            return entityFromUnescaped(charSequence);
        } catch (XmppStringprepException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static EntityJid entityFromUnescaped(CharSequence charSequence) throws XmppStringprepException {
        return entityFromUnescaped(charSequence.toString());
    }

    public static EntityJid entityFromUnescaped(String str) throws XmppStringprepException {
        return entityFrom(str, true);
    }

    @Deprecated
    public static EntityJid entityFromUnesacpedOrNull(CharSequence charSequence) {
        return entityFromUnescapedOrNull(charSequence);
    }

    public static EntityJid entityFromUnescapedOrNull(CharSequence charSequence) {
        try {
            return entityFromUnescaped(charSequence.toString());
        } catch (XmppStringprepException unused) {
            return null;
        }
    }

    private static EntityJid entityFrom(String str, boolean z) throws XmppStringprepException {
        Localpart localpartFrom;
        EntityJid entityJidEntityFullFrom;
        Cache<String, EntityJid> cache = ENTITYJID_CACHE;
        EntityJid entityJidLookup = cache.lookup(str);
        if (entityJidLookup != null) {
            return entityJidLookup;
        }
        String localpart = XmppStringUtils.parseLocalpart(str);
        if (localpart == null) {
            throw new XmppStringprepException("Does not contain a localpart", str);
        }
        try {
            if (z) {
                localpartFrom = Localpart.fromUnescaped(localpart);
            } else {
                localpartFrom = Localpart.from(localpart);
            }
            try {
                Domainpart domainpartFrom = Domainpart.from(XmppStringUtils.parseDomain(str));
                String resource = XmppStringUtils.parseResource(str);
                if (resource != null) {
                    try {
                        entityJidEntityFullFrom = entityFullFrom(localpartFrom, domainpartFrom, Resourcepart.from(resource));
                    } catch (XmppStringprepException e2) {
                        throw new XmppStringprepException(str, e2);
                    }
                } else {
                    entityJidEntityFullFrom = entityBareFrom(localpartFrom, domainpartFrom);
                }
                cache.put(str, entityJidEntityFullFrom);
                return entityJidEntityFullFrom;
            } catch (XmppStringprepException e3) {
                throw new XmppStringprepException(str, e3);
            }
        } catch (XmppStringprepException e4) {
            throw new XmppStringprepException(str, e4);
        }
    }

    public static EntityJid entityFromOrNull(CharSequence charSequence) {
        try {
            return entityFrom(charSequence);
        } catch (XmppStringprepException unused) {
            return null;
        }
    }

    public static EntityJid entityFromUrlEncoded(CharSequence charSequence) throws XmppStringprepException {
        return entityFrom(urlDecode(charSequence));
    }

    public static EntityBareJid entityBareFromOrThrowUnchecked(CharSequence charSequence) {
        try {
            return entityBareFrom(charSequence);
        } catch (XmppStringprepException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static EntityBareJid entityBareFrom(CharSequence charSequence) throws XmppStringprepException {
        return entityBareFrom(charSequence.toString());
    }

    public static EntityBareJid entityBareFrom(String str) throws XmppStringprepException {
        return entityBareFrom(str, JxmppContext.getDefaultContext());
    }

    public static EntityBareJid entityBareFrom(String str, JxmppContext jxmppContext) throws XmppStringprepException {
        EntityBareJid entityBareJidLookup;
        if (jxmppContext.isCachingEnabled() && (entityBareJidLookup = ENTITY_BAREJID_CACHE.lookup(str)) != null) {
            return entityBareJidLookup;
        }
        try {
            LocalAndDomainpartJid localAndDomainpartJid = new LocalAndDomainpartJid(XmppStringUtils.parseLocalpart(str), XmppStringUtils.parseDomain(str), jxmppContext);
            if (jxmppContext.isCachingEnabled()) {
                ENTITY_BAREJID_CACHE.put(str, localAndDomainpartJid);
            }
            return localAndDomainpartJid;
        } catch (XmppStringprepException e2) {
            throw new XmppStringprepException(str, e2);
        }
    }

    public static EntityBareJid entityBareFromUnescapedOrThrowUnchecked(CharSequence charSequence) {
        try {
            return entityBareFromUnescaped(charSequence);
        } catch (XmppStringprepException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static EntityBareJid entityBareFromUnescaped(CharSequence charSequence) throws XmppStringprepException {
        return entityBareFromUnescaped(charSequence.toString());
    }

    public static EntityBareJid entityBareFromUnescaped(String str) throws XmppStringprepException {
        return entityBareFromUnescaped(str, JxmppContext.getDefaultContext());
    }

    public static EntityBareJid entityBareFromUnescaped(String str, JxmppContext jxmppContext) throws XmppStringprepException {
        EntityBareJid entityBareJidLookup;
        if (jxmppContext.isCachingEnabled() && (entityBareJidLookup = ENTITY_BAREJID_CACHE.lookup(str)) != null) {
            return entityBareJidLookup;
        }
        try {
            LocalAndDomainpartJid localAndDomainpartJid = new LocalAndDomainpartJid(XmppStringUtils.escapeLocalpart(XmppStringUtils.parseLocalpart(str)), XmppStringUtils.parseDomain(str), jxmppContext);
            if (jxmppContext.isCachingEnabled()) {
                ENTITY_BAREJID_CACHE.put(str, localAndDomainpartJid);
            }
            return localAndDomainpartJid;
        } catch (XmppStringprepException e2) {
            throw new XmppStringprepException(str, e2);
        }
    }

    public static EntityBareJid entityBareFromUnescapedOrNull(CharSequence charSequence) {
        try {
            return entityBareFromUnescaped(charSequence.toString());
        } catch (XmppStringprepException unused) {
            return null;
        }
    }

    public static EntityBareJid entityBareFrom(Localpart localpart, DomainBareJid domainBareJid) {
        return entityBareFrom(localpart, domainBareJid.getDomain());
    }

    public static EntityBareJid entityBareFrom(Localpart localpart, Domainpart domainpart) {
        return new LocalAndDomainpartJid(localpart, domainpart);
    }

    public static EntityBareJid entityBareFromOrNull(CharSequence charSequence) {
        try {
            return entityBareFrom(charSequence);
        } catch (XmppStringprepException unused) {
            return null;
        }
    }

    public static EntityBareJid entityBareFromUrlEncoded(CharSequence charSequence) throws XmppStringprepException {
        return entityBareFrom(urlDecode(charSequence));
    }

    public static EntityFullJid entityFullFromOrThrowUnchecked(CharSequence charSequence) {
        try {
            return entityFullFrom(charSequence);
        } catch (XmppStringprepException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static EntityFullJid entityFullFrom(CharSequence charSequence) throws XmppStringprepException {
        return entityFullFrom(charSequence.toString());
    }

    public static EntityFullJid entityFullFrom(String str) throws XmppStringprepException {
        Cache<String, EntityFullJid> cache = ENTITY_FULLJID_CACHE;
        EntityFullJid entityFullJidLookup = cache.lookup(str);
        if (entityFullJidLookup != null) {
            return entityFullJidLookup;
        }
        try {
            EntityFullJid entityFullJidEntityFullFrom = entityFullFrom(XmppStringUtils.parseLocalpart(str), XmppStringUtils.parseDomain(str), XmppStringUtils.parseResource(str));
            cache.put(str, entityFullJidEntityFullFrom);
            return entityFullJidEntityFullFrom;
        } catch (XmppStringprepException e2) {
            throw new XmppStringprepException(str, e2);
        }
    }

    public static EntityFullJid entityFullFromOrNull(CharSequence charSequence) {
        try {
            return entityFullFrom(charSequence);
        } catch (XmppStringprepException unused) {
            return null;
        }
    }

    public static EntityFullJid entityFullFromUnescapedOrThrowUnchecked(CharSequence charSequence) {
        try {
            return entityFullFromUnescaped(charSequence);
        } catch (XmppStringprepException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static EntityFullJid entityFullFromUnescaped(CharSequence charSequence) throws XmppStringprepException {
        return entityFullFromUnescaped(charSequence.toString());
    }

    public static EntityFullJid entityFullFromUnescaped(String str) throws XmppStringprepException {
        return entityFullFromUnescaped(str, JxmppContext.getDefaultContext());
    }

    public static EntityFullJid entityFullFromUnescaped(String str, JxmppContext jxmppContext) throws XmppStringprepException {
        EntityFullJid entityFullJidLookup;
        if (jxmppContext.isCachingEnabled() && (entityFullJidLookup = ENTITY_FULLJID_CACHE.lookup(str)) != null) {
            return entityFullJidLookup;
        }
        try {
            LocalDomainAndResourcepartJid localDomainAndResourcepartJid = new LocalDomainAndResourcepartJid(XmppStringUtils.escapeLocalpart(XmppStringUtils.parseLocalpart(str)), XmppStringUtils.parseDomain(str), XmppStringUtils.parseResource(str), jxmppContext);
            if (jxmppContext.isCachingEnabled()) {
                ENTITY_FULLJID_CACHE.put(str, localDomainAndResourcepartJid);
            }
            return localDomainAndResourcepartJid;
        } catch (XmppStringprepException e2) {
            throw new XmppStringprepException(str, e2);
        }
    }

    public static EntityFullJid entityFullFromUnescapedOrNull(CharSequence charSequence) {
        try {
            return entityFullFromUnescaped(charSequence.toString());
        } catch (XmppStringprepException unused) {
            return null;
        }
    }

    public static EntityFullJid entityFullFrom(String str, String str2, String str3) throws XmppStringprepException {
        return entityFullFrom(str, str2, str3, JxmppContext.getDefaultContext());
    }

    public static EntityFullJid entityFullFrom(String str, String str2, String str3, JxmppContext jxmppContext) throws XmppStringprepException {
        try {
            return new LocalDomainAndResourcepartJid(str, str2, str3, jxmppContext);
        } catch (XmppStringprepException e2) {
            throw new XmppStringprepException(str + '@' + str2 + '/' + str3, e2);
        }
    }

    public static EntityFullJid entityFullFrom(Localpart localpart, DomainBareJid domainBareJid, Resourcepart resourcepart) {
        return entityFullFrom(localpart, domainBareJid.getDomain(), resourcepart);
    }

    public static EntityFullJid entityFullFrom(Localpart localpart, Domainpart domainpart, Resourcepart resourcepart) {
        return entityFullFrom(entityBareFrom(localpart, domainpart), resourcepart);
    }

    public static EntityFullJid entityFullFrom(EntityBareJid entityBareJid, Resourcepart resourcepart) {
        return new LocalDomainAndResourcepartJid(entityBareJid, resourcepart);
    }

    public static EntityFullJid entityFullFromUrlEncoded(CharSequence charSequence) throws XmppStringprepException {
        return entityFullFrom(urlDecode(charSequence));
    }

    public static DomainBareJid domainBareFromOrThrowUnchecked(CharSequence charSequence) {
        try {
            return domainBareFrom(charSequence);
        } catch (XmppStringprepException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static DomainBareJid domainBareFrom(CharSequence charSequence) throws XmppStringprepException {
        return domainBareFrom(charSequence.toString());
    }

    public static DomainBareJid domainBareFrom(String str) throws XmppStringprepException {
        return domainBareFrom(str, JxmppContext.getDefaultContext());
    }

    public static DomainBareJid domainBareFrom(String str, JxmppContext jxmppContext) throws XmppStringprepException {
        DomainBareJid domainBareJidLookup;
        if (jxmppContext.isCachingEnabled() && (domainBareJidLookup = DOMAINJID_CACHE.lookup(str)) != null) {
            return domainBareJidLookup;
        }
        try {
            DomainpartJid domainpartJid = new DomainpartJid(XmppStringUtils.parseDomain(str), jxmppContext);
            if (jxmppContext.isCachingEnabled()) {
                DOMAINJID_CACHE.put(str, domainpartJid);
            }
            return domainpartJid;
        } catch (XmppStringprepException e2) {
            throw new XmppStringprepException(str, e2);
        }
    }

    public static DomainBareJid domainBareFrom(Domainpart domainpart) {
        return new DomainpartJid(domainpart);
    }

    public static DomainBareJid domainBareFromOrNull(CharSequence charSequence) {
        try {
            return domainBareFrom(charSequence);
        } catch (XmppStringprepException unused) {
            return null;
        }
    }

    public static DomainBareJid domainBareFromUrlEncoded(CharSequence charSequence) throws XmppStringprepException {
        return domainBareFrom(urlDecode(charSequence));
    }

    public static DomainFullJid domainFullFromOrThrowUnchecked(CharSequence charSequence) {
        try {
            return domainFullFrom(charSequence);
        } catch (XmppStringprepException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static DomainFullJid domainFullFrom(CharSequence charSequence) throws XmppStringprepException {
        return domainFullFrom(charSequence.toString());
    }

    public static DomainFullJid domainFullFrom(String str) throws XmppStringprepException {
        return domainFullFrom(str, JxmppContext.getDefaultContext());
    }

    public static DomainFullJid domainFullFrom(String str, JxmppContext jxmppContext) throws XmppStringprepException {
        DomainFullJid domainFullJidLookup;
        if (jxmppContext.isCachingEnabled() && (domainFullJidLookup = DOMAINRESOURCEJID_CACHE.lookup(str)) != null) {
            return domainFullJidLookup;
        }
        try {
            DomainAndResourcepartJid domainAndResourcepartJid = new DomainAndResourcepartJid(XmppStringUtils.parseDomain(str), XmppStringUtils.parseResource(str), jxmppContext);
            if (jxmppContext.isCachingEnabled()) {
                DOMAINRESOURCEJID_CACHE.put(str, domainAndResourcepartJid);
            }
            return domainAndResourcepartJid;
        } catch (XmppStringprepException e2) {
            throw new XmppStringprepException(str, e2);
        }
    }

    public static DomainFullJid domainFullFrom(Domainpart domainpart, Resourcepart resourcepart) {
        return domainFullFrom(domainBareFrom(domainpart), resourcepart);
    }

    public static DomainFullJid domainFullFrom(DomainBareJid domainBareJid, Resourcepart resourcepart) {
        return new DomainAndResourcepartJid(domainBareJid, resourcepart);
    }

    public static DomainFullJid domainFullFromOrNull(CharSequence charSequence) {
        try {
            return domainFullFrom(charSequence);
        } catch (XmppStringprepException unused) {
            return null;
        }
    }

    public static DomainFullJid domainFullFromUrlEncoded(CharSequence charSequence) throws XmppStringprepException {
        return domainFullFrom(urlDecode(charSequence));
    }

    private static String urlDecode(CharSequence charSequence) {
        try {
            return URLDecoder.decode(charSequence.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }
}
