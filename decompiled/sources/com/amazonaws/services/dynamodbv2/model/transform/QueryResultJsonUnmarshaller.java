package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;
import com.clevertap.android.sdk.Constants;

/* JADX INFO: loaded from: classes4.dex */
public class QueryResultJsonUnmarshaller implements Unmarshaller<QueryResult, JsonUnmarshallerContext> {
    private static QueryResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public QueryResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        QueryResult queryResult = new QueryResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals(Constants.KEY_ITEMS)) {
                queryResult.setItems(new ListUnmarshaller(new MapUnmarshaller(AttributeValueJsonUnmarshaller.getInstance())).unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("Count")) {
                queryResult.setCount(SimpleTypeJsonUnmarshallers.IntegerJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("ScannedCount")) {
                queryResult.setScannedCount(SimpleTypeJsonUnmarshallers.IntegerJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("LastEvaluatedKey")) {
                queryResult.setLastEvaluatedKey(new MapUnmarshaller(AttributeValueJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("ConsumedCapacity")) {
                queryResult.setConsumedCapacity(ConsumedCapacityJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return queryResult;
    }

    public static QueryResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new QueryResultJsonUnmarshaller();
        }
        return instance;
    }
}
