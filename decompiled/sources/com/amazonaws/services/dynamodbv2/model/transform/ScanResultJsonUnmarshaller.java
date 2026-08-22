package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;
import com.clevertap.android.sdk.Constants;

/* JADX INFO: loaded from: classes4.dex */
public class ScanResultJsonUnmarshaller implements Unmarshaller<ScanResult, JsonUnmarshallerContext> {
    private static ScanResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public ScanResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ScanResult scanResult = new ScanResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals(Constants.KEY_ITEMS)) {
                scanResult.setItems(new ListUnmarshaller(new MapUnmarshaller(AttributeValueJsonUnmarshaller.getInstance())).unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("Count")) {
                scanResult.setCount(SimpleTypeJsonUnmarshallers.IntegerJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("ScannedCount")) {
                scanResult.setScannedCount(SimpleTypeJsonUnmarshallers.IntegerJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("LastEvaluatedKey")) {
                scanResult.setLastEvaluatedKey(new MapUnmarshaller(AttributeValueJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("ConsumedCapacity")) {
                scanResult.setConsumedCapacity(ConsumedCapacityJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return scanResult;
    }

    public static ScanResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ScanResultJsonUnmarshaller();
        }
        return instance;
    }
}
