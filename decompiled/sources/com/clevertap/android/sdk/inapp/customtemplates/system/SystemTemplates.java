package com.clevertap.android.sdk.inapp.customtemplates.system;

import com.clevertap.android.sdk.inapp.InAppActionHandler;
import com.clevertap.android.sdk.inapp.customtemplates.CustomTemplate;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemTemplates.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/clevertap/android/sdk/inapp/customtemplates/system/SystemTemplates;", "", "<init>", "()V", "getSystemTemplates", "", "Lcom/clevertap/android/sdk/inapp/customtemplates/CustomTemplate;", "systemActionHandler", "Lcom/clevertap/android/sdk/inapp/InAppActionHandler;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SystemTemplates {
    public static final SystemTemplates INSTANCE = new SystemTemplates();

    private SystemTemplates() {
    }

    public final Set<CustomTemplate> getSystemTemplates(InAppActionHandler systemActionHandler) {
        Intrinsics.checkNotNullParameter(systemActionHandler, "systemActionHandler");
        return SetsKt.setOfNotNull((Object[]) new CustomTemplate[]{OpenUrlTemplate.INSTANCE.createTemplate(systemActionHandler), PlayStoreAppRatingTemplate.INSTANCE.createTemplate(systemActionHandler), PushPermissionTemplate.INSTANCE.createTemplate(systemActionHandler)});
    }
}
