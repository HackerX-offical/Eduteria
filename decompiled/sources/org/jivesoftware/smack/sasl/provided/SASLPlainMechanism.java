package org.jivesoftware.smack.sasl.provided;

import javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.util.ByteUtils;

/* JADX INFO: loaded from: classes10.dex */
public class SASLPlainMechanism extends SASLMechanism {
    public static final String NAME = "PLAIN";

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public boolean authzidSupported() {
        return true;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public void checkIfSuccessfulOrThrow() {
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public int getPriority() {
        return 410;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    protected void authenticateInternal(CallbackHandler callbackHandler) {
        throw new UnsupportedOperationException("CallbackHandler not (yet) supported");
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    protected byte[] getAuthenticationText() {
        String string;
        if (this.authorizationId == null) {
            string = "";
        } else {
            string = this.authorizationId.toString();
        }
        return ByteUtils.concat(toBytes(string + (char) 0 + this.authenticationId), toBytes("\u0000" + this.password));
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public String getName() {
        return "PLAIN";
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public SASLPlainMechanism newInstance() {
        return new SASLPlainMechanism();
    }
}
