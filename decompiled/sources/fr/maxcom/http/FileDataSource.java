package fr.maxcom.http;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import com.android.vending.expansion.zipfile.APKExpansionSupport;
import com.android.vending.expansion.zipfile.ZipResourceFile;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.client.utils.URLEncodedUtils;
import fr.maxcom.util.Log;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.ShortBufferException;
import jcifs.smb.SmbFile;

/* JADX INFO: loaded from: classes9.dex */
public class FileDataSource implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1257a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private AssetFileDescriptor f46a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private DocumentFile f47a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ZipResourceFile.ZipEntryRO f48a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private CipherFactory f49a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private d f50a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private f f51a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private File f52a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f53a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private URI f54a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Cipher f55a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SmbFile f56a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f57a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1261e;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f1263b;

        static {
            int[] iArr = new int[e.values().length];
            f1263b = iArr;
            try {
                iArr[e.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1263b[e.FTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[f.values().length];
            f1262a = iArr2;
            try {
                iArr2[f.FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1262a[f.ZIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1262a[f.SMB.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1262a[f.DOCFILE.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1262a[f.ASSET.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1262a[f.REMOTE.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private enum e {
        HTTP,
        FTP
    }

    private enum f {
        UNSET,
        FILE,
        DOCFILE,
        ZIP,
        SMB,
        ASSET,
        REMOTE
    }

    @Override // fr.maxcom.http.DataSource
    public long getContentLength() {
        long contentSize = getContentSize();
        if (contentSize != -1) {
            return contentSize - this.f1257a;
        }
        return -1L;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // fr.maxcom.http.DataSource
    public long getContentSize() {
        if (this.f57a) {
            return -1L;
        }
        switch (a.f1262a[this.f51a.ordinal()]) {
            case 1:
                return this.f52a.length();
            case 2:
                ZipResourceFile.ZipEntryRO zipEntryRO = this.f48a;
                if (zipEntryRO != null) {
                    return zipEntryRO.mUncompressedLength;
                }
                return -1L;
            case 3:
                try {
                    SmbFile smbFile = this.f56a;
                    if (smbFile != null) {
                        return smbFile.length();
                    }
                } catch (Exception e2) {
                    Log.e("FileDataSource", "Unable to get the length of the resource: " + e2.getMessage());
                }
                return -1L;
            case 4:
                DocumentFile documentFile = this.f47a;
                if (documentFile != null) {
                    return documentFile.length();
                }
                return -1L;
            case 5:
                AssetFileDescriptor assetFileDescriptor = this.f46a;
                if (assetFileDescriptor != null) {
                    return assetFileDescriptor.getLength();
                }
                return -1L;
            case 6:
                return this.f50a.b();
            default:
                return -1L;
        }
    }

    @Override // fr.maxcom.http.DataSource
    public String getContentType() {
        String name;
        switch (a.f1262a[this.f51a.ordinal()]) {
            case 1:
                name = this.f52a.getName();
                break;
            case 2:
                ZipResourceFile.ZipEntryRO zipEntryRO = this.f48a;
                name = zipEntryRO == null ? null : zipEntryRO.mFileName;
                break;
            case 3:
                SmbFile smbFile = this.f56a;
                name = smbFile == null ? null : smbFile.getName();
                break;
            case 4:
                DocumentFile documentFile = this.f47a;
                if (documentFile != null) {
                    return documentFile.getType();
                }
                name = null;
                break;
            case 5:
                name = this.f46a == null ? null : new File(this.f53a).getName();
                break;
            case 6:
                String strM12371a = this.f50a.m12371a();
                if (strM12371a != null) {
                    return strM12371a;
                }
                name = this.f50a.m12374b();
                break;
            default:
                name = null;
                break;
        }
        if (name == null) {
            return null;
        }
        String strGuessContentTypeFromName = URLConnection.guessContentTypeFromName(name);
        return "text/texmacs".equals(strGuessContentTypeFromName) ? "application/octet-stream" : strGuessContentTypeFromName;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009c  */
    @Override // fr.maxcom.http.DataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.InputStream getInputStream() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.maxcom.http.FileDataSource.getInputStream():java.io.InputStream");
    }

    @Override // fr.maxcom.http.DataSource
    public long getOffset() {
        return this.f1257a;
    }

    @Override // fr.maxcom.http.DataSource
    public String getUriString() {
        URI uri = this.f54a;
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }

    @Override // fr.maxcom.http.DataSource
    public boolean isExisting() {
        switch (a.f1262a[this.f51a.ordinal()]) {
            case 1:
                return this.f52a.exists();
            case 2:
                return this.f48a != null;
            case 3:
                try {
                    SmbFile smbFile = this.f56a;
                    if (smbFile != null) {
                        if (smbFile.exists()) {
                            return true;
                        }
                    }
                    return false;
                } catch (Exception e2) {
                    Log.e("FileDataSource", "Unable to test the existence of the resource: " + e2.getMessage());
                    return false;
                }
            case 4:
                DocumentFile documentFile = this.f47a;
                return documentFile != null && documentFile.exists();
            case 5:
                return this.f46a != null;
            case 6:
                return this.f50a.m12375b();
            default:
                return false;
        }
    }

    @Override // fr.maxcom.http.DataSource
    public boolean isPartial() {
        return this.f1261e;
    }

    @Override // fr.maxcom.http.DataSource
    public boolean isReadable() {
        switch (a.f1262a[this.f51a.ordinal()]) {
            case 1:
                return this.f52a.canRead() && this.f52a.isFile() && !this.f52a.isHidden();
            case 2:
                ZipResourceFile.ZipEntryRO zipEntryRO = this.f48a;
                return zipEntryRO != null && zipEntryRO.isUncompressed();
            case 3:
                try {
                    SmbFile smbFile = this.f56a;
                    if (smbFile != null && smbFile.canRead() && this.f56a.isFile()) {
                        if (!this.f56a.isHidden()) {
                            return true;
                        }
                    }
                    return false;
                } catch (Exception e2) {
                    Log.e("FileDataSource", "Unable to test the readability of the resource: " + e2.getMessage());
                    return false;
                }
            case 4:
                DocumentFile documentFile = this.f47a;
                return documentFile != null && documentFile.canRead() && this.f47a.isFile();
            case 5:
                return this.f46a != null;
            case 6:
                return this.f50a.m12373a();
            default:
                return false;
        }
    }

    @Override // fr.maxcom.http.DataSource
    public void setCipher(Cipher cipher) {
        this.f55a = cipher;
        boolean z = false;
        if (cipher == null) {
            this.f57a = false;
            return;
        }
        String algorithm = cipher.getAlgorithm();
        if (algorithm != null) {
            algorithm = algorithm.toUpperCase(Locale.US);
        }
        this.f57a = (this.f55a.getBlockSize() == 0 || algorithm == null || algorithm.contains("/CFB") || algorithm.contains("/OFB") || algorithm.contains("/CTR") || algorithm.contains("/CTS") || algorithm.contains("/WITHCTS")) ? false : true;
        this.f1258b = algorithm != null && (algorithm.contains("/CTR") || algorithm.contains("/CBC") || algorithm.contains("/CFB") || algorithm.contains("/ECB"));
        this.f1259c = algorithm != null && algorithm.contains("/CTR");
        if (algorithm != null && this.f1258b && !algorithm.contains("/ECB")) {
            z = true;
        }
        this.f1260d = z;
    }

    @Override // fr.maxcom.http.DataSource
    public void setCipherFactory(CipherFactory cipherFactory) {
        this.f49a = cipherFactory;
    }

    @Override // fr.maxcom.http.DataSource
    public void setSource(URI uri, long j) {
        ZipResourceFile zipResourceFile;
        this.f54a = uri;
        this.f1261e = j >= 0;
        this.f1257a = j != -1 ? j : 0L;
        String path = uri.getPath();
        List<NameValuePair> list = URLEncodedUtils.parse(uri, "UTF-8");
        HashMap map = new HashMap(list.size());
        for (NameValuePair nameValuePair : list) {
            map.put(nameValuePair.getName(), nameValuePair.getValue());
        }
        this.f51a = f.UNSET;
        ZipResourceFile aPKExpansionZipFile = null;
        this.f52a = null;
        this.f47a = null;
        this.f53a = (String) map.get("e");
        this.f48a = null;
        this.f56a = null;
        this.f46a = null;
        this.f50a = null;
        CipherFactory cipherFactory = this.f49a;
        if (cipherFactory != null && this.f55a == null) {
            try {
                setCipher(cipherFactory.getCipher());
            } catch (GeneralSecurityException e2) {
                Log.e("FileDataSource", "Unable to get an initial cipher: " + e2.getMessage());
            }
        }
        if ("/expansion".equals(path)) {
            this.f51a = f.ZIP;
            try {
                aPKExpansionZipFile = APKExpansionSupport.getAPKExpansionZipFile(fr.maxcom.libmedia.a.f1292a, Integer.parseInt((String) map.get("m")), Integer.parseInt((String) map.get("p")));
            } catch (IOException e3) {
                Log.e("FileDataSource", "Unable to open the APK Expansion File: " + e3.getMessage());
            } catch (NumberFormatException e4) {
                Log.e("FileDataSource", "Invalid query string in URL: " + e4.getMessage());
            }
        } else if (path.startsWith("/smb://")) {
            this.f51a = f.SMB;
            try {
                this.f56a = new SmbFile(path.substring(1));
            } catch (MalformedURLException e5) {
                Log.e("FileDataSource", "Unable to construct the resource: " + e5.getMessage());
            }
        } else if (path.startsWith("/content://")) {
            this.f51a = f.DOCFILE;
            try {
                this.f47a = DocumentFile.fromSingleUri(fr.maxcom.libmedia.a.f1292a, Uri.parse(path.substring(1)));
            } catch (IllegalArgumentException e6) {
                Log.e("FileDataSource", "Unable to construct the Document File: " + e6.getMessage());
            }
        } else if (path.startsWith("/asset://")) {
            this.f51a = f.ASSET;
            if (fr.maxcom.libmedia.a.f1292a != null) {
                this.f53a = path.substring(9);
                try {
                    this.f46a = fr.maxcom.libmedia.a.f1292a.getAssets().openFd(this.f53a);
                } catch (IOException e7) {
                    Log.e("FileDataSource", "Unable to open the Asset File: " + e7.getMessage());
                }
            }
        } else if (path.startsWith("/http://") || path.startsWith("/https://") || path.startsWith("/ftp://")) {
            this.f51a = f.REMOTE;
            d dVar = new d(path.substring(1));
            this.f50a = dVar;
            try {
                dVar.a(this.f55a, this.f1257a, this.f49a, this.f1258b, this.f1260d, this.f1259c);
            } catch (Exception e8) {
                Log.e("FileDataSource", "Unable to construct the resource: " + e8.getMessage());
            }
        } else {
            if (this.f53a != null) {
                this.f51a = f.ZIP;
                try {
                    zipResourceFile = new ZipResourceFile(path);
                } catch (IOException e9) {
                    Log.e("FileDataSource", "Unable to open the Zip Expansion File: " + e9.getMessage());
                    zipResourceFile = aPKExpansionZipFile;
                }
                if (zipResourceFile != null || this.f53a == null) {
                }
                for (ZipResourceFile.ZipEntryRO zipEntryRO : zipResourceFile.getAllEntries()) {
                    if (this.f53a.equals(zipEntryRO.mFileName)) {
                        this.f48a = zipEntryRO;
                        return;
                    }
                }
                return;
            }
            this.f51a = f.FILE;
            this.f52a = new File(path);
        }
        zipResourceFile = aPKExpansionZipFile;
        if (zipResourceFile != null) {
        }
    }

    protected InputStream toInputStream(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    private class c extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1266a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private CipherFactory f62a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private Cipher f64a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f65a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final byte[] f66a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1267b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f67b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private byte[] f68b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f1268c;

        c(InputStream inputStream, Cipher cipher) {
            super(inputStream);
            this.f64a = cipher;
            int iMax = Math.max(cipher.getBlockSize(), 1);
            int iMax2 = Math.max(iMax, (4096 / iMax) * iMax);
            this.f66a = new byte[iMax2];
            int blockSize = cipher.getBlockSize();
            this.f68b = new byte[iMax2 + (blockSize > 0 ? blockSize * 2 : 0)];
        }

        void a(boolean z, boolean z2) {
            this.f67b = z;
            this.f1268c = z2;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return this.f1267b - this.f1266a;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            ((FilterInputStream) this).in.close();
            try {
                this.f64a.doFinal();
            } catch (GeneralSecurityException unused) {
                if (!this.f64a.equals(FileDataSource.this.f55a) || FileDataSource.this.f49a == null) {
                    return;
                }
                FileDataSource.this.f55a = null;
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.f1266a == this.f1267b && !a()) {
                return -1;
            }
            byte[] bArr = this.f68b;
            int i = this.f1266a;
            this.f1266a = i + 1;
            return bArr[i] & 255;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            long jSkip;
            if (!FileDataSource.this.f1258b || (this.f67b && this.f62a == null)) {
                return a(j);
            }
            b bVar = new b(FileDataSource.this, this.f64a, j, this.f67b, this.f1268c);
            long jM12369a = bVar.m12369a();
            if (jM12369a != 0) {
                long j2 = jM12369a;
                do {
                    jSkip = ((FilterInputStream) this).in.skip(j2);
                    j2 -= jSkip;
                    if (j2 <= 0) {
                        break;
                    }
                } while (jSkip > 0);
                if (j2 > 0) {
                    Log.e("FileDataSource", "missing " + j2 + " of the " + jM12369a + " bytes to skip");
                    throw new IOException("Unable to skip enough");
                }
                try {
                    Cipher cipherA = bVar.a(((FilterInputStream) this).in, this.f62a);
                    jM12369a += (long) bVar.a();
                    if (cipherA != null) {
                        this.f64a = cipherA;
                    }
                } catch (GeneralSecurityException e2) {
                    Log.e("FileDataSource", "Unable to get a new cipher: " + e2.getMessage());
                    throw new IOException("Failed to get a new cipher: " + e2.getMessage());
                }
            }
            return jM12369a + a(j - jM12369a);
        }

        void a(CipherFactory cipherFactory) {
            this.f62a = cipherFactory;
        }

        private boolean a() throws IOException {
            if (this.f65a) {
                return false;
            }
            if (((FilterInputStream) this).in != null) {
                this.f1266a = 0;
                this.f1267b = 0;
                while (this.f1267b == 0) {
                    int outputSize = this.f64a.getOutputSize(this.f66a.length);
                    byte[] bArr = this.f68b;
                    if (bArr == null || bArr.length < outputSize) {
                        this.f68b = new byte[outputSize];
                    }
                    int i = ((FilterInputStream) this).in.read(this.f66a);
                    if (i == -1) {
                        try {
                            int iDoFinal = this.f64a.doFinal(this.f68b, 0);
                            this.f1267b = iDoFinal;
                            this.f65a = true;
                            return iDoFinal != 0;
                        } catch (Exception e2) {
                            throw new IOException("Error while finalizing cipher", e2);
                        }
                    }
                    try {
                        this.f1267b = this.f64a.update(this.f66a, 0, i, this.f68b, 0);
                    } catch (ShortBufferException e3) {
                        throw new AssertionError(e3);
                    }
                }
                return true;
            }
            throw new NullPointerException("in == null");
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                if (this.f1266a != this.f1267b || a()) {
                    int iMin = Math.min(i2 - i3, this.f1267b - this.f1266a);
                    System.arraycopy(this.f68b, this.f1266a, bArr, i, iMin);
                    i += iMin;
                    this.f1266a += iMin;
                    i3 += iMin;
                } else if (i3 == 0) {
                    return -1;
                }
            }
            return i3;
        }

        private long a(long j) throws IOException {
            long j2 = 0;
            while (j2 < j && (this.f1266a != this.f1267b || a())) {
                int iMin = (int) Math.min(j - j2, this.f1267b - this.f1266a);
                this.f1266a += iMin;
                j2 += (long) iMin;
            }
            return j2;
        }
    }

    protected InputStream toInputStream(AssetFileDescriptor assetFileDescriptor) throws IOException {
        return assetFileDescriptor.createInputStream();
    }

    private class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f1264a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final long f58a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final boolean f59a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final byte[] f60a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1265b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private final boolean f61b;

        b(FileDataSource fileDataSource, Cipher cipher, long j, boolean z, boolean z2) {
            int blockSize = cipher.getBlockSize();
            this.f1264a = blockSize;
            this.f60a = cipher.getIV();
            this.f59a = z;
            this.f61b = z2;
            this.f58a = j / ((long) blockSize);
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        long m12369a() {
            long j = this.f58a;
            if (this.f59a && !this.f61b && j != 0) {
                j--;
            }
            return j * ((long) this.f1264a);
        }

        Cipher a(InputStream inputStream, CipherFactory cipherFactory) throws GeneralSecurityException, IOException {
            if (!this.f59a) {
                return null;
            }
            long j = this.f58a;
            if (j == 0) {
                return null;
            }
            int i = this.f1264a;
            byte[] bArr = new byte[i];
            if (this.f61b) {
                System.arraycopy(this.f60a, 0, bArr, 0, i);
                int i2 = i - 1;
                while (true) {
                    int i3 = (bArr[i2] & 255) + ((int) (255 & j));
                    int i4 = i2 - 1;
                    bArr[i2] = (byte) i3;
                    if ((i3 >> 8) > 0) {
                        for (int i5 = i4; i5 >= 0; i5--) {
                            byte b2 = (byte) (bArr[i5] + 1);
                            bArr[i5] = b2;
                            if (b2 != 0) {
                                break;
                            }
                        }
                    }
                    j >>= 8;
                    if (j <= 0 || i4 < 0) {
                        break;
                    }
                    i2 = i4;
                }
            } else {
                this.f1265b = inputStream.read(bArr);
            }
            return cipherFactory.rebaseCipher(bArr);
        }

        int a() {
            return this.f1265b;
        }
    }

    private class d {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private e f70a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private InputStream f72a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final String f73a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private Cipher f74a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private String f75b;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private long f69a = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1269a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f1270b = -1;

        d(String str) {
            this.f73a = str;
        }

        void a(Cipher cipher, long j, CipherFactory cipherFactory, boolean z, boolean z2, boolean z3) throws GeneralSecurityException, IOException {
            b bVar;
            String headerField;
            int iLastIndexOf;
            URL url = new URL(this.f73a);
            e eVar = url.getProtocol().startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? e.HTTP : e.FTP;
            this.f70a = eVar;
            if (e.HTTP != eVar) {
                bVar = null;
            } else {
                if (cipher == null) {
                    this.f69a = j;
                } else if (z && ((cipherFactory != null || !z2) && j != 0)) {
                    b bVar2 = new b(FileDataSource.this, cipher, j, z2, z3);
                    this.f69a = bVar2.m12369a();
                    bVar = bVar2;
                }
                bVar = null;
            }
            URLConnection uRLConnectionOpenConnection = (e.FTP != this.f70a || url.getFile().indexOf(32) == -1) ? url.openConnection() : url.openConnection(Proxy.NO_PROXY);
            if (this.f69a != 0) {
                uRLConnectionOpenConnection.setRequestProperty("Range", "bytes=" + this.f69a + "-");
            }
            try {
                this.f72a = new BufferedInputStream(uRLConnectionOpenConnection.getInputStream());
            } catch (FileNotFoundException unused) {
                Log.w("FileDataSource", "Remote response: " + uRLConnectionOpenConnection.getHeaderField((String) null));
            } catch (IOException e2) {
                String message = e2.getMessage();
                if (e.FTP != this.f70a || !message.contains("Unable to retrieve file: ")) {
                    throw e2;
                }
                try {
                    this.f1269a = Integer.parseInt(message.substring(message.length() - 3));
                    Log.w("FileDataSource", "Remote reply: " + this.f1269a);
                } catch (NumberFormatException unused2) {
                    Log.e("FileDataSource", "Unable to parse: " + message);
                    throw e2;
                }
            }
            if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                this.f1269a = ((HttpURLConnection) uRLConnectionOpenConnection).getResponseCode();
            }
            if (this.f69a != 0 && this.f1269a == 200) {
                Log.w("FileDataSource", "Range header not supported by the remote server");
                this.f69a = 0L;
            } else if (bVar != null) {
                this.f74a = bVar.a(this.f72a, cipherFactory);
                this.f69a += (long) bVar.a();
            }
            int i = this.f1269a;
            if (i == 200) {
                this.f1270b = uRLConnectionOpenConnection.getContentLength();
            } else if (i == 206 && (headerField = uRLConnectionOpenConnection.getHeaderField("Content-Range")) != null && (iLastIndexOf = headerField.lastIndexOf(47)) != -1) {
                try {
                    this.f1270b = Long.parseLong(headerField.substring(iLastIndexOf));
                } catch (NumberFormatException unused3) {
                }
            }
            String contentType = uRLConnectionOpenConnection.getContentType();
            this.f75b = contentType;
            if ("content/unknown".equals(contentType)) {
                this.f75b = null;
            }
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        boolean m12375b() {
            int i = a.f1263b[this.f70a.ordinal()];
            if (i != 1) {
                return (i == 2 && this.f1269a == 550) ? false : true;
            }
            int i2 = this.f1269a;
            return (i2 == 404 || i2 == 410) ? false : true;
        }

        long b() {
            return this.f1270b;
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        String m12374b() {
            return this.f73a;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        boolean m12373a() {
            if (a.f1263b[this.f70a.ordinal()] != 1) {
                return true;
            }
            int i = this.f1269a;
            return (i == 401 || i == 403 || i == 407) ? false : true;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        InputStream m12370a() {
            return this.f72a;
        }

        long a() {
            return this.f69a;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        Cipher m12372a() {
            return this.f74a;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        String m12371a() {
            return this.f75b;
        }
    }
}
