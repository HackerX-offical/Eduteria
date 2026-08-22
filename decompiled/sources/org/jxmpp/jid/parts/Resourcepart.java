package org.jxmpp.jid.parts;

import org.jxmpp.JxmppContext;
import org.jxmpp.stringprep.XmppStringPrepUtil;
import org.jxmpp.stringprep.XmppStringprepException;

/* JADX INFO: loaded from: classes10.dex */
public class Resourcepart extends Part {
    public static final Resourcepart EMPTY = new Resourcepart("");
    private static final long serialVersionUID = 1;

    private Resourcepart(String str) {
        super(str);
    }

    public static Resourcepart fromOrNull(CharSequence charSequence) {
        try {
            return from(charSequence.toString());
        } catch (XmppStringprepException unused) {
            return null;
        }
    }

    public static Resourcepart fromOrThrowUnchecked(CharSequence charSequence) {
        try {
            return from(charSequence.toString());
        } catch (XmppStringprepException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static Resourcepart from(String str) throws XmppStringprepException {
        return from(str, JxmppContext.getDefaultContext());
    }

    public static Resourcepart from(String str, JxmppContext jxmppContext) throws XmppStringprepException {
        String strResourceprep = XmppStringPrepUtil.resourceprep(str, jxmppContext);
        assertNotLongerThan1023BytesOrEmpty(strResourceprep);
        return new Resourcepart(strResourceprep);
    }
}
