package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AutoScalingTargetTrackingScalingPolicyConfigurationDescription;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* JADX INFO: loaded from: classes4.dex */
class AutoScalingTargetTrackingScalingPolicyConfigurationDescriptionJsonUnmarshaller implements Unmarshaller<AutoScalingTargetTrackingScalingPolicyConfigurationDescription, JsonUnmarshallerContext> {
    private static AutoScalingTargetTrackingScalingPolicyConfigurationDescriptionJsonUnmarshaller instance;

    AutoScalingTargetTrackingScalingPolicyConfigurationDescriptionJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public AutoScalingTargetTrackingScalingPolicyConfigurationDescription unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        AutoScalingTargetTrackingScalingPolicyConfigurationDescription autoScalingTargetTrackingScalingPolicyConfigurationDescription = new AutoScalingTargetTrackingScalingPolicyConfigurationDescription();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("DisableScaleIn")) {
                autoScalingTargetTrackingScalingPolicyConfigurationDescription.setDisableScaleIn(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("ScaleInCooldown")) {
                autoScalingTargetTrackingScalingPolicyConfigurationDescription.setScaleInCooldown(SimpleTypeJsonUnmarshallers.IntegerJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("ScaleOutCooldown")) {
                autoScalingTargetTrackingScalingPolicyConfigurationDescription.setScaleOutCooldown(SimpleTypeJsonUnmarshallers.IntegerJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("TargetValue")) {
                autoScalingTargetTrackingScalingPolicyConfigurationDescription.setTargetValue(SimpleTypeJsonUnmarshallers.DoubleJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return autoScalingTargetTrackingScalingPolicyConfigurationDescription;
    }

    public static AutoScalingTargetTrackingScalingPolicyConfigurationDescriptionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AutoScalingTargetTrackingScalingPolicyConfigurationDescriptionJsonUnmarshaller();
        }
        return instance;
    }
}
