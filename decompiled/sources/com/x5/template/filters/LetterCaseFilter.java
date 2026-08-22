package com.x5.template.filters;

import com.x5.template.Chunk;
import com.x5.template.ChunkLocale;
import java.util.Locale;

/* JADX INFO: loaded from: classes9.dex */
public class LetterCaseFilter extends BasicFilter implements ChunkFilter {
    int OP_UPPER = 0;
    int OP_LOWER = 1;
    int OP_CAPITALIZE = 2;
    int OP_TITLE = 4;

    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        if (str == null) {
            return null;
        }
        int i = this.OP_UPPER;
        if (filterArgs != null) {
            String filterName = filterArgs.getFilterName();
            if (filterName.equals("lower") || filterName.equals("lc")) {
                i = this.OP_LOWER;
            } else if (filterName.equals("capitalize") || filterName.equals("cap")) {
                i = this.OP_CAPITALIZE;
            } else if (filterName.equals("title")) {
                i = this.OP_TITLE;
            }
        }
        ChunkLocale locale = chunk == null ? null : chunk.getLocale();
        Locale javaLocale = locale != null ? locale.getJavaLocale() : null;
        if (javaLocale == null) {
            if (i == this.OP_UPPER) {
                return str.toUpperCase();
            }
            if (i == this.OP_LOWER) {
                return str.toLowerCase();
            }
            if (i == this.OP_CAPITALIZE) {
                return capitalize(str, null, false);
            }
            if (i == this.OP_TITLE) {
                return capitalize(str, null, true);
            }
        } else {
            if (i == this.OP_UPPER) {
                return str.toUpperCase(javaLocale);
            }
            if (i == this.OP_LOWER) {
                return str.toLowerCase(javaLocale);
            }
            if (i == this.OP_CAPITALIZE) {
                return capitalize(str, javaLocale, false);
            }
            if (i == this.OP_TITLE) {
                return capitalize(str, javaLocale, true);
            }
        }
        return null;
    }

    private String capitalize(String str, Locale locale, boolean z) {
        char c2;
        if (z) {
            str = locale == null ? str.toLowerCase() : str.toLowerCase(locale);
        }
        char[] charArray = str.toCharArray();
        boolean z2 = false;
        for (int i = 0; i < charArray.length; i++) {
            if (!z2 && Character.isLetter(charArray[i])) {
                charArray[i] = locale == null ? Character.toUpperCase(charArray[i]) : Character.toString(charArray[i]).toUpperCase(locale).charAt(0);
                z2 = true;
            } else if (Character.isWhitespace(charArray[i]) || (c2 = charArray[i]) == '.' || c2 == '\'') {
                z2 = false;
            }
        }
        return String.valueOf(charArray);
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "upper";
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String[] getFilterAliases() {
        return new String[]{"uc", "lower", "lc", "capitalize", "cap", "title"};
    }
}
