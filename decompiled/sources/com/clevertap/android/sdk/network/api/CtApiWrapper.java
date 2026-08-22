package com.clevertap.android.sdk.network.api;

import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.network.NetworkRepo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CtApiWrapper.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8GX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/clevertap/android/sdk/network/api/CtApiWrapper;", "", "networkRepo", "Lcom/clevertap/android/sdk/network/NetworkRepo;", "config", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "deviceInfo", "Lcom/clevertap/android/sdk/DeviceInfo;", "<init>", "(Lcom/clevertap/android/sdk/network/NetworkRepo;Lcom/clevertap/android/sdk/CleverTapInstanceConfig;Lcom/clevertap/android/sdk/DeviceInfo;)V", "ctApi", "Lcom/clevertap/android/sdk/network/api/CtApi;", "getCtApi", "()Lcom/clevertap/android/sdk/network/api/CtApi;", "ctApi$delegate", "Lkotlin/Lazy;", "needsHandshake", "", "isViewedEvent", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CtApiWrapper {
    private final CleverTapInstanceConfig config;

    /* JADX INFO: renamed from: ctApi$delegate, reason: from kotlin metadata */
    private final Lazy ctApi;
    private final DeviceInfo deviceInfo;
    private final NetworkRepo networkRepo;

    public CtApiWrapper(NetworkRepo networkRepo, CleverTapInstanceConfig config, DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(networkRepo, "networkRepo");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        this.networkRepo = networkRepo;
        this.config = config;
        this.deviceInfo = deviceInfo;
        this.ctApi = LazyKt.lazy(new Function0() { // from class: com.clevertap.android.sdk.network.api.CtApiWrapper$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CtApiWrapper.ctApi_delegate$lambda$0(this.f$0);
            }
        });
    }

    public final CtApi getCtApi() {
        return (CtApi) this.ctApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CtApi ctApi_delegate$lambda$0(CtApiWrapper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return CtApiProvider.INSTANCE.provideDefaultCtApi$clevertap_core_release(this$0.networkRepo, this$0.config, this$0.deviceInfo);
    }

    public final boolean needsHandshake(boolean isViewedEvent) {
        return getCtApi().needsHandshake(isViewedEvent);
    }
}
