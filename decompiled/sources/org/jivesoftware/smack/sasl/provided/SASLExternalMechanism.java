package org.jivesoftware.smack.sasl.provided;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.util.StringUtils;
import org.jxmpp.util.XmppStringUtils;

/* JADX INFO: loaded from: classes10.dex */
public class SASLExternalMechanism extends SASLMechanism {
    public static final String NAME = "EXTERNAL";

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    protected void authenticateInternal(CallbackHandler callbackHandler) {
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public boolean authzidSupported() {
        return true;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public void checkIfSuccessfulOrThrow() {
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public int getPriority() {
        return TypedValues.PositionType.TYPE_POSITION_TYPE;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public boolean requiresPassword() {
        return false;
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    protected byte[] getAuthenticationText() {
        if (this.authorizationId != null) {
            return toBytes(this.authorizationId.toString());
        }
        if (StringUtils.isNullOrEmpty(this.authenticationId)) {
            return null;
        }
        return toBytes(XmppStringUtils.completeJidFrom(this.authenticationId, this.serviceName));
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    public String getName() {
        return "EXTERNAL";
    }

    @Override // org.jivesoftware.smack.sasl.SASLMechanism
    protected SASLMechanism newInstance() {
        return new SASLExternalMechanism();
    }
}
