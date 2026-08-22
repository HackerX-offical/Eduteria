package com.appnew.android.Utils;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: loaded from: classes6.dex */
public class EmojiFilter {
    public static InputFilter[] getFilter() {
        return new InputFilter[]{new InputFilter() { // from class: com.appnew.android.Utils.EmojiFilter.1
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                while (start < end) {
                    int type = Character.getType(source.charAt(start));
                    if (type == 19 || type == 6 || type == 28) {
                        return "";
                    }
                    start++;
                }
                return null;
            }
        }};
    }

    public static InputFilter[] WhiteSpaceFilter() {
        return new InputFilter[]{new InputFilter() { // from class: com.appnew.android.Utils.EmojiFilter$$ExternalSyntheticLambda0
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return EmojiFilter.lambda$WhiteSpaceFilter$0(charSequence, i, i2, spanned, i3, i4);
            }
        }};
    }

    static /* synthetic */ CharSequence lambda$WhiteSpaceFilter$0(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        while (i < i2) {
            if (Character.isSpaceChar(charSequence.charAt(i))) {
                return "";
            }
            i++;
        }
        return null;
    }
}
