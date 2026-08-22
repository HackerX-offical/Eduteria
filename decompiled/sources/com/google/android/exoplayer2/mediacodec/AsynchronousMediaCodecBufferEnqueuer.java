package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes7.dex */
class AsynchronousMediaCodecBufferEnqueuer {
    private static final int MSG_OPEN_CV = 2;
    private static final int MSG_QUEUE_INPUT_BUFFER = 0;
    private static final int MSG_QUEUE_SECURE_INPUT_BUFFER = 1;
    private final MediaCodec codec;
    private final ConditionVariable conditionVariable;
    private Handler handler;
    private final HandlerThread handlerThread;
    private final AtomicReference<RuntimeException> pendingRuntimeException;
    private boolean started;
    private static final ArrayDeque<MessageParams> MESSAGE_PARAMS_INSTANCE_POOL = new ArrayDeque<>();
    private static final Object QUEUE_SECURE_LOCK = new Object();

    public AsynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec, HandlerThread handlerThread) {
        this(mediaCodec, handlerThread, new ConditionVariable());
    }

    AsynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec, HandlerThread handlerThread, ConditionVariable conditionVariable) {
        this.codec = mediaCodec;
        this.handlerThread = handlerThread;
        this.conditionVariable = conditionVariable;
        this.pendingRuntimeException = new AtomicReference<>();
    }

    public void start() {
        if (this.started) {
            return;
        }
        this.handlerThread.start();
        this.handler = new Handler(this.handlerThread.getLooper()) { // from class: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                AsynchronousMediaCodecBufferEnqueuer.this.doHandleMessage(message);
            }
        };
        this.started = true;
    }

    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        maybeThrowException();
        MessageParams messageParams = getMessageParams();
        messageParams.setQueueParams(i, i2, i3, j, i4);
        ((Handler) Util.castNonNull(this.handler)).obtainMessage(0, messageParams).sendToTarget();
    }

    public void queueSecureInputBuffer(int i, int i2, CryptoInfo cryptoInfo, long j, int i3) {
        maybeThrowException();
        MessageParams messageParams = getMessageParams();
        messageParams.setQueueParams(i, i2, 0, j, i3);
        copy(cryptoInfo, messageParams.cryptoInfo);
        ((Handler) Util.castNonNull(this.handler)).obtainMessage(1, messageParams).sendToTarget();
    }

    public void flush() {
        if (this.started) {
            try {
                flushHandlerThread();
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e2);
            }
        }
    }

    public void shutdown() {
        if (this.started) {
            flush();
            this.handlerThread.quit();
        }
        this.started = false;
    }

    public void waitUntilQueueingComplete() throws InterruptedException {
        blockUntilHandlerThreadIsIdle();
    }

    private void maybeThrowException() {
        RuntimeException andSet = this.pendingRuntimeException.getAndSet(null);
        if (andSet != null) {
            throw andSet;
        }
    }

    private void flushHandlerThread() throws InterruptedException {
        ((Handler) Assertions.checkNotNull(this.handler)).removeCallbacksAndMessages(null);
        blockUntilHandlerThreadIsIdle();
    }

    private void blockUntilHandlerThreadIsIdle() throws InterruptedException {
        this.conditionVariable.close();
        ((Handler) Assertions.checkNotNull(this.handler)).obtainMessage(2).sendToTarget();
        this.conditionVariable.block();
    }

    void setPendingRuntimeException(RuntimeException runtimeException) {
        this.pendingRuntimeException.set(runtimeException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void doHandleMessage(android.os.Message r9) {
        /*
            r8 = this;
            int r2 = r9.what
            if (r2 == 0) goto L36
            r3 = 1
            if (r2 == r3) goto L22
            r3 = 2
            r4 = 0
            if (r2 == r3) goto L1c
            java.util.concurrent.atomic.AtomicReference<java.lang.RuntimeException> r2 = r8.pendingRuntimeException
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            int r1 = r9.what
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r3.<init>(r1)
            androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(r2, r4, r3)
            goto L4a
        L1c:
            com.google.android.exoplayer2.util.ConditionVariable r1 = r8.conditionVariable
            r1.open()
            goto L4a
        L22:
            java.lang.Object r1 = r9.obj
            r7 = r1
            com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams r7 = (com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams) r7
            int r1 = r7.index
            int r2 = r7.offset
            android.media.MediaCodec$CryptoInfo r3 = r7.cryptoInfo
            long r4 = r7.presentationTimeUs
            int r6 = r7.flags
            r0 = r8
            r0.doQueueSecureInputBuffer(r1, r2, r3, r4, r6)
            goto L49
        L36:
            java.lang.Object r0 = r9.obj
            r7 = r0
            com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams r7 = (com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams) r7
            int r1 = r7.index
            int r2 = r7.offset
            int r3 = r7.size
            long r4 = r7.presentationTimeUs
            int r6 = r7.flags
            r0 = r8
            r0.doQueueInputBuffer(r1, r2, r3, r4, r6)
        L49:
            r4 = r7
        L4a:
            if (r4 == 0) goto L4f
            recycleMessageParams(r4)
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.doHandleMessage(android.os.Message):void");
    }

    private void doQueueInputBuffer(int i, int i2, int i3, long j, int i4) {
        try {
            this.codec.queueInputBuffer(i, i2, i3, j, i4);
        } catch (RuntimeException e2) {
            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingRuntimeException, null, e2);
        }
    }

    private void doQueueSecureInputBuffer(int i, int i2, MediaCodec.CryptoInfo cryptoInfo, long j, int i3) {
        try {
            synchronized (QUEUE_SECURE_LOCK) {
                this.codec.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
            }
        } catch (RuntimeException e2) {
            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingRuntimeException, null, e2);
        }
    }

    private static MessageParams getMessageParams() {
        ArrayDeque<MessageParams> arrayDeque = MESSAGE_PARAMS_INSTANCE_POOL;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                return new MessageParams();
            }
            return arrayDeque.removeFirst();
        }
    }

    private static void recycleMessageParams(MessageParams messageParams) {
        ArrayDeque<MessageParams> arrayDeque = MESSAGE_PARAMS_INSTANCE_POOL;
        synchronized (arrayDeque) {
            arrayDeque.add(messageParams);
        }
    }

    private static class MessageParams {
        public final MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        public int flags;
        public int index;
        public int offset;
        public long presentationTimeUs;
        public int size;

        MessageParams() {
        }

        public void setQueueParams(int i, int i2, int i3, long j, int i4) {
            this.index = i;
            this.offset = i2;
            this.size = i3;
            this.presentationTimeUs = j;
            this.flags = i4;
        }
    }

    private static void copy(CryptoInfo cryptoInfo, MediaCodec.CryptoInfo cryptoInfo2) {
        cryptoInfo2.numSubSamples = cryptoInfo.numSubSamples;
        cryptoInfo2.numBytesOfClearData = copy(cryptoInfo.numBytesOfClearData, cryptoInfo2.numBytesOfClearData);
        cryptoInfo2.numBytesOfEncryptedData = copy(cryptoInfo.numBytesOfEncryptedData, cryptoInfo2.numBytesOfEncryptedData);
        cryptoInfo2.key = (byte[]) Assertions.checkNotNull(copy(cryptoInfo.key, cryptoInfo2.key));
        cryptoInfo2.iv = (byte[]) Assertions.checkNotNull(copy(cryptoInfo.iv, cryptoInfo2.iv));
        cryptoInfo2.mode = cryptoInfo.mode;
        if (Util.SDK_INT >= 24) {
            cryptoInfo2.setPattern(new MediaCodec.CryptoInfo.Pattern(cryptoInfo.encryptedBlocks, cryptoInfo.clearBlocks));
        }
    }

    private static int[] copy(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    private static byte[] copy(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}
