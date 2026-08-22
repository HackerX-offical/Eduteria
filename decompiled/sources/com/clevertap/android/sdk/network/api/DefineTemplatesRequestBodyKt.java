package com.clevertap.android.sdk.network.api;

import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.inapp.customtemplates.CustomTemplate;
import com.clevertap.android.sdk.inapp.customtemplates.TemplateArgument;
import com.clevertap.android.sdk.utils.JsonUtilsKt;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DefineTemplatesRequestBody.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¨\u0006\u0004"}, d2 = {"toJSON", "Lorg/json/JSONObject;", "", "Lcom/clevertap/android/sdk/inapp/customtemplates/CustomTemplate;", "clevertap-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DefineTemplatesRequestBodyKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject toJSON(final Collection<CustomTemplate> collection) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "templatePayload");
        JsonUtilsKt.putObject(jSONObject, "definitions", new Function1() { // from class: com.clevertap.android.sdk.network.api.DefineTemplatesRequestBodyKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DefineTemplatesRequestBodyKt.toJSON$lambda$6$lambda$5(collection, (JSONObject) obj);
            }
        });
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toJSON$lambda$6$lambda$5(Collection templates, JSONObject putObject) throws JSONException {
        Intrinsics.checkNotNullParameter(templates, "$templates");
        Intrinsics.checkNotNullParameter(putObject, "$this$putObject");
        Iterator it = templates.iterator();
        while (it.hasNext()) {
            final CustomTemplate customTemplate = (CustomTemplate) it.next();
            JsonUtilsKt.putObject(putObject, customTemplate.getName(), new Function1() { // from class: com.clevertap.android.sdk.network.api.DefineTemplatesRequestBodyKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DefineTemplatesRequestBodyKt.toJSON$lambda$6$lambda$5$lambda$4(customTemplate, (JSONObject) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toJSON$lambda$6$lambda$5$lambda$4(final CustomTemplate template, JSONObject putObject) throws JSONException {
        Intrinsics.checkNotNullParameter(template, "$template");
        Intrinsics.checkNotNullParameter(putObject, "$this$putObject");
        putObject.put("type", template.getType().getStringName());
        JsonUtilsKt.putObject(putObject, "vars", new Function1() { // from class: com.clevertap.android.sdk.network.api.DefineTemplatesRequestBodyKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DefineTemplatesRequestBodyKt.toJSON$lambda$6$lambda$5$lambda$4$lambda$3(template, (JSONObject) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toJSON$lambda$6$lambda$5$lambda$4$lambda$3(CustomTemplate template, JSONObject putObject) throws JSONException {
        Intrinsics.checkNotNullParameter(template, "$template");
        Intrinsics.checkNotNullParameter(putObject, "$this$putObject");
        final int i = 0;
        for (Object obj : template.getArgs$clevertap_core_release()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final TemplateArgument templateArgument = (TemplateArgument) obj;
            JsonUtilsKt.putObject(putObject, templateArgument.getName(), new Function1() { // from class: com.clevertap.android.sdk.network.api.DefineTemplatesRequestBodyKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return DefineTemplatesRequestBodyKt.toJSON$lambda$6$lambda$5$lambda$4$lambda$3$lambda$2$lambda$1(templateArgument, i, (JSONObject) obj2);
                }
            });
            i = i2;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toJSON$lambda$6$lambda$5$lambda$4$lambda$3$lambda$2$lambda$1(TemplateArgument arg, int i, JSONObject putObject) throws JSONException {
        Intrinsics.checkNotNullParameter(arg, "$arg");
        Intrinsics.checkNotNullParameter(putObject, "$this$putObject");
        Object defaultValue = arg.getDefaultValue();
        if (defaultValue != null) {
            putObject.put("defaultValue", defaultValue);
        }
        putObject.put("type", arg.getType().getStringName());
        putObject.put(Const.ORDER, i);
        return Unit.INSTANCE;
    }
}
