package org.jivesoftware.smack.sasl.core;

import javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.sasl.SASLMechanism;

/* JADX INFO: loaded from: classes10.dex */
public class SASLAnonymous extends SASLMechanism {
    public static final String NAME = "ANONYMOUS";

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    protected void authenticateInternal(CallbackHandler callbackHandler) {
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public void checkIfSuccessfulOrThrow() {
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    protected byte[] getAuthenticationText() {
        return null;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public int getPriority() {
        return 500;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public boolean requiresPassword() {
        return false;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public String getName() {
        return NAME;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public SASLAnonymous newInstance() {
        return new SASLAnonymous();
    }
}
