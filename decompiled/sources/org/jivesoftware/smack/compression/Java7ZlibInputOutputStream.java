package org.jivesoftware.smack.compression;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.jivesoftware.smack.compression.XMPPInputOutputStream;

/* JADX INFO: loaded from: classes10.dex */
public class Java7ZlibInputOutputStream extends XMPPInputOutputStream {
    private static final int compressionLevel = -1;

    @Override // org.jivesoftware.smack.compression.XMPPInputOutputStream
    public boolean isSupported() {
        return true;
    }

    public Java7ZlibInputOutputStream() {
        super("zlib");
    }

    @Override // org.jivesoftware.smack.compression.XMPPInputOutputStream
    public InputStream getInputStream(InputStream inputStream) {
        return new InflaterInputStream(inputStream, new Inflater(), 512) { // from class: org.jivesoftware.smack.compression.Java7ZlibInputOutputStream.1
            @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                if (this.inf.needsInput()) {
                    return 0;
                }
                return super.available();
            }
        };
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.compression.Java7ZlibInputOutputStream$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$compression$XMPPInputOutputStream$FlushMethod;

        static {
            int[] iArr = new int[XMPPInputOutputStream.FlushMethod.values().length];
            $SwitchMap$org$jivesoftware$smack$compression$XMPPInputOutputStream$FlushMethod = iArr;
            try {
                iArr[XMPPInputOutputStream.FlushMethod.SYNC_FLUSH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$compression$XMPPInputOutputStream$FlushMethod[XMPPInputOutputStream.FlushMethod.FULL_FLUSH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // org.jivesoftware.smack.compression.XMPPInputOutputStream
    public OutputStream getOutputStream(OutputStream outputStream) {
        int i = AnonymousClass3.$SwitchMap$org$jivesoftware$smack$compression$XMPPInputOutputStream$FlushMethod[flushMethod.ordinal()];
        final int i2 = 2;
        if (i != 1) {
            if (i != 2) {
                throw new AssertionError();
            }
            i2 = 3;
        }
        return new DeflaterOutputStream(outputStream, new Deflater(-1)) { // from class: org.jivesoftware.smack.compression.Java7ZlibInputOutputStream.2
            @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                while (true) {
                    int iDeflate = this.def.deflate(this.buf, 0, this.buf.length, i2);
                    if (iDeflate > 0) {
                        this.out.write(this.buf, 0, iDeflate);
                    } else {
                        super.flush();
                        return;
                    }
                }
            }
        };
    }
}
