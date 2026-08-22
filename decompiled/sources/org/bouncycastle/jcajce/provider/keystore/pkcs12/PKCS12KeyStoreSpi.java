package org.bouncycastle.jcajce.provider.keystore.pkcs12;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.BEROctetString;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DERBMPString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.GOST28147Parameters;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.AuthenticatedSafe;
import org.bouncycastle.asn1.pkcs.CertBag;
import org.bouncycastle.asn1.pkcs.ContentInfo;
import org.bouncycastle.asn1.pkcs.EncryptedData;
import org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.MacData;
import org.bouncycastle.asn1.pkcs.PBES2Parameters;
import org.bouncycastle.asn1.pkcs.PBKDF2Params;
import org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.Pfx;
import org.bouncycastle.asn1.pkcs.SafeBag;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.SubjectKeyIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.jcajce.PKCS12Key;
import org.bouncycastle.jcajce.PKCS12StoreParameter;
import org.bouncycastle.jcajce.spec.GOST28147ParameterSpec;
import org.bouncycastle.jcajce.spec.PBKDF2KeySpec;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.interfaces.BCKeyStore;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.jce.provider.JDKPKCS12StoreParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Properties;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes10.dex */
public class PKCS12KeyStoreSpi extends KeyStoreSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers, BCKeyStore {
    static final int CERTIFICATE = 1;
    static final int KEY = 2;
    static final int KEY_PRIVATE = 0;
    static final int KEY_PUBLIC = 1;
    static final int KEY_SECRET = 2;
    private static final int MIN_ITERATIONS = 51200;
    static final int NULL = 0;
    static final String PKCS12_MAX_IT_COUNT_PROPERTY = "org.bouncycastle.pkcs12.max_it_count";
    private static final int SALT_SIZE = 20;
    static final int SEALED = 4;
    static final int SECRET = 3;
    private static final DefaultSecretKeyProvider keySizeProvider = new DefaultSecretKeyProvider();
    private ASN1ObjectIdentifier certAlgorithm;
    private CertificateFactory certFact;
    private IgnoresCaseHashtable certs;
    private ASN1ObjectIdentifier keyAlgorithm;
    private IgnoresCaseHashtable keys;

    /* JADX INFO: renamed from: helper, reason: collision with root package name */
    private final JcaJceHelper f1438helper = new BCJcaJceHelper();
    private Hashtable localIds = new Hashtable();
    private Hashtable chainCerts = new Hashtable();
    private Hashtable keyCerts = new Hashtable();
    protected SecureRandom random = CryptoServicesRegistrar.getSecureRandom();
    private AlgorithmIdentifier macAlgorithm = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
    private int itCount = 102400;
    private int saltLength = 20;

    public static class BCPKCS12KeyStore extends PKCS12KeyStoreSpi {
        public BCPKCS12KeyStore() {
            super(new BCJcaJceHelper(), pbeWithSHAAnd3_KeyTripleDES_CBC, pbeWithSHAAnd40BitRC2_CBC);
        }
    }

    public static class BCPKCS12KeyStore3DES extends PKCS12KeyStoreSpi {
        public BCPKCS12KeyStore3DES() {
            super(new BCJcaJceHelper(), pbeWithSHAAnd3_KeyTripleDES_CBC, pbeWithSHAAnd3_KeyTripleDES_CBC);
        }
    }

    private class CertId {
        byte[] id;

        CertId(PublicKey publicKey) {
            this.id = PKCS12KeyStoreSpi.this.createSubjectKeyId(publicKey).getKeyIdentifier();
        }

        CertId(byte[] bArr) {
            this.id = bArr;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof CertId) {
                return Arrays.areEqual(this.id, ((CertId) obj).id);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.id);
        }
    }

    public static class DefPKCS12KeyStore extends PKCS12KeyStoreSpi {
        public DefPKCS12KeyStore() {
            super(new DefaultJcaJceHelper(), pbeWithSHAAnd3_KeyTripleDES_CBC, pbeWithSHAAnd40BitRC2_CBC);
        }
    }

    public static class DefPKCS12KeyStore3DES extends PKCS12KeyStoreSpi {
        public DefPKCS12KeyStore3DES() {
            super(new DefaultJcaJceHelper(), pbeWithSHAAnd3_KeyTripleDES_CBC, pbeWithSHAAnd3_KeyTripleDES_CBC);
        }
    }

    private static class DefaultSecretKeyProvider {
        private final Map KEY_SIZES;

        DefaultSecretKeyProvider() {
            HashMap map = new HashMap();
            map.put(new ASN1ObjectIdentifier("1.2.840.113533.7.66.10"), Integers.valueOf(128));
            map.put(PKCSObjectIdentifiers.des_EDE3_CBC, Integers.valueOf(192));
            map.put(NISTObjectIdentifiers.id_aes128_CBC, Integers.valueOf(128));
            map.put(NISTObjectIdentifiers.id_aes192_CBC, Integers.valueOf(192));
            map.put(NISTObjectIdentifiers.id_aes256_CBC, Integers.valueOf(256));
            map.put(NTTObjectIdentifiers.id_camellia128_cbc, Integers.valueOf(128));
            map.put(NTTObjectIdentifiers.id_camellia192_cbc, Integers.valueOf(192));
            map.put(NTTObjectIdentifiers.id_camellia256_cbc, Integers.valueOf(256));
            map.put(CryptoProObjectIdentifiers.gostR28147_gcfb, Integers.valueOf(256));
            this.KEY_SIZES = Collections.unmodifiableMap(map);
        }

        public int getKeySize(AlgorithmIdentifier algorithmIdentifier) {
            Integer num = (Integer) this.KEY_SIZES.get(algorithmIdentifier.getAlgorithm());
            if (num != null) {
                return num.intValue();
            }
            return -1;
        }
    }

    private static class IgnoresCaseHashtable {
        private Hashtable keys;
        private Hashtable orig;

        private IgnoresCaseHashtable() {
            this.orig = new Hashtable();
            this.keys = new Hashtable();
        }

        public Enumeration elements() {
            return this.orig.elements();
        }

        public Object get(String str) {
            String str2 = (String) this.keys.get(str == null ? null : Strings.toLowerCase(str));
            if (str2 == null) {
                return null;
            }
            return this.orig.get(str2);
        }

        public Enumeration keys() {
            return this.orig.keys();
        }

        public void put(String str, Object obj) {
            String lowerCase = str == null ? null : Strings.toLowerCase(str);
            String str2 = (String) this.keys.get(lowerCase);
            if (str2 != null) {
                this.orig.remove(str2);
            }
            this.keys.put(lowerCase, str);
            this.orig.put(str, obj);
        }

        public Object remove(String str) {
            String str2 = (String) this.keys.remove(str == null ? null : Strings.toLowerCase(str));
            if (str2 == null) {
                return null;
            }
            return this.orig.remove(str2);
        }

        public int size() {
            return this.orig.size();
        }
    }

    public PKCS12KeyStoreSpi(JcaJceHelper jcaJceHelper, ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2) {
        this.keys = new IgnoresCaseHashtable();
        this.certs = new IgnoresCaseHashtable();
        this.keyAlgorithm = aSN1ObjectIdentifier;
        this.certAlgorithm = aSN1ObjectIdentifier2;
        try {
            this.certFact = jcaJceHelper.createCertificateFactory("X.509");
        } catch (Exception e2) {
            throw new IllegalArgumentException("can't create cert factory - " + e2.toString());
        }
    }

    private byte[] calculatePbeMac(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr, int i, char[] cArr, boolean z, byte[] bArr2) throws Exception {
        PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr, i);
        Mac macCreateMac = this.f1438helper.createMac(aSN1ObjectIdentifier.getId());
        macCreateMac.init(new PKCS12Key(cArr, z), pBEParameterSpec);
        macCreateMac.update(bArr2);
        return macCreateMac.doFinal();
    }

    private Cipher createCipher(int i, char[] cArr, AlgorithmIdentifier algorithmIdentifier) throws InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec gOST28147ParameterSpec;
        PBES2Parameters pBES2Parameters = PBES2Parameters.getInstance(algorithmIdentifier.getParameters());
        PBKDF2Params pBKDF2Params = PBKDF2Params.getInstance(pBES2Parameters.getKeyDerivationFunc().getParameters());
        AlgorithmIdentifier algorithmIdentifier2 = AlgorithmIdentifier.getInstance(pBES2Parameters.getEncryptionScheme());
        SecretKey secretKeyGenerateSecret = this.f1438helper.createSecretKeyFactory(pBES2Parameters.getKeyDerivationFunc().getAlgorithm().getId()).generateSecret(pBKDF2Params.isDefaultPrf() ? new PBEKeySpec(cArr, pBKDF2Params.getSalt(), validateIterationCount(pBKDF2Params.getIterationCount()), keySizeProvider.getKeySize(algorithmIdentifier2)) : new PBKDF2KeySpec(cArr, pBKDF2Params.getSalt(), validateIterationCount(pBKDF2Params.getIterationCount()), keySizeProvider.getKeySize(algorithmIdentifier2), pBKDF2Params.getPrf()));
        Cipher cipher = Cipher.getInstance(pBES2Parameters.getEncryptionScheme().getAlgorithm().getId());
        ASN1Encodable parameters = pBES2Parameters.getEncryptionScheme().getParameters();
        if (parameters instanceof ASN1OctetString) {
            gOST28147ParameterSpec = new IvParameterSpec(ASN1OctetString.getInstance(parameters).getOctets());
        } else {
            GOST28147Parameters gOST28147Parameters = GOST28147Parameters.getInstance(parameters);
            gOST28147ParameterSpec = new GOST28147ParameterSpec(gOST28147Parameters.getEncryptionParamSet(), gOST28147Parameters.getIV());
        }
        cipher.init(i, secretKeyGenerateSecret, gOST28147ParameterSpec);
        return cipher;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SafeBag createSafeBag(String str, Certificate certificate) throws CertificateEncodingException {
        CertBag certBag = new CertBag(x509Certificate, new DEROctetString(certificate.getEncoded()));
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        boolean z = false;
        if (certificate instanceof PKCS12BagAttributeCarrier) {
            PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier = (PKCS12BagAttributeCarrier) certificate;
            DERBMPString dERBMPString = (DERBMPString) pKCS12BagAttributeCarrier.getBagAttribute(pkcs_9_at_friendlyName);
            if ((dERBMPString == null || !dERBMPString.getString().equals(str)) && str != null) {
                pKCS12BagAttributeCarrier.setBagAttribute(pkcs_9_at_friendlyName, new DERBMPString(str));
            }
            Enumeration bagAttributeKeys = pKCS12BagAttributeCarrier.getBagAttributeKeys();
            while (bagAttributeKeys.hasMoreElements()) {
                ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) bagAttributeKeys.nextElement();
                if (!aSN1ObjectIdentifier.equals((ASN1Primitive) PKCSObjectIdentifiers.pkcs_9_at_localKeyId)) {
                    ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                    aSN1EncodableVector2.add(aSN1ObjectIdentifier);
                    aSN1EncodableVector2.add(new DERSet(pKCS12BagAttributeCarrier.getBagAttribute(aSN1ObjectIdentifier)));
                    aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
                    z = true;
                }
            }
        }
        if (!z) {
            ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
            aSN1EncodableVector3.add(pkcs_9_at_friendlyName);
            aSN1EncodableVector3.add(new DERSet(new DERBMPString(str)));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector3));
        }
        return new SafeBag(certBag, certBag.toASN1Primitive(), new DERSet(aSN1EncodableVector));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SubjectKeyIdentifier createSubjectKeyId(PublicKey publicKey) {
        try {
            return new SubjectKeyIdentifier(getDigest(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded())));
        } catch (Exception unused) {
            throw new RuntimeException("error creating key");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void doStore(OutputStream outputStream, char[] cArr, boolean z) throws IOException {
        boolean z2;
        boolean z3;
        PKCS12KeyStoreSpi pKCS12KeyStoreSpi = this;
        int size = pKCS12KeyStoreSpi.keys.size();
        String str = ASN1Encoding.BER;
        if (size == 0) {
            if (cArr == null) {
                Enumeration enumerationKeys = pKCS12KeyStoreSpi.certs.keys();
                ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                while (enumerationKeys.hasMoreElements()) {
                    try {
                        String str2 = (String) enumerationKeys.nextElement();
                        aSN1EncodableVector.add(pKCS12KeyStoreSpi.createSafeBag(str2, (Certificate) pKCS12KeyStoreSpi.certs.get(str2)));
                    } catch (CertificateEncodingException e2) {
                        throw new IOException("Error encoding certificate: " + e2.toString());
                    }
                }
                ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.data;
                if (z) {
                    new Pfx(new ContentInfo(PKCSObjectIdentifiers.data, new DEROctetString(new DERSequence(new ContentInfo(aSN1ObjectIdentifier, new DEROctetString(new DERSequence(aSN1EncodableVector).getEncoded()))).getEncoded())), null).encodeTo(outputStream, ASN1Encoding.DER);
                    return;
                } else {
                    new Pfx(new ContentInfo(PKCSObjectIdentifiers.data, new BEROctetString(new BERSequence(new ContentInfo(aSN1ObjectIdentifier, new BEROctetString(new BERSequence(aSN1EncodableVector).getEncoded()))).getEncoded())), null).encodeTo(outputStream, ASN1Encoding.BER);
                    return;
                }
            }
        } else if (cArr == null) {
            throw new NullPointerException("no password supplied for PKCS#12 KeyStore");
        }
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        Enumeration enumerationKeys2 = pKCS12KeyStoreSpi.keys.keys();
        while (enumerationKeys2.hasMoreElements()) {
            byte[] bArr = new byte[20];
            pKCS12KeyStoreSpi.random.nextBytes(bArr);
            String str3 = (String) enumerationKeys2.nextElement();
            PrivateKey privateKey = (PrivateKey) pKCS12KeyStoreSpi.keys.get(str3);
            PKCS12PBEParams pKCS12PBEParams = new PKCS12PBEParams(bArr, MIN_ITERATIONS);
            EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = new EncryptedPrivateKeyInfo(new AlgorithmIdentifier(pKCS12KeyStoreSpi.keyAlgorithm, pKCS12PBEParams.toASN1Primitive()), pKCS12KeyStoreSpi.wrapKey(pKCS12KeyStoreSpi.keyAlgorithm.getId(), privateKey, pKCS12PBEParams, cArr));
            ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
            if (privateKey instanceof PKCS12BagAttributeCarrier) {
                PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier = (PKCS12BagAttributeCarrier) privateKey;
                DERBMPString dERBMPString = (DERBMPString) pKCS12BagAttributeCarrier.getBagAttribute(pkcs_9_at_friendlyName);
                if (dERBMPString == null || !dERBMPString.getString().equals(str3)) {
                    pKCS12BagAttributeCarrier.setBagAttribute(pkcs_9_at_friendlyName, new DERBMPString(str3));
                }
                if (pKCS12BagAttributeCarrier.getBagAttribute(pkcs_9_at_localKeyId) == null) {
                    pKCS12BagAttributeCarrier.setBagAttribute(pkcs_9_at_localKeyId, pKCS12KeyStoreSpi.createSubjectKeyId(pKCS12KeyStoreSpi.engineGetCertificate(str3).getPublicKey()));
                }
                Enumeration bagAttributeKeys = pKCS12BagAttributeCarrier.getBagAttributeKeys();
                z3 = false;
                while (bagAttributeKeys.hasMoreElements()) {
                    ASN1ObjectIdentifier aSN1ObjectIdentifier2 = (ASN1ObjectIdentifier) bagAttributeKeys.nextElement();
                    ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
                    aSN1EncodableVector4.add(aSN1ObjectIdentifier2);
                    aSN1EncodableVector4.add(new DERSet(pKCS12BagAttributeCarrier.getBagAttribute(aSN1ObjectIdentifier2)));
                    aSN1EncodableVector3.add(new DERSequence(aSN1EncodableVector4));
                    z3 = true;
                }
            } else {
                z3 = false;
            }
            if (!z3) {
                ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
                Certificate certificateEngineGetCertificate = pKCS12KeyStoreSpi.engineGetCertificate(str3);
                aSN1EncodableVector5.add(pkcs_9_at_localKeyId);
                aSN1EncodableVector5.add(new DERSet(pKCS12KeyStoreSpi.createSubjectKeyId(certificateEngineGetCertificate.getPublicKey())));
                aSN1EncodableVector3.add(new DERSequence(aSN1EncodableVector5));
                ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
                aSN1EncodableVector6.add(pkcs_9_at_friendlyName);
                aSN1EncodableVector6.add(new DERSet(new DERBMPString(str3)));
                aSN1EncodableVector3.add(new DERSequence(aSN1EncodableVector6));
            }
            aSN1EncodableVector2.add(new SafeBag(pkcs8ShroudedKeyBag, encryptedPrivateKeyInfo.toASN1Primitive(), new DERSet(aSN1EncodableVector3)));
        }
        BEROctetString bEROctetString = new BEROctetString(new DERSequence(aSN1EncodableVector2).getEncoded(ASN1Encoding.DER));
        byte[] bArr2 = new byte[20];
        pKCS12KeyStoreSpi.random.nextBytes(bArr2);
        ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(pKCS12KeyStoreSpi.certAlgorithm, new PKCS12PBEParams(bArr2, MIN_ITERATIONS).toASN1Primitive());
        Hashtable hashtable = new Hashtable();
        Enumeration enumerationKeys3 = pKCS12KeyStoreSpi.keys.keys();
        while (enumerationKeys3.hasMoreElements()) {
            try {
                String str4 = (String) enumerationKeys3.nextElement();
                Certificate certificateEngineGetCertificate2 = pKCS12KeyStoreSpi.engineGetCertificate(str4);
                AlgorithmIdentifier algorithmIdentifier2 = algorithmIdentifier;
                CertBag certBag = new CertBag(x509Certificate, new DEROctetString(certificateEngineGetCertificate2.getEncoded()));
                ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
                if (certificateEngineGetCertificate2 instanceof PKCS12BagAttributeCarrier) {
                    PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier2 = (PKCS12BagAttributeCarrier) certificateEngineGetCertificate2;
                    DERBMPString dERBMPString2 = (DERBMPString) pKCS12BagAttributeCarrier2.getBagAttribute(pkcs_9_at_friendlyName);
                    if (dERBMPString2 == null || !dERBMPString2.getString().equals(str4)) {
                        pKCS12BagAttributeCarrier2.setBagAttribute(pkcs_9_at_friendlyName, new DERBMPString(str4));
                    }
                    if (pKCS12BagAttributeCarrier2.getBagAttribute(pkcs_9_at_localKeyId) == null) {
                        pKCS12BagAttributeCarrier2.setBagAttribute(pkcs_9_at_localKeyId, pKCS12KeyStoreSpi.createSubjectKeyId(certificateEngineGetCertificate2.getPublicKey()));
                    }
                    Enumeration bagAttributeKeys2 = pKCS12BagAttributeCarrier2.getBagAttributeKeys();
                    z2 = false;
                    while (bagAttributeKeys2.hasMoreElements()) {
                        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = (ASN1ObjectIdentifier) bagAttributeKeys2.nextElement();
                        Enumeration enumeration = bagAttributeKeys2;
                        ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
                        aSN1EncodableVector9.add(aSN1ObjectIdentifier3);
                        aSN1EncodableVector9.add(new DERSet(pKCS12BagAttributeCarrier2.getBagAttribute(aSN1ObjectIdentifier3)));
                        aSN1EncodableVector8.add(new DERSequence(aSN1EncodableVector9));
                        z2 = true;
                        bagAttributeKeys2 = enumeration;
                        enumerationKeys3 = enumerationKeys3;
                    }
                } else {
                    z2 = false;
                }
                Enumeration enumeration2 = enumerationKeys3;
                if (!z2) {
                    ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector();
                    aSN1EncodableVector10.add(pkcs_9_at_localKeyId);
                    aSN1EncodableVector10.add(new DERSet(pKCS12KeyStoreSpi.createSubjectKeyId(certificateEngineGetCertificate2.getPublicKey())));
                    aSN1EncodableVector8.add(new DERSequence(aSN1EncodableVector10));
                    ASN1EncodableVector aSN1EncodableVector11 = new ASN1EncodableVector();
                    aSN1EncodableVector11.add(pkcs_9_at_friendlyName);
                    aSN1EncodableVector11.add(new DERSet(new DERBMPString(str4)));
                    aSN1EncodableVector8.add(new DERSequence(aSN1EncodableVector11));
                }
                aSN1EncodableVector7.add(new SafeBag(certBag, certBag.toASN1Primitive(), new DERSet(aSN1EncodableVector8)));
                hashtable.put(certificateEngineGetCertificate2, certificateEngineGetCertificate2);
                algorithmIdentifier = algorithmIdentifier2;
                enumerationKeys3 = enumeration2;
            } catch (CertificateEncodingException e3) {
                throw new IOException("Error encoding certificate: " + e3.toString());
            }
        }
        AlgorithmIdentifier algorithmIdentifier3 = algorithmIdentifier;
        Enumeration enumerationKeys4 = pKCS12KeyStoreSpi.certs.keys();
        while (enumerationKeys4.hasMoreElements()) {
            try {
                String str5 = (String) enumerationKeys4.nextElement();
                Certificate certificate = (Certificate) pKCS12KeyStoreSpi.certs.get(str5);
                if (pKCS12KeyStoreSpi.keys.get(str5) == null) {
                    aSN1EncodableVector7.add(pKCS12KeyStoreSpi.createSafeBag(str5, certificate));
                    hashtable.put(certificate, certificate);
                }
            } catch (CertificateEncodingException e4) {
                throw new IOException("Error encoding certificate: " + e4.toString());
            }
        }
        Set usedCertificateSet = pKCS12KeyStoreSpi.getUsedCertificateSet();
        Enumeration enumerationKeys5 = pKCS12KeyStoreSpi.chainCerts.keys();
        while (enumerationKeys5.hasMoreElements()) {
            try {
                Certificate certificate2 = (Certificate) pKCS12KeyStoreSpi.chainCerts.get((CertId) enumerationKeys5.nextElement());
                if (usedCertificateSet.contains(certificate2) && hashtable.get(certificate2) == null) {
                    CertBag certBag2 = new CertBag(x509Certificate, new DEROctetString(certificate2.getEncoded()));
                    ASN1EncodableVector aSN1EncodableVector12 = new ASN1EncodableVector();
                    if (certificate2 instanceof PKCS12BagAttributeCarrier) {
                        PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier3 = (PKCS12BagAttributeCarrier) certificate2;
                        Enumeration bagAttributeKeys3 = pKCS12BagAttributeCarrier3.getBagAttributeKeys();
                        while (bagAttributeKeys3.hasMoreElements()) {
                            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = (ASN1ObjectIdentifier) bagAttributeKeys3.nextElement();
                            if (!aSN1ObjectIdentifier4.equals((ASN1Primitive) PKCSObjectIdentifiers.pkcs_9_at_localKeyId)) {
                                ASN1EncodableVector aSN1EncodableVector13 = new ASN1EncodableVector();
                                aSN1EncodableVector13.add(aSN1ObjectIdentifier4);
                                aSN1EncodableVector13.add(new DERSet(pKCS12BagAttributeCarrier3.getBagAttribute(aSN1ObjectIdentifier4)));
                                aSN1EncodableVector12.add(new DERSequence(aSN1EncodableVector13));
                            }
                        }
                    }
                    aSN1EncodableVector7.add(new SafeBag(certBag, certBag2.toASN1Primitive(), new DERSet(aSN1EncodableVector12)));
                    pKCS12KeyStoreSpi = this;
                }
            } catch (CertificateEncodingException e5) {
                throw new IOException("Error encoding certificate: " + e5.toString());
            }
        }
        ContentInfo contentInfo = new ContentInfo(data, new BEROctetString(new AuthenticatedSafe(new ContentInfo[]{new ContentInfo(data, bEROctetString), new ContentInfo(encryptedData, new EncryptedData(data, algorithmIdentifier3, new BEROctetString(cryptData(true, algorithmIdentifier3, cArr, false, new DERSequence(aSN1EncodableVector7).getEncoded(ASN1Encoding.DER)))).toASN1Primitive())}).getEncoded(z ? ASN1Encoding.DER : ASN1Encoding.BER)));
        byte[] bArr3 = new byte[this.saltLength];
        this.random.nextBytes(bArr3);
        try {
            Pfx pfx = new Pfx(contentInfo, new MacData(new DigestInfo(this.macAlgorithm, calculatePbeMac(this.macAlgorithm.getAlgorithm(), bArr3, this.itCount, cArr, false, ((ASN1OctetString) contentInfo.getContent()).getOctets())), bArr3, this.itCount));
            if (z) {
                str = ASN1Encoding.DER;
            }
            pfx.encodeTo(outputStream, str);
        } catch (Exception e6) {
            throw new IOException("error constructing MAC: " + e6.toString());
        }
    }

    private static byte[] getDigest(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        Digest digestCreateSHA1 = DigestFactory.createSHA1();
        byte[] bArr = new byte[digestCreateSHA1.getDigestSize()];
        byte[] bytes = subjectPublicKeyInfo.getPublicKeyData().getBytes();
        digestCreateSHA1.update(bytes, 0, bytes.length);
        digestCreateSHA1.doFinal(bArr, 0);
        return bArr;
    }

    private Set getUsedCertificateSet() {
        HashSet hashSet = new HashSet();
        Enumeration enumerationKeys = this.keys.keys();
        while (enumerationKeys.hasMoreElements()) {
            Certificate[] certificateArrEngineGetCertificateChain = engineGetCertificateChain((String) enumerationKeys.nextElement());
            for (int i = 0; i != certificateArrEngineGetCertificateChain.length; i++) {
                hashSet.add(certificateArrEngineGetCertificateChain[i]);
            }
        }
        Enumeration enumerationKeys2 = this.certs.keys();
        while (enumerationKeys2.hasMoreElements()) {
            hashSet.add(engineGetCertificate((String) enumerationKeys2.nextElement()));
        }
        return hashSet;
    }

    private int validateIterationCount(BigInteger bigInteger) {
        int iIntValue = bigInteger.intValue();
        if (iIntValue < 0) {
            throw new IllegalStateException("negative iteration count found");
        }
        BigInteger bigIntegerAsBigInteger = Properties.asBigInteger(PKCS12_MAX_IT_COUNT_PROPERTY);
        if (bigIntegerAsBigInteger == null || bigIntegerAsBigInteger.intValue() >= iIntValue) {
            return iIntValue;
        }
        throw new IllegalStateException("iteration count " + iIntValue + " greater than " + bigIntegerAsBigInteger.intValue());
    }

    protected byte[] cryptData(boolean z, AlgorithmIdentifier algorithmIdentifier, char[] cArr, boolean z2, byte[] bArr) throws IOException {
        ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
        int i = z ? 1 : 2;
        if (!algorithm.on(PKCSObjectIdentifiers.pkcs_12PbeIds)) {
            if (!algorithm.equals((ASN1Primitive) PKCSObjectIdentifiers.id_PBES2)) {
                throw new IOException("unknown PBE algorithm: " + algorithm);
            }
            try {
                return createCipher(i, cArr, algorithmIdentifier).doFinal(bArr);
            } catch (Exception e2) {
                throw new IOException("exception decrypting data - " + e2.toString());
            }
        }
        PKCS12PBEParams pKCS12PBEParams = PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters());
        try {
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.getIV(), pKCS12PBEParams.getIterations().intValue());
            PKCS12Key pKCS12Key = new PKCS12Key(cArr, z2);
            Cipher cipherCreateCipher = this.f1438helper.createCipher(algorithm.getId());
            cipherCreateCipher.init(i, pKCS12Key, pBEParameterSpec);
            return cipherCreateCipher.doFinal(bArr);
        } catch (Exception e3) {
            throw new IOException("exception decrypting data - " + e3.toString());
        }
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration engineAliases() {
        Hashtable hashtable = new Hashtable();
        Enumeration enumerationKeys = this.certs.keys();
        while (enumerationKeys.hasMoreElements()) {
            hashtable.put(enumerationKeys.nextElement(), "cert");
        }
        Enumeration enumerationKeys2 = this.keys.keys();
        while (enumerationKeys2.hasMoreElements()) {
            String str = (String) enumerationKeys2.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.keys();
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineContainsAlias(String str) {
        return (this.certs.get(str) == null && this.keys.get(str) == null) ? false : true;
    }

    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String str) throws KeyStoreException {
        Key key = (Key) this.keys.remove(str);
        Certificate certificate = (Certificate) this.certs.remove(str);
        if (certificate != null) {
            this.chainCerts.remove(new CertId(certificate.getPublicKey()));
        }
        if (key != null) {
            String str2 = (String) this.localIds.remove(str);
            if (str2 != null) {
                certificate = (Certificate) this.keyCerts.remove(str2);
            }
            if (certificate != null) {
                this.chainCerts.remove(new CertId(certificate.getPublicKey()));
            }
        }
    }

    @Override // java.security.KeyStoreSpi
    public Certificate engineGetCertificate(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null alias passed to getCertificate.");
        }
        Certificate certificate = (Certificate) this.certs.get(str);
        if (certificate != null) {
            return certificate;
        }
        String str2 = (String) this.localIds.get(str);
        return (Certificate) (str2 != null ? this.keyCerts.get(str2) : this.keyCerts.get(str));
    }

    @Override // java.security.KeyStoreSpi
    public String engineGetCertificateAlias(Certificate certificate) {
        Enumeration enumerationElements = this.certs.elements();
        Enumeration enumerationKeys = this.certs.keys();
        while (enumerationElements.hasMoreElements()) {
            Certificate certificate2 = (Certificate) enumerationElements.nextElement();
            String str = (String) enumerationKeys.nextElement();
            if (certificate2.equals(certificate)) {
                return str;
            }
        }
        Enumeration enumerationElements2 = this.keyCerts.elements();
        Enumeration enumerationKeys2 = this.keyCerts.keys();
        while (enumerationElements2.hasMoreElements()) {
            Certificate certificate3 = (Certificate) enumerationElements2.nextElement();
            String str2 = (String) enumerationKeys2.nextElement();
            if (certificate3.equals(certificate)) {
                return str2;
            }
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public Certificate[] engineGetCertificateChain(String str) {
        byte[] keyIdentifier;
        if (str == null) {
            throw new IllegalArgumentException("null alias passed to getCertificateChain.");
        }
        Certificate[] certificateArr = null;
        if (!engineIsKeyEntry(str)) {
            return null;
        }
        Certificate certificateEngineGetCertificate = engineGetCertificate(str);
        if (certificateEngineGetCertificate != null) {
            Vector vector = new Vector();
            while (certificateEngineGetCertificate != null) {
                X509Certificate x509Certificate = (X509Certificate) certificateEngineGetCertificate;
                byte[] extensionValue = x509Certificate.getExtensionValue(Extension.authorityKeyIdentifier.getId());
                Certificate certificate = (extensionValue == null || (keyIdentifier = AuthorityKeyIdentifier.getInstance(ASN1OctetString.getInstance(extensionValue).getOctets()).getKeyIdentifier()) == null) ? null : (Certificate) this.chainCerts.get(new CertId(keyIdentifier));
                if (certificate == null) {
                    Principal issuerDN = x509Certificate.getIssuerDN();
                    if (!issuerDN.equals(x509Certificate.getSubjectDN())) {
                        Enumeration enumerationKeys = this.chainCerts.keys();
                        while (true) {
                            if (!enumerationKeys.hasMoreElements()) {
                                break;
                            }
                            X509Certificate x509Certificate2 = (X509Certificate) this.chainCerts.get(enumerationKeys.nextElement());
                            if (x509Certificate2.getSubjectDN().equals(issuerDN)) {
                                try {
                                    x509Certificate.verify(x509Certificate2.getPublicKey());
                                    certificate = x509Certificate2;
                                    break;
                                } catch (Exception unused) {
                                    continue;
                                }
                            }
                        }
                    }
                }
                if (!vector.contains(certificateEngineGetCertificate)) {
                    vector.addElement(certificateEngineGetCertificate);
                    if (certificate != certificateEngineGetCertificate) {
                        certificateEngineGetCertificate = certificate;
                    }
                }
                certificateEngineGetCertificate = null;
            }
            int size = vector.size();
            certificateArr = new Certificate[size];
            for (int i = 0; i != size; i++) {
                certificateArr[i] = (Certificate) vector.elementAt(i);
            }
        }
        return certificateArr;
    }

    @Override // java.security.KeyStoreSpi
    public Date engineGetCreationDate(String str) {
        if (str == null) {
            throw new NullPointerException("alias == null");
        }
        if (this.keys.get(str) == null && this.certs.get(str) == null) {
            return null;
        }
        return new Date();
    }

    @Override // java.security.KeyStoreSpi
    public Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        if (str != null) {
            return (Key) this.keys.get(str);
        }
        throw new IllegalArgumentException("null alias passed to getKey.");
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsCertificateEntry(String str) {
        return this.certs.get(str) != null && this.keys.get(str) == null;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsKeyEntry(String str) {
        return this.keys.get(str) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fd  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.security.KeyStoreSpi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void engineLoad(java.io.InputStream r22, char[] r23) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.engineLoad(java.io.InputStream, char[]):void");
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
        if (this.keys.get(str) != null) {
            throw new KeyStoreException("There is a key entry with the name " + str + InstructionFileId.DOT);
        }
        this.certs.put(str, certificate);
        this.chainCerts.put(new CertId(certificate.getPublicKey()), certificate);
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
        boolean z = key instanceof PrivateKey;
        if (!z) {
            throw new KeyStoreException("PKCS12 does not support non-PrivateKeys");
        }
        if (z && certificateArr == null) {
            throw new KeyStoreException("no certificate chain for private key");
        }
        if (this.keys.get(str) != null) {
            engineDeleteEntry(str);
        }
        this.keys.put(str, key);
        if (certificateArr != null) {
            this.certs.put(str, certificateArr[0]);
            for (int i = 0; i != certificateArr.length; i++) {
                this.chainCerts.put(new CertId(certificateArr[i].getPublicKey()), certificateArr[i]);
            }
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
        throw new RuntimeException("operation not supported");
    }

    @Override // java.security.KeyStoreSpi
    public int engineSize() {
        Hashtable hashtable = new Hashtable();
        Enumeration enumerationKeys = this.certs.keys();
        while (enumerationKeys.hasMoreElements()) {
            hashtable.put(enumerationKeys.nextElement(), "cert");
        }
        Enumeration enumerationKeys2 = this.keys.keys();
        while (enumerationKeys2.hasMoreElements()) {
            String str = (String) enumerationKeys2.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.size();
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream outputStream, char[] cArr) throws IOException {
        doStore(outputStream, cArr, false);
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) throws NoSuchAlgorithmException, IOException, CertificateException {
        PKCS12StoreParameter pKCS12StoreParameter;
        char[] password;
        if (loadStoreParameter == null) {
            throw new IllegalArgumentException("'param' arg cannot be null");
        }
        boolean z = loadStoreParameter instanceof PKCS12StoreParameter;
        if (!z && !(loadStoreParameter instanceof JDKPKCS12StoreParameter)) {
            throw new IllegalArgumentException("No support for 'param' of type " + loadStoreParameter.getClass().getName());
        }
        if (z) {
            pKCS12StoreParameter = (PKCS12StoreParameter) loadStoreParameter;
        } else {
            JDKPKCS12StoreParameter jDKPKCS12StoreParameter = (JDKPKCS12StoreParameter) loadStoreParameter;
            pKCS12StoreParameter = new PKCS12StoreParameter(jDKPKCS12StoreParameter.getOutputStream(), loadStoreParameter.getProtectionParameter(), jDKPKCS12StoreParameter.isUseDEREncoding());
        }
        KeyStore.ProtectionParameter protectionParameter = loadStoreParameter.getProtectionParameter();
        if (protectionParameter == null) {
            password = null;
        } else {
            if (!(protectionParameter instanceof KeyStore.PasswordProtection)) {
                throw new IllegalArgumentException("No support for protection parameter of type " + protectionParameter.getClass().getName());
            }
            password = ((KeyStore.PasswordProtection) protectionParameter).getPassword();
        }
        doStore(pKCS12StoreParameter.getOutputStream(), password, pKCS12StoreParameter.isForDEREncoding());
    }

    @Override // org.bouncycastle.jce.interfaces.BCKeyStore
    public void setRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
    }

    protected PrivateKey unwrapKey(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, char[] cArr, boolean z) throws IOException {
        Cipher cipherCreateCipher;
        ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
        try {
            if (algorithm.on(PKCSObjectIdentifiers.pkcs_12PbeIds)) {
                PKCS12PBEParams pKCS12PBEParams = PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters());
                PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.getIV(), validateIterationCount(pKCS12PBEParams.getIterations()));
                cipherCreateCipher = this.f1438helper.createCipher(algorithm.getId());
                cipherCreateCipher.init(4, new PKCS12Key(cArr, z), pBEParameterSpec);
            } else {
                if (!algorithm.equals((ASN1Primitive) PKCSObjectIdentifiers.id_PBES2)) {
                    throw new IOException("exception unwrapping private key - cannot recognise: " + algorithm);
                }
                cipherCreateCipher = createCipher(4, cArr, algorithmIdentifier);
            }
            return (PrivateKey) cipherCreateCipher.unwrap(bArr, "", 2);
        } catch (Exception e2) {
            throw new IOException("exception unwrapping private key - " + e2.toString());
        }
    }

    protected byte[] wrapKey(String str, Key key, PKCS12PBEParams pKCS12PBEParams, char[] cArr) throws IOException {
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
        try {
            SecretKeyFactory secretKeyFactoryCreateSecretKeyFactory = this.f1438helper.createSecretKeyFactory(str);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.getIV(), pKCS12PBEParams.getIterations().intValue());
            Cipher cipherCreateCipher = this.f1438helper.createCipher(str);
            cipherCreateCipher.init(3, secretKeyFactoryCreateSecretKeyFactory.generateSecret(pBEKeySpec), pBEParameterSpec);
            return cipherCreateCipher.wrap(key);
        } catch (Exception e2) {
            throw new IOException("exception encrypting data - " + e2.toString());
        }
    }
}
