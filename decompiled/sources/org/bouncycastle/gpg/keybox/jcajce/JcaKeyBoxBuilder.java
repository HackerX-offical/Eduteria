package org.bouncycastle.gpg.keybox.jcajce;

import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;

/* JADX INFO: loaded from: classes10.dex */
public class JcaKeyBoxBuilder {

    /* JADX INFO: renamed from: helper, reason: collision with root package name */
    private JcaJceHelper f1416helper = new DefaultJcaJceHelper();

    public JcaKeyBox build(InputStream inputStream) throws NoSuchAlgorithmException, IOException, NoSuchProviderException {
        return new JcaKeyBox(inputStream, new JcaKeyFingerprintCalculator(), new JcaBlobVerifier(this.f1416helper));
    }

    public JcaKeyBox build(byte[] bArr) throws NoSuchAlgorithmException, IOException, NoSuchProviderException {
        return new JcaKeyBox(bArr, new JcaKeyFingerprintCalculator(), new JcaBlobVerifier(this.f1416helper));
    }

    public JcaKeyBoxBuilder setProvider(String str) {
        this.f1416helper = new NamedJcaJceHelper(str);
        return this;
    }

    public JcaKeyBoxBuilder setProvider(Provider provider) {
        this.f1416helper = new ProviderJcaJceHelper(provider);
        return this;
    }
}
