package com.clevertap.android.sdk.network;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.StorageHelper;
import com.clevertap.android.sdk.utils.Clock;
import java.security.SecureRandom;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkRepo.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0015\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\bJ\u0006\u0010\u001c\u001a\u00020\u0017J\u0006\u0010\u001d\u001a\u00020\bJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\bJ\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001fJ\u0010\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010%J\b\u0010&\u001a\u0004\u0018\u00010%J\b\u0010'\u001a\u0004\u0018\u00010%J\u000e\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020%J\u0016\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006."}, d2 = {"Lcom/clevertap/android/sdk/network/NetworkRepo;", "", "context", "Landroid/content/Context;", "config", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "generateRandomDelay", "Lkotlin/Function0;", "", "clock", "Lcom/clevertap/android/sdk/utils/Clock;", "<init>", "(Landroid/content/Context;Lcom/clevertap/android/sdk/CleverTapInstanceConfig;Lkotlin/jvm/functions/Function0;Lcom/clevertap/android/sdk/utils/Clock;)V", "getContext", "()Landroid/content/Context;", "getConfig", "()Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "getGenerateRandomDelay", "()Lkotlin/jvm/functions/Function0;", "getClock", "()Lcom/clevertap/android/sdk/utils/Clock;", "getFirstRequestTs", "setFirstRequestTs", "", "firstRequestTs", "clearFirstRequestTs", "setLastRequestTs", "lastRequestTs", "clearLastRequestTs", "getLastRequestTs", "isMuted", "", "getMuted", "setMuted", "mute", "setDomain", "domainName", "", "getDomain", "getSpikyDomain", "setSpikyDomain", "spikyDomainName", "getMinDelayFrequency", "currentDelay", "networkRetryCount", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NetworkRepo {
    public static final String KEY_DOMAIN_NAME = "comms_dmn";
    public static final String KEY_FIRST_TS = "comms_first_ts";
    public static final String KEY_LAST_TS = "comms_last_ts";
    public static final int MAX_DELAY_FREQUENCY = 600000;
    public static final int PUSH_DELAY_MS = 1000;
    public static final String SPIKY_KEY_DOMAIN_NAME = "comms_dmn_spiky";
    private final Clock clock;
    private final CleverTapInstanceConfig config;
    private final Context context;
    private final Function0<Integer> generateRandomDelay;

    public NetworkRepo(Context context, CleverTapInstanceConfig config, Function0<Integer> generateRandomDelay, Clock clock) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(generateRandomDelay, "generateRandomDelay");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.context = context;
        this.config = config;
        this.generateRandomDelay = generateRandomDelay;
        this.clock = clock;
    }

    public final Context getContext() {
        return this.context;
    }

    public final CleverTapInstanceConfig getConfig() {
        return this.config;
    }

    public /* synthetic */ NetworkRepo(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, Function0 function0, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, cleverTapInstanceConfig, (i & 4) != 0 ? new Function0() { // from class: com.clevertap.android.sdk.network.NetworkRepo$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(NetworkRepo._init_$lambda$0());
            }
        } : function0, (i & 8) != 0 ? Clock.SYSTEM : clock);
    }

    public final Function0<Integer> getGenerateRandomDelay() {
        return this.generateRandomDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _init_$lambda$0() {
        return (new SecureRandom().nextInt(10) + 1) * 1000;
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final int getFirstRequestTs() {
        Context context = this.context;
        String accountId = this.config.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId(...)");
        return StorageHelper.getIntFromPrefs(context, accountId, KEY_FIRST_TS, 0);
    }

    public final void setFirstRequestTs(int firstRequestTs) {
        Context context = this.context;
        String accountId = this.config.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId(...)");
        StorageHelper.putInt(context, accountId, KEY_FIRST_TS, firstRequestTs);
    }

    public final void clearFirstRequestTs() {
        Context context = this.context;
        String accountId = this.config.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId(...)");
        StorageHelper.putInt(context, accountId, KEY_FIRST_TS, 0);
    }

    public final void setLastRequestTs(int lastRequestTs) {
        Context context = this.context;
        String accountId = this.config.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId(...)");
        StorageHelper.putInt(context, accountId, KEY_LAST_TS, lastRequestTs);
    }

    public final void clearLastRequestTs() {
        Context context = this.context;
        String accountId = this.config.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId(...)");
        StorageHelper.putInt(context, accountId, KEY_LAST_TS, 0);
    }

    public final int getLastRequestTs() {
        Context context = this.context;
        String accountId = this.config.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId(...)");
        return StorageHelper.getIntFromPrefs(context, accountId, KEY_LAST_TS, 0);
    }

    public final boolean isMuted() {
        return this.clock.currentTimeSecondsInt() - getMuted() < 86400;
    }

    public final int getMuted() {
        Context context = this.context;
        String accountId = this.config.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId(...)");
        return StorageHelper.getIntFromPrefs(context, accountId, Constants.KEY_MUTED, 0);
    }

    public final void setMuted(boolean mute) {
        if (mute) {
            int iCurrentTimeSecondsInt = this.clock.currentTimeSecondsInt();
            Context context = this.context;
            String accountId = this.config.getAccountId();
            Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId(...)");
            StorageHelper.putInt(context, accountId, Constants.KEY_MUTED, iCurrentTimeSecondsInt);
            return;
        }
        Context context2 = this.context;
        String accountId2 = this.config.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId2, "getAccountId(...)");
        StorageHelper.putInt(context2, accountId2, Constants.KEY_MUTED, 0);
    }

    public final void setDomain(String domainName) {
        Context context = this.context;
        String accountId = this.config.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId(...)");
        StorageHelper.putString(context, accountId, KEY_DOMAIN_NAME, domainName);
    }

    public final String getDomain() {
        Context context = this.context;
        String accountId = this.config.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId(...)");
        return StorageHelper.getStringFromPrefs(context, accountId, KEY_DOMAIN_NAME, null);
    }

    public final String getSpikyDomain() {
        Context context = this.context;
        String accountId = this.config.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId(...)");
        return StorageHelper.getStringFromPrefs(context, accountId, SPIKY_KEY_DOMAIN_NAME, null);
    }

    public final void setSpikyDomain(String spikyDomainName) {
        Intrinsics.checkNotNullParameter(spikyDomainName, "spikyDomainName");
        Context context = this.context;
        String accountId = this.config.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId(...)");
        StorageHelper.putString(context, accountId, SPIKY_KEY_DOMAIN_NAME, spikyDomainName);
    }

    public final int getMinDelayFrequency(int currentDelay, int networkRetryCount) {
        this.config.getLogger().debug(this.config.getAccountId(), "Network retry #" + networkRetryCount);
        if (networkRetryCount < 10) {
            this.config.getLogger().debug(this.config.getAccountId(), "Failure count is " + networkRetryCount + ". Setting delay frequency to 1s");
            return 1000;
        }
        if (this.config.getAccountRegion() == null) {
            this.config.getLogger().debug(this.config.getAccountId(), "Setting delay frequency to 1s");
            return 1000;
        }
        int iIntValue = this.generateRandomDelay.invoke().intValue() + currentDelay;
        if (iIntValue >= 600000) {
            return 1000;
        }
        this.config.getLogger().debug(this.config.getAccountId(), "Setting delay frequency to " + currentDelay);
        return iIntValue;
    }
}
