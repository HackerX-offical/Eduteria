package com.amazonaws.services.dynamodbv2.model.transform;

import androidx.exifinterface.media.ExifInterface;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;
import com.clevertap.android.sdk.inapp.store.preference.InAppStore;

/* JADX INFO: loaded from: classes4.dex */
class AttributeValueJsonUnmarshaller implements Unmarshaller<AttributeValue, JsonUnmarshallerContext> {
    private static AttributeValueJsonUnmarshaller instance;

    AttributeValueJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public AttributeValue unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        AttributeValue attributeValue = new AttributeValue();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals(ExifInterface.LATITUDE_SOUTH)) {
                attributeValue.setS(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("N")) {
                attributeValue.setN(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("B")) {
                attributeValue.setB(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals(InAppStore.SERVER_SIDE_MODE)) {
                attributeValue.setSS(new ListUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("NS")) {
                attributeValue.setNS(new ListUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("BS")) {
                attributeValue.setBS(new ListUnmarshaller(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("M")) {
                attributeValue.setM(new MapUnmarshaller(getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("L")) {
                attributeValue.setL(new ListUnmarshaller(getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("NULL")) {
                attributeValue.setNULL(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("BOOL")) {
                attributeValue.setBOOL(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return attributeValue;
    }

    public static AttributeValueJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AttributeValueJsonUnmarshaller();
        }
        return instance;
    }
}
