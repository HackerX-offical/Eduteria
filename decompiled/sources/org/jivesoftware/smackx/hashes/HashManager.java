package org.jivesoftware.smackx.hashes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.hashes.element.HashElement;

/* JADX INFO: loaded from: classes10.dex */
public final class HashManager extends Manager {
    public static final String PREFIX_NS_ALGO = "urn:xmpp:hash-function-text-names:";
    public static final List<ALGORITHM> RECOMMENDED = Collections.unmodifiableList(Arrays.asList(ALGORITHM.SHA_256, ALGORITHM.SHA_384, ALGORITHM.SHA_512, ALGORITHM.SHA3_256, ALGORITHM.SHA3_384, ALGORITHM.SHA3_512, ALGORITHM.BLAKE2B256, ALGORITHM.BLAKE2B384, ALGORITHM.BLAKE2B512));
    private static final WeakHashMap<XMPPConnection, HashManager> INSTANCES = new WeakHashMap<>();

    enum AlgorithmRecommendation {
        unknown,
        must_not,
        should_not,
        should,
        must
    }

    public enum NAMESPACE {
        V1("urn:xmpp:hashes:1"),
        V2("urn:xmpp:hashes:2");

        final String name;

        NAMESPACE(String str) {
            this.name = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }

    private HashManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature(NAMESPACE.V2.toString());
        addAlgorithmsToFeatures(RECOMMENDED);
    }

    public static HashElement calculateHashElement(ALGORITHM algorithm, byte[] bArr) {
        return new HashElement(algorithm, hash(algorithm, bArr));
    }

    public static HashElement assembleHashElement(ALGORITHM algorithm, byte[] bArr) {
        return new HashElement(algorithm, bArr);
    }

    public void addAlgorithmsToFeatures(List<ALGORITHM> list) {
        ServiceDiscoveryManager instanceFor = ServiceDiscoveryManager.getInstanceFor(connection());
        Iterator<ALGORITHM> it = list.iterator();
        while (it.hasNext()) {
            instanceFor.addFeature(asFeature(it.next()));
        }
    }

    public static synchronized HashManager getInstanceFor(XMPPConnection xMPPConnection) {
        HashManager hashManager;
        WeakHashMap<XMPPConnection, HashManager> weakHashMap = INSTANCES;
        hashManager = weakHashMap.get(xMPPConnection);
        if (hashManager == null) {
            hashManager = new HashManager(xMPPConnection);
            weakHashMap.put(xMPPConnection, hashManager);
        }
        return hashManager;
    }

    public static String asFeature(ALGORITHM algorithm) {
        return PREFIX_NS_ALGO + algorithm.toString();
    }

    public enum ALGORITHM {
        MD5("md5", AlgorithmRecommendation.must_not),
        SHA_1("sha-1", AlgorithmRecommendation.should_not),
        SHA_224("sha-224", AlgorithmRecommendation.unknown),
        SHA_256("sha-256", AlgorithmRecommendation.must),
        SHA_384("sha-384", AlgorithmRecommendation.unknown),
        SHA_512("sha-512", AlgorithmRecommendation.should),
        SHA3_224("sha3-224", AlgorithmRecommendation.unknown),
        SHA3_256("sha3-256", AlgorithmRecommendation.must),
        SHA3_384("sha3-384", AlgorithmRecommendation.unknown),
        SHA3_512("sha3-512", AlgorithmRecommendation.should),
        BLAKE2B160("id-blake2b160", AlgorithmRecommendation.unknown),
        BLAKE2B256("id-blake2b256", AlgorithmRecommendation.must),
        BLAKE2B384("id-blake2b384", AlgorithmRecommendation.unknown),
        BLAKE2B512("id-blake2b512", AlgorithmRecommendation.should);

        private final String name;
        private final AlgorithmRecommendation recommendation;

        ALGORITHM(String str, AlgorithmRecommendation algorithmRecommendation) {
            this.name = str;
            this.recommendation = algorithmRecommendation;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }

        public AlgorithmRecommendation getRecommendation() {
            return this.recommendation;
        }

        public static ALGORITHM valueOfName(String str) {
            for (ALGORITHM algorithm : values()) {
                if (algorithm.toString().equals(str)) {
                    return algorithm;
                }
            }
            throw new IllegalArgumentException("No ALGORITHM enum with this name (" + str + ") found.");
        }
    }

    public static byte[] hash(ALGORITHM algorithm, byte[] bArr) {
        return getMessageDigest(algorithm).digest(bArr);
    }

    public static byte[] hash(ALGORITHM algorithm, String str) {
        return hash(algorithm, StringUtils.toUtf8Bytes(str));
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.hashes.HashManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM;

        static {
            int[] iArr = new int[ALGORITHM.values().length];
            $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM = iArr;
            try {
                iArr[ALGORITHM.MD5.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM[ALGORITHM.SHA_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM[ALGORITHM.SHA_224.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM[ALGORITHM.SHA_256.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM[ALGORITHM.SHA_384.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM[ALGORITHM.SHA_512.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM[ALGORITHM.SHA3_224.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM[ALGORITHM.SHA3_256.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM[ALGORITHM.SHA3_384.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM[ALGORITHM.SHA3_512.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM[ALGORITHM.BLAKE2B160.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM[ALGORITHM.BLAKE2B256.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM[ALGORITHM.BLAKE2B384.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM[ALGORITHM.BLAKE2B512.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public static MessageDigest getMessageDigest(ALGORITHM algorithm) {
        try {
            switch (AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM[algorithm.ordinal()]) {
                case 1:
                    return MessageDigest.getInstance(StringUtils.MD5);
                case 2:
                    return MessageDigest.getInstance("SHA-1");
                case 3:
                    return MessageDigest.getInstance(McElieceCCA2KeyGenParameterSpec.SHA224);
                case 4:
                    return MessageDigest.getInstance("SHA-256");
                case 5:
                    return MessageDigest.getInstance(McElieceCCA2KeyGenParameterSpec.SHA384);
                case 6:
                    return MessageDigest.getInstance("SHA-512");
                case 7:
                    return MessageDigest.getInstance("SHA3-224");
                case 8:
                    return MessageDigest.getInstance("SHA3-256");
                case 9:
                    return MessageDigest.getInstance("SHA3-384");
                case 10:
                    return MessageDigest.getInstance("SHA3-512");
                case 11:
                    return MessageDigest.getInstance("BLAKE2b-160");
                case 12:
                    return MessageDigest.getInstance("BLAKE2b-256");
                case 13:
                    return MessageDigest.getInstance("BLAKE2b-384");
                case 14:
                    return MessageDigest.getInstance("BLAKE2b-512");
                default:
                    throw new AssertionError("Invalid enum value: " + algorithm);
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static byte[] md5(byte[] bArr) {
        return getMessageDigest(ALGORITHM.MD5).digest(bArr);
    }

    public static byte[] md5(String str) {
        return md5(StringUtils.toUtf8Bytes(str));
    }

    public static String md5HexString(byte[] bArr) {
        return StringUtils.encodeHex(md5(bArr));
    }

    public static String md5HexString(String str) {
        return StringUtils.encodeHex(md5(str));
    }

    public static byte[] sha_1(byte[] bArr) {
        return getMessageDigest(ALGORITHM.SHA_1).digest(bArr);
    }

    public static byte[] sha_1(String str) {
        return sha_1(StringUtils.toUtf8Bytes(str));
    }

    public static String sha_1HexString(byte[] bArr) {
        return StringUtils.encodeHex(sha_1(bArr));
    }

    public static String sha_1HexString(String str) {
        return StringUtils.encodeHex(sha_1(str));
    }

    public static byte[] sha_224(byte[] bArr) {
        return getMessageDigest(ALGORITHM.SHA_224).digest(bArr);
    }

    public static byte[] sha_224(String str) {
        return sha_224(StringUtils.toUtf8Bytes(str));
    }

    public static String sha_224HexString(byte[] bArr) {
        return StringUtils.encodeHex(sha_224(bArr));
    }

    public static String sha_224HexString(String str) {
        return StringUtils.encodeHex(sha_224(str));
    }

    public static byte[] sha_256(byte[] bArr) {
        return getMessageDigest(ALGORITHM.SHA_256).digest(bArr);
    }

    public static byte[] sha_256(String str) {
        return sha_256(StringUtils.toUtf8Bytes(str));
    }

    public static String sha_256HexString(byte[] bArr) {
        return StringUtils.encodeHex(sha_256(bArr));
    }

    public static String sha_256HexString(String str) {
        return StringUtils.encodeHex(sha_256(str));
    }

    public static byte[] sha_384(byte[] bArr) {
        return getMessageDigest(ALGORITHM.SHA_384).digest(bArr);
    }

    public static byte[] sha_384(String str) {
        return sha_384(StringUtils.toUtf8Bytes(str));
    }

    public static String sha_384HexString(byte[] bArr) {
        return StringUtils.encodeHex(sha_384(bArr));
    }

    public static String sha_384HexString(String str) {
        return StringUtils.encodeHex(sha_384(str));
    }

    public static byte[] sha_512(byte[] bArr) {
        return getMessageDigest(ALGORITHM.SHA_512).digest(bArr);
    }

    public static byte[] sha_512(String str) {
        return sha_512(StringUtils.toUtf8Bytes(str));
    }

    public static String sha_512HexString(byte[] bArr) {
        return StringUtils.encodeHex(sha_512(bArr));
    }

    public static String sha_512HexString(String str) {
        return StringUtils.encodeHex(sha_512(str));
    }

    public static byte[] sha3_224(byte[] bArr) {
        return getMessageDigest(ALGORITHM.SHA3_224).digest(bArr);
    }

    public static byte[] sha3_224(String str) {
        return sha3_224(StringUtils.toUtf8Bytes(str));
    }

    public static String sha3_224HexString(byte[] bArr) {
        return StringUtils.encodeHex(sha3_224(bArr));
    }

    public static String sha3_224HexString(String str) {
        return StringUtils.encodeHex(sha3_224(str));
    }

    public static byte[] sha3_256(byte[] bArr) {
        return getMessageDigest(ALGORITHM.SHA3_256).digest(bArr);
    }

    public static byte[] sha3_256(String str) {
        return sha3_256(StringUtils.toUtf8Bytes(str));
    }

    public static String sha3_256HexString(byte[] bArr) {
        return StringUtils.encodeHex(sha3_256(bArr));
    }

    public static String sha3_256HexString(String str) {
        return StringUtils.encodeHex(sha3_256(str));
    }

    public static byte[] sha3_384(byte[] bArr) {
        return getMessageDigest(ALGORITHM.SHA3_384).digest(bArr);
    }

    public static byte[] sha3_384(String str) {
        return sha3_384(StringUtils.toUtf8Bytes(str));
    }

    public static String sha3_384HexString(byte[] bArr) {
        return StringUtils.encodeHex(sha3_384(bArr));
    }

    public static String sha3_384HexString(String str) {
        return StringUtils.encodeHex(sha3_384(str));
    }

    public static byte[] sha3_512(byte[] bArr) {
        return getMessageDigest(ALGORITHM.SHA3_512).digest(bArr);
    }

    public static byte[] sha3_512(String str) {
        return sha3_512(StringUtils.toUtf8Bytes(str));
    }

    public static String sha3_512HexString(byte[] bArr) {
        return StringUtils.encodeHex(sha3_512(bArr));
    }

    public static String sha3_512HexString(String str) {
        return StringUtils.encodeHex(sha3_512(str));
    }

    public static byte[] blake2b160(byte[] bArr) {
        return getMessageDigest(ALGORITHM.BLAKE2B160).digest(bArr);
    }

    public static byte[] blake2b160(String str) {
        return blake2b160(StringUtils.toUtf8Bytes(str));
    }

    public static String blake2b160HexString(byte[] bArr) {
        return StringUtils.encodeHex(blake2b160(bArr));
    }

    public static String blake2b160HexString(String str) {
        return StringUtils.encodeHex(blake2b160(str));
    }

    public static byte[] blake2b256(byte[] bArr) {
        return getMessageDigest(ALGORITHM.BLAKE2B256).digest(bArr);
    }

    public static byte[] blake2b256(String str) {
        return blake2b256(StringUtils.toUtf8Bytes(str));
    }

    public static String blake2b256HexString(byte[] bArr) {
        return StringUtils.encodeHex(blake2b256(bArr));
    }

    public static String blake2b256HexString(String str) {
        return StringUtils.encodeHex(blake2b256(str));
    }

    public static byte[] blake2b384(byte[] bArr) {
        return getMessageDigest(ALGORITHM.BLAKE2B384).digest(bArr);
    }

    public static byte[] blake2b384(String str) {
        return blake2b384(StringUtils.toUtf8Bytes(str));
    }

    public static String blake2b384HexString(byte[] bArr) {
        return StringUtils.encodeHex(blake2b384(bArr));
    }

    public static String blake2b384HexString(String str) {
        return StringUtils.encodeHex(blake2b384(str));
    }

    public static byte[] blake2b512(byte[] bArr) {
        return getMessageDigest(ALGORITHM.BLAKE2B512).digest(bArr);
    }

    public static byte[] blake2b512(String str) {
        return blake2b512(StringUtils.toUtf8Bytes(str));
    }

    public static String blake2b512HexString(byte[] bArr) {
        return StringUtils.encodeHex(blake2b512(bArr));
    }

    public static String blake2b512HexString(String str) {
        return StringUtils.encodeHex(blake2b512(str));
    }
}
