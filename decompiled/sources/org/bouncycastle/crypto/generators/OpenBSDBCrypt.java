package org.bouncycastle.crypto.generators;

import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Set;
import kotlin.text.Typography;
import okio.Utf8;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes10.dex */
public class OpenBSDBCrypt {
    private static final Set<String> allowedVersions;
    private static final String defaultVersion = "2y";
    private static final byte[] encodingTable = {46, 47, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57};
    private static final byte[] decodingTable = new byte[128];

    static {
        HashSet hashSet = new HashSet();
        allowedVersions = hashSet;
        hashSet.add("2a");
        hashSet.add(defaultVersion);
        hashSet.add("2b");
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = decodingTable;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        while (true) {
            byte[] bArr2 = encodingTable;
            if (i >= bArr2.length) {
                return;
            }
            decodingTable[bArr2[i]] = (byte) i;
            i++;
        }
    }

    private OpenBSDBCrypt() {
    }

    public static boolean checkPassword(String str, byte[] bArr) {
        if (bArr != null) {
            return doCheckPassword(str, Arrays.clone(bArr));
        }
        throw new IllegalArgumentException("Missing password.");
    }

    public static boolean checkPassword(String str, char[] cArr) {
        if (cArr != null) {
            return doCheckPassword(str, Strings.toUTF8ByteArray(cArr));
        }
        throw new IllegalArgumentException("Missing password.");
    }

    private static String createBcryptString(String str, byte[] bArr, byte[] bArr2, int i) {
        if (!allowedVersions.contains(str)) {
            throw new IllegalArgumentException("Version " + str + " is not accepted by this implementation.");
        }
        StringBuilder sb = new StringBuilder(60);
        sb.append(Typography.dollar);
        sb.append(str);
        sb.append(Typography.dollar);
        sb.append(i < 10 ? "0" + i : Integer.toString(i));
        sb.append(Typography.dollar);
        encodeData(sb, bArr2);
        encodeData(sb, BCrypt.generate(bArr, bArr2, i));
        return sb.toString();
    }

    private static byte[] decodeSaltString(String str) {
        char[] charArray = str.toCharArray();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16);
        if (charArray.length != 22) {
            throw new DataLengthException("Invalid base64 salt length: " + charArray.length + " , 22 required.");
        }
        for (char c2 : charArray) {
            if (c2 > 'z' || c2 < '.' || (c2 > '9' && c2 < 'A')) {
                throw new IllegalArgumentException("Salt string contains invalid character: " + ((int) c2));
            }
        }
        char[] cArr = new char[24];
        System.arraycopy(charArray, 0, cArr, 0, charArray.length);
        for (int i = 0; i < 24; i += 4) {
            byte[] bArr = decodingTable;
            byte b2 = bArr[cArr[i]];
            byte b3 = bArr[cArr[i + 1]];
            byte b4 = bArr[cArr[i + 2]];
            byte b5 = bArr[cArr[i + 3]];
            byteArrayOutputStream.write((b2 << 2) | (b3 >> 4));
            byteArrayOutputStream.write((b3 << 4) | (b4 >> 2));
            byteArrayOutputStream.write(b5 | (b4 << 6));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byte[] bArr2 = new byte[16];
        System.arraycopy(byteArray, 0, bArr2, 0, 16);
        return bArr2;
    }

    private static boolean doCheckPassword(String str, byte[] bArr) {
        if (str == null) {
            throw new IllegalArgumentException("Missing bcryptString.");
        }
        int length = str.length();
        if (length != 60) {
            throw new DataLengthException("Bcrypt String length: " + length + ", 60 required.");
        }
        if (str.charAt(0) != '$' || str.charAt(3) != '$' || str.charAt(6) != '$') {
            throw new IllegalArgumentException("Invalid Bcrypt String format.");
        }
        String strSubstring = str.substring(1, 3);
        if (!allowedVersions.contains(strSubstring)) {
            throw new IllegalArgumentException("Bcrypt version '" + strSubstring + "' is not supported by this implementation");
        }
        String strSubstring2 = str.substring(4, 6);
        try {
            int i = Integer.parseInt(strSubstring2);
            if (i < 4 || i > 31) {
                throw new IllegalArgumentException("Invalid cost factor: " + i + ", 4 < cost < 31 expected.");
            }
            String strDoGenerate = doGenerate(strSubstring, bArr, decodeSaltString(str.substring(str.lastIndexOf(36) + 1, length - 31)), i);
            boolean z = length == strDoGenerate.length();
            for (int i2 = 0; i2 != length; i2++) {
                z &= str.indexOf(i2) == strDoGenerate.indexOf(i2);
            }
            return z;
        } catch (NumberFormatException unused) {
            throw new IllegalArgumentException("Invalid cost factor: " + strSubstring2);
        }
    }

    private static String doGenerate(String str, byte[] bArr, byte[] bArr2, int i) {
        if (!allowedVersions.contains(str)) {
            throw new IllegalArgumentException("Version " + str + " is not accepted by this implementation.");
        }
        if (bArr2 == null) {
            throw new IllegalArgumentException("Salt required.");
        }
        if (bArr2.length != 16) {
            throw new DataLengthException("16 byte salt required: " + bArr2.length);
        }
        if (i < 4 || i > 31) {
            throw new IllegalArgumentException("Invalid cost factor.");
        }
        int length = bArr.length < 72 ? bArr.length + 1 : 72;
        byte[] bArr3 = new byte[length];
        if (length > bArr.length) {
            length = bArr.length;
        }
        System.arraycopy(bArr, 0, bArr3, 0, length);
        Arrays.fill(bArr, (byte) 0);
        String strCreateBcryptString = createBcryptString(str, bArr3, bArr2, i);
        Arrays.fill(bArr3, (byte) 0);
        return strCreateBcryptString;
    }

    private static void encodeData(StringBuilder sb, byte[] bArr) {
        boolean z;
        if (bArr.length != 24 && bArr.length != 16) {
            throw new DataLengthException("Invalid length: " + bArr.length + ", 24 for key or 16 for salt expected");
        }
        if (bArr.length == 16) {
            byte[] bArr2 = new byte[18];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            bArr = bArr2;
            z = true;
        } else {
            bArr[bArr.length - 1] = 0;
            z = false;
        }
        int length = bArr.length;
        for (int i = 0; i < length; i += 3) {
            int i2 = bArr[i] & 255;
            int i3 = bArr[i + 1] & 255;
            byte b2 = bArr[i + 2];
            byte[] bArr3 = encodingTable;
            sb.append((char) bArr3[(i2 >>> 2) & 63]);
            sb.append((char) bArr3[((i2 << 4) | (i3 >>> 4)) & 63]);
            sb.append((char) bArr3[((i3 << 2) | ((b2 & 255) >>> 6)) & 63]);
            sb.append((char) bArr3[b2 & Utf8.REPLACEMENT_BYTE]);
        }
        int length2 = sb.length();
        sb.setLength(z ? length2 - 2 : length2 - 1);
    }

    public static String generate(String str, byte[] bArr, byte[] bArr2, int i) {
        if (bArr != null) {
            return doGenerate(str, Arrays.clone(bArr), bArr2, i);
        }
        throw new IllegalArgumentException("Password required.");
    }

    public static String generate(String str, char[] cArr, byte[] bArr, int i) {
        if (cArr != null) {
            return doGenerate(str, Strings.toUTF8ByteArray(cArr), bArr, i);
        }
        throw new IllegalArgumentException("Password required.");
    }

    public static String generate(byte[] bArr, byte[] bArr2, int i) {
        return generate(defaultVersion, bArr, bArr2, i);
    }

    public static String generate(char[] cArr, byte[] bArr, int i) {
        return generate(defaultVersion, cArr, bArr, i);
    }
}
