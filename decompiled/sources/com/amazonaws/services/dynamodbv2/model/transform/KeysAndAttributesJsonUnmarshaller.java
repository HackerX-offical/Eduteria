package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* JADX INFO: loaded from: classes4.dex */
class KeysAndAttributesJsonUnmarshaller implements Unmarshaller<KeysAndAttributes, JsonUnmarshallerContext> {
    private static KeysAndAttributesJsonUnmarshaller instance;

    KeysAndAttributesJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public KeysAndAttributes unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        KeysAndAttributes keysAndAttributes = new KeysAndAttributes();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("Keys")) {
                keysAndAttributes.setKeys(new ListUnmarshaller(new MapUnmarshaller(AttributeValueJsonUnmarshaller.getInstance())).unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("AttributesToGet")) {
                keysAndAttributes.setAttributesToGet(new ListUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("ConsistentRead")) {
                keysAndAttributes.setConsistentRead(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("ProjectionExpression")) {
                keysAndAttributes.setProjectionExpression(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("ExpressionAttributeNames")) {
                keysAndAttributes.setExpressionAttributeNames(new MapUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return keysAndAttributes;
    }

    public static KeysAndAttributesJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new KeysAndAttributesJsonUnmarshaller();
        }
        return instance;
    }
}
