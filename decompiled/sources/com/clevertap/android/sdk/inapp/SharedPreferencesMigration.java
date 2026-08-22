package com.clevertap.android.sdk.inapp;

import android.content.SharedPreferences;
import androidx.exifinterface.media.ExifInterface;
import com.clevertap.android.sdk.StorageHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.amp.packet.AMPExtension;

/* JADX INFO: compiled from: SharedPreferencesMigration.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/clevertap/android/sdk/inapp/SharedPreferencesMigration;", ExifInterface.GPS_DIRECTION_TRUE, "", "oldSharedPreferences", "Landroid/content/SharedPreferences;", "newSharedPreferences", "valueType", "Ljava/lang/Class;", AMPExtension.Condition.ATTRIBUTE_NAME, "Lkotlin/Function1;", "", "<init>", "(Landroid/content/SharedPreferences;Landroid/content/SharedPreferences;Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)V", "migrate", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SharedPreferencesMigration<T> {
    private final Function1<T, Boolean> condition;
    private final SharedPreferences newSharedPreferences;
    private final SharedPreferences oldSharedPreferences;
    private final Class<T> valueType;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(Object obj) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SharedPreferencesMigration(SharedPreferences oldSharedPreferences, SharedPreferences newSharedPreferences, Class<T> valueType, Function1<? super T, Boolean> condition) {
        Intrinsics.checkNotNullParameter(oldSharedPreferences, "oldSharedPreferences");
        Intrinsics.checkNotNullParameter(newSharedPreferences, "newSharedPreferences");
        Intrinsics.checkNotNullParameter(valueType, "valueType");
        Intrinsics.checkNotNullParameter(condition, "condition");
        this.oldSharedPreferences = oldSharedPreferences;
        this.newSharedPreferences = newSharedPreferences;
        this.valueType = valueType;
        this.condition = condition;
    }

    public /* synthetic */ SharedPreferencesMigration(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2, Class cls, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferences, sharedPreferences2, cls, (i & 8) != 0 ? new Function1() { // from class: com.clevertap.android.sdk.inapp.SharedPreferencesMigration$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SharedPreferencesMigration._init_$lambda$0(obj));
            }
        } : function1);
    }

    public final void migrate() {
        Map<String, ?> all = this.oldSharedPreferences.getAll();
        SharedPreferences.Editor editorEdit = this.newSharedPreferences.edit();
        Intrinsics.checkNotNull(all);
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (this.valueType.isInstance(value) && this.condition.invoke((T) value).booleanValue()) {
                Class<T> cls = this.valueType;
                if (Intrinsics.areEqual(cls, Boolean.class)) {
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Boolean");
                    editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
                } else if (Intrinsics.areEqual(cls, Integer.class)) {
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Int");
                    editorEdit.putInt(key, ((Integer) value).intValue());
                } else if (Intrinsics.areEqual(cls, Long.class)) {
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Long");
                    editorEdit.putLong(key, ((Long) value).longValue());
                } else if (Intrinsics.areEqual(cls, Float.class)) {
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Float");
                    editorEdit.putFloat(key, ((Float) value).floatValue());
                } else if (Intrinsics.areEqual(cls, String.class)) {
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
                    editorEdit.putString(key, (String) value);
                } else {
                    if (value instanceof Boolean) {
                        editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
                    } else if (value instanceof Integer) {
                        editorEdit.putInt(key, ((Number) value).intValue());
                    } else if (value instanceof Long) {
                        editorEdit.putLong(key, ((Number) value).longValue());
                    } else if (value instanceof Float) {
                        editorEdit.putFloat(key, ((Number) value).floatValue());
                    } else if (value instanceof String) {
                        editorEdit.putString(key, (String) value);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        Intrinsics.checkNotNull(editorEdit);
        StorageHelper.persist(editorEdit);
        this.oldSharedPreferences.edit().clear().apply();
    }
}
