package org.jsoup.helper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.annotation.WillClose;
import org.jsoup.internal.ConstrainableInputStream;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

/* JADX INFO: loaded from: classes10.dex */
public final class DataUtil {
    public static final Charset UTF_8;
    static final int boundaryLength = 32;
    static final int bufferSize = 32768;
    private static final Pattern charsetPattern = Pattern.compile("(?i)\\bcharset=\\s*(?:[\"'])?([^\\s,;\"']*)");
    static final String defaultCharsetName;
    private static final int firstReadBufferSize = 5120;
    private static final char[] mimeBoundaryChars;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        UTF_8 = charsetForName;
        defaultCharsetName = charsetForName.name();
        mimeBoundaryChars = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    private DataUtil() {
    }

    public static Document load(File file, @Nullable String str, String str2) throws IOException {
        return load(file, str, str2, Parser.htmlParser());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.jsoup.nodes.Document load(java.io.File r3, @javax.annotation.Nullable java.lang.String r4, java.lang.String r5, org.jsoup.parser.Parser r6) throws java.io.IOException {
        /*
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r3)
            java.lang.String r1 = r3.getName()
            java.lang.String r1 = org.jsoup.internal.Normalizer.lowerCase(r1)
            java.lang.String r2 = ".gz"
            boolean r2 = r1.endsWith(r2)
            if (r2 != 0) goto L1d
            java.lang.String r2 = ".z"
            boolean r1 = r1.endsWith(r2)
            if (r1 == 0) goto L45
        L1d:
            int r1 = r0.read()     // Catch: java.lang.Throwable -> L4a
            r2 = 31
            if (r1 != r2) goto L2f
            int r1 = r0.read()     // Catch: java.lang.Throwable -> L4a
            r2 = 139(0x8b, float:1.95E-43)
            if (r1 != r2) goto L2f
            r1 = 1
            goto L30
        L2f:
            r1 = 0
        L30:
            r0.close()
            if (r1 == 0) goto L40
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream
            java.io.FileInputStream r1 = new java.io.FileInputStream
            r1.<init>(r3)
            r0.<init>(r1)
            goto L45
        L40:
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r3)
        L45:
            org.jsoup.nodes.Document r3 = parseInputStream(r0, r4, r5, r6)
            return r3
        L4a:
            r3 = move-exception
            r0.close()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.DataUtil.load(java.io.File, java.lang.String, java.lang.String, org.jsoup.parser.Parser):org.jsoup.nodes.Document");
    }

    public static Document load(@WillClose InputStream inputStream, @Nullable String str, String str2) throws IOException {
        return parseInputStream(inputStream, str, str2, Parser.htmlParser());
    }

    public static Document load(@WillClose InputStream inputStream, @Nullable String str, String str2, Parser parser) throws IOException {
        return parseInputStream(inputStream, str, str2, parser);
    }

    static void crossStreams(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[32768];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static org.jsoup.nodes.Document parseInputStream(@javax.annotation.Nullable @javax.annotation.WillClose java.io.InputStream r12, @javax.annotation.Nullable java.lang.String r13, java.lang.String r14, org.jsoup.parser.Parser r15) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.DataUtil.parseInputStream(java.io.InputStream, java.lang.String, java.lang.String, org.jsoup.parser.Parser):org.jsoup.nodes.Document");
    }

    public static ByteBuffer readToByteBuffer(InputStream inputStream, int i) throws IOException {
        Validate.isTrue(i >= 0, "maxSize must be 0 (unlimited) or larger");
        return ConstrainableInputStream.wrap(inputStream, 32768, i).readToByteBuffer(i);
    }

    static ByteBuffer emptyByteBuffer() {
        return ByteBuffer.allocate(0);
    }

    @Nullable
    static String getCharsetFromContentType(@Nullable String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = charsetPattern.matcher(str);
        if (matcher.find()) {
            return validateCharset(matcher.group(1).trim().replace("charset=", ""));
        }
        return null;
    }

    @Nullable
    private static String validateCharset(@Nullable String str) {
        if (str != null && str.length() != 0) {
            String strReplaceAll = str.trim().replaceAll("[\"']", "");
            try {
                if (Charset.isSupported(strReplaceAll)) {
                    return strReplaceAll;
                }
                String upperCase = strReplaceAll.toUpperCase(Locale.ENGLISH);
                if (Charset.isSupported(upperCase)) {
                    return upperCase;
                }
            } catch (IllegalCharsetNameException unused) {
            }
        }
        return null;
    }

    static String mimeBoundary() {
        StringBuilder sbBorrowBuilder = StringUtil.borrowBuilder();
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            char[] cArr = mimeBoundaryChars;
            sbBorrowBuilder.append(cArr[random.nextInt(cArr.length)]);
        }
        return StringUtil.releaseBuilder(sbBorrowBuilder);
    }

    @Nullable
    private static BomCharset detectCharsetFromBom(ByteBuffer byteBuffer) {
        byteBuffer.mark();
        byte[] bArr = new byte[4];
        if (byteBuffer.remaining() >= 4) {
            byteBuffer.get(bArr);
            byteBuffer.rewind();
        }
        byte b2 = bArr[0];
        if ((b2 == 0 && bArr[1] == 0 && bArr[2] == -2 && bArr[3] == -1) || (b2 == -1 && bArr[1] == -2 && bArr[2] == 0 && bArr[3] == 0)) {
            return new BomCharset("UTF-32", false);
        }
        if ((b2 == -2 && bArr[1] == -1) || (b2 == -1 && bArr[1] == -2)) {
            return new BomCharset("UTF-16", false);
        }
        if (b2 == -17 && bArr[1] == -69 && bArr[2] == -65) {
            return new BomCharset("UTF-8", true);
        }
        return null;
    }

    private static class BomCharset {
        private final String charset;
        private final boolean offset;

        public BomCharset(String str, boolean z) {
            this.charset = str;
            this.offset = z;
        }
    }
}
