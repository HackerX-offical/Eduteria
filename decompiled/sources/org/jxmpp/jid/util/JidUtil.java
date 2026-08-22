package org.jxmpp.jid.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jxmpp.jid.DomainFullJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;
import org.jxmpp.util.XmppStringUtils;

/* JADX INFO: loaded from: classes10.dex */
public class JidUtil {
    public static boolean isTypicalValidEntityBareJid(CharSequence charSequence) {
        try {
            validateTypicalEntityBareJid(charSequence);
            return true;
        } catch (NotAEntityBareJidStringException | XmppStringprepException unused) {
            return false;
        }
    }

    public static EntityBareJid validateTypicalEntityBareJid(CharSequence charSequence) throws NotAEntityBareJidStringException, XmppStringprepException {
        EntityBareJid entityBareJidValidateEntityBareJid = validateEntityBareJid(charSequence);
        if (entityBareJidValidateEntityBareJid.getDomain().toString().indexOf(46) != -1) {
            return entityBareJidValidateEntityBareJid;
        }
        throw new NotAEntityBareJidStringException("Domainpart does not include a dot ('.') character");
    }

    public static boolean isValidEntityBareJid(CharSequence charSequence) {
        try {
            validateEntityBareJid(charSequence);
            return true;
        } catch (NotAEntityBareJidStringException | XmppStringprepException unused) {
            return false;
        }
    }

    public static EntityBareJid validateEntityBareJid(CharSequence charSequence) throws NotAEntityBareJidStringException, XmppStringprepException {
        String string = charSequence.toString();
        int iIndexOf = string.indexOf(64);
        if (iIndexOf == -1) {
            throw new NotAEntityBareJidStringException("'" + string + "' does not contain a '@' character");
        }
        if (string.indexOf(64, iIndexOf + 1) != -1) {
            throw new NotAEntityBareJidStringException("'" + string + "' contains multiple '@' characters");
        }
        String localpart = XmppStringUtils.parseLocalpart(string);
        if (localpart == null || localpart.length() == 0) {
            throw new NotAEntityBareJidStringException("'" + string + "' has empty localpart");
        }
        String domain = XmppStringUtils.parseDomain(string);
        if (domain == null || domain.length() == 0) {
            throw new NotAEntityBareJidStringException("'" + string + "' has empty domainpart");
        }
        return JidCreate.entityBareFromUnescaped(string);
    }

    public static class NotAEntityBareJidStringException extends Exception {
        private static final long serialVersionUID = -1710386661031655082L;

        public NotAEntityBareJidStringException(String str) {
            super(str);
        }
    }

    public static void filterEntityBareJid(Collection<? extends Jid> collection, Collection<? super EntityBareJid> collection2) {
        Iterator<? extends Jid> it = collection.iterator();
        while (it.hasNext()) {
            EntityBareJid entityBareJidAsEntityBareJidIfPossible = it.next().asEntityBareJidIfPossible();
            if (entityBareJidAsEntityBareJidIfPossible != null) {
                collection2.add(entityBareJidAsEntityBareJidIfPossible);
            }
        }
    }

    public static Set<EntityBareJid> filterEntityBareJidSet(Collection<? extends Jid> collection) {
        HashSet hashSet = new HashSet(collection.size());
        filterEntityBareJid(collection, hashSet);
        return hashSet;
    }

    public static List<EntityBareJid> filterEntityBareJidList(Collection<? extends Jid> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        filterEntityBareJid(collection, arrayList);
        return arrayList;
    }

    public static void filterEntityFullJid(Collection<? extends Jid> collection, Collection<? super EntityFullJid> collection2) {
        Iterator<? extends Jid> it = collection.iterator();
        while (it.hasNext()) {
            EntityFullJid entityFullJidAsEntityFullJidIfPossible = it.next().asEntityFullJidIfPossible();
            if (entityFullJidAsEntityFullJidIfPossible != null) {
                collection2.add(entityFullJidAsEntityFullJidIfPossible);
            }
        }
    }

    public static Set<EntityFullJid> filterEntityFullJidSet(Collection<? extends Jid> collection) {
        HashSet hashSet = new HashSet(collection.size());
        filterEntityFullJid(collection, hashSet);
        return hashSet;
    }

    public static List<EntityFullJid> filterEntityFullJidList(Collection<? extends Jid> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        filterEntityFullJid(collection, arrayList);
        return arrayList;
    }

    public static void filterDomainFullJid(Collection<? extends Jid> collection, Collection<? super DomainFullJid> collection2) {
        Iterator<? extends Jid> it = collection.iterator();
        while (it.hasNext()) {
            DomainFullJid domainFullJidAsDomainFullJidIfPossible = it.next().asDomainFullJidIfPossible();
            if (domainFullJidAsDomainFullJidIfPossible != null) {
                collection2.add(domainFullJidAsDomainFullJidIfPossible);
            }
        }
    }

    public static Set<DomainFullJid> filterDomainFullJidSet(Collection<? extends Jid> collection) {
        HashSet hashSet = new HashSet(collection.size());
        filterDomainFullJid(collection, hashSet);
        return hashSet;
    }

    public static List<DomainFullJid> filterDomainFullJidList(Collection<? extends Jid> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        filterDomainFullJid(collection, arrayList);
        return arrayList;
    }

    public static Set<EntityBareJid> entityBareJidSetFrom(Collection<? extends CharSequence> collection) {
        HashSet hashSet = new HashSet(collection.size());
        entityBareJidsFrom(collection, hashSet, null);
        return hashSet;
    }

    public static void entityBareJidsFrom(Collection<? extends CharSequence> collection, Collection<? super EntityBareJid> collection2, List<XmppStringprepException> list) {
        Iterator<? extends CharSequence> it = collection.iterator();
        while (it.hasNext()) {
            try {
                collection2.add(JidCreate.entityBareFrom(it.next()));
            } catch (XmppStringprepException e2) {
                if (list != null) {
                    list.add(e2);
                } else {
                    throw new AssertionError(e2);
                }
            }
        }
    }

    public static Set<Jid> jidSetFrom(String[] strArr) {
        return jidSetFrom(Arrays.asList(strArr));
    }

    public static Set<Jid> jidSetFrom(Collection<? extends CharSequence> collection) {
        HashSet hashSet = new HashSet(collection.size());
        jidsFrom(collection, hashSet, null);
        return hashSet;
    }

    public static void jidsFrom(Collection<? extends CharSequence> collection, Collection<? super Jid> collection2, List<XmppStringprepException> list) {
        Iterator<? extends CharSequence> it = collection.iterator();
        while (it.hasNext()) {
            try {
                collection2.add(JidCreate.from(it.next()));
            } catch (XmppStringprepException e2) {
                if (list != null) {
                    list.add(e2);
                } else {
                    throw new AssertionError(e2);
                }
            }
        }
    }

    public static List<String> toStringList(Collection<? extends Jid> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        toStrings(collection, arrayList);
        return arrayList;
    }

    public static Set<String> toStringSet(Collection<? extends Jid> collection) {
        HashSet hashSet = new HashSet(collection.size());
        toStrings(collection, hashSet);
        return hashSet;
    }

    public static void toStrings(Collection<? extends Jid> collection, Collection<? super String> collection2) {
        Iterator<? extends Jid> it = collection.iterator();
        while (it.hasNext()) {
            collection2.add(it.next().toString());
        }
    }

    public static boolean equals(Jid jid, Jid jid2) {
        if (jid != null) {
            return jid.equals((CharSequence) jid2);
        }
        return jid2 == null;
    }
}
