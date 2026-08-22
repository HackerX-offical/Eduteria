package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughputDescription;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* JADX INFO: loaded from: classes4.dex */
class ProvisionedThroughputDescriptionJsonUnmarshaller implements Unmarshaller<ProvisionedThroughputDescription, JsonUnmarshallerContext> {
    private static ProvisionedThroughputDescriptionJsonUnmarshaller instance;

    ProvisionedThroughputDescriptionJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public ProvisionedThroughputDescription unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        ProvisionedThroughputDescription provisionedThroughputDescription = new ProvisionedThroughputDescription();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("LastIncreaseDateTime")) {
                provisionedThroughputDescription.setLastIncreaseDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("LastDecreaseDateTime")) {
                provisionedThroughputDescription.setLastDecreaseDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("NumberOfDecreasesToday")) {
                provisionedThroughputDescription.setNumberOfDecreasesToday(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("ReadCapacityUnits")) {
                provisionedThroughputDescription.setReadCapacityUnits(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("WriteCapacityUnits")) {
                provisionedThroughputDescription.setWriteCapacityUnits(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return provisionedThroughputDescription;
    }

    public static ProvisionedThroughputDescriptionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ProvisionedThroughputDescriptionJsonUnmarshaller();
        }
        return instance;
    }
}
