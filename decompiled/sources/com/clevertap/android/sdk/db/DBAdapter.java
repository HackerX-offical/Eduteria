package com.clevertap.android.sdk.db;

import android.content.Context;
import com.android.billingclient.api.BillingFlowParams;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.ILogger;
import com.clevertap.android.sdk.db.dao.EventDAO;
import com.clevertap.android.sdk.db.dao.EventDAOImpl;
import com.clevertap.android.sdk.db.dao.InboxMessageDAO;
import com.clevertap.android.sdk.db.dao.InboxMessageDAOImpl;
import com.clevertap.android.sdk.db.dao.PushNotificationDAO;
import com.clevertap.android.sdk.db.dao.PushNotificationDAOImpl;
import com.clevertap.android.sdk.db.dao.UninstallTimestampDAO;
import com.clevertap.android.sdk.db.dao.UninstallTimestampDAOImpl;
import com.clevertap.android.sdk.db.dao.UserProfileDAO;
import com.clevertap.android.sdk.db.dao.UserProfileDAOImpl;
import com.clevertap.android.sdk.inbox.CTMessageDAO;
import com.clevertap.android.sdk.usereventlogs.UserEventLogDAO;
import com.clevertap.android.sdk.usereventlogs.UserEventLogDAOImpl;
import com.clevertap.android.sdk.utils.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DBAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u000e\b\u0000\u0018\u0000 g2\u00020\u0001:\u0001gB9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0007J\u0018\u00105\u001a\u0002062\u0006\u00103\u001a\u0002042\u0006\u00107\u001a\u000208H\u0007J\u0010\u00109\u001a\u0002062\u0006\u0010:\u001a\u000208H\u0007J\u0018\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00052\u0006\u00103\u001a\u000204H\u0007J\u000e\u0010>\u001a\u00020<2\u0006\u00103\u001a\u000204J\u000e\u0010?\u001a\u00020<2\u0006\u00103\u001a\u000204J\u000e\u0010@\u001a\u0002082\u0006\u00103\u001a\u000204J%\u0010A\u001a\u0012\u0012\u0004\u0012\u00020C0Dj\b\u0012\u0004\u0012\u00020C`B2\u0006\u0010E\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010FJ\u0016\u0010G\u001a\u00020<2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020C0IH\u0007J\u001c\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u00052\b\u0010E\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010M\u001a\u00020K2\u0010\u0010N\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010I2\b\u0010E\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010O\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u00052\b\u0010E\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010P\u001a\u00020K2\u0010\u0010N\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010I2\b\u0010E\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010Q\u001a\u0002002\b\u0010R\u001a\u0004\u0018\u00010\u00052\b\u0010S\u001a\u0004\u0018\u00010\u00052\u0006\u00101\u001a\u000202H\u0007J\u001c\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002020U2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u001c\u0010V\u001a\u0004\u0018\u0001022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010S\u001a\u0004\u0018\u00010\u0005J\u0016\u0010W\u001a\u00020<2\u0006\u0010R\u001a\u00020\u00052\u0006\u0010X\u001a\u000200J\u0011\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00050Z¢\u0006\u0002\u0010[J\u000e\u0010\\\u001a\u00020K2\u0006\u0010R\u001a\u00020\u0005J\u001b\u0010]\u001a\u00020<2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00050ZH\u0007¢\u0006\u0002\u0010_J\u0006\u0010`\u001a\u00020<J\u0006\u0010a\u001a\u00020<J\u0006\u0010b\u001a\u000200J\b\u0010c\u001a\u00020,H\u0007J\b\u0010d\u001a\u00020.H\u0007J\r\u0010e\u001a\u00020<H\u0001¢\u0006\u0002\bfR\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0016\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0016\u001a\u0004\b(\u0010)R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006h"}, d2 = {"Lcom/clevertap/android/sdk/db/DBAdapter;", "", "context", "Landroid/content/Context;", "databaseName", "", BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "logger", "Lcom/clevertap/android/sdk/ILogger;", "dbEncryptionHandler", "Lcom/clevertap/android/sdk/db/DBEncryptionHandler;", "clock", "Lcom/clevertap/android/sdk/utils/Clock;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/clevertap/android/sdk/ILogger;Lcom/clevertap/android/sdk/db/DBEncryptionHandler;Lcom/clevertap/android/sdk/utils/Clock;)V", "dbHelper", "Lcom/clevertap/android/sdk/db/DatabaseHelper;", "eventDAO", "Lcom/clevertap/android/sdk/db/dao/EventDAO;", "getEventDAO", "()Lcom/clevertap/android/sdk/db/dao/EventDAO;", "eventDAO$delegate", "Lkotlin/Lazy;", "inboxMessageDAO", "Lcom/clevertap/android/sdk/db/dao/InboxMessageDAO;", "getInboxMessageDAO", "()Lcom/clevertap/android/sdk/db/dao/InboxMessageDAO;", "inboxMessageDAO$delegate", "userProfileDAO", "Lcom/clevertap/android/sdk/db/dao/UserProfileDAO;", "getUserProfileDAO", "()Lcom/clevertap/android/sdk/db/dao/UserProfileDAO;", "userProfileDAO$delegate", "pushNotificationDAO", "Lcom/clevertap/android/sdk/db/dao/PushNotificationDAO;", "getPushNotificationDAO", "()Lcom/clevertap/android/sdk/db/dao/PushNotificationDAO;", "pushNotificationDAO$delegate", "uninstallTimestampDAO", "Lcom/clevertap/android/sdk/db/dao/UninstallTimestampDAO;", "getUninstallTimestampDAO", "()Lcom/clevertap/android/sdk/db/dao/UninstallTimestampDAO;", "uninstallTimestampDAO$delegate", "userEventLogDao", "Lcom/clevertap/android/sdk/usereventlogs/UserEventLogDAO;", "delayedLegacyInAppDao", "Lcom/clevertap/android/sdk/db/DelayedLegacyInAppDAO;", "storeObject", "", "obj", "Lorg/json/JSONObject;", "table", "Lcom/clevertap/android/sdk/db/Table;", "fetchEvents", "Lcom/clevertap/android/sdk/db/QueueData;", Constants.KEY_LIMIT, "", "fetchCombinedEvents", "batchSize", "cleanupEventsFromLastId", "", "lastId", "cleanupStaleEvents", "removeEvents", "migrateEventsData", "getMessages", "Lkotlin/collections/ArrayList;", "Lcom/clevertap/android/sdk/inbox/CTMessageDAO;", "Ljava/util/ArrayList;", "userId", "(Ljava/lang/String;)Ljava/util/ArrayList;", "upsertMessages", "inboxMessages", "", "deleteMessageForId", "", "messageId", "deleteMessagesForIDs", "messageIDs", "markReadMessageForId", "markReadMessagesForIds", "storeUserProfile", "id", Constants.DEVICE_ID_TAG, "fetchUserProfilesByAccountId", "", "fetchUserProfileByAccountIdAndDeviceID", "storePushNotificationId", "ttlInSeconds", "fetchPushNotificationIds", "", "()[Ljava/lang/String;", "doesPushNotificationIdExist", "updatePushNotificationIds", "ids", "([Ljava/lang/String;)V", "cleanUpPushNotifications", "storeUninstallTimestamp", "getLastUninstallTimestamp", "userEventLogDAO", "delayedLegacyInAppDAO", "deleteDB", "deleteDB$clevertap_core_release", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DBAdapter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DATABASE_NAME = "clevertap";
    public static final long DB_OUT_OF_MEMORY_ERROR = -2;
    public static final long DB_UPDATE_ERROR = -1;
    public static final String NOT_ENOUGH_SPACE_LOG = "There is not enough space left on the device to store data, data discarded";
    private final String accountId;
    private final Clock clock;
    private final DBEncryptionHandler dbEncryptionHandler;
    private final DatabaseHelper dbHelper;
    private volatile DelayedLegacyInAppDAO delayedLegacyInAppDao;

    /* JADX INFO: renamed from: eventDAO$delegate, reason: from kotlin metadata */
    private final Lazy eventDAO;

    /* JADX INFO: renamed from: inboxMessageDAO$delegate, reason: from kotlin metadata */
    private final Lazy inboxMessageDAO;
    private final ILogger logger;

    /* JADX INFO: renamed from: pushNotificationDAO$delegate, reason: from kotlin metadata */
    private final Lazy pushNotificationDAO;

    /* JADX INFO: renamed from: uninstallTimestampDAO$delegate, reason: from kotlin metadata */
    private final Lazy uninstallTimestampDAO;
    private volatile UserEventLogDAO userEventLogDao;

    /* JADX INFO: renamed from: userProfileDAO$delegate, reason: from kotlin metadata */
    private final Lazy userProfileDAO;

    public DBAdapter(Context context, String databaseName, String accountId, ILogger logger, DBEncryptionHandler dbEncryptionHandler, Clock clock) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(databaseName, "databaseName");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(dbEncryptionHandler, "dbEncryptionHandler");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.accountId = accountId;
        this.logger = logger;
        this.dbEncryptionHandler = dbEncryptionHandler;
        this.clock = clock;
        this.dbHelper = new DatabaseHelper(context, accountId, databaseName, logger);
        this.eventDAO = LazyKt.lazy(new Function0() { // from class: com.clevertap.android.sdk.db.DBAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DBAdapter.eventDAO_delegate$lambda$0(this.f$0);
            }
        });
        this.inboxMessageDAO = LazyKt.lazy(new Function0() { // from class: com.clevertap.android.sdk.db.DBAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DBAdapter.inboxMessageDAO_delegate$lambda$1(this.f$0);
            }
        });
        this.userProfileDAO = LazyKt.lazy(new Function0() { // from class: com.clevertap.android.sdk.db.DBAdapter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DBAdapter.userProfileDAO_delegate$lambda$2(this.f$0);
            }
        });
        this.pushNotificationDAO = LazyKt.lazy(new Function0() { // from class: com.clevertap.android.sdk.db.DBAdapter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DBAdapter.pushNotificationDAO_delegate$lambda$3(this.f$0);
            }
        });
        this.uninstallTimestampDAO = LazyKt.lazy(new Function0() { // from class: com.clevertap.android.sdk.db.DBAdapter$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DBAdapter.uninstallTimestampDAO_delegate$lambda$4(this.f$0);
            }
        });
    }

    public /* synthetic */ DBAdapter(Context context, String str, String str2, ILogger iLogger, DBEncryptionHandler dBEncryptionHandler, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, str2, iLogger, dBEncryptionHandler, (i & 32) != 0 ? Clock.SYSTEM : clock);
    }

    /* JADX INFO: compiled from: DBAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/clevertap/android/sdk/db/DBAdapter$Companion;", "", "<init>", "()V", "DB_UPDATE_ERROR", "", "DB_OUT_OF_MEMORY_ERROR", "NOT_ENOUGH_SPACE_LOG", "", "DATABASE_NAME", "getDatabaseName", "config", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getDatabaseName(CleverTapInstanceConfig config) {
            Intrinsics.checkNotNullParameter(config, "config");
            return config.isDefaultInstance() ? DBAdapter.DATABASE_NAME : "clevertap_" + config.getAccountId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventDAOImpl eventDAO_delegate$lambda$0(DBAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return new EventDAOImpl(this$0.dbHelper, this$0.logger, this$0.dbEncryptionHandler, this$0.clock);
    }

    private final EventDAO getEventDAO() {
        return (EventDAO) this.eventDAO.getValue();
    }

    private final InboxMessageDAO getInboxMessageDAO() {
        return (InboxMessageDAO) this.inboxMessageDAO.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InboxMessageDAOImpl inboxMessageDAO_delegate$lambda$1(DBAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return new InboxMessageDAOImpl(this$0.dbHelper, this$0.logger, this$0.dbEncryptionHandler);
    }

    private final UserProfileDAO getUserProfileDAO() {
        return (UserProfileDAO) this.userProfileDAO.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UserProfileDAOImpl userProfileDAO_delegate$lambda$2(DBAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return new UserProfileDAOImpl(this$0.dbHelper, this$0.logger, this$0.dbEncryptionHandler);
    }

    private final PushNotificationDAO getPushNotificationDAO() {
        return (PushNotificationDAO) this.pushNotificationDAO.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PushNotificationDAOImpl pushNotificationDAO_delegate$lambda$3(DBAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return new PushNotificationDAOImpl(this$0.dbHelper, this$0.logger, this$0.clock);
    }

    private final UninstallTimestampDAO getUninstallTimestampDAO() {
        return (UninstallTimestampDAO) this.uninstallTimestampDAO.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UninstallTimestampDAOImpl uninstallTimestampDAO_delegate$lambda$4(DBAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return new UninstallTimestampDAOImpl(this$0.dbHelper, this$0.logger, null, 4, null);
    }

    public final synchronized long storeObject(JSONObject obj, Table table) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(table, "table");
        return getEventDAO().storeEvent(obj, table);
    }

    public final synchronized QueueData fetchEvents(Table table, int limit) {
        Intrinsics.checkNotNullParameter(table, "table");
        return getEventDAO().fetchEvents(table, limit);
    }

    public final synchronized QueueData fetchCombinedEvents(int batchSize) {
        return getEventDAO().fetchCombinedEvents(batchSize);
    }

    public final synchronized void cleanupEventsFromLastId(String lastId, Table table) {
        Intrinsics.checkNotNullParameter(lastId, "lastId");
        Intrinsics.checkNotNullParameter(table, "table");
        getEventDAO().cleanupEventsFromLastId(lastId, table);
    }

    public final synchronized void cleanupStaleEvents(Table table) {
        Intrinsics.checkNotNullParameter(table, "table");
        getEventDAO().cleanupStaleEvents(table);
    }

    public final synchronized void removeEvents(Table table) {
        Intrinsics.checkNotNullParameter(table, "table");
        getEventDAO().removeAllEvents(table);
    }

    public final int migrateEventsData(Table table) {
        Intrinsics.checkNotNullParameter(table, "table");
        return getEventDAO().updateAllEvents(table);
    }

    public final synchronized ArrayList<CTMessageDAO> getMessages(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return getInboxMessageDAO().getMessages(userId);
    }

    public final synchronized void upsertMessages(List<? extends CTMessageDAO> inboxMessages) {
        Intrinsics.checkNotNullParameter(inboxMessages, "inboxMessages");
        getInboxMessageDAO().upsertMessages(inboxMessages);
    }

    public final synchronized boolean deleteMessageForId(String messageId, String userId) {
        return (messageId == null || userId == null) ? false : getInboxMessageDAO().deleteMessage(messageId, userId);
    }

    public final synchronized boolean deleteMessagesForIDs(List<String> messageIDs, String userId) {
        boolean zDeleteMessages;
        zDeleteMessages = false;
        if (messageIDs != null && userId != null) {
            List<String> listFilterNotNull = CollectionsKt.filterNotNull(messageIDs);
            if (!listFilterNotNull.isEmpty()) {
                zDeleteMessages = getInboxMessageDAO().deleteMessages(listFilterNotNull, userId);
            }
        }
        return zDeleteMessages;
    }

    public final synchronized boolean markReadMessageForId(String messageId, String userId) {
        return (messageId == null || userId == null) ? false : getInboxMessageDAO().markMessageAsRead(messageId, userId);
    }

    public final synchronized boolean markReadMessagesForIds(List<String> messageIDs, String userId) {
        boolean zMarkMessagesAsRead;
        zMarkMessagesAsRead = false;
        if (messageIDs != null && userId != null) {
            List<String> listFilterNotNull = CollectionsKt.filterNotNull(messageIDs);
            if (!listFilterNotNull.isEmpty()) {
                zMarkMessagesAsRead = getInboxMessageDAO().markMessagesAsRead(listFilterNotNull, userId);
            }
        }
        return zMarkMessagesAsRead;
    }

    public final synchronized long storeUserProfile(String id, String deviceId, JSONObject obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        return (id == null || deviceId == null) ? -1L : getUserProfileDAO().storeUserProfile(id, deviceId, obj);
    }

    public final synchronized Map<String, JSONObject> fetchUserProfilesByAccountId(String accountId) {
        Map<String, JSONObject> mapEmptyMap;
        if (accountId != null) {
            mapEmptyMap = getUserProfileDAO().fetchUserProfilesByAccountId(accountId);
        } else {
            mapEmptyMap = MapsKt.emptyMap();
        }
        return mapEmptyMap;
    }

    public final synchronized JSONObject fetchUserProfileByAccountIdAndDeviceID(String accountId, String deviceId) {
        return (accountId == null || deviceId == null) ? null : getUserProfileDAO().fetchUserProfile(accountId, deviceId);
    }

    public final synchronized void storePushNotificationId(String id, long ttlInSeconds) {
        Intrinsics.checkNotNullParameter(id, "id");
        getPushNotificationDAO().storePushNotificationId(id, ttlInSeconds);
    }

    public final synchronized String[] fetchPushNotificationIds() {
        return getPushNotificationDAO().fetchPushNotificationIds();
    }

    public final synchronized boolean doesPushNotificationIdExist(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return getPushNotificationDAO().doesPushNotificationIdExist(id);
    }

    public final synchronized void updatePushNotificationIds(String[] ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        getPushNotificationDAO().updatePushNotificationIds(ids);
    }

    public final synchronized void cleanUpPushNotifications() {
        getPushNotificationDAO().cleanUpPushNotifications();
    }

    public final synchronized void storeUninstallTimestamp() {
        getUninstallTimestampDAO().storeUninstallTimestamp();
    }

    public final synchronized long getLastUninstallTimestamp() {
        return getUninstallTimestampDAO().getLastUninstallTimestamp();
    }

    public final UserEventLogDAO userEventLogDAO() {
        UserEventLogDAOImpl userEventLogDAOImpl;
        UserEventLogDAO userEventLogDAO = this.userEventLogDao;
        if (userEventLogDAO != null) {
            return userEventLogDAO;
        }
        synchronized (this) {
            userEventLogDAOImpl = this.userEventLogDao;
            if (userEventLogDAOImpl == null) {
                UserEventLogDAOImpl userEventLogDAOImpl2 = new UserEventLogDAOImpl(this.dbHelper, this.logger, Table.USER_EVENT_LOGS_TABLE);
                this.userEventLogDao = userEventLogDAOImpl2;
                userEventLogDAOImpl = userEventLogDAOImpl2;
            }
        }
        return userEventLogDAOImpl;
    }

    public final DelayedLegacyInAppDAO delayedLegacyInAppDAO() {
        DelayedLegacyInAppDAOImpl delayedLegacyInAppDAOImpl;
        DelayedLegacyInAppDAO delayedLegacyInAppDAO = this.delayedLegacyInAppDao;
        if (delayedLegacyInAppDAO != null) {
            return delayedLegacyInAppDAO;
        }
        synchronized (this) {
            delayedLegacyInAppDAOImpl = this.delayedLegacyInAppDao;
            if (delayedLegacyInAppDAOImpl == null) {
                DelayedLegacyInAppDAOImpl delayedLegacyInAppDAOImpl2 = new DelayedLegacyInAppDAOImpl(this.dbHelper, this.logger, Table.DELAYED_LEGACY_INAPPS, null, 8, null);
                this.delayedLegacyInAppDao = delayedLegacyInAppDAOImpl2;
                delayedLegacyInAppDAOImpl = delayedLegacyInAppDAOImpl2;
            }
        }
        return delayedLegacyInAppDAOImpl;
    }

    public final void deleteDB$clevertap_core_release() {
        this.dbHelper.deleteDatabase();
    }
}
