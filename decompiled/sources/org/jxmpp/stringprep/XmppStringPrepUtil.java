package org.jxmpp.stringprep;

import org.jxmpp.JxmppContext;
import org.jxmpp.XmppAddressParttype;
import org.jxmpp.stringprep.simple.SimpleXmppStringprep;
import org.jxmpp.util.cache.Cache;
import org.jxmpp.util.cache.LruCache;

/* JADX INFO: loaded from: classes10.dex */
public class XmppStringPrepUtil {
    private static final Cache<String, String> DOMAINPREP_CACHE;
    private static final Cache<String, String> NODEPREP_CACHE;
    private static final Cache<String, String> RESOURCEPREP_CACHE;

    static {
        SimpleXmppStringprep.setup();
        NODEPREP_CACHE = new LruCache(100);
        DOMAINPREP_CACHE = new LruCache(100);
        RESOURCEPREP_CACHE = new LruCache(100);
    }

    @Deprecated
    public static void setXmppStringprep(XmppStringprep xmppStringprep) {
        JxmppContext.setDefaultXmppStringprep(xmppStringprep);
    }

    public static String localprep(String str) throws XmppStringprepException {
        return localprep(str, JxmppContext.getDefaultContext());
    }

    public static String localprep(String str, JxmppContext jxmppContext) throws XmppStringprepException {
        String strLookup;
        throwIfNullOrEmpty(str, XmppAddressParttype.localpart);
        if (jxmppContext.isCachingEnabled() && (strLookup = NODEPREP_CACHE.lookup(str)) != null) {
            return strLookup;
        }
        String strLocalprep = jxmppContext.xmppStringprep.localprep(str);
        if (jxmppContext.isCachingEnabled()) {
            NODEPREP_CACHE.put(str, strLocalprep);
        }
        return strLocalprep;
    }

    public static String domainprep(String str) throws XmppStringprepException {
        return domainprep(str, JxmppContext.getDefaultContext());
    }

    public static String domainprep(String str, JxmppContext jxmppContext) throws XmppStringprepException {
        String strLookup;
        throwIfNullOrEmpty(str, XmppAddressParttype.domainpart);
        if (jxmppContext.isCachingEnabled() && (strLookup = DOMAINPREP_CACHE.lookup(str)) != null) {
            return strLookup;
        }
        String strDomainprep = jxmppContext.xmppStringprep.domainprep(str);
        if (jxmppContext.isCachingEnabled()) {
            DOMAINPREP_CACHE.put(str, strDomainprep);
        }
        return strDomainprep;
    }

    public static String resourceprep(String str) throws XmppStringprepException {
        return resourceprep(str, JxmppContext.getDefaultContext());
    }

    public static String resourceprep(String str, JxmppContext jxmppContext) throws XmppStringprepException {
        String strLookup;
        throwIfNullOrEmpty(str, XmppAddressParttype.resourcepart);
        if (jxmppContext.isCachingEnabled() && (strLookup = RESOURCEPREP_CACHE.lookup(str)) != null) {
            return strLookup;
        }
        String strResourceprep = jxmppContext.xmppStringprep.resourceprep(str);
        if (jxmppContext.isCachingEnabled()) {
            RESOURCEPREP_CACHE.put(str, strResourceprep);
        }
        return strResourceprep;
    }

    public static void setMaxCacheSizes(int i) {
        NODEPREP_CACHE.setMaxCacheSize(i);
        DOMAINPREP_CACHE.setMaxCacheSize(i);
        RESOURCEPREP_CACHE.setMaxCacheSize(i);
    }

    private static void throwIfNullOrEmpty(String str, XmppAddressParttype xmppAddressParttype) throws XmppStringprepException {
        if (str == null) {
            throw new XmppStringprepException(str, xmppAddressParttype + " can't be null");
        }
        if (str.isEmpty()) {
            throw new XmppStringprepException(str, xmppAddressParttype + " can't be the empty string");
        }
    }
}
