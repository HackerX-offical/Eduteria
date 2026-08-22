package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.TBSCertificate;
import org.bouncycastle.jcajce.PKIXExtendedBuilderParameters;
import org.bouncycastle.jcajce.PKIXExtendedParameters;
import org.bouncycastle.jcajce.interfaces.BCX509Certificate;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.x509.ExtendedPKIXParameters;

/* JADX INFO: loaded from: classes10.dex */
public class PKIXCertPathValidatorSpi extends CertPathValidatorSpi {

    /* JADX INFO: renamed from: helper, reason: collision with root package name */
    private final JcaJceHelper f1446helper;
    private final boolean isForCRLCheck;

    public PKIXCertPathValidatorSpi() {
        this(false);
    }

    public PKIXCertPathValidatorSpi(boolean z) {
        this.f1446helper = new BCJcaJceHelper();
        this.isForCRLCheck = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void checkCertificate(X509Certificate x509Certificate) throws AnnotatedException {
        if (x509Certificate instanceof BCX509Certificate) {
            try {
            } catch (RuntimeException e2) {
                e = e2;
            }
            if (((BCX509Certificate) x509Certificate).getTBSCertificateNative() != null) {
                return;
            }
            e = null;
            throw new AnnotatedException("unable to process TBSCertificate", e);
        }
        try {
            TBSCertificate.getInstance(x509Certificate.getTBSCertificate());
        } catch (IllegalArgumentException e3) {
            throw new AnnotatedException(e3.getMessage());
        } catch (CertificateEncodingException e4) {
            throw new AnnotatedException("unable to process TBSCertificate", e4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v4, types: [org.bouncycastle.asn1.x509.AlgorithmIdentifier] */
    @Override // java.security.cert.CertPathValidatorSpi
    public CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters certPathParameters) throws CertPathValidatorException, InvalidAlgorithmParameterException {
        PKIXExtendedParameters baseParameters;
        List<? extends Certificate> list;
        X500Name ca;
        PublicKey cAPublicKey;
        int i;
        HashSet hashSet;
        List list2;
        HashSet hashSet2;
        if (certPathParameters instanceof PKIXParameters) {
            PKIXExtendedParameters.Builder builder = new PKIXExtendedParameters.Builder((PKIXParameters) certPathParameters);
            if (certPathParameters instanceof ExtendedPKIXParameters) {
                ExtendedPKIXParameters extendedPKIXParameters = (ExtendedPKIXParameters) certPathParameters;
                builder.setUseDeltasEnabled(extendedPKIXParameters.isUseDeltasEnabled());
                builder.setValidityModel(extendedPKIXParameters.getValidityModel());
            }
            baseParameters = builder.build();
        } else if (certPathParameters instanceof PKIXExtendedBuilderParameters) {
            baseParameters = ((PKIXExtendedBuilderParameters) certPathParameters).getBaseParameters();
        } else {
            if (!(certPathParameters instanceof PKIXExtendedParameters)) {
                throw new InvalidAlgorithmParameterException("Parameters must be a " + PKIXParameters.class.getName() + " instance.");
            }
            baseParameters = (PKIXExtendedParameters) certPathParameters;
        }
        if (baseParameters.getTrustAnchors() == null) {
            throw new InvalidAlgorithmParameterException("trustAnchors is null, this is not allowed for certification path validation.");
        }
        List<? extends Certificate> certificates = certPath.getCertificates();
        int size = certificates.size();
        int algorithmIdentifier = -1;
        if (certificates.isEmpty()) {
            throw new CertPathValidatorException("Certification path is empty.", null, certPath, -1);
        }
        Set initialPolicies = baseParameters.getInitialPolicies();
        try {
            TrustAnchor trustAnchorFindTrustAnchor = CertPathValidatorUtilities.findTrustAnchor((X509Certificate) certificates.get(certificates.size() - 1), baseParameters.getTrustAnchors(), baseParameters.getSigProvider());
            if (trustAnchorFindTrustAnchor != null) {
                checkCertificate(trustAnchorFindTrustAnchor.getTrustedCert());
                PKIXExtendedParameters pKIXExtendedParametersBuild = new PKIXExtendedParameters.Builder(baseParameters).setTrustAnchor(trustAnchorFindTrustAnchor).build();
                int iPrepareNextCertI2 = size + 1;
                ArrayList[] arrayListArr = new ArrayList[iPrepareNextCertI2];
                for (int i2 = 0; i2 < iPrepareNextCertI2; i2++) {
                    arrayListArr[i2] = new ArrayList();
                }
                HashSet hashSet3 = new HashSet();
                hashSet3.add(RFC3280CertPathUtilities.ANY_POLICY);
                PKIXPolicyNode pKIXPolicyNode = new PKIXPolicyNode(new ArrayList(), 0, hashSet3, null, new HashSet(), RFC3280CertPathUtilities.ANY_POLICY, false);
                arrayListArr[0].add(pKIXPolicyNode);
                PKIXNameConstraintValidator pKIXNameConstraintValidator = new PKIXNameConstraintValidator();
                HashSet hashSet4 = new HashSet();
                int i3 = pKIXExtendedParametersBuild.isExplicitPolicyRequired() ? 0 : iPrepareNextCertI2;
                int i4 = pKIXExtendedParametersBuild.isAnyPolicyInhibited() ? 0 : iPrepareNextCertI2;
                if (pKIXExtendedParametersBuild.isPolicyMappingInhibited()) {
                    iPrepareNextCertI2 = 0;
                }
                X509Certificate trustedCert = trustAnchorFindTrustAnchor.getTrustedCert();
                try {
                    if (trustedCert != null) {
                        ca = PrincipalUtils.getSubjectPrincipal(trustedCert);
                        cAPublicKey = trustedCert.getPublicKey();
                    } else {
                        ca = PrincipalUtils.getCA(trustAnchorFindTrustAnchor);
                        cAPublicKey = trustAnchorFindTrustAnchor.getCAPublicKey();
                    }
                    try {
                        algorithmIdentifier = CertPathValidatorUtilities.getAlgorithmIdentifier(cAPublicKey);
                        algorithmIdentifier.getAlgorithm();
                        algorithmIdentifier.getParameters();
                        if (pKIXExtendedParametersBuild.getTargetConstraints() != null) {
                            i = 1;
                            if (!pKIXExtendedParametersBuild.getTargetConstraints().match((Certificate) certificates.get(0))) {
                                throw new ExtCertPathValidatorException("Target certificate in certification path does not match targetConstraints.", null, certPath, 0);
                            }
                        } else {
                            i = 1;
                        }
                        List certPathCheckers = pKIXExtendedParametersBuild.getCertPathCheckers();
                        Iterator it = certPathCheckers.iterator();
                        while (it.hasNext()) {
                            ((PKIXCertPathChecker) it.next()).init(false);
                        }
                        int size2 = certificates.size() - 1;
                        int i5 = i4;
                        PKIXPolicyNode pKIXPolicyNode2 = pKIXPolicyNode;
                        X500Name x500Name = ca;
                        PKIXNameConstraintValidator pKIXNameConstraintValidator2 = pKIXNameConstraintValidator;
                        X509Certificate x509Certificate = trustedCert;
                        int i6 = i5;
                        int i7 = i3;
                        X509Certificate x509Certificate2 = null;
                        int iPrepareNextCertM = size;
                        while (size2 >= 0) {
                            int i8 = size - size2;
                            List<? extends Certificate> list3 = certificates;
                            X509Certificate x509Certificate3 = (X509Certificate) certificates.get(size2);
                            boolean z = size2 == list3.size() + (-1) ? i : 0;
                            try {
                                checkCertificate(x509Certificate3);
                                PKIXNameConstraintValidator pKIXNameConstraintValidator3 = pKIXNameConstraintValidator2;
                                ArrayList[] arrayListArr2 = arrayListArr;
                                PublicKey publicKey = cAPublicKey;
                                TrustAnchor trustAnchor = trustAnchorFindTrustAnchor;
                                List list4 = certPathCheckers;
                                RFC3280CertPathUtilities.processCertA(certPath, pKIXExtendedParametersBuild, size2, publicKey, z, x500Name, x509Certificate, this.f1446helper);
                                PKIXExtendedParameters pKIXExtendedParameters = pKIXExtendedParametersBuild;
                                int i9 = size2;
                                PublicKey publicKey2 = publicKey;
                                X500Name x500Name2 = x500Name;
                                X509Certificate x509Certificate4 = x509Certificate;
                                RFC3280CertPathUtilities.processCertBC(certPath, i9, pKIXNameConstraintValidator3, this.isForCRLCheck);
                                HashSet hashSet5 = hashSet4;
                                int i10 = i6;
                                PKIXPolicyNode pKIXPolicyNodeProcessCertE = RFC3280CertPathUtilities.processCertE(certPath, i9, RFC3280CertPathUtilities.processCertD(certPath, i9, hashSet5, pKIXPolicyNode2, arrayListArr2, i10, this.isForCRLCheck));
                                RFC3280CertPathUtilities.processCertF(certPath, i9, pKIXPolicyNodeProcessCertE, i7);
                                if (i8 != size) {
                                    if (x509Certificate3 != null) {
                                        hashSet4 = hashSet5;
                                        int i11 = i;
                                        if (x509Certificate3.getVersion() == i11) {
                                            if (i8 != i11 || !x509Certificate3.equals(trustAnchor.getTrustedCert())) {
                                                throw new CertPathValidatorException("Version 1 certificates can't be used as CA ones.", null, certPath, i9);
                                            }
                                        }
                                    } else {
                                        hashSet4 = hashSet5;
                                    }
                                    RFC3280CertPathUtilities.prepareNextCertA(certPath, i9);
                                    PKIXPolicyNode pKIXPolicyNodePrepareCertB = RFC3280CertPathUtilities.prepareCertB(certPath, i9, arrayListArr2, pKIXPolicyNodeProcessCertE, iPrepareNextCertI2);
                                    RFC3280CertPathUtilities.prepareNextCertG(certPath, i9, pKIXNameConstraintValidator3);
                                    int iPrepareNextCertH1 = RFC3280CertPathUtilities.prepareNextCertH1(certPath, i9, i7);
                                    int iPrepareNextCertH2 = RFC3280CertPathUtilities.prepareNextCertH2(certPath, i9, iPrepareNextCertI2);
                                    int iPrepareNextCertH3 = RFC3280CertPathUtilities.prepareNextCertH3(certPath, i9, i10);
                                    int iPrepareNextCertI1 = RFC3280CertPathUtilities.prepareNextCertI1(certPath, i9, iPrepareNextCertH1);
                                    iPrepareNextCertI2 = RFC3280CertPathUtilities.prepareNextCertI2(certPath, i9, iPrepareNextCertH2);
                                    int iPrepareNextCertJ = RFC3280CertPathUtilities.prepareNextCertJ(certPath, i9, iPrepareNextCertH3);
                                    RFC3280CertPathUtilities.prepareNextCertK(certPath, i9);
                                    iPrepareNextCertM = RFC3280CertPathUtilities.prepareNextCertM(certPath, i9, RFC3280CertPathUtilities.prepareNextCertL(certPath, i9, iPrepareNextCertM));
                                    RFC3280CertPathUtilities.prepareNextCertN(certPath, i9);
                                    Set<String> criticalExtensionOIDs = x509Certificate3.getCriticalExtensionOIDs();
                                    if (criticalExtensionOIDs != null) {
                                        hashSet2 = new HashSet(criticalExtensionOIDs);
                                        hashSet2.remove(RFC3280CertPathUtilities.KEY_USAGE);
                                        hashSet2.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                                        hashSet2.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                                        hashSet2.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                                        hashSet2.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                                        hashSet2.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                                        hashSet2.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                                        hashSet2.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                                        hashSet2.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                                        hashSet2.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                                    } else {
                                        hashSet2 = new HashSet();
                                    }
                                    list2 = list4;
                                    RFC3280CertPathUtilities.prepareNextCertO(certPath, i9, hashSet2, list2);
                                    X500Name subjectPrincipal = PrincipalUtils.getSubjectPrincipal(x509Certificate3);
                                    try {
                                        PublicKey nextWorkingKey = CertPathValidatorUtilities.getNextWorkingKey(certPath.getCertificates(), i9, this.f1446helper);
                                        AlgorithmIdentifier algorithmIdentifier2 = CertPathValidatorUtilities.getAlgorithmIdentifier(nextWorkingKey);
                                        algorithmIdentifier2.getAlgorithm();
                                        algorithmIdentifier2.getParameters();
                                        pKIXPolicyNode2 = pKIXPolicyNodePrepareCertB;
                                        i6 = iPrepareNextCertJ;
                                        x500Name = subjectPrincipal;
                                        x509Certificate4 = x509Certificate3;
                                        publicKey2 = nextWorkingKey;
                                        i7 = iPrepareNextCertI1;
                                        size2 = i9 - 1;
                                        arrayListArr = arrayListArr2;
                                        certPathCheckers = list2;
                                        pKIXNameConstraintValidator2 = pKIXNameConstraintValidator3;
                                        trustAnchorFindTrustAnchor = trustAnchor;
                                        pKIXExtendedParametersBuild = pKIXExtendedParameters;
                                        x509Certificate = x509Certificate4;
                                        i = 1;
                                        cAPublicKey = publicKey2;
                                        x509Certificate2 = x509Certificate3;
                                        certificates = list3;
                                    } catch (CertPathValidatorException e2) {
                                        throw new CertPathValidatorException("Next working key could not be retrieved.", e2, certPath, i9);
                                    }
                                } else {
                                    hashSet4 = hashSet5;
                                }
                                list2 = list4;
                                pKIXPolicyNode2 = pKIXPolicyNodeProcessCertE;
                                i6 = i10;
                                x500Name = x500Name2;
                                size2 = i9 - 1;
                                arrayListArr = arrayListArr2;
                                certPathCheckers = list2;
                                pKIXNameConstraintValidator2 = pKIXNameConstraintValidator3;
                                trustAnchorFindTrustAnchor = trustAnchor;
                                pKIXExtendedParametersBuild = pKIXExtendedParameters;
                                x509Certificate = x509Certificate4;
                                i = 1;
                                cAPublicKey = publicKey2;
                                x509Certificate2 = x509Certificate3;
                                certificates = list3;
                            } catch (AnnotatedException e3) {
                                throw new CertPathValidatorException(e3.getMessage(), e3.getUnderlyingException(), certPath, size2);
                            }
                        }
                        PKIXExtendedParameters pKIXExtendedParameters2 = pKIXExtendedParametersBuild;
                        int i12 = size2;
                        ArrayList[] arrayListArr3 = arrayListArr;
                        List list5 = certPathCheckers;
                        TrustAnchor trustAnchor2 = trustAnchorFindTrustAnchor;
                        PKIXPolicyNode pKIXPolicyNode3 = pKIXPolicyNode2;
                        int i13 = i12 + 1;
                        int iWrapupCertB = RFC3280CertPathUtilities.wrapupCertB(certPath, i13, RFC3280CertPathUtilities.wrapupCertA(i7, x509Certificate2));
                        Set<String> criticalExtensionOIDs2 = x509Certificate2.getCriticalExtensionOIDs();
                        if (criticalExtensionOIDs2 != null) {
                            hashSet = new HashSet(criticalExtensionOIDs2);
                            hashSet.remove(RFC3280CertPathUtilities.KEY_USAGE);
                            hashSet.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                            hashSet.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                            hashSet.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                            hashSet.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                            hashSet.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                            hashSet.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                            hashSet.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                            hashSet.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                            hashSet.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                            hashSet.remove(RFC3280CertPathUtilities.CRL_DISTRIBUTION_POINTS);
                            hashSet.remove(Extension.extendedKeyUsage.getId());
                        } else {
                            hashSet = new HashSet();
                        }
                        RFC3280CertPathUtilities.wrapupCertF(certPath, i13, list5, hashSet);
                        PKIXPolicyNode pKIXPolicyNodeWrapupCertG = RFC3280CertPathUtilities.wrapupCertG(certPath, pKIXExtendedParameters2, initialPolicies, i13, arrayListArr3, pKIXPolicyNode3, hashSet4);
                        if (iWrapupCertB > 0 || pKIXPolicyNodeWrapupCertG != null) {
                            return new PKIXCertPathValidatorResult(trustAnchor2, pKIXPolicyNodeWrapupCertG, x509Certificate2.getPublicKey());
                        }
                        throw new CertPathValidatorException("Path processing failed on policy.", null, certPath, i12);
                    } catch (CertPathValidatorException e4) {
                        throw new ExtCertPathValidatorException("Algorithm identifier of public key of trust anchor could not be read.", e4, certPath, -1);
                    }
                } catch (RuntimeException e5) {
                    throw new ExtCertPathValidatorException("Subject of trust anchor could not be (re)encoded.", e5, certPath, algorithmIdentifier);
                }
            }
            list = certificates;
            try {
                throw new CertPathValidatorException("Trust anchor for certification path not found.", null, certPath, -1);
            } catch (AnnotatedException e6) {
                e = e6;
            }
        } catch (AnnotatedException e7) {
            e = e7;
            list = certificates;
        }
        throw new CertPathValidatorException(e.getMessage(), e.getUnderlyingException(), certPath, list.size() - 1);
    }
}
