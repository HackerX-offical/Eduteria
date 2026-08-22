package com.appnew.android.testmodulessc.utils;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.amazonaws.services.s3.internal.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SSCGsonSafe.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0006\b\u0000\u0010\t\u0018\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0086\b¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/appnew/android/testmodulessc/utils/SSCGsonSafe;", "", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "fromJson", ExifInterface.GPS_DIRECTION_TRUE, "json", "", "(Ljava/lang/String;)Ljava/lang/Object;", "toJson", "any", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SSCGsonSafe {
    public static final SSCGsonSafe INSTANCE = new SSCGsonSafe();
    private static final Gson gson = new Gson();
    public static final int $stable = 8;

    private SSCGsonSafe() {
    }

    public final Gson getGson() {
        return gson;
    }

    public final /* synthetic */ <T> T fromJson(String json) {
        try {
            String str = json;
            if (str != null && !StringsKt.isBlank(str) && !Intrinsics.areEqual(json, Constants.NULL_VERSION_ID)) {
                Gson gson2 = getGson();
                Intrinsics.needClassReification();
                return (T) gson2.fromJson(json, new TypeToken<T>() { // from class: com.appnew.android.testmodulessc.utils.SSCGsonSafe.fromJson.1
                }.getType());
            }
            return null;
        } catch (Exception e2) {
            Log.e("SSC_SUBMIT", "fromJson", e2);
            return null;
        }
    }

    public final String toJson(Object any) {
        try {
            return gson.toJson(any);
        } catch (Exception e2) {
            Log.e("SSC_SUBMIT", "toJson", e2);
            return null;
        }
    }
}
