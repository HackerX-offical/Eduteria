package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AutoScalingTargetTrackingScalingPolicyConfigurationUpdate;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* JADX INFO: loaded from: classes4.dex */
class AutoScalingTargetTrackingScalingPolicyConfigurationUpdateJsonUnmarshaller implements Unmarshaller<AutoScalingTargetTrackingScalingPolicyConfigurationUpdate, JsonUnmarshallerContext> {
    private static AutoScalingTargetTrackingScalingPolicyConfigurationUpdateJsonUnmarshaller instance;

    AutoScalingTargetTrackingScalingPolicyConfigurationUpdateJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public AutoScalingTargetTrackingScalingPolicyConfigurationUpdate unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        AutoScalingTargetTrackingScalingPolicyConfigurationUpdate autoScalingTargetTrackingScalingPolicyConfigurationUpdate = new AutoScalingTargetTrackingScalingPolicyConfigurationUpdate();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("DisableScaleIn")) {
                autoScalingTargetTrackingScalingPolicyConfigurationUpdate.setDisableScaleIn(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("ScaleInCooldown")) {
                autoScalingTargetTrackingScalingPolicyConfigurationUpdate.setScaleInCooldown(SimpleTypeJsonUnmarshallers.IntegerJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("ScaleOutCooldown")) {
                autoScalingTargetTrackingScalingPolicyConfigurationUpdate.setScaleOutCooldown(SimpleTypeJsonUnmarshallers.IntegerJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("TargetValue")) {
                autoScalingTargetTrackingScalingPolicyConfigurationUpdate.setTargetValue(SimpleTypeJsonUnmarshallers.DoubleJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return autoScalingTargetTrackingScalingPolicyConfigurationUpdate;
    }

    public static AutoScalingTargetTrackingScalingPolicyConfigurationUpdateJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AutoScalingTargetTrackingScalingPolicyConfigurationUpdateJsonUnmarshaller();
        }
        return instance;
    }
}
