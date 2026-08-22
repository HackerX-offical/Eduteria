package com.x5.template;

import com.clevertap.android.sdk.Constants;
import com.x5.template.filters.FilterArgs;
import com.x5.template.filters.RegexFilter;
import java.io.IOException;
import java.io.Writer;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes9.dex */
public class LocaleTag extends BlockTag {
    public static String LOCALE_SIMPLE_CLOSE = "]";
    public static String LOCALE_TAG_CLOSE = "}";
    private String[] args;
    private String body;
    private Chunk context;
    public static String LOCALE_TAG_OPEN = "{_[";
    public static String LOCALE_SIMPLE_OPEN = "_[";
    private static final Pattern OPEN_TAG_PATTERN = Pattern.compile(RegexFilter.escapeRegex(LOCALE_TAG_OPEN) + "|" + RegexFilter.escapeRegex(LOCALE_SIMPLE_OPEN));

    public LocaleTag(String str, Chunk chunk) {
        this.body = null;
        this.context = chunk;
        parseParams(str);
    }

    public LocaleTag() {
        this.body = null;
    }

    public LocaleTag(String str, Snippet snippet) {
        this.body = null;
        this.body = snippet.toString();
    }

    private void parseParams(String str) {
        int iIndexOf;
        if (str != null && (iIndexOf = str.indexOf(" ")) >= 0) {
            String strTrim = str.substring(iIndexOf + 1).trim();
            if (strTrim.startsWith(Constants.SEPARATOR_COMMA)) {
                strTrim = strTrim.substring(1).trim();
            }
            if (strTrim.length() == 0) {
                return;
            }
            this.args = strTrim.split(" *(?<!\\\\), *");
        }
    }

    private String _translate() {
        ChunkLocale locale = this.context.getLocale();
        if (locale == null) {
            return ChunkLocale.processFormatString(this.body, this.args, this.context);
        }
        return locale.translate(this.body, this.args, this.context);
    }

    @Override // com.x5.template.BlockTag
    public String getBlockStartMarker() {
        return "loc";
    }

    @Override // com.x5.template.BlockTag
    public String getBlockEndMarker() {
        return "/loc";
    }

    private static String convertToChunkTag(String str, Chunk chunk) {
        if (str.startsWith(LOCALE_SIMPLE_OPEN)) {
            int length = str.length();
            if (str.endsWith(LOCALE_SIMPLE_CLOSE)) {
                length--;
            }
            String strSubstring = str.substring(2, length);
            return chunk.makeTag(".loc") + strSubstring + chunk.makeTag("./loc");
        }
        if (!str.startsWith(LOCALE_TAG_OPEN)) {
            return str;
        }
        int iLastIndexOf = str.lastIndexOf(LOCALE_SIMPLE_CLOSE);
        if (iLastIndexOf < 0) {
            return convertToChunkTag(str.substring(1), chunk);
        }
        String strSubstring2 = str.substring(3, iLastIndexOf);
        int i = iLastIndexOf + 1;
        int length2 = str.length();
        if (str.endsWith(LOCALE_TAG_CLOSE)) {
            length2--;
        }
        return chunk.makeTag(".loc " + str.substring(i, length2)) + strSubstring2 + chunk.makeTag("./loc");
    }

    public static String expandLocaleTags(String str, Chunk chunk) {
        int[] iArrScanForMarkers = scanForMarkers(str);
        if (iArrScanForMarkers == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 0;
        while (i < iArrScanForMarkers.length) {
            int i3 = iArrScanForMarkers[i];
            int i4 = iArrScanForMarkers[i + 1];
            int i5 = iArrScanForMarkers[i + 2];
            sb.append(str.substring(i2, i3));
            sb.append(convertToChunkTag(str.substring(i3, i4), chunk));
            i += 3;
            i2 = i5;
        }
        if (i2 < str.length()) {
            sb.append(str.substring(i2));
        }
        return sb.toString();
    }

    private static int[] scanForMarkers(String str) {
        if (str.indexOf(LOCALE_SIMPLE_OPEN) < 0) {
            return null;
        }
        int length = str.length();
        Matcher matcher = OPEN_TAG_PATTERN.matcher(str);
        int iStart = matcher.find() ? matcher.start() : -1;
        String str2 = "";
        while (iStart > -1) {
            boolean zEquals = matcher.group().equals(LOCALE_SIMPLE_OPEN);
            int iNextUnescapedDelim = nextUnescapedDelim(zEquals, str, iStart);
            int length2 = (zEquals ? LOCALE_SIMPLE_CLOSE : LOCALE_TAG_CLOSE).length() + iNextUnescapedDelim;
            str2 = str2 + iStart + Constants.SEPARATOR_COMMA + iNextUnescapedDelim + Constants.SEPARATOR_COMMA + length2 + Constants.SEPARATOR_COMMA;
            if (length2 >= length) {
                break;
            }
            iStart = matcher.find(length2) ? matcher.start() : -1;
        }
        return makeIntArray(str2);
    }

    private static int nextUnescapedDelim(boolean z, String str, int i) {
        if (z) {
            return FilterArgs.nextUnescapedDelim(LOCALE_SIMPLE_CLOSE, str, i + LOCALE_SIMPLE_OPEN.length());
        }
        return FilterArgs.nextUnescapedDelim(LOCALE_TAG_CLOSE, str, i + LOCALE_TAG_OPEN.length());
    }

    private static int[] makeIntArray(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, Constants.SEPARATOR_COMMA);
        int iCountTokens = stringTokenizer.countTokens();
        int[] iArr = new int[iCountTokens];
        for (int i = 0; i < iCountTokens; i++) {
            iArr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        return iArr;
    }

    @Override // com.x5.template.BlockTag
    public void renderBlock(Writer writer, Chunk chunk, String str, int i) throws IOException {
        if (this.body == null) {
            return;
        }
        this.context = chunk;
        writer.append((CharSequence) _translate());
    }
}
