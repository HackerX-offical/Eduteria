package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AutoScalingPolicyDescription;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* JADX INFO: loaded from: classes4.dex */
class AutoScalingPolicyDescriptionJsonUnmarshaller implements Unmarshaller<AutoScalingPolicyDescription, JsonUnmarshallerContext> {
    private static AutoScalingPolicyDescriptionJsonUnmarshaller instance;

    AutoScalingPolicyDescriptionJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public AutoScalingPolicyDescription unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        AutoScalingPolicyDescription autoScalingPolicyDescription = new AutoScalingPolicyDescription();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("PolicyName")) {
                autoScalingPolicyDescription.setPolicyName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("TargetTrackingScalingPolicyConfiguration")) {
                autoScalingPolicyDescription.setTargetTrackingScalingPolicyConfiguration(AutoScalingTargetTrackingScalingPolicyConfigurationDescriptionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return autoScalingPolicyDescription;
    }

    public static AutoScalingPolicyDescriptionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AutoScalingPolicyDescriptionJsonUnmarshaller();
        }
        return instance;
    }
}
