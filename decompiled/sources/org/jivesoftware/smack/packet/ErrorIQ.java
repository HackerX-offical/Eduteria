package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.Objects;

/* JADX INFO: loaded from: classes10.dex */
public class ErrorIQ extends SimpleIQ {
    public static final String ELEMENT = "error";

    public ErrorIQ(StanzaError stanzaError) {
        super("error", null);
        Objects.requireNonNull(stanzaError, "stanzaError must not be null");
        setType(IQ.Type.error);
        setError(stanzaError);
    }
}
