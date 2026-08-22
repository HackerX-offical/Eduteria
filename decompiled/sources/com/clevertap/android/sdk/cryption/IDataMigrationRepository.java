package com.clevertap.android.sdk.cryption;

import com.clevertap.android.sdk.db.Column;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;
import org.json.JSONObject;

/* JADX INFO: compiled from: DataMigrationRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH&J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0003H&J,\u0010\u0013\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00152\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0017H&¨\u0006\u0018"}, d2 = {"Lcom/clevertap/android/sdk/cryption/IDataMigrationRepository;", "", "cachedGuidJsonObject", "Lorg/json/JSONObject;", "cachedGuidString", "", "saveCachedGuidJson", "", "json", "removeCachedGuidJson", "saveCachedGuidJsonLength", Range.ATTR_LENGTH, "", "userProfilesInAccount", "", "saveUserProfile", "", Column.DEVICE_ID, "profile", "inAppDataFiles", "keysToMigrate", "", "migrate", "Lkotlin/Function1;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IDataMigrationRepository {
    JSONObject cachedGuidJsonObject();

    String cachedGuidString();

    void inAppDataFiles(List<String> keysToMigrate, Function1<? super String, String> migrate);

    void removeCachedGuidJson();

    void saveCachedGuidJson(String json);

    void saveCachedGuidJsonLength(int length);

    long saveUserProfile(String deviceID, JSONObject profile);

    Map<String, JSONObject> userProfilesInAccount();
}
