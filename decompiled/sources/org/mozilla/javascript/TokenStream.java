package org.mozilla.javascript;

import java.io.IOException;
import java.io.Reader;
import org.mozilla.javascript.Token;

/* JADX INFO: loaded from: classes10.dex */
class TokenStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final char BYTE_ORDER_MARK = 65279;
    private static final int EOF_CHAR = -1;
    Token.CommentType commentType;
    int cursor;
    private boolean dirtyLine;
    private boolean isBinary;
    private boolean isHex;
    private boolean isOctal;
    private boolean isOldOctal;
    int lineno;
    private double number;
    private Parser parser;
    private int quoteChar;
    String regExpFlags;
    private char[] sourceBuffer;
    int sourceCursor;
    private int sourceEnd;
    private Reader sourceReader;
    private String sourceString;
    private int stringBufferTop;
    int tokenBeg;
    int tokenEnd;
    private int ungetCursor;
    private boolean xmlIsAttribute;
    private boolean xmlIsTagContent;
    private int xmlOpenTagsCount;
    private String string = "";
    private char[] stringBuffer = new char[128];
    private ObjToIntMap allStrings = new ObjToIntMap(50);
    private final int[] ungetBuffer = new int[3];
    private boolean hitEOF = false;
    private int lineStart = 0;
    private int lineEndChar = -1;
    private String commentPrefix = "";
    private int commentCursor = -1;

    private static boolean isAlpha(int i) {
        return i <= 90 ? 65 <= i : 97 <= i && i <= 122;
    }

    static boolean isDigit(int i) {
        return 48 <= i && i <= 57;
    }

    TokenStream(Parser parser, Reader reader, String str, int i) {
        this.parser = parser;
        this.lineno = i;
        if (reader != null) {
            if (str != null) {
                Kit.codeBug();
            }
            this.sourceReader = reader;
            this.sourceBuffer = new char[512];
            this.sourceEnd = 0;
        } else {
            if (str == null) {
                Kit.codeBug();
            }
            this.sourceString = str;
            this.sourceEnd = str.length();
        }
        this.cursor = 0;
        this.sourceCursor = 0;
    }

    String tokenToString(int i) {
        return "";
    }

    static boolean isKeyword(String str, int i, boolean z) {
        return stringToKeyword(str, i, z) != 0;
    }

    private static int stringToKeyword(String str, int i, boolean z) {
        if (i < 200) {
            return stringToKeywordForJS(str);
        }
        return stringToKeywordForES(str, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0204, code lost:
    
        if (r17.charAt(1) == 'n') goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x021c, code lost:
    
        if (r17.charAt(1) == 'a') goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x022e, code lost:
    
        if (r17.charAt(1) == 'h') goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x029c, code lost:
    
        if (r17.charAt(1) == 'n') goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x029e, code lost:
    
        r6 = 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x02d3, code lost:
    
        if (r17.charAt(0) == 'd') goto L225;
     */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02da A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02e4 A[PHI: r2
      0x02e4: PHI (r2v36 int) = (r2v2 int), (r2v0 int), (r2v37 int), (r2v37 int), (r2v37 int) binds: [B:217:0x02d3, B:158:0x021c, B:220:0x02d8, B:221:0x02da, B:223:0x02e0] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int stringToKeywordForJS(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.TokenStream.stringToKeywordForJS(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x01a8, code lost:
    
        if (r17.charAt(1) == 'l') goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0267, code lost:
    
        if (r17.charAt(0) == 'd') goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007a, code lost:
    
        if (r1 != 'x') goto L186;
     */
    /* JADX WARN: Removed duplicated region for block: B:186:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x026e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0278 A[PHI: r2
      0x0278: PHI (r2v33 int) = (r2v2 int), (r2v34 int), (r2v34 int), (r2v34 int) binds: [B:184:0x0267, B:187:0x026c, B:188:0x026e, B:190:0x0274] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int stringToKeywordForES(java.lang.String r17, boolean r18) {
        /*
            Method dump skipped, instruction units count: 672
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.TokenStream.stringToKeywordForES(java.lang.String, boolean):int");
    }

    final String getSourceString() {
        return this.sourceString;
    }

    final int getLineno() {
        return this.lineno;
    }

    final String getString() {
        return this.string;
    }

    final char getQuoteChar() {
        return (char) this.quoteChar;
    }

    final double getNumber() {
        return this.number;
    }

    final boolean isNumberBinary() {
        return this.isBinary;
    }

    final boolean isNumberOldOctal() {
        return this.isOldOctal;
    }

    final boolean isNumberOctal() {
        return this.isOctal;
    }

    final boolean isNumberHex() {
        return this.isHex;
    }

    final boolean eof() {
        return this.hitEOF;
    }

    /* JADX WARN: Removed duplicated region for block: B:214:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:491:0x0295 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:215:0x02a4 -> B:207:0x0288). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int getToken() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.TokenStream.getToken():int");
    }

    static boolean isJSSpace(int i) {
        return i <= 127 ? i == 32 || i == 9 || i == 12 || i == 11 : i == 160 || i == 65279 || Character.getType((char) i) == 12;
    }

    private static boolean isJSFormatChar(int i) {
        return i > 127 && Character.getType((char) i) == 16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a7, code lost:
    
        ungetChar(r2);
        r5.tokenEnd = r5.cursor - 1;
        r5.string = new java.lang.String(r5.stringBuffer, 0, r5.stringBufferTop);
        r5.parser.reportError("msg.unterminated.re.lit");
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c1, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void readRegExp(int r6) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.tokenBeg
            r1 = 0
            r5.stringBufferTop = r1
            r2 = 101(0x65, float:1.42E-43)
            if (r6 != r2) goto Lf
            r6 = 61
            r5.addToString(r6)
            goto L16
        Lf:
            r2 = 24
            if (r6 == r2) goto L16
            org.mozilla.javascript.Kit.codeBug()
        L16:
            r6 = r1
        L17:
            int r2 = r5.getChar()
            r3 = 47
            if (r2 != r3) goto L82
            if (r6 == 0) goto L22
            goto L82
        L22:
            int r6 = r5.stringBufferTop
        L24:
            r2 = 103(0x67, float:1.44E-43)
            boolean r3 = r5.matchChar(r2)
            if (r3 == 0) goto L30
            r5.addToString(r2)
            goto L24
        L30:
            r2 = 105(0x69, float:1.47E-43)
            boolean r3 = r5.matchChar(r2)
            if (r3 == 0) goto L3c
            r5.addToString(r2)
            goto L24
        L3c:
            r2 = 109(0x6d, float:1.53E-43)
            boolean r3 = r5.matchChar(r2)
            if (r3 == 0) goto L48
            r5.addToString(r2)
            goto L24
        L48:
            r2 = 121(0x79, float:1.7E-43)
            boolean r3 = r5.matchChar(r2)
            if (r3 == 0) goto L54
            r5.addToString(r2)
            goto L24
        L54:
            int r2 = r5.stringBufferTop
            int r0 = r0 + r2
            int r0 = r0 + 2
            r5.tokenEnd = r0
            int r0 = r5.peekChar()
            boolean r0 = isAlpha(r0)
            if (r0 == 0) goto L6c
            org.mozilla.javascript.Parser r0 = r5.parser
            java.lang.String r2 = "msg.invalid.re.flag"
            r0.reportError(r2)
        L6c:
            java.lang.String r0 = new java.lang.String
            char[] r2 = r5.stringBuffer
            r0.<init>(r2, r1, r6)
            r5.string = r0
            java.lang.String r0 = new java.lang.String
            char[] r1 = r5.stringBuffer
            int r2 = r5.stringBufferTop
            int r2 = r2 - r6
            r0.<init>(r1, r6, r2)
            r5.regExpFlags = r0
            return
        L82:
            r3 = 10
            r4 = 1
            if (r2 == r3) goto La7
            r3 = -1
            if (r2 != r3) goto L8b
            goto La7
        L8b:
            r3 = 92
            if (r2 != r3) goto L97
            r5.addToString(r2)
            int r2 = r5.getChar()
            goto La2
        L97:
            r3 = 91
            if (r2 != r3) goto L9d
            r6 = r4
            goto La2
        L9d:
            r3 = 93
            if (r2 != r3) goto La2
            r6 = r1
        La2:
            r5.addToString(r2)
            goto L17
        La7:
            r5.ungetChar(r2)
            int r6 = r5.cursor
            int r6 = r6 - r4
            r5.tokenEnd = r6
            java.lang.String r6 = new java.lang.String
            char[] r0 = r5.stringBuffer
            int r2 = r5.stringBufferTop
            r6.<init>(r0, r1, r2)
            r5.string = r6
            org.mozilla.javascript.Parser r6 = r5.parser
            java.lang.String r0 = "msg.unterminated.re.lit"
            r6.reportError(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.TokenStream.readRegExp(int):void");
    }

    String readAndClearRegExpFlags() {
        String str = this.regExpFlags;
        this.regExpFlags = null;
        return str;
    }

    boolean isXMLAttribute() {
        return this.xmlIsAttribute;
    }

    int getFirstXMLToken() throws IOException {
        this.xmlOpenTagsCount = 0;
        this.xmlIsAttribute = false;
        this.xmlIsTagContent = false;
        if (!canUngetChar()) {
            return -1;
        }
        ungetChar(60);
        return getNextXMLToken();
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0154, code lost:
    
        r10.stringBufferTop = 0;
        r10.string = null;
        r10.parser.addError("msg.XML.bad.form");
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x015d, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    int getNextXMLToken() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.TokenStream.getNextXMLToken():int");
    }

    private boolean readQuotedString(int i) throws IOException {
        int i2;
        do {
            i2 = getChar();
            if (i2 != -1) {
                addToString(i2);
            } else {
                this.stringBufferTop = 0;
                this.string = null;
                this.parser.addError("msg.XML.bad.form");
                return false;
            }
        } while (i2 != i);
        return true;
    }

    private boolean readXmlComment() throws IOException {
        int i = getChar();
        while (i != -1) {
            addToString(i);
            if (i == 45 && peekChar() == 45) {
                i = getChar();
                addToString(i);
                if (peekChar() == 62) {
                    addToString(getChar());
                    return true;
                }
            } else {
                i = getChar();
            }
        }
        this.stringBufferTop = 0;
        this.string = null;
        this.parser.addError("msg.XML.bad.form");
        return false;
    }

    private boolean readCDATA() throws IOException {
        int i = getChar();
        while (i != -1) {
            addToString(i);
            if (i == 93 && peekChar() == 93) {
                i = getChar();
                addToString(i);
                if (peekChar() == 62) {
                    addToString(getChar());
                    return true;
                }
            } else {
                i = getChar();
            }
        }
        this.stringBufferTop = 0;
        this.string = null;
        this.parser.addError("msg.XML.bad.form");
        return false;
    }

    private boolean readEntity() throws IOException {
        int i = getChar();
        int i2 = 1;
        while (i != -1) {
            addToString(i);
            if (i == 60) {
                i2++;
            } else if (i == 62 && i2 - 1 == 0) {
                return true;
            }
            i = getChar();
        }
        this.stringBufferTop = 0;
        this.string = null;
        this.parser.addError("msg.XML.bad.form");
        return false;
    }

    private boolean readPI() throws IOException {
        while (true) {
            int i = getChar();
            if (i != -1) {
                addToString(i);
                if (i == 63 && peekChar() == 62) {
                    addToString(getChar());
                    return true;
                }
            } else {
                this.stringBufferTop = 0;
                this.string = null;
                this.parser.addError("msg.XML.bad.form");
                return false;
            }
        }
    }

    private String getStringFromBuffer() {
        this.tokenEnd = this.cursor;
        return new String(this.stringBuffer, 0, this.stringBufferTop);
    }

    private void addToString(int i) {
        int i2 = this.stringBufferTop;
        char[] cArr = this.stringBuffer;
        if (i2 == cArr.length) {
            char[] cArr2 = new char[cArr.length * 2];
            System.arraycopy(cArr, 0, cArr2, 0, i2);
            this.stringBuffer = cArr2;
        }
        this.stringBuffer[i2] = (char) i;
        this.stringBufferTop = i2 + 1;
    }

    private boolean canUngetChar() {
        int i = this.ungetCursor;
        return i == 0 || this.ungetBuffer[i - 1] != 10;
    }

    private void ungetChar(int i) {
        int i2 = this.ungetCursor;
        if (i2 != 0 && this.ungetBuffer[i2 - 1] == 10) {
            Kit.codeBug();
        }
        int[] iArr = this.ungetBuffer;
        int i3 = this.ungetCursor;
        this.ungetCursor = i3 + 1;
        iArr[i3] = i;
        this.cursor--;
    }

    private boolean matchChar(int i) throws IOException {
        int charIgnoreLineEnd = getCharIgnoreLineEnd();
        if (charIgnoreLineEnd == i) {
            this.tokenEnd = this.cursor;
            return true;
        }
        ungetCharIgnoreLineEnd(charIgnoreLineEnd);
        return false;
    }

    private int peekChar() throws IOException {
        int i = getChar();
        ungetChar(i);
        return i;
    }

    private int getChar() throws IOException {
        return getChar(true);
    }

    private int getChar(boolean z) throws IOException {
        char cCharAt;
        int i = this.ungetCursor;
        if (i != 0) {
            this.cursor++;
            int[] iArr = this.ungetBuffer;
            int i2 = i - 1;
            this.ungetCursor = i2;
            return iArr[i2];
        }
        while (true) {
            String str = this.sourceString;
            if (str != null) {
                int i3 = this.sourceCursor;
                if (i3 == this.sourceEnd) {
                    this.hitEOF = true;
                    return -1;
                }
                this.cursor++;
                this.sourceCursor = i3 + 1;
                cCharAt = str.charAt(i3);
            } else {
                if (this.sourceCursor == this.sourceEnd && !fillSourceBuffer()) {
                    this.hitEOF = true;
                    return -1;
                }
                this.cursor++;
                char[] cArr = this.sourceBuffer;
                int i4 = this.sourceCursor;
                this.sourceCursor = i4 + 1;
                cCharAt = cArr[i4];
            }
            int i5 = this.lineEndChar;
            if (i5 >= 0) {
                if (i5 == 13 && cCharAt == '\n') {
                    this.lineEndChar = 10;
                } else {
                    this.lineEndChar = -1;
                    this.lineStart = this.sourceCursor - 1;
                    this.lineno++;
                }
            }
            if (cCharAt > 127) {
                if (cCharAt == 65279) {
                    break;
                }
                if (!z || !isJSFormatChar(cCharAt)) {
                    break;
                }
            } else if (cCharAt == '\n' || cCharAt == '\r') {
                this.lineEndChar = cCharAt;
                return 10;
            }
        }
        if (ScriptRuntime.isJSLineTerminator(cCharAt)) {
            this.lineEndChar = cCharAt;
            return 10;
        }
        return cCharAt;
    }

    private int getCharIgnoreLineEnd() throws IOException {
        char cCharAt;
        int i = this.ungetCursor;
        if (i != 0) {
            this.cursor++;
            int[] iArr = this.ungetBuffer;
            int i2 = i - 1;
            this.ungetCursor = i2;
            return iArr[i2];
        }
        while (true) {
            String str = this.sourceString;
            if (str != null) {
                int i3 = this.sourceCursor;
                if (i3 == this.sourceEnd) {
                    this.hitEOF = true;
                    return -1;
                }
                this.cursor++;
                this.sourceCursor = i3 + 1;
                cCharAt = str.charAt(i3);
            } else {
                if (this.sourceCursor == this.sourceEnd && !fillSourceBuffer()) {
                    this.hitEOF = true;
                    return -1;
                }
                this.cursor++;
                char[] cArr = this.sourceBuffer;
                int i4 = this.sourceCursor;
                this.sourceCursor = i4 + 1;
                cCharAt = cArr[i4];
            }
            if (cCharAt > 127) {
                if (cCharAt == 65279) {
                    break;
                }
                if (!isJSFormatChar(cCharAt)) {
                    if (ScriptRuntime.isJSLineTerminator(cCharAt)) {
                        this.lineEndChar = cCharAt;
                        return 10;
                    }
                }
            } else if (cCharAt == '\n' || cCharAt == '\r') {
                this.lineEndChar = cCharAt;
                return 10;
            }
        }
        return cCharAt;
    }

    private void ungetCharIgnoreLineEnd(int i) {
        int[] iArr = this.ungetBuffer;
        int i2 = this.ungetCursor;
        this.ungetCursor = i2 + 1;
        iArr[i2] = i;
        this.cursor--;
    }

    private void skipLine() throws IOException {
        int i;
        do {
            i = getChar();
            if (i == -1) {
                break;
            }
        } while (i != 10);
        ungetChar(i);
        this.tokenEnd = this.cursor;
    }

    final int getOffset() {
        int i = this.sourceCursor - this.lineStart;
        return this.lineEndChar >= 0 ? i - 1 : i;
    }

    private final int charAt(int i) {
        if (i < 0) {
            return -1;
        }
        String str = this.sourceString;
        if (str != null) {
            if (i >= this.sourceEnd) {
                return -1;
            }
            return str.charAt(i);
        }
        if (i >= this.sourceEnd) {
            int i2 = this.sourceCursor;
            try {
                if (!fillSourceBuffer()) {
                    return -1;
                }
                i -= i2 - this.sourceCursor;
            } catch (IOException unused) {
                return -1;
            }
        }
        return this.sourceBuffer[i];
    }

    private final String substring(int i, int i2) {
        String str = this.sourceString;
        if (str != null) {
            return str.substring(i, i2);
        }
        return new String(this.sourceBuffer, i, i2 - i);
    }

    final String getLine() {
        int i;
        int i2 = this.sourceCursor;
        int i3 = this.lineEndChar;
        if (i3 >= 0) {
            i = i2 - 1;
            if (i3 == 10 && charAt(i2 - 2) == 13) {
                i = i2 - 2;
            }
        } else {
            int i4 = i2 - this.lineStart;
            while (true) {
                int iCharAt = charAt(this.lineStart + i4);
                if (iCharAt == -1 || ScriptRuntime.isJSLineTerminator(iCharAt)) {
                    break;
                }
                i4++;
            }
            i = this.lineStart + i4;
        }
        return substring(this.lineStart, i);
    }

    final String getLine(int i, int[] iArr) {
        int i2 = (this.cursor + this.ungetCursor) - i;
        int i3 = this.sourceCursor;
        if (i2 > i3) {
            return null;
        }
        int i4 = 0;
        int i5 = 0;
        while (i2 > 0) {
            int iCharAt = charAt(i3 - 1);
            if (ScriptRuntime.isJSLineTerminator(iCharAt)) {
                if (iCharAt == 10 && charAt(i3 - 2) == 13) {
                    i2--;
                    i3--;
                }
                i4++;
                i5 = i3 - 1;
            }
            i2--;
            i3--;
        }
        int i6 = 0;
        while (true) {
            if (i3 <= 0) {
                i3 = 0;
                break;
            }
            if (ScriptRuntime.isJSLineTerminator(charAt(i3 - 1))) {
                break;
            }
            i3--;
            i6++;
        }
        iArr[0] = (this.lineno - i4) + (this.lineEndChar >= 0 ? 1 : 0);
        iArr[1] = i6;
        if (i4 == 0) {
            return getLine();
        }
        return substring(i3, i5);
    }

    private boolean fillSourceBuffer() throws IOException {
        if (this.sourceString != null) {
            Kit.codeBug();
        }
        if (this.sourceEnd == this.sourceBuffer.length) {
            if (this.lineStart != 0 && !isMarkingComment()) {
                char[] cArr = this.sourceBuffer;
                int i = this.lineStart;
                System.arraycopy(cArr, i, cArr, 0, this.sourceEnd - i);
                int i2 = this.sourceEnd;
                int i3 = this.lineStart;
                this.sourceEnd = i2 - i3;
                this.sourceCursor -= i3;
                this.lineStart = 0;
            } else {
                char[] cArr2 = this.sourceBuffer;
                char[] cArr3 = new char[cArr2.length * 2];
                System.arraycopy(cArr2, 0, cArr3, 0, this.sourceEnd);
                this.sourceBuffer = cArr3;
            }
        }
        Reader reader = this.sourceReader;
        char[] cArr4 = this.sourceBuffer;
        int i4 = this.sourceEnd;
        int i5 = reader.read(cArr4, i4, cArr4.length - i4);
        if (i5 < 0) {
            return false;
        }
        this.sourceEnd += i5;
        return true;
    }

    public int getCursor() {
        return this.cursor;
    }

    public int getTokenBeg() {
        return this.tokenBeg;
    }

    public int getTokenEnd() {
        return this.tokenEnd;
    }

    public int getTokenLength() {
        return this.tokenEnd - this.tokenBeg;
    }

    public Token.CommentType getCommentType() {
        return this.commentType;
    }

    private void markCommentStart() {
        markCommentStart("");
    }

    private void markCommentStart(String str) {
        if (!this.parser.compilerEnv.isRecordingComments() || this.sourceReader == null) {
            return;
        }
        this.commentPrefix = str;
        this.commentCursor = this.sourceCursor - 1;
    }

    private boolean isMarkingComment() {
        return this.commentCursor != -1;
    }

    final String getAndResetCurrentComment() {
        if (this.sourceString != null) {
            if (isMarkingComment()) {
                Kit.codeBug();
            }
            return this.sourceString.substring(this.tokenBeg, this.tokenEnd);
        }
        if (!isMarkingComment()) {
            Kit.codeBug();
        }
        StringBuilder sb = new StringBuilder(this.commentPrefix);
        sb.append(this.sourceBuffer, this.commentCursor, getTokenLength() - this.commentPrefix.length());
        this.commentCursor = -1;
        return sb.toString();
    }

    private String convertLastCharToHex(String str) {
        int length = str.length() - 1;
        StringBuilder sb = new StringBuilder(str.substring(0, length));
        sb.append("\\u");
        String hexString = Integer.toHexString(str.charAt(length));
        for (int i = 0; i < 4 - hexString.length(); i++) {
            sb.append('0');
        }
        sb.append(hexString);
        return sb.toString();
    }
}
