package com.clevertap.android.sdk.cryption;

import android.content.Context;
import android.content.SharedPreferences;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.StorageHelper;
import com.clevertap.android.sdk.db.Column;
import com.clevertap.android.sdk.db.DBAdapter;
import com.clevertap.android.sdk.utils.CTJsonConverter;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;
import org.json.JSONObject;

/* JADX INFO: compiled from: DataMigrationRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\rH\u0016J,\u0010\u001b\u001a\u00020\u000f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001d2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/clevertap/android/sdk/cryption/DataMigrationRepository;", "Lcom/clevertap/android/sdk/cryption/IDataMigrationRepository;", "context", "Landroid/content/Context;", "config", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "dbAdapter", "Lcom/clevertap/android/sdk/db/DBAdapter;", "<init>", "(Landroid/content/Context;Lcom/clevertap/android/sdk/CleverTapInstanceConfig;Lcom/clevertap/android/sdk/db/DBAdapter;)V", "cachedGuidString", "", "cachedGuidJsonObject", "Lorg/json/JSONObject;", "saveCachedGuidJson", "", "json", "removeCachedGuidJson", "saveCachedGuidJsonLength", Range.ATTR_LENGTH, "", "userProfilesInAccount", "", "saveUserProfile", "", Column.DEVICE_ID, "profile", "inAppDataFiles", "keysToMigrate", "", "migrate", "Lkotlin/Function1;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DataMigrationRepository implements IDataMigrationRepository {
    private final CleverTapInstanceConfig config;
    private final Context context;
    private final DBAdapter dbAdapter;

    public DataMigrationRepository(Context context, CleverTapInstanceConfig config, DBAdapter dbAdapter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(dbAdapter, "dbAdapter");
        this.context = context;
        this.config = config;
        this.dbAdapter = dbAdapter;
    }

    @Override // com.clevertap.android.sdk.cryption.IDataMigrationRepository
    public String cachedGuidString() {
        Context context = this.context;
        String accountId = this.config.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId(...)");
        return StorageHelper.getStringFromPrefs(context, accountId, Constants.CACHED_GUIDS_KEY, null);
    }

    @Override // com.clevertap.android.sdk.cryption.IDataMigrationRepository
    public JSONObject cachedGuidJsonObject() {
        JSONObject jsonObject = CTJsonConverter.toJsonObject(cachedGuidString(), this.config.getLogger(), this.config.getAccountId());
        Intrinsics.checkNotNullExpressionValue(jsonObject, "toJsonObject(...)");
        return jsonObject;
    }

    @Override // com.clevertap.android.sdk.cryption.IDataMigrationRepository
    public void saveCachedGuidJson(String json) {
        Context context = this.context;
        String accountId = this.config.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId(...)");
        StorageHelper.putString(context, accountId, Constants.CACHED_GUIDS_KEY, json);
    }

    @Override // com.clevertap.android.sdk.cryption.IDataMigrationRepository
    public void removeCachedGuidJson() {
        Context context = this.context;
        String accountId = this.config.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId(...)");
        StorageHelper.remove(context, accountId, Constants.CACHED_GUIDS_KEY);
    }

    @Override // com.clevertap.android.sdk.cryption.IDataMigrationRepository
    public void saveCachedGuidJsonLength(int length) {
        Context context = this.context;
        String accountId = this.config.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId(...)");
        StorageHelper.putInt(context, accountId, Constants.CACHED_GUIDS_LENGTH_KEY, length);
    }

    @Override // com.clevertap.android.sdk.cryption.IDataMigrationRepository
    public Map<String, JSONObject> userProfilesInAccount() {
        return this.dbAdapter.fetchUserProfilesByAccountId(this.config.getAccountId());
    }

    @Override // com.clevertap.android.sdk.cryption.IDataMigrationRepository
    public long saveUserProfile(String deviceID, JSONObject profile) {
        Intrinsics.checkNotNullParameter(deviceID, "deviceID");
        Intrinsics.checkNotNullParameter(profile, "profile");
        return this.dbAdapter.storeUserProfile(this.config.getAccountId(), deviceID, profile);
    }

    @Override // com.clevertap.android.sdk.cryption.IDataMigrationRepository
    public void inAppDataFiles(List<String> keysToMigrate, Function1<? super String, String> migrate) {
        Intrinsics.checkNotNullParameter(keysToMigrate, "keysToMigrate");
        Intrinsics.checkNotNullParameter(migrate, "migrate");
        File[] fileArrListFiles = new File(this.context.getApplicationInfo().dataDir, "shared_prefs").listFiles(new FilenameFilter() { // from class: com.clevertap.android.sdk.cryption.DataMigrationRepository$$ExternalSyntheticLambda0
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return DataMigrationRepository.inAppDataFiles$lambda$0(this.f$0, file, str);
            }
        });
        if (fileArrListFiles != null) {
            ArrayList<SharedPreferences> arrayList = new ArrayList(fileArrListFiles.length);
            for (File file : fileArrListFiles) {
                Intrinsics.checkNotNull(file);
                arrayList.add(this.context.getSharedPreferences(FilesKt.getNameWithoutExtension(file), 0));
            }
            for (SharedPreferences sharedPreferences : arrayList) {
                for (String str : keysToMigrate) {
                    String string = sharedPreferences.getString(str, null);
                    if (string != null) {
                        String strInvoke = migrate.invoke(string);
                        Intrinsics.checkNotNull(sharedPreferences);
                        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                        editorEdit.putString(str, strInvoke);
                        editorEdit.apply();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean inAppDataFiles$lambda$0(DataMigrationRepository this$0, File file, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(str);
        return StringsKt.startsWith$default(str, Constants.INAPP_KEY, false, 2, (Object) null) && StringsKt.endsWith$default(str, new StringBuilder().append(this$0.config.getAccountId()).append(".xml").toString(), false, 2, (Object) null);
    }
}
