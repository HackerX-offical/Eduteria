package com.clevertap.android.sdk.login;

import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.validation.ValidationResultFactory;
import com.clevertap.android.sdk.validation.ValidationResultStack;

/* JADX INFO: loaded from: classes7.dex */
public class ConfigurableIdentityRepo implements IdentityRepo {
    private static final String TAG = "ConfigurableIdentityRepo";
    private final CleverTapInstanceConfig config;
    private IdentitySet identitySet;
    private final LoginInfoProvider infoProvider;
    private final ValidationResultStack validationResultStack;

    public ConfigurableIdentityRepo(CleverTapInstanceConfig cleverTapInstanceConfig, LoginInfoProvider loginInfoProvider, ValidationResultStack validationResultStack) {
        this.config = cleverTapInstanceConfig;
        this.infoProvider = loginInfoProvider;
        this.validationResultStack = validationResultStack;
        loadIdentitySet();
    }

    @Override // com.clevertap.android.sdk.login.IdentityRepo
    public IdentitySet getIdentitySet() {
        return this.identitySet;
    }

    @Override // com.clevertap.android.sdk.login.IdentityRepo
    public boolean hasIdentity(String str) {
        boolean zContains = this.identitySet.contains(str);
        this.config.log(LoginConstants.LOG_TAG_ON_USER_LOGIN, "ConfigurableIdentityRepoisIdentity [Key: " + str + " , Value: " + zContains + Constants.AES_SUFFIX);
        return zContains;
    }

    void loadIdentitySet() {
        IdentitySet identitySetFrom = IdentitySet.from(this.infoProvider.getCachedIdentityKeysForAccount());
        this.config.log(LoginConstants.LOG_TAG_ON_USER_LOGIN, "ConfigurableIdentityRepoPrefIdentitySet [" + identitySetFrom + Constants.AES_SUFFIX);
        IdentitySet identitySetFrom2 = IdentitySet.from(this.config.getIdentityKeys());
        this.config.log(LoginConstants.LOG_TAG_ON_USER_LOGIN, "ConfigurableIdentityRepoConfigIdentitySet [" + identitySetFrom2 + Constants.AES_SUFFIX);
        handleError(identitySetFrom, identitySetFrom2);
        if (identitySetFrom.isValid()) {
            this.identitySet = identitySetFrom;
            this.config.log(LoginConstants.LOG_TAG_ON_USER_LOGIN, "ConfigurableIdentityRepoIdentity Set activated from Pref[" + this.identitySet + Constants.AES_SUFFIX);
        } else if (identitySetFrom2.isValid()) {
            this.identitySet = identitySetFrom2;
            this.config.log(LoginConstants.LOG_TAG_ON_USER_LOGIN, "ConfigurableIdentityRepoIdentity Set activated from Config[" + this.identitySet + Constants.AES_SUFFIX);
        } else {
            this.identitySet = IdentitySet.getDefault();
            this.config.log(LoginConstants.LOG_TAG_ON_USER_LOGIN, "ConfigurableIdentityRepoIdentity Set activated from Default[" + this.identitySet + Constants.AES_SUFFIX);
        }
        if (identitySetFrom.isValid()) {
            return;
        }
        String string = this.identitySet.toString();
        this.infoProvider.saveIdentityKeysForAccount(string);
        this.config.log(LoginConstants.LOG_TAG_ON_USER_LOGIN, "ConfigurableIdentityRepoSaving Identity Keys in Pref[" + string + Constants.AES_SUFFIX);
    }

    private void handleError(IdentitySet identitySet, IdentitySet identitySet2) {
        if (identitySet.isValid() && identitySet2.isValid() && !identitySet.equals(identitySet2)) {
            this.validationResultStack.pushValidationResult(ValidationResultFactory.create(531));
            this.config.log(LoginConstants.LOG_TAG_ON_USER_LOGIN, "ConfigurableIdentityRepopushing error due to mismatch [Pref:" + identitySet + "], [Config:" + identitySet2 + Constants.AES_SUFFIX);
            return;
        }
        this.config.log(LoginConstants.LOG_TAG_ON_USER_LOGIN, "ConfigurableIdentityRepoNo error found while comparing [Pref:" + identitySet + "], [Config:" + identitySet2 + Constants.AES_SUFFIX);
    }
}
