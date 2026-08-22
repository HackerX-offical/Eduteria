package org.mozilla.javascript.typedarrays;

import cz.msebera.android.httpclient.impl.client.cache.CacheValidityPolicy;
import org.mozilla.javascript.ScriptRuntime;

/* JADX INFO: loaded from: classes10.dex */
public class Conversions {
    public static final int EIGHT_BIT = 256;
    public static final int SIXTEEN_BIT = 65536;
    public static final long THIRTYTWO_BIT = 4294967296L;

    public static int toInt8(Object obj) {
        int int32;
        if (obj instanceof Integer) {
            int32 = ((Integer) obj).intValue();
        } else {
            int32 = ScriptRuntime.toInt32(obj);
        }
        int i = int32 % 256;
        return i >= 128 ? i - 256 : i;
    }

    public static int toUint8(Object obj) {
        int int32;
        if (obj instanceof Integer) {
            int32 = ((Integer) obj).intValue();
        } else {
            int32 = ScriptRuntime.toInt32(obj);
        }
        return int32 % 256;
    }

    public static int toUint8Clamp(Object obj) {
        double number = ScriptRuntime.toNumber(obj);
        if (number <= 0.0d) {
            return 0;
        }
        if (number >= 255.0d) {
            return 255;
        }
        double dFloor = Math.floor(number);
        double d2 = 0.5d + dFloor;
        if (d2 < number) {
            return (int) (dFloor + 1.0d);
        }
        if (number < d2) {
            return (int) dFloor;
        }
        int i = (int) dFloor;
        return i % 2 != 0 ? i + 1 : i;
    }

    public static int toInt16(Object obj) {
        int int32;
        if (obj instanceof Integer) {
            int32 = ((Integer) obj).intValue();
        } else {
            int32 = ScriptRuntime.toInt32(obj);
        }
        int i = int32 % 65536;
        return i >= 32768 ? i - 65536 : i;
    }

    public static int toUint16(Object obj) {
        int int32;
        if (obj instanceof Integer) {
            int32 = ((Integer) obj).intValue();
        } else {
            int32 = ScriptRuntime.toInt32(obj);
        }
        return int32 % 65536;
    }

    public static int toInt32(Object obj) {
        long number = ((long) ScriptRuntime.toNumber(obj)) % THIRTYTWO_BIT;
        if (number >= CacheValidityPolicy.MAX_AGE) {
            number -= THIRTYTWO_BIT;
        }
        return (int) number;
    }

    public static long toUint32(Object obj) {
        return ((long) ScriptRuntime.toNumber(obj)) % THIRTYTWO_BIT;
    }
}
