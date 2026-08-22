package org.jxmpp.jid.parts;

import org.jxmpp.JxmppContext;
import org.jxmpp.stringprep.XmppStringPrepUtil;
import org.jxmpp.stringprep.XmppStringprepException;
import org.jxmpp.util.XmppStringUtils;

/* JADX INFO: loaded from: classes10.dex */
public class Localpart extends Part {
    private static final long serialVersionUID = 1;
    private transient String unescapedCache;

    private Localpart(String str) {
        super(str);
    }

    public String asUnescapedString() {
        String str = this.unescapedCache;
        if (str != null) {
            return str;
        }
        String strUnescapeLocalpart = XmppStringUtils.unescapeLocalpart(toString());
        this.unescapedCache = strUnescapeLocalpart;
        return strUnescapeLocalpart;
    }

    public static Localpart fromOrThrowUnchecked(CharSequence charSequence) {
        try {
            return from(charSequence.toString());
        } catch (XmppStringprepException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static Localpart fromUnescapedOrThrowUnchecked(CharSequence charSequence) {
        try {
            return fromUnescaped(charSequence.toString());
        } catch (XmppStringprepException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static Localpart formUnescapedOrNull(CharSequence charSequence) {
        try {
            return fromUnescaped(charSequence);
        } catch (XmppStringprepException unused) {
            return null;
        }
    }

    public static Localpart fromUnescaped(String str) throws XmppStringprepException {
        return from(XmppStringUtils.escapeLocalpart(str));
    }

    public static Localpart fromUnescaped(CharSequence charSequence) throws XmppStringprepException {
        return fromUnescaped(charSequence.toString());
    }

    public static Localpart fromOrNull(CharSequence charSequence) {
        try {
            return from(charSequence.toString());
        } catch (XmppStringprepException unused) {
            return null;
        }
    }

    public static Localpart from(String str) throws XmppStringprepException {
        return from(str, JxmppContext.getDefaultContext());
    }

    public static Localpart from(String str, JxmppContext jxmppContext) throws XmppStringprepException {
        String strLocalprep = XmppStringPrepUtil.localprep(str, jxmppContext);
        assertNotLongerThan1023BytesOrEmpty(strLocalprep);
        return new Localpart(strLocalprep);
    }
}
