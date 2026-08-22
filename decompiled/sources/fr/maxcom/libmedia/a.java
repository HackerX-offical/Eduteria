package fr.maxcom.libmedia;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Base64;
import fr.maxcom.util.Log;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Calendar;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f1292a;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m12381a() {
        Context context = f1292a;
        if (context == null) {
            throw new SecurityException("Licensing.allow() has to be called first");
        }
        String packageName = context.getPackageName();
        try {
            Bundle bundle = f1292a.getPackageManager().getApplicationInfo(packageName, 128).metaData;
            if (bundle == null) {
                throw new SecurityException("Missing <meta-data> element in the manifest file");
            }
            String string = bundle.getString("fr.maxcom.libmedia.apiKey");
            if (string == null) {
                throw new SecurityException("Missing API Key");
            }
            if (!a(string, packageName)) {
                throw new SecurityException("Invalid or expired API Key");
            }
        } catch (PackageManager.NameNotFoundException e2) {
            throw new SecurityException(e2);
        }
    }

    public static int b() {
        return (int) Math.floor(Math.random() * 10.0d);
    }

    private static PublicKey a(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(m12382a(str)));
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        } catch (InvalidKeySpecException e3) {
            Log.e("Libmedia", "Invalid key specification.");
            throw new IllegalArgumentException(e3);
        }
    }

    private static boolean a(String str, String str2) {
        byte[] bArrM12382a = m12382a(str);
        byte[] bArrCopyOf = Arrays.copyOf(bArrM12382a, 64);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrM12382a, 64, bArrM12382a.length);
        if (!a(bArrCopyOfRange, bArrCopyOf)) {
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer) ByteBuffer.wrap(bArrCopyOfRange).position(4);
        int i = byteBuffer.getInt();
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.get(bArr);
        for (int i2 = 0; i2 < iRemaining; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ bArrCopyOfRange[(i2 + 3) % 4]);
        }
        if (str2.equals(new String(bArr))) {
            return i == 0 || i >= a();
        }
        return false;
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        PublicKey publicKeyA = a("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALCRcazTMcbOko2Eczit0ef5vMLCdpMsTxY4vv5Sw8ZppkeZ2wmoSDhX9vmEs6uSl+5wS/mNwiMDniE0F1g4hbcCAwEAAQ==");
        try {
            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initVerify(publicKeyA);
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static byte[] m12382a(String str) {
        return Base64.decode(str, 0);
    }

    public static int a() {
        return (int) (Calendar.getInstance().getTimeInMillis() / 1000);
    }
}
