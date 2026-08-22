package com.clevertap.android.sdk.db;

import kotlin.Metadata;
import me.leolin.shortcutbadger.impl.AdwHomeBadger;

/* JADX INFO: compiled from: CtDatabase.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/clevertap/android/sdk/db/Column;", "", "<init>", "()V", "ID", "", "DATA", "CREATED_AT", "IS_READ", "EXPIRES", "TAGS", "USER_ID", "CAMPAIGN", "WZRKPARAMS", "DEVICE_ID", "EVENT_NAME", "NORMALIZED_EVENT_NAME", "FIRST_TS", "LAST_TS", AdwHomeBadger.COUNT, "INAPP_ID", "DELAY", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Column {
    public static final String CAMPAIGN = "campaignId";
    public static final String COUNT = "count";
    public static final String CREATED_AT = "created_at";
    public static final String DATA = "data";
    public static final String DELAY = "delay";
    public static final String DEVICE_ID = "deviceID";
    public static final String EVENT_NAME = "eventName";
    public static final String EXPIRES = "expires";
    public static final String FIRST_TS = "firstTs";
    public static final String ID = "_id";
    public static final String INAPP_ID = "inAppId";
    public static final Column INSTANCE = new Column();
    public static final String IS_READ = "isRead";
    public static final String LAST_TS = "lastTs";
    public static final String NORMALIZED_EVENT_NAME = "normalizedEventName";
    public static final String TAGS = "tags";
    public static final String USER_ID = "messageUser";
    public static final String WZRKPARAMS = "wzrkParams";

    private Column() {
    }
}
