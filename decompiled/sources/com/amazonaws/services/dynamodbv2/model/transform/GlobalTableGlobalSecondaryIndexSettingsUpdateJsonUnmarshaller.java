package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.GlobalTableGlobalSecondaryIndexSettingsUpdate;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* JADX INFO: loaded from: classes4.dex */
class GlobalTableGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller implements Unmarshaller<GlobalTableGlobalSecondaryIndexSettingsUpdate, JsonUnmarshallerContext> {
    private static GlobalTableGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller instance;

    GlobalTableGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public GlobalTableGlobalSecondaryIndexSettingsUpdate unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        GlobalTableGlobalSecondaryIndexSettingsUpdate globalTableGlobalSecondaryIndexSettingsUpdate = new GlobalTableGlobalSecondaryIndexSettingsUpdate();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("IndexName")) {
                globalTableGlobalSecondaryIndexSettingsUpdate.setIndexName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("ProvisionedWriteCapacityUnits")) {
                globalTableGlobalSecondaryIndexSettingsUpdate.setProvisionedWriteCapacityUnits(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("ProvisionedWriteCapacityAutoScalingSettingsUpdate")) {
                globalTableGlobalSecondaryIndexSettingsUpdate.setProvisionedWriteCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return globalTableGlobalSecondaryIndexSettingsUpdate;
    }

    public static GlobalTableGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GlobalTableGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller();
        }
        return instance;
    }
}
