package com.appnew.android.TypeConverter;

import com.appnew.android.Model.ExtendValidity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class Converters {
    public static List<ExtendValidity> fromString(String value) {
        return (List) new Gson().fromJson(value, new TypeToken<List<ExtendValidity>>() { // from class: com.appnew.android.TypeConverter.Converters.1
        }.getType());
    }

    public static String fromArrayList(List<ExtendValidity> list) {
        return new Gson().toJson(list);
    }
}
