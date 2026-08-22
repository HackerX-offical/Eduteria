package com.clevertap.android.sdk.network;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.billingclient.api.BillingFlowParams;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.StorageHelper;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: ArpRepo.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0010J\"\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/clevertap/android/sdk/network/ArpRepo;", "", BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "", "logger", "Lcom/clevertap/android/sdk/Logger;", "deviceInfo", "Lcom/clevertap/android/sdk/DeviceInfo;", "<init>", "(Ljava/lang/String;Lcom/clevertap/android/sdk/Logger;Lcom/clevertap/android/sdk/DeviceInfo;)V", "newNamespaceARPKey", "getNewNamespaceARPKey", "()Ljava/lang/String;", "namespaceARPKey", "getNamespaceARPKey", "getARP", "Lorg/json/JSONObject;", "context", "Landroid/content/Context;", "handleARPUpdate", "", "arp", "migrateARPToNewNameSpace", "Landroid/content/SharedPreferences;", "newKey", "oldKey", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ArpRepo {
    private final String accountId;
    private final DeviceInfo deviceInfo;
    private final Logger logger;

    public ArpRepo(String accountId, Logger logger, DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        this.accountId = accountId;
        this.logger = logger;
        this.deviceInfo = deviceInfo;
    }

    private final String getNewNamespaceARPKey() {
        String str = this.accountId;
        if (str == null) {
            return null;
        }
        this.logger.verbose(str, "New ARP Key = ARP:" + str + ':' + this.deviceInfo.getDeviceID());
        return "ARP:" + str + ':' + this.deviceInfo.getDeviceID();
    }

    private final String getNamespaceARPKey() {
        String str = this.accountId;
        if (str == null) {
            return null;
        }
        this.logger.verbose(str, "Old ARP Key = ARP:" + str);
        return "ARP:" + str;
    }

    public final JSONObject getARP(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            String newNamespaceARPKey = getNewNamespaceARPKey();
            if (newNamespaceARPKey == null) {
                return null;
            }
            SharedPreferences preferences = StorageHelper.getPreferences(context, newNamespaceARPKey);
            Map<String, ?> all = preferences.getAll();
            Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
            if (all.isEmpty()) {
                preferences = migrateARPToNewNameSpace(context, newNamespaceARPKey, getNamespaceARPKey());
            }
            Map<String, ?> all2 = preferences.getAll();
            Iterator<Map.Entry<String, ?>> it = all2.entrySet().iterator();
            while (it.hasNext()) {
                Object value = it.next().getValue();
                Intrinsics.checkNotNull(value);
                if ((value instanceof Number) && ((Number) value).intValue() == -1) {
                    it.remove();
                }
            }
            JSONObject jSONObject = new JSONObject(all2);
            this.logger.verbose(this.accountId, "Fetched ARP for namespace key: " + newNamespaceARPKey + " values: " + all2);
            return jSONObject;
        } catch (Exception e2) {
            this.logger.verbose(this.accountId, "Failed to construct ARP object", e2);
            return null;
        }
    }

    public final void handleARPUpdate(Context context, JSONObject arp) {
        String newNamespaceARPKey;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(arp, "arp");
        if (arp.length() == 0 || (newNamespaceARPKey = getNewNamespaceARPKey()) == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = StorageHelper.getPreferences(context, newNamespaceARPKey).edit();
        Iterator<String> itKeys = arp.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                Object obj = arp.get(next);
                if (obj instanceof Number) {
                    editorEdit.putInt(next, ((Number) obj).intValue());
                } else if (obj instanceof String) {
                    if (((String) obj).length() < 100) {
                        editorEdit.putString(next, (String) obj);
                    } else {
                        this.logger.verbose(this.accountId, "ARP update for key " + next + " rejected (string value too long)");
                        Unit unit = Unit.INSTANCE;
                    }
                } else if (obj instanceof Boolean) {
                    editorEdit.putBoolean(next, ((Boolean) obj).booleanValue());
                } else {
                    this.logger.verbose(this.accountId, "ARP update for key " + next + " rejected (invalid data type)");
                    Unit unit2 = Unit.INSTANCE;
                }
            } catch (Exception unused) {
            }
        }
        this.logger.verbose(this.accountId, "Stored ARP for namespace key: " + newNamespaceARPKey + " values: " + arp);
        Intrinsics.checkNotNull(editorEdit);
        StorageHelper.persist(editorEdit);
    }

    private final SharedPreferences migrateARPToNewNameSpace(Context context, String newKey, String oldKey) {
        SharedPreferences preferences = StorageHelper.getPreferences(context, oldKey);
        SharedPreferences preferences2 = StorageHelper.getPreferences(context, newKey);
        SharedPreferences.Editor editorEdit = preferences2.edit();
        Map<String, ?> all = preferences.getAll();
        Intrinsics.checkNotNull(all);
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            Intrinsics.checkNotNull(value);
            if (value instanceof Number) {
                editorEdit.putInt(key, ((Number) value).intValue());
            } else if (value instanceof String) {
                String str = (String) value;
                if (str.length() < 100) {
                    editorEdit.putString(key, str);
                } else {
                    this.logger.verbose(this.accountId, "ARP update for key " + key + " rejected (string value too long)");
                    Unit unit = Unit.INSTANCE;
                }
            } else if (value instanceof Boolean) {
                editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
            } else {
                this.logger.verbose(this.accountId, "ARP update for key " + key + " rejected (invalid data type)");
                Unit unit2 = Unit.INSTANCE;
            }
        }
        this.logger.verbose(this.accountId, "Completed ARP update for namespace key: " + newKey);
        Intrinsics.checkNotNull(editorEdit);
        StorageHelper.persist(editorEdit);
        SharedPreferences.Editor editorEdit2 = preferences.edit();
        editorEdit2.clear();
        editorEdit2.apply();
        return preferences2;
    }
}
