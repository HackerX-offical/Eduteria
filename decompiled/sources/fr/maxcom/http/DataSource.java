package fr.maxcom.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes9.dex */
public interface DataSource {
    long getContentLength();

    long getContentSize();

    String getContentType();

    InputStream getInputStream() throws IOException;

    long getOffset();

    String getUriString();

    boolean isExisting();

    boolean isPartial();

    boolean isReadable();

    void setCipher(Cipher cipher);

    void setCipherFactory(CipherFactory cipherFactory);

    void setSource(URI uri, long j);
}
