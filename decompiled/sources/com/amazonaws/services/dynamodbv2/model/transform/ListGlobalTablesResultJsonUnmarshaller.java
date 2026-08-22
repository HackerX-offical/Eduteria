package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ListGlobalTablesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* JADX INFO: loaded from: classes4.dex */
public class ListGlobalTablesResultJsonUnmarshaller implements Unmarshaller<ListGlobalTablesResult, JsonUnmarshallerContext> {
    private static ListGlobalTablesResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public ListGlobalTablesResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListGlobalTablesResult listGlobalTablesResult = new ListGlobalTablesResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("GlobalTables")) {
                listGlobalTablesResult.setGlobalTables(new ListUnmarshaller(GlobalTableJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("LastEvaluatedGlobalTableName")) {
                listGlobalTablesResult.setLastEvaluatedGlobalTableName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return listGlobalTablesResult;
    }

    public static ListGlobalTablesResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListGlobalTablesResultJsonUnmarshaller();
        }
        return instance;
    }
}
