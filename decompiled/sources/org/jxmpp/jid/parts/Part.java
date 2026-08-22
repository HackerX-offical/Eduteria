package org.jxmpp.jid.parts;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import org.jxmpp.stringprep.XmppStringprepException;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Part implements CharSequence, Serializable {
    private static final long serialVersionUID = 1;
    private transient String internalizedCache;
    private final String part;

    protected Part(String str) {
        this.part = str;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.part.length();
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.part.charAt(i);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return this.part.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.part;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return this.part.equals(obj.toString());
    }

    public final int hashCode() {
        return this.part.hashCode();
    }

    protected static void assertNotLongerThan1023BytesOrEmpty(String str) throws XmppStringprepException {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        if (bytes.length > 1023) {
            throw new XmppStringprepException(str, "Given string is longer then 1023 bytes");
        }
        if (bytes.length == 0) {
            throw new XmppStringprepException(str, "Argument can't be the empty string");
        }
    }

    public final String intern() {
        if (this.internalizedCache == null) {
            this.internalizedCache = toString().intern();
        }
        return this.internalizedCache;
    }
}
