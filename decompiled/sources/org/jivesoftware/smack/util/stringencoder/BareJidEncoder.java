package org.jivesoftware.smack.util.stringencoder;

import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;

/* JADX INFO: loaded from: classes10.dex */
public abstract class BareJidEncoder implements StringEncoder<BareJid> {

    @Deprecated
    public static class LegacyEncoder extends BareJidEncoder {
        @Override // org.jivesoftware.smack.util.stringencoder.StringEncoder
        public String encode(BareJid bareJid) {
            return bareJid.toString();
        }

        @Override // org.jivesoftware.smack.util.stringencoder.StringEncoder
        public BareJid decode(String str) {
            try {
                return JidCreate.bareFrom(str);
            } catch (XmppStringprepException e2) {
                throw new IllegalArgumentException("BareJid cannot be decoded.", e2);
            }
        }
    }

    public static class UrlSafeEncoder extends BareJidEncoder {
        @Override // org.jivesoftware.smack.util.stringencoder.StringEncoder
        public String encode(BareJid bareJid) {
            return bareJid.asUrlEncodedString();
        }

        @Override // org.jivesoftware.smack.util.stringencoder.StringEncoder
        public BareJid decode(String str) {
            try {
                return JidCreate.bareFromUrlEncoded(str);
            } catch (XmppStringprepException e2) {
                throw new IllegalArgumentException("BareJid cannot be decoded.", e2);
            }
        }
    }
}
