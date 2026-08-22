package com.x5.template;

import com.x5.template.filters.RegexFilter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes9.dex */
public class IfTag extends BlockTag {
    private static final Pattern UNIVERSAL_LF = Pattern.compile("\n|\r\n|\r\r");
    private Snippet body;
    private boolean doTrim = true;
    private Map<String, String> options;
    private String primaryCond;

    @Override // com.x5.template.BlockTag
    public boolean doSmartTrimAroundBlock() {
        return true;
    }

    public IfTag(String str, Snippet snippet) {
        parseParams(str);
        initBody(snippet);
    }

    public IfTag() {
    }

    @Override // com.x5.template.BlockTag
    public String getBlockStartMarker() {
        return "if";
    }

    @Override // com.x5.template.BlockTag
    public String getBlockEndMarker() {
        return "/if";
    }

    private void initBody(Snippet snippet) {
        this.body = snippet;
    }

    private void parseParams(String str) {
        String str2;
        this.primaryCond = parseCond(str);
        Map<String, String> attributes = parseAttributes(str);
        this.options = attributes;
        if (attributes == null || (str2 = attributes.get("trim")) == null) {
            return;
        }
        if (str2.equalsIgnoreCase("false") || str2.equalsIgnoreCase("none")) {
            this.doTrim = false;
        }
    }

    private String parseCond(String str) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf("(");
        int iIndexOf2 = str.indexOf(" cond=\"");
        if (iIndexOf > -1) {
            int iLastIndexOf = str.lastIndexOf(")");
            if (iIndexOf2 < 0 && iLastIndexOf > iIndexOf) {
                return str.substring(iIndexOf + 1, iLastIndexOf);
            }
        }
        if (iIndexOf2 <= -1) {
            return null;
        }
        int length = iIndexOf2 + " cond='".length();
        int iIndexOf3 = str.indexOf("\"", length);
        if (iIndexOf3 < 0) {
            return str.substring(length);
        }
        return str.substring(length, iIndexOf3);
    }

    private Map<String, String> parseAttributes(String str) {
        Matcher matcher = Pattern.compile(" ([a-zA-Z0-9_-]+)=(\"([^\"]*)\"|'([^']*)')").matcher(str);
        HashMap map = null;
        while (matcher.find()) {
            matcher.group(0);
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(3);
            if (map == null) {
                map = new HashMap();
            }
            map.put(strGroup, strGroup2);
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0147 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean isTrueExpr(java.lang.String r10, com.x5.template.Chunk r11) {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.x5.template.IfTag.isTrueExpr(java.lang.String, com.x5.template.Chunk):boolean");
    }

    private String unescape(String str) {
        return RegexFilter.parseRegexEscapes(str);
    }

    private boolean isMatch(String str, String str2) {
        boolean z = false;
        if (str == null || str2 == null) {
            return false;
        }
        String strTrim = str2.trim();
        int i = strTrim.charAt(0) == 'm' ? 1 : 0;
        if (strTrim.charAt(i) == '/') {
            i++;
        }
        int iNextRegexDelim = RegexFilter.nextRegexDelim(strTrim, i);
        if (iNextRegexDelim < 0) {
            return false;
        }
        String strSubstring = strTrim.substring(i, iNextRegexDelim);
        boolean z2 = false;
        boolean z3 = false;
        for (int length = strTrim.length() - 1; length > iNextRegexDelim; length--) {
            char cCharAt = strTrim.charAt(length);
            if (cCharAt == 'i') {
                z3 = true;
            }
            if (cCharAt == 'm') {
                z = true;
            }
            if (cCharAt == 's') {
                z2 = true;
            }
        }
        if (z) {
            strSubstring = "(?m)" + strSubstring;
        }
        if (z3) {
            strSubstring = "(?i)" + strSubstring;
        }
        if (z2) {
            strSubstring = "(?s)" + strSubstring;
        }
        return Pattern.compile(strSubstring).matcher(str).find();
    }

    private String trimLeft(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        char cCharAt = str.charAt(0);
        while (true) {
            if ((cCharAt != '\n' && cCharAt != ' ' && cCharAt != '\r' && cCharAt != '\t') || (i = i + 1) == str.length()) {
                break;
            }
            cCharAt = str.charAt(i);
        }
        return i == 0 ? str : str.substring(i);
    }

    private String trimRight(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length() - 1;
        char cCharAt = str.charAt(length);
        while (true) {
            if ((cCharAt != '\n' && cCharAt != ' ' && cCharAt != '\r' && cCharAt != '\t') || length - 1 == -1) {
                break;
            }
            cCharAt = str.charAt(length);
        }
        int i = length + 1;
        return i >= str.length() ? str : str.substring(0, i);
    }

    private boolean isTrimAll() {
        Map<String, String> map = this.options;
        String str = map != null ? map.get("trim") : null;
        if (str != null) {
            return str.equals("all") || str.equals("true");
        }
        return false;
    }

    private String smartTrim(String str) {
        return smartTrim(str, false);
    }

    private String smartTrim(String str, boolean z) {
        if (!z && isTrimAll()) {
            return str.trim();
        }
        Matcher matcher = UNIVERSAL_LF.matcher(str);
        return (matcher.find() && str.substring(0, matcher.start()).trim().length() == 0) ? str.substring(matcher.end()) : str;
    }

    private int nextElseTag(List<SnippetPart> list, int i) {
        while (i < list.size()) {
            SnippetPart snippetPart = list.get(i);
            if ((snippetPart instanceof SnippetTag) && ((SnippetTag) snippetPart).getTag().startsWith(".else")) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // com.x5.template.BlockTag
    public void renderBlock(Writer writer, Chunk chunk, String str, int i) throws IOException {
        List<SnippetPart> parts = this.body.getParts();
        int iNextElseTag = nextElseTag(parts, 0);
        if (isTrueExpr(this.primaryCond, chunk)) {
            if (iNextElseTag < 0) {
                iNextElseTag = parts.size();
            }
            renderChosenParts(writer, chunk, str, i, parts, 0, iNextElseTag);
            return;
        }
        while (iNextElseTag > -1) {
            String tag = ((SnippetTag) parts.get(iNextElseTag)).getTag();
            if (tag.equals(".else")) {
                renderChosenParts(writer, chunk, str, i, parts, iNextElseTag + 1, parts.size());
                return;
            }
            if (isTrueExpr(parseCond(tag), chunk)) {
                int i2 = iNextElseTag + 1;
                int iNextElseTag2 = nextElseTag(parts, i2);
                if (iNextElseTag2 == -1) {
                    iNextElseTag2 = parts.size();
                }
                renderChosenParts(writer, chunk, str, i, parts, i2, iNextElseTag2);
                return;
            }
            iNextElseTag = nextElseTag(parts, iNextElseTag + 1);
        }
    }

    public void renderChosenParts(Writer writer, Chunk chunk, String str, int i, List<SnippetPart> list, int i2, int i3) throws IOException {
        int i4;
        if (!this.doTrim) {
            while (i2 < i3) {
                list.get(i2).render(writer, chunk, str, i);
                i2++;
            }
            return;
        }
        if (i3 <= i2) {
            return;
        }
        if (isTrimAll()) {
            while ((list.get(i2) instanceof SnippetComment) && i2 < i3 - 1) {
                i2++;
            }
            int i5 = i2 + 1;
            if (i5 == i3) {
                SnippetPart snippetPart = list.get(i2);
                if (snippetPart.isLiteral()) {
                    writer.append((CharSequence) snippetPart.getText().trim());
                    return;
                } else {
                    snippetPart.render(writer, chunk, str, i);
                    return;
                }
            }
            SnippetPart snippetPart2 = list.get(i2);
            if (snippetPart2.isLiteral()) {
                writer.append((CharSequence) trimLeft(snippetPart2.getText()));
            }
            while (true) {
                i4 = i3 - 1;
                if (i5 >= i4) {
                    break;
                }
                list.get(i5).render(writer, chunk, str, i);
                i5++;
            }
            SnippetPart snippetPart3 = list.get(i4);
            if (snippetPart3.isLiteral()) {
                writer.append((CharSequence) trimRight(snippetPart3.getText()));
                return;
            }
            return;
        }
        SnippetPart snippetPart4 = list.get(i2);
        if (snippetPart4.isLiteral()) {
            writer.append((CharSequence) smartTrim(snippetPart4.getText()));
        } else {
            snippetPart4.render(writer, chunk, str, i);
        }
        while (true) {
            i2++;
            if (i2 >= i3) {
                return;
            } else {
                list.get(i2).render(writer, chunk, str, i);
            }
        }
    }
}
