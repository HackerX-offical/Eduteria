package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ListBackupsResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* JADX INFO: loaded from: classes4.dex */
public class ListBackupsResultJsonUnmarshaller implements Unmarshaller<ListBackupsResult, JsonUnmarshallerContext> {
    private static ListBackupsResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public ListBackupsResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListBackupsResult listBackupsResult = new ListBackupsResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("BackupSummaries")) {
                listBackupsResult.setBackupSummaries(new ListUnmarshaller(BackupSummaryJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("LastEvaluatedBackupArn")) {
                listBackupsResult.setLastEvaluatedBackupArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return listBackupsResult;
    }

    public static ListBackupsResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListBackupsResultJsonUnmarshaller();
        }
        return instance;
    }
}
