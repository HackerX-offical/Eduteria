package org.jsoup.internal;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jsoup.helper.Validate;

/* JADX INFO: loaded from: classes10.dex */
public final class StringUtil {
    private static final int MaxCachedBuilderSize = 8192;
    private static final int MaxIdleBuilders = 8;
    static final String[] padding = {"", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          ", "           ", "            ", "             ", "              ", "               ", "                ", "                 ", "                  ", "                   ", "                    "};
    private static final Pattern extraDotSegmentsPattern = Pattern.compile("^/((\\.{1,2}/)+)");
    private static final Pattern validUriScheme = Pattern.compile("^[a-zA-Z][a-zA-Z0-9+-.]*:");
    private static final Pattern controlChars = Pattern.compile("[\\x00-\\x1f]*");
    private static final ThreadLocal<Stack<StringBuilder>> threadLocalBuilders = new ThreadLocal<Stack<StringBuilder>>() { // from class: org.jsoup.internal.StringUtil.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Stack<StringBuilder> initialValue() {
            return new Stack<>();
        }
    };

    public static boolean isActuallyWhitespace(int i) {
        return i == 32 || i == 9 || i == 10 || i == 12 || i == 13 || i == 160;
    }

    public static boolean isInvisibleChar(int i) {
        return i == 8203 || i == 173;
    }

    public static boolean isWhitespace(int i) {
        return i == 32 || i == 9 || i == 10 || i == 12 || i == 13;
    }

    public static String join(Collection<?> collection, String str) {
        return join(collection.iterator(), str);
    }

    public static String join(Iterator<?> it, String str) {
        if (!it.hasNext()) {
            return "";
        }
        String string = it.next().toString();
        if (!it.hasNext()) {
            return string;
        }
        StringJoiner stringJoiner = new StringJoiner(str);
        stringJoiner.add(string);
        while (it.hasNext()) {
            stringJoiner.add(it.next());
        }
        return stringJoiner.complete();
    }

    public static String join(String[] strArr, String str) {
        return join(Arrays.asList(strArr), str);
    }

    public static class StringJoiner {
        final String separator;

        @Nullable
        StringBuilder sb = StringUtil.borrowBuilder();
        boolean first = true;

        public StringJoiner(String str) {
            this.separator = str;
        }

        public StringJoiner add(Object obj) {
            Validate.notNull(this.sb);
            if (!this.first) {
                this.sb.append(this.separator);
            }
            this.sb.append(obj);
            this.first = false;
            return this;
        }

        public StringJoiner append(Object obj) {
            Validate.notNull(this.sb);
            this.sb.append(obj);
            return this;
        }

        public String complete() {
            String strReleaseBuilder = StringUtil.releaseBuilder(this.sb);
            this.sb = null;
            return strReleaseBuilder;
        }
    }

    public static String padding(int i) {
        return padding(i, 30);
    }

    public static String padding(int i, int i2) {
        Validate.isTrue(i >= 0, "width must be >= 0");
        Validate.isTrue(i2 >= -1);
        if (i2 != -1) {
            i = Math.min(i, i2);
        }
        String[] strArr = padding;
        if (i < strArr.length) {
            return strArr[i];
        }
        char[] cArr = new char[i];
        for (int i3 = 0; i3 < i; i3++) {
            cArr[i3] = ' ';
        }
        return String.valueOf(cArr);
    }

    public static boolean isBlank(String str) {
        if (str != null && str.length() != 0) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                if (!isWhitespace(str.codePointAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean startsWithNewline(String str) {
        return (str == null || str.length() == 0 || str.charAt(0) != '\n') ? false : true;
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(str.codePointAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String normaliseWhitespace(String str) {
        StringBuilder sbBorrowBuilder = borrowBuilder();
        appendNormalisedWhitespace(sbBorrowBuilder, str, false);
        return releaseBuilder(sbBorrowBuilder);
    }

    public static void appendNormalisedWhitespace(StringBuilder sb, String str, boolean z) {
        int length = str.length();
        int iCharCount = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (isActuallyWhitespace(iCodePointAt)) {
                if ((!z || z2) && !z3) {
                    sb.append(' ');
                    z3 = true;
                }
            } else if (!isInvisibleChar(iCodePointAt)) {
                sb.appendCodePoint(iCodePointAt);
                z3 = false;
                z2 = true;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
    }

    public static boolean in(String str, String... strArr) {
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean inSorted(String str, String[] strArr) {
        return Arrays.binarySearch(strArr, str) >= 0;
    }

    public static boolean isAscii(String str) {
        Validate.notNull(str);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > 127) {
                return false;
            }
        }
        return true;
    }

    public static URL resolve(URL url, String str) throws MalformedURLException {
        String strStripControlChars = stripControlChars(str);
        if (strStripControlChars.startsWith("?")) {
            strStripControlChars = url.getPath() + strStripControlChars;
        }
        URL url2 = new URL(url, strStripControlChars);
        String strReplaceFirst = extraDotSegmentsPattern.matcher(url2.getFile()).replaceFirst(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        if (url2.getRef() != null) {
            strReplaceFirst = strReplaceFirst + MqttTopic.MULTI_LEVEL_WILDCARD + url2.getRef();
        }
        return new URL(url2.getProtocol(), url2.getHost(), url2.getPort(), strReplaceFirst);
    }

    public static String resolve(String str, String str2) {
        String strStripControlChars = stripControlChars(str);
        String strStripControlChars2 = stripControlChars(str2);
        try {
            try {
                return resolve(new URL(strStripControlChars), strStripControlChars2).toExternalForm();
            } catch (MalformedURLException unused) {
                return new URL(strStripControlChars2).toExternalForm();
            }
        } catch (MalformedURLException unused2) {
            return validUriScheme.matcher(strStripControlChars2).find() ? strStripControlChars2 : "";
        }
    }

    private static String stripControlChars(String str) {
        return controlChars.matcher(str).replaceAll("");
    }

    public static StringBuilder borrowBuilder() {
        Stack<StringBuilder> stack = threadLocalBuilders.get();
        if (stack.empty()) {
            return new StringBuilder(8192);
        }
        return stack.pop();
    }

    public static String releaseBuilder(StringBuilder sb) {
        Validate.notNull(sb);
        String string = sb.toString();
        if (sb.length() > 8192) {
            sb = new StringBuilder(8192);
        } else {
            sb.delete(0, sb.length());
        }
        Stack<StringBuilder> stack = threadLocalBuilders.get();
        stack.push(sb);
        while (stack.size() > 8) {
            stack.pop();
        }
        return string;
    }
}
