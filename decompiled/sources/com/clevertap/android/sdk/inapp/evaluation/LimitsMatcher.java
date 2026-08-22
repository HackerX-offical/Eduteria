package com.clevertap.android.sdk.inapp.evaluation;

import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.db.Column;
import com.clevertap.android.sdk.inapp.ImpressionManager;
import com.clevertap.android.sdk.inapp.TriggerManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LimitsMatcher.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001c\u0010\u0011\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/clevertap/android/sdk/inapp/evaluation/LimitsMatcher;", "", "manager", "Lcom/clevertap/android/sdk/inapp/ImpressionManager;", "triggerManager", "Lcom/clevertap/android/sdk/inapp/TriggerManager;", "<init>", "(Lcom/clevertap/android/sdk/inapp/ImpressionManager;Lcom/clevertap/android/sdk/inapp/TriggerManager;)V", "matchWhenLimits", "", "whenLimits", "", "Lcom/clevertap/android/sdk/inapp/evaluation/LimitAdapter;", Column.CAMPAIGN, "", "matchLimit", Constants.KEY_LIMIT, "shouldDiscard", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LimitsMatcher {
    private final ImpressionManager manager;
    private final TriggerManager triggerManager;

    /* JADX INFO: compiled from: LimitsMatcher.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LimitType.values().length];
            try {
                iArr[LimitType.Session.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LimitType.Seconds.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LimitType.Minutes.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LimitType.Hours.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LimitType.Days.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LimitType.Weeks.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[LimitType.Ever.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[LimitType.OnEvery.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[LimitType.OnExactly.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LimitsMatcher(ImpressionManager manager, TriggerManager triggerManager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(triggerManager, "triggerManager");
        this.manager = manager;
        this.triggerManager = triggerManager;
    }

    public final boolean matchWhenLimits(List<LimitAdapter> whenLimits, String campaignId) {
        Intrinsics.checkNotNullParameter(whenLimits, "whenLimits");
        Intrinsics.checkNotNullParameter(campaignId, "campaignId");
        List<LimitAdapter> list = whenLimits;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!matchLimit((LimitAdapter) it.next(), campaignId)) {
                return false;
            }
        }
        return true;
    }

    private final boolean matchLimit(LimitAdapter limit, String campaignId) {
        switch (WhenMappings.$EnumSwitchMapping$0[limit.getLimitType().ordinal()]) {
            case 1:
                return this.manager.perSession(campaignId) < limit.getLimit();
            case 2:
                return this.manager.perSecond(campaignId, limit.getFrequency()) < limit.getLimit();
            case 3:
                return this.manager.perMinute(campaignId, limit.getFrequency()) < limit.getLimit();
            case 4:
                return this.manager.perHour(campaignId, limit.getFrequency()) < limit.getLimit();
            case 5:
                return this.manager.perDay(campaignId, limit.getFrequency()) < limit.getLimit();
            case 6:
                return this.manager.perWeek(campaignId, limit.getFrequency()) < limit.getLimit();
            case 7:
                return this.manager.getImpressions(campaignId).size() < limit.getLimit();
            case 8:
                return this.triggerManager.getTriggers(campaignId) % limit.getLimit() == 0;
            case 9:
                return this.triggerManager.getTriggers(campaignId) == limit.getLimit();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean shouldDiscard(List<LimitAdapter> whenLimits, String campaignId) {
        Intrinsics.checkNotNullParameter(whenLimits, "whenLimits");
        Intrinsics.checkNotNullParameter(campaignId, "campaignId");
        while (true) {
            boolean z = false;
            for (LimitAdapter limitAdapter : whenLimits) {
                if (!z) {
                    if (WhenMappings.$EnumSwitchMapping$0[limitAdapter.getLimitType().ordinal()] != 7 || matchLimit(limitAdapter, campaignId)) {
                        break;
                    }
                }
                z = true;
            }
            return z;
        }
    }
}
