package com.appnew.android.TypeConverter;

import com.appnew.android.table.Subjectfilter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class FilterConverter {
    public static List<Subjectfilter> fromString(String value) {
        return (List) new Gson().fromJson(value, new TypeToken<List<Subjectfilter>>() { // from class: com.appnew.android.TypeConverter.FilterConverter.1
        }.getType());
    }

    public static String fromArrayList(List<Subjectfilter> list) {
        return new Gson().toJson(list);
    }
}
