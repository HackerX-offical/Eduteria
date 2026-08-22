package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.TimeToLiveDescription;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* JADX INFO: loaded from: classes4.dex */
class TimeToLiveDescriptionJsonUnmarshaller implements Unmarshaller<TimeToLiveDescription, JsonUnmarshallerContext> {
    private static TimeToLiveDescriptionJsonUnmarshaller instance;

    TimeToLiveDescriptionJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public TimeToLiveDescription unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        TimeToLiveDescription timeToLiveDescription = new TimeToLiveDescription();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("TimeToLiveStatus")) {
                timeToLiveDescription.setTimeToLiveStatus(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("AttributeName")) {
                timeToLiveDescription.setAttributeName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return timeToLiveDescription;
    }

    public static TimeToLiveDescriptionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new TimeToLiveDescriptionJsonUnmarshaller();
        }
        return instance;
    }
}
