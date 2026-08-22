package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.internal.SdkInputStream;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public final class AwsChunkedEncodingInputStream extends SdkInputStream {
    private static final int BIT_MASK = 255;
    private static final String CHUNK_SIGNATURE_HEADER = ";chunk-signature=";
    private static final String CHUNK_STRING_TO_SIGN_PREFIX = "AWS4-HMAC-SHA256-PAYLOAD";
    private static final String CLRF = "\r\n";
    private static final int DEFAULT_BUFFER_SIZE = 262144;
    private static final int DEFAULT_CHUNK_SIZE = 131072;
    protected static final String DEFAULT_ENCODING = "UTF-8";
    private static final int SIGNATURE_LENGTH = 64;
    private final AWS4Signer aws4Signer;
    private ChunkContentIterator currentChunkIterator;
    private final String dateTime;
    private DecodedStreamBuffer decodedStreamBuffer;
    private final String headerSignature;
    private InputStream is;
    private boolean isAtStart;
    private boolean isTerminating;
    private final byte[] kSigning;
    private final String keyPath;
    private final int maxBufferSize;
    private String priorChunkSignature;
    private static final byte[] FINAL_CHUNK = new byte[0];
    private static final Log log = LogFactory.getLog(AwsChunkedEncodingInputStream.class);

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    public AwsChunkedEncodingInputStream(InputStream inputStream, byte[] bArr, String str, String str2, String str3, AWS4Signer aWS4Signer) {
        this(inputStream, 262144, bArr, str, str2, str3, aWS4Signer);
    }

    public AwsChunkedEncodingInputStream(InputStream inputStream, int i, byte[] bArr, String str, String str2, String str3, AWS4Signer aWS4Signer) {
        this.is = null;
        this.isAtStart = true;
        this.isTerminating = false;
        if (inputStream instanceof AwsChunkedEncodingInputStream) {
            AwsChunkedEncodingInputStream awsChunkedEncodingInputStream = (AwsChunkedEncodingInputStream) inputStream;
            i = Math.max(awsChunkedEncodingInputStream.maxBufferSize, i);
            this.is = awsChunkedEncodingInputStream.is;
            this.decodedStreamBuffer = awsChunkedEncodingInputStream.decodedStreamBuffer;
        } else {
            this.is = inputStream;
            this.decodedStreamBuffer = null;
        }
        if (i < 131072) {
            throw new IllegalArgumentException("Max buffer size should not be less than chunk size");
        }
        this.maxBufferSize = i;
        this.kSigning = bArr;
        this.dateTime = str;
        this.keyPath = str2;
        this.headerSignature = str3;
        this.priorChunkSignature = str3;
        this.aws4Signer = aWS4Signer;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        int i = read(bArr, 0, 1);
        if (i == -1) {
            return i;
        }
        Log log2 = log;
        if (log2.isDebugEnabled()) {
            log2.debug("One byte read from the stream.");
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        abortIfNeeded();
        bArr.getClass();
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        ChunkContentIterator chunkContentIterator = this.currentChunkIterator;
        if (chunkContentIterator == null || !chunkContentIterator.hasNext()) {
            if (this.isTerminating) {
                return -1;
            }
            this.isTerminating = setUpNextChunk();
        }
        int i3 = this.currentChunkIterator.read(bArr, i, i2);
        if (i3 > 0) {
            this.isAtStart = false;
            Log log2 = log;
            if (log2.isDebugEnabled()) {
                log2.debug(i3 + " byte read from the stream.");
            }
        }
        return i3;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        int i;
        if (j <= 0) {
            return 0L;
        }
        int iMin = (int) Math.min(262144L, j);
        byte[] bArr = new byte[iMin];
        long j2 = j;
        while (j2 > 0 && (i = read(bArr, 0, iMin)) >= 0) {
            j2 -= (long) i;
        }
        return j - j2;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        abortIfNeeded();
        if (!this.isAtStart) {
            throw new UnsupportedOperationException("Chunk-encoded stream only supports mark() at the start of the stream.");
        }
        if (this.is.markSupported()) {
            Log log2 = log;
            if (log2.isDebugEnabled()) {
                log2.debug("AwsChunkedEncodingInputStream marked at the start of the stream (will directly mark the wrapped stream since it's mark-supported).");
            }
            this.is.mark(Integer.MAX_VALUE);
        } else {
            Log log3 = log;
            if (log3.isDebugEnabled()) {
                log3.debug("AwsChunkedEncodingInputStream marked at the start of the stream (initializing the buffer since the wrapped stream is not mark-supported).");
            }
            this.decodedStreamBuffer = new DecodedStreamBuffer(this.maxBufferSize);
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        abortIfNeeded();
        this.currentChunkIterator = null;
        this.priorChunkSignature = this.headerSignature;
        if (this.is.markSupported()) {
            Log log2 = log;
            if (log2.isDebugEnabled()) {
                log2.debug("AwsChunkedEncodingInputStream reset (will reset the wrapped stream because it is mark-supported).");
            }
            this.is.reset();
        } else {
            Log log3 = log;
            if (log3.isDebugEnabled()) {
                log3.debug("AwsChunkedEncodingInputStream reset (will use the buffer of the decoded stream).");
            }
            DecodedStreamBuffer decodedStreamBuffer = this.decodedStreamBuffer;
            if (decodedStreamBuffer == null) {
                throw new IOException("Cannot reset the stream because the mark is not set.");
            }
            decodedStreamBuffer.startReadBuffer();
        }
        this.currentChunkIterator = null;
        this.isAtStart = true;
        this.isTerminating = false;
    }

    public static long calculateStreamContentLength(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Nonnegative content length expected.");
        }
        long j2 = j / 131072;
        long j3 = j % 131072;
        return (j2 * calculateSignedChunkLength(131072L)) + (j3 > 0 ? calculateSignedChunkLength(j3) : 0L) + calculateSignedChunkLength(0L);
    }

    private static long calculateSignedChunkLength(long j) {
        return ((long) (Long.toHexString(j).length() + CHUNK_SIGNATURE_HEADER.length() + 64 + CLRF.length())) + j + ((long) CLRF.length());
    }

    private boolean setUpNextChunk() throws IOException {
        byte[] bArr = new byte[131072];
        int i = 0;
        while (i < 131072) {
            DecodedStreamBuffer decodedStreamBuffer = this.decodedStreamBuffer;
            if (decodedStreamBuffer != null && decodedStreamBuffer.hasNext()) {
                bArr[i] = this.decodedStreamBuffer.next();
                i++;
            } else {
                int i2 = this.is.read(bArr, i, 131072 - i);
                if (i2 == -1) {
                    break;
                }
                DecodedStreamBuffer decodedStreamBuffer2 = this.decodedStreamBuffer;
                if (decodedStreamBuffer2 != null) {
                    decodedStreamBuffer2.buffer(bArr, i, i2);
                }
                i += i2;
            }
        }
        if (i == 0) {
            this.currentChunkIterator = new ChunkContentIterator(createSignedChunk(FINAL_CHUNK));
            return true;
        }
        if (i < 131072) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            bArr = bArr2;
        }
        this.currentChunkIterator = new ChunkContentIterator(createSignedChunk(bArr));
        return false;
    }

    private byte[] createSignedChunk(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(bArr.length));
        String hex = BinaryUtils.toHex(this.aws4Signer.sign("AWS4-HMAC-SHA256-PAYLOAD\n" + this.dateTime + "\n" + this.keyPath + "\n" + this.priorChunkSignature + "\n" + BinaryUtils.toHex(this.aws4Signer.hash("")) + "\n" + BinaryUtils.toHex(this.aws4Signer.hash(bArr)), this.kSigning, SigningAlgorithm.HmacSHA256));
        this.priorChunkSignature = hex;
        sb.append(CHUNK_SIGNATURE_HEADER + hex);
        sb.append(CLRF);
        try {
            byte[] bytes = sb.toString().getBytes(StringUtils.UTF8);
            byte[] bytes2 = CLRF.getBytes(StringUtils.UTF8);
            byte[] bArr2 = new byte[bytes.length + bArr.length + bytes2.length];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            System.arraycopy(bytes2, 0, bArr2, bytes.length + bArr.length, bytes2.length);
            return bArr2;
        } catch (Exception e2) {
            throw new AmazonClientException("Unable to sign the chunked data. " + e2.getMessage(), e2);
        }
    }

    @Override // com.amazonaws.internal.SdkInputStream
    protected InputStream getWrappedInputStream() {
        return this.is;
    }
}
