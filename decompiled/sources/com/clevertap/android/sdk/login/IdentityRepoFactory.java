package com.clevertap.android.sdk.login;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.validation.ValidationResultStack;

/* JADX INFO: loaded from: classes7.dex */
public class IdentityRepoFactory {
    public static IdentityRepo getRepo(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, ValidationResultStack validationResultStack) {
        IdentityRepo configurableIdentityRepo;
        LoginInfoProvider loginInfoProvider = new LoginInfoProvider(context, cleverTapInstanceConfig);
        if (loginInfoProvider.isLegacyProfileLoggedIn()) {
            configurableIdentityRepo = new LegacyIdentityRepo(cleverTapInstanceConfig);
        } else {
            configurableIdentityRepo = new ConfigurableIdentityRepo(cleverTapInstanceConfig, loginInfoProvider, validationResultStack);
        }
        cleverTapInstanceConfig.log(LoginConstants.LOG_TAG_ON_USER_LOGIN, "Repo provider: " + configurableIdentityRepo.getClass().getSimpleName());
        return configurableIdentityRepo;
    }

    private IdentityRepoFactory() {
    }
}
