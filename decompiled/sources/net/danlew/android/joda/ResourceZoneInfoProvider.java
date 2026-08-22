package net.danlew.android.joda;

import android.content.Context;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import net.danlew.android.joda.R;
import org.joda.time.DateTimeZone;
import org.joda.time.tz.Provider;

/* JADX INFO: loaded from: classes10.dex */
public class ResourceZoneInfoProvider implements Provider {
    private final Map<String, Object> iZoneInfoMap;
    private Context mAppContext;

    public ResourceZoneInfoProvider(Context context) throws IOException {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        this.mAppContext = context.getApplicationContext();
        this.iZoneInfoMap = loadZoneInfoMap(openResource("ZoneInfoMap"));
    }

    @Override // org.joda.time.tz.Provider
    public DateTimeZone getZone(String str) {
        Object obj;
        if (str == null || (obj = this.iZoneInfoMap.get(str)) == null) {
            return null;
        }
        if (str.equals(obj)) {
            return loadZoneData(str);
        }
        if (obj instanceof SoftReference) {
            DateTimeZone dateTimeZone = (DateTimeZone) ((SoftReference) obj).get();
            return dateTimeZone != null ? dateTimeZone : loadZoneData(str);
        }
        return getZone((String) obj);
    }

    @Override // org.joda.time.tz.Provider
    public Set<String> getAvailableIDs() {
        return new TreeSet(this.iZoneInfoMap.keySet());
    }

    protected void uncaughtException(Exception exc) {
        exc.printStackTrace();
    }

    private InputStream openResource(String str) throws IOException {
        if (this.mAppContext == null) {
            throw new RuntimeException("Need to call JodaTimeAndroid.init() before using joda-time-android");
        }
        String tzResource = ResUtils.getTzResource(str);
        int identifier = ResUtils.getIdentifier(R.raw.class, tzResource);
        if (identifier == 0) {
            throw new IOException("Resource not found: \"" + str + "\" (resName: \"" + tzResource + "\")");
        }
        return this.mAppContext.getResources().openRawResource(identifier);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x001a: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:9:0x001a */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.joda.time.DateTimeZone loadZoneData(java.lang.String r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r0 = 0
            java.io.InputStream r1 = r5.openResource(r6)     // Catch: java.lang.Throwable -> L1e java.io.IOException -> L20
            org.joda.time.DateTimeZone r2 = org.joda.time.tz.DateTimeZoneBuilder.readFrom(r1, r6)     // Catch: java.lang.Throwable -> L19 java.io.IOException -> L1c
            java.util.Map<java.lang.String, java.lang.Object> r3 = r5.iZoneInfoMap     // Catch: java.lang.Throwable -> L19 java.io.IOException -> L1c
            java.lang.ref.SoftReference r4 = new java.lang.ref.SoftReference     // Catch: java.lang.Throwable -> L19 java.io.IOException -> L1c
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L19 java.io.IOException -> L1c
            r3.put(r6, r4)     // Catch: java.lang.Throwable -> L19 java.io.IOException -> L1c
            if (r1 == 0) goto L18
            r1.close()     // Catch: java.io.IOException -> L18
        L18:
            return r2
        L19:
            r6 = move-exception
            r0 = r1
            goto L30
        L1c:
            r2 = move-exception
            goto L22
        L1e:
            r6 = move-exception
            goto L30
        L20:
            r2 = move-exception
            r1 = r0
        L22:
            r5.uncaughtException(r2)     // Catch: java.lang.Throwable -> L19
            java.util.Map<java.lang.String, java.lang.Object> r2 = r5.iZoneInfoMap     // Catch: java.lang.Throwable -> L19
            r2.remove(r6)     // Catch: java.lang.Throwable -> L19
            if (r1 == 0) goto L2f
            r1.close()     // Catch: java.io.IOException -> L2f
        L2f:
            return r0
        L30:
            if (r0 == 0) goto L35
            r0.close()     // Catch: java.io.IOException -> L35
        L35:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.danlew.android.joda.ResourceZoneInfoProvider.loadZoneData(java.lang.String):org.joda.time.DateTimeZone");
    }

    private static Map<String, Object> loadZoneInfoMap(InputStream inputStream) throws IOException {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        try {
            readZoneInfoMap(dataInputStream, concurrentHashMap);
            concurrentHashMap.put("UTC", new SoftReference(DateTimeZone.UTC));
            return concurrentHashMap;
        } finally {
            try {
                dataInputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    private static void readZoneInfoMap(DataInputStream dataInputStream, Map<String, Object> map) throws IOException {
        int unsignedShort = dataInputStream.readUnsignedShort();
        String[] strArr = new String[unsignedShort];
        for (int i = 0; i < unsignedShort; i++) {
            strArr[i] = dataInputStream.readUTF().intern();
        }
        int unsignedShort2 = dataInputStream.readUnsignedShort();
        for (int i2 = 0; i2 < unsignedShort2; i2++) {
            try {
                map.put(strArr[dataInputStream.readUnsignedShort()], strArr[dataInputStream.readUnsignedShort()]);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new IOException("Corrupt zone info map");
            }
        }
    }
}
