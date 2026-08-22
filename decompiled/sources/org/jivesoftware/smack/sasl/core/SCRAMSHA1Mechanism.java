package org.jivesoftware.smack.sasl.core;

import java.security.InvalidKeyException;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.util.MAC;

/* JADX INFO: loaded from: classes10.dex */
public class SCRAMSHA1Mechanism extends ScramMechanism {
    static final int PRIORITY = 110;
    static final ScramHmac SHA_1_SCRAM_HMAC = new ScramHmac() { // from class: org.jivesoftware.smack.sasl.core.SCRAMSHA1Mechanism.1
        @Override // org.jivesoftware.smack.sasl.core.ScramHmac
        public String getHmacName() {
            return "SHA-1";
        }

        @Override // org.jivesoftware.smack.sasl.core.ScramHmac
        public byte[] hmac(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
            return MAC.hmacsha1(bArr, bArr2);
        }
    };
    public static final String NAME = new SCRAMSHA1Mechanism().getName();

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public int getPriority() {
        return 110;
    }

    public SCRAMSHA1Mechanism() {
        super(SHA_1_SCRAM_HMAC);
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    protected SASLMechanism newInstance() {
        return new SCRAMSHA1Mechanism();
    }
}
