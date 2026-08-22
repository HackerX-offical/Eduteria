package org.jxmpp.jid.parts;

import org.jxmpp.JxmppContext;
import org.jxmpp.stringprep.XmppStringPrepUtil;
import org.jxmpp.stringprep.XmppStringprepException;

/* JADX INFO: loaded from: classes10.dex */
public class Domainpart extends Part {
    private static final long serialVersionUID = 1;

    private Domainpart(String str) {
        super(str);
    }

    public static Domainpart fromOrNull(CharSequence charSequence) {
        try {
            return from(charSequence.toString());
        } catch (XmppStringprepException unused) {
            return null;
        }
    }

    public static Domainpart fromOrThrowUnchecked(CharSequence charSequence) {
        try {
            return from(charSequence.toString());
        } catch (XmppStringprepException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static Domainpart from(String str) throws XmppStringprepException {
        return from(str, JxmppContext.getDefaultContext());
    }

    public static Domainpart from(String str, JxmppContext jxmppContext) throws XmppStringprepException {
        if (str == null) {
            throw new XmppStringprepException(str, "Input 'domain' must not be null");
        }
        if (str.length() > 0 && str.charAt(str.length() - 1) == '.') {
            str = str.substring(0, str.length() - 1);
        }
        String strDomainprep = XmppStringPrepUtil.domainprep(str, jxmppContext);
        assertNotLongerThan1023BytesOrEmpty(strDomainprep);
        return new Domainpart(strDomainprep);
    }
}
