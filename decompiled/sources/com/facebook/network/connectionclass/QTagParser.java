package com.facebook.network.connectionclass;

import android.os.StrictMode;
import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes7.dex */
class QTagParser {
    private static final String QTAGUID_UID_STATS = "/proc/net/xt_qtaguid/stats";
    private static final String TAG = "QTagParser";

    @Nullable
    public static QTagParser sInstance;
    private String mPath;
    private static final ThreadLocal<byte[]> sLineBuffer = new ThreadLocal<byte[]>() { // from class: com.facebook.network.connectionclass.QTagParser.1
        @Override // java.lang.ThreadLocal
        public byte[] initialValue() {
            return new byte[512];
        }
    };
    private static long sPreviousBytes = -1;
    private static LineBufferReader sStatsReader = new LineBufferReader();
    private static ByteArrayScanner sScanner = new ByteArrayScanner();

    @Nonnull
    public static synchronized QTagParser getInstance() {
        if (sInstance == null) {
            sInstance = new QTagParser(QTAGUID_UID_STATS);
        }
        return sInstance;
    }

    public QTagParser(String str) {
        this.mPath = str;
    }

    public long parseDataUsageForUidAndTag(int i) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            FileInputStream fileInputStream = new FileInputStream(this.mPath);
            sStatsReader.setFileStream(fileInputStream);
            byte[] bArr = sLineBuffer.get();
            try {
                sStatsReader.skipLine();
                long jNextInt = 0;
                int i2 = 2;
                while (true) {
                    int line = sStatsReader.readLine(bArr);
                    if (line == -1) {
                        break;
                    }
                    try {
                        sScanner.reset(bArr, line);
                        sScanner.useDelimiter(' ');
                        sScanner.skip();
                        if (!sScanner.nextStringEquals("lo")) {
                            sScanner.skip();
                            if (sScanner.nextInt() == i) {
                                sScanner.skip();
                                jNextInt += (long) sScanner.nextInt();
                                i2++;
                            }
                        }
                    } catch (NumberFormatException unused) {
                        Log.e(TAG, "Cannot parse byte count at line" + i2 + InstructionFileId.DOT);
                    } catch (NoSuchElementException unused2) {
                        Log.e(TAG, "Invalid number of tokens on line " + i2 + InstructionFileId.DOT);
                    }
                }
                fileInputStream.close();
                long j = sPreviousBytes;
                if (j == -1) {
                    sPreviousBytes = jNextInt;
                    return -1L;
                }
                long j2 = jNextInt - j;
                sPreviousBytes = jNextInt;
                return j2;
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
        } catch (IOException unused3) {
            Log.e(TAG, "Error reading from /proc/net/xt_qtaguid/stats. Please check if this file exists.");
            return -1L;
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }
}
