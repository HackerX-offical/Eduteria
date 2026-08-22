package org.jivesoftware.smack.compression.zlib;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XmppInputOutputFilter;
import org.jivesoftware.smack.compression.XMPPInputOutputStream;
import org.jivesoftware.smack.compression.XmppCompressionFactory;

/* JADX INFO: loaded from: classes10.dex */
public final class ZlibXmppCompressionFactory extends XmppCompressionFactory {
    public static final ZlibXmppCompressionFactory INSTANCE = new ZlibXmppCompressionFactory();

    private ZlibXmppCompressionFactory() {
        super("zlib", 100);
    }

    @Override // org.jivesoftware.smack.compression.XmppCompressionFactory
    public XmppInputOutputFilter fabricate(ConnectionConfiguration connectionConfiguration) {
        return new ZlibXmppInputOutputFilter();
    }

    private static final class ZlibXmppInputOutputFilter implements XmppInputOutputFilter {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int MINIMUM_OUTPUT_BUFFER_INCREASE = 480;
        private static final int MINIMUM_OUTPUT_BUFFER_INITIAL_SIZE = 4;
        private final Deflater compressor;
        private long compressorInBytes;
        private long compressorOutBytes;
        private final Inflater decompressor;
        private long decompressorInBytes;
        private long decompressorOutBytes;
        private int maxBytesWrittenAfterFullFlush;
        private int maxInputOutput;
        private int maxOutputOutput;
        private ByteBuffer outputBuffer;

        private ZlibXmppInputOutputFilter() {
            this(-1);
        }

        private ZlibXmppInputOutputFilter(int i) {
            this.decompressor = new Inflater();
            this.maxOutputOutput = -1;
            this.maxInputOutput = -1;
            this.maxBytesWrittenAfterFullFlush = -1;
            this.compressor = new Deflater(i);
        }

        @Override // org.jivesoftware.smack.XmppInputOutputFilter
        public XmppInputOutputFilter.OutputResult output(ByteBuffer byteBuffer, boolean z, boolean z2, boolean z3) throws IOException {
            int iRemaining;
            byte[] bArrArray;
            int iArrayOffset;
            if (z2 && XMPPInputOutputStream.getFlushMethod() == XMPPInputOutputStream.FlushMethod.FULL_FLUSH) {
                this.outputBuffer = ByteBuffer.allocate(256);
                int iDeflate = deflate(3);
                this.maxBytesWrittenAfterFullFlush = Math.max(iDeflate, this.maxBytesWrittenAfterFullFlush);
                this.compressorOutBytes += (long) iDeflate;
            }
            if (byteBuffer == null && this.outputBuffer == null) {
                return XmppInputOutputFilter.OutputResult.NO_OUTPUT;
            }
            int iRemaining2 = byteBuffer.remaining();
            if (this.outputBuffer == null) {
                if (iRemaining2 < 4) {
                    iRemaining2 = 4;
                }
                this.outputBuffer = ByteBuffer.allocate(iRemaining2);
            }
            if (byteBuffer.hasArray()) {
                bArrArray = byteBuffer.array();
                iArrayOffset = byteBuffer.arrayOffset();
                iRemaining = byteBuffer.remaining();
            } else {
                int iRemaining3 = byteBuffer.remaining();
                byte[] bArr = new byte[iRemaining3];
                byteBuffer.get(bArr);
                iRemaining = iRemaining3;
                bArrArray = bArr;
                iArrayOffset = 0;
            }
            this.compressorInBytes += (long) iRemaining;
            this.compressor.setInput(bArrArray, iArrayOffset, iRemaining);
            int iDeflate2 = deflate(z3 ? 0 : 2);
            this.maxOutputOutput = Math.max(this.outputBuffer.position(), this.maxOutputOutput);
            this.compressorOutBytes += (long) iDeflate2;
            XmppInputOutputFilter.OutputResult outputResult = new XmppInputOutputFilter.OutputResult(this.outputBuffer);
            this.outputBuffer = null;
            return outputResult;
        }

        private int deflate(int i) {
            int i2 = 0;
            while (true) {
                int iPosition = this.outputBuffer.position();
                int iDeflate = this.compressor.deflate(this.outputBuffer.array(), iPosition, this.outputBuffer.limit() - iPosition, i);
                this.outputBuffer.position(iPosition + iDeflate);
                i2 += iDeflate;
                if (this.compressor.needsInput() && this.outputBuffer.hasRemaining()) {
                    return i2;
                }
                int iCapacity = this.outputBuffer.capacity() * 2;
                if (iCapacity < 480) {
                    iCapacity = 480;
                }
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iCapacity);
                this.outputBuffer.flip();
                byteBufferAllocate.put(this.outputBuffer);
                this.outputBuffer = byteBufferAllocate;
            }
        }

        @Override // org.jivesoftware.smack.XmppInputOutputFilter
        public ByteBuffer input(ByteBuffer byteBuffer) throws IOException {
            byte[] bArr;
            int i;
            int iInflate;
            int iRemaining = byteBuffer.remaining();
            if (byteBuffer.hasArray()) {
                byte[] bArrArray = byteBuffer.array();
                int iArrayOffset = byteBuffer.arrayOffset();
                iRemaining = byteBuffer.remaining();
                i = iArrayOffset;
                bArr = bArrArray;
            } else {
                bArr = new byte[iRemaining];
                byteBuffer.get(bArr);
                i = 0;
            }
            this.decompressorInBytes += (long) iRemaining;
            this.decompressor.setInput(bArr, i, iRemaining);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iRemaining * 2);
            while (true) {
                byte[] bArrArray2 = byteBufferAllocate.array();
                int iPosition = byteBufferAllocate.position();
                try {
                    iInflate = this.decompressor.inflate(bArrArray2, iPosition, byteBufferAllocate.limit() - iPosition);
                    byteBufferAllocate.position(iPosition + iInflate);
                    this.decompressorOutBytes += (long) iInflate;
                    if (this.decompressor.needsInput()) {
                        break;
                    }
                    ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(byteBufferAllocate.capacity() * 2);
                    byteBufferAllocate.flip();
                    byteBufferAllocate2.put(byteBufferAllocate);
                    byteBufferAllocate = byteBufferAllocate2;
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            if (iInflate == 0) {
                return null;
            }
            this.maxInputOutput = Math.max(byteBufferAllocate.position(), this.maxInputOutput);
            return byteBufferAllocate;
        }

        @Override // org.jivesoftware.smack.XmppInputOutputFilter
        public Stats getStats() {
            return new Stats(this);
        }

        @Override // org.jivesoftware.smack.XmppInputOutputFilter
        public String getFilterName() {
            return "Compression (zlib)";
        }
    }

    public static final class Stats {
        public final double compressionRatio;
        public final long compressorInBytes;
        public final long compressorOutBytes;
        public final double decompressionRatio;
        public final long decompressorInBytes;
        public final long decompressorOutBytes;
        public final int maxBytesWrittenAfterFullFlush;
        public final int maxInputOutput;
        public final int maxOutputOutput;
        private transient String toStringCache;

        private Stats(ZlibXmppInputOutputFilter zlibXmppInputOutputFilter) {
            long j = zlibXmppInputOutputFilter.compressorOutBytes;
            this.compressorOutBytes = j;
            long j2 = zlibXmppInputOutputFilter.compressorInBytes;
            this.compressorInBytes = j2;
            this.compressionRatio = j / j2;
            long j3 = zlibXmppInputOutputFilter.decompressorOutBytes;
            this.decompressorOutBytes = j3;
            long j4 = zlibXmppInputOutputFilter.decompressorInBytes;
            this.decompressorInBytes = j4;
            this.decompressionRatio = j4 / j3;
            this.maxOutputOutput = zlibXmppInputOutputFilter.maxOutputOutput;
            this.maxInputOutput = zlibXmppInputOutputFilter.maxInputOutput;
            this.maxBytesWrittenAfterFullFlush = zlibXmppInputOutputFilter.maxBytesWrittenAfterFullFlush;
        }

        public String toString() {
            String str = this.toStringCache;
            if (str != null) {
                return str;
            }
            String str2 = "compressor-in-bytes: " + this.compressorInBytes + "\ncompressor-out-bytes: " + this.compressorOutBytes + "\ncompression-ratio: " + this.compressionRatio + "\ndecompressor-in-bytes: " + this.decompressorInBytes + "\ndecompressor-out-bytes: " + this.decompressorOutBytes + "\ndecompression-ratio: " + this.decompressionRatio + "\nmax-output-output: " + this.maxOutputOutput + "\nmax-input-output: " + this.maxInputOutput + "\nmax-bytes-written-after-full-flush: " + this.maxBytesWrittenAfterFullFlush + '\n';
            this.toStringCache = str2;
            return str2;
        }
    }
}
