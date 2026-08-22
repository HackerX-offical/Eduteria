package org.jxmpp.stringprep;

import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public class XmppStringprepException extends IOException {
    private static final long serialVersionUID = -8491853210107124624L;
    private final String causingString;

    public XmppStringprepException(String str, Exception exc) {
        super("XmppStringprepException caused by '" + str + "': " + exc);
        initCause(exc);
        this.causingString = str;
    }

    public XmppStringprepException(String str, String str2) {
        super(str2);
        this.causingString = str;
    }

    public String getCausingString() {
        return this.causingString;
    }

    public static class MissingDomainpart extends XmppStringprepException {
        private static final long serialVersionUID = 1;

        private MissingDomainpart(String str) {
            super(str, "The provided string does not have a domainpart");
        }

        public static MissingDomainpart from(String str, String str2) {
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                sb.append(str).append('@');
            }
            if (str2 != null) {
                sb.append('/').append(str2);
            }
            return new MissingDomainpart(sb.toString());
        }
    }
}
