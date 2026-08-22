package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* JADX INFO: loaded from: classes4.dex */
class ConditionJsonUnmarshaller implements Unmarshaller<Condition, JsonUnmarshallerContext> {
    private static ConditionJsonUnmarshaller instance;

    ConditionJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public Condition unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        Condition condition = new Condition();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("AttributeValueList")) {
                condition.setAttributeValueList(new ListUnmarshaller(AttributeValueJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("ComparisonOperator")) {
                condition.setComparisonOperator(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return condition;
    }

    public static ConditionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ConditionJsonUnmarshaller();
        }
        return instance;
    }
}
