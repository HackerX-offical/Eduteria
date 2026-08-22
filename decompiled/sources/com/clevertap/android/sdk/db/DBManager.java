package com.clevertap.android.sdk.db;

import android.content.Context;
import com.android.billingclient.api.BillingFlowParams;
import com.clevertap.android.sdk.CTLockManager;
import com.clevertap.android.sdk.ILogger;
import com.clevertap.android.sdk.events.EventGroup;
import com.clevertap.android.sdk.network.IJRepo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DBManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 42\u00020\u0001:\u00014BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0017J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0017J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J,\u0010 \u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030#H\u0016J\u001e\u0010%\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030#H\u0016J\u0018\u0010'\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J \u0010(\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001cH\u0017J\u0018\u0010,\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*H\u0017J\u0010\u0010-\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010.\u001a\u00020\u000fH\u0002J\u0010\u0010/\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u00100\u001a\u00020\u000fH\u0002J \u00101\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*2\u0006\u00102\u001a\u000203H\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/clevertap/android/sdk/db/DBManager;", "Lcom/clevertap/android/sdk/db/BaseDatabaseManager;", BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "", "logger", "Lcom/clevertap/android/sdk/ILogger;", "databaseName", "ctLockManager", "Lcom/clevertap/android/sdk/CTLockManager;", "ijRepo", "Lcom/clevertap/android/sdk/network/IJRepo;", "dbEncryptionHandler", "Lcom/clevertap/android/sdk/db/DBEncryptionHandler;", "clearFirstRequestTs", "Lkotlin/Function0;", "", "clearLastRequestTs", "<init>", "(Ljava/lang/String;Lcom/clevertap/android/sdk/ILogger;Ljava/lang/String;Lcom/clevertap/android/sdk/CTLockManager;Lcom/clevertap/android/sdk/network/IJRepo;Lcom/clevertap/android/sdk/db/DBEncryptionHandler;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "dbAdapter", "Lcom/clevertap/android/sdk/db/DBAdapter;", "loadDBAdapter", "context", "Landroid/content/Context;", "clearQueues", "getQueuedEvents", "Lcom/clevertap/android/sdk/db/QueueData;", "batchSize", "", "eventGroup", "Lcom/clevertap/android/sdk/events/EventGroup;", "getCombinedQueuedEvents", "cleanupSentEvents", "", "eventIds", "", "profileEventIds", "cleanupPushNotificationEvents", "ids", "getPushNotificationViewedQueuedEvents", "queueEventToDB", "event", "Lorg/json/JSONObject;", "type", "queuePushNotificationViewedEventToDB", "clearIJ", "clearLastRequestTimestamp", "clearUserContext", "clearFirstRequestTimestamp", "queueEventForTable", "table", "Lcom/clevertap/android/sdk/db/Table;", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DBManager implements BaseDatabaseManager {
    private static final Companion Companion = new Companion(null);
    private static final int USER_EVENT_LOG_ROWS_PER_USER = 2304;
    private static final int USER_EVENT_LOG_ROWS_THRESHOLD = 11520;
    private final String accountId;
    private final Function0<Unit> clearFirstRequestTs;
    private final Function0<Unit> clearLastRequestTs;
    private final CTLockManager ctLockManager;
    private final String databaseName;
    private DBAdapter dbAdapter;
    private final DBEncryptionHandler dbEncryptionHandler;
    private final IJRepo ijRepo;
    private final ILogger logger;

    /* JADX INFO: compiled from: DBManager.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventGroup.values().length];
            try {
                iArr[EventGroup.PUSH_NOTIFICATION_VIEWED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DBManager(String accountId, ILogger logger, String databaseName, CTLockManager ctLockManager, IJRepo ijRepo, DBEncryptionHandler dbEncryptionHandler, Function0<Unit> clearFirstRequestTs, Function0<Unit> clearLastRequestTs) {
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(databaseName, "databaseName");
        Intrinsics.checkNotNullParameter(ctLockManager, "ctLockManager");
        Intrinsics.checkNotNullParameter(ijRepo, "ijRepo");
        Intrinsics.checkNotNullParameter(dbEncryptionHandler, "dbEncryptionHandler");
        Intrinsics.checkNotNullParameter(clearFirstRequestTs, "clearFirstRequestTs");
        Intrinsics.checkNotNullParameter(clearLastRequestTs, "clearLastRequestTs");
        this.accountId = accountId;
        this.logger = logger;
        this.databaseName = databaseName;
        this.ctLockManager = ctLockManager;
        this.ijRepo = ijRepo;
        this.dbEncryptionHandler = dbEncryptionHandler;
        this.clearFirstRequestTs = clearFirstRequestTs;
        this.clearLastRequestTs = clearLastRequestTs;
    }

    public /* synthetic */ DBManager(String str, ILogger iLogger, String str2, CTLockManager cTLockManager, IJRepo iJRepo, DBEncryptionHandler dBEncryptionHandler, Function0 function0, Function0 function02, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, iLogger, str2, cTLockManager, iJRepo, dBEncryptionHandler, (i & 64) != 0 ? new Function0() { // from class: com.clevertap.android.sdk.db.DBManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        } : function0, (i & 128) != 0 ? new Function0() { // from class: com.clevertap.android.sdk.db.DBManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        } : function02);
    }

    /* JADX INFO: compiled from: DBManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/clevertap/android/sdk/db/DBManager$Companion;", "", "<init>", "()V", "USER_EVENT_LOG_ROWS_PER_USER", "", "USER_EVENT_LOG_ROWS_THRESHOLD", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.clevertap.android.sdk.db.BaseDatabaseManager
    public synchronized DBAdapter loadDBAdapter(Context context) {
        DBAdapter dBAdapter;
        Intrinsics.checkNotNullParameter(context, "context");
        dBAdapter = this.dbAdapter;
        if (dBAdapter == null) {
            DBAdapter dBAdapter2 = new DBAdapter(context, this.databaseName, this.accountId, this.logger, this.dbEncryptionHandler, null, 32, null);
            this.dbAdapter = dBAdapter2;
            dBAdapter2.cleanupStaleEvents(Table.EVENTS);
            dBAdapter2.cleanupStaleEvents(Table.PROFILE_EVENTS);
            dBAdapter2.cleanupStaleEvents(Table.PUSH_NOTIFICATION_VIEWED);
            dBAdapter2.cleanUpPushNotifications();
            dBAdapter2.userEventLogDAO().cleanUpExtraEvents(USER_EVENT_LOG_ROWS_THRESHOLD, USER_EVENT_LOG_ROWS_PER_USER);
            dBAdapter2.delayedLegacyInAppDAO().clearAll();
            dBAdapter = dBAdapter2;
        }
        return dBAdapter;
    }

    @Override // com.clevertap.android.sdk.db.BaseDatabaseManager
    public void clearQueues(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object eventLock = this.ctLockManager.getEventLock();
        Intrinsics.checkNotNullExpressionValue(eventLock, "getEventLock(...)");
        synchronized (eventLock) {
            DBAdapter dBAdapterLoadDBAdapter = loadDBAdapter(context);
            dBAdapterLoadDBAdapter.removeEvents(Table.EVENTS);
            dBAdapterLoadDBAdapter.removeEvents(Table.PROFILE_EVENTS);
            clearUserContext(context);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.clevertap.android.sdk.db.BaseDatabaseManager
    public QueueData getQueuedEvents(Context context, int batchSize, EventGroup eventGroup) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(eventGroup, "eventGroup");
        if (WhenMappings.$EnumSwitchMapping$0[eventGroup.ordinal()] == 1) {
            this.logger.verbose(this.accountId, "Returning Queued Notification Viewed events");
            return getPushNotificationViewedQueuedEvents(context, batchSize);
        }
        this.logger.verbose(this.accountId, "Returning combined queued events");
        return getCombinedQueuedEvents(context, batchSize);
    }

    @Override // com.clevertap.android.sdk.db.BaseDatabaseManager
    public QueueData getCombinedQueuedEvents(Context context, int batchSize) {
        QueueData queueDataFetchCombinedEvents;
        Intrinsics.checkNotNullParameter(context, "context");
        Object eventLock = this.ctLockManager.getEventLock();
        Intrinsics.checkNotNullExpressionValue(eventLock, "getEventLock(...)");
        synchronized (eventLock) {
            queueDataFetchCombinedEvents = loadDBAdapter(context).fetchCombinedEvents(batchSize);
        }
        return queueDataFetchCombinedEvents;
    }

    @Override // com.clevertap.android.sdk.db.BaseDatabaseManager
    public boolean cleanupSentEvents(Context context, List<String> eventIds, List<String> profileEventIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(eventIds, "eventIds");
        Intrinsics.checkNotNullParameter(profileEventIds, "profileEventIds");
        Object eventLock = this.ctLockManager.getEventLock();
        Intrinsics.checkNotNullExpressionValue(eventLock, "getEventLock(...)");
        synchronized (eventLock) {
            if (eventIds.isEmpty() && profileEventIds.isEmpty()) {
                return true;
            }
            try {
                DBAdapter dBAdapterLoadDBAdapter = loadDBAdapter(context);
                if (!eventIds.isEmpty()) {
                    dBAdapterLoadDBAdapter.cleanupEventsFromLastId(eventIds.get(eventIds.size() - 1), Table.EVENTS);
                    this.logger.verbose(this.accountId, "Cleaned " + eventIds.size() + " events from events table");
                }
                if (!profileEventIds.isEmpty()) {
                    dBAdapterLoadDBAdapter.cleanupEventsFromLastId(profileEventIds.get(profileEventIds.size() - 1), Table.PROFILE_EVENTS);
                    this.logger.verbose(this.accountId, "Cleaned " + profileEventIds.size() + " events from profileEvents table");
                }
                return true;
            } catch (Exception e2) {
                this.logger.verbose(this.accountId, "Error during cleanup of sent events", e2);
                return false;
            }
        }
    }

    @Override // com.clevertap.android.sdk.db.BaseDatabaseManager
    public boolean cleanupPushNotificationEvents(Context context, List<String> ids) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ids, "ids");
        Object eventLock = this.ctLockManager.getEventLock();
        Intrinsics.checkNotNullExpressionValue(eventLock, "getEventLock(...)");
        synchronized (eventLock) {
            if (ids.isEmpty()) {
                return true;
            }
            try {
                DBAdapter dBAdapterLoadDBAdapter = loadDBAdapter(context);
                if (!ids.isEmpty()) {
                    dBAdapterLoadDBAdapter.cleanupEventsFromLastId(ids.get(ids.size() - 1), Table.PUSH_NOTIFICATION_VIEWED);
                    this.logger.verbose(this.accountId, "Cleaned " + ids.size() + " events from Push impressions table");
                }
                return true;
            } catch (Exception e2) {
                this.logger.verbose(this.accountId, "Error during cleanup of notification sent events", e2);
                return false;
            }
        }
    }

    @Override // com.clevertap.android.sdk.db.BaseDatabaseManager
    public QueueData getPushNotificationViewedQueuedEvents(Context context, int batchSize) {
        QueueData queueDataFetchEvents;
        Intrinsics.checkNotNullParameter(context, "context");
        Object eventLock = this.ctLockManager.getEventLock();
        Intrinsics.checkNotNullExpressionValue(eventLock, "getEventLock(...)");
        synchronized (eventLock) {
            queueDataFetchEvents = loadDBAdapter(context).fetchEvents(Table.PUSH_NOTIFICATION_VIEWED, batchSize);
        }
        return queueDataFetchEvents;
    }

    @Override // com.clevertap.android.sdk.db.BaseDatabaseManager
    public void queueEventToDB(Context context, JSONObject event, int type) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(event, "event");
        queueEventForTable(context, event, type == 3 ? Table.PROFILE_EVENTS : Table.EVENTS);
    }

    @Override // com.clevertap.android.sdk.db.BaseDatabaseManager
    public void queuePushNotificationViewedEventToDB(Context context, JSONObject event) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(event, "event");
        queueEventForTable(context, event, Table.PUSH_NOTIFICATION_VIEWED);
    }

    private final void clearIJ(Context context) {
        this.ijRepo.clearIJ(context);
    }

    private final void clearLastRequestTimestamp() {
        this.clearLastRequestTs.invoke();
    }

    private final void clearUserContext(Context context) {
        clearIJ(context);
        clearFirstRequestTimestamp();
        clearLastRequestTimestamp();
    }

    private final void clearFirstRequestTimestamp() {
        this.clearFirstRequestTs.invoke();
    }

    private final void queueEventForTable(Context context, JSONObject event, Table table) {
        Object eventLock = this.ctLockManager.getEventLock();
        Intrinsics.checkNotNullExpressionValue(eventLock, "getEventLock(...)");
        synchronized (eventLock) {
            if (loadDBAdapter(context).storeObject(event, table) > 0) {
                this.logger.debug(this.accountId, "Queued event: " + event);
                this.logger.verbose(this.accountId, "Queued event to DB table " + table + ": " + event);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
