package org.jivesoftware.smack.sasl;

import java.text.Normalizer;
import javax.net.ssl.SSLSession;
import javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.EntityBareJid;

/* JADX INFO: loaded from: classes10.dex */
public abstract class SASLMechanism implements Comparable<SASLMechanism> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String CRAMMD5 = "CRAM-MD5";
    public static final String DIGESTMD5 = "DIGEST-MD5";
    public static final String EXTERNAL = "EXTERNAL";
    public static final String GSSAPI = "GSSAPI";
    public static final String PLAIN = "PLAIN";
    protected String authenticationId;
    private boolean authenticationSuccessful;
    protected EntityBareJid authorizationId;
    protected XMPPConnection connection;
    protected ConnectionConfiguration connectionConfiguration;
    private Exception exception;
    protected String host;
    protected String password;
    protected DomainBareJid serviceName;
    protected SSLSession sslSession;

    protected void authenticateInternal() throws SmackException.SmackSaslException {
    }

    protected abstract void authenticateInternal(CallbackHandler callbackHandler) throws SmackException.SmackSaslException;

    public boolean authzidSupported() {
        return false;
    }

    protected abstract void checkIfSuccessfulOrThrow() throws SmackException.SmackSaslException;

    protected byte[] evaluateChallenge(byte[] bArr) throws SmackException.SmackSaslException {
        return null;
    }

    protected abstract byte[] getAuthenticationText() throws SmackException.SmackSaslException;

    public abstract String getName();

    public abstract int getPriority();

    protected abstract SASLMechanism newInstance();

    public boolean requiresPassword() {
        return true;
    }

    public final void authenticate(String str, String str2, DomainBareJid domainBareJid, String str3, EntityBareJid entityBareJid, SSLSession sSLSession) throws SmackException.NotConnectedException, InterruptedException, SmackException.SmackSaslException {
        this.authenticationId = str;
        this.host = str2;
        this.serviceName = domainBareJid;
        this.password = str3;
        this.authorizationId = entityBareJid;
        this.sslSession = sSLSession;
        authenticateInternal();
        authenticate();
    }

    public void authenticate(String str, DomainBareJid domainBareJid, CallbackHandler callbackHandler, EntityBareJid entityBareJid, SSLSession sSLSession) throws SmackException.NotConnectedException, InterruptedException, SmackException.SmackSaslException {
        this.host = str;
        this.serviceName = domainBareJid;
        this.authorizationId = entityBareJid;
        this.sslSession = sSLSession;
        authenticateInternal(callbackHandler);
        authenticate();
    }

    private void authenticate() throws SmackException.NotConnectedException, InterruptedException, SmackException.SmackSaslException {
        String strEncodeToString;
        byte[] authenticationText = getAuthenticationText();
        if (authenticationText != null && authenticationText.length > 0) {
            strEncodeToString = Base64.encodeToString(authenticationText);
        } else {
            strEncodeToString = "=";
        }
        this.connection.sendNonza(new SaslNonza.AuthMechanism(getName(), strEncodeToString));
    }

    public final void challengeReceived(String str, boolean z) throws SmackException.NotConnectedException, InterruptedException, SmackException.SmackSaslException {
        SaslNonza.Response response;
        if (str != null && str.equals("=")) {
            str = "";
        }
        byte[] bArrEvaluateChallenge = evaluateChallenge(Base64.decode(str));
        if (z) {
            return;
        }
        if (bArrEvaluateChallenge == null) {
            response = new SaslNonza.Response();
        } else {
            response = new SaslNonza.Response(Base64.encodeToString(bArrEvaluateChallenge));
        }
        this.connection.sendNonza(response);
    }

    @Override // java.lang.Comparable
    public final int compareTo(SASLMechanism sASLMechanism) {
        return Integer.compare(Integer.valueOf(getPriority()).intValue(), sASLMechanism.getPriority());
    }

    public final void afterFinalSaslChallenge() throws SmackException.SmackSaslException {
        checkIfSuccessfulOrThrow();
        this.authenticationSuccessful = true;
    }

    public SASLMechanism instanceForAuthentication(XMPPConnection xMPPConnection, ConnectionConfiguration connectionConfiguration) {
        SASLMechanism sASLMechanismNewInstance = newInstance();
        sASLMechanismNewInstance.connection = xMPPConnection;
        sASLMechanismNewInstance.connectionConfiguration = connectionConfiguration;
        return sASLMechanismNewInstance;
    }

    public boolean isAuthenticationSuccessful() {
        return this.authenticationSuccessful;
    }

    public boolean isFinished() {
        return isAuthenticationSuccessful() || this.exception != null;
    }

    public void throwExceptionIfRequired() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, SmackException.SmackSaslException, SASLErrorException {
        Exception exc = this.exception;
        if (exc != null) {
            if (exc instanceof SmackException.SmackSaslException) {
                throw ((SmackException.SmackSaslException) exc);
            }
            if (exc instanceof SASLErrorException) {
                throw ((SASLErrorException) exc);
            }
            if (exc instanceof SmackException.NotConnectedException) {
                throw ((SmackException.NotConnectedException) exc);
            }
            if (exc instanceof InterruptedException) {
                throw ((InterruptedException) exc);
            }
            throw new IllegalStateException("Unexpected exception type", this.exception);
        }
        if (!this.authenticationSuccessful) {
            throw SmackException.NoResponseException.newWith(this.connection, "successful SASL authentication");
        }
    }

    public void setException(Exception exc) {
        this.exception = exc;
    }

    protected static byte[] toBytes(String str) {
        return StringUtils.toUtf8Bytes(str);
    }

    protected static String saslPrep(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFKC);
    }

    public final String toString() {
        return "SASL Mech: " + getName() + ", Prio: " + getPriority();
    }
}
