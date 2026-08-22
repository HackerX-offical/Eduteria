package com.github.jorgecastilloprz.utils;

import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public class LibraryUtils {
    public static boolean isAFutureSimpleFAB(View view) {
        return view.getClass().getCanonicalName().startsWith("com.getbase");
    }
}
