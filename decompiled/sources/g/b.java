package g;

import android.os.SystemClock;
import android.util.Log;
import androidx.work.WorkInfo;
import com.google.common.base.Ascii;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.mozilla.javascript.typedarrays.Conversions;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f1308d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f1309e = "yyyy-MM-dd'T'HH:mm:ssZ";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final SimpleDateFormat f1310f = new SimpleDateFormat(f1309e, Locale.US);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f1311g = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f1312h = 24;
    public static final int i = 32;
    public static final int j = 40;
    public static final int k = 48;
    public static final int l = 123;
    public static final int m = 3;
    public static final int n = 3;
    public static final long o = 2208988800L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f1315c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SimpleDateFormat a() {
            return b.f1310f;
        }

        public a() {
        }
    }

    public final long b() {
        return this.f1313a;
    }

    public final long c() {
        return this.f1314b;
    }

    public final long d() {
        return this.f1315c;
    }

    public final boolean a(String str, int i2) throws Throwable {
        DatagramSocket datagramSocket;
        DatagramSocket datagramSocket2 = null;
        try {
            try {
                datagramSocket = new DatagramSocket();
            } catch (Throwable th) {
                th = th;
                datagramSocket = null;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            datagramSocket.setSoTimeout(i2);
            InetAddress byName = InetAddress.getByName(str);
            Intrinsics.checkNotNullExpressionValue(byName, "getByName(...)");
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, byName, 123);
            bArr[0] = Ascii.ESC;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            a(bArr, 40, jCurrentTimeMillis);
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            long j2 = jElapsedRealtime2 - jElapsedRealtime;
            long j3 = jCurrentTimeMillis + j2;
            long jB = b(bArr, 24);
            long jB2 = b(bArr, 32);
            long jB3 = b(bArr, 40);
            this.f1313a = j3 + (((jB2 - jB) + (jB3 - j3)) / ((long) 2));
            this.f1314b = jElapsedRealtime2;
            this.f1315c = j2 - (jB3 - jB2);
            datagramSocket.close();
            return true;
        } catch (Exception e3) {
            e = e3;
            datagramSocket2 = datagramSocket;
            String message = e.getMessage();
            if (message == null) {
                message = "SNTPClient Error";
            }
            Log.d("SNTPClient", message);
            if (datagramSocket2 != null) {
                datagramSocket2.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            if (datagramSocket != null) {
                datagramSocket.close();
            }
            throw th;
        }
    }

    public final long b(byte[] bArr, int i2) {
        return ((a(bArr, i2) - o) * ((long) 1000)) + ((a(bArr, i2 + 4) * 1000) / Conversions.THIRTYTWO_BIT);
    }

    public final long a(byte[] bArr, int i2) {
        int i3 = bArr[i2];
        int i4 = bArr[i2 + 1];
        int i5 = bArr[i2 + 2];
        int i6 = bArr[i2 + 3];
        if (((byte) (i3 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT)) == -128) {
            i3 = ((byte) (i3 & 127)) + 128;
        }
        if (((byte) (i4 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT)) == -128) {
            i4 = ((byte) (i4 & 127)) + 128;
        }
        if (((byte) (i5 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT)) == -128) {
            i5 = ((byte) (i5 & 127)) + 128;
        }
        if (((byte) (i6 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT)) == -128) {
            i6 = ((byte) (i6 & 127)) + 128;
        }
        return (((long) i3) << 24) + (((long) i4) << 16) + (((long) i5) << 8) + ((long) i6);
    }

    public final void a(byte[] bArr, int i2, long j2) {
        long j3 = j2 / 1000;
        long j4 = j2 - (j3 * 1000);
        long j5 = j3 + o;
        bArr[i2] = (byte) (j5 >> 24);
        bArr[i2 + 1] = (byte) (j5 >> 16);
        bArr[i2 + 2] = (byte) (j5 >> 8);
        bArr[i2 + 3] = (byte) j5;
        long j6 = (j4 * Conversions.THIRTYTWO_BIT) / 1000;
        bArr[i2 + 4] = (byte) (j6 >> 24);
        bArr[i2 + 5] = (byte) (j6 >> 16);
        bArr[i2 + 6] = (byte) (j6 >> 8);
        bArr[i2 + 7] = (byte) (Math.random() * 255.0d);
    }
}
