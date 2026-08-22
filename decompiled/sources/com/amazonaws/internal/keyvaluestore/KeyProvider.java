package com.amazonaws.internal.keyvaluestore;

import android.content.Context;
import android.content.SharedPreferences;
import java.security.Key;

/* JADX INFO: loaded from: classes4.dex */
interface KeyProvider {
    Key getKey(SharedPreferences sharedPreferences, String str, Context context);
}
