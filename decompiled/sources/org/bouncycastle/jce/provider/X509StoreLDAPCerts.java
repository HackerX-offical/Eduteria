package org.bouncycastle.jce.provider;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import org.bouncycastle.jce.X509LDAPCertStoreParameters;
import org.bouncycastle.util.Selector;
import org.bouncycastle.util.StoreException;
import org.bouncycastle.x509.X509CertPairStoreSelector;
import org.bouncycastle.x509.X509CertStoreSelector;
import org.bouncycastle.x509.X509CertificatePair;
import org.bouncycastle.x509.X509StoreParameters;
import org.bouncycastle.x509.X509StoreSpi;
import org.bouncycastle.x509.util.LDAPStoreHelper;

/* JADX INFO: loaded from: classes10.dex */
public class X509StoreLDAPCerts extends X509StoreSpi {

    /* JADX INFO: renamed from: helper, reason: collision with root package name */
    private LDAPStoreHelper f1453helper;

    private Collection getCertificatesFromCrossCertificatePairs(X509CertStoreSelector x509CertStoreSelector) throws StoreException {
        HashSet hashSet = new HashSet();
        X509CertPairStoreSelector x509CertPairStoreSelector = new X509CertPairStoreSelector();
        x509CertPairStoreSelector.setForwardSelector(x509CertStoreSelector);
        x509CertPairStoreSelector.setReverseSelector(new X509CertStoreSelector());
        HashSet<X509CertificatePair> hashSet2 = new HashSet(this.f1453helper.getCrossCertificatePairs(x509CertPairStoreSelector));
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (X509CertificatePair x509CertificatePair : hashSet2) {
            if (x509CertificatePair.getForward() != null) {
                hashSet3.add(x509CertificatePair.getForward());
            }
            if (x509CertificatePair.getReverse() != null) {
                hashSet4.add(x509CertificatePair.getReverse());
            }
        }
        hashSet.addAll(hashSet3);
        hashSet.addAll(hashSet4);
        return hashSet;
    }

    @Override // org.bouncycastle.x509.X509StoreSpi
    public Collection engineGetMatches(Selector selector) throws StoreException {
        Collection userCertificates;
        if (!(selector instanceof X509CertStoreSelector)) {
            return Collections.EMPTY_SET;
        }
        X509CertStoreSelector x509CertStoreSelector = (X509CertStoreSelector) selector;
        HashSet hashSet = new HashSet();
        if (x509CertStoreSelector.getBasicConstraints() > 0) {
            hashSet.addAll(this.f1453helper.getCACertificates(x509CertStoreSelector));
            userCertificates = getCertificatesFromCrossCertificatePairs(x509CertStoreSelector);
        } else if (x509CertStoreSelector.getBasicConstraints() == -2) {
            userCertificates = this.f1453helper.getUserCertificates(x509CertStoreSelector);
        } else {
            hashSet.addAll(this.f1453helper.getUserCertificates(x509CertStoreSelector));
            hashSet.addAll(this.f1453helper.getCACertificates(x509CertStoreSelector));
            userCertificates = getCertificatesFromCrossCertificatePairs(x509CertStoreSelector);
        }
        hashSet.addAll(userCertificates);
        return hashSet;
    }

    @Override // org.bouncycastle.x509.X509StoreSpi
    public void engineInit(X509StoreParameters x509StoreParameters) {
        if (!(x509StoreParameters instanceof X509LDAPCertStoreParameters)) {
            throw new IllegalArgumentException("Initialization parameters must be an instance of " + X509LDAPCertStoreParameters.class.getName() + InstructionFileId.DOT);
        }
        this.f1453helper = new LDAPStoreHelper((X509LDAPCertStoreParameters) x509StoreParameters);
    }
}
