package org.jivesoftware.smack.util;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes10.dex */
public class StringUtils {
    public static final String AMP_ENCODE = "&amp;";
    public static final String APOS_ENCODE = "&apos;";
    public static final String GT_ENCODE = "&gt;";
    public static final String LT_ENCODE = "&lt;";
    public static final String MD5 = "MD5";
    public static final String PORTABLE_NEWLINE_REGEX = "\\r?\\n";
    public static final String QUOTE_ENCODE = "&quot;";
    private static final int RANDOM_STRING_CHUNK_SIZE = 4;
    public static final String SHA1 = "SHA-1";

    @Deprecated
    public static final String USASCII = "US-ASCII";

    @Deprecated
    public static final String UTF8 = "UTF-8";
    public static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();
    public static final String UNAMBIGUOUS_NUMBERS_AND_LETTERS_STRING = "123456789ABCDEFGHIJKLMNPQRSTUVWXYZ";
    private static final char[] UNAMBIGUOUS_NUMBERS_AND_LETTERS = UNAMBIGUOUS_NUMBERS_AND_LETTERS_STRING.toCharArray();
    private static final Pattern XML_WHITESPACE = Pattern.compile("[\t\n\r ]");

    private enum XmlEscapeMode {
        safe,
        forAttribute,
        forAttributeApos,
        forText
    }

    public static CharSequence escapeForXml(CharSequence charSequence) {
        return escapeForXml(charSequence, XmlEscapeMode.safe);
    }

    public static CharSequence escapeForXmlAttribute(CharSequence charSequence) {
        return escapeForXml(charSequence, XmlEscapeMode.forAttribute);
    }

    public static CharSequence escapeForXmlAttributeApos(CharSequence charSequence) {
        return escapeForXml(charSequence, XmlEscapeMode.forAttributeApos);
    }

    public static CharSequence escapeForXmlText(CharSequence charSequence) {
        return escapeForXml(charSequence, XmlEscapeMode.forText);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.CharSequence escapeForXml(java.lang.CharSequence r16, org.jivesoftware.smack.util.StringUtils.XmlEscapeMode r17) {
        /*
            r0 = r16
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r2 = r0.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            double r4 = (double) r2
            r6 = 4608533498688228557(0x3ff4cccccccccccd, double:1.3)
            double r4 = r4 * r6
            int r4 = (int) r4
            r3.<init>(r4)
            r4 = 0
            r5 = r4
        L19:
            if (r4 >= r2) goto L81
            char r6 = r0.charAt(r4)
            int[] r7 = org.jivesoftware.smack.util.StringUtils.AnonymousClass1.$SwitchMap$org$jivesoftware$smack$util$StringUtils$XmlEscapeMode
            int r8 = r17.ordinal()
            r7 = r7[r8]
            java.lang.String r8 = "&quot;"
            r9 = 34
            java.lang.String r10 = "&apos;"
            r11 = 39
            r12 = 1
            java.lang.String r13 = "&lt;"
            java.lang.String r14 = "&amp;"
            r15 = 38
            r1 = 60
            if (r7 == r12) goto L59
            r12 = 2
            if (r7 == r12) goto L50
            r8 = 3
            if (r7 == r8) goto L49
            r8 = 4
            if (r7 == r8) goto L44
            goto L65
        L44:
            if (r6 == r15) goto L69
            if (r6 == r1) goto L6e
            goto L65
        L49:
            if (r6 == r15) goto L69
            if (r6 == r11) goto L67
            if (r6 == r1) goto L6e
            goto L65
        L50:
            if (r6 == r9) goto L6f
            if (r6 == r1) goto L6e
            if (r6 == r15) goto L69
            if (r6 == r11) goto L67
            goto L65
        L59:
            if (r6 == r9) goto L6f
            if (r6 == r1) goto L6e
            r1 = 62
            if (r6 == r1) goto L6b
            if (r6 == r15) goto L69
            if (r6 == r11) goto L67
        L65:
            r8 = 0
            goto L6f
        L67:
            r8 = r10
            goto L6f
        L69:
            r8 = r14
            goto L6f
        L6b:
            java.lang.String r8 = "&gt;"
            goto L6f
        L6e:
            r8 = r13
        L6f:
            if (r8 == 0) goto L7d
            if (r4 <= r5) goto L76
            r3.append(r0, r5, r4)
        L76:
            r3.append(r8)
            int r5 = r4 + 1
            r4 = r5
            goto L7f
        L7d:
            int r4 = r4 + 1
        L7f:
            r1 = 0
            goto L19
        L81:
            if (r5 != 0) goto L84
            return r0
        L84:
            if (r4 <= r5) goto L89
            r3.append(r0, r5, r4)
        L89:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.util.StringUtils.escapeForXml(java.lang.CharSequence, org.jivesoftware.smack.util.StringUtils$XmlEscapeMode):java.lang.CharSequence");
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.util.StringUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$util$StringUtils$XmlEscapeMode;

        static {
            int[] iArr = new int[XmlEscapeMode.values().length];
            $SwitchMap$org$jivesoftware$smack$util$StringUtils$XmlEscapeMode = iArr;
            try {
                iArr[XmlEscapeMode.safe.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$util$StringUtils$XmlEscapeMode[XmlEscapeMode.forAttribute.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$util$StringUtils$XmlEscapeMode[XmlEscapeMode.forAttributeApos.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$util$StringUtils$XmlEscapeMode[XmlEscapeMode.forText.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Deprecated
    public static synchronized String hash(String str) {
        return SHA1.hex(str);
    }

    public static String encodeHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = HEX_CHARS;
            cArr[i2] = cArr2[(b2 & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b2 & Ascii.SI];
        }
        return new String(cArr);
    }

    public static byte[] toUtf8Bytes(String str) {
        return str.getBytes(StandardCharsets.UTF_8);
    }

    public static String insecureRandomString(int i) {
        return randomString(i, RandomUtil.RANDOM.get());
    }

    public static String secureOnlineAttackSafeRandomString() {
        return randomString(RandomUtil.SECURE_RANDOM.get(), UNAMBIGUOUS_NUMBERS_AND_LETTERS, 10);
    }

    public static String secureUniqueRandomString() {
        return randomString(RandomUtil.SECURE_RANDOM.get(), UNAMBIGUOUS_NUMBERS_AND_LETTERS, 13);
    }

    public static String secureOfflineAttackSafeRandomString() {
        return randomString(RandomUtil.SECURE_RANDOM.get(), UNAMBIGUOUS_NUMBERS_AND_LETTERS, 24);
    }

    private static String randomString(Random random, char[] cArr, int i) {
        CharBuffer charBufferAllocate = CharBuffer.allocate(((i - 1) / 4) + i);
        try {
            randomString(charBufferAllocate, random, cArr, i);
            return charBufferAllocate.flip().toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    private static void randomString(Appendable appendable, Random random, char[] cArr, int i) throws IOException {
        for (int i2 = 1; i2 <= i; i2++) {
            appendable.append(cArr[random.nextInt(cArr.length)]);
            if (i2 % 4 == 0 && i2 < i) {
                appendable.append('-');
            }
        }
    }

    public static String randomString(int i) {
        return randomString(i, RandomUtil.SECURE_RANDOM.get());
    }

    public static String randomString(int i, Random random) {
        if (i == 0) {
            return "";
        }
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            char[] cArr2 = UNAMBIGUOUS_NUMBERS_AND_LETTERS;
            cArr[i2] = cArr2[random.nextInt(cArr2.length)];
        }
        return new String(cArr);
    }

    public static boolean isNotEmpty(CharSequence charSequence) {
        return !isNullOrEmpty(charSequence);
    }

    public static boolean isNullOrEmpty(CharSequence charSequence) {
        return charSequence == null || isEmpty(charSequence);
    }

    public static boolean isNotEmpty(CharSequence... charSequenceArr) {
        for (CharSequence charSequence : charSequenceArr) {
            if (isNullOrEmpty(charSequence)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNullOrEmpty(CharSequence... charSequenceArr) {
        for (CharSequence charSequence : charSequenceArr) {
            if (isNotEmpty(charSequence)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNullOrNotEmpty(CharSequence charSequence) {
        if (charSequence == null) {
            return true;
        }
        return !charSequence.toString().isEmpty();
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence.length() == 0;
    }

    public static String collectionToString(Collection<? extends Object> collection) {
        return toStringBuilder(collection, " ").toString();
    }

    public static StringBuilder toStringBuilder(Collection<? extends Object> collection, String str) {
        StringBuilder sb = new StringBuilder(collection.size() * 20);
        appendTo(collection, str, sb);
        return sb;
    }

    public static void appendTo(Collection<? extends Object> collection, StringBuilder sb) {
        appendTo(collection, ", ", sb);
    }

    public static <O> void appendTo(Collection<O> collection, StringBuilder sb, Consumer<O> consumer) {
        appendTo(collection, ", ", sb, consumer);
    }

    public static void appendTo(Collection<? extends Object> collection, String str, final StringBuilder sb) {
        appendTo(collection, str, sb, new Consumer() { // from class: org.jivesoftware.smack.util.StringUtils$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.util.Consumer
            public final void accept(Object obj) {
                sb.append(obj);
            }
        });
    }

    public static <O> void appendTo(Collection<O> collection, String str, StringBuilder sb, Consumer<O> consumer) {
        Iterator<O> it = collection.iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
            if (it.hasNext()) {
                sb.append(str);
            }
        }
    }

    public static String returnIfNotEmptyTrimmed(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.length() > 0) {
            return strTrim;
        }
        return null;
    }

    public static boolean nullSafeCharSequenceEquals(CharSequence charSequence, CharSequence charSequence2) {
        return nullSafeCharSequenceComparator(charSequence, charSequence2) == 0;
    }

    public static int nullSafeCharSequenceComparator(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence == null) ^ (charSequence2 == null)) {
            return charSequence == null ? -1 : 1;
        }
        if (charSequence == null && charSequence2 == null) {
            return 0;
        }
        return charSequence.toString().compareTo(charSequence2.toString());
    }

    @Deprecated
    public static <CS extends CharSequence> CS requireNotNullOrEmpty(CS cs, String str) {
        return (CS) requireNotNullNorEmpty(cs, str);
    }

    public static <CS extends CharSequence> CS requireNotNullNorEmpty(CS cs, String str) {
        if (isNullOrEmpty(cs)) {
            throw new IllegalArgumentException(str);
        }
        return cs;
    }

    public static <CS extends CharSequence> CS requireNullOrNotEmpty(CS cs, String str) {
        if (cs == null) {
            return null;
        }
        if (isEmpty(cs)) {
            throw new IllegalArgumentException(str);
        }
        return cs;
    }

    public static String maybeToString(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        return charSequence.toString();
    }

    public static String deleteXmlWhitespace(String str) {
        return XML_WHITESPACE.matcher(str).replaceAll("");
    }

    public static Appendable appendHeading(Appendable appendable, String str) throws IOException {
        return appendHeading(appendable, str, '-');
    }

    public static Appendable appendHeading(Appendable appendable, String str, char c2) throws IOException {
        appendable.append(str).append('\n');
        for (int i = 0; i < str.length(); i++) {
            appendable.append(c2);
        }
        return appendable.append('\n');
    }

    public static List<String> splitLinesPortable(String str) {
        return Arrays.asList(str.split(PORTABLE_NEWLINE_REGEX));
    }

    public static List<String> toStrings(Collection<? extends CharSequence> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<? extends CharSequence> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toString());
        }
        return arrayList;
    }
}
