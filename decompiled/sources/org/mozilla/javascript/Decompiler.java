package org.mozilla.javascript;

import kotlin.text.Typography;
import okhttp3.internal.ws.WebSocketProtocol;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes10.dex */
public class Decompiler {
    public static final int CASE_GAP_PROP = 3;
    private static final int FUNCTION_END = 167;
    public static final int INDENT_GAP_PROP = 2;
    public static final int INITIAL_INDENT_PROP = 1;
    public static final int ONLY_BODY_FLAG = 1;
    public static final int TO_SOURCE_FLAG = 2;
    private static final boolean printSource = false;
    private char[] sourceBuffer = new char[128];
    private int sourceTop;

    String getEncodedSource() {
        return sourceToString(0);
    }

    int getCurrentOffset() {
        return this.sourceTop;
    }

    int markFunctionStart(int i) {
        int currentOffset = getCurrentOffset();
        if (i != 4) {
            addToken(110);
            append((char) i);
        }
        return currentOffset;
    }

    int markFunctionEnd(int i) {
        int currentOffset = getCurrentOffset();
        append(Typography.section);
        return currentOffset;
    }

    void addToken(int i) {
        if (i < 0 || i > 166) {
            throw new IllegalArgumentException();
        }
        append((char) i);
    }

    void addEOL(int i) {
        if (i < 0 || i > 166) {
            throw new IllegalArgumentException();
        }
        append((char) i);
        append((char) 1);
    }

    void addName(String str) {
        addToken(39);
        appendString(str);
    }

    void addString(String str) {
        addToken(41);
        appendString(str);
    }

    void addRegexp(String str, String str2) {
        addToken(48);
        appendString(MqttTopic.TOPIC_LEVEL_SEPARATOR + str + '/' + str2);
    }

    void addNumber(double d2) {
        addToken(40);
        long j = (long) d2;
        if (j != d2) {
            long jDoubleToLongBits = Double.doubleToLongBits(d2);
            append('D');
            append((char) (jDoubleToLongBits >> 48));
            append((char) (jDoubleToLongBits >> 32));
            append((char) (jDoubleToLongBits >> 16));
            append((char) jDoubleToLongBits);
            return;
        }
        if (j < 0) {
            Kit.codeBug();
        }
        if (j <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            append('S');
            append((char) j);
            return;
        }
        append('J');
        append((char) (j >> 48));
        append((char) (j >> 32));
        append((char) (j >> 16));
        append((char) j);
    }

    private void appendString(String str) {
        int length = str.length();
        int i = this.sourceTop + (length >= 32768 ? 2 : 1) + length;
        if (i > this.sourceBuffer.length) {
            increaseSourceCapacity(i);
        }
        if (length >= 32768) {
            char[] cArr = this.sourceBuffer;
            int i2 = this.sourceTop;
            cArr[i2] = (char) (32768 | (length >>> 16));
            this.sourceTop = i2 + 1;
        }
        char[] cArr2 = this.sourceBuffer;
        int i3 = this.sourceTop;
        cArr2[i3] = (char) length;
        int i4 = i3 + 1;
        this.sourceTop = i4;
        str.getChars(0, length, cArr2, i4);
        this.sourceTop = i;
    }

    private void append(char c2) {
        int i = this.sourceTop;
        if (i == this.sourceBuffer.length) {
            increaseSourceCapacity(i + 1);
        }
        char[] cArr = this.sourceBuffer;
        int i2 = this.sourceTop;
        cArr[i2] = c2;
        this.sourceTop = i2 + 1;
    }

    private void increaseSourceCapacity(int i) {
        if (i <= this.sourceBuffer.length) {
            Kit.codeBug();
        }
        char[] cArr = this.sourceBuffer;
        int length = cArr.length * 2;
        if (length >= i) {
            i = length;
        }
        char[] cArr2 = new char[i];
        System.arraycopy(cArr, 0, cArr2, 0, this.sourceTop);
        this.sourceBuffer = cArr2;
    }

    private String sourceToString(int i) {
        if (i < 0 || this.sourceTop < i) {
            Kit.codeBug();
        }
        return new String(this.sourceBuffer, i, this.sourceTop - i);
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x0234  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String decompile(java.lang.String r18, int r19, org.mozilla.javascript.UintMap r20) {
        /*
            Method dump skipped, instruction units count: 1404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Decompiler.decompile(java.lang.String, int, org.mozilla.javascript.UintMap):java.lang.String");
    }

    private static int getNext(String str, int i, int i2) {
        int i3 = i2 + 1;
        if (i3 < i) {
            return str.charAt(i3);
        }
        return 0;
    }

    private static int getSourceStringEnd(String str, int i) {
        return printSourceString(str, i, false, null);
    }

    private static int printSourceString(String str, int i, boolean z, StringBuilder sb) {
        int iCharAt = str.charAt(i);
        int i2 = i + 1;
        if ((32768 & iCharAt) != 0) {
            iCharAt = ((iCharAt & 32767) << 16) | str.charAt(i2);
            i2 = i + 2;
        }
        if (sb != null) {
            String strSubstring = str.substring(i2, i2 + iCharAt);
            if (!z) {
                sb.append(strSubstring);
            } else {
                sb.append('\"');
                sb.append(ScriptRuntime.escapeString(strSubstring));
                sb.append('\"');
            }
        }
        return i2 + iCharAt;
    }

    private static int printSourceNumber(String str, int i, StringBuilder sb) {
        int i2;
        char cCharAt = str.charAt(i);
        int i3 = i + 1;
        if (cCharAt == 'S') {
            dLongBitsToDouble = sb != null ? str.charAt(i3) : 0.0d;
            i2 = i + 2;
        } else {
            if (cCharAt != 'J' && cCharAt != 'D') {
                throw new RuntimeException();
            }
            if (sb != null) {
                long jCharAt = (((long) str.charAt(i3)) << 48) | (((long) str.charAt(i + 2)) << 32) | (((long) str.charAt(i + 3)) << 16) | ((long) str.charAt(i + 4));
                dLongBitsToDouble = cCharAt == 'J' ? jCharAt : Double.longBitsToDouble(jCharAt);
            }
            i2 = i + 5;
        }
        if (sb != null) {
            sb.append(ScriptRuntime.numberToString(dLongBitsToDouble, 10));
        }
        return i2;
    }
}
