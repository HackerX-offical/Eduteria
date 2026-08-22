package org.eclipse.paho.client.mqttv3.internal.websocket;

import androidx.work.WorkInfo;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes10.dex */
public class WebSocketFrame {
    public static final int frameLengthOverhead = 6;
    private boolean closeFlag;
    private boolean fin;
    private byte opcode;
    private byte[] payload;

    public byte getOpcode() {
        return this.opcode;
    }

    public boolean isFin() {
        return this.fin;
    }

    public byte[] getPayload() {
        return this.payload;
    }

    public boolean isCloseFlag() {
        return this.closeFlag;
    }

    public WebSocketFrame(byte b2, boolean z, byte[] bArr) {
        this.closeFlag = false;
        this.opcode = b2;
        this.fin = z;
        if (bArr != null) {
            this.payload = (byte[]) bArr.clone();
        }
    }

    public WebSocketFrame(byte[] bArr) {
        byte[] bArr2;
        int i = 0;
        this.closeFlag = false;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        setFinAndOpCode(byteBufferWrap.get());
        byte b2 = byteBufferWrap.get();
        boolean z = (b2 & 128) != 0;
        int i2 = (byte) (b2 & 127);
        int i3 = i2 == 127 ? 8 : i2 == 126 ? 2 : 0;
        while (true) {
            i3--;
            if (i3 <= 0) {
                break;
            } else {
                i2 |= (byteBufferWrap.get() & 255) << (i3 * 8);
            }
        }
        if (z) {
            bArr2 = new byte[4];
            byteBufferWrap.get(bArr2, 0, 4);
        } else {
            bArr2 = null;
        }
        byte[] bArr3 = new byte[i2];
        this.payload = bArr3;
        byteBufferWrap.get(bArr3, 0, i2);
        if (!z) {
            return;
        }
        while (true) {
            byte[] bArr4 = this.payload;
            if (i >= bArr4.length) {
                return;
            }
            bArr4[i] = (byte) (bArr4[i] ^ bArr2[i % 4]);
            i++;
        }
    }

    private void setFinAndOpCode(byte b2) {
        this.fin = (b2 & 128) != 0;
        this.opcode = (byte) (b2 & Ascii.SI);
    }

    public WebSocketFrame(InputStream inputStream) throws IOException {
        byte[] bArr;
        int i = 0;
        this.closeFlag = false;
        setFinAndOpCode((byte) inputStream.read());
        byte b2 = this.opcode;
        if (b2 != 2) {
            if (b2 == 8) {
                this.closeFlag = true;
                return;
            }
            throw new IOException("Invalid Frame: Opcode: " + ((int) this.opcode));
        }
        byte b3 = (byte) inputStream.read();
        boolean z = (b3 & 128) != 0;
        int i2 = (byte) (b3 & 127);
        int i3 = i2 != 127 ? i2 == 126 ? 2 : 0 : 8;
        i2 = i3 > 0 ? 0 : i2;
        while (true) {
            i3--;
            if (i3 < 0) {
                break;
            } else {
                i2 |= (((byte) inputStream.read()) & 255) << (i3 * 8);
            }
        }
        if (z) {
            bArr = new byte[4];
            inputStream.read(bArr, 0, 4);
        } else {
            bArr = null;
        }
        byte[] bArr2 = bArr;
        this.payload = new byte[i2];
        int i4 = 0;
        int i5 = i2;
        while (i4 != i2) {
            int i6 = inputStream.read(this.payload, i4, i5);
            i4 += i6;
            i5 -= i6;
        }
        if (!z) {
            return;
        }
        while (true) {
            byte[] bArr3 = this.payload;
            if (i >= bArr3.length) {
                return;
            }
            bArr3[i] = (byte) (bArr3[i] ^ bArr2[i % 4]);
            i++;
        }
    }

    public byte[] encodeFrame() {
        byte[] bArr = this.payload;
        int length = bArr.length;
        int i = length + 6;
        if (bArr.length > 65535) {
            i = length + 14;
        } else if (bArr.length >= 126) {
            i = length + 8;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        appendFinAndOpCode(byteBufferAllocate, this.opcode, this.fin);
        byte[] bArrGenerateMaskingKey = generateMaskingKey();
        appendLengthAndMask(byteBufferAllocate, this.payload.length, bArrGenerateMaskingKey);
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.payload;
            if (i2 < bArr2.length) {
                byte b2 = (byte) (bArr2[i2] ^ bArrGenerateMaskingKey[i2 % 4]);
                bArr2[i2] = b2;
                byteBufferAllocate.put(b2);
                i2++;
            } else {
                byteBufferAllocate.flip();
                return byteBufferAllocate.array();
            }
        }
    }

    public static void appendLengthAndMask(ByteBuffer byteBuffer, int i, byte[] bArr) {
        if (bArr != null) {
            appendLength(byteBuffer, i, true);
            byteBuffer.put(bArr);
        } else {
            appendLength(byteBuffer, i, false);
        }
    }

    private static void appendLength(ByteBuffer byteBuffer, int i, boolean z) {
        if (i < 0) {
            throw new IllegalArgumentException("Length cannot be negative");
        }
        int i2 = z ? WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT : 0;
        if (i <= 65535) {
            if (i >= 126) {
                byteBuffer.put((byte) (i2 | 126));
                byteBuffer.put((byte) (i >> 8));
                byteBuffer.put((byte) (i & 255));
                return;
            }
            byteBuffer.put((byte) (i | i2));
            return;
        }
        byteBuffer.put((byte) (i2 | 127));
        byteBuffer.put((byte) 0);
        byteBuffer.put((byte) 0);
        byteBuffer.put((byte) 0);
        byteBuffer.put((byte) 0);
        byteBuffer.put((byte) ((i >> 24) & 255));
        byteBuffer.put((byte) ((i >> 16) & 255));
        byteBuffer.put((byte) ((i >> 8) & 255));
        byteBuffer.put((byte) (i & 255));
    }

    public static void appendFinAndOpCode(ByteBuffer byteBuffer, byte b2, boolean z) {
        byteBuffer.put((byte) ((b2 & Ascii.SI) | (z ? (byte) 128 : (byte) 0)));
    }

    public static byte[] generateMaskingKey() {
        SecureRandom secureRandom = new SecureRandom();
        return new byte[]{(byte) secureRandom.nextInt(255), (byte) secureRandom.nextInt(255), (byte) secureRandom.nextInt(255), (byte) secureRandom.nextInt(255)};
    }
}
