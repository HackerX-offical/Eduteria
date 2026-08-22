package org.jivesoftware.smack.sasl.core;

import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.util.TLSUtils;

/* JADX INFO: loaded from: classes10.dex */
public abstract class ScramPlusMechanism extends ScramMechanism {
    protected ScramPlusMechanism(ScramHmac scramHmac) {
        super(scramHmac);
    }

    @Override // org.jivesoftware.smack.sasl.core.ScramMechanism, org.jivesoftware.smack.sasl.SASLMechanism
    public String getName() {
        return super.getName() + "-PLUS";
    }

    @Override // org.jivesoftware.smack.sasl.core.ScramMechanism
    protected String getGs2CbindFlag() {
        return "p=tls-server-end-point";
    }

    @Override // org.jivesoftware.smack.sasl.core.ScramMechanism
    protected byte[] getChannelBindingData() throws SmackException.SmackSaslException {
        try {
            return TLSUtils.getChannelBindingTlsServerEndPoint(this.sslSession);
        } catch (NoSuchAlgorithmException | CertificateEncodingException | SSLPeerUnverifiedException e2) {
            throw new SmackException.SmackSaslException(e2);
        }
    }
}
