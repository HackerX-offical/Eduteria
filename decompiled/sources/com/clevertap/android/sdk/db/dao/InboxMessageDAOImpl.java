package com.clevertap.android.sdk.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.clevertap.android.sdk.ILogger;
import com.clevertap.android.sdk.db.Column;
import com.clevertap.android.sdk.db.DBAdapter;
import com.clevertap.android.sdk.db.DBEncryptionHandler;
import com.clevertap.android.sdk.db.DatabaseHelper;
import com.clevertap.android.sdk.db.Table;
import com.clevertap.android.sdk.inbox.CTMessageDAO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: InboxMessageDAOImpl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ%\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\rj\b\u0012\u0004\u0012\u00020\f`\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0014H\u0017J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u001e\u0010\u0018\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u001e\u0010\u001b\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/clevertap/android/sdk/db/dao/InboxMessageDAOImpl;", "Lcom/clevertap/android/sdk/db/dao/InboxMessageDAO;", "dbHelper", "Lcom/clevertap/android/sdk/db/DatabaseHelper;", "logger", "Lcom/clevertap/android/sdk/ILogger;", "dbEncryptionHandler", "Lcom/clevertap/android/sdk/db/DBEncryptionHandler;", "<init>", "(Lcom/clevertap/android/sdk/db/DatabaseHelper;Lcom/clevertap/android/sdk/ILogger;Lcom/clevertap/android/sdk/db/DBEncryptionHandler;)V", "getMessages", "Lkotlin/collections/ArrayList;", "Lcom/clevertap/android/sdk/inbox/CTMessageDAO;", "Ljava/util/ArrayList;", "userId", "", "(Ljava/lang/String;)Ljava/util/ArrayList;", "upsertMessages", "", "inboxMessages", "", "deleteMessage", "", "messageId", "deleteMessages", "messageIds", "markMessageAsRead", "markMessagesAsRead", "getTemplateMarkersList", "count", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InboxMessageDAOImpl implements InboxMessageDAO {
    private final DBEncryptionHandler dbEncryptionHandler;
    private final DatabaseHelper dbHelper;
    private final ILogger logger;

    public InboxMessageDAOImpl(DatabaseHelper dbHelper, ILogger logger, DBEncryptionHandler dbEncryptionHandler) {
        Intrinsics.checkNotNullParameter(dbHelper, "dbHelper");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(dbEncryptionHandler, "dbEncryptionHandler");
        this.dbHelper = dbHelper;
        this.logger = logger;
        this.dbEncryptionHandler = dbEncryptionHandler;
    }

    @Override // com.clevertap.android.sdk.db.dao.InboxMessageDAO
    public ArrayList<CTMessageDAO> getMessages(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        String tableName = Table.INBOX_MESSAGES.getTableName();
        ArrayList<CTMessageDAO> arrayList = new ArrayList<>();
        try {
            Cursor cursorQuery = this.dbHelper.getReadableDatabase().query(tableName, null, "messageUser = ?", new String[]{userId}, null, null, "created_at DESC");
            if (cursorQuery == null) {
                return arrayList;
            }
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                int columnIndexOrThrow = cursor2.getColumnIndexOrThrow("_id");
                int columnIndexOrThrow2 = cursor2.getColumnIndexOrThrow("data");
                int columnIndexOrThrow3 = cursor2.getColumnIndexOrThrow("wzrkParams");
                int columnIndexOrThrow4 = cursor2.getColumnIndexOrThrow(Column.CREATED_AT);
                int columnIndexOrThrow5 = cursor2.getColumnIndexOrThrow("expires");
                int columnIndexOrThrow6 = cursor2.getColumnIndexOrThrow("isRead");
                int columnIndexOrThrow7 = cursor2.getColumnIndexOrThrow(Column.USER_ID);
                int columnIndexOrThrow8 = cursor2.getColumnIndexOrThrow("tags");
                int columnIndexOrThrow9 = cursor2.getColumnIndexOrThrow(Column.CAMPAIGN);
                while (cursor2.moveToNext()) {
                    String strUnwrapDbData = this.dbEncryptionHandler.unwrapDbData(cursor2.getString(columnIndexOrThrow2));
                    if (strUnwrapDbData == null) {
                        this.logger.debug("There was some problem in loading inbox message from DB");
                    } else {
                        CTMessageDAO cTMessageDAO = new CTMessageDAO();
                        cTMessageDAO.setId(cursor2.getString(columnIndexOrThrow));
                        cTMessageDAO.setJsonData(new JSONObject(strUnwrapDbData));
                        cTMessageDAO.setWzrkParams(new JSONObject(cursor2.getString(columnIndexOrThrow3)));
                        cTMessageDAO.setDate(cursor2.getLong(columnIndexOrThrow4));
                        cTMessageDAO.setExpires(cursor2.getLong(columnIndexOrThrow5));
                        cTMessageDAO.setRead(cursor2.getInt(columnIndexOrThrow6));
                        cTMessageDAO.setUserId(cursor2.getString(columnIndexOrThrow7));
                        cTMessageDAO.setTags(cursor2.getString(columnIndexOrThrow8));
                        cTMessageDAO.setCampaignId(cursor2.getString(columnIndexOrThrow9));
                        arrayList.add(cTMessageDAO);
                        columnIndexOrThrow2 = columnIndexOrThrow2;
                        columnIndexOrThrow = columnIndexOrThrow;
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
                return arrayList;
            } finally {
            }
        } catch (Exception e2) {
            this.logger.verbose("Error retrieving records from " + tableName, e2);
            return arrayList;
        }
    }

    @Override // com.clevertap.android.sdk.db.dao.InboxMessageDAO
    public void upsertMessages(List<? extends CTMessageDAO> inboxMessages) {
        Intrinsics.checkNotNullParameter(inboxMessages, "inboxMessages");
        if (!this.dbHelper.belowMemThreshold()) {
            this.logger.verbose(DBAdapter.NOT_ENOUGH_SPACE_LOG);
            return;
        }
        for (CTMessageDAO cTMessageDAO : inboxMessages) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_id", cTMessageDAO.getId());
            DBEncryptionHandler dBEncryptionHandler = this.dbEncryptionHandler;
            String string = cTMessageDAO.getJsonData().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            contentValues.put("data", dBEncryptionHandler.wrapDbData(string));
            contentValues.put("wzrkParams", cTMessageDAO.getWzrkParams().toString());
            contentValues.put(Column.CAMPAIGN, cTMessageDAO.getCampaignId());
            contentValues.put("tags", cTMessageDAO.getTags());
            contentValues.put("isRead", Integer.valueOf(cTMessageDAO.isRead()));
            contentValues.put("expires", Long.valueOf(cTMessageDAO.getExpires()));
            contentValues.put(Column.CREATED_AT, Long.valueOf(cTMessageDAO.getDate()));
            contentValues.put(Column.USER_ID, cTMessageDAO.getUserId());
            try {
                Long.valueOf(this.dbHelper.getWritableDatabase().insertWithOnConflict(Table.INBOX_MESSAGES.getTableName(), null, contentValues, 5));
            } catch (SQLiteException e2) {
                this.logger.verbose("Error adding data to table " + Table.INBOX_MESSAGES.getTableName(), e2);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // com.clevertap.android.sdk.db.dao.InboxMessageDAO
    public boolean deleteMessage(String messageId, String userId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        String tableName = Table.INBOX_MESSAGES.getTableName();
        try {
            this.dbHelper.getWritableDatabase().delete(tableName, "_id = ? AND messageUser = ?", new String[]{messageId, userId});
            return true;
        } catch (SQLiteException e2) {
            this.logger.verbose("Error removing stale records from " + tableName, e2);
            return false;
        }
    }

    @Override // com.clevertap.android.sdk.db.dao.InboxMessageDAO
    public boolean deleteMessages(List<String> messageIds, String userId) {
        Intrinsics.checkNotNullParameter(messageIds, "messageIds");
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (messageIds.isEmpty()) {
            this.logger.verbose("messageIds list is empty, nothing to delete.");
            return true;
        }
        String tableName = Table.INBOX_MESSAGES.getTableName();
        String templateMarkersList = getTemplateMarkersList(messageIds.size());
        List mutableList = CollectionsKt.toMutableList((Collection) messageIds);
        mutableList.add(userId);
        try {
            this.dbHelper.getWritableDatabase().delete(tableName, "_id IN (" + templateMarkersList + ") AND messageUser = ?", (String[]) mutableList.toArray(new String[0]));
            return true;
        } catch (SQLiteException e2) {
            this.logger.verbose("Error removing stale records from " + tableName, e2);
            return false;
        }
    }

    @Override // com.clevertap.android.sdk.db.dao.InboxMessageDAO
    public boolean markMessageAsRead(String messageId, String userId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        String tableName = Table.INBOX_MESSAGES.getTableName();
        ContentValues contentValues = new ContentValues();
        contentValues.put("isRead", (Integer) 1);
        try {
            this.dbHelper.getWritableDatabase().update(tableName, contentValues, "_id = ? AND messageUser = ?", new String[]{messageId, userId});
            return true;
        } catch (SQLiteException e2) {
            this.logger.verbose("Error updating record in " + tableName, e2);
            return false;
        }
    }

    @Override // com.clevertap.android.sdk.db.dao.InboxMessageDAO
    public boolean markMessagesAsRead(List<String> messageIds, String userId) {
        Intrinsics.checkNotNullParameter(messageIds, "messageIds");
        Intrinsics.checkNotNullParameter(userId, "userId");
        String tableName = Table.INBOX_MESSAGES.getTableName();
        String templateMarkersList = getTemplateMarkersList(messageIds.size());
        List mutableList = CollectionsKt.toMutableList((Collection) messageIds);
        mutableList.add(userId);
        ContentValues contentValues = new ContentValues();
        contentValues.put("isRead", (Integer) 1);
        try {
            this.dbHelper.getWritableDatabase().update(tableName, contentValues, "_id IN (" + templateMarkersList + ") AND messageUser = ?", (String[]) mutableList.toArray(new String[0]));
            return true;
        } catch (SQLiteException e2) {
            this.logger.verbose("Error updating records in " + tableName, e2);
            return false;
        }
    }

    private final String getTemplateMarkersList(int count) {
        StringBuilder sb = new StringBuilder();
        if (count > 0) {
            sb.append("?");
            int i = count - 1;
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(", ?");
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
