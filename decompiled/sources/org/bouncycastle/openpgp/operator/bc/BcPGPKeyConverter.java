package org.bouncycastle.openpgp.operator.bc;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cryptlib.CryptlibObjectIdentifiers;
import org.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import org.bouncycastle.asn1.gnu.GNUObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.bcpg.BCPGKey;
import org.bouncycastle.bcpg.DSAPublicBCPGKey;
import org.bouncycastle.bcpg.DSASecretBCPGKey;
import org.bouncycastle.bcpg.ECDHPublicBCPGKey;
import org.bouncycastle.bcpg.ECDSAPublicBCPGKey;
import org.bouncycastle.bcpg.ECPublicBCPGKey;
import org.bouncycastle.bcpg.ECSecretBCPGKey;
import org.bouncycastle.bcpg.EdDSAPublicBCPGKey;
import org.bouncycastle.bcpg.EdSecretBCPGKey;
import org.bouncycastle.bcpg.ElGamalPublicBCPGKey;
import org.bouncycastle.bcpg.ElGamalSecretBCPGKey;
import org.bouncycastle.bcpg.PublicKeyPacket;
import org.bouncycastle.bcpg.RSAPublicBCPGKey;
import org.bouncycastle.bcpg.RSASecretBCPGKey;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.crypto.params.ECNamedDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.crypto.params.ElGamalParameters;
import org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.bouncycastle.crypto.params.ElGamalPublicKeyParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.crypto.params.X25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.X25519PublicKeyParameters;
import org.bouncycastle.crypto.util.PrivateKeyFactory;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.crypto.util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.openpgp.PGPAlgorithmParameters;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPKdfParameters;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes10.dex */
public class BcPGPKeyConverter {
    private BCPGKey getPrivateBCPGKey(PGPPublicKey pGPPublicKey, AsymmetricKeyParameter asymmetricKeyParameter) throws PGPException {
        int algorithm = pGPPublicKey.getAlgorithm();
        if (algorithm == 1 || algorithm == 2 || algorithm == 3) {
            RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters = (RSAPrivateCrtKeyParameters) asymmetricKeyParameter;
            return new RSASecretBCPGKey(rSAPrivateCrtKeyParameters.getExponent(), rSAPrivateCrtKeyParameters.getP(), rSAPrivateCrtKeyParameters.getQ());
        }
        if (algorithm == 22) {
            return new EdSecretBCPGKey(new BigInteger(1, ((Ed25519PrivateKeyParameters) asymmetricKeyParameter).getEncoded()));
        }
        switch (algorithm) {
            case 16:
            case 20:
                return new ElGamalSecretBCPGKey(((ElGamalPrivateKeyParameters) asymmetricKeyParameter).getX());
            case 17:
                return new DSASecretBCPGKey(((DSAPrivateKeyParameters) asymmetricKeyParameter).getX());
            case 18:
                return asymmetricKeyParameter instanceof ECPrivateKeyParameters ? new ECSecretBCPGKey(((ECPrivateKeyParameters) asymmetricKeyParameter).getD()) : new ECSecretBCPGKey(new BigInteger(1, Arrays.reverse(((X25519PrivateKeyParameters) asymmetricKeyParameter).getEncoded())));
            case 19:
                return new ECSecretBCPGKey(((ECPrivateKeyParameters) asymmetricKeyParameter).getD());
            default:
                throw new PGPException("unknown key class");
        }
    }

    private BCPGKey getPublicBCPGKey(int i, PGPAlgorithmParameters pGPAlgorithmParameters, AsymmetricKeyParameter asymmetricKeyParameter, Date date) throws PGPException {
        if (asymmetricKeyParameter instanceof RSAKeyParameters) {
            RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) asymmetricKeyParameter;
            return new RSAPublicBCPGKey(rSAKeyParameters.getModulus(), rSAKeyParameters.getExponent());
        }
        if (asymmetricKeyParameter instanceof DSAPublicKeyParameters) {
            DSAPublicKeyParameters dSAPublicKeyParameters = (DSAPublicKeyParameters) asymmetricKeyParameter;
            DSAParameters parameters = dSAPublicKeyParameters.getParameters();
            return new DSAPublicBCPGKey(parameters.getP(), parameters.getQ(), parameters.getG(), dSAPublicKeyParameters.getY());
        }
        if (asymmetricKeyParameter instanceof ElGamalPublicKeyParameters) {
            ElGamalPublicKeyParameters elGamalPublicKeyParameters = (ElGamalPublicKeyParameters) asymmetricKeyParameter;
            ElGamalParameters parameters2 = elGamalPublicKeyParameters.getParameters();
            return new ElGamalPublicBCPGKey(parameters2.getP(), parameters2.getG(), elGamalPublicKeyParameters.getY());
        }
        if (!(asymmetricKeyParameter instanceof ECPublicKeyParameters)) {
            if (asymmetricKeyParameter instanceof Ed25519PublicKeyParameters) {
                byte[] bArr = new byte[33];
                bArr[0] = 64;
                ((Ed25519PublicKeyParameters) asymmetricKeyParameter).encode(bArr, 1);
                return new EdDSAPublicBCPGKey(GNUObjectIdentifiers.Ed25519, new BigInteger(1, bArr));
            }
            if (!(asymmetricKeyParameter instanceof X25519PublicKeyParameters)) {
                throw new PGPException("unknown key class");
            }
            byte[] bArr2 = new byte[33];
            bArr2[0] = 64;
            ((X25519PublicKeyParameters) asymmetricKeyParameter).encode(bArr2, 1);
            PGPKdfParameters pGPKdfParameters = (PGPKdfParameters) pGPAlgorithmParameters;
            if (pGPKdfParameters == null) {
                pGPKdfParameters = new PGPKdfParameters(8, 7);
            }
            return new ECDHPublicBCPGKey(CryptlibObjectIdentifiers.curvey25519, new BigInteger(1, bArr2), pGPKdfParameters.getHashAlgorithm(), pGPKdfParameters.getSymmetricWrapAlgorithm());
        }
        try {
            SubjectPublicKeyInfo subjectPublicKeyInfoCreateSubjectPublicKeyInfo = SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(asymmetricKeyParameter);
            ASN1ObjectIdentifier aSN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(subjectPublicKeyInfoCreateSubjectPublicKeyInfo.getAlgorithm().getParameters());
            X9ECPoint x9ECPoint = new X9ECPoint(ECNamedCurveTable.getByOID(aSN1ObjectIdentifier).getCurve(), new DEROctetString(subjectPublicKeyInfoCreateSubjectPublicKeyInfo.getPublicKeyData().getBytes()));
            if (i != 18) {
                if (i == 19) {
                    return new ECDSAPublicBCPGKey(aSN1ObjectIdentifier, x9ECPoint.getPoint());
                }
                throw new PGPException("unknown EC algorithm");
            }
            PGPKdfParameters pGPKdfParameters2 = (PGPKdfParameters) pGPAlgorithmParameters;
            if (pGPKdfParameters2 == null) {
                pGPKdfParameters2 = new PGPKdfParameters(8, 7);
            }
            return new ECDHPublicBCPGKey(aSN1ObjectIdentifier, x9ECPoint.getPoint(), pGPKdfParameters2.getHashAlgorithm(), pGPKdfParameters2.getSymmetricWrapAlgorithm());
        } catch (IOException e2) {
            throw new PGPException("Unable to encode key: " + e2.getMessage(), e2);
        }
    }

    private ECNamedDomainParameters implGetParametersEC(ECPublicBCPGKey eCPublicBCPGKey) {
        ASN1ObjectIdentifier curveOID = eCPublicBCPGKey.getCurveOID();
        X9ECParameters x9Parameters = BcUtil.getX9Parameters(curveOID);
        return new ECNamedDomainParameters(curveOID, x9Parameters.getCurve(), x9Parameters.getG(), x9Parameters.getN(), x9Parameters.getH());
    }

    private AsymmetricKeyParameter implGetPrivateKeyEC(ECPublicBCPGKey eCPublicBCPGKey, ECSecretBCPGKey eCSecretBCPGKey) throws IOException, PGPException {
        return new ECPrivateKeyParameters(eCSecretBCPGKey.getX(), implGetParametersEC(eCPublicBCPGKey));
    }

    private AsymmetricKeyParameter implGetPrivateKeyPKCS8(PrivateKeyInfo privateKeyInfo) throws IOException {
        return PrivateKeyFactory.createKey(privateKeyInfo);
    }

    private AsymmetricKeyParameter implGetPublicKeyEC(ECPublicBCPGKey eCPublicBCPGKey) throws IOException, PGPException {
        ECNamedDomainParameters eCNamedDomainParametersImplGetParametersEC = implGetParametersEC(eCPublicBCPGKey);
        return new ECPublicKeyParameters(BcUtil.decodePoint(eCPublicBCPGKey.getEncodedPoint(), eCNamedDomainParametersImplGetParametersEC.getCurve()), eCNamedDomainParametersImplGetParametersEC);
    }

    private AsymmetricKeyParameter implGetPublicKeyX509(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        return PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    public PGPPrivateKey getPGPPrivateKey(PGPPublicKey pGPPublicKey, AsymmetricKeyParameter asymmetricKeyParameter) throws PGPException {
        return new PGPPrivateKey(pGPPublicKey.getKeyID(), pGPPublicKey.getPublicKeyPacket(), getPrivateBCPGKey(pGPPublicKey, asymmetricKeyParameter));
    }

    public PGPPublicKey getPGPPublicKey(int i, PGPAlgorithmParameters pGPAlgorithmParameters, AsymmetricKeyParameter asymmetricKeyParameter, Date date) throws PGPException {
        return new PGPPublicKey(new PublicKeyPacket(i, date, getPublicBCPGKey(i, pGPAlgorithmParameters, asymmetricKeyParameter, date)), new BcKeyFingerprintCalculator());
    }

    public AsymmetricKeyParameter getPrivateKey(PGPPrivateKey pGPPrivateKey) throws PGPException {
        PrivateKeyInfo privateKeyInfo;
        ECPublicBCPGKey eCPublicBCPGKey;
        ECSecretBCPGKey eCSecretBCPGKey;
        PublicKeyPacket publicKeyPacket = pGPPrivateKey.getPublicKeyPacket();
        BCPGKey privateKeyDataPacket = pGPPrivateKey.getPrivateKeyDataPacket();
        try {
            int algorithm = publicKeyPacket.getAlgorithm();
            if (algorithm == 1 || algorithm == 2 || algorithm == 3) {
                RSASecretBCPGKey rSASecretBCPGKey = (RSASecretBCPGKey) privateKeyDataPacket;
                return new RSAPrivateCrtKeyParameters(rSASecretBCPGKey.getModulus(), ((RSAPublicBCPGKey) publicKeyPacket.getKey()).getPublicExponent(), rSASecretBCPGKey.getPrivateExponent(), rSASecretBCPGKey.getPrimeP(), rSASecretBCPGKey.getPrimeQ(), rSASecretBCPGKey.getPrimeExponentP(), rSASecretBCPGKey.getPrimeExponentQ(), rSASecretBCPGKey.getCrtCoefficient());
            }
            if (algorithm != 22) {
                switch (algorithm) {
                    case 16:
                    case 20:
                        ElGamalPublicBCPGKey elGamalPublicBCPGKey = (ElGamalPublicBCPGKey) publicKeyPacket.getKey();
                        return new ElGamalPrivateKeyParameters(((ElGamalSecretBCPGKey) privateKeyDataPacket).getX(), new ElGamalParameters(elGamalPublicBCPGKey.getP(), elGamalPublicBCPGKey.getG()));
                    case 17:
                        DSAPublicBCPGKey dSAPublicBCPGKey = (DSAPublicBCPGKey) publicKeyPacket.getKey();
                        return new DSAPrivateKeyParameters(((DSASecretBCPGKey) privateKeyDataPacket).getX(), new DSAParameters(dSAPublicBCPGKey.getP(), dSAPublicBCPGKey.getQ(), dSAPublicBCPGKey.getG()));
                    case 18:
                        eCPublicBCPGKey = (ECDHPublicBCPGKey) publicKeyPacket.getKey();
                        eCSecretBCPGKey = (ECSecretBCPGKey) privateKeyDataPacket;
                        if (CryptlibObjectIdentifiers.curvey25519.equals((ASN1Primitive) eCPublicBCPGKey.getCurveOID())) {
                            privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_X25519), new DEROctetString(Arrays.reverse(BigIntegers.asUnsignedByteArray(eCSecretBCPGKey.getX()))));
                            break;
                        }
                        return implGetPrivateKeyEC(eCPublicBCPGKey, eCSecretBCPGKey);
                    case 19:
                        eCPublicBCPGKey = (ECDSAPublicBCPGKey) publicKeyPacket.getKey();
                        eCSecretBCPGKey = (ECSecretBCPGKey) privateKeyDataPacket;
                        return implGetPrivateKeyEC(eCPublicBCPGKey, eCSecretBCPGKey);
                    default:
                        throw new PGPException("unknown public key algorithm encountered");
                }
            }
            privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_Ed25519), new DEROctetString(BigIntegers.asUnsignedByteArray(((EdSecretBCPGKey) privateKeyDataPacket).getX())));
            return implGetPrivateKeyPKCS8(privateKeyInfo);
        } catch (PGPException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new PGPException("Exception constructing key", e3);
        }
    }

    public AsymmetricKeyParameter getPublicKey(PGPPublicKey pGPPublicKey) throws PGPException {
        SubjectPublicKeyInfo subjectPublicKeyInfo;
        ECPublicBCPGKey eCPublicBCPGKey;
        PublicKeyPacket publicKeyPacket = pGPPublicKey.getPublicKeyPacket();
        try {
            int algorithm = publicKeyPacket.getAlgorithm();
            if (algorithm == 1 || algorithm == 2 || algorithm == 3) {
                RSAPublicBCPGKey rSAPublicBCPGKey = (RSAPublicBCPGKey) publicKeyPacket.getKey();
                return new RSAKeyParameters(false, rSAPublicBCPGKey.getModulus(), rSAPublicBCPGKey.getPublicExponent());
            }
            if (algorithm != 22) {
                switch (algorithm) {
                    case 16:
                    case 20:
                        ElGamalPublicBCPGKey elGamalPublicBCPGKey = (ElGamalPublicBCPGKey) publicKeyPacket.getKey();
                        return new ElGamalPublicKeyParameters(elGamalPublicBCPGKey.getY(), new ElGamalParameters(elGamalPublicBCPGKey.getP(), elGamalPublicBCPGKey.getG()));
                    case 17:
                        DSAPublicBCPGKey dSAPublicBCPGKey = (DSAPublicBCPGKey) publicKeyPacket.getKey();
                        return new DSAPublicKeyParameters(dSAPublicBCPGKey.getY(), new DSAParameters(dSAPublicBCPGKey.getP(), dSAPublicBCPGKey.getQ(), dSAPublicBCPGKey.getG()));
                    case 18:
                        eCPublicBCPGKey = (ECDHPublicBCPGKey) publicKeyPacket.getKey();
                        if (eCPublicBCPGKey.getCurveOID().equals((ASN1Primitive) CryptlibObjectIdentifiers.curvey25519)) {
                            byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(eCPublicBCPGKey.getEncodedPoint());
                            if (bArrAsUnsignedByteArray.length < 1 || 64 != bArrAsUnsignedByteArray[0]) {
                                throw new IllegalArgumentException("Invalid Curve25519 public key");
                            }
                            subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_X25519), Arrays.copyOfRange(bArrAsUnsignedByteArray, 1, bArrAsUnsignedByteArray.length));
                            break;
                        }
                        return implGetPublicKeyEC(eCPublicBCPGKey);
                    case 19:
                        eCPublicBCPGKey = (ECDSAPublicBCPGKey) publicKeyPacket.getKey();
                        return implGetPublicKeyEC(eCPublicBCPGKey);
                    default:
                        throw new PGPException("unknown public key algorithm encountered");
                }
            }
            byte[] bArrAsUnsignedByteArray2 = BigIntegers.asUnsignedByteArray(((EdDSAPublicBCPGKey) publicKeyPacket.getKey()).getEncodedPoint());
            if (bArrAsUnsignedByteArray2.length < 1 || 64 != bArrAsUnsignedByteArray2[0]) {
                throw new IllegalArgumentException("Invalid Ed25519 public key");
            }
            subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_Ed25519), Arrays.copyOfRange(bArrAsUnsignedByteArray2, 1, bArrAsUnsignedByteArray2.length));
            return implGetPublicKeyX509(subjectPublicKeyInfo);
        } catch (PGPException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new PGPException("exception constructing public key", e3);
        }
    }
}
