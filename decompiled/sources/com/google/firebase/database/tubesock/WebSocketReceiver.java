package com.google.firebase.database.tubesock;

import com.google.common.base.Ascii;
import com.google.firebase.database.tubesock.MessageBuilderFactory;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
class WebSocketReceiver {
    private MessageBuilderFactory.Builder pendingBuilder;
    private WebSocket websocket;
    private DataInputStream input = null;
    private WebSocketEventHandler eventHandler = null;
    private byte[] inputHeader = new byte[112];
    private volatile boolean stop = false;

    WebSocketReceiver(WebSocket webSocket) {
        this.websocket = null;
        this.websocket = webSocket;
    }

    void setInput(DataInputStream dataInputStream) {
        this.input = dataInputStream;
    }

    void run() {
        int i;
        byte[] bArr;
        byte b2;
        boolean z;
        long j;
        this.eventHandler = this.websocket.getEventHandler();
        while (!this.stop) {
            try {
                i = read(this.inputHeader, 0, 1);
                bArr = this.inputHeader;
                b2 = bArr[0];
                z = (b2 & 128) != 0;
            } catch (WebSocketException e2) {
                handleError(e2);
            } catch (SocketTimeoutException unused) {
            } catch (IOException e3) {
                handleError(new WebSocketException("IO Error", e3));
            }
            if ((b2 & 112) != 0) {
                throw new WebSocketException("Invalid frame received");
            }
            byte b3 = (byte) (b2 & Ascii.SI);
            int i2 = i + read(bArr, i, 1);
            byte[] bArr2 = this.inputHeader;
            byte b4 = bArr2[1];
            if (b4 < 126) {
                j = b4;
            } else if (b4 == 126) {
                read(bArr2, i2, 2);
                byte[] bArr3 = this.inputHeader;
                j = (((long) (bArr3[2] & 255)) << 8) | ((long) (bArr3[3] & 255));
            } else {
                j = b4 == 127 ? parseLong(this.inputHeader, (i2 + read(bArr2, i2, 8)) - 8) : 0L;
            }
            int i3 = (int) j;
            byte[] bArr4 = new byte[i3];
            read(bArr4, 0, i3);
            if (b3 == 8) {
                this.websocket.onCloseOpReceived();
            } else if (b3 != 10) {
                if (b3 != 1 && b3 != 2 && b3 != 9 && b3 != 0) {
                    throw new WebSocketException("Unsupported opcode: " + ((int) b3));
                }
                appendBytes(z, b3, bArr4);
            }
        }
    }

    private void appendBytes(boolean z, byte b2, byte[] bArr) {
        if (b2 == 9) {
            if (z) {
                handlePing(bArr);
                return;
            }
            throw new WebSocketException("PING must not fragment across frames");
        }
        MessageBuilderFactory.Builder builder = this.pendingBuilder;
        if (builder != null && b2 != 0) {
            throw new WebSocketException("Failed to continue outstanding frame");
        }
        if (builder == null && b2 == 0) {
            throw new WebSocketException("Received continuing frame, but there's nothing to continue");
        }
        if (builder == null) {
            this.pendingBuilder = MessageBuilderFactory.builder(b2);
        }
        if (!this.pendingBuilder.appendBytes(bArr)) {
            throw new WebSocketException("Failed to decode frame");
        }
        if (z) {
            WebSocketMessage message = this.pendingBuilder.toMessage();
            this.pendingBuilder = null;
            if (message == null) {
                throw new WebSocketException("Failed to decode whole message");
            }
            this.eventHandler.onMessage(message);
        }
    }

    private void handlePing(byte[] bArr) {
        if (bArr.length <= 125) {
            this.websocket.pong(bArr);
            return;
        }
        throw new WebSocketException("PING frame too long");
    }

    private long parseLong(byte[] bArr, int i) {
        return (((long) bArr[i]) << 56) + (((long) (bArr[i + 1] & 255)) << 48) + (((long) (bArr[i + 2] & 255)) << 40) + (((long) (bArr[i + 3] & 255)) << 32) + (((long) (bArr[i + 4] & 255)) << 24) + ((long) ((bArr[i + 5] & 255) << 16)) + ((long) ((bArr[i + 6] & 255) << 8)) + ((long) (bArr[i + 7] & 255));
    }

    private int read(byte[] bArr, int i, int i2) throws IOException {
        this.input.readFully(bArr, i, i2);
        return i2;
    }

    void stopit() {
        this.stop = true;
    }

    boolean isRunning() {
        return !this.stop;
    }

    private void handleError(WebSocketException webSocketException) {
        stopit();
        this.websocket.handleReceiverError(webSocketException);
    }
}
