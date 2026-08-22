package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.util.json.JsonUtils;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
class TransferDBUtil {
    private static final String QUERY_PLACE_HOLDER_STRING = ",?";
    private static TransferDBBase transferDBBase;
    private Gson gson = new Gson();
    private static final Log LOGGER = LogFactory.getLog(TransferDBUtil.class);
    private static final Object LOCK = new Object();

    public TransferDBUtil(Context context) {
        synchronized (LOCK) {
            if (transferDBBase == null) {
                transferDBBase = new TransferDBBase(context);
            }
        }
    }

    public void closeDB() {
        synchronized (LOCK) {
            TransferDBBase transferDBBase2 = transferDBBase;
            if (transferDBBase2 != null) {
                transferDBBase2.closeDBHelper();
            }
        }
    }

    public Uri insertMultipartUploadRecord(String str, String str2, File file, long j, int i, String str3, long j2, int i2, TransferUtilityOptions transferUtilityOptions) {
        ContentValues contentValuesGenerateContentValuesForMultiPartUpload = generateContentValuesForMultiPartUpload(str, str2, file, j, i, str3, j2, i2, new ObjectMetadata(), null, transferUtilityOptions);
        TransferDBBase transferDBBase2 = transferDBBase;
        return transferDBBase2.insert(transferDBBase2.getContentUri(), contentValuesGenerateContentValuesForMultiPartUpload);
    }

    public Uri insertSingleTransferRecord(TransferType transferType, String str, String str2, File file, ObjectMetadata objectMetadata, TransferUtilityOptions transferUtilityOptions) {
        return insertSingleTransferRecord(transferType, str, str2, file, objectMetadata, null, transferUtilityOptions);
    }

    public Uri insertSingleTransferRecord(TransferType transferType, String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList, TransferUtilityOptions transferUtilityOptions) {
        ContentValues contentValuesGenerateContentValuesForSinglePartTransfer = generateContentValuesForSinglePartTransfer(transferType, str, str2, file, objectMetadata, cannedAccessControlList, transferUtilityOptions);
        TransferDBBase transferDBBase2 = transferDBBase;
        return transferDBBase2.insert(transferDBBase2.getContentUri(), contentValuesGenerateContentValuesForSinglePartTransfer);
    }

    public Uri insertSingleTransferRecord(TransferType transferType, String str, String str2, File file, TransferUtilityOptions transferUtilityOptions) {
        return insertSingleTransferRecord(transferType, str, str2, file, new ObjectMetadata(), transferUtilityOptions);
    }

    public int bulkInsertTransferRecords(ContentValues[] contentValuesArr) {
        TransferDBBase transferDBBase2 = transferDBBase;
        return transferDBBase2.bulkInsert(transferDBBase2.getContentUri(), contentValuesArr);
    }

    public int updateTransferRecord(TransferRecord transferRecord) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(transferRecord.id));
        contentValues.put("state", transferRecord.state.toString());
        contentValues.put(TransferTable.COLUMN_BYTES_TOTAL, Long.valueOf(transferRecord.bytesTotal));
        contentValues.put(TransferTable.COLUMN_BYTES_CURRENT, Long.valueOf(transferRecord.bytesCurrent));
        return transferDBBase.update(getRecordUri(transferRecord.id), contentValues, null, null);
    }

    public int updateBytesTransferred(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TransferTable.COLUMN_BYTES_CURRENT, Long.valueOf(j));
        return transferDBBase.update(getRecordUri(i), contentValues, null, null);
    }

    public int updateBytesTotalForDownload(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TransferTable.COLUMN_BYTES_TOTAL, Long.valueOf(j));
        return transferDBBase.update(getRecordUri(i), contentValues, null, null);
    }

    public int updateState(int i, TransferState transferState) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", transferState.toString());
        if (TransferState.FAILED.equals(transferState)) {
            return transferDBBase.update(getRecordUri(i), contentValues, "state not in (?,?,?,?,?) ", new String[]{TransferState.COMPLETED.toString(), TransferState.PENDING_NETWORK_DISCONNECT.toString(), TransferState.PAUSED.toString(), TransferState.CANCELED.toString(), TransferState.WAITING_FOR_NETWORK.toString()});
        }
        return transferDBBase.update(getRecordUri(i), contentValues, null, null);
    }

    public int updateStateAndNotifyUpdate(int i, TransferState transferState) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", transferState.toString());
        TransferDBBase transferDBBase2 = transferDBBase;
        return transferDBBase2.update(transferDBBase2.getContentUri(), contentValues, "_id=" + i, null);
    }

    public int updateMultipartId(int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TransferTable.COLUMN_MULTIPART_ID, str);
        return transferDBBase.update(getRecordUri(i), contentValues, null, null);
    }

    public int updateETag(int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TransferTable.COLUMN_ETAG, str);
        return transferDBBase.update(getRecordUri(i), contentValues, null, null);
    }

    public int updateNetworkDisconnected() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", TransferState.PENDING_NETWORK_DISCONNECT.toString());
        TransferDBBase transferDBBase2 = transferDBBase;
        return transferDBBase2.update(transferDBBase2.getContentUri(), contentValues, "state in (?,?,?)", new String[]{TransferState.IN_PROGRESS.toString(), TransferState.RESUMED_WAITING.toString(), TransferState.WAITING.toString()});
    }

    public int updateNetworkConnected() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", TransferState.RESUMED_WAITING.toString());
        TransferDBBase transferDBBase2 = transferDBBase;
        return transferDBBase2.update(transferDBBase2.getContentUri(), contentValues, "state in (?,?)", new String[]{TransferState.PENDING_NETWORK_DISCONNECT.toString(), TransferState.WAITING_FOR_NETWORK.toString()});
    }

    public int setAllRunningRecordsToPausedBeforeShutdownService() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", TransferState.PAUSED.toString());
        TransferDBBase transferDBBase2 = transferDBBase;
        return transferDBBase2.update(transferDBBase2.getContentUri(), contentValues, "state in (?,?,?,?)", new String[]{TransferState.IN_PROGRESS.toString(), TransferState.PENDING_PAUSE.toString(), TransferState.RESUMED_WAITING.toString(), TransferState.WAITING.toString()});
    }

    public int pauseAllWithType(TransferType transferType) {
        String str;
        String[] strArr;
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", TransferState.PENDING_PAUSE.toString());
        if (transferType == TransferType.ANY) {
            strArr = new String[]{TransferState.IN_PROGRESS.toString(), TransferState.RESUMED_WAITING.toString(), TransferState.WAITING.toString()};
            str = "state in (?,?,?)";
        } else {
            str = "state in (?,?,?) and type=?";
            strArr = new String[]{TransferState.IN_PROGRESS.toString(), TransferState.RESUMED_WAITING.toString(), TransferState.WAITING.toString(), transferType.toString()};
        }
        TransferDBBase transferDBBase2 = transferDBBase;
        return transferDBBase2.update(transferDBBase2.getContentUri(), contentValues, str, strArr);
    }

    public int cancelAllWithType(TransferType transferType) {
        String str;
        String[] strArr;
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", TransferState.PENDING_CANCEL.toString());
        if (transferType == TransferType.ANY) {
            strArr = new String[]{TransferState.IN_PROGRESS.toString(), TransferState.RESUMED_WAITING.toString(), TransferState.WAITING.toString(), TransferState.PAUSED.toString(), TransferState.WAITING_FOR_NETWORK.toString()};
            str = "state in (?,?,?,?,?)";
        } else {
            str = "state in (?,?,?,?,?) and type=?";
            strArr = new String[]{TransferState.IN_PROGRESS.toString(), TransferState.RESUMED_WAITING.toString(), TransferState.WAITING.toString(), TransferState.PAUSED.toString(), TransferState.WAITING_FOR_NETWORK.toString(), transferType.toString()};
        }
        TransferDBBase transferDBBase2 = transferDBBase;
        return transferDBBase2.update(transferDBBase2.getContentUri(), contentValues, str, strArr);
    }

    public Cursor queryAllTransfersWithType(TransferType transferType) {
        if (transferType == TransferType.ANY) {
            TransferDBBase transferDBBase2 = transferDBBase;
            return transferDBBase2.query(transferDBBase2.getContentUri(), null, null, null, null);
        }
        TransferDBBase transferDBBase3 = transferDBBase;
        return transferDBBase3.query(transferDBBase3.getContentUri(), null, "type=?", new String[]{transferType.toString()}, null);
    }

    public Cursor queryTransfersWithTypeAndState(TransferType transferType, TransferState transferState) {
        if (transferType == TransferType.ANY) {
            return transferDBBase.query(getStateUri(transferState), null, null, null, null);
        }
        return transferDBBase.query(getStateUri(transferState), null, "type=?", new String[]{transferType.toString()}, null);
    }

    public Cursor queryTransfersWithTypeAndStates(TransferType transferType, TransferState[] transferStateArr) {
        String str;
        String[] strArr;
        int length = transferStateArr.length;
        String strCreatePlaceholders = createPlaceholders(length);
        int i = 0;
        if (transferType == TransferType.ANY) {
            String str2 = "state in (" + strCreatePlaceholders + ")";
            String[] strArr2 = new String[length];
            while (i < length) {
                strArr2[i] = transferStateArr[i].toString();
                i++;
            }
            str = str2;
            strArr = strArr2;
        } else {
            String str3 = "state in (" + strCreatePlaceholders + ") and type=?";
            String[] strArr3 = new String[length + 1];
            while (i < length) {
                strArr3[i] = transferStateArr[i].toString();
                i++;
            }
            strArr3[i] = transferType.toString();
            str = str3;
            strArr = strArr3;
        }
        TransferDBBase transferDBBase2 = transferDBBase;
        return transferDBBase2.query(transferDBBase2.getContentUri(), null, str, strArr, null);
    }

    public Cursor queryTransferById(int i) {
        return transferDBBase.query(getRecordUri(i), null, null, null, null);
    }

    public long queryBytesTransferredByMainUploadId(int i) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = transferDBBase.query(getPartUri(i), null, null, null, null);
            long j = 0;
            while (cursorQuery.moveToNext()) {
                if (TransferState.PART_COMPLETED.equals(TransferState.getState(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("state"))))) {
                    j += cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow(TransferTable.COLUMN_BYTES_TOTAL));
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return j;
        } finally {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0037, code lost:
    
        r9 = r1.getLong(r1.getColumnIndexOrThrow(com.amazonaws.mobileconnectors.s3.transferutility.TransferTable.COLUMN_BYTES_CURRENT));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long queryBytesTransferredOfPartNum(int r9, int r10) {
        /*
            r8 = this;
            r1 = 0
            com.amazonaws.mobileconnectors.s3.transferutility.TransferDBBase r2 = com.amazonaws.mobileconnectors.s3.transferutility.TransferDBUtil.transferDBBase     // Catch: java.lang.Throwable -> L4a
            android.net.Uri r3 = r8.getPartUri(r9)     // Catch: java.lang.Throwable -> L4a
            r6 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L4a
        Lf:
            boolean r9 = r1.moveToNext()     // Catch: java.lang.Throwable -> L4a
            if (r9 == 0) goto L42
            java.lang.String r9 = "part_num"
            int r9 = r1.getColumnIndexOrThrow(r9)     // Catch: java.lang.Throwable -> L4a
            int r9 = r1.getInt(r9)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r0 = "state"
            int r0 = r1.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L4a
            if (r9 != r10) goto Lf
            com.amazonaws.mobileconnectors.s3.transferutility.TransferState r9 = com.amazonaws.mobileconnectors.s3.transferutility.TransferState.PART_COMPLETED     // Catch: java.lang.Throwable -> L4a
            com.amazonaws.mobileconnectors.s3.transferutility.TransferState r0 = com.amazonaws.mobileconnectors.s3.transferutility.TransferState.getState(r0)     // Catch: java.lang.Throwable -> L4a
            boolean r9 = r9.equals(r0)     // Catch: java.lang.Throwable -> L4a
            if (r9 != 0) goto Lf
            java.lang.String r9 = "bytes_current"
            int r9 = r1.getColumnIndexOrThrow(r9)     // Catch: java.lang.Throwable -> L4a
            long r9 = r1.getLong(r9)     // Catch: java.lang.Throwable -> L4a
            goto L44
        L42:
            r9 = 0
        L44:
            if (r1 == 0) goto L49
            r1.close()
        L49:
            return r9
        L4a:
            r0 = move-exception
            r9 = r0
            if (r1 == 0) goto L51
            r1.close()
        L51:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferDBUtil.queryBytesTransferredOfPartNum(int, int):long");
    }

    public int deleteTransferRecords(int i) {
        return transferDBBase.delete(getRecordUri(i), null, null);
    }

    public List<PartETag> queryPartETagsOfUpload(int i) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            cursorQuery = transferDBBase.query(getPartUri(i), null, null, null, null);
            while (cursorQuery.moveToNext()) {
                arrayList.add(new PartETag(cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow(TransferTable.COLUMN_PART_NUM)), cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(TransferTable.COLUMN_ETAG))));
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } finally {
        }
    }

    public List<UploadPartRequest> getNonCompletedPartRequestsFromDB(int i, String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            cursorQuery = transferDBBase.query(getPartUri(i), null, null, null, null);
            while (cursorQuery.moveToNext()) {
                if (!TransferState.PART_COMPLETED.equals(TransferState.getState(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("state"))))) {
                    UploadPartRequest uploadPartRequestWithPartSize = new UploadPartRequest().withId(cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("_id"))).withMainUploadId(cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow(TransferTable.COLUMN_MAIN_UPLOAD_ID))).withBucketName(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(TransferTable.COLUMN_BUCKET_NAME))).withKey(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("key"))).withUploadId(str).withFile(new File(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("file")))).withFileOffset(cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow(TransferTable.COLUMN_FILE_OFFSET))).withPartNumber(cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow(TransferTable.COLUMN_PART_NUM))).withPartSize(cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow(TransferTable.COLUMN_BYTES_TOTAL)));
                    boolean z = true;
                    if (1 != cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow(TransferTable.COLUMN_IS_LAST_PART))) {
                        z = false;
                    }
                    arrayList.add(uploadPartRequestWithPartSize.withLastPart(z));
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } finally {
        }
    }

    public boolean checkWaitingForNetworkPartRequestsFromDB(int i) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = transferDBBase.query(getPartUri(i), null, "state=?", new String[]{TransferState.WAITING_FOR_NETWORK.toString()}, null);
            boolean zMoveToNext = cursorQuery.moveToNext();
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return zMoveToNext;
        } finally {
        }
    }

    private String createPlaceholders(int i) {
        if (i <= 0) {
            LOGGER.error("Cannot create a string of 0 or less placeholders.");
            return null;
        }
        StringBuilder sb = new StringBuilder((QUERY_PLACE_HOLDER_STRING.length() * i) - 1);
        sb.append("?");
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(QUERY_PLACE_HOLDER_STRING);
        }
        return sb.toString();
    }

    public ContentValues generateContentValuesForMultiPartUpload(String str, String str2, File file, long j, int i, String str3, long j2, int i2, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList, TransferUtilityOptions transferUtilityOptions) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", TransferType.UPLOAD.toString());
        contentValues.put("state", TransferState.WAITING.toString());
        contentValues.put(TransferTable.COLUMN_BUCKET_NAME, str);
        contentValues.put("key", str2);
        contentValues.put("file", file.getAbsolutePath());
        contentValues.put(TransferTable.COLUMN_BYTES_CURRENT, (Long) 0L);
        contentValues.put(TransferTable.COLUMN_BYTES_TOTAL, Long.valueOf(j2));
        contentValues.put(TransferTable.COLUMN_IS_MULTIPART, (Integer) 1);
        contentValues.put(TransferTable.COLUMN_PART_NUM, Integer.valueOf(i));
        contentValues.put(TransferTable.COLUMN_FILE_OFFSET, Long.valueOf(j));
        contentValues.put(TransferTable.COLUMN_MULTIPART_ID, str3);
        contentValues.put(TransferTable.COLUMN_IS_LAST_PART, Integer.valueOf(i2));
        contentValues.put(TransferTable.COLUMN_IS_ENCRYPTED, (Integer) 0);
        contentValues.putAll(generateContentValuesForObjectMetadata(objectMetadata));
        if (cannedAccessControlList != null) {
            contentValues.put(TransferTable.COLUMN_CANNED_ACL, cannedAccessControlList.toString());
        }
        if (transferUtilityOptions != null) {
            contentValues.put(TransferTable.COLUMN_TRANSFER_UTILITY_OPTIONS, this.gson.toJson(transferUtilityOptions));
        }
        return contentValues;
    }

    private ContentValues generateContentValuesForObjectMetadata(ObjectMetadata objectMetadata) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TransferTable.COLUMN_USER_METADATA, JsonUtils.mapToString(objectMetadata.getUserMetadata()));
        contentValues.put(TransferTable.COLUMN_HEADER_CONTENT_TYPE, objectMetadata.getContentType());
        contentValues.put(TransferTable.COLUMN_HEADER_CONTENT_ENCODING, objectMetadata.getContentEncoding());
        contentValues.put(TransferTable.COLUMN_HEADER_CACHE_CONTROL, objectMetadata.getCacheControl());
        contentValues.put(TransferTable.COLUMN_CONTENT_MD5, objectMetadata.getContentMD5());
        contentValues.put(TransferTable.COLUMN_HEADER_CONTENT_DISPOSITION, objectMetadata.getContentDisposition());
        contentValues.put(TransferTable.COLUMN_SSE_ALGORITHM, objectMetadata.getSSEAlgorithm());
        contentValues.put(TransferTable.COLUMN_SSE_KMS_KEY, objectMetadata.getSSEAwsKmsKeyId());
        contentValues.put(TransferTable.COLUMN_EXPIRATION_TIME_RULE_ID, objectMetadata.getExpirationTimeRuleId());
        if (objectMetadata.getHttpExpiresDate() != null) {
            contentValues.put(TransferTable.COLUMN_HTTP_EXPIRES_DATE, String.valueOf(objectMetadata.getHttpExpiresDate().getTime()));
        }
        if (objectMetadata.getStorageClass() != null) {
            contentValues.put(TransferTable.COLUMN_HEADER_STORAGE_CLASS, objectMetadata.getStorageClass());
        }
        return contentValues;
    }

    private ContentValues generateContentValuesForSinglePartTransfer(TransferType transferType, String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList, TransferUtilityOptions transferUtilityOptions) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", transferType.toString());
        contentValues.put("state", TransferState.WAITING.toString());
        contentValues.put(TransferTable.COLUMN_BUCKET_NAME, str);
        contentValues.put("key", str2);
        contentValues.put("file", file.getAbsolutePath());
        contentValues.put(TransferTable.COLUMN_BYTES_CURRENT, (Long) 0L);
        if (transferType.equals(TransferType.UPLOAD)) {
            contentValues.put(TransferTable.COLUMN_BYTES_TOTAL, Long.valueOf(file != null ? file.length() : 0L));
        }
        contentValues.put(TransferTable.COLUMN_IS_MULTIPART, (Integer) 0);
        contentValues.put(TransferTable.COLUMN_PART_NUM, (Integer) 0);
        contentValues.put(TransferTable.COLUMN_IS_ENCRYPTED, (Integer) 0);
        contentValues.putAll(generateContentValuesForObjectMetadata(objectMetadata));
        if (cannedAccessControlList != null) {
            contentValues.put(TransferTable.COLUMN_CANNED_ACL, cannedAccessControlList.toString());
        }
        if (transferUtilityOptions != null) {
            contentValues.put(TransferTable.COLUMN_TRANSFER_UTILITY_OPTIONS, this.gson.toJson(transferUtilityOptions));
        }
        return contentValues;
    }

    public Uri getContentUri() {
        return transferDBBase.getContentUri();
    }

    public Uri getRecordUri(int i) {
        return Uri.parse(transferDBBase.getContentUri() + MqttTopic.TOPIC_LEVEL_SEPARATOR + i);
    }

    public Uri getPartUri(int i) {
        return Uri.parse(transferDBBase.getContentUri() + "/part/" + i);
    }

    public Uri getStateUri(TransferState transferState) {
        return Uri.parse(transferDBBase.getContentUri() + "/state/" + transferState.toString());
    }

    TransferRecord getTransferById(int i) throws Throwable {
        Cursor cursor = null;
        TransferRecord transferRecord = null;
        try {
            Cursor cursorQueryTransferById = queryTransferById(i);
            try {
                if (cursorQueryTransferById.moveToFirst()) {
                    transferRecord = new TransferRecord(i);
                    transferRecord.updateFromDB(cursorQueryTransferById);
                }
                if (cursorQueryTransferById != null) {
                    cursorQueryTransferById.close();
                }
                return transferRecord;
            } catch (Throwable th) {
                th = th;
                cursor = cursorQueryTransferById;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    static TransferDBBase getTransferDBBase(Context context) {
        TransferDBBase transferDBBase2;
        synchronized (LOCK) {
            if (transferDBBase == null) {
                transferDBBase = new TransferDBBase(context);
            }
            transferDBBase2 = transferDBBase;
        }
        return transferDBBase2;
    }
}
