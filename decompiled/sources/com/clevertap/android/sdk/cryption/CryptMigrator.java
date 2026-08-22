package com.clevertap.android.sdk.cryption;

import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.ILogger;
import com.clevertap.android.sdk.cryption.CryptHandler;
import com.clevertap.android.sdk.db.DBAdapter;
import com.clevertap.android.sdk.db.Table;
import com.clevertap.android.sdk.utils.JsonUtilsKt;
import com.clevertap.android.sdk.variables.repo.VariablesRepo;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: CryptMigrator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0080\b\u0018\u0000 >2\u00020\u0001:\u0001>BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\u0018\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0017H\u0002J\b\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0003H\u0002J \u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010&\u001a\u00020\u0003H\u0002J\u0018\u0010+\u001a\u00020%2\u0006\u0010*\u001a\u00020)2\u0006\u0010&\u001a\u00020\u0003H\u0002J\u0018\u0010,\u001a\u00020%2\u0006\u0010*\u001a\u00020)2\u0006\u0010&\u001a\u00020\u0003H\u0002J\u0018\u0010-\u001a\u00020%2\u0006\u0010*\u001a\u00020)2\u0006\u0010&\u001a\u00020\u0003H\u0002J\u0010\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\u0017H\u0002J\u0010\u00100\u001a\u00020)2\u0006\u0010&\u001a\u00020\u0003H\u0002J\t\u00101\u001a\u00020\u0003HÂ\u0003J\t\u00102\u001a\u00020\u0005HÂ\u0003J\t\u00103\u001a\u00020\u0007HÂ\u0003J\t\u00104\u001a\u00020\tHÂ\u0003J\t\u00105\u001a\u00020\u000bHÂ\u0003J\t\u00106\u001a\u00020\rHÂ\u0003J\t\u00107\u001a\u00020\u000fHÂ\u0003J\t\u00108\u001a\u00020\u0011HÂ\u0003JY\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u0010:\u001a\u00020\u00172\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0005HÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/clevertap/android/sdk/cryption/CryptMigrator;", "", "logPrefix", "", "configEncryptionLevel", "", "logger", "Lcom/clevertap/android/sdk/ILogger;", "cryptHandler", "Lcom/clevertap/android/sdk/cryption/ICryptHandler;", "cryptRepository", "Lcom/clevertap/android/sdk/cryption/CryptRepository;", "dataMigrationRepository", "Lcom/clevertap/android/sdk/cryption/DataMigrationRepository;", "variablesRepo", "Lcom/clevertap/android/sdk/variables/repo/VariablesRepo;", "dbAdapter", "Lcom/clevertap/android/sdk/db/DBAdapter;", "<init>", "(Ljava/lang/String;ILcom/clevertap/android/sdk/ILogger;Lcom/clevertap/android/sdk/cryption/ICryptHandler;Lcom/clevertap/android/sdk/cryption/CryptRepository;Lcom/clevertap/android/sdk/cryption/DataMigrationRepository;Lcom/clevertap/android/sdk/variables/repo/VariablesRepo;Lcom/clevertap/android/sdk/db/DBAdapter;)V", "migrateEncryption", "", "handleAllMigrations", "", FirebaseAnalytics.Param.LEVEL, "Lcom/clevertap/android/sdk/cryption/EncryptionLevel;", "storedLevel", "firstUpgrade", "migrateVariablesData", "migrateInboxData", "migrateEventsData", "migrateCachedGuidsKeyPref", "convertCachedGuidsToPlainText", "Lorg/json/JSONObject;", "migrateDBProfile", "migrateInAppData", "performMigrationStep", "Lcom/clevertap/android/sdk/cryption/MigrationResult;", "data", "transitionEncryptionState", "currentState", "Lcom/clevertap/android/sdk/cryption/EncryptionState;", "targetState", "handleEncryptedAesTransition", "handleEncryptedAesGcmTransition", "handlePlainTextTransition", "getFinalEncryptionState", "encrypt", "getCurrentEncryptionState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", Constants.COPY_TYPE, "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class CryptMigrator {
    public static final String MIGRATION_FAILURE_COUNT_KEY = "encryptionMigrationFailureCount";
    public static final int MIGRATION_FIRST_UPGRADE = -1;
    public static final int MIGRATION_NEEDED = 1;
    public static final int MIGRATION_NOT_NEEDED = 0;
    public static final String SS_IN_APP_MIGRATED = "ssInAppMigrated";
    public static final int UNKNOWN_LEVEL = -1;
    private final int configEncryptionLevel;
    private final ICryptHandler cryptHandler;
    private final CryptRepository cryptRepository;
    private final DataMigrationRepository dataMigrationRepository;
    private final DBAdapter dbAdapter;
    private final String logPrefix;
    private final ILogger logger;
    private final VariablesRepo variablesRepo;

    /* JADX INFO: compiled from: CryptMigrator.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EncryptionState.values().length];
            try {
                iArr[EncryptionState.ENCRYPTED_AES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EncryptionState.ENCRYPTED_AES_GCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EncryptionState.PLAIN_TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final String getLogPrefix() {
        return this.logPrefix;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final int getConfigEncryptionLevel() {
        return this.configEncryptionLevel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final ILogger getLogger() {
        return this.logger;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final ICryptHandler getCryptHandler() {
        return this.cryptHandler;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    private final CryptRepository getCryptRepository() {
        return this.cryptRepository;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    private final DataMigrationRepository getDataMigrationRepository() {
        return this.dataMigrationRepository;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    private final VariablesRepo getVariablesRepo() {
        return this.variablesRepo;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    private final DBAdapter getDbAdapter() {
        return this.dbAdapter;
    }

    public static /* synthetic */ CryptMigrator copy$default(CryptMigrator cryptMigrator, String str, int i, ILogger iLogger, ICryptHandler iCryptHandler, CryptRepository cryptRepository, DataMigrationRepository dataMigrationRepository, VariablesRepo variablesRepo, DBAdapter dBAdapter, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cryptMigrator.logPrefix;
        }
        if ((i2 & 2) != 0) {
            i = cryptMigrator.configEncryptionLevel;
        }
        if ((i2 & 4) != 0) {
            iLogger = cryptMigrator.logger;
        }
        if ((i2 & 8) != 0) {
            iCryptHandler = cryptMigrator.cryptHandler;
        }
        if ((i2 & 16) != 0) {
            cryptRepository = cryptMigrator.cryptRepository;
        }
        if ((i2 & 32) != 0) {
            dataMigrationRepository = cryptMigrator.dataMigrationRepository;
        }
        if ((i2 & 64) != 0) {
            variablesRepo = cryptMigrator.variablesRepo;
        }
        if ((i2 & 128) != 0) {
            dBAdapter = cryptMigrator.dbAdapter;
        }
        VariablesRepo variablesRepo2 = variablesRepo;
        DBAdapter dBAdapter2 = dBAdapter;
        CryptRepository cryptRepository2 = cryptRepository;
        DataMigrationRepository dataMigrationRepository2 = dataMigrationRepository;
        return cryptMigrator.copy(str, i, iLogger, iCryptHandler, cryptRepository2, dataMigrationRepository2, variablesRepo2, dBAdapter2);
    }

    public final CryptMigrator copy(String logPrefix, int configEncryptionLevel, ILogger logger, ICryptHandler cryptHandler, CryptRepository cryptRepository, DataMigrationRepository dataMigrationRepository, VariablesRepo variablesRepo, DBAdapter dbAdapter) {
        Intrinsics.checkNotNullParameter(logPrefix, "logPrefix");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(cryptHandler, "cryptHandler");
        Intrinsics.checkNotNullParameter(cryptRepository, "cryptRepository");
        Intrinsics.checkNotNullParameter(dataMigrationRepository, "dataMigrationRepository");
        Intrinsics.checkNotNullParameter(variablesRepo, "variablesRepo");
        Intrinsics.checkNotNullParameter(dbAdapter, "dbAdapter");
        return new CryptMigrator(logPrefix, configEncryptionLevel, logger, cryptHandler, cryptRepository, dataMigrationRepository, variablesRepo, dbAdapter);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CryptMigrator)) {
            return false;
        }
        CryptMigrator cryptMigrator = (CryptMigrator) other;
        return Intrinsics.areEqual(this.logPrefix, cryptMigrator.logPrefix) && this.configEncryptionLevel == cryptMigrator.configEncryptionLevel && Intrinsics.areEqual(this.logger, cryptMigrator.logger) && Intrinsics.areEqual(this.cryptHandler, cryptMigrator.cryptHandler) && Intrinsics.areEqual(this.cryptRepository, cryptMigrator.cryptRepository) && Intrinsics.areEqual(this.dataMigrationRepository, cryptMigrator.dataMigrationRepository) && Intrinsics.areEqual(this.variablesRepo, cryptMigrator.variablesRepo) && Intrinsics.areEqual(this.dbAdapter, cryptMigrator.dbAdapter);
    }

    public int hashCode() {
        return (((((((((((((this.logPrefix.hashCode() * 31) + Integer.hashCode(this.configEncryptionLevel)) * 31) + this.logger.hashCode()) * 31) + this.cryptHandler.hashCode()) * 31) + this.cryptRepository.hashCode()) * 31) + this.dataMigrationRepository.hashCode()) * 31) + this.variablesRepo.hashCode()) * 31) + this.dbAdapter.hashCode();
    }

    public String toString() {
        return "CryptMigrator(logPrefix=" + this.logPrefix + ", configEncryptionLevel=" + this.configEncryptionLevel + ", logger=" + this.logger + ", cryptHandler=" + this.cryptHandler + ", cryptRepository=" + this.cryptRepository + ", dataMigrationRepository=" + this.dataMigrationRepository + ", variablesRepo=" + this.variablesRepo + ", dbAdapter=" + this.dbAdapter + ')';
    }

    public CryptMigrator(String logPrefix, int i, ILogger logger, ICryptHandler cryptHandler, CryptRepository cryptRepository, DataMigrationRepository dataMigrationRepository, VariablesRepo variablesRepo, DBAdapter dbAdapter) {
        Intrinsics.checkNotNullParameter(logPrefix, "logPrefix");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(cryptHandler, "cryptHandler");
        Intrinsics.checkNotNullParameter(cryptRepository, "cryptRepository");
        Intrinsics.checkNotNullParameter(dataMigrationRepository, "dataMigrationRepository");
        Intrinsics.checkNotNullParameter(variablesRepo, "variablesRepo");
        Intrinsics.checkNotNullParameter(dbAdapter, "dbAdapter");
        this.logPrefix = logPrefix;
        this.configEncryptionLevel = i;
        this.logger = logger;
        this.cryptHandler = cryptHandler;
        this.cryptRepository = cryptRepository;
        this.dataMigrationRepository = dataMigrationRepository;
        this.variablesRepo = variablesRepo;
        this.dbAdapter = dbAdapter;
    }

    public final void migrateEncryption() {
        int iStoredEncryptionLevel = this.cryptRepository.storedEncryptionLevel();
        int iMigrationFailureCount = this.cryptRepository.migrationFailureCount();
        boolean zIsSSInAppDataMigrated = this.cryptRepository.isSSInAppDataMigrated();
        if (!zIsSSInAppDataMigrated || (iStoredEncryptionLevel != this.configEncryptionLevel && iMigrationFailureCount != -1)) {
            iMigrationFailureCount = 1;
        }
        if (iMigrationFailureCount == 0) {
            this.logger.verbose(this.logPrefix, "Migration not required: config-encryption-level " + this.configEncryptionLevel + ", stored-encryption-level " + iStoredEncryptionLevel);
            return;
        }
        this.logger.verbose(this.logPrefix, "Starting migration from encryption level " + iStoredEncryptionLevel + " to " + this.configEncryptionLevel + " with migrationFailureCount " + iMigrationFailureCount + " and isSSInAppDataMigrated " + zIsSSInAppDataMigrated);
        boolean zHandleAllMigrations = handleAllMigrations(EncryptionLevel.INSTANCE.fromInt(this.configEncryptionLevel), EncryptionLevel.INSTANCE.fromInt(iStoredEncryptionLevel), iMigrationFailureCount == -1);
        if (zHandleAllMigrations) {
            this.cryptRepository.updateEncryptionLevel(this.configEncryptionLevel);
        }
        this.cryptRepository.updateIsSSInAppDataMigrated(zHandleAllMigrations);
        this.cryptRepository.updateMigrationFailureCount(zHandleAllMigrations);
    }

    private final boolean handleAllMigrations(EncryptionLevel level, EncryptionLevel storedLevel, boolean firstUpgrade) {
        boolean zMigrateCachedGuidsKeyPref = migrateCachedGuidsKeyPref(level, firstUpgrade);
        boolean zMigrateDBProfile = migrateDBProfile(level);
        boolean zMigrateInAppData = migrateInAppData(level);
        if (EncryptionLevel.FULL_DATA == storedLevel || EncryptionLevel.FULL_DATA == level) {
            migrateVariablesData();
            migrateInboxData();
            migrateEventsData();
        }
        return zMigrateCachedGuidsKeyPref && zMigrateDBProfile && zMigrateInAppData;
    }

    private final boolean migrateVariablesData() {
        String strLoadDataFromCache = this.variablesRepo.loadDataFromCache();
        if (strLoadDataFromCache != null) {
            this.variablesRepo.storeDataInCache(strLoadDataFromCache);
            return true;
        }
        this.logger.verbose("Skipping variable migration as there is no data");
        return true;
    }

    private final boolean migrateInboxData() {
        Map<String, JSONObject> mapUserProfilesInAccount = this.dataMigrationRepository.userProfilesInAccount();
        ArrayList arrayList = new ArrayList(mapUserProfilesInAccount.size());
        Iterator<Map.Entry<String, JSONObject>> it = mapUserProfilesInAccount.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getKey());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.dbAdapter.upsertMessages(this.dbAdapter.getMessages((String) it2.next()));
        }
        return true;
    }

    private final void migrateEventsData() {
        DBAdapter dBAdapter = this.dbAdapter;
        dBAdapter.migrateEventsData(Table.EVENTS);
        dBAdapter.migrateEventsData(Table.PROFILE_EVENTS);
    }

    private final boolean migrateCachedGuidsKeyPref(EncryptionLevel level, boolean firstUpgrade) {
        String strCachedGuidString;
        this.logger.verbose(this.logPrefix, "Migrating encryption level for cachedGUIDsKey prefs");
        if (firstUpgrade) {
            JSONObject jSONObjectConvertCachedGuidsToPlainText = convertCachedGuidsToPlainText();
            int length = jSONObjectConvertCachedGuidsToPlainText.length();
            this.dataMigrationRepository.saveCachedGuidJsonLength(length);
            if (length == 0) {
                this.dataMigrationRepository.removeCachedGuidJson();
                return true;
            }
            strCachedGuidString = jSONObjectConvertCachedGuidsToPlainText.toString();
            Intrinsics.checkNotNull(strCachedGuidString);
        } else {
            strCachedGuidString = this.dataMigrationRepository.cachedGuidString();
            if (strCachedGuidString == null) {
                return true;
            }
        }
        MigrationResult migrationResultPerformMigrationStep = performMigrationStep(level, strCachedGuidString);
        this.dataMigrationRepository.saveCachedGuidJson(migrationResultPerformMigrationStep.getData());
        this.logger.verbose(this.logPrefix, "Cached GUIDs migrated with success = " + migrationResultPerformMigrationStep + ".migrationSuccessful = " + migrationResultPerformMigrationStep.getData());
        return migrationResultPerformMigrationStep.getMigrationSuccessful();
    }

    private final JSONObject convertCachedGuidsToPlainText() {
        JSONObject jSONObjectCachedGuidJsonObject = this.dataMigrationRepository.cachedGuidJsonObject();
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<String> itKeys = jSONObjectCachedGuidJsonObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Intrinsics.checkNotNull(next);
                List listSplit$default = StringsKt.split$default((CharSequence) next, new String[]{"_"}, false, 2, 2, (Object) null);
                String str = (String) listSplit$default.get(0);
                MigrationResult migrationResultPerformMigrationStep = performMigrationStep(EncryptionLevel.NONE, (String) listSplit$default.get(1));
                if (migrationResultPerformMigrationStep.getMigrationSuccessful()) {
                    jSONObject.put(str + '_' + migrationResultPerformMigrationStep.getData(), jSONObjectCachedGuidJsonObject.get(next));
                }
            }
            return jSONObject;
        } catch (Throwable th) {
            this.logger.verbose(this.logPrefix, "Error migrating format for cached GUIDs: Clearing and starting fresh " + th);
            return jSONObject;
        }
    }

    private final boolean migrateDBProfile(EncryptionLevel level) {
        this.logger.verbose(this.logPrefix, "Migrating encryption level for user profiles in DB");
        boolean z = true;
        for (Map.Entry<String, JSONObject> entry : this.dataMigrationRepository.userProfilesInAccount().entrySet()) {
            String key = entry.getKey();
            JSONObject value = entry.getValue();
            try {
                HashSet<String> piiDBKeys = Constants.piiDBKeys;
                Intrinsics.checkNotNullExpressionValue(piiDBKeys, "piiDBKeys");
                for (String str : piiDBKeys) {
                    Intrinsics.checkNotNull(str);
                    String stringOrNull = JsonUtilsKt.getStringOrNull(value, str);
                    if (stringOrNull != null) {
                        MigrationResult migrationResultPerformMigrationStep = performMigrationStep(EncryptionLevel.FULL_DATA == level ? EncryptionLevel.NONE : level, stringOrNull);
                        z = z && migrationResultPerformMigrationStep.getMigrationSuccessful();
                        value.put(str, migrationResultPerformMigrationStep.getData());
                    }
                }
                this.logger.verbose(this.logPrefix, "DB migrated with success = " + z + " = " + value);
            } catch (Exception e2) {
                this.logger.verbose(this.logPrefix, "Error migrating profile " + key + ": " + e2);
            }
            if (this.dataMigrationRepository.saveUserProfile(key, value) <= -1) {
                z = false;
            }
        }
        return z;
    }

    private final boolean migrateInAppData(final EncryptionLevel level) {
        this.logger.verbose(this.logPrefix, "Migrating encryption for InAppData");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        this.dataMigrationRepository.inAppDataFiles(CollectionsKt.listOf((Object[]) new String[]{"inapp_notifs_cs", Constants.INAPP_KEY}), new Function1() { // from class: com.clevertap.android.sdk.cryption.CryptMigrator$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CryptMigrator.migrateInAppData$lambda$4(this.f$0, level, booleanRef, (String) obj);
            }
        });
        return booleanRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String migrateInAppData$lambda$4(CryptMigrator this$0, EncryptionLevel level, Ref.BooleanRef migrationSuccessful, String spData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(level, "$level");
        Intrinsics.checkNotNullParameter(migrationSuccessful, "$migrationSuccessful");
        Intrinsics.checkNotNullParameter(spData, "spData");
        MigrationResult migrationResultPerformMigrationStep = this$0.performMigrationStep(level, spData);
        migrationSuccessful.element = migrationSuccessful.element && migrationResultPerformMigrationStep.getMigrationSuccessful();
        return migrationResultPerformMigrationStep.getData();
    }

    private final MigrationResult performMigrationStep(EncryptionLevel level, String data) {
        return transitionEncryptionState(getCurrentEncryptionState(data), getFinalEncryptionState(level.shouldEncrypt()), data);
    }

    private final MigrationResult transitionEncryptionState(EncryptionState currentState, EncryptionState targetState, String data) {
        if (currentState == targetState) {
            return new MigrationResult(data, true);
        }
        int i = WhenMappings.$EnumSwitchMapping$0[currentState.ordinal()];
        if (i == 1) {
            return handleEncryptedAesTransition(targetState, data);
        }
        if (i == 2) {
            return handleEncryptedAesGcmTransition(targetState, data);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return handlePlainTextTransition(targetState, data);
    }

    private final MigrationResult handleEncryptedAesTransition(EncryptionState targetState, String data) {
        String strDecryptWithAlgorithm = this.cryptHandler.decryptWithAlgorithm(data, CryptHandler.EncryptionAlgorithm.AES);
        int i = WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()];
        if (i != 2) {
            if (i == 3) {
                if (strDecryptWithAlgorithm != null) {
                    data = strDecryptWithAlgorithm;
                }
                return new MigrationResult(data, strDecryptWithAlgorithm != null);
            }
            this.logger.verbose(this.logPrefix, "Invalid transition from ENCRYPTED_AES to " + targetState);
            return MigrationResult.INSTANCE.failure(data);
        }
        String strEncrypt = strDecryptWithAlgorithm != null ? this.cryptHandler.encrypt(strDecryptWithAlgorithm) : null;
        String str = strEncrypt == null ? strDecryptWithAlgorithm : strEncrypt;
        if (strEncrypt == null && strDecryptWithAlgorithm != null) {
            z = false;
        }
        return new MigrationResult(str, z);
    }

    private final MigrationResult handleEncryptedAesGcmTransition(EncryptionState targetState, String data) {
        String strDecrypt = this.cryptHandler.decrypt(data);
        if (WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()] == 3) {
            if (strDecrypt != null) {
                data = strDecrypt;
            }
            return new MigrationResult(data, strDecrypt != null);
        }
        this.logger.verbose(this.logPrefix, "Invalid transition from ENCRYPTED_AES_GCM to " + targetState);
        return MigrationResult.INSTANCE.failure(data);
    }

    private final MigrationResult handlePlainTextTransition(EncryptionState targetState, String data) {
        if (WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()] == 2) {
            String strEncrypt = this.cryptHandler.encrypt(data);
            if (strEncrypt != null) {
                data = strEncrypt;
            }
            return new MigrationResult(data, strEncrypt != null);
        }
        this.logger.verbose(this.logPrefix, "Invalid transition from PLAIN_TEXT to " + targetState);
        return MigrationResult.INSTANCE.failure(data);
    }

    private final EncryptionState getFinalEncryptionState(boolean encrypt) {
        if (encrypt) {
            return EncryptionState.ENCRYPTED_AES_GCM;
        }
        return EncryptionState.PLAIN_TEXT;
    }

    private final EncryptionState getCurrentEncryptionState(String data) {
        return CryptHandler.INSTANCE.isTextAESEncrypted(data) ? EncryptionState.ENCRYPTED_AES : CryptHandler.INSTANCE.isTextAESGCMEncrypted(data) ? EncryptionState.ENCRYPTED_AES_GCM : EncryptionState.PLAIN_TEXT;
    }
}
