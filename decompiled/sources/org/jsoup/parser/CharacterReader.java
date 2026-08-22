package org.jsoup.parser;

import androidx.core.app.FrameMetricsAggregator;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import javax.annotation.Nullable;
import org.jsoup.UncheckedIOException;
import org.jsoup.helper.Validate;

/* JADX INFO: loaded from: classes10.dex */
public final class CharacterReader {
    static final char EOF = 65535;
    static final int maxBufferLen = 32768;
    private static final int maxStringCacheLen = 12;
    private static final int minReadAheadLen = 1024;
    static final int readAheadLimit = 24576;
    private static final int stringCacheSize = 512;
    private int bufLength;
    private int bufMark;
    private int bufPos;
    private int bufSplitPoint;
    private char[] charBuf;
    private int lastIcIndex;

    @Nullable
    private String lastIcSeq;
    private int lineNumberOffset;

    @Nullable
    private ArrayList<Integer> newlinePositions;
    private boolean readFully;
    private Reader reader;
    private int readerPos;
    private String[] stringCache;

    public CharacterReader(Reader reader, int i) {
        this.bufMark = -1;
        this.stringCache = new String[512];
        this.newlinePositions = null;
        this.lineNumberOffset = 1;
        Validate.notNull(reader);
        Validate.isTrue(reader.markSupported());
        this.reader = reader;
        this.charBuf = new char[Math.min(i, 32768)];
        bufferUp();
    }

    public CharacterReader(Reader reader) {
        this(reader, 32768);
    }

    public CharacterReader(String str) {
        this(new StringReader(str), str.length());
    }

    public void close() {
        Reader reader = this.reader;
        if (reader == null) {
            return;
        }
        try {
            reader.close();
        } catch (IOException unused) {
        } catch (Throwable th) {
            this.reader = null;
            this.charBuf = null;
            this.stringCache = null;
            throw th;
        }
        this.reader = null;
        this.charBuf = null;
        this.stringCache = null;
    }

    private void bufferUp() {
        int i;
        int i2;
        boolean z;
        if (this.readFully || (i = this.bufPos) < this.bufSplitPoint) {
            return;
        }
        int i3 = this.bufMark;
        if (i3 != -1) {
            i2 = i - i3;
            i = i3;
        } else {
            i2 = 0;
        }
        try {
            long j = i;
            long jSkip = this.reader.skip(j);
            this.reader.mark(32768);
            int i4 = 0;
            while (true) {
                z = true;
                if (i4 > 1024) {
                    break;
                }
                Reader reader = this.reader;
                char[] cArr = this.charBuf;
                int i5 = reader.read(cArr, i4, cArr.length - i4);
                if (i5 == -1) {
                    this.readFully = true;
                }
                if (i5 <= 0) {
                    break;
                } else {
                    i4 += i5;
                }
            }
            this.reader.reset();
            if (i4 > 0) {
                if (jSkip != j) {
                    z = false;
                }
                Validate.isTrue(z);
                this.bufLength = i4;
                this.readerPos += i;
                this.bufPos = i2;
                if (this.bufMark != -1) {
                    this.bufMark = 0;
                }
                this.bufSplitPoint = Math.min(i4, readAheadLimit);
            }
            scanBufferForNewlines();
            this.lastIcSeq = null;
        } catch (IOException e2) {
            throw new UncheckedIOException(e2);
        }
    }

    public int pos() {
        return this.readerPos + this.bufPos;
    }

    public void trackNewlines(boolean z) {
        if (z && this.newlinePositions == null) {
            this.newlinePositions = new ArrayList<>(409);
            scanBufferForNewlines();
        } else {
            if (z) {
                return;
            }
            this.newlinePositions = null;
        }
    }

    public boolean isTrackNewlines() {
        return this.newlinePositions != null;
    }

    public int lineNumber() {
        return lineNumber(pos());
    }

    int lineNumber(int i) {
        if (!isTrackNewlines()) {
            return 1;
        }
        int iLineNumIndex = lineNumIndex(i);
        if (iLineNumIndex == -1) {
            return this.lineNumberOffset;
        }
        return iLineNumIndex + this.lineNumberOffset + 1;
    }

    public int columnNumber() {
        return columnNumber(pos());
    }

    int columnNumber(int i) {
        int iLineNumIndex;
        if (isTrackNewlines() && (iLineNumIndex = lineNumIndex(i)) != -1) {
            return (i - this.newlinePositions.get(iLineNumIndex).intValue()) + 1;
        }
        return i + 1;
    }

    String cursorPos() {
        return lineNumber() + ":" + columnNumber();
    }

    private int lineNumIndex(int i) {
        if (!isTrackNewlines()) {
            return 0;
        }
        int iBinarySearch = Collections.binarySearch(this.newlinePositions, Integer.valueOf(i));
        return iBinarySearch < -1 ? Math.abs(iBinarySearch) - 2 : iBinarySearch;
    }

    private void scanBufferForNewlines() {
        if (isTrackNewlines()) {
            if (this.newlinePositions.size() > 0) {
                int iLineNumIndex = lineNumIndex(this.readerPos);
                if (iLineNumIndex == -1) {
                    iLineNumIndex = 0;
                }
                int iIntValue = this.newlinePositions.get(iLineNumIndex).intValue();
                this.lineNumberOffset += iLineNumIndex;
                this.newlinePositions.clear();
                this.newlinePositions.add(Integer.valueOf(iIntValue));
            }
            for (int i = this.bufPos; i < this.bufLength; i++) {
                if (this.charBuf[i] == '\n') {
                    this.newlinePositions.add(Integer.valueOf(this.readerPos + 1 + i));
                }
            }
        }
    }

    public boolean isEmpty() {
        bufferUp();
        return this.bufPos >= this.bufLength;
    }

    private boolean isEmptyNoBufferUp() {
        return this.bufPos >= this.bufLength;
    }

    public char current() {
        bufferUp();
        if (isEmptyNoBufferUp()) {
            return (char) 65535;
        }
        return this.charBuf[this.bufPos];
    }

    char consume() {
        bufferUp();
        char c2 = isEmptyNoBufferUp() ? (char) 65535 : this.charBuf[this.bufPos];
        this.bufPos++;
        return c2;
    }

    void unconsume() {
        int i = this.bufPos;
        if (i < 1) {
            throw new UncheckedIOException(new IOException("WTF: No buffer left to unconsume."));
        }
        this.bufPos = i - 1;
    }

    public void advance() {
        this.bufPos++;
    }

    void mark() {
        if (this.bufLength - this.bufPos < 1024) {
            this.bufSplitPoint = 0;
        }
        bufferUp();
        this.bufMark = this.bufPos;
    }

    void unmark() {
        this.bufMark = -1;
    }

    void rewindToMark() {
        int i = this.bufMark;
        if (i == -1) {
            throw new UncheckedIOException(new IOException("Mark invalid"));
        }
        this.bufPos = i;
        unmark();
    }

    int nextIndexOf(char c2) {
        bufferUp();
        for (int i = this.bufPos; i < this.bufLength; i++) {
            if (c2 == this.charBuf[i]) {
                return i - this.bufPos;
            }
        }
        return -1;
    }

    int nextIndexOf(CharSequence charSequence) {
        bufferUp();
        char cCharAt = charSequence.charAt(0);
        int i = this.bufPos;
        while (i < this.bufLength) {
            if (cCharAt != this.charBuf[i]) {
                do {
                    i++;
                    if (i >= this.bufLength) {
                        break;
                    }
                } while (cCharAt != this.charBuf[i]);
            }
            int i2 = i + 1;
            int length = (charSequence.length() + i2) - 1;
            int i3 = this.bufLength;
            if (i < i3 && length <= i3) {
                int i4 = i2;
                for (int i5 = 1; i4 < length && charSequence.charAt(i5) == this.charBuf[i4]; i5++) {
                    i4++;
                }
                if (i4 == length) {
                    return i - this.bufPos;
                }
            }
            i = i2;
        }
        return -1;
    }

    public String consumeTo(char c2) {
        int iNextIndexOf = nextIndexOf(c2);
        if (iNextIndexOf != -1) {
            String strCacheString = cacheString(this.charBuf, this.stringCache, this.bufPos, iNextIndexOf);
            this.bufPos += iNextIndexOf;
            return strCacheString;
        }
        return consumeToEnd();
    }

    String consumeTo(String str) {
        int iNextIndexOf = nextIndexOf(str);
        if (iNextIndexOf != -1) {
            String strCacheString = cacheString(this.charBuf, this.stringCache, this.bufPos, iNextIndexOf);
            this.bufPos += iNextIndexOf;
            return strCacheString;
        }
        if (this.bufLength - this.bufPos < str.length()) {
            return consumeToEnd();
        }
        int length = (this.bufLength - str.length()) + 1;
        char[] cArr = this.charBuf;
        String[] strArr = this.stringCache;
        int i = this.bufPos;
        String strCacheString2 = cacheString(cArr, strArr, i, length - i);
        this.bufPos = length;
        return strCacheString2;
    }

    public String consumeToAny(char... cArr) {
        bufferUp();
        int i = this.bufPos;
        int i2 = this.bufLength;
        char[] cArr2 = this.charBuf;
        int i3 = i;
        loop0: while (i3 < i2) {
            for (char c2 : cArr) {
                if (cArr2[i3] == c2) {
                    break loop0;
                }
            }
            i3++;
        }
        this.bufPos = i3;
        return i3 > i ? cacheString(this.charBuf, this.stringCache, i, i3 - i) : "";
    }

    String consumeToAnySorted(char... cArr) {
        bufferUp();
        int i = this.bufPos;
        int i2 = this.bufLength;
        char[] cArr2 = this.charBuf;
        int i3 = i;
        while (i3 < i2 && Arrays.binarySearch(cArr, cArr2[i3]) < 0) {
            i3++;
        }
        this.bufPos = i3;
        return i3 > i ? cacheString(this.charBuf, this.stringCache, i, i3 - i) : "";
    }

    String consumeData() {
        int i = this.bufPos;
        int i2 = this.bufLength;
        char[] cArr = this.charBuf;
        int i3 = i;
        while (i3 < i2) {
            char c2 = cArr[i3];
            if (c2 == 0 || c2 == '&' || c2 == '<') {
                break;
            }
            i3++;
        }
        this.bufPos = i3;
        return i3 > i ? cacheString(this.charBuf, this.stringCache, i, i3 - i) : "";
    }

    String consumeAttributeQuoted(boolean z) {
        int i = this.bufPos;
        int i2 = this.bufLength;
        char[] cArr = this.charBuf;
        int i3 = i;
        while (i3 < i2) {
            char c2 = cArr[i3];
            if (c2 == 0) {
                break;
            }
            if (c2 != '\"') {
                if (c2 == '&') {
                    break;
                }
                if (c2 == '\'') {
                    if (!z) {
                        break;
                        break;
                    }
                    break;
                }
                continue;
                i3++;
            }
            if (!z) {
                break;
            }
            i3++;
        }
        this.bufPos = i3;
        return i3 > i ? cacheString(this.charBuf, this.stringCache, i, i3 - i) : "";
    }

    String consumeRawData() {
        int i = this.bufPos;
        int i2 = this.bufLength;
        char[] cArr = this.charBuf;
        int i3 = i;
        while (i3 < i2) {
            char c2 = cArr[i3];
            if (c2 == 0 || c2 == '<') {
                break;
            }
            i3++;
        }
        this.bufPos = i3;
        return i3 > i ? cacheString(this.charBuf, this.stringCache, i, i3 - i) : "";
    }

    String consumeTagName() {
        bufferUp();
        int i = this.bufPos;
        int i2 = this.bufLength;
        char[] cArr = this.charBuf;
        int i3 = i;
        while (i3 < i2) {
            char c2 = cArr[i3];
            if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ' || c2 == '/' || c2 == '<' || c2 == '>') {
                break;
            }
            i3++;
        }
        this.bufPos = i3;
        return i3 > i ? cacheString(this.charBuf, this.stringCache, i, i3 - i) : "";
    }

    String consumeToEnd() {
        bufferUp();
        char[] cArr = this.charBuf;
        String[] strArr = this.stringCache;
        int i = this.bufPos;
        String strCacheString = cacheString(cArr, strArr, i, this.bufLength - i);
        this.bufPos = this.bufLength;
        return strCacheString;
    }

    String consumeLetterSequence() {
        char c2;
        bufferUp();
        int i = this.bufPos;
        while (true) {
            int i2 = this.bufPos;
            if (i2 >= this.bufLength || (((c2 = this.charBuf[i2]) < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !Character.isLetter(c2)))) {
                break;
            }
            this.bufPos++;
        }
        return cacheString(this.charBuf, this.stringCache, i, this.bufPos - i);
    }

    String consumeLetterThenDigitSequence() {
        char c2;
        bufferUp();
        int i = this.bufPos;
        while (true) {
            int i2 = this.bufPos;
            if (i2 >= this.bufLength || (((c2 = this.charBuf[i2]) < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !Character.isLetter(c2)))) {
                break;
            }
            this.bufPos++;
        }
        while (!isEmptyNoBufferUp()) {
            char[] cArr = this.charBuf;
            int i3 = this.bufPos;
            char c3 = cArr[i3];
            if (c3 < '0' || c3 > '9') {
                break;
            }
            this.bufPos = i3 + 1;
        }
        return cacheString(this.charBuf, this.stringCache, i, this.bufPos - i);
    }

    String consumeHexSequence() {
        int i;
        char c2;
        bufferUp();
        int i2 = this.bufPos;
        while (true) {
            i = this.bufPos;
            if (i >= this.bufLength || (((c2 = this.charBuf[i]) < '0' || c2 > '9') && ((c2 < 'A' || c2 > 'F') && (c2 < 'a' || c2 > 'f')))) {
                break;
            }
            this.bufPos = i + 1;
        }
        return cacheString(this.charBuf, this.stringCache, i2, i - i2);
    }

    String consumeDigitSequence() {
        int i;
        char c2;
        bufferUp();
        int i2 = this.bufPos;
        while (true) {
            i = this.bufPos;
            if (i >= this.bufLength || (c2 = this.charBuf[i]) < '0' || c2 > '9') {
                break;
            }
            this.bufPos = i + 1;
        }
        return cacheString(this.charBuf, this.stringCache, i2, i - i2);
    }

    boolean matches(char c2) {
        return !isEmpty() && this.charBuf[this.bufPos] == c2;
    }

    boolean matches(String str) {
        bufferUp();
        int length = str.length();
        if (length > this.bufLength - this.bufPos) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != this.charBuf[this.bufPos + i]) {
                return false;
            }
        }
        return true;
    }

    boolean matchesIgnoreCase(String str) {
        bufferUp();
        int length = str.length();
        if (length > this.bufLength - this.bufPos) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (Character.toUpperCase(str.charAt(i)) != Character.toUpperCase(this.charBuf[this.bufPos + i])) {
                return false;
            }
        }
        return true;
    }

    boolean matchesAny(char... cArr) {
        if (isEmpty()) {
            return false;
        }
        bufferUp();
        char c2 = this.charBuf[this.bufPos];
        for (char c3 : cArr) {
            if (c3 == c2) {
                return true;
            }
        }
        return false;
    }

    boolean matchesAnySorted(char[] cArr) {
        bufferUp();
        return !isEmpty() && Arrays.binarySearch(cArr, this.charBuf[this.bufPos]) >= 0;
    }

    boolean matchesLetter() {
        if (isEmpty()) {
            return false;
        }
        char c2 = this.charBuf[this.bufPos];
        if (c2 < 'A' || c2 > 'Z') {
            return (c2 >= 'a' && c2 <= 'z') || Character.isLetter(c2);
        }
        return true;
    }

    boolean matchesAsciiAlpha() {
        if (isEmpty()) {
            return false;
        }
        char c2 = this.charBuf[this.bufPos];
        if (c2 < 'A' || c2 > 'Z') {
            return c2 >= 'a' && c2 <= 'z';
        }
        return true;
    }

    boolean matchesDigit() {
        char c2;
        return !isEmpty() && (c2 = this.charBuf[this.bufPos]) >= '0' && c2 <= '9';
    }

    boolean matchConsume(String str) {
        bufferUp();
        if (!matches(str)) {
            return false;
        }
        this.bufPos += str.length();
        return true;
    }

    boolean matchConsumeIgnoreCase(String str) {
        if (!matchesIgnoreCase(str)) {
            return false;
        }
        this.bufPos += str.length();
        return true;
    }

    boolean containsIgnoreCase(String str) {
        if (str.equals(this.lastIcSeq)) {
            int i = this.lastIcIndex;
            if (i == -1) {
                return false;
            }
            if (i >= this.bufPos) {
                return true;
            }
        }
        this.lastIcSeq = str;
        int iNextIndexOf = nextIndexOf(str.toLowerCase(Locale.ENGLISH));
        if (iNextIndexOf > -1) {
            this.lastIcIndex = this.bufPos + iNextIndexOf;
            return true;
        }
        int iNextIndexOf2 = nextIndexOf(str.toUpperCase(Locale.ENGLISH));
        boolean z = iNextIndexOf2 > -1;
        this.lastIcIndex = z ? this.bufPos + iNextIndexOf2 : -1;
        return z;
    }

    public String toString() {
        if (this.bufLength - this.bufPos < 0) {
            return "";
        }
        char[] cArr = this.charBuf;
        int i = this.bufPos;
        return new String(cArr, i, this.bufLength - i);
    }

    private static String cacheString(char[] cArr, String[] strArr, int i, int i2) {
        if (i2 > 12) {
            return new String(cArr, i, i2);
        }
        if (i2 < 1) {
            return "";
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 * 31) + cArr[i + i4];
        }
        int i5 = i3 & FrameMetricsAggregator.EVERY_DURATION;
        String str = strArr[i5];
        if (str != null && rangeEquals(cArr, i, i2, str)) {
            return str;
        }
        String str2 = new String(cArr, i, i2);
        strArr[i5] = str2;
        return str2;
    }

    static boolean rangeEquals(char[] cArr, int i, int i2, String str) {
        if (i2 != str.length()) {
            return false;
        }
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 == 0) {
                return true;
            }
            int i5 = i + 1;
            int i6 = i3 + 1;
            if (cArr[i] != str.charAt(i3)) {
                return false;
            }
            i = i5;
            i2 = i4;
            i3 = i6;
        }
    }

    boolean rangeEquals(int i, int i2, String str) {
        return rangeEquals(this.charBuf, i, i2, str);
    }
}
