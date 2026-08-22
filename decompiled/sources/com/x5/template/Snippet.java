package com.x5.template;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes9.dex */
public class Snippet {
    private static final int BLOCKSTART_ALONE = 0;
    private static final int BLOCKSTART_MIDLINE = 2;
    private static final int BLOCKSTART_TRIMMED_ALONE = -1;
    private static final int BLOCKSTART_WITHBODY = 1;
    private static final long CAN_GC_AFTER = 60000;
    public static final String MAGIC_CHARS = "~$%^./!*=+_";
    private static final int gcInterval = 500;
    private String origin;
    private List<SnippetPart> parts;
    private String simpleText;
    private static boolean useCache = isCacheEnabled();
    private static HashMap<String, Snippet> snippetCache = new HashMap<>();
    private static HashMap<String, Long> cacheAge = new HashMap<>();
    private static long lastGC = 0;
    private static long gcCounter = 0;
    private static final Pattern UNIVERSAL_LF = Pattern.compile("\n|\r\n|\r\r");

    private Snippet(String str) {
        this.parts = null;
        this.simpleText = null;
        this.origin = null;
        parseParts(str);
    }

    private Snippet(String str, String str2) {
        this.parts = null;
        this.simpleText = null;
        this.origin = str2;
        parseParts(str);
    }

    public static Snippet getSnippet(String str) {
        if (useCache) {
            return getSnippetFromCache(str);
        }
        return new Snippet(str);
    }

    public static Snippet getSnippet(String str, String str2) {
        if (useCache) {
            return getSnippetFromCache(str);
        }
        return new Snippet(str, str2);
    }

    private static Snippet getSnippetFromCache(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = gcCounter + 1;
        gcCounter = j;
        if (j % 500 == 0) {
            pruneCache(jCurrentTimeMillis);
        }
        Snippet snippet = snippetCache.get(str);
        if (snippet != null) {
            cacheAge.put(str, Long.valueOf(jCurrentTimeMillis));
            return snippet;
        }
        Snippet snippet2 = new Snippet(str);
        snippetCache.put(str, snippet2);
        cacheAge.put(str, Long.valueOf(jCurrentTimeMillis));
        return snippet2;
    }

    private static boolean isCacheEnabled() {
        return System.getProperty("chunk.snippetcache") != null;
    }

    private static void pruneCache(long j) {
        long j2 = j - 60000;
        if (lastGC > j2) {
            return;
        }
        Iterator<String> it = snippetCache.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (cacheAge.get(next).longValue() < j2) {
                it.remove();
                cacheAge.remove(next);
            }
        }
        lastGC = j;
    }

    public Snippet(List<SnippetPart> list) {
        this.parts = null;
        this.simpleText = null;
        this.origin = null;
        if (list == null || list.size() == 0) {
            this.simpleText = "";
        } else {
            this.parts = list;
        }
    }

    public Snippet(List<SnippetPart> list, int i, int i2) {
        this.parts = null;
        this.simpleText = null;
        this.origin = null;
        if (list == null || list.size() == 0) {
            this.simpleText = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        while (i < i2) {
            arrayList.add(list.get(i));
            i++;
        }
        this.parts = arrayList;
    }

    public void setOrigin(String str) {
        this.origin = str;
    }

    public String getOrigin() {
        return this.origin;
    }

    public List<SnippetPart> getParts() {
        return this.parts;
    }

    private void parseParts(String str) {
        boolean z;
        boolean z2;
        int i;
        char c2;
        int i2;
        String str2;
        int i3;
        int i4;
        int i5;
        char c3;
        int i6;
        int i7;
        Snippet snippet = this;
        String str3 = str;
        if (str3 == null) {
            return;
        }
        snippet.simpleText = null;
        int i8 = 0;
        int i9 = 0;
        int i10 = -1;
        char cCharAt = 0;
        boolean z3 = false;
        boolean z4 = false;
        int i11 = 0;
        int i12 = 0;
        boolean z5 = false;
        int i13 = -1;
        boolean z6 = false;
        for (int length = str3.length(); i9 < length; length = i4) {
            char cCharAt2 = str3.charAt(i9);
            if (i10 < 0) {
                int i14 = i9 + 1;
                if (i14 >= length) {
                    break;
                }
                z = z3;
                char cCharAt3 = str3.charAt(i14);
                if (cCharAt2 == '{') {
                    z2 = z4;
                    if (MAGIC_CHARS.indexOf(cCharAt3) > -1 && (cCharAt3 != '$' || !isJavascriptHeadFake(i9, str3))) {
                        if (cCharAt3 == '%') {
                            int i15 = i9 + 2;
                            if (i15 == length) {
                                break;
                            }
                            cCharAt = str3.charAt(i15);
                            i13 = i15;
                            while (i13 < length && Character.isWhitespace(cCharAt)) {
                                i13++;
                                cCharAt = str3.charAt(i13);
                            }
                            if (MAGIC_CHARS.indexOf(cCharAt) > -1) {
                                str2 = str3;
                                i3 = i9;
                                i9 = i13;
                                i13++;
                                i4 = length;
                            } else {
                                cCharAt = '.';
                                str2 = str3;
                                i3 = i9;
                                i4 = length;
                                i9 = i13;
                            }
                            z3 = z;
                            z4 = z2;
                            i11 = 0;
                        } else {
                            i13 = i9 + 2;
                            str2 = str3;
                            i3 = i9;
                            i4 = length;
                            cCharAt = cCharAt3;
                            z3 = z;
                            i9 = i14;
                            z4 = z2;
                            i11 = 0;
                        }
                    }
                } else {
                    z2 = z4;
                    if (cCharAt2 == '_' && cCharAt3 == '[') {
                        str2 = str3;
                        i3 = i9;
                        i4 = length;
                        i9 = i14;
                        z4 = z2;
                        z3 = true;
                    }
                }
                int i16 = i9;
                i = i8;
                c2 = cCharAt;
                i2 = i16;
                int i17 = i10;
                str2 = str3;
                i3 = i17;
                i4 = length;
                i5 = i13;
                int i18 = i2;
                cCharAt = c2;
                i8 = i;
                i9 = i18;
                i13 = i5;
                z3 = z;
                z4 = z2;
            } else {
                z = z3;
                z2 = z4;
                if (z && cCharAt2 == ']') {
                    if (i11 % 2 == 0) {
                        snippet.parts = snippet.getPartsForAppend();
                        if (i8 < i10) {
                            SnippetPart snippetPart = new SnippetPart(str3.substring(i8, i10));
                            snippetPart.setLiteral(true);
                            snippet.parts.add(snippetPart);
                        }
                        i8 = i9 + 1;
                        snippet.parts.add(new SnippetToken(str3.substring(i10, i8), str3.substring(i10 + 2, i9)));
                        str2 = str3;
                        i4 = length;
                        i3 = -1;
                        z4 = z2;
                        z3 = false;
                    }
                    int i162 = i9;
                    i = i8;
                    c2 = cCharAt;
                    i2 = i162;
                    int i172 = i10;
                    str2 = str3;
                    i3 = i172;
                    i4 = length;
                    i5 = i13;
                    int i182 = i2;
                    cCharAt = c2;
                    i8 = i;
                    i9 = i182;
                    i13 = i5;
                } else if (cCharAt2 == '}') {
                    if (!z2 && i11 % 2 == 0) {
                        if (z5) {
                            if (snippet.isLiteralClose(str3, cCharAt, i10, i9)) {
                                int i19 = i9 + 1;
                                SnippetPart snippetPart2 = new SnippetPart(str3.substring(i8, i19));
                                snippetPart2.setLiteral(true);
                                snippet.parts.add(snippetPart2);
                                i8 = i19;
                                z5 = false;
                            }
                            str2 = str3;
                            i4 = length;
                            i3 = -1;
                        } else if (cCharAt == '!') {
                            char cCharAt4 = str3.charAt(i9 - 1);
                            char cCharAt5 = str3.charAt(i9 - 2);
                            if (cCharAt4 == '-' && cCharAt5 == '-') {
                                int iExtractComment = snippet.extractComment(i8, i10, i9, str3, length);
                                i4 = length;
                                i8 = iExtractComment + 1;
                                i6 = iExtractComment;
                                i7 = -1;
                                z6 = false;
                            } else {
                                i4 = length;
                                i6 = i9;
                                z6 = true;
                                i7 = i10;
                            }
                            str2 = str;
                            i3 = i7;
                            z3 = z;
                            z4 = z2;
                            i9 = i6;
                            snippet = this;
                        } else {
                            int i20 = i9;
                            int i21 = i8;
                            char c4 = cCharAt;
                            i4 = length;
                            int i22 = i13;
                            SnippetPart snippetPartExtractTag = snippet.extractTag(c4, str3, i21, i10, i22, i20);
                            int i23 = i10;
                            str2 = str3;
                            int i24 = i23;
                            if (snippetPartExtractTag != null) {
                                snippet.parts.add(snippetPartExtractTag);
                                i24 = i20 + 1;
                            } else {
                                z5 = true;
                            }
                            i13 = i22;
                            i9 = i20;
                            z3 = z;
                            cCharAt = c4;
                            i8 = i24;
                            i3 = -1;
                        }
                    }
                    int i1622 = i9;
                    i = i8;
                    c2 = cCharAt;
                    i2 = i1622;
                    int i1722 = i10;
                    str2 = str3;
                    i3 = i1722;
                    i4 = length;
                    i5 = i13;
                    int i1822 = i2;
                    cCharAt = c2;
                    i8 = i;
                    i9 = i1822;
                    i13 = i5;
                } else {
                    int i25 = i9;
                    i = i8;
                    c2 = cCharAt;
                    i2 = i25;
                    int i26 = i10;
                    str2 = str3;
                    i3 = i26;
                    i4 = length;
                    i5 = i13;
                    if (cCharAt2 != '/' || i11 % 2 != 0) {
                        if (cCharAt2 == '\\') {
                            i11++;
                        } else if (i11 > 0) {
                            cCharAt = c2;
                            i8 = i;
                            i9 = i2;
                            i13 = i5;
                            z3 = z;
                            z4 = z2;
                            i11 = 0;
                        }
                        int i18222 = i2;
                        cCharAt = c2;
                        i8 = i;
                        i9 = i18222;
                        i13 = i5;
                    } else if (i12 > 0) {
                        i12--;
                        cCharAt = c2;
                        i8 = i;
                        i9 = i2;
                        i13 = i5;
                        z3 = z;
                        z4 = i12 < 1 ? false : z2;
                    } else {
                        char cCharAt6 = str2.charAt(i2 - 1);
                        char cCharAt7 = str2.charAt(i2 - 2);
                        if (cCharAt6 == 's' && cCharAt7 == '|') {
                            i12 = 2;
                            z4 = true;
                        } else {
                            if (cCharAt6 == 'm') {
                                if (cCharAt7 != ',') {
                                    c3 = '(';
                                    if (cCharAt7 == '(') {
                                    }
                                }
                                z4 = true;
                                i12 = 1;
                            } else {
                                c3 = '(';
                            }
                            if (cCharAt6 == ',' || (cCharAt6 == c3 && cCharAt7 == 'h')) {
                                z4 = true;
                                i12 = 1;
                            } else {
                                z4 = z2;
                            }
                        }
                        cCharAt = c2;
                        i8 = i;
                        i9 = i2;
                        i13 = i5;
                        z3 = z;
                    }
                }
                z3 = z;
                z4 = z2;
            }
            i9++;
            String str4 = str2;
            i10 = i3;
            str3 = str4;
        }
        int i27 = i8;
        String str5 = str3;
        if (snippet.parts == null) {
            snippet.simpleText = str5;
            return;
        }
        if (z6) {
            snippet.parts.add(new SnippetComment(str5.substring(i27)));
        } else if (i27 < str5.length()) {
            SnippetPart snippetPart3 = new SnippetPart(str5.substring(i27));
            snippetPart3.setLiteral(true);
            snippet.parts.add(snippetPart3);
        }
        snippet.groupBlocks(snippet.parts);
    }

    private static boolean isJavascriptHeadFake(int i, String str) {
        char cCharAt;
        int length = str.length();
        int i2 = i + 2;
        if (i2 >= length || (cCharAt = str.charAt(i2)) == '.' || cCharAt == '(' || cCharAt == ' ' || cCharAt == '$') {
            return true;
        }
        int i3 = i + 3;
        return i3 < length && str.charAt(i3) == '(';
    }

    public boolean isSimple() {
        return this.simpleText != null;
    }

    private boolean isLiteralClose(String str, char c2, int i, int i2) {
        if (c2 == '.' && i2 - i > 8) {
            if (str.charAt(i + 1) != '%') {
                return false;
            }
            int i3 = i2 - 1;
            if (str.charAt(i3) == '%') {
                i3 = i2 - 2;
            }
            String strTrim = str.substring(i + 2, i3).trim();
            return strTrim.equals("endliteral") || strTrim.equals("/literal");
        }
        if (c2 == '^') {
            return i == i2 + (-2);
        }
        if (c2 != '~') {
            return i == i2 + (-9) && c2 == '/' && str.substring(i + 1, i2).equals("/literal");
        }
        if (i == i2 - 3 && str.charAt(i2 - 1) == '.') {
            return true;
        }
        return i == i2 + (-11) && str.substring(i + 3, i2).equals("/literal");
    }

    private SnippetPart extractTag(char c2, String str, int i, int i2, int i3, int i4) {
        this.parts = getPartsForAppend();
        if (i < i2) {
            SnippetPart snippetPart = new SnippetPart(str.substring(i, i2));
            snippetPart.setLiteral(true);
            this.parts.add(snippetPart);
        }
        String strSubstring = str.substring(i2, i4 + 1);
        if (strSubstring.charAt(1) == '%') {
            if (strSubstring.charAt(strSubstring.length() - 2) == '%') {
                i4--;
            }
            while (i4 > i2 && Character.isWhitespace(strSubstring.charAt((i4 - i2) - 1))) {
                i4--;
            }
        }
        if (c2 == '~' || c2 == '$') {
            String strSubstring2 = str.substring(i3, i4);
            if (strSubstring2.startsWith(".end")) {
                strSubstring2 = "./" + strSubstring2.substring(4);
            }
            return new SnippetTag(strSubstring, strSubstring2);
        }
        if (c2 == '^' || c2 == '.') {
            String strSubstring3 = str.substring(i3, i4);
            if (strSubstring3.equals("literal") || strSubstring3.equals("^")) {
                return null;
            }
            if (strSubstring3.startsWith("end")) {
                strSubstring3 = MqttTopic.TOPIC_LEVEL_SEPARATOR + strSubstring3.substring(3);
            }
            return new SnippetTag(strSubstring, InstructionFileId.DOT + strSubstring3);
        }
        if (c2 == '/') {
            return new SnippetTag(strSubstring, "./" + str.substring(i3, i4));
        }
        if (c2 == '*') {
            if (strSubstring.length() == 3) {
                return new SnippetTag(strSubstring, "./exec");
            }
            if (str.charAt(i4 - 1) == '*') {
                i4--;
            }
            return new SnippetTag(strSubstring, ".exec " + str.substring(i3, i4).trim() + " original");
        }
        if (c2 == '=') {
            if (strSubstring.length() == 3) {
                return new SnippetTag(strSubstring, "=");
            }
        } else {
            if (c2 == '_') {
                return SnippetToken.parseTokenWithArgs(strSubstring);
            }
            if (c2 == '+') {
                if (strSubstring.startsWith("{+(") || strSubstring.indexOf("+(") == i3 - i2) {
                    return new SnippetTag(strSubstring, ".includeIf(" + str.substring(i3 + 1, i4));
                }
                return new SnippetTag(strSubstring, ".include " + str.substring(i3, i4));
            }
            if (c2 == '%') {
                SnippetPart snippetPart2 = new SnippetPart(strSubstring);
                snippetPart2.setLiteral(true);
                return snippetPart2;
            }
        }
        return new SnippetPart(strSubstring);
    }

    private List<SnippetPart> getPartsForAppend() {
        if (this.parts == null) {
            this.parts = new ArrayList();
        }
        return this.parts;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int extractComment(int r6, int r7, int r8, java.lang.String r9, int r10) {
        /*
            r5 = this;
            java.util.List r0 = r5.getPartsForAppend()
            r5.parts = r0
            r0 = 10
            r1 = 1
            if (r6 >= r7) goto L19
            java.lang.String r2 = r9.substring(r6, r7)
            int r3 = r2.lastIndexOf(r0)
            r4 = -1
            if (r3 <= r4) goto L1a
            int r3 = r3 + r6
            int r3 = r3 + r1
            goto L1b
        L19:
            r2 = 0
        L1a:
            r3 = r6
        L1b:
            if (r3 == r7) goto L2b
            java.lang.String r4 = r9.substring(r3, r7)
            java.lang.String r4 = r4.trim()
            int r4 = r4.length()
            if (r4 != 0) goto L4e
        L2b:
            int r4 = r8 + 1
            int r0 = r9.indexOf(r0, r4)
            if (r0 >= 0) goto L34
            r0 = r10
        L34:
            java.lang.String r4 = r9.substring(r4, r0)
            java.lang.String r4 = r4.trim()
            int r4 = r4.length()
            if (r4 != 0) goto L4e
            if (r3 >= r7) goto L49
            java.lang.String r2 = r9.substring(r6, r3)
            r7 = r3
        L49:
            if (r0 != r10) goto L4d
            int r0 = r0 + (-1)
        L4d:
            r8 = r0
        L4e:
            if (r2 == 0) goto L5d
            com.x5.template.SnippetPart r6 = new com.x5.template.SnippetPart
            r6.<init>(r2)
            r6.setLiteral(r1)
            java.util.List<com.x5.template.SnippetPart> r10 = r5.parts
            r10.add(r6)
        L5d:
            int r6 = r8 + 1
            java.lang.String r6 = r9.substring(r7, r6)
            java.lang.String r7 = r5.origin
            if (r7 != 0) goto L8c
            java.util.List<com.x5.template.SnippetPart> r7 = r5.parts
            int r7 = r7.size()
            if (r7 != 0) goto L8c
            java.lang.String r7 = "{!--@ORIGIN:"
            boolean r7 = r6.startsWith(r7)
            if (r7 == 0) goto L8c
            java.lang.String r7 = "@"
            r9 = 12
            int r7 = r6.indexOf(r7, r9)
            if (r7 >= 0) goto L85
            int r7 = r6.length()
        L85:
            java.lang.String r6 = r6.substring(r9, r7)
            r5.origin = r6
            return r8
        L8c:
            com.x5.template.SnippetComment r7 = new com.x5.template.SnippetComment
            r7.<init>(r6)
            java.util.List<com.x5.template.SnippetPart> r6 = r5.parts
            r6.add(r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.x5.template.Snippet.extractComment(int, int, int, java.lang.String, int):int");
    }

    private void groupBlocks(List<SnippetPart> list) {
        SnippetTag snippetTag;
        BlockTag blockTagType;
        int i = 0;
        while (i < list.size()) {
            SnippetPart snippetPart = list.get(i);
            if (snippetPart.isTag() && (blockTagType = (snippetTag = (SnippetTag) snippetPart).getBlockTagType()) != null) {
                int i2 = i + 1;
                int iFindMatchingBlockEnd = BlockTag.findMatchingBlockEnd(blockTagType, list, i2);
                if (iFindMatchingBlockEnd > i) {
                    SnippetTag snippetTag2 = (SnippetTag) list.remove(iFindMatchingBlockEnd);
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = i2; i3 < iFindMatchingBlockEnd; i3++) {
                        arrayList.add(list.get(i3));
                    }
                    for (int i4 = iFindMatchingBlockEnd - 1; i4 >= i; i4--) {
                        list.remove(i4);
                    }
                    groupBlocks(arrayList);
                    SnippetBlockTag snippetBlockTag = new SnippetBlockTag(snippetTag, arrayList, snippetTag2, this.origin);
                    list.add(i, snippetBlockTag);
                    if (snippetBlockTag.doSmartTrimAroundBlock() && smartTrimBeforeBlockStart(list, snippetBlockTag, i - 1) != 2) {
                        smartTrimAfterBlockEnd(list, snippetBlockTag, i2);
                    }
                } else {
                    list.add(i2, new SnippetError("[ERROR in template! " + blockTagType.getBlockStartMarker() + " block with no matching end marker! ]"));
                    i = i2;
                }
            }
            i++;
        }
    }

    private int smartTrimBeforeBlockStart(List<SnippetPart> list, SnippetBlockTag snippetBlockTag, int i) {
        int iSmartTrimBeforeBlockStart;
        boolean z = true;
        if (blockBodyStartsOnSameLine(snippetBlockTag)) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        SnippetPart snippetPart = list.get(i);
        while (true) {
            SnippetPart closeTag = snippetPart;
            if (!(closeTag instanceof SnippetComment)) {
                if (!closeTag.isLiteral()) {
                    if (!(closeTag instanceof SnippetBlockTag)) {
                        return 2;
                    }
                    closeTag = ((SnippetBlockTag) closeTag).getCloseTag();
                }
                String text = closeTag.getText();
                if (text.length() == 0) {
                    return smartTrimBeforeBlockStart(list, snippetBlockTag, i - 1);
                }
                int length = text.length() - 1;
                char cCharAt = text.charAt(length);
                while (true) {
                    if (!Character.isWhitespace(cCharAt)) {
                        z = false;
                        break;
                    }
                    if (cCharAt == '\n' || cCharAt == '\r') {
                        break;
                    }
                    length--;
                    if (length >= 0) {
                        cCharAt = text.charAt(length);
                    } else {
                        if (i != 0 && (iSmartTrimBeforeBlockStart = smartTrimBeforeBlockStart(list, snippetBlockTag, i - 1)) > 0) {
                            return iSmartTrimBeforeBlockStart;
                        }
                        length = 0;
                    }
                }
                length++;
                if (z) {
                    closeTag.setText(text.substring(0, length));
                }
                return z ? -1 : 2;
            }
            i--;
            if (i < 0) {
                return 0;
            }
            snippetPart = list.get(i);
        }
    }

    private boolean blockBodyStartsOnSameLine(SnippetBlockTag snippetBlockTag) {
        Snippet body = snippetBlockTag.getBody();
        if (body.parts != null) {
            int i = 0;
            while (true) {
                if (i >= body.parts.size()) {
                    break;
                }
                SnippetPart snippetPart = body.parts.get(i);
                if (snippetPart instanceof SnippetComment) {
                    String string = snippetPart.toString();
                    if (string.charAt(string.length() - 1) != '}') {
                        return false;
                    }
                    i++;
                } else if (snippetPart.isLiteral()) {
                    String text = snippetPart.getText();
                    Matcher matcher = UNIVERSAL_LF.matcher(text);
                    if (!matcher.find() || text.substring(0, matcher.start()).trim().length() == 0) {
                        break;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void smartTrimAfterBlockEnd(List<SnippetPart> list, SnippetBlockTag snippetBlockTag, int i) {
        if (list.size() <= i) {
            return;
        }
        SnippetPart snippetPart = list.get(i);
        while (true) {
            SnippetPart snippetPart2 = snippetPart;
            if (snippetPart2 instanceof SnippetComment) {
                if (snippetPart2.toString().charAt(r0.length() - 1) != '}' || list.size() <= (i = i + 1)) {
                    return;
                } else {
                    snippetPart = list.get(i);
                }
            } else {
                if (snippetPart2.isLiteral()) {
                    String text = snippetPart2.getText();
                    Matcher matcher = UNIVERSAL_LF.matcher(text);
                    if (matcher.find() && text.substring(0, matcher.start()).trim().length() == 0) {
                        snippetPart2.setText(text.substring(matcher.end()));
                        StringBuilder sb = new StringBuilder();
                        SnippetTag closeTag = snippetBlockTag.getCloseTag();
                        closeTag.snippetText = sb.append(closeTag.snippetText).append(text.substring(0, matcher.end())).toString();
                        return;
                    }
                    return;
                }
                return;
            }
        }
    }

    public String toString() {
        return _toString(true);
    }

    private String _toString(boolean z) {
        String str = this.simpleText;
        if (str != null) {
            return str;
        }
        if (this.parts == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (z && this.origin != null) {
            sb.append("{!--@ORIGIN:");
            sb.append(this.origin);
            sb.append("@--}");
        }
        Iterator<SnippetPart> it = this.parts.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        return sb.toString();
    }

    public String toSimpleString() {
        return _toString(false);
    }

    public void render(Writer writer, Chunk chunk, int i) throws IOException {
        String str = this.simpleText;
        if (str != null) {
            writer.append((CharSequence) str);
            return;
        }
        List<SnippetPart> list = this.parts;
        if (list != null) {
            Iterator<SnippetPart> it = list.iterator();
            while (it.hasNext()) {
                it.next().render(writer, chunk, this.origin, i + 1);
            }
        }
    }

    public Snippet copy() {
        if (this.simpleText != null) {
            Snippet snippet = new Snippet("");
            snippet.simpleText = this.simpleText;
            return snippet;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.parts);
        Snippet snippet2 = new Snippet(arrayList);
        snippet2.origin = this.origin;
        return snippet2;
    }

    public static Snippet makeLiteralSnippet(String str) {
        SnippetPart snippetPart = new SnippetPart(str);
        snippetPart.setLiteral(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(snippetPart);
        return new Snippet(arrayList);
    }

    boolean isSimplePointer() {
        List<SnippetPart> list = this.parts;
        return list != null && list.size() == 1 && (this.parts.get(0) instanceof SnippetTag);
    }

    String getPointer() {
        if (isSimplePointer()) {
            return ((SnippetTag) this.parts.get(0)).getTag();
        }
        return null;
    }

    SnippetTag getPointerTag() {
        if (isSimplePointer()) {
            return (SnippetTag) this.parts.get(0);
        }
        return null;
    }

    static Snippet consolidateSnippets(Vector<Snippet> vector) throws EndOfSnippetException {
        String str;
        if (vector == null) {
            return null;
        }
        if (vector.size() == 1) {
            return vector.get(0);
        }
        for (int i = 1; i < vector.size(); i++) {
            Snippet snippet = vector.get(i - 1);
            Snippet snippet2 = vector.get(i);
            String str2 = snippet.origin;
            if (!(str2 == null && snippet2.origin == null) && (str2 == null || (str = snippet2.origin) == null || !str2.equals(str))) {
                throw new EndOfSnippetException("Can't merge snippets, incompatible origins.");
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < vector.size(); i2++) {
            List<SnippetPart> listUngroupBlocks = vector.get(i2).ungroupBlocks();
            if (listUngroupBlocks != null) {
                arrayList.addAll(listUngroupBlocks);
            }
        }
        Snippet snippet3 = new Snippet(arrayList);
        snippet3.origin = vector.get(0).origin;
        snippet3.groupBlocks(snippet3.parts);
        return snippet3;
    }

    private List<SnippetPart> ungroupBlocks() {
        List<SnippetPart> list = this.parts;
        if (list == null) {
            if (this.simpleText.length() < 1) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            SnippetPart snippetPart = new SnippetPart(this.simpleText);
            snippetPart.setLiteral(true);
            arrayList.add(snippetPart);
            return arrayList;
        }
        for (SnippetPart snippetPart2 : list) {
            if ((snippetPart2 instanceof SnippetBlockTag) || (snippetPart2 instanceof SnippetError)) {
                ArrayList arrayList2 = new ArrayList();
                for (SnippetPart snippetPart3 : this.parts) {
                    if (snippetPart3 instanceof SnippetBlockTag) {
                        SnippetBlockTag snippetBlockTag = (SnippetBlockTag) snippetPart3;
                        arrayList2.add(snippetBlockTag.getOpenTag());
                        arrayList2.addAll(snippetBlockTag.getBody().ungroupBlocks());
                        arrayList2.add(snippetBlockTag.getCloseTag());
                    } else if (!(snippetPart3 instanceof SnippetError)) {
                        arrayList2.add(snippetPart3);
                    }
                }
                return arrayList2;
            }
        }
        return this.parts;
    }
}
