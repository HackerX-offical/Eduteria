package fr.maxcom.util;

import android.os.AsyncTask;
import android.util.LogPrinter;
import android.util.PrintWriterPrinter;
import android.util.Printer;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* JADX INFO: loaded from: classes9.dex */
public class LogManager {

    private static class b implements Printer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SocketAddress f1302a;

        @Override // android.util.Printer
        public void println(String str) {
            new c(this.f1302a).execute(str + '\n');
        }

        private b(SocketAddress socketAddress) {
            this.f1302a = socketAddress;
        }
    }

    private static class c extends AsyncTask<String, Void, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SocketAddress f1303a;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            DatagramSocket datagramSocket;
            byte[] bytes = strArr[0].getBytes();
            try {
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, this.f1303a);
                datagramSocket = new DatagramSocket();
                try {
                    datagramSocket.send(datagramPacket);
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
                datagramSocket = null;
            }
            if (datagramSocket != null) {
                datagramSocket.disconnect();
                datagramSocket.close();
            }
            return null;
        }

        private c(SocketAddress socketAddress) {
            this.f1303a = socketAddress;
        }
    }

    private LogManager() {
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a() {
        /*
            android.content.Context r0 = fr.maxcom.libmedia.a.f1292a
            r1 = 0
            if (r0 == 0) goto L8d
            java.lang.String r0 = r0.getPackageName()
            android.content.Context r2 = fr.maxcom.libmedia.a.f1292a     // Catch: java.lang.Exception -> L8d
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch: java.lang.Exception -> L8d
            r3 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo(r0, r3)     // Catch: java.lang.Exception -> L8d
            android.os.Bundle r2 = r2.metaData     // Catch: java.lang.Exception -> L8d
            if (r2 == 0) goto L8d
            java.lang.String r3 = "AQJyfjp5bYRve3k6eHVueXFwdW06bXx1V3GF"
            byte[] r3 = fr.maxcom.libmedia.a.m12382a(r3)     // Catch: java.lang.Exception -> L8d
            r4 = 2
            r5 = r4
        L21:
            int r6 = r3.length     // Catch: java.lang.Exception -> L8d
            if (r5 >= r6) goto L2e
            r6 = r3[r5]     // Catch: java.lang.Exception -> L8d
            int r6 = r6 + (-12)
            byte r6 = (byte) r6     // Catch: java.lang.Exception -> L8d
            r3[r5] = r6     // Catch: java.lang.Exception -> L8d
            int r5 = r5 + 1
            goto L21
        L2e:
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Exception -> L8d
            int r6 = r3.length     // Catch: java.lang.Exception -> L8d
            int r6 = r6 - r4
            r5.<init>(r3, r4, r6)     // Catch: java.lang.Exception -> L8d
            java.lang.String r2 = r2.getString(r5)     // Catch: java.lang.Exception -> L8d
            if (r2 == 0) goto L8d
            byte[] r2 = fr.maxcom.libmedia.a.m12382a(r2)     // Catch: java.lang.Exception -> L8d
            r3 = 64
            byte[] r4 = java.util.Arrays.copyOf(r2, r3)     // Catch: java.lang.Exception -> L8d
            int r5 = r2.length     // Catch: java.lang.Exception -> L8d
            byte[] r2 = java.util.Arrays.copyOfRange(r2, r3, r5)     // Catch: java.lang.Exception -> L8d
            boolean r3 = fr.maxcom.libmedia.a.a(r2, r4)     // Catch: java.lang.Exception -> L8d
            if (r3 == 0) goto L8d
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.wrap(r2)     // Catch: java.lang.Exception -> L8d
            r4 = 4
            java.nio.Buffer r3 = r3.position(r4)     // Catch: java.lang.Exception -> L8d
            java.nio.ByteBuffer r3 = (java.nio.ByteBuffer) r3     // Catch: java.lang.Exception -> L8d
            int r5 = r3.getInt()     // Catch: java.lang.Exception -> L8d
            int r6 = r3.remaining()     // Catch: java.lang.Exception -> L8d
            byte[] r7 = new byte[r6]     // Catch: java.lang.Exception -> L8d
            r3.get(r7)     // Catch: java.lang.Exception -> L8d
            r3 = r1
        L69:
            if (r3 >= r6) goto L79
            r8 = r7[r3]     // Catch: java.lang.Exception -> L8d
            int r9 = r3 + 3
            int r9 = r9 % r4
            r9 = r2[r9]     // Catch: java.lang.Exception -> L8d
            r8 = r8 ^ r9
            byte r8 = (byte) r8     // Catch: java.lang.Exception -> L8d
            r7[r3] = r8     // Catch: java.lang.Exception -> L8d
            int r3 = r3 + 1
            goto L69
        L79:
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Exception -> L8d
            r2.<init>(r7)     // Catch: java.lang.Exception -> L8d
            boolean r0 = r0.equals(r2)     // Catch: java.lang.Exception -> L8d
            if (r0 == 0) goto L8d
            if (r5 == 0) goto L8c
            int r0 = fr.maxcom.libmedia.a.a()     // Catch: java.lang.Exception -> L8d
            if (r5 < r0) goto L8d
        L8c:
            r1 = 1
        L8d:
            fr.maxcom.util.Log.f1301b = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.maxcom.util.LogManager.a():void");
    }

    public static void setInterceptor(boolean z) {
        fr.maxcom.libmedia.a.m12381a();
        Log.f94a = z;
    }

    public static void setTarget(File file) throws IOException {
        setTarget(file, false);
    }

    public static void setTarget(File file, boolean z) throws IOException {
        Log.f1300a = new PrintWriterPrinter(new PrintWriter((Writer) new FileWriter(file, z), true));
        a();
    }

    public static void setTarget(String str, int i) {
        setTarget(new InetSocketAddress(str, i));
    }

    public static void setTarget(SocketAddress socketAddress) {
        Log.f1300a = new b(socketAddress);
        a();
    }

    public static void setTarget(int i, String str) {
        Log.f1300a = new LogPrinter(i, str);
    }
}
