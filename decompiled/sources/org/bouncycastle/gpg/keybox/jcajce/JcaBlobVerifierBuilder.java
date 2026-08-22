package org.bouncycastle.gpg.keybox.jcajce;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;

/* JADX INFO: loaded from: classes10.dex */
public class JcaBlobVerifierBuilder {

    /* JADX INFO: renamed from: helper, reason: collision with root package name */
    private JcaJceHelper f1415helper = new DefaultJcaJceHelper();

    public JcaBlobVerifier build() throws NoSuchAlgorithmException, NoSuchProviderException {
        return new JcaBlobVerifier(this.f1415helper);
    }

    public JcaBlobVerifierBuilder setProvider(String str) {
        this.f1415helper = new NamedJcaJceHelper(str);
        return this;
    }

    public JcaBlobVerifierBuilder setProvider(Provider provider) {
        this.f1415helper = new ProviderJcaJceHelper(provider);
        return this;
    }
}
