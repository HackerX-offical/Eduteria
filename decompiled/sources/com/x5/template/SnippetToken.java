package com.x5.template;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes9.dex */
public class SnippetToken extends SnippetPart {
    private String[] args;
    protected String token;

    public SnippetToken(String str, String str2) {
        super(str);
        this.token = str2;
    }

    @Override // com.x5.template.SnippetPart
    public void render(Writer writer, Chunk chunk, String str, int i) throws IOException {
        String strTranslate;
        ChunkLocale locale = chunk.getLocale();
        if (locale == null) {
            String[] strArr = this.args;
            if (strArr == null) {
                writer.append((CharSequence) this.token);
                return;
            }
            strTranslate = ChunkLocale.processFormatString(this.token, strArr, chunk);
        } else {
            strTranslate = locale.translate(this.token, this.args, chunk);
        }
        Snippet.getSnippet(strTranslate).render(writer, chunk, i);
    }

    public static SnippetToken parseTokenWithArgs(String str) {
        int iLastIndexOf = str.lastIndexOf(LocaleTag.LOCALE_SIMPLE_CLOSE);
        int i = 3;
        if (iLastIndexOf < 0) {
            return new SnippetToken(str, str.substring(3));
        }
        int i2 = iLastIndexOf + 1;
        int length = str.length();
        if (str.endsWith(LocaleTag.LOCALE_TAG_CLOSE)) {
            length--;
        }
        if (str.startsWith("{%")) {
            i = 4;
            while (Character.isWhitespace(str.charAt(i - 2))) {
                i++;
            }
            if (str.charAt(length - 1) == '%') {
                length--;
            }
            while (Character.isWhitespace(str.charAt(length - 1))) {
                length--;
            }
        }
        if (str.charAt(i2) == ',') {
            i2 = iLastIndexOf + 2;
        }
        String strSubstring = str.substring(i2, length);
        SnippetToken snippetToken = new SnippetToken(str, str.substring(i, iLastIndexOf));
        if (strSubstring != null && strSubstring.trim().length() > 0) {
            snippetToken.args = strSubstring.split(" *, *");
        }
        return snippetToken;
    }
}
