package com.x5.template;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.x5.template.filters.FilterArgs;
import java.io.IOException;
import java.io.Writer;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes9.dex */
public class SnippetTag extends SnippetPart {
    private static final BlockTag[] BLOCK_TAGS;
    private static final String[] BLOCK_TAG_TOKENS;
    private boolean applyFiltersIfNull;
    private String filters;
    private String ifNull;
    private String[] path;
    protected String tag;

    @Override // com.x5.template.SnippetPart
    public boolean isTag() {
        return true;
    }

    public SnippetTag(String str, String str2) {
        super(str);
        this.applyFiltersIfNull = false;
        this.tag = str2;
    }

    public String getTag() {
        return this.tag;
    }

    @Override // com.x5.template.SnippetPart
    public void render(Writer writer, Chunk chunk, String str, int i) throws IOException {
        if (depthCheckFails(i, writer)) {
            return;
        }
        if (this.path == null) {
            init();
        }
        Object objResolveTagValue = chunk.resolveTagValue(this, i, str);
        if (objResolveTagValue == null) {
            writer.append((CharSequence) this.snippetText);
            return;
        }
        if (objResolveTagValue instanceof Snippet) {
            ((Snippet) objResolveTagValue).render(writer, chunk, i);
        } else if (objResolveTagValue instanceof String) {
            Snippet.getSnippet((String) objResolveTagValue, str).render(writer, chunk, i + 1);
        } else {
            chunk.explodeToPrinter(writer, objResolveTagValue, i + 1);
        }
    }

    private void init() {
        String strSubstring;
        String str;
        String strSubstring2;
        String strSubstring3 = this.tag;
        int iIndexOf = strSubstring3.indexOf(58);
        int iIndexOf2 = this.tag.indexOf(124);
        if (iIndexOf2 > -1) {
            iIndexOf2 = confirmPipe(this.tag, iIndexOf2);
        }
        if (iIndexOf > 0 || iIndexOf2 > 0) {
            int i = iIndexOf > 0 ? iIndexOf : iIndexOf2;
            if (iIndexOf2 > 0 && iIndexOf2 < iIndexOf) {
                i = iIndexOf2;
            }
            strSubstring3 = this.tag.substring(0, i);
            String str2 = Filter.FILTER_LAST;
            if (iIndexOf2 > 0 && iIndexOf > 0) {
                String[] tagTokens = parseTagTokens(this.tag, iIndexOf2, iIndexOf);
                strSubstring = tagTokens[0];
                strSubstring2 = tagTokens[1];
                str = tagTokens[2];
            } else if (iIndexOf > 0) {
                strSubstring2 = this.tag.substring(iIndexOf + 1);
                str = str2;
                strSubstring = null;
            } else {
                strSubstring = this.tag.substring(iIndexOf2 + 1);
                str = str2;
                strSubstring2 = null;
            }
            this.ifNull = strSubstring2;
            this.applyFiltersIfNull = str.equals(Filter.FILTER_LAST);
            this.filters = strSubstring;
        }
        this.path = parsePath(strSubstring3);
    }

    private String[] parsePath(String str) {
        int i = 0;
        if (str.indexOf(46, 1) < 0 || str.charAt(0) == '.') {
            return new String[]{str};
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, InstructionFileId.DOT);
        String[] strArr = new String[stringTokenizer.countTokens()];
        while (stringTokenizer.hasMoreTokens()) {
            strArr[i] = stringTokenizer.nextToken();
            i++;
        }
        return strArr;
    }

    private String[] parseTagTokens(String str, int i, int i2) {
        String strSubstring;
        int iIndexOf;
        String str2 = Filter.FILTER_LAST;
        String strSubstring2 = null;
        if (i2 < 0) {
            strSubstring = str.substring(i + 1);
        } else if (i < i2) {
            int iGrokFinalFilterPipe = Filter.grokFinalFilterPipe(str, i) + 1;
            if (str.indexOf(":", iGrokFinalFilterPipe) < 0 || (iIndexOf = str.indexOf(":", FilterArgs.grokValidColonScanPoint(str, iGrokFinalFilterPipe))) < 0) {
                strSubstring = str.substring(i + 1);
            } else {
                String strSubstring3 = str.substring(i + 1, iIndexOf);
                strSubstring2 = str.substring(iIndexOf + 1);
                str2 = Filter.FILTER_FIRST;
                strSubstring = strSubstring3;
            }
        } else {
            String strSubstring4 = str.substring(i + 1);
            strSubstring2 = str.substring(i2 + 1, i);
            strSubstring = strSubstring4;
        }
        return new String[]{strSubstring, strSubstring2, str2};
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b A[PHI: r0 r1
      0x001b: PHI (r0v1 java.lang.String) = (r0v0 java.lang.String), (r0v10 java.lang.String) binds: [B:3:0x000a, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]
      0x001b: PHI (r1v1 int) = (r1v0 int), (r1v6 int) binds: [B:3:0x000a, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int confirmPipe(java.lang.String r6, int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "includeIf("
            int r1 = r6.indexOf(r0)
            java.lang.String r2 = "`"
            java.lang.String r3 = ")"
            if (r1 >= 0) goto L1b
            java.lang.String r0 = "include.("
            int r1 = r6.indexOf(r0)
            if (r1 >= 0) goto L1b
            int r1 = r6.indexOf(r2)
            r0 = r2
            r4 = r0
            goto L1c
        L1b:
            r4 = r3
        L1c:
            if (r1 >= 0) goto L1f
            goto L5a
        L1f:
            int r0 = r0.length()
            int r1 = r1 + r0
            int r0 = r6.indexOf(r4, r1)
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L31
            if (r7 <= r0) goto L50
            goto L5a
        L31:
            java.lang.String r2 = "/"
            int r1 = r6.indexOf(r2, r1)
            if (r1 < 0) goto L5a
            if (r0 >= 0) goto L3c
            goto L5a
        L3c:
            if (r0 >= r1) goto L3f
            goto L5a
        L3f:
            int r1 = r1 + 1
            int r0 = com.x5.template.filters.RegexFilter.nextRegexDelim(r6, r1)
            int r0 = r0 + 1
            int r0 = r6.indexOf(r3, r0)
            if (r0 < 0) goto L5a
            if (r0 >= r7) goto L50
            goto L5a
        L50:
            java.lang.String r7 = "|"
            int r0 = r0 + 1
            int r6 = r6.indexOf(r7, r0)
            return r6
        L5a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.x5.template.SnippetTag.confirmPipe(java.lang.String, int):int");
    }

    public String[] getPath() {
        if (this.path == null) {
            init();
        }
        return this.path;
    }

    public String getDefaultValue() {
        String str = this.ifNull;
        if (str == null || str.length() == 0) {
            return this.ifNull;
        }
        char cCharAt = this.ifNull.charAt(0);
        if (cCharAt == '~' || cCharAt == '$' || cCharAt == '+' || cCharAt == '^' || cCharAt == '.') {
            if (this.filters == null) {
                return "{" + this.ifNull + '}';
            }
            if (this.applyFiltersIfNull) {
                return "{" + this.ifNull + '|' + this.filters + '}';
            }
            return "{" + this.ifNull + '}';
        }
        if (this.ifNull.charAt(0) == '\\') {
            return this.ifNull.substring(1);
        }
        return this.ifNull;
    }

    public String getFilters() {
        return this.filters;
    }

    public boolean applyFiltersFirst() {
        return !this.applyFiltersIfNull;
    }

    static SnippetTag parseTag(String str) {
        SnippetTag snippetTag = new SnippetTag(str, str);
        snippetTag.init();
        return snippetTag;
    }

    static {
        BlockTag[] blockTagArr = {new LoopTag(), new IfTag(), new LocaleTag(), new MacroTag()};
        BLOCK_TAGS = blockTagArr;
        BLOCK_TAG_TOKENS = extractTagTokens(blockTagArr);
    }

    private static String[] extractTagTokens(BlockTag[] blockTagArr) {
        String[] strArr = new String[blockTagArr.length];
        for (int i = 0; i < blockTagArr.length; i++) {
            strArr[i] = InstructionFileId.DOT + blockTagArr[i].getBlockStartMarker();
        }
        return strArr;
    }

    public BlockTag getBlockTagType() {
        int i = 0;
        while (true) {
            String[] strArr = BLOCK_TAG_TOKENS;
            if (i >= strArr.length) {
                return null;
            }
            if (this.tag.startsWith(strArr[i])) {
                BlockTag[] blockTagArr = BLOCK_TAGS;
                if (blockTagArr[i].hasBody(this.tag)) {
                    return blockTagArr[i];
                }
                return null;
            }
            i++;
        }
    }
}
