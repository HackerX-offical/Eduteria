package com.appnew.android.TypeConverter;

import com.appnew.android.Model.ExtraJson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SourceTypeConverter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0007¨\u0006\n"}, d2 = {"Lcom/appnew/android/TypeConverter/SourceTypeConverter;", "", "<init>", "()V", "fromSource", "", "extraJson", "Lcom/appnew/android/Model/ExtraJson;", "toSource", "source", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SourceTypeConverter {
    public static final int $stable = 0;

    public final String fromSource(ExtraJson extraJson) throws JSONException {
        Intrinsics.checkNotNullParameter(extraJson, "extraJson");
        JSONObject jSONObject = new JSONObject();
        String home_screen = extraJson.getHome_screen();
        if (home_screen == null) {
            home_screen = "0";
        }
        jSONObject.put("home_screen", home_screen);
        String is_new = extraJson.getIs_new();
        if (is_new == null) {
            is_new = "0";
        }
        jSONObject.put("is_new", is_new);
        String sold_out = extraJson.getSold_out();
        jSONObject.put("sold_out", sold_out != null ? sold_out : "0");
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final ExtraJson toSource(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        JSONObject jSONObject = new JSONObject(source);
        ExtraJson extraJson = new ExtraJson(jSONObject.optString("home_screen", "0"), jSONObject.optString("is_new", "0"));
        extraJson.setSold_out(jSONObject.optString("sold_out", "0"));
        return extraJson;
    }
}
