package com.appnew.android.TypeConverter;

import com.appnew.android.Model.Extra;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes6.dex */
public class SeminarExtraConverter {
    public static Extra fromString(String value) {
        return (Extra) new Gson().fromJson(value, Extra.class);
    }

    public static String fromExtraObject(Extra list) {
        return new Gson().toJson(list);
    }
}
