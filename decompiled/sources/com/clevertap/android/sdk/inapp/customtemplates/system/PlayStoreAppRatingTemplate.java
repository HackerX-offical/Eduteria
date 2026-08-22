package com.clevertap.android.sdk.inapp.customtemplates.system;

import com.clevertap.android.sdk.inapp.InAppActionHandler;
import com.clevertap.android.sdk.inapp.customtemplates.CustomTemplate;
import com.clevertap.android.sdk.inapp.customtemplates.CustomTemplateContext;
import com.clevertap.android.sdk.inapp.customtemplates.CustomTemplatesExtKt;
import com.clevertap.android.sdk.inapp.customtemplates.FunctionPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayStoreAppRatingTemplate.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/clevertap/android/sdk/inapp/customtemplates/system/PlayStoreAppRatingTemplate;", "", "<init>", "()V", "NAME", "", "createTemplate", "Lcom/clevertap/android/sdk/inapp/customtemplates/CustomTemplate;", "systemActionHandler", "Lcom/clevertap/android/sdk/inapp/InAppActionHandler;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlayStoreAppRatingTemplate {
    public static final PlayStoreAppRatingTemplate INSTANCE = new PlayStoreAppRatingTemplate();
    private static final String NAME = "ctsystem_apprating";

    private PlayStoreAppRatingTemplate() {
    }

    public final CustomTemplate createTemplate(final InAppActionHandler systemActionHandler) {
        Intrinsics.checkNotNullParameter(systemActionHandler, "systemActionHandler");
        if (systemActionHandler.isPlayStoreReviewLibraryAvailable()) {
            return CustomTemplatesExtKt.function(true, new Function1() { // from class: com.clevertap.android.sdk.inapp.customtemplates.system.PlayStoreAppRatingTemplate$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PlayStoreAppRatingTemplate.createTemplate$lambda$3(systemActionHandler, (CustomTemplate.FunctionBuilder) obj);
                }
            });
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createTemplate$lambda$3(final InAppActionHandler systemActionHandler, CustomTemplate.FunctionBuilder function) {
        Intrinsics.checkNotNullParameter(systemActionHandler, "$systemActionHandler");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.setSystemDefined$clevertap_core_release(true);
        function.name(NAME);
        function.presenter(new FunctionPresenter() { // from class: com.clevertap.android.sdk.inapp.customtemplates.system.PlayStoreAppRatingTemplate$$ExternalSyntheticLambda3
            @Override // com.clevertap.android.sdk.inapp.customtemplates.CustomTemplatePresenter
            public final void onPresent(CustomTemplateContext customTemplateContext) {
                PlayStoreAppRatingTemplate.createTemplate$lambda$3$lambda$2(systemActionHandler, (CustomTemplateContext.FunctionContext) customTemplateContext);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createTemplate$lambda$3$lambda$2(InAppActionHandler systemActionHandler, final CustomTemplateContext.FunctionContext templateContext) {
        Intrinsics.checkNotNullParameter(systemActionHandler, "$systemActionHandler");
        Intrinsics.checkNotNullParameter(templateContext, "templateContext");
        systemActionHandler.launchPlayStoreReviewFlow(new Function0() { // from class: com.clevertap.android.sdk.inapp.customtemplates.system.PlayStoreAppRatingTemplate$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlayStoreAppRatingTemplate.createTemplate$lambda$3$lambda$2$lambda$0(templateContext);
            }
        }, new Function1() { // from class: com.clevertap.android.sdk.inapp.customtemplates.system.PlayStoreAppRatingTemplate$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlayStoreAppRatingTemplate.createTemplate$lambda$3$lambda$2$lambda$1(templateContext, (Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createTemplate$lambda$3$lambda$2$lambda$0(CustomTemplateContext.FunctionContext templateContext) {
        Intrinsics.checkNotNullParameter(templateContext, "$templateContext");
        templateContext.setPresented();
        templateContext.setDismissed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createTemplate$lambda$3$lambda$2$lambda$1(CustomTemplateContext.FunctionContext templateContext, Exception exc) {
        Intrinsics.checkNotNullParameter(templateContext, "$templateContext");
        templateContext.setDismissed();
        return Unit.INSTANCE;
    }
}
