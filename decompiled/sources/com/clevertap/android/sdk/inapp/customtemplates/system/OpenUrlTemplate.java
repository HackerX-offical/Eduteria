package com.clevertap.android.sdk.inapp.customtemplates.system;

import com.clevertap.android.sdk.CTXtensions;
import com.clevertap.android.sdk.inapp.InAppActionHandler;
import com.clevertap.android.sdk.inapp.customtemplates.CustomTemplate;
import com.clevertap.android.sdk.inapp.customtemplates.CustomTemplateContext;
import com.clevertap.android.sdk.inapp.customtemplates.CustomTemplatesExtKt;
import com.clevertap.android.sdk.inapp.customtemplates.FunctionPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OpenUrlTemplate.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/clevertap/android/sdk/inapp/customtemplates/system/OpenUrlTemplate;", "", "<init>", "()V", "NAME", "", "URL_ARG", "createTemplate", "Lcom/clevertap/android/sdk/inapp/customtemplates/CustomTemplate;", "systemActionHandler", "Lcom/clevertap/android/sdk/inapp/InAppActionHandler;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OpenUrlTemplate {
    public static final OpenUrlTemplate INSTANCE = new OpenUrlTemplate();
    private static final String NAME = "ctsystem_openurl";
    private static final String URL_ARG = "Android";

    private OpenUrlTemplate() {
    }

    public final CustomTemplate createTemplate(final InAppActionHandler systemActionHandler) {
        Intrinsics.checkNotNullParameter(systemActionHandler, "systemActionHandler");
        return CustomTemplatesExtKt.function(true, new Function1() { // from class: com.clevertap.android.sdk.inapp.customtemplates.system.OpenUrlTemplate$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OpenUrlTemplate.createTemplate$lambda$1(systemActionHandler, (CustomTemplate.FunctionBuilder) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createTemplate$lambda$1(final InAppActionHandler systemActionHandler, CustomTemplate.FunctionBuilder function) {
        Intrinsics.checkNotNullParameter(systemActionHandler, "$systemActionHandler");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.setSystemDefined$clevertap_core_release(true);
        function.name(NAME);
        function.stringArgument("Android", "");
        function.presenter(new FunctionPresenter() { // from class: com.clevertap.android.sdk.inapp.customtemplates.system.OpenUrlTemplate$$ExternalSyntheticLambda0
            @Override // com.clevertap.android.sdk.inapp.customtemplates.CustomTemplatePresenter
            public final void onPresent(CustomTemplateContext customTemplateContext) {
                OpenUrlTemplate.createTemplate$lambda$1$lambda$0(systemActionHandler, (CustomTemplateContext.FunctionContext) customTemplateContext);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createTemplate$lambda$1$lambda$0(InAppActionHandler systemActionHandler, CustomTemplateContext.FunctionContext templateContext) {
        Intrinsics.checkNotNullParameter(systemActionHandler, "$systemActionHandler");
        Intrinsics.checkNotNullParameter(templateContext, "templateContext");
        String string = templateContext.getString("Android");
        if (CTXtensions.isNotNullAndBlank(string) && InAppActionHandler.openUrl$default(systemActionHandler, string, null, 2, null)) {
            templateContext.setPresented();
        }
        templateContext.setDismissed();
    }
}
