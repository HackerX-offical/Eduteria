package com.clevertap.android.sdk.inapp.customtemplates;

import com.clevertap.android.sdk.inapp.customtemplates.CustomTemplate;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Arrays;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomTemplatesExt.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0004\"\u00020\u0002¢\u0006\u0002\u0010\u0005\u001a\u001f\u0010\u0006\u001a\u00020\u00022\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b\u001a'\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¨\u0006\u0010"}, d2 = {"templatesSet", "", "Lcom/clevertap/android/sdk/inapp/customtemplates/CustomTemplate;", "templates", "", "([Lcom/clevertap/android/sdk/inapp/customtemplates/CustomTemplate;)Ljava/util/Set;", SDKConstants.PARAM_UPDATE_TEMPLATE, "buildBlock", "Lkotlin/Function1;", "Lcom/clevertap/android/sdk/inapp/customtemplates/CustomTemplate$TemplateBuilder;", "", "Lkotlin/ExtensionFunctionType;", "function", "isVisual", "", "Lcom/clevertap/android/sdk/inapp/customtemplates/CustomTemplate$FunctionBuilder;", "clevertap-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CustomTemplatesExtKt {
    public static final Set<CustomTemplate> templatesSet(CustomTemplate... templates) {
        Intrinsics.checkNotNullParameter(templates, "templates");
        return SetsKt.setOf(Arrays.copyOf(templates, templates.length));
    }

    public static final CustomTemplate template(Function1<? super CustomTemplate.TemplateBuilder, Unit> buildBlock) {
        Intrinsics.checkNotNullParameter(buildBlock, "buildBlock");
        CustomTemplate.TemplateBuilder templateBuilder = new CustomTemplate.TemplateBuilder();
        buildBlock.invoke(templateBuilder);
        return templateBuilder.build();
    }

    public static final CustomTemplate function(boolean z, Function1<? super CustomTemplate.FunctionBuilder, Unit> buildBlock) {
        Intrinsics.checkNotNullParameter(buildBlock, "buildBlock");
        CustomTemplate.FunctionBuilder functionBuilder = new CustomTemplate.FunctionBuilder(z);
        buildBlock.invoke(functionBuilder);
        return functionBuilder.build();
    }
}
