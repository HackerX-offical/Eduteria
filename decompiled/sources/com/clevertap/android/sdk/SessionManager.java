package com.clevertap.android.sdk;

import android.content.Context;
import com.clevertap.android.sdk.events.EventDetail;
import com.clevertap.android.sdk.usereventlogs.UserEventLog;
import com.clevertap.android.sdk.validation.Validator;

/* JADX INFO: loaded from: classes7.dex */
public class SessionManager extends BaseSessionManager {
    private long appLastSeen = 0;
    private final CoreMetaData cleverTapMetaData;
    private final CleverTapInstanceConfig config;
    private int lastVisitTime;
    private final LocalDataStore localDataStore;
    private long userLastVisitTs;
    private final Validator validator;

    public SessionManager(CleverTapInstanceConfig cleverTapInstanceConfig, CoreMetaData coreMetaData, Validator validator, LocalDataStore localDataStore) {
        this.config = cleverTapInstanceConfig;
        this.cleverTapMetaData = coreMetaData;
        this.validator = validator;
        this.localDataStore = localDataStore;
    }

    public void checkTimeoutSession() {
        if (this.appLastSeen > 0 && System.currentTimeMillis() - this.appLastSeen > 1200000) {
            this.config.getLogger().verbose(this.config.getAccountId(), "Session Timed Out");
            destroySession();
        }
    }

    @Override // com.clevertap.android.sdk.BaseSessionManager
    public void destroySession() {
        this.cleverTapMetaData.setCurrentSessionId(0);
        this.cleverTapMetaData.setRelaxNetwork(false);
        this.cleverTapMetaData.setAppLaunchPushed(false);
        if (this.cleverTapMetaData.isFirstSession()) {
            this.cleverTapMetaData.setFirstSession(false);
        }
        this.config.getLogger().verbose(this.config.getAccountId(), "Session destroyed; Session ID is now 0");
        this.cleverTapMetaData.clearSource();
        this.cleverTapMetaData.clearMedium();
        this.cleverTapMetaData.clearCampaign();
        this.cleverTapMetaData.clearWzrkParams();
    }

    public long getAppLastSeen() {
        return this.appLastSeen;
    }

    public void setAppLastSeen(long j) {
        this.appLastSeen = j;
    }

    public int getLastVisitTime() {
        return this.lastVisitTime;
    }

    @Override // com.clevertap.android.sdk.BaseSessionManager
    public void lazyCreateSession(Context context) {
        if (this.cleverTapMetaData.inCurrentSession()) {
            return;
        }
        this.cleverTapMetaData.setFirstRequestInSession(true);
        Validator validator = this.validator;
        if (validator != null) {
            validator.setDiscardedEvents(null);
        }
        createSession(context);
    }

    void setLastVisitTime() {
        EventDetail eventDetail = this.localDataStore.getEventDetail(Constants.APP_LAUNCHED_EVENT);
        if (eventDetail == null) {
            this.lastVisitTime = -1;
        } else {
            this.lastVisitTime = eventDetail.getLastTime();
        }
    }

    void setUserLastVisitTs() {
        UserEventLog userEventLog = this.localDataStore.readUserEventLog(Constants.APP_LAUNCHED_EVENT);
        this.userLastVisitTs = userEventLog != null ? userEventLog.getLastTs() : -1L;
    }

    private void createSession(Context context) {
        this.cleverTapMetaData.setCurrentSessionId(getNow());
        this.config.getLogger().verbose(this.config.getAccountId(), "Session created with ID: " + this.cleverTapMetaData.getCurrentSessionId());
        int intFromPrefs = StorageHelper.getIntFromPrefs(context, this.config.getAccountId(), Constants.SESSION_ID_LAST, 0);
        int intFromPrefs2 = StorageHelper.getIntFromPrefs(context, this.config.getAccountId(), Constants.LAST_SESSION_EPOCH, 0);
        if (intFromPrefs2 > 0) {
            this.cleverTapMetaData.setLastSessionLength(intFromPrefs2 - intFromPrefs);
        }
        this.config.getLogger().verbose(this.config.getAccountId(), "Last session length: " + this.cleverTapMetaData.getLastSessionLength() + " seconds");
        if (intFromPrefs == 0) {
            this.cleverTapMetaData.setFirstSession(true);
        }
        StorageHelper.putInt(context, this.config.getAccountId(), Constants.SESSION_ID_LAST, this.cleverTapMetaData.getCurrentSessionId());
    }

    int getNow() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public long getUserLastVisitTs() {
        return this.userLastVisitTs;
    }
}
